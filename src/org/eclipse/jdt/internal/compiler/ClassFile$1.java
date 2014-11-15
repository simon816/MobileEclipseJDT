package org.eclipse.jdt.internal.compiler;

import java.util.Comparator;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.lookup.class_40;

class ClassFile$1 implements Comparator {

    private final ClassFile field_1736;

    ClassFile$1(ClassFile var1) {
        this.field_1736 = var1;
    }

    public int compare(Object var1, Object var2) {
        class_40 var3 = (class_40)var1;
        class_40 var4 = (class_40)var2;
        return CharOperation.method_1354(var3.method_134(), var4.method_134());
    }
}
