package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class Initializer extends FieldDeclaration {

    public Block block;

    public int field_665;

    public int field_666;

    public int field_667;

    public Initializer(Block var1, int var2) {
        this.block = var1;
        this.field_656 = var2;
        if (var1 != null) {
            this.field_653 = this.field_444 = var1.field_444;
        }
    }

    public FlowInfo analyseCode(MethodScope var1, FlowContext var2, FlowInfo var3) {
        return this.block != null ? this.block.analyseCode(var1, var2, var3) : var3;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.block != null) {
                this.block.generateCode(var1, var2);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public int getKind() {
        return 2;
    }

    public boolean isStatic() {
        return (this.field_656 & 8) != 0;
    }

    public void parseStatements(Parser var1, TypeDeclaration var2, CompilationUnitDeclaration var3) {
        var1.parse(this, var2, var3);
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        if (this.field_656 != 0) {
            method_759(var1, var2);
            method_760(this.field_656, var2);
            if (this.annotations != null) {
                printAnnotations(this.annotations, var2);
            }
            var2.append("{\n");
            if (this.block != null) {
                this.block.method_841(var1, var2);
            }
            method_759(var1, var2).append('}');
            return var2;
        } else {
            if (this.block != null) {
                this.block.printStatement(var1, var2);
            } else {
                method_759(var1, var2).append("{}");
            }
            return var2;
        }
    }

    public void resolve(MethodScope var1) {
        FieldBinding var2 = var1.initializedField;
        int var3 = var1.field_407;
        try {
            var1.initializedField = null;
            var1.field_407 = this.field_665;
            if (this.isStatic()) {
                SourceTypeBinding var4 = var1.enclosingSourceType();
                if (var4.method_160() && !var4.method_226()) {
                    var1.problemReporter().innerTypesCannotDeclareStaticInitializers(var4, this);
                }
            }
            if (this.block != null) {
                this.block.resolve(var1);
            }
        } finally {
            var1.initializedField = var2;
            var1.field_407 = var3;
        }
    }

    public void traverse(ASTVisitor var1, MethodScope var2) {
        if (var1.visit(this, var2) && this.block != null) {
            this.block.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
