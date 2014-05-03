package m;

import b.class_233;
import h.class_91;
import m.class_34;
import m.class_35;
import m.class_43;

// $FF: renamed from: m.h
public class class_36 extends class_35 {

    // $FF: renamed from: a m.as
    public class_43 field_166;

    // $FF: renamed from: <init> (char[][], m.w, m.as, h.z) void
    public class_36(char[][] var1, class_34 var2, class_43 var3, class_91 var4) {
        super(var1, false, var2, var4);
        this.field_166 = var3;
    }

    // $FF: renamed from: a () char[]
    public char[] method_103() {
        return class_233.method_1361(this.field_162, '.');
    }

    public String toString() {
        return "method import : " + new String(this.method_103());
    }
}
