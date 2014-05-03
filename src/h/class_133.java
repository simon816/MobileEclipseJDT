package h;

import c.class_264;
import h.class_126;
import h.class_132;
import h.class_154;
import i.class_268;
import m.class_86;

// $FF: renamed from: h.au
public class class_133 extends class_132 {

    // $FF: renamed from: <init> (h.r, h.r, int, int) void
    public class_133(class_126 var1, class_126 var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        this.field_444 = var1.field_444;
        this.field_445 = var4;
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        ((class_154)this.field_687).method_1040(var1, var2, this, var3);
        if (var3) {
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: a () java.lang.String
    public String method_948() {
        switch (this.field_689) {
            case 13:
                return "--";
            case 14:
                return "++";
            default:
                return "unknown operator";
        }
    }

    // $FF: renamed from: b_ (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_946(int var1, StringBuffer var2) {
        return this.field_687.method_924(var1, var2).append(' ').append(this.method_948());
    }

    // $FF: renamed from: d_ () boolean
    public boolean method_949() {
        return true;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2045(this, var2)) {
            this.field_687.method_763(var1, var2);
        }
        var1.method_1960(this, var2);
    }
}
