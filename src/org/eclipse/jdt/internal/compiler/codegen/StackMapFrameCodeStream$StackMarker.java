package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.internal.compiler.codegen.VerificationTypeInfo;

public class StackMapFrameCodeStream$StackMarker {

    public int field_319;

    public int field_320;

    public VerificationTypeInfo[] infos;

    public StackMapFrameCodeStream$StackMarker(int var1, int var2) {
        this.field_319 = var1;
        this.field_320 = var2;
    }

    public void setInfos(VerificationTypeInfo[] var1) {
        this.infos = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("[copy stack items from ").append(this.field_319).append(" to ").append(this.field_320);
        if (this.infos != null) {
            int var2 = 0;
            for (int var3 = this.infos.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.infos[var2]);
            }
        }
        var1.append(']');
        return String.valueOf(var1);
    }
}
