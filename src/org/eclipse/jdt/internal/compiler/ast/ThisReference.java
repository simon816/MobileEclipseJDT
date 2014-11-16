package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class ThisReference extends Reference {

    public static ThisReference implicitThis() {
        ThisReference var10000 = new ThisReference(0, 0);
        ThisReference var0 = var10000;
        var0.field_446 |= 4;
        return var0;
    }

    public ThisReference(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    public FlowInfo analyseAssignment(BlockScope var1, FlowContext var2, FlowInfo var3, Assignment var4, boolean var5) {
        return var3;
    }

    public boolean checkAccess(MethodScope var1) {
        if (var1.field_405) {
            var1.problemReporter().fieldsOrThisBeforeConstructorInvocation(this);
            return false;
        } else if (var1.field_404) {
            var1.problemReporter().method_1546(this);
            return false;
        } else {
            return true;
        }
    }

    public void generateAssignment(BlockScope var1, CodeStream var2, Assignment var3, boolean var4) {}

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2093();
        }
        if ((this.field_446 & 4) == 0) {
            var2.method_2360(var4, this.field_444);
        }
    }

    public void generateCompoundAssignment(BlockScope var1, CodeStream var2, Expression var3, int var4, int var5, boolean var6) {}

    public void generatePostIncrement(BlockScope var1, CodeStream var2, CompoundAssignment var3, boolean var4) {}

    public boolean method_752() {
        return (this.field_446 & 4) != 0;
    }

    public boolean method_755() {
        return true;
    }

    public int nullStatus(FlowInfo var1) {
        return -1;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return this.method_752() ? var2 : var2.append("this");
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        return !this.method_752() && !this.checkAccess(var1.method_635()) ? null : (this.resolvedType = var1.method_584());
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
