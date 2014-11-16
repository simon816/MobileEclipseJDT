package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ExtendedStringLiteral extends StringLiteral {

    public ExtendedStringLiteral(StringLiteral var1, CharLiteral var2) {
        super(var1.source, var1.field_444, var1.field_445, var1.lineNumber);
        this.extendWith(var2);
    }

    public ExtendedStringLiteral(StringLiteral var1, StringLiteral var2) {
        super(var1.source, var1.field_444, var1.field_445, var1.lineNumber);
        this.extendWith(var2);
    }

    public ExtendedStringLiteral extendWith(CharLiteral var1) {
        int var2 = this.source.length;
        System.arraycopy(this.source, 0, this.source = new char[var2 + 1], 0, var2);
        this.source[var2] = var1.value;
        this.field_445 = var1.field_445;
        return this;
    }

    public ExtendedStringLiteral extendWith(StringLiteral var1) {
        int var2 = this.source.length;
        System.arraycopy(this.source, 0, this.source = new char[var2 + var1.source.length], 0, var2);
        System.arraycopy(var1.source, 0, this.source, var2, var1.source.length);
        this.field_445 = var1.field_445;
        return this;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return var2.append("ExtendedStringLiteral{").append(this.source).append('}');
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
