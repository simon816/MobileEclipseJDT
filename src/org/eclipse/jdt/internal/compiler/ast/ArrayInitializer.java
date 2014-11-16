package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ArrayInitializer extends Expression {

    public Expression[] expressions;

    public ArrayBinding binding;

    public ArrayInitializer() {
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.expressions != null) {
            int var4 = 0;
            for (int var5 = this.expressions.length; var4 < var5; ++var4) {
                var3 = this.expressions[var4].analyseCode(var1, var2, (FlowInfo)var3).method_3109();
            }
        }
        return (FlowInfo)var3;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        int var5 = this.expressions == null ? 0 : this.expressions.length;
        var2.method_2188(var5);
        var2.newArray(this.binding);
        if (this.expressions != null) {
            int var6 = this.binding.dimensions > 1 ? -1 : this.binding.leafComponentType.id;
            for (int var7 = 0; var7 < var5; ++var7) {
                Expression var8;
                if ((var8 = this.expressions[var7]).constant != Constant.NotAConstant) {
                    switch (var6) {
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                        case 10:
                            if (var8.constant.longValue() != 0L) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.generateCode(var1, var2, true);
                                var2.arrayAtPut(var6, false);
                            }
                            break;
                        case 5:
                            if (var8.constant.booleanValue()) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.generateCode(var1, var2, true);
                                var2.arrayAtPut(var6, false);
                            }
                            break;
                        case 6:
                        default:
                            if (!(var8 instanceof NullLiteral)) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.generateCode(var1, var2, true);
                                var2.arrayAtPut(var6, false);
                            }
                            break;
                        case 8:
                        case 9:
                            double var9 = var8.constant.doubleValue();
                            if (var9 == -0.0D || var9 != 0.0D) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.generateCode(var1, var2, true);
                                var2.arrayAtPut(var6, false);
                            }
                    }
                } else if (!(var8 instanceof NullLiteral)) {
                    var2.method_2141();
                    var2.method_2188(var7);
                    var8.generateCode(var1, var2, true);
                    var2.arrayAtPut(var6, false);
                }
            }
        }
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            var2.method_2352();
        }
        var2.method_2360(var4, this.field_444);
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append('{');
        if (this.expressions != null) {
            int var3 = 20;
            for (int var4 = 0; var4 < this.expressions.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.expressions[var4].printExpression(0, var2);
                --var3;
                if (var3 == 0) {
                    var2.append('\n');
                    method_759(var1 + 1, var2);
                    var3 = 20;
                }
            }
        }
        return var2.append('}');
    }

    public TypeBinding resolveTypeExpecting(BlockScope var1, TypeBinding var2) {
        this.constant = Constant.NotAConstant;
        int var4;
        if (var2 instanceof ArrayBinding) {
            TypeBinding var8;
            if ((this.field_446 & 1) == 0) {
                var8 = var2.method_173();
                if (!var8.method_167()) {
                    var1.problemReporter().method_1571(var8, this);
                }
            }
            this.resolvedType = this.binding = (ArrayBinding)var2;
            if (this.expressions == null) {
                return this.binding;
            } else {
                var8 = this.binding.method_187();
                var4 = 0;
                for (int var9 = this.expressions.length; var4 < var9; ++var4) {
                    Expression var12 = this.expressions[var4];
                    var12.setExpectedType(var8);
                    TypeBinding var11 = var12 instanceof ArrayInitializer ? var12.resolveTypeExpecting(var1, var8) : var12.resolveType(var1);
                    if (var11 != null) {
                        if (var8 != var11) {
                            var1.compilationUnitScope().recordTypeConversion(var8, var11);
                        }
                        if (!var12.isConstantValueOfTypeAssignableToType(var11, var8) && (!var8.method_148() || !BaseTypeBinding.method_185(var8.id, var11.id)) && !var11.isCompatibleWith(var8)) {
                            if (!var1.isBoxingCompatibleWith(var11, var8) && (!var11.method_148() || var1.compilerOptions().field_1928 < 3211264L || var8.method_148() || !var12.isConstantValueOfTypeAssignableToType(var11, var1.environment().method_486(var8)))) {
                                var1.problemReporter().typeMismatchError(var11, var8, var12, (ASTNode)null);
                            } else {
                                var12.computeConversion(var1, var8, var11);
                            }
                        } else {
                            var12.computeConversion(var1, var8, var11);
                        }
                    }
                }
                return this.binding;
            }
        } else {
            Object var3 = null;
            var4 = 1;
            if (this.expressions == null) {
                var3 = var1.method_609();
            } else {
                Expression var5;
                for (var5 = this.expressions[0]; var5 != null && var5 instanceof ArrayInitializer; var5 = ((ArrayInitializer)var5).expressions[0]) {
                    ++var4;
                    Expression[] var6 = ((ArrayInitializer)var5).expressions;
                    if (var6 == null) {
                        var3 = var1.method_609();
                        var5 = null;
                        break;
                    }
                }
                if (var5 != null) {
                    var3 = var5.resolveType(var1);
                }
                int var10 = 1;
                for (int var7 = this.expressions.length; var10 < var7; ++var10) {
                    var5 = this.expressions[var10];
                    if (var5 != null) {
                        var5.resolveType(var1);
                    }
                }
            }
            if (var3 != null) {
                this.resolvedType = var1.createArrayType((TypeBinding)var3, var4);
                if (var2 != null) {
                    var1.problemReporter().typeMismatchError(this.resolvedType, var2, this, (ASTNode)null);
                }
            }
            return null;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.expressions != null) {
            int var3 = this.expressions.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.expressions[var4].traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
