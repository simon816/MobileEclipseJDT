package org.eclipse.jdt.internal.compiler;

import java.util.Comparator;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

class ClassFile$2 implements Comparator {

    private final ClassFile field_1735;

    ClassFile$2(ClassFile var1) {
        this.field_1735 = var1;
    }

    public int compare(Object var1, Object var2) {
        TypeBinding var3 = (TypeBinding)var1;
        TypeBinding var4 = (TypeBinding)var2;
        return CharOperation.method_1354(var3.constantPoolName(), var4.constantPoolName());
    }
}
