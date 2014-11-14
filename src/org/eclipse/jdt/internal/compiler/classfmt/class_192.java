package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.class_191;
import org.eclipse.jdt.internal.compiler.classfmt.class_196;
import org.eclipse.jdt.internal.compiler.env.class_29;

public class class_192 extends class_191 {

    protected class_196[] field_863;

    class_192(class_191 var1, class_196[] var2) {
        super(var1.field_805, var1.field_806, var1.field_807);
        this.field_863 = var2;
        this.field_853 = var1.field_853;
        this.field_854 = var1.field_854;
        this.field_855 = var1.field_855;
        this.field_856 = var1.field_856;
        this.field_857 = var1.field_857;
        this.field_858 = var1.field_858;
        this.field_859 = var1.field_859;
        this.field_860 = var1.field_860;
    }

    public class_29[] method_71() {
        return this.field_863;
    }

    protected void method_1136() {
        int var1 = 0;
        for (int var2 = this.field_863 == null ? 0 : this.field_863.length; var1 < var2; ++var1) {
            if (this.field_863[var1] != null) {
                this.field_863[var1].method_1154();
            }
        }
        super.method_1136();
    }

    protected void method_1102() {
        int var1 = 0;
        for (int var2 = this.field_863 == null ? 0 : this.field_863.length; var1 < var2; ++var1) {
            if (this.field_863[var1] != null) {
                this.field_863[var1].method_1102();
            }
        }
        super.method_1102();
    }

    protected void method_1141(StringBuffer var1) {
        super.method_1141(var1);
        int var2 = 0;
        for (int var3 = this.field_863 == null ? 0 : this.field_863.length; var2 < var3; ++var2) {
            var1.append(this.field_863[var2]);
            var1.append('\n');
        }
    }
}
