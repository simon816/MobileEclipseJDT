package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ThrowStatement extends Statement {

    public Expression exception;

    public TypeBinding exceptionType;

    public ThrowStatement(Expression var1, int var2, int var3) {
        this.exception = var1;
        this.field_444 = var2;
        this.field_445 = var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.exception.analyseCode(var1, var2, var3);
        this.exception.checkNPE(var1, var2, var3);
        var2.checkExceptionHandlers(this.exceptionType, this, var3, var1);
        return FlowInfo.DEAD_END;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            this.exception.generateCode(var1, var2, true);
            var2.method_2107();
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("throw ");
        this.exception.printExpression(0, var2);
        return var2.append(';');
    }

    public void resolve(BlockScope var1) {
        this.exceptionType = this.exception.resolveType(var1);
        if (this.exceptionType != null && this.exceptionType.isValidBinding()) {
            if (this.exceptionType == TypeBinding.field_187) {
                if (var1.compilerOptions().field_1927 <= 3080192L) {
                    var1.problemReporter().method_1503(this.exception);
                }
            } else if (this.exceptionType.findSuperTypeOriginatingFrom(21, true) == null) {
                var1.problemReporter().method_1504(this.exception, this.exceptionType);
            }
            this.exception.computeConversion(var1, this.exceptionType, this.exceptionType);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.exception.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
