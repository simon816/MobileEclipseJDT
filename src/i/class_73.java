package i;

import b.class_233;
import i.class_268;
import i.class_72;
import m.class_40;

public class class_73 extends class_72 {

    public int[] field_324;

    public int field_325;

    public class_40 field_326;

    public class_73(class_268 var1, class_40 var2) {
        super(var1);
        this.field_324 = new int[] { -1, -1};
        this.field_325 = 0;
        this.field_326 = var2;
    }

    public void method_447() {
        this.field_322.method_2362(this);
        this.field_323 = this.field_322.method_2206();
    }

    public void method_448() {
        int var1 = this.field_322.field_1208;
        if (this.field_324[this.field_325 - 1] == var1) {
            --this.field_325;
        } else {
            this.field_324[this.field_325++] = var1;
        }
    }

    public void method_449() {
        int var1 = this.field_322.field_1208;
        if (this.field_325 > 0 && this.field_324[this.field_325 - 1] == var1) {
            --this.field_325;
        } else {
            int var2;
            if (this.field_325 == (var2 = this.field_324.length)) {
                System.arraycopy(this.field_324, 0, this.field_324 = new int[var2 * 2], 0, var2);
            }
            this.field_324[this.field_325++] = var1;
        }
    }

    public String toString() {
        String var1 = this.getClass().getName();
        var1 = var1.substring(var1.lastIndexOf(46) + 1);
        StringBuffer var2 = new StringBuffer(var1);
        var2.append('@').append(Integer.toHexString(this.hashCode()));
        var2.append("(type=").append(this.field_326 == null ? class_233.field_994 : this.field_326.method_103());
        var2.append(", position=").append(this.field_323);
        var2.append(", ranges = ");
        if (this.field_325 == 0) {
            var2.append("[]");
        } else {
            for (int var3 = 0; var3 < this.field_325; ++var3) {
                if ((var3 & 1) == 0) {
                    var2.append("[").append(this.field_324[var3]);
                } else {
                    var2.append(",").append(this.field_324[var3]).append("]");
                }
            }
            if ((this.field_325 & 1) == 1) {
                var2.append(",?]");
            }
        }
        var2.append(')');
        return var2.toString();
    }
}
