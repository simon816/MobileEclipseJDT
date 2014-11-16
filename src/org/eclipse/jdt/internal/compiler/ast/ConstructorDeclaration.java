package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.InitializationFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortMethod;

import java.util.ArrayList;

public class ConstructorDeclaration extends AbstractMethodDeclaration {

    public ExplicitConstructorCall constructorCall;

    public TypeParameter[] typeParameters;

    public ConstructorDeclaration(CompilationResult var1) {
        super(var1);
    }

    public void analyseCode(ClassScope var1, InitializationFlowContext var2, FlowInfo var3) {
        this.analyseCode(var1, var2, var3, 0);
    }

    public void analyseCode(ClassScope var1, InitializationFlowContext var2, FlowInfo var3, int var4) {
        if (!this.ignoreFurtherInvestigation) {
            int var5 = var3.reachMode();
            var3.setReachMode(var4);
            MethodBinding var6 = this.binding;
            if (this.binding != null && (this.field_446 & 128) == 0 && !var6.method_373()) {
                label119: {
                    if (var6.method_367()) {
                        if ((this.binding.declaringClass.tagBits & 4503599627370496L) == 0L) {
                            break label119;
                        }
                    } else if ((this.binding.declaringClass.tagBits & 48L) != 16L) {
                        break label119;
                    }
                    this.scope.problemReporter().method_1812(this);
                }
            }
            if (this.method_811((ArrayList)null)) {
                this.scope.problemReporter().recursiveConstructorInvocation(this.constructorCall);
            }
            try {
                ExceptionHandlingFlowContext var10000 = new ExceptionHandlingFlowContext(var2.parent, this, this.binding.thrownExceptions, this.scope, FlowInfo.DEAD_END);
                ExceptionHandlingFlowContext var13 = var10000;
                var2.checkInitializerExceptions(this.scope, var13, var3);
                int var8;
                if (this.binding.declaringClass.method_146()) {
                    ArrayList var7 = var13.field_1771;
                    if (var7 != null && (var8 = var7.size()) > 0) {
                        ReferenceBinding[] var9;
                        var7.toArray(var9 = new ReferenceBinding[var8]);
                        this.binding.thrownExceptions = var9;
                    }
                }
                if (this.arguments != null) {
                    int var14 = 0;
                    for (var8 = this.arguments.length; var14 < var8; ++var14) {
                        var3.method_3099(this.arguments[var14].binding);
                    }
                }
                FieldBinding var10;
                FieldBinding[] var15;
                int var17;
                if (this.constructorCall != null) {
                    if (this.constructorCall.field_551 == 3) {
                        var15 = this.binding.declaringClass.fields();
                        var8 = 0;
                        for (var17 = var15.length; var8 < var17; ++var8) {
                            if (!(var10 = var15[var8]).method_431()) {
                                var3.markAsDefinitelyAssigned(var10);
                            }
                        }
                    }
                    var3 = this.constructorCall.analyseCode(this.scope, var13, var3);
                }
                var3.setReachMode(var5);
                if (this.statements != null) {
                    boolean var16 = false;
                    var8 = 0;
                    for (var17 = this.statements.length; var8 < var17; ++var8) {
                        Statement var18 = this.statements[var8];
                        if (!var18.method_816(var3, this.scope, var16)) {
                            var3 = var18.analyseCode(this.scope, var13, var3);
                        } else {
                            var16 = true;
                        }
                    }
                }
                if ((var3.tagBits & 1) == 0) {
                    this.field_446 |= 64;
                }
                var3.setReachMode(var4);
                if (this.constructorCall != null && this.constructorCall.field_551 != 3) {
                    UnconditionalFlowInfo var12 = var3.mergedWith(var13.initsOnReturn);
                    var15 = this.binding.declaringClass.fields();
                    var8 = 0;
                    for (var17 = var15.length; var8 < var17; ++var8) {
                        if (!(var10 = var15[var8]).method_431() && var10.method_409() && !var12.method_3082(var15[var8])) {
                            ASTNode var18;
                            if ((this.field_446 & 128) != 0) {
                                var18 = this.scope.referenceType();
                            } else {
                                var18 = this;
                            }
                            this.scope.problemReporter().method_1788(var10, var18);
                        }
                    }
                }
                var13.complainIfUnusedExceptionHandlers(this);
                this.scope.checkUnusedParameters(this.binding);
            } catch (AbortMethod var11) {
                this.ignoreFurtherInvestigation = true;
            }
        }
    }

    public void generateCode(ClassScope var1, ClassFile var2) {
        byte var3 = 0;
        CategorizedProblem[] var6;
        if (this.ignoreFurtherInvestigation) {
            if (this.binding != null) {
                CategorizedProblem[] var12 = this.scope.referenceCompilationUnit().compilationResult.method_2922();
                int var4;
                var6 = new CategorizedProblem[var4 = var12.length];
                System.arraycopy(var12, 0, var6, 0, var4);
                var2.method_2967(this, this.binding, var6);
            }
        } else {
            try {
                int var11 = var2.field_1719;
                this.internalGenerateCode(var1, var2);
            } catch (AbortMethod var10) {
                CategorizedProblem[] var7;
                if (var10.compilationResult == CodeStream.RESTART_IN_WIDE_MODE) {
                    try {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                        var2.codeStream.field_1216 = true;
                        this.internalGenerateCode(var1, var2);
                    } catch (AbortMethod var9) {
                        var7 = this.scope.referenceCompilationUnit().compilationResult.method_2916();
                        int var13;
                        CategorizedProblem[] var8 = new CategorizedProblem[var13 = var7.length];
                        System.arraycopy(var7, 0, var8, 0, var13);
                        var2.method_2968(this, this.binding, var8, var3);
                    }
                } else {
                    var6 = this.scope.referenceCompilationUnit().compilationResult.method_2916();
                    int var5;
                    var7 = new CategorizedProblem[var5 = var6.length];
                    System.arraycopy(var6, 0, var7, 0, var5);
                    var2.method_2968(this, this.binding, var7, var3);
                }
            }
        }
    }

    public void generateSyntheticFieldInitializationsIfNecessary(MethodScope var1, CodeStream var2, ReferenceBinding var3) {
        if (var3.method_160()) {
            NestedTypeBinding var4 = (NestedTypeBinding)var3;
            SyntheticArgumentBinding[] var5 = var4.method_329();
            int var6 = 0;
            int var7;
            SyntheticArgumentBinding var8;
            for (var7 = var5 == null ? 0 : var5.length; var6 < var7; ++var6) {
                if ((var8 = var5[var6]).matchingField != null) {
                    var2.method_2093();
                    var2.load(var8);
                    var2.method_2356(var8.matchingField);
                }
            }
            var5 = var4.syntheticOuterLocalVariables();
            var6 = 0;
            for (var7 = var5 == null ? 0 : var5.length; var6 < var7; ++var6) {
                if ((var8 = var5[var6]).matchingField != null) {
                    var2.method_2093();
                    var2.load(var8);
                    var2.method_2356(var8.matchingField);
                }
            }
        }
    }

    private void internalGenerateCode(ClassScope var1, ClassFile var2) {
        var2.generateMethodInfoHeader(this.binding);
        int var3 = var2.field_1719;
        int var4 = var2.generateMethodInfoAttribute(this.binding);
        if (!this.binding.method_365() && !this.binding.method_356()) {
            TypeDeclaration var5 = var1.referenceContext;
            int var6 = var2.field_1719;
            var2.method_2989();
            CodeStream var7 = var2.codeStream;
            var7.reset(this, var2);
            ReferenceBinding var8 = this.binding.declaringClass;
            int var9 = var8.method_153() ? 2 : 0;
            int var10 = 1 + var9;
            if (var8.method_160()) {
                NestedTypeBinding var11 = (NestedTypeBinding)var8;
                this.scope.extraSyntheticArguments = var11.syntheticOuterLocalVariables();
                this.scope.computeLocalVariablePositions(var11.field_265 + 1 + var9, var7);
                var10 += var11.field_265;
                var10 += var11.field_266;
            } else {
                this.scope.computeLocalVariablePositions(1 + var9, var7);
            }
            if (this.arguments != null) {
                int var17 = 0;
                for (int var12 = this.arguments.length; var17 < var12; ++var17) {
                    LocalVariableBinding var13;
                    var7.method_2090(var13 = this.arguments[var17].binding);
                    var13.method_415(0);
                    TypeBinding var14 = var13.type;
                    if (var13.type != TypeBinding.field_183 && var14 != TypeBinding.field_185) {
                        ++var10;
                    } else {
                        var10 += 2;
                    }
                }
            }
            MethodScope var19 = var5.field_588;
            var19.computeLocalVariablePositions(var10, var7);
            boolean var18 = this.constructorCall == null || this.constructorCall.field_551 != 3;
            boolean var20 = this.scope.compilerOptions().field_1929 >= 3145728L;
            if (var18 && var20) {
                this.generateSyntheticFieldInitializationsIfNecessary(this.scope, var7, var8);
            }
            if (this.constructorCall != null) {
                this.constructorCall.generateCode(this.scope, var7);
            }
            int var15;
            int var21;
            if (var18) {
                if (!var20) {
                    this.generateSyntheticFieldInitializationsIfNecessary(this.scope, var7, var8);
                }
                if (var5.fields != null) {
                    var21 = 0;
                    for (var15 = var5.fields.length; var21 < var15; ++var21) {
                        FieldDeclaration var16;
                        if (!(var16 = var5.fields[var21]).isStatic()) {
                            var16.generateCode(var19, var7);
                        }
                    }
                }
            }
            if (this.statements != null) {
                var21 = 0;
                for (var15 = this.statements.length; var21 < var15; ++var21) {
                    this.statements[var21].generateCode(this.scope, var7);
                }
            }
            if (this.ignoreFurtherInvestigation) {
                AbortMethod var10000 = new AbortMethod(this.scope.referenceCompilationUnit().compilationResult, (CategorizedProblem)null);
                throw var10000;
            }
            if ((this.field_446 & 64) != 0) {
                var7.method_2371();
            }
            var7.exitUserScope(this.scope);
            var7.method_2360(0, this.field_491);
            var2.method_2979(var6);
            ++var4;
        }
        var2.method_2986(var3, var4);
    }

    public boolean method_795() {
        return true;
    }

    public boolean method_796() {
        return (this.field_446 & 128) != 0;
    }

    public boolean method_797() {
        return true;
    }

    public boolean method_811(ArrayList var1) {
        if (this.binding != null && this.constructorCall != null && this.constructorCall.binding != null && !this.constructorCall.isSuperAccess() && this.constructorCall.binding.isValidBinding()) {
            ConstructorDeclaration var2 = (ConstructorDeclaration)this.scope.referenceType().declarationOf(this.constructorCall.binding.original());
            if (this == var2) {
                return true;
            } else {
                if (var1 == null) {
                    ArrayList var10000 = new ArrayList(1);
                    var1 = var10000;
                } else {
                    int var3 = var1.indexOf(this);
                    if (var3 >= 0) {
                        return var3 == 0;
                    }
                }
                var1.add(this);
                return var2.method_811(var1);
            }
        } else {
            return false;
        }
    }

    public void parseStatements(Parser var1, CompilationUnitDeclaration var2) {
        if ((this.field_446 & 128) != 0 && this.constructorCall == null) {
            this.constructorCall = SuperReference.implicitSuperConstructorCall();
            this.constructorCall.field_444 = this.field_444;
            this.constructorCall.field_445 = this.field_445;
        } else {
            var1.parse(this, var2, false);
        }
    }

    public StringBuffer printBody(int var1, StringBuffer var2) {
        var2.append(" {");
        if (this.constructorCall != null) {
            var2.append('\n');
            this.constructorCall.printStatement(var1, var2);
        }
        if (this.statements != null) {
            for (int var3 = 0; var3 < this.statements.length; ++var3) {
                var2.append('\n');
                this.statements[var3].printStatement(var1, var2);
            }
        }
        var2.append('\n');
        method_759(var1 == 0 ? 0 : var1 - 1, var2).append('}');
        return var2;
    }

    public void method_804() {}

    public void resolveStatements() {
        SourceTypeBinding var1 = this.scope.enclosingSourceType();
        if (!CharOperation.method_1364(var1.sourceName, this.selector)) {
            this.scope.problemReporter().method_1680(this);
        }
        if (this.typeParameters != null) {
            int var2 = 0;
            for (int var3 = this.typeParameters.length; var2 < var3; ++var2) {
                this.typeParameters[var2].resolve(this.scope);
            }
        }
        if (this.binding != null && !this.binding.method_367()) {
            var1.tagBits |= 4503599627370496L;
        }
        if (this.constructorCall != null) {
            if (var1.id == 1 && this.constructorCall.field_551 != 3) {
                if (this.constructorCall.field_551 == 2) {
                    this.scope.problemReporter().method_1506(this.constructorCall);
                }
                this.constructorCall = null;
            } else {
                this.constructorCall.resolve(this.scope);
            }
        }
        if ((this.field_482 & 16777216) != 0) {
            this.scope.problemReporter().method_1672(this);
        }
        super.resolveStatements();
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
            if (this.constructorCall != null) {
                this.constructorCall.traverse(var1, this.scope);
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
