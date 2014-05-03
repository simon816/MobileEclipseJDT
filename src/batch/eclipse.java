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

    // $FF: renamed from: a javax.microedition.lcdui.TextField
    TextField field_420;
    // $FF: renamed from: b javax.microedition.lcdui.TextField
    TextField field_421;
    // $FF: renamed from: c javax.microedition.lcdui.TextField
    TextField field_422;
    // $FF: renamed from: a javax.microedition.lcdui.Command
    Command field_423;
    // $FF: renamed from: b javax.microedition.lcdui.Command
    Command field_424;
    // $FF: renamed from: c javax.microedition.lcdui.Command
    Command field_425;
    // $FF: renamed from: a javax.microedition.lcdui.Form
    Form field_426;
    // $FF: renamed from: a batch.eclipse
    public static eclipse field_427;
    // $FF: renamed from: a batch.i
    class_228 field_428;
    // $FF: renamed from: a java.lang.Integer
    Integer field_429;
    // $FF: renamed from: b java.lang.Integer
    Integer field_430;
    // $FF: renamed from: a javax.microedition.lcdui.Font
    Font field_431;
    // $FF: renamed from: a char[]
    char[] field_432;
    // $FF: renamed from: a int
    int field_433;
    // $FF: renamed from: a java.util.Vector
    static Vector field_434;
    // $FF: renamed from: b java.util.Vector
    static Vector field_435;
    // $FF: renamed from: d javax.microedition.lcdui.TextField
    TextField field_436;
    // $FF: renamed from: e javax.microedition.lcdui.TextField
    TextField field_437;
    // $FF: renamed from: d javax.microedition.lcdui.Command
    Command field_438;
    // $FF: renamed from: a javax.microedition.lcdui.Displayable
    Displayable field_439;
    // $FF: renamed from: a javax.microedition.lcdui.Ticker
    private Ticker field_440;
    // $FF: renamed from: b javax.microedition.lcdui.Ticker
    private Ticker field_441;
    // $FF: renamed from: b javax.microedition.lcdui.Form
    private Form field_442;
    // $FF: renamed from: e javax.microedition.lcdui.Command
    Command field_443;

    // $FF: renamed from: <init> () void
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

    // $FF: renamed from: a (java.lang.String) void
    public void method_733(String var1) {
        if (var1 != null) {
            this.method_742(var1);
        }
    }

    // $FF: renamed from: a (java.lang.Object) void
    public void method_734(Object var1) {
        if (var1 != null) {
            this.method_742(var1.toString());
        }
    }

    // $FF: renamed from: a () void
    public void method_735() {
        this.method_742("");
    }

    // $FF: renamed from: a (int) void
    public void method_736(int var1) {
        this.method_742(String.valueOf(var1));
    }

    // $FF: renamed from: b (java.lang.String) void
    public void method_737(String var1) {
        if (var1 != null) {
            this.method_738(var1);
        }
    }

    // $FF: renamed from: d (java.lang.String) void
    private void method_738(String var1) {
        this.field_432 = var1.toCharArray();
        this.method_740(true);
        this.field_428.repaint();
    }

    // $FF: renamed from: a (int, int, boolean) void
    private void method_739(int var1, int var2, boolean var3) {
        if (this.field_433 < field_435.size() - 17) {
            ++this.field_433;
        }
        field_434.addElement(new String(this.field_432, var1, var2));
        field_435.addElement(var3 ? this.field_429 : this.field_430);
    }

    // $FF: renamed from: a (boolean) void
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

    // $FF: renamed from: b (int, int, boolean) void
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

    // $FF: renamed from: e (java.lang.String) void
    private void method_742(String var1) {
        this.field_432 = var1.toCharArray();
        this.method_740(false);
        this.field_428.repaint();
    }

    // $FF: renamed from: b (int) void
    public void method_743(int var1) {
        this.method_742(">>  " + var1);
    }

    // $FF: renamed from: c (java.lang.String) void
    public void method_744(String var1) {
        this.method_742(">>  " + var1);
    }

    // $FF: renamed from: b () void
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

    // $FF: renamed from: <clinit> () void
    static {
        field_434 = new Vector(500);
        field_435 = new Vector(500);
    }
}
