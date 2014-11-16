package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public class UnresolvedAnnotationBinding extends AnnotationBinding {

    private LookupEnvironment env;

    private boolean typeUnresolved;

    UnresolvedAnnotationBinding(ReferenceBinding var1, ElementValuePair[] var2, LookupEnvironment var3) {
        super(var1, var2);
        this.typeUnresolved = true;
        this.env = var3;
    }

    public ReferenceBinding getAnnotationType() {
        if (this.typeUnresolved) {
            this.type = BinaryTypeBinding.method_267(this.type, this.env, false);
            this.typeUnresolved = false;
        }
        return this.type;
    }
}
