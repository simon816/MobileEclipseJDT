package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.SwitchFlowContext;
import org.eclipse.jdt.internal.compiler.flow.LabelFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class LoopingFlowContext extends SwitchFlowContext {

    public BranchLabel continueLabel;

    public UnconditionalFlowInfo initsOnContinue;

    private UnconditionalFlowInfo upstreamNullFlowInfo;

    private LoopingFlowContext[] innerFlowContexts;

    private UnconditionalFlowInfo[] innerFlowInfos;

    private int field_1753;

    private LabelFlowContext[] breakTargetContexts;

    private int field_1755;

    Reference[] finalAssignments;

    VariableBinding[] finalVariables;

    int field_1758;

    LocalVariableBinding[] nullLocals;

    Expression[] nullReferences;

    int[] nullCheckTypes;

    int field_1762;

    Scope associatedScope;

    public LoopingFlowContext(FlowContext var1, FlowInfo var2, ASTNode var3, BranchLabel var4, BranchLabel var5, Scope var6) {
        super(var1, var3, var4);
        this.initsOnContinue = FlowInfo.DEAD_END;
        this.innerFlowContexts = null;
        this.innerFlowInfos = null;
        this.field_1753 = 0;
        this.breakTargetContexts = null;
        this.field_1755 = 0;
        this.field_1758 = 0;
        this.field_1743 = true;
        this.continueLabel = var5;
        this.associatedScope = var6;
        this.upstreamNullFlowInfo = var2.method_3107();
    }

    public void method_3057(BlockScope var1, FlowInfo var2) {
        for (int var3 = 0; var3 < this.field_1758; ++var3) {
            VariableBinding var4 = this.finalVariables[var3];
            if (var4 != null) {
                boolean var5 = false;
                if (var4 instanceof FieldBinding) {
                    if (var2.method_3087((FieldBinding)var4)) {
                        var5 = true;
                        var1.problemReporter().duplicateInitializationOfBlankFinalField((FieldBinding)var4, this.finalAssignments[var3]);
                    }
                } else if (var2.method_3088((LocalVariableBinding)var4)) {
                    var5 = true;
                    var1.problemReporter().method_1528((LocalVariableBinding)var4, this.finalAssignments[var3]);
                }
                if (var5) {
                    for (FlowContext var6 = this.parent; var6 != null; var6 = var6.parent) {
                        var6.removeFinalAssignmentIfAny(this.finalAssignments[var3]);
                    }
                }
            }
        }
    }

    public void method_3058(BlockScope var1, FlowInfo var2) {
        for (int var3 = 0; var3 < this.field_1753; ++var3) {
            this.upstreamNullFlowInfo.method_3113(this.innerFlowContexts[var3].upstreamNullFlowInfo).method_3113(this.innerFlowInfos[var3]);
        }
        this.field_1753 = 0;
        UnconditionalFlowInfo var7 = this.upstreamNullFlowInfo.method_3113(var2.method_3110());
        int var4;
        if (this.field_1742) {
            for (var4 = 0; var4 < this.field_1762; ++var4) {
                LocalVariableBinding var5 = this.nullLocals[var4];
                Expression var6 = this.nullReferences[var4];
                switch (this.nullCheckTypes[var4]) {
                    case 3:
                        if (var7.method_3085(var5)) {
                            this.nullReferences[var4] = null;
                            var1.problemReporter().method_1665(var5, var6);
                            continue;
                        }
                        break;
                    case 256:
                    case 512:
                        if (var7.method_3084(var5)) {
                            this.nullReferences[var4] = null;
                            if (this.nullCheckTypes[var4] == 512) {
                                var1.problemReporter().method_1667(var5, var6);
                            } else {
                                var1.problemReporter().method_1662(var5, var6);
                            }
                            continue;
                        }
                        if (var7.method_3085(var5)) {
                            this.nullReferences[var4] = null;
                            if (this.nullCheckTypes[var4] == 256) {
                                var1.problemReporter().method_1668(var5, var6);
                            } else {
                                var1.problemReporter().method_1663(var5, var6);
                            }
                            continue;
                        }
                        break;
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var7.method_3085(var5)) {
                            this.nullReferences[var4] = null;
                            switch (this.nullCheckTypes[var4] & -256) {
                                case 256:
                                    var1.problemReporter().method_1668(var5, var6);
                                    continue;
                                case 512:
                                    var1.problemReporter().method_1663(var5, var6);
                                    continue;
                                case 768:
                                    var1.problemReporter().method_1669(var5, var6);
                                    continue;
                                case 1024:
                                    var1.problemReporter().method_1664(var5, var6);
                                    continue;
                            }
                        }
                        break;
                    case 258:
                    case 514:
                        if (var7.method_3084(var5)) {
                            this.nullReferences[var4] = null;
                            if (this.nullCheckTypes[var4] == 514) {
                                var1.problemReporter().method_1667(var5, var6);
                            } else {
                                var1.problemReporter().method_1662(var5, var6);
                            }
                            continue;
                        }
                }
                this.parent.recordUsingNullReference(var1, var5, var6, this.nullCheckTypes[var4], var7);
            }
        } else {
            for (var4 = 0; var4 < this.field_1762; ++var4) {
                Expression var8 = this.nullReferences[var4];
                LocalVariableBinding var9 = this.nullLocals[var4];
                switch (this.nullCheckTypes[var4]) {
                    case 3:
                        if (var7.method_3085(var9)) {
                            this.nullReferences[var4] = null;
                            var1.problemReporter().method_1665(var9, var8);
                        } else if (var7.method_3090(var9)) {
                            this.nullReferences[var4] = null;
                            var1.problemReporter().method_1666(var9, var8);
                        }
                        break;
                    case 256:
                    case 512:
                        if (var7.method_3084(var9)) {
                            this.nullReferences[var4] = null;
                            if (this.nullCheckTypes[var4] == 512) {
                                var1.problemReporter().method_1667(var9, var8);
                            } else {
                                var1.problemReporter().method_1662(var9, var8);
                            }
                            break;
                        }
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var7.method_3085(var9)) {
                            this.nullReferences[var4] = null;
                            switch (this.nullCheckTypes[var4] & -256) {
                                case 256:
                                    var1.problemReporter().method_1668(var9, var8);
                                    break;
                                case 512:
                                    var1.problemReporter().method_1663(var9, var8);
                                    break;
                                case 768:
                                    var1.problemReporter().method_1669(var9, var8);
                                    break;
                                case 1024:
                                    var1.problemReporter().method_1664(var9, var8);
                            }
                        }
                }
            }
        }
        this.initsOnBreak.method_3113(var7);
        for (var4 = 0; var4 < this.field_1755; ++var4) {
            this.breakTargetContexts[var4].initsOnBreak.method_3113(var7);
        }
    }

    public BranchLabel continueLabel() {
        return this.continueLabel;
    }

    public String individualToString() {
        StringBuffer var1 = new StringBuffer("Looping flow context");
        var1.append("[initsOnBreak - ").append(this.initsOnBreak.toString()).append(']');
        var1.append("[initsOnContinue - ").append(this.initsOnContinue.toString()).append(']');
        var1.append("[finalAssignments count - ").append(this.field_1758).append(']');
        var1.append("[nullReferences count - ").append(this.field_1762).append(']');
        return var1.toString();
    }

    public boolean method_3041() {
        return true;
    }

    public void recordBreakTo(FlowContext var1) {
        if (var1 instanceof LabelFlowContext) {
            int var2;
            if ((var2 = this.field_1755++) == 0) {
                this.breakTargetContexts = new LabelFlowContext[2];
            } else if (var2 == this.breakTargetContexts.length) {
                System.arraycopy(this.breakTargetContexts, 0, this.breakTargetContexts = new LabelFlowContext[var2 + 2], 0, var2);
            }
            this.breakTargetContexts[var2] = (LabelFlowContext)var1;
        }
    }

    public void recordContinueFrom(FlowContext var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            if ((this.initsOnContinue.tagBits & 1) == 0) {
                this.initsOnContinue = this.initsOnContinue.mergedWith(var2.method_3110());
            } else {
                this.initsOnContinue = var2.method_3107();
            }
            FlowContext var3;
            for (var3 = var1; var3 != this && !(var3 instanceof LoopingFlowContext); var3 = var3.parent) {
                ;
            }
            if (var3 == this) {
                this.upstreamNullFlowInfo.method_3113(var2.method_3110());
            } else {
                boolean var4 = false;
                if (this.innerFlowContexts == null) {
                    this.innerFlowContexts = new LoopingFlowContext[5];
                    this.innerFlowInfos = new UnconditionalFlowInfo[5];
                } else {
                    int var5;
                    if (this.field_1753 == (var5 = this.innerFlowContexts.length) - 1) {
                        System.arraycopy(this.innerFlowContexts, 0, this.innerFlowContexts = new LoopingFlowContext[var5 + 5], 0, var5);
                        System.arraycopy(this.innerFlowInfos, 0, this.innerFlowInfos = new UnconditionalFlowInfo[var5 + 5], 0, var5);
                    }
                }
                this.innerFlowContexts[this.field_1753] = (LoopingFlowContext)var3;
                this.innerFlowInfos[this.field_1753++] = var2.method_3110();
            }
        }
    }

    protected boolean recordFinalAssignment(VariableBinding var1, Reference var2) {
        if (var1 instanceof LocalVariableBinding) {
            Object var3 = ((LocalVariableBinding)var1).declaringScope;
            while ((var3 = ((Scope)var3).parent) != null) {
                if (var3 == this.associatedScope) {
                    return false;
                }
            }
        }
        if (this.field_1758 == 0) {
            this.finalAssignments = new Reference[5];
            this.finalVariables = new VariableBinding[5];
        } else {
            if (this.field_1758 == this.finalAssignments.length) {
                System.arraycopy(this.finalAssignments, 0, this.finalAssignments = new Reference[this.field_1758 * 2], 0, this.field_1758);
            }
            System.arraycopy(this.finalVariables, 0, this.finalVariables = new VariableBinding[this.field_1758 * 2], 0, this.field_1758);
        }
        this.finalAssignments[this.field_1758] = var2;
        this.finalVariables[this.field_1758++] = var1;
        return true;
    }

    protected void recordNullReference(LocalVariableBinding var1, Expression var2, int var3) {
        if (this.field_1762 == 0) {
            this.nullLocals = new LocalVariableBinding[5];
            this.nullReferences = new Expression[5];
            this.nullCheckTypes = new int[5];
        } else if (this.field_1762 == this.nullLocals.length) {
            System.arraycopy(this.nullLocals, 0, this.nullLocals = new LocalVariableBinding[this.field_1762 * 2], 0, this.field_1762);
            System.arraycopy(this.nullReferences, 0, this.nullReferences = new Expression[this.field_1762 * 2], 0, this.field_1762);
            System.arraycopy(this.nullCheckTypes, 0, this.nullCheckTypes = new int[this.field_1762 * 2], 0, this.field_1762);
        }
        this.nullLocals[this.field_1762] = var1;
        this.nullReferences[this.field_1762] = var2;
        this.nullCheckTypes[this.field_1762++] = var3;
    }

    public void recordUsingNullReference(Scope var1, LocalVariableBinding var2, Expression var3, int var4, FlowInfo var5) {
        if ((var5.tagBits & 1) == 0 && !var5.method_3086(var2)) {
            switch (var4) {
                case 3:
                    if (var5.method_3084(var2)) {
                        return;
                    } else if (var5.method_3085(var2)) {
                        var1.problemReporter().method_1665(var2, var3);
                        return;
                    } else {
                        if (var5.method_3090(var2)) {
                            var1.problemReporter().method_1666(var2, var3);
                            return;
                        }
                        this.recordNullReference(var2, var3, var4);
                        return;
                    }
                case 256:
                case 512:
                    if (var5.method_3084(var2)) {
                        if (var4 == 512) {
                            var1.problemReporter().method_1667(var2, var3);
                        } else {
                            var1.problemReporter().method_1662(var2, var3);
                        }
                    } else if (var5.method_3085(var2)) {
                        if (var4 == 256) {
                            var1.problemReporter().method_1668(var2, var3);
                        } else {
                            var1.problemReporter().method_1663(var2, var3);
                        }
                    } else if (!var5.method_3075(var2)) {
                        if (var5.method_3089(var2)) {
                            this.recordNullReference(var2, var3, 2 | var4 & -256);
                        } else {
                            this.recordNullReference(var2, var3, var4);
                        }
                    }
                    return;
                case 257:
                case 513:
                case 769:
                case 1025:
                    if (!var5.method_3089(var2) && !var5.method_3091(var2)) {
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
                        }
                        this.recordNullReference(var2, var3, var4);
                        return;
                    }
                    return;
                default:
            }
        }
    }

    void removeFinalAssignmentIfAny(Reference var1) {
        for (int var2 = 0; var2 < this.field_1758; ++var2) {
            if (this.finalAssignments[var2] == var1) {
                this.finalAssignments[var2] = null;
                this.finalVariables[var2] = null;
                return;
            }
        }
    }
}
