package h;

import c.class_264;
import h.class_147;
import m.class_40;
import m.class_83;
import m.class_84;
import m.class_86;

// $FF: renamed from: h.cs
public class class_149 extends class_147 {

    // $FF: renamed from: a int
    public int field_729;
    // $FF: renamed from: b int
    public int field_730;

    // $FF: renamed from: <init> (char[], int, long) void
    public class_149(char[] var1, int var2, long var3) {
        super(var1, var3);
        this.field_730 = this.field_445;
        this.field_729 = var2;
    }

    // $FF: renamed from: a () int
    public int method_1009() {
        return this.field_729;
    }

    // $FF: renamed from: b (m.bb) m.s
    protected class_40 method_1011(class_83 var1) {
        if (this.field_675 != null) {
            return this.field_675;
        } else {
            if (this.field_729 > 255) {
                var1.method_644().method_1768(this);
            }
            class_40 var2 = var1.method_616(this.field_726);
            return var1.method_580(var2, this.field_729);
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        super.method_924(var1, var2);
        int var3;
        if ((this.field_446 & 16384) != 0) {
            for (var3 = 0; var3 < this.field_729 - 1; ++var3) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var3 = 0; var3 < this.field_729; ++var3) {
                var2.append("[]");
            }
        }
        return var2;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_1998(this, var2);
        var1.method_1913(this, var2);
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_1021(class_264 var1, class_84 var2) {
        var1.method_1999(this, var2);
        var1.method_1914(this, var2);
    }
}
