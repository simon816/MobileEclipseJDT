package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ArrayTypeReference extends SingleTypeReference {

    public int field_729;

    public int field_730;

    public ArrayTypeReference(char[] var1, int var2, long var3) {
        super(var1, var3);
        this.field_730 = this.field_445;
        this.field_729 = var2;
    }

    public int dimensions() {
        return this.field_729;
    }

    protected TypeBinding getTypeBinding(Scope var1) {
        if (this.resolvedType != null) {
            return this.resolvedType;
        } else {
            if (this.field_729 > 255) {
                var1.problemReporter().method_1768(this);
            }
            TypeBinding var2 = var1.getType(this.token);
            return var1.createArrayType(var2, this.field_729);
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        super.printExpression(var1, var2);
        int var3;
        if ((this.field_446 & 16384) != 0) {
            for (var3 = 0; var3 < this.field_729 - 1; ++var3) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var3 = 0; var3 < this.field_729; ++var3) {
                var2.append("[]");
            }
        }
        return var2;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
