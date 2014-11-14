package j;

import b.CharOperation;
import h.class_112;
import h.class_114;
import h.class_121;
import h.class_124;
import h.class_125;
import h.class_89;
import h.class_93;
import h.class_98;
import j.class_251;
import j.class_254;
import j.class_255;
import j.class_257;
import j.class_258;
import j.class_259;
import j.class_260;
import m.class_40;

public class class_261 extends class_258 {

    public class_112 field_1144;

    public class_258[] field_1145;

    public int field_1146;

    public boolean field_1147;

    public class_259 field_1148;

    int field_1149;

    int field_1150;

    class_257[] field_1151;

    int field_1152;

    public class_261(class_112 var1, class_251 var2, int var3) {
        super(var1, var2, var3);
        this.field_1147 = false;
        this.field_1150 = -1;
        this.field_1144 = var1;
        this.field_1070 = true;
        this.field_1147 = this.method_1844().field_1621 || this.method_1844().field_1622;
    }

    public class_251 method_1832(class_93 var1, int var2) {
        if (this.field_1068 != null && this.field_1068 instanceof class_255) {
            class_255 var3 = (class_255)this.field_1068;
            if (var3.field_1095 == this && var3.field_1068 == null) {
                this.method_1846();
                return this;
            }
        }
        return super.method_1832(var1, var2);
    }

    public class_251 method_1833(class_112 var1, int var2) {
        this.method_1846();
        if (this.field_1144.field_445 != 0 && var1.field_444 > this.field_1144.field_445) {
            return this.field_1068.method_1833(var1, var2);
        } else {
            class_261 var10000 = new class_261(var1, this, var2);
            class_261 var3 = var10000;
            if (this.field_1148 != null) {
                var3.method_1889(this.field_1148);
                this.field_1148 = null;
            }
            if (this.method_1844().field_1622) {
                this.method_1839(var3);
            }
            this.method_1889(var3);
            return var1.field_445 == 0 ? var3 : this;
        }
    }

    public class_251 method_1836(class_124 var1, int var2) {
        return this.method_1886(var1, var2, false);
    }

    public class_251 method_1886(class_124 var1, int var2, boolean var3) {
        if (this.field_1144.field_445 != 0 && var1.field_653 > this.field_1144.field_445) {
            this.method_1846();
            return (class_251)(var3 ? this : this.field_1068.method_1836(var1, var2));
        } else {
            class_259 var10000 = new class_259(var1, this, var2);
            class_259 var4 = var10000;
            if (this.field_1152 > 0) {
                var4.method_1878(this.field_1151, this.field_1152, this.field_1149, this.field_1150);
            }
            this.method_1846();
            if (var1 instanceof class_125) {
                this.field_1148 = var4;
                return this;
            } else {
                this.method_1889(var4);
                if (var1.field_652 == 0) {
                    return var4;
                }
                return this;
            }
        }
    }

    public class_251 method_1837(class_98 var1, int var2) {
        return this.method_1887(var1, var2, false);
    }

    public class_251 method_1887(class_98 var1, int var2, boolean var3) {
        this.method_1846();
        if (this.field_1144.field_445 != 0 && var1.field_444 > this.field_1144.field_445) {
            return (class_251)(var3 ? this : this.field_1068.method_1837(var1, var2));
        } else {
            class_258 var10000 = new class_258(var1, this, var2);
            class_258 var4 = var10000;
            this.method_1889(var4);
            if (var1.field_445 == 0) {
                return var4;
            }
            return this;
        }
    }

    public class_251 method_1838(class_114 var1, int var2) {
        return this.method_1888(var1, var2, false);
    }

    public class_251 method_1888(class_114 var1, int var2, boolean var3) {
        if (this.field_1144.field_445 != 0 && var1.field_592 > this.field_1144.field_445) {
            this.method_1846();
            return (class_251)(var3 ? this : this.field_1068.method_1838(var1, var2));
        } else {
            class_260 var10000 = new class_260(var1, this, var2);
            class_260 var4 = var10000;
            if (this.field_1152 > 0) {
                var4.method_1881(this.field_1151, this.field_1152, this.field_1149, this.field_1150);
            }
            this.method_1846();
            this.method_1889(var4);
            if (var1.field_593 == 0) {
                return var4;
            }
            return this;
        }
    }

    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        if (this.field_1151 == null) {
            this.field_1151 = new class_257[5];
            this.field_1152 = 0;
        } else if (this.field_1152 == this.field_1151.length) {
            System.arraycopy(this.field_1151, 0, this.field_1151 = new class_257[2 * this.field_1152], 0, this.field_1152);
        }
        class_257 var10000 = new class_257(var1, var2, var3, this, var4);
        class_257 var5 = var10000;
        this.field_1151[this.field_1152++] = var5;
        return var5;
    }

    public void method_1840(int var1, int var2) {
        this.field_1149 |= var1;
        if (this.field_1150 < 0) {
            this.field_1150 = var2;
        }
    }

    void method_1889(class_258 var1) {
        if (this.field_1145 == null) {
            this.field_1145 = new class_258[5];
            this.field_1146 = 0;
        } else if (this.field_1146 == this.field_1145.length) {
            System.arraycopy(this.field_1145, 0, this.field_1145 = new class_258[2 * this.field_1146], 0, this.field_1146);
        }
        this.field_1145[this.field_1146++] = var1;
    }

    void method_1890(class_257[] var1, int var2, int var3, int var4) {
        this.field_1151 = var1;
        this.field_1152 = var2;
        this.field_1149 = var3;
        this.field_1150 = var4;
    }

    public class_89 method_1845() {
        return this.field_1144;
    }

    public void method_1846() {
        this.field_1151 = null;
        this.field_1152 = 0;
        this.field_1149 = 0;
        this.field_1150 = -1;
    }

    public String method_1850(int var1) {
        StringBuffer var2 = new StringBuffer(this.method_1848(var1));
        var2.append("Recovered block:\n");
        this.field_1144.method_757(var1 + 1, var2);
        if (this.field_1145 != null) {
            for (int var3 = 0; var3 < this.field_1146; ++var3) {
                var2.append("\n");
                var2.append(this.field_1145[var3].method_1850(var1 + 1));
            }
        }
        return var2.toString();
    }

    public class_112 method_1891() {
        if (this.field_1147 && this.field_1146 != 0) {
            class_98[] var1 = new class_98[this.field_1146];
            int var2 = 0;
            class_258 var3 = this.field_1145[this.field_1146 - 1];
            class_255 var4 = this.method_1842();
            class_254 var5 = this.method_1841();
            boolean var6 = false;
            int var11;
            if (var4 != null) {
                var11 = var4.field_1088.field_491;
                if (var5 != null && var4.field_1088.field_444 < var5.field_1073.field_444) {
                    var11 = var5.field_1073.field_652;
                }
            } else if (var5 != null) {
                var11 = var5.field_1073.field_652;
            } else {
                var11 = this.field_1144.field_445 - 1;
            }
            if (var3 instanceof class_259) {
                class_259 var7 = (class_259)var3;
                if (var7.field_1122.field_652 == 0) {
                    var7.field_1122.field_652 = var11;
                    var7.field_1122.field_651 = var11;
                }
            } else if (var3 instanceof class_261) {
                class_261 var12 = (class_261)var3;
                if (var12.field_1144.field_445 == 0) {
                    var12.field_1144.field_445 = var11;
                }
            } else if (!(var3 instanceof class_260) && var3.field_1117.field_445 == 0) {
                var3.field_1117.field_445 = var11;
            }
            int var13 = this.field_1144.field_444;
            for (int var8 = 0; var8 < this.field_1146; ++var8) {
                class_98 var9 = this.field_1145[var8].method_1876();
                if (var9 != null) {
                    var1[var2++] = var9;
                    if (var9 instanceof class_124) {
                        class_124 var10 = (class_124)var9;
                        if (var10.field_652 > var13) {
                            var13 = var10.field_652;
                        }
                    } else if (var9 instanceof class_114) {
                        class_114 var14 = (class_114)var9;
                        if (var14.field_593 > var13) {
                            var13 = var14.field_593;
                        }
                    } else if (var9.field_445 > var13) {
                        var13 = var9.field_445;
                    }
                }
            }
            if (var2 == 0) {
                return null;
            } else {
                if (var2 != this.field_1146) {
                    this.field_1144.field_572 = new class_98[var2];
                    System.arraycopy(var1, 0, this.field_1144.field_572, 0, var2);
                } else {
                    this.field_1144.field_572 = var1;
                }
                if (this.field_1144.field_445 == 0) {
                    if (var13 < var11) {
                        this.field_1144.field_445 = var11;
                    } else {
                        this.field_1144.field_445 = var13;
                    }
                }
                return this.field_1144;
            }
        } else {
            return null;
        }
    }

    public class_98 method_1876() {
        return this.method_1891();
    }

    public class_251 method_1853(int var1, int var2) {
        if (--this.field_1069 <= 0 && this.field_1068 != null) {
            this.method_1856(var1, var2);
            class_255 var3 = this.method_1842();
            if (var3 != null && var3.field_1095 == this) {
                return this.field_1068.method_1853(var1, var2);
            } else {
                class_254 var4 = this.method_1841();
                return var4 != null && var4.field_1083 == this ? this.field_1068.method_1853(var1, var2) : this.field_1068;
            }
        } else {
            return this;
        }
    }

    public class_251 method_1854(int var1, int var2) {
        class_112 var10000 = new class_112(0);
        class_112 var3 = var10000;
        var3.field_444 = this.method_1844().field_1628.field_1230;
        return this.method_1833(var3, 1);
    }

    public void method_1855() {
        this.method_1891();
    }

    public class_251 method_1834(class_121 var1, int var2) {
        this.method_1846();
        char[][] var3;
        if ((var1.field_656 & -17) == 0 && var1.field_660 != null && ((var3 = var1.field_660.method_1012()).length != 1 || !CharOperation.method_1364(var3[0], class_40.field_188.method_179()))) {
            return (class_251)(this.field_1144.field_445 != 0 && var1.field_653 > this.field_1144.field_445 ? this.field_1068.method_1834(var1, var2) : this);
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1834(var1, var2);
        }
    }
}
