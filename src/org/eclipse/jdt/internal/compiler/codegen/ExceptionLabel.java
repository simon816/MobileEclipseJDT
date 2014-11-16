package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.Label;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public class ExceptionLabel extends Label {

    public int[] ranges;

    public int count;

    public TypeBinding exceptionType;

    public ExceptionLabel(CodeStream var1, TypeBinding var2) {
        super(var1);
        this.ranges = new int[] { -1, -1};
        this.count = 0;
        this.exceptionType = var2;
    }

    public void method_447() {
        this.codeStream.registerExceptionHandler(this);
        this.position = this.codeStream.getPosition();
    }

    public void method_448() {
        int var1 = this.codeStream.field_1208;
        if (this.ranges[this.count - 1] == var1) {
            --this.count;
        } else {
            this.ranges[this.count++] = var1;
        }
    }

    public void method_449() {
        int var1 = this.codeStream.field_1208;
        if (this.count > 0 && this.ranges[this.count - 1] == var1) {
            --this.count;
        } else {
            int var2;
            if (this.count == (var2 = this.ranges.length)) {
                System.arraycopy(this.ranges, 0, this.ranges = new int[var2 * 2], 0, var2);
            }
            this.ranges[this.count++] = var1;
        }
    }

    public String toString() {
        String var1 = this.getClass().getName();
        var1 = var1.substring(var1.lastIndexOf(46) + 1);
        StringBuffer var2 = new StringBuffer(var1);
        var2.append('@').append(Integer.toHexString(this.hashCode()));
        var2.append("(type=").append(this.exceptionType == null ? CharOperation.NO_CHAR : this.exceptionType.readableName());
        var2.append(", position=").append(this.position);
        var2.append(", ranges = ");
        if (this.count == 0) {
            var2.append("[]");
        } else {
            for (int var3 = 0; var3 < this.count; ++var3) {
                if ((var3 & 1) == 0) {
                    var2.append("[").append(this.ranges[var3]);
                } else {
                    var2.append(",").append(this.ranges[var3]).append("]");
                }
            }
            if ((this.count & 1) == 1) {
                var2.append(",?]");
            }
        }
        var2.append(')');
        return var2.toString();
    }
}
