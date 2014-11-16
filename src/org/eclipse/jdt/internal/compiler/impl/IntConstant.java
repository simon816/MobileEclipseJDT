package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class IntConstant extends Constant {

    int value;

    private static final IntConstant field_1904;

    private static final IntConstant field_1905;

    private static final IntConstant field_1906;

    private static final IntConstant field_1907;

    private static final IntConstant field_1908;

    private static final IntConstant field_1909;

    private static final IntConstant field_1910;

    private static final IntConstant field_1911;

    private static final IntConstant field_1912;

    private static final IntConstant field_1913;

    private static final IntConstant field_1914;

    private static final IntConstant field_1915;

    private static final IntConstant field_1916;

    private static final IntConstant field_1917;

    private static final IntConstant field_1918;

    public static Constant fromValue(int var0) {
        switch (var0) {
            case -4:
                return field_1904;
            case -3:
                return field_1905;
            case -2:
                return field_1906;
            case -1:
                return field_1907;
            case 0:
                return field_1908;
            case 1:
                return field_1909;
            case 2:
                return field_1910;
            case 3:
                return field_1911;
            case 4:
                return field_1912;
            case 5:
                return field_1913;
            case 6:
                return field_1914;
            case 7:
                return field_1915;
            case 8:
                return field_1916;
            case 9:
                return field_1917;
            case 10:
                return field_1918;
            default:
                IntConstant var10000 = new IntConstant(var0);
                return var10000;
        }
    }

    private IntConstant(int var1) {
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
        return (short)this.value;
    }

    public String method_3287() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return "(int)" + this.value;
    }

    public int typeID() {
        return 10;
    }

    static {
        IntConstant var10000 = new IntConstant(-4);
        field_1904 = var10000;
        var10000 = new IntConstant(-3);
        field_1905 = var10000;
        var10000 = new IntConstant(-2);
        field_1906 = var10000;
        var10000 = new IntConstant(-1);
        field_1907 = var10000;
        var10000 = new IntConstant(0);
        field_1908 = var10000;
        var10000 = new IntConstant(1);
        field_1909 = var10000;
        var10000 = new IntConstant(2);
        field_1910 = var10000;
        var10000 = new IntConstant(3);
        field_1911 = var10000;
        var10000 = new IntConstant(4);
        field_1912 = var10000;
        var10000 = new IntConstant(5);
        field_1913 = var10000;
        var10000 = new IntConstant(6);
        field_1914 = var10000;
        var10000 = new IntConstant(7);
        field_1915 = var10000;
        var10000 = new IntConstant(8);
        field_1916 = var10000;
        var10000 = new IntConstant(9);
        field_1917 = var10000;
        var10000 = new IntConstant(10);
        field_1918 = var10000;
    }
}
