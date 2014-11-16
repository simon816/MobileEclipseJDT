package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class QualifiedAllocationExpression extends AllocationExpression {

    public Expression enclosingInstance;

    public TypeDeclaration anonymousType;

    public QualifiedAllocationExpression() {
    }

    public QualifiedAllocationExpression(TypeDeclaration var1) {
        this.anonymousType = var1;
        var1.allocation = this;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.enclosingInstance != null) {
            var3 = this.enclosingInstance.analyseCode(var1, var2, var3);
        }
        this.checkCapturedLocalInitializationIfNecessary((ReferenceBinding)(this.anonymousType == null ? this.binding.declaringClass.erasure() : this.binding.declaringClass.superclass().erasure()), var1, var3);
        if (this.arguments != null) {
            int var4 = 0;
            for (int var5 = this.arguments.length; var4 < var5; ++var4) {
                var3 = this.arguments[var4].analyseCode(var1, var2, var3);
            }
        }
        if (this.anonymousType != null) {
            var3 = this.anonymousType.analyseCode(var1, var2, var3);
        }
        ReferenceBinding[] var6 = this.binding.thrownExceptions;
        if (this.binding.thrownExceptions.length != 0) {
            var2.checkExceptionHandlers(var6, this, var3.method_3107(), var1);
        }
        this.manageEnclosingInstanceAccessIfNecessary(var1, var3);
        this.method_953(var1, var3);
        return var3;
    }

    public Expression enclosingInstance() {
        return this.enclosingInstance;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        ReferenceBinding var5 = this.field_694.declaringClass;
        var2.method_2343(var5);
        boolean var6 = (this.field_674 & 1024) != 0;
        if (var3 || var6) {
            var2.method_2141();
        }
        if (this.type != null) {
            var2.method_2360(var4, this.type.field_444);
        } else {
            var2.ldc(String.valueOf(this.enumConstant.name));
            var2.method_2188(this.enumConstant.binding.field_304);
        }
        if (var5.method_160()) {
            var2.generateSyntheticEnclosingInstanceValues(var1, var5, this.enclosingInstance(), this);
        }
        this.generateArguments(this.binding, this.arguments, var1, var2);
        if (var5.method_160()) {
            var2.generateSyntheticOuterArgumentValues(var1, var5, this);
        }
        if (this.syntheticAccessor == null) {
            var2.method_2272(this.field_694);
        } else {
            int var7 = 0;
            for (int var8 = this.syntheticAccessor.parameters.length - this.field_694.parameters.length; var7 < var8; ++var7) {
                var2.method_2087();
            }
            var2.method_2272(this.syntheticAccessor);
        }
        if (var3) {
            var2.method_2182(this.field_674);
        } else if (var6) {
            var2.method_2182(this.field_674);
            switch (this.postConversionType(var1).id) {
                case 7:
                case 8:
                    var2.method_2353();
                    break;
                default:
                    var2.method_2352();
            }
        }
        var2.method_2360(var4, this.field_444);
        if (this.anonymousType != null) {
            this.anonymousType.generateCode(var1, var2);
        }
    }

    public boolean isSuperAccess() {
        return this.anonymousType != null;
    }

    public void manageEnclosingInstanceAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            ReferenceBinding var3 = (ReferenceBinding)this.binding.declaringClass.erasure();
            if (var3.method_160() && var1.enclosingSourceType().method_158()) {
                if (var3.method_158()) {
                    ((LocalTypeBinding)var3).addInnerEmulationDependent(var1, this.enclosingInstance != null);
                } else {
                    var1.propagateInnerEmulation(var3, this.enclosingInstance != null);
                }
            }
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        if (this.enclosingInstance != null) {
            this.enclosingInstance.printExpression(0, var2).append('.');
        }
        super.printExpression(0, var2);
        if (this.anonymousType != null) {
            this.anonymousType.print(var1, var2);
        }
        return var2;
    }

    public TypeBinding resolveType(BlockScope var1) {
        if (this.anonymousType == null && this.enclosingInstance == null) {
            return super.resolveType(var1);
        } else {
            this.constant = Constant.NotAConstant;
            TypeBinding var2 = null;
            Object var3 = null;
            boolean var4 = false;
            boolean var5 = false;
            boolean var6 = false;
            int var9;
            if (this.enclosingInstance != null) {
                if (this.enclosingInstance instanceof CastExpression) {
                    this.enclosingInstance.field_446 |= 32;
                    var5 = true;
                }
                if ((var2 = this.enclosingInstance.resolveType(var1)) == null) {
                    var4 = true;
                } else if (!var2.method_148() && !var2.method_147()) {
                    if (this.type instanceof QualifiedTypeReference) {
                        var1.problemReporter().illegalUsageOfQualifiedTypeReference((QualifiedTypeReference)this.type);
                        var4 = true;
                    } else {
                        var3 = ((SingleTypeReference)this.type).resolveTypeEnclosing(var1, (ReferenceBinding)var2);
                        if (var3 != null && var5) {
                            CastExpression.checkNeedForEnclosingInstanceCast(var1, this.enclosingInstance, var2, (TypeBinding)var3);
                        }
                    }
                } else {
                    var1.problemReporter().method_1595(var2, this.enclosingInstance);
                    var4 = true;
                }
            } else if (this.type == null) {
                var3 = var1.enclosingSourceType();
            } else {
                var3 = this.type.resolveType(var1, true);
                if (var3 != null && ((TypeBinding)var3).isValidBinding() && this.type instanceof ParameterizedQualifiedTypeReference) {
                    ReferenceBinding var7 = (ReferenceBinding)var3;
                    label287:
                    while ((var7.modifiers & 8) == 0 && !var7.method_166()) {
                        if ((var7 = var7.enclosingType()) == null) {
                            ParameterizedQualifiedTypeReference var8 = (ParameterizedQualifiedTypeReference)this.type;
                            var9 = var8.typeArguments.length - 2;
                            while (true) {
                                if (var9 < 0) {
                                    break label287;
                                }
                                if (var8.typeArguments[var9] != null) {
                                    var1.problemReporter().method_1596(this.type, (TypeBinding)var3);
                                    break label287;
                                }
                                --var9;
                            }
                        }
                    }
                }
            }
            if (var3 == null || !((TypeBinding)var3).isValidBinding()) {
                var4 = true;
            }
            if (this.typeArguments != null) {
                int var14 = this.typeArguments.length;
                boolean var15 = var1.compilerOptions().field_1928 < 3211264L;
                this.genericTypeArguments = new TypeBinding[var14];
                for (var9 = 0; var9 < var14; ++var9) {
                    TypeReference var10 = this.typeArguments[var9];
                    if ((this.genericTypeArguments[var9] = var10.resolveType(var1, true)) == null) {
                        var15 = true;
                    }
                    if (var15 && var10 instanceof Wildcard) {
                        var1.problemReporter().method_1599(var10);
                    }
                }
                if (var15) {
                    if (this.arguments != null) {
                        var9 = 0;
                        for (int var20 = this.arguments.length; var9 < var20; ++var9) {
                            this.arguments[var9].resolveType(var1);
                        }
                    }
                    return null;
                }
            }
            TypeBinding[] var13 = Binding.field_150;
            if (this.arguments != null) {
                int var16 = this.arguments.length;
                var13 = new TypeBinding[var16];
                for (var9 = 0; var9 < var16; ++var9) {
                    Expression var22 = this.arguments[var9];
                    if (var22 instanceof CastExpression) {
                        var22.field_446 |= 32;
                        var6 = true;
                    }
                    if ((var13[var9] = var22.resolveType(var1)) == null) {
                        var4 = true;
                    }
                }
            }
            ReferenceBinding var17;
            if (!var4) {
                ReferenceBinding var19;
                if (this.anonymousType == null) {
                    if (!((TypeBinding)var3).method_129()) {
                        var1.problemReporter().method_1498(this.type, (TypeBinding)var3);
                        return (TypeBinding)(this.resolvedType = (TypeBinding)var3);
                    } else {
                        var17 = (ReferenceBinding)var3;
                        if ((this.binding = var1.method_599(var17, var13, this)).isValidBinding()) {
                            if (this.isMethodUseDeprecated(this.binding, var1, true)) {
                                var1.problemReporter().method_1515(this.binding, this);
                            }
                            method_749(var1, (Expression)null, var17, this.binding, this.arguments, var13, var6, this);
                            if (this.typeArguments != null && this.binding.original().typeVariables == Binding.NO_TYPE_VARIABLES) {
                                var1.problemReporter().unnecessaryTypeArgumentsForMethodInvocation(this.binding, this.genericTypeArguments, this.typeArguments);
                            }
                            if ((this.binding.tagBits & 128L) != 0L) {
                                var1.problemReporter().method_1682(this, this.binding);
                            }
                            var19 = this.binding.declaringClass.enclosingType();
                            if (var19 != var2) {
                                var1.compilationUnitScope().recordTypeConversion(var19, var2);
                            }
                            if (!var2.isCompatibleWith(var19) && !var1.isBoxingCompatibleWith(var2, var19)) {
                                var1.problemReporter().typeMismatchError(var2, var19, this.enclosingInstance, (ASTNode)null);
                                return (TypeBinding)(this.resolvedType = (TypeBinding)var3);
                            } else {
                                this.enclosingInstance.computeConversion(var1, var19, var2);
                                return (TypeBinding)(this.resolvedType = (TypeBinding)var3);
                            }
                        } else {
                            if (this.binding.declaringClass == null) {
                                this.binding.declaringClass = var17;
                            }
                            if (this.type != null && !this.type.resolvedType.isValidBinding()) {
                                return null;
                            } else {
                                var1.problemReporter().invalidConstructor(this, this.binding);
                                return (TypeBinding)(this.resolvedType = (TypeBinding)var3);
                            }
                        }
                    }
                } else {
                    var17 = (ReferenceBinding)var3;
                    if (var17.method_169()) {
                        ProblemReferenceBinding var10000 = new ProblemReferenceBinding(new char[][] {var17.method_179()}, var17, 9);
                        ProblemReferenceBinding var21 = var10000;
                        var1.problemReporter().method_1639(this, var21);
                        return null;
                    } else if (this.type != null && var17.method_153()) {
                        var1.problemReporter().method_1498(this.type, var17);
                        return this.resolvedType = var17;
                    } else {
                        var19 = var17.method_157() ? var1.method_609() : var17;
                        var1.addAnonymousType(this.anonymousType, var17);
                        this.anonymousType.resolve(var1);
                        this.resolvedType = this.anonymousType.binding;
                        if ((this.resolvedType.tagBits & 131072L) != 0L) {
                            return null;
                        } else {
                            MethodBinding var18 = var1.method_599(var19, var13, this);
                            if (!var18.isValidBinding()) {
                                if (var18.declaringClass == null) {
                                    var18.declaringClass = var19;
                                }
                                if (this.type != null && !this.type.resolvedType.isValidBinding()) {
                                    return null;
                                } else {
                                    var1.problemReporter().invalidConstructor(this, var18);
                                    return this.resolvedType;
                                }
                            } else {
                                if ((var18.tagBits & 128L) != 0L) {
                                    var1.problemReporter().method_1682(this, var18);
                                }
                                if (this.enclosingInstance != null) {
                                    ReferenceBinding var24 = var18.declaringClass.enclosingType();
                                    if (var24 == null) {
                                        var1.problemReporter().unnecessaryEnclosingInstanceSpecification(this.enclosingInstance, var17);
                                        return this.resolvedType;
                                    }
                                    if (!var2.isCompatibleWith(var24) && !var1.isBoxingCompatibleWith(var2, var24)) {
                                        var1.problemReporter().typeMismatchError(var2, var24, this.enclosingInstance, (ASTNode)null);
                                        return this.resolvedType;
                                    }
                                    this.enclosingInstance.computeConversion(var1, var24, var2);
                                }
                                if (this.arguments != null) {
                                    method_749(var1, (Expression)null, var19, var18, this.arguments, var13, var6, this);
                                }
                                if (this.typeArguments != null && var18.original().typeVariables == Binding.NO_TYPE_VARIABLES) {
                                    var1.problemReporter().unnecessaryTypeArgumentsForMethodInvocation(var18, this.genericTypeArguments, this.typeArguments);
                                }
                                this.binding = this.anonymousType.method_852(var18);
                                return this.resolvedType;
                            }
                        }
                    }
                }
            } else {
                if (var3 instanceof ReferenceBinding) {
                    var17 = (ReferenceBinding)var3;
                    if (!((TypeBinding)var3).isValidBinding()) {
                        return null;
                    }
                    var9 = this.arguments == null ? 0 : this.arguments.length;
                    TypeBinding[] var23 = new TypeBinding[var9];
                    int var11 = var9;
                    while (true) {
                        --var11;
                        if (var11 < 0) {
                            this.binding = var1.method_592(var17, TypeConstants.field_135, var23, this);
                            if (this.binding != null && !this.binding.isValidBinding()) {
                                Object var25 = ((ProblemMethodBinding)this.binding).closestMatch;
                                if (var25 != null) {
                                    if (((MethodBinding)var25).original().typeVariables != Binding.NO_TYPE_VARIABLES) {
                                        var25 = var1.environment().createParameterizedGenericMethod(((MethodBinding)var25).original(), (RawTypeBinding)null);
                                    }
                                    this.binding = (MethodBinding)var25;
                                    MethodBinding var12 = ((MethodBinding)var25).original();
                                    if ((var12.method_367() || var12.declaringClass.method_158()) && !var1.isDefinedInMethod(var12)) {
                                        var12.modifiers |= 134217728;
                                    }
                                }
                            }
                            if (this.anonymousType != null) {
                                var1.addAnonymousType(this.anonymousType, var17);
                                this.anonymousType.resolve(var1);
                                return this.resolvedType = this.anonymousType.binding;
                            }
                            break;
                        }
                        var23[var11] = (TypeBinding)(var13[var11] == null ? TypeBinding.field_187 : var13[var11]);
                    }
                }
                return (TypeBinding)(this.resolvedType = (TypeBinding)var3);
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.enclosingInstance != null) {
                this.enclosingInstance.traverse(var1, var2);
            }
            int var3;
            int var4;
            if (this.typeArguments != null) {
                var3 = 0;
                for (var4 = this.typeArguments.length; var3 < var4; ++var3) {
                    this.typeArguments[var3].traverse(var1, var2);
                }
            }
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
            if (this.arguments != null) {
                var3 = this.arguments.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.arguments[var4].traverse(var1, var2);
                }
            }
            if (this.anonymousType != null) {
                this.anonymousType.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
