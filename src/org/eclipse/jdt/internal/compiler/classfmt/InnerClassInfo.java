package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFileStruct;
import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;

public class InnerClassInfo extends ClassFileStruct implements IBinaryNestedType {

    int field_818;

    int field_819;

    int field_820;

    private char[] field_821;

    private char[] field_822;

    private char[] field_823;

    private int accessFlags;

    private boolean field_825;

    private boolean field_826;

    private boolean field_827;

    public InnerClassInfo(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_818 = -1;
        this.field_819 = -1;
        this.field_820 = -1;
        this.accessFlags = -1;
        this.field_825 = false;
        this.field_826 = false;
        this.field_827 = false;
        this.field_818 = this.method_1104(0);
        this.field_819 = this.method_1104(2);
        this.field_820 = this.method_1104(4);
    }

    public char[] method_1116() {
        if (!this.field_826) {
            this.field_826 = true;
            if (this.field_819 != 0) {
                int var1 = this.constantPoolOffsets[this.method_1104(this.constantPoolOffsets[this.field_819] - this.structOffset + 1)] - this.structOffset;
                this.field_822 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
            }
        }
        return this.field_822;
    }

    public int getModifiers() {
        if (this.accessFlags == -1) {
            this.accessFlags = this.method_1104(6);
        }
        return this.accessFlags;
    }

    public char[] method_68() {
        if (!this.field_825) {
            this.field_825 = true;
            if (this.field_818 != 0) {
                int var1 = this.constantPoolOffsets[this.field_818] - this.structOffset;
                int var2 = this.constantPoolOffsets[this.method_1104(var1 + 1)] - this.structOffset;
                this.field_821 = this.utf8At(var2 + 3, this.method_1104(var2 + 1));
            }
        }
        return this.field_821;
    }

    public char[] method_1118() {
        if (!this.field_827) {
            this.field_827 = true;
            if (this.field_820 != 0) {
                int var1 = this.constantPoolOffsets[this.field_820] - this.structOffset;
                this.field_823 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
            }
        }
        return this.field_823;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        if (this.method_68() != null) {
            var1.append(this.method_68());
        }
        var1.append("\n");
        if (this.method_1116() != null) {
            var1.append(this.method_1116());
        }
        var1.append("\n");
        if (this.method_1118() != null) {
            var1.append(this.method_1118());
        }
        return var1.toString();
    }

    void initialize() {
        this.getModifiers();
        this.method_68();
        this.method_1118();
        this.method_1116();
        this.reset();
    }
}
