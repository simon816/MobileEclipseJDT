package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;

public class ImportReference extends ASTNode {

    public char[][] field_467;

    public long[] field_468;

    public int field_469;

    public int field_470;

    public int field_471;

    public int field_472;

    public class_164[] field_473;

    public ImportReference(char[][] var1, long[] var2, boolean var3, int var4) {
        this.field_467 = var1;
        this.field_468 = var2;
        if (var3) {
            this.field_446 |= 131072;
        }
        this.field_445 = (int)(var2[var2.length - 1] & -1L);
        this.field_444 = (int)(var2[0] >>> 32);
        this.field_472 = var4;
    }

    public boolean method_781() {
        return (this.field_472 & 8) != 0;
    }

    public StringBuffer method_757(int var1, StringBuffer var2) {
        return this.method_782(var1, var2, true);
    }

    public StringBuffer method_782(int var1, StringBuffer var2, boolean var3) {
        for (int var4 = 0; var4 < this.field_467.length; ++var4) {
            if (var4 > 0) {
                var2.append('.');
            }
            var2.append(this.field_467[var4]);
        }
        if (var3 && (this.field_446 & 131072) != 0) {
            var2.append(".*");
        }
        return var2;
    }
}
