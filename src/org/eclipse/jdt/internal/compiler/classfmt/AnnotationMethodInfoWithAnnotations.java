package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.MethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationMethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;

public class AnnotationMethodInfoWithAnnotations extends AnnotationMethodInfo {

    private AnnotationInfo[] annotations;

    AnnotationMethodInfoWithAnnotations(MethodInfo var1, Object var2, AnnotationInfo[] var3) {
        super(var1, var2);
        this.annotations = var3;
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
