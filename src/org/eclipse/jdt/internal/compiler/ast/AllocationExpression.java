package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class AllocationExpression extends Expression implements InvocationSite {

    public TypeReference type;

    public Expression[] arguments;

    public MethodBinding binding;

    protected MethodBinding field_694;

    MethodBinding syntheticAccessor;

    public TypeReference[] typeArguments;

    public TypeBinding[] genericTypeArguments;

    public FieldDeclaration enumConstant;

    public AllocationExpression() {
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.checkCapturedLocalInitializationIfNecessary((ReferenceBinding)this.binding.declaringClass.erasure(), var1, (FlowInfo)var3);
        if (this.arguments != null) {
            int var4 = 0;
            for (int var5 = this.arguments.length; var4 < var5; ++var4) {
                var3 = this.arguments[var4].analyseCode(var1, var2, (FlowInfo)var3).method_3109();
            }
        }
        ReferenceBinding[] var6 = this.binding.thrownExceptions;
        if (this.binding.thrownExceptions.length != 0) {
            var2.checkExceptionHandlers(var6, this, ((FlowInfo)var3).method_3107(), var1);
        }
        this.manageEnclosingInstanceAccessIfNecessary(var1, (FlowInfo)var3);
        this.method_953(var1, (FlowInfo)var3);
        return (FlowInfo)var3;
    }

    public void checkCapturedLocalInitializationIfNecessary(ReferenceBinding var1, BlockScope var2, FlowInfo var3) {
        if ((var1.tagBits & 52L) == 20L && !var2.method_628(var1)) {
            NestedTypeBinding var4 = (NestedTypeBinding)var1;
            SyntheticArgumentBinding[] var5 = var4.syntheticOuterLocalVariables();
            if (var5 != null) {
                int var6 = 0;
                for (int var7 = var5.length; var6 < var7; ++var6) {
                    SyntheticArgumentBinding var8 = var5[var6];
                    LocalVariableBinding var9 = var8.actualOuterLocalVariable;
                    if (var8.actualOuterLocalVariable != null && var9.declaration != null && !var3.method_3083(var9)) {
                        var2.problemReporter().method_1789(var9, this);
                    }
                }
            }
        }
    }

    public Expression enclosingInstance() {
        return null;
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
    }

    public TypeBinding[] genericTypeArguments() {
        return this.genericTypeArguments;
    }

    public boolean isSuperAccess() {
        return false;
    }

    public void manageEnclosingInstanceAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            ReferenceBinding var3 = (ReferenceBinding)this.binding.declaringClass.erasure();
            if (var3.method_160() && var1.enclosingSourceType().method_158()) {
                if (var3.method_158()) {
                    ((LocalTypeBinding)var3).addInnerEmulationDependent(var1, false);
                } else {
                    var1.propagateInnerEmulation(var3, false);
                }
            }
        }
    }

    public void method_953(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            this.field_694 = this.binding.original();
            if (this.field_694.method_367()) {
                SourceTypeBinding var10000 = var1.enclosingSourceType();
                ReferenceBinding var3 = this.field_694.declaringClass;
                if (var10000 != this.field_694.declaringClass) {
                    if ((var3.tagBits & 16L) != 0L && var1.compilerOptions().field_1927 >= 3145728L) {
                        this.field_694.tagBits |= 1024L;
                    } else {
                        this.syntheticAccessor = ((SourceTypeBinding)var3).addSyntheticMethod(this.field_694, this.isSuperAccess());
                        var1.problemReporter().method_1691(this.field_694, this);
                    }
                }
            }
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        if (this.type != null) {
            var2.append("new ");
        }
        int var3;
        if (this.typeArguments != null) {
            var2.append('<');
            var3 = this.typeArguments.length - 1;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.typeArguments[var4].print(0, var2);
                var2.append(", ");
            }
            this.typeArguments[var3].print(0, var2);
            var2.append('>');
        }
        if (this.type != null) {
            this.type.printExpression(0, var2);
        }
        var2.append('(');
        if (this.arguments != null) {
            for (var3 = 0; var3 < this.arguments.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.arguments[var3].printExpression(0, var2);
            }
        }
        return var2.append(')');
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        int var4;
        if (this.type == null) {
            this.resolvedType = var1.method_584();
        } else {
            this.resolvedType = this.type.resolveType(var1, true);
            if (this.type instanceof ParameterizedQualifiedTypeReference) {
                ReferenceBinding var2 = (ReferenceBinding)this.resolvedType;
                if (var2 == null) {
                    return var2;
                }
                label175:
                while ((var2.modifiers & 8) == 0 && !var2.method_166()) {
                    if ((var2 = var2.enclosingType()) == null) {
                        ParameterizedQualifiedTypeReference var3 = (ParameterizedQualifiedTypeReference)this.type;
                        var4 = var3.typeArguments.length - 2;
                        while (true) {
                            if (var4 < 0) {
                                break label175;
                            }
                            if (var3.typeArguments[var4] != null) {
                                var1.problemReporter().method_1596(this.type, this.resolvedType);
                                break label175;
                            }
                            --var4;
                        }
                    }
                }
            }
        }
        int var14;
        if (this.typeArguments != null) {
            int var9 = this.typeArguments.length;
            boolean var11 = var1.compilerOptions().field_1928 < 3211264L;
            this.genericTypeArguments = new TypeBinding[var9];
            for (var4 = 0; var4 < var9; ++var4) {
                TypeReference var5 = this.typeArguments[var4];
                if ((this.genericTypeArguments[var4] = var5.resolveType(var1, true)) == null) {
                    var11 = true;
                }
                if (var11 && var5 instanceof Wildcard) {
                    var1.problemReporter().method_1599(var5);
                }
            }
            if (var11) {
                if (this.arguments != null) {
                    var4 = 0;
                    for (var14 = this.arguments.length; var4 < var14; ++var4) {
                        this.arguments[var4].resolveType(var1);
                    }
                }
                return null;
            }
        }
        boolean var10 = false;
        TypeBinding[] var12 = Binding.field_150;
        if (this.arguments != null) {
            boolean var13 = false;
            var14 = this.arguments.length;
            var12 = new TypeBinding[var14];
            for (int var6 = 0; var6 < var14; ++var6) {
                Expression var7 = this.arguments[var6];
                if (var7 instanceof CastExpression) {
                    var7.field_446 |= 32;
                    var10 = true;
                }
                if ((var12[var6] = var7.resolveType(var1)) == null) {
                    var13 = true;
                }
            }
            if (var13) {
                if (this.resolvedType instanceof ReferenceBinding) {
                    TypeBinding[] var16 = new TypeBinding[var14];
                    int var17 = var14;
                    while (true) {
                        --var17;
                        if (var17 < 0) {
                            this.binding = var1.method_592((ReferenceBinding)this.resolvedType, TypeConstants.field_135, var16, this);
                            if (this.binding != null && !this.binding.isValidBinding()) {
                                Object var18 = ((ProblemMethodBinding)this.binding).closestMatch;
                                if (var18 != null) {
                                    if (((MethodBinding)var18).original().typeVariables != Binding.NO_TYPE_VARIABLES) {
                                        var18 = var1.environment().createParameterizedGenericMethod(((MethodBinding)var18).original(), (RawTypeBinding)null);
                                    }
                                    this.binding = (MethodBinding)var18;
                                    MethodBinding var8 = ((MethodBinding)var18).original();
                                    if ((var8.method_367() || var8.declaringClass.method_158()) && !var1.isDefinedInMethod(var8)) {
                                        var8.modifiers |= 134217728;
                                    }
                                }
                            }
                            break;
                        }
                        var16[var17] = (TypeBinding)(var12[var17] == null ? TypeBinding.field_187 : var12[var17]);
                    }
                }
                return this.resolvedType;
            }
        }
        if (this.resolvedType != null && this.resolvedType.isValidBinding()) {
            if (this.type != null && !this.resolvedType.method_129()) {
                var1.problemReporter().method_1498(this.type, this.resolvedType);
                return this.resolvedType;
            } else {
                ReferenceBinding var15 = (ReferenceBinding)this.resolvedType;
                if (!(this.binding = var1.method_599(var15, var12, this)).isValidBinding()) {
                    if (this.binding.declaringClass == null) {
                        this.binding.declaringClass = var15;
                    }
                    if (this.type != null && !this.type.resolvedType.isValidBinding()) {
                        return null;
                    } else {
                        var1.problemReporter().invalidConstructor(this, this.binding);
                        return this.resolvedType;
                    }
                } else {
                    if ((this.binding.tagBits & 128L) != 0L) {
                        var1.problemReporter().method_1682(this, this.binding);
                    }
                    if (this.isMethodUseDeprecated(this.binding, var1, true)) {
                        var1.problemReporter().method_1515(this.binding, this);
                    }
                    method_749(var1, (Expression)null, var15, this.binding, this.arguments, var12, var10, this);
                    if (this.typeArguments != null && this.binding.original().typeVariables == Binding.NO_TYPE_VARIABLES) {
                        var1.problemReporter().unnecessaryTypeArgumentsForMethodInvocation(this.binding, this.genericTypeArguments, this.typeArguments);
                    }
                    return var15;
                }
            }
        } else {
            return null;
        }
    }

    public void setActualReceiverType(ReferenceBinding var1) {}

    public void method_2(int var1) {}

    public void setFieldIndex(int var1) {}

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
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
                var3 = 0;
                for (var4 = this.arguments.length; var3 < var4; ++var3) {
                    this.arguments[var3].traverse(var1, var2);
                }
            }
        }
        var1.endVisit(this, var2);
    }
}
