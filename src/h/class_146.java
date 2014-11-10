package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_147;
import h.class_149;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_51;
import m.class_83;
import m.class_84;
import m.class_86;

public abstract class class_146 extends class_126 {

    public class_146() {
    }

    public static final class_146 method_1005(int var0, int var1) {
        if (var1 == 0) {
            class_147 var2;
            switch (var0) {
                case 2:
                    var2 = new class_147(class_40.field_182.field_189, 0L);
                    return var2;
                case 3:
                    var2 = new class_147(class_40.field_180.field_189, 0L);
                    return var2;
                case 4:
                    var2 = new class_147(class_40.field_181.field_189, 0L);
                    return var2;
                case 5:
                    var2 = new class_147(class_40.field_186.field_189, 0L);
                    return var2;
                case 6:
                    var2 = new class_147(class_40.field_188.field_189, 0L);
                    return var2;
                case 7:
                default:
                    var2 = new class_147(class_40.field_183.field_189, 0L);
                    return var2;
                case 8:
                    var2 = new class_147(class_40.field_185.field_189, 0L);
                    return var2;
                case 9:
                    var2 = new class_147(class_40.field_184.field_189, 0L);
                    return var2;
                case 10:
                    var2 = new class_147(class_40.field_179.field_189, 0L);
                    return var2;
            }
        } else {
            class_149 var10000;
            switch (var0) {
                case 2:
                    var10000 = new class_149(class_40.field_182.field_189, var1, 0L);
                    return var10000;
                case 3:
                    var10000 = new class_149(class_40.field_180.field_189, var1, 0L);
                    return var10000;
                case 4:
                    var10000 = new class_149(class_40.field_181.field_189, var1, 0L);
                    return var10000;
                case 5:
                    var10000 = new class_149(class_40.field_186.field_189, var1, 0L);
                    return var10000;
                case 6:
                    var10000 = new class_149(class_40.field_188.field_189, var1, 0L);
                    return var10000;
                case 7:
                default:
                    var10000 = new class_149(class_40.field_183.field_189, var1, 0L);
                    return var10000;
                case 8:
                    var10000 = new class_149(class_40.field_185.field_189, var1, 0L);
                    return var10000;
                case 9:
                    var10000 = new class_149(class_40.field_184.field_189, var1, 0L);
                    return var10000;
                case 10:
                    var10000 = new class_149(class_40.field_179.field_189, var1, 0L);
                    return var10000;
            }
        }
    }

    public void method_1006(class_83 var1) {}

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public void method_1007(class_83 var1) {}

    public abstract class_146 method_1008(int var1);

    public int method_1009() {
        return 0;
    }

    public abstract char[] method_1010();

    protected abstract class_40 method_1011(class_83 var1);

    public abstract char[][] method_1012();

    protected class_40 method_1013(class_83 var1) {
        this.field_672 = class_331.field_1896;
        if (this.field_675 != null) {
            if (this.field_675.method_101()) {
                return this.field_675;
            } else {
                switch (this.field_675.method_102()) {
                    case 1:
                    case 2:
                    case 5:
                        class_40 var4 = this.field_675.method_131();
                        if (var4 == null) {
                            return null;
                        }
                        return var1.method_586().method_490(var4, false);
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            }
        } else {
            class_40 var3 = this.field_675 = this.method_1011(var1);
            if (var3 == null) {
                return null;
            } else {
                boolean var2;
                if (var2 = !var3.method_101()) {
                    this.method_1015(var1);
                    switch (var3.method_102()) {
                        case 1:
                        case 2:
                        case 5:
                            var3 = var3.method_131();
                            if (var3 == null) {
                                return null;
                            }
                            break;
                        case 3:
                        case 4:
                        default:
                            return null;
                    }
                }
                if (var3.method_147() && ((class_42)var3).field_192 == class_40.field_188) {
                    var1.method_644().method_1490(this);
                    return null;
                } else {
                    if (this.method_756(var3, var1)) {
                        this.method_1014(var3, var1);
                    }
                    var3 = var1.method_586().method_490(var3, false);
                    if (var3.method_173().method_166() && (this.field_446 & 1073741824) == 0 && var1.method_577().method_3313(35184372088832L) != -1) {
                        var1.method_644().method_1742(this, var3);
                    }
                    return var2 ? var3 : (this.field_675 = var3);
                }
            }
        }
    }

    protected void method_1014(class_40 var1, class_83 var2) {
        var2.method_644().method_1516(var1, this);
    }

    protected void method_1015(class_83 var1) {
        var1.method_644().method_1639(this, this.field_675);
    }

    public class_40 method_1016(class_84 var1) {
        class_40 var2 = this.method_1018(var1);
        if (var2 == null) {
            return null;
        } else if (var2.method_169()) {
            if (this.field_675.method_101()) {
                class_51 var10001 = new class_51(this.method_1012(), (class_43)this.field_675, 9);
                this.field_675 = var10001;
                this.method_1015(var1);
            }
            return null;
        } else {
            return var2;
        }
    }

    public final class_40 method_925(class_86 var1) {
        return this.method_1017(var1, true);
    }

    public class_40 method_1017(class_86 var1, boolean var2) {
        return this.method_1013(var1);
    }

    public class_40 method_1018(class_84 var1) {
        return this.method_1013(var1);
    }

    public class_40 method_1019(class_86 var1, class_43 var2, int var3) {
        return this.method_1017(var1, true);
    }

    public class_40 method_1020(class_84 var1, class_43 var2, int var3) {
        return this.method_1018(var1);
    }

    public abstract void method_763(class_264 var1, class_86 var2);

    public abstract void method_1021(class_264 var1, class_84 var2);
}
