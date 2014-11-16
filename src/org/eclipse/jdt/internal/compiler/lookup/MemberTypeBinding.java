package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

public final class MemberTypeBinding extends NestedTypeBinding {

    public MemberTypeBinding(char[][] var1, ClassScope var2, SourceTypeBinding var3) {
        super(var1, var2, var3);
        this.tagBits |= 12L;
    }

    void checkSyntheticArgsAndFields() {
        if (!this.method_226()) {
            if (!this.method_157()) {
                this.method_326(this.enclosingType);
            }
        }
    }

    public char[] constantPoolName() {
        return this.field_202 != null ? this.field_202 : (this.field_202 = CharOperation.concat(this.enclosingType().constantPoolName(), this.sourceName, '$'));
    }

    public void initializeDeprecatedAnnotationTagBits() {
        if ((this.tagBits & 17179869184L) == 0L) {
            super.initializeDeprecatedAnnotationTagBits();
            if ((this.tagBits & 70368744177664L) == 0L) {
                ReferenceBinding var1;
                if (((var1 = this.enclosingType()).tagBits & 17179869184L) == 0L) {
                    var1.initializeDeprecatedAnnotationTagBits();
                }
                if (var1.method_230()) {
                    this.modifiers |= 2097152;
                }
            }
        }
    }

    public String toString() {
        return "Member type : " + new String(this.method_179()) + " " + super.toString();
    }
}
