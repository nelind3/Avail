package dk.nelind.avail.gui.widget;

import java.util.List;
import java.util.function.Consumer;

import com.google.gson.JsonElement;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.screen.narration.NarrationPart;
import net.minecraft.client.gui.widget.ScrollableWidget;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;

public class DocDisplayWidget extends ScrollableWidget {
    private final TextRenderer textRenderer;
    private final Consumer<Style> textClickCallback;
    private final List<OrderedText> docLines;
    private final int contentsWidth;

    public DocDisplayWidget(int x, int y, int width, int height, JsonElement rawMessage, TextRenderer textRenderer, Consumer<Style> textClickCallback) {
        super(x, y, width, height, Text.Serializer.fromJson(rawMessage));
        this.textClickCallback = textClickCallback;
        this.textRenderer = textRenderer;
        Text message = Text.Serializer.fromJson(rawMessage);
        this.contentsWidth = width - (2 * this.getPadding());
        this.docLines = textRenderer.wrapLines(message, this.contentsWidth);
    }

    @Override
    protected int getContentsHeight() {
        return this.docLines.size() * this.textRenderer.fontHeight;
    }

    @Override
    protected double getDeltaYPerScroll() {
        return this.textRenderer.fontHeight;
    }

    @Override
    protected void renderContents(DrawContext context, int mouseX, int mouseY, float delta) {
        context.getMatrices().push();

        // TODO move hover event so its always visible
        Style hoveredStyle = this.getTextStyleAt(mouseX, mouseY);
        context.drawHoverEvent(this.textRenderer, hoveredStyle, mouseX, mouseY);

        context.getMatrices().translate(this.getX() + this.getPadding() + 1, this.getY() + this.getPadding() + 1, 0);
        for (OrderedText line : this.docLines) {
            assert Formatting.WHITE.getColorValue() != null;
            context.drawText(this.textRenderer, line, 0, 0, Formatting.WHITE.getColorValue(), false);
            context.getMatrices().translate(0, this.textRenderer.fontHeight, 0);
        }

        context.getMatrices().pop();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Style textStyle = this.getTextStyleAt(mouseX, mouseY);
        if(textStyle != null) {
            this.textClickCallback.accept(textStyle);
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Nullable
    public Style getTextStyleAt(double x, double y) {
        OrderedText line = this.getLineAt(x, y);
        if(line == null) return null;

        double relativeX = getRelativeXWithoutPadding(x);

        return this.textRenderer.getTextHandler().getStyleAt(line, (int) relativeX);
    }

    @Nullable
    private OrderedText getLineAt(double x, double y) {
        double relativeX = getRelativeXWithoutPadding(x);
        if(relativeX < 0 || relativeX > this.contentsWidth) return null;

        double relativeY = getRelativeY(y);
        if(relativeY < 0) return null;

        int lineIndex = MathHelper.floor(((this.getScrollY() - this.getPadding()) + relativeY) / this.textRenderer.fontHeight);
        if(lineIndex < 0 || lineIndex > this.docLines.size() - 1) return null;

        return this.docLines.get(lineIndex);
    }

    private double getRelativeXWithoutPadding(double x) {
        return getRelativeX(x) - this.getPadding();
    }

    private double getRelativeX(double x) {
        return x - (this.getX() + 1);
    }

    private double getRelativeY(double y) {
        return y - (this.getY() + 1);
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {
        builder.put(NarrationPart.TITLE, this.getMessage());
    }
}
