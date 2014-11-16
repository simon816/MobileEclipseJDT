package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.codegen.CaseLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.SwitchFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class SwitchStatement extends Statement {

    public Expression expression;

    public Statement[] statements;

    public BlockScope scope;

    public int field_605;

    public BranchLabel breakLabel;

    public CaseStatement[] field_607;

    public CaseStatement defaultCase;

    public int field_609;

    public int field_610;

    int[] constants;

    public SyntheticMethodBinding synthetic;

    int field_613;

    int field_614;

    public SwitchStatement() {
        this.field_613 = -1;
        this.field_614 = -1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        UnconditionalFlowInfo var17;
        try {
            var3 = this.expression.analyseCode(var1, var2, var3);
            BranchLabel var10005 = new BranchLabel();
            SwitchFlowContext var10000 = new SwitchFlowContext(var2, this, this.breakLabel = var10005);
            SwitchFlowContext var4 = var10000;
            Object var5 = FlowInfo.DEAD_END;
            this.field_613 = var1.method_635().recordInitializationStates(var3);
            int var6 = 0;
            if (this.statements != null) {
                boolean var7 = false;
                boolean var8 = false;
                int var9 = 0;
                for (int var10 = this.statements.length; var9 < var10; ++var9) {
                    Statement var11 = this.statements[var9];
                    if (var6 < this.field_610 && var11 == this.field_607[var6]) {
                        this.scope.enclosingCase = this.field_607[var6];
                        ++var6;
                        if (var8 && (var11.field_446 & 536870912) == 0) {
                            this.scope.problemReporter().method_1739(this.scope.enclosingCase);
                        }
                        var5 = ((FlowInfo)var5).mergedWith(var3.method_3109());
                        var7 = false;
                        var8 = false;
                    } else if (var11 == this.defaultCase) {
                        this.scope.enclosingCase = this.defaultCase;
                        if (var8 && (var11.field_446 & 536870912) == 0) {
                            this.scope.problemReporter().method_1739(this.scope.enclosingCase);
                        }
                        var5 = ((FlowInfo)var5).mergedWith(var3.method_3109());
                        var7 = false;
                        var8 = false;
                    } else {
                        var8 = true;
                    }
                    if (!var11.method_816((FlowInfo)var5, this.scope, var7)) {
                        var5 = var11.analyseCode(this.scope, var4, (FlowInfo)var5);
                        if (var5 == FlowInfo.DEAD_END) {
                            var8 = true;
                        }
                    } else {
                        var7 = true;
                    }
                }
            }
            TypeBinding var15 = this.expression.resolvedType;
            if (this.field_610 > 0 && var15.method_153()) {
                SourceTypeBinding var18 = this.scope.method_575().referenceContext.binding;
                this.synthetic = var18.addSyntheticMethodForSwitchEnum(var15);
            }
            if (this.defaultCase == null) {
                var3.method_3072(((FlowInfo)var5).mergedWith(var4.initsOnBreak));
                this.field_614 = var1.method_635().recordInitializationStates(var3);
                FlowInfo var19 = var3;
                return var19;
            }
            UnconditionalFlowInfo var16 = ((FlowInfo)var5).mergedWith(var4.initsOnBreak);
            this.field_614 = var1.method_635().recordInitializationStates(var16);
            var17 = var16;
        } finally {
            if (this.scope != null) {
                this.scope.enclosingCase = null;
            }
        }
        return var17;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        try {
            if ((this.field_446 & Integer.MIN_VALUE) == 0) {
                return;
            }
            int var3 = var2.field_1208;
            this.breakLabel.initialize(var2);
            CaseLabel[] var4 = new CaseLabel[this.field_610];
            boolean var5 = this.field_610 != 0;
            for (int var6 = 0; var6 < this.field_610; ++var6) {
                CaseStatement var10000 = this.field_607[var6];
                CaseLabel var10003 = new CaseLabel(var2);
                var10000.targetLabel = var4[var6] = var10003;
                var4[var6].tagBits |= 2;
            }
            CaseLabel var15 = new CaseLabel(var2);
            CaseLabel var16 = var15;
            if (var5) {
                var16.tagBits |= 2;
            }
            if (this.defaultCase != null) {
                this.defaultCase.targetLabel = var16;
            }
            TypeBinding var7 = this.expression.resolvedType;
            if (var7.method_153()) {
                if (var5) {
                    var2.method_2273(this.synthetic);
                    this.expression.generateCode(var1, var2, true);
                    var2.invokeEnumOrdinal(var7.constantPoolName());
                    var2.method_2218();
                } else {
                    this.expression.generateCode(var1, var2, false);
                }
            } else {
                this.expression.generateCode(var1, var2, var5);
            }
            int var9;
            int var10;
            if (var5) {
                int[] var8 = new int[this.field_610];
                for (var9 = 0; var9 < this.field_610; var8[var9] = var9++) {
                    ;
                }
                int[] var18;
                System.arraycopy(this.constants, 0, var18 = new int[this.field_610], 0, this.field_610);
                CodeStream.sort(var18, 0, this.field_610 - 1, var8);
                var10 = var18[this.field_610 - 1];
                int var11 = var18[0];
                if ((long)((double)this.field_610 * 2.5D) > (long)var10 - (long)var11) {
                    if (var10 > 2147418112 && var1.compilerOptions().field_1927 < 3145728L) {
                        var2.lookupswitch(var16, this.constants, var8, var4);
                    } else {
                        var2.tableswitch(var16, var11, var10, this.constants, var8, var4);
                    }
                } else {
                    var2.lookupswitch(var16, this.constants, var8, var4);
                }
                var2.method_2380(this.scope, var2.field_1208);
            }
            int var17 = 0;
            if (this.statements != null) {
                var9 = 0;
                for (var10 = this.statements.length; var9 < var10; ++var9) {
                    Statement var19 = this.statements[var9];
                    if (var17 < this.field_610 && var19 == this.field_607[var17]) {
                        this.scope.enclosingCase = this.field_607[var17];
                        if (this.field_613 != -1) {
                            var2.method_2363(var1, this.field_613);
                        }
                        ++var17;
                    } else if (var19 == this.defaultCase) {
                        this.scope.enclosingCase = this.defaultCase;
                        if (this.field_613 != -1) {
                            var2.method_2363(var1, this.field_613);
                        }
                    }
                    var19.generateCode(this.scope, var2);
                }
            }
            if (this.field_614 != -1) {
                var2.method_2363(var1, this.field_614);
                var2.method_2088(var1, this.field_614);
            }
            if (this.scope != var1) {
                var2.exitUserScope(this.scope);
            }
            this.breakLabel.place();
            if (this.defaultCase == null) {
                var2.recordPositionsFrom(var2.field_1208, this.field_445, true);
                var16.place();
            }
            var2.method_2360(var3, this.field_444);
        } finally {
            if (this.scope != null) {
                this.scope.enclosingCase = null;
            }
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("switch (");
        this.expression.printExpression(0, var2).append(") {");
        if (this.statements != null) {
            for (int var3 = 0; var3 < this.statements.length; ++var3) {
                var2.append('\n');
                if (this.statements[var3] instanceof CaseStatement) {
                    this.statements[var3].printStatement(var1, var2);
                } else {
                    this.statements[var3].printStatement(var1 + 2, var2);
                }
            }
        }
        var2.append("\n");
        return method_759(var1, var2).append('}');
    }

    public void resolve(BlockScope var1) {
        try {
            boolean var2 = false;
            TypeBinding var3 = this.expression.resolveType(var1);
            if (var3 != null) {
                this.expression.computeConversion(var1, var3, var3);
                if (!var3.isValidBinding()) {
                    var3 = null;
                } else {
                    label276: {
                        if (var3.method_148()) {
                            if (this.expression.isConstantValueOfTypeAssignableToType(var3, TypeBinding.field_179) || var3.isCompatibleWith(TypeBinding.field_179)) {
                                break label276;
                            }
                        } else {
                            if (var3.method_153()) {
                                var2 = true;
                                break label276;
                            }
                            if (var1.isBoxingCompatibleWith(var3, TypeBinding.field_179)) {
                                this.expression.computeConversion(var1, TypeBinding.field_179, var3);
                                break label276;
                            }
                        }
                        var1.problemReporter().method_1611(this.expression, var3);
                        var3 = null;
                    }
                }
            }
            int var4;
            int var6;
            int var7;
            if (this.statements != null) {
                BlockScope var10001 = new BlockScope(var1);
                this.scope = var10001;
                this.field_607 = new CaseStatement[var4 = this.statements.length];
                this.constants = new int[var4];
                CaseStatement[] var5 = null;
                var6 = 0;
                var7 = 0;
                for (int var8 = 0; var8 < var4; ++var8) {
                    Statement var10 = this.statements[var8];
                    Constant var9;
                    if ((var9 = var10.resolveCase(this.scope, var3, this)) != Constant.NotAConstant) {
                        int var11 = var9.intValue();
                        for (int var12 = 0; var12 < var7; ++var12) {
                            if (this.constants[var12] == var11) {
                                CaseStatement var13 = (CaseStatement)var10;
                                if (var5 == null) {
                                    this.scope.problemReporter().method_1521(this.field_607[var12]);
                                    this.scope.problemReporter().method_1521(var13);
                                    var5 = new CaseStatement[var4];
                                    var5[var6++] = this.field_607[var12];
                                    var5[var6++] = var13;
                                } else {
                                    boolean var14 = false;
                                    for (int var15 = 2; var15 < var6; ++var15) {
                                        if (var5[var15] == var10) {
                                            var14 = true;
                                            break;
                                        }
                                    }
                                    if (!var14) {
                                        this.scope.problemReporter().method_1521(var13);
                                        var5[var6++] = var13;
                                    }
                                }
                            }
                        }
                        this.constants[var7++] = var11;
                    }
                }
                if (var4 != var7) {
                    System.arraycopy(this.constants, 0, this.constants = new int[var7], 0, var7);
                }
            } else if ((this.field_446 & 8) != 0) {
                var1.problemReporter().method_1783(this.field_609, this.field_445);
            }
            if (var2 && this.defaultCase == null && var1.compilerOptions().method_3313(2199023255552L) != -1) {
                var4 = this.constants == null ? 0 : this.constants.length;
                if (var4 == this.field_610 && this.field_610 != ((ReferenceBinding)var3).method_202()) {
                    FieldBinding[] var20 = ((ReferenceBinding)var3.erasure()).fields();
                    var6 = 0;
                    label231:
                    for (var7 = var20.length; var6 < var7; ++var6) {
                        FieldBinding var21 = var20[var6];
                        if ((var21.field_300 & 16384) != 0) {
                            for (int var22 = 0; var22 < this.field_610; ++var22) {
                                if (var21.field_304 + 1 == this.constants[var22]) {
                                    continue label231;
                                }
                            }
                            var1.problemReporter().missingEnumConstantCase(this, var21);
                        }
                    }
                }
            }
        } finally {
            if (this.scope != null) {
                this.scope.enclosingCase = null;
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.expression.traverse(var1, this.scope);
            if (this.statements != null) {
                int var3 = this.statements.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.statements[var4].traverse(var1, this.scope);
                }
            }
        }
        var1.endVisit(this, var2);
    }

    public void branchChainTo(BranchLabel var1) {
        if (this.breakLabel.forwardReferenceCount() > 0) {
            var1.becomeDelegateFor(this.breakLabel);
        }
    }
}
