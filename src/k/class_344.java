package k;

import b.class_233;

// $FF: renamed from: k.b
public class class_344 {

    // $FF: renamed from: a char[]
    public char[] field_1977;
    // $FF: renamed from: a int
    public int field_1978;

    public int hashCode() {
        return this.field_1978 * 17 + class_233.method_1369(this.field_1977);
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class_344)) {
            return false;
        } else {
            class_344 var2 = (class_344)var1;
            return this.field_1978 != var2.field_1978 ? false : class_233.method_1364(this.field_1977, var2.field_1977);
        }
    }

    // $FF: renamed from: a () int
    public int method_3326() {
        return this.field_1978 & -33554433;
    }

    // $FF: renamed from: a () boolean
    public boolean method_3327() {
        return (this.field_1978 & 33554432) != 0;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("pattern=");
        var1.append(this.field_1977);
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
        if (this.method_3327()) {
            var1.append(" | IGNORE IF BETTER");
        }
        var1.append(')');
        return var1.toString();
    }
}
