package m;

import g.class_10;
import m.class_43;
import m.class_58;

// $FF: renamed from: m.bc
final class class_185 implements class_10 {

    // $FF: renamed from: <init> () void
    class_185() {
    }

    // $FF: renamed from: a (java.lang.Object, java.lang.Object) int
    public int method_27(Object var1, Object var2) {
        class_58 var3 = (class_58)var1;
        class_58 var4 = (class_58)var2;
        char[] var5 = var3.field_274;
        char[] var6 = var4.field_274;
        int var7 = class_43.method_191(var5, var6, var5.length, var6.length);
        return var7 == 0 ? var3.field_276.length - var4.field_276.length : var7;
    }
}
