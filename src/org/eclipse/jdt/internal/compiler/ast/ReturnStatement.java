package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;
import org.eclipse.jdt.internal.compiler.flow.InitializationFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class ReturnStatement extends Statement {

    public Expression expression;

    public SubRoutineStatement[] subroutines;

    public LocalVariableBinding saveValueVariable;

    public int initStateIndex;

    public ReturnStatement(Expression var1, int var2, int var3) {
        this.initStateIndex = -1;
        this.field_444 = var2;
        this.field_445 = var3;
        this.expression = var1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.expression != null) {
            var3 = this.expression.analyseCode(var1, var2, var3);
        }
        this.initStateIndex = var1.method_635().recordInitializationStates(var3);
        FlowContext var4 = var2;
        int var5 = 0;
        boolean var6 = false;
        boolean var7 = this.needValueStore();
        do {
            SubRoutineStatement var8;
            if ((var8 = var4.subroutine()) != null) {
                if (this.subroutines == null) {
                    this.subroutines = new SubRoutineStatement[5];
                }
                if (var5 == this.subroutines.length) {
                    System.arraycopy(this.subroutines, 0, this.subroutines = new SubRoutineStatement[var5 * 2], 0, var5);
                }
                this.subroutines[var5++] = var8;
                if (var8.isSubRoutineEscaping()) {
                    var6 = false;
                    this.field_446 |= 536870912;
                    break;
                }
            }
            var4.recordReturnFrom(var3.method_3109());
            if (var4 instanceof InsideSubRoutineFlowContext) {
                ASTNode var9 = var4.associatedNode;
                if (var9 instanceof SynchronizedStatement) {
                    this.field_446 |= 1073741824;
                } else if (var9 instanceof TryStatement) {
                    TryStatement var10 = (TryStatement)var9;
                    var3.method_3071(var10.subRoutineInits);
                    if (var7) {
                        if (this.saveValueVariable == null) {
                            this.prepareSaveValueLocation(var10);
                        }
                        var6 = true;
                    }
                }
            } else if (var4 instanceof InitializationFlowContext) {
                var1.problemReporter().method_1502(this);
                return FlowInfo.DEAD_END;
            }
        } while ((var4 = var4.parent) != null);
        if (this.subroutines != null && var5 != this.subroutines.length) {
            System.arraycopy(this.subroutines, 0, this.subroutines = new SubRoutineStatement[var5], 0, var5);
        }
        if (var6) {
            if (this.saveValueVariable != null) {
                this.saveValueVariable.field_307 = 1;
            }
        } else {
            this.saveValueVariable = null;
            if ((this.field_446 & 1073741824) == 0 && this.expression != null && this.expression.resolvedType == TypeBinding.field_186) {
                this.expression.field_446 |= 16;
            }
        }
        return FlowInfo.DEAD_END;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            boolean var4 = false;
            if (this.needValueStore()) {
                var4 = true;
                this.expression.generateCode(var1, var2, this.needValue());
                this.method_883(var2);
            }
            if (this.subroutines != null) {
                Object var5 = this.expression == null ? TypeBinding.field_188 : this.expression.reusableJSRTarget();
                int var6 = 0;
                for (int var7 = this.subroutines.length; var6 < var7; ++var6) {
                    SubRoutineStatement var8 = this.subroutines[var6];
                    boolean var9 = var8.generateSubRoutineInvocation(var1, var2, var5, this.initStateIndex, this.saveValueVariable);
                    if (var9) {
                        var2.method_2360(var3, this.field_444);
                        SubRoutineStatement.reenterAllExceptionHandlers(this.subroutines, var6, var2);
                        return;
                    }
                }
            }
            if (this.saveValueVariable != null) {
                var2.addVariable(this.saveValueVariable);
                var2.load(this.saveValueVariable);
            }
            if (this.expression != null && !var4) {
                this.expression.generateCode(var1, var2, true);
                this.method_883(var2);
            }
            this.method_882(var2);
            if (this.saveValueVariable != null) {
                var2.method_2365(this.saveValueVariable);
            }
            if (this.initStateIndex != -1) {
                var2.method_2363(var1, this.initStateIndex);
                var2.method_2088(var1, this.initStateIndex);
            }
            var2.method_2360(var3, this.field_444);
            SubRoutineStatement.reenterAllExceptionHandlers(this.subroutines, -1, var2);
        }
    }

    public void method_882(CodeStream var1) {
        var1.generateReturnBytecode(this.expression);
    }

    public void method_883(CodeStream var1) {
        if (this.saveValueVariable != null) {
            var1.store(this.saveValueVariable, false);
        }
    }

    private boolean needValueStore() {
        return this.expression != null && (this.expression.constant == Constant.NotAConstant || (this.expression.field_674 & 512) != 0) && !(this.expression instanceof NullLiteral);
    }

    public boolean needValue() {
        return this.saveValueVariable != null || (this.field_446 & 1073741824) != 0 || (this.field_446 & 536870912) == 0;
    }

    public void prepareSaveValueLocation(TryStatement var1) {
        this.saveValueVariable = var1.field_630;
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("return ");
        if (this.expression != null) {
            this.expression.printExpression(0, var2);
        }
        return var2.append(';');
    }

    public void resolve(BlockScope var1) {
        MethodScope var2 = var1.method_635();
        Object var10000;
        if (var2.referenceContext instanceof AbstractMethodDeclaration) {
            MethodBinding var3 = ((AbstractMethodDeclaration)var2.referenceContext).binding;
            var10000 = ((AbstractMethodDeclaration)var2.referenceContext).binding == null ? null : var3.returnType;
        } else {
            var10000 = TypeBinding.field_188;
        }
        Object var4 = var10000;
        TypeBinding var5;
        if (var4 == TypeBinding.field_188) {
            if (this.expression != null) {
                if ((var5 = this.expression.resolveType(var1)) != null) {
                    var1.problemReporter().attemptToReturnNonVoidExpression(this, var5);
                }
            }
        } else if (this.expression == null) {
            if (var4 != null) {
                var1.problemReporter().method_1754((TypeBinding)var4, this);
            }
        } else {
            this.expression.setExpectedType((TypeBinding)var4);
            if ((var5 = this.expression.resolveType(var1)) != null) {
                if (var5 == TypeBinding.field_188) {
                    var1.problemReporter().attemptToReturnVoidValue(this);
                } else if (var4 != null) {
                    if (var4 != var5) {
                        var1.compilationUnitScope().recordTypeConversion((TypeBinding)var4, var5);
                    }
                    if (!this.expression.isConstantValueOfTypeAssignableToType(var5, (TypeBinding)var4) && !var5.isCompatibleWith((TypeBinding)var4)) {
                        if (!var1.isBoxingCompatibleWith(var5, (TypeBinding)var4) && (!var5.method_148() || var1.compilerOptions().field_1928 < 3211264L || ((TypeBinding)var4).method_148() || !this.expression.isConstantValueOfTypeAssignableToType(var5, var1.environment().method_486((TypeBinding)var4)))) {
                            if ((((TypeBinding)var4).tagBits & 128L) == 0L) {
                                var1.problemReporter().typeMismatchError(var5, (TypeBinding)var4, this.expression, (ASTNode)null);
                            }
                        } else {
                            this.expression.computeConversion(var1, (TypeBinding)var4, var5);
                            if (this.expression instanceof CastExpression && (this.expression.field_446 & 16416) == 0) {
                                CastExpression.checkNeedForAssignedCast(var1, (TypeBinding)var4, (CastExpression)this.expression);
                            }
                        }
                    } else {
                        this.expression.computeConversion(var1, (TypeBinding)var4, var5);
                        if (var5.method_174((TypeBinding)var4)) {
                            var1.problemReporter().method_1806(this.expression, var5, (TypeBinding)var4);
                        }
                        if (this.expression instanceof CastExpression && (this.expression.field_446 & 16416) == 0) {
                            CastExpression.checkNeedForAssignedCast(var1, (TypeBinding)var4, (CastExpression)this.expression);
                        }
                    }
                }
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.expression != null) {
            this.expression.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
