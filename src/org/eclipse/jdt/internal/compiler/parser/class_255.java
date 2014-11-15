package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.class_105;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_123;
import org.eclipse.jdt.internal.compiler.ast.class_124;
import org.eclipse.jdt.internal.compiler.ast.class_125;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_158;
import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.class_92;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.class_94;
import org.eclipse.jdt.internal.compiler.ast.class_96;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.parser.class_251;
import org.eclipse.jdt.internal.compiler.parser.class_257;
import org.eclipse.jdt.internal.compiler.parser.class_260;
import org.eclipse.jdt.internal.compiler.parser.class_261;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.util.Util;

public class class_255 extends class_251 {

    public AbstractMethodDeclaration field_1088;

    public class_257[] field_1089;

    public int field_1090;

    public int field_1091;

    public int field_1092;

    public class_260[] field_1093;

    public int field_1094;

    public class_261 field_1095;

    public boolean field_1096;

    int field_1097;

    int field_1098;

    class_257[] field_1099;

    int field_1100;

    public class_255(AbstractMethodDeclaration var1, class_251 var2, int var3, Parser var4) {
        super(var2, var3, var4);
        this.field_1096 = true;
        this.field_1098 = -1;
        this.field_1088 = var1;
        this.field_1070 = !this.method_1865();
        if (this.field_1070) {
            ++this.field_1069;
        }
    }

    public class_251 method_1833(class_112 var1, int var2) {
        if (this.field_1088.field_481 > 0 && var1.field_444 > this.field_1088.field_481) {
            this.method_1846();
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1833(var1, var2));
        } else {
            if (!this.field_1070) {
                this.field_1070 = true;
                ++this.field_1069;
            }
            class_261 var10001 = new class_261(var1, this, var2);
            this.field_1095 = var10001;
            if (var1.field_445 == 0) {
                return this.field_1095;
            }
            return this;
        }
    }

    public class_251 method_1834(class_121 var1, int var2) {
        this.method_1846();
        char[][] var3;
        if ((var1.field_656 & -17) == 0 && var1.field_660 != null && ((var3 = var1.field_660.method_1012()).length != 1 || !CharOperation.method_1364(var3[0], class_40.field_188.method_179()))) {
            if (this.field_1088.field_481 > 0 && var1.field_653 > this.field_1088.field_481) {
                return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1834(var1, var2));
            } else {
                if (!this.field_1070) {
                    this.field_1070 = true;
                    ++this.field_1069;
                }
                return this;
            }
        } else if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1834(var1, var2);
        }
    }

    public class_251 method_1836(class_124 var1, int var2) {
        this.method_1846();
        if (this.field_1088.field_481 != 0 && var1.field_653 > this.field_1088.field_481) {
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1836(var1, var2));
        } else if (this.field_1095 != null) {
            return this.field_1095.method_1886(var1, var2, true);
        } else {
            class_112 var10000 = new class_112(0);
            class_112 var3 = var10000;
            var3.field_444 = this.field_1088.field_490;
            class_251 var4 = this.method_1833(var3, 1);
            if (this.field_1069 > 0) {
                for (int var5 = 0; var5 < this.field_1069 - 1; ++var5) {
                    class_112 var10001 = new class_112(0);
                    var4 = var4.method_1833(var10001, 1);
                }
                this.field_1069 = 1;
            }
            return var4.method_1836(var1, var2);
        }
    }

    public class_251 method_1837(class_98 var1, int var2) {
        this.method_1846();
        if (this.field_1088.field_481 != 0 && var1.field_444 > this.field_1088.field_481) {
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1837(var1, var2));
        } else if (this.field_1095 != null) {
            return this.field_1095.method_1887(var1, var2, true);
        } else {
            class_112 var10000 = new class_112(0);
            class_112 var3 = var10000;
            var3.field_444 = this.field_1088.field_490;
            class_251 var4 = this.method_1833(var3, 1);
            if (this.field_1069 > 0) {
                for (int var5 = 0; var5 < this.field_1069 - 1; ++var5) {
                    class_112 var10001 = new class_112(0);
                    var4 = var4.method_1833(var10001, 1);
                }
                this.field_1069 = 1;
            }
            return var4.method_1837(var1, var2);
        }
    }

    public class_251 method_1838(class_114 var1, int var2) {
        if (this.field_1088.field_481 != 0 && var1.field_592 > this.field_1088.field_481) {
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1838(var1, var2));
        } else if ((var1.field_446 & 256) == 0 && !this.method_1844().field_1621 && !this.method_1844().field_1622) {
            switch (class_114.method_859(var1.field_577)) {
                case 2:
                case 4:
                    this.method_1846();
                    this.method_1857(this.method_1847(var1.field_592 - 1));
                    if (this.field_1068 == null) {
                        return this;
                    }
                    return this.field_1068.method_1838(var1, var2);
                default:
                    if (this.field_1093 == null) {
                        this.field_1093 = new class_260[5];
                        this.field_1094 = 0;
                    } else if (this.field_1094 == this.field_1093.length) {
                        System.arraycopy(this.field_1093, 0, this.field_1093 = new class_260[2 * this.field_1094], 0, this.field_1094);
                    }
                    class_260 var5 = new class_260(var1, this, var2);
                    class_260 var4 = var5;
                    this.field_1093[this.field_1094++] = var4;
                    if (this.field_1100 > 0) {
                        var4.method_1881(this.field_1099, this.field_1100, this.field_1097, this.field_1098);
                    }
                    this.method_1846();
                    if (!this.field_1070) {
                        this.field_1070 = true;
                        ++this.field_1069;
                    }
                    return var4;
            }
        } else {
            if (this.field_1095 == null) {
                class_112 var10000 = new class_112(0);
                class_112 var3 = var10000;
                var3.field_444 = this.field_1088.field_490;
                this.method_1833(var3, 1);
            }
            this.field_1095.method_1890(this.field_1099, this.field_1100, this.field_1097, this.field_1098);
            this.method_1846();
            return this.field_1095.method_1888(var1, var2, true);
        }
    }

    public boolean method_1865() {
        return this.field_1088.field_490 == this.field_1088.field_445 + 1;
    }

    public ASTNode method_1845() {
        return this.field_1088;
    }

    public void method_1846() {
        this.field_1099 = null;
        this.field_1100 = 0;
        this.field_1097 = 0;
        this.field_1098 = -1;
    }

    public String method_1850(int var1) {
        StringBuffer var2 = new StringBuffer(this.method_1848(var1));
        var2.append("Recovered method:\n");
        this.field_1088.method_757(var1 + 1, var2);
        int var3;
        if (this.field_1089 != null) {
            for (var3 = 0; var3 < this.field_1090; ++var3) {
                var2.append("\n");
                var2.append(this.field_1089[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1093 != null) {
            for (var3 = 0; var3 < this.field_1094; ++var3) {
                var2.append("\n");
                var2.append(this.field_1093[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1095 != null) {
            var2.append("\n");
            var2.append(this.field_1095.method_1850(var1 + 1));
        }
        return var2.toString();
    }

    public void method_1851(int var1) {
        this.field_1070 = true;
        this.field_1088.field_490 = var1;
    }

    public AbstractMethodDeclaration method_1866() {
        if (this.field_1091 != 0) {
            this.field_1088.field_482 |= this.field_1091;
            if (this.field_1092 < this.field_1088.field_480) {
                this.field_1088.field_480 = this.field_1092;
            }
        }
        int var3;
        if (this.field_1090 > 0) {
            int var1 = this.field_1088.field_483 == null ? 0 : this.field_1088.field_483.length;
            class_164[] var2 = new class_164[var1 + this.field_1090];
            if (var1 > 0) {
                System.arraycopy(this.field_1088.field_483, 0, var2, this.field_1090, var1);
            }
            for (var3 = 0; var3 < this.field_1090; ++var3) {
                var2[var3] = this.field_1089[var3].method_1874();
            }
            this.field_1088.field_483 = var2;
            var3 = this.field_1089[0].field_1116.field_444;
            if (var3 < this.field_1088.field_480) {
                this.field_1088.field_480 = var3;
            }
        }
        if (this.field_1095 != null) {
            class_112 var4 = this.field_1095.method_1891();
            if (var4 != null) {
                this.field_1088.field_486 = var4.field_572;
                if (this.field_1088.field_481 == 0) {
                    this.field_1088.field_481 = var4.field_445;
                    this.field_1088.field_491 = var4.field_445;
                }
                if (this.field_1088.method_795()) {
                    class_94 var5 = (class_94)this.field_1088;
                    if (this.field_1088.field_486 != null && this.field_1088.field_486[0] instanceof class_105) {
                        var5.field_493 = (class_105)this.field_1088.field_486[0];
                        var3 = this.field_1088.field_486.length;
                        System.arraycopy(this.field_1088.field_486, 1, this.field_1088.field_486 = new class_98[var3 - 1], 0, var3 - 1);
                    }
                    if (var5.field_493 == null) {
                        var5.field_493 = class_158.method_1047();
                    }
                }
            }
        } else if (this.field_1088.field_481 == 0) {
            if (this.field_1088.field_445 + 1 == this.field_1088.field_490) {
                this.field_1088.field_481 = this.field_1088.field_445;
                this.field_1088.field_490 = this.field_1088.field_445;
                this.field_1088.field_491 = this.field_1088.field_445;
            } else {
                this.field_1088.field_481 = this.field_1088.field_490;
                this.field_1088.field_491 = this.field_1088.field_490;
            }
        }
        if (this.field_1094 > 0) {
            this.field_1088.field_446 |= 2;
        }
        return this.field_1088;
    }

    public void method_1852() {
        if (this.method_1865() && this.field_1068 != null) {
            Parser var1 = this.method_1844();
            if (var1.field_1595 > 0 && var1.field_1557 > 0) {
                int var2;
                int var3;
                boolean var4;
                int var6;
                if (this.field_1088.field_445 == var1.field_1598) {
                    var2 = var1.field_1558[var1.field_1557];
                    var3 = var1.field_1559 - var2;
                    var4 = var3 >= 0;
                    if (var4) {
                        if (!(var1.field_1560[var3] instanceof AbstractMethodDeclaration)) {
                            var4 = false;
                        }
                        int var5 = 1;
                        for (var6 = var2 + 1; var5 < var6; ++var5) {
                            if (!(var1.field_1560[var3 + var5] instanceof class_146)) {
                                var4 = false;
                            }
                        }
                    }
                    if (var4) {
                        var1.method_2701();
                    } else {
                        var1.field_1595 = 0;
                    }
                } else {
                    if (var1.field_1563 == 28 || var1.field_1563 == 27) {
                        --var1.field_1558[var1.field_1557];
                        --var1.field_1559;
                        --var1.field_1595;
                        var1.field_1563 = 0;
                    }
                    var2 = var1.field_1558[var1.field_1557];
                    var3 = var1.field_1559 - var2 + 1;
                    var4 = var1.field_1598 < var1.field_1597;
                    class_92[] var12;
                    for (var12 = null; var2 > 0 && var1.field_1560[var1.field_1559] instanceof class_92; var4 = true) {
                        System.arraycopy(var1.field_1560, var3, var12 = new class_92[var2], 0, var2);
                        --var1.field_1557;
                        var1.field_1559 -= var2;
                        var2 = var1.field_1558[var1.field_1557];
                        var3 = var1.field_1559 - var2 + 1;
                    }
                    for (var6 = 0; var6 < var2; ++var6) {
                        ASTNode var7 = var1.field_1560[var3 + var6];
                        if (!(var7 instanceof class_125)) {
                            var1.field_1558[var1.field_1557] = var6;
                            var1.field_1559 = var3 + var6 - 1;
                            var1.field_1595 = var6;
                            var1.field_1563 = 0;
                            break;
                        }
                        class_125 var8 = (class_125)var7;
                        char[][] var9 = var8.field_660.method_1012();
                        if ((var8.field_656 & -17) != 0 || var9.length == 1 && CharOperation.method_1364(var9[0], class_40.field_188.method_179())) {
                            var1.field_1558[var1.field_1557] = var6;
                            var1.field_1559 = var3 + var6 - 1;
                            var1.field_1595 = var6;
                            var1.field_1563 = 0;
                            break;
                        }
                        if (var4) {
                            var1.field_1598 = var8.field_445 + 1;
                        }
                    }
                    if (var1.field_1595 > 0 && var1.field_1557 > 0) {
                        int var13 = var1.field_1558[var1.field_1557];
                        int var14 = var1.field_1559 - var13;
                        boolean var15 = var14 >= 0;
                        if (var15) {
                            if (!(var1.field_1560[var14] instanceof AbstractMethodDeclaration)) {
                                var15 = false;
                            }
                            int var10 = 1;
                            for (int var11 = var13 + 1; var10 < var11; ++var10) {
                                if (!(var1.field_1560[var14 + var10] instanceof class_125)) {
                                    var15 = false;
                                }
                            }
                        }
                        if (var15) {
                            var1.method_2700();
                            if (var1.field_1562 == this) {
                                this.field_1088.field_445 = this.field_1088.field_484[this.field_1088.field_484.length - 1].field_445;
                                this.field_1088.field_490 = this.field_1088.field_445 + 1;
                                var1.field_1590 = this.field_1088.field_490;
                            }
                        }
                    }
                    if (var12 != null) {
                        System.arraycopy(var12, 0, var1.field_1560, var1.field_1559 + 1, var12.length);
                        var1.field_1559 += var12.length;
                        var1.field_1558[++var1.field_1557] = var12.length;
                    }
                }
            }
        }
    }

    public class_251 method_1853(int var1, int var2) {
        if (this.field_1088.method_793()) {
            this.method_1856(var1, var2);
            return (class_251)(!this.field_1070 && this.field_1068 != null ? this.field_1068.method_1853(var1, var2) : this);
        } else {
            if (this.field_1068 != null && this.field_1068 instanceof class_260) {
                int var3 = ((class_260)this.field_1068).field_1124.field_577;
                if (class_114.method_859(var3) == 2 && !this.field_1070) {
                    this.method_1856(var1 - 1, var1 - 1);
                    return this.field_1068.method_1853(var1, var2);
                }
            }
            return super.method_1853(var1, var2);
        }
    }

    public class_251 method_1854(int var1, int var2) {
        if (this.field_1069 == 0) {
            switch (this.method_1844().field_1593) {
                case -1:
                case 105:
                    break;
                default:
                    this.field_1070 = true;
                    this.field_1069 = 1;
            }
        }
        return super.method_1854(var1, var2);
    }

    public void method_1855() {
        this.method_1866();
    }

    public void method_1856(int var1, int var2) {
        if (this.field_1088.field_481 == 0) {
            if (this.method_1844().field_1611 >= var2) {
                this.field_1088.field_481 = this.method_1844().field_1610;
                this.field_1088.field_491 = this.method_1844().field_1609;
            } else {
                this.field_1088.field_481 = var2;
                this.field_1088.field_491 = var1 - 1;
            }
        }
    }

    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        if (this.field_1099 == null) {
            this.field_1099 = new class_257[5];
            this.field_1100 = 0;
        } else if (this.field_1100 == this.field_1099.length) {
            System.arraycopy(this.field_1099, 0, this.field_1099 = new class_257[2 * this.field_1100], 0, this.field_1100);
        }
        class_257 var10000 = new class_257(var1, var2, var3, this, var4);
        class_257 var5 = var10000;
        this.field_1099[this.field_1100++] = var5;
        return var5;
    }

    public void method_1840(int var1, int var2) {
        this.field_1097 |= var1;
        if (this.field_1098 < 0) {
            this.field_1098 = var2;
        }
    }

    void method_1867(class_123[] var1, int var2) {
        if (this.field_1088.field_482 == 0) {
            int var3 = var1[var1.length - 1].field_445;
            Parser var4 = this.method_1844();
            Scanner var5 = var4.field_1628;
            if (Util.method_1324(this.field_1088.field_480, var5.field_1256, 0, var5.field_1257) == Util.method_1324(var3, var5.field_1256, 0, var5.field_1257)) {
                if (var4.field_1600 <= var3 || var4.field_1600 >= this.field_1088.field_480) {
                    if (this.field_1088 instanceof class_96) {
                        ((class_96)this.field_1088).field_498 = var1;
                        this.field_1088.field_480 = var2;
                    } else if (this.field_1088 instanceof class_94) {
                        ((class_94)this.field_1088).field_494 = var1;
                        this.field_1088.field_480 = var2;
                    }
                }
            }
        }
    }

    public void method_1868(class_257[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            class_164[] var5 = this.field_1088.field_483;
            if (var5 != null) {
                this.field_1089 = new class_257[var2];
                this.field_1090 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].field_1116 == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.field_1089[this.field_1090++] = var1[var6];
                }
            } else {
                this.field_1089 = var1;
                this.field_1090 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1091 = var3;
            this.field_1092 = var4;
        }
    }
}
