package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class BooleanConstant extends Constant {

    private boolean value;

    private static final BooleanConstant field_1922;

    private static final BooleanConstant field_1923;

    public static BooleanConstant fromValue(boolean var0) {
        return var0 ? field_1922 : field_1923;
    }

    private BooleanConstant(boolean var1) {
        this.value = var1;
    }

    public boolean booleanValue() {
        return this.value;
    }

    public String method_3287() {
        return String.valueOf(this.value);
    }

    public String toString() {
        return "(boolean)" + this.value;
    }

    public int typeID() {
        return 5;
    }

    static {
        BooleanConstant var10000 = new BooleanConstant(true);
        field_1922 = var10000;
        var10000 = new BooleanConstant(false);
        field_1923 = var10000;
    }
}
