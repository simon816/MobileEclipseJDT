package d;

import d.class_231;
import h.class_114;
import h.class_121;
import h.class_122;
import h.class_93;

public class class_230 {

    public class_230() {
    }

    public static boolean method_1340(class_93 var0) {
        return var0.field_445 + 1 == var0.field_490 || var0.field_491 == var0.field_481;
    }

    public static int[][] method_1341(class_114[] var0) {
        if (var0 != null && var0.length != 0) {
            class_231 var10000 = new class_231();
            class_231 var1 = var10000;
            method_1342(var0, var1);
            return var1.method_1347();
        } else {
            return new int[3][0];
        }
    }

    private static void method_1342(class_114[] var0, class_231 var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            class_114[] var3 = var0[var2].field_585;
            if (var3 != null && var3.length > 0) {
                method_1342(var0[var2].field_585, var1);
            }
            class_93[] var4 = var0[var2].field_584;
            int var6;
            if (var4 != null) {
                int var5 = var4.length;
                for (var6 = 0; var6 < var5; ++var6) {
                    class_93 var7 = var4[var6];
                    if (method_1343(var7)) {
                        if (method_1340(var7)) {
                            var7.field_446 |= 32;
                            var1.method_1346(var7.field_480, var7.field_481, 2);
                        } else {
                            int var8 = var7.field_445 + 1 == var7.field_490 ? 1 : 0;
                            var1.method_1346(var7.field_490, var7.field_491, var8);
                        }
                    }
                }
            }
            class_121[] var9 = var0[var2].field_583;
            if (var9 != null) {
                var6 = var9.length;
                for (int var10 = 0; var10 < var6; ++var10) {
                    if (var9[var10] instanceof class_122) {
                        class_122 var11 = (class_122)var9[var10];
                        if (var11.field_652 == var11.field_667 && var11.field_653 != var11.field_652) {
                            var11.field_446 |= 32;
                            var1.method_1346(var11.field_653, var11.field_652, 2);
                        } else {
                            var1.method_1345(var11.field_666, var11.field_667);
                        }
                    }
                }
            }
        }
    }

    public static boolean method_1343(class_93 var0) {
        return !var0.method_796() && !var0.method_794() && (var0.field_482 & 16777216) == 0;
    }
}
