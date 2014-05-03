package h;

import c.class_264;
import h.class_126;
import h.class_132;
import m.class_86;

// $FF: renamed from: h.at
public class class_134 extends class_132 {

    // $FF: renamed from: <init> (h.r, h.r, int, int) void
    public class_134(class_126 var1, class_126 var2, int var3, int var4) {
        super(var1, var2, var3, var1.field_445);
        this.field_444 = var4;
        this.field_445 = var1.field_445;
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
        var2.append(this.method_948()).append(' ');
        return this.field_687.method_924(0, var2);
    }

    // $FF: renamed from: d_ () boolean
    public boolean method_949() {
        return true;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2046(this, var2)) {
            this.field_687.method_763(var1, var2);
        }
        var1.method_1961(this, var2);
    }
}
