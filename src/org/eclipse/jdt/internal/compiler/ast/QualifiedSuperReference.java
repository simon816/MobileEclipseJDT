package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class QualifiedSuperReference extends QualifiedThisReference {

    public QualifiedSuperReference(TypeReference var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public boolean method_754() {
        return true;
    }

    public boolean method_755() {
        return false;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return this.qualification.print(0, var2).append(".super");
    }

    public TypeBinding resolveType(BlockScope var1) {
        if ((this.field_446 & 534773760) != 0) {
            var1.problemReporter().method_1638(this);
            return null;
        } else {
            super.resolveType(var1);
            if (this.currentCompatibleType == null) {
                return null;
            } else if (this.currentCompatibleType.id == 1) {
                var1.problemReporter().method_1506(this);
                return null;
            } else {
                return this.resolvedType = this.currentCompatibleType.superclass();
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.qualification.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
