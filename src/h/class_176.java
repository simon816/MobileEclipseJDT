package h;

import a.class_331;
import c.class_264;
import h.class_173;
import i.class_268;
import l.class_301;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.an
public class class_176 extends class_173 {

    // $FF: renamed from: a char[]
    static final char[] field_791;

    // $FF: renamed from: <init> (int, int) void
    public class_176(int var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a () void
    public void method_1081() {
        this.field_672 = class_331.field_1896;
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2087();
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1082(class_86 var1) {
        return class_40.field_187;
    }

    // $FF: renamed from: a (l.g) int
    public int method_921(class_301 var1) {
        return 1;
    }

    // $FF: renamed from: a () java.lang.Object
    public Object method_927() {
        return class_40.field_187;
    }

    // $FF: renamed from: a () char[]
    public char[] method_1083() {
        return field_791;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2039(this, var2);
        var1.method_1954(this, var2);
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_791 = new char[] {'n', 'u', 'l', 'l'};
    }
}
