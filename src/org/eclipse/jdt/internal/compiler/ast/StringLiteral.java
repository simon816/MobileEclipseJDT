package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Literal;
import org.eclipse.jdt.internal.compiler.ast.ExtendedStringLiteral;
import org.eclipse.jdt.internal.compiler.ast.StringLiteralConcatenation;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.StringConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class StringLiteral extends Literal {

    char[] source;

    int lineNumber;

    public StringLiteral(char[] var1, int var2, int var3, int var4) {
        this(var2, var3);
        this.source = var1;
        this.lineNumber = var4 - 1;
    }

    public StringLiteral(int var1, int var2) {
        super(var1, var2);
    }

    public void computeConstant() {
        this.constant = StringConstant.fromValue(String.valueOf(this.source));
    }

    public ExtendedStringLiteral extendWith(CharLiteral var1) {
        ExtendedStringLiteral var10000 = new ExtendedStringLiteral(this, var1);
        return var10000;
    }

    public ExtendedStringLiteral extendWith(StringLiteral var1) {
        ExtendedStringLiteral var10000 = new ExtendedStringLiteral(this, var1);
        return var10000;
    }

    public StringLiteralConcatenation extendsWith(StringLiteral var1) {
        StringLiteralConcatenation var10000 = new StringLiteralConcatenation(this, var1);
        return var10000;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.ldc(this.constant.method_3287());
        }
        var2.method_2360(var4, this.field_444);
    }

    public TypeBinding literalType(BlockScope var1) {
        return var1.method_610();
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append('\"');
        for (int var3 = 0; var3 < this.source.length; ++var3) {
            switch (this.source[var3]) {
                case 8:
                    var2.append("\\b");
                    break;
                case 9:
                    var2.append("\\t");
                    break;
                case 10:
                    var2.append("\\n");
                    break;
                case 12:
                    var2.append("\\f");
                    break;
                case 13:
                    var2.append("\\r");
                    break;
                case 34:
                    var2.append("\\\"");
                    break;
                case 39:
                    var2.append("\\\'");
                    break;
                case 92:
                    var2.append("\\\\");
                    break;
                default:
                    var2.append(this.source[var3]);
            }
        }
        var2.append('\"');
        return var2;
    }

    public char[] source() {
        return this.source;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
