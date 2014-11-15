package org.eclipse.jdt.internal.compiler.batch;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;

import org.eclipse.jdt.internal.compiler.batch.eclipse;

class ConsoleCanvas extends Canvas {

    private final eclipse eclipseInst;

    ConsoleCanvas(eclipse var1) {
        this.eclipseInst = var1;
        this.setFullScreenMode(true);
    }

    protected void paint(Graphics var1) {
        var1.setColor(-16777215);
        var1.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int var2 = this.eclipseInst.currentLine; var2 < eclipse.outputTextBuffer.size() && var2 - this.eclipseInst.currentLine < 20; ++var2) {
            var1.setColor(((Integer)((Integer)eclipse.outputColorBuffer.elementAt(var2))).intValue());
            var1.drawString((String)((String)eclipse.outputTextBuffer.elementAt(var2)), 1, 2 + 18 * (var2 - this.eclipseInst.currentLine), 20);
        }
    }

    protected void keyPressed(int var1) {
        switch (var1) {
            case -7:
                Display.getDisplay(eclipse.instance).setCurrent(eclipse.instance.form);
                break;
            case -4:
                this.eclipseInst.currentLine += 15;
                if (this.eclipseInst.currentLine > eclipse.outputColorBuffer.size()) {
                    this.eclipseInst.currentLine -= 15;
                }
                break;
            case -3:
                this.eclipseInst.currentLine -= 15;
                if (this.eclipseInst.currentLine < 0) {
                    this.eclipseInst.currentLine = 0;
                }
                break;
            case -2:
                ++this.eclipseInst.currentLine;
                if (this.eclipseInst.currentLine > eclipse.outputColorBuffer.size()) {
                    --this.eclipseInst.currentLine;
                }
                break;
            case -1:
                --this.eclipseInst.currentLine;
                if (this.eclipseInst.currentLine < 0) {
                    this.eclipseInst.currentLine = 0;
                }
        }
        this.repaint();
    }
}
