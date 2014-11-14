package batch;

import SpashScreen;
import batch.CompileRunner;
import batch.ConsoleCanvas;
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

    TextField srcTextbox;

    TextField libTextbox;

    TextField classOutTextbox;

    Command compileCommand;

    Command resultCommand;

    Command exitCommand;

    Form form;

    public static eclipse instance;

    ConsoleCanvas canvas;

    Integer field_429;

    Integer field_430;

    Font font;

    char[] field_432;

    int field_433;

    static Vector field_434;

    static Vector field_435;

    TextField resTextbox;

    TextField resOutTextbox;

    Command hideCommand;

    Displayable nullScreen;

    private Ticker creditTicker;

    private Ticker developerTicker;

    private Form aboutForm;

    Command aboutCommand;

    public eclipse() {
        this.aboutCommand = new Command("About", 5, 1);
        this.compileCommand = new Command("Compile", 4, 1);
        this.hideCommand = new Command("Hide", 2, 1);
        this.resultCommand = new Command("Result", 3, 1);
        this.exitCommand = new Command("Exit", 7, 1);
        this.creditTicker = new Ticker("Credits: Alvin Alexander & Yosep Karli");
        this.developerTicker = new Ticker("Developer: ASM \u00a9 2012-2013");
        this.field_429 = new Integer(16711680);
        this.field_430 = new Integer(255);
        this.font = Font.getDefaultFont();
        this.field_433 = 0;
    }

    public void startApp() {
        Form var1 = new Form("Mobile Eclipse JDT");
        Random var10000 = new Random();
        boolean var2 = true;
        Random var4 = var10000;
        int var5;
        if ((var5 = (int)(1L * (long)var4.nextInt() >> 31)) == 1) {
            var1.setTicker(this.creditTicker);
        } else if (var5 == 0) {
            var1.setTicker(this.developerTicker);
        }
        this.srcTextbox = new TextField("Sources", "/E:/src", 256, 0);
        this.resTextbox = new TextField("Resources", "/E:/res", 256, 0);
        this.libTextbox = new TextField("Library", "/E:/lib", 256, 0);
        this.classOutTextbox = new TextField("Class Ouput", "/E:/build", 256, 0);
        this.resOutTextbox = new TextField("Res Ouput", "/E:/build", 256, 0);
        var1.append(this.srcTextbox);
        var1.append(this.resTextbox);
        var1.append(this.libTextbox);
        var1.append(this.classOutTextbox);
        var1.append(this.resOutTextbox);
        var1.addCommand(this.exitCommand);
        var1.addCommand(this.aboutCommand);
        var1.addCommand(this.compileCommand);
        var1.addCommand(this.resultCommand);
        var1.addCommand(this.hideCommand);
        var1.setCommandListener(this);
        this.form = var1;
        instance = this;
        ConsoleCanvas var10001 = new ConsoleCanvas(this);
        this.canvas = var10001;
        Display var6 = Display.getDisplay(this);
        new SpashScreen(var6, var1);
    }

    public void pauseApp() {}

    public void destroyApp(boolean var1) {}

    public void commandAction(Command var1, Displayable var2) {
        if (var1 == this.compileCommand) {
            Display.getDisplay(this).setCurrent(this.canvas);
            CompileRunner var10002 = new CompileRunner(this);
            Thread var10000 = new Thread(var10002);
            var10000.start();
        } else if (var1 == this.exitCommand) {
            this.notifyDestroyed();
        } else if (var1 == this.hideCommand) {
            Display.getDisplay(this).setCurrent(this.nullScreen);
        } else if (var1 == this.aboutCommand) {
            this.showAbout();
        } else if (var1 == this.resultCommand) {
            Display.getDisplay(this).setCurrent(this.canvas);
        }
    }

    public void print(String var1) {
        if (var1 != null) {
            this.method_742(var1);
        }
    }

    public void print(Object var1) {
        if (var1 != null) {
            this.method_742(var1.toString());
        }
    }

    public void newLine() {
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
        this.canvas.repaint();
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
                for (var4 = 0; var4 < 230 && var1 <= var2; var4 += this.font.charWidth(this.field_432[var1++])) {
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
        this.canvas.repaint();
    }

    public void method_743(int var1) {
        this.method_742(">>  " + var1);
    }

    public void method_744(String var1) {
        this.method_742(">>  " + var1);
    }

    private void showAbout() {
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
        this.aboutForm = new Form("About");
        try {
            ImageItem var4 = new ImageItem((String)null, Image.createImage("/i_64.png"), 515, (String)null);
            this.aboutForm.append(var4);
        } catch (Exception var5) {
            ;
        }
        this.aboutForm.append("\nMobile Eclipse " + var1 + "\n\n" + "Developer: " + var2 + "\n\n" + var3);
        this.aboutForm.addCommand(this.resultCommand);
        this.aboutForm.setCommandListener(this);
        Display.getDisplay(this).setCurrent(this.aboutForm);
    }

    static {
        field_434 = new Vector(500);
        field_435 = new Vector(500);
    }
}
