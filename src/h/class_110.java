package h;

import c.class_264;
import h.class_109;
import h.class_116;
import h.class_117;
import h.class_89;
import l.class_293;
import l.class_294;
import l.class_301;
import m.class_86;

public class class_110 extends class_109 {

    public class_110(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_293 var4 = this.field_568 == null ? var2.method_3038() : var2.method_3036(this.field_568);
        if (var4 == null) {
            if (this.field_568 == null) {
                var1.method_644().method_1625(this);
            } else {
                var1.method_644().method_1781(this);
            }
            return var3;
        } else if (var4 == class_293.field_1738) {
            var1.method_644().method_1625(this);
            return var3;
        } else {
            this.field_571 = var1.method_635().method_729(var3);
            this.field_569 = var4.method_3034();
            class_293 var5 = var2;
            int var6 = 0;
            this.field_570 = new class_116[5];
            do {
                class_116 var7;
                if ((var7 = var5.method_3052()) != null) {
                    if (var6 == this.field_570.length) {
                        System.arraycopy(this.field_570, 0, this.field_570 = new class_116[var6 * 2], 0, var6);
                    }
                    this.field_570[var6++] = var7;
                    if (var7.method_876()) {
                        break;
                    }
                }
                var5.method_3048(var3.method_3109());
                if (var5 instanceof class_294) {
                    class_89 var8 = var5.field_1739;
                    if (var8 instanceof class_117) {
                        class_117 var9 = (class_117)var8;
                        var3.method_3071(var9.field_624);
                    }
                } else if (var5 == var4) {
                    var4.method_3046(var2, var3);
                    break;
                }
            } while ((var5 = var5.field_1740) != null);
            if (var6 != this.field_570.length) {
                System.arraycopy(this.field_570, 0, this.field_570 = new class_116[var6], 0, var6);
            }
            return class_301.field_1784;
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("continue ");
        if (this.field_568 != null) {
            var2.append(this.field_568);
        }
        return var2.append(';');
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2013(this, var2);
        var1.method_1928(this, var2);
    }
}
