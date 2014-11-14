package n;

import a.class_33;
import a.CompilerOptions;
import b.CharOperation;
import b.class_235;
import c.class_284;
import c.class_7;
import c.class_8;
import f.Util;
import n.class_241;

public class class_247 {

    public static final String[] field_1061;

    public final class_7 field_1062;

    public final class_8 field_1063;

    public final CompilerOptions field_1064;

    public class_247(class_7 var1, CompilerOptions var2, class_8 var3) {
        this.field_1062 = var1;
        this.field_1063 = var3;
        this.field_1064 = var2;
    }

    public int method_1449(int var1) {
        return 1;
    }

    public class_235 method_1450(String var1, int var2, String[] var3, String[] var4, int var5, int var6, int var7, int var8, int var9) {
        return this.field_1063.method_24(var1, var2, var3, var4, var5, var6, var7, var8, var9);
    }

    public class_235 method_1451(String var1, int var2, String[] var3, int var4, String[] var5, int var6, int var7, int var8, int var9, int var10) {
        return this.field_1063.method_25(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
    }

    public void method_1452(int var1, String[] var2, int var3, String[] var4, int var5, int var6, int var7, class_33 var8, class_284 var9) {
        if (var5 != -1) {
            if (var8 == null) {
                if ((var5 & 1) != 0) {
                    class_235 var16 = this.method_1451((String)null, var1, var2, var3, var4, var5, 0, 0, 0, 0);
                    class_241 var15 = new class_241((class_284)null, var16);
                    throw var15;
                }
            } else {
                int[] var10;
                int var11 = var6 >= 0 ? Util.method_1324(var6, var10 = var9.method_2921(), 0, var10.length - 1) : 0;
                int var12 = var6 >= 0 ? Util.method_1327(var9.method_2921(), var11, var6) : 0;
                class_235 var13 = this.method_1451(var9.method_2920(), var1, var2, var3, var4, var5, var6, var7, var11, var12);
                if (var13 != null) {
                    switch (var5 & 1) {
                        case 0:
                            this.method_1454(var13, var9, var8);
                            break;
                        case 1:
                            this.method_1454(var13, var9, var8);
                            if ((var5 & 128) != 0) {
                                var8.method_96();
                                int var10000 = this.field_1062.method_23() ? 2 : var5 & 30;
                                int var14 = var10000;
                                if (var10000 != 0) {
                                    var8.method_93(var14, var13);
                                }
                            }
                    }
                }
            }
        }
    }

    public void method_1453(int var1, String[] var2, String[] var3, int var4, int var5, class_33 var6, class_284 var7) {
        this.method_1452(var1, var2, 0, var3, this.method_1449(var1), var4, var5, var6, var7);
    }

    public void method_1454(class_235 var1, class_284 var2, class_33 var3) {
        var2.method_2929(var1, var3);
    }

    static {
        field_1061 = CharOperation.field_996;
    }
}
