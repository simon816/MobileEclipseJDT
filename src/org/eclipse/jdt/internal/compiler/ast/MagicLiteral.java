package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Literal;

public abstract class MagicLiteral extends Literal {

    public MagicLiteral(int var1, int var2) {
        super(var1, var2);
    }

    public char[] source() {
        return null;
    }
}
