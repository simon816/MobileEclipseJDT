package org.eclipse.jdt.internal.compiler.problem;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.util.Util;

public class AbortCompilation extends RuntimeException {

    public CompilationResult compilationResult;

    public Throwable exception;

    public CategorizedProblem problem;

    public boolean isSilent;

    public RuntimeException silentException;

    public AbortCompilation() {
    }

    public AbortCompilation(CompilationResult var1, CategorizedProblem var2) {
        this();
        this.compilationResult = var1;
        this.problem = var2;
    }

    public AbortCompilation(CompilationResult var1, Throwable var2) {
        this();
        this.compilationResult = var1;
        this.exception = var2;
    }

    public AbortCompilation(boolean var1, RuntimeException var2) {
        this();
        this.isSilent = var1;
        this.silentException = var2;
    }

    public void updateContext(InvocationSite var1, CompilationResult var2) {
        if (this.problem != null) {
            if (this.problem.method_1401() == 0 && this.problem.method_1402() == 0) {
                this.problem.method_13(var1.method_5());
                this.problem.method_11(var1.method_6());
                int[] var3 = var2.getLineSeparatorPositions();
                this.problem.method_12(Util.getLineNumber(var1.method_5(), var3, 0, var3.length - 1));
                this.compilationResult = var2;
            }
        }
    }

    public void updateContext(ASTNode var1, CompilationResult var2) {
        if (this.problem != null) {
            if (this.problem.method_1401() == 0 && this.problem.method_1402() == 0) {
                this.problem.method_13(var1.method_5());
                this.problem.method_11(var1.method_6());
                int[] var3 = var2.getLineSeparatorPositions();
                this.problem.method_12(Util.getLineNumber(var1.method_5(), var3, 0, var3.length - 1));
                this.compilationResult = var2;
            }
        }
    }
}
