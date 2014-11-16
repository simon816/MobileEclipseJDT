package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class LocalDeclaration extends AbstractVariableDeclaration {

    public LocalVariableBinding binding;

    public LocalDeclaration(char[] var1, int var2, int var3) {
        this.name = var1;
        this.field_444 = var2;
        this.field_445 = var3;
        this.field_651 = var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if ((var3.tagBits & 1) == 0) {
            this.field_446 |= 1073741824;
        }
        if (this.initialization == null) {
            return var3;
        } else {
            int var4 = this.initialization.nullStatus(var3);
            UnconditionalFlowInfo var5 = this.initialization.analyseCode(var1, var2, var3).method_3109();
            if (!var5.method_3083(this.binding)) {
                this.field_446 |= 8;
            } else {
                this.field_446 &= -9;
            }
            var5.method_3099(this.binding);
            if ((this.binding.type.tagBits & 2L) == 0L) {
                switch (var4) {
                    case -1:
                        var5.method_3097(this.binding);
                        break;
                    case 1:
                        var5.method_3098(this.binding);
                        break;
                    default:
                        var5.method_3100(this.binding);
                }
            }
            return var5;
        }
    }

    public void checkModifiers() {
        if ((this.field_656 & '\uffff' & -17) != 0) {
            this.field_656 = this.field_656 & -4194305 | 8388608;
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if (this.binding.field_306 != -1) {
            var2.method_2090(this.binding);
        }
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.initialization != null) {
                if (this.binding.field_306 < 0) {
                    if (this.initialization.constant == Constant.NotAConstant) {
                        this.initialization.generateCode(var1, var2, false);
                    }
                } else {
                    this.initialization.generateCode(var1, var2, true);
                    if (this.binding.type.method_147() && (this.initialization.resolvedType == TypeBinding.field_187 || this.initialization instanceof CastExpression && ((CastExpression)this.initialization).innermostCastedExpression().resolvedType == TypeBinding.field_187)) {
                        var2.method_2113(this.binding.type);
                    }
                    var2.store(this.binding, false);
                    if ((this.field_446 & 8) != 0) {
                        this.binding.method_415(var2.field_1208);
                    }
                }
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public int getKind() {
        return 4;
    }

    public void resolve(BlockScope var1) {
        TypeBinding var2 = this.type.resolveType(var1, true);
        this.checkModifiers();
        if (var2 != null) {
            if (var2 == TypeBinding.field_188) {
                var1.problemReporter().method_1821(this);
                return;
            }
            if (var2.method_147() && ((ArrayBinding)var2).leafComponentType == TypeBinding.field_188) {
                var1.problemReporter().method_1822(this);
                return;
            }
        }
        Binding var3 = var1.getBinding(this.name, 3, this, false);
        if (var3 != null && var3.isValidBinding()) {
            if (var3 instanceof LocalVariableBinding && this.field_654 == 0) {
                var1.problemReporter().method_1745(this);
            } else {
                var1.problemReporter().localVariableHiding(this, var3, false);
            }
        }
        if ((this.field_656 & 16) != 0 && this.initialization == null) {
            this.field_656 |= 67108864;
        }
        LocalVariableBinding var10001 = new LocalVariableBinding(this, var2, this.field_656, false);
        this.binding = var10001;
        var1.addLocalVariable(this.binding);
        this.binding.setConstant(Constant.NotAConstant);
        if (var2 == null) {
            if (this.initialization != null) {
                this.initialization.resolveType(var1);
            }
        } else {
            if (this.initialization != null) {
                TypeBinding var4;
                if (this.initialization instanceof ArrayInitializer) {
                    var4 = this.initialization.resolveTypeExpecting(var1, var2);
                    if (var4 != null) {
                        ((ArrayInitializer)this.initialization).binding = (ArrayBinding)var4;
                        this.initialization.computeConversion(var1, var2, var4);
                    }
                } else {
                    this.initialization.setExpectedType(var2);
                    var4 = this.initialization.resolveType(var1);
                    if (var4 != null) {
                        if (var2 != var4) {
                            var1.compilationUnitScope().recordTypeConversion(var2, var4);
                        }
                        if (!this.initialization.isConstantValueOfTypeAssignableToType(var4, var2) && (!var2.method_148() || !BaseTypeBinding.method_185(var2.id, var4.id)) && !var4.isCompatibleWith(var2)) {
                            if (!var1.isBoxingCompatibleWith(var4, var2) && (!var4.method_148() || var1.compilerOptions().field_1928 < 3211264L || var2.method_148() || !this.initialization.isConstantValueOfTypeAssignableToType(var4, var1.environment().method_486(var2)))) {
                                if ((var2.tagBits & 128L) == 0L) {
                                    var1.problemReporter().typeMismatchError(var4, var2, this.initialization, (ASTNode)null);
                                }
                            } else {
                                this.initialization.computeConversion(var1, var2, var4);
                                if (this.initialization instanceof CastExpression && (this.initialization.field_446 & 16384) == 0) {
                                    CastExpression.checkNeedForAssignedCast(var1, var2, (CastExpression)this.initialization);
                                }
                            }
                        } else {
                            this.initialization.computeConversion(var1, var2, var4);
                            if (var4.method_174(var2)) {
                                var1.problemReporter().method_1806(this.initialization, var4, var2);
                            }
                            if (this.initialization instanceof CastExpression && (this.initialization.field_446 & 16384) == 0) {
                                CastExpression.checkNeedForAssignedCast(var1, var2, (CastExpression)this.initialization);
                            }
                        }
                    }
                }
                if (this.binding == Assignment.method_944(this.initialization)) {
                    var1.problemReporter().assignmentHasNoEffect(this, this.name);
                }
                this.binding.setConstant(this.binding.method_409() ? this.initialization.constant.castTo((var2.id << 4) + this.initialization.constant.typeID()) : Constant.NotAConstant);
            }
            method_761(var1, this.annotations, this.binding);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.annotations != null) {
                int var3 = this.annotations.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.annotations[var4].traverse(var1, var2);
                }
            }
            this.type.traverse(var1, var2);
            if (this.initialization != null) {
                this.initialization.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
