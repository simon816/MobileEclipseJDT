package h;

import h.class_154;
import m.class_0;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_67;

// $FF: renamed from: h.af
public abstract class class_161 extends class_154 implements class_0 {

    // $FF: renamed from: a m.w
    public class_34 field_748;
    // $FF: renamed from: b m.w
    public class_34 field_749;
    // $FF: renamed from: a m.s
    public class_40 field_750;

    // $FF: renamed from: <init> () void
    public class_161() {
        this.field_446 |= 7;
    }

    // $FF: renamed from: a () m.k
    public class_67 method_1036() {
        return (class_67)this.field_748;
    }

    // $FF: renamed from: e_ () boolean
    public boolean method_1() {
        return false;
    }

    // $FF: renamed from: a (m.as) void
    public void method_4(class_43 var1) {
        if (var1 != null) {
            this.field_750 = var1;
        }
    }

    // $FF: renamed from: a (int) void
    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    // $FF: renamed from: b (int) void
    public void method_3(int var1) {}
}
