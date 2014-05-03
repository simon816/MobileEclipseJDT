package i;

import java.io.IOException;
import i.class_77;
import m.class_40;

// $FF: renamed from: i.h
public class class_280 {

    // $FF: renamed from: a int
    public int field_1642;
    // $FF: renamed from: b int
    public int field_1643;
    // $FF: renamed from: c int
    private int field_1644;
    // $FF: renamed from: a i.c[]
    public class_77[] field_1645;
    // $FF: renamed from: b i.c[]
    public class_77[] field_1646;
    // $FF: renamed from: d int
    private int field_1647;

    // $FF: renamed from: <init> (int) void
    public class_280(int var1) {
        this.field_1647 = -1;
        this.field_1645 = new class_77[var1];
        this.field_1644 = -1;
        this.field_1647 = -1;
    }

    // $FF: renamed from: a (i.h) int
    public int method_2890(class_280 var1) {
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

    // $FF: renamed from: a (i.c) void
    public void method_2891(class_77 var1) {
        if (var1 == null) {
            throw new IllegalArgumentException("info cannot be null");
        } else {
            if (this.field_1646 == null) {
                this.field_1646 = new class_77[1];
                this.field_1646[0] = var1;
                this.field_1643 = 1;
            } else {
                int var2 = this.field_1646.length;
                if (this.field_1643 == var2) {
                    System.arraycopy(this.field_1646, 0, this.field_1646 = new class_77[var2 + 1], 0, var2);
                }
                this.field_1646[this.field_1643++] = var1;
            }
        }
    }

    // $FF: renamed from: a (m.s) void
    public void method_2892(class_40 var1) {
        class_77[] var10000;
        class_77 var10002;
        if (this.field_1646 == null) {
            this.field_1646 = new class_77[1];
            var10000 = this.field_1646;
            var10002 = new class_77(var1);
            var10000[0] = var10002;
            this.field_1643 = 1;
        } else {
            int var2 = this.field_1646.length;
            if (this.field_1643 == var2) {
                System.arraycopy(this.field_1646, 0, this.field_1646 = new class_77[var2 + 1], 0, var2);
            }
            var10000 = this.field_1646;
            int var10001 = this.field_1643++;
            var10002 = new class_77(var1);
            var10000[var10001] = var10002;
        }
    }

    // $FF: renamed from: a () i.h
    public class_280 method_2893() {
        class_280 var10000 = new class_280(this.field_1645.length);
        class_280 var1 = var10000;
        var1.field_1644 = -1;
        var1.field_1647 = -1;
        var1.field_1642 = this.field_1642;
        var1.field_1643 = this.field_1643;
        int var2 = this.field_1645 == null ? 0 : this.field_1645.length;
        int var3;
        if (var2 != 0) {
            var1.field_1645 = new class_77[var2];
            for (var3 = 0; var3 < var2; ++var3) {
                class_77 var4 = this.field_1645[var3];
                if (var4 != null) {
                    var1.field_1645[var3] = var4.method_474();
                }
            }
        }
        var2 = this.field_1643;
        if (var2 != 0) {
            var1.field_1646 = new class_77[var2];
            for (var3 = 0; var3 < var2; ++var3) {
                var1.field_1646[var3] = this.field_1646[var3].method_474();
            }
        }
        return var1;
    }

    // $FF: renamed from: b (i.h) int
    public int method_2894(class_280 var1) {
        if (this.field_1647 != -1) {
            return this.field_1647;
        } else if (var1 == null) {
            this.field_1647 = 0;
            return 0;
        } else {
            class_77[] var2 = var1.field_1645;
            class_77[] var3 = this.field_1645;
            int var4 = var2 == null ? 0 : var2.length;
            int var5 = var3 == null ? 0 : var3.length;
            int var6 = var1.method_2895();
            int var7 = this.method_2895();
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
                class_77 var13;
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
                        class_77 var14 = var2[var9];
                        if (var14 != null) {
                            ++var12;
                            switch (var14.method_473()) {
                                case 7:
                                case 8:
                                    ++var9;
                            }
                        }
                        if (this.method_2902(var14, var13) && var9 == var10) {
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

    // $FF: renamed from: a () int
    public int method_2895() {
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

    // $FF: renamed from: c (i.h) int
    public int method_2896(class_280 var1) {
        return var1 == null ? this.field_1642 : (var1.field_1642 == -1 ? this.field_1642 : this.field_1642 - var1.field_1642 - 1);
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        this.method_2897(var1, this);
        return String.valueOf(var1);
    }

    // $FF: renamed from: a (java.lang.StringBuffer, i.h) void
    private void method_2897(StringBuffer var1, class_280 var2) {
        var1.append("pc : ").append(var2.field_1642).append(" locals: ").append(var2.method_2895());
        var1.append(" stack items: ").append(var2.field_1643).append("\r\nlocals: ");
        var1.append(this.method_2898(var2.field_1645, var2.field_1645 == null ? 0 : var2.field_1645.length)).append("\r\nstack: ");
        var1.append(this.method_2898(var2.field_1646, var2.field_1643)).append("\r\n");
    }

    // $FF: renamed from: a (i.c[], int) java.lang.String
    private String method_2898(class_77[] var1, int var2) {
        StringBuffer var3 = new StringBuffer();
        var3.append('[');
        if (var1 != null) {
            for (int var4 = 0; var4 < var2; ++var4) {
                if (var4 != 0) {
                    var3.append(',');
                }
                class_77 var5 = var1[var4];
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

    // $FF: renamed from: a (int, i.c) void
    public void method_2899(int var1, class_77 var2) {
        if (this.field_1645 == null) {
            this.field_1645 = new class_77[var1 + 1];
            this.field_1645[var1] = var2;
        } else {
            int var3 = this.field_1645.length;
            if (var1 >= var3) {
                System.arraycopy(this.field_1645, 0, this.field_1645 = new class_77[var1 + 1], 0, var3);
            }
            this.field_1645[var1] = var2;
        }
    }

    // $FF: renamed from: a () void
    public void method_2900() {
        class_77 var1 = this.field_1646[this.field_1643 - 1];
        class_77 var2 = var1.method_474();
        var2.method_477();
        this.field_1646[this.field_1643 - 1] = var2;
    }

    // $FF: renamed from: a (int) int
    public int method_2901(int var1) {
        for (int var2 = this.field_1645.length - 1; var2 >= 0; --var2) {
            class_77 var3 = this.field_1645[var2];
            if (var3 != null) {
                --var1;
                if (var1 == 0) {
                    return var2;
                }
            }
        }
        return 0;
    }

    // $FF: renamed from: a (i.c, i.c) boolean
    private boolean method_2902(class_77 var1, class_77 var2) {
        return var1 == null ? var2 == null : (var2 == null ? false : var1.equals(var2));
    }
}
