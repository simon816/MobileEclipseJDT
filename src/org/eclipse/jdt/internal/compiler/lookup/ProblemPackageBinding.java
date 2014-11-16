package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;

public class ProblemPackageBinding extends PackageBinding {

    private int problemId;

    ProblemPackageBinding(char[][] var1, int var2) {
        this.compoundName = var1;
        this.problemId = var2;
    }

    ProblemPackageBinding(char[] var1, int var2) {
        this(new char[][] {var1}, var2);
    }

    public final int problemId() {
        return this.problemId;
    }
}
