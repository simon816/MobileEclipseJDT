package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Literal;

public abstract class NumberLiteral extends Literal {

    char[] source;

    public NumberLiteral(char[] var1, int var2, int var3) {
        this(var2, var3);
        this.source = var1;
    }

    public NumberLiteral(int var1, int var2) {
        super(var1, var2);
    }

    public char[] source() {
        return this.source;
    }
}
