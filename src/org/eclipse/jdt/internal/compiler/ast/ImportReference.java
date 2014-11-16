package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;

public class ImportReference extends ASTNode {

    public char[][] tokens;

    public long[] sourcePositions;

    public int field_469;

    public int field_470;

    public int field_471;

    public int field_472;

    public Annotation[] annotations;

    public ImportReference(char[][] var1, long[] var2, boolean var3, int var4) {
        this.tokens = var1;
        this.sourcePositions = var2;
        if (var3) {
            this.field_446 |= 131072;
        }
        this.field_445 = (int)(var2[var2.length - 1] & -1L);
        this.field_444 = (int)(var2[0] >>> 32);
        this.field_472 = var4;
    }

    public boolean isStatic() {
        return (this.field_472 & 8) != 0;
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        return this.print(var1, var2, true);
    }

    public StringBuffer print(int var1, StringBuffer var2, boolean var3) {
        for (int var4 = 0; var4 < this.tokens.length; ++var4) {
            if (var4 > 0) {
                var2.append('.');
            }
            var2.append(this.tokens[var4]);
        }
        if (var3 && (this.field_446 & 131072) != 0) {
            var2.append(".*");
        }
        return var2;
    }
}
