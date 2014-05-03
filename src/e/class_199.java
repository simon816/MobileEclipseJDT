package e;

import k.class_30;

// $FF: renamed from: e.e
public class class_199 implements class_30 {

    // $FF: renamed from: a e.e[]
    static final class_199[] field_880;
    // $FF: renamed from: a char[]
    private char[] field_881;
    // $FF: renamed from: a java.lang.Object
    private Object field_882;

    // $FF: renamed from: <init> (char[], java.lang.Object) void
    class_199(char[] var1, Object var2) {
        this.field_881 = var1;
        this.field_882 = var2;
    }

    // $FF: renamed from: a () char[]
    public char[] method_85() {
        return this.field_881;
    }

    // $FF: renamed from: a () java.lang.Object
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

    // $FF: renamed from: <clinit> () void
    static {
        field_880 = new class_199[0];
    }
}
