package org.eclipse.jdt.internal.compiler.problem;

import java.io.IOException;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;

public class AbortCompilationUnit extends AbortCompilation {

    public String encoding;

    public AbortCompilationUnit(CompilationResult var1, CategorizedProblem var2) {
        super(var1, var2);
    }

    public AbortCompilationUnit(CompilationResult var1, IOException var2, String var3) {
        super(var1, var2);
        this.encoding = var3;
    }
}
