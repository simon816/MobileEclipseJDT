package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.ExceptionLabel;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class SubRoutineStatement extends Statement {

    ExceptionLabel anyExceptionLabel;

    public SubRoutineStatement() {
    }

    public static void reenterAllExceptionHandlers(SubRoutineStatement[] var0, int var1, CodeStream var2) {
        if (var0 != null) {
            if (var1 < 0) {
                var1 = var0.length;
            }
            for (int var3 = 0; var3 < var1; ++var3) {
                SubRoutineStatement var4 = var0[var3];
                var4.enterAnyExceptionHandler(var2);
                var4.method_873(var2);
            }
        }
    }

    public ExceptionLabel enterAnyExceptionHandler(CodeStream var1) {
        if (this.anyExceptionLabel == null) {
            ExceptionLabel var10001 = new ExceptionLabel(var1, (TypeBinding)null);
            this.anyExceptionLabel = var10001;
        }
        this.anyExceptionLabel.method_449();
        return this.anyExceptionLabel;
    }

    public void method_873(CodeStream var1) {}

    public void exitAnyExceptionHandler() {
        if (this.anyExceptionLabel != null) {
            this.anyExceptionLabel.method_448();
        }
    }

    public abstract boolean generateSubRoutineInvocation(BlockScope var1, CodeStream var2, Object var3, int var4, LocalVariableBinding var5);

    public abstract boolean isSubRoutineEscaping();

    public void method_877() {
        this.anyExceptionLabel.method_447();
    }
}
