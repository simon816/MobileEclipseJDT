package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.class_170;

import java.util.Comparator;

final class class_330 implements Comparator {

    class_330() {
    }

    public int compare(Object var1, Object var2) {
        class_170 var3 = (class_170)var1;
        class_170 var4 = (class_170)var2;
        return var3.field_444 - var4.field_444;
    }
}
