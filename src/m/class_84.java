package m;

import b.class_233;
import f.class_325;
import g.class_312;
import h.class_114;
import h.class_121;
import h.class_123;
import h.class_136;
import h.class_146;
import h.class_89;
import h.class_93;
import k.class_345;
import m.class_17;
import m.class_34;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_44;
import m.class_46;
import m.class_52;
import m.class_53;
import m.class_54;
import m.class_56;
import m.class_57;
import m.class_58;
import m.class_67;
import m.class_80;
import m.class_83;
import m.class_85;
import m.class_87;
import n.class_241;
import n.class_248;

// $FF: renamed from: m.f
public class class_84 extends class_83 {

    // $FF: renamed from: a h.bq
    public class_114 field_376;
    // $FF: renamed from: a h.bo
    public class_146 field_377;

    // $FF: renamed from: <init> (m.bb, h.bq) void
    public class_84(class_83 var1, class_114 var2) {
        super(3, var1);
        this.field_376 = var2;
    }

    // $FF: renamed from: a (m.az, m.as) void
    void method_648(class_54 var1, class_43 var2) {
        class_57 var3 = this.method_651(var1, var2, var1.field_200);
        if (var2.method_157()) {
            var3.field_252 = this.method_609();
            var3.field_253 = new class_43[] {var2};
        } else {
            var3.field_252 = var2;
            var3.field_253 = class_34.field_155;
            class_146 var4 = this.field_376.field_598.field_691;
            if (var4 != null) {
                if (var2.method_138().field_177 == 41) {
                    this.method_644().method_1496(var3, var4, var2);
                    var3.field_178 |= 131072L;
                    var3.field_252 = this.method_609();
                } else if (var2.method_221()) {
                    this.method_644().method_1478(var4, var2);
                    var3.field_178 |= 131072L;
                    var3.field_252 = this.method_609();
                } else if ((var2.field_178 & 1073741824L) != 0L) {
                    this.method_644().method_1765(var3, var4, var2);
                    var3.field_178 |= 131072L;
                    var3.field_252 = this.method_609();
                }
            }
        }
        this.method_662();
        this.method_650();
        var3.method_306();
        var3.method_321(this.method_586().method_516());
    }

    // $FF: renamed from: a () void
    void method_649() {
        class_54 var1 = this.field_376.field_586;
        if (!var1.method_304()) {
            if (this.field_376.field_583 == null) {
                var1.method_315(class_34.field_153);
            } else {
                class_121[] var2 = this.field_376.field_583;
                int var3 = var2.length;
                int var4 = 0;
                int var5 = 0;
                while (var5 < var3) {
                    switch (var2[var5].method_887()) {
                        case 1:
                        case 3:
                            ++var4;
                        default:
                            ++var5;
                    }
                }
                class_67[] var15 = new class_67[var4];
                class_325 var10000 = new class_325(var4);
                class_325 var6 = var10000;
                boolean var7 = false;
                var4 = 0;
                class_67 var10;
                for (int var8 = 0; var8 < var3; ++var8) {
                    class_121 var9 = var2[var8];
                    if (var9.method_887() == 2) {
                        if (var1.method_157()) {
                            this.method_644().method_1621(var1, var9);
                        }
                    } else {
                        class_67 var14 = new class_67(var9, (class_40)null, var9.field_656 | 33554432, var1);
                        var10 = var14;
                        var10.field_304 = var4;
                        this.method_658(var10, var9);
                        if (var6.method_3225(var9.field_659)) {
                            var7 = true;
                            class_67 var11 = (class_67)var6.method_3226(var9.field_659);
                            if (var11 != null) {
                                for (int var12 = 0; var12 < var8; ++var12) {
                                    class_121 var13 = var2[var12];
                                    if (var13.field_661 == var11) {
                                        this.method_644().method_1524(var1, var13);
                                        var13.field_661 = null;
                                        break;
                                    }
                                }
                            }
                            var6.method_3227(var9.field_659, (Object)null);
                            this.method_644().method_1524(var1, var9);
                            var9.field_661 = null;
                        } else {
                            var6.method_3227(var9.field_659, var10);
                            var15[var4++] = var10;
                        }
                    }
                }
                if (var7) {
                    class_67[] var16 = new class_67[var15.length];
                    var3 = var4;
                    var4 = 0;
                    for (int var17 = 0; var17 < var3; ++var17) {
                        var10 = var15[var17];
                        if (var6.method_3226(var10.field_302) != null) {
                            var10.field_304 = var4;
                            var16[var4++] = var10;
                        }
                    }
                    var15 = var16;
                }
                if (var4 != var15.length) {
                    System.arraycopy(var15, 0, var15 = new class_67[var4], 0, var4);
                }
                var1.field_178 &= -12289L;
                var1.method_315(var15);
            }
        }
    }

    // $FF: renamed from: b () void
    void method_650() {
        this.method_649();
        this.method_654();
        class_54 var1 = this.field_376.field_586;
        if (var1.method_159() && !var1.method_158()) {
            ((class_56)var1).method_332();
        }
        class_43[] var2 = var1.field_256;
        int var3 = 0;
        for (int var4 = var2.length; var3 < var4; ++var3) {
            ((class_54)var2[var3]).field_258.method_650();
        }
    }

    // $FF: renamed from: a (m.az, m.as, m.ar) m.aa
    private class_57 method_651(class_54 var1, class_43 var2, class_38 var3) {
        this.field_376.field_587 = this;
        class_114 var10000 = this.field_376;
        class_87 var10001 = new class_87(this, this.field_376, true);
        var10000.field_589 = var10001;
        var10000 = this.field_376;
        var10001 = new class_87(this, this.field_376, false);
        var10000.field_588 = var10001;
        class_57 var15 = new class_57(this, var1, this.method_622(), var2);
        class_57 var4 = var15;
        this.field_376.field_586 = var4;
        this.method_657();
        this.method_656();
        class_43[] var5 = class_34.field_156;
        if (this.field_376.field_585 != null) {
            int var6 = this.field_376.field_585.length;
            var5 = new class_43[var6];
            int var7 = 0;
            label43:
            for (int var8 = 0; var8 < var6; ++var8) {
                class_114 var9 = this.field_376.field_585[var8];
                switch (class_114.method_859(var9.field_577)) {
                    case 2:
                    case 4:
                        this.method_644().method_1573(var9);
                        break;
                    default:
                        Object var10 = var4;
                        do {
                            if (class_233.method_1364(((class_43)var10).field_198, var9.field_580)) {
                                this.method_644().method_1772(var9);
                                continue label43;
                            }
                            var10 = ((class_43)var10).method_137();
                        } while (var10 != null);
                        for (int var11 = 0; var11 < var8; ++var11) {
                            if (class_233.method_1364(this.field_376.field_585[var11].field_580, var9.field_580)) {
                                this.method_644().method_1534(var9);
                                continue label43;
                            }
                        }
                        class_84 var14 = new class_84(this, this.field_376.field_585[var8]);
                        class_84 var16 = var14;
                        class_57 var12 = var16.method_651(var4, (class_43)null, var3);
                        var12.method_337();
                        var5[var7++] = var12;
                }
            }
            if (var7 != var6) {
                System.arraycopy(var5, 0, var5 = new class_43[var7], 0, var7);
            }
        }
        var4.field_256 = var5;
        return var4;
    }

    // $FF: renamed from: a (m.az) void
    void method_652(class_54 var1) {
        class_57 var2 = this.method_651(var1, (class_43)null, var1.field_200);
        this.method_666();
        this.method_650();
        var2.method_306();
        this.field_376.field_586.method_321(this.method_586().method_516());
    }

    // $FF: renamed from: a (k.c) void
    private void method_653(class_345 var1) {
        class_54 var2 = this.field_376.field_586;
        class_43[] var3 = class_34.field_156;
        if (this.field_376.field_585 != null) {
            int var4 = this.field_376.field_585.length;
            var3 = new class_43[var4];
            int var5 = 0;
            label50:
            for (int var6 = 0; var6 < var4; ++var6) {
                class_114 var7 = this.field_376.field_585[var6];
                switch (class_114.method_859(var7.field_577)) {
                    case 2:
                    case 4:
                        if (var2.method_160() && var2.method_151() && !var2.method_226()) {
                            this.method_644().method_1573(var7);
                            break;
                        }
                    default:
                        Object var8 = var2;
                        do {
                            if (class_233.method_1364(((class_43)var8).field_198, var7.field_580)) {
                                this.method_644().method_1772(var7);
                                continue label50;
                            }
                            var8 = ((class_43)var8).method_137();
                        } while (var8 != null);
                        for (int var9 = 0; var9 < var6; ++var9) {
                            if (class_233.method_1364(this.field_376.field_585[var9].field_580, var7.field_580)) {
                                this.method_644().method_1534(var7);
                                continue label50;
                            }
                        }
                        class_84 var10000 = new class_84(this, var7);
                        class_84 var10 = var10000;
                        var3[var5++] = var10.method_655(var2, var2.field_200, var1);
                }
            }
            if (var5 != var4) {
                System.arraycopy(var3, 0, var3 = new class_43[var5], 0, var5);
            }
        }
        var2.field_256 = var3;
    }

    // $FF: renamed from: c () void
    void method_654() {
        class_54 var1 = this.field_376.field_586;
        if (!var1.method_305()) {
            boolean var2 = class_114.method_859(this.field_376.field_577) == 3;
            if (this.field_376.field_584 == null && !var2) {
                this.field_376.field_586.method_316(class_34.field_154);
            } else {
                class_93[] var3 = this.field_376.field_584;
                int var4 = var3 == null ? 0 : var3.length;
                int var5 = -1;
                int var6;
                for (var6 = 0; var6 < var4; ++var6) {
                    if (var3[var6].method_794()) {
                        var5 = var6;
                        break;
                    }
                }
                var6 = var2 ? 2 : 0;
                class_58[] var7 = new class_58[(var5 == -1 ? var4 : var4 - 1) + var6];
                if (var2) {
                    var7[0] = var1.method_299(class_17.field_71);
                    var7[1] = var1.method_299(class_17.field_72);
                }
                for (int var8 = 0; var8 < var4; ++var8) {
                    if (var8 != var5) {
                        class_87 var10000 = new class_87(this, var3[var8], false);
                        class_87 var9 = var10000;
                        class_58 var10 = var9.method_725(var3[var8]);
                        if (var10 != null) {
                            var7[var6++] = var10;
                        }
                    }
                }
                if (var6 != var7.length) {
                    System.arraycopy(var7, 0, var7 = new class_58[var6], 0, var6);
                }
                var1.field_178 &= -49153L;
                var1.method_316(var7);
            }
        }
    }

    // $FF: renamed from: a (m.az, m.ar, k.c) m.az
    class_54 method_655(class_54 var1, class_38 var2, class_345 var3) {
        this.field_376.field_587 = this;
        class_114 var10000 = this.field_376;
        class_87 var10001 = new class_87(this, this.field_376, true);
        var10000.field_589 = var10001;
        var10000 = this.field_376;
        var10001 = new class_87(this, this.field_376, false);
        var10000.field_588 = var10001;
        char[][] var4;
        if (var1 == null) {
            var4 = class_233.method_1353(var2.field_171, this.field_376.field_580);
            var10000 = this.field_376;
            class_54 var6 = new class_54(var4, var2, this);
            var10000.field_586 = var6;
        } else {
            var4 = class_233.method_1362(var1.field_197);
            var4[var4.length - 1] = class_233.method_1357(var4[var4.length - 1], this.field_376.field_580, '$');
            class_43 var5 = var2.method_124(var4[var4.length - 1]);
            if (var5 != null && !(var5 instanceof class_44)) {
                this.field_374.method_644().method_1534(this.field_376);
            }
            var10000 = this.field_376;
            class_56 var7 = new class_56(var4, this, var1);
            var10000.field_586 = var7;
        }
        class_54 var8 = this.field_376.field_586;
        this.method_586().method_519(var8, var3);
        var8.field_200.method_118(var8);
        this.method_657();
        this.method_656();
        this.method_653(var3);
        return var8;
    }

    // $FF: renamed from: g () void
    private void method_656() {
        class_54 var1 = this.field_376.field_586;
        class_123[] var2 = this.field_376.field_601;
        if (var2 != null && this.method_577().field_1928 >= 3211264L) {
            var1.field_257 = class_34.field_157;
            if (var1.field_177 == 1) {
                this.method_644().method_1711(this.field_376);
            } else {
                var1.field_257 = this.method_581(var2, var1);
                var1.field_199 |= 1073741824;
            }
        } else {
            var1.field_257 = class_34.field_157;
        }
    }

    // $FF: renamed from: h () void
    private void method_657() {
        class_54 var1 = this.field_376.field_586;
        int var2 = var1.field_199;
        if ((var2 & 4194304) != 0) {
            this.method_644().method_1532(var1);
        }
        class_43 var3 = var1.method_137();
        boolean var4 = var1.method_159();
        if (var4) {
            var2 |= var3.field_199 & 1073743872;
            if (var3.method_157()) {
                var2 |= 1;
            }
            if (var1.method_153()) {
                if (!var3.method_226()) {
                    this.method_644().method_1706(var1);
                } else {
                    var2 |= 8;
                }
            }
            if (var3.method_230() && !var1.method_220()) {
                var2 |= 2097152;
            }
        } else if (var1.method_158()) {
            if (var1.method_153()) {
                this.method_644().method_1573(this.field_376);
                var1.field_199 = 0;
                return;
            }
            if (var1.method_146()) {
                var2 |= 16;
                if (this.field_376.field_598.field_691 == null) {
                    var2 |= 16384;
                }
            }
            Object var5 = this;
            do {
                switch (((class_83)var5).field_373) {
                    case 2:
                        class_87 var6 = (class_87)var5;
                        if (var6.method_727()) {
                            class_54 var7 = ((class_114)var6.field_403).field_586;
                            if (var6.field_406 != null) {
                                if (var6.field_406.method_434() && !var1.method_220()) {
                                    var2 |= 2097152;
                                }
                            } else {
                                if (var7.method_227()) {
                                    var2 |= 2048;
                                }
                                if (var7.method_230() && !var1.method_220()) {
                                    var2 |= 2097152;
                                }
                            }
                        } else {
                            class_58 var17 = ((class_93)var6.field_403).field_488;
                            if (var17 != null) {
                                if (var17.method_371()) {
                                    var2 |= 2048;
                                }
                                if (var17.method_375() && !var1.method_220()) {
                                    var2 |= 2097152;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (var3.method_227()) {
                            var2 |= 2048;
                        }
                        if (var3.method_230() && !var1.method_220()) {
                            var2 |= 2097152;
                        }
                }
                var5 = ((class_83)var5).field_374;
            } while (var5 != null);
        }
        int var15 = var2 & '\uffff';
        if ((var15 & 512) != 0) {
            if (var4) {
                if ((var15 & -11792) != 0) {
                    if ((var15 & 8192) != 0) {
                        this.method_644().method_1578(var1);
                    } else {
                        this.method_644().method_1592(var1);
                    }
                }
            } else if ((var15 & -11778) != 0) {
                if ((var15 & 8192) != 0) {
                    this.method_644().method_1579(var1);
                } else {
                    this.method_644().method_1585(var1);
                }
            }
            if (var1.field_198 == class_17.field_144 && this.method_577().field_1929 > 3211264L) {
                var2 |= 4096;
            }
            var2 |= 1024;
        } else if ((var15 & 16384) != 0) {
            if (var4) {
                if ((var15 & -18448) != 0) {
                    this.method_644().method_1591(var1);
                    var2 &= -1025;
                    var15 &= -1025;
                }
            } else if (var1.method_158()) {
                if ((var15 & -18449) != 0) {
                    this.method_644().method_1589(var1);
                }
            } else if ((var15 & -18434) != 0) {
                this.method_644().method_1581(var1);
            }
            if (!var1.method_146()) {
                label268: {
                    int var8;
                    class_114 var16;
                    class_121[] var19;
                    if ((this.field_376.field_446 & 2048) != 0) {
                        var2 |= 1024;
                    } else {
                        var16 = this.field_376;
                        var19 = var16.field_583;
                        var8 = var19 == null ? 0 : var19.length;
                        if (var8 != 0) {
                            class_93[] var9 = var16.field_584;
                            int var10 = var9 == null ? 0 : var9.length;
                            boolean var11 = var16.field_582 != null;
                            for (int var12 = 0; var12 < var10 && !var11; ++var12) {
                                var11 = var9[var12].method_792();
                            }
                            if (var11) {
                                boolean var22 = false;
                                int var13 = 0;
                                while (true) {
                                    if (var13 >= var8) {
                                        if (var22) {
                                            var2 |= 1024;
                                        }
                                        break;
                                    }
                                    class_121 var14 = var19[var13];
                                    if (var14.method_887() == 3) {
                                        if (!(var14.field_655 instanceof class_136)) {
                                            break;
                                        }
                                        var22 = true;
                                    }
                                    ++var13;
                                }
                            }
                        }
                    }
                    var16 = this.field_376;
                    var19 = var16.field_583;
                    if (var19 != null) {
                        var8 = 0;
                        for (int var20 = var19.length; var8 < var20; ++var8) {
                            class_121 var21 = var19[var8];
                            if (var21.method_887() == 3 && var21.field_655 instanceof class_136) {
                                break label268;
                            }
                        }
                    }
                    var2 |= 16;
                }
            }
        } else {
            if (var4) {
                if ((var15 & -3104) != 0) {
                    this.method_644().method_1590(var1);
                }
            } else if (var1.method_158()) {
                if ((var15 & -3089) != 0) {
                    this.method_644().method_1588(var1);
                }
            } else if ((var15 & -3090) != 0) {
                this.method_644().method_1580(var1);
            }
            if ((var15 & 1040) == 1040) {
                this.method_644().method_1574(var1);
            }
        }
        if (var4) {
            if (var3.method_157()) {
                if ((var15 & 6) != 0) {
                    this.method_644().method_1604(var1);
                    if ((var15 & 4) != 0) {
                        var2 &= -5;
                    }
                    if ((var15 & 2) != 0) {
                        var2 &= -3;
                    }
                }
            } else {
                int var18 = var15 & 7;
                if ((var18 & var18 - 1) > 1) {
                    this.method_644().method_1602(var1);
                    if ((var18 & 1) != 0) {
                        if ((var18 & 4) != 0) {
                            var2 &= -5;
                        }
                        if ((var18 & 2) != 0) {
                            var2 &= -3;
                        }
                    } else if ((var18 & 4) != 0 && (var18 & 2) != 0) {
                        var2 &= -3;
                    }
                }
            }
            if ((var15 & 8) == 0) {
                if (var3.method_157()) {
                    var2 |= 8;
                }
            } else if (!var3.method_226()) {
                this.method_644().method_1597(var1);
            }
        }
        var1.field_199 = var2;
    }

    // $FF: renamed from: a (m.k, h.m) void
    private void method_658(class_67 var1, class_121 var2) {
        int var3 = var1.field_300;
        class_43 var4 = var1.field_314;
        if ((var3 & 4194304) != 0) {
            this.method_644().method_1530(var4, var2);
        }
        if (var4.method_157()) {
            var3 |= 25;
            if ((var3 & '\uffff') != 25) {
                if ((var4.field_199 & 8192) != 0) {
                    this.method_644().method_1576(var2);
                } else {
                    this.method_644().method_1586(var2);
                }
            }
            var1.field_300 = var3;
        } else if (var2.method_887() == 3) {
            if ((var3 & '\uffff') != 0) {
                this.method_644().method_1582(var4, var2);
            }
            var1.field_300 |= 16409;
        } else {
            int var5 = var3 & '\uffff';
            if ((var5 & -224) != 0) {
                this.method_644().method_1584(var4, var2);
                var3 &= -65313;
            }
            int var7 = var5 & 7;
            if ((var7 & var7 - 1) > 1) {
                this.method_644().method_1601(var4, var2);
                if ((var7 & 1) != 0) {
                    if ((var7 & 4) != 0) {
                        var3 &= -5;
                    }
                    if ((var7 & 2) != 0) {
                        var3 &= -3;
                    }
                } else if ((var7 & 4) != 0 && (var7 & 2) != 0) {
                    var3 &= -3;
                }
            }
            if ((var5 & 80) == 80) {
                this.method_644().method_1575(var4, var2);
            }
            if (var2.field_655 == null && (var3 & 16) != 0) {
                var3 |= 67108864;
            }
            var1.field_300 = var3;
        }
    }

    // $FF: renamed from: d () void
    public void method_659() {
        class_54 var1 = this.field_376.field_586;
        class_43[] var2 = var1.field_253;
        class_312 var10000 = new class_312(2);
        class_312 var3 = var10000;
        class_43 var4 = var1.method_157() ? null : var1.field_252;
        int var5 = 0;
        int var6;
        int var8;
        for (var6 = var2.length; var5 < var6; ++var5) {
            class_43 var7 = var2[var5];
            if (var7 != null && (var4 == null || !this.method_621(var4, var7, var3, var1, this.field_376))) {
                for (var8 = 0; var8 < var5; ++var8) {
                    class_43 var9 = var2[var8];
                    if (var9 != null && this.method_621(var7, var9, var3, var1, this.field_376)) {
                        break;
                    }
                }
            }
        }
        class_123[] var17 = this.field_376.field_601;
        var6 = 0;
        int var18;
        label91:
        for (var18 = var17 == null ? 0 : var17.length; var6 < var18; ++var6) {
            class_123 var20 = var17[var6];
            class_46 var21 = var20.field_668;
            if (var21 != null && var21.method_101()) {
                class_146[] var10 = var20.field_669;
                if (var10 != null) {
                    boolean var11 = var21.field_222 == var21.field_223;
                    int var12 = 0;
                    for (int var13 = var10.length; var12 < var13; ++var12) {
                        class_146 var14 = var10[var12];
                        class_40 var15 = var14.field_675;
                        if (var15 != null && var15.method_101()) {
                            if (var11 && this.method_621(var15, var21.field_223, var3, var21, var14)) {
                                break;
                            }
                            int var16 = var21.field_224.length;
                            while (true) {
                                --var16;
                                if (var16 < 0) {
                                    break;
                                }
                                if (this.method_621(var15, var21.field_224[var16], var3, var21, var14)) {
                                    continue label91;
                                }
                            }
                        }
                    }
                }
            }
        }
        class_43[] var19 = this.field_376.field_586.field_256;
        if (var19 != null && var19 != class_34.field_156) {
            var18 = 0;
            for (var8 = var19.length; var18 < var8; ++var18) {
                ((class_54)var19[var18]).field_258.method_659();
            }
        }
    }

    // $FF: renamed from: b (m.az) void
    private void method_660(class_54 var1) {
        Object var2 = var1;
        class_43[] var3 = null;
        int var4 = 0;
        int var6;
        int var9;
        do {
            if (((class_43)var2).method_213()) {
                return;
            }
            class_43[] var5 = ((class_43)var2).method_241();
            if (var5 != null && var5 != class_34.field_155) {
                if (var3 == null) {
                    var3 = var5;
                    var4 = var5.length;
                } else {
                    var6 = var5.length;
                    if (var4 + var6 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new class_43[var4 + var6 + 5], 0, var4);
                    }
                    label108:
                    for (int var7 = 0; var7 < var6; ++var7) {
                        class_43 var8 = var5[var7];
                        for (var9 = 0; var9 < var4; ++var9) {
                            if (var8 == var3[var9]) {
                                continue label108;
                            }
                        }
                        var3[var4++] = var8;
                    }
                }
            }
        } while ((var2 = ((class_43)var2).method_240()) != null && (((class_43)var2).field_178 & 65536L) == 0L);
        if (var3 != null) {
            boolean var13 = false;
            for (var6 = 0; var6 < var4; ++var6) {
                class_43 var14 = var3[var6];
                if ((var14.field_178 & 65536L) == 0L) {
                    if (var14.method_213()) {
                        return;
                    }
                    var13 = true;
                    class_43[] var15 = var14.method_241();
                    if (var15 != null && var15 != class_34.field_155) {
                        var9 = var15.length;
                        if (var4 + var9 >= var3.length) {
                            System.arraycopy(var3, 0, var3 = new class_43[var4 + var9 + 5], 0, var4);
                        }
                        label84:
                        for (int var10 = 0; var10 < var9; ++var10) {
                            class_43 var11 = var15[var10];
                            for (int var12 = 0; var12 < var4; ++var12) {
                                if (var11 == var3[var12]) {
                                    continue label84;
                                }
                            }
                            var3[var4++] = var11;
                        }
                    }
                }
            }
            if (var13) {
                for (var6 = 0; var6 < var4; ++var6) {
                    var3[var6].field_178 |= 65536L;
                }
            }
        }
        var2 = var1;
        do {
            ((class_43)var2).field_178 |= 65536L;
        } while ((var2 = ((class_43)var2).method_240()) != null && (((class_43)var2).field_178 & 65536L) == 0L);
    }

    // $FF: renamed from: e () void
    public void method_661() {
        class_146 var1 = this.field_376.field_581;
        if (var1 != null) {
            var1.method_1007(this);
        }
        class_146[] var2 = this.field_376.field_582;
        int var4;
        if (var2 != null) {
            int var3 = 0;
            for (var4 = var2.length; var3 < var4; ++var3) {
                var2[var3].method_1007(this);
            }
        }
        class_123[] var7 = this.field_376.field_601;
        int var5;
        if (var7 != null) {
            var4 = 0;
            for (var5 = var7.length; var4 < var5; ++var4) {
                var7[var4].method_896(this);
            }
        }
        class_43[] var8 = this.field_376.field_586.field_256;
        if (var8 != null && var8 != class_34.field_156) {
            var5 = 0;
            for (int var6 = var8.length; var5 < var6; ++var5) {
                ((class_54)var8[var5]).field_258.method_661();
            }
        }
    }

    // $FF: renamed from: i () void
    private void method_662() {
        class_54 var1 = this.field_376.field_586;
        class_43[] var2 = var1.field_256;
        if (var2 != null && var2 != class_34.field_156) {
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                ((class_54)var2[var3]).field_258.method_666();
            }
        }
    }

    // $FF: renamed from: a () boolean
    private boolean method_663() {
        class_54 var1 = this.field_376.field_586;
        if (var1.field_177 == 1) {
            var1.field_252 = null;
            var1.field_253 = class_34.field_155;
            if (!var1.method_151()) {
                this.method_644().method_1713(var1);
            }
            if (this.field_376.field_581 != null || this.field_376.field_582 != null && this.field_376.field_582.length > 0) {
                this.method_644().method_1712(var1);
            }
            return true;
        } else if (this.field_376.field_581 == null) {
            if (var1.method_153() && this.method_577().field_1928 >= 3211264L) {
                return this.method_664();
            } else {
                var1.field_252 = this.method_609();
                return !this.method_669(var1, var1.field_252, (class_146)null);
            }
        } else {
            class_146 var2 = this.field_376.field_581;
            class_43 var3 = this.method_670(var2);
            if (var3 != null) {
                if (!var3.method_151() && (var3.field_178 & 128L) == 0L) {
                    this.method_644().method_1761(var1, var2, var3);
                } else if (var3.method_221()) {
                    this.method_644().method_1508(var1, var2, var3);
                } else if ((var3.field_178 & 1073741824L) != 0L) {
                    this.method_644().method_1765(var1, var2, var3);
                } else {
                    if (var3.method_138().field_177 != 41) {
                        if ((var3.field_178 & 131072L) == 0L && var2.field_675.method_101()) {
                            var1.field_252 = var3;
                            return true;
                        }
                        var1.field_252 = var3;
                        var1.field_178 |= 131072L;
                        return var2.field_675.method_101();
                    }
                    this.method_644().method_1496(var1, var2, var3);
                }
            }
            var1.field_178 |= 131072L;
            var1.field_252 = this.method_609();
            if ((var1.field_252.field_178 & 256L) == 0L) {
                this.method_669(var1, var1.field_252, (class_146)null);
            }
            return false;
        }
    }

    // $FF: renamed from: b () boolean
    private boolean method_664() {
        class_54 var1 = this.field_376.field_586;
        class_43 var2 = this.method_608();
        boolean var3 = this.method_669(var1, var2, (class_146)null);
        class_46[] var4 = var2.method_181();
        if (var4 == class_34.field_157) {
            this.method_644().method_1702(0, (class_89)null, var2, new class_40[] {var1});
            return false;
        } else if (1 != var4.length) {
            this.method_644().method_1609((class_89)null, var2, new class_40[] {var1});
            return false;
        } else {
            class_52 var5 = this.method_586().method_500(var2, new class_40[] {this.method_586().method_490(var1, false)}, (class_43)null);
            var1.field_178 |= var5.field_178 & 131072L;
            var1.field_252 = var5;
            if (var4[0].method_255(var5, var1) != 0) {
                this.method_644().method_1778(var2, var4[0], var1, (class_89)null);
            }
            return !var3;
        }
    }

    // $FF: renamed from: c () boolean
    private boolean method_665() {
        class_54 var1 = this.field_376.field_586;
        var1.field_253 = class_34.field_155;
        if (this.field_376.field_582 == null) {
            if (var1.method_145() && this.method_577().field_1928 >= 3211264L) {
                class_43 var11 = this.method_604();
                boolean var10 = this.method_669(var1, var11, (class_146)null);
                var1.field_253 = new class_43[] {var11};
                return !var10;
            } else {
                return true;
            }
        } else if (var1.field_177 == 1) {
            return true;
        } else {
            boolean var2 = true;
            int var3 = this.field_376.field_582.length;
            class_43[] var4 = new class_43[var3];
            int var5 = 0;
            label77:
            for (int var6 = 0; var6 < var3; ++var6) {
                class_146 var7 = this.field_376.field_582[var6];
                class_43 var8 = this.method_670(var7);
                if (var8 == null) {
                    var1.field_178 |= 131072L;
                    var2 = false;
                } else {
                    for (int var9 = 0; var9 < var6; ++var9) {
                        if (var4[var9] == var8) {
                            this.method_644().method_1535(var1, var7, var8);
                            var1.field_178 |= 131072L;
                            var2 = false;
                            continue label77;
                        }
                    }
                    if (!var8.method_157() && (var8.field_178 & 128L) == 0L) {
                        this.method_644().method_1763(var1, var7, var8);
                        var1.field_178 |= 131072L;
                        var2 = false;
                    } else {
                        if (var8.method_145()) {
                            this.method_644().method_1473(var1, var7, var8);
                        }
                        if ((var8.field_178 & 1073741824L) != 0L) {
                            this.method_644().method_1765(var1, var7, var8);
                            var1.field_178 |= 131072L;
                            var2 = false;
                        } else {
                            if ((var8.field_178 & 131072L) != 0L || !var7.field_675.method_101()) {
                                var1.field_178 |= 131072L;
                                var2 &= var7.field_675.method_101();
                            }
                            var4[var5++] = var8;
                        }
                    }
                }
            }
            if (var5 > 0) {
                if (var5 != var3) {
                    System.arraycopy(var4, 0, var4 = new class_43[var5], 0, var5);
                }
                var1.field_253 = var4;
            }
            return var2;
        }
    }

    // $FF: renamed from: f () void
    void method_666() {
        class_54 var1 = this.field_376.field_586;
        if ((var1.field_178 & 256L) == 0L) {
            var1.field_178 |= 256L;
            boolean var2 = this.method_663();
            var2 &= this.method_665();
            var1.field_178 |= 512L;
            var2 &= this.method_579(this.field_376.field_601, false);
            var1.field_178 |= 262144L;
            if (var2 && var1.method_156()) {
                this.method_644().method_1565(var1);
            }
        }
        this.method_662();
        class_80 var9 = this.method_586();
        try {
            var9.field_363 = this.field_376;
            this.method_660(var1);
        } catch (class_241 var7) {
            var7.method_1438(this.field_376, this.method_645().field_455);
            throw var7;
        } finally {
            var9.field_363 = null;
        }
    }

    // $FF: renamed from: j () void
    private void method_667() {
        if (this.field_374 instanceof class_85) {
            if (((class_85)this.field_374).field_382 == null) {
                ((class_85)this.field_374).method_675();
            }
        } else if (this.field_374 instanceof class_84) {
            ((class_84)this.field_374).method_667();
        }
        class_54 var1 = this.field_376.field_586;
        if ((var1.field_178 & 256L) == 0L) {
            var1.field_178 |= 256L;
            boolean var2 = this.method_663();
            var2 &= this.method_665();
            var1.field_178 |= 512L;
            var2 &= this.method_579(this.field_376.field_601, false);
            var1.field_178 |= 262144L;
            if (var2 && var1.method_156()) {
                this.method_644().method_1565(var1);
            }
        }
    }

    // $FF: renamed from: a (m.s, h.bo) boolean
    public boolean method_668(class_40 var1, class_146 var2) {
        if (!(var1 instanceof class_43)) {
            return false;
        } else if (var2 == this.field_377) {
            if (((class_40)var1).method_169()) {
                return false;
            } else {
                if (((class_40)var1).method_162()) {
                    var1 = ((class_52)var1).method_286();
                }
                this.method_576().method_691((class_40)var1);
                return this.method_669(this.field_376.field_586, (class_43)var1, var2);
            }
        } else {
            return false;
        }
    }

    // $FF: renamed from: a (m.az, m.as, h.bo) boolean
    private boolean method_669(class_54 var1, class_43 var2, class_146 var3) {
        if (var2.method_166()) {
            var2 = ((class_53)var2).method_286();
        }
        if (var1 == var2) {
            this.method_644().method_1564(var1, var2, var3);
            var1.field_178 |= 131072L;
            return true;
        } else {
            if (var2.method_159()) {
                class_43 var4 = var2.method_137();
                do {
                    if (var4.method_222() && var4 == var1) {
                        this.method_644().method_1564(var1, var4, var3);
                        var1.field_178 |= 131072L;
                        var4.field_178 |= 131072L;
                        return true;
                    }
                } while ((var4 = var4.method_137()) != null);
            }
            if (var2.method_218()) {
                boolean var11 = false;
                class_43 var5 = var2.method_240();
                if (var5 != null) {
                    if (var1 == var5) {
                        this.method_644().method_1564(var1, var2, var3);
                        var1.field_178 |= 131072L;
                        var2.field_178 |= 131072L;
                        return true;
                    }
                    if (var5.method_162()) {
                        var5 = ((class_52)var5).method_286();
                    }
                    var11 |= this.method_669(var1, var5, var3);
                    if ((var5.field_178 & 131072L) != 0L) {
                        var1.field_178 |= 131072L;
                        var5.field_178 |= 131072L;
                    }
                }
                class_43[] var6 = var2.method_241();
                if (var6 != null && var6 != class_34.field_155) {
                    int var7 = 0;
                    for (int var8 = var6.length; var7 < var8; ++var7) {
                        class_43 var9 = var6[var7];
                        if (var1 == var9) {
                            this.method_644().method_1564(var1, var2, var3);
                            var1.field_178 |= 131072L;
                            var2.field_178 |= 131072L;
                            return true;
                        }
                        if (var9.method_162()) {
                            var9 = ((class_52)var9).method_286();
                        }
                        var11 |= this.method_669(var1, var9, var3);
                        if ((var9.field_178 & 131072L) != 0L) {
                            var1.field_178 |= 131072L;
                            var2.field_178 |= 131072L;
                        }
                    }
                }
                return var11;
            } else {
                if (var2.method_222()) {
                    class_146 var10 = ((class_54)var2).field_258.field_377;
                    if (var10 != null && (var10.field_675 == null || ((class_43)var10.field_675).method_222())) {
                        this.method_644().method_1564(var1, var2, var3);
                        var1.field_178 |= 131072L;
                        var2.field_178 |= 131072L;
                        return true;
                    }
                }
                if ((var2.field_178 & 256L) == 0L) {
                    ((class_54)var2).field_258.method_667();
                }
                if ((var2.field_178 & 131072L) != 0L) {
                    var1.field_178 |= 131072L;
                }
                return false;
            }
        }
    }

    // $FF: renamed from: a (h.bo) m.as
    private class_43 method_670(class_146 var1) {
        class_85 var2 = this.method_576();
        class_80 var3 = var2.field_378;
        class_43 var11;
        try {
            var3.field_363 = var1;
            var1.method_1006(this);
            var2.method_687(var1.method_1012());
            this.field_377 = var1;
            class_43 var4 = (class_43)var1.method_1016(this);
            var11 = var4;
        } catch (class_241 var9) {
            class_54 var5 = this.field_376.field_586;
            if (var5.field_253 == null) {
                var5.field_253 = class_34.field_155;
            }
            var9.method_1438(var1, this.method_645().field_455);
            throw var9;
        } finally {
            var3.field_363 = null;
            this.field_377 = null;
        }
        return var11;
    }

    // $FF: renamed from: a () n.e
    public class_248 method_644() {
        class_87 var1;
        if ((var1 = this.method_641()) == null) {
            class_248 var2 = this.method_645().field_454;
            var2.field_1065 = this.field_376;
            return var2;
        } else {
            return var1.method_644();
        }
    }

    // $FF: renamed from: a () h.bq
    public class_114 method_671() {
        return this.field_376;
    }

    public String toString() {
        return this.field_376 != null ? "--- Class Scope ---\n\n" + this.field_376.field_586.toString() : "--- Class Scope ---\n\n Binding not initialized";
    }
}
