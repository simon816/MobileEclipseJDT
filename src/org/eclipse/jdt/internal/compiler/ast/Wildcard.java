package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class Wildcard extends SingleTypeReference {

    public TypeReference bound;

    public int kind;

    public Wildcard(int var1) {
        super(field_51, 0L);
        this.kind = var1;
    }

    public char[][] getTypeName() {
        switch (this.kind) {
            case 0:
                return new char[][] {field_51};
            case 1:
                return new char[][] {CharOperation.method_1356(field_51, field_53, CharOperation.concatWith(this.bound.getTypeName(), '.'))};
            default:
                return new char[][] {CharOperation.method_1356(field_51, field_52, CharOperation.concatWith(this.bound.getTypeName(), '.'))};
        }
    }

    private TypeBinding internalResolveType(Scope var1, ReferenceBinding var2, int var3) {
        TypeBinding var4 = null;
        if (this.bound != null) {
            var4 = var1.kind == 3 ? this.bound.resolveType((ClassScope)var1) : this.bound.resolveType((BlockScope)var1, true);
            if (var4 == null) {
                return null;
            }
        }
        WildcardBinding var5 = var1.environment().createWildcard(var2, var3, var4, (TypeBinding[])null, this.kind);
        return this.resolvedType = var5;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        switch (this.kind) {
            case 0:
                var2.append(field_51);
                break;
            case 1:
                var2.append(field_51).append(field_53);
                this.bound.printExpression(0, var2);
                break;
            default:
                var2.append(field_51).append(field_52);
                this.bound.printExpression(0, var2);
        }
        return var2;
    }

    public TypeBinding resolveType(BlockScope var1, boolean var2) {
        if (this.bound != null) {
            this.bound.resolveType(var1, var2);
        }
        return null;
    }

    public TypeBinding resolveType(ClassScope var1) {
        if (this.bound != null) {
            this.bound.resolveType(var1);
        }
        return null;
    }

    public TypeBinding resolveTypeArgument(BlockScope var1, ReferenceBinding var2, int var3) {
        return this.internalResolveType(var1, var2, var3);
    }

    public TypeBinding resolveTypeArgument(ClassScope var1, ReferenceBinding var2, int var3) {
        return this.internalResolveType(var1, var2, var3);
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.bound != null) {
            this.bound.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        if (var1.visit(this, var2) && this.bound != null) {
            this.bound.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
