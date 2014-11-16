package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.env.AccessRule;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;

public class AccessRuleSet {

    private AccessRule[] accessRules;

    public byte classpathEntryType;

    public String classpathEntryName;

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof AccessRuleSet)) {
            return false;
        } else {
            AccessRuleSet var2 = (AccessRuleSet)var1;
            if (this.classpathEntryType == var2.classpathEntryType && (this.classpathEntryName != null || var2.classpathEntryName == null) && this.classpathEntryName.equals(var2.classpathEntryName)) {
                int var3 = this.accessRules.length;
                if (var3 != var2.accessRules.length) {
                    return false;
                } else {
                    for (int var4 = 0; var4 < var3; ++var4) {
                        if (!this.accessRules[var4].equals(var2.accessRules[var4])) {
                            return false;
                        }
                    }
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public AccessRestriction getViolatedRestriction(char[] var1) {
        int var2 = 0;
        for (int var3 = this.accessRules.length; var2 < var3; ++var2) {
            AccessRule var4 = this.accessRules[var2];
            if (CharOperation.pathMatch(var4.pattern, var1, true, '/')) {
                switch (var4.method_3326()) {
                    case 16777496:
                    case 16777523:
                        AccessRestriction var10000 = new AccessRestriction(var4, this.classpathEntryType, this.classpathEntryName);
                        return var10000;
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    public String toString() {
        return this.toString(true);
    }

    public String toString(boolean var1) {
        StringBuffer var2 = new StringBuffer(200);
        var2.append("AccessRuleSet {");
        if (var1) {
            var2.append('\n');
        }
        int var3 = 0;
        for (int var4 = this.accessRules.length; var3 < var4; ++var3) {
            if (var1) {
                var2.append('\t');
            }
            AccessRule var5 = this.accessRules[var3];
            var2.append(var5);
            if (var1) {
                var2.append('\n');
            } else if (var3 < var4 - 1) {
                var2.append(", ");
            }
        }
        var2.append("} [classpath entry: ");
        var2.append(this.classpathEntryName);
        var2.append("]");
        return var2.toString();
    }
}
