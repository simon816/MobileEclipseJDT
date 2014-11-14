package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.class_191;
import org.eclipse.jdt.internal.compiler.classfmt.class_194;
import org.eclipse.jdt.internal.compiler.classfmt.class_196;
import org.eclipse.jdt.internal.compiler.env.class_29;

public class class_195 extends class_194 {

    private class_196[] field_866;

    class_195(class_191 var1, Object var2, class_196[] var3) {
        super(var1, var2);
        this.field_866 = var3;
    }

    public class_29[] method_71() {
        return this.field_866;
    }

    protected void method_1136() {
        int var1 = 0;
        for (int var2 = this.field_866 == null ? 0 : this.field_866.length; var1 < var2; ++var1) {
            if (this.field_866[var1] != null) {
                this.field_866[var1].method_1154();
            }
        }
        super.method_1136();
    }

    protected void method_1102() {
        int var1 = 0;
        for (int var2 = this.field_866 == null ? 0 : this.field_866.length; var1 < var2; ++var1) {
            if (this.field_866[var1] != null) {
                this.field_866[var1].method_1102();
            }
        }
        super.method_1102();
    }

    protected void method_1141(StringBuffer var1) {
        super.method_1141(var1);
        int var2 = 0;
        for (int var3 = this.field_866 == null ? 0 : this.field_866.length; var2 < var3; ++var2) {
            var1.append(this.field_866[var2]);
            var1.append('\n');
        }
    }
}
