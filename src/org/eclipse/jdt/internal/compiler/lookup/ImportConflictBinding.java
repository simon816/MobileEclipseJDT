package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ImportBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public class ImportConflictBinding extends ImportBinding {

    public ReferenceBinding conflictingTypeBinding;

    public ImportConflictBinding(char[][] var1, Binding var2, ReferenceBinding var3, ImportReference var4) {
        super(var1, false, var2, var4);
        this.conflictingTypeBinding = var3;
    }

    public char[] readableName() {
        return CharOperation.concatWith(this.compoundName, '.');
    }

    public String toString() {
        return "method import : " + new String(this.readableName());
    }
}
