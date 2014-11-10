package l;

import h.class_89;
import l.class_293;
import l.class_298;
import l.class_301;
import l.class_303;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_86;

public class class_299 extends class_298 {

    public int field_1772;

    public class_40[] field_1773;

    public class_89[] field_1774;

    public class_301[] field_1775;

    public class_299(class_293 var1, class_89 var2, class_86 var3) {
        super(var1, var2, class_34.field_151, var3, class_301.field_1784);
        this.field_1773 = new class_40[5];
        this.field_1774 = new class_89[5];
        this.field_1775 = new class_301[5];
    }

    public void method_3067(class_86 var1, class_293 var2, class_301 var3) {
        for (int var4 = 0; var4 < this.field_1772; ++var4) {
            var2.method_3032(this.field_1773[var4], this.field_1774[var4], this.field_1775[var4], var1);
        }
    }

    public String method_3039() {
        StringBuffer var1 = new StringBuffer("Initialization flow context");
        for (int var2 = 0; var2 < this.field_1772; ++var2) {
            var1.append('[').append(this.field_1773[var2].method_103());
            var1.append('-').append(this.field_1775[var2].toString()).append(']');
        }
        return var1.toString();
    }

    public void method_3065(class_43 var1, class_303 var2, class_40 var3, class_89 var4, boolean var5) {
        int var6 = this.field_1773.length;
        if (this.field_1772 == var6) {
            System.arraycopy(this.field_1773, 0, this.field_1773 = new class_40[var6 * 2], 0, var6);
            System.arraycopy(this.field_1774, 0, this.field_1774 = new class_89[var6 * 2], 0, var6);
            System.arraycopy(this.field_1775, 0, this.field_1775 = new class_301[var6 * 2], 0, var6);
        }
        this.field_1773[this.field_1772] = var3;
        this.field_1774[this.field_1772] = var4;
        this.field_1775[this.field_1772++] = var2.method_3078();
    }
}
