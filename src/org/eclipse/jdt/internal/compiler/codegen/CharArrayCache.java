package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.core.compiler.CharOperation;

public class CharArrayCache {

    public char[][] keyTable;

    public int[] valueTable;

    int field_1155;

    int field_1156;

    public CharArrayCache() {
        this(9);
    }

    public CharArrayCache(int var1) {
        this.field_1155 = 0;
        this.field_1156 = var1 * 2 / 3;
        this.keyTable = new char[var1][];
        this.valueTable = new int[var1];
    }

    public void clear() {
        int var1 = this.keyTable.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_1155 = 0;
                return;
            }
            this.keyTable[var1] = null;
            this.valueTable[var1] = 0;
        }
    }

    public int get(char[] var1) {
        int var2 = this.keyTable.length;
        int var3 = CharOperation.hashCode(var1) % var2;
        while (this.keyTable[var3] != null) {
            if (CharOperation.method_1364(this.keyTable[var3], var1)) {
                return this.valueTable[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return -1;
    }

    public int putIfAbsent(char[] var1, int var2) {
        int var3 = this.keyTable.length;
        int var4 = CharOperation.hashCode(var1) % var3;
        while (this.keyTable[var4] != null) {
            if (CharOperation.method_1364(this.keyTable[var4], var1)) {
                return this.valueTable[var4];
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.keyTable[var4] = var1;
        this.valueTable[var4] = var2;
        if (++this.field_1155 > this.field_1156) {
            this.rehash();
        }
        return -var2;
    }

    private int put(char[] var1, int var2) {
        int var3 = this.keyTable.length;
        int var4 = CharOperation.hashCode(var1) % var3;
        while (this.keyTable[var4] != null) {
            if (CharOperation.method_1364(this.keyTable[var4], var1)) {
                return this.valueTable[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.keyTable[var4] = var1;
        this.valueTable[var4] = var2;
        if (++this.field_1155 > this.field_1156) {
            this.rehash();
        }
        return var2;
    }

    private void rehash() {
        CharArrayCache var10000 = new CharArrayCache(this.keyTable.length * 2);
        CharArrayCache var1 = var10000;
        int var2 = this.keyTable.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.keyTable = var1.keyTable;
                this.valueTable = var1.valueTable;
                this.field_1156 = var1.field_1156;
                return;
            }
            if (this.keyTable[var2] != null) {
                var1.put(this.keyTable[var2], this.valueTable[var2]);
            }
        }
    }

    public void remove(char[] var1) {
        int var2 = this.keyTable.length;
        int var3 = CharOperation.hashCode(var1) % var2;
        while (this.keyTable[var3] != null) {
            if (CharOperation.method_1364(this.keyTable[var3], var1)) {
                this.valueTable[var3] = 0;
                this.keyTable[var3] = null;
                return;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
    }

    public char[] returnKeyFor(int var1) {
        int var2 = this.keyTable.length;
        do {
            if (var2-- <= 0) {
                return null;
            }
        } while (this.valueTable[var2] != var1);
        return this.keyTable[var2];
    }

    public int size() {
        return this.field_1155;
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
