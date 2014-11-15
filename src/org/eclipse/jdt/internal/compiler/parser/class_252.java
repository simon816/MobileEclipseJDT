package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.parser.class_251;

public class class_252 extends class_251 {

    public ImportReference field_1072;

    public class_252(ImportReference var1, class_251 var2, int var3) {
        super(var2, var3);
        this.field_1072 = var1;
    }

    public ASTNode method_1845() {
        return this.field_1072;
    }

    public String method_1850(int var1) {
        return this.method_1848(var1) + "Recovered import: " + this.field_1072.toString();
    }

    public ImportReference method_1859() {
        return this.field_1072;
    }

    public void method_1855() {
        this.method_1859();
    }

    public void method_1856(int var1, int var2) {
        if (this.field_1072.field_471 == 0) {
            this.field_1072.field_471 = var2;
            this.field_1072.field_469 = var2;
        }
    }
}
