package org.eclipse.jdt.internal.compiler;

import java.util.Arrays;

import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

public class ClassFilePool {

    ClassFile[] classFiles;

    public ClassFilePool() {
        this.classFiles = new ClassFile[25];
    }

    public synchronized ClassFile acquire(SourceTypeBinding var1) {
        ClassFile var10000;
        for (int var2 = 0; var2 < 25; ++var2) {
            ClassFile var3 = this.classFiles[var2];
            if (var3 == null) {
                var10000 = new ClassFile(var1);
                ClassFile var4 = var10000;
                this.classFiles[var2] = var4;
                var4.isShared = true;
                return var4;
            }
            if (!var3.isShared) {
                var3.reset(var1);
                var3.isShared = true;
                return var3;
            }
        }
        var10000 = new ClassFile(var1);
        return var10000;
    }

    public synchronized void release(ClassFile var1) {
        var1.isShared = false;
    }

    public void reset() {
        Arrays.fill(this.classFiles, (Object)null);
    }
}
