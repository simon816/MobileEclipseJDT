package c;

import a.class_33;
import b.class_235;
import c.class_287;
import c.class_288;
import f.Util;
import g.class_10;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import g.class_316;
import h.class_93;
import j.class_267;
import java.util.Vector;
import k.class_19;
import m.class_54;

public class class_284 {

    public class_235[] field_1673;

    public class_235[] field_1674;

    public int field_1675;

    public int field_1676;

    public class_19 field_1677;

    public Map field_1678;

    public Vector field_1679;

    private int field_1680;

    public char[][][] field_1681;

    public char[][] field_1682;

    public boolean field_1683;

    public int[] field_1684;

    public class_267 field_1685;

    public Map field_1686;

    public int field_1687;

    public int field_1688;

    public boolean field_1689;

    public String field_1690;

    public boolean field_1691;

    public boolean field_1692;

    public char[][] field_1693;

    public boolean field_1694;

    private static final int[] field_1695;

    private static final class_10 field_1696;

    public class_284(String var1, int var2, int var3, int var4) {
        this.field_1683 = false;
        HashMap var10001 = new HashMap(11);
        this.field_1686 = var10001;
        this.field_1689 = false;
        this.field_1691 = false;
        this.field_1692 = false;
        this.field_1694 = false;
        this.field_1690 = var1;
        this.field_1687 = var2;
        this.field_1688 = var3;
        this.field_1680 = var4;
    }

    public class_284(class_19 var1, int var2, int var3, int var4) {
        this.field_1683 = false;
        HashMap var10001 = new HashMap(11);
        this.field_1686 = var10001;
        this.field_1689 = false;
        this.field_1691 = false;
        this.field_1692 = false;
        this.field_1694 = false;
        this.field_1690 = var1.method_50();
        this.field_1677 = var1;
        this.field_1687 = var2;
        this.field_1688 = var3;
        this.field_1680 = var4;
    }

    private int method_2915(class_235 var1) {
        int var6 = 10000 - var1.method_1403();
        if (var6 < 0) {
            var6 = 0;
        }
        if (var1.method_1399()) {
            var6 += 100000;
        }
        class_33 var7 = this.field_1678 == null ? null : (class_33)this.field_1678.get(var1);
        if (var7 != null) {
            if (var7 instanceof class_93) {
                class_93 var8 = (class_93)var7;
                if (var8.method_799()) {
                    var6 += 10000;
                }
            } else {
                var6 += '\u9c40';
            }
            if (this.field_1679.contains(var1)) {
                var6 += 20000;
            }
        } else {
            var6 += '\u9c40';
        }
        return var6;
    }

    public class_235[] method_2916() {
        class_235[] var1 = this.method_2922();
        int var2 = var1 != null ? var1.length : 0;
        class_235[] var3 = this.method_2923();
        int var4 = var3 != null ? var3.length : 0;
        if (var4 == 0) {
            return var1;
        } else if (var2 == 0) {
            return var3;
        } else {
            int var5 = var2 + var4;
            class_235[] var6 = new class_235[var5];
            int var7 = 0;
            int var8 = 0;
            class_235 var12;
            for (int var9 = 0; var8 + var9 < var5; var6[var7++] = var12) {
                class_235 var10 = null;
                class_235 var11 = null;
                if (var8 < var4) {
                    var10 = var3[var8];
                }
                if (var9 < var2) {
                    var11 = var1[var9];
                }
                var12 = null;
                if (var11 != null) {
                    if (var10 != null) {
                        if (var11.method_1401() < var10.method_1401()) {
                            var12 = var11;
                            ++var9;
                        } else {
                            var12 = var10;
                            ++var8;
                        }
                    } else {
                        var12 = var11;
                        ++var9;
                    }
                } else if (var10 != null) {
                    var12 = var10;
                    ++var8;
                }
            }
            return var6;
        }
    }

    public class_288[] method_2917() {
        class_288[] var1 = new class_288[this.field_1686.size()];
        this.field_1686.values().toArray(var1);
        return var1;
    }

    public class_19 method_2918() {
        return this.field_1677;
    }

    public class_235[] method_2919() {
        class_235[] var1 = this.method_2922();
        int var2 = 0;
        for (int var3 = 0; var3 < this.field_1675; ++var3) {
            if (var1[var3].method_1399()) {
                ++var2;
            }
        }
        if (var2 == this.field_1675) {
            return var1;
        } else {
            class_235[] var6 = new class_235[var2];
            int var4 = 0;
            for (int var5 = 0; var5 < this.field_1675; ++var5) {
                if (var1[var5].method_1399()) {
                    var6[var4++] = var1[var5];
                }
            }
            return var6;
        }
    }

    public String method_2920() {
        return this.field_1690;
    }

    public int[] method_2921() {
        return this.field_1684 == null ? field_1695 : this.field_1684;
    }

    public class_235[] method_2922() {
        if (this.field_1673 != null) {
            if (this.field_1675 != this.field_1673.length) {
                System.arraycopy(this.field_1673, 0, this.field_1673 = new class_235[this.field_1675], 0, this.field_1675);
            }
            if (this.field_1680 > 0 && this.field_1675 > this.field_1680) {
                this.method_2927(this.field_1673, 0, this.field_1675 - 1);
                this.field_1675 = this.field_1680;
                System.arraycopy(this.field_1673, 0, this.field_1673 = new class_235[this.field_1675], 0, this.field_1675);
            }
            class_316.method_3172(this.field_1673, 0, this.field_1673.length, field_1696);
        }
        return this.field_1673;
    }

    public class_235[] method_2923() {
        if (this.field_1674 != null) {
            if (this.field_1676 != this.field_1674.length) {
                System.arraycopy(this.field_1674, 0, this.field_1674 = new class_235[this.field_1676], 0, this.field_1676);
            }
            class_316.method_3172(this.field_1674, 0, this.field_1674.length, field_1696);
        }
        return this.field_1674;
    }

    public boolean method_2924() {
        if (this.field_1673 != null) {
            for (int var1 = 0; var1 < this.field_1675; ++var1) {
                if (this.field_1673[var1].method_1399()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean method_2925() {
        return this.field_1675 != 0;
    }

    public boolean method_2926() {
        return this.field_1676 != 0;
    }

    private void method_2927(class_235[] var1, int var2, int var3) {
        if (var2 < var3) {
            int var4 = var2;
            int var5 = var3;
            int var6 = this.method_2915(var1[var2 + (var3 - var2) / 2]);
            while (true) {
                while (this.method_2915(var1[var3]) >= var6) {
                    while (var6 < this.method_2915(var1[var2])) {
                        ++var2;
                    }
                    if (var2 <= var3) {
                        class_235 var7 = var1[var2];
                        var1[var2] = var1[var3];
                        var1[var3] = var7;
                        ++var2;
                        --var3;
                    }
                    if (var2 > var3) {
                        if (var4 < var3) {
                            this.method_2927(var1, var4, var3);
                        }
                        if (var2 < var5) {
                            this.method_2927(var1, var2, var5);
                        }
                        return;
                    }
                }
                --var3;
            }
        }
    }

    public void method_2928(char[][] var1) {
        this.field_1693 = var1;
    }

    public void method_2929(class_235 var1, class_33 var2) {
        if (var1.method_1398() == 536871362) {
            this.method_2931(var1);
        } else {
            if (this.field_1675 == 0) {
                this.field_1673 = new class_235[5];
            } else if (this.field_1675 == this.field_1673.length) {
                System.arraycopy(this.field_1673, 0, this.field_1673 = new class_235[this.field_1675 * 2], 0, this.field_1675);
            }
            this.field_1673[this.field_1675++] = var1;
            if (var2 != null) {
                if (this.field_1678 == null) {
                    HashMap var10001 = new HashMap(5);
                    this.field_1678 = var10001;
                }
                if (this.field_1679 == null) {
                    this.field_1679 = new Vector(5);
                }
                if (var1.method_1399() && !var2.method_95()) {
                    this.field_1679.addElement(var1);
                }
                this.field_1678.put(var1, var2);
            }
            if ((var1.method_1398() & 1073741824) != 0 && var1.method_1399()) {
                this.field_1692 = true;
            }
        }
    }

    public void method_2930(char[] var1, class_288 var2) {
        class_54 var3 = var2.field_1729;
        if (!var3.method_158() && var3.method_156()) {
            this.field_1691 = true;
        }
        this.field_1686.put(var1, var2);
    }

    private void method_2931(class_235 var1) {
        if (this.field_1676 == 0) {
            this.field_1674 = new class_235[5];
        } else if (this.field_1676 == this.field_1674.length) {
            System.arraycopy(this.field_1674, 0, this.field_1674 = new class_235[this.field_1676 * 2], 0, this.field_1676);
        }
        this.field_1674[this.field_1676++] = var1;
    }

    public class_284 method_2932() {
        this.field_1689 = true;
        this.field_1678 = null;
        this.field_1679 = null;
        return this;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        if (this.field_1690 != null) {
            var1.append("Filename : ").append(this.field_1690).append('\n');
        }
        if (this.field_1686 != null) {
            var1.append("COMPILED type(s)\t\n");
            Iterator var2 = this.field_1686.keySet().iterator();
            while (var2.hasNext()) {
                char[] var3 = (char[])((char[])var2.next());
                var1.append("\t - ").append(var3).append('\n');
            }
        } else {
            var1.append("No COMPILED type\n");
        }
        if (this.field_1673 != null) {
            var1.append(this.field_1675).append(" PROBLEM(s) detected \n");
            for (int var4 = 0; var4 < this.field_1675; ++var4) {
                var1.append("\t - ").append(this.field_1673[var4]).append('\n');
            }
        } else {
            var1.append("No PROBLEM\n");
        }
        return var1.toString();
    }

    static {
        field_1695 = Util.field_983;
        class_287 var10000 = new class_287();
        field_1696 = var10000;
    }
}
