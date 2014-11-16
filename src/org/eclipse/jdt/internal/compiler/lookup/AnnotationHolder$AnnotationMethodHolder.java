package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder$MethodHolder;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;

class AnnotationHolder$AnnotationMethodHolder extends AnnotationHolder$MethodHolder {

    Object defaultValue;

    AnnotationHolder$AnnotationMethodHolder(AnnotationBinding[] var1, AnnotationBinding[][] var2, Object var3) {
        super(var1, var2);
        this.defaultValue = var3;
    }

    Object getDefaultValue() {
        return this.defaultValue;
    }
}
