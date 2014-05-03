package h;

import h.class_164;
import h.class_89;

// $FF: renamed from: h.z
public class class_91 extends class_89 {

    // $FF: renamed from: a char[][]
    public char[][] field_467;
    // $FF: renamed from: a long[]
    public long[] field_468;
    // $FF: renamed from: a int
    public int field_469;
    // $FF: renamed from: b int
    public int field_470;
    // $FF: renamed from: c int
    public int field_471;
    // $FF: renamed from: d int
    public int field_472;
    // $FF: renamed from: a h.cn[]
    public class_164[] field_473;

    // $FF: renamed from: <init> (char[][], long[], boolean, int) void
    public class_91(char[][] var1, long[] var2, boolean var3, int var4) {
        this.field_467 = var1;
        this.field_468 = var2;
        if (var3) {
            this.field_446 |= 131072;
        }
        this.field_445 = (int)(var2[var2.length - 1] & -1L);
        this.field_444 = (int)(var2[0] >>> 32);
        this.field_472 = var4;
    }

    // $FF: renamed from: a () boolean
    public boolean method_781() {
        return (this.field_472 & 8) != 0;
    }

    // $FF: renamed from: a (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_757(int var1, StringBuffer var2) {
        return this.method_782(var1, var2, true);
    }

    // $FF: renamed from: a (int, java.lang.StringBuffer, boolean) java.lang.StringBuffer
    public StringBuffer method_782(int var1, StringBuffer var2, boolean var3) {
        for (int var4 = 0; var4 < this.field_467.length; ++var4) {
            if (var4 > 0) {
                var2.append('.');
            }
            var2.append(this.field_467[var4]);
        }
        if (var3 && (this.field_446 & 131072) != 0) {
            var2.append(".*");
        }
        return var2;
    }
}
