package h;

import a.class_331;
import a.class_341;
import b.class_233;
import c.class_264;
import h.class_126;
import h.class_130;
import h.class_131;
import h.class_132;
import h.class_141;
import h.class_161;
import h.class_180;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_43;
import m.class_50;
import m.class_51;
import m.class_54;
import m.class_58;
import m.class_64;
import m.class_65;
import m.class_67;
import m.class_69;
import m.class_83;
import m.class_86;
import m.class_87;
import n.class_248;

// $FF: renamed from: h.ay
public class class_162 extends class_161 {

    // $FF: renamed from: a char[]
    public char[] field_751;
    // $FF: renamed from: a m.ae[]
    public class_58[] field_752;
    // $FF: renamed from: b m.s
    public class_40 field_753;

    // $FF: renamed from: <init> (char[], long) void
    public class_162(char[] var1, long var2) {
        this.field_751 = var1;
        this.field_444 = (int)(var2 >>> 32);
        this.field_445 = (int)var2;
    }

    // $FF: renamed from: a (m.v, l.j, l.g, h.cb, boolean) l.g
    public class_301 method_1035(class_86 var1, class_293 var2, class_301 var3, class_131 var4, boolean var5) {
        boolean var6 = (((class_301)var3).field_1783 & 1) == 0;
        class_67 var7;
        class_65 var8;
        if (var5) {
            switch (this.field_446 & 7) {
                case 1:
                    if ((var7 = (class_67)this.field_748).method_408() && var1.method_716(var7) && !((class_301)var3).method_3082(var7)) {
                        var1.method_644().method_1788(var7, this);
                    }
                    this.method_1054(var1, (class_301)var3, true);
                    break;
                case 2:
                    if (!((class_301)var3).method_3083(var8 = (class_65)this.field_748)) {
                        var1.method_644().method_1789(var8, this);
                    }
                    if (var6) {
                        var8.field_307 = 1;
                    } else if (var8.field_307 == 0) {
                        var8.field_307 = 2;
                    }
            }
        }
        if (var4.field_688 != null) {
            var3 = var4.field_688.method_814(var1, var2, (class_301)var3).method_3109();
        }
        switch (this.field_446 & 7) {
            case 1:
                this.method_1054(var1, (class_301)var3, false);
                var7 = (class_67)this.field_748;
                if (var7.method_409()) {
                    if (!var5 && var7.method_408() && var1.method_706(var7)) {
                        if (((class_301)var3).method_3087(var7)) {
                            var1.method_644().method_1527(var7, this);
                        } else {
                            var2.method_3049(var7, this, (class_301)var3);
                        }
                        ((class_301)var3).method_3096(var7);
                    } else {
                        var1.method_644().method_1491(var7, this);
                    }
                }
                break;
            case 2:
                var8 = (class_65)this.field_748;
                if (!((class_301)var3).method_3083(var8)) {
                    this.field_446 |= 8;
                } else {
                    this.field_446 &= -9;
                }
                if (var8.method_409()) {
                    if ((this.field_446 & 8160) == 0) {
                        if ((!var6 || !var5) && var8.method_408()) {
                            if (((class_301)var3).method_3088(var8)) {
                                var1.method_644().method_1528(var8, this);
                            } else {
                                var2.method_3049(var8, this, (class_301)var3);
                            }
                        } else {
                            var1.method_644().method_1492(var8, this);
                        }
                    } else {
                        var1.method_644().method_1493(var8, this);
                    }
                } else if ((var8.field_305 & 1024L) != 0L) {
                    var1.method_644().method_1720(var8, this);
                }
                ((class_301)var3).method_3099(var8);
        }
        this.method_1053(var1, (class_301)var3);
        return (class_301)var3;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return this.method_907(var1, var2, var3, true);
    }

    // $FF: renamed from: a (m.v, l.j, l.g, boolean) l.g
    public class_301 method_907(class_86 var1, class_293 var2, class_301 var3, boolean var4) {
        switch (this.field_446 & 7) {
            case 1:
                if (var4 || var1.method_577().field_1927 >= 3145728L) {
                    this.method_1054(var1, var3, true);
                }
                class_67 var5 = (class_67)this.field_748;
                if (var5.method_408() && var1.method_716(var5) && !var3.method_3082(var5)) {
                    var1.method_644().method_1788(var5, this);
                }
                break;
            case 2:
                class_65 var6;
                if (!var3.method_3083(var6 = (class_65)this.field_748)) {
                    var1.method_644().method_1789(var6, this);
                }
                if ((var3.field_1783 & 1) == 0) {
                    var6.field_307 = 1;
                } else if (var6.field_307 == 0) {
                    var6.field_307 = 2;
                }
        }
        if (var4) {
            this.method_1053(var1, var3);
        }
        return var3;
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1050(class_86 var1) {
        class_67 var2 = (class_67)this.field_748;
        this.field_672 = var2.method_407();
        this.field_446 &= -8;
        this.field_446 |= 1;
        class_87 var3 = var1.method_635();
        if (var2.method_431()) {
            class_43 var4 = var2.field_314;
            if (var4.method_153()) {
                class_54 var5 = var1.method_585();
                if (this.field_672 == class_331.field_1896 && !var3.field_404 && (var5 == var4 || var5.field_252 == var4) && var3.method_728()) {
                    var1.method_644().method_1543(var2, this);
                }
            }
        } else {
            if (var1.method_577().method_3313(4194304L) != -1) {
                var1.method_644().method_1796(this, var2);
            }
            if (var3.field_404) {
                var1.method_644().method_1757(this, var2);
                return var2.field_301;
            }
        }
        if (this.method_751(var2, var1, (this.field_446 & 8192) != 0)) {
            var1.method_644().method_1514(var2, this);
        }
        if ((this.field_446 & 8192) == 0 && var3.method_585() == var2.method_435().field_314 && var3.field_407 >= 0 && var2.field_304 >= var3.field_407 && (!var2.method_431() || var3.field_404)) {
            var1.method_644().method_1556(this, 0, var3.method_585());
            this.field_446 |= 536870912;
        }
        return var2.field_301;
    }

    // $FF: renamed from: a (m.bb, m.s, m.s) void
    public void method_911(class_83 var1, class_40 var2, class_40 var3) {
        if (var2 != null && var3 != null) {
            if ((this.field_446 & 1) != 0 && this.field_748 != null && this.field_748.method_101()) {
                class_67 var4 = (class_67)this.field_748;
                class_67 var5 = var4.method_435();
                class_40 var6 = var5.field_301;
                if (var5 != var4 && var6 != var4.field_301 && var2.field_177 != 1 && (var6.field_178 & 536870912L) != 0L) {
                    class_40 var7 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    this.field_753 = var6.method_141(var1.method_574(var7));
                    if (this.field_753 instanceof class_43) {
                        class_43 var8 = (class_43)this.field_753;
                        if (!var8.method_196(var1)) {
                            class_248 var10000 = var1.method_644();
                            class_51 var10002 = new class_51(class_233.method_1385('.', var8.method_104()), var8, 2);
                            var10000.method_1639(this, var10002);
                        }
                    }
                }
            }
            super.method_911(var1, var2, var3);
        }
    }

    // $FF: renamed from: a (m.v, i.o, h.cb, boolean) void
    public void method_1038(class_86 var1, class_268 var2, class_131 var3, boolean var4) {
        int var6;
        if (var3.field_688.method_918()) {
            class_141 var5 = (class_141)var3.field_688;
            var6 = (var5.field_446 & 4032) >> 6;
            class_162 var7;
            if (var5.field_715 instanceof class_162 && (var7 = (class_162)var5.field_715).field_748 == this.field_748) {
                var7.method_1051(var1, var2, this.field_752 == null ? null : this.field_752[1], var5.field_716, var6, var5.field_674, var4);
                if (var4) {
                    var2.method_2182(var3.field_674);
                }
                return;
            }
            if (var5.field_716 instanceof class_162 && (var6 == 14 || var6 == 15) && (var7 = (class_162)var5.field_716).field_748 == this.field_748 && var5.field_715.field_672 != class_331.field_1896 && (var5.field_715.field_674 & 255) >> 4 != 11 && (var5.field_716.field_674 & 255) >> 4 != 11) {
                var7.method_1051(var1, var2, this.field_752 == null ? null : this.field_752[1], var5.field_715, var6, var5.field_674, var4);
                if (var4) {
                    var2.method_2182(var3.field_674);
                }
                return;
            }
        }
        switch (this.field_446 & 7) {
            case 1:
                var6 = var2.field_1208;
                class_67 var9;
                if (!(var9 = (class_67)this.field_749).method_431()) {
                    if ((this.field_446 & 8160) != 0) {
                        class_43 var10 = var1.method_585().method_201((this.field_446 & 8160) >> 5);
                        Object[] var8 = var1.method_714(var10, true, false);
                        var2.method_2191(var8, this, var10, var1);
                    } else {
                        this.method_1052(var2);
                    }
                }
                var2.method_2360(var6, this.field_444);
                var3.field_688.method_912(var1, var2, true);
                this.method_1037(var2, var9, this.field_752 == null ? null : this.field_752[1], var4);
                if (var4) {
                    var2.method_2182(var3.field_674);
                }
                return;
            case 2:
                class_65 var11 = (class_65)this.field_749;
                if (var11.field_306 == -1) {
                    if (var3.field_688.field_672 != class_331.field_1896) {
                        if (var4) {
                            var2.method_2179(var3.field_688.field_672, var3.field_674);
                        }
                    } else {
                        var3.field_688.method_912(var1, var2, true);
                        if (var4) {
                            var2.method_2182(var3.field_674);
                        } else if (var11.field_301 != class_40.field_183 && var11.field_301 != class_40.field_185) {
                            var2.method_2352();
                        } else {
                            var2.method_2353();
                        }
                    }
                    return;
                } else {
                    var3.field_688.method_912(var1, var2, true);
                    if (var11.field_301.method_147() && (var3.field_688.field_675 == class_40.field_187 || var3.field_688 instanceof class_130 && ((class_130)var3.field_688).method_940().field_675 == class_40.field_187)) {
                        var2.method_2113(var11.field_301);
                    }
                    var2.method_2376(var11, var4);
                    if ((this.field_446 & 8) != 0) {
                        var11.method_415(var2.field_1208);
                    }
                    if (var4) {
                        var2.method_2182(var3.field_674);
                    }
                }
            default:
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
            switch (this.field_446 & 7) {
                case 1:
                    class_67 var5 = (class_67)this.field_749;
                    class_331 var6 = var5.method_407();
                    if (var6 != class_331.field_1896) {
                        if (var3) {
                            var2.method_2179(var6, this.field_674);
                        }
                        var2.method_2360(var4, this.field_444);
                        return;
                    }
                    if (var5.method_431()) {
                        if (!var3 && ((class_67)this.field_748).method_435().field_314 == this.field_750.method_138() && (this.field_674 & 1024) == 0 && this.field_753 == null) {
                            var2.method_2360(var4, this.field_444);
                            return;
                        }
                        if (this.field_752 != null && this.field_752[0] != null) {
                            var2.method_2273(this.field_752[0]);
                        } else {
                            var2.method_2207(var5);
                        }
                    } else {
                        if (!var3 && (this.field_674 & 1024) == 0 && this.field_753 == null) {
                            var2.method_2360(var4, this.field_444);
                            return;
                        }
                        if ((this.field_446 & 8160) != 0) {
                            class_43 var10 = var1.method_585().method_201((this.field_446 & 8160) >> 5);
                            Object[] var11 = var1.method_714(var10, true, false);
                            var2.method_2191(var11, this, var10, var1);
                        } else {
                            this.method_1052(var2);
                        }
                        if (this.field_752 != null && this.field_752[0] != null) {
                            var2.method_2273(this.field_752[0]);
                        } else {
                            var2.method_2205(var5);
                        }
                    }
                    break;
                case 2:
                    class_65 var7 = (class_65)this.field_749;
                    if (!var3 && (this.field_674 & 1024) == 0) {
                        var2.method_2360(var4, this.field_444);
                        return;
                    }
                    if ((this.field_446 & 8160) != 0) {
                        class_64[] var8 = var1.method_713(var7);
                        var2.method_2191(var8, this, var7, var1);
                    } else {
                        var2.method_2324(var7);
                    }
                    break;
                default:
                    var2.method_2360(var4, this.field_444);
                    return;
            }
            if (this.field_753 != null) {
                var2.method_2113(this.field_753);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            } else {
                boolean var9 = (this.field_674 & 1024) != 0;
                if (var9) {
                    var2.method_2182(this.field_674);
                }
                switch (var9 ? this.method_923(var1).field_177 : this.field_675.field_177) {
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
    }

    // $FF: renamed from: a (m.v, i.o, h.r, int, int, boolean) void
    public void method_1039(class_86 var1, class_268 var2, class_126 var3, int var4, int var5, boolean var6) {
        this.method_1051(var1, var2, this.field_752 == null ? null : this.field_752[1], var3, var4, var5, var6);
    }

    // $FF: renamed from: a (m.v, i.o, m.ae, h.r, int, int, boolean) void
    public void method_1051(class_86 var1, class_268 var2, class_58 var3, class_126 var4, int var5, int var6, boolean var7) {
        class_65 var9;
        switch (this.field_446 & 7) {
            case 1:
                class_67 var8;
                if ((var8 = (class_67)this.field_749).method_431()) {
                    if (this.field_752 != null && this.field_752[0] != null) {
                        var2.method_2273(this.field_752[0]);
                    } else {
                        var2.method_2207(var8);
                    }
                } else {
                    if ((this.field_446 & 8160) != 0) {
                        class_43 var13 = var1.method_585().method_201((this.field_446 & 8160) >> 5);
                        Object[] var14 = var1.method_714(var13, true, false);
                        var2.method_2191(var14, this, var13, var1);
                    } else {
                        var2.method_2093();
                    }
                    var2.method_2141();
                    if (this.field_752 != null && this.field_752[0] != null) {
                        var2.method_2273(this.field_752[0]);
                    } else {
                        var2.method_2205(var8);
                    }
                }
                break;
            case 2:
                var9 = (class_65)this.field_749;
                label54:
                switch (var9.field_301.field_177) {
                    case 10:
                        class_331 var10 = var4.field_672;
                        if (var4.field_672 != class_331.field_1896 && var10.method_3288() != 9 && var10.method_3288() != 8) {
                            int var11;
                            switch (var5) {
                                case 13:
                                    var11 = -var10.method_3284();
                                    if (var11 == (short)var11) {
                                        var2.method_2245(var9.field_306, var11);
                                        if (var7) {
                                            var2.method_2324(var9);
                                        }
                                        return;
                                    }
                                    break label54;
                                case 14:
                                    var11 = var10.method_3284();
                                    if (var11 == (short)var11) {
                                        var2.method_2245(var9.field_306, var11);
                                        if (var7) {
                                            var2.method_2324(var9);
                                        }
                                        return;
                                    }
                            }
                        }
                    case 11: {
                        var2.method_2193(var1, this, var4);
                        if (var7) {
                            var2.method_2141();
                        }
                        var2.method_2376(var9, false);
                        return;
                    }
                    default:
                        var2.method_2324(var9);
                }
        }
        int var12;
        switch (var12 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.method_2193(var1, (class_126)null, var4);
                break;
            default:
                if (this.field_753 != null) {
                    var2.method_2113(this.field_753);
                }
                var2.method_2182(this.field_674);
                if (var4 == class_180.field_797) {
                    var2.method_2179(var4.field_672, this.field_674);
                } else {
                    var4.method_912(var1, var2, true);
                }
                var2.method_2374(var5, var12);
                var2.method_2182(var6);
        }
        switch (this.field_446 & 7) {
            case 1:
                this.method_1037(var2, (class_67)this.field_749, var3, var7);
                return;
            case 2:
                var9 = (class_65)this.field_749;
                if (var7) {
                    if (var9.field_301 != class_40.field_183 && var9.field_301 != class_40.field_185) {
                        var2.method_2141();
                    } else {
                        var2.method_2144();
                    }
                }
                var2.method_2376(var9, false);
            default:
        }
    }

    // $FF: renamed from: a (m.v, i.o, h.i, boolean) void
    public void method_1040(class_86 var1, class_268 var2, class_132 var3, boolean var4) {
        switch (this.field_446 & 7) {
            case 1:
                class_67 var5;
                if ((var5 = (class_67)this.field_749).method_431()) {
                    if (this.field_752 != null && this.field_752[0] != null) {
                        var2.method_2273(this.field_752[0]);
                    } else {
                        var2.method_2207(var5);
                    }
                } else {
                    if ((this.field_446 & 8160) != 0) {
                        class_43 var8 = var1.method_585().method_201((this.field_446 & 8160) >> 5);
                        Object[] var7 = var1.method_714(var8, true, false);
                        var2.method_2191(var7, this, var8, var1);
                    } else {
                        var2.method_2093();
                    }
                    var2.method_2141();
                    if (this.field_752 != null && this.field_752[0] != null) {
                        var2.method_2273(this.field_752[0]);
                    } else {
                        var2.method_2205(var5);
                    }
                }
                if (var4) {
                    if (var5.method_431()) {
                        if (var5.field_301 != class_40.field_183 && var5.field_301 != class_40.field_185) {
                            var2.method_2141();
                        } else {
                            var2.method_2144();
                        }
                    } else if (var5.field_301 != class_40.field_183 && var5.field_301 != class_40.field_185) {
                        var2.method_2142();
                    } else {
                        var2.method_2145();
                    }
                }
                if (this.field_753 != null) {
                    var2.method_2113(this.field_753);
                }
                var2.method_2182(this.field_674);
                var2.method_2179(var3.field_688.field_672, this.field_674);
                var2.method_2374(var3.field_689, this.field_674 & 15);
                var2.method_2182(var3.field_690);
                this.method_1037(var2, var5, this.field_752 == null ? null : this.field_752[1], false);
                return;
            case 2:
                class_65 var6 = (class_65)this.field_749;
                if (var6.field_301 == class_40.field_179) {
                    if (var4) {
                        var2.method_2324(var6);
                    }
                    if (var3.field_689 == 14) {
                        var2.method_2245(var6.field_306, 1);
                    } else {
                        var2.method_2245(var6.field_306, -1);
                    }
                } else {
                    var2.method_2324(var6);
                    if (var4) {
                        if (var6.field_301 != class_40.field_183 && var6.field_301 != class_40.field_185) {
                            var2.method_2141();
                        } else {
                            var2.method_2144();
                        }
                    }
                    var2.method_2182(this.field_674);
                    var2.method_2179(var3.field_688.field_672, this.field_674);
                    var2.method_2374(var3.field_689, this.field_674 & 15);
                    var2.method_2182(var3.field_690);
                    var2.method_2376(var6, false);
                }
            default:
        }
    }

    // $FF: renamed from: a (i.o) void
    public void method_1052(class_268 var1) {
        var1.method_2093();
    }

    // $FF: renamed from: a () m.s[]
    public class_40[] method_0() {
        return null;
    }

    // $FF: renamed from: a () m.ab
    public class_65 method_920() {
        switch (this.field_446 & 7) {
            case 1:
            default:
                return null;
            case 2:
                return (class_65)this.field_748;
        }
    }

    // $FF: renamed from: a (m.v, l.g) void
    public void method_1053(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            if ((this.field_446 & 8160) == 0 || this.field_672 != class_331.field_1896) {
                return;
            }
            if ((this.field_446 & 7) == 2) {
                var1.method_710((class_65)this.field_748);
            }
        }
    }

    // $FF: renamed from: a (m.v, l.g, boolean) void
    public void method_1054(class_86 var1, class_301 var2, boolean var3) {
        if ((var2.field_1783 & 1) == 0) {
            if (this.field_672 == class_331.field_1896) {
                if ((this.field_446 & 1) != 0) {
                    class_67 var4 = (class_67)this.field_748;
                    class_67 var5 = var4.method_435();
                    this.field_749 = var5;
                    if ((this.field_446 & 8160) != 0 && (var5.method_428() || var5.method_429() && var5.field_314.method_143() != var1.method_585().method_143())) {
                        if (this.field_752 == null) {
                            this.field_752 = new class_58[2];
                        }
                        this.field_752[var3 ? 0 : 1] = ((class_54)var1.method_585().method_201((this.field_446 & 8160) >> 5)).method_298(var5, var3);
                        var1.method_644().method_1690(var5, this, var3);
                        return;
                    }
                    if (var4.field_314 != this.field_750 && !this.field_750.method_147() && var4.field_314 != null && var4.method_407() == class_331.field_1896) {
                        class_341 var6 = var1.method_577();
                        if (var6.field_1929 >= 3014656L && (var6.field_1927 >= 3145728L || !var4.method_431()) && var4.field_314.field_177 != 1 || !var4.field_314.method_196(var1)) {
                            this.field_749 = var1.method_585().method_311(var5, (class_43)this.field_750.method_138());
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (l.g) int
    public int method_921(class_301 var1) {
        if (this.field_672 != null && this.field_672 != class_331.field_1896) {
            return -1;
        } else {
            switch (this.field_446 & 7) {
                case 1:
                    return 0;
                case 2:
                    class_65 var2 = (class_65)this.field_748;
                    if (var2 != null) {
                        if (var1.method_3085(var2)) {
                            return 1;
                        } else {
                            if (var1.method_3084(var2)) {
                                return -1;
                            }
                            return 0;
                        }
                    }
                default:
                    return -1;
            }
        }
    }

    // $FF: renamed from: a (m.bb) m.s
    public class_40 method_923(class_83 var1) {
        Object var2 = this.field_675;
        if (this.field_753 != null) {
            var2 = this.field_753;
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
        return var2.append(this.field_751);
    }

    // $FF: renamed from: c (m.v) m.s
    public class_40 method_1055(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if (this.field_748 instanceof class_69) {
            var1.method_644().method_1629(this, (class_67)this.field_748);
        } else if (!(this.field_748 instanceof class_51) && !(this.field_748 instanceof class_50)) {
            var1.method_644().method_1799(this, this.field_748);
        } else {
            var1.method_644().method_1639(this, (class_40)this.field_748);
        }
        return null;
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        if (this.field_750 != null) {
            this.field_748 = var1.method_601(this.field_750, this.field_751, this);
        } else {
            this.field_750 = var1.method_585();
            this.field_748 = var1.method_598(this.field_751, this.field_446 & 7, this, true);
        }
        this.field_749 = this.field_748;
        if (this.field_748.method_101()) {
            switch (this.field_446 & 7) {
                case 3:
                case 7:
                    if (this.field_748 instanceof class_64) {
                        class_64 var4 = (class_64)this.field_748;
                        class_40 var3;
                        if (this.field_748 instanceof class_65) {
                            this.field_446 &= -8;
                            this.field_446 |= 2;
                            if (!var4.method_409() && (this.field_446 & 8160) != 0) {
                                var1.method_644().method_1501((class_65)var4, this);
                            }
                            var3 = var4.field_301;
                            this.field_672 = (this.field_446 & 8192) == 0 ? var4.method_407() : class_331.field_1896;
                        } else {
                            var3 = this.method_1050(var1);
                        }
                        if (var3 != null) {
                            class_40 var10001 = (this.field_446 & 8192) == 0 ? var3.method_130(var1, this.field_445) : var3;
                            var3 = var10001;
                            this.field_675 = var10001;
                            if ((var3.field_178 & 128L) != 0L) {
                                if ((this.field_446 & 2) == 0) {
                                    var1.method_644().method_1639(this, var3);
                                }
                                return null;
                            }
                        }
                        return var3;
                    }
                    this.field_446 &= -8;
                    this.field_446 |= 4;
                case 4:
                    this.field_672 = class_331.field_1896;
                    class_40 var2 = (class_40)this.field_748;
                    if (this.method_756(var2, var1)) {
                        var1.method_644().method_1516(var2, this);
                    }
                    var2 = var1.method_586().method_490(var2, false);
                    return this.field_675 = var2;
                case 5:
                case 6:
            }
        }
        return this.field_675 = this.method_1055(var1);
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2055(this, var2);
        var1.method_1970(this, var2);
    }
}
