package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public class SyntheticArgumentBinding extends LocalVariableBinding {

    public LocalVariableBinding actualOuterLocalVariable;

    public FieldBinding matchingField;

    public SyntheticArgumentBinding(LocalVariableBinding var1) {
        super(CharOperation.concat(TypeConstants.field_141, var1.name), var1.type, 16, true);
        this.tagBits |= 1024L;
        this.field_307 = 1;
        this.actualOuterLocalVariable = var1;
    }

    public SyntheticArgumentBinding(ReferenceBinding var1) {
        super(CharOperation.concat(TypeConstants.field_142, String.valueOf(var1.method_199()).toCharArray()), var1, 16, true);
        this.tagBits |= 1024L;
        this.field_307 = 1;
    }
}
