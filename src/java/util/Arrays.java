package java.util;

import java.util.Comparator;
import java.lang.Comparable;
import java.util.List;

public class Arrays {

    public Arrays() {
    }

    public static void sort(int[] var0, int var1, int var2) {
        method_3177(var0, var1, var2 - var1);
    }

    public static void sort(int[] var0) {
        method_3177(var0, 0, var0.length);
    }

    public static void sort(Object[] var0, Comparator var1) {
        method_3175(var0, 0, var0.length, var1);
    }

    public static void sort(Comparable[] var0) {
        method_3176(var0, 0, var0.length);
    }

    public static void sort(Object[] var0, int var1, int var2, Comparator var3) {
        method_3175(var0, var1, var2 - var1, var3);
    }

    public static void fill(Object[] var0, Object var1) {
        for (int var2 = var0.length - 1; var2 >= 0; --var2) {
            var0[var2] = var1;
        }
    }

    public static void sort(List var0, Comparator var1) {
        Object[] var2 = var0.toArray();
        int var3 = var2.length;
        sort(var2, var1);
        var0.clear();
        for (int var4 = 0; var4 < var3; ++var4) {
            var0.add(var2[var4]);
        }
    }

    private static void method_3175(Object[] var0, int var1, int var2, Comparator var3) {
        for (int var4 = var1; var4 < var2 + var1; ++var4) {
            for (int var5 = var4; var5 > var1 && var3.compare(var0[var5 - 1], var0[var5]) > 0; --var5) {
                Object var6 = var0[var5];
                var0[var5] = var0[var5 - 1];
                var0[var5 - 1] = var6;
            }
        }
    }

    private static void method_3176(Comparable[] var0, int var1, int var2) {
        for (int var3 = var1; var3 < var2 + var1; ++var3) {
            for (int var4 = var3; var4 > var1 && var0[var4 - 1].compareTo(var0[var4]) > 0; --var4) {
                Comparable var5 = var0[var4];
                var0[var4] = var0[var4 - 1];
                var0[var4 - 1] = var5;
            }
        }
    }

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

    private static void method_3178(int[] var0, int var1, int var2) {
        int var3 = var0[var1];
        var0[var1] = var0[var2];
        var0[var2] = var3;
    }

    private static void method_3179(int[] var0, int var1, int var2, int var3) {
        for (int var4 = 0; var4 < var3; ++var2) {
            method_3178(var0, var1, var2);
            ++var4;
            ++var1;
        }
    }

    private static int method_3180(int[] var0, int var1, int var2, int var3) {
        return var0[var1] < var0[var2] ? (var0[var2] < var0[var3] ? var2 : (var0[var1] < var0[var3] ? var3 : var1)) : (var0[var2] > var0[var3] ? var2 : (var0[var1] > var0[var3] ? var3 : var1));
    }
}
