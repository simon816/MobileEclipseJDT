package j;

import f.class_226;
import h.class_112;
import h.class_114;
import h.class_121;
import h.class_124;
import h.class_89;
import h.class_91;
import h.class_93;
import h.class_98;
import j.class_254;
import j.class_255;
import j.class_260;
import j.class_261;
import j.class_270;
import j.class_278;

// $FF: renamed from: j.e
public class class_251 {

    // $FF: renamed from: a j.e
    public class_251 field_1068;
    // $FF: renamed from: e int
    public int field_1069;
    // $FF: renamed from: b boolean
    public boolean field_1070;
    // $FF: renamed from: a j.r
    protected class_278 field_1071;

    // $FF: renamed from: <init> (j.e, int) void
    public class_251(class_251 var1, int var2) {
        this(var1, var2, (class_278)null);
    }

    // $FF: renamed from: <init> (j.e, int, j.r) void
    public class_251(class_251 var1, int var2, class_278 var3) {
        this.field_1068 = var1;
        this.field_1069 = var2;
        this.field_1071 = var3;
    }

    // $FF: renamed from: a (int, int, int, int) j.e
    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var3 - 1));
            return this.field_1068.method_1831(var1, var2, var3, var4);
        }
    }

    // $FF: renamed from: a (h.ci, int) j.e
    public class_251 method_1832(class_93 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_480 - 1));
            return this.field_1068.method_1832(var1, var2);
        }
    }

    // $FF: renamed from: a (h.bz, int) j.e
    public class_251 method_1833(class_112 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_444 - 1));
            return this.field_1068.method_1833(var1, var2);
        }
    }

    // $FF: renamed from: a (h.m, int) j.e
    public class_251 method_1834(class_121 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1834(var1, var2);
        }
    }

    // $FF: renamed from: a (h.z, int) j.e
    public class_251 method_1835(class_91 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_470 - 1));
            return this.field_1068.method_1835(var1, var2);
        }
    }

    // $FF: renamed from: a (h.ac, int) j.e
    public class_251 method_1836(class_124 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1836(var1, var2);
        }
    }

    // $FF: renamed from: a (h.bf, int) j.e
    public class_251 method_1837(class_98 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_444 - 1));
            return this.field_1068.method_1837(var1, var2);
        }
    }

    // $FF: renamed from: a (h.bq, int) j.e
    public class_251 method_1838(class_114 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_592 - 1));
            return this.field_1068.method_1838(var1, var2);
        }
    }

    // $FF: renamed from: a (j.f) void
    protected void method_1839(class_261 var1) {
        class_112 var2 = var1.field_1144;
        if (var2.field_572 != null) {
            class_98[] var3 = var2.field_572;
            for (int var4 = 0; var4 < var3.length; ++var4) {
                var1.method_1837(var3[var4], 0);
            }
        }
    }

    // $FF: renamed from: b (int, int) void
    public void method_1840(int var1, int var2) {}

    // $FF: renamed from: a () j.q
    public class_254 method_1841() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_254) {
                return (class_254)var1;
            }
        }
        return null;
    }

    // $FF: renamed from: a () j.o
    public class_255 method_1842() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_255) {
                return (class_255)var1;
            }
        }
        return null;
    }

    // $FF: renamed from: a () j.m
    public class_260 method_1843() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_260) {
                return (class_260)var1;
            }
        }
        return null;
    }

    // $FF: renamed from: a () j.r
    public class_278 method_1844() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1.field_1071 != null) {
                return var1.field_1071;
            }
        }
        return null;
    }

    // $FF: renamed from: a () h.cj
    public class_89 method_1845() {
        return null;
    }

    // $FF: renamed from: b () void
    public void method_1846() {}

    // $FF: renamed from: a (int) int
    public int method_1847(int var1) {
        class_278 var2 = this.method_1844();
        if (var2 == null) {
            return var1;
        } else {
            class_270 var3 = var2.field_1628;
            if (var3.field_1256 == null) {
                return var1;
            } else {
                int var4 = class_226.method_1324(var1, var3.field_1256, 0, var3.field_1257);
                if (var4 < 2) {
                    return var1;
                } else {
                    int var5 = var3.field_1256[var4 - 2];
                    char[] var6 = var3.field_1237;
                    for (int var7 = var5 + 1; var7 < var1; ++var7) {
                        if (var6[var7] != 32 && var6[var7] != 9) {
                            return var1;
                        }
                    }
                    return var5;
                }
            }
        }
    }

    // $FF: renamed from: b (int) java.lang.String
    protected String method_1848(int var1) {
        StringBuffer var2 = new StringBuffer();
        for (int var3 = var1; var3 > 0; --var3) {
            var2.append("  ");
        }
        return var2.toString();
    }

    // $FF: renamed from: a () j.e
    public class_251 method_1849() {
        class_251 var1;
        for (var1 = this; var1.field_1068 != null; var1 = var1.field_1068) {
            ;
        }
        return var1;
    }

    public String toString() {
        return this.method_1850(0);
    }

    // $FF: renamed from: a (int) java.lang.String
    public String method_1850(int var1) {
        return super.toString();
    }

    // $FF: renamed from: a (int) void
    public void method_1851(int var1) {
        this.field_1070 = true;
    }

    // $FF: renamed from: c () void
    public void method_1852() {}

    // $FF: renamed from: a (int, int) j.e
    public class_251 method_1853(int var1, int var2) {
        if (--this.field_1069 <= 0 && this.field_1068 != null) {
            this.method_1856(var1, var2);
            return this.field_1068;
        } else {
            return this;
        }
    }

    // $FF: renamed from: b (int, int) j.e
    public class_251 method_1854(int var1, int var2) {
        if (this.field_1069++ == 0) {
            this.method_1851(var2 + 1);
            return this;
        } else {
            return null;
        }
    }

    // $FF: renamed from: a () void
    public void method_1855() {}

    // $FF: renamed from: a (int, int) void
    public void method_1856(int var1, int var2) {}

    // $FF: renamed from: b (int) void
    public void method_1857(int var1) {
        this.method_1856(var1 + 1, var1);
    }
}
