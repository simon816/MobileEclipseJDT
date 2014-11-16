package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class SuperReference extends ThisReference {

    public SuperReference(int var1, int var2) {
        super(var1, var2);
    }

    public static ExplicitConstructorCall implicitSuperConstructorCall() {
        ExplicitConstructorCall var10000 = new ExplicitConstructorCall(1);
        return var10000;
    }

    public boolean method_752() {
        return false;
    }

    public boolean method_754() {
        return true;
    }

    public boolean method_755() {
        return false;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return var2.append("super");
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        if (!this.checkAccess(var1.method_635())) {
            return null;
        } else {
            ReferenceBinding var2 = var1.method_584();
            if (var2.id == 1) {
                var1.problemReporter().method_1506(this);
                return null;
            } else {
                return this.resolvedType = var2.superclass();
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
