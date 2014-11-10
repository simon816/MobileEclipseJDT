package m;

import b.class_233;
import f.class_324;
import f.class_328;
import m.class_17;
import m.class_34;
import m.class_43;
import m.class_49;
import m.class_51;
import m.class_80;

public class class_38 extends class_34 implements class_17 {

    public long field_170;

    public char[][] field_171;

    class_38 field_172;

    public class_80 field_173;

    class_328 field_174;

    class_324 field_175;

    protected class_38() {
        this.field_170 = 0L;
    }

    public class_38(char[] var1, class_80 var2) {
        this(new char[][] {var1}, (class_38)null, var2);
    }

    public class_38(char[][] var1, class_38 var2, class_80 var3) {
        this.field_170 = 0L;
        this.field_171 = var1;
        this.field_172 = var2;
        this.field_173 = var3;
        this.field_174 = null;
        class_324 var10001 = new class_324(3);
        this.field_175 = var10001;
    }

    public class_38(class_80 var1) {
        this(class_233.field_995, (class_38)null, var1);
    }

    private void method_115(char[] var1) {
        this.field_175.method_3220(var1, class_80.field_366);
    }

    private void method_116(char[] var1) {
        if (this.field_174 == null) {
            class_328 var10001 = new class_328(25);
            this.field_174 = var10001;
        }
        this.field_174.method_3248(var1, class_80.field_367);
    }

    void method_117(class_38 var1) {
        if ((var1.field_170 & 128L) == 0L) {
            this.method_119();
        }
        this.field_175.method_3220(var1.field_171[var1.field_171.length - 1], var1);
    }

    void method_118(class_43 var1) {
        if ((var1.field_178 & 128L) == 0L) {
            this.method_119();
        }
        if (this.field_174 == null) {
            class_328 var10001 = new class_328(25);
            this.field_174 = var10001;
        }
        this.field_174.method_3248(var1.field_197[var1.field_197.length - 1], var1);
    }

    void method_119() {
        class_38 var1 = this;
        do {
            var1.field_170 &= -129L;
        } while ((var1 = var1.field_172) != null);
    }

    private class_38 method_120(char[] var1) {
        if (!this.field_173.method_515(this.field_171, var1)) {
            return null;
        } else {
            char[][] var2 = class_233.method_1353(this.field_171, var1);
            class_38 var10000 = new class_38(var2, this, this.field_173);
            class_38 var3 = var10000;
            this.method_117(var3);
            return var3;
        }
    }

    class_38 method_121(char[] var1) {
        class_38 var2 = this.method_122(var1);
        if (var2 != null) {
            return var2 == class_80.field_366 ? null : var2;
        } else if ((var2 = this.method_120(var1)) != null) {
            return var2;
        } else {
            this.method_115(var1);
            return null;
        }
    }

    class_38 method_122(char[] var1) {
        return this.field_175.method_3219(var1);
    }

    class_43 method_123(char[] var1) {
        class_43 var2 = this.method_124(var1);
        if (var2 == null && (var2 = this.field_173.method_482(this, var1)) == null) {
            this.method_116(var1);
            return null;
        } else if (var2 == class_80.field_367) {
            return null;
        } else {
            var2 = class_49.method_267(var2, this.field_173, false);
            if (var2.method_160()) {
                class_51 var10000 = new class_51(new char[][] {var1}, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        }
    }

    class_43 method_124(char[] var1) {
        return this.field_174 == null ? null : this.field_174.method_3247(var1);
    }

    public class_34 method_125(char[] var1) {
        class_43 var2 = this.method_124(var1);
        class_51 var10000;
        if (var2 != null && var2 != class_80.field_367) {
            var2 = class_49.method_267(var2, this.field_173, false);
            if (var2.method_160()) {
                var10000 = new class_51(new char[][] {var1}, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        } else {
            class_38 var3 = this.method_122(var1);
            if (var3 != null && var3 != class_80.field_366) {
                return var3;
            } else {
                if (var2 == null) {
                    if ((var2 = this.field_173.method_482(this, var1)) != null) {
                        if (var2.method_160()) {
                            var10000 = new class_51(new char[][] {var1}, var2, 4);
                            return var10000;
                        }
                        return var2;
                    }
                    this.method_116(var1);
                }
                if (var3 == null) {
                    if ((var3 = this.method_120(var1)) != null) {
                        return var3;
                    }
                    this.method_115(var1);
                }
                return null;
            }
        }
    }

    public final int method_98() {
        return 16;
    }

    public int method_102() {
        return (this.field_170 & 128L) != 0L ? 1 : 0;
    }

    public char[] method_103() {
        return class_233.method_1361(this.field_171, '.');
    }

    public String toString() {
        String var1;
        if (this.field_171 == class_233.field_995) {
            var1 = "The Default Package";
        } else {
            var1 = "package " + (this.field_171 != null ? class_233.method_1389(this.field_171) : "UNNAMED");
        }
        if ((this.field_170 & 128L) != 0L) {
            var1 = var1 + "[MISSING]";
        }
        return var1;
    }
}
