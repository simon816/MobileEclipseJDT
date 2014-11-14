package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_130;
import org.eclipse.jdt.internal.compiler.ast.class_134;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.ast.class_155;
import org.eclipse.jdt.internal.compiler.ast.class_159;
import org.eclipse.jdt.internal.compiler.ast.class_162;
import org.eclipse.jdt.internal.compiler.ast.class_163;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_41;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_131 extends class_126 {

    public class_126 field_687;

    public class_126 field_688;

    public class_131(class_126 var1, class_126 var2, int var3) {
        this.field_687 = var1;
        var1.field_446 |= 8192;
        this.field_688 = var2;
        this.field_444 = var1.field_444;
        this.field_445 = var3;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_65 var4 = this.field_687.method_920();
        int var5 = this.field_688.method_921(var3);
        if (var4 != null && (var4.field_301.field_178 & 2L) == 0L && var5 == 1) {
            var2.method_3050(var1, var4, this.field_687, 769, var3);
        }
        class_303 var6 = ((class_154)this.field_687).method_1035(var1, var2, var3, this, false).method_3109();
        if (var4 != null && (var4.field_301.field_178 & 2L) == 0L) {
            switch (var5) {
                case -1:
                    var6.method_3097(var4);
                    break;
                case 1:
                    var6.method_3098(var4);
                    break;
                default:
                    var6.method_3100(var4);
            }
            if (var2.field_1741 != null) {
                switch (var5) {
                    case -1:
                        var2.field_1741.method_3097(var4);
                        break;
                    case 1:
                        var2.field_1741.method_3098(var4);
                        break;
                    default:
                        var2.field_1741.method_3100(var4);
                }
            }
        }
        return var6;
    }

    void method_943(class_86 var1, class_40 var2, class_40 var3) {
        class_67 var4 = this.method_945(this.field_687);
        if (var4 != null && var3 != class_40.field_187 && var2.method_98() == 516 && ((class_45)var2).field_215 != 2) {
            var1.method_644().method_1824(var2, var3, this.field_688);
        } else if (var4 != null && !var4.method_431() && var4.field_314 != null && var4.field_314.method_166()) {
            var1.method_644().method_1802(var4, var3, this.field_687);
        } else if (var3.method_174(var2)) {
            var1.method_644().method_1806(this.field_688, var3, var2);
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        ((class_154)this.field_687).method_1038(var1, var2, this, var3);
        var2.method_2360(var4, this.field_444);
    }

    public static class_34 method_944(class_126 var0) {
        if ((var0.field_446 & 536870912) != 0) {
            return null;
        } else if (var0 instanceof class_162) {
            return ((class_162)var0).field_748;
        } else {
            if (var0 instanceof class_155) {
                class_155 var1 = (class_155)var0;
                if (var1.field_736.method_755() && !(var1.field_736 instanceof class_159)) {
                    return var1.field_738;
                }
            } else if (var0 instanceof class_131) {
                class_126 var2 = ((class_131)var0).field_687;
                if ((var2.field_446 & 8192) != 0) {
                    return method_944(((class_131)var0).field_687);
                }
                if (var0 instanceof class_134) {
                    return method_944(((class_131)var0).field_687);
                }
            } else if (var0 instanceof class_163) {
                class_163 var3 = (class_163)var0;
                if (var3.field_759 != 1 && var3.field_756 == null) {
                    return var3.field_748;
                }
            }
            return null;
        }
    }

    class_67 method_945(class_126 var1) {
        if (var1 instanceof class_162) {
            if ((var1.field_446 & 7) == 1) {
                return (class_67)((class_162)var1).field_748;
            }
        } else {
            if (var1 instanceof class_155) {
                return ((class_155)var1).field_738;
            }
            if (var1 instanceof class_163) {
                class_163 var2 = (class_163)var1;
                if (var2.field_756 != null) {
                    return var2.field_756[var2.field_756.length - 1];
                }
                if ((var1.field_446 & 7) == 1) {
                    return (class_67)var2.field_748;
                }
            }
        }
        return null;
    }

    public int method_921(class_301 var1) {
        return this.field_688.method_921(var1);
    }

    public StringBuffer method_757(int var1, StringBuffer var2) {
        method_759(var1, var2);
        return this.method_946(var1, var2);
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append('(');
        return this.method_946(0, var2).append(')');
    }

    public StringBuffer method_946(int var1, StringBuffer var2) {
        this.field_687.method_924(var1, var2).append(" = ");
        return this.field_688.method_924(0, var2);
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        return this.method_757(var1, var2).append(';');
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if (this.field_687 instanceof class_154 && !this.field_687.method_755()) {
            class_40 var2 = this.field_687.method_925(var1);
            this.field_688.method_928(var2);
            if (var2 != null) {
                this.field_675 = var2.method_130(var1, this.field_445);
            }
            class_40 var3 = this.field_688.method_925(var1);
            if (var2 != null && var3 != null) {
                class_34 var4 = method_944(this.field_687);
                if (var4 != null && var4 == method_944(this.field_688)) {
                    var1.method_644().method_1482(this, var4.method_104());
                }
                if (var2 != var3) {
                    var1.method_576().method_692(var2, var3);
                }
                if (!this.field_688.method_919(var3, var2) && (!var2.method_148() || !class_41.method_185(var2.field_177, var3.field_177)) && !var3.method_152(var2)) {
                    if (!var1.method_624(var3, var2) && (!var3.method_148() || var1.method_577().field_1928 < 3211264L || var2.method_148() || !this.field_688.method_919(var3, var1.method_586().method_486(var2)))) {
                        var1.method_644().method_1777(var3, var2, this.field_688, this.field_687);
                        return var2;
                    } else {
                        this.field_688.method_911(var1, var2, var3);
                        if (this.field_688 instanceof class_130 && (this.field_688.field_446 & 16384) == 0) {
                            class_130.method_933(var1, var2, (class_130)this.field_688);
                        }
                        return this.field_675;
                    }
                } else {
                    this.field_688.method_911(var1, var2, var3);
                    this.method_943(var1, var2, var3);
                    if (this.field_688 instanceof class_130 && (this.field_688.field_446 & 16384) == 0) {
                        class_130.method_933(var1, var2, (class_130)this.field_688);
                    }
                    return this.field_675;
                }
            } else {
                return null;
            }
        } else {
            var1.method_644().method_1547(this.field_687);
            return null;
        }
    }

    public class_40 method_926(class_86 var1, class_40 var2) {
        class_40 var3 = super.method_926(var1, var2);
        if (var3 == null) {
            return null;
        } else {
            class_40 var4 = this.field_675;
            class_40 var5 = this.field_688.field_675;
            if (var2 == class_40.field_186 && var4 == class_40.field_186 && (this.field_687.field_446 & 8192) != 0) {
                var1.method_644().method_1738(this);
            }
            this.method_943(var1, var4, var5);
            return var3;
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2001(this, var2)) {
            this.field_687.method_763(var1, var2);
            this.field_688.method_763(var1, var2);
        }
        var1.method_1916(this, var2);
    }

    public class_65 method_920() {
        return this.field_687.method_920();
    }
}
