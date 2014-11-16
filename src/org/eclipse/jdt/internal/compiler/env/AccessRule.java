package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.core.compiler.CharOperation;

public class AccessRule {

    public char[] pattern;

    public int problemId;

    public int hashCode() {
        return this.problemId * 17 + CharOperation.hashCode(this.pattern);
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof AccessRule)) {
            return false;
        } else {
            AccessRule var2 = (AccessRule)var1;
            return this.problemId != var2.problemId ? false : CharOperation.method_1364(this.pattern, var2.pattern);
        }
    }

    public int method_3326() {
        return this.problemId & -33554433;
    }

    public boolean ignoreIfBetter() {
        return (this.problemId & 33554432) != 0;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("pattern=");
        var1.append(this.pattern);
        switch (this.method_3326()) {
            case 16777496:
                var1.append(" (DISCOURAGED");
                break;
            case 16777523:
                var1.append(" (NON ACCESSIBLE");
                break;
            default:
                var1.append(" (ACCESSIBLE");
        }
        if (this.ignoreIfBetter()) {
            var1.append(" | IGNORE IF BETTER");
        }
        var1.append(')');
        return var1.toString();
    }
}
