package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.MagicLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class NullLiteral extends MagicLiteral {

    static final char[] source;

    public NullLiteral(int var1, int var2) {
        super(var1, var2);
    }

    public void computeConstant() {
        this.constant = Constant.NotAConstant;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2087();
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public TypeBinding literalType(BlockScope var1) {
        return TypeBinding.field_187;
    }

    public int nullStatus(FlowInfo var1) {
        return 1;
    }

    public Object reusableJSRTarget() {
        return TypeBinding.field_187;
    }

    public char[] source() {
        return source;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    static {
        source = new char[] {'n', 'u', 'l', 'l'};
    }
}
