package h;

import a.class_331;
import c.class_264;
import h.class_116;
import h.class_117;
import h.class_118;
import h.class_126;
import h.class_130;
import h.class_176;
import h.class_89;
import h.class_93;
import h.class_98;
import i.class_268;
import l.class_293;
import l.class_294;
import l.class_299;
import l.class_301;
import m.class_40;
import m.class_58;
import m.class_65;
import m.class_86;
import m.class_87;

// $FF: renamed from: h.ba
public class class_119 extends class_98 {

    // $FF: renamed from: a h.r
    public class_126 field_647;
    // $FF: renamed from: a h.bi[]
    public class_116[] field_648;
    // $FF: renamed from: a m.ab
    public class_65 field_649;
    // $FF: renamed from: a int
    public int field_650;

    // $FF: renamed from: <init> (h.r, int, int) void
    public class_119(class_126 var1, int var2, int var3) {
        this.field_650 = -1;
        this.field_444 = var2;
        this.field_445 = var3;
        this.field_647 = var1;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_647 != null) {
            var3 = this.field_647.method_814(var1, var2, var3);
        }
        this.field_650 = var1.method_635().method_729(var3);
        class_293 var4 = var2;
        int var5 = 0;
        boolean var6 = false;
        boolean var7 = this.method_884();
        do {
            class_116 var8;
            if ((var8 = var4.method_3052()) != null) {
                if (this.field_648 == null) {
                    this.field_648 = new class_116[5];
                }
                if (var5 == this.field_648.length) {
                    System.arraycopy(this.field_648, 0, this.field_648 = new class_116[var5 * 2], 0, var5);
                }
                this.field_648[var5++] = var8;
                if (var8.method_876()) {
                    var6 = false;
                    this.field_446 |= 536870912;
                    break;
                }
            }
            var4.method_3048(var3.method_3109());
            if (var4 instanceof class_294) {
                class_89 var9 = var4.field_1739;
                if (var9 instanceof class_118) {
                    this.field_446 |= 1073741824;
                } else if (var9 instanceof class_117) {
                    class_117 var10 = (class_117)var9;
                    var3.method_3071(var10.field_624);
                    if (var7) {
                        if (this.field_649 == null) {
                            this.method_886(var10);
                        }
                        var6 = true;
                    }
                }
            } else if (var4 instanceof class_299) {
                var1.method_644().method_1502(this);
                return class_301.field_1784;
            }
        } while ((var4 = var4.field_1740) != null);
        if (this.field_648 != null && var5 != this.field_648.length) {
            System.arraycopy(this.field_648, 0, this.field_648 = new class_116[var5], 0, var5);
        }
        if (var6) {
            if (this.field_649 != null) {
                this.field_649.field_307 = 1;
            }
        } else {
            this.field_649 = null;
            if ((this.field_446 & 1073741824) == 0 && this.field_647 != null && this.field_647.field_675 == class_40.field_186) {
                this.field_647.field_446 |= 16;
            }
        }
        return class_301.field_1784;
    }

    // $FF: renamed from: a (m.v, i.o) void
    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            boolean var4 = false;
            if (this.method_884()) {
                var4 = true;
                this.field_647.method_912(var1, var2, this.method_885());
                this.method_883(var2);
            }
            if (this.field_648 != null) {
                Object var5 = this.field_647 == null ? class_40.field_188 : this.field_647.method_927();
                int var6 = 0;
                for (int var7 = this.field_648.length; var6 < var7; ++var6) {
                    class_116 var8 = this.field_648[var6];
                    boolean var9 = var8.method_875(var1, var2, var5, this.field_650, this.field_649);
                    if (var9) {
                        var2.method_2360(var3, this.field_444);
                        class_116.method_871(this.field_648, var6, var2);
                        return;
                    }
                }
            }
            if (this.field_649 != null) {
                var2.method_2091(this.field_649);
                var2.method_2324(this.field_649);
            }
            if (this.field_647 != null && !var4) {
                this.field_647.method_912(var1, var2, true);
                this.method_883(var2);
            }
            this.method_882(var2);
            if (this.field_649 != null) {
                var2.method_2365(this.field_649);
            }
            if (this.field_650 != -1) {
                var2.method_2363(var1, this.field_650);
                var2.method_2088(var1, this.field_650);
            }
            var2.method_2360(var3, this.field_444);
            class_116.method_871(this.field_648, -1, var2);
        }
    }

    // $FF: renamed from: a (i.o) void
    public void method_882(class_268 var1) {
        var1.method_2192(this.field_647);
    }

    // $FF: renamed from: b (i.o) void
    public void method_883(class_268 var1) {
        if (this.field_649 != null) {
            var1.method_2376(this.field_649, false);
        }
    }

    // $FF: renamed from: f () boolean
    private boolean method_884() {
        return this.field_647 != null && (this.field_647.field_672 == class_331.field_1896 || (this.field_647.field_674 & 512) != 0) && !(this.field_647 instanceof class_176);
    }

    // $FF: renamed from: a () boolean
    public boolean method_885() {
        return this.field_649 != null || (this.field_446 & 1073741824) != 0 || (this.field_446 & 536870912) == 0;
    }

    // $FF: renamed from: a (h.bl) void
    public void method_886(class_117 var1) {
        this.field_649 = var1.field_630;
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("return ");
        if (this.field_647 != null) {
            this.field_647.method_924(0, var2);
        }
        return var2.append(';');
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {
        class_87 var2 = var1.method_635();
        Object var10000;
        if (var2.field_403 instanceof class_93) {
            class_58 var3 = ((class_93)var2.field_403).field_488;
            var10000 = ((class_93)var2.field_403).field_488 == null ? null : var3.field_275;
        } else {
            var10000 = class_40.field_188;
        }
        Object var4 = var10000;
        class_40 var5;
        if (var4 == class_40.field_188) {
            if (this.field_647 != null) {
                if ((var5 = this.field_647.method_925(var1)) != null) {
                    var1.method_644().method_1483(this, var5);
                }
            }
        } else if (this.field_647 == null) {
            if (var4 != null) {
                var1.method_644().method_1754((class_40)var4, this);
            }
        } else {
            this.field_647.method_928((class_40)var4);
            if ((var5 = this.field_647.method_925(var1)) != null) {
                if (var5 == class_40.field_188) {
                    var1.method_644().method_1484(this);
                } else if (var4 != null) {
                    if (var4 != var5) {
                        var1.method_576().method_692((class_40)var4, var5);
                    }
                    if (!this.field_647.method_919(var5, (class_40)var4) && !var5.method_152((class_40)var4)) {
                        if (!var1.method_624(var5, (class_40)var4) && (!var5.method_148() || var1.method_577().field_1928 < 3211264L || ((class_40)var4).method_148() || !this.field_647.method_919(var5, var1.method_586().method_486((class_40)var4)))) {
                            if ((((class_40)var4).field_178 & 128L) == 0L) {
                                var1.method_644().method_1777(var5, (class_40)var4, this.field_647, (class_89)null);
                            }
                        } else {
                            this.field_647.method_911(var1, (class_40)var4, var5);
                            if (this.field_647 instanceof class_130 && (this.field_647.field_446 & 16416) == 0) {
                                class_130.method_933(var1, (class_40)var4, (class_130)this.field_647);
                            }
                        }
                    } else {
                        this.field_647.method_911(var1, (class_40)var4, var5);
                        if (var5.method_174((class_40)var4)) {
                            var1.method_644().method_1806(this.field_647, var5, (class_40)var4);
                        }
                        if (this.field_647 instanceof class_130 && (this.field_647.field_446 & 16416) == 0) {
                            class_130.method_933(var1, (class_40)var4, (class_130)this.field_647);
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2053(this, var2) && this.field_647 != null) {
            this.field_647.method_763(var1, var2);
        }
        var1.method_1968(this, var2);
    }
}
