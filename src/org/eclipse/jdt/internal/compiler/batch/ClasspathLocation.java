package org.eclipse.jdt.internal.compiler.batch;

import org.eclipse.jdt.internal.compiler.batch.FileSystem$Classpath;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.util.SuffixConstants;

public abstract class ClasspathLocation implements FileSystem$Classpath, SuffixConstants {

    String path;

    char[] normalizedPath;

    public AccessRuleSet accessRuleSet;

    public String destinationPath;

    protected ClasspathLocation(AccessRuleSet var1, String var2) {
        this.accessRuleSet = var1;
        this.destinationPath = var2;
    }

    protected AccessRestriction fetchAccessRestriction(String var1) {
        if (this.accessRuleSet == null) {
            return null;
        } else {
            char[] var2 = var1.substring(0, var1.length() - field_1.length).toCharArray();
            return this.accessRuleSet.getViolatedRestriction(var2);
        }
    }
}
