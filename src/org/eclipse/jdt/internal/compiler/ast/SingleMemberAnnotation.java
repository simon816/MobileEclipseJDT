package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class SingleMemberAnnotation extends Annotation {

    public Expression memberValue;

    private MemberValuePair[] singlePairs;

    public SingleMemberAnnotation(TypeReference var1, int var2) {
        this.type = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    public ElementValuePair[] computeElementValuePairs() {
        return new ElementValuePair[] {this.memberValuePairs()[0].compilerElementPair};
    }

    public MemberValuePair[] memberValuePairs() {
        if (this.singlePairs == null) {
            MemberValuePair[] var10001 = new MemberValuePair[1];
            MemberValuePair var10004 = new MemberValuePair(field_70, this.memberValue.field_444, this.memberValue.field_445, this.memberValue);
            var10001[0] = var10004;
            this.singlePairs = var10001;
        }
        return this.singlePairs;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        super.printExpression(var1, var2);
        var2.append('(');
        this.memberValue.printExpression(var1, var2);
        return var2.append(')');
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
            if (this.memberValue != null) {
                this.memberValue.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
