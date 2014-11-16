package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.CharConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

public class CharLiteral extends NumberLiteral {

    char value;

    public CharLiteral(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
        this.computeValue();
    }

    public void computeConstant() {
        this.constant = CharConstant.fromValue(this.value);
    }

    private void computeValue() {
        if ((this.value = this.source[1]) == 92) {
            char var1;
            switch (var1 = this.source[2]) {
                case 34:
                    this.value = 34;
                    break;
                case 39:
                    this.value = 39;
                    break;
                case 92:
                    this.value = 92;
                    break;
                case 98:
                    this.value = 8;
                    break;
                case 102:
                    this.value = 12;
                    break;
                case 110:
                    this.value = 10;
                    break;
                case 114:
                    this.value = 13;
                    break;
                case 116:
                    this.value = 9;
                    break;
                default:
                    int var2 = ScannerHelper.getNumericValue(var1);
                    if ((var1 = this.source[3]) != 39) {
                        var2 = var2 * 8 + ScannerHelper.getNumericValue(var1);
                        if ((var1 = this.source[4]) != 39) {
                            var2 = var2 * 8 + ScannerHelper.getNumericValue(var1);
                        }
                        this.value = (char)var2;
                    } else {
                        this.constant = CharConstant.fromValue(this.value = (char)var2);
                    }
            }
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
        return TypeBinding.field_182;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
