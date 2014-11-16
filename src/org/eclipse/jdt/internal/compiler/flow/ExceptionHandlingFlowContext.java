package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.ObjectCache;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

import java.util.ArrayList;

public class ExceptionHandlingFlowContext extends FlowContext {

    public ReferenceBinding[] handledExceptions;

    int[] field_1765;

    int[] field_1766;

    UnconditionalFlowInfo[] initsOnExceptions;

    ObjectCache indexes;

    boolean isMethodContext;

    public UnconditionalFlowInfo initsOnReturn;

    public ArrayList field_1771;

    public ExceptionHandlingFlowContext(FlowContext var1, ASTNode var2, ReferenceBinding[] var3, BlockScope var4, UnconditionalFlowInfo var5) {
        super(var1, var2);
        ObjectCache var10001 = new ObjectCache();
        this.indexes = var10001;
        this.isMethodContext = var4 == var4.method_635();
        this.handledExceptions = var3;
        int var6 = var3.length;
        int var7 = var6 / 32 + 1;
        this.field_1765 = new int[var7];
        this.field_1766 = new int[var7];
        this.initsOnExceptions = new UnconditionalFlowInfo[var6];
        boolean var8 = !this.isMethodContext || var4.compilerOptions().field_1946;
        for (int var9 = 0; var9 < var6; ++var9) {
            ReferenceBinding var10 = var3[var9];
            this.indexes.put(var10, var9);
            if (var10.isUncheckedException(true)) {
                if (var8 || var10.id != 21 && var10.id != 25) {
                    this.field_1765[var9 / 32] |= 1 << var9 % 32;
                }
                this.initsOnExceptions[var9] = var5.method_3107();
            } else {
                this.initsOnExceptions[var9] = FlowInfo.DEAD_END;
            }
        }
        if (!this.isMethodContext) {
            System.arraycopy(this.field_1765, 0, this.field_1766, 0, var7);
        }
        this.initsOnReturn = FlowInfo.DEAD_END;
    }

    public void complainIfUnusedExceptionHandlers(AbstractMethodDeclaration var1) {
        MethodScope var2 = var1.scope;
        if ((var1.binding.modifiers & 805306368) == 0 || var2.compilerOptions().field_1944) {
            Object var3 = null;
            byte var4 = 0;
            int var5 = 0;
            label32:
            for (int var6 = this.handledExceptions.length; var5 < var6; ++var5) {
                int var7 = this.indexes.method_2499(this.handledExceptions[var5]);
                if ((this.field_1765[var7 / 32] & 1 << var7 % 32) == 0) {
                    for (int var8 = 0; var8 < var4; ++var8) {
                        if (((Object[])var3)[var8] == this.handledExceptions[var5]) {
                            continue label32;
                        }
                    }
                    var2.problemReporter().unusedDeclaredThrownException(this.handledExceptions[var7], var1, var1.thrownExceptions[var7]);
                }
            }
        }
    }

    public void complainIfUnusedExceptionHandlers(BlockScope var1, TryStatement var2) {
        int var3 = 0;
        for (int var4 = this.handledExceptions.length; var3 < var4; ++var3) {
            int var5 = this.indexes.method_2499(this.handledExceptions[var3]);
            int var6 = var5 / 32;
            int var7 = 1 << var5 % 32;
            if ((this.field_1765[var6] & var7) == 0) {
                var1.problemReporter().method_1797(this.handledExceptions[var5], var2.catchArguments[var5].type);
            } else if ((this.field_1766[var6] & var7) == 0) {
                var1.problemReporter().method_1563(this.handledExceptions[var5], var2.catchArguments[var5].type);
            }
        }
    }

    public String individualToString() {
        StringBuffer var1 = new StringBuffer("Exception flow context");
        int var2 = this.handledExceptions.length;
        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = var3 / 32;
            int var5 = 1 << var3 % 32;
            var1.append('[').append(this.handledExceptions[var3].readableName());
            if ((this.field_1765[var4] & var5) != 0) {
                if ((this.field_1766[var4] & var5) == 0) {
                    var1.append("-masked");
                } else {
                    var1.append("-reached");
                }
            } else {
                var1.append("-not reached");
            }
            var1.append('-').append(this.initsOnExceptions[var3].toString()).append(']');
        }
        var1.append("[initsOnReturn -").append(this.initsOnReturn.toString()).append(']');
        return var1.toString();
    }

    public UnconditionalFlowInfo initsOnException(ReferenceBinding var1) {
        int var2;
        return (var2 = this.indexes.method_2499(var1)) < 0 ? FlowInfo.DEAD_END : this.initsOnExceptions[var2];
    }

    public void mergeUnhandledException(TypeBinding var1) {
        if (this.field_1771 == null) {
            ArrayList var10001 = new ArrayList(5);
            this.field_1771 = var10001;
            for (int var2 = 0; var2 < this.handledExceptions.length; ++var2) {
                this.field_1771.add(this.handledExceptions[var2]);
            }
        }
        boolean var4 = false;
        for (int var3 = this.field_1771.size() - 1; var3 >= 0; --var3) {
            switch (Scope.compareTypes(var1, (TypeBinding)this.field_1771.get(var3))) {
                case -1:
                    var4 = true;
                case 0:
                default:
                    break;
                case 1:
                    this.field_1771.remove(var3);
            }
        }
        if (!var4) {
            this.field_1771.add(var1);
        }
    }

    public void recordHandlingException(ReferenceBinding var1, UnconditionalFlowInfo var2, TypeBinding var3, ASTNode var4, boolean var5) {
        int var6 = this.indexes.method_2499(var1);
        int var7 = var6 / 32;
        int var8 = 1 << var6 % 32;
        if (!var5) {
            this.field_1766[var7] |= var8;
        }
        this.field_1765[var7] |= var8;
        this.initsOnExceptions[var6] = (this.initsOnExceptions[var6].tagBits & 1) == 0 ? this.initsOnExceptions[var6].mergedWith(var2) : var2.method_3107();
    }

    public void recordReturnFrom(UnconditionalFlowInfo var1) {
        if ((var1.tagBits & 1) == 0) {
            if ((this.initsOnReturn.tagBits & 1) == 0) {
                this.initsOnReturn = this.initsOnReturn.mergedWith(var1);
            } else {
                this.initsOnReturn = (UnconditionalFlowInfo)var1.method_3078();
            }
        }
    }

    public SubRoutineStatement subroutine() {
        return this.associatedNode instanceof SubRoutineStatement ? (this.parent.subroutine() == this.associatedNode ? null : (SubRoutineStatement)this.associatedNode) : null;
    }
}
