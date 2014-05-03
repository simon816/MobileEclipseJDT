package h;

import a.class_331;
import a.class_341;
import b.class_233;
import c.class_264;
import h.class_126;
import h.class_131;
import h.class_132;
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
import m.class_60;
import m.class_64;
import m.class_65;
import m.class_67;
import m.class_69;
import m.class_83;
import m.class_86;
import m.class_87;
import n.class_248;

// $FF: renamed from: h.ar
public class class_163 extends class_161 {

    // $FF: renamed from: a char[][]
    public char[][] field_754;
    // $FF: renamed from: a long[]
    public long[] field_755;
    // $FF: renamed from: a m.k[]
    public class_67[] field_756;
    // $FF: renamed from: b m.k[]
    public class_67[] field_757;
    // $FF: renamed from: a int[]
    int[] field_758;
    // $FF: renamed from: a int
    public int field_759;
    // $FF: renamed from: a m.d
    public class_60 field_760;
    // $FF: renamed from: a m.d[]
    public class_60[] field_761;
    // $FF: renamed from: b m.s
    public class_40 field_762;
    // $FF: renamed from: a m.s[]
    public class_40[] field_763;

    // $FF: renamed from: <init> (char[][], long[], int, int) void
    public class_163(char[][] var1, long[] var2, int var3, int var4) {
        this.field_754 = var1;
        this.field_755 = var2;
        this.field_444 = var3;
        this.field_445 = var4;
    }

    // $FF: renamed from: a (m.v, l.j, l.g, h.cb, boolean) l.g
    public class_301 method_1035(class_86 var1, class_293 var2, class_301 var3, class_131 var4, boolean var5) {
        int var6 = this.field_756 == null ? 0 : this.field_756.length;
        boolean var7 = var6 == 0 || !this.field_756[0].method_431();
        boolean var8 = var1.method_577().field_1927 >= 3145728L;
        class_67 var9 = null;
        switch (this.field_446 & 7) {
            case 1:
                var9 = (class_67)this.field_748;
                if (var7 || var8) {
                    this.method_1064(var1, var9, this.field_750, 0, (class_301)var3);
                }
                if (var9.method_408() && this.field_756 != null && var1.method_716(var9) && !((class_301)var3).method_3082(var9)) {
                    var1.method_644().method_1788(var9, this);
                }
                break;
            case 2:
                class_65 var10;
                if (!((class_301)var3).method_3083(var10 = (class_65)this.field_748)) {
                    var1.method_644().method_1789(var10, this);
                }
                if ((((class_301)var3).field_1783 & 1) == 0) {
                    var10.field_307 = 1;
                } else if (var10.field_307 == 0) {
                    var10.field_307 = 2;
                }
                this.method_1057(var1, var2, (class_301)var3, true);
        }
        if (var7) {
            this.method_1063(var1, (class_301)var3);
        }
        if (this.field_756 != null) {
            for (int var12 = 0; var12 < var6 - 1; ++var12) {
                var9 = this.field_756[var12];
                var7 = !this.field_756[var12 + 1].method_431();
                if (var7 || var8) {
                    this.method_1064(var1, var9, var12 == 0 ? ((class_64)this.field_748).field_301 : this.field_756[var12 - 1].field_301, var12 + 1, (class_301)var3);
                }
            }
            var9 = this.field_756[var6 - 1];
        }
        class_40 var11;
        if (var5) {
            if (var6 == 0 && var9.method_408() && var1.method_716(var9) && !((class_301)var3).method_3082(var9)) {
                var1.method_644().method_1788(var9, this);
            }
            switch (var6) {
                case 0:
                    var11 = this.field_750;
                    break;
                case 1:
                    var11 = ((class_64)this.field_748).field_301;
                    break;
                default:
                    var11 = this.field_756[var6 - 2].field_301;
            }
            this.method_1064(var1, var9, var11, var6, (class_301)var3);
        }
        if (var4.field_688 != null) {
            var3 = var4.field_688.method_814(var1, var2, (class_301)var3).method_3109();
        }
        if (var9.method_409()) {
            if (var6 == 0 && this.field_759 == 1 && var9.method_408() && !var5 && var1.method_706(var9)) {
                if (((class_301)var3).method_3087(var9)) {
                    var1.method_644().method_1527(var9, this);
                } else {
                    var2.method_3049(var9, this, (class_301)var3);
                }
                ((class_301)var3).method_3096(var9);
            } else {
                var1.method_644().method_1491(var9, this);
                if (var6 == 0 && var1.method_706(var9)) {
                    ((class_301)var3).method_3096(var9);
                }
            }
        }
        switch (var6) {
            case 0:
                var11 = this.field_750;
                break;
            case 1:
                var11 = ((class_64)this.field_748).field_301;
                break;
            default:
                var11 = this.field_756[var6 - 2].field_301;
        }
        this.method_1064(var1, var9, var11, -1, (class_301)var3);
        return (class_301)var3;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return this.method_907(var1, var2, var3, true);
    }

    // $FF: renamed from: a (m.v, l.j, l.g, boolean) l.g
    public class_301 method_907(class_86 var1, class_293 var2, class_301 var3, boolean var4) {
        int var5 = this.field_756 == null ? 0 : this.field_756.length;
        boolean var6 = var5 == 0 ? var4 : !this.field_756[0].method_431();
        boolean var7 = var1.method_577().field_1927 >= 3145728L;
        switch (this.field_446 & 7) {
            case 1:
                if (var6 || var7) {
                    this.method_1064(var1, (class_67)this.field_748, this.field_750, 0, var3);
                }
                if (this.field_759 == 1) {
                    class_67 var11 = (class_67)this.field_748;
                    if (var11.method_408() && var1.method_716(var11) && !var3.method_3082(var11)) {
                        var1.method_644().method_1788(var11, this);
                    }
                }
                break;
            case 2:
                class_65 var8;
                if (!var3.method_3083(var8 = (class_65)this.field_748)) {
                    var1.method_644().method_1789(var8, this);
                }
                if ((var3.field_1783 & 1) == 0) {
                    var8.field_307 = 1;
                } else if (var8.field_307 == 0) {
                    var8.field_307 = 2;
                }
                this.method_1057(var1, var2, var3, true);
        }
        if (var6) {
            this.method_1063(var1, var3);
        }
        if (this.field_756 != null) {
            for (int var10 = 0; var10 < var5; ++var10) {
                var6 = var10 < var5 - 1 ? !this.field_756[var10 + 1].method_431() : var4;
                if (var6 || var7) {
                    class_40 var9 = this.method_1061(var10);
                    if (var9 == null) {
                        if (var10 == 0) {
                            var9 = ((class_64)this.field_748).field_301;
                        } else {
                            var9 = this.field_756[var10 - 1].field_301;
                        }
                    }
                    this.method_1064(var1, this.field_756[var10], var9, var10 + 1, var3);
                }
            }
        }
        return var3;
    }

    // $FF: renamed from: a (m.v, l.j, l.g, boolean) void
    public void method_1057(class_86 var1, class_293 var2, class_301 var3, boolean var4) {
        if ((this.field_446 & 7) == 2) {
            class_65 var5 = (class_65)this.field_748;
            if (var5 != null && (var5.field_301.field_178 & 2L) == 0L && (var4 || var5.field_301.field_177 != 11)) {
                if ((this.field_446 & 131072) == 0) {
                    var2.method_3050(var1, var5, this, 3, var3);
                }
                var3.method_3094(var5);
                if (var2.field_1741 != null) {
                    var2.field_1741.method_3094(var5);
                }
            }
        }
    }

    // $FF: renamed from: a (m.bb, m.s, m.s) void
    public void method_911(class_83 var1, class_40 var2, class_40 var3) {
        if (var2 != null && var3 != null) {
            class_67 var4 = null;
            int var5 = this.field_756 == null ? 0 : this.field_756.length;
            if (var5 == 0) {
                if ((this.field_446 & 1) != 0 && this.field_748 != null && this.field_748.method_101()) {
                    var4 = (class_67)this.field_748;
                }
            } else {
                var4 = this.field_756[var5 - 1];
            }
            if (var4 != null) {
                class_67 var6 = var4.method_435();
                class_40 var7 = var6.field_301;
                if (var6 != var4 && var7 != var4.field_301 && var2.field_177 != 1 && (var7.field_178 & 536870912L) != 0L) {
                    class_40 var8 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    class_40 var9 = var7.method_141(var8);
                    this.method_1067(var5, var9);
                    if (var9 instanceof class_43) {
                        class_43 var10 = (class_43)var9;
                        if (!var10.method_196(var1)) {
                            class_248 var10000 = var1.method_644();
                            class_51 var10002 = new class_51(class_233.method_1385('.', var10.method_104()), var10, 2);
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
        int var5 = var2.field_1208;
        class_67 var6 = this.method_1058(var1, var2);
        var2.method_2360(var5, this.field_444);
        var3.field_688.method_912(var1, var2, true);
        this.method_1037(var2, var6, this.field_760, var4);
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
        } else {
            class_67 var5 = this.method_1058(var1, var2);
            if (var5 != null) {
                boolean var6 = var5.method_431();
                class_331 var7 = var5.method_407();
                if (var7 != class_331.field_1896) {
                    if (!var6) {
                        var2.method_2271();
                        var2.method_2352();
                    }
                    if (var3) {
                        var2.method_2179(var7, this.field_674);
                    }
                } else {
                    boolean var8 = var5 == this.field_748 && (this.field_759 == 1 || var5.field_314 == var1.method_584()) && this.field_756 == null;
                    class_40 var9 = this.method_1061(this.field_757 == null ? 0 : this.field_757.length);
                    if (!var3 && (var8 || var1.method_577().field_1927 < 3145728L) && (this.field_674 & 1024) == 0 && var9 == null) {
                        if (!var6) {
                            var2.method_2271();
                            var2.method_2352();
                        }
                    } else {
                        int var10 = var2.field_1208;
                        if (var5.field_314 == null) {
                            var2.method_2101();
                            if (var3) {
                                var2.method_2182(this.field_674);
                            } else {
                                var2.method_2352();
                            }
                        } else {
                            class_60 var11 = this.field_761 == null ? null : this.field_761[this.field_761.length - 1];
                            if (var11 == null) {
                                if (var6) {
                                    var2.method_2207(var5);
                                } else {
                                    var2.method_2205(var5);
                                }
                            } else {
                                var2.method_2273(var11);
                            }
                            if (var9 != null) {
                                var2.method_2113(var9);
                            }
                            if (var3) {
                                var2.method_2182(this.field_674);
                            } else {
                                boolean var12 = (this.field_674 & 1024) != 0;
                                if (var12) {
                                    var2.method_2182(this.field_674);
                                }
                                switch (var12 ? this.method_923(var1).field_177 : var5.field_301.field_177) {
                                    case 7:
                                    case 8:
                                        var2.method_2353();
                                        break;
                                    default:
                                        var2.method_2352();
                                }
                            }
                        }
                        int var13 = (int)(this.field_755[this.field_755.length - 1] >>> 32);
                        var2.method_2360(var10, var13);
                    }
                }
            }
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: a (m.v, i.o, h.r, int, int, boolean) void
    public void method_1039(class_86 var1, class_268 var2, class_126 var3, int var4, int var5, boolean var6) {
        class_67 var7 = this.method_1058(var1, var2);
        class_60 var8 = this.field_761 == null ? null : this.field_761[this.field_761.length - 1];
        if (var7.method_431()) {
            if (var8 == null) {
                var2.method_2207(var7);
            } else {
                var2.method_2273(var8);
            }
        } else {
            var2.method_2141();
            if (var8 == null) {
                var2.method_2205(var7);
            } else {
                var2.method_2273(var8);
            }
        }
        int var9;
        switch (var9 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.method_2193(var1, (class_126)null, var3);
                break;
            default:
                class_40 var10 = this.method_1061(this.field_757 == null ? 0 : this.field_757.length);
                if (var10 != null) {
                    var2.method_2113(var10);
                }
                var2.method_2182(this.field_674);
                if (var3 == class_180.field_797) {
                    var2.method_2179(var3.field_672, this.field_674);
                } else {
                    var3.method_912(var1, var2, true);
                }
                var2.method_2374(var4, var9);
                var2.method_2182(var5);
        }
        this.method_1037(var2, var7, this.field_760, var6);
    }

    // $FF: renamed from: a (m.v, i.o, h.i, boolean) void
    public void method_1040(class_86 var1, class_268 var2, class_132 var3, boolean var4) {
        class_67 var5 = this.method_1058(var1, var2);
        class_60 var6 = this.field_761 == null ? null : this.field_761[this.field_761.length - 1];
        if (var5.method_431()) {
            if (var6 == null) {
                var2.method_2207(var5);
            } else {
                var2.method_2273(var6);
            }
        } else {
            var2.method_2141();
            if (var6 == null) {
                var2.method_2205(var5);
            } else {
                var2.method_2273(var6);
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
        class_40 var7 = this.method_1061(this.field_757 == null ? 0 : this.field_757.length);
        if (var7 != null) {
            var2.method_2113(var7);
        }
        var2.method_2182(this.field_674);
        var2.method_2179(var3.field_688.field_672, this.field_674);
        var2.method_2374(var3.field_689, this.field_674 & 15);
        var2.method_2182(var3.field_690);
        this.method_1037(var2, var5, this.field_760, false);
    }

    // $FF: renamed from: a (m.v, i.o) m.k
    public class_67 method_1058(class_86 var1, class_268 var2) {
        int var3 = this.field_757 == null ? 0 : this.field_757.length;
        boolean var4 = var3 == 0 || !this.field_756[0].method_431();
        class_67 var5 = null;
        class_40 var6 = null;
        boolean var7 = var1.method_577().field_1927 >= 3145728L;
        int var15;
        switch (this.field_446 & 7) {
            case 1:
                var5 = (class_67)this.field_749;
                var6 = this.field_762;
                if (var5.method_407() == class_331.field_1896 && (var4 && !var5.method_431() || var6 != null)) {
                    var15 = var2.field_1208;
                    if ((this.field_446 & 8160) != 0) {
                        class_43 var16 = var1.method_585().method_201((this.field_446 & 8160) >> 5);
                        Object[] var18 = var1.method_714(var16, true, false);
                        var2.method_2191(var18, this, var16, var1);
                    } else {
                        this.method_1059(var2);
                    }
                    var2.method_2360(var15, this.field_444);
                }
                break;
            case 2:
                if (var4) {
                    class_65 var8 = (class_65)this.field_749;
                    class_331 var9 = var8.method_407();
                    if (var9 != class_331.field_1896) {
                        var2.method_2179(var9, 0);
                    } else if ((this.field_446 & 8160) != 0) {
                        class_64[] var10 = var1.method_713(var8);
                        var2.method_2191(var10, this, var8, var1);
                    } else {
                        var2.method_2324(var8);
                    }
                }
        }
        var15 = this.field_755.length;
        if (this.field_757 != null) {
            for (int var17 = 0; var17 < var3; ++var17) {
                int var19 = var2.field_1208;
                class_67 var11 = this.field_757[var17];
                class_40 var12 = this.field_763 == null ? null : this.field_763[var17];
                if (var5 != null) {
                    var4 = !var11.method_431();
                    class_331 var13 = var5.method_407();
                    if (var13 != class_331.field_1896) {
                        if (var17 > 0 && !var5.method_431()) {
                            var2.method_2271();
                            var2.method_2352();
                        }
                        if (var4) {
                            var2.method_2179(var13, 0);
                        }
                    } else {
                        class_60 var14;
                        if (!var4 && (var17 <= 0 || !var7) && var6 == null) {
                            if (this.field_749 == var5) {
                                if (var5.method_431() && ((class_67)this.field_748).method_435().field_314 != this.field_750.method_138()) {
                                    var14 = this.field_761 == null ? null : this.field_761[var17];
                                    if (var14 == null) {
                                        var2.method_2207(var5);
                                    } else {
                                        var2.method_2273(var14);
                                    }
                                    var2.method_2352();
                                }
                            } else if (!var5.method_431()) {
                                var2.method_2271();
                                var2.method_2352();
                            }
                        } else {
                            var14 = this.field_761 == null ? null : this.field_761[var17];
                            if (var14 == null) {
                                if (var5.method_431()) {
                                    var2.method_2207(var5);
                                } else {
                                    var2.method_2205(var5);
                                }
                            } else {
                                var2.method_2273(var14);
                            }
                            if (var6 != null) {
                                var2.method_2113(var6);
                            }
                            if (!var4) {
                                var2.method_2352();
                            }
                        }
                        if (var15 - var3 + var17 - 1 >= 0) {
                            int var20 = (int)(this.field_755[var15 - var3 + var17 - 1] >>> 32);
                            var2.method_2360(var19, var20);
                        }
                    }
                }
                var5 = var11;
                var6 = var12;
            }
        }
        return var5;
    }

    // $FF: renamed from: a (i.o) void
    public void method_1059(class_268 var1) {
        var1.method_2093();
    }

    // $FF: renamed from: a () m.s[]
    public class_40[] method_0() {
        return null;
    }

    // $FF: renamed from: a (int) m.k
    protected class_67 method_1060(int var1) {
        return var1 == 0 ? (class_67)this.field_749 : this.field_757[var1 - 1];
    }

    // $FF: renamed from: a (int) m.s
    protected class_40 method_1061(int var1) {
        return var1 == 0 ? this.field_762 : (this.field_763 == null ? null : this.field_763[var1 - 1]);
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1062(class_86 var1) {
        int var2 = this.field_754.length;
        class_67 var3;
        if ((this.field_446 & 1) != 0) {
            var3 = (class_67)this.field_748;
            if (!var3.method_431()) {
                if (this.field_759 > 1 || var1.method_635().field_404) {
                    var1.method_644().method_1757(this, var3);
                    return null;
                }
            } else if (this.field_759 > 1 && var3.field_314 != this.field_750 && var3.field_314.method_196(var1)) {
                var1.method_644().method_1612(this, var3);
            }
            if (this.method_751(var3, var1, (this.field_446 & 8192) != 0 && this.field_759 == var2)) {
                var1.method_644().method_1514(var3, this);
            }
        } else {
            var3 = null;
        }
        class_40 var4 = ((class_64)this.field_748).field_301;
        int var5 = this.field_759;
        if (var5 == var2) {
            this.field_672 = ((class_67)this.field_748).method_407();
            return var4 != null && (this.field_446 & 8192) == 0 ? var4.method_130(var1, this.field_445) : var4;
        } else {
            int var6 = var2 - var5;
            this.field_757 = this.field_756 = new class_67[var6];
            this.field_758 = new int[var6];
            this.field_672 = ((class_64)this.field_748).method_407();
            int var7 = (this.field_446 & 8160) >> 5;
            while (true) {
                if (var5 < var2) {
                    char[] var8 = this.field_754[var5];
                    if (var4 == null) {
                        return null;
                    }
                    this.field_446 &= -8161;
                    class_67 var9 = var3;
                    var3 = var1.method_601(var4.method_130(var1, (int)this.field_755[var5]), var8, this);
                    int var10 = var5 - this.field_759;
                    this.field_756[var10] = var3;
                    this.field_758[var10] = (this.field_446 & 8160) >> 5;
                    if (var3.method_101()) {
                        if (var9 != null) {
                            Object var11 = var4;
                            class_40 var12 = var4.method_138();
                            if (var12 instanceof class_43 && var12.method_140(var3.field_314) == null) {
                                var11 = var3.field_314;
                            }
                            class_67 var13 = var9.method_435();
                            if ((var13.field_301.field_178 & 536870912L) != 0L && ((class_40)var11).field_177 != 1) {
                                this.method_1067(var5 - 1, var13.field_301.method_141((class_40)var11));
                            }
                        }
                        if (this.method_751(var3, var1, (this.field_446 & 8192) != 0 && var5 + 1 == var2)) {
                            var1.method_644().method_1514(var3, this);
                        }
                        if (this.field_672 != class_331.field_1896) {
                            this.field_672 = var3.method_407();
                        }
                        if (var3.method_431()) {
                            class_43 var15 = var3.field_314;
                            if (var15.method_153()) {
                                class_87 var14 = var1.method_635();
                                class_54 var16 = var14.method_585();
                                if ((var16 == var15 || var16.field_252 == var15) && var3.method_407() == class_331.field_1896 && !var14.field_404 && var14.method_728()) {
                                    var1.method_644().method_1543(var3, this);
                                }
                            }
                            var1.method_644().method_1704(this, var3, var5);
                            if (var3.field_314 != var4) {
                                var1.method_644().method_1612(this, var3);
                            }
                        }
                        var4 = var3.field_301;
                        ++var5;
                        continue;
                    }
                    this.field_672 = class_331.field_1896;
                    var1.method_644().method_1630(this, var3, var5, var4);
                    this.method_2(var7);
                    return null;
                }
                this.method_2(var7);
                var4 = this.field_756[var6 - 1].field_301;
                return var4 != null && (this.field_446 & 8192) == 0 ? var4.method_130(var1, this.field_445) : var4;
            }
        }
    }

    // $FF: renamed from: a (m.v, l.g) void
    public void method_1063(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            if ((this.field_446 & 8160) == 0 || this.field_672 != class_331.field_1896) {
                return;
            }
            if ((this.field_446 & 7) == 2) {
                var1.method_710((class_65)this.field_748);
            }
        }
    }

    // $FF: renamed from: a (m.v, m.k, m.s, int, l.g) void
    public void method_1064(class_86 var1, class_67 var2, class_40 var3, int var4, class_301 var5) {
        if ((var5.field_1783 & 1) == 0) {
            if (var2.method_407() == class_331.field_1896) {
                class_67 var6 = var2.method_435();
                if (var6 != var2) {
                    this.method_1066(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4, var6);
                }
                if (var2.method_428()) {
                    class_67 var7 = this.method_1060(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4);
                    if (var7.field_314 != var1.method_585()) {
                        this.method_1068(var2, var4, ((class_54)var7.field_314).method_298(var7, var4 >= 0));
                        var1.method_644().method_1690(var7, this, var4 >= 0);
                        return;
                    }
                } else if (var2.method_429()) {
                    int var9 = var4 != 0 && (var4 >= 0 || this.field_758 != null) ? this.field_758[var4 < 0 ? this.field_758.length - 1 : var4 - 1] : (this.field_446 & 8160) >> 5;
                    if (var9 > 0 && var2.field_314.method_143() != var1.method_585().method_143()) {
                        class_67 var8 = this.method_1060(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4);
                        this.method_1068(var2, var4, ((class_54)var1.method_585().method_201(var9)).method_298(var8, var4 >= 0));
                        var1.method_644().method_1690(var8, this, var4 >= 0);
                        return;
                    }
                }
                if (var2.field_314 != var3 && !var3.method_147() && var2.field_314 != null && var2.method_407() == class_331.field_1896) {
                    class_341 var10 = var1.method_577();
                    if (var10.field_1929 >= 3014656L && (var10.field_1927 >= 3145728L || var4 > 1 || this.field_759 != 1 || !var2.method_431()) && var2.field_314.field_177 != 1 || !var2.field_314.method_196(var1)) {
                        this.method_1066(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4, var1.method_585().method_311(this.method_1060(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4), (class_43)var3.method_138()));
                    }
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
                if (this.field_672 != class_331.field_1896) {
                    return this.field_672;
                } else {
                    switch (this.field_446 & 7) {
                        case 1:
                            if (this.field_756 == null) {
                                return ((class_67)this.field_748).method_407();
                            }
                        case 2:
                            return this.field_756[this.field_756.length - 1].method_407();
                    }
                }
            default:
                return class_331.field_1896;
        }
    }

    // $FF: renamed from: a (m.bb) m.s
    public class_40 method_923(class_83 var1) {
        Object var2 = this.field_675;
        class_40 var3 = this.method_1061(this.field_757 == null ? 0 : this.field_757.length);
        if (var3 != null) {
            var2 = var3;
        }
        int var4 = (this.field_674 & 255) >> 4;
        switch (var4) {
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
        for (int var3 = 0; var3 < this.field_754.length; ++var3) {
            if (var3 > 0) {
                var2.append('.');
            }
            var2.append(this.field_754[var3]);
        }
        return var2;
    }

    // $FF: renamed from: c (m.v) m.s
    public class_40 method_1065(class_86 var1) {
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
        this.field_750 = var1.method_584();
        this.field_672 = class_331.field_1896;
        if ((this.field_749 = this.field_748 = var1.method_712(this.field_754, this.field_446 & 7, this, true)).method_101()) {
            switch (this.field_446 & 7) {
                case 3:
                case 7:
                    class_248 var10000;
                    class_69 var10002;
                    if (this.field_748 instanceof class_65) {
                        class_65 var7 = (class_65)this.field_748;
                        if (!var7.method_409() && (this.field_446 & 8160) != 0) {
                            var1.method_644().method_1501((class_65)this.field_748, this);
                        }
                        this.field_446 &= -8;
                        this.field_446 |= 2;
                        if (var7.field_301 != null && (var7.field_301.field_178 & 128L) != 0L) {
                            return null;
                        }
                        this.field_675 = this.method_1062(var1);
                        if (this.field_675 != null && (this.field_675.field_178 & 128L) != 0L) {
                            class_67 var8 = this.field_756[this.field_756.length - 1];
                            var10000 = var1.method_644();
                            var10002 = new class_69(var8.field_314, var8.field_302, 1);
                            var10000.method_1630(this, var10002, this.field_754.length, this.field_675.method_173());
                            return null;
                        }
                        return this.field_675;
                    }
                    if (this.field_748 instanceof class_67) {
                        class_67 var6 = (class_67)this.field_748;
                        class_87 var3 = var1.method_635();
                        if (this.field_759 == 1 && var3.method_585() == var6.method_435().field_314 && var3.field_407 >= 0 && var6.field_304 >= var3.field_407 && (!var6.method_431() || var3.field_404)) {
                            var1.method_644().method_1556(this, 0, var3.method_585());
                        }
                        if (var6.method_431()) {
                            class_43 var4 = var6.field_314;
                            if (var4.method_153()) {
                                class_54 var5 = var3.method_585();
                                if ((var5 == var4 || var5.field_252 == var4) && var6.method_407() == class_331.field_1896 && !var3.field_404 && var3.method_728()) {
                                    var1.method_644().method_1543(var6, this);
                                }
                            }
                        } else if (this.field_759 == 1 && var1.method_577().method_3313(4194304L) != -1) {
                            var1.method_644().method_1796(this, var6);
                        }
                        this.field_446 &= -8;
                        this.field_446 |= 1;
                        this.field_675 = this.method_1062(var1);
                        if (this.field_675 != null && (this.field_675.field_178 & 128L) != 0L) {
                            class_67 var9 = this.field_759 == this.field_754.length ? (class_67)this.field_748 : this.field_756[this.field_756.length - 1];
                            var10000 = var1.method_644();
                            var10002 = new class_69(var9.field_314, var9.field_302, 1);
                            var10000.method_1630(this, var10002, this.field_754.length, this.field_675.method_173());
                            return null;
                        }
                        return this.field_675;
                    }
                    this.field_446 &= -8;
                    this.field_446 |= 4;
                case 4:
                    class_40 var2 = (class_40)this.field_748;
                    var2 = var1.method_586().method_490(var2, false);
                    return this.field_675 = var2;
                case 5:
                case 6:
            }
        }
        return this.field_675 = this.method_1065(var1);
    }

    // $FF: renamed from: a (int, m.k) void
    protected void method_1066(int var1, class_67 var2) {
        if (var1 == 0) {
            this.field_749 = var2;
        } else {
            int var3 = this.field_756.length;
            if (this.field_757 == this.field_756) {
                System.arraycopy(this.field_756, 0, this.field_757 = new class_67[var3], 0, var3);
            }
            this.field_757[var1 - 1] = var2;
        }
    }

    // $FF: renamed from: b (int) void
    public void method_3(int var1) {
        this.field_759 = var1;
    }

    // $FF: renamed from: a (int, m.s) void
    protected void method_1067(int var1, class_40 var2) {
        if (var1 == 0) {
            this.field_762 = var2;
        } else {
            if (this.field_763 == null) {
                this.field_763 = new class_40[this.field_756.length];
            }
            this.field_763[var1 - 1] = var2;
        }
    }

    // $FF: renamed from: a (m.k, int, m.d) void
    protected void method_1068(class_67 var1, int var2, class_60 var3) {
        if (var2 < 0) {
            this.field_760 = var3;
        } else {
            if (this.field_761 == null) {
                this.field_761 = new class_60[this.field_756 == null ? 1 : this.field_756.length + 1];
            }
            this.field_761[var2] = var3;
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2048(this, var2);
        var1.method_1963(this, var2);
    }
}
