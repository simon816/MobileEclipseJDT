package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public class ProblemBinding extends Binding {

    public char[] name;

    public ReferenceBinding searchType;

    private int problemId;

    public ProblemBinding(char[][] var1, int var2) {
        this(CharOperation.concatWith(var1, '.'), var2);
    }

    public ProblemBinding(char[][] var1, ReferenceBinding var2, int var3) {
        this(CharOperation.concatWith(var1, '.'), var2, var3);
    }

    ProblemBinding(char[] var1, int var2) {
        this.name = var1;
        this.problemId = var2;
    }

    ProblemBinding(char[] var1, ReferenceBinding var2, int var3) {
        this(var1, var3);
        this.searchType = var2;
    }

    public final int kind() {
        return 7;
    }

    public final int problemId() {
        return this.problemId;
    }

    public char[] readableName() {
        return this.name;
    }
}
