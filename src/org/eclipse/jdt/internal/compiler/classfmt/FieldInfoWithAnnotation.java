package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.FieldInfo;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;

public final class FieldInfoWithAnnotation extends FieldInfo {

    private AnnotationInfo[] annotations;

    FieldInfoWithAnnotation(FieldInfo var1, AnnotationInfo[] var2) {
        super(var1.reference, var1.constantPoolOffsets, var1.structOffset);
        this.field_808 = var1.field_808;
        this.field_809 = var1.field_809;
        this.constant = var1.constant;
        this.constantPoolOffsets = var1.constantPoolOffsets;
        this.field_811 = var1.field_811;
        this.field_812 = var1.field_812;
        this.field_813 = var1.field_813;
        this.field_814 = var1.field_814;
        this.tagBits = var1.tagBits;
        this.wrappedConstantValue = var1.wrappedConstantValue;
        this.annotations = var2;
    }

    public IBinaryAnnotation[] getAnnotations() {
        return this.annotations;
    }

    protected void initialize() {
        int var1 = 0;
        for (int var2 = this.annotations.length; var1 < var2; ++var1) {
            this.annotations[var1].initialize();
        }
        super.initialize();
    }

    protected void reset() {
        if (this.annotations != null) {
            int var1 = 0;
            for (int var2 = this.annotations.length; var1 < var2; ++var1) {
                this.annotations[var1].reset();
            }
        }
        super.reset();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(this.getClass().getName());
        if (this.annotations != null) {
            var1.append('\n');
            for (int var2 = 0; var2 < this.annotations.length; ++var2) {
                var1.append(this.annotations[var2]);
                var1.append('\n');
            }
        }
        this.toStringContent(var1);
        return var1.toString();
    }
}
