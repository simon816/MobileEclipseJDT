package j;

import c.class_264;
import h.class_114;
import h.class_122;
import h.class_94;
import h.class_96;
import j.class_265;
import j.class_278;
import m.class_84;
import m.class_86;
import m.class_87;

// $FF: renamed from: j.h
class class_266 extends class_264 {

    // $FF: renamed from: a j.i
    public class_265 field_1164;
    // $FF: renamed from: a h.bq[]
    class_114[] field_1165;
    // $FF: renamed from: a int
    int field_1166;
    // $FF: renamed from: a j.r
    private final class_278 field_1167;

    // $FF: renamed from: <init> (j.r) void
    class_266(class_278 var1) {
        this.field_1167 = var1;
        this.field_1165 = new class_114[0];
        this.field_1166 = -1;
    }

    // $FF: renamed from: a (h.bq, m.v) void
    public void method_1981(class_114 var1, class_86 var2) {
        this.method_2078();
    }

    // $FF: renamed from: a (h.bq, m.f) void
    public void method_1982(class_114 var1, class_84 var2) {
        this.method_2078();
    }

    // $FF: renamed from: a () void
    private void method_2078() {
        --this.field_1166;
    }

    // $FF: renamed from: a (h.bq, m.v) boolean
    public boolean method_2066(class_114 var1, class_86 var2) {
        return this.method_2079(var1);
    }

    // $FF: renamed from: a (h.bq, m.f) boolean
    public boolean method_2067(class_114 var1, class_84 var2) {
        return this.method_2079(var1);
    }

    // $FF: renamed from: a (h.bq) boolean
    private boolean method_2079(class_114 var1) {
        if (this.field_1165.length <= ++this.field_1166) {
            int var2 = this.field_1166;
            System.arraycopy(this.field_1165, 0, this.field_1165 = new class_114[var2 * 2 + 1], 0, var2);
        }
        this.field_1165[this.field_1166] = var1;
        return true;
    }

    // $FF: renamed from: a (h.g, m.f) boolean
    public boolean method_2012(class_94 var1, class_84 var2) {
        if (var1.method_796()) {
            return false;
        } else {
            var1.method_806(this.field_1164, var2);
            return false;
        }
    }

    // $FF: renamed from: a (h.y, m.aj) boolean
    public boolean method_2027(class_122 var1, class_87 var2) {
        if (var1.field_664 == null) {
            return false;
        } else {
            this.field_1164.field_1160 = this.field_1165[this.field_1166];
            var1.method_893(this.field_1164, var2);
            return false;
        }
    }

    // $FF: renamed from: a (h.ae, m.f) boolean
    public boolean method_2036(class_96 var1, class_84 var2) {
        var1.method_806(this.field_1164, var2);
        return false;
    }
}