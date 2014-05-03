package batch;

import batch.eclipse;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;

// $FF: renamed from: batch.i
class class_228 extends Canvas {

    // $FF: renamed from: a batch.eclipse
    private final eclipse field_986;

    // $FF: renamed from: <init> (batch.eclipse) void
    class_228(eclipse var1) {
        this.field_986 = var1;
        this.setFullScreenMode(true);
    }

    protected void paint(Graphics var1) {
        var1.setColor(-16777215);
        var1.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int var2 = this.field_986.field_433; var2 < eclipse.field_434.size() && var2 - this.field_986.field_433 < 20; ++var2) {
            var1.setColor(((Integer)((Integer)eclipse.field_435.elementAt(var2))).intValue());
            var1.drawString((String)((String)eclipse.field_434.elementAt(var2)), 1, 2 + 18 * (var2 - this.field_986.field_433), 20);
        }
    }

    protected void keyPressed(int var1) {
        switch (var1) {
            case -7:
                Display.getDisplay(eclipse.field_427).setCurrent(eclipse.field_427.field_426);
                break;
            case -4:
                this.field_986.field_433 += 15;
                if (this.field_986.field_433 > eclipse.field_435.size()) {
                    this.field_986.field_433 -= 15;
                }
                break;
            case -3:
                this.field_986.field_433 -= 15;
                if (this.field_986.field_433 < 0) {
                    this.field_986.field_433 = 0;
                }
                break;
            case -2:
                ++this.field_986.field_433;
                if (this.field_986.field_433 > eclipse.field_435.size()) {
                    --this.field_986.field_433;
                }
                break;
            case -1:
                --this.field_986.field_433;
                if (this.field_986.field_433 < 0) {
                    this.field_986.field_433 = 0;
                }
        }
        this.repaint();
    }
}
