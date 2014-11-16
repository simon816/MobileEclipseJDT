package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class LongConstant extends Constant {

    private static final LongConstant field_1900;

    private long value;

    public static Constant fromValue(long var0) {
        if (var0 == 0L) {
            return field_1900;
        } else {
            LongConstant var10000 = new LongConstant(var0);
            return var10000;
        }
    }

    private LongConstant(long var1) {
        this.value = var1;
    }

    public byte byteValue() {
        return (byte)((int)this.value);
    }

    public char charValue() {
        return (char)((int)this.value);
    }

    public double doubleValue() {
        return (double)this.value;
    }

    public float floatValue() {
        return (float)this.value;
    }

    public int intValue() {
        return (int)this.value;
    }

    public long longValue() {
        return this.value;
    }

    public short shortValue() {
        return (short)((int)this.value);
    }

    public String method_3287() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return "(long)" + this.value;
    }

    public int typeID() {
        return 7;
    }

    static {
        LongConstant var10000 = new LongConstant(0L);
        field_1900 = var10000;
    }
}
