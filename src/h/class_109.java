package h;

import h.class_116;
import h.class_98;
import i.class_268;
import i.class_74;
import m.class_65;
import m.class_86;

public abstract class class_109 extends class_98 {

    public char[] field_568;

    public class_74 field_569;

    public class_116[] field_570;

    public int field_571;

    public class_109(char[] var1, int var2, int var3) {
        this.field_571 = -1;
        this.field_568 = var1;
        this.field_444 = var2;
        this.field_445 = var3;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_570 != null) {
                int var4 = 0;
                for (int var5 = this.field_570.length; var4 < var5; ++var4) {
                    class_116 var6 = this.field_570[var4];
                    boolean var7 = var6.method_875(var1, var2, this.field_569, this.field_571, (class_65)null);
                    if (var7) {
                        var2.method_2360(var3, this.field_444);
                        class_116.method_871(this.field_570, var4, var2);
                        if (this.field_571 != -1) {
                            var2.method_2363(var1, this.field_571);
                            var2.method_2088(var1, this.field_571);
                        }
                        return;
                    }
                }
            }
            var2.method_2209(this.field_569);
            var2.method_2360(var3, this.field_444);
            class_116.method_871(this.field_570, -1, var2);
            if (this.field_571 != -1) {
                var2.method_2363(var1, this.field_571);
                var2.method_2088(var1, this.field_571);
            }
        }
    }

    public void method_821(class_86 var1) {}
}
