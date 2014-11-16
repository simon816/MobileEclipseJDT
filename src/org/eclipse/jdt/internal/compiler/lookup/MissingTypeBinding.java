package org.eclipse.jdt.internal.compiler.lookup;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public class MissingTypeBinding extends BinaryTypeBinding {

    public MissingTypeBinding(PackageBinding var1, char[][] var2, LookupEnvironment var3) {
        this.compoundName = var2;
        this.computeId();
        this.tagBits |= 131264L;
        this.environment = var3;
        this.fPackage = var1;
        this.field_201 = new String(CharOperation.concatWith(var2, '/'));
        this.sourceName = var2[var2.length - 1];
        this.modifiers = 1;
        this.field_231 = null;
        this.field_233 = Binding.field_155;
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
        this.field_236 = Binding.field_156;
        this.fields = Binding.field_153;
        this.methods = Binding.field_154;
    }

    public List method_132(List var1) {
        if (var1 == null) {
            ArrayList var10000 = new ArrayList(5);
            var1 = var10000;
        } else if (((List)var1).contains(this)) {
            return (List)var1;
        }
        ((List)var1).add(this);
        return (List)var1;
    }

    public int problemId() {
        return 1;
    }

    void setMissingSuperclass(ReferenceBinding var1) {
        this.field_231 = var1;
    }

    public String toString() {
        return "[MISSING:" + new String(CharOperation.concatWith(this.compoundName, '.')) + "]";
    }
}
