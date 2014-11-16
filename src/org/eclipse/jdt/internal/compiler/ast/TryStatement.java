package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream;
import org.eclipse.jdt.internal.compiler.codegen.ExceptionLabel;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;
import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.flow.NullInfoRegistry;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class TryStatement extends SubRoutineStatement {

    private static final char[] field_616;

    private static final char[] field_617;

    private static final char[] field_618;

    public Block field_619;

    public Block[] catchBlocks;

    public Argument[] catchArguments;

    public Block field_622;

    BlockScope scope;

    public UnconditionalFlowInfo subRoutineInits;

    ReferenceBinding[] caughtExceptionTypes;

    boolean[] catchExits;

    BranchLabel subRoutineStartLabel;

    public LocalVariableBinding field_628;

    public LocalVariableBinding field_629;

    public LocalVariableBinding field_630;

    ExceptionLabel[] declaredExceptionLabels;

    private Object[] reusableJSRTargets;

    private BranchLabel[] reusableJSRSequenceStartLabels;

    private int[] reusableJSRStateIndexes;

    private int reusableJSRTargetsCount;

    int field_636;

    int field_637;

    int field_638;

    int[] catchExitInitStateIndexes;

    public TryStatement() {
        this.reusableJSRTargetsCount = 0;
        this.field_636 = -1;
        this.field_637 = -1;
        this.field_638 = -1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.field_637 = var1.method_635().recordInitializationStates(var3);
        if (this.field_628 != null) {
            this.field_628.field_307 = 1;
        }
        if (this.field_629 != null) {
            this.field_629.field_307 = 1;
        }
        Object var8;
        NullInfoRegistry var10001;
        ExceptionHandlingFlowContext var14;
        if (this.subRoutineStartLabel == null) {
            var14 = new ExceptionHandlingFlowContext(var2, this, this.caughtExceptionTypes, this.scope, var3.method_3109());
            ExceptionHandlingFlowContext var15 = var14;
            var10001 = new NullInfoRegistry(var3.method_3109());
            var15.initsOnFinally = var10001;
            Object var16;
            if (this.field_619.isEmptyBlock()) {
                var16 = var3;
            } else {
                var16 = this.field_619.analyseCode(var1, var15, var3.method_3078());
                if ((((FlowInfo)var16).tagBits & 1) != 0) {
                    this.field_446 |= 536870912;
                }
            }
            var15.complainIfUnusedExceptionHandlers(this.scope, this);
            if (this.catchArguments != null) {
                int var17;
                this.catchExits = new boolean[var17 = this.catchBlocks.length];
                this.catchExitInitStateIndexes = new int[var17];
                for (int var18 = 0; var18 < var17; ++var18) {
                    if (this.caughtExceptionTypes[var18].isUncheckedException(true)) {
                        var8 = var15.initsOnFinally.mitigateNullInfoOf(var3.method_3107().method_3072(var15.initsOnException(this.caughtExceptionTypes[var18])).method_3072((FlowInfo)var16).method_3072(var15.initsOnReturn));
                    } else {
                        var8 = var3.method_3107().method_3072(var15.initsOnException(this.caughtExceptionTypes[var18])).method_3072(((FlowInfo)var16).method_3106()).method_3072(var15.initsOnReturn.method_3106());
                    }
                    LocalVariableBinding var20 = this.catchArguments[var18].binding;
                    ((FlowInfo)var8).method_3099(var20);
                    ((FlowInfo)var8).method_3097(var20);
                    if (this.field_619.statements == null) {
                        ((FlowInfo)var8).setReachMode(1);
                    }
                    FlowInfo var21 = this.catchBlocks[var18].analyseCode(var1, var2, (FlowInfo)var8);
                    this.catchExitInitStateIndexes[var18] = var1.method_635().recordInitializationStates(var21);
                    this.catchExits[var18] = (var21.tagBits & 1) != 0;
                    var16 = ((FlowInfo)var16).mergedWith(var21.method_3109());
                }
            }
            this.field_636 = var1.method_635().recordInitializationStates((FlowInfo)var16);
            if (var2.initsOnFinally != null) {
                var2.initsOnFinally.add(var15.initsOnFinally);
            }
            return (FlowInfo)var16;
        } else {
            InsideSubRoutineFlowContext var10000 = new InsideSubRoutineFlowContext(var2, this);
            InsideSubRoutineFlowContext var4 = var10000;
            Block var13 = this.field_622;
            FinallyFlowContext var10002 = new FinallyFlowContext(var2, this.field_622);
            FinallyFlowContext var5 = var10002;
            UnconditionalFlowInfo var6 = var13.analyseCode(var1, var10002, var3.method_3106()).method_3109();
            if (var6 == FlowInfo.DEAD_END) {
                this.field_446 |= 16384;
                this.scope.problemReporter().finallyMustCompleteNormally(this.field_622);
            }
            this.subRoutineInits = var6;
            var14 = new ExceptionHandlingFlowContext(var4, this, this.caughtExceptionTypes, this.scope, var3.method_3109());
            ExceptionHandlingFlowContext var7 = var14;
            var10001 = new NullInfoRegistry(var3.method_3109());
            var7.initsOnFinally = var10001;
            if (this.field_619.isEmptyBlock()) {
                var8 = var3;
            } else {
                var8 = this.field_619.analyseCode(var1, var7, var3.method_3078());
                if ((((FlowInfo)var8).tagBits & 1) != 0) {
                    this.field_446 |= 536870912;
                }
            }
            var7.complainIfUnusedExceptionHandlers(this.scope, this);
            if (this.catchArguments != null) {
                int var9;
                this.catchExits = new boolean[var9 = this.catchBlocks.length];
                this.catchExitInitStateIndexes = new int[var9];
                for (int var10 = 0; var10 < var9; ++var10) {
                    Object var11;
                    if (this.caughtExceptionTypes[var10].isUncheckedException(true)) {
                        var11 = var7.initsOnFinally.mitigateNullInfoOf(var3.method_3107().method_3072(var7.initsOnException(this.caughtExceptionTypes[var10])).method_3072((FlowInfo)var8).method_3072(var7.initsOnReturn));
                    } else {
                        var11 = var3.method_3107().method_3072(var7.initsOnException(this.caughtExceptionTypes[var10])).method_3072(((FlowInfo)var8).method_3106()).method_3072(var7.initsOnReturn.method_3106());
                    }
                    LocalVariableBinding var12 = this.catchArguments[var10].binding;
                    ((FlowInfo)var11).method_3099(var12);
                    ((FlowInfo)var11).method_3097(var12);
                    if (this.field_619.statements == null) {
                        ((FlowInfo)var11).setReachMode(1);
                    }
                    FlowInfo var22 = this.catchBlocks[var10].analyseCode(var1, var4, (FlowInfo)var11);
                    this.catchExitInitStateIndexes[var10] = var1.method_635().recordInitializationStates(var22);
                    this.catchExits[var10] = (var22.tagBits & 1) != 0;
                    var8 = ((FlowInfo)var8).mergedWith(var22.method_3109());
                }
            }
            var5.complainOnDeferredChecks(var7.initsOnFinally.mitigateNullInfoOf((FlowInfo)((((FlowInfo)var8).tagBits & 1) == 0 ? var3.method_3107().method_3072((FlowInfo)var8).method_3072(var4.initsOnReturn) : var4.initsOnReturn)), var1);
            if (var2.initsOnFinally != null) {
                var2.initsOnFinally.add(var7.initsOnFinally);
            }
            this.field_638 = var1.method_635().recordInitializationStates((FlowInfo)var8);
            if (var6 == FlowInfo.DEAD_END) {
                this.field_636 = var1.method_635().recordInitializationStates(var6);
                return var6;
            } else {
                FlowInfo var19 = ((FlowInfo)var8).method_3071(var6);
                this.field_636 = var1.method_635().recordInitializationStates(var19);
                return var19;
            }
        }
    }

    public ExceptionLabel enterAnyExceptionHandler(CodeStream var1) {
        return this.subRoutineStartLabel == null ? null : super.enterAnyExceptionHandler(var1);
    }

    public void method_873(CodeStream var1) {
        int var2 = 0;
        for (int var3 = this.declaredExceptionLabels == null ? 0 : this.declaredExceptionLabels.length; var2 < var3; ++var2) {
            this.declaredExceptionLabels[var2].method_449();
        }
    }

    public void exitAnyExceptionHandler() {
        if (this.subRoutineStartLabel != null) {
            super.exitAnyExceptionHandler();
        }
    }

    public void method_878(CodeStream var1) {
        int var2 = 0;
        for (int var3 = this.declaredExceptionLabels == null ? 0 : this.declaredExceptionLabels.length; var2 < var3; ++var2) {
            this.declaredExceptionLabels[var2].method_448();
        }
    }

    private int finallyMode() {
        return this.subRoutineStartLabel == null ? 0 : (this.isSubRoutineEscaping() ? 2 : (this.scope.compilerOptions().field_1957 ? 3 : 1));
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            boolean var3 = var2 instanceof StackMapFrameCodeStream;
            this.anyExceptionLabel = null;
            this.reusableJSRTargets = null;
            this.reusableJSRSequenceStartLabels = null;
            this.reusableJSRTargetsCount = 0;
            int var4 = var2.field_1208;
            int var5 = this.finallyMode();
            boolean var6 = false;
            int var7 = this.catchArguments == null ? 0 : this.catchArguments.length;
            ExceptionLabel[] var8;
            ExceptionLabel var10000;
            if (var7 > 0) {
                var8 = new ExceptionLabel[var7];
                for (int var9 = 0; var9 < var7; ++var9) {
                    var10000 = new ExceptionLabel(var2, this.catchArguments[var9].binding.type);
                    ExceptionLabel var10 = var10000;
                    var10.method_449();
                    var8[var9] = var10;
                }
            } else {
                var8 = null;
            }
            if (this.subRoutineStartLabel != null) {
                this.subRoutineStartLabel.initialize(var2);
                this.enterAnyExceptionHandler(var2);
            }
            try {
                this.declaredExceptionLabels = var8;
                this.field_619.generateCode(this.scope, var2);
            } finally {
                this.declaredExceptionLabels = null;
            }
            boolean var18 = var2.field_1208 != var4;
            if (var18) {
                BranchLabel var17 = new BranchLabel(var2);
                BranchLabel var19 = var17;
                BranchLabel var11 = null;
                int var12;
                for (var12 = 0; var12 < var7; ++var12) {
                    var8[var12].method_448();
                }
                if ((this.field_446 & 536870912) == 0) {
                    var12 = var2.field_1208;
                    switch (var5) {
                        case 0:
                            if (this.field_638 != -1) {
                                var2.method_2363(var1, this.field_638);
                                var2.method_2088(var1, this.field_638);
                            }
                            var2.method_2209(var19);
                            break;
                        case 1:
                        case 3:
                            var6 = true;
                            if (this.field_638 != -1) {
                                var2.method_2363(var1, this.field_638);
                                var2.method_2088(var1, this.field_638);
                            }
                            var2.method_2209(var19);
                            break;
                        case 2:
                            var2.method_2209(this.subRoutineStartLabel);
                    }
                    var2.method_2380(this.field_619.scope, var12);
                }
                this.exitAnyExceptionHandler();
                int var14;
                if (this.catchArguments != null) {
                    var17 = new BranchLabel(var2);
                    var11 = var17;
                    for (var12 = 0; var12 < var7; ++var12) {
                        if (var8[var12].count != 0) {
                            this.enterAnyExceptionHandler(var2);
                            if (this.field_637 != -1) {
                                var2.method_2363(var1, this.field_637);
                                var2.method_2088(var1, this.field_637);
                            }
                            var2.method_2355(var8[var12].exceptionType);
                            var8[var12].method_447();
                            var14 = var2.field_1208;
                            LocalVariableBinding var13;
                            if ((var13 = this.catchArguments[var12].binding).field_306 != -1) {
                                var2.store(var13, false);
                                var13.method_415(var2.field_1208);
                                var2.method_2090(var13);
                            } else {
                                var2.method_2352();
                            }
                            var2.method_2360(var14, this.catchArguments[var12].field_444);
                            this.catchBlocks[var12].generateCode(this.scope, var2);
                            this.exitAnyExceptionHandler();
                            if (!this.catchExits[var12]) {
                                switch (var5) {
                                    case 1:
                                        var6 = true;
                                    case 0:
                                        if (this.field_638 != -1) {
                                            var2.method_2363(var1, this.field_638);
                                            var2.method_2088(var1, this.field_638);
                                        }
                                        var2.method_2209(var19);
                                        break;
                                    case 2:
                                        var2.method_2209(this.subRoutineStartLabel);
                                        break;
                                    case 3:
                                        if (var3) {
                                            ((StackMapFrameCodeStream)var2).method_2401(this.field_638);
                                        }
                                        if (this.catchExitInitStateIndexes[var12] != -1) {
                                            var2.method_2363(var1, this.catchExitInitStateIndexes[var12]);
                                            var2.method_2088(var1, this.catchExitInitStateIndexes[var12]);
                                        }
                                        this.field_622.generateCode(this.scope, var2);
                                        var2.method_2209(var11);
                                        if (var3) {
                                            ((StackMapFrameCodeStream)var2).method_2400();
                                        }
                                }
                            }
                        }
                    }
                }
                if (var6 && var5 == 1) {
                    var10000 = new ExceptionLabel(var2, (TypeBinding)null);
                } else {
                    var10000 = null;
                }
                ExceptionLabel var20 = var10000;
                int var21 = var2.field_1208;
                if (this.subRoutineStartLabel != null && this.anyExceptionLabel.count != 0) {
                    var2.method_2355(this.scope.method_611());
                    if (this.field_637 != -1) {
                        var2.method_2363(var1, this.field_637);
                        var2.method_2088(var1, this.field_637);
                    }
                    this.method_877();
                    if (var20 != null) {
                        var20.method_447();
                    }
                    switch (var5) {
                        case 1:
                            var2.store(this.field_628, false);
                            var2.method_2297(this.subRoutineStartLabel);
                            var2.method_2360(var21, this.field_622.field_444);
                            var14 = var2.field_1208;
                            var2.method_2379(this.field_628);
                            var2.method_2360(var14, this.field_622.field_445);
                            this.subRoutineStartLabel.place();
                            var2.method_2355(this.scope.method_611());
                            var14 = var2.field_1208;
                            var2.store(this.field_629, false);
                            var2.method_2360(var14, this.field_622.field_444);
                            this.field_622.generateCode(this.scope, var2);
                            var14 = var2.field_1208;
                            var2.ret(this.field_629.field_306);
                            var2.method_2360(var14, this.field_622.field_445);
                            break;
                        case 2:
                            var2.method_2352();
                            this.subRoutineStartLabel.place();
                            var2.method_2360(var21, this.field_622.field_444);
                            this.field_622.generateCode(this.scope, var2);
                            break;
                        case 3:
                            var2.store(this.field_628, false);
                            var2.addVariable(this.field_628);
                            var2.method_2360(var21, this.field_622.field_444);
                            this.field_622.generateCode(var1, var2);
                            var14 = var2.field_1208;
                            var2.method_2379(this.field_628);
                            var2.method_2365(this.field_628);
                            if (this.field_637 != -1) {
                                var2.method_2363(var1, this.field_637);
                            }
                            this.subRoutineStartLabel.place();
                            var2.method_2360(var14, this.field_622.field_445);
                    }
                    if (var6) {
                        switch (var5) {
                            case 1:
                                var19.place();
                                var14 = var2.field_1208;
                                var20.method_449();
                                var2.method_2297(this.subRoutineStartLabel);
                                var20.method_448();
                                var2.method_2360(var14, this.field_622.field_445);
                            case 2:
                                break;
                            case 3:
                                if (var3) {
                                    ((StackMapFrameCodeStream)var2).method_2401(this.field_638);
                                }
                                if (this.field_638 != -1) {
                                    var2.method_2363(var1, this.field_638);
                                    var2.method_2088(var1, this.field_638);
                                }
                                var19.place();
                                this.field_622.generateCode(this.scope, var2);
                                if (var11 != null) {
                                    var14 = var2.field_1208;
                                    var2.method_2209(var11);
                                    var2.method_2360(var14, this.field_622.field_445);
                                }
                                if (var3) {
                                    ((StackMapFrameCodeStream)var2).method_2400();
                                }
                                break;
                            default:
                                var19.place();
                        }
                    }
                    if (var11 != null) {
                        var11.place();
                    }
                } else {
                    var19.place();
                }
            } else if (this.subRoutineStartLabel != null) {
                this.field_622.generateCode(this.scope, var2);
            }
            if (this.field_636 != -1) {
                var2.method_2363(var1, this.field_636);
                var2.method_2088(var1, this.field_636);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public boolean generateSubRoutineInvocation(BlockScope var1, CodeStream var2, Object var3, int var4, LocalVariableBinding var5) {
        boolean var6 = var2 instanceof StackMapFrameCodeStream;
        int var7 = this.finallyMode();
        switch (var7) {
            case 0:
                this.method_878(var2);
                return false;
            case 2:
                var2.method_2209(this.subRoutineStartLabel);
                return true;
            default:
                if (var3 != null) {
                    boolean var8 = true;
                    if (this.reusableJSRTargetsCount > 0) {
                        int var9 = 0;
                        for (int var10 = this.reusableJSRTargetsCount; var9 < var10; ++var9) {
                            Object var11 = this.reusableJSRTargets[var9];
                            if (var3 == var11 || var3 instanceof Constant && var11 instanceof Constant && ((Constant)var3).hasSameValue((Constant)var11)) {
                                if (this.reusableJSRStateIndexes[var9] == var4 || var7 != 3 || !var6) {
                                    var2.method_2209(this.reusableJSRSequenceStartLabels[var9]);
                                    return true;
                                }
                                var8 = false;
                                break;
                            }
                        }
                    } else {
                        this.reusableJSRTargets = new Object[3];
                        this.reusableJSRSequenceStartLabels = new BranchLabel[3];
                        this.reusableJSRStateIndexes = new int[3];
                    }
                    if (var8) {
                        if (this.reusableJSRTargetsCount == this.reusableJSRTargets.length) {
                            System.arraycopy(this.reusableJSRTargets, 0, this.reusableJSRTargets = new Object[2 * this.reusableJSRTargetsCount], 0, this.reusableJSRTargetsCount);
                            System.arraycopy(this.reusableJSRSequenceStartLabels, 0, this.reusableJSRSequenceStartLabels = new BranchLabel[2 * this.reusableJSRTargetsCount], 0, this.reusableJSRTargetsCount);
                            System.arraycopy(this.reusableJSRStateIndexes, 0, this.reusableJSRStateIndexes = new int[2 * this.reusableJSRTargetsCount], 0, this.reusableJSRTargetsCount);
                        }
                        this.reusableJSRTargets[this.reusableJSRTargetsCount] = var3;
                        BranchLabel var10000 = new BranchLabel(var2);
                        BranchLabel var12 = var10000;
                        var12.place();
                        this.reusableJSRStateIndexes[this.reusableJSRTargetsCount] = var4;
                        this.reusableJSRSequenceStartLabels[this.reusableJSRTargetsCount++] = var12;
                    }
                }
                if (var7 == 3) {
                    if (var6) {
                        ((StackMapFrameCodeStream)var2).method_2401(var4);
                        if (this.field_638 != -1 || var4 != -1) {
                            var2.method_2363(var1, this.field_638);
                            var2.method_2088(var1, this.field_638);
                        }
                    } else if (this.field_638 != -1) {
                        var2.method_2363(var1, this.field_638);
                        var2.method_2088(var1, this.field_638);
                    }
                    if (var5 != null) {
                        var2.addVariable(var5);
                    }
                    this.exitAnyExceptionHandler();
                    this.method_878(var2);
                    this.field_622.generateCode(var1, var2);
                    if (var6) {
                        ((StackMapFrameCodeStream)var2).method_2400();
                    }
                } else {
                    var2.method_2297(this.subRoutineStartLabel);
                    this.exitAnyExceptionHandler();
                    this.method_878(var2);
                }
                return false;
        }
    }

    public boolean isSubRoutineEscaping() {
        return (this.field_446 & 16384) != 0;
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("try \n");
        this.field_619.printStatement(var1 + 1, var2);
        if (this.catchBlocks != null) {
            for (int var3 = 0; var3 < this.catchBlocks.length; ++var3) {
                var2.append('\n');
                method_759(var1, var2).append("catch (");
                this.catchArguments[var3].print(0, var2).append(") ");
                this.catchBlocks[var3].printStatement(var1 + 1, var2);
            }
        }
        if (this.field_622 != null) {
            var2.append('\n');
            method_759(var1, var2).append("finally\n");
            this.field_622.printStatement(var1 + 1, var2);
        }
        return var2;
    }

    public void resolve(BlockScope var1) {
        BlockScope var10001 = new BlockScope(var1);
        this.scope = var10001;
        BlockScope var10000 = new BlockScope(this.scope);
        BlockScope var2 = var10000;
        BlockScope var3 = null;
        if (this.field_622 != null) {
            if (this.field_622.isEmptyBlock()) {
                if ((this.field_622.field_446 & 8) != 0) {
                    this.scope.problemReporter().method_1783(this.field_622.field_444, this.field_622.field_445);
                }
            } else {
                var10000 = new BlockScope(this.scope, false);
                var3 = var10000;
                MethodScope var4 = this.scope.method_635();
                LocalVariableBinding var10;
                if (!var1.compilerOptions().field_1957) {
                    var10 = new LocalVariableBinding(field_616, var1.method_609(), 0, false);
                    this.field_629 = var10;
                    var3.addLocalVariable(this.field_629);
                    this.field_629.setConstant(Constant.NotAConstant);
                }
                BranchLabel var9 = new BranchLabel();
                this.subRoutineStartLabel = var9;
                var10 = new LocalVariableBinding(field_617, this.scope.method_611(), 0, false);
                this.field_628 = var10;
                var3.addLocalVariable(this.field_628);
                this.field_628.setConstant(Constant.NotAConstant);
                if (!var4.method_727()) {
                    MethodBinding var5 = ((AbstractMethodDeclaration)var4.referenceContext).binding;
                    if (var5 != null) {
                        TypeBinding var6 = var5.returnType;
                        if (var6.id != 6) {
                            var10 = new LocalVariableBinding(field_618, var6, 0, false);
                            this.field_630 = var10;
                            var3.addLocalVariable(this.field_630);
                            this.field_630.setConstant(Constant.NotAConstant);
                        }
                    }
                }
                this.field_622.method_842(var3);
                var3.shiftScopes = new BlockScope[this.catchArguments == null ? 1 : this.catchArguments.length + 1];
                var3.shiftScopes[0] = var2;
            }
        }
        this.field_619.method_842(var2);
        if (this.catchBlocks != null) {
            int var11 = this.catchArguments.length;
            TypeBinding[] var12 = new TypeBinding[var11];
            boolean var13 = false;
            int var7;
            for (var7 = 0; var7 < var11; ++var7) {
                var10000 = new BlockScope(this.scope);
                BlockScope var8 = var10000;
                if (var3 != null) {
                    var3.shiftScopes[var7 + 1] = var8;
                }
                if ((var12[var7] = this.catchArguments[var7].resolveForCatch(var8)) == null) {
                    var13 = true;
                }
                this.catchBlocks[var7].method_842(var8);
            }
            if (var13) {
                return;
            }
            this.caughtExceptionTypes = new ReferenceBinding[var11];
            for (var7 = 0; var7 < var11; ++var7) {
                this.caughtExceptionTypes[var7] = (ReferenceBinding)var12[var7];
                for (int var14 = 0; var14 < var7; ++var14) {
                    if (this.caughtExceptionTypes[var7].isCompatibleWith(var12[var14])) {
                        this.scope.problemReporter().wrongSequenceOfExceptionTypesError(this, this.caughtExceptionTypes[var7], var7, var12[var14]);
                    }
                }
            }
        } else {
            this.caughtExceptionTypes = new ReferenceBinding[0];
        }
        if (var3 != null) {
            this.scope.addSubscope(var3);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_619.traverse(var1, this.scope);
            if (this.catchArguments != null) {
                int var3 = 0;
                for (int var4 = this.catchBlocks.length; var3 < var4; ++var3) {
                    this.catchArguments[var3].traverse(var1, this.scope);
                    this.catchBlocks[var3].traverse(var1, this.scope);
                }
            }
            if (this.field_622 != null) {
                this.field_622.traverse(var1, this.scope);
            }
        }
        var1.endVisit(this, var2);
    }

    static {
        field_616 = " returnAddress".toCharArray();
        field_617 = " anyExceptionHandler".toCharArray();
        field_618 = " returnValue".toCharArray();
    }
}
