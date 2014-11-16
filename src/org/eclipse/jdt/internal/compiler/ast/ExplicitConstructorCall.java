package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class ExplicitConstructorCall extends Statement implements InvocationSite {

    public Expression[] arguments;

    public Expression qualification;

    public MethodBinding binding;

    protected MethodBinding field_549;

    MethodBinding syntheticAccessor;

    public int field_551;

    public TypeReference[] typeArguments;

    public TypeBinding[] genericTypeArguments;

    public int field_554;

    public ExplicitConstructorCall(int var1) {
        this.field_551 = var1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        Object var10;
        try {
            ((MethodScope)var1).field_405 = true;
            if (this.qualification != null) {
                var3 = this.qualification.analyseCode(var1, var2, (FlowInfo)var3).method_3109();
            }
            if (this.arguments != null) {
                int var4 = 0;
                for (int var5 = this.arguments.length; var4 < var5; ++var4) {
                    var3 = this.arguments[var4].analyseCode(var1, var2, (FlowInfo)var3).method_3109();
                }
            }
            ReferenceBinding[] var9 = this.binding.thrownExceptions;
            if (this.binding.thrownExceptions != Binding.field_151) {
                var2.checkExceptionHandlers(var9, (ASTNode)(this.field_551 == 1 ? (ASTNode)var1.method_635().referenceContext : this), (FlowInfo)var3, var1);
            }
            this.manageEnclosingInstanceAccessIfNecessary(var1, (FlowInfo)var3);
            this.manageSyntheticAccessIfNecessary(var1, (FlowInfo)var3);
            var10 = var3;
        } finally {
            ((MethodScope)var1).field_405 = false;
        }
        return (FlowInfo)var10;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            try {
                ((MethodScope)var1).field_405 = true;
                int var3 = var2.field_1208;
                var2.method_2093();
                ReferenceBinding var4 = this.field_549.declaringClass;
                if (var4.erasure().id == 41 || var4.method_153()) {
                    var2.method_2094();
                    var2.method_2249();
                }
                if (var4.method_160()) {
                    var2.generateSyntheticEnclosingInstanceValues(var1, var4, (this.field_446 & 8192) != 0 ? null : this.qualification, this);
                }
                this.generateArguments(this.binding, this.arguments, var1, var2);
                if (var4.method_160()) {
                    var2.generateSyntheticOuterArgumentValues(var1, var4, this);
                }
                if (this.syntheticAccessor != null) {
                    int var5 = 0;
                    for (int var6 = this.syntheticAccessor.parameters.length - this.field_549.parameters.length; var5 < var6; ++var5) {
                        var2.method_2087();
                    }
                    var2.method_2272(this.syntheticAccessor);
                } else {
                    var2.method_2272(this.field_549);
                }
                var2.method_2360(var3, this.field_444);
            } finally {
                ((MethodScope)var1).field_405 = false;
            }
        }
    }

    public TypeBinding[] genericTypeArguments() {
        return this.genericTypeArguments;
    }

    public boolean method_831() {
        return this.field_551 == 1;
    }

    public boolean isSuperAccess() {
        return this.field_551 != 3;
    }

    void manageEnclosingInstanceAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        ReferenceBinding var3 = (ReferenceBinding)this.binding.declaringClass.erasure();
        if ((var2.tagBits & 1) == 0 && var3.method_160() && var1.enclosingSourceType().method_158()) {
            if (var3.method_158()) {
                ((LocalTypeBinding)var3).addInnerEmulationDependent(var1, this.qualification != null);
            } else {
                var1.propagateInnerEmulation(var3, this.qualification != null);
            }
        }
    }

    public void manageSyntheticAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            this.field_549 = this.binding.original();
            if (this.binding.method_367() && this.field_551 != 3) {
                ReferenceBinding var3 = this.field_549.declaringClass;
                if ((var3.tagBits & 16L) != 0L && var1.compilerOptions().field_1927 >= 3145728L) {
                    this.field_549.tagBits |= 1024L;
                } else {
                    this.syntheticAccessor = ((SourceTypeBinding)var3).addSyntheticMethod(this.field_549, this.isSuperAccess());
                    var1.problemReporter().method_1691(this.field_549, this);
                }
            }
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2);
        if (this.qualification != null) {
            this.qualification.printExpression(0, var2).append('.');
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
        if (this.field_551 == 3) {
            var2.append("this(");
        } else {
            var2.append("super(");
        }
        if (this.arguments != null) {
            for (var3 = 0; var3 < this.arguments.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.arguments[var3].printExpression(0, var2);
            }
        }
        return var2.append(");");
    }

    public void resolve(BlockScope var1) {
        MethodScope var2 = var1.method_635();
        try {
            AbstractMethodDeclaration var3 = var2.referenceMethod();
            if (var3 == null || !var3.method_795() || ((ConstructorDeclaration)var3).constructorCall != this) {
                var1.problemReporter().method_1627(this);
                if (this.qualification != null) {
                    this.qualification.resolveType(var1);
                }
                int var16;
                int var18;
                if (this.typeArguments != null) {
                    var16 = 0;
                    for (var18 = this.typeArguments.length; var16 < var18; ++var16) {
                        this.typeArguments[var16].resolveType(var1, true);
                    }
                }
                if (this.arguments != null) {
                    var16 = 0;
                    for (var18 = this.arguments.length; var16 < var18; ++var16) {
                        this.arguments[var16].resolveType(var1);
                    }
                }
            } else {
                var2.field_405 = true;
                ReferenceBinding var4 = var1.method_584();
                boolean var5 = false;
                if (this.field_551 != 3) {
                    var4 = var4.superclass();
                    TypeReference var6 = var1.referenceType().superclass;
                    if (var6 != null && var6.resolvedType != null && !var6.resolvedType.isValidBinding()) {
                        var5 = true;
                    }
                }
                if (var4 != null) {
                    if (this.field_551 == 2 && var4.erasure().id == 41) {
                        var1.problemReporter().cannotInvokeSuperConstructorInEnum(this, var2.referenceMethod().binding);
                    }
                    if (this.qualification != null) {
                        if (this.field_551 != 2) {
                            var1.problemReporter().unnecessaryEnclosingInstanceSpecification(this.qualification, var4);
                        }
                        if (!var5) {
                            ReferenceBinding var19 = var4.enclosingType();
                            if (var19 == null) {
                                var1.problemReporter().unnecessaryEnclosingInstanceSpecification(this.qualification, var4);
                                this.field_446 |= 8192;
                            } else {
                                TypeBinding var7 = this.qualification.resolveTypeExpecting(var1, var19);
                                this.qualification.computeConversion(var1, var7, var7);
                            }
                        }
                    }
                }
                int var24;
                if (this.typeArguments != null) {
                    boolean var17 = var1.compilerOptions().field_1928 < 3211264L;
                    int var20 = this.typeArguments.length;
                    this.genericTypeArguments = new TypeBinding[var20];
                    int var8 = 0;
                    while (true) {
                        if (var8 >= var20) {
                            if (var17) {
                                if (this.arguments == null) {
                                    return;
                                }
                                var8 = 0;
                                for (var24 = this.arguments.length; var8 < var24; ++var8) {
                                    this.arguments[var8].resolveType(var1);
                                }
                                return;
                            }
                            break;
                        }
                        TypeReference var9 = this.typeArguments[var8];
                        if ((this.genericTypeArguments[var8] = var9.resolveType(var1, true)) == null) {
                            var17 = true;
                        }
                        if (var17 && var9 instanceof Wildcard) {
                            var1.problemReporter().method_1599(var9);
                        }
                        ++var8;
                    }
                }
                TypeBinding[] var22 = Binding.field_150;
                boolean var21 = false;
                if (this.arguments == null) {
                    if (var4.erasure().id == 41) {
                        var22 = new TypeBinding[] {var1.method_610(), TypeBinding.field_179};
                    }
                } else {
                    boolean var23 = false;
                    var24 = this.arguments.length;
                    var22 = new TypeBinding[var24];
                    for (int var10 = 0; var10 < var24; ++var10) {
                        Expression var11 = this.arguments[var10];
                        if (var11 instanceof CastExpression) {
                            var11.field_446 |= 32;
                            var21 = true;
                        }
                        if ((var22[var10] = var11.resolveType(var1)) == null) {
                            var23 = true;
                        }
                    }
                    if (var23) {
                        if (var4 != null) {
                            TypeBinding[] var26 = new TypeBinding[var24];
                            int var25 = var24;
                            while (true) {
                                --var25;
                                if (var25 < 0) {
                                    this.binding = var1.method_592(var4, TypeConstants.field_135, var26, this);
                                    if (this.binding != null && !this.binding.isValidBinding()) {
                                        Object var27 = ((ProblemMethodBinding)this.binding).closestMatch;
                                        if (var27 != null) {
                                            if (((MethodBinding)var27).original().typeVariables != Binding.NO_TYPE_VARIABLES) {
                                                var27 = var1.environment().createParameterizedGenericMethod(((MethodBinding)var27).original(), (RawTypeBinding)null);
                                            }
                                            this.binding = (MethodBinding)var27;
                                            MethodBinding var12 = ((MethodBinding)var27).original();
                                            if ((var12.method_367() || var12.declaringClass.method_158()) && !var1.isDefinedInMethod(var12)) {
                                                var12.modifiers |= 134217728;
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                var26[var25] = (TypeBinding)(var22[var25] == null ? TypeBinding.field_187 : var22[var25]);
                            }
                        }
                        return;
                    }
                }
                if (var4 != null) {
                    if ((this.binding = var1.method_599(var4, var22, this)).isValidBinding()) {
                        if ((this.binding.tagBits & 128L) != 0L && !var2.enclosingSourceType().method_146()) {
                            var1.problemReporter().method_1682(this, this.binding);
                        }
                        if (this.isMethodUseDeprecated(this.binding, var1, this.field_551 != 1)) {
                            var1.problemReporter().method_1515(this.binding, this);
                        }
                        method_749(var1, (Expression)null, var4, this.binding, this.arguments, var22, var21, this);
                        if (this.binding.method_367() || var4.method_158()) {
                            MethodBinding var10000 = this.binding.original();
                            var10000.modifiers |= 134217728;
                        }
                        if (this.typeArguments != null && this.binding.original().typeVariables == Binding.NO_TYPE_VARIABLES) {
                            var1.problemReporter().unnecessaryTypeArgumentsForMethodInvocation(this.binding, this.genericTypeArguments, this.typeArguments);
                            return;
                        }
                    } else {
                        if (this.binding.declaringClass == null) {
                            this.binding.declaringClass = var4;
                        }
                        if (var5) {
                            return;
                        }
                        var1.problemReporter().invalidConstructor(this, this.binding);
                    }
                }
            }
        } finally {
            var2.field_405 = false;
        }
    }

    public void setActualReceiverType(ReferenceBinding var1) {}

    public void method_2(int var1) {}

    public void setFieldIndex(int var1) {}

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.qualification != null) {
                this.qualification.traverse(var1, var2);
            }
            int var3;
            int var4;
            if (this.typeArguments != null) {
                var3 = 0;
                for (var4 = this.typeArguments.length; var3 < var4; ++var3) {
                    this.typeArguments[var3].traverse(var1, var2);
                }
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
