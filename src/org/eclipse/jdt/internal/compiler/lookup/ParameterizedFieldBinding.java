package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class ParameterizedFieldBinding extends FieldBinding {

    public FieldBinding originalField;

    public ParameterizedFieldBinding(ParameterizedTypeBinding var1, FieldBinding var2) {
        super(var2.name, (TypeBinding)((var2.field_300 & 16384) != 0 ? var1 : ((var2.field_300 & 8) != 0 ? var2.type : Scope.substitute(var1, var2.type))), var2.field_300, var1, (Constant)null);
        this.originalField = var2;
        this.tagBits = var2.tagBits;
        this.field_304 = var2.field_304;
    }

    public Constant constant() {
        return this.originalField.constant();
    }

    public FieldBinding original() {
        return this.originalField.original();
    }

    public void setConstant(Constant var1) {
        this.originalField.setConstant(var1);
    }
}
