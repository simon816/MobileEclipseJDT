package org.eclipse.jdt.internal.compiler.util;

public final class HashtableOfInt {

    public int[] keyTable;

    public Object[] valueTable;

    public int elementSize;

    int threshold;

    public HashtableOfInt() {
        this(13);
    }

    public HashtableOfInt(int var1) {
        this.elementSize = 0;
        this.threshold = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.threshold == var2) {
            ++var2;
        }
        this.keyTable = new int[var2];
        this.valueTable = new Object[var2];
    }

    public Object get(int var1) {
        int var2 = this.keyTable.length;
        int var3 = var1 % var2;
        int var4;
        while ((var4 = this.keyTable[var3]) != 0) {
            if (var4 == var1) {
                return this.valueTable[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    public Object put(int var1, Object var2) {
        int var3 = this.keyTable.length;
        int var4 = var1 % var3;
        int var5;
        while ((var5 = this.keyTable[var4]) != 0) {
            if (var5 == var1) {
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
        HashtableOfInt var10000 = new HashtableOfInt(this.elementSize * 2);
        HashtableOfInt var1 = var10000;
        int var3 = this.keyTable.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.keyTable = var1.keyTable;
                this.valueTable = var1.valueTable;
                this.threshold = var1.threshold;
                return;
            }
            int var2;
            if ((var2 = this.keyTable[var3]) != 0) {
                var1.put(var2, this.valueTable[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.valueTable.length; var3 < var4; ++var3) {
            Object var2;
            if ((var2 = this.valueTable[var3]) != null) {
                var1 = var1 + this.keyTable[var3] + " -> " + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
