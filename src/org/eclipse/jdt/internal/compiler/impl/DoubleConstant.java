package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class DoubleConstant extends Constant {

    private double value;

    public static Constant fromValue(double var0) {
        DoubleConstant var10000 = new DoubleConstant(var0);
        return var10000;
    }

    private DoubleConstant(double var1) {
        this.value = var1;
    }

    public byte byteValue() {
        return (byte)((int)this.value);
    }

    public char charValue() {
        return (char)((int)this.value);
    }

    public double doubleValue() {
        return this.value;
    }

    public float floatValue() {
        return (float)this.value;
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
        return this == NotAConstant ? "(Constant) NotAConstant" : "(double)" + this.value;
    }

    public int typeID() {
        return 8;
    }
}
