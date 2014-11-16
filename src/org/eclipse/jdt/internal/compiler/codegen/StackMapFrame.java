package org.eclipse.jdt.internal.compiler.codegen;

import java.io.IOException;

import org.eclipse.jdt.internal.compiler.codegen.VerificationTypeInfo;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public class StackMapFrame {

    public int field_1642;

    public int field_1643;

    private int field_1644;

    public VerificationTypeInfo[] field_1645;

    public VerificationTypeInfo[] field_1646;

    private int field_1647;

    public StackMapFrame(int var1) {
        this.field_1647 = -1;
        this.field_1645 = new VerificationTypeInfo[var1];
        this.field_1644 = -1;
        this.field_1647 = -1;
    }

    public int method_2890(StackMapFrame var1) {
        int var2 = this.method_2896(var1);
        switch (this.field_1643) {
            case 0:
                switch (this.method_2894(var1)) {
                    case -3:
                    case -2:
                    case -1:
                        return 1;
                    case 0:
                        return var2 <= 63 ? 0 : 3;
                    case 1:
                    case 2:
                    case 3:
                        return 2;
                    default:
                        return 4;
                }
            case 1:
                switch (this.method_2894(var1)) {
                    case 0:
                        return var2 <= 63 ? 5 : 6;
                }
        }
        return 4;
    }

    public void addStackItem(VerificationTypeInfo var1) {
        if (var1 == null) {
            throw new IllegalArgumentException("info cannot be null");
        } else {
            if (this.field_1646 == null) {
                this.field_1646 = new VerificationTypeInfo[1];
                this.field_1646[0] = var1;
                this.field_1643 = 1;
            } else {
                int var2 = this.field_1646.length;
                if (this.field_1643 == var2) {
                    System.arraycopy(this.field_1646, 0, this.field_1646 = new VerificationTypeInfo[var2 + 1], 0, var2);
                }
                this.field_1646[this.field_1643++] = var1;
            }
        }
    }

    public void addStackItem(TypeBinding var1) {
        VerificationTypeInfo[] var10000;
        VerificationTypeInfo var10002;
        if (this.field_1646 == null) {
            this.field_1646 = new VerificationTypeInfo[1];
            var10000 = this.field_1646;
            var10002 = new VerificationTypeInfo(var1);
            var10000[0] = var10002;
            this.field_1643 = 1;
        } else {
            int var2 = this.field_1646.length;
            if (this.field_1643 == var2) {
                System.arraycopy(this.field_1646, 0, this.field_1646 = new VerificationTypeInfo[var2 + 1], 0, var2);
            }
            var10000 = this.field_1646;
            int var10001 = this.field_1643++;
            var10002 = new VerificationTypeInfo(var1);
            var10000[var10001] = var10002;
        }
    }

    public StackMapFrame duplicate() {
        StackMapFrame var10000 = new StackMapFrame(this.field_1645.length);
        StackMapFrame var1 = var10000;
        var1.field_1644 = -1;
        var1.field_1647 = -1;
        var1.field_1642 = this.field_1642;
        var1.field_1643 = this.field_1643;
        int var2 = this.field_1645 == null ? 0 : this.field_1645.length;
        int var3;
        if (var2 != 0) {
            var1.field_1645 = new VerificationTypeInfo[var2];
            for (var3 = 0; var3 < var2; ++var3) {
                VerificationTypeInfo var4 = this.field_1645[var3];
                if (var4 != null) {
                    var1.field_1645[var3] = var4.duplicate();
                }
            }
        }
        var2 = this.field_1643;
        if (var2 != 0) {
            var1.field_1646 = new VerificationTypeInfo[var2];
            for (var3 = 0; var3 < var2; ++var3) {
                var1.field_1646[var3] = this.field_1646[var3].duplicate();
            }
        }
        return var1;
    }

    public int method_2894(StackMapFrame var1) {
        if (this.field_1647 != -1) {
            return this.field_1647;
        } else if (var1 == null) {
            this.field_1647 = 0;
            return 0;
        } else {
            VerificationTypeInfo[] var2 = var1.field_1645;
            VerificationTypeInfo[] var3 = this.field_1645;
            int var4 = var2 == null ? 0 : var2.length;
            int var5 = var3 == null ? 0 : var3.length;
            int var6 = var1.getNumberOfLocals();
            int var7 = this.getNumberOfLocals();
            int var8 = 0;
            int var9;
            int var10;
            if (var6 == 0) {
                if (var7 != 0) {
                    var8 = var7;
                    var9 = 0;
                    var10 = 0;
                    while (var10 < var5 && var9 < var7) {
                        if (var3[var10] == null) {
                            var8 = Integer.MAX_VALUE;
                            this.field_1647 = var8;
                            return var8;
                        }
                        switch (var3[var10].method_473()) {
                            case 7:
                            case 8:
                                ++var10;
                            default:
                                ++var9;
                                ++var10;
                        }
                    }
                }
            } else if (var7 == 0) {
                var9 = 0;
                var8 = -var6;
                var10 = 0;
                while (var10 < var4 && var9 < var6) {
                    if (var2[var10] == null) {
                        var8 = Integer.MAX_VALUE;
                        this.field_1647 = var8;
                        return var8;
                    }
                    switch (var2[var10].method_473()) {
                        case 7:
                        case 8:
                            ++var10;
                        default:
                            ++var9;
                            ++var10;
                    }
                }
            } else {
                var9 = 0;
                var10 = 0;
                int var11 = 0;
                int var12 = 0;
                VerificationTypeInfo var13;
                while (var10 < var5 && var11 < var7) {
                    var13 = var3[var10];
                    if (var13 != null) {
                        ++var11;
                        switch (var13.method_473()) {
                            case 7:
                            case 8:
                                ++var10;
                        }
                    }
                    if (var9 < var4 && var12 < var6) {
                        VerificationTypeInfo var14 = var2[var9];
                        if (var14 != null) {
                            ++var12;
                            switch (var14.method_473()) {
                                case 7:
                                case 8:
                                    ++var9;
                            }
                        }
                        if (this.equals(var14, var13) && var9 == var10) {
                            if (var8 != 0) {
                                var8 = Integer.MAX_VALUE;
                                this.field_1647 = var8;
                                return var8;
                            }
                            ++var9;
                            ++var10;
                            continue;
                        }
                        var8 = Integer.MAX_VALUE;
                        this.field_1647 = var8;
                        return var8;
                    }
                    if (var13 == null) {
                        var8 = Integer.MAX_VALUE;
                        this.field_1647 = var8;
                        return var8;
                    }
                    ++var8;
                    ++var10;
                    break;
                }
                if (var11 < var7) {
                    while (var10 < var5 && var11 < var7) {
                        var13 = var3[var10];
                        if (var13 == null) {
                            var8 = Integer.MAX_VALUE;
                            this.field_1647 = var8;
                            return var8;
                        }
                        ++var8;
                        ++var11;
                        switch (var13.method_473()) {
                            case 7:
                            case 8:
                                ++var10;
                            default:
                                ++var10;
                        }
                    }
                } else if (var12 < var6) {
                    var8 = -var8;
                    while (var9 < var4 && var12 < var6) {
                        var13 = var2[var9];
                        if (var13 == null) {
                            var8 = Integer.MAX_VALUE;
                            this.field_1647 = var8;
                            return var8;
                        }
                        --var8;
                        ++var12;
                        switch (var13.method_473()) {
                            case 7:
                            case 8:
                                ++var9;
                            default:
                                ++var9;
                        }
                    }
                }
            }
            this.field_1647 = var8;
            return var8;
        }
    }

    public int getNumberOfLocals() {
        if (this.field_1644 != -1) {
            return this.field_1644;
        } else {
            int var1 = 0;
            int var2 = this.field_1645 == null ? 0 : this.field_1645.length;
            for (int var3 = 0; var3 < var2; ++var3) {
                if (this.field_1645[var3] != null) {
                    switch (this.field_1645[var3].method_473()) {
                        case 7:
                        case 8:
                            ++var3;
                        default:
                            ++var1;
                    }
                }
            }
            this.field_1644 = var1;
            return var1;
        }
    }

    public int method_2896(StackMapFrame var1) {
        return var1 == null ? this.field_1642 : (var1.field_1642 == -1 ? this.field_1642 : this.field_1642 - var1.field_1642 - 1);
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        this.printFrame(var1, this);
        return String.valueOf(var1);
    }

    private void printFrame(StringBuffer var1, StackMapFrame var2) {
        var1.append("pc : ").append(var2.field_1642).append(" locals: ").append(var2.getNumberOfLocals());
        var1.append(" stack items: ").append(var2.field_1643).append("\r\nlocals: ");
        var1.append(this.print(var2.field_1645, var2.field_1645 == null ? 0 : var2.field_1645.length)).append("\r\nstack: ");
        var1.append(this.print(var2.field_1646, var2.field_1643)).append("\r\n");
    }

    private String print(VerificationTypeInfo[] var1, int var2) {
        StringBuffer var3 = new StringBuffer();
        var3.append('[');
        if (var1 != null) {
            for (int var4 = 0; var4 < var2; ++var4) {
                if (var4 != 0) {
                    var3.append(',');
                }
                VerificationTypeInfo var5 = var1[var4];
                if (var5 == null) {
                    var3.append("top");
                } else {
                    var3.append(var5);
                }
            }
        }
        var3.append(']');
        return String.valueOf(var3);
    }

    public void method_2899(int var1, VerificationTypeInfo var2) {
        if (this.field_1645 == null) {
            this.field_1645 = new VerificationTypeInfo[var1 + 1];
            this.field_1645[var1] = var2;
        } else {
            int var3 = this.field_1645.length;
            if (var1 >= var3) {
                System.arraycopy(this.field_1645, 0, this.field_1645 = new VerificationTypeInfo[var1 + 1], 0, var3);
            }
            this.field_1645[var1] = var2;
        }
    }

    public void replaceWithElementType() {
        VerificationTypeInfo var1 = this.field_1646[this.field_1643 - 1];
        VerificationTypeInfo var2 = var1.duplicate();
        var2.replaceWithElementType();
        this.field_1646[this.field_1643 - 1] = var2;
    }

    public int getIndexOfDifferentLocals(int var1) {
        for (int var2 = this.field_1645.length - 1; var2 >= 0; --var2) {
            VerificationTypeInfo var3 = this.field_1645[var2];
            if (var3 != null) {
                --var1;
                if (var1 == 0) {
                    return var2;
                }
            }
        }
        return 0;
    }

    private boolean equals(VerificationTypeInfo var1, VerificationTypeInfo var2) {
        return var1 == null ? var2 == null : (var2 == null ? false : var1.equals(var2));
    }
}
