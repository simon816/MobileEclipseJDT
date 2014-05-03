package i;

// $FF: renamed from: i.k
public class class_274 {

    // $FF: renamed from: a float[]
    private float[] field_1515;
    // $FF: renamed from: a int[]
    private int[] field_1516;
    // $FF: renamed from: a int
    private int field_1517;

    // $FF: renamed from: <init> () void
    public class_274() {
        this(13);
    }

    // $FF: renamed from: <init> (int) void
    public class_274(int var1) {
        this.field_1517 = 0;
        this.field_1515 = new float[var1];
        this.field_1516 = new int[var1];
    }

    // $FF: renamed from: a () void
    public void method_2483() {
        int var1 = this.field_1515.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_1517 = 0;
                return;
            }
            this.field_1515[var1] = 0.0F;
            this.field_1516[var1] = 0;
        }
    }

    // $FF: renamed from: a (float, int) int
    public int method_2484(float var1, int var2) {
        int var3;
        int var4;
        if (var1 == 0.0F) {
            var3 = 0;
            for (var4 = this.field_1517; var3 < var4; ++var3) {
                if (this.field_1515[var3] == 0.0F) {
                    int var5 = Float.floatToIntBits(var1);
                    int var6 = Float.floatToIntBits(this.field_1515[var3]);
                    if (var5 == Integer.MIN_VALUE && var6 == Integer.MIN_VALUE) {
                        return this.field_1516[var3];
                    }
                    if (var5 == 0 && var6 == 0) {
                        return this.field_1516[var3];
                    }
                }
            }
        } else {
            var3 = 0;
            for (var4 = this.field_1517; var3 < var4; ++var3) {
                if (this.field_1515[var3] == var1) {
                    return this.field_1516[var3];
                }
            }
        }
        if (this.field_1517 == this.field_1515.length) {
            System.arraycopy(this.field_1515, 0, this.field_1515 = new float[this.field_1517 * 2], 0, this.field_1517);
            System.arraycopy(this.field_1516, 0, this.field_1516 = new int[this.field_1517 * 2], 0, this.field_1517);
        }
        this.field_1515[this.field_1517] = var1;
        this.field_1516[this.field_1517] = var2;
        ++this.field_1517;
        return -var2;
    }

    public String toString() {
        int var1 = this.field_1517;
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.field_1515[var3] != 0.0F || this.field_1515[var3] == 0.0F && this.field_1516[var3] != 0) {
                var2.append(this.field_1515[var3]).append("->").append(this.field_1516[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
