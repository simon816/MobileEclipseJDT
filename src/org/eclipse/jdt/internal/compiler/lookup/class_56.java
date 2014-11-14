package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_54;
import org.eclipse.jdt.internal.compiler.lookup.class_55;
import org.eclipse.jdt.internal.compiler.lookup.class_84;

public final class class_56 extends class_55 {

    public class_56(char[][] var1, class_84 var2, class_54 var3) {
        super(var1, var2, var3);
        this.field_178 |= 12L;
    }

    void method_332() {
        if (!this.method_226()) {
            if (!this.method_157()) {
                this.method_326(this.field_262);
            }
        }
    }

    public char[] method_134() {
        return this.field_202 != null ? this.field_202 : (this.field_202 = CharOperation.method_1357(this.method_137().method_134(), this.field_198, '$'));
    }

    public void method_100() {
        if ((this.field_178 & 17179869184L) == 0L) {
            super.method_100();
            if ((this.field_178 & 70368744177664L) == 0L) {
                class_43 var1;
                if (((var1 = this.method_137()).field_178 & 17179869184L) == 0L) {
                    var1.method_100();
                }
                if (var1.method_230()) {
                    this.field_199 |= 2097152;
                }
            }
        }
    }

    public String toString() {
        return "Member type : " + new String(this.method_179()) + " " + super.toString();
    }
}
