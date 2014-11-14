package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_122;
import org.eclipse.jdt.internal.compiler.ast.class_124;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.parser.class_251;
import org.eclipse.jdt.internal.compiler.parser.class_253;
import org.eclipse.jdt.internal.compiler.parser.class_257;
import org.eclipse.jdt.internal.compiler.parser.class_260;
import org.eclipse.jdt.internal.compiler.parser.class_261;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class class_254 extends class_253 {

    public class_260[] field_1081;

    public int field_1082;

    public class_261 field_1083;

    int field_1084;

    int field_1085;

    class_257[] field_1086;

    int field_1087;

    public class_254(class_121 var1, class_251 var2, int var3) {
        this(var1, var2, var3, (Parser)null);
    }

    public class_254(class_121 var1, class_251 var2, int var3, Parser var4) {
        super(var1, var2, var3, var4);
        this.field_1085 = -1;
        this.field_1070 = true;
    }

    public class_251 method_1833(class_112 var1, int var2) {
        if (this.field_1073.field_652 > 0 && var1.field_444 > this.field_1073.field_652) {
            this.method_1846();
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1833(var1, var2));
        } else {
            if (!this.field_1070) {
                this.field_1070 = true;
                ++this.field_1069;
            }
            class_261 var10001 = new class_261(var1, this, var2);
            this.field_1083 = var10001;
            if (var1.field_445 == 0) {
                return this.field_1083;
            }
            return this;
        }
    }

    public class_251 method_1834(class_121 var1, int var2) {
        this.method_1846();
        char[][] var3;
        if ((var1.field_656 & -17) == 0 && var1.field_660 != null && ((var3 = var1.field_660.method_1012()).length != 1 || !CharOperation.method_1364(var3[0], class_40.field_188.method_179()))) {
            return (class_251)(this.field_1073.field_652 > 0 && var1.field_653 > this.field_1073.field_652 ? (this.field_1068 == null ? this : this.field_1068.method_1834(var1, var2)) : this);
        } else if (this.field_1068 == null) {
            return this;
        } else {
            this.method_1857(this.method_1847(var1.field_653 - 1));
            return this.field_1068.method_1834(var1, var2);
        }
    }

    public class_251 method_1836(class_124 var1, int var2) {
        if (this.field_1073.field_652 != 0 && var1.field_653 > this.field_1073.field_652) {
            this.method_1846();
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1836(var1, var2));
        } else {
            class_112 var10000 = new class_112(0);
            class_112 var3 = var10000;
            var3.field_444 = ((class_122)this.field_1073).field_444;
            class_251 var4 = this.method_1833(var3, 1);
            if (this.field_1083 != null) {
                this.field_1083.method_1890(this.field_1086, this.field_1087, this.field_1084, this.field_1085);
            }
            this.method_1846();
            return var4.method_1836(var1, var2);
        }
    }

    public class_251 method_1837(class_98 var1, int var2) {
        if (this.field_1073.field_652 != 0 && var1.field_444 > this.field_1073.field_652) {
            this.method_1846();
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1837(var1, var2));
        } else {
            class_112 var10000 = new class_112(0);
            class_112 var3 = var10000;
            var3.field_444 = ((class_122)this.field_1073).field_444;
            class_251 var4 = this.method_1833(var3, 1);
            if (this.field_1083 != null) {
                this.field_1083.method_1890(this.field_1086, this.field_1087, this.field_1084, this.field_1085);
            }
            this.method_1846();
            return var4.method_1837(var1, var2);
        }
    }

    public class_251 method_1838(class_114 var1, int var2) {
        if (this.field_1073.field_652 != 0 && var1.field_592 > this.field_1073.field_652) {
            this.method_1846();
            return (class_251)(this.field_1068 == null ? this : this.field_1068.method_1838(var1, var2));
        } else if ((var1.field_446 & 256) == 0 && !this.method_1844().field_1621 && !this.method_1844().field_1622) {
            if (this.field_1081 == null) {
                this.field_1081 = new class_260[5];
                this.field_1082 = 0;
            } else if (this.field_1082 == this.field_1081.length) {
                System.arraycopy(this.field_1081, 0, this.field_1081 = new class_260[2 * this.field_1082], 0, this.field_1082);
            }
            class_260 var6 = new class_260(var1, this, var2);
            class_260 var5 = var6;
            this.field_1081[this.field_1082++] = var5;
            if (this.field_1087 > 0) {
                var5.method_1881(this.field_1086, this.field_1087, this.field_1084, this.field_1085);
            }
            this.method_1846();
            if (!this.field_1070) {
                this.field_1070 = true;
                ++this.field_1069;
            }
            return var5;
        } else {
            class_112 var10000 = new class_112(0);
            class_112 var3 = var10000;
            var3.field_444 = ((class_122)this.field_1073).field_444;
            class_251 var4 = this.method_1833(var3, 1);
            if (this.field_1083 != null) {
                this.field_1083.method_1890(this.field_1086, this.field_1087, this.field_1084, this.field_1085);
            }
            this.method_1846();
            return var4.method_1838(var1, var2);
        }
    }

    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        if (this.field_1086 == null) {
            this.field_1086 = new class_257[5];
            this.field_1087 = 0;
        } else if (this.field_1087 == this.field_1086.length) {
            System.arraycopy(this.field_1086, 0, this.field_1086 = new class_257[2 * this.field_1087], 0, this.field_1087);
        }
        class_257 var10000 = new class_257(var1, var2, var3, this, var4);
        class_257 var5 = var10000;
        this.field_1086[this.field_1087++] = var5;
        return var5;
    }

    public void method_1840(int var1, int var2) {
        this.field_1084 |= var1;
        if (this.field_1085 < 0) {
            this.field_1085 = var2;
        }
    }

    public void method_1846() {
        this.field_1086 = null;
        this.field_1087 = 0;
        this.field_1084 = 0;
        this.field_1085 = -1;
    }

    public String method_1850(int var1) {
        StringBuffer var2 = new StringBuffer(this.method_1848(var1));
        var2.append("Recovered initializer:\n");
        this.field_1073.method_757(var1 + 1, var2);
        if (this.field_1075 != null) {
            for (int var3 = 0; var3 < this.field_1076; ++var3) {
                var2.append("\n");
                var2.append(this.field_1075[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1083 != null) {
            var2.append("\n");
            var2.append(this.field_1083.method_1850(var1 + 1));
        }
        return var2.toString();
    }

    public class_121 method_1863() {
        if (this.field_1083 != null) {
            class_112 var1 = this.field_1083.method_1891();
            if (var1 != null) {
                class_122 var2 = (class_122)this.field_1073;
                var2.field_664 = var1;
                if (var2.field_652 == 0) {
                    var2.field_652 = var1.field_445;
                    var2.field_667 = var1.field_445;
                }
            }
            if (this.field_1082 > 0) {
                this.field_1073.field_446 |= 2;
            }
        }
        if (this.field_1073.field_445 == 0) {
            this.field_1073.field_445 = this.field_1073.field_652;
        }
        return this.field_1073;
    }

    public class_251 method_1853(int var1, int var2) {
        if (--this.field_1069 <= 0 && this.field_1068 != null) {
            this.method_1856(var1, var2);
            return this.field_1068;
        } else {
            return this;
        }
    }

    public class_251 method_1854(int var1, int var2) {
        ++this.field_1069;
        return this;
    }

    public void method_1856(int var1, int var2) {
        if (this.field_1073.field_652 == 0) {
            class_122 var3 = (class_122)this.field_1073;
            if (this.method_1844().field_1611 >= var2) {
                if (var3.field_666 < this.method_1844().field_1610) {
                    var3.field_652 = this.method_1844().field_1610;
                } else {
                    var3.field_652 = var3.field_666;
                }
                if (var3.field_666 < this.method_1844().field_1609) {
                    var3.field_667 = this.method_1844().field_1609;
                } else {
                    var3.field_667 = var3.field_666;
                }
            } else {
                var3.field_652 = var2;
                var3.field_667 = var1 - 1;
            }
            if (var3.field_664 != null) {
                var3.field_664.field_445 = var3.field_652;
            }
        }
    }
}
