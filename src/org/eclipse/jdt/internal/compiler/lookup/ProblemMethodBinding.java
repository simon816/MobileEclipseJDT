package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;

public class ProblemMethodBinding extends MethodBinding {

    private int problemReason;

    public MethodBinding closestMatch;

    public ProblemMethodBinding(char[] var1, TypeBinding[] var2, int var3) {
        this.selector = var1;
        this.parameters = var2 != null && var2.length != 0 ? var2 : Binding.field_150;
        this.problemReason = var3;
        this.thrownExceptions = Binding.field_151;
    }

    public ProblemMethodBinding(char[] var1, TypeBinding[] var2, ReferenceBinding var3, int var4) {
        this.selector = var1;
        this.parameters = var2 != null && var2.length != 0 ? var2 : Binding.field_150;
        this.declaringClass = var3;
        this.problemReason = var4;
        this.thrownExceptions = Binding.field_151;
    }

    public ProblemMethodBinding(MethodBinding var1, char[] var2, TypeBinding[] var3, int var4) {
        this(var2, var3, var4);
        this.closestMatch = var1;
        if (var1 != null && var4 != 3) {
            this.declaringClass = var1.declaringClass;
        }
    }

    public final int problemId() {
        return this.problemReason;
    }
}
