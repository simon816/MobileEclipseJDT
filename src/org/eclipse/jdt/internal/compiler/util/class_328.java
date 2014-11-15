package org.eclipse.jdt.internal.compiler.util;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public final class class_328 {

    public char[][] field_1856;

    public ReferenceBinding[] field_1857;

    public int field_1858;

    int field_1859;

    public class_328() {
        this(3);
    }

    public class_328(int var1) {
        this.field_1858 = 0;
        this.field_1859 = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.field_1859 == var2) {
            ++var2;
        }
        this.field_1856 = new char[var2][];
        this.field_1857 = new ReferenceBinding[var2];
    }

    public ReferenceBinding method_3247(char[] var1) {
        int var2 = this.field_1856.length;
        int var3 = CharOperation.method_1369(var1) % var2;
        int var4 = var1.length;
        char[] var5;
        while ((var5 = this.field_1856[var3]) != null) {
            if (var5.length == var4 && CharOperation.method_1364(var5, var1)) {
                return this.field_1857[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    public ReferenceBinding method_3248(char[] var1, ReferenceBinding var2) {
        int var3 = this.field_1856.length;
        int var4 = CharOperation.method_1369(var1) % var3;
        int var5 = var1.length;
        char[] var6;
        while ((var6 = this.field_1856[var4]) != null) {
            if (var6.length == var5 && CharOperation.method_1364(var6, var1)) {
                return this.field_1857[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1856[var4] = var1;
        this.field_1857[var4] = var2;
        if (++this.field_1858 > this.field_1859) {
            this.method_3249();
        }
        return var2;
    }

    private void method_3249() {
        class_328 var10000 = new class_328(this.field_1858 < 100 ? 100 : this.field_1858 * 2);
        class_328 var1 = var10000;
        int var3 = this.field_1856.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_1856 = var1.field_1856;
                this.field_1857 = var1.field_1857;
                this.field_1859 = var1.field_1859;
                return;
            }
            char[] var2;
            if ((var2 = this.field_1856[var3]) != null) {
                var1.method_3248(var2, this.field_1857[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.field_1857.length; var3 < var4; ++var3) {
            ReferenceBinding var2;
            if ((var2 = this.field_1857[var3]) != null) {
                var1 = var1 + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
