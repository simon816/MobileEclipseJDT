package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class Literal extends Expression {

    public Literal(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public abstract void computeConstant();

    public abstract TypeBinding literalType(BlockScope var1);

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return var2.append(this.source());
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.resolvedType = this.literalType(var1);
        this.computeConstant();
        if (this.constant == null) {
            var1.problemReporter().constantOutOfRange(this, this.resolvedType);
            this.constant = Constant.NotAConstant;
        }
        return this.resolvedType;
    }

    public abstract char[] source();
}
