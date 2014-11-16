package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;

class Compiler$1 implements ICompilerRequestor {

    private final ICompilerRequestor field_1733;

    private final Compiler field_1734;

    Compiler$1(Compiler var1, ICompilerRequestor var2) {
        this.field_1734 = var1;
        this.field_1733 = var2;
    }

    public void acceptResult(CompilationResult var1) {
        if (Compiler.DebugRequestor.isActive()) {
            Compiler.DebugRequestor.acceptDebugResult(var1);
        }
        this.field_1733.acceptResult(var1);
    }
}
