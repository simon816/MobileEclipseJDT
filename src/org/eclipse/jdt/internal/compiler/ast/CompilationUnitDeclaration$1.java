package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.StringLiteral;

import java.util.Comparator;

final class CompilationUnitDeclaration$1 implements Comparator {

    CompilationUnitDeclaration$1() {
    }

    public int compare(Object var1, Object var2) {
        StringLiteral var3 = (StringLiteral)var1;
        StringLiteral var4 = (StringLiteral)var2;
        return var3.field_444 - var4.field_444;
    }
}
