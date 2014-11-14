package j;

import h.class_114;
import h.class_126;
import h.class_146;
import h.class_162;
import h.class_164;
import h.class_165;
import h.class_166;
import h.class_167;
import h.class_89;
import h.class_92;
import j.class_251;
import j.RecoveryScanner;
import j.Parser;

public class class_257 extends class_251 {

    private int field_1110;

    private int field_1111;

    private int field_1112;

    private int field_1113;

    public boolean field_1114;

    public int field_1115;

    public class_164 field_1116;

    public class_257(int var1, int var2, int var3, class_251 var4, int var5) {
        super(var4, var5);
        this.field_1115 = -1;
        this.field_1110 = 0;
        this.field_1111 = var1;
        this.field_1112 = var2;
        this.field_1113 = var3;
    }

    public class_251 method_1838(class_114 var1, int var2) {
        return (class_251)(this.field_1116 == null && (var1.field_446 & 512) != 0 ? this : super.method_1838(var1, var2));
    }

    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        class_257 var10000 = new class_257(var1, var2, var3, this, var4);
        class_257 var5 = var10000;
        return var5;
    }

    public class_251 method_1872(class_164 var1, int var2) {
        this.field_1116 = var1;
        return (class_251)(this.field_1068 != null ? this.field_1068 : this);
    }

    public void method_1852() {
        Parser var1 = this.method_1844();
        if (this.field_1116 == null && this.field_1111 <= var1.field_1584) {
            Object var2 = null;
            boolean var3 = false;
            class_92 var4 = null;
            int var8;
            int var9;
            if (this.field_1114 && this.field_1111 < var1.field_1584) {
                char[] var5 = var1.field_1585[this.field_1111 + 1];
                long var6 = var1.field_1583[this.field_1111 + 1];
                var8 = (int)(var6 >>> 32);
                var9 = (int)var6;
                int var10 = this.field_1115 > -1 ? this.field_1115 : var9;
                class_162 var10000 = new class_162(RecoveryScanner.field_1301, ((long)var10 + 1L << 32) + (long)var10);
                class_162 var11 = var10000;
                class_92 var14 = new class_92(var5, var8, var9, var11);
                var4 = var14;
            }
            var1.field_1584 = this.field_1111;
            var1.field_1581 = this.field_1112;
            class_146 var16 = var1.method_2832();
            class_167 var13;
            class_126 var17;
            switch (this.field_1110) {
                case 1:
                    if (var1.field_1559 > -1 && var1.field_1560[var1.field_1559] instanceof class_92) {
                        var17 = null;
                        int var18 = var1.field_1558[var1.field_1557];
                        var8 = var1.field_1559 - var18 + 1;
                        if (var18 > 0) {
                            class_92[] var19;
                            if (var4 != null) {
                                var19 = new class_92[var18 + 1];
                                System.arraycopy(var1.field_1560, var8, var19, 0, var18);
                                --var1.field_1557;
                                var1.field_1559 -= var18;
                                var19[var18] = var4;
                                var9 = var4.field_445;
                            } else {
                                var19 = new class_92[var18];
                                System.arraycopy(var1.field_1560, var8, var19, 0, var18);
                                --var1.field_1557;
                                var1.field_1559 -= var18;
                                class_92 var22 = var19[var19.length - 1];
                                var9 = var22.field_475 != null ? (var22.field_475 instanceof class_164 ? ((class_164)var22.field_475).field_765 : var22.field_475.field_445) : var22.field_445;
                            }
                            var13 = new class_167(var16, this.field_1113);
                            class_167 var23 = var13;
                            var23.field_771 = var19;
                            var23.field_765 = var9;
                            var23.field_446 |= 32;
                            var2 = var23;
                            var3 = true;
                        }
                    }
                    break;
                case 2:
                    if (var1.field_1570 > -1) {
                        var17 = var1.field_1571[var1.field_1570--];
                        class_165 var15 = new class_165(var16, this.field_1113);
                        class_165 var7 = var15;
                        var7.field_769 = var17;
                        var7.field_765 = var17.field_445;
                        var7.field_446 |= 32;
                        var2 = var7;
                        var3 = true;
                    }
            }
            if (!var3) {
                if (var4 != null) {
                    var13 = new class_167(var16, this.field_1113);
                    class_167 var20 = var13;
                    var20.field_771 = new class_92[] {var4};
                    var20.field_765 = var4.field_475.field_445;
                    var20.field_446 |= 32;
                    var2 = var20;
                } else {
                    class_166 var12 = new class_166(var16, this.field_1113);
                    class_166 var21 = var12;
                    var21.field_765 = var21.field_445;
                    var21.field_446 |= 32;
                    var2 = var21;
                }
            }
            var1.field_1562 = this.method_1872((class_164)var2, this.field_1111);
            var1.method_2519(((class_164)var2).field_444, ((class_164)var2).field_765);
            if (this.field_1068 != null) {
                this.field_1068.method_1852();
            }
        }
    }

    public class_89 method_1845() {
        return this.field_1116;
    }

    public void method_1846() {
        if (this.field_1068 != null) {
            this.field_1068.method_1846();
        }
    }

    public void method_1873(int var1) {
        this.field_1110 = var1;
    }

    public String method_1850(int var1) {
        return this.field_1116 != null ? this.method_1848(var1) + "Recovered annotation:\n" + this.field_1116.method_757(var1 + 1, new StringBuffer(10)) : this.method_1848(var1) + "Recovered annotation: identiferPtr=" + this.field_1111 + " identiferlengthPtr=" + this.field_1112 + "\n";
    }

    public class_164 method_1874() {
        return this.field_1116;
    }

    public class_251 method_1853(int var1, int var2) {
        if (this.field_1069 > 0) {
            --this.field_1069;
            return this;
        } else {
            return (class_251)(this.field_1068 != null ? this.field_1068.method_1853(var1, var2) : this);
        }
    }

    public void method_1855() {
        this.method_1874();
    }
}
