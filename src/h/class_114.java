package h;

import a.class_33;
import b.class_233;
import b.class_235;
import c.class_264;
import c.class_284;
import c.class_288;
import f.class_226;
import h.class_121;
import h.class_122;
import h.class_123;
import h.class_125;
import h.class_126;
import h.class_136;
import h.class_146;
import h.class_158;
import h.class_162;
import h.class_164;
import h.class_90;
import h.class_93;
import h.class_94;
import h.class_95;
import h.class_96;
import h.class_98;
import i.class_268;
import j.class_278;
import l.class_293;
import l.class_299;
import l.class_301;
import l.class_303;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_46;
import m.class_54;
import m.class_55;
import m.class_57;
import m.class_58;
import m.class_66;
import m.class_67;
import m.class_84;
import m.class_85;
import m.class_86;
import m.class_87;
import n.class_241;
import n.class_242;
import n.class_243;
import n.class_244;
import n.class_248;

// $FF: renamed from: h.bq
public class class_114 extends class_98 implements class_33 {

    // $FF: renamed from: a int
    public int field_577;
    // $FF: renamed from: b int
    public int field_578;
    // $FF: renamed from: a h.cn[]
    public class_164[] field_579;
    // $FF: renamed from: a char[]
    public char[] field_580;
    // $FF: renamed from: a h.bo
    public class_146 field_581;
    // $FF: renamed from: a h.bo[]
    public class_146[] field_582;
    // $FF: renamed from: a h.m[]
    public class_121[] field_583;
    // $FF: renamed from: a h.ci[]
    public class_93[] field_584;
    // $FF: renamed from: a h.bq[]
    public class_114[] field_585;
    // $FF: renamed from: a m.az
    public class_54 field_586;
    // $FF: renamed from: a m.f
    public class_84 field_587;
    // $FF: renamed from: a m.aj
    public class_87 field_588;
    // $FF: renamed from: b m.aj
    public class_87 field_589;
    // $FF: renamed from: a boolean
    public boolean field_590;
    // $FF: renamed from: c int
    public int field_591;
    // $FF: renamed from: d int
    public int field_592;
    // $FF: renamed from: e int
    public int field_593;
    // $FF: renamed from: f int
    public int field_594;
    // $FF: renamed from: g int
    public int field_595;
    // $FF: renamed from: a c.h
    public class_284 field_596;
    // $FF: renamed from: a h.ae[]
    public class_96[] field_597;
    // $FF: renamed from: a h.as
    public class_136 field_598;
    // $FF: renamed from: a h.bq
    public class_114 field_599;
    // $FF: renamed from: a m.k
    public class_67 field_600;
    // $FF: renamed from: a h.br[]
    public class_123[] field_601;

    // $FF: renamed from: <init> (c.h) void
    public class_114(class_284 var1) {
        this.field_577 = 0;
        this.field_590 = false;
        this.field_596 = var1;
    }

    // $FF: renamed from: a (int, b.e) void
    public void method_93(int var1, class_235 var2) {
        switch (var1) {
            case 2:
                class_241 var5 = new class_241(this.field_596, var2);
                throw var5;
            case 4:
                class_242 var4 = new class_242(this.field_596, var2);
                throw var4;
            case 16:
                class_244 var10000 = new class_244(this.field_596, var2);
                throw var10000;
            default:
                class_243 var3 = new class_243(this.field_596, var2);
                throw var3;
        }
    }

    // $FF: renamed from: b () void
    public final void method_845() {
        if (this.method_862()) {
            class_93[] var2 = this.field_584;
            if (this.field_584 == null) {
                boolean var1 = false;
                var2 = new class_93[1];
            } else {
                int var4 = var2.length;
                System.arraycopy(var2, 0, var2 = new class_93[var4 + 1], 1, var4);
            }
            class_95 var10000 = new class_95(this.field_596);
            class_95 var3 = var10000;
            var2[0] = var3;
            var3.field_480 = var3.field_444 = this.field_444;
            var3.field_481 = var3.field_445 = this.field_445;
            var3.field_491 = this.field_445;
            this.field_584 = var2;
        }
    }

    // $FF: renamed from: a (m.ae) h.ae
    public class_96 method_846(class_58 var1) {
        class_40[] var2 = var1.field_276;
        int var3 = var2.length;
        class_96 var10000 = new class_96(this.field_596);
        class_96 var4 = var10000;
        var4.field_479 = var1.field_274;
        var4.field_444 = this.field_444;
        var4.field_445 = this.field_445;
        var4.field_482 = var1.method_352() & -1025;
        if (var3 > 0) {
            String var5 = "arg";
            class_125[] var6 = var4.field_484 = new class_125[var3];
            int var7 = var3;
            while (true) {
                --var7;
                if (var7 < 0) {
                    break;
                }
                class_125 var10002 = new class_125((var5 + var7).toCharArray(), 0L, (class_146)null, 0);
                var6[var7] = var10002;
            }
        }
        if (this.field_597 == null) {
            this.field_597 = new class_96[] {var4};
        } else {
            class_96[] var9;
            System.arraycopy(this.field_597, 0, var9 = new class_96[this.field_597.length + 1], 1, this.field_597.length);
            var9[0] = var4;
            this.field_597 = var9;
        }
        class_58 var10001 = new class_58(var4.field_482 | 4096, var1.field_274, var1.field_275, var3 == 0 ? class_34.field_150 : var2, var1.field_277, this.field_586);
        var4.field_488 = var10001;
        class_87 var8 = new class_87(this.field_587, var4, true);
        var4.field_478 = var8;
        var4.method_787();
        return var4;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_590) {
            return var3;
        } else {
            try {
                if ((var3.field_1783 & 1) == 0) {
                    this.field_446 |= Integer.MIN_VALUE;
                    class_57 var4 = (class_57)this.field_586;
                    var4.method_338(var1.method_576().method_677(var4));
                }
                this.method_860(var1, var3);
                this.method_870();
                this.method_858(var2, var3);
            } catch (class_243 var5) {
                this.field_590 = true;
            }
            return var3;
        }
    }

    // $FF: renamed from: a (m.f) void
    public void method_847(class_84 var1) {
        if (!this.field_590) {
            try {
                this.method_870();
                this.method_858((class_293)null, class_301.method_3079(this.field_591));
            } catch (class_243 var3) {
                this.field_590 = true;
            }
        }
    }

    // $FF: renamed from: a (m.f, l.j, l.g) void
    public void method_848(class_84 var1, class_293 var2, class_301 var3) {
        if (!this.field_590) {
            try {
                if ((var3.field_1783 & 1) == 0) {
                    this.field_446 |= Integer.MIN_VALUE;
                    class_57 var4 = (class_57)this.field_586;
                    var4.method_338(var1.method_576().method_677(var4));
                }
                this.method_861(var1, var3);
                this.method_870();
                this.method_858(var2, var3);
            } catch (class_243 var5) {
                this.field_590 = true;
            }
        }
    }

    // $FF: renamed from: a (m.e) void
    public void method_849(class_85 var1) {
        if (!this.field_590) {
            try {
                this.method_858((class_293)null, class_301.method_3079(this.field_591));
            } catch (class_243 var3) {
                this.field_590 = true;
            }
        }
    }

    // $FF: renamed from: a (j.r) boolean
    public boolean method_850(class_278 var1) {
        boolean var2 = false;
        if (this.field_584 != null) {
            int var3 = this.field_584.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    break;
                }
                class_93 var4;
                if ((var4 = this.field_584[var3]).method_795()) {
                    if (!class_233.method_1364(var4.field_479, this.field_580)) {
                        class_94 var5 = (class_94)var4;
                        if (var5.field_493 == null || var5.field_493.method_831()) {
                            class_96 var6 = var1.method_2821(var5, this.field_596);
                            this.field_584[var3] = var6;
                        }
                    } else {
                        switch (method_859(this.field_577)) {
                            case 2:
                                var1.method_2862().method_1620((class_94)var4);
                                break;
                            case 4:
                                var1.method_2862().method_1470((class_94)var4);
                        }
                        var2 = true;
                    }
                }
            }
        }
        return var2;
    }

    // $FF: renamed from: a () c.h
    public class_284 method_94() {
        return this.field_596;
    }

    // $FF: renamed from: a (boolean, boolean) h.g
    public class_94 method_851(boolean var1, boolean var2) {
        class_94 var10000 = new class_94(this.field_596);
        class_94 var3 = var10000;
        var3.field_446 |= 128;
        var3.field_479 = this.field_580;
        var3.field_482 = this.field_577 & 7;
        var3.field_480 = var3.field_444 = this.field_444;
        var3.field_481 = var3.field_445 = var3.field_491 = this.field_445;
        if (var1) {
            var3.field_493 = class_158.method_1047();
            var3.field_493.field_444 = this.field_444;
            var3.field_493.field_445 = this.field_445;
        }
        if (var2) {
            if (this.field_584 == null) {
                this.field_584 = new class_93[] {var3};
            } else {
                class_93[] var4;
                System.arraycopy(this.field_584, 0, var4 = new class_93[this.field_584.length + 1], 1, this.field_584.length);
                var4[0] = var3;
                this.field_584 = var4;
            }
        }
        return var3;
    }

    // $FF: renamed from: a (m.ae) m.ae
    public class_58 method_852(class_58 var1) {
        String var2 = "$anonymous";
        class_40[] var3 = var1.field_276;
        int var4 = var3.length;
        class_94 var10000 = new class_94(this.field_596);
        class_94 var5 = var10000;
        var5.field_479 = new char[] {'x'};
        var5.field_444 = this.field_444;
        var5.field_445 = this.field_445;
        int var6 = this.field_577 & 7;
        if (var1.method_374()) {
            var6 |= 128;
        }
        var5.field_482 = var6;
        var5.field_446 |= 128;
        int var8;
        if (var4 > 0) {
            class_125[] var7 = var5.field_484 = new class_125[var4];
            var8 = var4;
            while (true) {
                --var8;
                if (var8 < 0) {
                    break;
                }
                class_125 var10002 = new class_125((var2 + var8).toCharArray(), 0L, (class_146)null, 0);
                var7[var8] = var10002;
            }
        }
        var5.field_493 = class_158.method_1047();
        var5.field_493.field_444 = this.field_444;
        var5.field_493.field_445 = this.field_445;
        if (var4 > 0) {
            class_126[] var12 = var5.field_493.field_546 = new class_126[var4];
            var8 = var4;
            while (true) {
                --var8;
                if (var8 < 0) {
                    break;
                }
                class_162 var10 = new class_162((var2 + var8).toCharArray(), 0L);
                var12[var8] = var10;
            }
        }
        if (this.field_584 == null) {
            this.field_584 = new class_93[] {var5};
        } else {
            class_93[] var14;
            System.arraycopy(this.field_584, 0, var14 = new class_93[this.field_584.length + 1], 1, this.field_584.length);
            var14[0] = var5;
            this.field_584 = var14;
        }
        class_54 var13 = this.field_586;
        class_58 var10001 = new class_58(var5.field_482, var4 == 0 ? class_34.field_150 : var3, var1.field_277, var13);
        var5.field_488 = var10001;
        var5.field_488.field_281 |= var1.field_281 & 128L;
        var5.field_488.field_273 |= 67108864;
        class_87 var11 = new class_87(this.field_587, var5, true);
        var5.field_478 = var11;
        var5.method_787();
        var5.field_493.method_821(var5.field_478);
        class_58[] var15 = var13.method_232();
        int var9;
        System.arraycopy(var15, 0, var15 = new class_58[(var9 = var15.length) + 1], 1, var9);
        var15[0] = var5.field_488;
        ++var9;
        if (var9 > 1) {
            class_43.method_193(var15, 0, var9);
        }
        var13.method_316(var15);
        return var5.field_488;
    }

    // $FF: renamed from: a (m.k) h.m
    public class_121 method_853(class_67 var1) {
        if (var1 != null && this.field_583 != null) {
            int var2 = 0;
            for (int var3 = this.field_583.length; var2 < var3; ++var2) {
                class_121 var4;
                if ((var4 = this.field_583[var2]).field_661 == var1) {
                    return var4;
                }
            }
        }
        return null;
    }

    // $FF: renamed from: a (m.ae) h.ci
    public class_93 method_854(class_58 var1) {
        if (var1 != null && this.field_584 != null) {
            int var2 = 0;
            for (int var3 = this.field_584.length; var2 < var3; ++var2) {
                class_93 var4;
                if ((var4 = this.field_584[var2]).field_488 == var1) {
                    return var4;
                }
            }
        }
        return null;
    }

    // $FF: renamed from: a (c.d) void
    public void method_855(class_288 var1) {
        if ((this.field_446 & 8192) == 0) {
            this.field_446 |= 8192;
            if (this.field_590) {
                if (this.field_586 != null) {
                    class_288.method_2955(this, this.field_587.method_645().field_455);
                }
            } else {
                try {
                    class_288 var2 = class_288.method_2956(this.field_586);
                    var2.method_3006(this.field_586, var1, false);
                    if (this.field_586.method_159()) {
                        var2.method_3012(this.field_586);
                    } else if (this.field_586.method_158()) {
                        var1.method_3012(this.field_586);
                        var2.method_3012(this.field_586);
                    }
                    var2.method_2964();
                    int var3;
                    int var4;
                    if (this.field_585 != null) {
                        var3 = 0;
                        for (var4 = this.field_585.length; var3 < var4; ++var3) {
                            class_114 var5 = this.field_585[var3];
                            var2.method_3012(var5.field_586);
                            var5.method_856(this.field_587, var2);
                        }
                    }
                    var2.method_3017();
                    if (this.field_584 != null) {
                        var3 = 0;
                        for (var4 = this.field_584.length; var3 < var4; ++var3) {
                            this.field_584[var3].method_789(this.field_587, var2);
                        }
                    }
                    var2.method_2971();
                    if (this.field_590) {
                        class_243 var10000 = new class_243(this.field_587.method_645().field_455, (class_235)null);
                        throw var10000;
                    }
                    var2.method_2960();
                    this.field_587.method_645().field_455.method_2930(this.field_586.method_134(), var2);
                } catch (class_243 var6) {
                    if (this.field_586 == null) {
                        return;
                    }
                    class_288.method_2955(this, this.field_587.method_645().field_455);
                }
            }
        }
    }

    // $FF: renamed from: a (m.v, i.o) void
    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            if ((this.field_446 & 8192) == 0) {
                int var3 = var2.field_1208;
                if (this.field_586 != null) {
                    ((class_55)this.field_586).method_327();
                }
                this.method_855(var2.field_1189);
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    // $FF: renamed from: a (m.f, c.d) void
    public void method_856(class_84 var1, class_288 var2) {
        if ((this.field_446 & 8192) == 0) {
            if (this.field_586 != null) {
                ((class_55)this.field_586).method_327();
            }
            this.method_855(var2);
        }
    }

    // $FF: renamed from: b (m.e) void
    public void method_857(class_85 var1) {
        this.method_855((class_288)null);
    }

    // $FF: renamed from: a () boolean
    public boolean method_95() {
        return this.field_590;
    }

    // $FF: renamed from: a (l.j, l.g) void
    private void method_858(class_293 var1, class_301 var2) {
        if ((this.field_586.method_223() || (this.field_586.field_178 & 48L) == 16L) && !this.field_586.method_229() && !this.field_587.method_645().field_455.field_1692) {
            this.field_587.method_644().method_1815(this);
        }
        class_299 var10000 = new class_299((class_293)null, this, this.field_588);
        class_299 var3 = var10000;
        var10000 = new class_299((class_293)null, this, this.field_589);
        class_299 var4 = var10000;
        Object var5 = var2.method_3108();
        Object var6 = var2.method_3108();
        int var7;
        int var8;
        if (this.field_583 != null) {
            var7 = 0;
            for (var8 = this.field_583.length; var7 < var8; ++var7) {
                class_121 var9 = this.field_583[var7];
                if (var9.method_891()) {
                    if ((((class_301)var6).field_1783 & 1) != 0) {
                        var9.field_446 &= Integer.MAX_VALUE;
                    }
                    var4.field_1764 = class_34.field_152;
                    var6 = var9.method_890(this.field_589, var4, (class_301)var6);
                    if (var6 == class_301.field_1784) {
                        this.field_589.method_644().method_1618(var9);
                        var6 = class_301.method_3079(this.field_591).method_3104(1);
                    }
                } else {
                    if ((((class_301)var5).field_1783 & 1) != 0) {
                        var9.field_446 &= Integer.MAX_VALUE;
                    }
                    var3.field_1764 = class_34.field_152;
                    var5 = var9.method_890(this.field_588, var3, (class_301)var5);
                    if (var5 == class_301.field_1784) {
                        this.field_588.method_644().method_1618(var9);
                        var5 = class_301.method_3079(this.field_591).method_3104(1);
                    }
                }
            }
        }
        if (this.field_585 != null) {
            var7 = 0;
            for (var8 = this.field_585.length; var7 < var8; ++var7) {
                if (var1 != null) {
                    this.field_585[var7].method_848(this.field_587, var1, ((class_301)var5).method_3078().method_3104(var2.method_3102()));
                } else {
                    this.field_585[var7].method_847(this.field_587);
                }
            }
        }
        if (this.field_584 != null) {
            class_303 var13 = var2.method_3108();
            class_301 var12 = ((class_301)var5).method_3109().method_3115().method_3071(var13);
            int var14 = 0;
            for (int var10 = this.field_584.length; var14 < var10; ++var14) {
                class_93 var11 = this.field_584[var14];
                if (!var11.field_489) {
                    if (var11.method_797()) {
                        if (var11.method_799()) {
                            var11.method_786(this.field_587, var4, ((class_301)var6).method_3109().method_3115().method_3071(var13));
                        } else {
                            ((class_94)var11).method_808(this.field_587, var3, var12.method_3078(), var2.method_3102());
                        }
                    } else {
                        var11.method_786(this.field_587, (class_299)null, var2.method_3078());
                    }
                }
            }
        }
        if (this.field_586.method_153() && !this.field_586.method_146()) {
            this.field_600 = this.field_586.method_297();
        }
    }

    // $FF: renamed from: a (int) int
    public static final int method_859(int var0) {
        switch (var0 & 25088) {
            case 512:
                return 2;
            case 8704:
                return 4;
            case 16384:
                return 3;
            default:
                return 1;
        }
    }

    // $FF: renamed from: a (m.v, l.g) void
    public void method_860(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            class_55 var3 = (class_55)this.field_586;
            class_87 var4 = var1.method_635();
            if (!var4.field_404 && !var4.field_405) {
                var3.method_326(var3.method_137());
            }
            if (var3.method_146()) {
                class_43 var5 = (class_43)var3.field_252.method_138();
                if (var5.method_137() != null && !var5.method_226() && (!var5.method_158() || ((class_55)var5).method_310(var5.method_137(), true) != null)) {
                    var3.method_324(var5.method_137());
                }
                if (!var4.field_404 && var4.field_405 && var1.method_577().field_1927 >= 3211264L) {
                    class_43 var6 = var3.method_137();
                    if (var6.method_160()) {
                        class_55 var7 = (class_55)var6;
                        class_66 var8 = var7.method_331(var7.method_137(), true);
                        if (var8 != null) {
                            var3.method_325(var8);
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (m.f, l.g) void
    public void method_861(class_84 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            class_55 var3 = (class_55)this.field_586;
            var3.method_326(this.field_586.method_137());
        }
    }

    // $FF: renamed from: f () boolean
    public final boolean method_862() {
        if ((this.field_446 & 1) != 0) {
            return true;
        } else {
            switch (method_859(this.field_577)) {
                case 2:
                case 4:
                    return this.field_583 != null;
                case 3:
                    return true;
                default:
                    if (this.field_583 != null) {
                        int var1 = this.field_583.length;
                        while (true) {
                            --var1;
                            if (var1 < 0) {
                                break;
                            }
                            class_121 var2 = this.field_583[var1];
                            if ((var2.field_656 & 8) != 0) {
                                return true;
                            }
                        }
                    }
                    return false;
            }
        }
    }

    // $FF: renamed from: a (j.r, h.b) void
    public void method_863(class_278 var1, class_90 var2) {
        if (!var2.field_452) {
            int var3;
            int var4;
            if (this.field_585 != null) {
                var3 = this.field_585.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_585[var4].method_863(var1, var2);
                }
            }
            if (this.field_584 != null) {
                var3 = this.field_584.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_584[var4].method_800(var1, var2);
                }
            }
            if (this.field_583 != null) {
                var3 = this.field_583.length;
                var4 = 0;
                while (var4 < var3) {
                    class_121 var5 = this.field_583[var4];
                    switch (var5.method_887()) {
                        case 2:
                            ((class_122)var5).method_895(var1, this, var2);
                        default:
                            ++var4;
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_757(int var1, StringBuffer var2) {
        if ((this.field_446 & 512) == 0) {
            method_759(var1, var2);
            this.method_865(0, var2);
        }
        return this.method_864(var1, var2);
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_864(int var1, StringBuffer var2) {
        var2.append(" {");
        int var3;
        if (this.field_585 != null) {
            for (var3 = 0; var3 < this.field_585.length; ++var3) {
                if (this.field_585[var3] != null) {
                    var2.append('\n');
                    this.field_585[var3].method_757(var1 + 1, var2);
                }
            }
        }
        if (this.field_583 != null) {
            for (var3 = 0; var3 < this.field_583.length; ++var3) {
                if (this.field_583[var3] != null) {
                    var2.append('\n');
                    this.field_583[var3].method_757(var1 + 1, var2);
                }
            }
        }
        if (this.field_584 != null) {
            for (var3 = 0; var3 < this.field_584.length; ++var3) {
                if (this.field_584[var3] != null) {
                    var2.append('\n');
                    this.field_584[var3].method_757(var1 + 1, var2);
                }
            }
        }
        var2.append('\n');
        return method_759(var1, var2).append('}');
    }

    // $FF: renamed from: d (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_865(int var1, StringBuffer var2) {
        method_760(this.field_577, var2);
        if (this.field_579 != null) {
            method_758(this.field_579, var2);
        }
        switch (method_859(this.field_577)) {
            case 1:
                var2.append("class ");
                break;
            case 2:
                var2.append("interface ");
                break;
            case 3:
                var2.append("enum ");
                break;
            case 4:
                var2.append("@interface ");
        }
        var2.append(this.field_580);
        int var3;
        if (this.field_601 != null) {
            var2.append("<");
            for (var3 = 0; var3 < this.field_601.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_601[var3].method_757(0, var2);
            }
            var2.append(">");
        }
        if (this.field_581 != null) {
            var2.append(" extends ");
            this.field_581.method_757(0, var2);
        }
        if (this.field_582 != null && this.field_582.length > 0) {
            switch (method_859(this.field_577)) {
                case 1:
                case 3:
                    var2.append(" implements ");
                    break;
                case 2:
                case 4:
                    var2.append(" extends ");
            }
            for (var3 = 0; var3 < this.field_582.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_582[var3].method_757(0, var2);
            }
        }
        return var2;
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        return this.method_757(var1, var2);
    }

    // $FF: renamed from: c () void
    public void method_866() {
        class_54 var1 = this.field_586;
        if (var1 == null) {
            this.field_590 = true;
        } else {
            try {
                boolean var2 = this.field_589.field_412;
                try {
                    this.field_589.field_412 = true;
                    method_761(this.field_589, this.field_579, var1);
                } finally {
                    this.field_589.field_412 = var2;
                }
                if ((var1.method_99() & 70368744177664L) == 0L && (var1.field_199 & 1048576) != 0 && this.field_587.method_577().field_1928 >= 3211264L) {
                    this.field_587.method_644().method_1677(this);
                }
                if ((this.field_446 & 8) != 0) {
                    this.field_587.method_644().method_1783(this.field_594 - 1, this.field_595);
                }
                boolean var3 = this.field_587.method_577().method_3313(4294967296L) != -1 && var1.method_151() && var1.method_139(56, false) == null && var1.method_139(37, false) != null;
                if (var3) {
                    class_85 var4;
                    class_58 var5;
                    class_43[] var6;
                    boolean var10000;
                    label617: {
                        var4 = this.field_587.method_576();
                        var5 = var1.method_207(class_17.field_40, new class_40[0], var4);
                        if (var5 != null && var5.method_101() && var5.field_275.field_177 == 1) {
                            var6 = var5.field_277;
                            if (var5.field_277.length == 1 && var6[0].field_177 == 57) {
                                var10000 = false;
                                break label617;
                            }
                        }
                        var10000 = true;
                    }
                    var3 = var10000;
                    if (var3) {
                        boolean var7 = false;
                        boolean var8 = false;
                        class_40 var9 = this.field_587.method_618(class_17.field_133, 3);
                        if (var9.method_101()) {
                            label606: {
                                var5 = var1.method_207(class_17.field_42, new class_40[] {var9}, var4);
                                if (var5 != null && var5.method_101() && var5.field_273 == 2 && var5.field_275 == class_40.field_188) {
                                    var6 = var5.field_277;
                                    if (var5.field_277.length == 1 && var6[0].field_177 == 58) {
                                        var10000 = true;
                                        break label606;
                                    }
                                }
                                var10000 = false;
                            }
                            var7 = var10000;
                        }
                        var9 = this.field_587.method_618(class_17.field_134, 3);
                        if (var9.method_101()) {
                            label595: {
                                var5 = var1.method_207(class_17.field_41, new class_40[] {var9}, var4);
                                if (var5 != null && var5.method_101() && var5.field_273 == 2 && var5.field_275 == class_40.field_188) {
                                    var6 = var5.field_277;
                                    if (var5.field_277.length == 1 && var6[0].field_177 == 58) {
                                        var10000 = true;
                                        break label595;
                                    }
                                }
                                var10000 = false;
                            }
                            var8 = var10000;
                        }
                        var3 = !var7 || !var8;
                    }
                }
                if (var1.method_139(21, true) != null) {
                    Object var17 = var1;
                    do {
                        if (((class_43)var17).method_155()) {
                            this.field_587.method_644().method_1558(this);
                            break;
                        }
                        if (((class_43)var17).method_226()) {
                            break;
                        }
                        if (((class_43)var17).method_158()) {
                            class_55 var19 = (class_55)((class_43)var17).method_138();
                            if (var19.field_258.method_635().field_404) {
                                break;
                            }
                        }
                    } while ((var17 = ((class_43)var17).method_137()) != null);
                }
                this.field_591 = 0;
                int var18 = -1;
                boolean var20 = false;
                class_121[] var21 = null;
                int var23;
                int var22;
                if (this.field_601 != null) {
                    var22 = 0;
                    for (var23 = this.field_601.length; var22 < var23; ++var22) {
                        this.field_601[var22].method_898(this.field_587);
                    }
                }
                if (this.field_585 != null) {
                    var22 = 0;
                    for (var23 = this.field_585.length; var22 < var23; ++var22) {
                        this.field_585[var22].method_867(this.field_587);
                    }
                }
                if (this.field_583 != null) {
                    var22 = 0;
                    for (var23 = this.field_583.length; var22 < var23; ++var22) {
                        class_121 var25 = this.field_583[var22];
                        switch (var25.method_887()) {
                            case 2:
                                ((class_122)var25).field_665 = var18 + 1;
                                break;
                            case 3:
                                var20 = true;
                                if (!(var25.field_655 instanceof class_136)) {
                                    if (var21 == null) {
                                        var21 = new class_121[var23];
                                    }
                                    var21[var22] = var25;
                                }
                            case 1:
                                class_67 var10 = var25.field_661;
                                if (var10 == null) {
                                    if (var25.field_655 != null) {
                                        var25.field_655.method_821(var25.method_891() ? this.field_589 : this.field_588);
                                    }
                                    this.field_590 = true;
                                    continue;
                                }
                                if (var3 && (var10.field_300 & 24) == 24 && class_233.method_1364(class_17.field_37, var10.field_302) && class_40.field_183 == var10.field_301) {
                                    var3 = false;
                                }
                                ++this.field_591;
                                var18 = var25.field_661.field_304;
                        }
                        var25.method_892(var25.method_891() ? this.field_589 : this.field_588);
                    }
                }
                if (var3) {
                    this.field_587.method_644().method_1681(this);
                }
                int var11;
                int var27;
                switch (method_859(this.field_577)) {
                    case 3:
                        if (this.field_586.method_217()) {
                            class_93 var24;
                            if (!var20) {
                                var22 = 0;
                                for (var23 = this.field_584.length; var22 < var23; ++var22) {
                                    var24 = this.field_584[var22];
                                    if (var24.method_792() && var24.field_488 != null) {
                                        this.field_587.method_644().method_1540(var24);
                                    }
                                }
                            } else if (var21 != null) {
                                var22 = 0;
                                for (var23 = this.field_584.length; var22 < var23; ++var22) {
                                    var24 = this.field_584[var22];
                                    if (var24.method_792() && var24.field_488 != null) {
                                        var27 = 0;
                                        for (var11 = var21.length; var27 < var11; ++var27) {
                                            if (var21[var27] != null) {
                                                this.field_587.method_644().method_1541(var24, var21[var27]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        if (this.field_581 != null) {
                            this.field_587.method_644().method_1471(this);
                        }
                        if (this.field_582 != null) {
                            this.field_587.method_644().method_1472(this);
                        }
                }
                var22 = this.field_597 == null ? 0 : this.field_597.length;
                var23 = this.field_584 == null ? 0 : this.field_584.length;
                if (var23 + var22 > '\uffff') {
                    this.field_587.method_644().method_1770(this);
                }
                int var28;
                if (this.field_584 != null) {
                    var28 = 0;
                    for (var27 = this.field_584.length; var28 < var27; ++var28) {
                        this.field_584[var28].method_803(this.field_587);
                    }
                }
                if (!var1.method_158()) {
                    var28 = var1.field_199 & 7;
                    class_248 var26 = this.field_587.method_644();
                    var11 = var26.method_1449(-1610612250);
                    if (var11 != -1) {
                        if (this.field_599 != null) {
                            var28 = class_226.method_1318(this.field_599, var28);
                        }
                        int var12 = this.field_586.field_199 & -8 | var28;
                    }
                }
            } catch (class_243 var16) {
                this.field_590 = true;
            }
        }
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {
        if ((this.field_446 & 512) == 0) {
            class_40 var2 = var1.method_616(this.field_580);
            if (var2 instanceof class_43 && var2 != this.field_586 && var2.method_101()) {
                class_43 var3 = (class_43)var2;
                if (var3 instanceof class_46) {
                    var1.method_644().method_1775(this, (class_46)var3);
                } else if (var3 instanceof class_57 && ((class_57)var3).field_258.method_635() == var1.method_635()) {
                    var1.method_644().method_1534(this);
                } else if (var1.method_628(var3)) {
                    var1.method_644().method_1772(this);
                } else if (var1.method_627(var3)) {
                    var1.method_644().method_1774(this, var3);
                }
            }
            var1.method_703(this);
        }
        if (this.field_586 != null) {
            var1.method_645().method_777((class_57)this.field_586);
            this.method_866();
            this.method_870();
        }
    }

    // $FF: renamed from: b (m.f) void
    public void method_867(class_84 var1) {
        if (this.field_586 != null && this.field_586 instanceof class_57) {
            var1.method_645().method_777((class_57)this.field_586);
        }
        this.method_866();
        this.method_870();
    }

    // $FF: renamed from: c (m.e) void
    public void method_868(class_85 var1) {
        this.method_866();
        this.method_870();
    }

    // $FF: renamed from: a () void
    public void method_96() {
        this.field_590 = true;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        try {
            if (var1.method_2066(this, var2)) {
                int var3;
                int var4;
                if (this.field_579 != null) {
                    var3 = this.field_579.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_579[var4].method_763(var1, this.field_589);
                    }
                }
                if (this.field_581 != null) {
                    this.field_581.method_1021(var1, this.field_587);
                }
                if (this.field_582 != null) {
                    var3 = this.field_582.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_582[var4].method_1021(var1, this.field_587);
                    }
                }
                if (this.field_601 != null) {
                    var3 = this.field_601.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_601[var4].method_899(var1, this.field_587);
                    }
                }
                if (this.field_585 != null) {
                    var3 = this.field_585.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_585[var4].method_869(var1, this.field_587);
                    }
                }
                if (this.field_583 != null) {
                    var3 = this.field_583.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        class_121 var5;
                        if (!(var5 = this.field_583[var4]).method_891()) {
                            var5.method_893(var1, this.field_588);
                        }
                    }
                }
                if (this.field_584 != null) {
                    var3 = this.field_584.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_584[var4].method_806(var1, this.field_587);
                    }
                }
            }
            var1.method_1981(this, var2);
        } catch (class_243 var6) {
            ;
        }
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_869(class_264 var1, class_84 var2) {
        try {
            if (var1.method_2067(this, var2)) {
                int var3;
                int var4;
                if (this.field_579 != null) {
                    var3 = this.field_579.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_579[var4].method_763(var1, this.field_589);
                    }
                }
                if (this.field_581 != null) {
                    this.field_581.method_1021(var1, this.field_587);
                }
                if (this.field_582 != null) {
                    var3 = this.field_582.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_582[var4].method_1021(var1, this.field_587);
                    }
                }
                if (this.field_601 != null) {
                    var3 = this.field_601.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_601[var4].method_899(var1, this.field_587);
                    }
                }
                if (this.field_585 != null) {
                    var3 = this.field_585.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_585[var4].method_869(var1, this.field_587);
                    }
                }
                if (this.field_583 != null) {
                    var3 = this.field_583.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        class_121 var5;
                        if ((var5 = this.field_583[var4]).method_891()) {
                            var5.method_893(var1, this.field_589);
                        } else {
                            var5.method_893(var1, this.field_588);
                        }
                    }
                }
                if (this.field_584 != null) {
                    var3 = this.field_584.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.field_584[var4].method_806(var1, this.field_587);
                    }
                }
            }
            var1.method_1982(this, var2);
        } catch (class_243 var6) {
            ;
        }
    }

    // $FF: renamed from: d () void
    void method_870() {
        if (this.field_586 != null) {
            class_114 var1 = this.field_587.method_640().method_671();
            if (this.field_591 > var1.field_591) {
                var1.field_591 = this.field_591;
            } else {
                this.field_591 = var1.field_591;
            }
        }
    }
}
