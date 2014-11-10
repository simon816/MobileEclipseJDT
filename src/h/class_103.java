package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_98;
import h.class_99;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_297;
import l.class_301;
import l.class_303;
import m.class_40;
import m.class_86;

public class class_103 extends class_98 {

    public class_98[] field_530;

    public class_126 field_531;

    public class_98[] field_532;

    public class_98 field_533;

    public class_86 field_534;

    private class_74 field_535;

    private class_74 field_536;

    int field_537;

    int field_538;

    int field_539;

    int field_540;

    public class_103(class_98[] var1, class_126 var2, class_98[] var3, class_98 var4, boolean var5, int var6, int var7) {
        this.field_537 = -1;
        this.field_538 = -1;
        this.field_539 = -1;
        this.field_540 = -1;
        this.field_444 = var6;
        this.field_445 = var7;
        this.field_530 = var1;
        this.field_531 = var2;
        this.field_532 = var3;
        this.field_533 = var4;
        if (var4 instanceof class_99) {
            var4.field_446 |= 1;
        }
        if (var5) {
            this.field_446 |= 536870912;
        }
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_74 var10001 = new class_74();
        this.field_535 = var10001;
        var10001 = new class_74();
        this.field_536 = var10001;
        if (this.field_530 != null) {
            int var4 = 0;
            for (int var5 = this.field_530.length; var4 < var5; ++var4) {
                var3 = this.field_530[var4].method_814(this.field_534, var2, var3);
            }
        }
        this.field_537 = var1.method_635().method_729(var3);
        class_331 var20 = this.field_531 == null ? null : this.field_531.field_672;
        boolean var21 = var20 == null || var20 != class_331.field_1896 && var20.method_3257();
        boolean var6 = var20 != null && var20 != class_331.field_1896 && !var20.method_3257();
        var20 = this.field_531 == null ? null : this.field_531.method_922();
        boolean var7 = var20 == null || var20 != class_331.field_1896 && var20.method_3257();
        boolean var8 = var20 != null && var20 != class_331.field_1896 && !var20.method_3257();
        class_297 var9 = null;
        Object var10 = var3.method_3106();
        if (this.field_531 != null && !var21) {
            class_126 var10000 = this.field_531;
            class_86 var18 = this.field_534;
            class_297 var10002 = new class_297(var2, var3, this, (class_74)null, (class_74)null, this.field_534);
            var9 = var10002;
            var10 = var10000.method_814(var18, var10002, (class_301)var10);
        }
        class_297 var11;
        class_303 var12;
        class_301 var13;
        class_297 var19;
        if (this.field_533 != null && (!this.field_533.method_819() || var1.method_577().field_1927 > 3080192L)) {
            var19 = new class_297(var2, var3, this, this.field_535, this.field_536, this.field_534);
            var11 = var19;
            var13 = ((class_301)var10).method_3081();
            this.field_539 = var1.method_635().method_729(var13);
            if (var6) {
                var12 = class_301.field_1784;
            } else {
                var12 = var13.method_3107();
                if (var8) {
                    var12.method_3104(1);
                }
            }
            if (!this.field_533.method_816(var12, this.field_534, false)) {
                var12 = this.field_533.method_814(this.field_534, var11, var12).method_3109();
            }
            if ((var12.field_1783 & var11.field_1749.field_1783 & 1) != 0) {
                this.field_536 = null;
            } else {
                if (var9 != null) {
                    var9.method_3057(this.field_534, (class_301)var10);
                }
                var12 = var12.method_3105(var11.field_1749);
                var11.method_3057(this.field_534, var12);
            }
        } else {
            if (var9 != null) {
                var9.method_3057(this.field_534, (class_301)var10);
            }
            if (var21) {
                if (var9 != null) {
                    var9.method_3058(var1, (class_301)var10);
                }
                return class_301.field_1784;
            }
            if (var6) {
                this.field_536 = null;
            }
            var12 = ((class_301)var10).method_3081().method_3107();
            var19 = new class_297(var2, var3, this, this.field_535, this.field_536, this.field_534);
            var11 = var19;
        }
        var13 = var3.method_3078();
        class_297 var14 = null;
        if (this.field_536 != null) {
            if (this.field_532 != null) {
                var19 = new class_297(var2, var3, this, (class_74)null, (class_74)null, this.field_534);
                var14 = var19;
                Object var15 = var12;
                this.field_538 = var1.method_635().method_729(var12);
                int var16 = 0;
                for (int var17 = this.field_532.length; var16 < var17; ++var16) {
                    var15 = this.field_532[var16].method_814(this.field_534, var14, (class_301)var15);
                }
                var14.method_3057(this.field_534, var12 = ((class_301)var15).method_3109());
            }
            var13.method_3072(var12).method_3071(((class_301)var10).method_3080());
        } else {
            var13.method_3071(((class_301)var10).method_3080());
        }
        if (var9 != null) {
            var9.method_3058(var1, var12);
        }
        var11.method_3058(var1, var12);
        if (var14 != null) {
            var14.method_3058(var1, var12);
        }
        class_303 var22 = class_301.method_3101((class_301)((var11.field_1746.field_1783 & 1) != 0 ? var11.field_1746 : var3.method_3071(var11.field_1746)), var7, var13, var8, !var21);
        this.field_540 = var1.method_635().method_729(var22);
        return var22;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_530 != null) {
                int var4 = 0;
                for (int var5 = this.field_530.length; var4 < var5; ++var4) {
                    this.field_530[var4].method_818(this.field_534, var2);
                }
            }
            class_331 var10 = this.field_531 == null ? null : this.field_531.method_922();
            boolean var11 = var10 != null && var10 != class_331.field_1896 && !var10.method_3257();
            if (var11) {
                this.field_531.method_912(this.field_534, var2, false);
                if ((this.field_446 & 536870912) != 0) {
                    var2.method_2147(this.field_534);
                }
                if (this.field_540 != -1) {
                    var2.method_2363(var1, this.field_540);
                    var2.method_2088(var1, this.field_540);
                }
                var2.method_2360(var3, this.field_444);
            } else {
                class_74 var10000 = new class_74(var2);
                class_74 var6 = var10000;
                var6.field_330 |= 2;
                var10000 = new class_74(var2);
                class_74 var7 = var10000;
                this.field_535.method_456(var2);
                int var8;
                if (this.field_536 == null) {
                    var7.method_458();
                    if (this.field_531 != null && this.field_531.field_672 == class_331.field_1896) {
                        this.field_531.method_913(this.field_534, var2, (class_74)null, this.field_535, true);
                    }
                } else {
                    this.field_536.method_456(var2);
                    if (this.field_531 != null && this.field_531.field_672 == class_331.field_1896 && (this.field_533 != null && !this.field_533.method_819() || this.field_532 != null)) {
                        var7.field_330 |= 2;
                        var8 = var2.field_1208;
                        var2.method_2209(var7);
                        var2.method_2360(var8, this.field_531.field_444);
                    }
                }
                if (this.field_533 != null) {
                    if (this.field_539 != -1) {
                        var2.method_2088(var1, this.field_539);
                    }
                    var6.method_458();
                    this.field_533.method_818(this.field_534, var2);
                } else {
                    var6.method_458();
                }
                if (this.field_538 != -1) {
                    var2.method_2363(var1, this.field_538);
                    var2.method_2088(var1, this.field_538);
                }
                if (this.field_536 != null) {
                    this.field_536.method_458();
                    if (this.field_532 != null) {
                        var8 = 0;
                        for (int var9 = this.field_532.length; var8 < var9; ++var8) {
                            this.field_532[var8].method_818(this.field_534, var2);
                        }
                    }
                    if (this.field_537 != -1) {
                        var2.method_2363(var1, this.field_537);
                    }
                    var7.method_458();
                    if (this.field_531 != null && this.field_531.field_672 == class_331.field_1896) {
                        this.field_531.method_913(this.field_534, var2, var6, (class_74)null, true);
                    } else {
                        var2.method_2209(var6);
                    }
                } else if (this.field_537 != -1) {
                    var2.method_2363(var1, this.field_537);
                }
                if ((this.field_446 & 536870912) != 0) {
                    var2.method_2147(this.field_534);
                }
                if (this.field_540 != -1) {
                    var2.method_2363(var1, this.field_540);
                    var2.method_2088(var1, this.field_540);
                }
                this.field_535.method_458();
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("for (");
        int var3;
        if (this.field_530 != null) {
            for (var3 = 0; var3 < this.field_530.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_530[var3].method_757(0, var2);
            }
        }
        var2.append("; ");
        if (this.field_531 != null) {
            this.field_531.method_924(0, var2);
        }
        var2.append("; ");
        if (this.field_532 != null) {
            for (var3 = 0; var3 < this.field_532.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_532[var3].method_757(0, var2);
            }
        }
        var2.append(") ");
        if (this.field_533 == null) {
            var2.append(';');
        } else {
            var2.append('\n');
            this.field_533.method_820(var1 + 1, var2);
        }
        return var2;
    }

    public void method_821(class_86 var1) {
        class_86 var10001;
        if ((this.field_446 & 536870912) != 0) {
            var10001 = new class_86(var1);
        } else {
            var10001 = var1;
        }
        this.field_534 = var10001;
        int var2;
        int var3;
        if (this.field_530 != null) {
            var2 = 0;
            for (var3 = this.field_530.length; var2 < var3; ++var2) {
                this.field_530[var2].method_821(this.field_534);
            }
        }
        if (this.field_531 != null) {
            class_40 var4 = this.field_531.method_926(this.field_534, class_40.field_186);
            this.field_531.method_911(this.field_534, var4, var4);
        }
        if (this.field_532 != null) {
            var2 = 0;
            for (var3 = this.field_532.length; var2 < var3; ++var2) {
                this.field_532[var2].method_821(this.field_534);
            }
        }
        if (this.field_533 != null) {
            this.field_533.method_821(this.field_534);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2025(this, var2)) {
            int var3;
            int var4;
            if (this.field_530 != null) {
                var3 = this.field_530.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_530[var4].method_763(var1, this.field_534);
                }
            }
            if (this.field_531 != null) {
                this.field_531.method_763(var1, this.field_534);
            }
            if (this.field_532 != null) {
                var3 = this.field_532.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_532[var4].method_763(var1, this.field_534);
                }
            }
            if (this.field_533 != null) {
                this.field_533.method_763(var1, this.field_534);
            }
        }
        var1.method_1940(this, var2);
    }
}
