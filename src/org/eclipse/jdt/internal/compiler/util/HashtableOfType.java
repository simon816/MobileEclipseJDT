package org.eclipse.jdt.internal.compiler.util;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public final class HashtableOfType {

    public char[][] keyTable;

    public ReferenceBinding[] valueTable;

    public int elementSize;

    int threshold;

    public HashtableOfType() {
        this(3);
    }

    public HashtableOfType(int var1) {
        this.elementSize = 0;
        this.threshold = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.threshold == var2) {
            ++var2;
        }
        this.keyTable = new char[var2][];
        this.valueTable = new ReferenceBinding[var2];
    }

    public ReferenceBinding get(char[] var1) {
        int var2 = this.keyTable.length;
        int var3 = CharOperation.hashCode(var1) % var2;
        int var4 = var1.length;
        char[] var5;
        while ((var5 = this.keyTable[var3]) != null) {
            if (var5.length == var4 && CharOperation.method_1364(var5, var1)) {
                return this.valueTable[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    public ReferenceBinding put(char[] var1, ReferenceBinding var2) {
        int var3 = this.keyTable.length;
        int var4 = CharOperation.hashCode(var1) % var3;
        int var5 = var1.length;
        char[] var6;
        while ((var6 = this.keyTable[var4]) != null) {
            if (var6.length == var5 && CharOperation.method_1364(var6, var1)) {
                return this.valueTable[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.keyTable[var4] = var1;
        this.valueTable[var4] = var2;
        if (++this.elementSize > this.threshold) {
            this.rehash();
        }
        return var2;
    }

    private void rehash() {
        HashtableOfType var10000 = new HashtableOfType(this.elementSize < 100 ? 100 : this.elementSize * 2);
        HashtableOfType var1 = var10000;
        int var3 = this.keyTable.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.keyTable = var1.keyTable;
                this.valueTable = var1.valueTable;
                this.threshold = var1.threshold;
                return;
            }
            char[] var2;
            if ((var2 = this.keyTable[var3]) != null) {
                var1.put(var2, this.valueTable[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.valueTable.length; var3 < var4; ++var3) {
            ReferenceBinding var2;
            if ((var2 = this.valueTable[var3]) != null) {
                var1 = var1 + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
