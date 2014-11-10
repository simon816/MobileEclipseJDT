package j;

import a.class_33;
import c.class_264;
import h.class_114;
import h.class_122;
import h.class_93;
import h.class_94;
import h.class_96;
import j.class_270;
import j.class_278;
import m.class_84;
import m.class_86;
import m.class_87;

class class_265 extends class_264 {

    public class_264 field_1159;

    class_114 field_1160;

    class_114[] field_1161;

    int field_1162;

    private final class_278 field_1163;

    class_265(class_278 var1) {
        this.field_1163 = var1;
        this.field_1161 = new class_114[0];
        this.field_1162 = -1;
    }

    public boolean method_2012(class_94 var1, class_84 var2) {
        this.field_1162 = -1;
        return true;
    }

    public boolean method_2027(class_122 var1, class_87 var2) {
        this.field_1162 = -1;
        return var1.field_664 != null;
    }

    public boolean method_2036(class_96 var1, class_84 var2) {
        this.field_1162 = -1;
        return true;
    }

    public boolean method_2066(class_114 var1, class_86 var2) {
        return this.method_2075(var1);
    }

    public boolean method_2067(class_114 var1, class_84 var2) {
        return this.method_2075(var1);
    }

    private boolean method_2075(class_114 var1) {
        if (this.field_1161.length <= ++this.field_1162) {
            int var2 = this.field_1162;
            System.arraycopy(this.field_1161, 0, this.field_1161 = new class_114[var2 * 2 + 1], 0, var2);
        }
        this.field_1161[this.field_1162] = var1;
        return false;
    }

    public void method_1927(class_94 var1, class_84 var2) {
        this.method_2076(var1, var2);
    }

    public void method_1951(class_96 var1, class_84 var2) {
        this.method_2076(var1, var2);
    }

    private void method_2076(class_93 var1, class_84 var2) {
        class_114[] var3 = null;
        int var4 = 0;
        if (this.field_1162 > -1) {
            var4 = this.field_1162 + 1;
            var3 = new class_114[var4];
            System.arraycopy(this.field_1161, 0, var3, 0, var4);
        }
        class_33 var5 = this.field_1163.field_1615;
        this.field_1163.field_1627.method_2435(var1.field_490, var1.field_491);
        class_270 var6 = this.field_1163.field_1628;
        this.field_1163.field_1628 = this.field_1163.field_1627;
        this.field_1163.method_2860(var1, var1.field_490, var1.field_491, var3, this.field_1163.field_1561);
        this.field_1163.field_1628 = var6;
        this.field_1163.field_1615 = var5;
        for (int var7 = 0; var7 < var4; ++var7) {
            var3[var7].method_869(this.field_1159, var2);
        }
    }

    public void method_1942(class_122 var1, class_87 var2) {
        if (var1.field_664 != null) {
            class_114[] var3 = null;
            int var4 = 0;
            if (this.field_1162 > -1) {
                var4 = this.field_1162 + 1;
                var3 = new class_114[var4];
                System.arraycopy(this.field_1161, 0, var3, 0, var4);
            }
            class_33 var5 = this.field_1163.field_1615;
            this.field_1163.field_1627.method_2435(var1.field_666, var1.field_667);
            class_270 var6 = this.field_1163.field_1628;
            this.field_1163.field_1628 = this.field_1163.field_1627;
            this.field_1163.method_2860(this.field_1160, var1.field_666, var1.field_667, var3, this.field_1163.field_1561);
            this.field_1163.field_1628 = var6;
            this.field_1163.field_1615 = var5;
            for (int var7 = 0; var7 < var4; ++var7) {
                var3[var7].method_763(this.field_1159, var2);
            }
        }
    }
}
