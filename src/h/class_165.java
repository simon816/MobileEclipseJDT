package h;

import c.class_264;
import h.class_126;
import h.class_146;
import h.class_164;
import h.class_92;
import m.class_320;
import m.class_86;

// $FF: renamed from: h.az
public class class_165 extends class_164 {

    // $FF: renamed from: a h.r
    public class_126 field_769;
    // $FF: renamed from: a h.ak[]
    private class_92[] field_770;

    // $FF: renamed from: <init> (h.bo, int) void
    public class_165(class_146 var1, int var2) {
        this.field_767 = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    // $FF: renamed from: a () m.c[]
    public class_320[] method_1071() {
        return new class_320[] {this.method_1074()[0].field_477};
    }

    // $FF: renamed from: a () h.ak[]
    public class_92[] method_1074() {
        if (this.field_770 == null) {
            class_92[] var10001 = new class_92[1];
            class_92 var10004 = new class_92(field_70, this.field_769.field_444, this.field_769.field_445, this.field_769);
            var10001[0] = var10004;
            this.field_770 = var10001;
        }
        return this.field_770;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        super.method_924(var1, var2);
        var2.append('(');
        this.field_769.method_924(var1, var2);
        return var2.append(')');
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2054(this, var2)) {
            if (this.field_767 != null) {
                this.field_767.method_763(var1, var2);
            }
            if (this.field_769 != null) {
                this.field_769.method_763(var1, var2);
            }
        }
        var1.method_1969(this, var2);
    }
}
