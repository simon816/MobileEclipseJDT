package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.LabeledStatement;
import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;
import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.flow.NullInfoRegistry;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class FlowContext implements TypeConstants {

    public static final FlowContext NotContinuableContext;

    public ASTNode associatedNode;

    public FlowContext parent;

    public NullInfoRegistry initsOnFinally;

    boolean field_1742;

    boolean field_1743;

    public FlowContext(FlowContext var1, ASTNode var2) {
        this.parent = var1;
        this.associatedNode = var2;
        if (var1 != null) {
            this.field_1742 = var1.field_1742 || var1.field_1743;
            this.initsOnFinally = var1.initsOnFinally;
        }
    }

    public BranchLabel breakLabel() {
        return null;
    }

    public void checkExceptionHandlers(TypeBinding var1, ASTNode var2, FlowInfo var3, BlockScope var4) {
        for (FlowContext var5 = this; var5 != null; var5 = var5.parent) {
            SubRoutineStatement var6;
            if ((var6 = var5.subroutine()) != null && var6.isSubRoutineEscaping()) {
                return;
            }
            if (var5 instanceof ExceptionHandlingFlowContext) {
                ExceptionHandlingFlowContext var7 = (ExceptionHandlingFlowContext)var5;
                ReferenceBinding[] var8 = var7.handledExceptions;
                if (var7.handledExceptions != Binding.field_151) {
                    boolean var9 = false;
                    int var10 = 0;
                    for (int var11 = var8.length; var10 < var11; ++var10) {
                        ReferenceBinding var12 = var8[var10];
                        int var13 = var12 == null ? -1 : Scope.compareTypes(var1, var12);
                        switch (var13) {
                            case -1:
                                var7.recordHandlingException(var12, var3.method_3109(), var1, var2, var9);
                                var9 = true;
                                break;
                            case 1:
                                var7.recordHandlingException(var12, var3.method_3109(), var1, var2, false);
                        }
                    }
                    if (var9) {
                        return;
                    }
                }
                if (var7.isMethodContext) {
                    if (var1.isUncheckedException(false)) {
                        return;
                    }
                    if (var7.associatedNode instanceof AbstractMethodDeclaration) {
                        AbstractMethodDeclaration var16 = (AbstractMethodDeclaration)var7.associatedNode;
                        if (var16.method_795() && var16.binding.declaringClass.method_146()) {
                            var7.mergeUnhandledException(var1);
                            return;
                        }
                    }
                    break;
                }
            }
            var5.recordReturnFrom(var3.method_3109());
            if (var5 instanceof InsideSubRoutineFlowContext) {
                ASTNode var14 = var5.associatedNode;
                if (var14 instanceof TryStatement) {
                    TryStatement var15 = (TryStatement)var14;
                    var3.method_3071(var15.subRoutineInits);
                }
            }
        }
        var4.problemReporter().method_1786(var1, var2);
    }

    public void checkExceptionHandlers(TypeBinding[] var1, ASTNode var2, FlowInfo var3, BlockScope var4) {
        int var6;
        if (var1 != null && (var6 = var1.length) != 0) {
            int var5 = var6;
            System.arraycopy(var1, 0, var1 = new TypeBinding[var6], 0, var6);
            for (FlowContext var7 = this; var7 != null; var7 = var7.parent) {
                SubRoutineStatement var8;
                if ((var8 = var7.subroutine()) != null && var8.isSubRoutineEscaping()) {
                    return;
                }
                if (var7 instanceof ExceptionHandlingFlowContext) {
                    ExceptionHandlingFlowContext var9 = (ExceptionHandlingFlowContext)var7;
                    ReferenceBinding[] var10 = var9.handledExceptions;
                    int var11;
                    if (var9.handledExceptions != Binding.field_151) {
                        var11 = var10.length;
                        boolean[] var12 = new boolean[var6];
                        int var13;
                        for (var13 = 0; var13 < var11; ++var13) {
                            ReferenceBinding var14 = var10[var13];
                            for (int var15 = 0; var15 < var6; ++var15) {
                                TypeBinding var16;
                                if ((var16 = var1[var15]) != null) {
                                    int var17 = var14 == null ? -1 : Scope.compareTypes(var16, var14);
                                    switch (var17) {
                                        case -1:
                                            var9.recordHandlingException(var14, var3.method_3109(), var16, var2, var12[var15]);
                                            if (!var12[var15]) {
                                                var12[var15] = true;
                                                --var5;
                                            }
                                            break;
                                        case 1:
                                            var9.recordHandlingException(var14, var3.method_3109(), var16, var2, false);
                                    }
                                }
                            }
                        }
                        for (var13 = 0; var13 < var6; ++var13) {
                            if (var12[var13]) {
                                var1[var13] = null;
                            }
                        }
                    }
                    if (var9.isMethodContext) {
                        for (var11 = 0; var11 < var6; ++var11) {
                            TypeBinding var23;
                            if ((var23 = var1[var11]) != null && var23.isUncheckedException(false)) {
                                --var5;
                                var1[var11] = null;
                            }
                        }
                        if (var9.associatedNode instanceof AbstractMethodDeclaration) {
                            AbstractMethodDeclaration var25 = (AbstractMethodDeclaration)var9.associatedNode;
                            if (var25.method_795() && var25.binding.declaringClass.method_146()) {
                                for (int var24 = 0; var24 < var6; ++var24) {
                                    TypeBinding var26;
                                    if ((var26 = var1[var24]) != null) {
                                        var9.mergeUnhandledException(var26);
                                    }
                                }
                                return;
                            }
                        }
                        break;
                    }
                }
                if (var5 == 0) {
                    return;
                }
                var7.recordReturnFrom(var3.method_3109());
                if (var7 instanceof InsideSubRoutineFlowContext) {
                    ASTNode var19 = var7.associatedNode;
                    if (var19 instanceof TryStatement) {
                        TryStatement var21 = (TryStatement)var19;
                        var3.method_3071(var21.subRoutineInits);
                    }
                }
            }
            label107:
            for (int var18 = 0; var18 < var6; ++var18) {
                TypeBinding var20;
                if ((var20 = var1[var18]) != null) {
                    for (int var22 = 0; var22 < var18; ++var22) {
                        if (var1[var22] == var20) {
                            continue label107;
                        }
                    }
                    var4.problemReporter().method_1786(var20, var2);
                }
            }
        }
    }

    public BranchLabel continueLabel() {
        return null;
    }

    public FlowContext method_3035(char[] var1) {
        FlowContext var2 = this;
        for (FlowContext var3 = null; var2 != null; var2 = var2.parent) {
            if (var2.isNonReturningContext()) {
                var3 = var2;
            }
            char[] var4;
            if ((var4 = var2.labelName()) != null && CharOperation.method_1364(var4, var1)) {
                ((LabeledStatement)var2.associatedNode).field_446 |= 64;
                if (var3 == null) {
                    return var2;
                }
                return var3;
            }
        }
        return null;
    }

    public FlowContext method_3036(char[] var1) {
        FlowContext var2 = this;
        FlowContext var3 = null;
        for (FlowContext var4 = null; var2 != null; var2 = var2.parent) {
            if (var2.isNonReturningContext()) {
                var4 = var2;
            } else if (var2.method_3041()) {
                var3 = var2;
            }
            char[] var5;
            if ((var5 = var2.labelName()) != null && CharOperation.method_1364(var5, var1)) {
                ((LabeledStatement)var2.associatedNode).field_446 |= 64;
                if (var3 != null && var2.associatedNode.concreteStatement() == var3.associatedNode) {
                    if (var4 == null) {
                        return var3;
                    }
                    return var4;
                }
                return NotContinuableContext;
            }
        }
        return null;
    }

    public FlowContext method_3037() {
        FlowContext var1 = this;
        for (FlowContext var2 = null; var1 != null; var1 = var1.parent) {
            if (var1.isNonReturningContext()) {
                var2 = var1;
            }
            if (var1.isBreakable() && var1.labelName() == null) {
                if (var2 == null) {
                    return var1;
                }
                return var2;
            }
        }
        return null;
    }

    public FlowContext method_3038() {
        FlowContext var1 = this;
        for (FlowContext var2 = null; var1 != null; var1 = var1.parent) {
            if (var1.isNonReturningContext()) {
                var2 = var1;
            }
            if (var1.method_3041()) {
                if (var2 == null) {
                    return var1;
                }
                return var2;
            }
        }
        return null;
    }

    public String individualToString() {
        return "Flow context";
    }

    public boolean isBreakable() {
        return false;
    }

    public boolean method_3041() {
        return false;
    }

    public boolean isNonReturningContext() {
        return false;
    }

    public char[] labelName() {
        return null;
    }

    public void recordBreakFrom(FlowInfo var1) {}

    public void recordBreakTo(FlowContext var1) {}

    public void recordContinueFrom(FlowContext var1, FlowInfo var2) {}

    protected boolean recordFinalAssignment(VariableBinding var1, Reference var2) {
        return true;
    }

    public void recordReturnFrom(UnconditionalFlowInfo var1) {}

    public void recordSettingFinal(VariableBinding var1, Reference var2, FlowInfo var3) {
        if ((var3.tagBits & 1) == 0) {
            for (FlowContext var4 = this; var4 != null && var4.recordFinalAssignment(var1, var2); var4 = var4.parent) {
                ;
            }
        }
    }

    public void recordUsingNullReference(Scope var1, LocalVariableBinding var2, Expression var3, int var4, FlowInfo var5) {
        if ((var5.tagBits & 1) == 0 && !var5.method_3086(var2)) {
            switch (var4) {
                case 3:
                    if (var5.method_3085(var2)) {
                        var1.problemReporter().method_1665(var2, var3);
                        return;
                    }
                    if (var5.method_3090(var2)) {
                        var1.problemReporter().method_1666(var2, var3);
                        return;
                    }
                    break;
                case 256:
                case 512:
                    if (var5.method_3084(var2)) {
                        if (var4 == 512) {
                            var1.problemReporter().method_1667(var2, var3);
                        } else {
                            var1.problemReporter().method_1662(var2, var3);
                        }
                        return;
                    }
                    if (var5.method_3075(var2)) {
                        return;
                    }
                case 257:
                case 513:
                case 769:
                case 1025:
                    if (var5.method_3085(var2)) {
                        switch (var4 & -256) {
                            case 256:
                                var1.problemReporter().method_1668(var2, var3);
                                return;
                            case 512:
                                var1.problemReporter().method_1663(var2, var3);
                                return;
                            case 768:
                                var1.problemReporter().method_1669(var2, var3);
                                return;
                            case 1024:
                                var1.problemReporter().method_1664(var2, var3);
                                return;
                        }
                    } else if (var5.method_3075(var2)) {
                        return;
                    }
            }
            if (this.parent != null) {
                this.parent.recordUsingNullReference(var1, var2, var3, var4, var5);
            }
        }
    }

    void removeFinalAssignmentIfAny(Reference var1) {}

    public SubRoutineStatement subroutine() {
        return null;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        FlowContext var2 = this;
        int var3;
        for (var3 = 0; (var2 = var2.parent) != null; ++var3) {
            ;
        }
        FlowContext[] var4 = new FlowContext[var3 + 1];
        var2 = this;
        for (int var5 = var3; var5 >= 0; var2 = var2.parent) {
            var4[var5--] = var2;
        }
        int var6;
        for (var6 = 0; var6 < var3; ++var6) {
            for (int var7 = 0; var7 < var6; ++var7) {
                var1.append('\t');
            }
            var1.append(var4[var6].individualToString()).append('\n');
        }
        var1.append('*');
        for (var6 = 0; var6 < var3 + 1; ++var6) {
            var1.append('\t');
        }
        var1.append(this.individualToString()).append('\n');
        return var1.toString();
    }

    static {
        FlowContext var10000 = new FlowContext((FlowContext)null, (ASTNode)null);
        NotContinuableContext = var10000;
    }
}
