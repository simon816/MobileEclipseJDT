package org.eclipse.jdt.internal.compiler.batch;

import org.eclipse.jdt.internal.compiler.batch.FileSystem$Classpath;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.util.SuffixConstants;

public abstract class ClasspathLocation implements FileSystem$Classpath, SuffixConstants {

    String field_937;

    char[] field_938;

    public AccessRuleSet field_939;

    public String field_940;

    protected ClasspathLocation(AccessRuleSet var1, String var2) {
        this.field_939 = var1;
        this.field_940 = var2;
    }

    protected AccessRestriction method_1279(String var1) {
        if (this.field_939 == null) {
            return null;
        } else {
            char[] var2 = var1.substring(0, var1.length() - field_1.length).toCharArray();
            return this.field_939.method_3324(var2);
        }
    }
}
