package n;

import b.class_235;

// $FF: renamed from: n.b
public class class_236 extends class_235 {

    // $FF: renamed from: a java.lang.String
    private String field_997;
    // $FF: renamed from: a int
    private int field_998;
    // $FF: renamed from: b int
    private int field_999;
    // $FF: renamed from: c int
    private int field_1000;
    // $FF: renamed from: d int
    private int field_1001;
    // $FF: renamed from: e int
    private int field_1002;
    // $FF: renamed from: f int
    private int field_1003;
    // $FF: renamed from: a java.lang.String[]
    private String[] field_1004;
    // $FF: renamed from: b java.lang.String
    private String field_1005;
    // $FF: renamed from: a java.lang.Object[]
    public static final Object[] field_1006;

    // $FF: renamed from: <init> (java.lang.String, java.lang.String, int, java.lang.String[], int, int, int, int, int) void
    public class_236(String var1, String var2, int var3, String[] var4, int var5, int var6, int var7, int var8, int var9) {
        this.field_997 = var1;
        this.field_1005 = var2;
        this.field_998 = var3;
        this.field_1004 = var4;
        this.field_1003 = var5;
        this.field_999 = var6;
        this.field_1000 = var7;
        this.field_1001 = var8;
        this.field_1002 = var9;
    }

    // $FF: renamed from: a () java.lang.String[]
    public String[] method_9() {
        return this.field_1004;
    }

    // $FF: renamed from: a () int
    public int method_1398() {
        return this.field_998;
    }

    // $FF: renamed from: b () java.lang.String
    public String method_1404() {
        return this.field_1005;
    }

    // $FF: renamed from: a () java.lang.String
    public String method_1400() {
        return this.field_997;
    }

    // $FF: renamed from: c () int
    public int method_1402() {
        return this.field_1000;
    }

    // $FF: renamed from: d () int
    public int method_1403() {
        return this.field_1001;
    }

    // $FF: renamed from: b () int
    public int method_1401() {
        return this.field_999;
    }

    // $FF: renamed from: b () boolean
    public boolean method_1399() {
        return (this.field_1003 & 1) != 0;
    }

    // $FF: renamed from: a () boolean
    public boolean method_10() {
        return (this.field_1003 & 1) == 0;
    }

    // $FF: renamed from: a (java.lang.String) void
    public void method_1406(String var1) {
        this.field_997 = var1;
    }

    // $FF: renamed from: a (int) void
    public void method_11(int var1) {
        this.field_1000 = var1;
    }

    // $FF: renamed from: b (int) void
    public void method_12(int var1) {
        this.field_1001 = var1;
    }

    // $FF: renamed from: c (int) void
    public void method_13(int var1) {
        this.field_999 = var1;
    }

    public String toString() {
        String var1 = "Pb(" + (this.field_998 & 16777215) + ") ";
        if (this.field_1005 != null) {
            var1 = var1 + this.field_1005;
        } else if (this.field_1004 != null) {
            for (int var2 = 0; var2 < this.field_1004.length; ++var2) {
                var1 = var1 + " " + this.field_1004[var2];
            }
        }
        return var1;
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_1006 = new Object[0];
    }
}
