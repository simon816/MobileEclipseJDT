package org.eclipse.jdt.internal.compiler.codegen;

import java.lang.Comparable;

import org.eclipse.jdt.core.compiler.CharOperation;

public class StackMapFrameCodeStream$ExceptionMarker implements Comparable {

    public char[] constantPoolName;

    public int pc;

    public StackMapFrameCodeStream$ExceptionMarker(int var1, char[] var2) {
        this.pc = var1;
        this.constantPoolName = var2;
    }

    public int compareTo(Object var1) {
        return var1 instanceof StackMapFrameCodeStream$ExceptionMarker ? this.pc - ((StackMapFrameCodeStream$ExceptionMarker)var1).pc : 0;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof StackMapFrameCodeStream$ExceptionMarker)) {
            return false;
        } else {
            StackMapFrameCodeStream$ExceptionMarker var2 = (StackMapFrameCodeStream$ExceptionMarker)var1;
            return this.pc == var2.pc && CharOperation.method_1364(this.constantPoolName, var2.constantPoolName);
        }
    }

    public int hashCode() {
        return this.pc + this.constantPoolName.hashCode();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append('(').append(this.pc).append(',').append(this.constantPoolName).append(')');
        return String.valueOf(var1);
    }
}
