package e;

// $FF: renamed from: e.g
public abstract class class_186 {

    // $FF: renamed from: a byte[]
    byte[] field_805;
    // $FF: renamed from: a int[]
    int[] field_806;
    // $FF: renamed from: b int
    int field_807;

    // $FF: renamed from: <init> (byte[], int[], int) void
    public class_186(byte[] var1, int[] var2, int var3) {
        this.field_805 = var1;
        this.field_806 = var2;
        this.field_807 = var3;
    }

    // $FF: renamed from: a (int) double
    public double method_1098(int var1) {
        return Double.longBitsToDouble(this.method_1101(var1));
    }

    // $FF: renamed from: a (int) float
    public float method_1099(int var1) {
        return Float.intBitsToFloat(this.method_1100(var1));
    }

    // $FF: renamed from: a (int) int
    public int method_1100(int var1) {
        int var2 = var1 + this.field_807;
        return (this.field_805[var2++] & 255) << 24 | (this.field_805[var2++] & 255) << 16 | ((this.field_805[var2++] & 255) << 8) + (this.field_805[var2] & 255);
    }

    // $FF: renamed from: a (int) long
    public long method_1101(int var1) {
        int var2 = var1 + this.field_807;
        return (long)(this.field_805[var2++] & 255) << 56 | (long)(this.field_805[var2++] & 255) << 48 | (long)(this.field_805[var2++] & 255) << 40 | (long)(this.field_805[var2++] & 255) << 32 | (long)(this.field_805[var2++] & 255) << 24 | (long)(this.field_805[var2++] & 255) << 16 | (long)(this.field_805[var2++] & 255) << 8 | (long)(this.field_805[var2++] & 255);
    }

    // $FF: renamed from: b () void
    protected void method_1102() {
        this.field_805 = null;
        this.field_806 = null;
    }

    // $FF: renamed from: b (int) int
    public int method_1103(int var1) {
        return this.field_805[var1 + this.field_807] & 255;
    }

    // $FF: renamed from: c (int) int
    public int method_1104(int var1) {
        int var2 = var1 + this.field_807;
        return (this.field_805[var2++] & 255) << 8 | this.field_805[var2] & 255;
    }

    // $FF: renamed from: b (int) long
    public long method_1105(int var1) {
        int var2 = var1 + this.field_807;
        return ((long)this.field_805[var2++] & 255L) << 24 | (long)((this.field_805[var2++] & 255) << 16) | (long)((this.field_805[var2++] & 255) << 8) | (long)(this.field_805[var2] & 255);
    }

    // $FF: renamed from: a (int, int) char[]
    public char[] method_1106(int var1, int var2) {
        int var3 = var2;
        char[] var4 = new char[var2];
        int var5 = 0;
        int var7;
        for (int var6 = this.field_807 + var1; var3 != 0; var4[var5++] = (char)var7) {
            var7 = this.field_805[var6++] & 255;
            --var3;
            if ((128 & var7) != 0) {
                if ((var7 & 32) != 0) {
                    var3 -= 2;
                    var7 = (var7 & 15) << 12 | (this.field_805[var6++] & 63) << 6 | this.field_805[var6++] & 63;
                } else {
                    --var3;
                    var7 = (var7 & 31) << 6 | this.field_805[var6++] & 63;
                }
            }
        }
        if (var5 != var2) {
            System.arraycopy(var4, 0, var4 = new char[var5], 0, var5);
        }
        return var4;
    }
}