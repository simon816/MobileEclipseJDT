package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.ast.QualifiedSuperReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

public class MessageSend extends Expression implements InvocationSite {

    public Expression receiver;

    public char[] selector;

    public Expression[] arguments;

    public MethodBinding field_775;

    public MethodBinding field_776;

    public MethodBinding field_777;

    public TypeBinding field_778;

    public long nameSourcePosition;

    public TypeBinding field_780;

    public TypeBinding field_781;

    public TypeBinding field_782;

    public TypeReference[] typeArguments;

    public TypeBinding[] genericTypeArguments;

    public MessageSend() {
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        boolean var4 = !this.field_775.method_370();
        UnconditionalFlowInfo var7 = this.receiver.analyseCode(var1, var2, var3, var4).method_3109();
        if (var4) {
            this.receiver.checkNPE(var1, var2, var7);
        }
        if (this.arguments != null) {
            int var5 = this.arguments.length;
            for (int var6 = 0; var6 < var5; ++var6) {
                var7 = this.arguments[var6].analyseCode(var1, var2, var7).method_3109();
            }
        }
        ReferenceBinding[] var8 = this.field_775.thrownExceptions;
        if (this.field_775.thrownExceptions != Binding.field_151) {
            var2.checkExceptionHandlers(var8, this, var7.method_3078(), var1);
        }
        this.manageSyntheticAccessIfNecessary(var1, var7);
        return var7;
    }

    public void computeConversion(Scope var1, TypeBinding var2, TypeBinding var3) {
        if (var2 != null && var3 != null) {
            if (this.field_775 != null && this.field_775.isValidBinding()) {
                MethodBinding var4 = this.field_775.original();
                TypeBinding var5 = var4.returnType;
                if (var4 != this.field_775 && var5 != this.field_775.returnType && var2.id != 1 && (var5.tagBits & 536870912L) != 0L) {
                    TypeBinding var6 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    this.field_782 = var5.method_141(var6);
                } else if (this.field_780.method_147() && var2.id != 1 && this.field_775.parameters == Binding.field_150 && var1.compilerOptions().field_1927 >= 3211264L && CharOperation.method_1364(this.field_775.selector, TypeConstants.field_33)) {
                    this.field_782 = var2;
                }
                if (this.field_782 instanceof ReferenceBinding) {
                    ReferenceBinding var7 = (ReferenceBinding)this.field_782;
                    if (!var7.canBeSeenBy(var1)) {
                        ProblemReporter var10000 = var1.problemReporter();
                        ProblemReferenceBinding var10002 = new ProblemReferenceBinding(CharOperation.method_1385('.', var7.shortReadableName()), var7, 2);
                        var10000.method_1639(this, var10002);
                    }
                }
            }
            super.computeConversion(var1, var2, var3);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        boolean var5 = this.field_776.method_370();
        if (var5) {
            this.receiver.generateCode(var1, var2, false);
            var2.method_2360(var4, this.field_444);
        } else if ((this.field_446 & 8160) != 0 && this.receiver.method_752()) {
            ReferenceBinding var6 = var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5);
            Object[] var7 = var1.getEmulationPath(var6, true, false);
            var2.generateOuterAccess(var7, this, var6, var1);
        } else {
            this.receiver.generateCode(var1, var2, true);
            if (this.field_781 != null) {
                var2.method_2113(this.field_781);
            }
            var2.method_2360(var4, this.field_444);
        }
        this.generateArguments(this.field_775, this.arguments, var1, var2);
        if (this.field_777 == null) {
            if (var5) {
                var2.method_2273(this.field_776);
            } else if (!this.receiver.method_754() && !this.field_776.method_367()) {
                if (this.field_776.declaringClass.method_157()) {
                    var2.method_2261(this.field_776);
                } else {
                    var2.method_2282(this.field_776);
                }
            } else {
                var2.method_2272(this.field_776);
            }
        } else {
            var2.method_2273(this.field_777);
        }
        if (this.field_782 != null) {
            var2.method_2113(this.field_782);
        }
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            boolean var8 = (this.field_674 & 1024) != 0;
            if (var8) {
                var2.method_2182(this.field_674);
            }
            switch (var8 ? this.postConversionType(var1).id : this.field_776.returnType.id) {
                case 6:
                    break;
                case 7:
                case 8:
                    var2.method_2353();
                    break;
                default:
                    var2.method_2352();
            }
        }
        var2.method_2360(var4, (int)(this.nameSourcePosition >>> 32));
    }

    public TypeBinding[] genericTypeArguments() {
        return this.genericTypeArguments;
    }

    public boolean isSuperAccess() {
        return this.receiver.method_754();
    }

    public void manageSyntheticAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            this.field_776 = this.field_775.original();
            if (this.field_775.method_367()) {
                if (var1.enclosingSourceType() != this.field_776.declaringClass) {
                    this.field_777 = ((SourceTypeBinding)this.field_776.declaringClass).addSyntheticMethod(this.field_776, this.isSuperAccess());
                    var1.problemReporter().method_1691(this.field_776, this);
                    return;
                }
            } else {
                SourceTypeBinding var3;
                if (this.receiver instanceof QualifiedSuperReference) {
                    var3 = (SourceTypeBinding)((SourceTypeBinding)((QualifiedSuperReference)this.receiver).currentCompatibleType);
                    this.field_777 = var3.addSyntheticMethod(this.field_776, this.isSuperAccess());
                    var1.problemReporter().method_1691(this.field_776, this);
                    return;
                }
                if (this.field_775.method_368() && (this.field_446 & 8160) != 0 && this.field_776.declaringClass.getPackage() != (var3 = var1.enclosingSourceType()).getPackage()) {
                    SourceTypeBinding var4 = (SourceTypeBinding)var3.enclosingTypeAt((this.field_446 & 8160) >> 5);
                    this.field_777 = var4.addSyntheticMethod(this.field_776, this.isSuperAccess());
                    var1.problemReporter().method_1691(this.field_776, this);
                    return;
                }
            }
            if (this.field_775.declaringClass != this.field_780 && this.field_781 == null && !this.field_780.method_147()) {
                CompilerOptions var5 = var1.compilerOptions();
                if (var5.field_1929 >= 3014656L && (var5.field_1927 >= 3145728L || !this.receiver.method_752() || !this.field_776.method_370()) && this.field_775.declaringClass.id != 1 || !this.field_775.declaringClass.canBeSeenBy(var1)) {
                    this.field_776 = var1.enclosingSourceType().method_312(this.field_776, (ReferenceBinding)this.field_780.erasure());
                }
            }
        }
    }

    public int nullStatus(FlowInfo var1) {
        return 0;
    }

    public TypeBinding postConversionType(Scope var1) {
        Object var2 = this.resolvedType;
        if (this.field_782 != null) {
            var2 = this.field_782;
        }
        int var3 = (this.field_674 & 255) >> 4;
        switch (var3) {
            case 2:
                var2 = TypeBinding.field_182;
                break;
            case 3:
                var2 = TypeBinding.field_180;
                break;
            case 4:
                var2 = TypeBinding.field_181;
                break;
            case 5:
                var2 = TypeBinding.field_186;
            case 6:
            default:
                break;
            case 7:
                var2 = TypeBinding.field_183;
                break;
            case 8:
                var2 = TypeBinding.field_185;
                break;
            case 9:
                var2 = TypeBinding.field_184;
                break;
            case 10:
                var2 = TypeBinding.field_179;
        }
        if ((this.field_674 & 512) != 0) {
            var2 = var1.environment().method_486((TypeBinding)var2);
        }
        return (TypeBinding)var2;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        if (!this.receiver.method_752()) {
            this.receiver.printExpression(0, var2).append('.');
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
        var2.append(this.selector).append('(');
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
        boolean var2 = false;
        boolean var3 = false;
        if (this.receiver instanceof CastExpression) {
            this.receiver.field_446 |= 32;
            var2 = true;
        }
        this.field_780 = this.receiver.resolveType(var1);
        boolean var4 = this.receiver instanceof NameReference && (((NameReference)this.receiver).field_446 & 4) != 0;
        if (var2 && this.field_780 != null && ((CastExpression)this.receiver).field_684.resolvedType == this.field_780) {
            var1.problemReporter().unnecessaryCast((CastExpression)this.receiver);
        }
        boolean var6;
        int var7;
        int var15;
        if (this.typeArguments != null) {
            int var5 = this.typeArguments.length;
            var6 = var1.compilerOptions().field_1928 < 3211264L;
            this.genericTypeArguments = new TypeBinding[var5];
            for (var7 = 0; var7 < var5; ++var7) {
                TypeReference var8 = this.typeArguments[var7];
                if ((this.genericTypeArguments[var7] = var8.resolveType(var1, true)) == null) {
                    var6 = true;
                }
                if (var6 && var8 instanceof Wildcard) {
                    var1.problemReporter().method_1599(var8);
                }
            }
            if (var6) {
                if (this.arguments != null) {
                    var7 = 0;
                    for (var15 = this.arguments.length; var7 < var15; ++var7) {
                        this.arguments[var7].resolveType(var1);
                    }
                }
                return null;
            }
        }
        TypeBinding[] var11 = Binding.field_150;
        if (this.arguments != null) {
            var6 = false;
            var7 = this.arguments.length;
            var11 = new TypeBinding[var7];
            for (var15 = 0; var15 < var7; ++var15) {
                Expression var9 = this.arguments[var15];
                if (var9 instanceof CastExpression) {
                    var9.field_446 |= 32;
                    var3 = true;
                }
                if ((var11[var15] = var9.resolveType(var1)) == null) {
                    var6 = true;
                }
            }
            if (var6) {
                if (this.field_780 instanceof ReferenceBinding) {
                    TypeBinding[] var17 = new TypeBinding[var7];
                    int var21 = var7;
                    while (true) {
                        --var21;
                        if (var21 < 0) {
                            this.field_775 = this.receiver.method_752() ? var1.getImplicitMethod(this.selector, var17, this) : var1.method_592((ReferenceBinding)this.field_780, this.selector, var17, this);
                            if (this.field_775 != null && !this.field_775.isValidBinding()) {
                                Object var22 = ((ProblemMethodBinding)this.field_775).closestMatch;
                                if (var22 != null) {
                                    if (((MethodBinding)var22).original().typeVariables != Binding.NO_TYPE_VARIABLES) {
                                        var22 = var1.environment().createParameterizedGenericMethod(((MethodBinding)var22).original(), (RawTypeBinding)null);
                                    }
                                    this.field_775 = (MethodBinding)var22;
                                    MethodBinding var10 = ((MethodBinding)var22).original();
                                    if ((var10.method_367() || var10.declaringClass.method_158()) && !var1.isDefinedInMethod(var10)) {
                                        var10.modifiers |= 134217728;
                                    }
                                }
                            }
                            break;
                        }
                        var17[var21] = (TypeBinding)(var11[var21] == null ? TypeBinding.field_187 : var11[var21]);
                    }
                }
                return null;
            }
        }
        if (this.field_780 == null) {
            return null;
        } else if (this.field_780.method_148()) {
            var1.problemReporter().errorNoMethodFor(this, this.field_780, var11);
            return null;
        } else {
            try {
                this.field_775 = this.receiver.method_752() ? var1.getImplicitMethod(this.selector, var11, this) : var1.method_614(this.field_780, this.selector, var11, this);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (!this.field_775.isValidBinding()) {
                if (this.field_775.declaringClass == null) {
                    if (!(this.field_780 instanceof ReferenceBinding)) {
                        var1.problemReporter().errorNoMethodFor(this, this.field_780, var11);
                        return null;
                    }
                    this.field_775.declaringClass = (ReferenceBinding)this.field_780;
                }
                var1.problemReporter().method_1632(this, this.field_775);
                MethodBinding var13 = ((ProblemMethodBinding)this.field_775).closestMatch;
                switch (this.field_775.problemId()) {
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                        if (var13 != null) {
                            this.resolvedType = var13.returnType;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 9:
                }
                if (var13 != null) {
                    this.field_775 = var13;
                    MethodBinding var20 = var13.original();
                    if ((var20.method_367() || var20.declaringClass.method_158()) && !var1.isDefinedInMethod(var20)) {
                        var20.modifiers |= 134217728;
                    }
                }
                return this.resolvedType != null && (this.resolvedType.tagBits & 128L) == 0L ? this.resolvedType : null;
            } else {
                if ((this.field_775.tagBits & 128L) != 0L) {
                    var1.problemReporter().method_1683(this, this.field_775);
                }
                CompilerOptions var14 = var1.compilerOptions();
                TypeBinding var12;
                if (!this.field_775.method_370()) {
                    if (var4) {
                        var1.problemReporter().method_1687(this, this.field_775);
                        if (this.field_780.method_166() && (this.receiver.field_446 & 1073741824) == 0 && var14.method_3313(35184372088832L) != -1) {
                            var1.problemReporter().method_1742(this.receiver, this.field_780);
                        }
                    } else {
                        this.receiver.computeConversion(var1, this.field_780, this.field_780);
                        var12 = this.field_780.erasure();
                        if (var12 instanceof ReferenceBinding && var12.method_140(this.field_775.declaringClass) == null) {
                            this.field_781 = this.field_775.declaringClass;
                        }
                    }
                } else {
                    if (!this.receiver.method_752() && !this.receiver.method_754() && !var4) {
                        var1.problemReporter().method_1705(this, this.field_775);
                    }
                    if (!this.receiver.method_752() && this.field_775.declaringClass != this.field_780) {
                        var1.problemReporter().method_1613(this, this.field_775);
                    }
                }
                method_749(var1, this.receiver, this.field_780, this.field_775, this.arguments, var11, var3, this);
                if (this.field_775.method_356() && this.receiver.method_754()) {
                    var1.problemReporter().method_1495(this, this.field_775);
                }
                if (this.isMethodUseDeprecated(this.field_775, var1, true)) {
                    var1.problemReporter().method_1515(this.field_775, this);
                }
                if (this.field_780.method_147() && this.field_775.parameters == Binding.field_150 && var14.field_1927 >= 3211264L && CharOperation.method_1364(this.field_775.selector, TypeConstants.field_33)) {
                    this.resolvedType = this.field_780;
                } else {
                    var12 = this.field_775.returnType;
                    if (var12 != null) {
                        var12 = var12.capture(var1, this.field_445);
                    }
                    this.resolvedType = var12;
                }
                if (this.receiver.method_754() && var14.method_3313(562949953421312L) != -1) {
                    ReferenceContext var16 = var1.method_635().referenceContext;
                    if (var16 instanceof AbstractMethodDeclaration) {
                        AbstractMethodDeclaration var19 = (AbstractMethodDeclaration)var16;
                        MethodBinding var18 = var19.binding;
                        if (var18.method_366() && CharOperation.method_1364(this.field_775.selector, var18.selector) && this.field_775.method_344(var18)) {
                            var19.field_446 |= 16;
                        }
                    }
                }
                if (this.typeArguments != null && this.field_775.original().typeVariables == Binding.NO_TYPE_VARIABLES) {
                    var1.problemReporter().unnecessaryTypeArgumentsForMethodInvocation(this.field_775, this.genericTypeArguments, this.typeArguments);
                }
                return (this.resolvedType.tagBits & 128L) == 0L ? this.resolvedType : null;
            }
        }
    }

    public void setActualReceiverType(ReferenceBinding var1) {
        if (var1 != null) {
            this.field_780 = var1;
        }
    }

    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    public void setExpectedType(TypeBinding var1) {
        this.field_778 = var1;
    }

    public void setFieldIndex(int var1) {}

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.receiver.traverse(var1, var2);
            int var3;
            int var4;
            if (this.typeArguments != null) {
                var3 = 0;
                for (var4 = this.typeArguments.length; var3 < var4; ++var3) {
                    this.typeArguments[var3].traverse(var1, var2);
                }
            }
            if (this.arguments != null) {
                var3 = this.arguments.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.arguments[var4].traverse(var1, var2);
                }
            }
        }
        var1.endVisit(this, var2);
    }
}
