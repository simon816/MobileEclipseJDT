package a;

import g.class_11;

// $FF: renamed from: a.b
public class class_342 implements class_11 {

    // $FF: renamed from: a long
    public long field_1967;
    // $FF: renamed from: b long
    public long field_1968;
    // $FF: renamed from: c long
    public long field_1969;
    // $FF: renamed from: d long
    public long field_1970;
    // $FF: renamed from: e long
    public long field_1971;
    // $FF: renamed from: f long
    public long field_1972;
    // $FF: renamed from: g long
    public long field_1973;

    // $FF: renamed from: <init> () void
    public class_342() {
    }

    // $FF: renamed from: a () long
    public long method_3323() {
        return this.field_1968 - this.field_1967;
    }

    // $FF: renamed from: a (java.lang.Object) int
    public int method_28(Object var1) {
        class_342 var2 = (class_342)var1;
        long var3 = this.method_3323();
        long var5 = var2.method_3323();
        return var3 < var5 ? -1 : (var3 == var5 ? 0 : 1);
    }
}
