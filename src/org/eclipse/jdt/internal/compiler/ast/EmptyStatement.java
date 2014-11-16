package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class EmptyStatement extends Statement {

    public EmptyStatement(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public boolean method_816(FlowInfo var1, BlockScope var2, boolean var3) {
        return var2.compilerOptions().field_1927 < 3145728L ? false : super.method_816(var1, var2, var3);
    }

    public void generateCode(BlockScope var1, CodeStream var2) {}

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        return method_759(var1, var2).append(';');
    }

    public void resolve(BlockScope var1) {
        if ((this.field_446 & 1) == 0) {
            var1.problemReporter().method_1762(this.field_444, this.field_445);
        } else {
            var1.problemReporter().method_1539(this.field_444, this.field_445);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
