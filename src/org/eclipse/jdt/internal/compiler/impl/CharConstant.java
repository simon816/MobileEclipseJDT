package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class CharConstant extends Constant {

    private char value;

    public static Constant fromValue(char var0) {
        CharConstant var10000 = new CharConstant(var0);
        return var10000;
    }

    private CharConstant(char var1) {
        this.value = var1;
    }

    public byte byteValue() {
        return (byte)this.value;
    }

    public char charValue() {
        return this.value;
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
        return "(char)" + this.value;
    }

    public int typeID() {
        return 2;
    }
}
