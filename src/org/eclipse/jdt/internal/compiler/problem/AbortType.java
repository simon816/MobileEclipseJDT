package org.eclipse.jdt.internal.compiler.problem;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;

public class AbortType extends AbortCompilationUnit {

    public AbortType(CompilationResult var1, CategorizedProblem var2) {
        super(var1, var2);
    }
}
