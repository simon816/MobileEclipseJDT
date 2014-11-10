package a;

import a.class_331;

public class class_340 extends class_331 {

    private boolean field_1921;

    private static final class_340 field_1922;

    private static final class_340 field_1923;

    public static class_340 method_3307(boolean var0) {
        return var0 ? field_1922 : field_1923;
    }

    private class_340(boolean var1) {
        this.field_1921 = var1;
    }

    public boolean method_3257() {
        return this.field_1921;
    }

    public String method_3287() {
        return String.valueOf(this.field_1921);
    }

    public String toString() {
        return "(boolean)" + this.field_1921;
    }

    public int method_3288() {
        return 5;
    }

    static {
        class_340 var10000 = new class_340(true);
        field_1922 = var10000;
        var10000 = new class_340(false);
        field_1923 = var10000;
    }
}
