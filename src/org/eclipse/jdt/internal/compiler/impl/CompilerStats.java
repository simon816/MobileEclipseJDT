package org.eclipse.jdt.internal.compiler.impl;

import java.lang.Comparable;

public class CompilerStats implements Comparable {

    public long field_1967;

    public long field_1968;

    public long field_1969;

    public long field_1970;

    public long field_1971;

    public long field_1972;

    public long field_1973;

    public CompilerStats() {
    }

    public long elapsedTime() {
        return this.field_1968 - this.field_1967;
    }

    public int compareTo(Object var1) {
        CompilerStats var2 = (CompilerStats)var1;
        long var3 = this.elapsedTime();
        long var5 = var2.elapsedTime();
        return var3 < var5 ? -1 : (var3 == var5 ? 0 : 1);
    }
}
