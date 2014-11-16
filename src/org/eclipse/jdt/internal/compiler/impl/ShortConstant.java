package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class ShortConstant extends Constant {

    private short value;

    public static Constant fromValue(short var0) {
        ShortConstant var10000 = new ShortConstant(var0);
        return var10000;
    }

    private ShortConstant(short var1) {
        this.value = var1;
    }

    public byte byteValue() {
        return (byte)this.value;
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
        return this.value;
    }

    public String method_3287() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return "(short)" + this.value;
    }

    public int typeID() {
        return 4;
    }
}
