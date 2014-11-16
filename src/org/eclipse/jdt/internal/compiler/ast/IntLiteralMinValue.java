package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.IntConstant;

public class IntLiteralMinValue extends IntLiteral {

    static final char[] CharValue;

    static final Constant field_800;

    public IntLiteralMinValue() {
        super(CharValue, 0, 0, Integer.MIN_VALUE);
        this.constant = field_800;
    }

    public void computeConstant() {}

    static {
        CharValue = new char[] {'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        field_800 = IntConstant.fromValue(Integer.MIN_VALUE);
    }
}
