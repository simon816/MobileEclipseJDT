package h;

import a.class_33;
import a.class_331;
import a.class_341;
import b.class_233;
import c.class_264;
import h.class_126;
import h.class_130;
import h.class_146;
import h.class_148;
import h.class_160;
import h.class_161;
import h.class_93;
import i.class_268;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_0;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_51;
import m.class_53;
import m.class_54;
import m.class_58;
import m.class_61;
import m.class_83;
import m.class_86;
import n.class_248;

public class class_168 extends class_126 implements class_0 {

    public class_126 field_772;

    public char[] field_773;

    public class_126[] field_774;

    public class_58 field_775;

    public class_58 field_776;

    public class_58 field_777;

    public class_40 field_778;

    public long field_779;

    public class_40 field_780;

    public class_40 field_781;

    public class_40 field_782;

    public class_146[] field_783;

    public class_40[] field_784;

    public class_168() {
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        boolean var4 = !this.field_775.method_370();
        class_303 var7 = this.field_772.method_907(var1, var2, var3, var4).method_3109();
        if (var4) {
            this.field_772.method_909(var1, var2, var7);
        }
        if (this.field_774 != null) {
            int var5 = this.field_774.length;
            for (int var6 = 0; var6 < var5; ++var6) {
                var7 = this.field_774[var6].method_814(var1, var2, var7).method_3109();
            }
        }
        class_43[] var8 = this.field_775.field_277;
        if (this.field_775.field_277 != class_34.field_151) {
            var2.method_3033(var8, this, var7.method_3078(), var1);
        }
        this.method_1079(var1, var7);
        return var7;
    }

    public void method_911(class_83 var1, class_40 var2, class_40 var3) {
        if (var2 != null && var3 != null) {
            if (this.field_775 != null && this.field_775.method_101()) {
                class_58 var4 = this.field_775.method_376();
                class_40 var5 = var4.field_275;
                if (var4 != this.field_775 && var5 != this.field_775.field_275 && var2.field_177 != 1 && (var5.field_178 & 536870912L) != 0L) {
                    class_40 var6 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    this.field_782 = var5.method_141(var6);
                } else if (this.field_780.method_147() && var2.field_177 != 1 && this.field_775.field_276 == class_34.field_150 && var1.method_577().field_1927 >= 3211264L && class_233.method_1364(this.field_775.field_274, class_17.field_33)) {
                    this.field_782 = var2;
                }
                if (this.field_782 instanceof class_43) {
                    class_43 var7 = (class_43)this.field_782;
                    if (!var7.method_196(var1)) {
                        class_248 var10000 = var1.method_644();
                        class_51 var10002 = new class_51(class_233.method_1385('.', var7.method_104()), var7, 2);
                        var10000.method_1639(this, var10002);
                    }
                }
            }
            super.method_911(var1, var2, var3);
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        boolean var5 = this.field_776.method_370();
        if (var5) {
            this.field_772.method_912(var1, var2, false);
            var2.method_2360(var4, this.field_444);
        } else if ((this.field_446 & 8160) != 0 && this.field_772.method_752()) {
            class_43 var6 = var1.method_585().method_201((this.field_446 & 8160) >> 5);
            Object[] var7 = var1.method_714(var6, true, false);
            var2.method_2191(var7, this, var6, var1);
        } else {
            this.field_772.method_912(var1, var2, true);
            if (this.field_781 != null) {
                var2.method_2113(this.field_781);
            }
            var2.method_2360(var4, this.field_444);
        }
        this.method_817(this.field_775, this.field_774, var1, var2);
        if (this.field_777 == null) {
            if (var5) {
                var2.method_2273(this.field_776);
            } else if (!this.field_772.method_754() && !this.field_776.method_367()) {
                if (this.field_776.field_278.method_157()) {
                    var2.method_2261(this.field_776);
                } else {
                    var2.method_2282(this.field_776);
                }
            } else {
                var2.method_2272(this.field_776);
            }
        } else {
            var2.method_2273(this.field_777);
        }
        if (this.field_782 != null) {
            var2.method_2113(this.field_782);
        }
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            boolean var8 = (this.field_674 & 1024) != 0;
            if (var8) {
                var2.method_2182(this.field_674);
            }
            switch (var8 ? this.method_923(var1).field_177 : this.field_776.field_275.field_177) {
                case 6:
                    break;
                case 7:
                case 8:
                    var2.method_2353();
                    break;
                default:
                    var2.method_2352();
            }
        }
        var2.method_2360(var4, (int)(this.field_779 >>> 32));
    }

    public class_40[] method_0() {
        return this.field_784;
    }

    public boolean method_1() {
        return this.field_772.method_754();
    }

    public void method_1079(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            this.field_776 = this.field_775.method_376();
            if (this.field_775.method_367()) {
                if (var1.method_585() != this.field_776.field_278) {
                    this.field_777 = ((class_54)this.field_776.field_278).method_302(this.field_776, this.method_1());
                    var1.method_644().method_1691(this.field_776, this);
                    return;
                }
            } else {
                class_54 var3;
                if (this.field_772 instanceof class_160) {
                    var3 = (class_54)((class_54)((class_160)this.field_772).field_747);
                    this.field_777 = var3.method_302(this.field_776, this.method_1());
                    var1.method_644().method_1691(this.field_776, this);
                    return;
                }
                if (this.field_775.method_368() && (this.field_446 & 8160) != 0 && this.field_776.field_278.method_143() != (var3 = var1.method_585()).method_143()) {
                    class_54 var4 = (class_54)var3.method_201((this.field_446 & 8160) >> 5);
                    this.field_777 = var4.method_302(this.field_776, this.method_1());
                    var1.method_644().method_1691(this.field_776, this);
                    return;
                }
            }
            if (this.field_775.field_278 != this.field_780 && this.field_781 == null && !this.field_780.method_147()) {
                class_341 var5 = var1.method_577();
                if (var5.field_1929 >= 3014656L && (var5.field_1927 >= 3145728L || !this.field_772.method_752() || !this.field_776.method_370()) && this.field_775.field_278.field_177 != 1 || !this.field_775.field_278.method_196(var1)) {
                    this.field_776 = var1.method_585().method_312(this.field_776, (class_43)this.field_780.method_138());
                }
            }
        }
    }

    public int method_921(class_301 var1) {
        return 0;
    }

    public class_40 method_923(class_83 var1) {
        Object var2 = this.field_675;
        if (this.field_782 != null) {
            var2 = this.field_782;
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

    public StringBuffer method_924(int var1, StringBuffer var2) {
        if (!this.field_772.method_752()) {
            this.field_772.method_924(0, var2).append('.');
        }
        int var3;
        if (this.field_783 != null) {
            var2.append('<');
            var3 = this.field_783.length - 1;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.field_783[var4].method_757(0, var2);
                var2.append(", ");
            }
            this.field_783[var3].method_757(0, var2);
            var2.append('>');
        }
        var2.append(this.field_773).append('(');
        if (this.field_774 != null) {
            for (var3 = 0; var3 < this.field_774.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_774[var3].method_924(0, var2);
            }
        }
        return var2.append(')');
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        boolean var2 = false;
        boolean var3 = false;
        if (this.field_772 instanceof class_130) {
            this.field_772.field_446 |= 32;
            var2 = true;
        }
        this.field_780 = this.field_772.method_925(var1);
        boolean var4 = this.field_772 instanceof class_161 && (((class_161)this.field_772).field_446 & 4) != 0;
        if (var2 && this.field_780 != null && ((class_130)this.field_772).field_684.field_675 == this.field_780) {
            var1.method_644().method_1790((class_130)this.field_772);
        }
        boolean var6;
        int var7;
        int var15;
        if (this.field_783 != null) {
            int var5 = this.field_783.length;
            var6 = var1.method_577().field_1928 < 3211264L;
            this.field_784 = new class_40[var5];
            for (var7 = 0; var7 < var5; ++var7) {
                class_146 var8 = this.field_783[var7];
                if ((this.field_784[var7] = var8.method_1017(var1, true)) == null) {
                    var6 = true;
                }
                if (var6 && var8 instanceof class_148) {
                    var1.method_644().method_1599(var8);
                }
            }
            if (var6) {
                if (this.field_774 != null) {
                    var7 = 0;
                    for (var15 = this.field_774.length; var7 < var15; ++var7) {
                        this.field_774[var7].method_925(var1);
                    }
                }
                return null;
            }
        }
        class_40[] var11 = class_34.field_150;
        if (this.field_774 != null) {
            var6 = false;
            var7 = this.field_774.length;
            var11 = new class_40[var7];
            for (var15 = 0; var15 < var7; ++var15) {
                class_126 var9 = this.field_774[var15];
                if (var9 instanceof class_130) {
                    var9.field_446 |= 32;
                    var3 = true;
                }
                if ((var11[var15] = var9.method_925(var1)) == null) {
                    var6 = true;
                }
            }
            if (var6) {
                if (this.field_780 instanceof class_43) {
                    class_40[] var17 = new class_40[var7];
                    int var21 = var7;
                    while (true) {
                        --var21;
                        if (var21 < 0) {
                            this.field_775 = this.field_772.method_752() ? var1.method_602(this.field_773, var17, this) : var1.method_592((class_43)this.field_780, this.field_773, var17, this);
                            if (this.field_775 != null && !this.field_775.method_101()) {
                                Object var22 = ((class_61)this.field_775).field_291;
                                if (var22 != null) {
                                    if (((class_58)var22).method_376().field_279 != class_34.field_157) {
                                        var22 = var1.method_586().method_498(((class_58)var22).method_376(), (class_53)null);
                                    }
                                    this.field_775 = (class_58)var22;
                                    class_58 var10 = ((class_58)var22).method_376();
                                    if ((var10.method_367() || var10.field_278.method_158()) && !var1.method_626(var10)) {
                                        var10.field_273 |= 134217728;
                                    }
                                }
                            }
                            break;
                        }
                        var17[var21] = (class_40)(var11[var21] == null ? class_40.field_187 : var11[var21]);
                    }
                }
                return null;
            }
        }
        if (this.field_780 == null) {
            return null;
        } else if (this.field_780.method_148()) {
            var1.method_644().method_1545(this, this.field_780, var11);
            return null;
        } else {
            try {
                this.field_775 = this.field_772.method_752() ? var1.method_602(this.field_773, var11, this) : var1.method_614(this.field_780, this.field_773, var11, this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (!this.field_775.method_101()) {
                if (this.field_775.field_278 == null) {
                    if (!(this.field_780 instanceof class_43)) {
                        var1.method_644().method_1545(this, this.field_780, var11);
                        return null;
                    }
                    this.field_775.field_278 = (class_43)this.field_780;
                }
                var1.method_644().method_1632(this, this.field_775);
                class_58 var13 = ((class_61)this.field_775).field_291;
                switch (this.field_775.method_102()) {
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                        if (var13 != null) {
                            this.field_675 = var13.field_275;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 9:
                }
                if (var13 != null) {
                    this.field_775 = var13;
                    class_58 var20 = var13.method_376();
                    if ((var20.method_367() || var20.field_278.method_158()) && !var1.method_626(var20)) {
                        var20.field_273 |= 134217728;
                    }
                }
                return this.field_675 != null && (this.field_675.field_178 & 128L) == 0L ? this.field_675 : null;
            } else {
                if ((this.field_775.field_281 & 128L) != 0L) {
                    var1.method_644().method_1683(this, this.field_775);
                }
                class_341 var14 = var1.method_577();
                class_40 var12;
                if (!this.field_775.method_370()) {
                    if (var4) {
                        var1.method_644().method_1687(this, this.field_775);
                        if (this.field_780.method_166() && (this.field_772.field_446 & 1073741824) == 0 && var14.method_3313(35184372088832L) != -1) {
                            var1.method_644().method_1742(this.field_772, this.field_780);
                        }
                    } else {
                        this.field_772.method_911(var1, this.field_780, this.field_780);
                        var12 = this.field_780.method_138();
                        if (var12 instanceof class_43 && var12.method_140(this.field_775.field_278) == null) {
                            this.field_781 = this.field_775.field_278;
                        }
                    }
                } else {
                    if (!this.field_772.method_752() && !this.field_772.method_754() && !var4) {
                        var1.method_644().method_1705(this, this.field_775);
                    }
                    if (!this.field_772.method_752() && this.field_775.field_278 != this.field_780) {
                        var1.method_644().method_1613(this, this.field_775);
                    }
                }
                method_749(var1, this.field_772, this.field_780, this.field_775, this.field_774, var11, var3, this);
                if (this.field_775.method_356() && this.field_772.method_754()) {
                    var1.method_644().method_1495(this, this.field_775);
                }
                if (this.method_753(this.field_775, var1, true)) {
                    var1.method_644().method_1515(this.field_775, this);
                }
                if (this.field_780.method_147() && this.field_775.field_276 == class_34.field_150 && var14.field_1927 >= 3211264L && class_233.method_1364(this.field_775.field_274, class_17.field_33)) {
                    this.field_675 = this.field_780;
                } else {
                    var12 = this.field_775.field_275;
                    if (var12 != null) {
                        var12 = var12.method_130(var1, this.field_445);
                    }
                    this.field_675 = var12;
                }
                if (this.field_772.method_754() && var14.method_3313(562949953421312L) != -1) {
                    class_33 var16 = var1.method_635().field_403;
                    if (var16 instanceof class_93) {
                        class_93 var19 = (class_93)var16;
                        class_58 var18 = var19.field_488;
                        if (var18.method_366() && class_233.method_1364(this.field_775.field_274, var18.field_274) && this.field_775.method_344(var18)) {
                            var19.field_446 |= 16;
                        }
                    }
                }
                if (this.field_783 != null && this.field_775.method_376().field_279 == class_34.field_157) {
                    var1.method_644().method_1795(this.field_775, this.field_784, this.field_783);
                }
                return (this.field_675.field_178 & 128L) == 0L ? this.field_675 : null;
            }
        }
    }

    public void method_4(class_43 var1) {
        if (var1 != null) {
            this.field_780 = var1;
        }
    }

    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    public void method_928(class_40 var1) {
        this.field_778 = var1;
    }

    public void method_3(int var1) {}

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2035(this, var2)) {
            this.field_772.method_763(var1, var2);
            int var3;
            int var4;
            if (this.field_783 != null) {
                var3 = 0;
                for (var4 = this.field_783.length; var3 < var4; ++var3) {
                    this.field_783[var3].method_763(var1, var2);
                }
            }
            if (this.field_774 != null) {
                var3 = this.field_774.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_774[var4].method_763(var1, var2);
                }
            }
        }
        var1.method_1950(this, var2);
    }
}
