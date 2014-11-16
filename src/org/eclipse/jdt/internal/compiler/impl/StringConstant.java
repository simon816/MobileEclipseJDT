package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.Constant;

public class StringConstant extends Constant {

    private String value;

    public static Constant fromValue(String var0) {
        StringConstant var10000 = new StringConstant(var0);
        return var10000;
    }

    private StringConstant(String var1) {
        this.value = var1;
    }

    public String method_3287() {
        return this.value;
    }

    public String toString() {
        return "(String)\"" + this.value + "\"";
    }

    public int typeID() {
        return 11;
    }
}
