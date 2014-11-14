package org.eclipse.jdt.internal.compiler.batch;

import org.eclipse.jdt.internal.compiler.batch.class_4;
import org.eclipse.jdt.internal.compiler.env.class_343;
import org.eclipse.jdt.internal.compiler.env.class_345;
import org.eclipse.jdt.internal.compiler.util.SuffixConstants;

public abstract class class_219 implements class_4, SuffixConstants {

    String field_937;

    char[] field_938;

    public class_343 field_939;

    public String field_940;

    protected class_219(class_343 var1, String var2) {
        this.field_939 = var1;
        this.field_940 = var2;
    }

    protected class_345 method_1279(String var1) {
        if (this.field_939 == null) {
            return null;
        } else {
            char[] var2 = var1.substring(0, var1.length() - field_1.length).toCharArray();
            return this.field_939.method_3324(var2);
        }
    }
}
