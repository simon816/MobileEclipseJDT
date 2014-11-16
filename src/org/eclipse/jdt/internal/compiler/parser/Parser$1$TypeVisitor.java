package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Parser$1$MethodVisitor;
import org.eclipse.jdt.internal.compiler.parser.Parser;

class Parser$1$TypeVisitor extends ASTVisitor {

    public Parser$1$MethodVisitor methodVisitor;

    TypeDeclaration[] types;

    int typePtr;

    private final Parser field_1167;

    Parser$1$TypeVisitor(Parser var1) {
        this.field_1167 = var1;
        this.types = new TypeDeclaration[0];
        this.typePtr = -1;
    }

    public void endVisit(TypeDeclaration var1, BlockScope var2) {
        this.endVisitType();
    }

    public void endVisit(TypeDeclaration var1, ClassScope var2) {
        this.endVisitType();
    }

    private void endVisitType() {
        --this.typePtr;
    }

    public boolean visit(TypeDeclaration var1, BlockScope var2) {
        return this.visit(var1);
    }

    public boolean visit(TypeDeclaration var1, ClassScope var2) {
        return this.visit(var1);
    }

    private boolean visit(TypeDeclaration var1) {
        if (this.types.length <= ++this.typePtr) {
            int var2 = this.typePtr;
            System.arraycopy(this.types, 0, this.types = new TypeDeclaration[var2 * 2 + 1], 0, var2);
        }
        this.types[this.typePtr] = var1;
        return true;
    }

    public boolean visit(ConstructorDeclaration var1, ClassScope var2) {
        if (var1.method_796()) {
            return false;
        } else {
            var1.traverse(this.methodVisitor, var2);
            return false;
        }
    }

    public boolean visit(Initializer var1, MethodScope var2) {
        if (var1.block == null) {
            return false;
        } else {
            this.methodVisitor.enclosingType = this.types[this.typePtr];
            var1.traverse(this.methodVisitor, var2);
            return false;
        }
    }

    public boolean visit(MethodDeclaration var1, ClassScope var2) {
        var1.traverse(this.methodVisitor, var2);
        return false;
    }
}
