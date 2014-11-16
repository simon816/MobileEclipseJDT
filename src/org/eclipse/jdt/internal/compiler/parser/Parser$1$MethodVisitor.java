package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;

class Parser$1$MethodVisitor extends ASTVisitor {

    public ASTVisitor typeVisitor;

    TypeDeclaration enclosingType;

    TypeDeclaration[] types;

    int typePtr;

    private final Parser field_1163;

    Parser$1$MethodVisitor(Parser var1) {
        this.field_1163 = var1;
        this.types = new TypeDeclaration[0];
        this.typePtr = -1;
    }

    public boolean visit(ConstructorDeclaration var1, ClassScope var2) {
        this.typePtr = -1;
        return true;
    }

    public boolean visit(Initializer var1, MethodScope var2) {
        this.typePtr = -1;
        return var1.block != null;
    }

    public boolean visit(MethodDeclaration var1, ClassScope var2) {
        this.typePtr = -1;
        return true;
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
        return false;
    }

    public void endVisit(ConstructorDeclaration var1, ClassScope var2) {
        this.endVisitMethod(var1, var2);
    }

    public void endVisit(MethodDeclaration var1, ClassScope var2) {
        this.endVisitMethod(var1, var2);
    }

    private void endVisitMethod(AbstractMethodDeclaration var1, ClassScope var2) {
        TypeDeclaration[] var3 = null;
        int var4 = 0;
        if (this.typePtr > -1) {
            var4 = this.typePtr + 1;
            var3 = new TypeDeclaration[var4];
            System.arraycopy(this.types, 0, var3, 0, var4);
        }
        ReferenceContext var5 = this.field_1163.referenceContext;
        this.field_1163.recoveryScanner.method_2435(var1.field_490, var1.field_491);
        Scanner var6 = this.field_1163.scanner;
        this.field_1163.scanner = this.field_1163.recoveryScanner;
        this.field_1163.parseStatements(var1, var1.field_490, var1.field_491, var3, this.field_1163.compilationUnit);
        this.field_1163.scanner = var6;
        this.field_1163.referenceContext = var5;
        for (int var7 = 0; var7 < var4; ++var7) {
            var3[var7].traverse(this.typeVisitor, var2);
        }
    }

    public void endVisit(Initializer var1, MethodScope var2) {
        if (var1.block != null) {
            TypeDeclaration[] var3 = null;
            int var4 = 0;
            if (this.typePtr > -1) {
                var4 = this.typePtr + 1;
                var3 = new TypeDeclaration[var4];
                System.arraycopy(this.types, 0, var3, 0, var4);
            }
            ReferenceContext var5 = this.field_1163.referenceContext;
            this.field_1163.recoveryScanner.method_2435(var1.field_666, var1.field_667);
            Scanner var6 = this.field_1163.scanner;
            this.field_1163.scanner = this.field_1163.recoveryScanner;
            this.field_1163.parseStatements(this.enclosingType, var1.field_666, var1.field_667, var3, this.field_1163.compilationUnit);
            this.field_1163.scanner = var6;
            this.field_1163.referenceContext = var5;
            for (int var7 = 0; var7 < var4; ++var7) {
                var3[var7].traverse(this.typeVisitor, var2);
            }
        }
    }
}
