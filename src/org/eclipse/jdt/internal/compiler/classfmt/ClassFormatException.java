package org.eclipse.jdt.internal.compiler.classfmt;

public class ClassFormatException extends Exception {

    private int field_876;

    private int field_877;

    private RuntimeException nestedException;

    private String field_879;

    public ClassFormatException(RuntimeException var1, String var2) {
        this.nestedException = var1;
        this.field_879 = var2;
    }

    public ClassFormatException(int var1, int var2) {
        this.field_876 = var1;
        this.field_877 = var2;
    }
}
