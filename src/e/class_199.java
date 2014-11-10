package e;

import k.class_30;

public class class_199 implements class_30 {

    static final class_199[] field_880;

    private char[] field_881;

    private Object field_882;

    class_199(char[] var1, Object var2) {
        this.field_881 = var1;
        this.field_882 = var2;
    }

    public char[] method_85() {
        return this.field_881;
    }

    public Object method_86() {
        return this.field_882;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(this.field_881);
        var1.append('=');
        if (this.field_882 instanceof Object[]) {
            Object[] var2 = (Object[])((Object[])this.field_882);
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
            var1.append(this.field_882);
        }
        return var1.toString();
    }

    static {
        field_880 = new class_199[0];
    }
}
