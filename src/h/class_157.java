package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_131;
import h.class_132;
import h.class_154;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_86;
import m.class_87;

// $FF: renamed from: h.bm
public class class_157 extends class_154 {

    // $FF: renamed from: a () h.bm
    public static class_157 method_1044() {
        class_157 var10000 = new class_157(0, 0);
        class_157 var0 = var10000;
        var0.field_446 |= 4;
        return var0;
    }

    // $FF: renamed from: <init> (int, int) void
    public class_157(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    // $FF: renamed from: a (m.v, l.j, l.g, h.cb, boolean) l.g
    public class_301 method_1035(class_86 var1, class_293 var2, class_301 var3, class_131 var4, boolean var5) {
        return var3;
    }

    // $FF: renamed from: a (m.aj) boolean
    public boolean method_1046(class_87 var1) {
        if (var1.field_405) {
            var1.method_644().method_1549(this);
            return false;
        } else if (var1.field_404) {
            var1.method_644().method_1546(this);
            return false;
        } else {
            return true;
        }
    }

    // $FF: renamed from: a (m.v, i.o, h.cb, boolean) void
    public void method_1038(class_86 var1, class_268 var2, class_131 var3, boolean var4) {}

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2093();
        }
        if ((this.field_446 & 4) == 0) {
            var2.method_2360(var4, this.field_444);
        }
    }

    // $FF: renamed from: a (m.v, i.o, h.r, int, int, boolean) void
    public void method_1039(class_86 var1, class_268 var2, class_126 var3, int var4, int var5, boolean var6) {}

    // $FF: renamed from: a (m.v, i.o, h.i, boolean) void
    public void method_1040(class_86 var1, class_268 var2, class_132 var3, boolean var4) {}

    // $FF: renamed from: e () boolean
    public boolean method_752() {
        return (this.field_446 & 4) != 0;
    }

    // $FF: renamed from: c () boolean
    public boolean method_755() {
        return true;
    }

    // $FF: renamed from: a (l.g) int
    public int method_921(class_301 var1) {
        return -1;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        return this.method_752() ? var2 : var2.append("this");
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        return !this.method_752() && !this.method_1046(var1.method_635()) ? null : (this.field_675 = var1.method_584());
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2062(this, var2);
        var1.method_1977(this, var2);
    }
}
