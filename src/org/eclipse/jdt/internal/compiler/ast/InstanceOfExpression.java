package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.OperatorExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class InstanceOfExpression extends OperatorExpression {

    public Expression expression;

    public TypeReference type;

    public InstanceOfExpression(Expression var1, TypeReference var2) {
        this.expression = var1;
        this.type = var2;
        var2.field_446 |= 1073741824;
        this.field_446 |= 1984;
        this.field_444 = var1.field_444;
        this.field_445 = var2.field_445;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        LocalVariableBinding var4 = this.expression.localVariableBinding();
        if (var4 != null && (var4.type.tagBits & 2L) == 0L) {
            var2.recordUsingNullReference(var1, var4, this.expression, 1025, var3);
            UnconditionalFlowInfo var6 = this.expression.analyseCode(var1, var2, var3).method_3109();
            FlowInfo var5 = var6.method_3078();
            var5.method_3094(var4);
            return FlowInfo.conditional(var5, var6.method_3078());
        } else {
            return this.expression.analyseCode(var1, var2, var3).method_3109();
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        this.expression.generateCode(var1, var2, true);
        var2.method_2257(this.type.resolvedType);
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            var2.method_2352();
        }
        var2.method_2360(var4, this.field_444);
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        this.expression.printExpression(var1, var2).append(" instanceof ");
        return this.type.print(0, var2);
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        TypeBinding var2 = this.expression.resolveType(var1);
        TypeBinding var3 = this.type.resolveType(var1, true);
        if (var2 != null && var3 != null) {
            if (!var3.method_167()) {
                var1.problemReporter().method_1572(var3, this);
            } else if (var2 != TypeBinding.field_187 && var2.method_148() || !this.checkCastTypesCompatibility(var1, var3, var2, (Expression)null)) {
                var1.problemReporter().notCompatibleTypesError(this, var2, var3);
            }
            return this.resolvedType = TypeBinding.field_186;
        } else {
            return null;
        }
    }

    public void tagAsUnnecessaryCast(Scope var1, TypeBinding var2) {
        if (this.expression.resolvedType != TypeBinding.field_187) {
            var1.problemReporter().unnecessaryInstanceof(this, var2);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.expression.traverse(var1, var2);
            this.type.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
