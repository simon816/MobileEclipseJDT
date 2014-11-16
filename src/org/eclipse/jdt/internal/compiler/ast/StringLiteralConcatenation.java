package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class StringLiteralConcatenation extends StringLiteral {

    public Expression[] literals;

    public int counter;

    public StringLiteralConcatenation(StringLiteral var1, StringLiteral var2) {
        super(var1.field_444, var1.field_445);
        this.source = var1.source;
        this.literals = new StringLiteral[5];
        this.counter = 0;
        this.literals[this.counter++] = var1;
        this.extendsWith(var2);
    }

    public StringLiteralConcatenation extendsWith(StringLiteral var1) {
        this.field_445 = var1.field_445;
        int var2 = this.literals.length;
        if (this.counter == var2) {
            System.arraycopy(this.literals, 0, this.literals = new StringLiteral[var2 + 5], 0, var2);
        }
        int var3 = this.source.length;
        System.arraycopy(this.source, 0, this.source = new char[var3 + var1.source.length], 0, var3);
        System.arraycopy(var1.source, 0, this.source, var3, var1.source.length);
        this.literals[this.counter++] = var1;
        return this;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append("StringLiteralConcatenation{");
        int var3 = 0;
        for (int var4 = this.counter; var3 < var4; ++var3) {
            this.literals[var3].printExpression(var1, var2);
            var2.append("+\n");
        }
        return var2.append('}');
    }

    public char[] source() {
        return this.source;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            int var3 = 0;
            for (int var4 = this.counter; var3 < var4; ++var3) {
                this.literals[var3].traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
