package org.eclipse.jdt.internal.compiler.problem;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

public class DefaultProblem extends CategorizedProblem {

    private String field_997;

    private int field_998;

    private int field_999;

    private int field_1000;

    private int field_1001;

    private int field_1002;

    private int field_1003;

    private String[] arguments;

    private String field_1005;

    public static final Object[] EMPTY_VALUES;

    public DefaultProblem(String var1, String var2, int var3, String[] var4, int var5, int var6, int var7, int var8, int var9) {
        this.field_997 = var1;
        this.field_1005 = var2;
        this.field_998 = var3;
        this.arguments = var4;
        this.field_1003 = var5;
        this.field_999 = var6;
        this.field_1000 = var7;
        this.field_1001 = var8;
        this.field_1002 = var9;
    }

    public String[] getArguments() {
        return this.arguments;
    }

    public int method_1398() {
        return this.field_998;
    }

    public String method_1404() {
        return this.field_1005;
    }

    public String method_1400() {
        return this.field_997;
    }

    public int method_1402() {
        return this.field_1000;
    }

    public int method_1403() {
        return this.field_1001;
    }

    public int method_1401() {
        return this.field_999;
    }

    public boolean method_1399() {
        return (this.field_1003 & 1) != 0;
    }

    public boolean method_10() {
        return (this.field_1003 & 1) == 0;
    }

    public void method_1406(String var1) {
        this.field_997 = var1;
    }

    public void method_11(int var1) {
        this.field_1000 = var1;
    }

    public void method_12(int var1) {
        this.field_1001 = var1;
    }

    public void method_13(int var1) {
        this.field_999 = var1;
    }

    public String toString() {
        String var1 = "Pb(" + (this.field_998 & 16777215) + ") ";
        if (this.field_1005 != null) {
            var1 = var1 + this.field_1005;
        } else if (this.arguments != null) {
            for (int var2 = 0; var2 < this.arguments.length; ++var2) {
                var1 = var1 + " " + this.arguments[var2];
            }
        }
        return var1;
    }

    static {
        EMPTY_VALUES = new Object[0];
    }
}
