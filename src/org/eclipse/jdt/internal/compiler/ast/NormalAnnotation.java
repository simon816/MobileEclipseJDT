package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class NormalAnnotation extends Annotation {

    public MemberValuePair[] memberValuePairs;

    public NormalAnnotation(TypeReference var1, int var2) {
        this.type = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    public ElementValuePair[] computeElementValuePairs() {
        int var1 = this.memberValuePairs == null ? 0 : this.memberValuePairs.length;
        if (var1 == 0) {
            return Binding.NO_ELEMENT_VALUE_PAIRS;
        } else {
            ElementValuePair[] var2 = new ElementValuePair[var1];
            for (int var3 = 0; var3 < var1; ++var3) {
                var2[var3] = this.memberValuePairs[var3].compilerElementPair;
            }
            return var2;
        }
    }

    public MemberValuePair[] memberValuePairs() {
        return this.memberValuePairs == null ? NoValuePairs : this.memberValuePairs;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        super.printExpression(var1, var2);
        var2.append('(');
        if (this.memberValuePairs != null) {
            int var3 = 0;
            for (int var4 = this.memberValuePairs.length; var3 < var4; ++var3) {
                if (var3 > 0) {
                    var2.append(',');
                }
                this.memberValuePairs[var3].print(var1, var2);
            }
        }
        var2.append(')');
        return var2;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
            if (this.memberValuePairs != null) {
                int var3 = this.memberValuePairs.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.memberValuePairs[var4].traverse(var1, var2);
                }
            }
        }
        var1.endVisit(this, var2);
    }
}
