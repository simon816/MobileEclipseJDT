package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class MarkerAnnotation extends Annotation {

    public MarkerAnnotation(TypeReference var1, int var2) {
        this.type = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    public MemberValuePair[] memberValuePairs() {
        return NoValuePairs;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.type != null) {
            this.type.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
