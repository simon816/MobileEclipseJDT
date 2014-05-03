package h;

import a.class_336;
import c.class_264;
import h.class_169;
import h.class_171;
import h.class_172;
import h.class_182;
import i.class_268;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.bc
public class class_170 extends class_169 {

    // $FF: renamed from: a char[]
    char[] field_785;
    // $FF: renamed from: a int
    int field_786;

    // $FF: renamed from: <init> (char[], int, int, int) void
    public class_170(char[] var1, int var2, int var3, int var4) {
        this(var2, var3);
        this.field_785 = var1;
        this.field_786 = var4 - 1;
    }

    // $FF: renamed from: <init> (int, int) void
    public class_170(int var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a () void
    public void method_1081() {
        this.field_672 = class_336.method_3299(String.valueOf(this.field_785));
    }

    // $FF: renamed from: a (h.cg) h.o
    public class_171 method_1085(class_182 var1) {
        class_171 var10000 = new class_171(this, var1);
        return var10000;
    }

    // $FF: renamed from: a (h.bc) h.o
    public class_171 method_1086(class_170 var1) {
        class_171 var10000 = new class_171(this, var1);
        return var10000;
    }

    // $FF: renamed from: a (h.bc) h.bd
    public class_172 method_1087(class_170 var1) {
        class_172 var10000 = new class_172(this, var1);
        return var10000;
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2311(this.field_672.method_3287());
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1082(class_86 var1) {
        return var1.method_610();
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append('\"');
        for (int var3 = 0; var3 < this.field_785.length; ++var3) {
            switch (this.field_785[var3]) {
                case 8:
                    var2.append("\\b");
                    break;
                case 9:
                    var2.append("\\t");
                    break;
                case 10:
                    var2.append("\\n");
                    break;
                case 12:
                    var2.append("\\f");
                    break;
                case 13:
                    var2.append("\\r");
                    break;
                case 34:
                    var2.append("\\\"");
                    break;
                case 39:
                    var2.append("\\\'");
                    break;
                case 92:
                    var2.append("\\\\");
                    break;
                default:
                    var2.append(this.field_785[var3]);
            }
        }
        var2.append('\"');
        return var2;
    }

    // $FF: renamed from: a () char[]
    public char[] method_1083() {
        return this.field_785;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2058(this, var2);
        var1.method_1973(this, var2);
    }
}
