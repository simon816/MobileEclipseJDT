package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_124;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.parser.class_254;
import org.eclipse.jdt.internal.compiler.parser.class_255;
import org.eclipse.jdt.internal.compiler.parser.class_260;
import org.eclipse.jdt.internal.compiler.parser.class_261;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.util.Util;

public class class_251 {

    public class_251 field_1068;

    public int field_1069;

    public boolean field_1070;

    protected Parser field_1071;

    public class_251(class_251 var1, int var2) {
        this(var1, var2, (Parser)null);
    }

    public class_251(class_251 var1, int var2, Parser var3) {
        this.field_1068 = var1;
        this.field_1069 = var2;
        this.field_1071 = var3;
    }

    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var3 - 1));
            return this.field_1068.method_1831(var1, var2, var3, var4);
        }
    }

    public class_251 method_1832(AbstractMethodDeclaration var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_480 - 1));
            return this.field_1068.method_1832(var1, var2);
        }
    }

    public class_251 method_1833(class_112 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_444 - 1));
            return this.field_1068.method_1833(var1, var2);
        }
    }

    public class_251 method_1834(class_121 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1834(var1, var2);
        }
    }

    public class_251 method_1835(ImportReference var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_470 - 1));
            return this.field_1068.method_1835(var1, var2);
        }
    }

    public class_251 method_1836(class_124 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1836(var1, var2);
        }
    }

    public class_251 method_1837(class_98 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_444 - 1));
            return this.field_1068.method_1837(var1, var2);
        }
    }

    public class_251 method_1838(class_114 var1, int var2) {
        this.method_1846();
        if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_592 - 1));
            return this.field_1068.method_1838(var1, var2);
        }
    }

    protected void method_1839(class_261 var1) {
        class_112 var2 = var1.field_1144;
        if (var2.field_572 != null) {
            class_98[] var3 = var2.field_572;
            for (int var4 = 0; var4 < var3.length; ++var4) {
                var1.method_1837(var3[var4], 0);
            }
        }
    }

    public void method_1840(int var1, int var2) {}

    public class_254 method_1841() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_254) {
                return (class_254)var1;
            }
        }
        return null;
    }

    public class_255 method_1842() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_255) {
                return (class_255)var1;
            }
        }
        return null;
    }

    public class_260 method_1843() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1 instanceof class_260) {
                return (class_260)var1;
            }
        }
        return null;
    }

    public Parser method_1844() {
        for (class_251 var1 = this; var1 != null; var1 = var1.field_1068) {
            if (var1.field_1071 != null) {
                return var1.field_1071;
            }
        }
        return null;
    }

    public ASTNode method_1845() {
        return null;
    }

    public void method_1846() {}

    public int method_1847(int var1) {
        Parser var2 = this.method_1844();
        if (var2 == null) {
            return var1;
        } else {
            Scanner var3 = var2.field_1628;
            if (var3.field_1256 == null) {
                return var1;
            } else {
                int var4 = Util.method_1324(var1, var3.field_1256, 0, var3.field_1257);
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

    protected String method_1848(int var1) {
        StringBuffer var2 = new StringBuffer();
        for (int var3 = var1; var3 > 0; --var3) {
            var2.append("  ");
        }
        return var2.toString();
    }

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

    public String method_1850(int var1) {
        return super.toString();
    }

    public void method_1851(int var1) {
        this.field_1070 = true;
    }

    public void method_1852() {}

    public class_251 method_1853(int var1, int var2) {
        if (--this.field_1069 <= 0 && this.field_1068 != null) {
            this.method_1856(var1, var2);
            return this.field_1068;
        } else {
            return this;
        }
    }

    public class_251 method_1854(int var1, int var2) {
        if (this.field_1069++ == 0) {
            this.method_1851(var2 + 1);
            return this;
        } else {
            return null;
        }
    }

    public void method_1855() {}

    public void method_1856(int var1, int var2) {}

    public void method_1857(int var1) {
        this.method_1856(var1 + 1, var1);
    }
}
