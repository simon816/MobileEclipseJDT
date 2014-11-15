package org.eclipse.jdt.internal.compiler;

import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

public class ClassFilePool {

    ClassFile[] field_1737;

    public ClassFilePool() {
        this.field_1737 = new ClassFile[25];
    }

    public synchronized ClassFile method_3027(SourceTypeBinding var1) {
        ClassFile var10000;
        for (int var2 = 0; var2 < 25; ++var2) {
            ClassFile var3 = this.field_1737[var2];
            if (var3 == null) {
                var10000 = new ClassFile(var1);
                ClassFile var4 = var10000;
                this.field_1737[var2] = var4;
                var4.field_1727 = true;
                return var4;
            }
            if (!var3.field_1727) {
                var3.method_3013(var1);
                var3.field_1727 = true;
                return var3;
            }
        }
        var10000 = new ClassFile(var1);
        return var10000;
    }

    public synchronized void method_3028(ClassFile var1) {
        var1.field_1727 = false;
    }

    public void method_3029() {
        Arrays.fill(this.field_1737, (Object)null);
    }
}
