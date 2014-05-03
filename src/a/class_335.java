package a;

import a.class_331;

// $FF: renamed from: a.h
public class class_335 extends class_331 {

    // $FF: renamed from: a a.h
    private static final class_335 field_1900;
    // $FF: renamed from: a long
    private long field_1901;

    // $FF: renamed from: a (long) a.k
    public static class_331 method_3297(long var0) {
        if (var0 == 0L) {
            return field_1900;
        } else {
            class_335 var10000 = new class_335(var0);
            return var10000;
        }
    }

    // $FF: renamed from: <init> (long) void
    private class_335(long var1) {
        this.field_1901 = var1;
    }

    // $FF: renamed from: a () byte
    public byte method_3258() {
        return (byte)((int)this.field_1901);
    }

    // $FF: renamed from: a () char
    public char method_3260() {
        return (char)((int)this.field_1901);
    }

    // $FF: renamed from: a () double
    public double method_3281() {
        return (double)this.field_1901;
    }

    // $FF: renamed from: a () float
    public float method_3282() {
        return (float)this.field_1901;
    }

    // $FF: renamed from: b () int
    public int method_3284() {
        return (int)this.field_1901;
    }

    // $FF: renamed from: a () long
    public long method_3285() {
        return this.field_1901;
    }

    // $FF: renamed from: a () short
    public short method_3286() {
        return (short)((int)this.field_1901);
    }

    // $FF: renamed from: a () java.lang.String
    public String method_3287() {
        return String.valueOf(this.field_1901);
    }

    public String toString() {
        return "(long)" + this.field_1901;
    }

    // $FF: renamed from: a () int
    public int method_3288() {
        return 7;
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_335 var10000 = new class_335(0L);
        field_1900 = var10000;
    }
}
