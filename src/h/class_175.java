package h;

import a.class_340;
import c.class_264;
import h.class_173;
import i.class_268;
import i.class_74;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.bk
public class class_175 extends class_173 {

    // $FF: renamed from: a char[]
    static final char[] field_790;

    // $FF: renamed from: <init> (int, int) void
    public class_175(int var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a () void
    public void method_1081() {
        this.field_672 = class_340.method_3307(true);
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: a (m.v, i.o, i.s, i.s, boolean) void
    public void method_913(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        int var6 = var2.field_1208;
        if (var5 && var4 == null && var3 != null) {
            var2.method_2209(var3);
        }
        var2.method_2360(var6, this.field_444);
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1082(class_86 var1) {
        return class_40.field_186;
    }

    // $FF: renamed from: a () char[]
    public char[] method_1083() {
        return field_790;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2064(this, var2);
        var1.method_1979(this, var2);
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_790 = new char[] {'t', 'r', 'u', 'e'};
    }
}
