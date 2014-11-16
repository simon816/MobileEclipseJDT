package org.eclipse.jdt.internal.compiler.env;

public class ClassSignature {

    char[] className;

    public ClassSignature(char[] var1) {
        this.className = var1;
    }

    public char[] getTypeName() {
        return this.className;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(this.className);
        var1.append(".class");
        return var1.toString();
    }
}
