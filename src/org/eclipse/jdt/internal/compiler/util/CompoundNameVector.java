package org.eclipse.jdt.internal.compiler.util;

import org.eclipse.jdt.core.compiler.CharOperation;

public final class CompoundNameVector {

    static int INITIAL_SIZE;

    public int size;

    int maxSize;

    char[][][] elements;

    public CompoundNameVector() {
        this.maxSize = INITIAL_SIZE;
        this.size = 0;
        this.elements = new char[this.maxSize][][];
    }

    public void add(char[][] var1) {
        if (this.size == this.maxSize) {
            System.arraycopy(this.elements, 0, this.elements = new char[this.maxSize *= 2][][], 0, this.size);
        }
        this.elements[this.size++] = var1;
    }

    public boolean contains(char[][] var1) {
        int var2 = this.size;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (!CharOperation.equals(var1, this.elements[var2]));
        return true;
    }

    public char[][] elementAt(int var1) {
        return this.elements[var1];
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        for (int var2 = 0; var2 < this.size; ++var2) {
            var1.append(CharOperation.toString(this.elements[var2])).append("\n");
        }
        return var1.toString();
    }

    static {
        INITIAL_SIZE = 10;
    }
}
