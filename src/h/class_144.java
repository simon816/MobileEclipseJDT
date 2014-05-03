package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_130;
import h.class_141;
import i.class_268;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.cc
public class class_144 extends class_141 {

    // $FF: renamed from: a int
    public int field_720;
    // $FF: renamed from: b int
    public int field_721;
    // $FF: renamed from: c int
    public static int field_722;
    // $FF: renamed from: a h.by[]
    public class_141[] field_723;

    // $FF: renamed from: <init> (h.r, h.r, int, int) void
    public class_144(class_126 var1, class_126 var2, int var3, int var4) {
        super(var1, var2, var3);
        this.method_1003(var1, var4);
    }

    // $FF: renamed from: <init> (h.cc) void
    public class_144(class_144 var1) {
        super(var1);
        this.method_1003(var1.field_715, var1.field_720);
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_723 == null) {
            return super.method_814(var1, var2, var3);
        } else {
            class_141 var4;
            if ((var4 = this.field_723[0]).field_675.field_177 != 11) {
                var4.field_715.method_909(var1, var2, var3);
            }
            class_303 var7 = var4.field_715.method_814(var1, var2, var3).method_3109();
            int var5 = 0;
            for (int var6 = this.field_720; var5 < var6; ++var5) {
                if ((var4 = this.field_723[var5]).field_675.field_177 != 11) {
                    var4.field_716.method_909(var1, var2, var7);
                }
                var7 = var4.field_716.method_814(var1, var2, var7).method_3109();
            }
            if (this.field_675.field_177 != 11) {
                this.field_716.method_909(var1, var2, var7);
            }
            return this.field_716.method_814(var1, var2, var7).method_3109();
        }
    }

    // $FF: renamed from: a (m.v, i.o, int) void
    public void method_914(class_86 var1, class_268 var2, int var3) {
        if (this.field_723 == null) {
            super.method_914(var1, var2, var3);
        } else if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11) {
            if (this.field_672 != class_331.field_1896) {
                var2.method_2179(this.field_672, this.field_674);
                var2.method_2274(this.field_674 & 15);
            } else {
                class_141 var4 = this.field_723[0];
                boolean var5 = false;
                int var6 = var2.field_1208;
                int var9;
                for (var9 = this.field_720 - 1; var9 >= 0; --var9) {
                    if ((var4 = this.field_723[var9]).field_672 != class_331.field_1896) {
                        var2.method_2179(var4.field_672, var4.field_674);
                        var2.method_2274(var4.field_674 & 15);
                        break;
                    }
                }
                ++var9;
                if (var9 == 0) {
                    var4.field_715.method_914(var1, var2, var4.field_715.field_674 & 15);
                }
                for (int var8 = var9; var8 < this.field_720; ++var8) {
                    var2.method_2360(var6, (var4 = this.field_723[var8]).field_715.field_444);
                    int var7 = var2.field_1208;
                    var4.field_716.method_914(var1, var2, var4.field_716.field_674 & 15);
                    var2.method_2360(var7, var4.field_716.field_444);
                }
                var2.method_2360(var6, this.field_715.field_444);
                var6 = var2.field_1208;
                this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
                var2.method_2360(var6, this.field_716.field_444);
            }
        } else {
            super.method_914(var1, var2, var3);
        }
    }

    // $FF: renamed from: b (m.v, i.o, int) void
    public void method_915(class_86 var1, class_268 var2, int var3) {
        if (this.field_723 == null) {
            super.method_915(var1, var2, var3);
        } else if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11 && this.field_672 == class_331.field_1896) {
            int var4 = var2.field_1208;
            class_141 var5 = this.field_723[this.field_720 - 1];
            boolean var6 = false;
            int var9;
            for (var9 = this.field_720 - 1; var9 >= 0; --var9) {
                if (((var5 = this.field_723[var9]).field_446 & 4032) >> 6 != 14 || (var5.field_446 & 15) != 11) {
                    var5.method_915(var1, var2, var5.field_674 & 15);
                    break;
                }
                if (var5.field_672 != class_331.field_1896) {
                    var2.method_2349();
                    var2.method_2141();
                    var2.method_2311(var5.field_672.method_3287());
                    var2.method_2276();
                    break;
                }
            }
            ++var9;
            if (var9 == 0) {
                var5.field_715.method_915(var1, var2, var5.field_715.field_674 & 15);
            }
            for (int var8 = var9; var8 < this.field_720; ++var8) {
                var2.method_2360(var4, (var5 = this.field_723[var8]).field_715.field_444);
                int var7 = var2.field_1208;
                var5.field_716.method_914(var1, var2, var5.field_716.field_674 & 15);
                var2.method_2360(var7, var5.field_716.field_444);
            }
            var2.method_2360(var4, this.field_715.field_444);
            var4 = var2.field_1208;
            this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
            var2.method_2360(var4, this.field_716.field_444);
        } else {
            super.method_915(var1, var2, var3);
        }
    }

    // $FF: renamed from: a (h.r, int) void
    private void method_1003(class_126 var1, int var2) {
        this.field_720 = var2;
        if (var2 > 1) {
            this.field_723 = new class_141[var2];
            this.field_723[var2 - 1] = (class_141)var1;
            for (int var3 = var2 - 1; var3 > 0; --var3) {
                this.field_723[var3 - 1] = (class_141)this.field_723[var3].field_715;
            }
        } else {
            this.field_721 = field_722;
        }
    }

    // $FF: renamed from: a_ (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_975(int var1, StringBuffer var2) {
        if (this.field_723 == null) {
            return super.method_975(var1, var2);
        } else {
            String var3 = this.method_974();
            int var4;
            for (var4 = this.field_720 - 1; var4 >= 0; --var4) {
                var2.append('(');
            }
            var2 = this.field_723[0].field_715.method_924(var1, var2);
            var4 = 0;
            for (int var5 = this.field_720; var4 < var5; ++var4) {
                var2.append(' ').append(var3).append(' ');
                var2 = this.field_723[var4].field_716.method_924(0, var2);
                var2.append(')');
            }
            var2.append(' ').append(var3).append(' ');
            return this.field_716.method_924(0, var2);
        }
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        if (this.field_723 == null) {
            return super.method_925(var1);
        } else {
            class_141 var2;
            if ((var2 = this.field_723[0]).field_715 instanceof class_130) {
                var2.field_715.field_446 |= 32;
            }
            var2.field_715.method_925(var1);
            int var3 = 0;
            for (int var4 = this.field_720; var3 < var4; ++var3) {
                this.field_723[var3].method_992(var1);
            }
            this.method_992(var1);
            return this.field_675;
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (this.field_723 == null) {
            super.method_763(var1, var2);
        } else {
            if (var1.method_2002(this, var2)) {
                int var3;
                for (var3 = this.field_720 - 1; var3 >= 0; --var3) {
                    if (!var1.method_2002(this.field_723[var3], var2)) {
                        var1.method_1917(this.field_723[var3], var2);
                        break;
                    }
                }
                ++var3;
                if (var3 == 0) {
                    this.field_723[0].field_715.method_763(var1, var2);
                }
                int var4 = var3;
                for (int var5 = this.field_720; var4 < var5; ++var4) {
                    this.field_723[var4].field_716.method_763(var1, var2);
                    var1.method_1917(this.field_723[var4], var2);
                }
                this.field_716.method_763(var1, var2);
            }
            var1.method_1917(this, var2);
        }
    }

    // $FF: renamed from: c () void
    public void method_1004() {
        if (this.field_721 < 160) {
            this.field_721 *= 2;
        }
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_722 = 20;
    }
}
