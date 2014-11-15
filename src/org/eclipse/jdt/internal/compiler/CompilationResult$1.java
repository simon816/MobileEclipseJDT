package org.eclipse.jdt.internal.compiler;

import java.util.Comparator;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

final class CompilationResult$1 implements Comparator {

    CompilationResult$1() {
    }

    public int compare(Object var1, Object var2) {
        return ((CategorizedProblem)var1).method_1401() - ((CategorizedProblem)var2).method_1401();
    }
}
