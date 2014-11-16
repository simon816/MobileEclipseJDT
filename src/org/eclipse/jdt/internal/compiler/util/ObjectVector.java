package org.eclipse.jdt.internal.compiler.util;

public final class ObjectVector {

    static int INITIAL_SIZE;

    public int size;

    int maxSize;

    Object[] elements;

    public ObjectVector() {
        this(INITIAL_SIZE);
    }

    public ObjectVector(int var1) {
        this.maxSize = var1 > 0 ? var1 : INITIAL_SIZE;
        this.size = 0;
        this.elements = new Object[this.maxSize];
    }

    public void add(Object var1) {
        if (this.size == this.maxSize) {
            System.arraycopy(this.elements, 0, this.elements = new Object[this.maxSize *= 2], 0, this.size);
        }
        this.elements[this.size++] = var1;
    }

    public void method_3232(Object[] var1) {
        if (this.size + var1.length >= this.maxSize) {
            this.maxSize = this.size + var1.length;
            System.arraycopy(this.elements, 0, this.elements = new Object[this.maxSize], 0, this.size);
        }
        System.arraycopy(var1, 0, this.elements, this.size, var1.length);
        this.size += var1.length;
    }

    public boolean method_3233(Object var1) {
        int var2 = this.size;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (var1 != this.elements[var2]);
        return true;
    }

    public boolean method_3234(Object var1) {
        int var2 = this.size;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (!var1.equals(this.elements[var2]));
        return true;
    }

    public void method_3235(Object[] var1) {
        this.copyInto(var1, 0);
    }

    public void copyInto(Object[] var1, int var2) {
        System.arraycopy(this.elements, 0, var1, var2, this.size);
    }

    public Object elementAt(int var1) {
        return this.elements[var1];
    }

    public String toString() {
        String var1 = "";
        for (int var2 = 0; var2 < this.size; ++var2) {
            var1 = var1 + this.elements[var2].toString() + "\n";
        }
        return var1;
    }

    static {
        INITIAL_SIZE = 10;
    }
}
