package h;

import a.class_331;
import c.class_264;
import h.class_114;
import h.class_126;
import h.class_93;
import h.class_95;
import h.class_98;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_40;
import m.class_43;
import m.class_54;
import m.class_67;
import m.class_86;

// $FF: renamed from: h.ca
public class class_106 extends class_98 {

    // $FF: renamed from: a h.r
    public class_126 field_555;
    // $FF: renamed from: b h.r
    public class_126 field_556;
    // $FF: renamed from: a int
    int field_557;
    // $FF: renamed from: a m.k
    private class_67 field_558;

    // $FF: renamed from: <init> (h.r, h.r, int) void
    public class_106(class_126 var1, class_126 var2, int var3) {
        this.field_557 = -1;
        this.field_555 = var2;
        this.field_556 = var1;
        this.field_444 = var3;
        this.field_445 = var1.field_445;
    }

    // $FF: renamed from: <init> (h.r, int) void
    public class_106(class_126 var1, int var2) {
        this.field_557 = -1;
        this.field_555 = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.field_557 = var1.method_635().method_729(var3);
        class_331 var4 = this.field_555.method_922();
        boolean var5 = var4 != class_331.field_1896 && var4.method_3257();
        boolean var6 = var4 != class_331.field_1896 && !var4.method_3257();
        class_301 var7 = this.field_555.method_814(var1, var2, var3.method_3078());
        class_303 var8 = var7.method_3081().method_3109();
        class_303 var9 = var7.method_3107();
        if (var5) {
            var9.method_3104(1);
        }
        if (this.field_556 != null) {
            class_301 var10 = this.field_556.method_814(var1, var2, var9.method_3078());
            if (!var5) {
                var2.method_3032(var1.method_605(), this, var10, var1);
            }
        }
        if (!var5) {
            this.method_836(var1, var3);
        }
        return var6 ? var3 : var3.method_3105(var9.method_3106()).method_3071(var8.method_3114());
    }

    // $FF: renamed from: a (m.v, i.o) void
    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_558 != null) {
                class_74 var10000 = new class_74(var2);
                class_74 var4 = var10000;
                var2.method_2207(this.field_558);
                var2.method_2242(var4);
                class_126 var6 = this.field_555;
                class_74 var10003 = new class_74(var2);
                class_74 var5 = var10003;
                var6.method_913(var1, var2, var10003, (class_74)null, true);
                var2.method_2346();
                var2.method_2141();
                if (this.field_556 != null) {
                    this.field_556.method_912(var1, var2, true);
                    var2.method_2262(this.field_556.field_674 & 15);
                } else {
                    var2.method_2263();
                }
                var2.method_2107();
                if (this.field_557 != -1) {
                    var2.method_2363(var1, this.field_557);
                }
                var5.method_458();
                var4.method_458();
            } else if (this.field_557 != -1) {
                var2.method_2363(var1, this.field_557);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {
        this.field_555.method_926(var1, class_40.field_186);
        if (this.field_556 != null) {
            class_40 var2 = this.field_556.method_925(var1);
            if (var2 != null) {
                int var3 = var2.field_177;
                switch (var3) {
                    case 6:
                        var1.method_644().method_1605(this.field_556);
                    default:
                        var3 = 1;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        this.field_556.field_674 = (var3 << 4) + var3;
                }
            }
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2000(this, var2)) {
            this.field_555.method_763(var1, var2);
            if (this.field_556 != null) {
                this.field_556.method_763(var1, var2);
            }
        }
        var1.method_1915(this, var2);
    }

    // $FF: renamed from: a (m.v, l.g) void
    public void method_836(class_86 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            class_54 var3;
            class_43 var4;
            for (var3 = var1.method_585(); var3.method_158(); var3 = (class_54)var4) {
                var4 = var3.method_137();
                if (var4 == null || var4.method_157()) {
                    break;
                }
            }
            this.field_558 = var3.method_296(var1);
            class_114 var9 = var3.field_258.method_671();
            class_93[] var5 = var9.field_584;
            int var6 = 0;
            for (int var7 = var5.length; var6 < var7; ++var6) {
                class_93 var8 = var5[var6];
                if (var8.method_794()) {
                    ((class_95)var8).method_813(this.field_558, var1.method_577().field_1928 < 3211264L);
                    break;
                }
            }
        }
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2);
        var2.append("assert ");
        this.field_555.method_924(0, var2);
        if (this.field_556 != null) {
            var2.append(": ");
            this.field_556.method_924(0, var2);
        }
        return var2.append(';');
    }
}
