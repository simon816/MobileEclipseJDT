package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.MethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.MethodInfoWithAnnotations;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;

class MethodInfoWithParameterAnnotations extends MethodInfoWithAnnotations {

    private AnnotationInfo[][] parameterAnnotations;

    MethodInfoWithParameterAnnotations(MethodInfo var1, AnnotationInfo[] var2, AnnotationInfo[][] var3) {
        super(var1, var2);
        this.parameterAnnotations = var3;
    }

    public IBinaryAnnotation[] getParameterAnnotations(int var1) {
        return this.parameterAnnotations[var1];
    }

    protected void initialize() {
        int var1 = 0;
        for (int var2 = this.parameterAnnotations == null ? 0 : this.parameterAnnotations.length; var1 < var2; ++var1) {
            AnnotationInfo[] var3 = this.parameterAnnotations[var1];
            int var4 = 0;
            for (int var5 = var3 == null ? 0 : var3.length; var4 < var5; ++var4) {
                var3[var4].initialize();
            }
        }
        super.initialize();
    }

    protected void reset() {
        int var1 = 0;
        for (int var2 = this.parameterAnnotations == null ? 0 : this.parameterAnnotations.length; var1 < var2; ++var1) {
            AnnotationInfo[] var3 = this.parameterAnnotations[var1];
            int var4 = 0;
            for (int var5 = var3 == null ? 0 : var3.length; var4 < var5; ++var4) {
                var3[var4].reset();
            }
        }
        super.reset();
    }

    protected void toStringContent(StringBuffer var1) {
        super.toStringContent(var1);
        int var2 = 0;
        for (int var3 = this.parameterAnnotations == null ? 0 : this.parameterAnnotations.length; var2 < var3; ++var2) {
            var1.append("param" + (var2 - 1));
            var1.append('\n');
            AnnotationInfo[] var4 = this.parameterAnnotations[var2];
            int var5 = 0;
            for (int var6 = var4 == null ? 0 : var4.length; var5 < var6; ++var5) {
                var1.append(var4[var5]);
                var1.append('\n');
            }
        }
    }
}
