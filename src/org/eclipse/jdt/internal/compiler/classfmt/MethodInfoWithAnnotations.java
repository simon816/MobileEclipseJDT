package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.MethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;

public class MethodInfoWithAnnotations extends MethodInfo {

    protected AnnotationInfo[] annotations;

    MethodInfoWithAnnotations(MethodInfo var1, AnnotationInfo[] var2) {
        super(var1.reference, var1.constantPoolOffsets, var1.structOffset);
        this.annotations = var2;
        this.field_853 = var1.field_853;
        this.field_854 = var1.field_854;
        this.field_855 = var1.field_855;
        this.field_856 = var1.field_856;
        this.field_857 = var1.field_857;
        this.field_858 = var1.field_858;
        this.field_859 = var1.field_859;
        this.tagBits = var1.tagBits;
    }

    public IBinaryAnnotation[] getAnnotations() {
        return this.annotations;
    }

    protected void initialize() {
        int var1 = 0;
        for (int var2 = this.annotations == null ? 0 : this.annotations.length; var1 < var2; ++var1) {
            if (this.annotations[var1] != null) {
                this.annotations[var1].initialize();
            }
        }
        super.initialize();
    }

    protected void reset() {
        int var1 = 0;
        for (int var2 = this.annotations == null ? 0 : this.annotations.length; var1 < var2; ++var1) {
            if (this.annotations[var1] != null) {
                this.annotations[var1].reset();
            }
        }
        super.reset();
    }

    protected void toStringContent(StringBuffer var1) {
        super.toStringContent(var1);
        int var2 = 0;
        for (int var3 = this.annotations == null ? 0 : this.annotations.length; var2 < var3; ++var2) {
            var1.append(this.annotations[var2]);
            var1.append('\n');
        }
    }
}
