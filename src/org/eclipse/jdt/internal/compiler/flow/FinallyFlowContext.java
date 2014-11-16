package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class FinallyFlowContext extends FlowContext {

    Reference[] finalAssignments;

    VariableBinding[] finalVariables;

    int field_1778;

    LocalVariableBinding[] nullLocals;

    Expression[] nullReferences;

    int[] nullCheckTypes;

    int field_1782;

    public FinallyFlowContext(FlowContext var1, ASTNode var2) {
        super(var1, var2);
    }

    public void complainOnDeferredChecks(FlowInfo var1, BlockScope var2) {
        int var3;
        for (var3 = 0; var3 < this.field_1778; ++var3) {
            VariableBinding var4 = this.finalVariables[var3];
            if (var4 != null) {
                boolean var5 = false;
                if (var4 instanceof FieldBinding) {
                    if (var1.method_3087((FieldBinding)var4)) {
                        var5 = true;
                        var2.problemReporter().duplicateInitializationOfBlankFinalField((FieldBinding)var4, this.finalAssignments[var3]);
                    }
                } else if (var1.method_3088((LocalVariableBinding)var4)) {
                    var5 = true;
                    var2.problemReporter().method_1528((LocalVariableBinding)var4, this.finalAssignments[var3]);
                }
                if (var5) {
                    for (FlowContext var6 = this.parent; var6 != null; var6 = var6.parent) {
                        var6.removeFinalAssignmentIfAny(this.finalAssignments[var3]);
                    }
                }
            }
        }
        if (this.field_1742) {
            for (var3 = 0; var3 < this.field_1782; ++var3) {
                this.parent.recordUsingNullReference(var2, this.nullLocals[var3], this.nullReferences[var3], this.nullCheckTypes[var3], var1);
            }
        } else {
            for (var3 = 0; var3 < this.field_1782; ++var3) {
                Expression var7 = this.nullReferences[var3];
                LocalVariableBinding var8 = this.nullLocals[var3];
                switch (this.nullCheckTypes[var3]) {
                    case 3:
                        if (var1.method_3085(var8)) {
                            var2.problemReporter().method_1665(var8, var7);
                        } else if (var1.method_3090(var8)) {
                            var2.problemReporter().method_1666(var8, var7);
                        }
                        break;
                    case 256:
                    case 512:
                        if (var1.method_3084(var8)) {
                            if (this.nullCheckTypes[var3] == 512) {
                                var2.problemReporter().method_1667(var8, var7);
                            } else {
                                var2.problemReporter().method_1662(var8, var7);
                            }
                            break;
                        }
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var1.method_3085(var8)) {
                            switch (this.nullCheckTypes[var3] & -256) {
                                case 256:
                                    var2.problemReporter().method_1668(var8, var7);
                                    break;
                                case 512:
                                    var2.problemReporter().method_1663(var8, var7);
                                    break;
                                case 768:
                                    var2.problemReporter().method_1669(var8, var7);
                                    break;
                                case 1024:
                                    var2.problemReporter().method_1664(var8, var7);
                            }
                        }
                }
            }
        }
    }

    public String individualToString() {
        StringBuffer var1 = new StringBuffer("Finally flow context");
        var1.append("[finalAssignments count - ").append(this.field_1778).append(']');
        var1.append("[nullReferences count - ").append(this.field_1782).append(']');
        return var1.toString();
    }

    protected boolean recordFinalAssignment(VariableBinding var1, Reference var2) {
        if (this.field_1778 == 0) {
            this.finalAssignments = new Reference[5];
            this.finalVariables = new VariableBinding[5];
        } else {
            if (this.field_1778 == this.finalAssignments.length) {
                System.arraycopy(this.finalAssignments, 0, this.finalAssignments = new Reference[this.field_1778 * 2], 0, this.field_1778);
            }
            System.arraycopy(this.finalVariables, 0, this.finalVariables = new VariableBinding[this.field_1778 * 2], 0, this.field_1778);
        }
        this.finalAssignments[this.field_1778] = var2;
        this.finalVariables[this.field_1778++] = var1;
        return true;
    }

    public void recordUsingNullReference(Scope var1, LocalVariableBinding var2, Expression var3, int var4, FlowInfo var5) {
        if ((var5.tagBits & 1) == 0 && !var5.method_3086(var2)) {
            if (this.field_1742) {
                switch (var4) {
                    case 3:
                        if (var5.method_3076(var2)) {
                            return;
                        }
                        if (var5.method_3077(var2)) {
                            var1.problemReporter().method_1665(var2, var3);
                            return;
                        }
                        break;
                    case 256:
                    case 257:
                    case 512:
                    case 513:
                    case 769:
                    case 1025:
                        if (var5.method_3076(var2)) {
                            if (var4 == 512) {
                                var1.problemReporter().method_1667(var2, var3);
                            } else {
                                var1.problemReporter().method_1662(var2, var3);
                            }
                            return;
                        }
                        if (var5.method_3077(var2)) {
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
                }
            } else {
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
                        if (var5.method_3084(var2)) {
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
                        }
                }
            }
            this.recordNullReference(var2, var3, var4);
        }
    }

    void removeFinalAssignmentIfAny(Reference var1) {
        for (int var2 = 0; var2 < this.field_1778; ++var2) {
            if (this.finalAssignments[var2] == var1) {
                this.finalAssignments[var2] = null;
                this.finalVariables[var2] = null;
                return;
            }
        }
    }

    protected void recordNullReference(LocalVariableBinding var1, Expression var2, int var3) {
        if (this.field_1782 == 0) {
            this.nullLocals = new LocalVariableBinding[5];
            this.nullReferences = new Expression[5];
            this.nullCheckTypes = new int[5];
        } else if (this.field_1782 == this.nullLocals.length) {
            int var4 = this.field_1782 * 2;
            System.arraycopy(this.nullLocals, 0, this.nullLocals = new LocalVariableBinding[var4], 0, this.field_1782);
            System.arraycopy(this.nullReferences, 0, this.nullReferences = new Expression[var4], 0, this.field_1782);
            System.arraycopy(this.nullCheckTypes, 0, this.nullCheckTypes = new int[var4], 0, this.field_1782);
        }
        this.nullLocals[this.field_1782] = var1;
        this.nullReferences[this.field_1782] = var2;
        this.nullCheckTypes[this.field_1782++] = var3;
    }
}
