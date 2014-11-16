package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.InitializationFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortMethod;

public class MethodDeclaration extends AbstractMethodDeclaration {

    public TypeReference returnType;

    public TypeParameter[] typeParameters;

    public MethodDeclaration(CompilationResult var1) {
        super(var1);
    }

    public void analyseCode(ClassScope var1, InitializationFlowContext var2, FlowInfo var3) {
        if (!this.ignoreFurtherInvestigation) {
            try {
                if (this.binding == null) {
                    return;
                }
                if (!this.binding.method_373() && (this.binding.method_367() || (this.binding.modifiers & 805306368) == 0 && this.binding.declaringClass.method_158()) && !var1.referenceCompilationUnit().compilationResult.field_1692) {
                    this.scope.problemReporter().method_1814(this);
                }
                if (this.binding.declaringClass.method_153() && (this.selector == TypeConstants.field_71 || this.selector == TypeConstants.field_72)) {
                    return;
                }
                if (this.binding.method_356() || this.binding.method_365()) {
                    return;
                }
                ExceptionHandlingFlowContext var10000 = new ExceptionHandlingFlowContext(var2, this, this.binding.thrownExceptions, this.scope, FlowInfo.DEAD_END);
                ExceptionHandlingFlowContext var4 = var10000;
                int var6;
                if (this.arguments != null) {
                    int var5 = 0;
                    for (var6 = this.arguments.length; var5 < var6; ++var5) {
                        var3.method_3099(this.arguments[var5].binding);
                    }
                }
                if (this.statements != null) {
                    boolean var10 = false;
                    var6 = 0;
                    for (int var7 = this.statements.length; var6 < var7; ++var6) {
                        Statement var8 = this.statements[var6];
                        if (!var8.method_816(var3, this.scope, var10)) {
                            var3 = var8.analyseCode(this.scope, var4, var3);
                        } else {
                            var10 = true;
                        }
                    }
                }
                TypeBinding var11 = this.binding.returnType;
                if (var11 != TypeBinding.field_188 && !this.method_792()) {
                    if (var3 != FlowInfo.DEAD_END) {
                        this.scope.problemReporter().method_1754(var11, this);
                    }
                } else if ((var3.tagBits & 1) == 0) {
                    this.field_446 |= 64;
                }
                var4.complainIfUnusedExceptionHandlers(this);
                this.scope.checkUnusedParameters(this.binding);
            } catch (AbortMethod var9) {
                this.ignoreFurtherInvestigation = true;
            }
        }
    }

    public void parseStatements(Parser var1, CompilationUnitDeclaration var2) {
        var1.parse(this, var2);
    }

    public StringBuffer printReturnType(int var1, StringBuffer var2) {
        return this.returnType == null ? var2 : this.returnType.printExpression(0, var2).append(' ');
    }

    public void resolveStatements() {
        if (this.returnType != null && this.binding != null) {
            this.returnType.resolvedType = this.binding.returnType;
        }
        if (CharOperation.method_1364(this.scope.enclosingSourceType().sourceName, this.selector)) {
            this.scope.problemReporter().method_1674(this);
        }
        int var2;
        if (this.typeParameters != null) {
            int var1 = 0;
            for (var2 = this.typeParameters.length; var1 < var2; ++var1) {
                this.typeParameters[var1].resolve(this.scope);
            }
        }
        CompilerOptions var6 = this.scope.compilerOptions();
        if (this.binding != null) {
            long var7 = var6.field_1928;
            if (var7 >= 3211264L) {
                int var4 = this.binding.modifiers;
                boolean var5 = (this.binding.tagBits & 562949953421312L) != 0L;
                if (var5) {
                    if ((var4 & 268435464) != 268435456 && (var7 < 3276800L || (var4 & 536870920) != 536870912)) {
                        this.scope.problemReporter().method_1670(this);
                    }
                } else if (!this.binding.declaringClass.method_157() && (var4 & 268435464) == 268435456) {
                    this.scope.problemReporter().method_1679(this);
                }
            }
        }
        switch (TypeDeclaration.kind(this.scope.referenceType().field_577)) {
            case 3:
                if (this.selector == TypeConstants.field_71 || this.selector == TypeConstants.field_72) {
                    break;
                }
            case 1:
                if ((this.field_482 & 16777216) != 0) {
                    if ((this.field_482 & 256) == 0 && (this.field_482 & 1024) == 0) {
                        this.scope.problemReporter().method_1672(this);
                    }
                } else if ((this.field_482 & 256) != 0 || (this.field_482 & 1024) != 0) {
                    this.scope.problemReporter().method_1673(this);
                }
        }
        super.resolveStatements();
        if (var6.method_3313(562949953421312L) != -1 && this.binding != null) {
            var2 = this.binding.modifiers;
            if ((var2 & 805306368) == 268435456 && (this.field_446 & 16) == 0) {
                this.scope.problemReporter().overridesMethodWithoutSuperInvocation(this.binding);
            }
        }
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        if (var1.visit(this, var2)) {
            int var3;
            int var4;
            if (this.annotations != null) {
                var3 = this.annotations.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.annotations[var4].traverse(var1, this.scope);
                }
            }
            if (this.typeParameters != null) {
                var3 = this.typeParameters.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.typeParameters[var4].traverse(var1, this.scope);
                }
            }
            if (this.returnType != null) {
                this.returnType.traverse(var1, this.scope);
            }
            if (this.arguments != null) {
                var3 = this.arguments.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.arguments[var4].traverse(var1, this.scope);
                }
            }
            if (this.thrownExceptions != null) {
                var3 = this.thrownExceptions.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.thrownExceptions[var4].traverse(var1, this.scope);
                }
            }
            if (this.statements != null) {
                var3 = this.statements.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.statements[var4].traverse(var1, this.scope);
                }
            }
        }
        var1.endVisit(this, var2);
    }

    public TypeParameter[] typeParameters() {
        return this.typeParameters;
    }
}
