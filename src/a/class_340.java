package a;

import a.class_331;

// $FF: renamed from: a.a
public class class_340 extends class_331 {

    // $FF: renamed from: a boolean
    private boolean field_1921;
    // $FF: renamed from: a a.a
    private static final class_340 field_1922;
    // $FF: renamed from: b a.a
    private static final class_340 field_1923;

    // $FF: renamed from: a (boolean) a.a
    public static class_340 method_3307(boolean var0) {
        return var0 ? field_1922 : field_1923;
    }

    // $FF: renamed from: <init> (boolean) void
    private class_340(boolean var1) {
        this.field_1921 = var1;
    }

    // $FF: renamed from: a () boolean
    public boolean method_3257() {
        return this.field_1921;
    }

    // $FF: renamed from: a () java.lang.String
    public String method_3287() {
        return String.valueOf(this.field_1921);
    }

    public String toString() {
        return "(boolean)" + this.field_1921;
    }

    // $FF: renamed from: a () int
    public int method_3288() {
        return 5;
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_340 var10000 = new class_340(true);
        field_1922 = var10000;
        var10000 = new class_340(false);
        field_1923 = var10000;
    }
}
