package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_49;
import org.eclipse.jdt.internal.compiler.lookup.class_51;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.util.class_324;
import org.eclipse.jdt.internal.compiler.util.class_328;

public class PackageBinding extends class_34 implements class_17 {

    public long field_170;

    public char[][] field_171;

    PackageBinding field_172;

    public LookupEnvironment field_173;

    class_328 field_174;

    class_324 field_175;

    protected PackageBinding() {
        this.field_170 = 0L;
    }

    public PackageBinding(char[] var1, LookupEnvironment var2) {
        this(new char[][] {var1}, (PackageBinding)null, var2);
    }

    public PackageBinding(char[][] var1, PackageBinding var2, LookupEnvironment var3) {
        this.field_170 = 0L;
        this.field_171 = var1;
        this.field_172 = var2;
        this.field_173 = var3;
        this.field_174 = null;
        class_324 var10001 = new class_324(3);
        this.field_175 = var10001;
    }

    public PackageBinding(LookupEnvironment var1) {
        this(CharOperation.field_995, (PackageBinding)null, var1);
    }

    private void method_115(char[] var1) {
        this.field_175.method_3220(var1, LookupEnvironment.field_366);
    }

    private void method_116(char[] var1) {
        if (this.field_174 == null) {
            class_328 var10001 = new class_328(25);
            this.field_174 = var10001;
        }
        this.field_174.method_3248(var1, LookupEnvironment.field_367);
    }

    void method_117(PackageBinding var1) {
        if ((var1.field_170 & 128L) == 0L) {
            this.method_119();
        }
        this.field_175.method_3220(var1.field_171[var1.field_171.length - 1], var1);
    }

    void method_118(ReferenceBinding var1) {
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
        PackageBinding var1 = this;
        do {
            var1.field_170 &= -129L;
        } while ((var1 = var1.field_172) != null);
    }

    private PackageBinding method_120(char[] var1) {
        if (!this.field_173.method_515(this.field_171, var1)) {
            return null;
        } else {
            char[][] var2 = CharOperation.method_1353(this.field_171, var1);
            PackageBinding var10000 = new PackageBinding(var2, this, this.field_173);
            PackageBinding var3 = var10000;
            this.method_117(var3);
            return var3;
        }
    }

    PackageBinding method_121(char[] var1) {
        PackageBinding var2 = this.method_122(var1);
        if (var2 != null) {
            return var2 == LookupEnvironment.field_366 ? null : var2;
        } else if ((var2 = this.method_120(var1)) != null) {
            return var2;
        } else {
            this.method_115(var1);
            return null;
        }
    }

    PackageBinding method_122(char[] var1) {
        return this.field_175.method_3219(var1);
    }

    ReferenceBinding method_123(char[] var1) {
        ReferenceBinding var2 = this.method_124(var1);
        if (var2 == null && (var2 = this.field_173.method_482(this, var1)) == null) {
            this.method_116(var1);
            return null;
        } else if (var2 == LookupEnvironment.field_367) {
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

    ReferenceBinding method_124(char[] var1) {
        return this.field_174 == null ? null : this.field_174.method_3247(var1);
    }

    public class_34 method_125(char[] var1) {
        ReferenceBinding var2 = this.method_124(var1);
        class_51 var10000;
        if (var2 != null && var2 != LookupEnvironment.field_367) {
            var2 = class_49.method_267(var2, this.field_173, false);
            if (var2.method_160()) {
                var10000 = new class_51(new char[][] {var1}, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        } else {
            PackageBinding var3 = this.method_122(var1);
            if (var3 != null && var3 != LookupEnvironment.field_366) {
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
        return CharOperation.method_1361(this.field_171, '.');
    }

    public String toString() {
        String var1;
        if (this.field_171 == CharOperation.field_995) {
            var1 = "The Default Package";
        } else {
            var1 = "package " + (this.field_171 != null ? CharOperation.method_1389(this.field_171) : "UNNAMED");
        }
        if ((this.field_170 & 128L) != 0L) {
            var1 = var1 + "[MISSING]";
        }
        return var1;
    }
}
