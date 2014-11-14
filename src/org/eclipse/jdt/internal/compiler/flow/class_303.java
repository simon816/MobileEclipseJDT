package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;

public class class_303 extends class_301 {

    public long field_1787;

    public long field_1788;

    public long field_1789;

    public long field_1790;

    public long field_1791;

    public long field_1792;

    public long[][] field_1793;

    public int field_1794;

    public class_303() {
    }

    public class_301 method_3071(class_301 var1) {
        if (this == field_1784) {
            return this;
        } else if (var1 == field_1784) {
            return this;
        } else {
            class_303 var2 = var1.method_3109();
            this.field_1787 |= var2.field_1787;
            this.field_1788 |= var2.field_1788;
            boolean var3 = (this.field_1783 & 2) != 0;
            boolean var4 = (var2.field_1783 & 2) != 0;
            long var5;
            long var7;
            long var9;
            long var11;
            long var13;
            long var15;
            long var17;
            long var19;
            long var21;
            long var23;
            long var25;
            long var27;
            long var29;
            long var31;
            long var35;
            long var33;
            if (var4) {
                if (!var3) {
                    this.field_1789 = var2.field_1789;
                    this.field_1790 = var2.field_1790;
                    this.field_1791 = var2.field_1791;
                    this.field_1792 = var2.field_1792;
                } else {
                    var21 = var2.field_1789;
                    var5 = this.field_1789;
                    var9 = this.field_1791;
                    var11 = this.field_1792;
                    long var10003 = this.field_1791 & this.field_1792;
                    var23 = var2.field_1790;
                    var10003 &= var31 = ~var2.field_1790;
                    var27 = var2.field_1792;
                    var10003 &= var35 = ~var2.field_1792;
                    long var10004 = (var19 = ~var11) | (var17 = ~var9);
                    var7 = this.field_1790;
                    long var10005 = (var15 = ~this.field_1790) & var31;
                    var25 = var2.field_1791;
                    this.field_1789 = var2.field_1789 | this.field_1789 & (var10003 | var10004 & (var10005 | var7 & (var33 = ~var2.field_1791) & var35));
                    this.field_1790 = var23 & (var35 | var33) | var17 & var19 & var23 | var7 & (var33 & var35 | (var29 = ~var21) & (var17 | (var13 = ~var5)) | var5 & var23);
                    this.field_1791 = var25 & (var29 & (var23 | var7 | var13) | var21 & (var27 | var31 | var5 & var9) | var13 & var15 & var19) | var9 & var31 & var35 | var29 & ((var15 & var11 | var13) & var9 | var5 & var15 & var19 & var23);
                    this.field_1792 = var29 & (var11 & (var17 & var33 | (var9 | var15) & var31) | var5 & (var9 & var31 & var27 | var7 & var23 & (var27 | var9 & var19 & var33))) | var21 & (var9 & var11 & var27 | var15 & var19 & var33 & var27 | var7 & ((var25 | var11) & var27 | var17 & var11 & var23 & var25) | var13 & (var27 | (var11 | var7) & var23 & var25)) | (var13 & (var17 & var33 | var15 & var31) | var5 & (var31 & var33 | var7 & var9)) & var27;
                }
                this.field_1783 |= 2;
            }
            if (this.field_1793 != null || var2.field_1793 != null) {
                int var37 = 0;
                int var38 = 0;
                int var39;
                int var40;
                if (this.field_1793 != null) {
                    if (var2.field_1793 != null) {
                        if ((var39 = this.field_1793[0].length) < (var40 = var2.field_1793[0].length)) {
                            for (int var41 = 0; var41 < 6; ++var41) {
                                System.arraycopy(this.field_1793[var41], 0, this.field_1793[var41] = new long[var40], 0, var39);
                            }
                            var37 = var39;
                            var38 = var40;
                        } else {
                            var37 = var40;
                        }
                    }
                } else if (var2.field_1793 != null) {
                    this.field_1793 = new long[6][];
                    System.arraycopy(var2.field_1793[0], 0, this.field_1793[0] = new long[var39 = var2.field_1793[0].length], 0, var39);
                    System.arraycopy(var2.field_1793[1], 0, this.field_1793[1] = new long[var39], 0, var39);
                    if (var4) {
                        for (var40 = 2; var40 < 6; ++var40) {
                            System.arraycopy(var2.field_1793[var40], 0, this.field_1793[var40] = new long[var39], 0, var39);
                        }
                    } else {
                        for (var40 = 2; var40 < 6; ++var40) {
                            this.field_1793[var40] = new long[var39];
                        }
                    }
                }
                for (var39 = 0; var39 < var37; ++var39) {
                    this.field_1793[0][var39] |= var2.field_1793[0][var39];
                    this.field_1793[1][var39] |= var2.field_1793[1][var39];
                }
                while (var39 < var38) {
                    this.field_1793[0][var39] = var2.field_1793[0][var39];
                    this.field_1793[1][var39] = var2.field_1793[1][var39];
                    ++var39;
                }
                if (!var3) {
                    if (var38 < var37) {
                        var38 = var37;
                    }
                    var37 = 0;
                }
                if (!var4) {
                    var38 = 0;
                    var37 = 0;
                }
                for (var39 = 0; var39 < var37; ++var39) {
                    this.field_1793[2][var39] = (var21 = var2.field_1793[2][var39]) | (var5 = this.field_1793[2][var39]) & ((var9 = this.field_1793[4][var39]) & (var11 = this.field_1793[5][var39]) & (var31 = ~(var23 = var2.field_1793[3][var39])) & (var35 = ~(var27 = var2.field_1793[5][var39])) | ((var19 = ~var11) | (var17 = ~var9)) & ((var15 = ~(var7 = this.field_1793[3][var39])) & var31 | var7 & (var33 = ~(var25 = var2.field_1793[4][var39])) & var35));
                    this.field_1793[3][var39] = var23 & (var35 | var33) | var17 & var19 & var23 | var7 & (var33 & var35 | (var29 = ~var21) & (var17 | (var13 = ~var5)) | var5 & var23);
                    this.field_1793[4][var39] = var25 & (var29 & (var23 | var7 | var13) | var21 & (var27 | var31 | var5 & var9) | var13 & var15 & var19) | var9 & var31 & var35 | var29 & ((var15 & var11 | var13) & var9 | var5 & var15 & var19 & var23);
                    this.field_1793[5][var39] = var29 & (var11 & (var17 & var33 | (var9 | var15) & var31) | var5 & (var9 & var31 & var27 | var7 & var23 & (var27 | var9 & var19 & var33))) | var21 & (var9 & var11 & var27 | var15 & var19 & var33 & var27 | var7 & ((var25 | var11) & var27 | var17 & var11 & var23 & var25) | var13 & (var27 | (var11 | var7) & var23 & var25)) | (var13 & (var17 & var33 | var15 & var31) | var5 & (var31 & var33 | var7 & var9)) & var27;
                }
                while (var39 < var38) {
                    for (var40 = 2; var40 < 6; ++var40) {
                        this.field_1793[var40][var39] = var2.field_1793[var40][var39];
                    }
                    ++var39;
                }
            }
            return this;
        }
    }

    public class_301 method_3072(class_301 var1) {
        if (this == field_1784) {
            return this;
        } else if (var1 == field_1784) {
            return this;
        } else {
            class_303 var2 = var1.method_3109();
            this.field_1788 |= var2.field_1788;
            int var3;
            int var4;
            if (this.field_1793 != null) {
                if (var2.field_1793 != null) {
                    var3 = 0;
                    int var5;
                    if ((var4 = this.field_1793[0].length) < (var5 = var2.field_1793[0].length)) {
                        for (int var6 = 0; var6 < 6; ++var6) {
                            System.arraycopy(this.field_1793[var6], 0, this.field_1793[var6] = new long[var5], 0, var4);
                        }
                        while (var3 < var4) {
                            this.field_1793[1][var3] |= var2.field_1793[1][var3];
                            ++var3;
                        }
                        while (var3 < var5) {
                            this.field_1793[1][var3] = var2.field_1793[1][var3];
                            ++var3;
                        }
                    } else {
                        while (var3 < var5) {
                            this.field_1793[1][var3] |= var2.field_1793[1][var3];
                            ++var3;
                        }
                    }
                }
            } else if (var2.field_1793 != null) {
                var3 = var2.field_1793[0].length;
                this.field_1793 = new long[6][];
                for (var4 = 0; var4 < 6; ++var4) {
                    this.field_1793[var4] = new long[var3];
                }
                System.arraycopy(var2.field_1793[1], 0, this.field_1793[1], 0, var3);
            }
            this.method_3113(var2);
            return this;
        }
    }

    public class_303 method_3113(class_303 var1) {
        if ((this.field_1783 & 1) == 0 && (var1.field_1783 & 1) == 0 && (var1.field_1783 & 2) != 0) {
            boolean var2 = (this.field_1783 & 2) != 0;
            boolean var3 = false;
            long var4;
            long var6;
            long var8;
            long var10;
            long var12;
            long var14;
            long var16;
            long var18;
            long var20;
            long var22;
            long var24;
            long var26;
            long var28;
            long var30;
            long var34;
            long var32;
            long var10002;
            if (var2) {
                var4 = this.field_1789;
                var8 = this.field_1791;
                var10 = this.field_1792;
                var10002 = this.field_1791 & this.field_1792;
                var22 = var1.field_1790;
                long var10003 = var30 = ~var1.field_1790;
                var26 = var1.field_1792;
                var10003 &= var34 = ~var1.field_1792;
                var20 = var1.field_1789;
                var24 = var1.field_1791;
                var10002 &= var10003 | var1.field_1789 & var1.field_1791;
                var6 = this.field_1790;
                this.field_1789 &= var10002 | (var14 = ~this.field_1790) & (var20 & var24 | ((var18 = ~var10) | (var16 = ~var8)) & var30) | var6 & (var18 | var16) & ((var32 = ~var24) & var34 | var20 & var22);
                this.field_1790 = var22 & (var32 | (var28 = ~var20)) | var6 & (var32 & var34 | var22 | var16 | (var12 = ~var4));
                this.field_1791 = var24 & (var28 & var22 | var6 & (var30 | var8) | var12 & var30 | var4 & var14 & var18 & var20) | var8 & (var30 & var34 | var14 & var10 | var12) | var4 & var14 & var18 & var22;
                this.field_1792 = var16 & (var28 & var32 & var26 | var10 & (var32 | var20 & var22)) | var30 & (var16 & var20 & var32 | var14 & (var28 & var26 | var20 & var32 | var10)) | var8 & (var10 & (var30 | var20 & var24) | var4 & var6 & (var28 & var26 | var18 & (var22 | var20) & var32));
                if ((this.field_1790 | this.field_1791 | this.field_1792) != 0L) {
                    var3 = true;
                }
            } else {
                this.field_1789 = 0L;
                var22 = var1.field_1790;
                var24 = var1.field_1791;
                var10002 = var32 = ~var1.field_1791;
                var20 = var1.field_1789;
                this.field_1790 = var1.field_1790 & (var10002 | (var28 = ~var1.field_1789));
                this.field_1791 = var24 & (var28 | (var30 = ~var22));
                long var10001 = ~var20 & ~var24;
                var26 = var1.field_1792;
                this.field_1792 = var10001 & var1.field_1792 | ~var22 & (var20 & ~var24 | ~var20 & var26);
                if ((this.field_1790 | this.field_1791 | this.field_1792) != 0L) {
                    var3 = true;
                }
            }
            if (var1.field_1793 != null) {
                int var36 = 0;
                int var37 = var1.field_1793[0].length;
                int var38;
                if (this.field_1793 == null) {
                    this.field_1793 = new long[6][];
                    for (var38 = 0; var38 < 6; ++var38) {
                        this.field_1793[var38] = new long[var37];
                    }
                } else {
                    var36 = var37;
                    if (var37 > this.field_1793[0].length) {
                        var36 = this.field_1793[0].length;
                        for (var38 = 0; var38 < 6; ++var38) {
                            System.arraycopy(this.field_1793[var38], 0, this.field_1793[var38] = new long[var37], 0, var36);
                        }
                        if (!var2) {
                            var36 = 0;
                        }
                    }
                }
                for (var38 = 0; var38 < var36; ++var38) {
                    this.field_1793[2][var38] = (var4 = this.field_1793[2][var38]) & ((var8 = this.field_1793[4][var38]) & (var10 = this.field_1793[5][var38]) & ((var30 = ~(var22 = var1.field_1793[3][var38])) & (var34 = ~(var26 = var1.field_1793[5][var38])) | (var20 = var1.field_1793[2][var38]) & (var24 = var1.field_1793[4][var38])) | (var14 = ~(var6 = this.field_1793[3][var38])) & (var20 & var24 | ((var18 = ~var10) | (var16 = ~var8)) & var30) | var6 & (var18 | var16) & ((var32 = ~var24) & var34 | var20 & var22));
                    this.field_1793[3][var38] = var22 & (var32 | (var28 = ~var20)) | var6 & (var32 & var34 | var22 | var16 | (var12 = ~var4));
                    this.field_1793[4][var38] = var24 & (var28 & var22 | var6 & (var30 | var8) | var12 & var30 | var4 & var14 & var18 & var20) | var8 & (var30 & var34 | var14 & var10 | var12) | var4 & var14 & var18 & var22;
                    this.field_1793[5][var38] = var16 & (var28 & var32 & var26 | var10 & (var32 | var20 & var22)) | var30 & (var16 & var20 & var32 | var14 & (var28 & var26 | var20 & var32 | var10)) | var8 & (var10 & (var30 | var20 & var24) | var4 & var6 & (var28 & var26 | var18 & (var22 | var20) & var32));
                    if ((this.field_1793[3][var38] | this.field_1793[4][var38] | this.field_1793[5][var38]) != 0L) {
                        var3 = true;
                    }
                }
                for (; var38 < var37; ++var38) {
                    this.field_1793[2][var38] = 0L;
                    this.field_1793[3][var38] = (var22 = var1.field_1793[3][var38]) & (~(var24 = var1.field_1793[4][var38]) | (var28 = ~(var20 = var1.field_1793[2][var38])));
                    this.field_1793[4][var38] = var24 & (var28 | (var30 = ~var22));
                    this.field_1793[5][var38] = ~var20 & ~var24 & (var26 = var1.field_1793[5][var38]) | ~var22 & (var20 & ~var24 | ~var20 & var26);
                    if ((this.field_1793[3][var38] | this.field_1793[4][var38] | this.field_1793[5][var38]) != 0L) {
                        var3 = true;
                    }
                }
            }
            if (var3) {
                this.field_1783 |= 2;
            } else {
                this.field_1783 &= 2;
            }
            return this;
        } else {
            return this;
        }
    }

    public final boolean method_3075(class_65 var1) {
        int var2;
        int var3;
        long var4;
        long var6;
        long var8;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? ((~this.field_1789 & (this.field_1790 & this.field_1791 | this.field_1792) | ~this.field_1790 & ~this.field_1791 & this.field_1792) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : ((~this.field_1793[2][var3] & ((var4 = this.field_1793[3][var3]) & (var6 = this.field_1793[4][var3]) | (var8 = this.field_1793[5][var3])) | ~var4 & ~var6 & var8) & 1L << var2 % 64) != 0L))) : false;
    }

    public final boolean method_3076(class_65 var1) {
        int var2;
        int var3;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? (this.field_1789 & this.field_1791 & (this.field_1790 & this.field_1792 | ~this.field_1790) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[4][var3] & (this.field_1793[3][var3] & this.field_1793[5][var3] | ~this.field_1793[3][var3]) & 1L << var2 % 64) != 0L))) : false;
    }

    public final boolean method_3077(class_65 var1) {
        int var2;
        int var3;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? (this.field_1789 & this.field_1790 & (~this.field_1791 | ~this.field_1792) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[3][var3] & (~this.field_1793[4][var3] | ~this.field_1793[5][var3]) & 1L << var2 % 64) != 0L))) : false;
    }

    public class_301 method_3078() {
        if (this == field_1784) {
            return this;
        } else {
            class_303 var10000 = new class_303();
            class_303 var1 = var10000;
            var1.field_1787 = this.field_1787;
            var1.field_1788 = this.field_1788;
            boolean var2 = (this.field_1783 & 2) != 0;
            if (var2) {
                var1.field_1789 = this.field_1789;
                var1.field_1790 = this.field_1790;
                var1.field_1791 = this.field_1791;
                var1.field_1792 = this.field_1792;
            }
            var1.field_1783 = this.field_1783;
            var1.field_1794 = this.field_1794;
            if (this.field_1793 != null) {
                var1.field_1793 = new long[6][];
                int var3;
                System.arraycopy(this.field_1793[0], 0, var1.field_1793[0] = new long[var3 = this.field_1793[0].length], 0, var3);
                System.arraycopy(this.field_1793[1], 0, var1.field_1793[1] = new long[var3], 0, var3);
                int var4;
                if (var2) {
                    for (var4 = 2; var4 < 6; ++var4) {
                        System.arraycopy(this.field_1793[var4], 0, var1.field_1793[var4] = new long[var3], 0, var3);
                    }
                } else {
                    for (var4 = 2; var4 < 6; ++var4) {
                        var1.field_1793[var4] = new long[var3];
                    }
                }
            }
            return var1;
        }
    }

    public class_303 method_3114() {
        if (this == field_1784) {
            return this;
        } else {
            this.field_1787 = this.field_1788 = 0L;
            if (this.field_1793 != null) {
                int var1 = 0;
                for (int var2 = this.field_1793[0].length; var1 < var2; ++var1) {
                    this.field_1793[0][var1] = this.field_1793[1][var1] = 0L;
                }
            }
            return this;
        }
    }

    public class_303 method_3115() {
        int var1 = this.field_1794;
        if (var1 < 64) {
            long var2 = (1L << var1) - 1L;
            this.field_1787 &= var2;
            this.field_1788 &= var2;
            this.field_1789 &= var2;
            this.field_1790 &= var2;
            this.field_1791 &= var2;
            this.field_1792 &= var2;
        }
        if (this.field_1793 == null) {
            return this;
        } else {
            int var3 = this.field_1793[0].length;
            int var7;
            if ((var7 = var1 / 64 - 1) >= var3) {
                return this;
            } else {
                if (var7 >= 0) {
                    long var4 = (1L << var1 % 64) - 1L;
                    for (int var6 = 0; var6 < 6; ++var6) {
                        this.field_1793[var6][var7] &= var4;
                    }
                }
                for (int var8 = var7 + 1; var8 < var3; ++var8) {
                    for (int var5 = 0; var5 < 6; ++var5) {
                        this.field_1793[var5][var8] = 0L;
                    }
                }
                return this;
            }
        }
    }

    public class_301 method_3080() {
        return this;
    }

    public class_301 method_3081() {
        return this;
    }

    private final boolean method_3116(int var1) {
        int var2;
        return var1 < 64 ? (this.field_1787 & 1L << var1) != 0L : (this.field_1793 == null ? false : ((var2 = var1 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[0][var2] & 1L << var1 % 64) != 0L));
    }

    public final boolean method_3082(class_67 var1) {
        return (this.field_1783 & 1) != 0 ? true : this.method_3116(var1.field_304);
    }

    public final boolean method_3083(class_65 var1) {
        return (this.field_1783 & 1) != 0 && (var1.field_309.field_446 & 1073741824) != 0 ? true : this.method_3116(var1.field_304 + this.field_1794);
    }

    public final boolean method_3084(class_65 var1) {
        if ((this.field_1783 & 1) == 0 && (this.field_1783 & 2) != 0) {
            if ((var1.field_301.field_178 & 2L) == 0L && var1.method_407() == class_331.field_1896) {
                int var2 = var1.field_304 + this.field_1794;
                int var3;
                return var2 < 64 ? (this.field_1789 & this.field_1791 & (~this.field_1790 | this.field_1792) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[4][var3] & (~this.field_1793[3][var3] | this.field_1793[5][var3]) & 1L << var2 % 64) != 0L));
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public final boolean method_3085(class_65 var1) {
        if ((this.field_1783 & 1) == 0 && (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L) {
            int var2 = var1.field_304 + this.field_1794;
            int var3;
            return var2 < 64 ? (this.field_1789 & this.field_1790 & (~this.field_1791 | ~this.field_1792) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[3][var3] & (~this.field_1793[4][var3] | ~this.field_1793[5][var3]) & 1L << var2 % 64) != 0L));
        } else {
            return false;
        }
    }

    public final boolean method_3086(class_65 var1) {
        if ((this.field_1783 & 1) == 0 && (this.field_1783 & 2) != 0) {
            int var2 = var1.field_304 + this.field_1794;
            int var3;
            return var2 < 64 ? (this.field_1789 & this.field_1792 & ~this.field_1790 & ~this.field_1791 & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[5][var3] & ~this.field_1793[3][var3] & ~this.field_1793[4][var3] & 1L << var2 % 64) != 0L));
        } else {
            return false;
        }
    }

    private final boolean method_3117(int var1) {
        int var2;
        return var1 < 64 ? (this.field_1788 & 1L << var1) != 0L : (this.field_1793 == null ? false : ((var2 = var1 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[1][var2] & 1L << var1 % 64) != 0L));
    }

    public final boolean method_3087(class_67 var1) {
        return this.method_3117(var1.field_304);
    }

    public final boolean method_3088(class_65 var1) {
        return var1.method_407() != class_331.field_1896 ? true : this.method_3117(var1.field_304 + this.field_1794);
    }

    public final boolean method_3089(class_65 var1) {
        int var2;
        int var3;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? (this.field_1791 & (~this.field_1789 | ~this.field_1790) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[4][var3] & (~this.field_1793[2][var3] | ~this.field_1793[3][var3]) & 1L << var2 % 64) != 0L))) : false;
    }

    public final boolean method_3090(class_65 var1) {
        int var2;
        int var3;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? (this.field_1790 & (~this.field_1789 | ~this.field_1791) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[3][var3] & (~this.field_1793[2][var3] | ~this.field_1793[4][var3]) & 1L << var2 % 64) != 0L))) : false;
    }

    public final boolean method_3091(class_65 var1) {
        if ((this.field_1783 & 1) == 0 && (this.field_1783 & 2) != 0) {
            int var2 = var1.field_304 + this.field_1794;
            int var3;
            return var2 < 64 ? (this.field_1792 & (~this.field_1789 | ~this.field_1790 & ~this.field_1791) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[5][var3] & (~this.field_1793[2][var3] | ~this.field_1793[3][var3] & ~this.field_1793[4][var3]) & 1L << var2 % 64) != 0L));
        } else {
            return false;
        }
    }

    public final boolean method_3092(class_65 var1) {
        int var2;
        int var3;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? (this.field_1789 & this.field_1791 & this.field_1792 & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[4][var3] & this.field_1793[5][var3] & 1L << var2 % 64) != 0L))) : false;
    }

    public final boolean method_3093(class_65 var1) {
        int var2;
        int var3;
        return (this.field_1783 & 2) != 0 && (var1.field_301.field_178 & 2L) == 0L ? ((var2 = var1.field_304 + this.field_1794) < 64 ? (this.field_1789 & this.field_1790 & (this.field_1791 ^ this.field_1792) & 1L << var2) != 0L : (this.field_1793 == null ? false : ((var3 = var2 / 64 - 1) >= this.field_1793[0].length ? false : (this.field_1793[2][var3] & this.field_1793[3][var3] & (this.field_1793[4][var3] ^ this.field_1793[5][var3]) & 1L << var2 % 64) != 0L))) : false;
    }

    public void method_3094(class_65 var1) {
        if (this != field_1784) {
            this.field_1783 |= 2;
            int var2;
            long var3;
            long var5;
            long var7;
            long var9;
            long var11;
            long var13;
            if ((var2 = var1.field_304 + this.field_1794) < 64) {
                long var10000 = var3 = 1L << var2;
                var5 = this.field_1789;
                var10000 &= this.field_1789;
                var7 = this.field_1790;
                var10000 &= var13 = ~this.field_1790;
                var9 = this.field_1791;
                var10000 &= ~this.field_1791;
                var11 = this.field_1792;
                if ((var10000 & this.field_1792) != 0L) {
                    this.field_1792 &= ~var3;
                } else if ((var3 & var5 & var13 & var9) == 0L) {
                    this.field_1792 |= var3;
                    if ((var3 & var5) == 0L) {
                        if ((var3 & var7 & (var9 ^ var11)) != 0L) {
                            this.field_1790 &= ~var3;
                        } else if ((var3 & (var7 | var9 | var11)) == 0L) {
                            this.field_1790 |= var3;
                        }
                    }
                }
                this.field_1789 |= var3;
                this.field_1791 |= var3;
            } else {
                int var15 = var2 / 64 - 1;
                int var17;
                int var16;
                if (this.field_1793 == null) {
                    var16 = var15 + 1;
                    this.field_1793 = new long[6][];
                    for (var17 = 0; var17 < 6; ++var17) {
                        this.field_1793[var17] = new long[var16];
                    }
                } else if (var15 >= (var16 = this.field_1793[0].length)) {
                    var17 = var15 + 1;
                    for (int var18 = 0; var18 < 6; ++var18) {
                        System.arraycopy(this.field_1793[var18], 0, this.field_1793[var18] = new long[var17], 0, var16);
                    }
                }
                if (((var3 = 1L << var2 % 64) & (var5 = this.field_1793[2][var15]) & (var13 = ~(var7 = this.field_1793[3][var15])) & ~(var9 = this.field_1793[4][var15]) & (var11 = this.field_1793[5][var15])) != 0L) {
                    this.field_1793[5][var15] &= ~var3;
                } else if ((var3 & var5 & var13 & var9) == 0L) {
                    this.field_1793[5][var15] |= var3;
                    if ((var3 & var5) == 0L) {
                        if ((var3 & var7 & (var9 ^ var11)) != 0L) {
                            this.field_1793[3][var15] &= ~var3;
                        } else if ((var3 & (var7 | var9 | var11)) == 0L) {
                            this.field_1793[3][var15] |= var3;
                        }
                    }
                }
                this.field_1793[2][var15] |= var3;
                this.field_1793[4][var15] |= var3;
            }
        }
    }

    public void method_3095(class_65 var1) {
        if (this != field_1784) {
            this.field_1783 |= 2;
            int var2;
            long var3;
            if ((var2 = var1.field_304 + this.field_1794) < 64) {
                if (((var3 = 1L << var2) & this.field_1789) != 0L) {
                    if ((var3 & (~this.field_1790 | this.field_1791 | ~this.field_1792)) != 0L) {
                        this.field_1792 &= ~var3;
                    }
                } else if ((var3 & this.field_1792) != 0L) {
                    this.field_1791 &= ~var3;
                } else if ((var3 & this.field_1790) != 0L) {
                    this.field_1791 &= ~var3;
                    this.field_1792 |= var3;
                } else {
                    this.field_1791 |= var3;
                }
                this.field_1789 |= var3;
                this.field_1790 |= var3;
            } else {
                int var5 = var2 / 64 - 1;
                var3 = 1L << var2 % 64;
                int var6;
                int var7;
                if (this.field_1793 == null) {
                    var6 = var5 + 1;
                    this.field_1793 = new long[6][];
                    for (var7 = 0; var7 < 6; ++var7) {
                        this.field_1793[var7] = new long[var6];
                    }
                } else if (var5 >= (var6 = this.field_1793[0].length)) {
                    var7 = var5 + 1;
                    for (int var8 = 0; var8 < 6; ++var8) {
                        System.arraycopy(this.field_1793[var8], 0, this.field_1793[var8] = new long[var7], 0, var6);
                    }
                }
                if ((var3 & this.field_1793[2][var5]) != 0L) {
                    if ((var3 & (~this.field_1793[3][var5] | this.field_1793[4][var5] | ~this.field_1793[5][var5])) != 0L) {
                        this.field_1793[5][var5] &= ~var3;
                    }
                } else if ((var3 & this.field_1793[5][var5]) != 0L) {
                    this.field_1793[4][var5] &= ~var3;
                } else if ((var3 & this.field_1793[3][var5]) != 0L) {
                    this.field_1793[4][var5] &= ~var3;
                    this.field_1793[5][var5] |= var3;
                } else {
                    this.field_1793[4][var5] |= var3;
                }
                this.field_1793[2][var5] |= var3;
                this.field_1793[3][var5] |= var3;
            }
        }
    }

    private final void method_3118(int var1) {
        if (this != field_1784) {
            if (var1 < 64) {
                long var2;
                this.field_1787 |= var2 = 1L << var1;
                this.field_1788 |= var2;
            } else {
                int var5 = var1 / 64 - 1;
                int var3;
                int var4;
                if (this.field_1793 == null) {
                    var3 = var5 + 1;
                    this.field_1793 = new long[6][];
                    for (var4 = 0; var4 < 6; ++var4) {
                        this.field_1793[var4] = new long[var3];
                    }
                } else if (var5 >= (var3 = this.field_1793[0].length)) {
                    for (var4 = 0; var4 < 6; ++var4) {
                        System.arraycopy(this.field_1793[var4], 0, this.field_1793[var4] = new long[var5 + 1], 0, var3);
                    }
                }
                long var6;
                this.field_1793[0][var5] |= var6 = 1L << var1 % 64;
                this.field_1793[1][var5] |= var6;
            }
        }
    }

    public void method_3096(class_67 var1) {
        if (this != field_1784) {
            this.method_3118(var1.field_304);
        }
    }

    public void method_3099(class_65 var1) {
        if (this != field_1784) {
            this.method_3118(var1.field_304 + this.field_1794);
        }
    }

    public void method_3097(class_65 var1) {
        if (this != field_1784) {
            this.field_1783 |= 2;
            long var2;
            int var4;
            if ((var4 = var1.field_304 + this.field_1794) < 64) {
                this.field_1789 |= var2 = 1L << var4;
                this.field_1791 |= var2;
                this.field_1790 &= var2 = ~var2;
                this.field_1792 &= var2;
            } else {
                long[] var10000 = this.field_1793[2];
                int var5;
                int var10001 = var5 = var4 / 64 - 1;
                var10000[var10001] |= var2 = 1L << var4 % 64;
                this.field_1793[4][var5] |= var2;
                this.field_1793[3][var5] &= var2 = ~var2;
                this.field_1793[5][var5] &= var2;
            }
        }
    }

    public void method_3098(class_65 var1) {
        if (this != field_1784) {
            this.field_1783 |= 2;
            long var2;
            int var4;
            if ((var4 = var1.field_304 + this.field_1794) < 64) {
                this.field_1789 |= var2 = 1L << var4;
                this.field_1790 |= var2;
                this.field_1791 &= var2 = ~var2;
                this.field_1792 &= var2;
            } else {
                long[] var10000 = this.field_1793[2];
                int var5;
                int var10001 = var5 = var4 / 64 - 1;
                var10000[var10001] |= var2 = 1L << var4 % 64;
                this.field_1793[3][var5] |= var2;
                this.field_1793[4][var5] &= var2 = ~var2;
                this.field_1793[5][var5] &= var2;
            }
        }
    }

    public void method_3100(class_65 var1) {
        if (this != field_1784) {
            this.field_1783 |= 2;
            long var2;
            int var4;
            if ((var4 = var1.field_304 + this.field_1794) < 64) {
                this.field_1789 |= var2 = 1L << var4;
                this.field_1792 |= var2;
                this.field_1790 &= var2 = ~var2;
                this.field_1791 &= var2;
            } else {
                long[] var10000 = this.field_1793[2];
                int var5;
                int var10001 = var5 = var4 / 64 - 1;
                var10000[var10001] |= var2 = 1L << var4 % 64;
                this.field_1793[5][var5] |= var2;
                this.field_1793[3][var5] &= var2 = ~var2;
                this.field_1793[4][var5] &= var2;
            }
        }
    }

    public class_303 method_3105(class_303 var1) {
        if ((var1.field_1783 & 1) != 0 && this != field_1784) {
            return this;
        } else if ((this.field_1783 & 1) != 0) {
            return (class_303)var1.method_3078();
        } else {
            this.field_1787 &= var1.field_1787;
            this.field_1788 |= var1.field_1788;
            boolean var2 = (this.field_1783 & 2) != 0;
            boolean var3 = (var1.field_1783 & 2) != 0;
            long var5;
            long var7;
            long var9;
            long var11;
            long var13;
            long var15;
            long var17;
            long var19;
            long var21;
            long var23;
            long var25;
            long var27;
            long var29;
            long var31;
            long var35;
            long var33;
            long var10002;
            if (var2) {
                if (var3) {
                    var7 = this.field_1790;
                    var9 = this.field_1791;
                    long var10001 = this.field_1790 & this.field_1791;
                    var11 = this.field_1792;
                    var10001 &= this.field_1792;
                    var29 = var1.field_1789;
                    var10001 &= var1.field_1789;
                    var31 = var1.field_1790;
                    var10001 &= var23 = ~var1.field_1790;
                    var5 = this.field_1789;
                    long var10004 = var9 & var11;
                    var33 = var1.field_1791;
                    var10004 &= var1.field_1791;
                    var35 = var1.field_1792;
                    this.field_1789 = var10001 | this.field_1789 & (var29 & (var10004 & var1.field_1792 | (var15 = ~var7) & var23 & ((var27 = ~var35) | (var19 = ~var11) | (var17 = ~var9) & (var25 = ~var33)) | var7 & var31 & (var19 | var17) & (var27 | var25)) | var15 & var31 & var33 & var35);
                    this.field_1790 = var31 & (var25 | (var21 = ~var29) | var9 & (var11 | (var13 = ~var5)) & var27) | var7 & (var31 | var19 & var33 & (var35 | var21) | var17 | var13);
                    this.field_1791 = var33 & (var23 & var35 | var21 | var9 & (var19 & var27 | var11 & var35)) | var9 & (var15 & var11 | var13) | (var7 | var13) & var29 & var23 & var27 | var5 & var15 & var19 & (var31 | var21);
                    this.field_1792 = var17 & (var21 & var25 & var35 | var29 & (var23 & var25 | var11 & var31 & var27) | var13 & var11 & (var25 | var29 & var31)) | var9 & var11 & (var33 & var35 | var29 & var23) | var15 & (var21 & var35 | var29 & var25 | var13 & var11) & var23 | var5 & (var17 & (var25 & var35 | var29 & var31 & var33 & var27 | var15 & (var25 | var23)) | var15 & var33 & var35 | var7 & (var21 & var35 | var9 & var19 & var29) & var25);
                } else {
                    var5 = this.field_1789;
                    this.field_1789 = 0L;
                    var7 = this.field_1790;
                    var9 = this.field_1791;
                    this.field_1790 &= var17 = ~this.field_1791 | (var13 = ~var5);
                    var10002 = var15 = ~var7;
                    var11 = this.field_1792;
                    this.field_1791 = var9 & (var10002 & this.field_1792 | var13) | var5 & var15 & ~var11;
                    this.field_1792 = (var17 | var15) & var13 & var11 | var5 & var17 & var15;
                }
            } else if (var3) {
                this.field_1789 = 0L;
                var31 = var1.field_1790;
                var33 = var1.field_1791;
                var10002 = ~var1.field_1791;
                var29 = var1.field_1789;
                this.field_1790 = var1.field_1790 & (var25 = var10002 | (var21 = ~var1.field_1789));
                var10002 = var23 = ~var31;
                var35 = var1.field_1792;
                this.field_1791 = var33 & (var10002 & var1.field_1792 | var21) | var29 & var23 & ~var35;
                this.field_1792 = (var25 | var23) & var21 & var35 | var29 & var25 & var23;
                var2 = this.field_1790 != 0L || this.field_1791 != 0L || this.field_1792 != 0L;
            }
            if (this.field_1793 != null || var1.field_1793 != null) {
                int var37 = 0;
                int var38 = 0;
                int var39 = 0;
                int var42;
                int var41;
                if (this.field_1793 != null) {
                    if (var1.field_1793 != null) {
                        if ((var41 = this.field_1793[0].length) < (var42 = var1.field_1793[0].length)) {
                            for (int var43 = 0; var43 < 6; ++var43) {
                                System.arraycopy(this.field_1793[var43], 0, this.field_1793[var43] = new long[var42], 0, var41);
                            }
                            var37 = var41;
                            var38 = var42;
                        } else {
                            var37 = var42;
                            var39 = var41;
                        }
                    } else {
                        var39 = this.field_1793[0].length;
                    }
                } else if (var1.field_1793 != null) {
                    var41 = var1.field_1793[0].length;
                    this.field_1793 = new long[6][];
                    for (var42 = 0; var42 < 6; ++var42) {
                        this.field_1793[var42] = new long[var41];
                    }
                    System.arraycopy(var1.field_1793[1], 0, this.field_1793[1], 0, var41);
                    var38 = var41;
                }
                int var40;
                for (var40 = 0; var40 < var37; ++var40) {
                    this.field_1793[0][var40] &= var1.field_1793[0][var40];
                    this.field_1793[1][var40] |= var1.field_1793[1][var40];
                }
                while (var40 < var38) {
                    this.field_1793[1][var40] = var1.field_1793[1][var40];
                    ++var40;
                }
                while (var40 < var39) {
                    this.field_1793[0][var40] = 0L;
                    ++var40;
                }
                if (!var3) {
                    if (var39 < var37) {
                        var39 = var37;
                    }
                    var38 = 0;
                    var37 = 0;
                }
                if (!var2) {
                    var39 = 0;
                }
                for (var40 = 0; var40 < var37; ++var40) {
                    this.field_1793[2][var40] = (var7 = this.field_1793[3][var40]) & (var9 = this.field_1793[4][var40]) & (var11 = this.field_1793[5][var40]) & (var29 = var1.field_1793[2][var40]) & (var23 = ~(var31 = var1.field_1793[3][var40])) | (var5 = this.field_1793[2][var40]) & (var29 & (var9 & var11 & (var33 = var1.field_1793[4][var40]) & (var35 = var1.field_1793[5][var40]) | (var15 = ~var7) & var23 & ((var27 = ~var35) | (var19 = ~var11) | (var17 = ~var9) & (var25 = ~var33)) | var7 & var31 & (var19 | var17) & (var27 | var25)) | var15 & var31 & var33 & var35);
                    this.field_1793[3][var40] = var31 & (var25 | (var21 = ~var29) | var9 & (var11 | (var13 = ~var5)) & var27) | var7 & (var31 | var19 & var33 & (var35 | var21) | var17 | var13);
                    this.field_1793[4][var40] = var33 & (var23 & var35 | var21 | var9 & (var19 & var27 | var11 & var35)) | var9 & (var15 & var11 | var13) | (var7 | var13) & var29 & var23 & var27 | var5 & var15 & var19 & (var31 | var21);
                    this.field_1793[5][var40] = var17 & (var21 & var25 & var35 | var29 & (var23 & var25 | var11 & var31 & var27) | var13 & var11 & (var25 | var29 & var31)) | var9 & var11 & (var33 & var35 | var29 & var23) | var15 & (var21 & var35 | var29 & var25 | var13 & var11) & var23 | var5 & (var17 & (var25 & var35 | var29 & var31 & var33 & var27 | var15 & (var25 | var23)) | var15 & var33 & var35 | var7 & (var21 & var35 | var9 & var19 & var29) & var25);
                    var2 = var2 || this.field_1793[3][var40] != 0L || this.field_1793[4][var40] != 0L || this.field_1793[5][var40] != 0L;
                }
                while (var40 < var38) {
                    this.field_1793[2][var40] = 0L;
                    this.field_1793[3][var40] = (var31 = var1.field_1793[3][var40]) & (var25 = ~(var33 = var1.field_1793[4][var40]) | (var21 = ~(var29 = var1.field_1793[2][var40])));
                    this.field_1793[4][var40] = var33 & ((var23 = ~var31) & (var35 = var1.field_1793[5][var40]) | var21) | var29 & var23 & ~var35;
                    this.field_1793[5][var40] = (var25 | var23) & var21 & var35 | var29 & var25 & var23;
                    var2 = var2 || this.field_1793[3][var40] != 0L || this.field_1793[4][var40] != 0L || this.field_1793[5][var40] != 0L;
                    ++var40;
                }
                while (var40 < var39) {
                    var5 = this.field_1793[2][var40];
                    this.field_1793[2][var40] = 0L;
                    this.field_1793[3][var40] = (var7 = this.field_1793[3][var40]) & (var17 = ~(var9 = this.field_1793[4][var40]) | (var13 = ~var5));
                    this.field_1793[4][var40] = var9 & ((var15 = ~var7) & (var11 = this.field_1793[5][var40]) | var13) | var5 & var15 & ~var11;
                    this.field_1793[5][var40] = (var17 | var15) & var13 & var11 | var5 & var17 & var15;
                    var2 = var2 || this.field_1793[3][var40] != 0L || this.field_1793[4][var40] != 0L || this.field_1793[5][var40] != 0L;
                    ++var40;
                }
            }
            if (var2) {
                this.field_1783 |= 2;
            } else {
                this.field_1783 &= -3;
            }
            return this;
        }
    }

    public class_303 method_3106() {
        if (this == field_1784) {
            return this;
        } else {
            class_303 var10000 = new class_303();
            class_303 var1 = var10000;
            var1.field_1787 = this.field_1787;
            var1.field_1788 = this.field_1788;
            var1.field_1783 = this.field_1783 & -3;
            var1.field_1794 = this.field_1794;
            if (this.field_1793 != null) {
                var1.field_1793 = new long[6][];
                int var2;
                System.arraycopy(this.field_1793[0], 0, var1.field_1793[0] = new long[var2 = this.field_1793[0].length], 0, var2);
                System.arraycopy(this.field_1793[1], 0, var1.field_1793[1] = new long[var2], 0, var2);
                for (int var3 = 2; var3 < 6; ++var3) {
                    var1.field_1793[var3] = new long[var2];
                }
            }
            return var1;
        }
    }

    public class_301 method_3103() {
        return this.method_3078();
    }

    public class_301 method_3104(int var1) {
        if (var1 == 0 && this != field_1784) {
            this.field_1783 &= -2;
        } else {
            if ((this.field_1783 & 1) == 0) {
                this.field_1788 = 0L;
                if (this.field_1793 != null) {
                    int var2 = 0;
                    for (int var3 = this.field_1793[0].length; var2 < var3; ++var2) {
                        this.field_1793[1][var2] = 0L;
                    }
                }
            }
            this.field_1783 |= 1;
        }
        return this;
    }

    public String toString() {
        if (this == field_1784) {
            return "FlowInfo.DEAD_END";
        } else {
            String var1;
            String var2;
            int var4;
            if ((this.field_1783 & 2) != 0) {
                if (this.field_1793 == null) {
                    return "FlowInfo<def: " + this.field_1787 + ", pot: " + this.field_1788 + ", reachable:" + ((this.field_1783 & 1) == 0) + ", null: " + this.field_1789 + this.field_1790 + this.field_1791 + this.field_1792 + ">";
                } else {
                    var1 = "FlowInfo<def:[" + this.field_1787;
                    var2 = "], pot:[" + this.field_1788;
                    String var6 = ", null:[" + this.field_1789 + this.field_1790 + this.field_1791 + this.field_1792;
                    var4 = 0;
                    int var5;
                    for (var5 = this.field_1793[0].length > 3 ? 3 : this.field_1793[0].length; var4 < var5; ++var4) {
                        var1 = var1 + "," + this.field_1793[0][var4];
                        var2 = var2 + "," + this.field_1793[1][var4];
                        var6 = var6 + "," + this.field_1793[2][var4] + this.field_1793[3][var4] + this.field_1793[4][var4] + this.field_1793[5][var4];
                    }
                    if (var5 < this.field_1793[0].length) {
                        var1 = var1 + ",...";
                        var2 = var2 + ",...";
                        var6 = var6 + ",...";
                    }
                    return var1 + var2 + "], reachable:" + ((this.field_1783 & 1) == 0) + var6 + "]>";
                }
            } else if (this.field_1793 == null) {
                return "FlowInfo<def: " + this.field_1787 + ", pot: " + this.field_1788 + ", reachable:" + ((this.field_1783 & 1) == 0) + ", no null info>";
            } else {
                var1 = "FlowInfo<def:[" + this.field_1787;
                var2 = "], pot:[" + this.field_1788;
                int var3 = 0;
                for (var4 = this.field_1793[0].length > 3 ? 3 : this.field_1793[0].length; var3 < var4; ++var3) {
                    var1 = var1 + "," + this.field_1793[0][var3];
                    var2 = var2 + "," + this.field_1793[1][var3];
                }
                if (var4 < this.field_1793[0].length) {
                    var1 = var1 + ",...";
                    var2 = var2 + ",...";
                }
                return var1 + var2 + "], reachable:" + ((this.field_1783 & 1) == 0) + ", no null info>";
            }
        }
    }

    public class_303 method_3107() {
        return (class_303)this.method_3078();
    }

    public class_303 method_3108() {
        class_303 var10000 = new class_303();
        class_303 var1 = var10000;
        var1.field_1783 = this.field_1783;
        var1.field_1794 = this.field_1794;
        int var2 = this.field_1794;
        if (var2 < 64) {
            long var3;
            var1.field_1787 = this.field_1787 & (var3 = ~((1L << var2) - 1L));
            var1.field_1788 = this.field_1788 & var3;
            var1.field_1789 = this.field_1789 & var3;
            var1.field_1790 = this.field_1790 & var3;
            var1.field_1791 = this.field_1791 & var3;
            var1.field_1792 = this.field_1792 & var3;
        }
        if (this.field_1793 == null) {
            return var1;
        } else {
            int var4;
            int var10;
            if ((var10 = var2 / 64 - 1) >= (var4 = this.field_1793[0].length)) {
                return var1;
            } else {
                var1.field_1793 = new long[6][];
                int var5;
                int var8;
                if ((var5 = var10 + 1) < var4) {
                    var8 = var4 - var5;
                    for (int var9 = 0; var9 < 6; ++var9) {
                        System.arraycopy(this.field_1793[var9], var5, var1.field_1793[var9] = new long[var4], var5, var8);
                    }
                } else if (var10 >= 0) {
                    for (var8 = 0; var8 < 6; ++var8) {
                        var1.field_1793[var8] = new long[var4];
                    }
                }
                if (var10 >= 0) {
                    long var6 = ~((1L << var2 % 64) - 1L);
                    for (var8 = 0; var8 < 6; ++var8) {
                        var1.field_1793[var8][var10] = this.field_1793[var8][var10] & var6;
                    }
                }
                return var1;
            }
        }
    }

    public class_303 method_3109() {
        return this;
    }

    public class_303 method_3110() {
        return this;
    }
}
