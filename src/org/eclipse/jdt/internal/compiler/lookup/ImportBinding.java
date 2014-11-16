package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.lookup.Binding;

public class ImportBinding extends Binding {

    public char[][] compoundName;

    public boolean onDemand;

    public ImportReference reference;

    public Binding resolvedImport;

    public ImportBinding(char[][] var1, boolean var2, Binding var3, ImportReference var4) {
        this.compoundName = var1;
        this.onDemand = var2;
        this.resolvedImport = var3;
        this.reference = var4;
    }

    public final int kind() {
        return 32;
    }

    public boolean isStatic() {
        return this.reference != null && this.reference.isStatic();
    }

    public char[] readableName() {
        return this.onDemand ? CharOperation.concat(CharOperation.concatWith(this.compoundName, '.'), ".*".toCharArray()) : CharOperation.concatWith(this.compoundName, '.');
    }

    public String toString() {
        return "import : " + new String(this.readableName());
    }
}
