package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.ConstantPool;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.InitializationFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortMethod;

public class Clinit extends AbstractMethodDeclaration {

    private FieldBinding field_495;

    private FieldBinding field_496;

    public Clinit(CompilationResult var1) {
        super(var1);
        this.field_495 = null;
        this.field_496 = null;
        this.field_482 = 0;
        this.selector = TypeConstants.field_136;
    }

    public void analyseCode(ClassScope var1, InitializationFlowContext var2, FlowInfo var3) {
        if (!this.ignoreFurtherInvestigation) {
            try {
                ExceptionHandlingFlowContext var10000 = new ExceptionHandlingFlowContext(var2.parent, this, Binding.field_151, this.scope, FlowInfo.DEAD_END);
                ExceptionHandlingFlowContext var4 = var10000;
                if ((var3.tagBits & 1) == 0) {
                    this.field_446 |= 64;
                }
                UnconditionalFlowInfo var10 = var3.mergedWith(var2.initsOnReturn);
                FieldBinding[] var5 = this.scope.enclosingSourceType().fields();
                int var6 = 0;
                for (int var7 = var5.length; var6 < var7; ++var6) {
                    FieldBinding var8;
                    if ((var8 = var5[var6]).method_431() && var8.method_409() && !var10.method_3082(var5[var6])) {
                        this.scope.problemReporter().method_1788(var8, this.scope.referenceType().declarationOf(var8.original()));
                    }
                }
                var2.checkInitializerExceptions(this.scope, var4, var10);
            } catch (AbortMethod var9) {
                this.ignoreFurtherInvestigation = true;
            }
        }
    }

    public void generateCode(ClassScope var1, ClassFile var2) {
        byte var3 = 0;
        if (!this.ignoreFurtherInvestigation) {
            try {
                int var8 = var2.field_1719;
                this.generateCode(var1, var2, var8);
            } catch (AbortMethod var7) {
                if (var7.compilationResult == CodeStream.RESTART_IN_WIDE_MODE) {
                    try {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                        var2.codeStream.field_1216 = true;
                        this.generateCode(var1, var2, var3);
                    } catch (AbortMethod var6) {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                    }
                } else {
                    var2.field_1719 = var3;
                    --var2.field_1725;
                }
            }
        }
    }

    private void generateCode(ClassScope var1, ClassFile var2, int var3) {
        ConstantPool var4 = var2.constantPool;
        int var5 = var4.field_1321;
        int var6 = var4.field_1320;
        var2.method_2997();
        int var7 = var2.field_1719;
        var2.method_2989();
        CodeStream var8 = var2.codeStream;
        this.resolve(var1);
        var8.reset(this, var2);
        TypeDeclaration var9 = var1.referenceContext;
        MethodScope var10 = var9.field_589;
        var10.computeLocalVariablePositions(0, var8);
        if (this.field_495 != null) {
            var8.generateClassLiteralAccessForType(var1.method_640().enclosingSourceType(), this.field_496);
            var8.method_2264();
            BranchLabel var10000 = new BranchLabel(var8);
            BranchLabel var11 = var10000;
            var8.method_2242(var11);
            var8.method_2222();
            var10000 = new BranchLabel(var8);
            BranchLabel var12 = var10000;
            var8.method_2125(1);
            var8.method_2209(var12);
            var11.place();
            var8.method_2221();
            var12.place();
            var8.method_2357(this.field_495);
        }
        FieldDeclaration[] var18 = var9.fields;
        BlockScope var19 = null;
        int var13;
        int var14;
        if (TypeDeclaration.kind(var9.field_577) == 3) {
            var13 = 0;
            var14 = 0;
            int var15;
            FieldDeclaration var17;
            int var16;
            if (var18 != null) {
                var15 = 0;
                for (var16 = var18.length; var15 < var16; ++var15) {
                    var17 = var18[var15];
                    if (var17.isStatic()) {
                        if (var17.getKind() == 3) {
                            var17.generateCode(var10, var8);
                            ++var13;
                        } else {
                            ++var14;
                        }
                    }
                }
            }
            var8.method_2188(var13);
            var8.method_2097(var9.binding);
            if (var13 > 0 && var18 != null) {
                var15 = 0;
                for (var16 = var18.length; var15 < var16; ++var15) {
                    var17 = var18[var15];
                    if (var17.getKind() == 3) {
                        var8.method_2141();
                        var8.method_2188(var17.binding.field_304);
                        var8.method_2207(var17.binding);
                        var8.method_2086();
                    }
                }
            }
            var8.method_2357(var9.enumValuesSyntheticfield);
            if (var14 != 0) {
                var15 = 0;
                for (var16 = var18.length; var15 < var16; ++var15) {
                    var17 = var18[var15];
                    switch (var17.getKind()) {
                        case 1:
                            if (var17.binding.method_431()) {
                                var19 = null;
                                var17.generateCode(var10, var8);
                            }
                            break;
                        case 2:
                            if (var17.isStatic()) {
                                var19 = ((Initializer)var17).block.scope;
                                var17.generateCode(var10, var8);
                            }
                        case 3:
                    }
                }
            }
        } else if (var18 != null) {
            var13 = 0;
            for (var14 = var18.length; var13 < var14; ++var13) {
                FieldDeclaration var20 = var18[var13];
                switch (var20.getKind()) {
                    case 1:
                        if (var20.binding.method_431()) {
                            var19 = null;
                            var20.generateCode(var10, var8);
                        }
                        break;
                    case 2:
                        if (var20.isStatic()) {
                            var19 = ((Initializer)var20).block.scope;
                            var20.generateCode(var10, var8);
                        }
                }
            }
        }
        if (var8.field_1208 == 0) {
            var2.field_1719 = var3;
            --var2.field_1725;
            var4.resetForClinit(var6, var5);
        } else {
            if ((this.field_446 & 64) != 0) {
                var13 = var8.field_1208;
                var8.method_2371();
                if (var19 != null) {
                    var8.method_2380(var19, var13);
                }
            }
            var8.method_2360(0, var9.field_444);
            var2.method_2980(var7);
        }
    }

    public boolean method_794() {
        return true;
    }

    public boolean method_797() {
        return true;
    }

    public boolean method_799() {
        return true;
    }

    public void parseStatements(Parser var1, CompilationUnitDeclaration var2) {}

    public StringBuffer print(int var1, StringBuffer var2) {
        method_759(var1, var2).append("<clinit>()");
        this.printBody(var1 + 1, var2);
        return var2;
    }

    public void resolve(ClassScope var1) {
        MethodScope var10001 = new MethodScope(var1, var1.referenceContext, true);
        this.scope = var10001;
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    public void setAssertionSupport(FieldBinding var1, boolean var2) {
        this.field_495 = var1;
        if (var2) {
            SourceTypeBinding var3 = this.scope.method_640().enclosingSourceType();
            if (!var3.method_157() && !var3.method_148()) {
                this.field_496 = var3.addSyntheticFieldForClassLiteral(var3, this.scope);
            }
        }
    }
}
