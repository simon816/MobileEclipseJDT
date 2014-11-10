package m;

import a.class_331;
import b.class_233;
import f.class_327;
import g.class_313;
import k.class_22;
import k.class_23;
import k.class_25;
import k.class_27;
import k.class_29;
import k.class_30;
import k.class_318;
import k.class_319;
import m.class_17;
import m.class_197;
import m.class_203;
import m.class_204;
import m.class_320;
import m.class_34;
import m.class_38;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_44;
import m.class_45;
import m.class_46;
import m.class_52;
import m.class_58;
import m.class_67;
import m.class_80;
import m.class_83;
import m.class_85;

public class class_49 extends class_43 {

    protected class_43 field_231;

    protected class_43 field_232;

    protected class_43[] field_233;

    protected class_67[] field_234;

    protected class_58[] field_235;

    protected class_43[] field_236;

    protected class_46[] field_237;

    protected class_80 field_238;

    protected class_327 field_239;

    static Object method_264(Object var0, class_80 var1, char[][][] var2) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof class_331) {
            return var0;
        } else if (var0 instanceof class_318) {
            class_40 var8 = var1.method_512(((class_318)var0).method_3193(), 0, -1, false, (class_40)null, var2);
            return var8.method_148() ? var8 : method_267((class_43)var8, var1, false);
        } else if (var0 instanceof class_29) {
            return method_265((class_29)var0, var1, var2);
        } else if (var0 instanceof class_319) {
            class_319 var7 = (class_319)var0;
            class_43 var9 = (class_43)var1.method_512(var7.method_3195(), 0, -1, false, (class_40)null, var2);
            var9 = method_267(var9, var1, false);
            return var9.method_208(var7.method_3196(), false);
        } else if (!(var0 instanceof Object[])) {
            throw new IllegalStateException();
        } else {
            Object[] var3 = (Object[])((Object[])var0);
            int var4 = var3.length;
            if (var4 == 0) {
                return var3;
            } else {
                Object[] var5 = new Object[var4];
                for (int var6 = 0; var6 < var4; ++var6) {
                    var5[var6] = method_264(var3[var6], var1, var2);
                }
                return var5;
            }
        }
    }

    static class_203 method_265(class_29 var0, class_80 var1, char[][][] var2) {
        class_30[] var3 = var0.method_84();
        int var4 = var3 == null ? 0 : var3.length;
        class_320[] var5 = var4 == 0 ? class_34.field_159 : new class_320[var4];
        for (int var6 = 0; var6 < var4; ++var6) {
            class_320 var10002 = new class_320(var3[var6].method_85(), method_264(var3[var6].method_86(), var1, var2), (class_58)null);
            var5[var6] = var10002;
        }
        char[] var8 = var0.method_83();
        class_43 var7 = var1.method_511(var8, 1, var8.length - 1, false, var2);
        class_204 var10000 = new class_204(var7, var5, var1);
        return var10000;
    }

    public static class_203[] method_266(class_29[] var0, class_80 var1, char[][][] var2) {
        int var3 = var0 == null ? 0 : var0.length;
        class_203[] var4 = var3 == 0 ? class_34.field_158 : new class_203[var3];
        for (int var5 = 0; var5 < var3; ++var5) {
            var4[var5] = method_265(var0[var5], var1, var2);
        }
        return var4;
    }

    public static class_43 method_267(class_43 var0, class_80 var1, boolean var2) {
        if (var0 instanceof class_44) {
            return ((class_44)var0).method_247(var1, var2);
        } else {
            switch (var0.method_98()) {
                case 260:
                    return ((class_52)var0).method_289();
                case 516:
                case 8196:
                    return ((class_45)var0).method_252();
                default:
                    return var2 ? (class_43)var1.method_491(var0) : var0;
            }
        }
    }

    public static class_40 method_268(class_40 var0, class_80 var1, class_52 var2, int var3) {
        switch (var0.method_98()) {
            case 68:
                method_268(((class_42)var0).field_192, var1, var2, var3);
                break;
            case 260:
                return ((class_52)var0).method_289();
            case 516:
            case 8196:
                return ((class_45)var0).method_252();
            case 2052:
                if (var2 == null) {
                    return var1.method_491(var0);
                }
                break;
            case 4100:
                ((class_46)var0).method_260(var1);
                break;
            default:
                if (var0 instanceof class_44) {
                    return ((class_44)var0).method_247(var1, var2 == null);
                }
        }
        return var0;
    }

    protected class_49() {
        this.field_239 = null;
    }

    public class_49(class_38 var1, class_22 var2, class_80 var3) {
        this.field_239 = null;
        this.field_197 = class_233.method_1385('/', var2.method_60());
        this.method_198();
        this.field_178 |= 64L;
        this.field_238 = var3;
        this.field_200 = var1;
        this.field_201 = var2.method_50();
        char[] var4 = var3.field_352.field_1928 >= 3211264L ? var2.method_52() : null;
        this.field_237 = var4 != null && var4.length > 0 && var4[0] == 60 ? null : class_34.field_157;
        this.field_198 = var2.method_61();
        this.field_199 = var2.method_54();
        if ((var2.method_63() & 131072L) != 0L) {
            this.field_178 |= 131072L;
        }
        if (var2.method_64()) {
            this.field_178 |= 52L;
        } else if (var2.method_65()) {
            this.field_178 |= 20L;
        } else if (var2.method_66()) {
            this.field_178 |= 12L;
        }
        char[] var5 = var2.method_51();
        if (var5 != null) {
            this.field_232 = var3.method_511(var5, 0, -1, true, (char[][][])null);
            this.field_178 |= 12L;
            this.field_178 |= 134217728L;
            if (this.method_137().method_227()) {
                this.field_199 |= 2048;
            }
            if (this.method_137().method_220()) {
                this.field_199 |= 2097152;
            }
        }
    }

    void method_270(class_22 var1, boolean var2) {
        this.field_237 = class_34.field_157;
        this.field_233 = class_34.field_155;
        this.field_236 = class_34.field_156;
        class_23[] var3 = var1.method_57();
        if (var3 != null) {
            int var4 = var3.length;
            if (var4 > 0) {
                this.field_236 = new class_43[var4];
                for (int var5 = 0; var5 < var4; ++var5) {
                    this.field_236[var5] = this.field_238.method_511(var3[var5].method_68(), 0, -1, false, (char[][][])null);
                }
                this.field_178 |= 268435456L;
            }
        }
        long var13 = this.field_238.field_352.field_1928;
        char[] var6 = null;
        if (var13 >= 3211264L) {
            var6 = var1.method_52();
            this.field_178 |= var1.method_63();
        }
        char[][][] var7 = var1.method_59();
        if (var6 == null) {
            char[] var8 = var1.method_62();
            if (var8 != null) {
                this.field_231 = this.field_238.method_511(var8, 0, -1, false, var7);
                this.field_178 |= 33554432L;
            }
            this.field_233 = class_34.field_155;
            char[][] var9 = var1.method_53();
            if (var9 != null) {
                int var10 = var9.length;
                if (var10 > 0) {
                    this.field_233 = new class_43[var10];
                    for (int var11 = 0; var11 < var10; ++var11) {
                        this.field_233[var11] = this.field_238.method_511(var9[var11], 0, -1, false, var7);
                    }
                    this.field_178 |= 67108864L;
                }
            }
        } else {
            class_197 var10000 = new class_197(var6);
            class_197 var14 = var10000;
            if (var14.field_872[var14.field_873] == 60) {
                ++var14.field_873;
                this.field_237 = this.method_274(var14, true, var7);
                ++var14.field_873;
                this.field_178 |= 16777216L;
                this.field_199 |= 1073741824;
            }
            this.field_231 = (class_43)this.field_238.method_513(var14, class_34.field_157, this, var7);
            this.field_178 |= 33554432L;
            this.field_233 = class_34.field_155;
            if (!var14.method_1161()) {
                class_313 var12 = new class_313(2);
                class_313 var15 = var12;
                do {
                    var15.method_34(this.field_238.method_513(var14, class_34.field_157, this, var7));
                } while (!var14.method_1161());
                this.field_233 = new class_43[var15.method_29()];
                var15.method_33(this.field_233);
                this.field_178 |= 67108864L;
            }
        }
        if (var2) {
            this.method_271(var1.method_56(), var13, var7);
            this.method_273(var1.method_58(), var13, var7);
        } else {
            this.field_234 = class_34.field_153;
            this.field_235 = class_34.field_154;
        }
        if (this.field_238.field_352.field_1963) {
            this.method_236(method_266(var1.method_55(), this.field_238, var7));
        }
    }

    private void method_271(class_27[] var1, long var2, char[][][] var4) {
        this.field_234 = class_34.field_153;
        if (var1 != null) {
            int var5 = var1.length;
            if (var5 > 0) {
                this.field_234 = new class_67[var5];
                boolean var6 = var2 >= 3211264L;
                boolean var7 = this.method_230();
                boolean var8 = this.method_214();
                int var9 = -1;
                int var10;
                class_27 var11;
                for (var10 = 0; var10 < var5; ++var10) {
                    var11 = var1[var10];
                    char[] var12 = var6 ? var11.method_74() : null;
                    class_40 var10000;
                    if (var12 == null) {
                        var10000 = this.field_238.method_512(var11.method_77(), 0, -1, false, this, var4);
                    } else {
                        class_80 var16 = this.field_238;
                        class_197 var10001 = new class_197(var12);
                        var10000 = var16.method_513(var10001, class_34.field_157, this, var4);
                    }
                    class_40 var13 = var10000;
                    class_67 var15 = new class_67(var11.method_75(), var13, var11.method_69() | 33554432, this, var11.method_79());
                    class_67 var14 = var15;
                    if (var9 < 0 && this.field_238.field_352.field_1963 && var11.method_71() != null) {
                        var9 = var10;
                    }
                    var14.field_304 = var10;
                    if (var6) {
                        var14.field_305 |= var11.method_78();
                    }
                    if (var7 && !var14.method_427()) {
                        var14.field_300 |= 2097152;
                    }
                    if (var8) {
                        var14.field_300 |= 262144;
                    }
                    if (var12 != null) {
                        var14.field_300 |= 1073741824;
                    }
                    this.field_234[var10] = var14;
                }
                if (var9 >= 0) {
                    for (var10 = var9; var10 < var5; ++var10) {
                        var11 = var1[var10];
                        this.field_234[var10].method_436(method_266(var11.method_71(), this.field_238, var4));
                    }
                }
            }
        }
    }

    private class_58 method_272(class_25 var1, long var2, char[][][] var4) {
        int var5 = var1.method_69() | 33554432;
        if (var2 < 3211264L) {
            var5 &= -129;
        }
        class_43[] var6 = class_34.field_151;
        class_40[] var7 = class_34.field_150;
        class_46[] var8 = class_34.field_157;
        class_203[][] var9 = (class_203[][])null;
        class_40 var10 = null;
        boolean var11 = var2 >= 3211264L;
        char[] var12 = var11 ? var1.method_74() : null;
        int var14;
        int var16;
        int var25;
        if (var12 == null) {
            char[] var13 = var1.method_75();
            var14 = 0;
            var16 = 0;
            while (true) {
                ++var16;
                char var15;
                if ((var15 = var13[var16]) == 41) {
                    int var17 = var1.method_70() && this.method_159() && !this.method_226() ? 1 : 0;
                    int var18 = var14 - var17;
                    int var20;
                    if (var18 > 0) {
                        var7 = new class_40[var18];
                        if (this.field_238.field_352.field_1963) {
                            var9 = new class_203[var18][];
                        }
                        var16 = 1;
                        int var19 = 0;
                        for (var20 = 0; var20 < var14; ++var20) {
                            do {
                                ++var19;
                            } while ((var15 = var13[var19]) == 91);
                            if (var15 == 76) {
                                while (true) {
                                    ++var19;
                                    if (var13[var19] != 59) {
                                        continue;
                                    }
                                }
                            }
                            if (var20 >= var17) {
                                var7[var20 - var17] = this.field_238.method_512(var13, var16, var19, false, this, var4);
                                if (var9 != null) {
                                    var9[var20 - var17] = method_266(var1.method_76(var20), this.field_238, var4);
                                }
                            }
                            var16 = var19 + 1;
                        }
                    }
                    char[][] var26 = var1.method_73();
                    if (var26 != null) {
                        var18 = var26.length;
                        if (var18 > 0) {
                            var6 = new class_43[var18];
                            for (var20 = 0; var20 < var18; ++var20) {
                                var6[var20] = this.field_238.method_511(var26[var20], 0, -1, false, var4);
                            }
                        }
                    }
                    if (!var1.method_70()) {
                        var10 = this.field_238.method_512(var13, var16 + 1, -1, false, this, var4);
                    }
                    break;
                }
                if (var15 != 91) {
                    ++var14;
                    if (var15 == 76) {
                        while (true) {
                            ++var16;
                            if (var13[var16] == 59) {
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            var5 |= 1073741824;
            class_197 var10000 = new class_197(var12);
            class_197 var22 = var10000;
            if (var22.field_872[var22.field_873] == 60) {
                ++var22.field_873;
                var8 = this.method_274(var22, false, var4);
                ++var22.field_873;
            }
            class_313 var24;
            class_313 var28;
            if (var22.field_872[var22.field_873] == 40) {
                ++var22.field_873;
                if (var22.field_872[var22.field_873] == 41) {
                    ++var22.field_873;
                } else {
                    var28 = new class_313(2);
                    var24 = var28;
                    while (var22.field_872[var22.field_873] != 41) {
                        var24.method_34(this.field_238.method_513(var22, var8, this, var4));
                    }
                    ++var22.field_873;
                    var25 = var24.method_29();
                    var7 = new class_40[var25];
                    var24.method_33(var7);
                    if (this.field_238.field_352.field_1963) {
                        var9 = new class_203[var25][];
                        for (var16 = 0; var16 < var25; ++var16) {
                            var9[var16] = method_266(var1.method_76(var16), this.field_238, var4);
                        }
                    }
                }
            }
            var10 = this.field_238.method_513(var22, var8, this, var4);
            if (!var22.method_1161() && var22.field_872[var22.field_873] == 94) {
                var28 = new class_313(2);
                var24 = var28;
                do {
                    ++var22.field_873;
                    var24.method_34(this.field_238.method_513(var22, var8, this, var4));
                } while (!var22.method_1161() && var22.field_872[var22.field_873] == 94);
                var6 = new class_43[var24.method_29()];
                var24.method_33(var6);
            } else {
                char[][] var23 = var1.method_73();
                if (var23 != null) {
                    var25 = var23.length;
                    if (var25 > 0) {
                        var6 = new class_43[var25];
                        for (var16 = 0; var16 < var25; ++var16) {
                            var6[var16] = this.field_238.method_511(var23[var16], 0, -1, false, var4);
                        }
                    }
                }
            }
        }
        class_58 var27;
        if (var1.method_70()) {
            var27 = new class_58(var5, var7, var6, this);
        } else {
            var27 = new class_58(var5, var1.method_77(), var10, var7, var6, this);
        }
        class_58 var21 = var27;
        if (this.field_238.field_352.field_1963) {
            var21.method_378(method_266(var1.method_71(), this.field_238, var4), var9, this.method_145() ? method_264(var1.method_72(), this.field_238, var4) : null);
        }
        if (var11) {
            var21.field_281 |= var1.method_78();
        }
        var21.field_279 = var8;
        var14 = 0;
        for (var25 = var8.length; var14 < var25; ++var14) {
            var8[var14].field_220 = var21;
        }
        return var21;
    }

    private void method_273(class_25[] var1, long var2, char[][][] var4) {
        int var5 = 0;
        int var6 = 0;
        int var7 = -1;
        int[] var8 = null;
        boolean var9;
        if (var1 != null) {
            var5 = var6 = var1.length;
            var9 = var2 < 3211264L && this.field_238.field_352.field_1927 >= 3211264L;
            int var10 = var5;
            while (true) {
                --var10;
                if (var10 < 0) {
                    break;
                }
                class_25 var11 = var1[var10];
                if ((var11.method_69() & 4096) != 0) {
                    if (!var9 || (var11.method_69() & 64) == 0) {
                        if (var8 == null) {
                            var8 = new int[var1.length];
                        }
                        var8[var10] = -1;
                        --var5;
                    }
                } else if (var7 == -1) {
                    char[] var12 = var11.method_77();
                    if (var12.length == 8 && var12[0] == 60) {
                        var7 = var10;
                        --var5;
                    }
                }
            }
        }
        if (var5 == 0) {
            this.field_235 = class_34.field_154;
        } else {
            var9 = this.method_230();
            boolean var15 = this.method_214();
            this.field_235 = new class_58[var5];
            int var14;
            if (var5 == var6) {
                for (var14 = 0; var14 < var6; ++var14) {
                    class_58 var16 = this.method_272(var1[var14], var2, var4);
                    if (var9 && !var16.method_361()) {
                        var16.field_273 |= 2097152;
                    }
                    if (var15) {
                        var16.field_273 |= 262144;
                    }
                    this.field_235[var14] = var16;
                }
            } else {
                var14 = 0;
                for (int var17 = 0; var14 < var6; ++var14) {
                    if (var7 != var14 && (var8 == null || var8[var14] != -1)) {
                        class_58 var13 = this.method_272(var1[var14], var2, var4);
                        if (var9 && !var13.method_361()) {
                            var13.field_273 |= 2097152;
                        }
                        if (var15) {
                            var13.field_273 |= 262144;
                        }
                        this.field_235[var17++] = var13;
                    }
                }
            }
        }
    }

    private class_46[] method_274(class_197 var1, boolean var2, char[][][] var3) {
        char[] var4 = var1.field_872;
        boolean var5 = false;
        int var6 = var4.length;
        int var7 = 0;
        class_313 var10000 = new class_313(1);
        class_313 var8 = var10000;
        int var13 = 0;
        boolean var9 = true;
        int var11;
        label41:
        for (int var10 = 1; var10 < var6; ++var10) {
            switch (var4[var10]) {
                case 59:
                    if (var13 == 0 && var10 + 1 < var6 && var4[var10 + 1] != 58) {
                        var9 = true;
                    }
                    break;
                case 60:
                    ++var13;
                    break;
                case 61:
                default:
                    if (var9) {
                        var9 = false;
                        var11 = class_233.method_1374(':', var4, var10);
                        char[] var12 = class_233.method_1388(var4, var10, var11);
                        class_46 var10001 = new class_46(var12, this, var7++);
                        var8.method_34(var10001);
                    }
                    break;
                case 62:
                    --var13;
                    if (var13 < 0) {
                        break label41;
                    }
            }
        }
        class_46[] var14;
        var8.method_33(var14 = new class_46[var7]);
        if (var2) {
            this.field_237 = var14;
        }
        for (var11 = 0; var11 < var7; ++var11) {
            this.method_275(var14[var11], var14, var1, var3);
        }
        return var14;
    }

    public class_43 method_137() {
        if ((this.field_178 & 134217728L) == 0L) {
            return this.field_232;
        } else {
            this.field_232 = method_267(this.field_232, this.field_238, false);
            this.field_178 &= -134217729L;
            return this.field_232;
        }
    }

    public class_67[] method_204() {
        if ((this.field_178 & 8192L) != 0L) {
            return this.field_234;
        } else {
            int var1;
            if ((this.field_178 & 4096L) == 0L) {
                var1 = this.field_234.length;
                if (var1 > 1) {
                    class_43.method_192(this.field_234, 0, var1);
                }
                this.field_178 |= 4096L;
            }
            var1 = this.field_234.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.field_178 |= 8192L;
                    return this.field_234;
                }
                this.method_276(this.field_234[var1]);
            }
        }
    }

    public char[] method_142() {
        return this.method_197(this.field_237);
    }

    public class_58 method_206(class_40[] var1) {
        int var2;
        if ((this.field_178 & 16384L) == 0L) {
            var2 = this.field_235.length;
            if (var2 > 1) {
                class_43.method_193(this.field_235, 0, var2);
            }
            this.field_178 |= 16384L;
        }
        var2 = var1.length;
        long var3;
        if ((var3 = class_43.method_190(class_17.field_135, this.field_235)) >= 0L) {
            int var5 = (int)var3;
            label35:
            for (int var6 = (int)(var3 >> 32); var5 <= var6; ++var5) {
                class_58 var7 = this.field_235[var5];
                if (var7.field_276.length == var2) {
                    this.method_277(var7);
                    class_40[] var8 = var7.field_276;
                    for (int var9 = 0; var9 < var2; ++var9) {
                        if (var8[var9] != var1[var9]) {
                            continue label35;
                        }
                    }
                    return var7;
                }
            }
        }
        return null;
    }

    public class_58 method_207(char[] var1, class_40[] var2, class_85 var3) {
        int var4;
        if ((this.field_178 & 16384L) == 0L) {
            var4 = this.field_235.length;
            if (var4 > 1) {
                class_43.method_193(this.field_235, 0, var4);
            }
            this.field_178 |= 16384L;
        }
        var4 = var2.length;
        boolean var5 = true;
        long var6;
        if ((var6 = class_43.method_190(var1, this.field_235)) >= 0L) {
            int var8 = (int)var6;
            label54:
            for (int var9 = (int)(var6 >> 32); var8 <= var9; ++var8) {
                class_58 var10 = this.field_235[var8];
                var5 = false;
                if (var10.field_276.length == var4) {
                    this.method_277(var10);
                    class_40[] var11 = var10.field_276;
                    for (int var12 = 0; var12 < var4; ++var12) {
                        if (var11[var12] != var2[var12]) {
                            continue label54;
                        }
                    }
                    return var10;
                }
            }
        }
        if (var5) {
            if (this.method_157()) {
                if (this.method_241().length == 1) {
                    if (var3 != null) {
                        var3.method_693(this.field_233[0]);
                    }
                    return this.field_233[0].method_207(var1, var2, var3);
                }
            } else if (this.method_240() != null) {
                if (var3 != null) {
                    var3.method_693(this.field_231);
                }
                return this.field_231.method_207(var1, var2, var3);
            }
        }
        return null;
    }

    public class_67 method_208(char[] var1, boolean var2) {
        if ((this.field_178 & 4096L) == 0L) {
            int var3 = this.field_234.length;
            if (var3 > 1) {
                class_43.method_192(this.field_234, 0, var3);
            }
            this.field_178 |= 4096L;
        }
        class_67 var4 = class_43.method_189(var1, this.field_234);
        return var2 && var4 != null ? this.method_276(var4) : var4;
    }

    public class_43 method_209(char[] var1) {
        int var2 = this.field_236.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return null;
            }
            class_43 var3 = this.field_236[var2];
            if (var3 instanceof class_44) {
                char[] var4 = var3.field_198;
                int var5 = this.field_197[this.field_197.length - 1].length + 1;
                if (var4.length == var5 + var1.length && class_233.method_1368(var1, var4, var5, true)) {
                    return this.field_236[var2] = method_267(var3, this.field_238, false);
                }
            } else if (class_233.method_1364(var1, var3.field_198)) {
                return var3;
            }
        }
    }

    public class_58[] method_210(char[] var1) {
        int var4;
        int var5;
        int var6;
        class_58[] var7;
        long var10;
        if ((this.field_178 & 32768L) != 0L) {
            if ((var10 = class_43.method_190(var1, this.field_235)) >= 0L) {
                var4 = (int)var10;
                var5 = (int)(var10 >> 32);
                var6 = var5 - var4 + 1;
                if ((this.field_178 & 32768L) != 0L) {
                    System.arraycopy(this.field_235, var4, var7 = new class_58[var6], 0, var6);
                    return var7;
                }
            }
            return class_34.field_154;
        } else {
            if ((this.field_178 & 16384L) == 0L) {
                int var2 = this.field_235.length;
                if (var2 > 1) {
                    class_43.method_193(this.field_235, 0, var2);
                }
                this.field_178 |= 16384L;
            }
            if ((var10 = class_43.method_190(var1, this.field_235)) < 0L) {
                return class_34.field_154;
            } else {
                var4 = (int)var10;
                var5 = (int)(var10 >> 32);
                var6 = var5 - var4 + 1;
                var7 = new class_58[var6];
                int var8 = var4;
                for (int var9 = 0; var8 <= var5; ++var9) {
                    var7[var9] = this.method_277(this.field_235[var8]);
                    ++var8;
                }
                return var7;
            }
        }
    }

    public boolean method_213() {
        return this.field_236.length > 0;
    }

    public class_46 method_211(char[] var1) {
        class_46 var2 = super.method_211(var1);
        var2.method_260(this.field_238);
        return var2;
    }

    private void method_275(class_46 var1, class_46[] var2, class_197 var3, char[][][] var4) {
        int var5 = class_233.method_1374(':', var3.field_872, var3.field_873);
        var3.field_873 = var5 + 1;
        class_43 var7 = null;
        class_43 var6;
        if (var3.field_872[var3.field_873] == 58) {
            var6 = this.field_238.method_506(class_17.field_99, (class_83)null);
        } else {
            var6 = (class_43)this.field_238.method_513(var3, var2, this, var4);
            var7 = var6;
        }
        var1.field_199 |= 33554432;
        var1.field_223 = var6;
        class_43[] var8 = null;
        if (var3.field_872[var3.field_873] == 58) {
            class_313 var10000 = new class_313(2);
            class_313 var9 = var10000;
            do {
                ++var3.field_873;
                var9.method_34(this.field_238.method_513(var3, var2, this, var4));
            } while (var3.field_872[var3.field_873] == 58);
            var8 = new class_43[var9.method_29()];
            var9.method_33(var8);
        }
        var1.field_224 = var8 == null ? class_34.field_155 : var8;
        if (var7 == null) {
            var7 = var1.field_224.length == 0 ? null : var1.field_224[0];
        }
        var1.field_222 = var7;
    }

    public boolean method_154(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.method_98()) {
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                case 1028:
                    return var1.method_138() == this;
                default:
                    return false;
            }
        }
    }

    public boolean method_155() {
        return this.field_237 != class_34.field_157;
    }

    public int method_98() {
        return this.field_237 != class_34.field_157 ? 2052 : 4;
    }

    public class_43[] method_231() {
        if ((this.field_178 & 268435456L) == 0L) {
            return this.field_236;
        } else {
            int var1 = this.field_236.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.field_178 &= -268435457L;
                    return this.field_236;
                }
                this.field_236[var1] = method_267(this.field_236[var1], this.field_238, false);
            }
        }
    }

    public class_58[] method_232() {
        if ((this.field_178 & 32768L) != 0L) {
            return this.field_235;
        } else {
            int var1;
            if ((this.field_178 & 16384L) == 0L) {
                var1 = this.field_235.length;
                if (var1 > 1) {
                    class_43.method_193(this.field_235, 0, var1);
                }
                this.field_178 |= 16384L;
            }
            var1 = this.field_235.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.field_178 |= 32768L;
                    return this.field_235;
                }
                this.method_277(this.field_235[var1]);
            }
        }
    }

    private class_67 method_276(class_67 var1) {
        if ((var1.field_300 & 33554432) == 0) {
            return var1;
        } else {
            class_40 var2 = method_268(var1.field_301, this.field_238, (class_52)null, 0);
            var1.field_301 = var2;
            if ((var2.field_178 & 128L) != 0L) {
                var1.field_305 |= 128L;
            }
            var1.field_300 &= -33554433;
            return var1;
        }
    }

    class_58 method_277(class_58 var1) {
        if ((var1.field_273 & 33554432) == 0) {
            return var1;
        } else {
            if (!var1.method_358()) {
                class_40 var2 = method_268(var1.field_275, this.field_238, (class_52)null, 0);
                var1.field_275 = var2;
                if ((var2.field_178 & 128L) != 0L) {
                    var1.field_281 |= 128L;
                }
            }
            int var4 = var1.field_276.length;
            while (true) {
                --var4;
                if (var4 < 0) {
                    var4 = var1.field_277.length;
                    while (true) {
                        --var4;
                        if (var4 < 0) {
                            var4 = var1.field_279.length;
                            while (true) {
                                --var4;
                                if (var4 < 0) {
                                    var1.field_273 &= -33554433;
                                    return var1;
                                }
                                var1.field_279[var4].method_260(this.field_238);
                            }
                        }
                        class_43 var5 = method_267(var1.field_277[var4], this.field_238, true);
                        var1.field_277[var4] = var5;
                        if ((var5.field_178 & 128L) != 0L) {
                            var1.field_281 |= 128L;
                        }
                    }
                }
                class_40 var3 = method_268(var1.field_276[var4], this.field_238, (class_52)null, 0);
                var1.field_276[var4] = var3;
                if ((var3.field_178 & 128L) != 0L) {
                    var1.field_281 |= 128L;
                }
            }
        }
    }

    class_203[] method_235(class_34 var1) {
        return class_203.method_1176(super.method_235(var1), var1.method_99(), this.field_238);
    }

    class_327 method_239(boolean var1) {
        if (var1 && this.field_239 == null) {
            if (!this.field_238.field_352.field_1963) {
                return null;
            }
            class_327 var10001 = new class_327(3);
            this.field_239 = var10001;
        }
        return this.field_239;
    }

    public class_43 method_240() {
        if ((this.field_178 & 33554432L) == 0L) {
            return this.field_231;
        } else {
            this.field_231 = method_267(this.field_231, this.field_238, true);
            this.field_178 &= -33554433L;
            if (this.field_231.method_102() == 1) {
                this.field_178 |= 131072L;
            }
            return this.field_231;
        }
    }

    public class_43[] method_241() {
        if ((this.field_178 & 67108864L) == 0L) {
            return this.field_233;
        } else {
            int var1 = this.field_233.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.field_178 &= -67108865L;
                    return this.field_233;
                }
                this.field_233[var1] = method_267(this.field_233[var1], this.field_238, true);
                if (this.field_233[var1].method_102() == 1) {
                    this.field_178 |= 131072L;
                }
            }
        }
    }

    public class_46[] method_181() {
        if ((this.field_178 & 16777216L) == 0L) {
            return this.field_237;
        } else {
            int var1 = this.field_237.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.field_178 &= -16777217L;
                    return this.field_237;
                }
                this.field_237[var1].method_260(this.field_238);
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        if (this.method_220()) {
            var1.append("deprecated ");
        }
        if (this.method_225()) {
            var1.append("public ");
        }
        if (this.method_224()) {
            var1.append("protected ");
        }
        if (this.method_223()) {
            var1.append("private ");
        }
        if (this.method_217() && this.method_151()) {
            var1.append("abstract ");
        }
        if (this.method_226() && this.method_160()) {
            var1.append("static ");
        }
        if (this.method_221()) {
            var1.append("final ");
        }
        if (this.method_153()) {
            var1.append("enum ");
        } else if (this.method_145()) {
            var1.append("@interface ");
        } else if (this.method_151()) {
            var1.append("class ");
        } else {
            var1.append("interface ");
        }
        var1.append(this.field_197 != null ? class_233.method_1389(this.field_197) : "UNNAMED TYPE");
        var1.append("\n\textends ");
        var1.append(this.field_231 != null ? this.field_231.method_135() : "NULL TYPE");
        int var2;
        int var3;
        if (this.field_233 != null) {
            if (this.field_233 != class_34.field_155) {
                var1.append("\n\timplements : ");
                var2 = 0;
                for (var3 = this.field_233.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.field_233[var2] != null ? this.field_233[var2].method_135() : "NULL TYPE");
                }
            }
        } else {
            var1.append("NULL SUPERINTERFACES");
        }
        if (this.field_232 != null) {
            var1.append("\n\tenclosing type : ");
            var1.append(this.field_232.method_135());
        }
        if (this.field_234 != null) {
            if (this.field_234 != class_34.field_153) {
                var1.append("\n/*   fields   */");
                var2 = 0;
                for (var3 = this.field_234.length; var2 < var3; ++var2) {
                    var1.append(this.field_234[var2] != null ? "\n" + this.field_234[var2].toString() : "\nNULL FIELD");
                }
            }
        } else {
            var1.append("NULL FIELDS");
        }
        if (this.field_235 != null) {
            if (this.field_235 != class_34.field_154) {
                var1.append("\n/*   methods   */");
                var2 = 0;
                for (var3 = this.field_235.length; var2 < var3; ++var2) {
                    var1.append(this.field_235[var2] != null ? "\n" + this.field_235[var2].toString() : "\nNULL METHOD");
                }
            }
        } else {
            var1.append("NULL METHODS");
        }
        if (this.field_236 != null) {
            if (this.field_236 != class_34.field_156) {
                var1.append("\n/*   members   */");
                var2 = 0;
                for (var3 = this.field_236.length; var2 < var3; ++var2) {
                    var1.append(this.field_236[var2] != null ? "\n" + this.field_236[var2].toString() : "\nNULL TYPE");
                }
            }
        } else {
            var1.append("NULL MEMBER TYPES");
        }
        var1.append("\n\n\n");
        return var1.toString();
    }

    class_58[] method_244() {
        return this.field_235;
    }
}
