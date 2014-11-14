package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_120;
import org.eclipse.jdt.internal.compiler.ast.class_128;
import org.eclipse.jdt.internal.compiler.ast.class_130;
import org.eclipse.jdt.internal.compiler.ast.class_131;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_41;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_124 extends class_120 {

    public class_65 field_670;

    public class_124(char[] var1, int var2, int var3) {
        this.field_659 = var1;
        this.field_444 = var2;
        this.field_445 = var3;
        this.field_651 = var3;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if ((var3.field_1783 & 1) == 0) {
            this.field_446 |= 1073741824;
        }
        if (this.field_655 == null) {
            return var3;
        } else {
            int var4 = this.field_655.method_921(var3);
            class_303 var5 = this.field_655.method_814(var1, var2, var3).method_3109();
            if (!var5.method_3083(this.field_670)) {
                this.field_446 |= 8;
            } else {
                this.field_446 &= -9;
            }
            var5.method_3099(this.field_670);
            if ((this.field_670.field_301.field_178 & 2L) == 0L) {
                switch (var4) {
                    case -1:
                        var5.method_3097(this.field_670);
                        break;
                    case 1:
                        var5.method_3098(this.field_670);
                        break;
                    default:
                        var5.method_3100(this.field_670);
                }
            }
            return var5;
        }
    }

    public void method_901() {
        if ((this.field_656 & '\uffff' & -17) != 0) {
            this.field_656 = this.field_656 & -4194305 | 8388608;
        }
    }

    public void method_818(class_86 var1, class_268 var2) {
        if (this.field_670.field_306 != -1) {
            var2.method_2090(this.field_670);
        }
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_655 != null) {
                if (this.field_670.field_306 < 0) {
                    if (this.field_655.field_672 == class_331.field_1896) {
                        this.field_655.method_912(var1, var2, false);
                    }
                } else {
                    this.field_655.method_912(var1, var2, true);
                    if (this.field_670.field_301.method_147() && (this.field_655.field_675 == class_40.field_187 || this.field_655 instanceof class_130 && ((class_130)this.field_655).method_940().field_675 == class_40.field_187)) {
                        var2.method_2113(this.field_670.field_301);
                    }
                    var2.method_2376(this.field_670, false);
                    if ((this.field_446 & 8) != 0) {
                        this.field_670.method_415(var2.field_1208);
                    }
                }
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public int method_887() {
        return 4;
    }

    public void method_821(class_86 var1) {
        class_40 var2 = this.field_660.method_1017(var1, true);
        this.method_901();
        if (var2 != null) {
            if (var2 == class_40.field_188) {
                var1.method_644().method_1821(this);
                return;
            }
            if (var2.method_147() && ((class_42)var2).field_192 == class_40.field_188) {
                var1.method_644().method_1822(this);
                return;
            }
        }
        class_34 var3 = var1.method_598(this.field_659, 3, this, false);
        if (var3 != null && var3.method_101()) {
            if (var3 instanceof class_65 && this.field_654 == 0) {
                var1.method_644().method_1745(this);
            } else {
                var1.method_644().method_1661(this, var3, false);
            }
        }
        if ((this.field_656 & 16) != 0 && this.field_655 == null) {
            this.field_656 |= 67108864;
        }
        class_65 var10001 = new class_65(this, var2, this.field_656, false);
        this.field_670 = var10001;
        var1.method_704(this.field_670);
        this.field_670.method_410(class_331.field_1896);
        if (var2 == null) {
            if (this.field_655 != null) {
                this.field_655.method_925(var1);
            }
        } else {
            if (this.field_655 != null) {
                class_40 var4;
                if (this.field_655 instanceof class_128) {
                    var4 = this.field_655.method_926(var1, var2);
                    if (var4 != null) {
                        ((class_128)this.field_655).field_680 = (class_42)var4;
                        this.field_655.method_911(var1, var2, var4);
                    }
                } else {
                    this.field_655.method_928(var2);
                    var4 = this.field_655.method_925(var1);
                    if (var4 != null) {
                        if (var2 != var4) {
                            var1.method_576().method_692(var2, var4);
                        }
                        if (!this.field_655.method_919(var4, var2) && (!var2.method_148() || !class_41.method_185(var2.field_177, var4.field_177)) && !var4.method_152(var2)) {
                            if (!var1.method_624(var4, var2) && (!var4.method_148() || var1.method_577().field_1928 < 3211264L || var2.method_148() || !this.field_655.method_919(var4, var1.method_586().method_486(var2)))) {
                                if ((var2.field_178 & 128L) == 0L) {
                                    var1.method_644().method_1777(var4, var2, this.field_655, (class_89)null);
                                }
                            } else {
                                this.field_655.method_911(var1, var2, var4);
                                if (this.field_655 instanceof class_130 && (this.field_655.field_446 & 16384) == 0) {
                                    class_130.method_933(var1, var2, (class_130)this.field_655);
                                }
                            }
                        } else {
                            this.field_655.method_911(var1, var2, var4);
                            if (var4.method_174(var2)) {
                                var1.method_644().method_1806(this.field_655, var4, var2);
                            }
                            if (this.field_655 instanceof class_130 && (this.field_655.field_446 & 16384) == 0) {
                                class_130.method_933(var1, var2, (class_130)this.field_655);
                            }
                        }
                    }
                }
                if (this.field_670 == class_131.method_944(this.field_655)) {
                    var1.method_644().method_1481(this, this.field_659);
                }
                this.field_670.method_410(this.field_670.method_409() ? this.field_655.field_672.method_3259((var2.field_177 << 4) + this.field_655.field_672.method_3288()) : class_331.field_1896);
            }
            method_761(var1, this.field_658, this.field_670);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2031(this, var2)) {
            if (this.field_658 != null) {
                int var3 = this.field_658.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_658[var4].method_763(var1, var2);
                }
            }
            this.field_660.method_763(var1, var2);
            if (this.field_655 != null) {
                this.field_655.method_763(var1, var2);
            }
        }
        var1.method_1946(this, var2);
    }
}
