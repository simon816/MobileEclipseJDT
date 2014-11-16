package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.DoubleConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.util.FloatUtil;

public class DoubleLiteral extends NumberLiteral {

    double value;

    public DoubleLiteral(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public void computeConstant() {
        Double var1;
        try {
            var1 = Double.valueOf(String.valueOf(this.source));
        } catch (NumberFormatException var7) {
            try {
                double var3 = FloatUtil.valueOfHexDoubleLiteral(this.source);
                if (var3 == Double.POSITIVE_INFINITY) {
                    return;
                }
                if (Double.isNaN(var3)) {
                    return;
                }
                this.value = var3;
                this.constant = DoubleConstant.fromValue(var3);
            } catch (NumberFormatException var6) {
                ;
            }
            return;
        }
        double var2 = var1.doubleValue();
        if (var2 <= Double.MAX_VALUE) {
            if (var2 < Double.MIN_VALUE) {
                boolean var4 = false;
                int var5 = 0;
                label52:
                while (var5 < this.source.length) {
                    switch (this.source[var5]) {
                        case 68:
                        case 69:
                        case 70:
                        case 100:
                        case 101:
                        case 102:
                            if (var4) {
                                return;
                            }
                        case 80:
                        case 112:
                            break label52;
                        case 88:
                        case 120:
                            var4 = true;
                        case 46:
                        case 48:
                            ++var5;
                            break;
                        default:
                            return;
                    }
                }
            }
            this.value = var2;
            this.constant = DoubleConstant.fromValue(this.value);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.generateConstant(this.constant, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public TypeBinding literalType(BlockScope var1) {
        return TypeBinding.field_185;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
