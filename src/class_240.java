import java.util.Timer;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// $FF: renamed from: b
public final class class_240 extends Canvas {

    // $FF: renamed from: a javax.microedition.lcdui.Display
    private Display field_1046;
    // $FF: renamed from: a javax.microedition.lcdui.Displayable
    private Displayable field_1047;
    // $FF: renamed from: a java.util.Timer
    private Timer field_1048;

    // $FF: renamed from: <init> (javax.microedition.lcdui.Display, javax.microedition.lcdui.Displayable) void
    public class_240(Display var1, Displayable var2) {
        this.field_1048 = new Timer();
        this.field_1046 = var1;
        this.field_1047 = var2;
        var1.setCurrent(this);
    }

    protected final void paint(Graphics var1) {
        Image var2 = null;
        try {
            if ((var2 = Image.createImage("/eclipse.png")) != null) {
                var1.setColor(0);
                var1.fillRect(0, 0, this.getWidth(), this.getHeight());
                var1.drawImage(var2, this.getWidth() / 2, this.getHeight() / 2, 3);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    protected final void showNotify() {
        Timer var10000 = this.field_1048;
        class_245 var10001 = new class_245(this);
        var10000.schedule(var10001, 3500L);
    }

    // $FF: renamed from: a (b) void
    static void method_1432(class_240 var0) {
        var0.field_1048.cancel();
        var0.field_1046.setCurrent(var0.field_1047);
    }
}
