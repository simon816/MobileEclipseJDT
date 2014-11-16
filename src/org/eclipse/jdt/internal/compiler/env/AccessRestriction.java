package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.AccessRule;

public class AccessRestriction {

    private AccessRule accessRule;

    public byte classpathEntryType;

    public String classpathEntryName;

    public AccessRestriction(AccessRule var1, byte var2, String var3) {
        this.accessRule = var1;
        this.classpathEntryName = var3;
        this.classpathEntryType = var2;
    }

    public int getProblemId() {
        return this.accessRule.method_3326();
    }

    public boolean ignoreIfBetter() {
        return this.accessRule.ignoreIfBetter();
    }
}
