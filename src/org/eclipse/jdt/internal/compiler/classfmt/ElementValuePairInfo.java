package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.env.IBinaryElementValuePair;

public class ElementValuePairInfo implements IBinaryElementValuePair {

    static final ElementValuePairInfo[] NoMembers;

    private char[] name;

    private Object value;

    ElementValuePairInfo(char[] var1, Object var2) {
        this.name = var1;
        this.value = var2;
    }

    public char[] getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(this.name);
        var1.append('=');
        if (this.value instanceof Object[]) {
            Object[] var2 = (Object[])((Object[])this.value);
            var1.append('{');
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                if (var3 > 0) {
                    var1.append(", ");
                }
                var1.append(var2[var3]);
            }
            var1.append('}');
        } else {
            var1.append(this.value);
        }
        return var1.toString();
    }

    static {
        NoMembers = new ElementValuePairInfo[0];
    }
}
