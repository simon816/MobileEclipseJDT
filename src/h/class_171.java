package h;

import c.class_264;
import h.class_170;
import h.class_182;
import m.class_86;

// $FF: renamed from: h.o
public class class_171 extends class_170 {

    // $FF: renamed from: <init> (h.bc, h.cg) void
    public class_171(class_170 var1, class_182 var2) {
        super(var1.field_785, var1.field_444, var1.field_445, var1.field_786);
        this.method_1085(var2);
    }

    // $FF: renamed from: <init> (h.bc, h.bc) void
    public class_171(class_170 var1, class_170 var2) {
        super(var1.field_785, var1.field_444, var1.field_445, var1.field_786);
        this.method_1086(var2);
    }

    // $FF: renamed from: a (h.cg) h.o
    public class_171 method_1085(class_182 var1) {
        int var2 = this.field_785.length;
        System.arraycopy(this.field_785, 0, this.field_785 = new char[var2 + 1], 0, var2);
        this.field_785[var2] = var1.field_801;
        this.field_445 = var1.field_445;
        return this;
    }

    // $FF: renamed from: a (h.bc) h.o
    public class_171 method_1086(class_170 var1) {
        int var2 = this.field_785.length;
        System.arraycopy(this.field_785, 0, this.field_785 = new char[var2 + var1.field_785.length], 0, var2);
        System.arraycopy(var1.field_785, 0, this.field_785, var2, var1.field_785.length);
        this.field_445 = var1.field_445;
        return this;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        return var2.append("ExtendedStringLiteral{").append(this.field_785).append('}');
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2019(this, var2);
        var1.method_1934(this, var2);
    }
}
