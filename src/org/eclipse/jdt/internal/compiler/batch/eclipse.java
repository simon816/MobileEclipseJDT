package org.eclipse.jdt.internal.compiler.batch;

import SpashScreen;

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

import org.eclipse.jdt.internal.compiler.batch.CompileRunner;
import org.eclipse.jdt.internal.compiler.batch.ConsoleCanvas;

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

    Integer stdErrColor;

    Integer stdOutColor;

    Font font;

    char[] currentTextOutput;

    int currentLine;

    static Vector outputTextBuffer;

    static Vector outputColorBuffer;

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
        this.stdErrColor = new Integer(16711680);
        this.stdOutColor = new Integer(255);
        this.font = Font.getDefaultFont();
        this.currentLine = 0;
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

    public void println(String var1) {
        if (var1 != null) {
            this.writeLine(var1);
        }
    }

    public void println(Object var1) {
        if (var1 != null) {
            this.writeLine(var1.toString());
        }
    }

    public void println() {
        this.writeLine("");
    }

    public void println(int var1) {
        this.writeLine(String.valueOf(var1));
    }

    public void printErrLn(String var1) {
        if (var1 != null) {
            this.writeErrorLine(var1);
        }
    }

    private void writeErrorLine(String var1) {
        this.currentTextOutput = var1.toCharArray();
        this.wrapAndBufferText(true);
        this.canvas.repaint();
    }

    private void addLineToBuffer(int var1, int var2, boolean var3) {
        if (this.currentLine < outputColorBuffer.size() - 17) {
            ++this.currentLine;
        }
        outputTextBuffer.addElement(new String(this.currentTextOutput, var1, var2));
        outputColorBuffer.addElement(var3 ? this.stdErrColor : this.stdOutColor);
    }

    synchronized void wrapAndBufferText(boolean var1) {
        int var2 = this.currentTextOutput.length - 1;
        int var3 = 0;
        for (int var4 = 0; var4 < var2; ++var4) {
            if (this.currentTextOutput[var4] == 10) {
                this.currentTextOutput[var4] = 32;
                this.bufferText(var3, var4, var1);
                ++var4;
                while (var4 < var2 && (this.currentTextOutput[var4] == 13 || this.currentTextOutput[var4] == 10)) {
                    ++var4;
                }
                var3 = var4--;
            } else if (this.currentTextOutput[var4] >= 0 && this.currentTextOutput[var4] < 32) {
                this.currentTextOutput[var4] = 32;
            }
        }
        this.bufferText(var3, var2, var1);
    }

    private void bufferText(int var1, int var2, boolean var3) {
        if (var1 < var2) {
            if (this.currentTextOutput[var2] == 32) {
                --var2;
            }
            int var5;
            for (; var2 > var1; this.addLineToBuffer(var1, var1 - var5, var3)) {
                var5 = var1;
                int var4;
                for (var4 = 0; var4 < 230 && var1 <= var2; var4 += this.font.charWidth(this.currentTextOutput[var1++])) {
                    ;
                }
                if (var4 >= 230) {
                    --var1;
                }
            }
        }
    }

    private void writeLine(String var1) {
        this.currentTextOutput = var1.toCharArray();
        this.wrapAndBufferText(false);
        this.canvas.repaint();
    }

    public void print(int var1) {
        this.writeLine(">>  " + var1);
    }

    public void print(String var1) {
        this.writeLine(">>  " + var1);
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
        outputTextBuffer = new Vector(500);
        outputColorBuffer = new Vector(500);
    }
}
