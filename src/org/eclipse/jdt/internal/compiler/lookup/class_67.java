package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_0;
import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_38;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_54;
import org.eclipse.jdt.internal.compiler.lookup.class_64;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_87;

public class class_67 extends class_64 {

    public class_43 field_314;

    protected class_67() {
        super((char[])null, (class_40)null, 0, (class_331)null);
    }

    public class_67(char[] var1, class_40 var2, int var3, class_43 var4, class_331 var5) {
        super(var1, var2, var3, var5);
        this.field_314 = var4;
    }

    public class_67(class_67 var1, class_43 var2) {
        super(var1.field_302, var1.field_301, var1.field_300, var1.method_407());
        this.field_314 = var2;
        this.field_304 = var1.field_304;
        this.method_436(var1.method_426());
    }

    public class_67(class_121 var1, class_40 var2, int var3, class_43 var4) {
        this(var1.field_659, var2, var3, var4, (class_331)null);
        var1.field_661 = this;
    }

    public final boolean method_422(class_38 var1) {
        return this.method_430() ? true : (this.method_428() ? false : var1 == this.field_314.method_143());
    }

    public final boolean method_423(class_40 var1, class_0 var2, class_83 var3) {
        if (this.method_430()) {
            return true;
        } else {
            class_54 var4 = var3.method_585();
            if (var4 == this.field_314 && var4 == var1) {
                return true;
            } else if (var4 == null) {
                return !this.method_428() && var3.method_600() == this.field_314.field_200;
            } else {
                Object var5;
                class_43 var7;
                if (this.method_429()) {
                    if (var4 == this.field_314) {
                        return true;
                    } else if (var4.field_200 == this.field_314.field_200) {
                        return true;
                    } else {
                        var5 = var4;
                        int var10 = 0;
                        var7 = (class_43)var1.method_138();
                        class_43 var8 = (class_43)this.field_314.method_138();
                        do {
                            if (((class_43)var5).method_140(var8) != null) {
                                if (var2.method_1()) {
                                    return true;
                                }
                                if (var1 instanceof class_42) {
                                    return false;
                                }
                                if (this.method_431()) {
                                    if (var10 > 0) {
                                        var2.method_2(var10);
                                    }
                                    return true;
                                }
                                if (var5 == var7 || var7.method_140((class_40)var5) != null) {
                                    if (var10 > 0) {
                                        var2.method_2(var10);
                                    }
                                    return true;
                                }
                            }
                            ++var10;
                            var5 = ((class_43)var5).method_137();
                        } while (var5 != null);
                        return false;
                    }
                } else {
                    class_43 var6;
                    if (!this.method_428()) {
                        class_38 var9 = this.field_314.field_200;
                        if (var4.field_200 != var9) {
                            return false;
                        } else if (var1 instanceof class_42) {
                            return false;
                        } else {
                            var6 = (class_43)var1;
                            do {
                                if (this.field_314 == var6) {
                                    return true;
                                }
                                class_38 var11 = var6.field_200;
                                if (var11 != null && var11 != var9) {
                                    return false;
                                }
                            } while ((var6 = var6.method_240()) != null);
                            return false;
                        }
                    } else if (var1 != this.field_314 && (!var1.method_169() || !((class_46)var1).method_258(this.field_314.method_138()))) {
                        return false;
                    } else {
                        if (var4 != this.field_314) {
                            var5 = var4;
                            for (var6 = var4.method_137(); var6 != null; var6 = var6.method_137()) {
                                var5 = var6;
                            }
                            var7 = (class_43)this.field_314.method_138();
                            for (var6 = var7.method_137(); var6 != null; var6 = var6.method_137()) {
                                var7 = var6;
                            }
                            if (var5 != var7) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    public class_331 method_407() {
        class_331 var1 = this.field_303;
        if (var1 == null) {
            if (this.method_409()) {
                class_67 var2 = this.method_435();
                if (var2.field_314 instanceof class_54) {
                    class_54 var3 = (class_54)var2.field_314;
                    if (var3.field_258 != null) {
                        class_114 var4 = var3.field_258.field_376;
                        class_121 var5 = var4.method_853(var2);
                        var5.method_892(var2.method_431() ? var4.field_589 : var4.field_588);
                        var1 = var2.field_303 == null ? class_331.field_1896 : var2.field_303;
                    } else {
                        var1 = class_331.field_1896;
                    }
                } else {
                    var1 = class_331.field_1896;
                }
            } else {
                var1 = class_331.field_1896;
            }
            this.field_303 = var1;
        }
        return var1;
    }

    public char[] method_424() {
        return (this.field_300 & 1073741824) == 0 ? null : this.field_301.method_142();
    }

    public final int method_425() {
        return this.field_300 & '\uffff';
    }

    public class_203[] method_426() {
        class_67 var1 = this.method_435();
        class_43 var2 = var1.field_314;
        return var2 == null ? class_34.field_158 : var2.method_235(var1);
    }

    public long method_99() {
        class_67 var1 = this.method_435();
        if ((var1.field_305 & 8589934592L) == 0L && var1.field_314 instanceof class_54) {
            class_84 var2 = ((class_54)var1.field_314).field_258;
            if (var2 == null) {
                this.field_305 |= 25769803776L;
                return 0L;
            }
            class_114 var3 = var2.field_376;
            class_121 var4 = var3.method_853(var1);
            if (var4 != null) {
                class_87 var5 = this.method_431() ? var3.field_589 : var3.field_588;
                class_67 var6 = var5.field_406;
                int var7 = var5.field_407;
                try {
                    var5.field_406 = var1;
                    var5.field_407 = var1.field_304;
                    class_89.method_761(var5, var4.field_658, var1);
                } finally {
                    var5.field_406 = var6;
                    var5.field_407 = var7;
                }
            }
        }
        return var1.field_305;
    }

    public final boolean method_427() {
        return (this.field_300 & 1048576) != 0;
    }

    public final boolean method_428() {
        return (this.field_300 & 2) != 0;
    }

    public final boolean method_429() {
        return (this.field_300 & 4) != 0;
    }

    public final boolean method_430() {
        return (this.field_300 & 1) != 0;
    }

    public final boolean method_431() {
        return (this.field_300 & 8) != 0;
    }

    public final boolean method_432() {
        return (this.field_300 & 4096) != 0;
    }

    public final boolean method_433() {
        return (this.field_300 & 134217728) != 0;
    }

    public final boolean method_434() {
        return (this.field_300 & 3145728) != 0;
    }

    public final int method_98() {
        return 1;
    }

    public class_67 method_435() {
        return this;
    }

    public void method_436(class_203[] var1) {
        this.field_314.method_238(this, var1);
    }

    public class_121 method_437() {
        class_54 var1;
        try {
            var1 = (class_54)this.field_314;
        } catch (ClassCastException var4) {
            return null;
        }
        class_121[] var2 = var1.field_258.field_376.field_583;
        if (var2 != null) {
            int var3 = var2.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    break;
                }
                if (this == var2[var3].field_661) {
                    return var2[var3];
                }
            }
        }
        return null;
    }
}
