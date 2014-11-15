package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_152;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_51;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;

public class class_151 extends class_146 {

    public char[][] field_732;

    public long[] field_733;

    public class_151(char[][] var1, long[] var2) {
        this.field_732 = var1;
        this.field_733 = var2;
        this.field_444 = (int)(this.field_733[0] >>> 32);
        this.field_445 = (int)(this.field_733[this.field_733.length - 1] & 4294967295L);
    }

    public class_146 method_1008(int var1) {
        class_152 var10000 = new class_152(this.field_732, var1, this.field_733);
        return var10000;
    }

    protected class_40 method_1030(int var1, class_83 var2, PackageBinding var3) {
        LookupEnvironment var4 = var2.method_586();
        class_40 var5;
        try {
            var4.field_363 = this;
            if (this.field_675 == null) {
                this.field_675 = var2.method_617(this.field_732[var1], var3);
            } else {
                this.field_675 = var2.method_613(this.field_732[var1], (ReferenceBinding)this.field_675);
                if (!this.field_675.method_101()) {
                    class_51 var10001 = new class_51(CharOperation.method_1387(this.field_732, 0, var1 + 1), (ReferenceBinding)this.field_675.method_131(), this.field_675.method_102());
                    this.field_675 = var10001;
                }
            }
            var5 = this.field_675;
        } catch (AbortCompilation var9) {
            var9.method_1438(this, var2.method_645().field_455);
            throw var9;
        } finally {
            var4.field_363 = null;
        }
        return var5;
    }

    public char[] method_1010() {
        return this.field_732[this.field_732.length - 1];
    }

    protected class_40 method_1011(class_83 var1) {
        if (this.field_675 != null) {
            return this.field_675;
        } else {
            class_34 var2 = var1.method_615(this.field_732);
            if (var2 != null && !var2.method_101()) {
                if (var2 instanceof class_51 && var2.method_102() == 1) {
                    class_51 var11 = (class_51)var2;
                    class_34 var12 = var1.method_620(this.field_732);
                    class_51 var10000 = new class_51(var11.field_197, var12 instanceof PackageBinding ? null : var1.method_586().method_496((PackageBinding)null, this.field_732), 1);
                    return var10000;
                } else {
                    return (ReferenceBinding)var2;
                }
            } else {
                PackageBinding var3 = var2 == null ? null : (PackageBinding)var2;
                boolean var4 = var1.field_373 == 3;
                Object var5 = null;
                int var6 = var3 == null ? 0 : var3.field_171.length;
                int var7 = this.field_732.length;
                for (int var8 = var7 - 1; var6 < var7; ++var6) {
                    this.method_1030(var6, var1, var3);
                    if (!this.field_675.method_101()) {
                        return this.field_675;
                    }
                    if (var6 == 0 && this.field_675.method_169() && ((class_46)this.field_675).field_222 == null) {
                        var1.method_644().method_1567((class_46)this.field_675, this);
                        return null;
                    }
                    if (var6 < var8 && this.method_756(this.field_675, var1)) {
                        this.method_1014(this.field_675, var1);
                    }
                    if (var4 && ((class_84)var1).method_668(this.field_675, this)) {
                        return null;
                    }
                    ReferenceBinding var9 = (ReferenceBinding)this.field_675;
                    if (var5 != null) {
                        if (var9.method_155()) {
                            var5 = var1.method_586().method_501(var9, (ReferenceBinding)var5);
                        } else {
                            boolean var10;
                            if ((var10 = ((ReferenceBinding)var5).method_166()) && !var9.method_226()) {
                                var5 = var1.method_586().method_501((ReferenceBinding)var9.method_138(), (ReferenceBinding)var5);
                            } else if ((var10 || ((ReferenceBinding)var5).method_162()) && ((ReferenceBinding)var5).method_138() == var9.method_137().method_138()) {
                                var5 = var1.method_586().method_500((ReferenceBinding)var9.method_138(), (class_40[])null, (ReferenceBinding)var5);
                            } else {
                                var5 = var9;
                            }
                        }
                    } else {
                        var5 = var9.method_155() ? (ReferenceBinding)var1.method_586().method_490(var9, false) : var9;
                    }
                }
                this.field_675 = (class_40)var5;
                return this.field_675;
            }
        }
    }

    public char[][] method_1012() {
        return this.field_732;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        for (int var3 = 0; var3 < this.field_732.length; ++var3) {
            if (var3 > 0) {
                var2.append('.');
            }
            var2.append(this.field_732[var3]);
        }
        return var2;
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2051(this, var2);
        var1.method_1966(this, var2);
    }

    public void method_1021(class_264 var1, class_84 var2) {
        var1.method_2052(this, var2);
        var1.method_1967(this, var2);
    }
}
