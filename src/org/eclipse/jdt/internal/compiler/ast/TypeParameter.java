package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class TypeParameter extends AbstractVariableDeclaration {

    public TypeVariableBinding binding;

    public TypeReference[] bounds;

    public TypeParameter() {
    }

    public int getKind() {
        return 6;
    }

    public void checkBounds(Scope var1) {
        if (this.type != null) {
            this.type.checkBounds(var1);
        }
        if (this.bounds != null) {
            int var2 = 0;
            for (int var3 = this.bounds.length; var2 < var3; ++var2) {
                this.bounds[var2].checkBounds(var1);
            }
        }
    }

    private void internalResolve(Scope var1, boolean var2) {
        if (this.binding != null) {
            Binding var3 = var1.parent.getBinding(this.name, 4, this, false);
            if (var3 != null && this.binding != var3 && var3.isValidBinding() && (var3.kind() != 4100 || !var2)) {
                var1.problemReporter().typeHiding(this, var3);
            }
        }
    }

    public void resolve(BlockScope var1) {
        this.internalResolve(var1, var1.method_635().field_404);
    }

    public void resolve(ClassScope var1) {
        this.internalResolve(var1, var1.enclosingSourceType().method_226());
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        var2.append(this.name);
        if (this.type != null) {
            var2.append(" extends ");
            this.type.print(0, var2);
        }
        if (this.bounds != null) {
            for (int var3 = 0; var3 < this.bounds.length; ++var3) {
                var2.append(" & ");
                this.bounds[var3].print(0, var2);
            }
        }
        return var2;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {}

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
            if (this.bounds != null) {
                int var3 = this.bounds.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.bounds[var4].traverse(var1, var2);
                }
            }
        }
        var1.endVisit(this, var2);
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        if (var1.visit(this, var2)) {
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
            if (this.bounds != null) {
                int var3 = this.bounds.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.bounds[var4].traverse(var1, var2);
                }
            }
        }
        var1.endVisit(this, var2);
    }
}
