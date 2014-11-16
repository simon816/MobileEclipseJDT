package org.eclipse.jdt.internal.compiler.util;

public final class HashSetOfInt {

    public int[] set;

    public int elementSize;

    int threshold;

    public HashSetOfInt() {
        this(13);
    }

    public HashSetOfInt(int var1) {
        this.elementSize = 0;
        this.threshold = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.threshold == var2) {
            ++var2;
        }
        this.set = new int[var2];
    }

    public boolean contains(int var1) {
        int var2 = this.set.length;
        int var3 = var1 % var2;
        int var4;
        while ((var4 = this.set[var3]) != 0) {
            if (var4 == var1) {
                return true;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return false;
    }

    public int method_3210(int var1) {
        int var2 = this.set.length;
        int var3 = var1 % var2;
        int var4;
        while ((var4 = this.set[var3]) != 0) {
            if (var4 == var1) {
                return this.set[var3] = var1;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        this.set[var3] = var1;
        if (++this.elementSize > this.threshold) {
            this.rehash();
        }
        return var1;
    }

    private void rehash() {
        HashSetOfInt var10000 = new HashSetOfInt(this.elementSize * 2);
        HashSetOfInt var1 = var10000;
        int var3 = this.set.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.set = var1.set;
                this.threshold = var1.threshold;
                return;
            }
            int var2;
            if ((var2 = this.set[var3]) != 0) {
                var1.method_3210(var2);
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        int var3 = 0;
        for (int var4 = this.set.length; var3 < var4; ++var3) {
            int var2;
            if ((var2 = this.set[var3]) != 0) {
                var1.append(var2);
                if (var3 != var4 - 1) {
                    var1.append('\n');
                }
            }
        }
        return var1.toString();
    }
}
