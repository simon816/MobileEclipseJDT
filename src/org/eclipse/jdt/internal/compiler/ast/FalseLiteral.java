package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.MagicLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.impl.BooleanConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class FalseLiteral extends MagicLiteral {

    static final char[] source;

    public FalseLiteral(int var1, int var2) {
        super(var1, var2);
    }

    public void computeConstant() {
        this.constant = BooleanConstant.fromValue(false);
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.generateConstant(this.constant, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = var2.field_1208;
        if (var5 && var4 != null && var3 == null) {
            var2.method_2209(var4);
        }
        var2.method_2360(var6, this.field_444);
    }

    public TypeBinding literalType(BlockScope var1) {
        return TypeBinding.field_186;
    }

    public char[] source() {
        return source;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    static {
        source = new char[] {'f', 'a', 'l', 's', 'e'};
    }
}
