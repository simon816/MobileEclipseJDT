package k;

import b.class_233;
import k.class_344;
import k.class_345;

// $FF: renamed from: k.a
public class class_343 {

    // $FF: renamed from: a k.b[]
    private class_344[] field_1974;
    // $FF: renamed from: a byte
    public byte field_1975;
    // $FF: renamed from: a java.lang.String
    public String field_1976;

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof class_343)) {
            return false;
        } else {
            class_343 var2 = (class_343)var1;
            if (this.field_1975 == var2.field_1975 && (this.field_1976 != null || var2.field_1976 == null) && this.field_1976.equals(var2.field_1976)) {
                int var3 = this.field_1974.length;
                if (var3 != var2.field_1974.length) {
                    return false;
                } else {
                    for (int var4 = 0; var4 < var3; ++var4) {
                        if (!this.field_1974[var4].equals(var2.field_1974[var4])) {
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

    // $FF: renamed from: a (char[]) k.c
    public class_345 method_3324(char[] var1) {
        int var2 = 0;
        for (int var3 = this.field_1974.length; var2 < var3; ++var2) {
            class_344 var4 = this.field_1974[var2];
            if (class_233.method_1379(var4.field_1977, var1, true, '/')) {
                switch (var4.method_3326()) {
                    case 16777496:
                    case 16777523:
                        class_345 var10000 = new class_345(var4, this.field_1975, this.field_1976);
                        return var10000;
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    public String toString() {
        return this.method_3325(true);
    }

    // $FF: renamed from: a (boolean) java.lang.String
    public String method_3325(boolean var1) {
        StringBuffer var2 = new StringBuffer(200);
        var2.append("AccessRuleSet {");
        if (var1) {
            var2.append('\n');
        }
        int var3 = 0;
        for (int var4 = this.field_1974.length; var3 < var4; ++var3) {
            if (var1) {
                var2.append('\t');
            }
            class_344 var5 = this.field_1974[var3];
            var2.append(var5);
            if (var1) {
                var2.append('\n');
            } else if (var3 < var4 - 1) {
                var2.append(", ");
            }
        }
        var2.append("} [classpath entry: ");
        var2.append(this.field_1976);
        var2.append("]");
        return var2.toString();
    }
}
