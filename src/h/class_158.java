package h;

import a.class_331;
import c.class_264;
import h.class_105;
import h.class_157;
import m.class_40;
import m.class_43;
import m.class_86;

// $FF: renamed from: h.bj
public class class_158 extends class_157 {

    // $FF: renamed from: <init> (int, int) void
    public class_158(int var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a () h.q
    public static class_105 method_1047() {
        class_105 var10000 = new class_105(1);
        return var10000;
    }

    // $FF: renamed from: e () boolean
    public boolean method_752() {
        return false;
    }

    // $FF: renamed from: b () boolean
    public boolean method_754() {
        return true;
    }

    // $FF: renamed from: c () boolean
    public boolean method_755() {
        return false;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        return var2.append("super");
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if (!this.method_1046(var1.method_635())) {
            return null;
        } else {
            class_43 var2 = var1.method_584();
            if (var2.field_177 == 1) {
                var1.method_644().method_1506(this);
                return null;
            } else {
                return this.field_675 = var2.method_240();
            }
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2059(this, var2);
        var1.method_1974(this, var2);
    }
}
