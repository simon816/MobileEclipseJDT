package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class PostfixExpression extends CompoundAssignment {

    public PostfixExpression(Expression var1, Expression var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        this.field_444 = var1.field_444;
        this.field_445 = var4;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        ((Reference)this.field_687).generatePostIncrement(var1, var2, this, var3);
        if (var3) {
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
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
        return this.field_687.printExpression(var1, var2).append(' ').append(this.operatorToString());
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
