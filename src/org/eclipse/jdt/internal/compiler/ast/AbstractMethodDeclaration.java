package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.InitializationFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.AbortType;
import org.eclipse.jdt.internal.compiler.problem.AbortMethod;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Util;

public abstract class AbstractMethodDeclaration extends ASTNode implements ReferenceContext {

    public MethodScope scope;

    public char[] selector;

    public int field_480;

    public int field_481;

    public int field_482;

    public Annotation[] annotations;

    public Argument[] arguments;

    public TypeReference[] thrownExceptions;

    public Statement[] statements;

    public int field_487;

    public MethodBinding binding;

    public boolean ignoreFurtherInvestigation;

    public int field_490;

    public int field_491;

    public CompilationResult compilationResult;

    AbstractMethodDeclaration(CompilationResult var1) {
        this.ignoreFurtherInvestigation = false;
        this.field_491 = -1;
        this.compilationResult = var1;
    }

    public void abort(int var1, CategorizedProblem var2) {
        switch (var1) {
            case 2:
                AbortCompilation var5 = new AbortCompilation(this.compilationResult, var2);
                throw var5;
            case 4:
                AbortCompilationUnit var4 = new AbortCompilationUnit(this.compilationResult, var2);
                throw var4;
            case 8:
                AbortType var10000 = new AbortType(this.compilationResult, var2);
                throw var10000;
            default:
                AbortMethod var3 = new AbortMethod(this.compilationResult, var2);
                throw var3;
        }
    }

    public abstract void analyseCode(ClassScope var1, InitializationFlowContext var2, FlowInfo var3);

    public void method_787() {
        if (this.arguments != null) {
            if (this.binding == null) {
                int var7 = 0;
                for (int var8 = this.arguments.length; var7 < var8; ++var7) {
                    this.arguments[var7].bind(this.scope, (TypeBinding)null, true);
                }
                return;
            }
            boolean var1 = this.binding.method_356() || this.binding.method_365();
            AnnotationBinding[][] var2 = (AnnotationBinding[][])null;
            int var3 = 0;
            for (int var4 = this.arguments.length; var3 < var4; ++var3) {
                Argument var5 = this.arguments[var3];
                var5.bind(this.scope, this.binding.parameters[var3], var1);
                if (var5.annotations != null) {
                    if (var2 == null) {
                        var2 = new AnnotationBinding[var4][];
                        for (int var6 = 0; var6 < var3; ++var6) {
                            var2[var6] = Binding.NO_ANNOTATIONS;
                        }
                    }
                    var2[var3] = var5.binding.getAnnotations();
                } else if (var2 != null) {
                    var2[var3] = Binding.NO_ANNOTATIONS;
                }
            }
            if (var2 != null) {
                this.binding.setParameterAnnotations(var2);
            }
        }
    }

    public void method_788() {
        if (this.thrownExceptions != null && this.binding != null && this.binding.thrownExceptions != null) {
            int var1 = this.thrownExceptions.length;
            int var2 = this.binding.thrownExceptions.length;
            int var3;
            if (var2 == var1) {
                for (var3 = 0; var3 < var2; ++var3) {
                    this.thrownExceptions[var3].resolvedType = this.binding.thrownExceptions[var3];
                }
            } else {
                var3 = 0;
                for (int var4 = 0; var4 < var1 && var3 < var2; ++var4) {
                    TypeReference var5 = this.thrownExceptions[var4];
                    ReferenceBinding var6 = this.binding.thrownExceptions[var3];
                    char[][] var7 = var6.compoundName;
                    if (var7 != null) {
                        if (var5 instanceof SingleTypeReference) {
                            int var8 = var7.length;
                            char[] var9 = var5.getTypeName()[0];
                            if (CharOperation.method_1364(var9, var7[var8 - 1])) {
                                var5.resolvedType = var6;
                                ++var3;
                            }
                        } else if (CharOperation.equals(var5.getTypeName(), var7)) {
                            var5.resolvedType = var6;
                            ++var3;
                        }
                    }
                }
            }
        }
    }

    public CompilationResult compilationResult() {
        return this.compilationResult;
    }

    public void generateCode(ClassScope var1, ClassFile var2) {
        byte var3 = 0;
        var2.codeStream.field_1216 = false;
        CategorizedProblem[] var6;
        if (this.ignoreFurtherInvestigation) {
            if (this.binding != null) {
                CategorizedProblem[] var12 = this.scope.referenceCompilationUnit().compilationResult.method_2922();
                int var4;
                var6 = new CategorizedProblem[var4 = var12.length];
                System.arraycopy(var12, 0, var6, 0, var4);
                var2.method_2969(this, this.binding, var6);
            }
        } else {
            try {
                int var11 = var2.field_1719;
                this.generateCode(var2);
            } catch (AbortMethod var10) {
                CategorizedProblem[] var7;
                if (var10.compilationResult == CodeStream.RESTART_IN_WIDE_MODE) {
                    try {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                        var2.codeStream.field_1216 = true;
                        this.generateCode(var2);
                    } catch (AbortMethod var9) {
                        var7 = this.scope.referenceCompilationUnit().compilationResult.method_2916();
                        int var13;
                        CategorizedProblem[] var8 = new CategorizedProblem[var13 = var7.length];
                        System.arraycopy(var7, 0, var8, 0, var13);
                        var2.method_2970(this, this.binding, var8, var3);
                    }
                } else {
                    var6 = this.scope.referenceCompilationUnit().compilationResult.method_2916();
                    int var5;
                    var7 = new CategorizedProblem[var5 = var6.length];
                    System.arraycopy(var6, 0, var7, 0, var5);
                    var2.method_2970(this, this.binding, var7, var3);
                }
            }
        }
    }

    public void generateCode(ClassFile var1) {
        var1.generateMethodInfoHeader(this.binding);
        int var2 = var1.field_1719;
        int var3 = var1.generateMethodInfoAttribute(this.binding);
        if (!this.binding.method_365() && !this.binding.method_356()) {
            int var4 = var1.field_1719;
            var1.method_2989();
            CodeStream var5 = var1.codeStream;
            var5.reset(this, var1);
            this.scope.computeLocalVariablePositions(this.binding.method_370() ? 0 : 1, var5);
            int var6;
            int var7;
            if (this.arguments != null) {
                var6 = 0;
                for (var7 = this.arguments.length; var6 < var7; ++var6) {
                    LocalVariableBinding var8;
                    var5.method_2090(var8 = this.arguments[var6].binding);
                    var8.method_415(0);
                }
            }
            if (this.statements != null) {
                var6 = 0;
                for (var7 = this.statements.length; var6 < var7; ++var6) {
                    this.statements[var6].generateCode(this.scope, var5);
                }
            }
            if (this.ignoreFurtherInvestigation) {
                AbortMethod var10000 = new AbortMethod(this.scope.referenceCompilationUnit().compilationResult, (CategorizedProblem)null);
                throw var10000;
            }
            if ((this.field_446 & 64) != 0) {
                var5.method_2371();
            }
            var5.exitUserScope(this.scope);
            var5.method_2360(0, this.field_481);
            var1.method_2979(var4);
            ++var3;
        } else {
            this.checkArgumentsSize();
        }
        var1.method_2986(var2, var3);
    }

    private void checkArgumentsSize() {
        TypeBinding[] var1 = this.binding.parameters;
        int var2 = 1;
        int var3 = 0;
        for (int var4 = var1.length; var3 < var4; ++var3) {
            TypeBinding var5 = var1[var3];
            if (var5 != TypeBinding.field_183 && var5 != TypeBinding.field_185) {
                ++var2;
            } else {
                var2 += 2;
            }
            if (var2 > 255) {
                this.scope.problemReporter().method_1697(this.scope.locals[var3], this.scope.locals[var3].declaration);
            }
        }
    }

    public boolean hasErrors() {
        return this.ignoreFurtherInvestigation;
    }

    public boolean method_792() {
        return this.binding != null ? this.binding.method_356() : (this.field_482 & 1024) != 0;
    }

    public boolean method_793() {
        return false;
    }

    public boolean method_794() {
        return false;
    }

    public boolean method_795() {
        return false;
    }

    public boolean method_796() {
        return false;
    }

    public boolean method_797() {
        return false;
    }

    public boolean method_798() {
        return this.binding != null ? this.binding.method_365() : (this.field_482 & 256) != 0;
    }

    public boolean method_799() {
        return this.binding != null ? this.binding.method_370() : (this.field_482 & 8) != 0;
    }

    public abstract void parseStatements(Parser var1, CompilationUnitDeclaration var2);

    public StringBuffer print(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_482, var2);
        if (this.annotations != null) {
            printAnnotations(this.annotations, var2);
        }
        TypeParameter[] var3 = this.typeParameters();
        int var4;
        if (var3 != null) {
            var2.append('<');
            var4 = var3.length - 1;
            for (int var5 = 0; var5 < var4; ++var5) {
                var3[var5].print(0, var2);
                var2.append(", ");
            }
            var3[var4].print(0, var2);
            var2.append('>');
        }
        this.printReturnType(0, var2).append(this.selector).append('(');
        if (this.arguments != null) {
            for (var4 = 0; var4 < this.arguments.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.arguments[var4].print(0, var2);
            }
        }
        var2.append(')');
        if (this.thrownExceptions != null) {
            var2.append(" throws ");
            for (var4 = 0; var4 < this.thrownExceptions.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.thrownExceptions[var4].print(0, var2);
            }
        }
        this.printBody(var1 + 1, var2);
        return var2;
    }

    public StringBuffer printBody(int var1, StringBuffer var2) {
        if (!this.method_792() && (this.field_482 & 16777216) == 0) {
            var2.append(" {");
            if (this.statements != null) {
                for (int var3 = 0; var3 < this.statements.length; ++var3) {
                    var2.append('\n');
                    this.statements[var3].printStatement(var1, var2);
                }
            }
            var2.append('\n');
            method_759(var1 == 0 ? 0 : var1 - 1, var2).append('}');
            return var2;
        } else {
            return var2.append(';');
        }
    }

    public StringBuffer printReturnType(int var1, StringBuffer var2) {
        return var2;
    }

    public void resolve(ClassScope var1) {
        if (this.binding == null) {
            this.ignoreFurtherInvestigation = true;
        }
        try {
            this.method_787();
            this.method_788();
            this.method_804();
            method_761(this.scope, this.annotations, this.binding);
            this.resolveStatements();
            if (this.binding != null && (this.binding.getAnnotationTagBits() & 70368744177664L) == 0L && (this.binding.modifiers & 1048576) != 0 && this.scope.compilerOptions().field_1928 >= 3211264L) {
                this.scope.problemReporter().method_1676(this);
            }
        } catch (AbortMethod var3) {
            this.ignoreFurtherInvestigation = true;
        }
    }

    public void method_804() {
        if (this.binding != null) {
            if (this.binding.declaringClass != null && !this.binding.declaringClass.method_158()) {
                int var1 = this.binding.modifiers & 7;
                ClassScope var2 = this.scope.method_575();
                ProblemReporter var3 = this.scope.problemReporter();
                int var4 = var3.computeSeverity(-1610612250);
                if (var4 != -1) {
                    if (var2 != null) {
                        var1 = Util.computeOuterMostVisibility(var2.referenceType(), var1);
                    }
                    int var5 = this.binding.modifiers & -8 | var1;
                }
            }
        }
    }

    public void resolveStatements() {
        if (this.statements != null) {
            int var1 = 0;
            for (int var2 = this.statements.length; var1 < var2; ++var1) {
                this.statements[var1].resolve(this.scope);
            }
        } else if ((this.field_446 & 8) != 0) {
            this.scope.problemReporter().method_1783(this.field_490 - 1, this.field_491 + 1);
        }
    }

    public void tagAsHavingErrors() {
        this.ignoreFurtherInvestigation = true;
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {}

    public TypeParameter[] typeParameters() {
        return null;
    }
}
