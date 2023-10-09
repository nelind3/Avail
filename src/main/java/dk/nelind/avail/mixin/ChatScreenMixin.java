package dk.nelind.avail.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import dk.nelind.avail.gui.HomeScreen;

import java.util.Objects;

@Environment(EnvType.CLIENT)
@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin extends Screen {
    protected ChatScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void addAvailDocButton(CallbackInfo ci) {
        int buttonWidth = 14;
        int buttonHeight = 14;
        int buttonMargin = 2;
        int chatTextFieldMargin = 2;
        int chatTextFieldHeight = 12;

        Objects.requireNonNull(this.client);

        addDrawableChild(
            new ButtonWidget.Builder(
                Text.translatable("§a?"),
                btn -> this.client.setScreen(new HomeScreen()))
                .position(
                    this.width  - chatTextFieldMargin - buttonWidth,
                    this.height - chatTextFieldMargin - buttonHeight - chatTextFieldHeight - buttonMargin
                )
                .size(buttonWidth, buttonHeight)
                .build()
        );
    }
}
