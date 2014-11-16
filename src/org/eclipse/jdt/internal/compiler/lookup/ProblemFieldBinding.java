package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public class ProblemFieldBinding extends FieldBinding {

    private int problemId;

    public FieldBinding closestMatch;

    public ProblemFieldBinding(ReferenceBinding var1, char[] var2, int var3) {
        this((FieldBinding)null, var1, var2, var3);
    }

    public ProblemFieldBinding(FieldBinding var1, ReferenceBinding var2, char[] var3, int var4) {
        this.closestMatch = var1;
        this.declaringClass = var2;
        this.name = var3;
        this.problemId = var4;
    }

    public final int problemId() {
        return this.problemId;
    }
}
