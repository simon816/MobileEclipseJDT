package h;

import c.class_264;
import h.class_146;
import h.class_164;
import h.class_92;
import m.class_320;
import m.class_34;
import m.class_86;

// $FF: renamed from: h.ag
public class class_167 extends class_164 {

    // $FF: renamed from: a h.ak[]
    public class_92[] field_771;

    // $FF: renamed from: <init> (h.bo, int) void
    public class_167(class_146 var1, int var2) {
        this.field_767 = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    // $FF: renamed from: a () m.c[]
    public class_320[] method_1071() {
        int var1 = this.field_771 == null ? 0 : this.field_771.length;
        if (var1 == 0) {
            return class_34.field_159;
        } else {
            class_320[] var2 = new class_320[var1];
            for (int var3 = 0; var3 < var1; ++var3) {
                var2[var3] = this.field_771[var3].field_477;
            }
            return var2;
        }
    }

    // $FF: renamed from: a () h.ak[]
    public class_92[] method_1074() {
        return this.field_771 == null ? field_764 : this.field_771;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        super.method_924(var1, var2);
        var2.append('(');
        if (this.field_771 != null) {
            int var3 = 0;
            for (int var4 = this.field_771.length; var3 < var4; ++var3) {
                if (var3 > 0) {
                    var2.append(',');
                }
                this.field_771[var3].method_757(var1, var2);
            }
        }
        var2.append(')');
        return var2;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2038(this, var2)) {
            if (this.field_767 != null) {
                this.field_767.method_763(var1, var2);
            }
            if (this.field_771 != null) {
                int var3 = this.field_771.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_771[var4].method_763(var1, var2);
                }
            }
        }
        var1.method_1953(this, var2);
    }
}
