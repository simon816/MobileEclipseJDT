package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public class ProblemReferenceBinding extends ReferenceBinding {

    ReferenceBinding closestMatch;

    private int problemReason;

    public ProblemReferenceBinding(char[][] var1, ReferenceBinding var2, int var3) {
        this.compoundName = var1;
        this.closestMatch = var2;
        this.problemReason = var3;
    }

    public TypeBinding closestMatch() {
        return this.closestMatch;
    }

    public ReferenceBinding closestReferenceMatch() {
        return this.closestMatch;
    }

    public int problemId() {
        return this.problemReason;
    }

    public char[] shortReadableName() {
        return this.readableName();
    }
}
