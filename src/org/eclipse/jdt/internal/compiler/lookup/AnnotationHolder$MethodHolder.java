package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;

class AnnotationHolder$MethodHolder extends AnnotationHolder {

    AnnotationBinding[][] parameterAnnotations;

    AnnotationHolder$MethodHolder(AnnotationBinding[] var1, AnnotationBinding[][] var2) {
        this.setAnnotations(var1);
        this.parameterAnnotations = var2;
    }

    public AnnotationBinding[][] getParameterAnnotations() {
        return this.parameterAnnotations;
    }

    AnnotationHolder setAnnotations(AnnotationBinding[] var1) {
        this.annotations = var1 != null && var1.length != 0 ? var1 : Binding.NO_ANNOTATIONS;
        return this;
    }
}
