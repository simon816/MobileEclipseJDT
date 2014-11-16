package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class SingleTypeReference extends TypeReference {

    public char[] token;

    public SingleTypeReference(char[] var1, long var2) {
        this.token = var1;
        this.field_444 = (int)(var2 >>> 32);
        this.field_445 = (int)(var2 & 4294967295L);
    }

    public TypeReference copyDims(int var1) {
        ArrayTypeReference var10000 = new ArrayTypeReference(this.token, var1, ((long)this.field_444 << 32) + (long)this.field_445);
        return var10000;
    }

    public char[] getLastToken() {
        return this.token;
    }

    protected TypeBinding getTypeBinding(Scope var1) {
        if (this.resolvedType != null) {
            return this.resolvedType;
        } else {
            this.resolvedType = var1.getType(this.token);
            return var1.kind == 3 && this.resolvedType.isValidBinding() && ((ClassScope)var1).detectHierarchyCycle(this.resolvedType, this) ? null : this.resolvedType;
        }
    }

    public char[][] getTypeName() {
        return new char[][] {this.token};
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return var2.append(this.token);
    }

    public TypeBinding resolveTypeEnclosing(BlockScope var1, ReferenceBinding var2) {
        Object var3 = this.resolvedType = var1.getMemberType(this.token, var2);
        boolean var4 = false;
        if (!((TypeBinding)var3).isValidBinding()) {
            var4 = true;
            var1.problemReporter().invalidEnclosingType(this, (TypeBinding)var3, var2);
            var3 = ((ReferenceBinding)var3).closestMatch();
            if (var3 == null) {
                return null;
            }
        }
        if (this.isTypeUseDeprecated((TypeBinding)var3, var1)) {
            var1.problemReporter().method_1516((TypeBinding)var3, this);
        }
        TypeBinding var5 = var1.environment().convertToRawType((TypeBinding)var3, false);
        if (var5.method_166() && (this.field_446 & 1073741824) == 0 && var1.compilerOptions().method_3313(35184372088832L) != -1) {
            var1.problemReporter().method_1742(this, var5);
        }
        return var4 ? var5 : (this.resolvedType = var5);
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
