import java.util.TimerTask;

final class SplashScreenTask extends TimerTask {

    private final SpashScreen splashScreen;

    private SplashScreenTask(SpashScreen var1, byte var2) {
        this.splashScreen = var1;
    }

    public final void run() {
        SpashScreen.close(this.splashScreen);
    }

    SplashScreenTask(SpashScreen var1) {
        this(var1, (byte)0);
    }
}
