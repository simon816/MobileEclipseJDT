package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.class_331;

public class class_335 extends class_331 {

    private static final class_335 field_1900;

    private long field_1901;

    public static class_331 method_3297(long var0) {
        if (var0 == 0L) {
            return field_1900;
        } else {
            class_335 var10000 = new class_335(var0);
            return var10000;
        }
    }

    private class_335(long var1) {
        this.field_1901 = var1;
    }

    public byte method_3258() {
        return (byte)((int)this.field_1901);
    }

    public char method_3260() {
        return (char)((int)this.field_1901);
    }

    public double method_3281() {
        return (double)this.field_1901;
    }

    public float method_3282() {
        return (float)this.field_1901;
    }

    public int method_3284() {
        return (int)this.field_1901;
    }

    public long method_3285() {
        return this.field_1901;
    }

    public short method_3286() {
        return (short)((int)this.field_1901);
    }

    public String method_3287() {
        return String.valueOf(this.field_1901);
    }

    public String toString() {
        return "(long)" + this.field_1901;
    }

    public int method_3288() {
        return 7;
    }

    static {
        class_335 var10000 = new class_335(0L);
        field_1900 = var10000;
    }
}