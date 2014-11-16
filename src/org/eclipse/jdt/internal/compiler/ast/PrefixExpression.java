package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class PrefixExpression extends CompoundAssignment {

    public PrefixExpression(Expression var1, Expression var2, int var3, int var4) {
        super(var1, var2, var3, var1.field_445);
        this.field_444 = var4;
        this.field_445 = var1.field_445;
    }

    public String operatorToString() {
        switch (this.field_689) {
            case 13:
                return "--";
            case 14:
                return "++";
            default:
                return "unknown operator";
        }
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        var2.append(this.operatorToString()).append(' ');
        return this.field_687.printExpression(0, var2);
    }

    public boolean restrainUsageToNumericTypes() {
        return true;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_687.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
