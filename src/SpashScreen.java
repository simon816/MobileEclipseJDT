import java.util.Timer;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class SpashScreen extends Canvas {

    private Display display;

    private Displayable nextScreen;

    private Timer splashTimer;

    public SpashScreen(Display var1, Displayable var2) {
        this.splashTimer = new Timer();
        this.display = var1;
        this.nextScreen = var2;
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
        Timer var10000 = this.splashTimer;
        SplashScreenTask var10001 = new SplashScreenTask(this);
        var10000.schedule(var10001, 3500L);
    }

    static void close(SpashScreen var0) {
        var0.splashTimer.cancel();
        var0.display.setCurrent(var0.nextScreen);
    }
}
