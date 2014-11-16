package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class FloatConstant extends Constant {

    float value;

    public static Constant fromValue(float var0) {
        FloatConstant var10000 = new FloatConstant(var0);
        return var10000;
    }

    private FloatConstant(float var1) {
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
        return this.value;
    }

    public int intValue() {
        return (int)this.value;
    }

    public long longValue() {
        return (long)this.value;
    }

    public short shortValue() {
        return (short)((int)this.value);
    }

    public String method_3287() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return "(float)" + this.value;
    }

    public int typeID() {
        return 9;
    }
}
