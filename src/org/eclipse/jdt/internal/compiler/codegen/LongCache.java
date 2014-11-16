package org.eclipse.jdt.internal.compiler.codegen;

public class LongCache {

    public long[] keyTable;

    public int[] valueTable;

    int field_334;

    int field_335;

    public LongCache() {
        this(13);
    }

    public LongCache(int var1) {
        this.field_334 = 0;
        this.field_335 = (int)((double)var1 * 0.66D);
        this.keyTable = new long[var1];
        this.valueTable = new int[var1];
    }

    public void clear() {
        int var1 = this.keyTable.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_334 = 0;
                return;
            }
            this.keyTable[var1] = 0L;
            this.valueTable[var1] = 0;
        }
    }

    public int hash(long var1) {
        return ((int)var1 & Integer.MAX_VALUE) % this.keyTable.length;
    }

    public int method_464(long var1, int var3) {
        int var4 = this.hash(var1);
        int var5 = this.keyTable.length;
        while (this.keyTable[var4] != 0L || this.keyTable[var4] == 0L && this.valueTable[var4] != 0) {
            if (this.keyTable[var4] == var1) {
                return this.valueTable[var4] = var3;
            }
            ++var4;
            if (var4 == var5) {
                var4 = 0;
            }
        }
        this.keyTable[var4] = var1;
        this.valueTable[var4] = var3;
        if (++this.field_334 > this.field_335) {
            this.rehash();
        }
        return var3;
    }

    public int method_465(long var1, int var3) {
        int var4 = this.hash(var1);
        int var5 = this.keyTable.length;
        while (this.keyTable[var4] != 0L || this.keyTable[var4] == 0L && this.valueTable[var4] != 0) {
            if (this.keyTable[var4] == var1) {
                return this.valueTable[var4];
            }
            ++var4;
            if (var4 == var5) {
                var4 = 0;
            }
        }
        this.keyTable[var4] = var1;
        this.valueTable[var4] = var3;
        if (++this.field_334 > this.field_335) {
            this.rehash();
        }
        return -var3;
    }

    private void rehash() {
        LongCache var10000 = new LongCache(this.keyTable.length * 2);
        LongCache var1 = var10000;
        int var2 = this.keyTable.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.keyTable = var1.keyTable;
                this.valueTable = var1.valueTable;
                this.field_335 = var1.field_335;
                return;
            }
            long var3 = this.keyTable[var2];
            int var5 = this.valueTable[var2];
            if (var3 != 0L || var3 == 0L && var5 != 0) {
                var1.method_464(var3, var5);
            }
        }
    }

    public int size() {
        return this.field_334;
    }

    public String toString() {
        int var1 = this.size();
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.keyTable[var3] != 0L || this.keyTable[var3] == 0L && this.valueTable[var3] != 0) {
                var2.append(this.keyTable[var3]).append("->").append(this.valueTable[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
