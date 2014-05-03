package g;

import g.class_10;
import g.class_11;
import g.class_13;

// $FF: renamed from: g.s
public class class_316 {

    // $FF: renamed from: <init> () void
    public class_316() {
    }

    // $FF: renamed from: a (int[], int, int) void
    public static void method_3168(int[] var0, int var1, int var2) {
        method_3177(var0, var1, var2 - var1);
    }

    // $FF: renamed from: a (int[]) void
    public static void method_3169(int[] var0) {
        method_3177(var0, 0, var0.length);
    }

    // $FF: renamed from: a (java.lang.Object[], g.f) void
    public static void method_3170(Object[] var0, class_10 var1) {
        method_3175(var0, 0, var0.length, var1);
    }

    // $FF: renamed from: a (g.e[]) void
    public static void method_3171(class_11[] var0) {
        method_3176(var0, 0, var0.length);
    }

    // $FF: renamed from: a (java.lang.Object[], int, int, g.f) void
    public static void method_3172(Object[] var0, int var1, int var2, class_10 var3) {
        method_3175(var0, var1, var2 - var1, var3);
    }

    // $FF: renamed from: a (java.lang.Object[], java.lang.Object) void
    public static void method_3173(Object[] var0, Object var1) {
        for (int var2 = var0.length - 1; var2 >= 0; --var2) {
            var0[var2] = var1;
        }
    }

    // $FF: renamed from: a (g.l, g.f) void
    public static void method_3174(class_13 var0, class_10 var1) {
        Object[] var2 = var0.method_32();
        int var3 = var2.length;
        method_3170(var2, var1);
        var0.method_35();
        for (int var4 = 0; var4 < var3; ++var4) {
            var0.method_34(var2[var4]);
        }
    }

    // $FF: renamed from: b (java.lang.Object[], int, int, g.f) void
    private static void method_3175(Object[] var0, int var1, int var2, class_10 var3) {
        for (int var4 = var1; var4 < var2 + var1; ++var4) {
            for (int var5 = var4; var5 > var1 && var3.method_27(var0[var5 - 1], var0[var5]) > 0; --var5) {
                Object var6 = var0[var5];
                var0[var5] = var0[var5 - 1];
                var0[var5 - 1] = var6;
            }
        }
    }

    // $FF: renamed from: a (g.e[], int, int) void
    private static void method_3176(class_11[] var0, int var1, int var2) {
        for (int var3 = var1; var3 < var2 + var1; ++var3) {
            for (int var4 = var3; var4 > var1 && var0[var4 - 1].method_28(var0[var4]) > 0; --var4) {
                class_11 var5 = var0[var4];
                var0[var4] = var0[var4 - 1];
                var0[var4 - 1] = var5;
            }
        }
    }

    // $FF: renamed from: b (int[], int, int) void
    private static void method_3177(int[] var0, int var1, int var2) {
        int var3;
        int var4;
        if (var2 < 7) {
            for (var3 = var1; var3 < var2 + var1; ++var3) {
                for (var4 = var3; var4 > var1 && var0[var4 - 1] > var0[var4]; --var4) {
                    method_3178(var0, var4, var4 - 1);
                }
            }
        } else {
            var3 = var1 + (var2 >> 1);
            int var5;
            int var6;
            if (var2 > 7) {
                var4 = var1;
                var5 = var1 + var2 - 1;
                if (var2 > 40) {
                    var6 = var2 / 8;
                    var4 = method_3180(var0, var1, var1 + var6, var1 + 2 * var6);
                    var3 = method_3180(var0, var3 - var6, var3, var3 + var6);
                    var5 = method_3180(var0, var5 - 2 * var6, var5 - var6, var5);
                }
                var3 = method_3180(var0, var4, var3, var5);
            }
            var4 = var0[var3];
            var5 = var1;
            var6 = var1;
            int var7 = var1 + var2 - 1;
            int var8 = var7;
            while (true) {
                while (var6 > var7 || var0[var6] > var4) {
                    for (; var7 >= var6 && var0[var7] >= var4; --var7) {
                        if (var0[var7] == var4) {
                            method_3178(var0, var7, var8--);
                        }
                    }
                    if (var6 > var7) {
                        int var10 = var1 + var2;
                        int var9 = Math.min(var5 - var1, var6 - var5);
                        method_3179(var0, var1, var6 - var9, var9);
                        var9 = Math.min(var8 - var7, var10 - var8 - 1);
                        method_3179(var0, var6, var10 - var9, var9);
                        if ((var9 = var6 - var5) > 1) {
                            method_3177(var0, var1, var9);
                        }
                        if ((var9 = var8 - var7) > 1) {
                            method_3177(var0, var10 - var9, var9);
                        }
                        return;
                    }
                    method_3178(var0, var6++, var7--);
                }
                if (var0[var6] == var4) {
                    method_3178(var0, var5++, var6);
                }
                ++var6;
            }
        }
    }

    // $FF: renamed from: c (int[], int, int) void
    private static void method_3178(int[] var0, int var1, int var2) {
        int var3 = var0[var1];
        var0[var1] = var0[var2];
        var0[var2] = var3;
    }

    // $FF: renamed from: a (int[], int, int, int) void
    private static void method_3179(int[] var0, int var1, int var2, int var3) {
        for (int var4 = 0; var4 < var3; ++var2) {
            method_3178(var0, var1, var2);
            ++var4;
            ++var1;
        }
    }

    // $FF: renamed from: a (int[], int, int, int) int
    private static int method_3180(int[] var0, int var1, int var2, int var3) {
        return var0[var1] < var0[var2] ? (var0[var2] < var0[var3] ? var2 : (var0[var1] < var0[var3] ? var3 : var1)) : (var0[var2] > var0[var3] ? var2 : (var0[var1] > var0[var3] ? var3 : var1));
    }
}
