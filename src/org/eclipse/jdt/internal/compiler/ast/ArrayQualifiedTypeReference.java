package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;

public class ArrayQualifiedTypeReference extends QualifiedTypeReference {

    int dimensions;

    public ArrayQualifiedTypeReference(char[][] var1, int var2, long[] var3) {
        super(var1, var3);
        this.dimensions = var2;
    }

    public int dimensions() {
        return this.dimensions;
    }

    protected TypeBinding getTypeBinding(Scope var1) {
        if (this.resolvedType != null) {
            return this.resolvedType;
        } else {
            if (this.dimensions > 255) {
                var1.problemReporter().method_1768(this);
            }
            LookupEnvironment var2 = var1.environment();
            ArrayBinding var4;
            try {
                var2.missingClassFileLocation = this;
                TypeBinding var3 = super.getTypeBinding(var1);
                var4 = (ArrayBinding)(this.resolvedType = var1.createArrayType(var3, this.dimensions));
            } catch (AbortCompilation var8) {
                var8.updateContext(this, var1.referenceCompilationUnit().compilationResult);
                throw var8;
            } finally {
                var2.missingClassFileLocation = null;
            }
            return var4;
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        super.printExpression(var1, var2);
        int var3;
        if ((this.field_446 & 16384) != 0) {
            for (var3 = 0; var3 < this.dimensions - 1; ++var3) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var3 = 0; var3 < this.dimensions; ++var3) {
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
