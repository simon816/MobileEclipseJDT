package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder$MethodHolder;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder$AnnotationMethodHolder;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;

public class AnnotationHolder {

    AnnotationBinding[] annotations;

    public AnnotationHolder() {
    }

    static AnnotationHolder method_1169(AnnotationBinding[] var0, AnnotationBinding[][] var1, Object var2) {
        if (var1 != null) {
            boolean var3 = true;
            int var4 = var1.length;
            while (var3) {
                --var4;
                if (var4 < 0) {
                    break;
                }
                if (var1[var4] != null && var1[var4].length > 0) {
                    var3 = false;
                }
            }
            if (var3) {
                var1 = (AnnotationBinding[][])null;
            }
        }
        if (var2 != null) {
            AnnotationHolder$AnnotationMethodHolder var6 = new AnnotationHolder$AnnotationMethodHolder(var0, var1, var2);
            return var6;
        } else if (var1 != null) {
            AnnotationHolder$MethodHolder var5 = new AnnotationHolder$MethodHolder(var0, var1);
            return var5;
        } else {
            AnnotationHolder var10000 = new AnnotationHolder();
            return var10000.setAnnotations(var0);
        }
    }

    AnnotationBinding[] getAnnotations() {
        return this.annotations;
    }

    Object getDefaultValue() {
        return null;
    }

    public AnnotationBinding[][] getParameterAnnotations() {
        return (AnnotationBinding[][])null;
    }

    AnnotationHolder setAnnotations(AnnotationBinding[] var1) {
        if (var1 != null && var1.length != 0) {
            this.annotations = var1;
            return this;
        } else {
            return null;
        }
    }
}
