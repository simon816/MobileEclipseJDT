package org.eclipse.jdt.internal.compiler.classfmt;

public abstract class ClassFileStruct {

    byte[] reference;

    int[] constantPoolOffsets;

    int structOffset;

    public ClassFileStruct(byte[] var1, int[] var2, int var3) {
        this.reference = var1;
        this.constantPoolOffsets = var2;
        this.structOffset = var3;
    }

    public double doubleAt(int var1) {
        return Double.longBitsToDouble(this.method_1101(var1));
    }

    public float floatAt(int var1) {
        return Float.intBitsToFloat(this.method_1100(var1));
    }

    public int method_1100(int var1) {
        int var2 = var1 + this.structOffset;
        return (this.reference[var2++] & 255) << 24 | (this.reference[var2++] & 255) << 16 | ((this.reference[var2++] & 255) << 8) + (this.reference[var2] & 255);
    }

    public long method_1101(int var1) {
        int var2 = var1 + this.structOffset;
        return (long)(this.reference[var2++] & 255) << 56 | (long)(this.reference[var2++] & 255) << 48 | (long)(this.reference[var2++] & 255) << 40 | (long)(this.reference[var2++] & 255) << 32 | (long)(this.reference[var2++] & 255) << 24 | (long)(this.reference[var2++] & 255) << 16 | (long)(this.reference[var2++] & 255) << 8 | (long)(this.reference[var2++] & 255);
    }

    protected void reset() {
        this.reference = null;
        this.constantPoolOffsets = null;
    }

    public int method_1103(int var1) {
        return this.reference[var1 + this.structOffset] & 255;
    }

    public int method_1104(int var1) {
        int var2 = var1 + this.structOffset;
        return (this.reference[var2++] & 255) << 8 | this.reference[var2] & 255;
    }

    public long method_1105(int var1) {
        int var2 = var1 + this.structOffset;
        return ((long)this.reference[var2++] & 255L) << 24 | (long)((this.reference[var2++] & 255) << 16) | (long)((this.reference[var2++] & 255) << 8) | (long)(this.reference[var2] & 255);
    }

    public char[] utf8At(int var1, int var2) {
        int var3 = var2;
        char[] var4 = new char[var2];
        int var5 = 0;
        int var7;
        for (int var6 = this.structOffset + var1; var3 != 0; var4[var5++] = (char)var7) {
            var7 = this.reference[var6++] & 255;
            --var3;
            if ((128 & var7) != 0) {
                if ((var7 & 32) != 0) {
                    var3 -= 2;
                    var7 = (var7 & 15) << 12 | (this.reference[var6++] & 63) << 6 | this.reference[var6++] & 63;
                } else {
                    --var3;
                    var7 = (var7 & 31) << 6 | this.reference[var6++] & 63;
                }
            }
        }
        if (var5 != var2) {
            System.arraycopy(var4, 0, var4 = new char[var5], 0, var5);
        }
        return var4;
    }
}
