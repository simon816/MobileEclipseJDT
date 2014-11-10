package m;

import m.class_40;
import m.class_43;
import m.class_54;
import m.class_65;
import m.class_66;
import m.class_84;

public class class_55 extends class_54 {

    public class_54 field_262;

    public class_66[] field_263;

    public class_66[] field_264;

    public int field_265;

    public int field_266;

    public class_55(char[][] var1, class_84 var2, class_54 var3) {
        super(var1, var3.field_200, var2);
        this.field_178 |= 4L;
        this.field_262 = var3;
    }

    public class_66 method_323(class_65 var1) {
        class_66 var2 = null;
        if (this.field_264 == null) {
            class_66 var10000 = new class_66(var1);
            var2 = var10000;
            this.field_264 = new class_66[] {var2};
        } else {
            int var3 = this.field_264.length;
            int var4 = var3;
            int var5 = var3;
            while (true) {
                --var5;
                if (var5 < 0) {
                    class_66[] var6 = new class_66[var3 + 1];
                    System.arraycopy(this.field_264, 0, var6, 0, var4);
                    class_66 var10002 = new class_66(var1);
                    var2 = var10002;
                    var6[var4] = var10002;
                    System.arraycopy(this.field_264, var4, var6, var4 + 1, var3 - var4);
                    this.field_264 = var6;
                    break;
                }
                if (this.field_264[var5].field_312 == var1) {
                    return this.field_264[var5];
                }
                if (this.field_264[var5].field_304 > var1.field_304) {
                    var4 = var5;
                }
            }
        }
        if (this.field_258.method_645().field_458) {
            this.method_330();
        }
        return var2;
    }

    public class_66 method_324(class_43 var1) {
        class_66 var2 = null;
        if (this.field_263 == null) {
            class_66 var10000 = new class_66(var1);
            var2 = var10000;
            this.field_263 = new class_66[] {var2};
        } else {
            int var3 = this.field_263.length;
            int var4 = var3;
            int var5 = var3;
            while (true) {
                --var5;
                if (var5 < 0) {
                    class_66[] var6 = new class_66[var3 + 1];
                    System.arraycopy(this.field_263, 0, var6, var4 == 0 ? 1 : 0, var3);
                    class_66 var10002 = new class_66(var1);
                    var2 = var10002;
                    var6[var4] = var10002;
                    this.field_263 = var6;
                    break;
                }
                if (this.field_263[var5].field_301 == var1) {
                    return this.field_263[var5];
                }
                if (this.method_137() == var1) {
                    var4 = 0;
                }
            }
        }
        if (this.field_258.method_645().field_458) {
            this.method_330();
        }
        return var2;
    }

    public class_66 method_325(class_65 var1) {
        class_66 var2 = this.method_323(var1);
        if (var2 == null) {
            return null;
        } else {
            if (var2.field_313 == null) {
                var2.field_313 = this.method_293(var1);
            }
            return var2;
        }
    }

    public class_66 method_326(class_43 var1) {
        class_66 var2 = this.method_324(var1);
        if (var2 == null) {
            return null;
        } else {
            if (var2.field_313 == null) {
                var2.field_313 = this.method_294(var1);
            }
            return var2;
        }
    }

    public final void method_327() {
        int var1 = 0;
        int var2 = this.field_263 == null ? 0 : this.field_263.length;
        int var3;
        for (var3 = 0; var3 < var2; ++var3) {
            class_66 var4 = this.field_263[var3];
            var4.field_306 = var1 + 1;
            if (var1 + 1 > 255) {
                this.field_258.method_644().method_1697(var4, this.field_258.method_671());
            }
            if (var4.field_301 != class_40.field_183 && var4.field_301 != class_40.field_185) {
                ++var1;
            } else {
                var1 += 2;
            }
        }
        this.field_265 = var1;
        var1 = 0;
        var3 = this.field_264 == null ? 0 : this.field_264.length;
        for (int var6 = 0; var6 < var3; ++var6) {
            class_66 var5 = this.field_264[var6];
            if (var5.field_301 != class_40.field_183 && var5.field_301 != class_40.field_185) {
                ++var1;
            } else {
                var1 += 2;
            }
        }
        this.field_266 = var1;
    }

    public class_43 method_137() {
        return this.field_262;
    }

    public class_66 method_328(class_65 var1) {
        if (this.field_264 == null) {
            return null;
        } else {
            int var2 = this.field_264.length;
            do {
                --var2;
                if (var2 < 0) {
                    return null;
                }
            } while (this.field_264[var2].field_312 != var1);
            return this.field_264[var2];
        }
    }

    public class_66[] method_329() {
        return this.field_263;
    }

    public class_43[] method_242() {
        if (this.field_263 == null) {
            return null;
        } else {
            int var1 = this.field_263.length;
            class_43[] var2 = new class_43[var1];
            for (int var3 = 0; var3 < var1; ++var3) {
                var2[var3] = (class_43)this.field_263[var3].field_301;
            }
            return var2;
        }
    }

    public class_66[] method_243() {
        return this.field_264;
    }

    public void method_330() {}

    public class_66 method_331(class_43 var1, boolean var2) {
        if (this.field_263 == null) {
            return null;
        } else {
            int var3 = this.field_263.length;
            do {
                --var3;
                if (var3 < 0) {
                    if (!var2) {
                        var3 = this.field_263.length;
                        while (true) {
                            --var3;
                            if (var3 < 0) {
                                break;
                            }
                            if (this.field_263[var3].field_312 == null && this.field_263[var3].field_301.method_140(var1) != null) {
                                return this.field_263[var3];
                            }
                        }
                    }
                    return null;
                }
            } while (this.field_263[var3].field_301 != var1 || this.field_263[var3].field_312 != null);
            return this.field_263[var3];
        }
    }
}
