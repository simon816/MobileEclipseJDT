package a;

import a.class_331;

public class class_332 extends class_331 {

    private double field_1897;

    public static class_331 method_3291(double var0) {
        class_332 var10000 = new class_332(var0);
        return var10000;
    }

    private class_332(double var1) {
        this.field_1897 = var1;
    }

    public byte method_3258() {
        return (byte)((int)this.field_1897);
    }

    public char method_3260() {
        return (char)((int)this.field_1897);
    }

    public double method_3281() {
        return this.field_1897;
    }

    public float method_3282() {
        return (float)this.field_1897;
    }

    public int method_3284() {
        return (int)this.field_1897;
    }

    public long method_3285() {
        return (long)this.field_1897;
    }

    public short method_3286() {
        return (short)((int)this.field_1897);
    }

    public String method_3287() {
        return String.valueOf(this.field_1897);
    }

    public String toString() {
        return this == field_1896 ? "(Constant) NotAConstant" : "(double)" + this.field_1897;
    }

    public int method_3288() {
        return 8;
    }
}
