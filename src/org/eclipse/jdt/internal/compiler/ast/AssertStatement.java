package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class AssertStatement extends Statement {

    public Expression field_555;

    public Expression field_556;

    int preAssertInitStateIndex;

    private FieldBinding assertionSyntheticFieldBinding;

    public AssertStatement(Expression var1, Expression var2, int var3) {
        this.preAssertInitStateIndex = -1;
        this.field_555 = var2;
        this.field_556 = var1;
        this.field_444 = var3;
        this.field_445 = var1.field_445;
    }

    public AssertStatement(Expression var1, int var2) {
        this.preAssertInitStateIndex = -1;
        this.field_555 = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.preAssertInitStateIndex = var1.method_635().recordInitializationStates(var3);
        Constant var4 = this.field_555.optimizedBooleanConstant();
        boolean var5 = var4 != Constant.NotAConstant && var4.booleanValue();
        boolean var6 = var4 != Constant.NotAConstant && !var4.booleanValue();
        FlowInfo var7 = this.field_555.analyseCode(var1, var2, var3.method_3078());
        UnconditionalFlowInfo var8 = var7.method_3081().method_3109();
        UnconditionalFlowInfo var9 = var7.method_3107();
        if (var5) {
            var9.setReachMode(1);
        }
        if (this.field_556 != null) {
            FlowInfo var10 = this.field_556.analyseCode(var1, var2, var9.method_3078());
            if (!var5) {
                var2.checkExceptionHandlers(var1.method_605(), this, var10, var1);
            }
        }
        if (!var5) {
            this.manageSyntheticAccessIfNecessary(var1, var3);
        }
        return var6 ? var3 : var3.mergedWith(var9.method_3106()).method_3071(var8.method_3114());
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.assertionSyntheticFieldBinding != null) {
                BranchLabel var10000 = new BranchLabel(var2);
                BranchLabel var4 = var10000;
                var2.method_2207(this.assertionSyntheticFieldBinding);
                var2.method_2242(var4);
                Expression var6 = this.field_555;
                BranchLabel var10003 = new BranchLabel(var2);
                BranchLabel var5 = var10003;
                var6.generateOptimizedBoolean(var1, var2, var10003, (BranchLabel)null, true);
                var2.method_2346();
                var2.method_2141();
                if (this.field_556 != null) {
                    this.field_556.generateCode(var1, var2, true);
                    var2.method_2262(this.field_556.field_674 & 15);
                } else {
                    var2.method_2263();
                }
                var2.method_2107();
                if (this.preAssertInitStateIndex != -1) {
                    var2.method_2363(var1, this.preAssertInitStateIndex);
                }
                var5.place();
                var4.place();
            } else if (this.preAssertInitStateIndex != -1) {
                var2.method_2363(var1, this.preAssertInitStateIndex);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public void resolve(BlockScope var1) {
        this.field_555.resolveTypeExpecting(var1, TypeBinding.field_186);
        if (this.field_556 != null) {
            TypeBinding var2 = this.field_556.resolveType(var1);
            if (var2 != null) {
                int var3 = var2.id;
                switch (var3) {
                    case 6:
                        var1.problemReporter().method_1605(this.field_556);
                    default:
                        var3 = 1;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        this.field_556.field_674 = (var3 << 4) + var3;
                }
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_555.traverse(var1, var2);
            if (this.field_556 != null) {
                this.field_556.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }

    public void manageSyntheticAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            SourceTypeBinding var3;
            ReferenceBinding var4;
            for (var3 = var1.enclosingSourceType(); var3.method_158(); var3 = (SourceTypeBinding)var4) {
                var4 = var3.enclosingType();
                if (var4 == null || var4.method_157()) {
                    break;
                }
            }
            this.assertionSyntheticFieldBinding = var3.addSyntheticFieldForAssert(var1);
            TypeDeclaration var9 = var3.scope.referenceType();
            AbstractMethodDeclaration[] var5 = var9.methods;
            int var6 = 0;
            for (int var7 = var5.length; var6 < var7; ++var6) {
                AbstractMethodDeclaration var8 = var5[var6];
                if (var8.method_794()) {
                    ((Clinit)var8).setAssertionSupport(this.assertionSyntheticFieldBinding, var1.compilerOptions().field_1928 < 3211264L);
                    break;
                }
            }
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2);
        var2.append("assert ");
        this.field_555.printExpression(0, var2);
        if (this.field_556 != null) {
            var2.append(": ");
            this.field_556.printExpression(0, var2);
        }
        return var2.append(';');
    }
}
