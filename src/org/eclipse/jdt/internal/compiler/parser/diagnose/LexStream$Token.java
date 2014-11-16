package org.eclipse.jdt.internal.compiler.parser.diagnose;

public class LexStream$Token {

    int field_920;

    char[] name;

    int field_922;

    int field_923;

    int field_924;

    int field_925;

    public LexStream$Token() {
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(this.name).append('[').append(this.field_920).append(']');
        var1.append('{').append(this.field_922).append(',').append(this.field_923).append('}').append(this.field_924);
        return var1.toString();
    }
}
