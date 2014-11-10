package g;

import java.util.Enumeration;

public class class_307 implements Enumeration {

    private int field_1796;

    private int field_1797;

    private int field_1798;

    private String field_1799;

    private String field_1800;

    private boolean field_1801;

    private boolean field_1802;

    private int field_1803;

    private boolean field_1804;

    private int[] field_1805;

    private void method_3131() {
        if (this.field_1800 == null) {
            this.field_1803 = 0;
        } else {
            int var1 = 0;
            int var3 = 0;
            int var2;
            int var4;
            for (var4 = 0; var4 < this.field_1800.length(); var4 += method_3132(var2)) {
                var2 = this.field_1800.charAt(var4);
                if (var2 >= '\ud800' && var2 <= '\udfff') {
                    var2 = method_3133(this.field_1800, var4);
                    this.field_1804 = true;
                }
                if (var1 < var2) {
                    var1 = var2;
                }
                ++var3;
            }
            this.field_1803 = var1;
            if (this.field_1804) {
                this.field_1805 = new int[var3];
                var4 = 0;
                for (int var5 = 0; var4 < var3; var5 += method_3132(var2)) {
                    var2 = method_3133(this.field_1800, var5);
                    this.field_1805[var4] = var2;
                    ++var4;
                }
            }
        }
    }

    static int method_3132(int var0) {
        return var0 >= 65536 ? 2 : 1;
    }

    static int method_3133(String var0, int var1) {
        char var2 = var0.charAt(var1++);
        if (var2 >= '\ud800' && var2 <= '\udbff' && var1 < var0.length()) {
            char var3 = var0.charAt(var1);
            if (var3 >= '\udc00' && var3 <= '\udfff') {
                return (var2 - '\ud800' << 10) + (var3 - '\udc00') + 65536;
            }
        }
        return var2;
    }

    public class_307(String var1, String var2, boolean var3) {
        this.field_1804 = false;
        this.field_1796 = 0;
        this.field_1797 = -1;
        this.field_1802 = false;
        this.field_1799 = var1;
        this.field_1798 = var1.length();
        this.field_1800 = var2;
        this.field_1801 = var3;
        this.method_3131();
    }

    public class_307(String var1, String var2) {
        this(var1, var2, false);
    }

    private int method_3136(int var1) {
        if (this.field_1800 == null) {
            throw new NullPointerException();
        } else {
            int var2 = var1;
            while (!this.field_1801 && var2 < this.field_1798) {
                if (!this.field_1804) {
                    char var4 = this.field_1799.charAt(var2);
                    if (var4 > this.field_1803 || this.field_1800.indexOf(var4) < 0) {
                        break;
                    }
                    ++var2;
                } else {
                    int var3 = method_3133(this.field_1799, var2);
                    if (var3 > this.field_1803 || !this.method_3138(var3)) {
                        break;
                    }
                    var2 += method_3132(var3);
                }
            }
            return var2;
        }
    }

    private int method_3137(int var1) {
        int var2 = var1;
        int var3;
        char var4;
        while (var2 < this.field_1798) {
            if (!this.field_1804) {
                var4 = this.field_1799.charAt(var2);
                if (var4 <= this.field_1803 && this.field_1800.indexOf(var4) >= 0) {
                    break;
                }
                ++var2;
            } else {
                var3 = method_3133(this.field_1799, var2);
                if (var3 <= this.field_1803 && this.method_3138(var3)) {
                    break;
                }
                var2 += method_3132(var3);
            }
        }
        if (this.field_1801 && var1 == var2) {
            if (!this.field_1804) {
                var4 = this.field_1799.charAt(var2);
                if (var4 <= this.field_1803 && this.field_1800.indexOf(var4) >= 0) {
                    ++var2;
                }
            } else {
                var3 = method_3133(this.field_1799, var2);
                if (var3 <= this.field_1803 && this.method_3138(var3)) {
                    var2 += method_3132(var3);
                }
            }
        }
        return var2;
    }

    private boolean method_3138(int var1) {
        for (int var2 = 0; var2 < this.field_1805.length; ++var2) {
            if (this.field_1805[var2] == var1) {
                return true;
            }
        }
        return false;
    }

    public boolean method_3139() {
        this.field_1797 = this.method_3136(this.field_1796);
        return this.field_1797 < this.field_1798;
    }

    public String method_3140() {
        this.field_1796 = this.field_1797 >= 0 && !this.field_1802 ? this.field_1797 : this.method_3136(this.field_1796);
        this.field_1802 = false;
        this.field_1797 = -1;
        if (this.field_1796 >= this.field_1798) {
            throw new RuntimeException();
        } else {
            int var1 = this.field_1796;
            this.field_1796 = this.method_3137(this.field_1796);
            return this.field_1799.substring(var1, this.field_1796);
        }
    }

    public boolean hasMoreElements() {
        return this.method_3139();
    }

    public Object nextElement() {
        return this.method_3140();
    }
}
