package batch;

import class_240;
import batch.class_225;
import batch.class_228;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.MIDlet;

public class eclipse extends MIDlet implements CommandListener {

    TextField field_420;

    TextField field_421;

    TextField field_422;

    Command field_423;

    Command field_424;

    Command field_425;

    Form field_426;

    public static eclipse field_427;

    class_228 field_428;

    Integer field_429;

    Integer field_430;

    Font field_431;

    char[] field_432;

    int field_433;

    static Vector field_434;

    static Vector field_435;

    TextField field_436;

    TextField field_437;

    Command field_438;

    Displayable field_439;

    private Ticker field_440;

    private Ticker field_441;

    private Form field_442;

    Command field_443;

    public eclipse() {
        this.field_443 = new Command("About", 5, 1);
        this.field_423 = new Command("Compile", 4, 1);
        this.field_438 = new Command("Hide", 2, 1);
        this.field_424 = new Command("Result", 3, 1);
        this.field_425 = new Command("Exit", 7, 1);
        this.field_440 = new Ticker("Credits: Alvin Alexander & Yosep Karli");
        this.field_441 = new Ticker("Developer: ASM \u00a9 2012-2013");
        this.field_429 = new Integer(16711680);
        this.field_430 = new Integer(255);
        this.field_431 = Font.getDefaultFont();
        this.field_433 = 0;
    }

    public void startApp() {
        Form var1 = new Form("Mobile Eclipse JDT");
        Random var10000 = new Random();
        boolean var2 = true;
        Random var4 = var10000;
        int var5;
        if ((var5 = (int)(1L * (long)var4.nextInt() >> 31)) == 1) {
            var1.setTicker(this.field_440);
        } else if (var5 == 0) {
            var1.setTicker(this.field_441);
        }
        this.field_420 = new TextField("Sources", "/E:/src", 256, 0);
        this.field_436 = new TextField("Resources", "/E:/res", 256, 0);
        this.field_421 = new TextField("Library", "/E:/lib", 256, 0);
        this.field_422 = new TextField("Class Ouput", "/E:/build", 256, 0);
        this.field_437 = new TextField("Res Ouput", "/E:/build", 256, 0);
        var1.append(this.field_420);
        var1.append(this.field_436);
        var1.append(this.field_421);
        var1.append(this.field_422);
        var1.append(this.field_437);
        var1.addCommand(this.field_425);
        var1.addCommand(this.field_443);
        var1.addCommand(this.field_423);
        var1.addCommand(this.field_424);
        var1.addCommand(this.field_438);
        var1.setCommandListener(this);
        this.field_426 = var1;
        field_427 = this;
        class_228 var10001 = new class_228(this);
        this.field_428 = var10001;
        Display var6 = Display.getDisplay(this);
        new class_240(var6, var1);
    }

    public void pauseApp() {}

    public void destroyApp(boolean var1) {}

    public void commandAction(Command var1, Displayable var2) {
        if (var1 == this.field_423) {
            Display.getDisplay(this).setCurrent(this.field_428);
            class_225 var10002 = new class_225(this);
            Thread var10000 = new Thread(var10002);
            var10000.start();
        } else if (var1 == this.field_425) {
            this.notifyDestroyed();
        } else if (var1 == this.field_438) {
            Display.getDisplay(this).setCurrent(this.field_439);
        } else if (var1 == this.field_443) {
            this.method_745();
        } else if (var1 == this.field_424) {
            Display.getDisplay(this).setCurrent(this.field_428);
        }
    }

    public void method_733(String var1) {
        if (var1 != null) {
            this.method_742(var1);
        }
    }

    public void method_734(Object var1) {
        if (var1 != null) {
            this.method_742(var1.toString());
        }
    }

    public void method_735() {
        this.method_742("");
    }

    public void method_736(int var1) {
        this.method_742(String.valueOf(var1));
    }

    public void method_737(String var1) {
        if (var1 != null) {
            this.method_738(var1);
        }
    }

    private void method_738(String var1) {
        this.field_432 = var1.toCharArray();
        this.method_740(true);
        this.field_428.repaint();
    }

    private void method_739(int var1, int var2, boolean var3) {
        if (this.field_433 < field_435.size() - 17) {
            ++this.field_433;
        }
        field_434.addElement(new String(this.field_432, var1, var2));
        field_435.addElement(var3 ? this.field_429 : this.field_430);
    }

    synchronized void method_740(boolean var1) {
        int var2 = this.field_432.length - 1;
        int var3 = 0;
        for (int var4 = 0; var4 < var2; ++var4) {
            if (this.field_432[var4] == 10) {
                this.field_432[var4] = 32;
                this.method_741(var3, var4, var1);
                ++var4;
                while (var4 < var2 && (this.field_432[var4] == 13 || this.field_432[var4] == 10)) {
                    ++var4;
                }
                var3 = var4--;
            } else if (this.field_432[var4] >= 0 && this.field_432[var4] < 32) {
                this.field_432[var4] = 32;
            }
        }
        this.method_741(var3, var2, var1);
    }

    private void method_741(int var1, int var2, boolean var3) {
        if (var1 < var2) {
            if (this.field_432[var2] == 32) {
                --var2;
            }
            int var5;
            for (; var2 > var1; this.method_739(var1, var1 - var5, var3)) {
                var5 = var1;
                int var4;
                for (var4 = 0; var4 < 230 && var1 <= var2; var4 += this.field_431.charWidth(this.field_432[var1++])) {
                    ;
                }
                if (var4 >= 230) {
                    --var1;
                }
            }
        }
    }

    private void method_742(String var1) {
        this.field_432 = var1.toCharArray();
        this.method_740(false);
        this.field_428.repaint();
    }

    public void method_743(int var1) {
        this.method_742(">>  " + var1);
    }

    public void method_744(String var1) {
        this.method_742(">>  " + var1);
    }

    private void method_745() {
        String var1 = this.getAppProperty("MIDlet-Version");
        String var2 = this.getAppProperty("MIDlet-Vendor");
        String var3 = this.getAppProperty("MIDlet-Info-URL");
        if (var1 == null) {
            var1 = "Unknown version";
        }
        if (var2 == null) {
            var2 = "Unknown vendor";
        }
        if (var3 == null) {
            var3 = "Unknown info URL";
        }
        this.field_442 = new Form("About");
        try {
            ImageItem var4 = new ImageItem((String)null, Image.createImage("/i_64.png"), 515, (String)null);
            this.field_442.append(var4);
        } catch (Exception var5) {
            ;
        }
        this.field_442.append("\nMobile Eclipse " + var1 + "\n\n" + "Developer: " + var2 + "\n\n" + var3);
        this.field_442.addCommand(this.field_424);
        this.field_442.setCommandListener(this);
        Display.getDisplay(this).setCurrent(this.field_442);
    }

    static {
        field_434 = new Vector(500);
        field_435 = new Vector(500);
    }
}
