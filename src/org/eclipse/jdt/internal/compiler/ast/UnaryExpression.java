package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.OperatorExpression;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.BooleanConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class UnaryExpression extends OperatorExpression {

    public Expression expression;

    public Constant optimizedBooleanConstant;

    public UnaryExpression(Expression var1, int var2) {
        this.expression = var1;
        this.field_446 |= var2 << 6;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.expression.checkNPE(var1, var2, var3);
        return (this.field_446 & 4032) >> 6 == 11 ? this.expression.analyseCode(var1, var2, var3).asNegatedCondition() : this.expression.analyseCode(var1, var2, var3);
    }

    public Constant optimizedBooleanConstant() {
        return this.optimizedBooleanConstant == null ? this.constant : this.optimizedBooleanConstant;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.constant != Constant.NotAConstant) {
            if (var3) {
                var2.generateConstant(this.constant, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            label63:
            switch ((this.field_446 & 4032) >> 6) {
                case 11:
                    switch ((this.expression.field_674 & 255) >> 4) {
                        case 5:
                            Expression var10000 = this.expression;
                            BranchLabel var10004 = new BranchLabel(var2);
                            BranchLabel var5 = var10004;
                            var10000.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var10004, var3);
                            if (var3) {
                                var2.method_2221();
                                if (var5.forwardReferenceCount() > 0) {
                                    BranchLabel var10001 = new BranchLabel(var2);
                                    BranchLabel var6 = var10001;
                                    var2.method_2209(var10001);
                                    var2.method_2125(1);
                                    var5.place();
                                    var2.method_2222();
                                    var6.place();
                                }
                            } else {
                                var5.place();
                            }
                        default:
                            break label63;
                    }
                case 12:
                    switch ((this.expression.field_674 & 255) >> 4) {
                        case 7:
                            this.expression.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2314(-1L);
                                var2.method_2339();
                            }
                            break label63;
                        case 10:
                            this.expression.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2227();
                                var2.method_2296();
                            }
                        default:
                            break label63;
                    }
                case 13:
                    if (this.constant != Constant.NotAConstant) {
                        if (var3) {
                            switch ((this.expression.field_674 & 255) >> 4) {
                                case 7:
                                    var2.method_2189(this.constant.longValue() * -1L);
                                    break label63;
                                case 8:
                                    var2.method_2186(this.constant.doubleValue() * -1.0D);
                                    break label63;
                                case 9:
                                    var2.method_2187(this.constant.floatValue() * -1.0F);
                                    break label63;
                                case 10:
                                    var2.method_2188(this.constant.intValue() * -1);
                            }
                        }
                    } else {
                        this.expression.generateCode(var1, var2, var3);
                        if (var3) {
                            switch ((this.expression.field_674 & 255) >> 4) {
                                case 7:
                                    var2.method_2323();
                                    break label63;
                                case 8:
                                    var2.method_2132();
                                    break label63;
                                case 9:
                                    var2.method_2167();
                                    break label63;
                                case 10:
                                    var2.method_2253();
                            }
                        }
                    }
                    break;
                case 14:
                    this.expression.generateCode(var1, var2, var3);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if (this.constant != Constant.NotAConstant && this.constant.typeID() == 5) {
            super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
        } else {
            if ((this.field_446 & 4032) >> 6 == 11) {
                this.expression.generateOptimizedBoolean(var1, var2, var4, var3, var5);
            } else {
                super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
            }
        }
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        var2.append(this.operatorToString()).append(' ');
        return this.expression.printExpression(0, var2);
    }

    public TypeBinding resolveType(BlockScope var1) {
        boolean var2;
        if (var2 = this.expression instanceof CastExpression) {
            this.expression.field_446 |= 32;
        }
        TypeBinding var3 = this.expression.resolveType(var1);
        if (var3 == null) {
            this.constant = Constant.NotAConstant;
            return null;
        } else {
            int var4 = var3.id;
            boolean var5 = var1.compilerOptions().field_1928 >= 3211264L;
            if (var5 && !var3.method_148()) {
                var4 = var1.environment().method_486(var3).id;
            }
            if (var4 > 15) {
                this.constant = Constant.NotAConstant;
                var1.problemReporter().invalidOperator(this, var3);
                return null;
            } else {
                byte var6;
                switch ((this.field_446 & 4032) >> 6) {
                    case 11:
                        var6 = 0;
                        break;
                    case 12:
                        var6 = 10;
                        break;
                    default:
                        var6 = 13;
                }
                int var7 = OperatorSignatures[var6][(var4 << 4) + var4];
                this.expression.computeConversion(var1, TypeBinding.wellKnownType(var1, var7 >>> 16 & 15), var3);
                this.field_446 |= var7 & 15;
                switch (var7 & 15) {
                    case 2:
                        this.resolvedType = TypeBinding.field_182;
                        break;
                    case 3:
                        this.resolvedType = TypeBinding.field_180;
                        break;
                    case 4:
                    case 6:
                    default:
                        this.constant = Constant.NotAConstant;
                        if (var4 != 0) {
                            var1.problemReporter().invalidOperator(this, var3);
                        }
                        return null;
                    case 5:
                        this.resolvedType = TypeBinding.field_186;
                        break;
                    case 7:
                        this.resolvedType = TypeBinding.field_183;
                        break;
                    case 8:
                        this.resolvedType = TypeBinding.field_185;
                        break;
                    case 9:
                        this.resolvedType = TypeBinding.field_184;
                        break;
                    case 10:
                        this.resolvedType = TypeBinding.field_179;
                }
                if (this.expression.constant != Constant.NotAConstant) {
                    this.constant = Constant.computeConstantOperation(this.expression.constant, var4, (this.field_446 & 4032) >> 6);
                } else {
                    this.constant = Constant.NotAConstant;
                    if ((this.field_446 & 4032) >> 6 == 11) {
                        Constant var8 = this.expression.optimizedBooleanConstant();
                        if (var8 != Constant.NotAConstant) {
                            this.optimizedBooleanConstant = BooleanConstant.fromValue(!var8.booleanValue());
                        }
                    }
                }
                if (var2) {
                    CastExpression.checkNeedForArgumentCast(var1, var6, var7, this.expression, var4);
                }
                return this.resolvedType;
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.expression.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
