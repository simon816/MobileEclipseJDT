package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;

public class NullInfoRegistry extends UnconditionalFlowInfo {

    public NullInfoRegistry(UnconditionalFlowInfo var1) {
        this.maxFieldCount = var1.maxFieldCount;
        if ((var1.tagBits & 2) != 0) {
            long var2 = var1.field_1789;
            long var4 = var1.field_1790;
            long var10001 = var1.field_1789 & var1.field_1790;
            long var6 = var1.field_1791;
            long var12;
            var10001 &= var12 = ~var1.field_1791;
            long var8 = var1.field_1792;
            long var14;
            this.field_1790 = var10001 & (var14 = ~var1.field_1792);
            long var10;
            this.field_1791 = var2 & (var10 = ~var4) & var6 & var14;
            this.field_1792 = var2 & var10 & var12 & var8;
            if ((this.field_1790 | this.field_1791 | this.field_1792) != 0L) {
                this.tagBits |= 2;
            }
            if (var1.extra != null) {
                this.extra = new long[6][];
                int var16 = var1.extra[2].length;
                int var17;
                for (var17 = 2; var17 < 6; ++var17) {
                    this.extra[var17] = new long[var16];
                }
                for (var17 = 0; var17 < var16; ++var17) {
                    this.extra[3][var17] = (var2 = var1.extra[2][var17]) & (var4 = var1.extra[3][var17]) & (var12 = ~(var6 = var1.extra[4][var17])) & (var14 = ~(var8 = var1.extra[5][var17]));
                    this.extra[4][var17] = var2 & (var10 = ~var4) & var6 & var14;
                    this.extra[5][var17] = var2 & var10 & var12 & var8;
                    if ((this.extra[3][var17] | this.extra[4][var17] | this.extra[5][var17]) != 0L) {
                        this.tagBits |= 2;
                    }
                }
            }
        }
    }

    public NullInfoRegistry add(NullInfoRegistry var1) {
        if ((var1.tagBits & 2) == 0) {
            return this;
        } else {
            this.tagBits |= 2;
            this.field_1789 |= var1.field_1789;
            this.field_1790 |= var1.field_1790;
            this.field_1791 |= var1.field_1791;
            this.field_1792 |= var1.field_1792;
            if (var1.extra != null) {
                int var2;
                int var3;
                if (this.extra == null) {
                    this.extra = new long[6][];
                    var2 = 2;
                    for (var3 = var1.extra[2].length; var2 < 6; ++var2) {
                        System.arraycopy(var1.extra[var2], 0, this.extra[var2] = new long[var3], 0, var3);
                    }
                } else {
                    var2 = this.extra[2].length;
                    var3 = var1.extra[2].length;
                    int var4;
                    if (var3 > var2) {
                        for (var4 = 2; var4 < 6; ++var4) {
                            System.arraycopy(this.extra[var4], 0, this.extra[var4] = new long[var3], 0, var2);
                            System.arraycopy(var1.extra[var4], var2, this.extra[var4], var2, var3 - var2);
                        }
                    } else if (var3 < var2) {
                        var2 = var3;
                    }
                    for (var4 = 2; var4 < 6; ++var4) {
                        for (int var5 = 0; var5 < var2; ++var5) {
                            this.extra[var4][var5] |= var1.extra[var4][var5];
                        }
                    }
                }
            }
            return this;
        }
    }

    public void method_3094(LocalVariableBinding var1) {
        if (this != DEAD_END) {
            this.tagBits |= 2;
            int var2;
            if ((var2 = var1.field_304 + this.maxFieldCount) < 64) {
                this.field_1789 |= 1L << var2;
            } else {
                int var3 = var2 / 64 - 1;
                int var4;
                int var5;
                if (this.extra == null) {
                    var4 = var3 + 1;
                    this.extra = new long[6][];
                    for (var5 = 2; var5 < 6; ++var5) {
                        this.extra[var5] = new long[var4];
                    }
                } else if (var3 >= (var4 = this.extra[2].length)) {
                    for (var5 = 2; var5 < 6; ++var5) {
                        System.arraycopy(this.extra[var5], 0, this.extra[var5] = new long[var3 + 1], 0, var4);
                    }
                }
                this.extra[2][var3] |= 1L << var2 % 64;
            }
        }
    }

    public void method_3097(LocalVariableBinding var1) {
        if (this != DEAD_END) {
            this.tagBits |= 2;
            int var2;
            if ((var2 = var1.field_304 + this.maxFieldCount) < 64) {
                this.field_1791 |= 1L << var2;
            } else {
                int var3 = var2 / 64 - 1;
                int var4;
                int var5;
                if (this.extra == null) {
                    var4 = var3 + 1;
                    this.extra = new long[6][];
                    for (var5 = 2; var5 < 6; ++var5) {
                        this.extra[var5] = new long[var4];
                    }
                } else if (var3 >= (var4 = this.extra[2].length)) {
                    for (var5 = 2; var5 < 6; ++var5) {
                        System.arraycopy(this.extra[var5], 0, this.extra[var5] = new long[var3 + 1], 0, var4);
                    }
                }
                this.extra[4][var3] |= 1L << var2 % 64;
            }
        }
    }

    public void method_3098(LocalVariableBinding var1) {
        if (this != DEAD_END) {
            this.tagBits |= 2;
            int var2;
            if ((var2 = var1.field_304 + this.maxFieldCount) < 64) {
                this.field_1790 |= 1L << var2;
            } else {
                int var3 = var2 / 64 - 1;
                int var4;
                int var5;
                if (this.extra == null) {
                    var4 = var3 + 1;
                    this.extra = new long[6][];
                    for (var5 = 2; var5 < 6; ++var5) {
                        this.extra[var5] = new long[var4];
                    }
                } else if (var3 >= (var4 = this.extra[2].length)) {
                    for (var5 = 2; var5 < 6; ++var5) {
                        System.arraycopy(this.extra[var5], 0, this.extra[var5] = new long[var3 + 1], 0, var4);
                    }
                }
                this.extra[3][var3] |= 1L << var2 % 64;
            }
        }
    }

    public void method_3100(LocalVariableBinding var1) {
        if (this != DEAD_END) {
            this.tagBits |= 2;
            int var2;
            if ((var2 = var1.field_304 + this.maxFieldCount) < 64) {
                this.field_1792 |= 1L << var2;
            } else {
                int var3 = var2 / 64 - 1;
                int var4;
                int var5;
                if (this.extra == null) {
                    var4 = var3 + 1;
                    this.extra = new long[6][];
                    for (var5 = 2; var5 < 6; ++var5) {
                        this.extra[var5] = new long[var4];
                    }
                } else if (var3 >= (var4 = this.extra[2].length)) {
                    for (var5 = 2; var5 < 6; ++var5) {
                        System.arraycopy(this.extra[var5], 0, this.extra[var5] = new long[var3 + 1], 0, var4);
                    }
                }
                this.extra[5][var3] |= 1L << var2 % 64;
            }
        }
    }

    public UnconditionalFlowInfo mitigateNullInfoOf(FlowInfo var1) {
        if ((this.tagBits & 2) == 0) {
            return var1.method_3109();
        } else {
            boolean var34 = false;
            UnconditionalFlowInfo var35 = var1.method_3109();
            long var20 = var35.field_1789;
            long var26 = var35.field_1791;
            long var10000 = var35.field_1789 & var35.field_1791;
            long var30 = var35.field_1792;
            var10000 &= var35.field_1792;
            long var14 = this.field_1790;
            long var18 = this.field_1792;
            long var4 = var10000 & (this.field_1790 | this.field_1792);
            long var22 = this.field_1790;
            var10000 = var20 & this.field_1790 & (var26 ^ var30);
            long var16 = this.field_1791;
            long var8 = var10000 & (this.field_1791 | var18);
            long var32;
            long var24;
            long var28;
            long var12 = var20 & (var22 & (var28 = ~var26) & (var32 = ~var30) & (var16 | var18) | (var24 = ~var22) & var26 & var32 & (var14 | var18) | var24 & var28 & var30 & (var14 | var16));
            long var2;
            long var6;
            long var10;
            if ((var2 = var4 | var8 | var12) != 0L) {
                var34 = true;
                var35 = var35.method_3107();
                var35.field_1789 &= ~var2;
                var35.field_1790 &= (var6 = ~var4) & ((var10 = ~var8) | var18);
                var35.field_1791 &= (var6 | var14) & var10;
                var35.field_1792 &= var6 & var10;
            }
            if (this.extra != null && var35.extra != null) {
                int var36 = this.extra[2].length;
                int var37 = var35.extra[0].length;
                if (var37 < var36) {
                    var36 = var37;
                }
                for (int var38 = 0; var38 < var36; ++var38) {
                    var4 = (var20 = var35.extra[2][var38]) & (var26 = var35.extra[4][var38]) & (var30 = var35.extra[5][var38]) & ((var14 = this.extra[3][var38]) | (var18 = this.extra[5][var38]));
                    var8 = var20 & (var22 = this.extra[3][var38]) & (var26 ^ var30) & ((var16 = this.extra[4][var38]) | var18);
                    var12 = var20 & (var22 & (var28 = ~var26) & (var32 = ~var30) & (var16 | var18) | (var24 = ~var22) & var26 & var32 & (var14 | var18) | var24 & var28 & var30 & (var14 | var16));
                    if ((var2 = var4 | var8 | var12) != 0L) {
                        if (!var34) {
                            var34 = true;
                            var35 = var35.method_3107();
                        }
                        var35.extra[2][var38] &= ~var2;
                        var35.extra[3][var38] &= (var6 = ~var4) & ((var10 = ~var8) | var18);
                        var35.extra[4][var38] &= (var6 | var14) & var10;
                        var35.extra[5][var38] &= var6 & var10;
                    }
                }
            }
            return var35;
        }
    }

    public String toString() {
        if (this.extra == null) {
            return "NullInfoRegistry<" + this.field_1789 + this.field_1790 + this.field_1791 + this.field_1792 + ">";
        } else {
            String var1 = "NullInfoRegistry<[" + this.field_1789 + this.field_1790 + this.field_1791 + this.field_1792;
            int var2 = 0;
            int var3;
            for (var3 = this.extra[0].length > 3 ? 3 : this.extra[0].length; var2 < var3; ++var2) {
                var1 = var1 + "," + this.extra[2][var2] + this.extra[3][var2] + this.extra[4][var2] + this.extra[5][var2];
            }
            if (var3 < this.extra[0].length) {
                var1 = var1 + ",...";
            }
            return var1 + "]>";
        }
    }
}
