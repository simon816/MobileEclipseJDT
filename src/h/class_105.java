package h;

import c.class_264;
import h.class_126;
import h.class_130;
import h.class_146;
import h.class_148;
import h.class_89;
import h.class_93;
import h.class_94;
import h.class_98;
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
import m.class_57;
import m.class_58;
import m.class_61;
import m.class_86;
import m.class_87;

public class class_105 extends class_98 implements class_0 {

    public class_126[] field_546;

    public class_126 field_547;

    public class_58 field_548;

    protected class_58 field_549;

    class_58 field_550;

    public int field_551;

    public class_146[] field_552;

    public class_40[] field_553;

    public int field_554;

    public class_105(int var1) {
        this.field_551 = var1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        Object var10;
        try {
            ((class_87)var1).field_405 = true;
            if (this.field_547 != null) {
                var3 = this.field_547.method_814(var1, var2, (class_301)var3).method_3109();
            }
            if (this.field_546 != null) {
                int var4 = 0;
                for (int var5 = this.field_546.length; var4 < var5; ++var4) {
                    var3 = this.field_546[var4].method_814(var1, var2, (class_301)var3).method_3109();
                }
            }
            class_43[] var9 = this.field_548.field_277;
            if (this.field_548.field_277 != class_34.field_151) {
                var2.method_3033(var9, (class_89)(this.field_551 == 1 ? (class_89)var1.method_635().field_403 : this), (class_301)var3, var1);
            }
            this.method_832(var1, (class_301)var3);
            this.method_833(var1, (class_301)var3);
            var10 = var3;
        } finally {
            ((class_87)var1).field_405 = false;
        }
        return (class_301)var10;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            try {
                ((class_87)var1).field_405 = true;
                int var3 = var2.field_1208;
                var2.method_2093();
                class_43 var4 = this.field_549.field_278;
                if (var4.method_138().field_177 == 41 || var4.method_153()) {
                    var2.method_2094();
                    var2.method_2249();
                }
                if (var4.method_160()) {
                    var2.method_2201(var1, var4, (this.field_446 & 8192) != 0 ? null : this.field_547, this);
                }
                this.method_817(this.field_548, this.field_546, var1, var2);
                if (var4.method_160()) {
                    var2.method_2202(var1, var4, this);
                }
                if (this.field_550 != null) {
                    int var5 = 0;
                    for (int var6 = this.field_550.field_276.length - this.field_549.field_276.length; var5 < var6; ++var5) {
                        var2.method_2087();
                    }
                    var2.method_2272(this.field_550);
                } else {
                    var2.method_2272(this.field_549);
                }
                var2.method_2360(var3, this.field_444);
            } finally {
                ((class_87)var1).field_405 = false;
            }
        }
    }

    public class_40[] method_0() {
        return this.field_553;
    }

    public boolean method_831() {
        return this.field_551 == 1;
    }

    public boolean method_1() {
        return this.field_551 != 3;
    }

    void method_832(class_86 var1, class_301 var2) {
        class_43 var3 = (class_43)this.field_548.field_278.method_138();
        if ((var2.field_1783 & 1) == 0 && var3.method_160() && var1.method_585().method_158()) {
            if (var3.method_158()) {
                ((class_57)var3).method_334(var1, this.field_547 != null);
            } else {
                var1.method_717(var3, this.field_547 != null);
            }
        }
    }

    public void method_833(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            this.field_549 = this.field_548.method_376();
            if (this.field_548.method_367() && this.field_551 != 3) {
                class_43 var3 = this.field_549.field_278;
                if ((var3.field_178 & 16L) != 0L && var1.method_577().field_1927 >= 3145728L) {
                    this.field_549.field_281 |= 1024L;
                } else {
                    this.field_550 = ((class_54)var3).method_302(this.field_549, this.method_1());
                    var1.method_644().method_1691(this.field_549, this);
                }
            }
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2);
        if (this.field_547 != null) {
            this.field_547.method_924(0, var2).append('.');
        }
        int var3;
        if (this.field_552 != null) {
            var2.append('<');
            var3 = this.field_552.length - 1;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.field_552[var4].method_757(0, var2);
                var2.append(", ");
            }
            this.field_552[var3].method_757(0, var2);
            var2.append('>');
        }
        if (this.field_551 == 3) {
            var2.append("this(");
        } else {
            var2.append("super(");
        }
        if (this.field_546 != null) {
            for (var3 = 0; var3 < this.field_546.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_546[var3].method_924(0, var2);
            }
        }
        return var2.append(");");
    }

    public void method_821(class_86 var1) {
        class_87 var2 = var1.method_635();
        try {
            class_93 var3 = var2.method_730();
            if (var3 == null || !var3.method_795() || ((class_94)var3).field_493 != this) {
                var1.method_644().method_1627(this);
                if (this.field_547 != null) {
                    this.field_547.method_925(var1);
                }
                int var16;
                int var18;
                if (this.field_552 != null) {
                    var16 = 0;
                    for (var18 = this.field_552.length; var16 < var18; ++var16) {
                        this.field_552[var16].method_1017(var1, true);
                    }
                }
                if (this.field_546 != null) {
                    var16 = 0;
                    for (var18 = this.field_546.length; var16 < var18; ++var16) {
                        this.field_546[var16].method_925(var1);
                    }
                }
            } else {
                var2.field_405 = true;
                class_43 var4 = var1.method_584();
                boolean var5 = false;
                if (this.field_551 != 3) {
                    var4 = var4.method_240();
                    class_146 var6 = var1.method_718().field_581;
                    if (var6 != null && var6.field_675 != null && !var6.field_675.method_101()) {
                        var5 = true;
                    }
                }
                if (var4 != null) {
                    if (this.field_551 == 2 && var4.method_138().field_177 == 41) {
                        var1.method_644().method_1499(this, var2.method_730().field_488);
                    }
                    if (this.field_547 != null) {
                        if (this.field_551 != 2) {
                            var1.method_644().method_1792(this.field_547, var4);
                        }
                        if (!var5) {
                            class_43 var19 = var4.method_137();
                            if (var19 == null) {
                                var1.method_644().method_1792(this.field_547, var4);
                                this.field_446 |= 8192;
                            } else {
                                class_40 var7 = this.field_547.method_926(var1, var19);
                                this.field_547.method_911(var1, var7, var7);
                            }
                        }
                    }
                }
                int var24;
                if (this.field_552 != null) {
                    boolean var17 = var1.method_577().field_1928 < 3211264L;
                    int var20 = this.field_552.length;
                    this.field_553 = new class_40[var20];
                    int var8;
                    for (var8 = 0; var8 < var20; ++var8) {
                        class_146 var9 = this.field_552[var8];
                        if ((this.field_553[var8] = var9.method_1017(var1, true)) == null) {
                            var17 = true;
                        }
                        if (var17 && var9 instanceof class_148) {
                            var1.method_644().method_1599(var9);
                        }
                    }
                    if (var17) {
                        if (this.field_546 == null) {
                            return;
                        }
                        var8 = 0;
                        for (var24 = this.field_546.length; var8 < var24; ++var8) {
                            this.field_546[var8].method_925(var1);
                        }
                        return;
                    }
                }
                class_40[] var22 = class_34.field_150;
                boolean var21 = false;
                if (this.field_546 == null) {
                    if (var4.method_138().field_177 == 41) {
                        var22 = new class_40[] {var1.method_610(), class_40.field_179};
                    }
                } else {
                    boolean var23 = false;
                    var24 = this.field_546.length;
                    var22 = new class_40[var24];
                    for (int var10 = 0; var10 < var24; ++var10) {
                        class_126 var11 = this.field_546[var10];
                        if (var11 instanceof class_130) {
                            var11.field_446 |= 32;
                            var21 = true;
                        }
                        if ((var22[var10] = var11.method_925(var1)) == null) {
                            var23 = true;
                        }
                    }
                    if (var23) {
                        if (var4 != null) {
                            class_40[] var26 = new class_40[var24];
                            int var25 = var24;
                            while (true) {
                                --var25;
                                if (var25 < 0) {
                                    this.field_548 = var1.method_592(var4, class_17.field_135, var26, this);
                                    if (this.field_548 != null && !this.field_548.method_101()) {
                                        Object var27 = ((class_61)this.field_548).field_291;
                                        if (var27 != null) {
                                            if (((class_58)var27).method_376().field_279 != class_34.field_157) {
                                                var27 = var1.method_586().method_498(((class_58)var27).method_376(), (class_53)null);
                                            }
                                            this.field_548 = (class_58)var27;
                                            class_58 var12 = ((class_58)var27).method_376();
                                            if ((var12.method_367() || var12.field_278.method_158()) && !var1.method_626(var12)) {
                                                var12.field_273 |= 134217728;
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                var26[var25] = (class_40)(var22[var25] == null ? class_40.field_187 : var22[var25]);
                            }
                        }
                        return;
                    }
                }
                if (var4 != null) {
                    if ((this.field_548 = var1.method_599(var4, var22, this)).method_101()) {
                        if ((this.field_548.field_281 & 128L) != 0L && !var2.method_585().method_146()) {
                            var1.method_644().method_1682(this, this.field_548);
                        }
                        if (this.method_753(this.field_548, var1, this.field_551 != 1)) {
                            var1.method_644().method_1515(this.field_548, this);
                        }
                        method_749(var1, (class_126)null, var4, this.field_548, this.field_546, var22, var21, this);
                        if (this.field_548.method_367() || var4.method_158()) {
                            class_58 var10000 = this.field_548.method_376();
                            var10000.field_273 |= 134217728;
                        }
                        if (this.field_552 != null && this.field_548.method_376().field_279 == class_34.field_157) {
                            var1.method_644().method_1795(this.field_548, this.field_553, this.field_552);
                            return;
                        }
                    } else {
                        if (this.field_548.field_278 == null) {
                            this.field_548.field_278 = var4;
                        }
                        if (var5) {
                            return;
                        }
                        var1.method_644().method_1624(this, this.field_548);
                    }
                }
            }
        } finally {
            var2.field_405 = false;
        }
    }

    public void method_4(class_43 var1) {}

    public void method_2(int var1) {}

    public void method_3(int var1) {}

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2018(this, var2)) {
            if (this.field_547 != null) {
                this.field_547.method_763(var1, var2);
            }
            int var3;
            int var4;
            if (this.field_552 != null) {
                var3 = 0;
                for (var4 = this.field_552.length; var3 < var4; ++var3) {
                    this.field_552[var3].method_763(var1, var2);
                }
            }
            if (this.field_546 != null) {
                var3 = 0;
                for (var4 = this.field_546.length; var3 < var4; ++var3) {
                    this.field_546[var3].method_763(var1, var2);
                }
            }
        }
        var1.method_1933(this, var2);
    }
}
