package j;

import h.class_112;
import h.class_114;
import h.class_121;
import h.class_122;
import h.class_123;
import h.class_136;
import h.class_146;
import h.class_164;
import h.class_89;
import h.class_93;
import h.class_98;
import j.class_251;
import j.class_253;
import j.class_254;
import j.class_255;
import j.class_257;
import j.class_258;
import j.Parser;

public class class_260 extends class_258 {

    public class_114 field_1124;

    public class_257[] field_1125;

    public int field_1126;

    public int field_1127;

    public int field_1128;

    public class_260[] field_1129;

    public int field_1130;

    public class_253[] field_1131;

    public int field_1132;

    public class_255[] field_1133;

    public int field_1134;

    public boolean field_1135;

    public int field_1136;

    public boolean field_1137;

    public class_123[] field_1138;

    public int field_1139;

    int field_1140;

    int field_1141;

    class_257[] field_1142;

    int field_1143;

    public class_260(class_114 var1, class_251 var2, int var3) {
        super(var1, var2, var3);
        this.field_1135 = false;
        this.field_1137 = false;
        this.field_1141 = -1;
        this.field_1124 = var1;
        if (var1.field_598 != null && var1.field_598.field_691 == null) {
            this.field_1070 = true;
        } else {
            this.field_1070 = !this.method_1883();
        }
        this.field_1137 = class_114.method_859(var1.field_577) == 3;
        if (this.field_1070) {
            ++this.field_1069;
        }
        this.field_1135 = this.method_1844().field_1621 || this.method_1844().field_1622;
    }

    public class_251 method_1832(class_93 var1, int var2) {
        if (this.field_1124.field_593 != 0 && var1.field_480 > this.field_1124.field_593) {
            this.field_1138 = null;
            this.method_1846();
            return this.field_1068.method_1832(var1, var2);
        } else {
            if (this.field_1133 == null) {
                this.field_1133 = new class_255[5];
                this.field_1134 = 0;
            } else if (this.field_1134 == this.field_1133.length) {
                System.arraycopy(this.field_1133, 0, this.field_1133 = new class_255[2 * this.field_1134], 0, this.field_1134);
            }
            class_255 var10000 = new class_255(var1, this, var2, this.field_1071);
            class_255 var3 = var10000;
            this.field_1133[this.field_1134++] = var3;
            if (this.field_1138 != null) {
                var3.method_1867(this.field_1138, this.field_1139);
                this.field_1138 = null;
            }
            if (this.field_1143 > 0) {
                var3.method_1868(this.field_1142, this.field_1143, this.field_1140, this.field_1141);
            }
            this.method_1846();
            this.field_1137 = false;
            if (!this.field_1070) {
                this.field_1070 = true;
                ++this.field_1069;
            }
            if (var1.field_481 == 0) {
                return var3;
            }
            return this;
        }
    }

    public class_251 method_1833(class_112 var1, int var2) {
        this.field_1138 = null;
        this.method_1846();
        byte var3 = 0;
        if (this.method_1844().field_1614 != 0) {
            var3 = 8;
        }
        class_122 var10001 = new class_122(var1, var3);
        return this.method_1834(var10001, var2);
    }

    public class_251 method_1834(class_121 var1, int var2) {
        this.field_1138 = null;
        if (this.field_1124.field_593 != 0 && var1.field_653 > this.field_1124.field_593) {
            this.method_1846();
            return this.field_1068.method_1834(var1, var2);
        } else {
            if (this.field_1131 == null) {
                this.field_1131 = new class_253[5];
                this.field_1132 = 0;
            } else if (this.field_1132 == this.field_1131.length) {
                System.arraycopy(this.field_1131, 0, this.field_1131 = new class_253[2 * this.field_1132], 0, this.field_1132);
            }
            Object var3;
            switch (var1.method_887()) {
                case 1:
                case 3:
                    class_253 var4 = new class_253(var1, this, var2);
                    var3 = var4;
                    break;
                case 2:
                    class_254 var10000 = new class_254(var1, this, var2);
                    var3 = var10000;
                    break;
                default:
                    return this;
            }
            this.field_1131[this.field_1132++] = (class_253)var3;
            if (this.field_1143 > 0) {
                ((class_253)var3).method_1862(this.field_1142, this.field_1143, this.field_1140, this.field_1141);
            }
            this.method_1846();
            if (!this.field_1070) {
                this.field_1070 = true;
                ++this.field_1069;
            }
            if (var1.field_652 == 0) {
                return (class_251) var3;
            }
            return this;
        }
    }

    public class_251 method_1838(class_114 var1, int var2) {
        this.field_1138 = null;
        if (this.field_1124.field_593 != 0 && var1.field_592 > this.field_1124.field_593) {
            this.method_1846();
            return this.field_1068.method_1838(var1, var2);
        } else {
            this.field_1137 = false;
            if ((var1.field_446 & 512) != 0) {
                if (this.field_1134 > 0) {
                    class_255 var4 = this.field_1133[this.field_1134 - 1];
                    var4.field_1088.field_491 = 0;
                    var4.field_1088.field_481 = 0;
                    ++var4.field_1069;
                    this.method_1846();
                    return var4.method_1838(var1, var2);
                } else {
                    return this;
                }
            } else {
                if (this.field_1129 == null) {
                    this.field_1129 = new class_260[5];
                    this.field_1130 = 0;
                } else if (this.field_1130 == this.field_1129.length) {
                    System.arraycopy(this.field_1129, 0, this.field_1129 = new class_260[2 * this.field_1130], 0, this.field_1130);
                }
                class_260 var10000 = new class_260(var1, this, var2);
                class_260 var3 = var10000;
                this.field_1129[this.field_1130++] = var3;
                if (this.field_1143 > 0) {
                    var3.method_1881(this.field_1142, this.field_1143, this.field_1140, this.field_1141);
                }
                this.method_1846();
                if (!this.field_1070) {
                    this.field_1070 = true;
                    ++this.field_1069;
                }
                return var1.field_593 == 0 ? var3 : this;
            }
        }
    }

    public void method_1880(class_123[] var1, int var2) {
        this.field_1138 = var1;
        this.field_1139 = var2;
    }

    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        if (this.field_1142 == null) {
            this.field_1142 = new class_257[5];
            this.field_1143 = 0;
        } else if (this.field_1143 == this.field_1142.length) {
            System.arraycopy(this.field_1142, 0, this.field_1142 = new class_257[2 * this.field_1143], 0, this.field_1143);
        }
        class_257 var10000 = new class_257(var1, var2, var3, this, var4);
        class_257 var5 = var10000;
        this.field_1142[this.field_1143++] = var5;
        return var5;
    }

    public void method_1840(int var1, int var2) {
        this.field_1140 |= var1;
        if (this.field_1141 < 0) {
            this.field_1141 = var2;
        }
    }

    public void method_1881(class_257[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            class_164[] var5 = this.field_1124.field_579;
            if (var5 != null) {
                this.field_1125 = new class_257[var2];
                this.field_1126 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].field_1116 == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.field_1125[this.field_1126++] = var1[var6];
                }
            } else {
                this.field_1125 = var1;
                this.field_1126 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1127 = var3;
            this.field_1128 = var4;
        }
    }

    public int method_1882() {
        return this.field_1136 == 0 ? this.field_1124.field_593 : this.field_1136;
    }

    public boolean method_1883() {
        return this.field_1124.field_582 == null ? (this.field_1124.field_581 == null ? (this.field_1124.field_601 == null ? this.field_1124.field_594 == this.field_1124.field_445 + 1 : this.field_1124.field_594 == this.field_1124.field_601[this.field_1124.field_601.length - 1].field_445 + 1) : this.field_1124.field_594 == this.field_1124.field_581.field_445 + 1) : this.field_1124.field_594 == this.field_1124.field_582[this.field_1124.field_582.length - 1].field_445 + 1;
    }

    public class_260 method_1843() {
        for (class_251 var1 = this.field_1068; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_260) {
                return (class_260)var1;
            }
        }
        return null;
    }

    public class_89 method_1845() {
        return this.field_1124;
    }

    public void method_1846() {
        this.field_1142 = null;
        this.field_1143 = 0;
        this.field_1140 = 0;
        this.field_1141 = -1;
    }

    public String method_1850(int var1) {
        StringBuffer var2 = new StringBuffer(this.method_1848(var1));
        var2.append("Recovered type:\n");
        if ((this.field_1124.field_446 & 512) != 0) {
            var2.append(this.method_1848(var1));
            var2.append(" ");
        }
        this.field_1124.method_757(var1 + 1, var2);
        int var3;
        if (this.field_1125 != null) {
            for (var3 = 0; var3 < this.field_1126; ++var3) {
                var2.append("\n");
                var2.append(this.field_1125[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1129 != null) {
            for (var3 = 0; var3 < this.field_1130; ++var3) {
                var2.append("\n");
                var2.append(this.field_1129[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1131 != null) {
            for (var3 = 0; var3 < this.field_1132; ++var3) {
                var2.append("\n");
                var2.append(this.field_1131[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1133 != null) {
            for (var3 = 0; var3 < this.field_1134; ++var3) {
                var2.append("\n");
                var2.append(this.field_1133[var3].method_1850(var1 + 1));
            }
        }
        return var2.toString();
    }

    public void method_1851(int var1) {
        this.field_1070 = true;
        this.field_1124.field_594 = var1;
    }

    public class_98 method_1876() {
        if ((this.field_1124.field_446 & 512) != 0 && !this.field_1135) {
            return null;
        } else {
            class_114 var1 = this.method_1884();
            if ((var1.field_446 & 512) != 0) {
                class_136 var2 = var1.field_598;
                if (var2.field_673 == -1) {
                    var2.field_673 = var1.field_593;
                }
                return var2;
            } else {
                return var1;
            }
        }
    }

    public class_114 method_1884() {
        int var1 = this.field_1124.field_594;
        if (this.field_1127 != 0) {
            this.field_1124.field_577 |= this.field_1127;
            if (this.field_1128 < this.field_1124.field_592) {
                this.field_1124.field_592 = this.field_1128;
            }
        }
        int var2;
        int var4;
        if (this.field_1126 > 0) {
            var2 = this.field_1124.field_579 == null ? 0 : this.field_1124.field_579.length;
            class_164[] var3 = new class_164[var2 + this.field_1126];
            if (var2 > 0) {
                System.arraycopy(this.field_1124.field_579, 0, var3, this.field_1126, var2);
            }
            for (var4 = 0; var4 < this.field_1126; ++var4) {
                var3[var4] = this.field_1125[var4].method_1874();
            }
            this.field_1124.field_579 = var3;
            var4 = this.field_1125[0].field_1116.field_444;
            if (var4 < this.field_1124.field_592) {
                this.field_1124.field_592 = var4;
            }
        }
        if (this.field_1130 > 0) {
            var2 = this.field_1124.field_585 == null ? 0 : this.field_1124.field_585.length;
            class_114[] var10 = new class_114[var2 + this.field_1130];
            if (var2 > 0) {
                System.arraycopy(this.field_1124.field_585, 0, var10, 0, var2);
            }
            if (this.field_1129[this.field_1130 - 1].field_1124.field_593 == 0) {
                var4 = this.method_1882();
                this.field_1129[this.field_1130 - 1].field_1124.field_593 = var4;
                this.field_1129[this.field_1130 - 1].field_1124.field_595 = var4;
            }
            for (var4 = 0; var4 < this.field_1130; ++var4) {
                var10[var2 + var4] = this.field_1129[var4].method_1884();
            }
            this.field_1124.field_585 = var10;
            if (var10[var10.length - 1].field_593 > var1) {
                var1 = var10[var10.length - 1].field_593;
            }
        }
        if (this.field_1132 > 0) {
            var2 = this.field_1124.field_583 == null ? 0 : this.field_1124.field_583.length;
            class_121[] var11 = new class_121[var2 + this.field_1132];
            if (var2 > 0) {
                System.arraycopy(this.field_1124.field_583, 0, var11, 0, var2);
            }
            if (this.field_1131[this.field_1132 - 1].field_1073.field_652 == 0) {
                var4 = this.method_1882();
                this.field_1131[this.field_1132 - 1].field_1073.field_652 = var4;
                this.field_1131[this.field_1132 - 1].field_1073.field_651 = var4;
            }
            for (var4 = 0; var4 < this.field_1132; ++var4) {
                var11[var2 + var4] = this.field_1131[var4].method_1863();
            }
            this.field_1124.field_583 = var11;
            if (var11[var11.length - 1].field_652 > var1) {
                var1 = var11[var11.length - 1].field_652;
            }
        }
        var2 = this.field_1124.field_584 == null ? 0 : this.field_1124.field_584.length;
        boolean var12 = false;
        boolean var14 = false;
        boolean var5 = false;
        int var6 = -1;
        class_93[] var7;
        int var8;
        int var13;
        if (this.field_1134 > 0) {
            var7 = new class_93[var2 + this.field_1134];
            class_93 var9;
            for (var8 = 0; var8 < var2; ++var8) {
                var9 = this.field_1124.field_584[var8];
                if (var9.method_796()) {
                    var6 = var8;
                }
                if (var9.method_792()) {
                    var5 = true;
                }
                var7[var8] = var9;
            }
            if (this.field_1133[this.field_1134 - 1].field_1088.field_481 == 0) {
                var8 = this.method_1882();
                this.field_1133[this.field_1134 - 1].field_1088.field_481 = var8;
                this.field_1133[this.field_1134 - 1].field_1088.field_491 = var8;
            }
            for (var8 = 0; var8 < this.field_1134; ++var8) {
                var9 = this.field_1133[var8].method_1866();
                if (var9.method_795()) {
                    var14 = true;
                }
                if (var9.method_792()) {
                    var5 = true;
                }
                var7[var2 + var8] = var9;
            }
            this.field_1124.field_584 = var7;
            if (var7[var7.length - 1].field_481 > var1) {
                var1 = var7[var7.length - 1].field_481;
            }
            if (var5) {
                this.field_1124.field_446 |= 2048;
            }
            var12 = this.field_1124.method_850(this.method_1844());
        } else {
            for (var13 = 0; var13 < var2; ++var13) {
                if (this.field_1124.field_584[var13].method_795()) {
                    var12 = true;
                }
            }
        }
        if (this.field_1124.method_862()) {
            boolean var15 = false;
            for (var8 = 0; var8 < var2; ++var8) {
                if (this.field_1124.field_584[var8].method_794()) {
                    var15 = true;
                    break;
                }
            }
            if (!var15) {
                this.field_1124.method_845();
            }
        }
        if (var6 >= 0 && var14) {
            var7 = new class_93[this.field_1124.field_584.length - 1];
            if (var6 != 0) {
                System.arraycopy(this.field_1124.field_584, 0, var7, 0, var6);
            }
            if (var6 != this.field_1124.field_584.length - 1) {
                System.arraycopy(this.field_1124.field_584, var6 + 1, var7, var6, this.field_1124.field_584.length - var6 - 1);
            }
            this.field_1124.field_584 = var7;
        } else {
            var13 = class_114.method_859(this.field_1124.field_577);
            if (!var12 && var13 != 2 && var13 != 4 && this.field_1124.field_598 == null) {
                boolean var17 = false;
                for (class_251 var16 = this.field_1068; var16 != null; var16 = var16.field_1068) {
                    if (var16 instanceof class_253) {
                        var17 = true;
                        break;
                    }
                }
                this.field_1124.method_851(!this.method_1844().field_1564 || var17, true);
            }
        }
        if (this.field_1068 instanceof class_260) {
            this.field_1124.field_446 |= 1024;
        } else if (this.field_1068 instanceof class_255) {
            this.field_1124.field_446 |= 256;
        }
        if (this.field_1124.field_593 == 0) {
            this.field_1124.field_593 = var1;
            this.field_1124.field_595 = var1;
        }
        return this.field_1124;
    }

    public void method_1852() {
        if (this.method_1883() && this.field_1124.field_598 == null) {
            Parser var1 = this.method_1844();
            int var2;
            int var3;
            boolean var4;
            int var5;
            if (var1.field_1595 > 0 && var1.field_1557 > 0) {
                var2 = var1.field_1558[var1.field_1557];
                var3 = var1.field_1559 - var2;
                var4 = var3 >= 0;
                if (var4) {
                    if (!(var1.field_1560[var3] instanceof class_114)) {
                        var4 = false;
                    }
                    var5 = 1;
                    for (int var6 = var2 + 1; var5 < var6; ++var5) {
                        if (!(var1.field_1560[var3 + var5] instanceof class_146)) {
                            var4 = false;
                        }
                    }
                }
                if (var4) {
                    var1.method_2575();
                }
            } else if (var1.field_1596 > 0) {
                var2 = var1.field_1596;
                var3 = var1.field_1577;
                var4 = var3 + 1 >= var2 && var1.field_1559 > -1;
                if (var4) {
                    if (!(var1.field_1560[var1.field_1559] instanceof class_114)) {
                        var4 = false;
                    }
                    while (var3 + 1 > var2 && !(var1.field_1578[var3] instanceof class_123)) {
                        --var3;
                    }
                    for (var5 = 0; var5 < var2; ++var5) {
                        if (!(var1.field_1578[var3 - var5] instanceof class_123)) {
                            var4 = false;
                        }
                    }
                }
                if (var4) {
                    class_114 var7 = (class_114)var1.field_1560[var1.field_1559];
                    System.arraycopy(var1.field_1578, var3 - var2 + 1, var7.field_601 = new class_123[var2], 0, var2);
                    var7.field_594 = var7.field_601[var2 - 1].field_652 + 1;
                    var1.field_1596 = 0;
                    var1.field_1590 = var7.field_594;
                }
            }
        }
    }

    public class_251 method_1853(int var1, int var2) {
        if (--this.field_1069 <= 0 && this.field_1068 != null) {
            this.method_1856(var1, var2);
            this.field_1136 = var1 - 1;
            return this.field_1068;
        } else {
            return this;
        }
    }

    public class_251 method_1854(int var1, int var2) {
        if (this.field_1069 == 0) {
            Parser var3 = this.method_1844();
            switch (var3.field_1593) {
                case -1:
                case 10:
                case 11:
                case 13:
                case 99:
                case 106:
                    if (var3.field_1614 == 0) {
                        break;
                    }
                default:
                    this.field_1070 = true;
                    this.field_1069 = 1;
            }
        }
        if (this.field_1069 == 1) {
            class_112 var10000 = new class_112(0);
            class_112 var6 = var10000;
            Parser var4 = this.method_1844();
            var6.field_444 = var4.field_1628.field_1230;
            class_122 var5;
            class_122 var7;
            if (var4.field_1614 == 0) {
                var7 = new class_122(var6, 0);
                var5 = var7;
            } else {
                var7 = new class_122(var6, 8);
                var5 = var7;
                var5.field_653 = var4.field_1614;
            }
            var5.field_666 = var4.field_1628.field_1231;
            return this.method_1834(var5, 1);
        } else {
            return super.method_1854(var1, var2);
        }
    }

    public void method_1855() {
        this.method_1884();
    }

    public void method_1856(int var1, int var2) {
        if (this.field_1124.field_593 == 0) {
            this.field_1136 = 0;
            this.field_1124.field_593 = var2;
            this.field_1124.field_595 = var2;
        }
    }
}
