package org.eclipse.jdt.core.compiler;

import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

public final class CharOperation {

    public static final char[] field_994;

    public static final char[][] field_995;

    public static final String[] field_996;

    public CharOperation() {
    }

    public static final char[][] method_1353(char[][] var0, char[] var1) {
        if (var1 == null) {
            return var0;
        } else if (var0 == null) {
            return new char[][] {var1};
        } else {
            int var2 = var0.length;
            char[][] var3 = new char[var2 + 1][];
            System.arraycopy(var0, 0, var3, 0, var2);
            var3[var2] = var1;
            return var3;
        }
    }

    public static final int method_1354(char[] var0, char[] var1) {
        int var2 = var0.length;
        int var3 = var1.length;
        int var4 = Math.min(var2, var3);
        for (int var5 = 0; var5 < var4; ++var5) {
            if (var0[var5] != var1[var5]) {
                return var0[var5] - var1[var5];
            }
        }
        return var2 - var3;
    }

    public static final char[] method_1355(char[] var0, char[] var1) {
        if (var0 == null) {
            return var1;
        } else if (var1 == null) {
            return var0;
        } else {
            int var2 = var0.length;
            int var3 = var1.length;
            char[] var4 = new char[var2 + var3];
            System.arraycopy(var0, 0, var4, 0, var2);
            System.arraycopy(var1, 0, var4, var2, var3);
            return var4;
        }
    }

    public static final char[] method_1356(char[] var0, char[] var1, char[] var2) {
        if (var0 == null) {
            return method_1355(var1, var2);
        } else if (var1 == null) {
            return method_1355(var0, var2);
        } else if (var2 == null) {
            return method_1355(var0, var1);
        } else {
            int var3 = var0.length;
            int var4 = var1.length;
            int var5 = var2.length;
            char[] var6 = new char[var3 + var4 + var5];
            System.arraycopy(var0, 0, var6, 0, var3);
            System.arraycopy(var1, 0, var6, var3, var4);
            System.arraycopy(var2, 0, var6, var3 + var4, var5);
            return var6;
        }
    }

    public static final char[] method_1357(char[] var0, char[] var1, char var2) {
        if (var0 == null) {
            return var1;
        } else if (var1 == null) {
            return var0;
        } else {
            int var3 = var0.length;
            if (var3 == 0) {
                return var1;
            } else {
                int var4 = var1.length;
                if (var4 == 0) {
                    return var0;
                } else {
                    char[] var5 = new char[var3 + var4 + 1];
                    System.arraycopy(var0, 0, var5, 0, var3);
                    var5[var3] = var2;
                    System.arraycopy(var1, 0, var5, var3 + 1, var4);
                    return var5;
                }
            }
        }
    }

    public static final char[] method_1358(char[] var0, char var1, char[] var2, char var3, char[] var4) {
        if (var0 == null) {
            return method_1357(var2, var4, var3);
        } else if (var2 == null) {
            return method_1357(var0, var4, var1);
        } else if (var4 == null) {
            return method_1357(var0, var2, var1);
        } else {
            int var5 = var0.length;
            int var6 = var2.length;
            int var7 = var4.length;
            char[] var8 = new char[var5 + var6 + var7 + 2];
            System.arraycopy(var0, 0, var8, 0, var5);
            var8[var5] = var1;
            System.arraycopy(var2, 0, var8, var5 + 1, var6);
            var8[var5 + var6 + 1] = var3;
            System.arraycopy(var4, 0, var8, var5 + var6 + 2, var7);
            return var8;
        }
    }

    public static final char[] method_1359(char var0, char[] var1, char var2) {
        if (var1 == null) {
            return new char[] {var0, var2};
        } else {
            int var3 = var1.length;
            char[] var4 = new char[var3 + 2];
            var4[0] = var0;
            System.arraycopy(var1, 0, var4, 1, var3);
            var4[var3 + 1] = var2;
            return var4;
        }
    }

    public static final char[] method_1360(char[][] var0, char[] var1, char var2) {
        int var3 = var1 == null ? 0 : var1.length;
        if (var3 == 0) {
            return method_1361(var0, var2);
        } else {
            int var4 = var0 == null ? 0 : var0.length;
            if (var4 == 0) {
                return var1;
            } else {
                int var5 = var3;
                int var6 = var4;
                while (true) {
                    --var6;
                    if (var6 < 0) {
                        char[] var7 = new char[var5];
                        var6 = 0;
                        for (int var8 = 0; var8 < var4; ++var8) {
                            int var9 = var0[var8].length;
                            if (var9 > 0) {
                                System.arraycopy(var0[var8], 0, var7, var6, var9);
                                var6 += var9;
                                var7[var6++] = var2;
                            }
                        }
                        System.arraycopy(var1, 0, var7, var6, var3);
                        return var7;
                    }
                    if (var0[var6].length > 0) {
                        var5 += var0[var6].length + 1;
                    }
                }
            }
        }
    }

    public static final char[] method_1361(char[][] var0, char var1) {
        int var2 = var0 == null ? 0 : var0.length;
        if (var2 == 0) {
            return field_994;
        } else {
            int var3 = var2 - 1;
            int var4 = var2;
            while (true) {
                --var4;
                if (var4 < 0) {
                    if (var3 <= 0) {
                        return field_994;
                    }
                    char[] var5 = new char[var3];
                    var4 = var2;
                    while (true) {
                        --var4;
                        if (var4 < 0) {
                            return var5;
                        }
                        var2 = var0[var4].length;
                        if (var2 > 0) {
                            System.arraycopy(var0[var4], 0, var5, var3 -= var2, var2);
                            --var3;
                            if (var3 >= 0) {
                                var5[var3] = var1;
                            }
                        }
                    }
                }
                if (var0[var4].length == 0) {
                    --var3;
                } else {
                    var3 += var0[var4].length;
                }
            }
        }
    }

    public static final char[][] method_1362(char[][] var0) {
        int var1 = var0.length;
        char[][] var2 = new char[var1][];
        for (int var3 = 0; var3 < var1; ++var3) {
            char[] var4 = var0[var3];
            int var5 = var4.length;
            char[] var6 = new char[var5];
            System.arraycopy(var4, 0, var6, 0, var5);
            var2[var3] = var6;
        }
        return var2;
    }

    public static final boolean method_1363(char[][] var0, char[][] var1) {
        if (var0 == var1) {
            return true;
        } else if (var0 != null && var1 != null) {
            if (var0.length != var1.length) {
                return false;
            } else {
                int var2 = var0.length;
                do {
                    --var2;
                    if (var2 < 0) {
                        return true;
                    }
                } while (method_1364(var0[var2], var1[var2]));
                return false;
            }
        } else {
            return false;
        }
    }

    public static final boolean method_1364(char[] var0, char[] var1) {
        if (var0 == var1) {
            return true;
        } else if (var0 != null && var1 != null) {
            if (var0.length != var1.length) {
                return false;
            } else {
                int var2 = var0.length;
                do {
                    --var2;
                    if (var2 < 0) {
                        return true;
                    }
                } while (var0[var2] == var1[var2]);
                return false;
            }
        } else {
            return false;
        }
    }

    public static final boolean method_1365(char[] var0, char[] var1, int var2, int var3) {
        return method_1366(var0, var1, var2, var3, true);
    }

    public static final boolean method_1366(char[] var0, char[] var1, int var2, int var3, boolean var4) {
        if (var0 == var1) {
            return true;
        } else if (var0 != null && var1 != null) {
            if (var0.length != var3 - var2) {
                return false;
            } else {
                int var5;
                if (var4) {
                    var5 = var0.length;
                    while (true) {
                        --var5;
                        if (var5 < 0) {
                            break;
                        }
                        if (var0[var5] != var1[var5 + var2]) {
                            return false;
                        }
                    }
                } else {
                    var5 = var0.length;
                    while (true) {
                        --var5;
                        if (var5 < 0) {
                            break;
                        }
                        if (ScannerHelper.method_3341(var0[var5]) != ScannerHelper.method_3341(var1[var5 + var2])) {
                            return false;
                        }
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    public static final boolean method_1367(char[] var0, char[] var1, boolean var2) {
        if (var2) {
            return method_1364(var0, var1);
        } else if (var0 == var1) {
            return true;
        } else if (var0 != null && var1 != null) {
            if (var0.length != var1.length) {
                return false;
            } else {
                int var3 = var0.length;
                do {
                    --var3;
                    if (var3 < 0) {
                        return true;
                    }
                } while (ScannerHelper.method_3341(var0[var3]) == ScannerHelper.method_3341(var1[var3]));
                return false;
            }
        } else {
            return false;
        }
    }

    public static final boolean method_1368(char[] var0, char[] var1, int var2, boolean var3) {
        int var4 = var0.length;
        if (var1.length < var4 + var2) {
            return false;
        } else {
            int var5;
            if (var3) {
                var5 = var4;
                do {
                    --var5;
                    if (var5 < 0) {
                        return true;
                    }
                } while (var0[var5] == var1[var5 + var2]);
                return false;
            } else {
                var5 = var4;
                do {
                    --var5;
                    if (var5 < 0) {
                        return true;
                    }
                } while (ScannerHelper.method_3341(var0[var5]) == ScannerHelper.method_3341(var1[var5 + var2]));
                return false;
            }
        }
    }

    public static final int method_1369(char[] var0) {
        int var1 = var0.length;
        int var2 = var1 == 0 ? 31 : var0[0];
        int var3;
        if (var1 < 8) {
            var3 = var1;
            while (true) {
                --var3;
                if (var3 <= 0) {
                    break;
                }
                var2 = var2 * 31 + var0[var3];
            }
        } else {
            var3 = var1 - 1;
            for (int var4 = var3 > 16 ? var3 - 16 : 0; var3 > var4; var3 -= 2) {
                var2 = var2 * 31 + var0[var3];
            }
        }
        return var2 & Integer.MAX_VALUE;
    }

    public static boolean method_1370(char var0) {
        return var0 < 128 && (ScannerHelper.field_1984[var0] & 256) != 0;
    }

    public static final int method_1371(char var0, char[] var1) {
        return method_1374(var0, var1, 0);
    }

    public static final int method_1372(char[] var0, char[] var1, boolean var2, int var3) {
        return method_1373(var0, var1, var2, var3, var1.length);
    }

    public static final int method_1373(char[] var0, char[] var1, boolean var2, int var3, int var4) {
        int var5 = var4;
        int var6 = var0.length;
        if (var6 > var4) {
            return -1;
        } else if (var6 == 0) {
            return 0;
        } else {
            int var7;
            if (var6 == var4) {
                if (var2) {
                    for (var7 = var3; var7 < var5; ++var7) {
                        if (var1[var7] != var0[var7]) {
                            return -1;
                        }
                    }
                    return 0;
                } else {
                    for (var7 = var3; var7 < var5; ++var7) {
                        if (ScannerHelper.method_3341(var1[var7]) != ScannerHelper.method_3341(var0[var7])) {
                            return -1;
                        }
                    }
                    return 0;
                }
            } else {
                int var8;
                int var9;
                if (var2) {
                    var7 = var3;
                    label87:
                    for (var8 = var4 - var6 + 1; var7 < var8; ++var7) {
                        if (var1[var7] == var0[0]) {
                            for (var9 = 1; var9 < var6; ++var9) {
                                if (var1[var7 + var9] != var0[var9]) {
                                    continue label87;
                                }
                            }
                            return var7;
                        }
                    }
                } else {
                    var7 = var3;
                    label74:
                    for (var8 = var4 - var6 + 1; var7 < var8; ++var7) {
                        if (ScannerHelper.method_3341(var1[var7]) == ScannerHelper.method_3341(var0[0])) {
                            for (var9 = 1; var9 < var6; ++var9) {
                                if (ScannerHelper.method_3341(var1[var7 + var9]) != ScannerHelper.method_3341(var0[var9])) {
                                    continue label74;
                                }
                            }
                            return var7;
                        }
                    }
                }
                return -1;
            }
        }
    }

    public static final int method_1374(char var0, char[] var1, int var2) {
        for (int var3 = var2; var3 < var1.length; ++var3) {
            if (var0 == var1[var3]) {
                return var3;
            }
        }
        return -1;
    }

    public static final int method_1375(char var0, char[] var1, int var2, int var3) {
        for (int var4 = var2; var4 < var3; ++var4) {
            if (var0 == var1[var4]) {
                return var4;
            }
        }
        return -1;
    }

    public static final int method_1376(char var0, char[] var1) {
        int var2 = var1.length;
        do {
            --var2;
            if (var2 < 0) {
                return -1;
            }
        } while (var0 != var1[var2]);
        return var2;
    }

    public static final char[] method_1377(char[] var0, char var1) {
        int var2 = method_1376(var1, var0);
        return var2 < 0 ? var0 : method_1388(var0, var2 + 1, var0.length);
    }

    public static final boolean method_1378(char[] var0, int var1, int var2, char[] var3, int var4, int var5, boolean var6) {
        if (var3 == null) {
            return false;
        } else if (var0 == null) {
            return true;
        } else {
            int var7 = var1;
            int var8 = var4;
            if (var2 < 0) {
                var2 = var0.length;
            }
            if (var5 < 0) {
                var5 = var3.length;
            }
            char var9;
            for (var9 = 0; var7 < var2 && (var9 = var0[var7]) != 42; ++var7) {
                if (var8 == var5) {
                    return false;
                }
                if (var9 != (var6 ? var3[var8] : ScannerHelper.method_3341(var3[var8])) && var9 != 63) {
                    return false;
                }
                ++var8;
            }
            int var10;
            if (var9 == 42) {
                ++var7;
                var10 = var7;
            } else {
                var10 = 0;
            }
            int var11 = var8;
            while (var8 < var5) {
                if (var7 == var2) {
                    var7 = var10;
                    ++var11;
                    var8 = var11;
                } else if ((var9 = var0[var7]) == 42) {
                    ++var7;
                    var10 = var7;
                    if (var7 == var2) {
                        return true;
                    }
                    var11 = var8;
                } else if ((var6 ? var3[var8] : ScannerHelper.method_3341(var3[var8])) != var9 && var9 != 63) {
                    var7 = var10;
                    ++var11;
                    var8 = var11;
                } else {
                    ++var8;
                    ++var7;
                }
            }
            return var10 == var2 || var8 == var5 && var7 == var2 || var7 == var2 - 1 && var0[var7] == 42;
        }
    }

    public static final boolean method_1379(char[] var0, char[] var1, boolean var2, char var3) {
        if (var1 == null) {
            return false;
        } else if (var0 == null) {
            return true;
        } else {
            int var4 = var0[0] == var3 ? 1 : 0;
            int var5 = var0.length;
            int var6 = method_1374(var3, var0, var4 + 1);
            if (var6 < 0) {
                var6 = var5;
            }
            boolean var7 = var0[var5 - 1] == var3;
            int var9 = var1.length;
            int var8;
            if (var1[0] != var3) {
                var8 = 0;
            } else {
                var8 = 1;
            }
            if (var8 != var4) {
                return false;
            } else {
                int var10 = method_1374(var3, var1, var8 + 1);
                if (var10 < 0) {
                    var10 = var9;
                }
                while (var4 < var5 && (var6 != var5 || !var7) && (var6 != var4 + 2 || var0[var4] != 42 || var0[var4 + 1] != 42)) {
                    if (var8 >= var9) {
                        return false;
                    }
                    if (!method_1378(var0, var4, var6, var1, var8, var10, var2)) {
                        return false;
                    }
                    var6 = method_1374(var3, var0, var4 = var6 + 1);
                    if (var6 < 0) {
                        var6 = var5;
                    }
                    var10 = method_1374(var3, var1, var8 = var10 + 1);
                    if (var10 < 0) {
                        var10 = var9;
                    }
                }
                int var11;
                if ((var4 < var5 || !var7) && (var6 != var4 + 2 || var0[var4] != 42 || var0[var4 + 1] != 42)) {
                    if (var4 >= var5) {
                        return var8 >= var9;
                    }
                    var11 = 0;
                } else {
                    var6 = method_1374(var3, var0, var4 = var6 + 1);
                    if (var6 < 0) {
                        var6 = var5;
                    }
                    var11 = var4;
                }
                int var12 = var8;
                while (var8 < var9) {
                    if (var4 >= var5) {
                        if (var7) {
                            return true;
                        }
                        var4 = var11;
                        var6 = method_1374(var3, var0, var11);
                        if (var6 < 0) {
                            var6 = var5;
                        }
                        var12 = method_1374(var3, var1, var12 + 1);
                        if (var12 < 0) {
                            var12 = var9;
                        } else {
                            ++var12;
                        }
                        var8 = var12;
                        var10 = method_1374(var3, var1, var12);
                        if (var10 < 0) {
                            var10 = var9;
                        }
                    } else if (var6 == var4 + 2 && var0[var4] == 42 && var0[var4 + 1] == 42) {
                        var6 = method_1374(var3, var0, var4 = var6 + 1);
                        if (var6 < 0) {
                            var6 = var5;
                        }
                        var11 = var4;
                        var12 = var8;
                        if (var4 >= var5) {
                            return true;
                        }
                    } else if (!method_1378(var0, var4, var6, var1, var8, var10, var2)) {
                        var4 = var11;
                        var6 = method_1374(var3, var0, var11);
                        if (var6 < 0) {
                            var6 = var5;
                        }
                        var12 = method_1374(var3, var1, var12 + 1);
                        if (var12 < 0) {
                            var12 = var9;
                        } else {
                            ++var12;
                        }
                        var8 = var12;
                        var10 = method_1374(var3, var1, var12);
                        if (var10 < 0) {
                            var10 = var9;
                        }
                    } else {
                        var6 = method_1374(var3, var0, var4 = var6 + 1);
                        if (var6 < 0) {
                            var6 = var5;
                        }
                        var10 = method_1374(var3, var1, var8 = var10 + 1);
                        if (var10 < 0) {
                            var10 = var9;
                        }
                    }
                }
                return var11 >= var6 || var8 >= var9 && var4 >= var5 || var4 == var5 - 2 && var0[var4] == 42 && var0[var4 + 1] == 42 || var4 == var5 && var7;
            }
        }
    }

    public static final int method_1380(char[] var0, int var1, int var2) {
        if (var2 == 1) {
            int var3 = var0[var1] - 48;
            if (var3 >= 0 && var3 <= 9) {
                return var3;
            } else {
                throw new NumberFormatException("invalid digit");
            }
        } else {
            return Integer.parseInt(new String(var0, var1, var2));
        }
    }

    public static final boolean method_1381(char[] var0, char[] var1) {
        int var2 = var0.length;
        if (var1.length < var2) {
            return false;
        } else {
            int var3 = var2;
            do {
                --var3;
                if (var3 < 0) {
                    return true;
                }
            } while (var0[var3] == var1[var3]);
            return false;
        }
    }

    public static final void method_1382(char[] var0, char var1, char var2) {
        if (var1 != var2) {
            int var3 = 0;
            for (int var4 = var0.length; var3 < var4; ++var3) {
                if (var0[var3] == var1) {
                    var0[var3] = var2;
                }
            }
        }
    }

    public static final char[] method_1383(char[] var0, char[] var1, char[] var2) {
        int var3 = var0.length;
        int var4 = var1.length;
        int var5 = var2.length;
        int[] var6 = new int[5];
        int var7 = 0;
        int var9;
        if (!method_1364(var1, var2)) {
            int var8 = 0;
            while (var8 < var3) {
                var9 = method_1372(var1, var0, true, var8);
                if (var9 == -1) {
                    ++var8;
                } else {
                    if (var7 == var6.length) {
                        System.arraycopy(var6, 0, var6 = new int[var7 * 2], 0, var7);
                    }
                    var6[var7++] = var9;
                    var8 = var9 + var4;
                }
            }
        }
        if (var7 == 0) {
            return var0;
        } else {
            char[] var13 = new char[var3 + var7 * (var5 - var4)];
            var9 = 0;
            int var10 = 0;
            for (int var11 = 0; var11 < var7; ++var11) {
                int var12 = var6[var11] - var9;
                System.arraycopy(var0, var9, var13, var10, var12);
                var9 += var12;
                var10 += var12;
                System.arraycopy(var2, 0, var13, var10, var5);
                var9 += var4;
                var10 += var5;
            }
            System.arraycopy(var0, var9, var13, var10, var3 - var9);
            return var13;
        }
    }

    public static final char[][] method_1384(char var0, char[] var1) {
        int var2 = var1 == null ? 0 : var1.length;
        if (var2 == 0) {
            return field_995;
        } else {
            int var3 = 1;
            for (int var4 = 0; var4 < var2; ++var4) {
                if (var1[var4] == var0) {
                    ++var3;
                }
            }
            char[][] var10 = new char[var3][];
            int var5 = 0;
            int var6 = 0;
            int var7;
            int var8;
            for (var7 = 0; var7 < var2; ++var7) {
                if (var1[var7] == var0) {
                    var8 = var5;
                    int var9;
                    for (var9 = var7 - 1; var8 < var7 && var1[var8] == 32; ++var8) {
                        ;
                    }
                    while (var9 > var8 && var1[var9] == 32) {
                        --var9;
                    }
                    var10[var6] = new char[var9 - var8 + 1];
                    System.arraycopy(var1, var8, var10[var6++], 0, var9 - var8 + 1);
                    var5 = var7 + 1;
                }
            }
            var7 = var5;
            for (var8 = var2 - 1; var7 < var2 && var1[var7] == 32; ++var7) {
                ;
            }
            while (var8 > var7 && var1[var8] == 32) {
                --var8;
            }
            var10[var6] = new char[var8 - var7 + 1];
            System.arraycopy(var1, var7, var10[var6++], 0, var8 - var7 + 1);
            return var10;
        }
    }

    public static final char[][] method_1385(char var0, char[] var1) {
        int var2 = var1 == null ? 0 : var1.length;
        if (var2 == 0) {
            return field_995;
        } else {
            int var3 = 1;
            for (int var4 = 0; var4 < var2; ++var4) {
                if (var1[var4] == var0) {
                    ++var3;
                }
            }
            char[][] var8 = new char[var3][];
            int var5 = 0;
            int var6 = 0;
            for (int var7 = 0; var7 < var2; ++var7) {
                if (var1[var7] == var0) {
                    var8[var6] = new char[var7 - var5];
                    System.arraycopy(var1, var5, var8[var6++], 0, var7 - var5);
                    var5 = var7 + 1;
                }
            }
            var8[var6] = new char[var2 - var5];
            System.arraycopy(var1, var5, var8[var6], 0, var2 - var5);
            return var8;
        }
    }

    public static final char[][] method_1386(char var0, char[] var1, int var2, int var3) {
        int var4 = var1 == null ? 0 : var1.length;
        if (var4 != 0 && var2 <= var3) {
            int var5 = 1;
            for (int var6 = var2; var6 < var3; ++var6) {
                if (var1[var6] == var0) {
                    ++var5;
                }
            }
            char[][] var10 = new char[var5][];
            int var7 = var2;
            int var8 = 0;
            for (int var9 = var2; var9 < var3; ++var9) {
                if (var1[var9] == var0) {
                    var10[var8] = new char[var9 - var7];
                    System.arraycopy(var1, var7, var10[var8++], 0, var9 - var7);
                    var7 = var9 + 1;
                }
            }
            var10[var8] = new char[var3 - var7];
            System.arraycopy(var1, var7, var10[var8], 0, var3 - var7);
            return var10;
        } else {
            return field_995;
        }
    }

    public static final char[][] method_1387(char[][] var0, int var1, int var2) {
        if (var2 == -1) {
            var2 = var0.length;
        }
        if (var1 > var2) {
            return (char[][])null;
        } else if (var1 < 0) {
            return (char[][])null;
        } else if (var2 > var0.length) {
            return (char[][])null;
        } else {
            char[][] var3 = new char[var2 - var1][];
            System.arraycopy(var0, var1, var3, 0, var2 - var1);
            return var3;
        }
    }

    public static final char[] method_1388(char[] var0, int var1, int var2) {
        if (var2 == -1) {
            var2 = var0.length;
        }
        if (var1 > var2) {
            return null;
        } else if (var1 < 0) {
            return null;
        } else if (var2 > var0.length) {
            return null;
        } else {
            char[] var3 = new char[var2 - var1];
            System.arraycopy(var0, var1, var3, 0, var2 - var1);
            return var3;
        }
    }

    public static final String method_1389(char[][] var0) {
        char[] var1 = method_1361(var0, '.');
        return new String(var1);
    }

    static {
        field_994 = new char[0];
        field_995 = new char[0][];
        field_996 = new String[0];
    }
}
