package h;

import a.class_331;
import c.class_264;
import h.class_121;
import h.class_126;
import h.class_130;
import h.class_146;
import h.class_148;
import h.class_153;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_0;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_53;
import m.class_54;
import m.class_55;
import m.class_57;
import m.class_58;
import m.class_61;
import m.class_65;
import m.class_66;
import m.class_86;

// $FF: renamed from: h.ck
public class class_135 extends class_126 implements class_0 {

    // $FF: renamed from: a h.bo
    public class_146 field_691;
    // $FF: renamed from: a h.r[]
    public class_126[] field_692;
    // $FF: renamed from: a m.ae
    public class_58 field_693;
    // $FF: renamed from: b m.ae
    protected class_58 field_694;
    // $FF: renamed from: c m.ae
    class_58 field_695;
    // $FF: renamed from: a h.bo[]
    public class_146[] field_696;
    // $FF: renamed from: a m.s[]
    public class_40[] field_697;
    // $FF: renamed from: a h.m
    public class_121 field_698;

    // $FF: renamed from: <init> () void
    public class_135() {
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.method_950((class_43)this.field_693.field_278.method_138(), var1, (class_301)var3);
        if (this.field_692 != null) {
            int var4 = 0;
            for (int var5 = this.field_692.length; var4 < var5; ++var4) {
                var3 = this.field_692[var4].method_814(var1, var2, (class_301)var3).method_3109();
            }
        }
        class_43[] var6 = this.field_693.field_277;
        if (this.field_693.field_277.length != 0) {
            var2.method_3033(var6, this, ((class_301)var3).method_3107(), var1);
        }
        this.method_952(var1, (class_301)var3);
        this.method_953(var1, (class_301)var3);
        return (class_301)var3;
    }

    // $FF: renamed from: a (m.as, m.v, l.g) void
    public void method_950(class_43 var1, class_86 var2, class_301 var3) {
        if ((var1.field_178 & 52L) == 20L && !var2.method_628(var1)) {
            class_55 var4 = (class_55)var1;
            class_66[] var5 = var4.method_243();
            if (var5 != null) {
                int var6 = 0;
                for (int var7 = var5.length; var6 < var7; ++var6) {
                    class_66 var8 = var5[var6];
                    class_65 var9 = var8.field_312;
                    if (var8.field_312 != null && var9.field_309 != null && !var3.method_3083(var9)) {
                        var2.method_644().method_1789(var9, this);
                    }
                }
            }
        }
    }

    // $FF: renamed from: a () h.r
    public class_126 method_951() {
        return null;
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
    }

    // $FF: renamed from: a () m.s[]
    public class_40[] method_0() {
        return this.field_697;
    }

    // $FF: renamed from: e_ () boolean
    public boolean method_1() {
        return false;
    }

    // $FF: renamed from: a (m.v, l.g) void
    public void method_952(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            class_43 var3 = (class_43)this.field_693.field_278.method_138();
            if (var3.method_160() && var1.method_585().method_158()) {
                if (var3.method_158()) {
                    ((class_57)var3).method_334(var1, false);
                } else {
                    var1.method_717(var3, false);
                }
            }
        }
    }

    // $FF: renamed from: b (m.v, l.g) void
    public void method_953(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            this.field_694 = this.field_693.method_376();
            if (this.field_694.method_367()) {
                class_54 var10000 = var1.method_585();
                class_43 var3 = this.field_694.field_278;
                if (var10000 != this.field_694.field_278) {
                    if ((var3.field_178 & 16L) != 0L && var1.method_577().field_1927 >= 3145728L) {
                        this.field_694.field_281 |= 1024L;
                    } else {
                        this.field_695 = ((class_54)var3).method_302(this.field_694, this.method_1());
                        var1.method_644().method_1691(this.field_694, this);
                    }
                }
            }
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        if (this.field_691 != null) {
            var2.append("new ");
        }
        int var3;
        if (this.field_696 != null) {
            var2.append('<');
            var3 = this.field_696.length - 1;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.field_696[var4].method_757(0, var2);
                var2.append(", ");
            }
            this.field_696[var3].method_757(0, var2);
            var2.append('>');
        }
        if (this.field_691 != null) {
            this.field_691.method_924(0, var2);
        }
        var2.append('(');
        if (this.field_692 != null) {
            for (var3 = 0; var3 < this.field_692.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_692[var3].method_924(0, var2);
            }
        }
        return var2.append(')');
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        int var4;
        if (this.field_691 == null) {
            this.field_675 = var1.method_584();
        } else {
            this.field_675 = this.field_691.method_1017(var1, true);
            if (this.field_691 instanceof class_153) {
                class_43 var2 = (class_43)this.field_675;
                if (var2 == null) {
                    return var2;
                }
                label175:
                while ((var2.field_199 & 8) == 0 && !var2.method_166()) {
                    if ((var2 = var2.method_137()) == null) {
                        class_153 var3 = (class_153)this.field_691;
                        var4 = var3.field_735.length - 2;
                        while (true) {
                            if (var4 < 0) {
                                break label175;
                            }
                            if (var3.field_735[var4] != null) {
                                var1.method_644().method_1596(this.field_691, this.field_675);
                                break label175;
                            }
                            --var4;
                        }
                    }
                }
            }
        }
        int var14;
        if (this.field_696 != null) {
            int var9 = this.field_696.length;
            boolean var11 = var1.method_577().field_1928 < 3211264L;
            this.field_697 = new class_40[var9];
            for (var4 = 0; var4 < var9; ++var4) {
                class_146 var5 = this.field_696[var4];
                if ((this.field_697[var4] = var5.method_1017(var1, true)) == null) {
                    var11 = true;
                }
                if (var11 && var5 instanceof class_148) {
                    var1.method_644().method_1599(var5);
                }
            }
            if (var11) {
                if (this.field_692 != null) {
                    var4 = 0;
                    for (var14 = this.field_692.length; var4 < var14; ++var4) {
                        this.field_692[var4].method_925(var1);
                    }
                }
                return null;
            }
        }
        boolean var10 = false;
        class_40[] var12 = class_34.field_150;
        if (this.field_692 != null) {
            boolean var13 = false;
            var14 = this.field_692.length;
            var12 = new class_40[var14];
            for (int var6 = 0; var6 < var14; ++var6) {
                class_126 var7 = this.field_692[var6];
                if (var7 instanceof class_130) {
                    var7.field_446 |= 32;
                    var10 = true;
                }
                if ((var12[var6] = var7.method_925(var1)) == null) {
                    var13 = true;
                }
            }
            if (var13) {
                if (this.field_675 instanceof class_43) {
                    class_40[] var16 = new class_40[var14];
                    int var17 = var14;
                    while (true) {
                        --var17;
                        if (var17 < 0) {
                            this.field_693 = var1.method_592((class_43)this.field_675, class_17.field_135, var16, this);
                            if (this.field_693 != null && !this.field_693.method_101()) {
                                Object var18 = ((class_61)this.field_693).field_291;
                                if (var18 != null) {
                                    if (((class_58)var18).method_376().field_279 != class_34.field_157) {
                                        var18 = var1.method_586().method_498(((class_58)var18).method_376(), (class_53)null);
                                    }
                                    this.field_693 = (class_58)var18;
                                    class_58 var8 = ((class_58)var18).method_376();
                                    if ((var8.method_367() || var8.field_278.method_158()) && !var1.method_626(var8)) {
                                        var8.field_273 |= 134217728;
                                    }
                                }
                            }
                            break;
                        }
                        var16[var17] = (class_40)(var12[var17] == null ? class_40.field_187 : var12[var17]);
                    }
                }
                return this.field_675;
            }
        }
        if (this.field_675 != null && this.field_675.method_101()) {
            if (this.field_691 != null && !this.field_675.method_129()) {
                var1.method_644().method_1498(this.field_691, this.field_675);
                return this.field_675;
            } else {
                class_43 var15 = (class_43)this.field_675;
                if (!(this.field_693 = var1.method_599(var15, var12, this)).method_101()) {
                    if (this.field_693.field_278 == null) {
                        this.field_693.field_278 = var15;
                    }
                    if (this.field_691 != null && !this.field_691.field_675.method_101()) {
                        return null;
                    } else {
                        var1.method_644().method_1624(this, this.field_693);
                        return this.field_675;
                    }
                } else {
                    if ((this.field_693.field_281 & 128L) != 0L) {
                        var1.method_644().method_1682(this, this.field_693);
                    }
                    if (this.method_753(this.field_693, var1, true)) {
                        var1.method_644().method_1515(this.field_693, this);
                    }
                    method_749(var1, (class_126)null, var15, this.field_693, this.field_692, var12, var10, this);
                    if (this.field_696 != null && this.field_693.method_376().field_279 == class_34.field_157) {
                        var1.method_644().method_1795(this.field_693, this.field_697, this.field_696);
                    }
                    return var15;
                }
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: a (m.as) void
    public void method_4(class_43 var1) {}

    // $FF: renamed from: a (int) void
    public void method_2(int var1) {}

    // $FF: renamed from: b (int) void
    public void method_3(int var1) {}

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_1989(this, var2)) {
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
                var3 = 0;
                for (var4 = this.field_692.length; var3 < var4; ++var3) {
                    this.field_692[var3].method_763(var1, var2);
                }
            }
        }
        var1.method_1904(this, var2);
    }
}
