package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public class StackMapFrameCodeStream$StackDepthMarker {

    public int field_340;

    public int field_341;

    public TypeBinding typeBinding;

    public StackMapFrameCodeStream$StackDepthMarker(int var1, int var2, TypeBinding var3) {
        this.field_340 = var1;
        this.typeBinding = var3;
        this.field_341 = var2;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append('(').append(this.field_340).append(',').append(this.field_341);
        if (this.typeBinding != null) {
            var1.append(',').append(this.typeBinding.method_176()).append(this.typeBinding.method_177());
        }
        var1.append(')');
        return String.valueOf(var1);
    }
}
