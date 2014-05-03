package k;

import k.class_19;
import k.class_21;
import k.class_22;
import k.class_345;

// $FF: renamed from: k.q
public class class_317 {

    // $FF: renamed from: a k.o
    class_22 field_1816;
    // $FF: renamed from: a k.h
    class_19 field_1817;
    // $FF: renamed from: a k.p[]
    class_21[] field_1818;
    // $FF: renamed from: a k.c
    class_345 field_1819;

    // $FF: renamed from: <init> (k.o, k.c) void
    public class_317(class_22 var1, class_345 var2) {
        this.field_1816 = var1;
        this.field_1819 = var2;
    }

    // $FF: renamed from: <init> (k.h, k.c) void
    public class_317(class_19 var1, class_345 var2) {
        this.field_1817 = var1;
        this.field_1819 = var2;
    }

    // $FF: renamed from: a () k.c
    public class_345 method_3183() {
        return this.field_1819;
    }

    // $FF: renamed from: a () k.o
    public class_22 method_3184() {
        return this.field_1816;
    }

    // $FF: renamed from: a () k.h
    public class_19 method_3185() {
        return this.field_1817;
    }

    // $FF: renamed from: a () k.p[]
    public class_21[] method_3186() {
        return this.field_1818;
    }

    // $FF: renamed from: a () boolean
    public boolean method_3187() {
        return this.field_1816 != null;
    }

    // $FF: renamed from: b () boolean
    public boolean method_3188() {
        return this.field_1817 != null;
    }

    // $FF: renamed from: c () boolean
    public boolean method_3189() {
        return this.field_1818 != null;
    }

    // $FF: renamed from: d () boolean
    public boolean method_3190() {
        return this.field_1819 != null && this.field_1819.method_3330();
    }

    // $FF: renamed from: a (k.q) boolean
    public boolean method_3191(class_317 var1) {
        return var1 == null ? true : (this.field_1819 == null ? true : var1.field_1819 != null && this.field_1819.method_3329() < var1.field_1819.method_3329());
    }
}
