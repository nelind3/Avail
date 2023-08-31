package dk.nelind.avail.gui;

import net.minecraft.client.gui.widget.ScrollableTextWidget;
import net.minecraft.text.Text;

public class MainScreen extends AbstractAvailScreen {
    public MainScreen() {
        super(Text.of("Avail Main Screen"));
    }
    private final Text FORMAT_TEXT_TEST = Text.of("""
        · §0Test§r  §0§kTest§r  §0§lTest§r  §0§lTest§r  §0§mTest§r  §0§nTest§r  §0§oTest§r
        
        · §1Test§r  §1§kTest§r  §1§lTest§r  §1§lTest§r  §1§mTest§r  §1§nTest§r  §1§oTest§r
        
        · §2Test§r  §2§kTest§r  §2§lTest§r  §2§lTest§r  §2§mTest§r  §2§nTest§r  §2§oTest§r
        
        · §3Test§r  §3§kTest§r  §3§lTest§r  §3§lTest§r  §3§mTest§r  §3§nTest§r  §3§oTest§r
          
        · §4Test§r  §4§kTest§r  §4§lTest§r  §4§lTest§r  §4§mTest§r  §4§nTest§r  §4§oTest§r
        
        · §5Test§r  §5§kTest§r  §5§lTest§r  §5§lTest§r  §5§mTest§r  §5§nTest§r  §5§oTest§r
        
        · §6Test§r  §6§kTest§r  §6§lTest§r  §6§lTest§r  §6§mTest§r  §6§nTest§r  §6§oTest§r
        
        · §7Test§r  §7§kTest§r  §7§lTest§r  §7§lTest§r  §7§mTest§r  §7§nTest§r  §7§oTest§r
        
        · §8Test§r  §8§kTest§r  §8§lTest§r  §8§lTest§r  §8§mTest§r  §8§nTest§r  §8§oTest§r
        
        · §9Test§r  §9§kTest§r  §9§lTest§r  §9§lTest§r  §9§mTest§r  §9§nTest§r  §9§oTest§r
        
        · §aTest§r  §a§kTest§r  §a§lTest§r  §a§lTest§r  §a§mTest§r  §a§nTest§r  §a§oTest§r
        
        · §bTest§r  §b§kTest§r  §b§lTest§r  §b§lTest§r  §b§mTest§r  §b§nTest§r  §b§oTest§r
        
        · §cTest§r  §c§kTest§r  §c§lTest§r  §c§lTest§r  §c§mTest§r  §c§nTest§r  §c§oTest§r
        
        · §dTest§r  §d§kTest§r  §d§lTest§r  §d§lTest§r  §d§mTest§r  §d§nTest§r  §d§oTest§r
        
        · §eTest§r  §e§kTest§r  §e§lTest§r  §e§lTest§r  §e§mTest§r  §e§nTest§r  §e§oTest§r
        
        · §fTest§r  §f§kTest§r  §f§lTest§r  §f§lTest§r  §f§mTest§r  §f§nTest§r  §f§oTest§r"""
    );
    private final Text LOREM_IPSUM = Text.of("""
       Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nec erat enim. Nullam sapien nisi, vestibulum id ex sit amet, cursus feugiat eros. Pellentesque vestibulum semper molestie. Nam ac tellus sit amet nisi iaculis ultrices ut vitae dui. Vestibulum a posuere turpis. Proin lectus orci, pellentesque et mattis in, cursus sit amet velit. Nulla gravida sollicitudin porttitor. Cras sed neque finibus mauris varius interdum. Nulla facilisi.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
       Curabitur fringilla nec urna sit amet eleifend. Suspendisse sodales vitae tellus sit amet dictum. Vivamus condimentum blandit interdum. Donec ac placerat enim. Pellentesque elementum condimentum massa, id condimentum lorem maximus sit amet. Vivamus accumsan imperdiet urna, eget malesuada felis iaculis quis. Nunc orci neque, blandit nec lorem eu, mattis porta erat. Etiam et imperdiet tellus. Nulla ac gravida tellus. Integer imperdiet lorem sed mattis fermentum. Ut ultricies placerat sapien eu scelerisque. In eget lacus a arcu vulputate tempus. Maecenas eget rhoncus tellus. Donec ac justo tortor. Sed rhoncus, arcu sit amet accumsan mattis, urna ex sodales nunc, a volutpat justo erat nec quam.
       
       Morbi tincidunt dictum tempus. Morbi fringilla nibh sed convallis faucibus. Sed felis odio, pulvinar vel dolor id, euismod semper risus. Fusce semper imperdiet nisl, vel dapibus sem tincidunt non. Ut ligula est, tempus eu leo in, ultricies cursus risus. Nam luctus ex urna, et suscipit enim placerat sit amet. Nulla facilisi. Aliquam sit amet consequat odio. Etiam tempor varius tortor, vitae volutpat neque lacinia quis. In maximus diam ex, at porta ipsum commodo quis.
       
       Sed consequat purus tortor. Quisque et nisi quis nisl malesuada molestie. Proin lacus eros, tincidunt at ornare eu, consectetur a lectus. Sed volutpat rutrum diam interdum gravida. Proin fringilla ante nibh, at interdum enim ultricies sit amet. Quisque sed eros sem. Nam vitae tellus odio.
       
       Pellentesque odio sem, vehicula tristique nibh eleifend, tempus sollicitudin quam. Donec cursus quis nunc eget aliquet. Etiam porta rhoncus sollicitudin. Nam lacinia eget justo quis pharetra. Proin dignissim cursus felis, vel vulputate lorem. Duis pretium mi elit, vitae viverra ipsum pretium quis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Fusce metus est, dictum at purus sed, egestas porta eros. Maecenas ornare tristique massa non placerat. Aliquam dictum leo porta purus accumsan hendrerit. Aliquam non luctus orci, vel accumsan ipsum. Integer vitae iaculis est. In tempor nulla sed semper posuere. Nunc a est mattis risus vulputate faucibus ac eu dui. Pellentesque consequat nibh elit, eget fermentum nibh placerat sit amet. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas."""
    );

    @Override
    protected void init() {
        addDrawableChild(new ScrollableTextWidget(
            10,30,
            this.width - 28, this.height - 40,
            LOREM_IPSUM,
            this.textRenderer
        ));
    }
}
