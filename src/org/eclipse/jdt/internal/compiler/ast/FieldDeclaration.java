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
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Util;

public class FieldDeclaration extends AbstractVariableDeclaration {

    public FieldBinding binding;

    public int field_662;

    public int field_663;

    public FieldDeclaration() {
    }

    public FieldDeclaration(char[] var1, int var2, int var3) {
        this.name = var1;
        this.field_444 = var2;
        this.field_445 = var3;
    }

    public FlowInfo analyseCode(MethodScope var1, FlowContext var2, FlowInfo var3) {
        if (this.binding != null && !this.binding.method_433() && (this.binding.method_428() || this.binding.declaringClass != null && this.binding.declaringClass.method_158()) && !var1.referenceCompilationUnit().compilationResult.field_1692) {
            var1.problemReporter().method_1813(this);
        }
        if (this.binding != null && this.binding.isValidBinding() && this.binding.method_431() && this.binding.constant() == Constant.NotAConstant && this.binding.declaringClass.method_160() && !this.binding.declaringClass.method_226()) {
            var1.problemReporter().method_1784((SourceTypeBinding)this.binding.declaringClass, this);
        }
        if (this.initialization != null) {
            var3 = this.initialization.analyseCode(var1, var2, (FlowInfo)var3).method_3109();
            ((FlowInfo)var3).markAsDefinitelyAssigned(this.binding);
        }
        return (FlowInfo)var3;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            boolean var4;
            if (this.initialization != null && (!(var4 = this.binding.method_431()) || this.binding.constant() == Constant.NotAConstant)) {
                if (!var4) {
                    var2.method_2093();
                }
                this.initialization.generateCode(var1, var2, true);
                if (var4) {
                    var2.method_2357(this.binding);
                } else {
                    var2.method_2356(this.binding);
                }
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public int getKind() {
        return this.type == null ? 3 : 1;
    }

    public boolean isStatic() {
        return this.binding != null ? this.binding.method_431() : (this.field_656 & 8) != 0;
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        return super.printStatement(var1, var2);
    }

    public void resolve(MethodScope var1) {
        if ((this.field_446 & 16) == 0) {
            if (this.binding != null && this.binding.isValidBinding()) {
                this.field_446 |= 16;
                ClassScope var2 = var1.method_582();
                if (var2 != null) {
                    label338: {
                        SourceTypeBinding var3 = var2.enclosingSourceType();
                        if (var3.superclass != null) {
                            FieldBinding var4 = var2.findField(var3.superclass, this.name, this, false);
                            if (var4 != null && var4.isValidBinding()) {
                                label334: {
                                    if (var4 instanceof FieldBinding) {
                                        FieldBinding var5 = (FieldBinding)var4;
                                        if (var5.original() == this.binding || !var5.canBeSeenBy(var3, this, var1)) {
                                            break label334;
                                        }
                                    }
                                    var1.problemReporter().fieldHiding(this, var4);
                                    break label338;
                                }
                            }
                        }
                        Scope var13 = var2.parent;
                        if (var13.kind != 4) {
                            Binding var15 = var13.getBinding(this.name, 3, this, false);
                            if (var15 != null && var15.isValidBinding() && var15 != this.binding) {
                                label323: {
                                    if (var15 instanceof FieldBinding) {
                                        FieldBinding var6 = (FieldBinding)var15;
                                        if (var6.original() == this.binding || !var6.method_431() && var3.method_226()) {
                                            break label323;
                                        }
                                    }
                                    var1.problemReporter().fieldHiding(this, var15);
                                }
                            }
                        }
                    }
                }
                if (this.type != null) {
                    this.type.resolvedType = this.binding.type;
                }
                FieldBinding var12 = var1.initializedField;
                int var14 = var1.field_407;
                try {
                    var1.initializedField = this.binding;
                    var1.field_407 = this.binding.field_304;
                    method_761(var1, this.annotations, this.binding);
                    if ((this.binding.getAnnotationTagBits() & 70368744177664L) == 0L && (this.binding.field_300 & 1048576) != 0 && var1.compilerOptions().field_1928 >= 3211264L) {
                        var1.problemReporter().method_1675(this);
                    }
                    if (this.initialization == null) {
                        this.binding.setConstant(Constant.NotAConstant);
                    } else {
                        this.binding.setConstant(Constant.NotAConstant);
                        TypeBinding var17 = this.binding.type;
                        this.initialization.setExpectedType(var17);
                        TypeBinding var18;
                        if (this.initialization instanceof ArrayInitializer) {
                            if ((var18 = this.initialization.resolveTypeExpecting(var1, var17)) != null) {
                                ((ArrayInitializer)this.initialization).binding = (ArrayBinding)var18;
                                this.initialization.computeConversion(var1, var17, var18);
                            }
                        } else if ((var18 = this.initialization.resolveType(var1)) != null) {
                            if (var17 != var18) {
                                var1.compilationUnitScope().recordTypeConversion(var17, var18);
                            }
                            if (!this.initialization.isConstantValueOfTypeAssignableToType(var18, var17) && (!var17.method_148() || !BaseTypeBinding.method_185(var17.id, var18.id)) && !var18.isCompatibleWith(var17)) {
                                if (!var1.isBoxingCompatibleWith(var18, var17) && (!var18.method_148() || var1.compilerOptions().field_1928 < 3211264L || var17.method_148() || !this.initialization.isConstantValueOfTypeAssignableToType(var18, var1.environment().method_486(var17)))) {
                                    if ((var17.tagBits & 128L) == 0L) {
                                        var1.problemReporter().typeMismatchError(var18, var17, this.initialization, (ASTNode)null);
                                    }
                                } else {
                                    this.initialization.computeConversion(var1, var17, var18);
                                    if (this.initialization instanceof CastExpression && (this.initialization.field_446 & 16384) == 0) {
                                        CastExpression.checkNeedForAssignedCast(var1, var17, (CastExpression)this.initialization);
                                    }
                                }
                            } else {
                                this.initialization.computeConversion(var1, var17, var18);
                                if (var18.method_174(var17)) {
                                    var1.problemReporter().method_1806(this.initialization, var18, var17);
                                }
                                if (this.initialization instanceof CastExpression && (this.initialization.field_446 & 16384) == 0) {
                                    CastExpression.checkNeedForAssignedCast(var1, var17, (CastExpression)this.initialization);
                                }
                            }
                            if (this.binding.method_409()) {
                                this.binding.setConstant(this.initialization.constant.castTo((this.binding.type.id << 4) + this.initialization.constant.typeID()));
                            }
                        } else {
                            this.binding.setConstant(Constant.NotAConstant);
                        }
                        if (this.binding == Assignment.method_944(this.initialization)) {
                            var1.problemReporter().assignmentHasNoEffect(this, this.name);
                        }
                    }
                    if (this.binding != null && this.binding.declaringClass != null && !this.binding.declaringClass.method_158()) {
                        int var16 = this.binding.field_300 & 7;
                        ProblemReporter var19 = var1.problemReporter();
                        int var7 = var19.computeSeverity(-1610612250);
                        if (var7 != -1) {
                            if (var2 != null) {
                                var16 = Util.computeOuterMostVisibility(var2.referenceType(), var16);
                            }
                            int var8 = this.binding.field_300 & -8 | var16;
                        }
                    }
                } finally {
                    var1.initializedField = var12;
                    var1.field_407 = var14;
                    if (this.binding.constant() == null) {
                        this.binding.setConstant(Constant.NotAConstant);
                    }
                }
            }
        }
    }

    public void traverse(ASTVisitor var1, MethodScope var2) {
        if (var1.visit(this, var2)) {
            if (this.annotations != null) {
                int var3 = this.annotations.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.annotations[var4].traverse(var1, var2);
                }
            }
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
            if (this.initialization != null) {
                this.initialization.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
