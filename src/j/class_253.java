package j;

import h.class_114;
import h.class_121;
import h.class_126;
import h.class_149;
import h.class_152;
import h.class_164;
import h.class_89;
import h.class_98;
import j.class_251;
import j.class_257;
import j.class_260;
import j.Parser;

public class class_253 extends class_251 {

    public class_121 field_1073;

    boolean field_1074;

    public class_257[] field_1075;

    public int field_1076;

    public int field_1077;

    public int field_1078;

    public class_260[] field_1079;

    public int field_1080;

    public class_253(class_121 var1, class_251 var2, int var3) {
        this(var1, var2, var3, (Parser)null);
    }

    public class_253(class_121 var1, class_251 var2, int var3, Parser var4) {
        super(var2, var3, var4);
        this.field_1073 = var1;
        this.field_1074 = var1.field_655 != null;
    }

    public class_251 method_1837(class_98 var1, int var2) {
        if (!this.field_1074 && var1 instanceof class_126) {
            this.field_1074 = true;
            this.field_1073.field_655 = (class_126)var1;
            this.field_1073.field_652 = var1.field_445;
            this.field_1073.field_651 = var1.field_445;
            return this;
        } else {
            return super.method_1837(var1, var2);
        }
    }

    public class_251 method_1838(class_114 var1, int var2) {
        if (!this.field_1074 && (var1.field_446 & 512) != 0 && (this.field_1073.field_652 == 0 || var1.field_444 <= this.field_1073.field_652)) {
            if (this.field_1079 == null) {
                this.field_1079 = new class_260[5];
                this.field_1080 = 0;
            } else if (this.field_1080 == this.field_1079.length) {
                System.arraycopy(this.field_1079, 0, this.field_1079 = new class_260[2 * this.field_1080], 0, this.field_1080);
            }
            class_260 var10000 = new class_260(var1, this, var2);
            class_260 var3 = var10000;
            this.field_1079[this.field_1080++] = var3;
            return var3;
        } else {
            return super.method_1838(var1, var2);
        }
    }

    public void method_1862(class_257[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            class_164[] var5 = this.field_1073.field_658;
            if (var5 != null) {
                this.field_1075 = new class_257[var2];
                this.field_1076 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].field_1116 == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.field_1075[this.field_1076++] = var1[var6];
                }
            } else {
                this.field_1075 = var1;
                this.field_1076 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1077 = var3;
            this.field_1078 = var4;
        }
    }

    public class_89 method_1845() {
        return this.field_1073;
    }

    public String method_1850(int var1) {
        StringBuffer var2 = new StringBuffer(this.method_1848(var1));
        var2.append("Recovered field:\n");
        this.field_1073.method_757(var1 + 1, var2);
        int var3;
        if (this.field_1075 != null) {
            for (var3 = 0; var3 < this.field_1076; ++var3) {
                var2.append("\n");
                var2.append(this.field_1075[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1079 != null) {
            for (var3 = 0; var3 < this.field_1080; ++var3) {
                var2.append("\n");
                var2.append(this.field_1079[var3].method_1850(var1 + 1));
            }
        }
        return var2.toString();
    }

    public class_121 method_1863() {
        if (this.field_1077 != 0) {
            this.field_1073.field_656 |= this.field_1077;
            if (this.field_1078 < this.field_1073.field_653) {
                this.field_1073.field_653 = this.field_1078;
            }
        }
        int var1;
        if (this.field_1076 > 0) {
            var1 = this.field_1073.field_658 == null ? 0 : this.field_1073.field_658.length;
            class_164[] var2 = new class_164[var1 + this.field_1076];
            if (var1 > 0) {
                System.arraycopy(this.field_1073.field_658, 0, var2, this.field_1076, var1);
            }
            int var3;
            for (var3 = 0; var3 < this.field_1076; ++var3) {
                var2[var3] = this.field_1075[var3].method_1874();
            }
            this.field_1073.field_658 = var2;
            var3 = this.field_1075[0].field_1116.field_444;
            if (var3 < this.field_1073.field_653) {
                this.field_1073.field_653 = var3;
            }
        }
        if (this.field_1079 != null) {
            class_260 var6;
            class_114 var7;
            if (this.field_1073.field_655 == null) {
                for (var1 = 0; var1 < this.field_1080; ++var1) {
                    var6 = this.field_1079[var1];
                    var7 = var6.field_1124;
                    if (var7.field_593 == 0) {
                        var7.field_593 = this.field_1073.field_652;
                        var7.field_595 = this.field_1073.field_652;
                    }
                    if (var6.field_1135) {
                        class_114 var4 = var6.method_1884();
                        this.field_1073.field_655 = var4.field_598;
                        if (this.field_1073.field_652 == 0) {
                            int var5 = var4.field_593;
                            this.field_1073.field_652 = var5;
                            this.field_1073.field_651 = var5;
                        }
                    }
                }
                if (this.field_1080 > 0) {
                    this.field_1073.field_446 |= 2;
                }
            } else if (this.field_1073.method_887() == 3) {
                for (var1 = 0; var1 < this.field_1080; ++var1) {
                    var6 = this.field_1079[var1];
                    var7 = var6.field_1124;
                    if (var7.field_593 == 0) {
                        var7.field_593 = this.field_1073.field_652;
                        var7.field_595 = this.field_1073.field_652;
                    }
                    var6.method_1884();
                }
            }
        }
        return this.field_1073;
    }

    public class_251 method_1853(int var1, int var2) {
        if (this.field_1069 > 0) {
            --this.field_1069;
            if (this.field_1069 == 0) {
                if (this.field_1073.method_887() == 3) {
                    this.method_1857(var2 - 1);
                    return this.field_1068;
                }
                this.field_1074 = true;
            }
            return this;
        } else {
            if (this.field_1069 == 0) {
                this.field_1074 = true;
                this.method_1857(var2 - 1);
            }
            return (class_251)(this.field_1068 != null ? this.field_1068.method_1853(var1, var2) : this);
        }
    }

    public class_251 method_1854(int var1, int var2) {
        if (this.field_1073.field_652 == 0 && (this.field_1073.field_660 instanceof class_149 || this.field_1073.field_660 instanceof class_152) && !this.field_1074) {
            ++this.field_1069;
            return null;
        } else if (this.field_1073.field_652 == 0 && this.field_1073.method_887() == 3) {
            ++this.field_1069;
            return null;
        } else {
            this.method_1856(var1 - 1, var2 - 1);
            return this.field_1068.method_1854(var1, var2);
        }
    }

    public void method_1855() {
        this.method_1863();
    }

    public void method_1856(int var1, int var2) {
        if (this.field_1073.field_652 == 0) {
            this.field_1073.field_652 = var2;
            this.field_1073.field_651 = var2;
        }
    }
}
