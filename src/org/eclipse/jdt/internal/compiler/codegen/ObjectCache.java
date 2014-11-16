package org.eclipse.jdt.internal.compiler.codegen;

public class ObjectCache {

    public Object[] keyTable;

    public int[] valueTable;

    int field_1527;

    int field_1528;

    public ObjectCache() {
        this(13);
    }

    public ObjectCache(int var1) {
        this.field_1527 = 0;
        this.field_1528 = (int)((float)var1 * 0.66F);
        this.keyTable = new Object[var1];
        this.valueTable = new int[var1];
    }

    public int method_2499(Object var1) {
        int var2 = this.method_2500(var1);
        int var3 = this.keyTable.length;
        while (this.keyTable[var2] != null) {
            if (this.keyTable[var2] == var1) {
                return this.valueTable[var2];
            }
            ++var2;
            if (var2 == var3) {
                var2 = 0;
            }
        }
        return -1;
    }

    public int method_2500(Object var1) {
        return (var1.hashCode() & Integer.MAX_VALUE) % this.keyTable.length;
    }

    public int put(Object var1, int var2) {
        int var3 = this.method_2500(var1);
        int var4 = this.keyTable.length;
        while (this.keyTable[var3] != null) {
            if (this.keyTable[var3] == var1) {
                return this.valueTable[var3] = var2;
            }
            ++var3;
            if (var3 == var4) {
                var3 = 0;
            }
        }
        this.keyTable[var3] = var1;
        this.valueTable[var3] = var2;
        if (++this.field_1527 > this.field_1528) {
            this.rehash();
        }
        return var2;
    }

    private void rehash() {
        ObjectCache var10000 = new ObjectCache(this.keyTable.length * 2);
        ObjectCache var1 = var10000;
        int var2 = this.keyTable.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.keyTable = var1.keyTable;
                this.valueTable = var1.valueTable;
                this.field_1528 = var1.field_1528;
                return;
            }
            if (this.keyTable[var2] != null) {
                var1.put(this.keyTable[var2], this.valueTable[var2]);
            }
        }
    }

    public int size() {
        return this.field_1527;
    }

    public String toString() {
        int var1 = this.size();
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.keyTable[var3] != null) {
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
