package h;

import a.class_331;
import a.class_341;
import b.class_233;
import c.class_264;
import h.class_126;
import h.class_130;
import h.class_131;
import h.class_132;
import h.class_154;
import h.class_157;
import h.class_159;
import h.class_160;
import h.class_161;
import h.class_180;
import i.class_268;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_0;
import m.class_40;
import m.class_43;
import m.class_51;
import m.class_54;
import m.class_58;
import m.class_67;
import m.class_83;
import m.class_86;
import m.class_87;
import n.class_248;

// $FF: renamed from: h.n
public class class_155 extends class_154 implements class_0 {

    // $FF: renamed from: a h.r
    public class_126 field_736;
    // $FF: renamed from: a char[]
    public char[] field_737;
    // $FF: renamed from: a m.k
    public class_67 field_738;
    // $FF: renamed from: b m.k
    protected class_67 field_739;
    // $FF: renamed from: a m.ae[]
    public class_58[] field_740;
    // $FF: renamed from: a long
    public long field_741;
    // $FF: renamed from: a m.s
    public class_40 field_742;
    // $FF: renamed from: b m.s
    public class_40 field_743;

    // $FF: renamed from: <init> (char[], long) void
    public class_155(char[] var1, long var2) {
        this.field_737 = var1;
        this.field_741 = var2;
        this.field_444 = (int)(var2 >>> 32);
        this.field_445 = (int)(var2 & 4294967295L);
        this.field_446 |= 1;
    }

    // $FF: renamed from: a (m.v, l.j, l.g, h.cb, boolean) l.g
    public class_301 method_1035(class_86 var1, class_293 var2, class_301 var3, class_131 var4, boolean var5) {
        if (var5) {
            if (this.field_738.method_408() && this.field_736.method_755() && var1.method_716(this.field_738) && !var3.method_3082(this.field_738)) {
                var1.method_644().method_1788(this.field_738, this);
            }
            this.method_1042(var1, var3, true);
        }
        class_303 var6 = this.field_736.method_907(var1, var2, var3, !this.field_738.method_431()).method_3109();
        if (var4.field_688 != null) {
            var6 = var4.field_688.method_814(var1, var2, var6).method_3109();
        }
        this.method_1042(var1, var6, false);
        if (this.field_738.method_409()) {
            if (this.field_738.method_408() && !var5 && this.field_736.method_755() && !(this.field_736 instanceof class_159) && (this.field_736.field_446 & 534773760) == 0 && var1.method_706(this.field_738)) {
                if (var6.method_3087(this.field_738)) {
                    var1.method_644().method_1527(this.field_738, this);
                } else {
                    var2.method_3049(this.field_738, this, var6);
                }
                var6.method_3096(this.field_738);
            } else {
                var1.method_644().method_1491(this.field_738, this);
            }
        }
        return var6;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return this.method_907(var1, var2, var3, true);
    }

    // $FF: renamed from: a (m.v, l.j, l.g, boolean) l.g
    public class_301 method_907(class_86 var1, class_293 var2, class_301 var3, boolean var4) {
        boolean var5 = !this.field_738.method_431();
        this.field_736.method_907(var1, var2, var3, var5);
        if (var5) {
            this.field_736.method_909(var1, var2, var3);
        }
        if (var4 || var1.method_577().field_1927 >= 3145728L) {
            this.method_1042(var1, var3, true);
        }
        return var3;
    }

    // $FF: renamed from: a (m.bb, m.s, m.s) void
    public void method_911(class_83 var1, class_40 var2, class_40 var3) {
        if (var2 != null && var3 != null) {
            if (this.field_738 != null && this.field_738.method_101()) {
                class_67 var4 = this.field_738.method_435();
                class_40 var5 = var4.field_301;
                if (var4 != this.field_738 && var5 != this.field_738.field_301 && var2.field_177 != 1 && (var5.field_178 & 536870912L) != 0L) {
                    class_40 var6 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    this.field_743 = var4.field_301.method_141(var6);
                    if (this.field_743 instanceof class_43) {
                        class_43 var7 = (class_43)this.field_743;
                        if (!var7.method_196(var1)) {
                            class_248 var10000 = var1.method_644();
                            class_51 var10002 = new class_51(class_233.method_1385('.', var7.method_104()), var7, 2);
                            var10000.method_1639(this, var10002);
                        }
                    }
                }
            }
            super.method_911(var1, var2, var3);
        }
    }

    // $FF: renamed from: a () m.k
    public class_67 method_1036() {
        return this.field_738;
    }

    // $FF: renamed from: a (m.v, i.o, h.cb, boolean) void
    public void method_1038(class_86 var1, class_268 var2, class_131 var3, boolean var4) {
        int var5 = var2.field_1208;
        this.field_736.method_912(var1, var2, !this.field_739.method_431());
        var2.method_2360(var5, this.field_444);
        var3.field_688.method_912(var1, var2, true);
        this.method_1037(var2, this.field_739, this.field_740 == null ? null : this.field_740[1], var4);
        if (var4) {
            var2.method_2182(var3.field_674);
        }
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_672 != class_331.field_1896) {
            if (var3) {
                var2.method_2179(this.field_672, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            boolean var5 = this.field_739.method_431();
            boolean var6 = this.field_736 instanceof class_157;
            class_331 var7 = this.field_739.method_407();
            if (var7 != class_331.field_1896) {
                if (!var6) {
                    this.field_736.method_912(var1, var2, !var5);
                    if (!var5) {
                        var2.method_2271();
                        var2.method_2352();
                    }
                }
                if (var3) {
                    var2.method_2179(var7, this.field_674);
                }
                var2.method_2360(var4, this.field_444);
            } else {
                if (!var3 && (var6 || var1.method_577().field_1927 < 3145728L) && (this.field_674 & 1024) == 0 && this.field_743 == null) {
                    if (var6) {
                        if (var5 && this.field_738.method_435().field_314 != this.field_742.method_138()) {
                            class_58 var9 = this.field_740 == null ? null : this.field_740[0];
                            if (var9 == null) {
                                var2.method_2207(this.field_739);
                            } else {
                                var2.method_2273(var9);
                            }
                            switch (this.field_739.field_301.field_177) {
                                case 7:
                                case 8:
                                    var2.method_2353();
                                    break;
                                default:
                                    var2.method_2352();
                            }
                        }
                    } else {
                        this.field_736.method_912(var1, var2, !var5);
                        if (!var5) {
                            var2.method_2271();
                            var2.method_2352();
                        }
                    }
                } else {
                    this.field_736.method_912(var1, var2, !var5);
                    var4 = var2.field_1208;
                    if (this.field_739.field_314 == null) {
                        var2.method_2101();
                        if (var3) {
                            var2.method_2182(this.field_674);
                        } else {
                            var2.method_2352();
                        }
                    } else {
                        if (this.field_740 != null && this.field_740[0] != null) {
                            var2.method_2273(this.field_740[0]);
                        } else if (var5) {
                            var2.method_2207(this.field_739);
                        } else {
                            var2.method_2205(this.field_739);
                        }
                        if (this.field_743 != null) {
                            var2.method_2113(this.field_743);
                        }
                        if (var3) {
                            var2.method_2182(this.field_674);
                        } else {
                            boolean var8 = (this.field_674 & 1024) != 0;
                            if (var8) {
                                var2.method_2182(this.field_674);
                            }
                            switch (var8 ? this.method_923(var1).field_177 : this.field_739.field_301.field_177) {
                                case 7:
                                case 8:
                                    var2.method_2353();
                                    break;
                                default:
                                    var2.method_2352();
                            }
                        }
                    }
                }
                var2.method_2360(var4, this.field_445);
            }
        }
    }

    // $FF: renamed from: a (m.v, i.o, h.r, int, int, boolean) void
    public void method_1039(class_86 var1, class_268 var2, class_126 var3, int var4, int var5, boolean var6) {
        boolean var7;
        this.field_736.method_912(var1, var2, !(var7 = this.field_739.method_431()));
        if (var7) {
            if (this.field_740 != null && this.field_740[0] != null) {
                var2.method_2273(this.field_740[0]);
            } else {
                var2.method_2207(this.field_739);
            }
        } else {
            var2.method_2141();
            if (this.field_740 != null && this.field_740[0] != null) {
                var2.method_2273(this.field_740[0]);
            } else {
                var2.method_2205(this.field_739);
            }
        }
        int var8;
        switch (var8 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.method_2193(var1, (class_126)null, var3);
                break;
            default:
                if (this.field_743 != null) {
                    var2.method_2113(this.field_743);
                }
                var2.method_2182(this.field_674);
                if (var3 == class_180.field_797) {
                    var2.method_2179(var3.field_672, this.field_674);
                } else {
                    var3.method_912(var1, var2, true);
                }
                var2.method_2374(var4, var8);
                var2.method_2182(var5);
        }
        this.method_1037(var2, this.field_739, this.field_740 == null ? null : this.field_740[1], var6);
    }

    // $FF: renamed from: a (m.v, i.o, h.i, boolean) void
    public void method_1040(class_86 var1, class_268 var2, class_132 var3, boolean var4) {
        boolean var5;
        this.field_736.method_912(var1, var2, !(var5 = this.field_739.method_431()));
        if (var5) {
            if (this.field_740 != null && this.field_740[0] != null) {
                var2.method_2273(this.field_740[0]);
            } else {
                var2.method_2207(this.field_739);
            }
        } else {
            var2.method_2141();
            if (this.field_740 != null && this.field_740[0] != null) {
                var2.method_2273(this.field_740[0]);
            } else {
                var2.method_2205(this.field_739);
            }
        }
        if (var4) {
            if (var5) {
                if (this.field_739.field_301 != class_40.field_183 && this.field_739.field_301 != class_40.field_185) {
                    var2.method_2141();
                } else {
                    var2.method_2144();
                }
            } else if (this.field_739.field_301 != class_40.field_183 && this.field_739.field_301 != class_40.field_185) {
                var2.method_2142();
            } else {
                var2.method_2145();
            }
        }
        if (this.field_743 != null) {
            var2.method_2113(this.field_743);
        }
        var2.method_2182(this.field_674);
        var2.method_2179(var3.field_688.field_672, this.field_674);
        var2.method_2374(var3.field_689, this.field_674 & 15);
        var2.method_2182(var3.field_690);
        this.method_1037(var2, this.field_739, this.field_740 == null ? null : this.field_740[1], false);
    }

    // $FF: renamed from: a () m.s[]
    public class_40[] method_0() {
        return null;
    }

    // $FF: renamed from: e_ () boolean
    public boolean method_1() {
        return this.field_736.method_754();
    }

    // $FF: renamed from: a (m.v, l.g, boolean) void
    public void method_1042(class_86 var1, class_301 var2, boolean var3) {
        if ((var2.field_1783 & 1) == 0) {
            this.field_739 = this.field_738.method_435();
            if (this.field_738.method_428()) {
                if (var1.method_585() != this.field_739.field_314 && this.field_738.method_407() == class_331.field_1896) {
                    if (this.field_740 == null) {
                        this.field_740 = new class_58[2];
                    }
                    this.field_740[var3 ? 0 : 1] = ((class_54)this.field_739.field_314).method_298(this.field_739, var3);
                    var1.method_644().method_1690(this.field_739, this, var3);
                    return;
                }
            } else {
                class_54 var4;
                if (this.field_736 instanceof class_160) {
                    var4 = (class_54)((class_54)((class_160)this.field_736).field_747);
                    if (this.field_740 == null) {
                        this.field_740 = new class_58[2];
                    }
                    this.field_740[var3 ? 0 : 1] = var4.method_298(this.field_739, var3);
                    var1.method_644().method_1690(this.field_739, this, var3);
                    return;
                }
                if (this.field_738.method_429() && (this.field_446 & 8160) != 0 && this.field_738.field_314.method_143() != (var4 = var1.method_585()).method_143()) {
                    class_54 var5 = (class_54)var4.method_201((this.field_446 & 8160) >> 5);
                    if (this.field_740 == null) {
                        this.field_740 = new class_58[2];
                    }
                    this.field_740[var3 ? 0 : 1] = var5.method_298(this.field_739, var3);
                    var1.method_644().method_1690(this.field_739, this, var3);
                    return;
                }
            }
            if (this.field_738.field_314 != this.field_742 && !this.field_742.method_147() && this.field_738.field_314 != null && this.field_738.method_407() == class_331.field_1896) {
                class_341 var6 = var1.method_577();
                if (var6.field_1929 >= 3014656L && (var6.field_1927 >= 3145728L || !this.field_736.method_752() || !this.field_739.method_431()) && this.field_738.field_314.field_177 != 1 || !this.field_738.field_314.method_196(var1)) {
                    this.field_739 = var1.method_585().method_311(this.field_739, (class_43)this.field_742.method_138());
                }
            }
        }
    }

    // $FF: renamed from: a (l.g) int
    public int method_921(class_301 var1) {
        return 0;
    }

    // $FF: renamed from: a () a.k
    public class_331 method_922() {
        switch (this.field_675.field_177) {
            case 5:
            case 33:
                return this.field_672 != class_331.field_1896 ? this.field_672 : this.field_738.method_407();
            default:
                return class_331.field_1896;
        }
    }

    // $FF: renamed from: a (m.bb) m.s
    public class_40 method_923(class_83 var1) {
        Object var2 = this.field_675;
        if (this.field_743 != null) {
            var2 = this.field_743;
        }
        int var3 = (this.field_674 & 255) >> 4;
        switch (var3) {
            case 2:
                var2 = class_40.field_182;
                break;
            case 3:
                var2 = class_40.field_180;
                break;
            case 4:
                var2 = class_40.field_181;
                break;
            case 5:
                var2 = class_40.field_186;
            case 6:
            default:
                break;
            case 7:
                var2 = class_40.field_183;
                break;
            case 8:
                var2 = class_40.field_185;
                break;
            case 9:
                var2 = class_40.field_184;
                break;
            case 10:
                var2 = class_40.field_179;
        }
        if ((this.field_674 & 512) != 0) {
            var2 = var1.method_586().method_486((class_40)var2);
        }
        return (class_40)var2;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        return this.field_736.method_924(0, var2).append('.').append(this.field_737);
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        boolean var2 = false;
        if (this.field_736 instanceof class_130) {
            this.field_736.field_446 |= 32;
            var2 = true;
        }
        this.field_742 = this.field_736.method_925(var1);
        if (this.field_742 == null) {
            this.field_672 = class_331.field_1896;
            return null;
        } else {
            if (var2 && ((class_130)this.field_736).field_684.field_675 == this.field_742) {
                var1.method_644().method_1790((class_130)this.field_736);
            }
            class_67 var3 = this.field_739 = this.field_738 = var1.method_601(this.field_742, this.field_737, this);
            if (!var3.method_101()) {
                this.field_672 = class_331.field_1896;
                if (this.field_736.field_675 instanceof class_51) {
                    return null;
                } else {
                    var1.method_644().method_1628(this, this.field_742);
                    return null;
                }
            } else {
                class_40 var4 = this.field_742.method_138();
                if (var4 instanceof class_43 && var4.method_140(var3.field_314) == null) {
                    this.field_742 = var3.field_314;
                }
                this.field_736.method_911(var1, this.field_742, this.field_742);
                if (this.method_751(var3, var1, (this.field_446 & 8192) != 0)) {
                    var1.method_644().method_1514(var3, this);
                }
                boolean var5 = this.field_736.method_752();
                this.field_672 = var5 ? var3.method_407() : class_331.field_1896;
                if (var3.method_431()) {
                    if (!var5 && (!(this.field_736 instanceof class_161) || (((class_161)this.field_736).field_446 & 4) == 0)) {
                        var1.method_644().method_1703(this, var3);
                    }
                    class_43 var6 = this.field_738.field_314;
                    if (!var5 && var6 != this.field_742 && var6.method_196(var1)) {
                        var1.method_644().method_1612(this, var3);
                    }
                    if (var6.method_153()) {
                        class_87 var7 = var1.method_635();
                        class_54 var8 = var1.method_585();
                        if (this.field_672 == class_331.field_1896 && !var7.field_404 && (var8 == var6 || var8.field_252 == var6) && var7.method_728()) {
                            var1.method_644().method_1543(this.field_738, this);
                        }
                    }
                }
                class_40 var9 = var3.field_301;
                if (var9 != null) {
                    if ((this.field_446 & 8192) == 0) {
                        var9 = var9.method_130(var1, this.field_445);
                    }
                    this.field_675 = var9;
                    if ((var9.field_178 & 128L) != 0L) {
                        var1.method_644().method_1639(this, var9);
                        return null;
                    }
                }
                return var9;
            }
        }
    }

    // $FF: renamed from: a (m.as) void
    public void method_4(class_43 var1) {}

    // $FF: renamed from: a (int) void
    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    // $FF: renamed from: b (int) void
    public void method_3(int var1) {}

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2022(this, var2)) {
            this.field_736.method_763(var1, var2);
        }
        var1.method_1937(this, var2);
    }
}
