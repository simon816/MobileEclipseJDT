package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;

public interface ReferenceContext {

    void abort(int var1, CategorizedProblem var2);

    CompilationResult compilationResult();

    boolean hasErrors();

    void tagAsHavingErrors();
}
