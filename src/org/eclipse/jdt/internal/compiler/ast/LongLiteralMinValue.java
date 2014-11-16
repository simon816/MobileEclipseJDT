package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.LongConstant;

public class LongLiteralMinValue extends LongLiteral {

    static final char[] CharValue;

    static final Constant field_804;

    public LongLiteralMinValue() {
        super(CharValue, 0, 0);
        this.constant = field_804;
    }

    public void computeConstant() {}

    static {
        CharValue = new char[] {'-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8', 'L'};
        field_804 = LongConstant.fromValue(Long.MIN_VALUE);
    }
}
