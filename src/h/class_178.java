package h;

import a.class_332;
import c.class_264;
import f.class_215;
import h.class_177;
import i.class_268;
import m.class_40;
import m.class_86;

public class class_178 extends class_177 {

    double field_793;

    public class_178(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public void method_1081() {
        Double var1;
        try {
            var1 = Double.valueOf(String.valueOf(this.field_792));
        } catch (NumberFormatException var7) {
            try {
                double var3 = class_215.method_1224(this.field_792);
                if (var3 == Double.POSITIVE_INFINITY) {
                    return;
                }
                if (Double.isNaN(var3)) {
                    return;
                }
                this.field_793 = var3;
                this.field_672 = class_332.method_3291(var3);
            } catch (NumberFormatException var6) {
                ;
            }
            return;
        }
        double var2 = var1.doubleValue();
        if (var2 <= Double.MAX_VALUE) {
            if (var2 < Double.MIN_VALUE) {
                boolean var4 = false;
                int var5 = 0;
                label52:
                while (var5 < this.field_792.length) {
                    switch (this.field_792[var5]) {
                        case 68:
                        case 69:
                        case 70:
                        case 100:
                        case 101:
                        case 102:
                            if (var4) {
                                return;
                            }
                        case 80:
                        case 112:
                            break label52;
                        case 88:
                        case 120:
                            var4 = true;
                        case 46:
                        case 48:
                            ++var5;
                            break;
                        default:
                            return;
                    }
                }
            }
            this.field_793 = var2;
            this.field_672 = class_332.method_3291(this.field_793);
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public class_40 method_1082(class_86 var1) {
        return class_40.field_185;
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2015(this, var2);
        var1.method_1930(this, var2);
    }
}
