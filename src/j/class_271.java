package j;

import b.class_232;
import b.class_233;
import j.class_267;
import j.class_270;
import j.class_278;

// $FF: renamed from: j.k
public class class_271 extends class_270 {

    // $FF: renamed from: E char[]
    public static final char[] field_1301;
    // $FF: renamed from: a j.j
    private class_267 field_1302;
    // $FF: renamed from: e int[]
    private int[] field_1303;
    // $FF: renamed from: r int
    private int field_1304;
    // $FF: renamed from: F char[]
    private char[] field_1305;
    // $FF: renamed from: q boolean
    private boolean field_1306;
    // $FF: renamed from: r boolean
    private boolean field_1307;
    // $FF: renamed from: s int
    private int field_1308;
    // $FF: renamed from: p boolean
    public boolean field_1309;

    // $FF: renamed from: <init> (j.a, j.j) void
    public class_271(class_270 var1, class_267 var2) {
        super(false, var1.field_1236, var1.field_1292, var1.field_1223, var1.field_1224, var1.field_1252, var1.field_1253, var1.field_1254);
        this.field_1304 = -1;
        this.field_1305 = null;
        this.field_1306 = true;
        this.field_1307 = false;
        this.field_1308 = -1;
        this.field_1309 = true;
        this.method_2453(var2);
    }

    // $FF: renamed from: a (int, int, int) void
    public void method_2446(int var1, int var2, int var3) {
        this.method_2448(new int[] {var1}, var2, var3);
    }

    // $FF: renamed from: a (int[]) int[]
    private int[] method_2447(int[] var1) {
        int var2 = var1.length;
        int var3 = 0;
        for (int var4 = var2 / 2; var3 < var4; ++var3) {
            int var5 = var1[var3];
            var1[var3] = var1[var2 - var3 - 1];
            var1[var2 - var3 - 1] = var5;
        }
        return var1;
    }

    // $FF: renamed from: a (int[], int, int) void
    public void method_2448(int[] var1, int var2, int var3) {
        if (this.field_1309) {
            if (var2 <= -1 || class_278.field_1544[var2] == 0) {
                ++this.field_1302.field_1168;
                if (this.field_1302.field_1169 == null) {
                    this.field_1302.field_1169 = new int[10][];
                    this.field_1302.field_1170 = new int[10];
                    this.field_1302.field_1171 = new boolean[10];
                } else if (this.field_1302.field_1169.length == this.field_1302.field_1168) {
                    int var4 = this.field_1302.field_1169.length;
                    System.arraycopy(this.field_1302.field_1169, 0, this.field_1302.field_1169 = new int[var4 * 2][], 0, var4);
                    System.arraycopy(this.field_1302.field_1170, 0, this.field_1302.field_1170 = new int[var4 * 2], 0, var4);
                    System.arraycopy(this.field_1302.field_1171, 0, this.field_1302.field_1171 = new boolean[var4 * 2], 0, var4);
                }
                this.field_1302.field_1169[this.field_1302.field_1168] = this.method_2447(var1);
                this.field_1302.field_1170[this.field_1302.field_1168] = var3;
                this.field_1302.field_1171[this.field_1302.field_1168] = false;
            }
        }
    }

    // $FF: renamed from: b (int, int, int) void
    public void method_2449(int var1, int var2, int var3) {
        this.method_2450(new int[] {var1}, var2, var3);
    }

    // $FF: renamed from: b (int[], int, int) void
    public void method_2450(int[] var1, int var2, int var3) {
        if (this.field_1309) {
            ++this.field_1302.field_1172;
            if (this.field_1302.field_1174 == null) {
                this.field_1302.field_1173 = new int[10][];
                this.field_1302.field_1174 = new int[10];
                this.field_1302.field_1175 = new int[10];
                this.field_1302.field_1176 = new boolean[10];
            } else if (this.field_1302.field_1174.length == this.field_1302.field_1172) {
                int var4 = this.field_1302.field_1174.length;
                System.arraycopy(this.field_1302.field_1173, 0, this.field_1302.field_1173 = new int[var4 * 2][], 0, var4);
                System.arraycopy(this.field_1302.field_1174, 0, this.field_1302.field_1174 = new int[var4 * 2], 0, var4);
                System.arraycopy(this.field_1302.field_1175, 0, this.field_1302.field_1175 = new int[var4 * 2], 0, var4);
                System.arraycopy(this.field_1302.field_1176, 0, this.field_1302.field_1176 = new boolean[var4 * 2], 0, var4);
            }
            this.field_1302.field_1173[this.field_1302.field_1172] = this.method_2447(var1);
            this.field_1302.field_1174[this.field_1302.field_1172] = var2;
            this.field_1302.field_1175[this.field_1302.field_1172] = var3;
            this.field_1302.field_1176[this.field_1302.field_1172] = false;
        }
    }

    // $FF: renamed from: c (int, int) void
    public void method_2451(int var1, int var2) {
        if (this.field_1309) {
            ++this.field_1302.field_1177;
            if (this.field_1302.field_1178 == null) {
                this.field_1302.field_1178 = new int[10];
                this.field_1302.field_1179 = new int[10];
                this.field_1302.field_1180 = new boolean[10];
            } else if (this.field_1302.field_1178.length == this.field_1302.field_1177) {
                int var3 = this.field_1302.field_1178.length;
                System.arraycopy(this.field_1302.field_1178, 0, this.field_1302.field_1178 = new int[var3 * 2], 0, var3);
                System.arraycopy(this.field_1302.field_1179, 0, this.field_1302.field_1179 = new int[var3 * 2], 0, var3);
                System.arraycopy(this.field_1302.field_1180, 0, this.field_1302.field_1180 = new boolean[var3 * 2], 0, var3);
            }
            this.field_1302.field_1178[this.field_1302.field_1177] = var1;
            this.field_1302.field_1179[this.field_1302.field_1177] = var2;
            this.field_1302.field_1180[this.field_1302.field_1177] = false;
        }
    }

    // $FF: renamed from: d () int
    public int method_2419() throws class_232 {
        int var1;
        if (this.field_1304 > -1) {
            var1 = this.field_1303[this.field_1304--];
            if (var1 == 26) {
                this.field_1305 = field_1301;
            } else {
                this.field_1305 = class_233.field_994;
            }
            return var1;
        } else {
            this.field_1305 = null;
            this.field_1307 = false;
            int var2;
            if (this.field_1302.field_1169 != null) {
                for (var1 = 0; var1 <= this.field_1302.field_1168; ++var1) {
                    if (this.field_1302.field_1170[var1] == this.field_1231 - 1 && var1 > this.field_1308) {
                        this.field_1302.field_1171[var1] = true;
                        this.field_1303 = this.field_1302.field_1169[var1];
                        this.field_1304 = this.field_1302.field_1169[var1].length - 1;
                        this.field_1306 = true;
                        this.field_1230 = this.field_1231;
                        this.field_1308 = var1;
                        var2 = this.field_1303[this.field_1304--];
                        if (var2 == 26) {
                            this.field_1305 = field_1301;
                        } else {
                            this.field_1305 = class_233.field_994;
                        }
                        return var2;
                    }
                }
                this.field_1308 = -1;
            }
            var1 = this.field_1231;
            var2 = super.method_2419();
            int var3;
            if (this.field_1302.field_1173 != null) {
                for (var3 = 0; var3 <= this.field_1302.field_1172; ++var3) {
                    if (this.field_1302.field_1174[var3] >= var1 && this.field_1302.field_1174[var3] <= this.field_1230 && this.field_1302.field_1175[var3] >= this.field_1231 - 1) {
                        this.field_1302.field_1176[var3] = true;
                        this.field_1303 = this.field_1302.field_1173[var3];
                        this.field_1304 = this.field_1302.field_1173[var3].length - 1;
                        this.field_1305 = field_1301;
                        this.field_1306 = false;
                        this.field_1231 = this.field_1302.field_1175[var3] + 1;
                        int var4 = this.field_1303[this.field_1304--];
                        if (var4 == 26) {
                            this.field_1305 = field_1301;
                        } else {
                            this.field_1305 = class_233.field_994;
                        }
                        return var4;
                    }
                }
            }
            if (this.field_1302.field_1178 != null) {
                for (var3 = 0; var3 <= this.field_1302.field_1177; ++var3) {
                    if (this.field_1302.field_1178[var3] >= var1 && this.field_1302.field_1178[var3] <= this.field_1230 && this.field_1302.field_1179[var3] >= this.field_1231 - 1) {
                        this.field_1302.field_1180[var3] = true;
                        this.field_1231 = this.field_1302.field_1179[var3] + 1;
                        this.field_1307 = false;
                        return this.method_2419();
                    }
                }
            }
            return var2;
        }
    }

    // $FF: renamed from: a () char[]
    public char[] method_2407() {
        return this.field_1305 != null ? this.field_1305 : super.method_2407();
    }

    // $FF: renamed from: c () char[]
    public char[] method_2410() {
        return this.field_1305 != null ? this.field_1305 : super.method_2410();
    }

    // $FF: renamed from: b () char[]
    public char[] method_2409() {
        return this.field_1305 != null ? this.field_1305 : super.method_2409();
    }

    // $FF: renamed from: a () j.j
    public class_267 method_2452() {
        return this.field_1302;
    }

    // $FF: renamed from: a (j.j) void
    public void method_2453(class_267 var1) {
        if (var1 == null) {
            class_267 var10001 = new class_267();
            this.field_1302 = var10001;
        } else {
            this.field_1302 = var1;
        }
    }

    // $FF: renamed from: a (int[]) void
    public void method_2454(int[] var1) {
        this.field_1303 = var1;
        this.field_1304 = var1.length - 1;
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_1301 = "$missing$".toCharArray();
    }
}
