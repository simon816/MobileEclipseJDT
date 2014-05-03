package h;

import a.class_331;
import c.class_264;
import h.class_114;
import h.class_126;
import h.class_130;
import h.class_135;
import h.class_146;
import h.class_147;
import h.class_148;
import h.class_151;
import h.class_153;
import h.class_89;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_51;
import m.class_53;
import m.class_57;
import m.class_58;
import m.class_61;
import m.class_86;

// $FF: renamed from: h.as
public class class_136 extends class_135 {

    // $FF: renamed from: a h.r
    public class_126 field_699;
    // $FF: renamed from: a h.bq
    public class_114 field_700;

    // $FF: renamed from: <init> () void
    public class_136() {
    }

    // $FF: renamed from: <init> (h.bq) void
    public class_136(class_114 var1) {
        this.field_700 = var1;
        var1.field_598 = this;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_699 != null) {
            var3 = this.field_699.method_814(var1, var2, var3);
        }
        this.method_950((class_43)(this.field_700 == null ? this.field_693.field_278.method_138() : this.field_693.field_278.method_240().method_138()), var1, var3);
        if (this.field_692 != null) {
            int var4 = 0;
            for (int var5 = this.field_692.length; var4 < var5; ++var4) {
                var3 = this.field_692[var4].method_814(var1, var2, var3);
            }
        }
        if (this.field_700 != null) {
            var3 = this.field_700.method_814(var1, var2, var3);
        }
        class_43[] var6 = this.field_693.field_277;
        if (this.field_693.field_277.length != 0) {
            var2.method_3033(var6, this, var3.method_3107(), var1);
        }
        this.method_952(var1, var3);
        this.method_953(var1, var3);
        return var3;
    }

    // $FF: renamed from: a () h.r
    public class_126 method_951() {
        return this.field_699;
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        class_43 var5 = this.field_694.field_278;
        var2.method_2343(var5);
        boolean var6 = (this.field_674 & 1024) != 0;
        if (var3 || var6) {
            var2.method_2141();
        }
        if (this.field_691 != null) {
            var2.method_2360(var4, this.field_691.field_444);
        } else {
            var2.method_2311(String.valueOf(this.field_698.field_659));
            var2.method_2188(this.field_698.field_661.field_304);
        }
        if (var5.method_160()) {
            var2.method_2201(var1, var5, this.method_951(), this);
        }
        this.method_817(this.field_693, this.field_692, var1, var2);
        if (var5.method_160()) {
            var2.method_2202(var1, var5, this);
        }
        if (this.field_695 == null) {
            var2.method_2272(this.field_694);
        } else {
            int var7 = 0;
            for (int var8 = this.field_695.field_276.length - this.field_694.field_276.length; var7 < var8; ++var7) {
                var2.method_2087();
            }
            var2.method_2272(this.field_695);
        }
        if (var3) {
            var2.method_2182(this.field_674);
        } else if (var6) {
            var2.method_2182(this.field_674);
            switch (this.method_923(var1).field_177) {
                case 7:
                case 8:
                    var2.method_2353();
                    break;
                default:
                    var2.method_2352();
            }
        }
        var2.method_2360(var4, this.field_444);
        if (this.field_700 != null) {
            this.field_700.method_818(var1, var2);
        }
    }

    // $FF: renamed from: e_ () boolean
    public boolean method_1() {
        return this.field_700 != null;
    }

    // $FF: renamed from: a (m.v, l.g) void
    public void method_952(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            class_43 var3 = (class_43)this.field_693.field_278.method_138();
            if (var3.method_160() && var1.method_585().method_158()) {
                if (var3.method_158()) {
                    ((class_57)var3).method_334(var1, this.field_699 != null);
                } else {
                    var1.method_717(var3, this.field_699 != null);
                }
            }
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        if (this.field_699 != null) {
            this.field_699.method_924(0, var2).append('.');
        }
        super.method_924(0, var2);
        if (this.field_700 != null) {
            this.field_700.method_757(var1, var2);
        }
        return var2;
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        if (this.field_700 == null && this.field_699 == null) {
            return super.method_925(var1);
        } else {
            this.field_672 = class_331.field_1896;
            class_40 var2 = null;
            Object var3 = null;
            boolean var4 = false;
            boolean var5 = false;
            boolean var6 = false;
            int var9;
            if (this.field_699 != null) {
                if (this.field_699 instanceof class_130) {
                    this.field_699.field_446 |= 32;
                    var5 = true;
                }
                if ((var2 = this.field_699.method_925(var1)) == null) {
                    var4 = true;
                } else if (!var2.method_148() && !var2.method_147()) {
                    if (this.field_691 instanceof class_151) {
                        var1.method_644().method_1598((class_151)this.field_691);
                        var4 = true;
                    } else {
                        var3 = ((class_147)this.field_691).method_1023(var1, (class_43)var2);
                        if (var3 != null && var5) {
                            class_130.method_935(var1, this.field_699, var2, (class_40)var3);
                        }
                    }
                } else {
                    var1.method_644().method_1595(var2, this.field_699);
                    var4 = true;
                }
            } else if (this.field_691 == null) {
                var3 = var1.method_585();
            } else {
                var3 = this.field_691.method_1017(var1, true);
                if (var3 != null && ((class_40)var3).method_101() && this.field_691 instanceof class_153) {
                    class_43 var7 = (class_43)var3;
                    label287:
                    while ((var7.field_199 & 8) == 0 && !var7.method_166()) {
                        if ((var7 = var7.method_137()) == null) {
                            class_153 var8 = (class_153)this.field_691;
                            var9 = var8.field_735.length - 2;
                            while (true) {
                                if (var9 < 0) {
                                    break label287;
                                }
                                if (var8.field_735[var9] != null) {
                                    var1.method_644().method_1596(this.field_691, (class_40)var3);
                                    break label287;
                                }
                                --var9;
                            }
                        }
                    }
                }
            }
            if (var3 == null || !((class_40)var3).method_101()) {
                var4 = true;
            }
            if (this.field_696 != null) {
                int var14 = this.field_696.length;
                boolean var15 = var1.method_577().field_1928 < 3211264L;
                this.field_697 = new class_40[var14];
                for (var9 = 0; var9 < var14; ++var9) {
                    class_146 var10 = this.field_696[var9];
                    if ((this.field_697[var9] = var10.method_1017(var1, true)) == null) {
                        var15 = true;
                    }
                    if (var15 && var10 instanceof class_148) {
                        var1.method_644().method_1599(var10);
                    }
                }
                if (var15) {
                    if (this.field_692 != null) {
                        var9 = 0;
                        for (int var20 = this.field_692.length; var9 < var20; ++var9) {
                            this.field_692[var9].method_925(var1);
                        }
                    }
                    return null;
                }
            }
            class_40[] var13 = class_34.field_150;
            if (this.field_692 != null) {
                int var16 = this.field_692.length;
                var13 = new class_40[var16];
                for (var9 = 0; var9 < var16; ++var9) {
                    class_126 var22 = this.field_692[var9];
                    if (var22 instanceof class_130) {
                        var22.field_446 |= 32;
                        var6 = true;
                    }
                    if ((var13[var9] = var22.method_925(var1)) == null) {
                        var4 = true;
                    }
                }
            }
            class_43 var17;
            if (!var4) {
                class_43 var19;
                if (this.field_700 == null) {
                    if (!((class_40)var3).method_129()) {
                        var1.method_644().method_1498(this.field_691, (class_40)var3);
                        return (class_40)(this.field_675 = (class_40)var3);
                    } else {
                        var17 = (class_43)var3;
                        if ((this.field_693 = var1.method_599(var17, var13, this)).method_101()) {
                            if (this.method_753(this.field_693, var1, true)) {
                                var1.method_644().method_1515(this.field_693, this);
                            }
                            method_749(var1, (class_126)null, var17, this.field_693, this.field_692, var13, var6, this);
                            if (this.field_696 != null && this.field_693.method_376().field_279 == class_34.field_157) {
                                var1.method_644().method_1795(this.field_693, this.field_697, this.field_696);
                            }
                            if ((this.field_693.field_281 & 128L) != 0L) {
                                var1.method_644().method_1682(this, this.field_693);
                            }
                            var19 = this.field_693.field_278.method_137();
                            if (var19 != var2) {
                                var1.method_576().method_692(var19, var2);
                            }
                            if (!var2.method_152(var19) && !var1.method_624(var2, var19)) {
                                var1.method_644().method_1777(var2, var19, this.field_699, (class_89)null);
                                return (class_40)(this.field_675 = (class_40)var3);
                            } else {
                                this.field_699.method_911(var1, var19, var2);
                                return (class_40)(this.field_675 = (class_40)var3);
                            }
                        } else {
                            if (this.field_693.field_278 == null) {
                                this.field_693.field_278 = var17;
                            }
                            if (this.field_691 != null && !this.field_691.field_675.method_101()) {
                                return null;
                            } else {
                                var1.method_644().method_1624(this, this.field_693);
                                return (class_40)(this.field_675 = (class_40)var3);
                            }
                        }
                    }
                } else {
                    var17 = (class_43)var3;
                    if (var17.method_169()) {
                        class_51 var10000 = new class_51(new char[][] {var17.method_179()}, var17, 9);
                        class_51 var21 = var10000;
                        var1.method_644().method_1639(this, var21);
                        return null;
                    } else if (this.field_691 != null && var17.method_153()) {
                        var1.method_644().method_1498(this.field_691, var17);
                        return this.field_675 = var17;
                    } else {
                        var19 = var17.method_157() ? var1.method_609() : var17;
                        var1.method_702(this.field_700, var17);
                        this.field_700.method_821(var1);
                        this.field_675 = this.field_700.field_586;
                        if ((this.field_675.field_178 & 131072L) != 0L) {
                            return null;
                        } else {
                            class_58 var18 = var1.method_599(var19, var13, this);
                            if (!var18.method_101()) {
                                if (var18.field_278 == null) {
                                    var18.field_278 = var19;
                                }
                                if (this.field_691 != null && !this.field_691.field_675.method_101()) {
                                    return null;
                                } else {
                                    var1.method_644().method_1624(this, var18);
                                    return this.field_675;
                                }
                            } else {
                                if ((var18.field_281 & 128L) != 0L) {
                                    var1.method_644().method_1682(this, var18);
                                }
                                if (this.field_699 != null) {
                                    class_43 var24 = var18.field_278.method_137();
                                    if (var24 == null) {
                                        var1.method_644().method_1792(this.field_699, var17);
                                        return this.field_675;
                                    }
                                    if (!var2.method_152(var24) && !var1.method_624(var2, var24)) {
                                        var1.method_644().method_1777(var2, var24, this.field_699, (class_89)null);
                                        return this.field_675;
                                    }
                                    this.field_699.method_911(var1, var24, var2);
                                }
                                if (this.field_692 != null) {
                                    method_749(var1, (class_126)null, var19, var18, this.field_692, var13, var6, this);
                                }
                                if (this.field_696 != null && var18.method_376().field_279 == class_34.field_157) {
                                    var1.method_644().method_1795(var18, this.field_697, this.field_696);
                                }
                                this.field_693 = this.field_700.method_852(var18);
                                return this.field_675;
                            }
                        }
                    }
                }
            } else {
                if (var3 instanceof class_43) {
                    var17 = (class_43)var3;
                    if (!((class_40)var3).method_101()) {
                        return null;
                    }
                    var9 = this.field_692 == null ? 0 : this.field_692.length;
                    class_40[] var23 = new class_40[var9];
                    int var11 = var9;
                    while (true) {
                        --var11;
                        if (var11 < 0) {
                            this.field_693 = var1.method_592(var17, class_17.field_135, var23, this);
                            if (this.field_693 != null && !this.field_693.method_101()) {
                                Object var25 = ((class_61)this.field_693).field_291;
                                if (var25 != null) {
                                    if (((class_58)var25).method_376().field_279 != class_34.field_157) {
                                        var25 = var1.method_586().method_498(((class_58)var25).method_376(), (class_53)null);
                                    }
                                    this.field_693 = (class_58)var25;
                                    class_58 var12 = ((class_58)var25).method_376();
                                    if ((var12.method_367() || var12.field_278.method_158()) && !var1.method_626(var12)) {
                                        var12.field_273 |= 134217728;
                                    }
                                }
                            }
                            if (this.field_700 != null) {
                                var1.method_702(this.field_700, var17);
                                this.field_700.method_821(var1);
                                return this.field_675 = this.field_700.field_586;
                            }
                            break;
                        }
                        var23[var11] = (class_40)(var13[var11] == null ? class_40.field_187 : var13[var11]);
                    }
                }
                return (class_40)(this.field_675 = (class_40)var3);
            }
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2047(this, var2)) {
            if (this.field_699 != null) {
                this.field_699.method_763(var1, var2);
            }
            int var3;
            int var4;
            if (this.field_696 != null) {
                var3 = 0;
                for (var4 = this.field_696.length; var3 < var4; ++var3) {
                    this.field_696[var3].method_763(var1, var2);
                }
            }
            if (this.field_691 != null) {
                this.field_691.method_763(var1, var2);
            }
            if (this.field_692 != null) {
                var3 = this.field_692.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_692[var4].method_763(var1, var2);
                }
            }
            if (this.field_700 != null) {
                this.field_700.method_763(var1, var2);
            }
        }
        var1.method_1962(this, var2);
    }
}
