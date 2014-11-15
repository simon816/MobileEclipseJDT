package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;

public class class_66 extends class_65 {

    public class_65 field_312;

    public class_67 field_313;

    public class_66(class_65 var1) {
        super(CharOperation.method_1355(class_17.field_141, var1.field_302), var1.field_301, 16, true);
        this.field_305 |= 1024L;
        this.field_307 = 1;
        this.field_312 = var1;
    }

    public class_66(ReferenceBinding var1) {
        super(CharOperation.method_1355(class_17.field_142, String.valueOf(var1.method_199()).toCharArray()), var1, 16, true);
        this.field_305 |= 1024L;
        this.field_307 = 1;
    }
}
