package m;

import a.class_33;
import a.class_341;
import b.class_233;
import f.class_229;
import f.class_325;
import f.class_326;
import g.class_13;
import g.class_14;
import g.class_16;
import g.class_312;
import g.class_313;
import h.class_108;
import h.class_123;
import h.class_146;
import h.class_89;
import h.class_90;
import h.class_91;
import h.class_93;
import m.class_0;
import m.class_17;
import m.class_32;
import m.class_34;
import m.class_35;
import m.class_36;
import m.class_37;
import m.class_38;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_45;
import m.class_46;
import m.class_47;
import m.class_50;
import m.class_51;
import m.class_52;
import m.class_54;
import m.class_58;
import m.class_59;
import m.class_61;
import m.class_62;
import m.class_63;
import m.class_65;
import m.class_67;
import m.class_69;
import m.class_80;
import m.class_81;
import m.class_84;
import m.class_85;
import m.class_86;
import m.class_87;
import n.class_241;
import n.class_248;

// $FF: renamed from: m.bb
public abstract class class_83 implements class_17 {

    // $FF: renamed from: i int
    public int field_373;
    // $FF: renamed from: a m.bb
    public class_83 field_374;
    // $FF: renamed from: a char[][]
    private static final char[][] field_375 = field_92;

    // $FF: renamed from: a (m.s, m.s) int
    public static int method_566(class_40 var0, class_40 var1) {
        return var0.method_152(var1) ? -1 : (var1.method_152(var0) ? 1 : 0);
    }

    // $FF: renamed from: a (char[]) m.s
    public static class_40 method_567(char[] var0) {
        int var1 = var0.length;
        if (var1 > 2 && var1 < 8) {
            switch (var0[0]) {
                case 98:
                    if (var1 == 7 && var0[1] == 111 && var0[2] == 111 && var0[3] == 108 && var0[4] == 101 && var0[5] == 97 && var0[6] == 110) {
                        return class_40.field_186;
                    }
                    if (var1 == 4 && var0[1] == 121 && var0[2] == 116 && var0[3] == 101) {
                        return class_40.field_180;
                    }
                    break;
                case 99:
                    if (var1 == 4 && var0[1] == 104 && var0[2] == 97 && var0[3] == 114) {
                        return class_40.field_182;
                    }
                    break;
                case 100:
                    if (var1 == 6 && var0[1] == 111 && var0[2] == 117 && var0[3] == 98 && var0[4] == 108 && var0[5] == 101) {
                        return class_40.field_185;
                    }
                case 101:
                case 103:
                case 104:
                case 106:
                case 107:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 116:
                case 117:
                default:
                    break;
                case 102:
                    if (var1 == 5 && var0[1] == 108 && var0[2] == 111 && var0[3] == 97 && var0[4] == 116) {
                        return class_40.field_184;
                    }
                    break;
                case 105:
                    if (var1 == 3 && var0[1] == 110 && var0[2] == 116) {
                        return class_40.field_179;
                    }
                    break;
                case 108:
                    if (var1 == 4 && var0[1] == 111 && var0[2] == 110 && var0[3] == 103) {
                        return class_40.field_183;
                    }
                    break;
                case 115:
                    if (var1 == 5 && var0[1] == 104 && var0[2] == 111 && var0[3] == 114 && var0[4] == 116) {
                        return class_40.field_181;
                    }
                    break;
                case 118:
                    if (var1 == 4 && var0[1] == 111 && var0[2] == 105 && var0[3] == 100) {
                        return class_40.field_188;
                    }
            }
        }
        return null;
    }

    // $FF: renamed from: a (m.as[]) m.as[]
    public static class_43[] method_568(class_43[] var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1 = var0.length;
            if (var1 == 0) {
                return null;
            } else {
                class_43[] var2 = var0;
                int var3 = 0;
                int var6;
                class_43 var7;
                for (int var4 = 0; var4 < var1; ++var4) {
                    class_43 var5 = var2[var4];
                    if (var5 != null) {
                        for (var6 = 0; var6 < var1; ++var6) {
                            if (var4 != var6) {
                                var7 = var2[var6];
                                if (var7 != null && var5.method_152(var7)) {
                                    if (var2 == var0) {
                                        System.arraycopy(var2, 0, var2 = new class_43[var1], 0, var1);
                                    }
                                    var2[var6] = null;
                                    ++var3;
                                }
                            }
                        }
                    }
                }
                if (var3 == 0) {
                    return var2;
                } else if (var1 == var3) {
                    return null;
                } else {
                    class_43[] var8 = new class_43[var1 - var3];
                    int var9 = 0;
                    for (var6 = 0; var9 < var1; ++var9) {
                        var7 = var2[var9];
                        if (var7 != null) {
                            var8[var6++] = var7;
                        }
                    }
                    return var8;
                }
            }
        }
    }

    // $FF: renamed from: a (m.s[]) m.s[]
    public static class_40[] method_569(class_40[] var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1 = var0.length;
            if (var1 == 0) {
                return null;
            } else {
                class_40[] var2 = var0;
                int var3 = 0;
                int var6;
                class_40 var7;
                for (int var4 = 0; var4 < var1; ++var4) {
                    class_40 var5 = var2[var4];
                    if (var5 != null) {
                        for (var6 = 0; var6 < var1; ++var6) {
                            if (var4 != var6) {
                                var7 = var2[var6];
                                if (var7 != null && var5.method_152(var7)) {
                                    if (var2 == var0) {
                                        System.arraycopy(var2, 0, var2 = new class_40[var1], 0, var1);
                                    }
                                    var2[var6] = null;
                                    ++var3;
                                }
                            }
                        }
                    }
                }
                if (var3 == 0) {
                    return var2;
                } else if (var1 == var3) {
                    return null;
                } else {
                    class_40[] var8 = new class_40[var1 - var3];
                    int var9 = 0;
                    for (var6 = 0; var9 < var1; ++var9) {
                        var7 = var2[var9];
                        if (var7 != null) {
                            var8[var6++] = var7;
                        }
                    }
                    return var8;
                }
            }
        }
    }

    // $FF: renamed from: a (m.j, m.as[]) m.as[]
    public static class_43[] method_570(class_32 var0, class_43[] var1) {
        if (var1 == null) {
            return null;
        } else {
            class_43[] var2 = var1;
            int var3 = 0;
            for (int var4 = var1.length; var3 < var4; ++var3) {
                class_43 var5 = var1[var3];
                class_40 var6 = method_571(var0, var5);
                if (!(var6 instanceof class_43)) {
                    return null;
                }
                if (var6 != var5) {
                    if (var2 == var1) {
                        System.arraycopy(var1, 0, var2 = new class_43[var4], 0, var3);
                    }
                    var2[var3] = (class_43)var6;
                } else if (var2 != var1) {
                    var2[var3] = var5;
                }
            }
            return var2;
        }
    }

    // $FF: renamed from: a (m.j, m.s) m.s
    public static class_40 method_571(class_32 var0, class_40 var1) {
        if (var1 == null) {
            return null;
        } else {
            class_43 var3;
            class_43 var4;
            class_40[] var6;
            class_43 var11;
            switch (var1.method_98()) {
                case 4:
                    if (var1.method_159()) {
                        var11 = (class_43)var1;
                        var3 = var1.method_137();
                        var4 = var3;
                        if (var3 != null) {
                            var4 = (class_43)method_571(var0, var3);
                        }
                        if (var4 != var3) {
                            return (class_40)(var0.method_92() ? var0.method_91().method_501(var11, var4) : var0.method_91().method_500(var11, (class_40[])null, var4));
                        }
                    }
                    break;
                case 68:
                    class_42 var7 = (class_42)var1;
                    class_40 var8 = var7.field_192;
                    class_40 var9 = method_571(var0, var8);
                    if (var9 != var8) {
                        return var7.field_194.method_493(var9.method_173(), var9.method_136() + var1.method_136());
                    }
                    break;
                case 260:
                    class_52 var2 = (class_52)var1;
                    var3 = var1.method_137();
                    var4 = var3;
                    if (var3 != null) {
                        var4 = (class_43)method_571(var0, var3);
                    }
                    class_40[] var16 = var2.field_243;
                    var6 = var16;
                    if (var16 != null) {
                        if (var0.method_92()) {
                            return var2.field_244.method_501(var2.method_286(), var4);
                        }
                        var6 = method_572(var0, var16);
                    }
                    if (var6 != var16 || var4 != var3) {
                        return var2.field_244.method_500(var2.method_286(), var6, var4);
                    }
                    break;
                case 516:
                case 8196:
                    class_45 var10 = (class_45)var1;
                    if (var10.field_215 != 0) {
                        class_40 var15 = var10.field_212;
                        class_40 var12 = method_571(var0, var15);
                        class_40[] var13 = var10.field_213;
                        class_40[] var14 = method_572(var0, var13);
                        if (var12 != var15 || var13 != var14) {
                            return var10.field_219.method_502(var10.field_210, var10.field_211, var12, var14, var10.field_215);
                        }
                    }
                    break;
                case 2052:
                    var11 = (class_43)var1;
                    var3 = var1.method_137();
                    var4 = var3;
                    if (var3 != null) {
                        var4 = (class_43)method_571(var0, var3);
                    }
                    if (var0.method_92()) {
                        return var0.method_91().method_501(var11, var4);
                    }
                    class_46[] var5 = var11.method_181();
                    var6 = method_572(var0, var5);
                    return var0.method_91().method_500(var11, var6, var4);
                case 4100:
                    return var0.method_90((class_46)var1);
            }
            return var1;
        }
    }

    // $FF: renamed from: a (m.j, m.s[]) m.s[]
    public static class_40[] method_572(class_32 var0, class_40[] var1) {
        if (var1 == null) {
            return null;
        } else {
            class_40[] var2 = var1;
            int var3 = 0;
            for (int var4 = var1.length; var3 < var4; ++var3) {
                class_40 var5 = var1[var3];
                class_40 var6 = method_571(var0, var5);
                if (var6 != var5) {
                    if (var2 == var1) {
                        System.arraycopy(var1, 0, var2 = new class_40[var4], 0, var3);
                    }
                    var2[var3] = var6;
                } else if (var2 != var1) {
                    var2[var3] = var5;
                }
            }
            return var2;
        }
    }

    // $FF: renamed from: <init> (int, m.bb) void
    protected class_83(int var1, class_83 var2) {
        this.field_373 = var1;
        this.field_374 = var2;
    }

    // $FF: renamed from: a (m.s) m.s
    public class_40 method_574(class_40 var1) {
        return var1.method_148() ? this.method_586().method_486(var1) : var1;
    }

    // $FF: renamed from: a () m.f
    public final class_84 method_575() {
        class_83 var1 = this;
        while (!(var1 instanceof class_84)) {
            var1 = var1.field_374;
            if (var1 == null) {
                return null;
            }
        }
        return (class_84)var1;
    }

    // $FF: renamed from: a () m.e
    public final class_85 method_576() {
        class_83 var1 = null;
        class_83 var2 = this;
        do {
            var1 = var2;
            var2 = var2.field_374;
        } while (var2 != null);
        return (class_85)var1;
    }

    // $FF: renamed from: a () a.c
    public final class_341 method_577() {
        return this.method_576().field_378.field_352;
    }

    // $FF: renamed from: a (m.ae, m.s[], m.ad) m.ae
    protected final class_58 method_578(class_58 var1, class_40[] var2, class_0 var3) {
        class_40[] var4 = var3.method_0();
        class_40[] var5 = var1.field_276;
        class_46[] var6 = var1.field_279;
        if (var5 == var2 && (var1.field_275.field_178 & 536870912L) == 0L && var4 == null && var6 == class_34.field_157) {
            return var1;
        } else {
            int var7 = var2.length;
            int var8 = var5.length;
            boolean var9 = var1.method_374();
            if (var7 != var8 && (!var9 || var7 < var8 - 1)) {
                return null;
            } else {
                class_61 var10000;
                if (var6 != class_34.field_157) {
                    class_40[] var10 = null;
                    for (int var11 = 0; var11 < var7; ++var11) {
                        class_40 var12 = var11 < var8 ? var5[var11] : var5[var8 - 1];
                        if (var2[var11].method_148() != var12.method_148()) {
                            if (var10 == null) {
                                var10 = new class_40[var7];
                                System.arraycopy(var2, 0, var10, 0, var7);
                            }
                            var10[var11] = this.method_586().method_486(var2[var11]);
                        }
                    }
                    if (var10 != null) {
                        var2 = var10;
                    }
                    var1 = class_63.method_400(var1, var2, this, var3);
                    if (var1 == null) {
                        return null;
                    }
                    if (!var1.method_101()) {
                        return var1;
                    }
                } else if (var4 != null) {
                    if (var1 instanceof class_63) {
                        if (!((class_63)var1).field_296) {
                            var10000 = new class_61(var1, var1.field_274, var4, 13);
                            return var10000;
                        }
                    } else if (this.method_577().field_1927 < 3342336L) {
                        var10000 = new class_61(var1, var1.field_274, var4, 11);
                        return var10000;
                    }
                }
                if (this.method_642(var1, var2) > -1) {
                    return var1;
                } else if (var4 != null) {
                    var10000 = new class_61(var1, var1.field_274, var2, 12);
                    return var10000;
                } else {
                    return null;
                }
            }
        }
    }

    // $FF: renamed from: a (h.br[], boolean) boolean
    protected boolean method_579(class_123[] var1, boolean var2) {
        if (var1 != null && this.method_577().field_1928 >= 3211264L) {
            class_312 var10000 = new class_312(2);
            class_312 var3 = var10000;
            boolean var4 = true;
            int var5 = 0;
            int var6;
            class_123 var7;
            class_46 var8;
            for (var6 = var1.length; var5 < var6; ++var5) {
                var7 = var1[var5];
                var8 = var7.field_668;
                if (var8 == null) {
                    return false;
                }
                var8.field_223 = this.method_609();
                var8.field_224 = class_34.field_155;
                var8.field_222 = null;
            }
            var5 = 0;
            for (var6 = var1.length; var5 < var6; ++var5) {
                var7 = var1[var5];
                var8 = var7.field_668;
                class_146 var9 = var7.field_660;
                if (var9 != null) {
                    boolean var10 = false;
                    class_40 var11 = this.field_373 == 2 ? var9.method_1017((class_86)this, false) : var9.method_1018((class_84)this);
                    if (var11 == null) {
                        var8.field_178 |= 131072L;
                    } else {
                        label155: {
                            var9.field_675 = var11;
                            switch (var11.method_98()) {
                                case 68:
                                    this.method_644().method_1486(var9, var11);
                                    var8.field_178 |= 131072L;
                                    break label155;
                                case 4100:
                                    var10 = true;
                                    class_46 var12 = (class_46)var11;
                                    if (var12.field_221 >= var8.field_221 && var12.field_220 == var8.field_220 && this.method_577().field_1927 <= 3276800L) {
                                        this.method_644().method_1557(var7, var12);
                                        var8.field_178 |= 131072L;
                                        break label155;
                                    }
                                    break;
                                default:
                                    if (((class_43)var11).method_221()) {
                                        this.method_644().method_1552(var8, var9);
                                    }
                            }
                            class_43 var19 = (class_43)var11;
                            if (!var11.method_157()) {
                                var8.field_223 = var19;
                            } else {
                                var8.field_224 = new class_43[] {var19};
                            }
                            var8.field_222 = var19;
                        }
                    }
                    class_146[] var20 = var7.field_669;
                    if (var20 != null) {
                        int var13 = 0;
                        for (int var14 = var20.length; var13 < var14; ++var13) {
                            var9 = var20[var13];
                            var11 = this.field_373 == 2 ? var9.method_1017((class_86)this, false) : var9.method_1018((class_84)this);
                            if (var11 == null) {
                                var8.field_178 |= 131072L;
                            } else {
                                boolean var15 = !var9.field_675.method_101();
                                if (var10 && var13 == 0) {
                                    this.method_644().method_1692(var9);
                                    var8.field_178 |= 131072L;
                                    var15 = true;
                                } else {
                                    if (var11.method_147()) {
                                        if (!var15) {
                                            this.method_644().method_1486(var9, var11);
                                            var8.field_178 |= 131072L;
                                        }
                                        continue;
                                    }
                                    if (!var11.method_157()) {
                                        if (!var15) {
                                            this.method_644().method_1487(var9, var11);
                                            var8.field_178 |= 131072L;
                                        }
                                        continue;
                                    }
                                }
                                if (!var2 || var8.field_222 != var8.field_223 || !this.method_621(var11, var8.field_223, var3, var8, var9)) {
                                    class_43 var16 = (class_43)var11;
                                    int var17 = var8.field_224.length;
                                    class_43 var18;
                                    do {
                                        --var17;
                                        if (var17 < 0) {
                                            var17 = var8.field_224.length;
                                            System.arraycopy(var8.field_224, 0, var8.field_224 = new class_43[var17 + 1], 0, var17);
                                            var8.field_224[var17] = var16;
                                            break;
                                        }
                                        var18 = var8.field_224[var17];
                                        if (var18 == var16) {
                                            this.method_644().method_1520(var9, var11);
                                            var8.field_178 |= 131072L;
                                            break;
                                        }
                                    } while (!var2 || !this.method_621(var11, var18, var3, var8, var9));
                                }
                            }
                        }
                    }
                    var4 &= (var8.field_178 & 131072L) == 0L;
                }
            }
            return var4;
        } else {
            return true;
        }
    }

    // $FF: renamed from: a (m.s, int) m.p
    public class_42 method_580(class_40 var1, int var2) {
        if (var1.method_101()) {
            return this.method_586().method_493(var1, var2);
        } else {
            class_42 var10000 = new class_42(var1, var2, this.method_586());
            return var10000;
        }
    }

    // $FF: renamed from: a (h.br[], m.w) m.x[]
    public class_46[] method_581(class_123[] var1, class_34 var2) {
        if (var1 != null && this.method_577().field_1928 >= 3211264L) {
            class_38 var3 = this.method_576().field_381;
            int var4 = var1.length;
            class_46[] var5 = new class_46[var4];
            int var6 = 0;
            for (int var7 = 0; var7 < var4; ++var7) {
                class_123 var8 = var1[var7];
                class_46 var10000 = new class_46(var8.field_659, var2, var7);
                class_46 var9 = var10000;
                var9.field_200 = var3;
                var8.field_668 = var9;
                for (int var10 = 0; var10 < var6; ++var10) {
                    class_46 var11 = var5[var10];
                    if (class_233.method_1364(var11.field_198, var8.field_659)) {
                        this.method_644().method_1537(var8);
                    }
                }
                var5[var6++] = var9;
            }
            if (var6 != var4) {
                System.arraycopy(var5, 0, var5 = new class_46[var6], 0, var6);
            }
            return var5;
        } else {
            return class_34.field_157;
        }
    }

    // $FF: renamed from: b () m.f
    public final class_84 method_582() {
        class_83 var1 = this;
        do {
            if ((var1 = var1.field_374) == null) {
                return null;
            }
        } while (!(var1 instanceof class_84));
        return (class_84)var1;
    }

    // $FF: renamed from: a () m.aj
    public final class_87 method_583() {
        class_83 var1 = this;
        do {
            if ((var1 = var1.field_374) == null) {
                return null;
            }
        } while (!(var1 instanceof class_87));
        return (class_87)var1;
    }

    // $FF: renamed from: a () m.as
    public final class_43 method_584() {
        class_83 var1 = this;
        while (!(var1 instanceof class_84)) {
            var1 = var1.field_374;
            if (var1 == null) {
                return null;
            }
        }
        return this.method_586().method_489(((class_84)var1).field_376.field_586);
    }

    // $FF: renamed from: a () m.az
    public final class_54 method_585() {
        class_83 var1 = this;
        while (!(var1 instanceof class_84)) {
            var1 = var1.field_374;
            if (var1 == null) {
                return null;
            }
        }
        return ((class_84)var1).field_376.field_586;
    }

    // $FF: renamed from: a () m.af
    public final class_80 method_586() {
        class_83 var2 = this;
        while (true) {
            class_83 var1 = var2.field_374;
            if (var2.field_374 == null) {
                return ((class_85)var2).field_378;
            }
            var2 = var1;
        }
    }

    // $FF: renamed from: a (m.as, char[], m.s[], m.ad, m.as, f.d, m.ae) m.ae
    protected class_58 method_587(class_43 var1, char[] var2, class_40[] var3, class_0 var4, class_43 var5, class_326 var6, class_58 var7) {
        int var8 = var6.field_1849;
        for (class_43 var9 = var5; var9 != null; var9 = var9.method_240()) {
            this.method_595(var9, var2, var6);
        }
        class_58[] var10 = null;
        int var11 = 0;
        class_58 var12 = null;
        int var13 = var6.field_1849;
        if (var13 > var8) {
            for (int var14 = var8; var14 < var13; ++var14) {
                class_58 var15 = (class_58)var6.method_3237(var14);
                class_58 var16 = this.method_578(var15, var3, var4);
                if (var16 != null) {
                    if (var16.method_101()) {
                        if (var7 == null || ((class_58)var7).field_278.method_140(var16.field_278) == null || !this.method_586().method_516().method_548((class_58)var7, var16)) {
                            if (var11 == 0) {
                                var10 = new class_58[var13 - var8 + 1];
                                if (var7 != null) {
                                    var10[var11++] = (class_58)var7;
                                }
                            }
                            var10[var11++] = var16;
                        }
                    } else if (var12 == null) {
                        var12 = var16;
                    }
                }
            }
        }
        if (var11 < 2) {
            if (var7 == null) {
                if (var11 == 0) {
                    return var12;
                }
                var7 = var10[0];
            }
            this.method_576().method_694(((class_58)var7).field_277);
            return (class_58)var7;
        } else {
            return this.method_577().field_1927 >= 3145728L ? this.method_639(var10, var11, var3, var4, var1) : this.method_638(var10, var11, var4);
        }
    }

    // $FF: renamed from: a (char[], m.as) m.as
    public class_43 method_588(char[] var1, class_43 var2) {
        if ((var2.field_178 & 65536L) != 0L) {
            return null;
        } else {
            class_43 var3 = this.method_584();
            class_85 var4 = this.method_576();
            var4.method_689(var2, var1);
            class_43 var5 = var2.method_209(var1);
            if (var5 == null) {
                return null;
            } else {
                var4.method_693(var5);
                if (var3 == null) {
                    if (var5.method_194(this.method_600())) {
                        return var5;
                    }
                } else if (var5.method_195(var2, var3)) {
                    return var5;
                }
                class_51 var10000 = new class_51(new char[][] {var1}, var5, 2);
                return var10000;
            }
        }
    }

    // $FF: renamed from: a (m.as, char[], m.s[], m.ad) m.ae
    public class_58 method_589(class_43 var1, char[] var2, class_40[] var3, class_0 var4) {
        class_85 var5 = this.method_576();
        var5.method_694(var3);
        class_58 var6 = var1.method_207(var2, var3, var5);
        if (var6 != null && var6.field_279 == class_34.field_157 && !var6.method_357()) {
            if (this.method_577().field_1928 >= 3211264L) {
                int var7 = var3.length;
                while (true) {
                    --var7;
                    if (var7 < 0) {
                        break;
                    }
                    if (var3[var7].method_166()) {
                        return null;
                    }
                }
            }
            var5.method_694(var6.field_277);
            if (var1.method_157() || var6.method_347(var1, var4, this)) {
                if (var1.field_177 != 1 && var3 == class_34.field_150 && class_233.method_1364(var2, class_17.field_34) && var6.field_275.method_162()) {
                    return class_62.method_399(var1, var6, this);
                }
                if (var4.method_0() != null) {
                    var6 = this.method_578(var6, var3, var4);
                }
                return var6;
            }
        }
        return null;
    }

    // $FF: renamed from: a (m.s, char[], m.ad, boolean) m.k
    public class_67 method_590(class_40 var1, char[] var2, class_0 var3, boolean var4) {
        class_85 var5 = this.method_576();
        var5.method_693(var1);
        class_40 var6;
        class_69 var10000;
        switch (var1.method_98()) {
            case 68:
                var6 = var1.method_173();
                break;
            case 132:
                return null;
            case 516:
            case 4100:
            case 8196:
                class_40 var7 = var1.method_138();
                if (var7.method_147()) {
                    var6 = var7.method_173();
                    break;
                }
            default:
                class_43 var22 = (class_43)var1;
                if (!var22.method_196(this)) {
                    var10000 = new class_69(var22, var2, 8);
                    return var10000;
                }
                var22.method_144();
                class_67 var21 = var22.method_208(var2, var4);
                if (var21 != null) {
                    if (var3 == null) {
                        if (var21.method_422(this.method_600())) {
                            return var21;
                        }
                    } else if (var21.method_423(var22, var3, this)) {
                        return var21;
                    }
                    var10000 = new class_69(var21, var21.field_314, var2, 2);
                    return var10000;
                }
                class_43[] var8 = null;
                int var9 = 0;
                class_67 var10 = null;
                boolean var11 = true;
                class_67 var12 = null;
                int var14;
                int var17;
                while (var11) {
                    class_43[] var13 = var22.method_241();
                    if (var13 != null && var13 != class_34.field_155) {
                        if (var8 == null) {
                            var8 = var13;
                            var9 = var13.length;
                        } else {
                            var14 = var13.length;
                            if (var9 + var14 >= var8.length) {
                                System.arraycopy(var8, 0, var8 = new class_43[var9 + var14 + 5], 0, var9);
                            }
                            label157:
                            for (int var15 = 0; var15 < var14; ++var15) {
                                class_43 var16 = var13[var15];
                                for (var17 = 0; var17 < var9; ++var17) {
                                    if (var16 == var8[var17]) {
                                        continue label157;
                                    }
                                }
                                var8[var9++] = var16;
                            }
                        }
                    }
                    if ((var22 = var22.method_240()) == null) {
                        break;
                    }
                    var5.method_693(var22);
                    var22.method_144();
                    if ((var21 = var22.method_208(var2, var4)) != null) {
                        var11 = false;
                        if (var21.method_423(var1, var3, this)) {
                            if (var10 != null) {
                                var10000 = new class_69(var10, var10.field_314, var2, 3);
                                return var10000;
                            }
                            var10 = var21;
                        } else if (var12 == null) {
                            var12 = var21;
                        }
                    }
                }
                if (var8 != null) {
                    class_69 var23 = null;
                    for (var14 = 0; var14 < var9; ++var14) {
                        class_43 var25 = var8[var14];
                        var5.method_693(var25);
                        if ((var21 = var25.method_208(var2, true)) != null) {
                            if (var10 != null) {
                                var10000 = new class_69(var10, var10.field_314, var2, 3);
                                var23 = var10000;
                                break;
                            }
                            var10 = var21;
                        } else {
                            class_43[] var24 = var25.method_241();
                            if (var24 != null && var24 != class_34.field_155) {
                                var17 = var24.length;
                                if (var9 + var17 >= var8.length) {
                                    System.arraycopy(var8, 0, var8 = new class_43[var9 + var17 + 5], 0, var9);
                                }
                                label130:
                                for (int var18 = 0; var18 < var17; ++var18) {
                                    class_43 var19 = var24[var18];
                                    for (int var20 = 0; var20 < var9; ++var20) {
                                        if (var19 == var8[var20]) {
                                            continue label130;
                                        }
                                    }
                                    var8[var9++] = var19;
                                }
                            }
                        }
                    }
                    if (var23 != null) {
                        return var23;
                    }
                }
                if (var10 != null) {
                    return var10;
                }
                if (var12 != null) {
                    var10000 = new class_69(var12, var22, var2, 2);
                    return var10000;
                }
                return null;
        }
        if (var6 instanceof class_43 && !((class_43)var6).method_196(this)) {
            var10000 = new class_69((class_43)var6, var2, 8);
            return var10000;
        } else if (class_233.method_1364(var2, class_17.field_32)) {
            if ((var6.field_178 & 128L) != 0L) {
                var10000 = new class_69(class_42.field_191, (class_43)null, var2, 1);
                return var10000;
            } else {
                return class_42.field_191;
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: b (char[], m.as) m.as
    public class_43 method_591(char[] var1, class_43 var2) {
        if ((var2.field_178 & 65536L) != 0L) {
            return null;
        } else {
            class_54 var3 = this.method_585();
            class_38 var4 = this.method_600();
            class_85 var5 = this.method_576();
            var5.method_689(var2, var1);
            class_43 var6 = var2.method_209(var1);
            class_51 var10000;
            if (var6 != null) {
                var5.method_693(var6);
                if (var3 == null) {
                    if (var6.method_194(var4)) {
                        return var6;
                    }
                } else if (var6.method_195(var2, var3)) {
                    return var6;
                }
                var10000 = new class_51(new char[][] {var1}, var6, 2);
                return var10000;
            } else {
                class_43 var7 = var2;
                class_43[] var8 = null;
                int var9 = 0;
                class_43 var10 = null;
                boolean var11 = true;
                class_43 var12 = null;
                int var17;
                int var22;
                while (var11) {
                    class_43[] var13 = var7.method_241();
                    if (var13 == null) {
                        class_43 var14 = var7.method_162() ? ((class_52)var7).method_286() : var7;
                        if (var14.method_222()) {
                            return null;
                        }
                        ((class_54)var14).field_258.method_666();
                        var13 = var7.method_241();
                    }
                    if (var13 != null && var13 != class_34.field_155) {
                        if (var8 == null) {
                            var8 = var13;
                            var9 = var13.length;
                        } else {
                            var22 = var13.length;
                            if (var9 + var22 >= var8.length) {
                                System.arraycopy(var8, 0, var8 = new class_43[var9 + var22 + 5], 0, var9);
                            }
                            label156:
                            for (int var15 = 0; var15 < var22; ++var15) {
                                class_43 var16 = var13[var15];
                                for (var17 = 0; var17 < var9; ++var17) {
                                    if (var16 == var8[var17]) {
                                        continue label156;
                                    }
                                }
                                var8[var9++] = var16;
                            }
                        }
                    }
                    if ((var7 = var7.method_240()) == null) {
                        break;
                    }
                    var5.method_689(var7, var1);
                    if ((var6 = var7.method_209(var1)) != null) {
                        label142: {
                            var5.method_693(var6);
                            var11 = false;
                            if (var3 == null) {
                                if (var6.method_194(var4)) {
                                    break label142;
                                }
                            } else if (var6.method_195(var2, var3)) {
                                break label142;
                            }
                            var12 = var6;
                            continue;
                        }
                        if (var10 != null) {
                            var10000 = new class_51(new char[][] {var1}, var10, 3);
                            return var10000;
                        }
                        var10 = var6;
                    }
                }
                if (var8 != null) {
                    class_51 var21 = null;
                    for (var22 = 0; var22 < var9; ++var22) {
                        Object var24 = var8[var22];
                        var5.method_689((class_43)var24, var1);
                        if ((var6 = ((class_43)var24).method_209(var1)) != null) {
                            var5.method_693(var6);
                            if (var10 != null) {
                                var10000 = new class_51(new char[][] {var1}, var10, 3);
                                var21 = var10000;
                                break;
                            }
                            var10 = var6;
                        } else {
                            class_43[] var23 = ((class_43)var24).method_241();
                            if (var23 != null && var23 != class_34.field_155) {
                                var17 = var23.length;
                                if (var9 + var17 >= var8.length) {
                                    System.arraycopy(var8, 0, var8 = new class_43[var9 + var17 + 5], 0, var9);
                                }
                                label119:
                                for (int var18 = 0; var18 < var17; ++var18) {
                                    class_43 var19 = var23[var18];
                                    for (int var20 = 0; var20 < var9; ++var20) {
                                        if (var19 == var8[var20]) {
                                            continue label119;
                                        }
                                    }
                                    var8[var9++] = var19;
                                }
                            }
                        }
                    }
                    if (var21 != null) {
                        return var21;
                    }
                }
                if (var10 != null) {
                    return var10;
                } else if (var12 != null) {
                    var10000 = new class_51(new char[][] {var1}, var12, 2);
                    return var10000;
                } else {
                    return null;
                }
            }
        }
    }

    // $FF: renamed from: b (m.as, char[], m.s[], m.ad) m.ae
    public class_58 method_592(class_43 var1, char[] var2, class_40[] var3, class_0 var4) {
        return this.method_593(var1, var2, var3, var4, false);
    }

    // $FF: renamed from: a (m.as, char[], m.s[], m.ad, boolean) m.ae
    public class_58 method_593(class_43 var1, char[] var2, class_40[] var3, class_0 var4, boolean var5) {
        class_43 var6 = var1;
        boolean var7 = var1.method_157();
        class_326 var10000 = new class_326(3);
        class_326 var8 = var10000;
        class_85 var9 = this.method_576();
        var9.method_694(var3);
        if (var7) {
            var9.method_693(var1);
            class_58[] var10 = var1.method_210(var2);
            if (var10.length > 0) {
                var8.method_3232(var10);
            }
            this.method_595(var1, var2, var8);
            var6 = this.method_609();
        }
        long var33 = this.method_577().field_1927;
        boolean var12 = var33 >= 3145728L;
        boolean var13 = var33 >= 3211264L;
        class_43 var14 = var6;
        int var18;
        int var21;
        class_58 var23;
        int var22;
        for (class_81 var15 = this.method_586().method_516(); var6 != null; var6 = var6.method_240()) {
            var9.method_693(var6);
            class_58[] var16 = var6.method_210(var2);
            int var17 = var16.length;
            if (var17 > 0) {
                int var19;
                class_58 var20;
                if (var12 && (var7 || var8.field_1849 > 0)) {
                    var18 = 0;
                    for (var19 = var17; var18 < var19; ++var18) {
                        var20 = var16[var18];
                        if (var20 != null) {
                            if (var7 && !var20.method_369()) {
                                --var17;
                                var16[var18] = null;
                            } else {
                                var21 = 0;
                                for (var22 = var8.field_1849; var21 < var22; ++var21) {
                                    var23 = (class_58)var8.method_3237(var21);
                                    if (var15.method_548(var23.method_376(), var20.method_376())) {
                                        if (!var13 || !var23.method_357() || var20.method_357()) {
                                            --var17;
                                            var16[var18] = null;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (var17 > 0) {
                    if (var16.length == var17) {
                        var8.method_3232(var16);
                    } else {
                        var18 = 0;
                        for (var19 = var16.length; var18 < var19; ++var18) {
                            var20 = var16[var18];
                            if (var20 != null) {
                                var8.method_3231(var20);
                            }
                        }
                    }
                }
            }
        }
        int var34 = var8.field_1849;
        class_58[] var35 = null;
        var18 = 0;
        class_58 var37 = null;
        boolean var36 = var12 && !var7 && (var1.method_217() || var1.method_169());
        class_58 var38;
        if (var34 > 0) {
            for (var21 = 0; var21 < var34; ++var21) {
                var38 = (class_58)var8.method_3237(var21);
                var23 = this.method_578(var38, var3, var4);
                if (var23 != null) {
                    if (var23.method_101()) {
                        if (var34 == 1 && var23.method_347(var1, var4, this)) {
                            if (var36) {
                                return this.method_587(var1, var2, var3, var4, var14, var8, var23);
                            }
                            var9.method_694(var23.field_277);
                            return var23;
                        }
                        if (var18 == 0) {
                            var35 = new class_58[var34];
                        }
                        var35[var18++] = var23;
                    } else if (var37 == null) {
                        var37 = var23;
                    }
                }
            }
        }
        int var24;
        class_61 var46;
        if (var18 == 0) {
            class_58 var40 = this.method_587(var1, var2, var3, var4, var14, var8, (class_58)null);
            if (var40 != null) {
                return var40;
            } else if (var8.field_1849 == 0) {
                return null;
            } else if (var37 != null) {
                return var37;
            } else {
                var22 = -1;
                var23 = (class_58)var8.method_3237(0);
                var24 = var3.length;
                var34 = var8.field_1849;
                for (int var42 = 0; var42 < var34; ++var42) {
                    class_58 var26 = (class_58)var8.method_3237(var42);
                    class_40[] var27 = var26.field_276;
                    int var28 = var27.length;
                    int var29 = 0;
                    int var30 = 0;
                    int var32;
                    while (var30 < var24) {
                        class_40 var31 = var3[var30];
                        var32 = var30 == 0 ? 0 : var30 - 1;
                        while (true) {
                            if (var32 < var28 && var32 < var30 + 1) {
                                if (var27[var32] != var31) {
                                    ++var32;
                                    continue;
                                }
                                ++var29;
                            }
                            ++var30;
                            break;
                        }
                    }
                    if (var29 >= var22) {
                        if (var29 == var22) {
                            var30 = var28 < var24 ? 2 * (var24 - var28) : var28 - var24;
                            int var45 = var23.field_276.length;
                            var32 = var45 < var24 ? 2 * (var24 - var45) : var45 - var24;
                            if (var30 >= var32) {
                                continue;
                            }
                        }
                        var22 = var29;
                        var23 = var26;
                    }
                }
                var46 = new class_61(var23, var23.field_274, var3, 1);
                return var46;
            }
        } else {
            var21 = 0;
            if (var7) {
                if (var18 == 1) {
                    var9.method_694(var35[0].field_277);
                    return var35[0];
                }
                var21 = var18;
            } else {
                for (var22 = 0; var22 < var18; ++var22) {
                    Object var43 = var35[var22];
                    if (((class_58)var43).method_347(var1, var4, this)) {
                        if (var21 != var22) {
                            var35[var22] = null;
                            var35[var21] = (class_58)var43;
                        }
                        ++var21;
                    }
                }
                switch (var21) {
                    case 0:
                        var38 = this.method_587(var1, var2, var3, var4, var14, var8, (class_58)null);
                        if (var38 != null) {
                            return var38;
                        }
                        var46 = new class_61(var35[0], var35[0].field_274, var35[0].field_276, 2);
                        return var46;
                    case 1:
                        if (var36) {
                            return this.method_587(var1, var2, var3, var4, var14, var8, var35[0]);
                        }
                        var9.method_694(var35[0].field_277);
                        return var35[0];
                }
            }
            if (var33 <= 3080192L) {
                class_43 var39 = var35[0].field_278;
                return !var39.method_157() ? this.method_637(var35, var21, var4) : this.method_638(var35, var21, var4);
            } else {
                if (this.method_577().field_1928 >= 3211264L) {
                    for (var22 = 0; var22 < var21; ++var22) {
                        var23 = var35[var22];
                        if (var23 instanceof class_63) {
                            var23 = ((class_63)var23).field_292;
                        }
                        if (var23 instanceof class_62) {
                            for (var24 = var22 + 1; var24 < var21; ++var24) {
                                class_58 var25 = var35[var24];
                                if (var25 == var23 || var23.field_278 == var25.field_278 && var23.method_344(var25)) {
                                    var46 = new class_61(var35[var22], var35[var22].field_274, var35[var22].field_276, 3);
                                    return var46;
                                }
                            }
                        }
                    }
                }
                if (var5) {
                    class_58[] var44 = new class_58[var21];
                    int var41 = 0;
                    for (var24 = 0; var24 < var21; ++var24) {
                        if (var35[var24].method_370()) {
                            var44[var41++] = var35[var24];
                        }
                    }
                    if (var41 == 1) {
                        return var44[0];
                    }
                    if (var41 > 1) {
                        return this.method_639(var44, var41, var3, var4, var1);
                    }
                }
                var38 = this.method_639(var35, var21, var3, var4, var1);
                if (var36) {
                    if (var38.method_101()) {
                        return this.method_587(var1, var2, var3, var4, var14, var8, var38);
                    }
                    var23 = this.method_587(var1, var2, var3, var4, var14, var8, (class_58)null);
                    if (var23 != null && var23.method_101()) {
                        return var23;
                    }
                }
                return var38;
            }
        }
    }

    // $FF: renamed from: a (m.p, char[], m.s[], m.ad) m.ae
    public class_58 method_594(class_42 var1, char[] var2, class_40[] var3, class_0 var4) {
        class_40 var5 = var1.method_173();
        class_61 var8;
        if (var5 instanceof class_43 && !((class_43)var5).method_196(this)) {
            var8 = new class_61(var2, class_34.field_150, (class_43)var5, 8);
            return var8;
        } else {
            class_43 var6 = this.method_609();
            class_58 var7 = var6.method_207(var2, var3, (class_85)null);
            if (var7 != null) {
                if (var3 == class_34.field_150) {
                    switch (var2[0]) {
                        case 99:
                            if (class_233.method_1364(var2, class_17.field_33)) {
                                class_40 var9;
                                if (this.method_577().field_1929 >= 3145728L) {
                                    var9 = var1;
                                } else {
                                    var9 = var6;
                                }
                                class_59 var10000 = new class_59(var9, var7.field_273 & -5 | 1, class_17.field_33, var7.field_275, var3, (class_43[])null, var6);
                                return var10000;
                            }
                            break;
                        case 103:
                            if (class_233.method_1364(var2, class_17.field_34) && var7.field_275.method_162()) {
                                return class_62.method_399(var1, var7, this);
                            }
                    }
                }
                if (var7.method_347(var1, var4, this)) {
                    return var7;
                }
            }
            var7 = this.method_592(var6, var2, var3, var4);
            if (var7 == null) {
                var8 = new class_61(var2, var3, 1);
                return var8;
            } else {
                return var7;
            }
        }
    }

    // $FF: renamed from: a (m.as, char[], f.d) void
    protected void method_595(class_43 var1, char[] var2, class_326 var3) {
        class_43[] var4 = var1.method_241();
        if (var4 != null && var4 != class_34.field_155) {
            class_43[] var5 = var4;
            int var6 = var4.length;
            for (int var7 = 0; var7 < var6; ++var7) {
                var1 = var5[var7];
                this.method_576().method_693(var1);
                class_58[] var8 = var1.method_210(var2);
                int var9;
                int var10;
                if (var8.length > 0) {
                    var9 = var3.field_1849;
                    if (var9 > 0) {
                        var10 = 0;
                        label67:
                        for (int var11 = var8.length; var10 < var11; ++var10) {
                            class_58 var12 = var8[var10];
                            for (int var13 = 0; var13 < var9; ++var13) {
                                if (var12 == var3.method_3237(var13)) {
                                    continue label67;
                                }
                            }
                            var3.method_3231(var12);
                        }
                    } else {
                        var3.method_3232(var8);
                    }
                }
                if ((var4 = var1.method_241()) != null && var4 != class_34.field_155) {
                    var9 = var4.length;
                    if (var6 + var9 >= var5.length) {
                        System.arraycopy(var5, 0, var5 = new class_43[var6 + var9 + 5], 0, var6);
                    }
                    label51:
                    for (var10 = 0; var10 < var9; ++var10) {
                        class_43 var14 = var4[var10];
                        for (int var15 = 0; var15 < var6; ++var15) {
                            if (var14 == var5[var15]) {
                                continue label51;
                            }
                        }
                        var5[var6++] = var14;
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (char[], m.ar, m.ar) m.as
    public class_43 method_596(char[] var1, class_38 var2, class_38 var3) {
        this.method_576().method_688(var2.field_171, var1);
        class_43 var4 = var2.method_123(var1);
        if (var4 == null) {
            return null;
        } else if (var4.method_101() && var2 != var3 && !var4.method_194(var3)) {
            class_51 var10000 = new class_51(new char[][] {var1}, var4, 2);
            return var10000;
        } else {
            return var4;
        }
    }

    // $FF: renamed from: a (char[]) m.ab
    public class_65 method_597(char[] var1) {
        return null;
    }

    // $FF: renamed from: a (char[], int, m.ad, boolean) m.w
    public class_34 method_598(char[] var1, int var2, class_0 var3, boolean var4) {
        class_85 var5 = this.method_576();
        class_80 var6 = var5.field_378;
        try {
            var6.field_363 = var3;
            Object var7 = null;
            class_67 var8 = null;
            if ((var2 & 3) != 0) {
                boolean var9 = false;
                boolean var10 = false;
                boolean var11 = false;
                class_67 var12 = null;
                class_69 var13 = null;
                class_83 var14 = this;
                int var15 = 0;
                int var16 = 0;
                class_43 var17 = null;
                label606:
                while (true) {
                    class_67 var23;
                    class_69 var10000;
                    switch (var14.field_373) {
                        case 2:
                            class_87 var37 = (class_87)var14;
                            var9 |= var37.field_404;
                            var10 |= var37.field_405;
                            var11 = var37.field_412;
                        case 1:
                            class_65 var40 = var14.method_597(var1);
                            if (var40 != null) {
                                if (var12 != null && var12.method_101()) {
                                    var10000 = new class_69(var12, var12.field_314, var1, 5);
                                    class_69 var51 = var10000;
                                    return var51;
                                }
                                if (var15 > 0) {
                                    var3.method_2(var15);
                                }
                                class_65 var50 = var40;
                                return var50;
                            }
                            break;
                        case 3:
                            class_84 var47 = (class_84)var14;
                            class_43 var49 = var47.method_584();
                            if (!var11) {
                                class_67 var43 = var47.method_590(var49, var1, var3, var4);
                                if (var43 != null) {
                                    class_69 var52;
                                    if (var43.method_102() == 3) {
                                        if (var12 != null && var12.method_102() != 2) {
                                            var10000 = new class_69(var12, var12.field_314, var1, 5);
                                            var52 = var10000;
                                            return var52;
                                        }
                                        var23 = var43;
                                        return var23;
                                    }
                                    var52 = null;
                                    if (var43.method_101()) {
                                        if (!var43.method_431()) {
                                            if (var10) {
                                                var10000 = new class_69(var43, var43.field_314, var1, 6);
                                                var52 = var10000;
                                            } else if (var9) {
                                                var10000 = new class_69(var43, var43.field_314, var1, 7);
                                                var52 = var10000;
                                            }
                                        }
                                        if (var49 == var43.field_314 || this.method_577().field_1927 >= 3145728L) {
                                            if (var12 == null) {
                                                if (var15 > 0) {
                                                    var3.method_2(var15);
                                                    var3.method_4(var49);
                                                }
                                                Object var54 = var52 == null ? var43 : var52;
                                                return (class_34)var54;
                                            }
                                            if (var12.method_101() && var12.field_314 != var43.field_314) {
                                                var10000 = new class_69(var12, var12.field_314, var1, 5);
                                                class_69 var53 = var10000;
                                                return var53;
                                            }
                                        }
                                    }
                                    if (var12 == null || var12.method_102() == 2 && var43.method_102() != 2) {
                                        var16 = var15;
                                        var17 = var49;
                                        var13 = var52;
                                        var12 = var43;
                                    }
                                }
                            }
                            var11 = false;
                            ++var15;
                            var9 |= var49.method_226();
                            class_87 var44 = var14.method_635();
                            var10 = var44 == null ? false : var44.field_405;
                            break;
                        case 4:
                            if (var13 != null) {
                                class_69 var38 = var13;
                                return var38;
                            }
                            if (var12 != null) {
                                if (var12.method_101()) {
                                    if (var16 > 0) {
                                        var3.method_2(var16);
                                        var3.method_4(var17);
                                    }
                                    class_67 var39 = var12;
                                    return var39;
                                }
                                var8 = var12;
                                var12 = null;
                            }
                            if (this.method_577().field_1928 >= 3211264L) {
                                var5.method_679();
                                class_35[] var18 = var5.field_382;
                                if (var18 != null) {
                                    int var19 = 0;
                                    int var20;
                                    for (var20 = var18.length; var19 < var20; ++var19) {
                                        class_35 var21 = var18[var19];
                                        if (var21.method_106() && !var21.field_163 && class_233.method_1364(var21.field_162[var21.field_162.length - 1], var1) && var5.method_695(var21) != null && var21.field_165 instanceof class_67) {
                                            var12 = (class_67)var21.field_165;
                                            class_91 var22 = var21.field_164;
                                            if (var22 != null && var4) {
                                                var22.field_446 |= 2;
                                            }
                                            var3.method_4(var12.field_314);
                                            if (var12.method_101()) {
                                                var23 = var12;
                                                return var23;
                                            }
                                            if (var8 == null) {
                                                var8 = var12;
                                            }
                                        }
                                    }
                                    boolean var41 = false;
                                    var20 = 0;
                                    for (int var48 = var18.length; var20 < var48; ++var20) {
                                        class_35 var42 = var18[var20];
                                        if (var42.method_106() && var42.field_163) {
                                            class_34 var45 = var42.field_165;
                                            if (var45 instanceof class_43) {
                                                class_67 var24 = this.method_590((class_43)var45, var1, var3, var4);
                                                if (var24 != null) {
                                                    if (!var24.method_101()) {
                                                        if (var8 == null) {
                                                            var8 = var24;
                                                        }
                                                    } else if (var24.method_431() && var12 != var24) {
                                                        class_91 var25 = var42.field_164;
                                                        if (var25 != null && var4) {
                                                            var25.field_446 |= 2;
                                                        }
                                                        if (var41) {
                                                            var10000 = new class_69(var12, var12.field_314, var1, 3);
                                                            class_69 var26 = var10000;
                                                            return var26;
                                                        }
                                                        var12 = var24;
                                                        var41 = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (var12 != null) {
                                        var3.method_4(var12.field_314);
                                        class_67 var46 = var12;
                                        return var46;
                                    }
                                }
                            }
                            break label606;
                    }
                    var14 = var14.field_374;
                }
            }
            Object var33;
            if ((var2 & 4) != 0) {
                class_40 var32;
                if ((var32 = method_567(var1)) != null) {
                    class_40 var35 = var32;
                    return var35;
                }
                var7 = this.method_619(var1, (var2 & 16) == 0 ? 4 : 20, var4);
                if (((class_34)var7).method_101() || var2 == 4) {
                    var33 = var7;
                    return (class_34)var33;
                }
            } else if ((var2 & 16) != 0) {
                var5.method_690(var1);
                if ((var7 = var6.method_507(var1)) != null) {
                    var33 = var7;
                    return (class_34)var33;
                }
            }
            if (var8 != null) {
                class_67 var36 = var8;
                return var36;
            } else if (var7 != null && ((class_34)var7).method_102() != 1) {
                var33 = var7;
                return (class_34)var33;
            } else {
                class_37 var55 = new class_37(var1, this.method_585(), 1);
                class_37 var34 = var55;
                return var34;
            }
        } catch (class_241 var30) {
            var30.method_1437(var3, this.method_645().field_455);
            throw var30;
        } finally {
            var6.field_363 = null;
        }
    }

    // $FF: renamed from: a (m.as, m.s[], m.ad) m.ae
    public class_58 method_599(class_43 var1, class_40[] var2, class_0 var3) {
        class_85 var4 = this.method_576();
        class_80 var5 = var4.field_378;
        class_58 var23;
        try {
            var5.field_363 = var3;
            var4.method_693(var1);
            var4.method_694(var2);
            class_58 var6 = var1.method_206(var2);
            if (var6 != null && var6.method_345(var3, this)) {
                if (var3.method_0() != null) {
                    var6 = this.method_578(var6, var2, var3);
                }
                class_58 var20 = var6;
                return var20;
            }
            class_58[] var7 = var1.method_210(class_17.field_135);
            class_61 var10000;
            if (var7 == class_34.field_154) {
                var10000 = new class_61(class_17.field_135, var2, 1);
                class_61 var21 = var10000;
                return var21;
            }
            class_58[] var8 = new class_58[var7.length];
            int var9 = 0;
            class_58 var10 = null;
            int var11 = 0;
            int var12;
            class_58 var13;
            for (var12 = var7.length; var11 < var12; ++var11) {
                var13 = this.method_578(var7[var11], var2, var3);
                if (var13 != null) {
                    if (var13.method_101()) {
                        var8[var9++] = var13;
                    } else if (var10 == null) {
                        var10 = var13;
                    }
                }
            }
            if (var9 != 0) {
                class_58[] var22 = new class_58[var9];
                var12 = 0;
                for (int var25 = 0; var25 < var9; ++var25) {
                    class_58 var14 = var8[var25];
                    if (var14.method_345(var3, this)) {
                        var22[var12++] = var14;
                    }
                }
                if (var12 == 1) {
                    var13 = var22[0];
                    return var13;
                }
                if (var12 == 0) {
                    var10000 = new class_61(var8[0], class_17.field_135, var8[0].field_276, 2);
                    class_61 var26 = var10000;
                    return var26;
                }
                var13 = this.method_639(var22, var12, var2, var3, var1);
                return var13;
            }
            if (var10 == null) {
                var10000 = new class_61(var7[0], class_17.field_135, var2, 1);
                class_61 var24 = var10000;
                return var24;
            }
            var23 = var10;
        } catch (class_241 var18) {
            var18.method_1437(var3, this.method_645().field_455);
            throw var18;
        } finally {
            var5.field_363 = null;
        }
        return var23;
    }

    // $FF: renamed from: a () m.ar
    public final class_38 method_600() {
        class_83 var2 = this;
        while (true) {
            class_83 var1 = var2.field_374;
            if (var2.field_374 == null) {
                return ((class_85)var2).field_381;
            }
            var2 = var1;
        }
    }

    // $FF: renamed from: a (m.s, char[], m.ad) m.k
    public class_67 method_601(class_40 var1, char[] var2, class_0 var3) {
        class_80 var4 = this.method_586();
        class_67 var6;
        try {
            var4.field_363 = var3;
            class_67 var5 = this.method_590(var1, var2, var3, true);
            if (var5 == null) {
                class_69 var10000 = new class_69(var1 instanceof class_43 ? (class_43)var1 : null, var2, 1);
                class_69 var12 = var10000;
                return var12;
            }
            var6 = var5;
        } catch (class_241 var10) {
            var10.method_1437(var3, this.method_645().field_455);
            throw var10;
        } finally {
            var4.field_363 = null;
        }
        return var6;
    }

    // $FF: renamed from: a (char[], m.s[], m.ad) m.ae
    public class_58 method_602(char[] var1, class_40[] var2, class_0 var3) {
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        class_58 var7 = null;
        Object var8 = null;
        boolean var9 = false;
        class_83 var10 = this;
        int var11 = 0;
        class_341 var12;
        boolean var13 = (var12 = this.method_577()).field_1927 >= 3145728L;
        while (true) {
            class_61 var35;
            switch (var10.field_373) {
                case 2:
                    class_87 var27 = (class_87)var10;
                    var4 |= var27.field_404;
                    var5 |= var27.field_405;
                    var6 = var27.field_412;
                    break;
                case 3:
                    class_84 var26 = (class_84)var10;
                    class_43 var28 = var26.method_584();
                    if (!var6) {
                        class_58 var29 = var26.method_589(var28, var1, var2, var3);
                        if (var29 == null) {
                            var29 = var26.method_592(var28, var1, var2, var3);
                        }
                        if (var29 != null) {
                            if (var7 == null) {
                                if (var29.method_101()) {
                                    if (!var29.method_370() && (var5 || var4)) {
                                        if (var8 != null && ((class_58)var8).method_102() != 2) {
                                            return (class_58)var8;
                                        }
                                        var35 = new class_61(var29, var29.field_274, var29.field_276, var5 ? 6 : 7);
                                        return var35;
                                    }
                                    if (var13 || var28 == var29.field_278 || var28.method_210(var1) != class_34.field_154) {
                                        if (var9) {
                                            return (class_58)var8;
                                        }
                                        if (var11 > 0) {
                                            var3.method_2(var11);
                                            var3.method_4(var28);
                                        }
                                        if (var28.field_177 != 1 && var2 == class_34.field_150 && class_233.method_1364(var1, class_17.field_34) && var29.field_275.method_162()) {
                                            return class_62.method_399(var28, var29, this);
                                        }
                                        return var29;
                                    }
                                    if (var8 == null || ((class_58)var8).method_102() == 2) {
                                        if (var8 != null) {
                                            var8 = null;
                                        }
                                        if (var11 > 0) {
                                            var3.method_2(var11);
                                            var3.method_4(var28);
                                        }
                                        var7 = var29;
                                    }
                                } else {
                                    if (var29.method_102() != 2 && var29.method_102() != 1) {
                                        return var29;
                                    }
                                    if (var8 == null) {
                                        var8 = var29;
                                    }
                                    if (!var9 && var29.method_102() == 1) {
                                        class_58 var30 = ((class_61)var29).field_291;
                                        if (var30 != null && var30.method_347(var28, var3, this)) {
                                            var8 = var29;
                                            var9 = true;
                                        }
                                    }
                                }
                            } else if (var29.method_102() == 3 || var7.field_278 != var29.field_278 && (var28 == var29.field_278 || var28.method_210(var1) != class_34.field_154)) {
                                var35 = new class_61(var29, var1, var2, 5);
                                return var35;
                            }
                        }
                    }
                    var6 = false;
                    ++var11;
                    var4 |= var28.method_226();
                    class_87 var32 = var10.method_635();
                    var5 = var32 == null ? false : var32.field_405;
                    break;
                case 4:
                    if (var4 && var12.field_1928 >= 3211264L) {
                        if (var8 != null) {
                            if (((class_58)var8).field_278 != null && ((class_58)var8).field_278.field_177 == 1) {
                                return (class_58)var8;
                            }
                            if (((class_58)var8).method_102() == 1 && var9) {
                                return (class_58)var8;
                            }
                        }
                        class_85 var14 = (class_85)var10;
                        var14.method_679();
                        class_35[] var15 = var14.field_382;
                        if (var15 != null) {
                            class_326 var16 = null;
                            boolean var17 = false;
                            int var18 = 0;
                            for (int var19 = var15.length; var18 < var19; ++var18) {
                                class_35 var20 = var15[var18];
                                if (var20.method_106()) {
                                    class_34 var21 = var20.field_165;
                                    class_58 var22 = null;
                                    class_58 var23;
                                    if (var20.field_163) {
                                        if (!var17 && var21 instanceof class_43) {
                                            var22 = this.method_593((class_43)var21, var1, var2, var3, true);
                                        }
                                    } else if (var21 instanceof class_58) {
                                        var23 = (class_58)var21;
                                        if (class_233.method_1364(var23.field_274, var1)) {
                                            var22 = this.method_593(var23.field_278, var1, var2, var3, true);
                                        }
                                    } else if (var21 instanceof class_67) {
                                        class_67 var33 = (class_67)var21;
                                        if (class_233.method_1364(var33.field_302, var1)) {
                                            char[][] var24 = var20.field_164.field_467;
                                            class_40 var25 = this.method_618(var24, var24.length - 1);
                                            if (var25 != null) {
                                                var22 = this.method_593((class_43)var25, var1, var2, var3, true);
                                            }
                                        }
                                    }
                                    if (var22 != null && var22 != var8) {
                                        if (!var22.method_101()) {
                                            if (var8 == null) {
                                                var8 = var22;
                                            }
                                        } else if (var22.method_370()) {
                                            var23 = this.method_578(var22, var2, var3);
                                            if (var23 != null) {
                                                if (var23.method_101()) {
                                                    if (var23.method_346(var14.field_381)) {
                                                        if (var16 == null || !var16.method_3234(var23)) {
                                                            class_91 var34 = var20.field_164;
                                                            if (var34 != null) {
                                                                var34.field_446 |= 2;
                                                            }
                                                            if (!var17 && !var20.field_163) {
                                                                var16 = null;
                                                                var17 = true;
                                                            }
                                                            if (var16 == null) {
                                                                class_326 var10000 = new class_326(3);
                                                                var16 = var10000;
                                                            }
                                                            var16.method_3231(var23);
                                                        }
                                                    } else if (var8 == null) {
                                                        var35 = new class_61(var23, var1, var23.field_276, 2);
                                                        var8 = var35;
                                                    }
                                                } else if (var8 == null) {
                                                    var8 = var23;
                                                }
                                            } else if (var8 == null) {
                                                var35 = new class_61(var22, var1, var2, 1);
                                                var8 = var35;
                                            }
                                        }
                                    }
                                }
                            }
                            if (var16 != null) {
                                class_58[] var31 = new class_58[var16.field_1849];
                                var16.method_3235(var31);
                                var7 = this.method_639(var31, var31.length, var2, var3, (class_43)null);
                            }
                        }
                    }
                    if (var7 != null) {
                        var3.method_4(var7.field_278);
                        return var7;
                    }
                    if (var8 != null) {
                        return (class_58)var8;
                    }
                    var35 = new class_61(var1, var2, 1);
                    return var35;
            }
            var10 = var10.field_374;
        }
    }

    // $FF: renamed from: b () m.as
    public final class_43 method_603() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_108);
        return var1.field_378.method_506(class_17.field_108, this);
    }

    // $FF: renamed from: c () m.as
    public final class_43 method_604() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_88);
        return var1.field_378.method_506(class_17.field_88, this);
    }

    // $FF: renamed from: d () m.as
    public final class_43 method_605() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_89);
        return var1.field_378.method_506(class_17.field_89, this);
    }

    // $FF: renamed from: e () m.as
    public final class_43 method_606() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_90);
        return var1.field_378.method_506(class_17.field_90, this);
    }

    // $FF: renamed from: f () m.as
    public final class_43 method_607() {
        class_85 var1 = this.method_576();
        var1.method_687(field_375);
        return var1.field_378.method_506(field_375, this);
    }

    // $FF: renamed from: g () m.as
    public final class_43 method_608() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_93);
        return var1.field_378.method_506(class_17.field_93, this);
    }

    // $FF: renamed from: h () m.as
    public final class_43 method_609() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_99);
        return var1.field_378.method_506(class_17.field_99, this);
    }

    // $FF: renamed from: i () m.as
    public final class_43 method_610() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_100);
        return var1.field_378.method_506(class_17.field_100, this);
    }

    // $FF: renamed from: j () m.as
    public final class_43 method_611() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_105);
        return var1.field_378.method_506(class_17.field_105, this);
    }

    // $FF: renamed from: k () m.as
    public final class_43 method_612() {
        class_85 var1 = this.method_576();
        var1.method_687(class_17.field_118);
        return var1.field_378.method_506(class_17.field_118, this);
    }

    // $FF: renamed from: c (char[], m.as) m.as
    public final class_43 method_613(char[] var1, class_43 var2) {
        class_43 var3 = this.method_591(var1, var2);
        if (var3 != null) {
            return var3;
        } else {
            char[][] var4 = new char[][] {var1};
            class_51 var10000 = new class_51(var4, (class_43)null, 1);
            return var10000;
        }
    }

    // $FF: renamed from: a (m.s, char[], m.s[], m.ad) m.ae
    public class_58 method_614(class_40 var1, char[] var2, class_40[] var3, class_0 var4) throws Throwable {
        class_85 var5 = this.method_576();
        class_80 var6 = var5.field_378;
        class_61 var7;
        label86: {
            class_58 var13;
            label85: {
                class_61 var15;
                label84: {
                    class_58 var9;
                    label83: {
                        class_61 var17;
                        label82: {
                            label81: {
                                class_62 var16;
                                label80: {
                                    try {
                                        try {
                                            var6.field_363 = var4;
                                            class_61 var10000;
                                            switch (var1.method_98()) {
                                                case 68:
                                                    var5.method_693(var1);
                                                    var13 = this.method_594((class_42)var1, var2, var3, var4);
                                                    break label85;
                                                case 132:
                                                    var10000 = new class_61(var2, var3, 1);
                                                    var7 = var10000;
                                                    break label86;
                                            }
                                            var5.method_693(var1);
                                            class_43 var14 = (class_43)var1;
                                            if (!var14.method_196(this)) {
                                                var10000 = new class_61(var2, var3, 8);
                                                var15 = var10000;
                                                break label84;
                                            }
                                            class_58 var8 = this.method_589(var14, var2, var3, var4);
                                            if (var8 != null) {
                                                var9 = var8;
                                                break label83;
                                            }
                                            var8 = this.method_592(var14, var2, var3, var4);
                                            if (var8 == null) {
                                                var10000 = new class_61(var2, var3, 1);
                                                var17 = var10000;
                                                break label82;
                                            }
                                            if (!var8.method_101()) {
                                                var9 = var8;
                                                break label81;
                                            }
                                            if (var1.field_177 != 1 && var3 == class_34.field_150 && class_233.method_1364(var2, class_17.field_34) && var8.field_275.method_162()) {
                                                var16 = class_62.method_399(var1, var8, this);
                                                break label80;
                                            }
                                            var9 = var8;
                                        } catch (class_241 var11) {
                                            var11.method_1437(var4, this.method_645().field_455);
                                            throw var11;
                                        }
                                    } catch (Throwable var12) {
                                        var6.field_363 = null;
                                        throw var12;
                                    }
                                    var6.field_363 = null;
                                    return var9;
                                }
                                var6.field_363 = null;
                                return var16;
                            }
                            var6.field_363 = null;
                            return var9;
                        }
                        var6.field_363 = null;
                        return var17;
                    }
                    var6.field_363 = null;
                    return var9;
                }
                var6.field_363 = null;
                return var15;
            }
            var6.field_363 = null;
            return var13;
        }
        var6.field_363 = null;
        return var7;
    }

    // $FF: renamed from: a (char[][]) m.w
    public final class_34 method_615(char[][] var1) {
        this.method_576().method_687(var1);
        class_34 var2 = this.method_619(var1[0], 20, true);
        char[][] var6;
        class_51 var10000;
        if (var2 == null) {
            var6 = new char[][] {var1[0]};
            var10000 = new class_51(var6, this.method_586().method_496((class_38)null, var1), 1);
            return var10000;
        } else if (!var2.method_101()) {
            if (var2 instanceof class_38) {
                var6 = new char[][] {var1[0]};
                var10000 = new class_51(var6, (class_43)null, 1);
                return var10000;
            } else {
                return var2;
            }
        } else if (!(var2 instanceof class_38)) {
            return null;
        } else {
            int var3 = 1;
            int var4 = var1.length;
            for (class_38 var5 = (class_38)var2; var3 < var4; var5 = (class_38)var2) {
                var2 = var5.method_125(var1[var3++]);
                if (var2 == null) {
                    var10000 = new class_51(class_233.method_1387(var1, 0, var3), (class_43)null, 1);
                    return var10000;
                }
                if (!var2.method_101()) {
                    var10000 = new class_51(class_233.method_1387(var1, 0, var3), var2 instanceof class_43 ? (class_43)((class_43)var2).method_131() : null, var2.method_102());
                    return var10000;
                }
                if (!(var2 instanceof class_38)) {
                    return var5;
                }
            }
            var10000 = new class_51(var1, (class_43)null, 1);
            return var10000;
        }
    }

    // $FF: renamed from: b (char[]) m.s
    public final class_40 method_616(char[] var1) {
        class_40 var2 = method_567(var1);
        return (class_40)(var2 != null ? var2 : (class_43)this.method_619(var1, 4, true));
    }

    // $FF: renamed from: a (char[], m.ar) m.s
    public final class_40 method_617(char[] var1, class_38 var2) {
        if (var2 == null) {
            return this.method_616(var1);
        } else {
            class_34 var3 = var2.method_125(var1);
            class_51 var10000;
            if (var3 == null) {
                var10000 = new class_51(class_233.method_1353(var2.field_171, var1), (class_43)null, 1);
                return var10000;
            } else if (!var3.method_101()) {
                var10000 = new class_51(var3 instanceof class_43 ? ((class_43)var3).field_197 : class_233.method_1353(var2.field_171, var1), var3 instanceof class_43 ? (class_43)((class_43)var3).method_131() : null, var3.method_102());
                return var10000;
            } else {
                class_43 var4 = (class_43)var3;
                if (!var4.method_196(this)) {
                    var10000 = new class_51(var4.field_197, var4, 2);
                    return var10000;
                } else {
                    return var4;
                }
            }
        }
    }

    // $FF: renamed from: a (char[][], int) m.s
    public final class_40 method_618(char[][] var1, int var2) {
        if (var2 == 1) {
            class_40 var3 = method_567(var1[0]);
            if (var3 != null) {
                return var3;
            }
        }
        class_85 var9 = this.method_576();
        var9.method_687(var1);
        class_34 var4 = this.method_619(var1[0], var2 == 1 ? 4 : 20, true);
        class_51 var10000;
        if (var4 == null) {
            char[][] var10 = new char[][] {var1[0]};
            var10000 = new class_51(var10, this.method_586().method_496(this.method_576().method_600(), var10), 1);
            return var10000;
        } else if (!var4.method_101()) {
            return (class_43)var4;
        } else {
            int var5 = 1;
            boolean var6 = false;
            if (var4 instanceof class_38) {
                char[][] var8;
                for (class_38 var7 = (class_38)var4; var5 < var2; var7 = (class_38)var4) {
                    var4 = var7.method_125(var1[var5++]);
                    if (var4 == null) {
                        var8 = class_233.method_1387(var1, 0, var5);
                        var10000 = new class_51(var8, this.method_586().method_496(var7, var8), 1);
                        return var10000;
                    }
                    if (!var4.method_101()) {
                        var10000 = new class_51(class_233.method_1387(var1, 0, var5), var4 instanceof class_43 ? (class_43)((class_43)var4).method_131() : null, var4.method_102());
                        return var10000;
                    }
                    if (!(var4 instanceof class_38)) {
                        break;
                    }
                }
                if (var4 instanceof class_38) {
                    var8 = class_233.method_1387(var1, 0, var5);
                    var10000 = new class_51(var8, this.method_586().method_496((class_38)null, var8), 1);
                    return var10000;
                }
                var6 = true;
            }
            class_43 var11 = (class_43)var4;
            var9.method_693(var11);
            if (var6 && !var11.method_196(this)) {
                var10000 = new class_51(class_233.method_1387(var1, 0, var5), var11, 2);
                return var10000;
            } else {
                do {
                    if (var5 >= var2) {
                        return var11;
                    }
                    var11 = this.method_613(var1[var5++], var11);
                } while (var11.method_101());
                if (var11 instanceof class_51) {
                    class_51 var12 = (class_51)var11;
                    var10000 = new class_51(class_233.method_1387(var1, 0, var5), var12.method_281(), var11.method_102());
                    return var10000;
                } else {
                    var10000 = new class_51(class_233.method_1387(var1, 0, var5), (class_43)((class_43)var4).method_131(), var11.method_102());
                    return var10000;
                }
            }
        }
    }

    // $FF: renamed from: a (char[], int, boolean) m.w
    final class_34 method_619(char[] var1, int var2, boolean var3) {
        class_83 var4 = this;
        Object var5 = null;
        boolean var6 = false;
        boolean var7 = false;
        int var12;
        class_43 var35;
        class_51 var10000;
        if ((var2 & 4) == 0) {
            while (true) {
                class_83 var8 = var4.field_374;
                if (var4.field_374 == null) {
                    break;
                }
                var4 = var8;
            }
        } else {
            boolean var22 = this.method_577().field_1927 >= 3145728L;
            label340:
            while (true) {
                switch (var4.field_373) {
                    case 2:
                        class_87 var23 = (class_87)var4;
                        class_93 var36 = var23.method_730();
                        if (var36 != null) {
                            if (var36.field_488 != null) {
                                class_46 var37 = var36.field_488.method_353(var1);
                                if (var37 != null) {
                                    return var37;
                                }
                            } else {
                                class_123[] var33 = var36.method_807();
                                var12 = var33 == null ? 0 : var33.length;
                                while (true) {
                                    --var12;
                                    if (var12 < 0) {
                                        break;
                                    }
                                    if (class_233.method_1364(var33[var12].field_659, var1) && var33[var12].field_668 != null && var33[var12].field_668.method_101()) {
                                        return var33[var12].field_668;
                                    }
                                }
                            }
                        }
                        var6 |= var23.field_404;
                        var7 = var23.field_412;
                    case 1:
                        class_43 var34 = ((class_86)var4).method_711(var1);
                        if (var34 != null) {
                            if (var5 != null && var5 != var34) {
                                var10000 = new class_51(new char[][] {var1}, (class_43)var5, 5);
                                return var10000;
                            }
                            return var34;
                        }
                        break;
                    case 3:
                        class_54 var29 = ((class_84)var4).field_376.field_586;
                        class_46 var40;
                        if (var4 == this && (var29.field_178 & 262144L) == 0L) {
                            var40 = var29.method_211(var1);
                            if (var40 != null) {
                                return var40;
                            }
                            if (class_233.method_1364(var1, var29.field_198)) {
                                return var29;
                            }
                            var6 |= var29.method_226();
                        } else {
                            if (!var7) {
                                var35 = this.method_591(var1, var29);
                                if (var35 != null) {
                                    if (var35.method_102() == 3) {
                                        if (var5 != null && ((class_43)var5).method_102() != 2) {
                                            var10000 = new class_51(new char[][] {var1}, (class_43)var5, 5);
                                            return var10000;
                                        }
                                        return var35;
                                    }
                                    if (var35.method_101() && (var29 == var35.method_137() || var22)) {
                                        if (var6 && !var35.method_226() && var29.method_155()) {
                                            var10000 = new class_51(new char[][] {var1}, var35, 7);
                                            return var10000;
                                        }
                                        if (var5 == null || var22 && ((class_43)var5).method_102() == 2) {
                                            return var35;
                                        }
                                        if (((class_43)var5).method_101() && var5 != var35) {
                                            var10000 = new class_51(new char[][] {var1}, (class_43)var5, 5);
                                            return var10000;
                                        }
                                    }
                                    if (var5 == null || ((class_43)var5).method_102() == 2 && var35.method_102() != 2) {
                                        var5 = var35;
                                    }
                                }
                            }
                            var40 = var29.method_211(var1);
                            if (var40 != null) {
                                if (var6) {
                                    var10000 = new class_51(new char[][] {var1}, var40, 7);
                                    return var10000;
                                }
                                return var40;
                            }
                            var6 |= var29.method_226();
                            var7 = false;
                            if (class_233.method_1364(var29.field_198, var1)) {
                                if (var5 != null && var5 != var29 && ((class_43)var5).method_102() != 2) {
                                    var10000 = new class_51(new char[][] {var1}, (class_43)var5, 5);
                                    return var10000;
                                }
                                return var29;
                            }
                        }
                        break;
                    case 4:
                        if (var5 != null && ((class_43)var5).method_102() != 2) {
                            return (class_34)var5;
                        }
                        break label340;
                }
                var4 = var4.field_374;
            }
        }
        class_85 var21 = (class_85)var4;
        class_325 var9 = var21.field_383;
        if (var9 != null) {
            Object var10 = (class_34)var9.method_3226(var1);
            if (var10 != null) {
                if (var10 instanceof class_35) {
                    class_91 var11 = ((class_35)var10).field_164;
                    if (var11 != null) {
                        var11.field_446 |= 2;
                    }
                    if (var10 instanceof class_36) {
                        var9.method_3227(var1, var10 = ((class_36)var10).field_166);
                    } else {
                        var9.method_3227(var1, var10 = ((class_35)var10).field_165);
                    }
                }
                if ((var2 & 4) != 0) {
                    if (var5 != null && ((class_43)var5).method_102() != 2 && ((class_34)var10).method_102() != 3) {
                        return (class_34)var5;
                    }
                    if (var10 instanceof class_43) {
                        return (class_34)var10;
                    }
                }
                if ((var2 & 16) != 0 && var10 instanceof class_38) {
                    return (class_34)var10;
                }
            }
        }
        if ((var2 & 4) != 0) {
            class_35[] var31 = var21.field_382;
            if (var31 != null && var9 == null) {
                int var24 = 0;
                for (var12 = var31.length; var24 < var12; ++var24) {
                    class_35 var13 = var31[var24];
                    if (!var13.field_163 && class_233.method_1364(var13.field_162[var13.field_162.length - 1], var1)) {
                        Object var14 = var21.method_695(var13);
                        if (var14 != null) {
                            if (var14 instanceof class_58) {
                                var14 = this.method_618(var13.field_162, var13.field_162.length);
                                if (!((class_34)var14).method_101()) {
                                    continue;
                                }
                            }
                            if (var14 instanceof class_40) {
                                class_91 var15 = var13.field_164;
                                if (var15 != null) {
                                    var15.field_446 |= 2;
                                }
                                return (class_34)var14;
                            }
                        }
                    }
                }
            }
            class_38 var30 = var21.field_381;
            var21.method_688(var30.field_171, var1);
            class_34 var27 = var30.method_125(var1);
            if (var27 instanceof class_43) {
                var35 = (class_43)var27;
                if ((var35.field_178 & 128L) == 0L) {
                    if (var9 != null) {
                        var9.method_3227(var1, var35);
                    }
                    return var35;
                }
            }
            if (var31 != null) {
                boolean var32 = false;
                class_43 var38 = null;
                int var39 = 0;
                for (int var16 = var31.length; var39 < var16; ++var39) {
                    class_35 var17 = var31[var39];
                    if (var17.field_163) {
                        class_34 var18 = var17.field_165;
                        class_43 var19 = null;
                        if (var18 instanceof class_38) {
                            var19 = this.method_596(var1, (class_38)var18, var30);
                        } else if (var17.method_106()) {
                            var19 = this.method_591(var1, (class_43)var18);
                            if (var19 != null && !var19.method_226()) {
                                var19 = null;
                            }
                        } else {
                            var19 = this.method_588(var1, (class_43)var18);
                        }
                        if (var19 != var38 && var19 != null) {
                            if (var19.method_101()) {
                                class_91 var20 = var17.field_164;
                                if (var20 != null) {
                                    var20.field_446 |= 2;
                                }
                                if (var32) {
                                    var10000 = new class_51(new char[][] {var1}, var38, 3);
                                    class_51 var41 = var10000;
                                    if (var9 != null) {
                                        var9.method_3227(var1, var41);
                                    }
                                    return var41;
                                }
                                var38 = var19;
                                var32 = true;
                            } else if (var5 == null) {
                                var5 = var19;
                            }
                        }
                    }
                }
                if (var38 != null) {
                    if (var9 != null) {
                        var9.method_3227(var1, var38);
                    }
                    return var38;
                }
            }
        }
        var21.method_690(var1);
        if ((var2 & 16) != 0) {
            class_38 var26 = var21.field_378.method_507(var1);
            if (var26 != null) {
                if (var9 != null) {
                    var9.method_3227(var1, var26);
                }
                return var26;
            }
        }
        char[][] var28;
        if (var5 == null) {
            var28 = new char[][] {var1};
            class_50 var25 = null;
            if (((var2 & 16) != 0 || var21.field_378.method_507(var1) == null) && var3) {
                var25 = this.method_586().method_496(var21.field_381, var28);
            }
            var10000 = new class_51(var28, var25, 1);
            var5 = var10000;
            if (var9 != null && (var2 & 16) != 0) {
                var9.method_3227(var1, var5);
            }
        } else if ((((class_43)var5).field_178 & 128L) != 0L) {
            var28 = new char[][] {var1};
            var10000 = new class_51(var28, (class_43)var5, 1);
            var5 = var10000;
            if (var9 != null && (var2 & 16) != 0) {
                var9.method_3227(var1, var5);
            }
        }
        return (class_34)var5;
    }

    // $FF: renamed from: b (char[][]) m.w
    public final class_34 method_620(char[][] var1) {
        int var2 = var1.length;
        if (var2 == 1) {
            class_40 var3 = method_567(var1[0]);
            if (var3 != null) {
                return var3;
            }
        }
        class_34 var8 = this.method_619(var1[0], 20, true);
        if (!var8.method_101()) {
            return var8;
        } else {
            int var4 = 1;
            boolean var5 = false;
            class_51 var10000;
            if (var8 instanceof class_38) {
                for (class_38 var6 = (class_38)var8; var4 < var2; var6 = (class_38)var8) {
                    var8 = var6.method_125(var1[var4++]);
                    if (var8 == null) {
                        var10000 = new class_51(class_233.method_1387(var1, 0, var4), (class_43)null, 1);
                        return var10000;
                    }
                    if (!var8.method_101()) {
                        var10000 = new class_51(class_233.method_1387(var1, 0, var4), var8 instanceof class_43 ? (class_43)((class_43)var8).method_131() : null, var8.method_102());
                        return var10000;
                    }
                    if (!(var8 instanceof class_38)) {
                        break;
                    }
                }
                if (var8 instanceof class_38) {
                    return var8;
                }
                var5 = true;
            }
            class_43 var9 = (class_43)var8;
            Object var7 = (class_43)this.method_586().method_490(var9, false);
            if (var5 && !var9.method_196(this)) {
                var10000 = new class_51(class_233.method_1387(var1, 0, var4), var9, 2);
                return var10000;
            } else {
                while (var4 < var2) {
                    var9 = this.method_613(var1[var4++], var9);
                    if (!var9.method_101()) {
                        var10000 = new class_51(class_233.method_1387(var1, 0, var4), (class_43)var9.method_131(), var9.method_102());
                        return var10000;
                    }
                    if (var9.method_155()) {
                        var7 = this.method_586().method_501(var9, (class_43)var7);
                    } else {
                        var7 = var7 != null && (((class_43)var7).method_166() || ((class_43)var7).method_162()) ? this.method_586().method_500(var9, (class_40[])null, (class_43)var7) : var9;
                    }
                }
                return (class_34)var7;
            }
        }
    }

    // $FF: renamed from: a (m.s, m.s, g.m, m.as, h.cj) boolean
    protected boolean method_621(class_40 var1, class_40 var2, class_14 var3, class_43 var4, class_89 var5) {
        var3.method_41();
        class_40[] var6 = this.method_636(new class_40[] {var1, var2}, var3);
        if (var6 != null) {
            int var7 = 0;
            for (int var8 = var6.length; var7 < var8; ++var7) {
                class_40 var9 = var6[var7];
                if (var9 != null) {
                    Object var10 = var3.method_38(var9);
                    if (var10 instanceof class_40[]) {
                        class_40[] var11 = (class_40[])((class_40[])var10);
                        this.method_644().method_1764(var11[0].method_138(), var5, var11[0], var11[1]);
                        var4.field_178 |= 131072L;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // $FF: renamed from: a () h.bu
    public class_108 method_622() {
        class_83 var1 = this;
        while (!(var1 instanceof class_86)) {
            var1 = var1.field_374;
            if (var1 == null) {
                return null;
            }
        }
        return ((class_86)var1).field_399;
    }

    // $FF: renamed from: a (m.ae, m.ae) boolean
    protected boolean method_623(class_58 var1, class_58 var2) {
        class_40[] var3 = var1.field_276;
        class_40[] var4 = var2.field_276;
        int var5 = var3.length;
        int var6 = var4.length;
        int var7;
        if (var5 == var6) {
            for (var7 = 0; var7 < var5; ++var7) {
                class_40 var8 = var3[var7];
                class_40 var9 = var4[var7];
                if (var8 == var9) {
                    if (var9.method_173().method_166() && var8 == var1.method_376().field_276[var7] && var9.method_173().method_138() != var2.method_376().field_276[var7].method_173().method_138()) {
                        return false;
                    }
                } else {
                    if (!var8.method_152(var9)) {
                        if (var7 == var5 - 1 && var1.method_374() && var2.method_374()) {
                            class_40 var10 = ((class_42)var9).method_187();
                            if (var8 == var10 || var8.method_152(var10)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    if (var8.method_173().method_166() && var8.method_174(var2.field_278.method_166() ? var9 : var2.method_376().field_276[var7])) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            if (var1.method_374() && var2.method_374()) {
                if (var5 > var6 && ((class_42)var4[var6 - 1]).method_187().field_177 != 1) {
                    return false;
                }
                for (var7 = (var5 > var6 ? var6 : var5) - 2; var7 >= 0; --var7) {
                    if (var3[var7] != var4[var7] && !var3[var7].method_152(var4[var7])) {
                        return false;
                    }
                }
                if (this.method_642(var1, var4) == -1 && this.method_642(var2, var3) == 2) {
                    return true;
                }
            }
            return false;
        }
    }

    // $FF: renamed from: a (m.s, m.s) boolean
    public boolean method_624(class_40 var1, class_40 var2) {
        class_80 var3 = this.method_586();
        if (var3.field_352.field_1928 >= 3211264L && var1.method_148() != var2.method_148()) {
            class_40 var4 = var3.method_486(var1);
            return var4 == var2 || var4.method_152(var2);
        } else {
            return false;
        }
    }

    // $FF: renamed from: c (m.k) boolean
    public final boolean method_625(class_67 var1) {
        class_83 var2 = this;
        do {
            if (var2 instanceof class_87) {
                class_87 var3 = (class_87)var2;
                if (var3.field_406 == var1) {
                    return true;
                }
            }
            var2 = var2.field_374;
        } while (var2 != null);
        return false;
    }

    // $FF: renamed from: a (m.ae) boolean
    public final boolean method_626(class_58 var1) {
        class_83 var2 = this;
        do {
            if (var2 instanceof class_87) {
                class_33 var3 = ((class_87)var2).field_403;
                if (var3 instanceof class_93 && ((class_93)var3).field_488 == var1) {
                    return true;
                }
            }
            var2 = var2.field_374;
        } while (var2 != null);
        return false;
    }

    // $FF: renamed from: a (m.as) boolean
    public final boolean method_627(class_43 var1) {
        class_43 var2;
        for (var2 = var1; (var1 = var2.method_137()) != null; var2 = var1) {
            ;
        }
        class_83 var4 = this;
        while (true) {
            class_83 var3 = var4.field_374;
            if (var4.field_374 == null) {
                class_54[] var5 = ((class_85)var4).field_384;
                int var6 = var5.length;
                do {
                    --var6;
                    if (var6 < 0) {
                        return false;
                    }
                } while (var5[var6] != var2);
                return true;
            }
            var4 = var3;
        }
    }

    // $FF: renamed from: b (m.as) boolean
    public final boolean method_628(class_43 var1) {
        class_83 var2 = this;
        do {
            if (var2 instanceof class_84 && ((class_84)var2).field_376.field_586 == var1) {
                return true;
            }
            var2 = var2.field_374;
        } while (var2 != null);
        return false;
    }

    // $FF: renamed from: a (h.bu) boolean
    public boolean method_629(class_108 var1) {
        class_83 var2 = this;
        do {
            switch (var2.field_373) {
                case 1:
                    if (((class_86)var2).field_399 == var1) {
                        return true;
                    }
            }
            var2 = var2.field_374;
        } while (var2 != null);
        return false;
    }

    // $FF: renamed from: d () boolean
    public boolean method_630() {
        class_54 var2;
        switch (this.field_373) {
            case 1:
            case 2:
                class_87 var1 = this.method_635();
                if (!var1.method_727()) {
                    class_58 var5 = ((class_93)var1.field_403).field_488;
                    if (var5 != null && var5.method_375()) {
                        return true;
                    }
                } else {
                    var2 = ((class_86)this).method_718().field_586;
                    if (var1.field_406 != null && var1.field_406.method_434()) {
                        return true;
                    }
                    if (var2 != null) {
                        var2.method_100();
                        if (var2.method_230()) {
                            return true;
                        }
                    }
                }
                break;
            case 3:
                var2 = ((class_84)this).method_671().field_586;
                if (var2 != null) {
                    var2.method_100();
                    if (var2.method_230()) {
                        return true;
                    }
                }
                break;
            case 4:
                class_90 var3 = this.method_645();
                if (var3.field_450 != null && var3.field_450.length > 0) {
                    class_54 var4 = var3.field_450[0].field_586;
                    if (var4 != null) {
                        var4.method_100();
                        if (var4.method_230()) {
                            return true;
                        }
                    }
                }
        }
        return false;
    }

    // $FF: renamed from: a (m.s, java.lang.Object, g.l) m.s
    private class_40 method_631(class_40 var1, Object var2, class_13 var3) {
        if (var2 == null) {
            return var1;
        } else if (var2 instanceof class_40) {
            return (class_40)var2;
        } else {
            class_40[] var4 = (class_40[])((class_40[])var2);
            int var5 = var1.method_136();
            var1 = var1.method_173();
            int var6 = var1.method_181().length;
            if (var6 == 0) {
                return var1;
            } else {
                class_40[] var7 = new class_40[var6];
                int var8 = 0;
                label67:
                for (int var9 = var4.length; var8 < var9; ++var8) {
                    class_40 var10 = var4[var8].method_173();
                    switch (var10.method_98()) {
                        case 260:
                            class_52 var16 = (class_52)var10;
                            int var17 = 0;
                            while (true) {
                                if (var17 >= var6) {
                                    continue label67;
                                }
                                class_40 var14 = this.method_632(var7[var17], var16.field_243[var17], (class_43)var1, var17, var3);
                                if (var14 == null) {
                                    return null;
                                }
                                var7[var17] = var14;
                                ++var17;
                            }
                        case 1028:
                            return (class_40)(var5 == 0 ? var10 : this.method_586().method_493(var10, var5));
                        case 2052:
                            class_46[] var11 = var10.method_181();
                            for (int var12 = 0; var12 < var6; ++var12) {
                                class_40 var13 = this.method_632(var7[var12], var11[var12], (class_43)var1, var12, var3);
                                if (var13 == null) {
                                    return null;
                                }
                                var7[var12] = var13;
                            }
                    }
                }
                class_52 var15 = this.method_586().method_500((class_43)var1.method_138(), var7, var1.method_137());
                if (var5 == 0) {
                    return var15;
                }
                return this.method_586().method_493(var15, var5);
            }
        }
    }

    // $FF: renamed from: a (m.s, m.s, m.as, int, g.l) m.s
    private class_40 method_632(class_40 var1, class_40 var2, class_43 var3, int var4, class_13 var5) {
        if (var1 == null) {
            return var2;
        } else if (var1 == var2) {
            return var1;
        } else {
            class_45 var6;
            class_40[] var8;
            class_40 var10;
            if (var2.method_172()) {
                var6 = (class_45)var2;
                if (var1.method_172()) {
                    class_45 var7 = (class_45)var1;
                    label86:
                    switch (var7.field_215) {
                        case 1:
                            switch (var6.field_215) {
                                case 1:
                                    class_40 var11 = this.method_634(new class_40[] {var7.field_212, var6.field_212}, var5);
                                    if (var11 == null) {
                                        return null;
                                    }
                                    if (var11 == class_40.field_179) {
                                        return this.method_586().method_502(var3, var4, (class_40)null, (class_40[])null, 0);
                                    }
                                    return this.method_586().method_502(var3, var4, var11, (class_40[])null, 1);
                                case 2:
                                    if (var7.field_212 == var6.field_212) {
                                        return var7.field_212;
                                    }
                                    return this.method_586().method_502(var3, var4, (class_40)null, (class_40[])null, 0);
                                default:
                                    break label86;
                            }
                        case 2:
                            if (var7.field_215 == 2) {
                                var8 = method_569(new class_40[] {var7.field_212, var6.field_212});
                                if (var8 == null) {
                                    return null;
                                }
                                return this.method_586().method_502(var3, var4, var8[0], (class_40[])null, 2);
                            }
                    }
                } else {
                    switch (var6.field_215) {
                        case 0:
                        default:
                            break;
                        case 1:
                            var10 = this.method_634(new class_40[] {var1, var6.field_212}, var5);
                            if (var10 == null) {
                                return null;
                            }
                            if (var10 == class_40.field_179) {
                                return this.method_586().method_502(var3, var4, (class_40)null, (class_40[])null, 0);
                            }
                            return this.method_586().method_502(var3, var4, var10, (class_40[])null, 1);
                        case 2:
                            var8 = method_569(new class_40[] {var1, var6.field_212});
                            if (var8 == null) {
                                return null;
                            }
                            return this.method_586().method_502(var3, var4, var8[0], (class_40[])null, 2);
                    }
                }
            } else if (var1.method_172()) {
                var6 = (class_45)var1;
                switch (var6.field_215) {
                    case 0:
                    default:
                        break;
                    case 1:
                        var10 = this.method_634(new class_40[] {var6.field_212, var2}, var5);
                        if (var10 == null) {
                            return null;
                        }
                        if (var10 == class_40.field_179) {
                            return this.method_586().method_502(var3, var4, (class_40)null, (class_40[])null, 0);
                        }
                        return this.method_586().method_502(var3, var4, var10, (class_40[])null, 1);
                    case 2:
                        var8 = method_569(new class_40[] {var6.field_212, var2});
                        if (var8 == null) {
                            return null;
                        }
                        return this.method_586().method_502(var3, var4, var8[0], (class_40[])null, 2);
                }
            }
            class_40 var9 = this.method_634(new class_40[] {var1, var2}, var5);
            return var9 == null ? null : (var9 == class_40.field_179 ? this.method_586().method_502(var3, var4, (class_40)null, (class_40[])null, 0) : this.method_586().method_502(var3, var4, var9, (class_40[])null, 1));
        }
    }

    // $FF: renamed from: a (m.s[]) m.s
    public class_40 method_633(class_40[] var1) {
        int var2 = var1.length;
        if (var2 == 1) {
            class_40 var3 = var1[0];
            return (class_40)(var3 == null ? class_40.field_188 : var3);
        } else {
            class_313 var10002 = new class_313(1);
            return this.method_634(var1, var10002);
        }
    }

    // $FF: renamed from: a (m.s[], g.l) m.s
    private class_40 method_634(class_40[] var1, class_13 var2) {
        int var3 = var1.length;
        if (var3 == 1) {
            class_40 var15 = var1[0];
            return (class_40)(var15 == null ? class_40.field_188 : var15);
        } else {
            int var4 = var2.method_29();
            class_40[] var6;
            int var7;
            int var8;
            class_40 var9;
            int var10;
            label134:
            for (int var5 = 0; var5 < var4; ++var5) {
                var6 = (class_40[])((class_40[])var2.method_36(var5));
                var7 = var6.length;
                if (var7 >= var3) {
                    for (var8 = 0; var8 < var3; ++var8) {
                        var9 = var1[var8];
                        if (var9 != null) {
                            var10 = 0;
                            while (true) {
                                if (var10 >= var7) {
                                    continue label134;
                                }
                                class_40 var11 = var6[var10];
                                if (var11 != null && (var11 == var9 || var11.method_154(var9))) {
                                    break;
                                }
                                ++var10;
                            }
                        }
                    }
                    return class_40.field_179;
                }
            }
            var2.method_34(var1);
            class_312 var10000 = new class_312(1);
            class_312 var16 = var10000;
            var6 = this.method_636(var1, var16);
            if (var6 == null) {
                return null;
            } else {
                var7 = var6.length;
                if (var7 == 0) {
                    return class_40.field_188;
                } else {
                    var8 = 0;
                    var9 = null;
                    var10 = -1;
                    int var13;
                    for (int var17 = 0; var17 < var7; ++var17) {
                        class_40 var12 = var6[var17];
                        if (var12 != null) {
                            var12 = this.method_631(var12, var16.method_38(var12), var2);
                            if (var12 == null) {
                                return null;
                            }
                            var13 = var12.method_136();
                            if (var10 == -1) {
                                var10 = var13;
                            } else if (var13 != var10) {
                                return null;
                            }
                            if (var9 == null && !var12.method_173().method_157()) {
                                var9 = var12.method_173();
                            }
                            var6[var8++] = var12;
                        }
                    }
                    switch (var8) {
                        case 0:
                            return class_40.field_188;
                        case 1:
                            return var6[0];
                        case 2:
                            if ((var10 == 0 ? var6[1].field_177 : var6[1].method_173().field_177) == 1) {
                                return var6[0];
                            } else if ((var10 == 0 ? var6[0].field_177 : var6[0].method_173().field_177) == 1) {
                                return var6[1];
                            }
                        default:
                            class_40[] var19 = new class_40[var8 - 1];
                            int var18 = 0;
                            for (var13 = 0; var13 < var8; ++var13) {
                                class_40 var14 = var10 == 0 ? var6[var13] : var6[var13].method_173();
                                if (var14.method_157()) {
                                    var19[var18++] = var14;
                                }
                            }
                            class_45 var20 = this.method_586().method_502((class_43)null, 0, var9, var19, 1);
                            if (var10 == 0) {
                                return var20;
                            }
                            return this.method_586().method_493(var20, var10);
                    }
                }
            }
        }
    }

    // $FF: renamed from: b () m.aj
    public final class_87 method_635() {
        class_83 var1 = this;
        while (!(var1 instanceof class_87)) {
            var1 = var1.field_374;
            if (var1 == null) {
                return null;
            }
        }
        return (class_87)var1;
    }

    // $FF: renamed from: a (m.s[], g.m) m.s[]
    protected class_40[] method_636(class_40[] var1, class_14 var2) {
        int var3 = var1.length;
        int var4 = -1;
        int var5 = 0;
        for (int var6 = 0; var6 < var3; ++var6) {
            class_40 var7 = var1[var6];
            if (var7 != null) {
                if (var7.method_148()) {
                    return null;
                }
                if (var4 < 0) {
                    var4 = var6;
                }
                ++var5;
            }
        }
        switch (var5) {
            case 0:
                return class_34.field_149;
            case 1:
                return var1;
            default:
                class_40 var26 = var1[var4];
                if (var26.method_148()) {
                    return null;
                } else {
                    class_313 var10000 = new class_313(5);
                    class_313 var27 = var10000;
                    int var8 = var26.method_136();
                    class_40 var9 = var26.method_173();
                    class_40 var10;
                    switch (var9.method_98()) {
                        case 68:
                        case 260:
                        case 1028:
                            var10 = var26.method_138();
                            break;
                        default:
                            var10 = var26;
                    }
                    if (var10 != var26) {
                        var2.method_39(var10, var26);
                    }
                    var27.method_34(var26);
                    int var11 = 1;
                    int var13 = 0;
                    int var17;
                    int var16;
                    for (; var13 < var11; ++var13) {
                        class_40 var14 = (class_40)var27.method_36(var13);
                        var8 = var14.method_136();
                        class_40 var31;
                        if (var8 > 0) {
                            var9 = var14.method_173();
                            switch (var9.field_177) {
                                case 1:
                                    if (var8 > 1) {
                                        var31 = ((class_42)var14).method_187();
                                        if (!var27.method_30(var31)) {
                                            var27.method_34(var31);
                                            ++var11;
                                        }
                                        continue;
                                    }
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                    class_43 var15 = this.method_603();
                                    if (!var27.method_30(var15)) {
                                        var27.method_34(var15);
                                        ++var11;
                                    }
                                    var15 = this.method_607();
                                    if (!var27.method_30(var15)) {
                                        var27.method_34(var15);
                                        ++var11;
                                    }
                                    var15 = this.method_609();
                                    if (!var27.method_30(var15)) {
                                        var27.method_34(var15);
                                        ++var11;
                                    }
                                    continue;
                                case 6:
                                default:
                                    var14 = var9;
                            }
                        }
                        class_43 var12 = (class_43)var14;
                        Object var33;
                        if (var12.method_150()) {
                            var31 = ((class_47)var12).field_222;
                            if (var31 != null && var31.method_147()) {
                                Object var35 = var8 == 0 ? var31 : this.method_586().method_493(var31, var8);
                                if (!var27.method_30(var35)) {
                                    var27.method_34(var35);
                                    ++var11;
                                    var33 = !var31.method_169() && !var31.method_172() ? ((class_40)var35).method_138() : var35;
                                    if (var33 != var35) {
                                        var2.method_39(var33, var35);
                                    }
                                }
                                continue;
                            }
                        }
                        class_43[] var30 = var12.method_241();
                        if (var30 != null) {
                            var16 = 0;
                            for (var17 = var30.length; var16 < var17; ++var16) {
                                class_43 var18 = var30[var16];
                                Object var19;
                                if (var8 == 0) {
                                    var19 = var18;
                                } else {
                                    var19 = this.method_586().method_493(var18, var8);
                                }
                                if (!var27.method_30(var19)) {
                                    var27.method_34(var19);
                                    ++var11;
                                    Object var20 = !var18.method_169() && !var18.method_172() ? ((class_40)var19).method_138() : var19;
                                    if (var20 != var19) {
                                        var2.method_39(var20, var19);
                                    }
                                }
                            }
                        }
                        class_43 var29 = var12.method_240();
                        if (var29 != null) {
                            if (var8 == 0) {
                                var33 = var29;
                            } else {
                                var33 = this.method_586().method_493(var29, var8);
                            }
                            if (!var27.method_30(var33)) {
                                var27.method_34(var33);
                                ++var11;
                                Object var39 = !var29.method_169() && !var29.method_172() ? ((class_40)var33).method_138() : var33;
                                if (var39 != var33) {
                                    var2.method_39(var39, var33);
                                }
                            }
                        }
                    }
                    var13 = var27.method_29();
                    class_40[] var28 = new class_40[var13];
                    int var36 = 0;
                    class_40 var32;
                    for (class_16 var34 = var27.method_31(); var34.method_47(); var28[var36++] = !var9.method_169() && !var9.method_172() ? var32.method_138() : var32) {
                        var32 = (class_40)var34.method_48();
                        var9 = var32.method_173();
                    }
                    var16 = var13;
                    class_40 var38;
                    int var37;
                    class_40 var40;
                    for (var17 = var4 + 1; var17 < var3; ++var17) {
                        var38 = var1[var17];
                        if (var38 != null) {
                            class_40 var21;
                            class_40[] var23;
                            Object var22;
                            int var25;
                            int var24;
                            if (var38.method_147()) {
                                label247:
                                for (var37 = 0; var37 < var13; ++var37) {
                                    var40 = var28[var37];
                                    if (var40 != null && var40 != var38) {
                                        if ((var21 = var38.method_140(var40)) == null) {
                                            var28[var37] = null;
                                            --var16;
                                            if (var16 == 0) {
                                                return null;
                                            }
                                        } else {
                                            var22 = var2.method_38(var40);
                                            if (var22 == null) {
                                                var2.method_39(var40, var21);
                                            } else if (var22 instanceof class_40) {
                                                if (var21 != var22) {
                                                    var23 = new class_40[] {(class_40)var22, var21};
                                                    var2.method_39(var40, var23);
                                                }
                                            } else {
                                                var23 = (class_40[])((class_40[])var22);
                                                var24 = var23.length;
                                                for (var25 = 0; var25 < var24; ++var25) {
                                                    if (var23[var25] == var21) {
                                                        continue label247;
                                                    }
                                                }
                                                System.arraycopy(var23, 0, var23 = new class_40[var24 + 1], 0, var24);
                                                var2.method_39(var40, var23);
                                                var23[var24] = var21;
                                            }
                                        }
                                    }
                                }
                            } else {
                                label277:
                                for (var37 = 0; var37 < var13; ++var37) {
                                    var40 = var28[var37];
                                    if (var40 != null) {
                                        if (var40 != var38 && (var40.field_177 != 1 || !var38.method_157())) {
                                            if (var40.method_147()) {
                                                var21 = null;
                                            } else {
                                                var21 = var38.method_140(var40);
                                            }
                                            if (var21 == null) {
                                                var28[var37] = null;
                                                --var16;
                                                if (var16 == 0) {
                                                    return null;
                                                }
                                                continue;
                                            }
                                        } else {
                                            var21 = var40;
                                        }
                                        var22 = var2.method_38(var40);
                                        if (var22 == null) {
                                            var2.method_39(var40, var21);
                                        } else if (var22 instanceof class_40) {
                                            if (var21 != var22) {
                                                var23 = new class_40[] {(class_40)var22, var21};
                                                var2.method_39(var40, var23);
                                            }
                                        } else {
                                            var23 = (class_40[])((class_40[])var22);
                                            var24 = var23.length;
                                            for (var25 = 0; var25 < var24; ++var25) {
                                                if (var23[var25] == var21) {
                                                    continue label277;
                                                }
                                            }
                                            System.arraycopy(var23, 0, var23 = new class_40[var24 + 1], 0, var24);
                                            var2.method_39(var40, var23);
                                            var23[var24] = var21;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (var16 > 1) {
                        for (var17 = 0; var17 < var13; ++var17) {
                            var38 = var28[var17];
                            if (var38 != null) {
                                for (var37 = 0; var37 < var13; ++var37) {
                                    if (var17 != var37) {
                                        var40 = var28[var37];
                                        if (var40 != null) {
                                            if (var38 instanceof class_43) {
                                                if ((var40.field_177 != 1 || !var38.method_157()) && var38.method_140(var40) != null) {
                                                    var28[var37] = null;
                                                    --var16;
                                                }
                                            } else if (var38.method_147() && (!var40.method_147() || var40.method_173().field_177 != 1 || var40.method_136() != var38.method_136() || !var38.method_173().method_157()) && var38.method_140(var40) != null) {
                                                var28[var37] = null;
                                                --var16;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return var28;
                }
        }
    }

    // $FF: renamed from: a (m.ae[], int, m.ad) m.ae
    protected final class_58 method_637(class_58[] var1, int var2, class_0 var3) {
        class_58 var4 = null;
        int var5 = 0;
        label36:
        while (var5 < var2) {
            class_58 var6 = var1[var5];
            if (var4 != null && var6.field_278 != var4.field_278) {
                break;
            }
            if (!var6.method_370()) {
                var4 = var6;
            }
            for (int var7 = 0; var7 < var2; ++var7) {
                if (var5 != var7 && !var1[var7].method_343(var6.field_276)) {
                    ++var5;
                    continue label36;
                }
            }
            this.method_576().method_694(var6.field_277);
            return var6;
        }
        class_61 var10000 = new class_61(var1[0], var1[0].field_274, var1[0].field_276, 3);
        return var10000;
    }

    // $FF: renamed from: b (m.ae[], int, m.ad) m.ae
    protected final class_58 method_638(class_58[] var1, int var2, class_0 var3) {
        int var4 = 0;
        label26:
        while (var4 < var2) {
            class_58 var5 = var1[var4];
            for (int var6 = 0; var6 < var2; ++var6) {
                if (var4 != var6 && !var1[var6].method_343(var5.field_276)) {
                    ++var4;
                    continue label26;
                }
            }
            this.method_576().method_694(var5.field_277);
            return var5;
        }
        class_61 var10000 = new class_61(var1[0], var1[0].field_274, var1[0].field_276, 3);
        return var10000;
    }

    // $FF: renamed from: a (m.ae[], int, m.s[], m.ad, m.as) m.ae
    protected final class_58 method_639(class_58[] var1, int var2, class_40[] var3, class_0 var4, class_43 var5) {
        int[] var6 = new int[var2];
        for (int var7 = 0; var7 < var2; ++var7) {
            var6[var7] = this.method_642(var1[var7], var3);
        }
        boolean var25 = var4.method_0() == null;
        class_58[] var8 = new class_58[var2];
        int var9 = 0;
        int var10 = 0;
        class_58 var14;
        class_58 var17;
        int var16;
        class_58 var32;
        for (int var11 = 2; var10 <= var11; ++var10) {
            label308:
            for (int var12 = 0; var12 < var2; ++var12) {
                if (var6[var12] == var10) {
                    var11 = var10;
                    class_58 var13 = var1[var12];
                    var14 = var13.method_376();
                    class_58 var15 = var25 ? var13.method_386() : var13;
                    for (var16 = 0; var16 < var2; ++var16) {
                        if (var12 != var16 && var6[var16] == var10) {
                            var17 = var1[var16];
                            if (var14 == var17.method_376()) {
                                var6[var16] = -1;
                            } else {
                                class_58 var18 = var17;
                                if (var17 instanceof class_63) {
                                    class_63 var19 = (class_63)var17;
                                    if (!var19.field_297 || var19.method_370()) {
                                        var18 = var19.field_292;
                                    }
                                }
                                var32 = this.method_578(var18, var15.field_276, var4);
                                if (var32 == null || !var32.method_101() || !this.method_623(var15, var32) || var13.method_357() && !var17.method_357() && var15.method_344(var32)) {
                                    continue label308;
                                }
                            }
                        }
                    }
                    var8[var12] = var13;
                    ++var9;
                }
            }
        }
        class_61 var42;
        if (var9 == 1) {
            for (var10 = 0; var10 < var2; ++var10) {
                if (var8[var10] != null) {
                    this.method_576().method_694(var1[var10].field_277);
                    return var1[var10];
                }
            }
        } else if (var9 == 0) {
            var42 = new class_61(var1[0], var1[0].field_274, var1[0].field_276, 3);
            return var42;
        }
        if (var5 != null) {
            var5 = var5 instanceof class_47 ? var5 : (class_43)var5.method_138();
        }
        label267:
        for (var10 = 0; var10 < var2; ++var10) {
            class_58 var27 = var8[var10];
            if (var27 != null) {
                class_43[] var26 = null;
                class_229 var28 = null;
                var14 = var27.method_376();
                int var21;
                for (int var29 = 0; var29 < var2; ++var29) {
                    class_58 var30 = var8[var29];
                    if (var30 != null && var10 != var29) {
                        var17 = var30.method_376();
                        if (var14.field_278 == var17.field_278) {
                            break label267;
                        }
                        int var20;
                        class_40 var33;
                        class_58[] var37;
                        if (!var14.method_356()) {
                            if (!var17.method_356()) {
                                var33 = var14.field_278.method_140(var17.field_278.method_138());
                                if (var33 == null) {
                                    continue label267;
                                }
                                if (var27.method_354() || var14.field_279 != class_34.field_157) {
                                    if (var17.field_278 != var33) {
                                        var37 = ((class_43)var33).method_210(var17.field_274);
                                        var20 = 0;
                                        for (var21 = var37.length; var20 < var21; ++var20) {
                                            if (var37[var20].method_376() == var17) {
                                                var17 = var37[var20];
                                                break;
                                            }
                                        }
                                    }
                                    if (!this.method_586().method_516().method_548(var14, var17)) {
                                        continue label267;
                                    }
                                }
                            }
                        } else if (var5 != null) {
                            var33 = var5.method_140(var14.field_278.method_138());
                            if (var14.field_278 != var33 && var33 instanceof class_43) {
                                var37 = ((class_43)var33).method_210(var14.field_274);
                                var20 = 0;
                                for (var21 = var37.length; var20 < var21; ++var20) {
                                    if (var37[var20].method_376() == var14) {
                                        var14 = var37[var20];
                                        break;
                                    }
                                }
                            }
                            var33 = var5.method_140(var17.field_278.method_138());
                            if (var17.field_278 != var33 && var33 instanceof class_43) {
                                var37 = ((class_43)var33).method_210(var17.field_274);
                                var20 = 0;
                                for (var21 = var37.length; var20 < var21; ++var20) {
                                    if (var37[var20].method_376() == var17) {
                                        var17 = var37[var20];
                                        break;
                                    }
                                }
                            }
                            if (var14.field_279 != class_34.field_157) {
                                var17 = var14.method_349(var17, this.method_586());
                            }
                            if (var17 == null || !var14.method_342(var17) || !var14.field_275.method_152(var17.field_275) && !var14.field_275.method_138().method_152(var17.field_275.method_138())) {
                                continue label267;
                            }
                            if (var14.field_277 != var17.field_277) {
                                if (var26 == null) {
                                    var26 = var14.field_277;
                                }
                                class_229 var10000;
                                if (var28 == null) {
                                    var10000 = new class_229(3);
                                    var28 = var10000;
                                }
                                int var34 = var26.length;
                                var20 = var17.field_277.length;
                                var10000 = new class_229(var34);
                                class_229 var41 = var10000;
                                for (int var22 = 0; var22 < var34; ++var22) {
                                    class_43 var23 = var26[var22];
                                    for (int var24 = 0; var24 < var20; ++var24) {
                                        if (var23.method_152(var17.field_277[var24])) {
                                            var28.method_1335(var27);
                                            var41.method_1335(var23);
                                            break;
                                        }
                                        if (var17.field_277[var24].method_152(var23)) {
                                            var28.method_1335(var30);
                                            var41.method_1335(var17.field_277[var24]);
                                            break;
                                        }
                                    }
                                }
                                var26 = var41.field_988 == 0 ? class_34.field_151 : new class_43[var41.field_988];
                                var41.method_1336(var26);
                            }
                        }
                    }
                }
                if (var26 == null) {
                    return var27;
                }
                Object[] var31 = var28.field_987;
                var16 = var26.length;
                int var36 = 0;
                label186:
                for (int var35 = var31.length; var36 < var35; ++var36) {
                    var32 = (class_58)var31[var36];
                    if (var32 != null) {
                        class_43[] var38 = var32.field_277;
                        if (var38.length == var16) {
                            var21 = 0;
                            while (var21 < var16) {
                                class_43 var39 = var38[var21];
                                int var40 = 0;
                                while (true) {
                                    if (var40 >= var16) {
                                        continue label186;
                                    }
                                    if (var39 == var26[var40]) {
                                        ++var21;
                                        break;
                                    }
                                    ++var40;
                                }
                            }
                            return var32;
                        }
                    }
                }
                class_58 var43 = new class_58(var27.field_273 | 4096, var27.field_274, var27.field_275, var27.field_276, var26, var27.field_278);
                return var43;
            }
        }
        var42 = new class_61(var1[0], var1[0].field_274, var1[0].field_276, 3);
        return var42;
    }

    // $FF: renamed from: c () m.f
    public final class_84 method_640() {
        class_84 var1 = null;
        class_83 var2 = this;
        do {
            if (var2 instanceof class_84) {
                var1 = (class_84)var2;
            }
            var2 = var2.field_374;
        } while (var2 != null);
        return var1;
    }

    // $FF: renamed from: c () m.aj
    public final class_87 method_641() {
        class_87 var1 = null;
        class_83 var2 = this;
        do {
            if (var2 instanceof class_87) {
                var1 = (class_87)var2;
            }
            var2 = var2.field_374;
        } while (var2 != null);
        return var1;
    }

    // $FF: renamed from: a (m.ae, m.s[]) int
    public int method_642(class_58 var1, class_40[] var2) {
        class_40[] var3 = var1.field_276;
        int var4 = var3.length;
        int var5 = var2.length;
        int var6;
        if (this.method_577().field_1928 < 3211264L) {
            if (var4 != var5) {
                return -1;
            } else {
                for (var6 = 0; var6 < var5; ++var6) {
                    class_40 var13 = var3[var6];
                    class_40 var14 = var2[var6];
                    if (var14 != var13 && !var14.method_152(var13)) {
                        return -1;
                    }
                }
                return 0;
            }
        } else {
            var6 = 0;
            int var7 = var5;
            class_80 var8 = this.method_586();
            class_40 var10;
            class_40 var11;
            if (var1.method_374()) {
                var7 = var4 - 1;
                class_40 var9;
                if (var4 == var5) {
                    var9 = var3[var7];
                    var10 = var2[var7];
                    if (var9 != var10) {
                        var6 = this.method_643(var10, var9, var8);
                        if (var6 == -1) {
                            var9 = ((class_42)var9).method_187();
                            if (this.method_643(var10, var9, var8) == -1) {
                                return -1;
                            }
                            var6 = 2;
                        }
                    }
                } else {
                    if (var4 < var5) {
                        var9 = ((class_42)var3[var7]).method_187();
                        for (int var16 = var7; var16 < var5; ++var16) {
                            var11 = var2[var16];
                            if (var9 != var11 && this.method_643(var11, var9, var8) == -1) {
                                return -1;
                            }
                        }
                    } else if (var7 != var5) {
                        return -1;
                    }
                    var6 = 2;
                }
            } else if (var4 != var5) {
                return -1;
            }
            for (int var15 = 0; var15 < var7; ++var15) {
                var10 = var3[var15];
                var11 = var2[var15];
                if (var11 != var10) {
                    int var12 = this.method_643(var11, var10, var8);
                    if (var12 == -1) {
                        return -1;
                    }
                    if (var12 > var6) {
                        var6 = var12;
                    }
                }
            }
            return var6;
        }
    }

    // $FF: renamed from: a (m.s, m.s, m.af) int
    private int method_643(class_40 var1, class_40 var2, class_80 var3) {
        if (var1.method_152(var2)) {
            return 0;
        } else {
            if (var1.method_148() != var2.method_148()) {
                class_40 var4 = var3.method_486(var1);
                if (var4 == var2 || var4.method_152(var2)) {
                    return 1;
                }
            }
            return -1;
        }
    }

    // $FF: renamed from: a () n.e
    public abstract class_248 method_644();

    // $FF: renamed from: a () h.b
    public final class_90 method_645() {
        class_83 var2 = this;
        while (true) {
            class_83 var1 = var2.field_374;
            if (var2.field_374 == null) {
                return ((class_85)var2).field_379;
            }
            var2 = var1;
        }
    }

    // $FF: renamed from: b () int
    int method_646() {
        return 0;
    }
}
