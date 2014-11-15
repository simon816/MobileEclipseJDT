package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_320;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_49;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public class class_204 extends class_203 {

    private LookupEnvironment field_888;

    private boolean field_889;

    class_204(ReferenceBinding var1, class_320[] var2, LookupEnvironment var3) {
        super(var1, var2);
        this.field_889 = true;
        this.field_888 = var3;
    }

    public ReferenceBinding method_1182() {
        if (this.field_889) {
            this.field_886 = class_49.method_267(this.field_886, this.field_888, false);
            this.field_889 = false;
        }
        return this.field_886;
    }
}
