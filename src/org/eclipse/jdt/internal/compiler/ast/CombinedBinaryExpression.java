package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class CombinedBinaryExpression extends BinaryExpression {

    public int field_720;

    public int field_721;

    public static int defaultArityMaxStartingValue;

    public BinaryExpression[] referencesTable;

    public CombinedBinaryExpression(Expression var1, Expression var2, int var3, int var4) {
        super(var1, var2, var3);
        this.initArity(var1, var4);
    }

    public CombinedBinaryExpression(CombinedBinaryExpression var1) {
        super(var1);
        this.initArity(var1.field_715, var1.field_720);
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.referencesTable == null) {
            return super.analyseCode(var1, var2, var3);
        } else {
            BinaryExpression var4;
            if ((var4 = this.referencesTable[0]).resolvedType.id != 11) {
                var4.field_715.checkNPE(var1, var2, var3);
            }
            UnconditionalFlowInfo var7 = var4.field_715.analyseCode(var1, var2, var3).method_3109();
            int var5 = 0;
            for (int var6 = this.field_720; var5 < var6; ++var5) {
                if ((var4 = this.referencesTable[var5]).resolvedType.id != 11) {
                    var4.field_716.checkNPE(var1, var2, var7);
                }
                var7 = var4.field_716.analyseCode(var1, var2, var7).method_3109();
            }
            if (this.resolvedType.id != 11) {
                this.field_716.checkNPE(var1, var2, var7);
            }
            return this.field_716.analyseCode(var1, var2, var7).method_3109();
        }
    }

    public void method_914(BlockScope var1, CodeStream var2, int var3) {
        if (this.referencesTable == null) {
            super.method_914(var1, var2, var3);
        } else if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11) {
            if (this.constant != Constant.NotAConstant) {
                var2.generateConstant(this.constant, this.field_674);
                var2.method_2274(this.field_674 & 15);
            } else {
                BinaryExpression var4 = this.referencesTable[0];
                boolean var5 = false;
                int var6 = var2.field_1208;
                int var9;
                for (var9 = this.field_720 - 1; var9 >= 0; --var9) {
                    if ((var4 = this.referencesTable[var9]).constant != Constant.NotAConstant) {
                        var2.generateConstant(var4.constant, var4.field_674);
                        var2.method_2274(var4.field_674 & 15);
                        break;
                    }
                }
                ++var9;
                if (var9 == 0) {
                    var4.field_715.method_914(var1, var2, var4.field_715.field_674 & 15);
                }
                for (int var8 = var9; var8 < this.field_720; ++var8) {
                    var2.method_2360(var6, (var4 = this.referencesTable[var8]).field_715.field_444);
                    int var7 = var2.field_1208;
                    var4.field_716.method_914(var1, var2, var4.field_716.field_674 & 15);
                    var2.method_2360(var7, var4.field_716.field_444);
                }
                var2.method_2360(var6, this.field_715.field_444);
                var6 = var2.field_1208;
                this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
                var2.method_2360(var6, this.field_716.field_444);
            }
        } else {
            super.method_914(var1, var2, var3);
        }
    }

    public void method_915(BlockScope var1, CodeStream var2, int var3) {
        if (this.referencesTable == null) {
            super.method_915(var1, var2, var3);
        } else if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11 && this.constant == Constant.NotAConstant) {
            int var4 = var2.field_1208;
            BinaryExpression var5 = this.referencesTable[this.field_720 - 1];
            boolean var6 = false;
            int var9;
            for (var9 = this.field_720 - 1; var9 >= 0; --var9) {
                if (((var5 = this.referencesTable[var9]).field_446 & 4032) >> 6 != 14 || (var5.field_446 & 15) != 11) {
                    var5.method_915(var1, var2, var5.field_674 & 15);
                    break;
                }
                if (var5.constant != Constant.NotAConstant) {
                    var2.method_2349();
                    var2.method_2141();
                    var2.ldc(var5.constant.method_3287());
                    var2.method_2276();
                    break;
                }
            }
            ++var9;
            if (var9 == 0) {
                var5.field_715.method_915(var1, var2, var5.field_715.field_674 & 15);
            }
            for (int var8 = var9; var8 < this.field_720; ++var8) {
                var2.method_2360(var4, (var5 = this.referencesTable[var8]).field_715.field_444);
                int var7 = var2.field_1208;
                var5.field_716.method_914(var1, var2, var5.field_716.field_674 & 15);
                var2.method_2360(var7, var5.field_716.field_444);
            }
            var2.method_2360(var4, this.field_715.field_444);
            var4 = var2.field_1208;
            this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
            var2.method_2360(var4, this.field_716.field_444);
        } else {
            super.method_915(var1, var2, var3);
        }
    }

    private void initArity(Expression var1, int var2) {
        this.field_720 = var2;
        if (var2 > 1) {
            this.referencesTable = new BinaryExpression[var2];
            this.referencesTable[var2 - 1] = (BinaryExpression)var1;
            for (int var3 = var2 - 1; var3 > 0; --var3) {
                this.referencesTable[var3 - 1] = (BinaryExpression)this.referencesTable[var3].field_715;
            }
        } else {
            this.field_721 = defaultArityMaxStartingValue;
        }
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        if (this.referencesTable == null) {
            return super.printExpressionNoParenthesis(var1, var2);
        } else {
            String var3 = this.operatorToString();
            int var4;
            for (var4 = this.field_720 - 1; var4 >= 0; --var4) {
                var2.append('(');
            }
            var2 = this.referencesTable[0].field_715.printExpression(var1, var2);
            var4 = 0;
            for (int var5 = this.field_720; var4 < var5; ++var4) {
                var2.append(' ').append(var3).append(' ');
                var2 = this.referencesTable[var4].field_716.printExpression(0, var2);
                var2.append(')');
            }
            var2.append(' ').append(var3).append(' ');
            return this.field_716.printExpression(0, var2);
        }
    }

    public TypeBinding resolveType(BlockScope var1) {
        if (this.referencesTable == null) {
            return super.resolveType(var1);
        } else {
            BinaryExpression var2;
            if ((var2 = this.referencesTable[0]).field_715 instanceof CastExpression) {
                var2.field_715.field_446 |= 32;
            }
            var2.field_715.resolveType(var1);
            int var3 = 0;
            for (int var4 = this.field_720; var3 < var4; ++var3) {
                this.referencesTable[var3].nonRecursiveResolveTypeUpwards(var1);
            }
            this.nonRecursiveResolveTypeUpwards(var1);
            return this.resolvedType;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (this.referencesTable == null) {
            super.traverse(var1, var2);
        } else {
            if (var1.visit(this, var2)) {
                int var3;
                for (var3 = this.field_720 - 1; var3 >= 0; --var3) {
                    if (!var1.visit(this.referencesTable[var3], var2)) {
                        var1.endVisit(this.referencesTable[var3], var2);
                        break;
                    }
                }
                ++var3;
                if (var3 == 0) {
                    this.referencesTable[0].field_715.traverse(var1, var2);
                }
                int var4 = var3;
                for (int var5 = this.field_720; var4 < var5; ++var4) {
                    this.referencesTable[var4].field_716.traverse(var1, var2);
                    var1.endVisit(this.referencesTable[var4], var2);
                }
                this.field_716.traverse(var1, var2);
            }
            var1.endVisit(this, var2);
        }
    }

    public void tuneArityMax() {
        if (this.field_721 < 160) {
            this.field_721 *= 2;
        }
    }

    static {
        defaultArityMaxStartingValue = 20;
    }
}
