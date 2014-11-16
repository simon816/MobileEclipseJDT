package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class BranchStatement extends Statement {

    public char[] label;

    public BranchLabel targetLabel;

    public SubRoutineStatement[] subroutines;

    public int initStateIndex;

    public BranchStatement(char[] var1, int var2, int var3) {
        this.initStateIndex = -1;
        this.label = var1;
        this.field_444 = var2;
        this.field_445 = var3;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.subroutines != null) {
                int var4 = 0;
                for (int var5 = this.subroutines.length; var4 < var5; ++var4) {
                    SubRoutineStatement var6 = this.subroutines[var4];
                    boolean var7 = var6.generateSubRoutineInvocation(var1, var2, this.targetLabel, this.initStateIndex, (LocalVariableBinding)null);
                    if (var7) {
                        var2.method_2360(var3, this.field_444);
                        SubRoutineStatement.reenterAllExceptionHandlers(this.subroutines, var4, var2);
                        if (this.initStateIndex != -1) {
                            var2.method_2363(var1, this.initStateIndex);
                            var2.method_2088(var1, this.initStateIndex);
                        }
                        return;
                    }
                }
            }
            var2.method_2209(this.targetLabel);
            var2.method_2360(var3, this.field_444);
            SubRoutineStatement.reenterAllExceptionHandlers(this.subroutines, -1, var2);
            if (this.initStateIndex != -1) {
                var2.method_2363(var1, this.initStateIndex);
                var2.method_2088(var1, this.initStateIndex);
            }
        }
    }

    public void resolve(BlockScope var1) {}
}
