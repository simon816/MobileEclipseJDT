package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.FloatConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.util.FloatUtil;

public class FloatLiteral extends NumberLiteral {

    float value;

    static final float field_795;

    public FloatLiteral(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public void computeConstant() {
        Float var1;
        try {
            var1 = Float.valueOf(String.valueOf(this.source));
        } catch (NumberFormatException var6) {
            try {
                float var3 = FloatUtil.valueOfHexFloatLiteral(this.source);
                if (var3 == Float.POSITIVE_INFINITY) {
                    return;
                }
                if (Float.isNaN(var3)) {
                    return;
                }
                this.value = var3;
                this.constant = FloatConstant.fromValue(var3);
            } catch (NumberFormatException var5) {
                ;
            }
            return;
        }
        float var2 = var1.floatValue();
        if (var2 <= Float.MAX_VALUE) {
            if (var2 < Float.MIN_VALUE) {
                boolean var7 = false;
                int var4 = 0;
                label52:
                while (var4 < this.source.length) {
                    switch (this.source[var4]) {
                        case 68:
                        case 69:
                        case 70:
                        case 100:
                        case 101:
                        case 102:
                            if (var7) {
                                return;
                            }
                        case 80:
                        case 112:
                            break label52;
                        case 88:
                        case 120:
                            var7 = true;
                        case 46:
                        case 48:
                            ++var4;
                            break;
                        default:
                            return;
                    }
                }
            }
            this.value = var2;
            this.constant = FloatConstant.fromValue(this.value);
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
        return TypeBinding.field_184;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    static {
        field_795 = Float.intBitsToFloat(1);
    }
}
