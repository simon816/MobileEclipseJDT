package h;

import h.class_126;
import h.class_146;
import h.class_164;
import h.class_98;
import l.class_293;
import l.class_301;
import m.class_0;
import m.class_40;
import m.class_43;
import m.class_86;

// $FF: renamed from: h.cl
public abstract class class_120 extends class_98 implements class_0 {

    // $FF: renamed from: f int
    public int field_651;
    // $FF: renamed from: g int
    public int field_652;
    // $FF: renamed from: k int
    public int field_653;
    // $FF: renamed from: l int
    public int field_654;
    // $FF: renamed from: a h.r
    public class_126 field_655;
    // $FF: renamed from: m int
    public int field_656;
    // $FF: renamed from: n int
    public int field_657;
    // $FF: renamed from: a h.cn[]
    public class_164[] field_658;
    // $FF: renamed from: a char[]
    public char[] field_659;
    // $FF: renamed from: a h.bo
    public class_146 field_660;

    // $FF: renamed from: <init> () void
    public class_120() {
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    // $FF: renamed from: a () m.s[]
    public class_40[] method_0() {
        return null;
    }

    // $FF: renamed from: a () int
    public abstract int method_887();

    // $FF: renamed from: e_ () boolean
    public boolean method_1() {
        return false;
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        this.method_888(var1, var2);
        switch (this.method_887()) {
            case 3:
                return var2.append(',');
            default:
                return var2.append(';');
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_888(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_656, var2);
        if (this.field_658 != null) {
            method_758(this.field_658, var2);
        }
        if (this.field_660 != null) {
            this.field_660.method_757(0, var2).append(' ');
        }
        var2.append(this.field_659);
        switch (this.method_887()) {
            case 3:
                if (this.field_655 != null) {
                    this.field_655.method_924(var1, var2);
                }
                break;
            default:
                if (this.field_655 != null) {
                    var2.append(" = ");
                    this.field_655.method_924(var1, var2);
                }
        }
        return var2;
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {}

    // $FF: renamed from: a (m.as) void
    public void method_4(class_43 var1) {}

    // $FF: renamed from: a (int) void
    public void method_2(int var1) {
        this.field_654 = var1;
    }

    // $FF: renamed from: b (int) void
    public void method_3(int var1) {}
}
