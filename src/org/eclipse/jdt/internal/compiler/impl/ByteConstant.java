package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class ByteConstant extends Constant {

    private byte value;

    public static Constant fromValue(byte var0) {
        ByteConstant var10000 = new ByteConstant(var0);
        return var10000;
    }

    private ByteConstant(byte var1) {
        this.value = var1;
    }

    public byte byteValue() {
        return this.value;
    }

    public char charValue() {
        return (char)this.value;
    }

    public double doubleValue() {
        return (double)this.value;
    }

    public float floatValue() {
        return (float)this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return (long)this.value;
    }

    public short shortValue() {
        return (short)this.value;
    }

    public String method_3287() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return "(byte)" + this.value;
    }

    public int typeID() {
        return 3;
    }
}
