package h;

import c.class_264;
import h.class_98;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_86;

// $FF: renamed from: h.c
public class class_99 extends class_98 {

    // $FF: renamed from: <init> (int, int) void
    public class_99(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    // $FF: renamed from: a (l.g, m.v, boolean) boolean
    public boolean method_816(class_301 var1, class_86 var2, boolean var3) {
        return var2.method_577().field_1927 < 3145728L ? false : super.method_816(var1, var2, var3);
    }

    // $FF: renamed from: a (m.v, i.o) void
    public void method_818(class_86 var1, class_268 var2) {}

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        return method_759(var1, var2).append(';');
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {
        if ((this.field_446 & 1) == 0) {
            var1.method_644().method_1762(this.field_444, this.field_445);
        } else {
            var1.method_644().method_1539(this.field_444, this.field_445);
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2016(this, var2);
        var1.method_1931(this, var2);
    }
}
