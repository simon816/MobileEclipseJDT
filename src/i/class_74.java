package i;

import g.class_316;
import i.class_268;
import i.class_72;
import m.class_65;

// $FF: renamed from: i.s
public class class_74 extends class_72 {

    // $FF: renamed from: a int[]
    private int[] field_327;
    // $FF: renamed from: b int
    private int field_328;
    // $FF: renamed from: a i.s
    class_74 field_329;
    // $FF: renamed from: c int
    public int field_330;

    // $FF: renamed from: <init> () void
    public class_74() {
        this.field_327 = new int[10];
        this.field_328 = 0;
    }

    // $FF: renamed from: <init> (i.o) void
    public class_74(class_268 var1) {
        super(var1);
        this.field_327 = new int[10];
        this.field_328 = 0;
    }

    // $FF: renamed from: a (int) void
    void method_450(int var1) {
        if (this.field_329 != null) {
            this.field_329.method_450(var1);
        } else {
            int var2 = this.field_328;
            int var3;
            if (var2 >= 1) {
                var3 = this.field_327[var2 - 1];
                if (var3 < var1) {
                    int var4;
                    if (var2 >= (var4 = this.field_327.length)) {
                        System.arraycopy(this.field_327, 0, this.field_327 = new int[2 * var4], 0, var4);
                    }
                    this.field_327[this.field_328++] = var1;
                } else if (var3 > var1) {
                    int[] var7 = this.field_327;
                    int var5 = 0;
                    for (int var6 = this.field_328; var5 < var6; ++var5) {
                        if (var7[var5] == var1) {
                            return;
                        }
                    }
                    if (var2 >= (var5 = var7.length)) {
                        System.arraycopy(var7, 0, this.field_327 = new int[2 * var5], 0, var5);
                    }
                    this.field_327[this.field_328++] = var1;
                    class_316.method_3168(this.field_327, 0, this.field_328);
                }
            } else {
                if (var2 >= (var3 = this.field_327.length)) {
                    System.arraycopy(this.field_327, 0, this.field_327 = new int[2 * var3], 0, var3);
                }
                this.field_327[this.field_328++] = var1;
            }
        }
    }

    // $FF: renamed from: a (i.s) void
    public void method_451(class_74 var1) {
        var1.field_329 = this;
        int var2 = var1.field_328;
        if (var2 != 0) {
            int[] var3 = new int[this.field_328 + var2];
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = this.field_328;
            int var8 = var1.field_328;
            while (var6 < var7) {
                int var9 = this.field_327[var6];
                while (true) {
                    if (var5 < var8) {
                        int var10 = var1.field_327[var5];
                        if (var9 < var10) {
                            var3[var4++] = var9;
                        } else {
                            if (var9 != var10) {
                                var3[var4++] = var10;
                                ++var5;
                                continue;
                            }
                            var3[var4++] = var9;
                            ++var5;
                        }
                    } else {
                        var3[var4++] = var9;
                    }
                    ++var6;
                    break;
                }
            }
            while (var5 < var8) {
                var3[var4++] = var1.field_327[var5];
                ++var5;
            }
            this.field_327 = var3;
            this.field_328 = var4;
        }
    }

    // $FF: renamed from: a () void
    void method_452() {
        this.field_330 |= 2;
        if (this.field_329 != null) {
            this.field_329.method_452();
        } else {
            if (this.field_323 == -1) {
                this.method_450(this.field_322.field_1208);
                this.field_322.field_1208 += 2;
                this.field_322.field_1190 += 2;
            } else {
                this.field_322.method_2381(this);
            }
        }
    }

    // $FF: renamed from: b () void
    void method_453() {
        this.field_330 |= 2;
        if (this.field_329 != null) {
            this.field_329.method_453();
        } else {
            if (this.field_323 == -1) {
                this.method_450(this.field_322.field_1208);
                this.field_330 |= 1;
                this.field_322.field_1208 += 4;
                this.field_322.field_1190 += 4;
            } else {
                this.field_322.method_2388(this);
            }
        }
    }

    // $FF: renamed from: a () int
    public int method_454() {
        if (this.field_329 != null) {
            this.field_329.method_454();
        }
        return this.field_328;
    }

    // $FF: renamed from: a () int[]
    public int[] method_455() {
        if (this.field_329 != null) {
            this.field_329.method_455();
        }
        return this.field_327;
    }

    // $FF: renamed from: a (i.o) void
    public void method_456(class_268 var1) {
        this.field_322 = var1;
        this.field_323 = -1;
        this.field_328 = 0;
        this.field_329 = null;
    }

    // $FF: renamed from: a () boolean
    public boolean method_457() {
        return true;
    }

    // $FF: renamed from: c () void
    public void method_458() {
        if (this.field_323 == -1) {
            this.field_323 = this.field_322.field_1208;
            this.field_322.method_2089(this);
            int var1 = this.field_323;
            boolean var2 = false;
            if (this.field_328 != 0) {
                var2 = this.field_327[this.field_328 - 1] + 2 == this.field_323 && this.field_322.field_1188[this.field_322.field_1190 - 3] == -89;
                if (var2) {
                    if (this.field_322.field_1198 == this.field_323) {
                        this.field_322.field_1198 = -1;
                    }
                    this.field_322.field_1208 = this.field_323 -= 3;
                    this.field_322.field_1190 -= 3;
                    --this.field_328;
                    if (this.field_322.field_1197 == var1) {
                        this.field_322.field_1197 = this.field_323;
                    }
                    if ((this.field_322.field_1195 & 28) != 0) {
                        class_65[] var3 = this.field_322.field_1202;
                        int var4 = 0;
                        for (int var5 = var3.length; var4 < var5; ++var4) {
                            class_65 var6 = var3[var4];
                            if (var6 != null && var6.field_311 > 0) {
                                if (var6.field_310[(var6.field_311 - 1 << 1) + 1] == var1) {
                                    var6.field_310[(var6.field_311 - 1 << 1) + 1] = this.field_323;
                                }
                                if (var6.field_310[var6.field_311 - 1 << 1] == var1) {
                                    var6.field_310[var6.field_311 - 1 << 1] = this.field_323;
                                }
                            }
                        }
                    }
                    if ((this.field_322.field_1195 & 2) != 0) {
                        this.field_322.method_2364();
                    }
                }
            }
            for (int var7 = 0; var7 < this.field_328; ++var7) {
                this.field_322.method_2382(this, this.field_327[var7]);
            }
            if (var2) {
                this.field_322.method_2351(var1, this);
            }
        }
    }

    public String toString() {
        String var1 = this.getClass().getName();
        var1 = var1.substring(var1.lastIndexOf(46) + 1);
        StringBuffer var2 = new StringBuffer(var1);
        var2.append('@').append(Integer.toHexString(this.hashCode()));
        var2.append("(position=").append(this.field_323);
        if (this.field_329 != null) {
            var2.append("delegate=").append(this.field_329);
        }
        var2.append(", forwards = [");
        for (int var3 = 0; var3 < this.field_328 - 1; ++var3) {
            var2.append(this.field_327[var3] + ", ");
        }
        if (this.field_328 >= 1) {
            var2.append(this.field_327[this.field_328 - 1]);
        }
        var2.append("] )");
        return var2.toString();
    }
}
