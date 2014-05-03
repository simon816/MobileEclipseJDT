package h;

import b.class_233;
import c.class_264;
import h.class_146;
import h.class_147;
import m.class_40;
import m.class_43;
import m.class_45;
import m.class_83;
import m.class_84;
import m.class_86;

// $FF: renamed from: h.bs
public class class_148 extends class_147 {

    // $FF: renamed from: a h.bo
    public class_146 field_727;
    // $FF: renamed from: a int
    public int field_728;

    // $FF: renamed from: <init> (int) void
    public class_148(int var1) {
        super(field_51, 0L);
        this.field_728 = var1;
    }

    // $FF: renamed from: a () char[][]
    public char[][] method_1012() {
        switch (this.field_728) {
            case 0:
                return new char[][] {field_51};
            case 1:
                return new char[][] {class_233.method_1356(field_51, field_53, class_233.method_1361(this.field_727.method_1012(), '.'))};
            default:
                return new char[][] {class_233.method_1356(field_51, field_52, class_233.method_1361(this.field_727.method_1012(), '.'))};
        }
    }

    // $FF: renamed from: a (m.bb, m.as, int) m.s
    private class_40 method_1025(class_83 var1, class_43 var2, int var3) {
        class_40 var4 = null;
        if (this.field_727 != null) {
            var4 = var1.field_373 == 3 ? this.field_727.method_1018((class_84)var1) : this.field_727.method_1017((class_86)var1, true);
            if (var4 == null) {
                return null;
            }
        }
        class_45 var5 = var1.method_586().method_502(var2, var3, var4, (class_40[])null, this.field_728);
        return this.field_675 = var5;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        switch (this.field_728) {
            case 0:
                var2.append(field_51);
                break;
            case 1:
                var2.append(field_51).append(field_53);
                this.field_727.method_924(0, var2);
                break;
            default:
                var2.append(field_51).append(field_52);
                this.field_727.method_924(0, var2);
        }
        return var2;
    }

    // $FF: renamed from: a (m.v, boolean) m.s
    public class_40 method_1017(class_86 var1, boolean var2) {
        if (this.field_727 != null) {
            this.field_727.method_1017(var1, var2);
        }
        return null;
    }

    // $FF: renamed from: a (m.f) m.s
    public class_40 method_1018(class_84 var1) {
        if (this.field_727 != null) {
            this.field_727.method_1018(var1);
        }
        return null;
    }

    // $FF: renamed from: a (m.v, m.as, int) m.s
    public class_40 method_1019(class_86 var1, class_43 var2, int var3) {
        return this.method_1025(var1, var2, var3);
    }

    // $FF: renamed from: a (m.f, m.as, int) m.s
    public class_40 method_1020(class_84 var1, class_43 var2, int var3) {
        return this.method_1025(var1, var2, var3);
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2072(this, var2) && this.field_727 != null) {
            this.field_727.method_763(var1, var2);
        }
        var1.method_1987(this, var2);
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_1021(class_264 var1, class_84 var2) {
        if (var1.method_2073(this, var2) && this.field_727 != null) {
            this.field_727.method_1021(var1, var2);
        }
        var1.method_1988(this, var2);
    }
}
