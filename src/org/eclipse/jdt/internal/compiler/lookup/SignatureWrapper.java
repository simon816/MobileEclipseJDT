package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;

public class SignatureWrapper {

    public char[] signature;

    public int field_873;

    public int field_874;

    public int field_875;

    public SignatureWrapper(char[] var1) {
        this.signature = var1;
        this.field_873 = 0;
        this.field_874 = this.field_875 = -1;
    }

    public boolean atEnd() {
        return this.field_873 < 0 || this.field_873 >= this.signature.length;
    }

    public int computeEnd() {
        int var1;
        for (var1 = this.field_873; this.signature[var1] == 91; ++var1) {
            ;
        }
        switch (this.signature[var1]) {
            case 76:
            case 84:
                this.field_874 = CharOperation.method_1374(';', this.signature, this.field_873);
                if (this.field_875 <= this.field_873) {
                    this.field_875 = CharOperation.method_1374('<', this.signature, this.field_873);
                }
                if (this.field_875 > this.field_873 && this.field_875 < this.field_874) {
                    this.field_874 = this.field_875;
                } else if (this.field_874 == -1) {
                    this.field_874 = this.signature.length + 1;
                }
                break;
            default:
                this.field_874 = this.field_873;
        }
        this.field_873 = this.field_874 + 1;
        return this.field_874;
    }

    public char[] nextWord() {
        this.field_874 = CharOperation.method_1374(';', this.signature, this.field_873);
        if (this.field_875 <= this.field_873) {
            this.field_875 = CharOperation.method_1374('<', this.signature, this.field_873);
        }
        int var1 = CharOperation.method_1374('.', this.signature, this.field_873);
        if (this.field_875 > this.field_873 && this.field_875 < this.field_874) {
            this.field_874 = this.field_875;
        }
        if (var1 > this.field_873 && var1 < this.field_874) {
            this.field_874 = var1;
        }
        return CharOperation.subarray(this.signature, this.field_873, this.field_873 = this.field_874);
    }

    public String toString() {
        return new String(this.signature) + " @ " + this.field_873;
    }
}
