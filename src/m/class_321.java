package m;

import m.class_40;
import m.class_46;
import m.class_58;

public class class_321 {

    private class_40[][][] field_1826;

    class_58 field_1827;

    int field_1828;

    int field_1829;

    class_40 field_1830;

    boolean field_1831;

    class_40[] field_1832;

    public class_321(class_58 var1) {
        this.field_1827 = var1;
        class_46[] var2 = var1.field_279;
        int var3 = var2.length;
        this.field_1826 = new class_40[var3][3][];
        this.field_1832 = new class_40[var3];
    }

    public boolean method_3203() {
        if (this.field_1828 > 0) {
            return false;
        } else {
            this.field_1829 = 2;
            return true;
        }
    }

    public class_40[] method_3204(class_46 var1, int var2) {
        return this.field_1826[var1.field_221][var2];
    }

    public boolean method_3205() {
        int var1 = 0;
        for (int var2 = this.field_1832.length; var1 < var2; ++var1) {
            if (this.field_1832[var1] == null) {
                return true;
            }
        }
        return false;
    }

    public void method_3206(class_46 var1, class_40 var2, int var3) {
        class_40[][] var4 = this.field_1826[var1.field_221];
        class_40[] var5 = var4[var3];
        int var6;
        if (var5 == null) {
            var6 = 0;
            var5 = new class_40[1];
        } else {
            var6 = var5.length;
            for (int var7 = 0; var7 < var6; ++var7) {
                class_40 var8 = var5[var7];
                if (var8 == var2) {
                    return;
                }
                if (var8 == null) {
                    var5[var7] = var2;
                    return;
                }
            }
            System.arraycopy(var5, 0, var5 = new class_40[var6 + 1], 0, var6);
        }
        var5[var6] = var2;
        var4[var3] = var5;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(20);
        var1.append("InferenceContex for ");
        int var2 = 0;
        int var3;
        for (var3 = this.field_1827.field_279.length; var2 < var3; ++var2) {
            var1.append(this.field_1827.field_279[var2]);
        }
        var1.append(this.field_1827);
        var1.append("\n\t[status=");
        switch (this.field_1829) {
            case 0:
                var1.append("ok]");
                break;
            case 1:
                var1.append("failed]");
                break;
            case 2:
                var1.append("raw-subst]");
        }
        if (this.field_1830 == null) {
            var1.append(" [expectedType=null]");
        } else {
            var1.append(" [expectedType=").append(this.field_1830.method_104()).append(']');
        }
        var1.append(" [depth=").append(this.field_1828).append(']');
        var1.append("\n\t[collected={");
        var2 = 0;
        for (var3 = this.field_1826 == null ? 0 : this.field_1826.length; var2 < var3; ++var2) {
            class_40[][] var4 = this.field_1826[var2];
            for (int var5 = 0; var5 <= 2; ++var5) {
                class_40[] var6 = var4[var5];
                if (var6 != null) {
                    int var7 = 0;
                    for (int var8 = var6.length; var7 < var8; ++var7) {
                        var1.append("\n\t\t").append(this.field_1827.field_279[var2].field_198);
                        switch (var5) {
                            case 0:
                                var1.append("=");
                                break;
                            case 1:
                                var1.append("<:");
                                break;
                            case 2:
                                var1.append(">:");
                        }
                        if (var6[var7] != null) {
                            var1.append(var6[var7].method_104());
                        }
                    }
                }
            }
        }
        var1.append("}]");
        var1.append("\n\t[inferred=");
        var2 = 0;
        var3 = 0;
        for (int var9 = this.field_1832 == null ? 0 : this.field_1832.length; var3 < var9; ++var3) {
            if (this.field_1832[var3] != null) {
                ++var2;
                var1.append('{').append(this.field_1827.field_279[var3].field_198);
                var1.append("=").append(this.field_1832[var3].method_104()).append('}');
            }
        }
        if (var2 == 0) {
            var1.append("{}");
        }
        var1.append(']');
        return var1.toString();
    }
}
