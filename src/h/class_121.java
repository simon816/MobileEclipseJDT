package h;

import a.class_331;
import c.class_264;
import f.Util;
import h.class_120;
import h.class_128;
import h.class_130;
import h.class_131;
import h.class_89;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_34;
import m.class_40;
import m.class_41;
import m.class_42;
import m.class_54;
import m.class_67;
import m.class_83;
import m.class_84;
import m.class_86;
import m.class_87;
import n.ProblemReporter;

public class class_121 extends class_120 {

    public class_67 field_661;

    public int field_662;

    public int field_663;

    public class_121() {
    }

    public class_121(char[] var1, int var2, int var3) {
        this.field_659 = var1;
        this.field_444 = var2;
        this.field_445 = var3;
    }

    public class_301 method_890(class_87 var1, class_293 var2, class_301 var3) {
        if (this.field_661 != null && !this.field_661.method_433() && (this.field_661.method_428() || this.field_661.field_314 != null && this.field_661.field_314.method_158()) && !var1.method_645().field_455.field_1692) {
            var1.method_644().method_1813(this);
        }
        if (this.field_661 != null && this.field_661.method_101() && this.field_661.method_431() && this.field_661.method_407() == class_331.field_1896 && this.field_661.field_314.method_160() && !this.field_661.field_314.method_226()) {
            var1.method_644().method_1784((class_54)this.field_661.field_314, this);
        }
        if (this.field_655 != null) {
            var3 = this.field_655.method_814(var1, var2, (class_301)var3).method_3109();
            ((class_301)var3).method_3096(this.field_661);
        }
        return (class_301)var3;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            boolean var4;
            if (this.field_655 != null && (!(var4 = this.field_661.method_431()) || this.field_661.method_407() == class_331.field_1896)) {
                if (!var4) {
                    var2.method_2093();
                }
                this.field_655.method_912(var1, var2, true);
                if (var4) {
                    var2.method_2357(this.field_661);
                } else {
                    var2.method_2356(this.field_661);
                }
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public int method_887() {
        return this.field_660 == null ? 3 : 1;
    }

    public boolean method_891() {
        return this.field_661 != null ? this.field_661.method_431() : (this.field_656 & 8) != 0;
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        return super.method_820(var1, var2);
    }

    public void method_892(class_87 var1) {
        if ((this.field_446 & 16) == 0) {
            if (this.field_661 != null && this.field_661.method_101()) {
                this.field_446 |= 16;
                class_84 var2 = var1.method_582();
                if (var2 != null) {
                    label338: {
                        class_54 var3 = var2.method_585();
                        if (var3.field_252 != null) {
                            class_67 var4 = var2.method_590(var3.field_252, this.field_659, this, false);
                            if (var4 != null && var4.method_101()) {
                                label334: {
                                    if (var4 instanceof class_67) {
                                        class_67 var5 = (class_67)var4;
                                        if (var5.method_435() == this.field_661 || !var5.method_423(var3, this, var1)) {
                                            break label334;
                                        }
                                    }
                                    var1.method_644().method_1548(this, var4);
                                    break label338;
                                }
                            }
                        }
                        class_83 var13 = var2.field_374;
                        if (var13.field_373 != 4) {
                            class_34 var15 = var13.method_598(this.field_659, 3, this, false);
                            if (var15 != null && var15.method_101() && var15 != this.field_661) {
                                label323: {
                                    if (var15 instanceof class_67) {
                                        class_67 var6 = (class_67)var15;
                                        if (var6.method_435() == this.field_661 || !var6.method_431() && var3.method_226()) {
                                            break label323;
                                        }
                                    }
                                    var1.method_644().method_1548(this, var15);
                                }
                            }
                        }
                    }
                }
                if (this.field_660 != null) {
                    this.field_660.field_675 = this.field_661.field_301;
                }
                class_67 var12 = var1.field_406;
                int var14 = var1.field_407;
                try {
                    var1.field_406 = this.field_661;
                    var1.field_407 = this.field_661.field_304;
                    method_761(var1, this.field_658, this.field_661);
                    if ((this.field_661.method_99() & 70368744177664L) == 0L && (this.field_661.field_300 & 1048576) != 0 && var1.method_577().field_1928 >= 3211264L) {
                        var1.method_644().method_1675(this);
                    }
                    if (this.field_655 == null) {
                        this.field_661.method_410(class_331.field_1896);
                    } else {
                        this.field_661.method_410(class_331.field_1896);
                        class_40 var17 = this.field_661.field_301;
                        this.field_655.method_928(var17);
                        class_40 var18;
                        if (this.field_655 instanceof class_128) {
                            if ((var18 = this.field_655.method_926(var1, var17)) != null) {
                                ((class_128)this.field_655).field_680 = (class_42)var18;
                                this.field_655.method_911(var1, var17, var18);
                            }
                        } else if ((var18 = this.field_655.method_925(var1)) != null) {
                            if (var17 != var18) {
                                var1.method_576().method_692(var17, var18);
                            }
                            if (!this.field_655.method_919(var18, var17) && (!var17.method_148() || !class_41.method_185(var17.field_177, var18.field_177)) && !var18.method_152(var17)) {
                                if (!var1.method_624(var18, var17) && (!var18.method_148() || var1.method_577().field_1928 < 3211264L || var17.method_148() || !this.field_655.method_919(var18, var1.method_586().method_486(var17)))) {
                                    if ((var17.field_178 & 128L) == 0L) {
                                        var1.method_644().method_1777(var18, var17, this.field_655, (class_89)null);
                                    }
                                } else {
                                    this.field_655.method_911(var1, var17, var18);
                                    if (this.field_655 instanceof class_130 && (this.field_655.field_446 & 16384) == 0) {
                                        class_130.method_933(var1, var17, (class_130)this.field_655);
                                    }
                                }
                            } else {
                                this.field_655.method_911(var1, var17, var18);
                                if (var18.method_174(var17)) {
                                    var1.method_644().method_1806(this.field_655, var18, var17);
                                }
                                if (this.field_655 instanceof class_130 && (this.field_655.field_446 & 16384) == 0) {
                                    class_130.method_933(var1, var17, (class_130)this.field_655);
                                }
                            }
                            if (this.field_661.method_409()) {
                                this.field_661.method_410(this.field_655.field_672.method_3259((this.field_661.field_301.field_177 << 4) + this.field_655.field_672.method_3288()));
                            }
                        } else {
                            this.field_661.method_410(class_331.field_1896);
                        }
                        if (this.field_661 == class_131.method_944(this.field_655)) {
                            var1.method_644().method_1481(this, this.field_659);
                        }
                    }
                    if (this.field_661 != null && this.field_661.field_314 != null && !this.field_661.field_314.method_158()) {
                        int var16 = this.field_661.field_300 & 7;
                        ProblemReporter var19 = var1.method_644();
                        int var7 = var19.method_1449(-1610612250);
                        if (var7 != -1) {
                            if (var2 != null) {
                                var16 = Util.method_1318(var2.method_671(), var16);
                            }
                            int var8 = this.field_661.field_300 & -8 | var16;
                        }
                    }
                } finally {
                    var1.field_406 = var12;
                    var1.field_407 = var14;
                    if (this.field_661.method_407() == null) {
                        this.field_661.method_410(class_331.field_1896);
                    }
                }
            }
        }
    }

    public void method_893(class_264 var1, class_87 var2) {
        if (var1.method_2021(this, var2)) {
            if (this.field_658 != null) {
                int var3 = this.field_658.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_658[var4].method_763(var1, var2);
                }
            }
            if (this.field_660 != null) {
                this.field_660.method_763(var1, var2);
            }
            if (this.field_655 != null) {
                this.field_655.method_763(var1, var2);
            }
        }
        var1.method_1936(this, var2);
    }
}
