package org.eclipse.jdt.internal.compiler.codegen;

public class CachedIndexEntry {

    public char[] signature;

    public int index;

    public CachedIndexEntry(char[] var1, int var2) {
        this.signature = var1;
        this.index = var2;
    }
}
