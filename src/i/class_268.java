package i;

import a.class_331;
import b.CharOperation;
import b.class_235;
import c.class_284;
import c.class_288;
import f.Util;
import h.class_105;
import h.class_126;
import h.class_135;
import h.class_89;
import h.class_93;
import i.class_272;
import i.class_73;
import i.class_74;
import i.class_75;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_54;
import m.class_55;
import m.class_58;
import m.class_60;
import m.class_64;
import m.class_65;
import m.class_66;
import m.class_67;
import m.class_83;
import m.class_84;
import m.class_86;
import m.class_87;
import n.class_244;

public class class_268 {

    public static class_67[] field_1181;

    static class_73[] field_1182;

    static class_74[] field_1183;

    static class_65[] field_1184;

    static class_65[] field_1185;

    public static final class_284 field_1186;

    public int field_1187;

    public byte[] field_1188;

    public class_288 field_1189;

    public int field_1190;

    public class_272 field_1191;

    public int field_1192;

    public class_73[] field_1193;

    public int field_1194;

    public int field_1195;

    public class_74[] field_1196;

    public int field_1197;

    public int field_1198;

    public int[] field_1199;

    public int field_1200;

    public int field_1201;

    public class_65[] field_1202;

    public int field_1203;

    public int field_1204;

    public class_93 field_1205;

    public int[] field_1206;

    public int field_1207;

    public int field_1208;

    public boolean field_1209;

    public int field_1210;

    public int field_1211;

    public int field_1212;

    protected long field_1213;

    public class_65[] field_1214;

    int field_1215;

    public boolean field_1216;

    public static int method_2081(int[] var0, int var1, int var2) {
        int var3 = 0;
        int var4 = var1 - 2;
        int var5 = 0;
        while (var3 <= var4) {
            var5 = (var3 + var4) / 2;
            if ((var5 & 1) != 0) {
                --var5;
            }
            int var6 = var0[var5];
            if (var2 < var6) {
                var4 = var5 - 2;
            } else {
                if (var2 <= var6) {
                    return -1;
                }
                var3 = var5 + 2;
            }
        }
        if (var2 < var0[var5]) {
            return var5;
        } else {
            return var5 + 2;
        }
    }

    public static final void method_2082(int[] var0, int var1, int var2, int[] var3) {
        int var4 = var1;
        int var5 = var2;
        if (var2 > var1) {
            int var6 = var0[var1 + (var2 - var1) / 2];
            while (var4 <= var5) {
                while (var4 < var2 && var0[var4] < var6) {
                    ++var4;
                }
                while (var5 > var1 && var0[var5] > var6) {
                    --var5;
                }
                if (var4 <= var5) {
                    method_2083(var0, var4, var5, var3);
                    ++var4;
                    --var5;
                }
            }
            if (var1 < var5) {
                method_2082(var0, var1, var5, var3);
            }
            if (var4 < var2) {
                method_2082(var0, var4, var2, var3);
            }
        }
    }

    private static final void method_2083(int[] var0, int var1, int var2, int[] var3) {
        int var4 = var0[var1];
        var0[var1] = var0[var2];
        var0[var2] = var4;
        var4 = var3[var2];
        var3[var2] = var3[var1];
        var3[var1] = var4;
    }

    public class_268(class_288 var1) {
        this.field_1193 = new class_73[5];
        this.field_1196 = new class_74[5];
        this.field_1202 = new class_65[10];
        this.field_1206 = new int[24];
        this.field_1214 = new class_65[10];
        this.field_1216 = false;
        this.field_1213 = var1.field_1731;
        this.field_1195 = var1.field_1728;
        if ((var1.field_1728 & 2) != 0) {
            this.field_1199 = var1.field_1729.field_258.method_645().field_455.method_2921();
        }
    }

    public void method_2085() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 50;
    }

    public void method_2086() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 83;
    }

    public void method_2087() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 1;
    }

    public void method_2088(class_83 var1, int var2) {
        if ((this.field_1195 & 28) != 0) {
            for (int var3 = 0; var3 < this.field_1215; ++var3) {
                class_65 var4 = this.field_1214[var3];
                if (var4 != null && this.method_2286(var1, var2, var4) && (var4.field_311 == 0 || var4.field_310[(var4.field_311 - 1 << 1) + 1] != -1)) {
                    var4.method_415(this.field_1208);
                }
            }
        }
    }

    public void method_2089(class_74 var1) {
        if (this.field_1192 == this.field_1196.length) {
            System.arraycopy(this.field_1196, 0, this.field_1196 = new class_74[this.field_1192 + 5], 0, this.field_1192);
        }
        this.field_1196[this.field_1192++] = var1;
    }

    public void method_2090(class_65 var1) {
        if ((this.field_1195 & 28) != 0) {
            if (this.field_1215 >= this.field_1214.length) {
                System.arraycopy(this.field_1214, 0, this.field_1214 = new class_65[this.field_1215 * 2], 0, this.field_1215);
            }
            this.field_1214[this.field_1215++] = var1;
        }
    }

    public void method_2091(class_65 var1) {}

    public void method_2092(int var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 <= var1) {
            this.field_1204 = var1 + 1;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 25;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 25;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2093() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 == 0) {
            this.field_1204 = 1;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 42;
    }

    public void method_2094() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 <= 1) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 43;
    }

    public void method_2095() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 <= 2) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 44;
    }

    public void method_2096() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 <= 3) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 45;
    }

    public void method_2097(class_40 var1) {
        this.field_1192 = 0;
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -67;
        this.method_2387(this.field_1191.method_2467(var1));
    }

    public void method_2098() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -80;
        this.field_1198 = this.field_1208;
    }

    public void method_2099(int var1) {
        switch (var1) {
            case 2:
                this.method_2111();
                break;
            case 3:
            case 5:
                this.method_2108();
                break;
            case 4:
                this.method_2372();
                break;
            case 6:
            default:
                this.method_2085();
                break;
            case 7:
                this.method_2303();
                break;
            case 8:
                this.method_2118();
                break;
            case 9:
                this.method_2153();
                break;
            case 10:
                this.method_2218();
        }
    }

    public void method_2100(int var1, boolean var2) {
        switch (var1) {
            case 2:
                if (var2) {
                    this.method_2143();
                }
                this.method_2112();
                break;
            case 3:
            case 5:
                if (var2) {
                    this.method_2143();
                }
                this.method_2109();
                break;
            case 4:
                if (var2) {
                    this.method_2143();
                }
                this.method_2373();
                break;
            case 6:
            default:
                if (var2) {
                    this.method_2143();
                }
                this.method_2086();
                break;
            case 7:
                if (var2) {
                    this.method_2146();
                }
                this.method_2305();
                break;
            case 8:
                if (var2) {
                    this.method_2146();
                }
                this.method_2119();
                break;
            case 9:
                if (var2) {
                    this.method_2143();
                }
                this.method_2154();
                break;
            case 10:
                if (var2) {
                    this.method_2143();
                }
                this.method_2220();
        }
    }

    public void method_2101() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -66;
    }

    public void method_2102(int var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= var1) {
            this.field_1204 = var1 + 1;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 58;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 58;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2103() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 == 0) {
            this.field_1204 = 1;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 75;
    }

    public void method_2104() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 1) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 76;
    }

    public void method_2105() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 2) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 77;
    }

    public void method_2106() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 3) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 78;
    }

    public void method_2107() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -65;
        this.field_1198 = this.field_1208;
    }

    public void method_2108() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 51;
    }

    public void method_2109() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 84;
    }

    public void method_2110(byte var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 1 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1208 += 2;
        this.field_1188[this.field_1190++] = 16;
        this.field_1188[this.field_1190++] = var1;
    }

    public void method_2111() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 52;
    }

    public void method_2112() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 85;
    }

    public void method_2113(class_40 var1) {
        this.field_1192 = 0;
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -64;
        this.method_2387(this.field_1191.method_2467(var1));
    }

    public void method_2114() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -112;
    }

    public void method_2115() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -114;
    }

    public void method_2116() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -113;
    }

    public void method_2117() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 99;
    }

    public void method_2118() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 49;
    }

    public void method_2119() {
        this.field_1192 = 0;
        this.field_1210 -= 4;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 82;
    }

    public void method_2120() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -104;
    }

    public void method_2121() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -105;
    }

    public void method_2122() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 14;
    }

    public void method_2123() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 15;
    }

    public void method_2124() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 111;
    }

    public void method_2125(int var1) {
        this.field_1210 -= var1;
    }

    public void method_2126(int var1) {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 < var1 + 2) {
            this.field_1204 = var1 + 2;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 24;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 24;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2127() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 < 2) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 38;
    }

    public void method_2128() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 < 3) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 39;
    }

    public void method_2129() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 < 4) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 40;
    }

    public void method_2130() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1204 < 5) {
            this.field_1204 = 5;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 41;
    }

    public void method_2131() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 107;
    }

    public void method_2132() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 119;
    }

    public void method_2133() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 115;
    }

    public void method_2134() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -81;
        this.field_1198 = this.field_1208;
    }

    public void method_2135(int var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 <= var1 + 1) {
            this.field_1204 = var1 + 2;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 57;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 57;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2136() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 2) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 71;
    }

    public void method_2137() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 3) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 72;
    }

    public void method_2138() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 4) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 73;
    }

    public void method_2139() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 5) {
            this.field_1204 = 5;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 74;
    }

    public void method_2140() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 103;
    }

    public void method_2141() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 89;
    }

    public void method_2142() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 90;
    }

    public void method_2143() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 91;
    }

    public void method_2144() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 92;
    }

    public void method_2145() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 93;
    }

    public void method_2146() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 94;
    }

    public void method_2147(class_86 var1) {
        if ((this.field_1195 & 28) != 0) {
            int var2 = this.field_1215 - 1;
            while (var2 >= 0) {
                class_65 var3 = this.field_1214[var2];
                if (var3 != null && var3.field_308 == var1) {
                    if (var3.field_311 > 0) {
                        var3.method_414(this.field_1208);
                    }
                    this.field_1214[var2--] = null;
                } else {
                    --var2;
                }
            }
        }
    }

    public void method_2148(class_86 var1, class_65 var2) {
        if ((this.field_1195 & 28) != 0) {
            int var3 = this.field_1215 - 1;
            while (var3 >= 0) {
                class_65 var4 = this.field_1214[var3];
                if (var4 != null && var4.field_308 == var1 && var4 != var2) {
                    if (var4.field_311 > 0) {
                        var4.method_414(this.field_1208);
                    }
                    this.field_1214[var3--] = null;
                } else {
                    --var3;
                }
            }
        }
    }

    public void method_2149() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -115;
    }

    public void method_2150() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -117;
    }

    public void method_2151() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -116;
    }

    public void method_2152() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 98;
    }

    public void method_2153() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 48;
    }

    public void method_2154() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 81;
    }

    public void method_2155() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -106;
    }

    public void method_2156() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -107;
    }

    public void method_2157() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 11;
    }

    public void method_2158() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 12;
    }

    public void method_2159() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 13;
    }

    public void method_2160() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 110;
    }

    public void method_2161(int var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= var1) {
            this.field_1204 = var1 + 1;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 23;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 23;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2162() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 == 0) {
            this.field_1204 = 1;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 34;
    }

    public void method_2163() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 1) {
            this.field_1204 = 2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 35;
    }

    public void method_2164() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 2) {
            this.field_1204 = 3;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 36;
    }

    public void method_2165() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 3) {
            this.field_1204 = 4;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 37;
    }

    public void method_2166() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 106;
    }

    public void method_2167() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 118;
    }

    public void method_2168() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 114;
    }

    public void method_2169() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -82;
        this.field_1198 = this.field_1208;
    }

    public void method_2170(int var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= var1) {
            this.field_1204 = var1 + 1;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 56;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 56;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2171() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 == 0) {
            this.field_1204 = 1;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 67;
    }

    public void method_2172() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 1) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 68;
    }

    public void method_2173() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 2) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 69;
    }

    public void method_2174() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 3) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 70;
    }

    public void method_2175() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 102;
    }

    public void method_2176(int var1) {
        switch (var1) {
            case 2:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 1, 1, class_272.field_1409, class_272.field_1497, class_272.field_1339);
                } else {
                    this.method_2350(var1);
                    this.method_2142();
                    this.method_2377();
                    this.method_2258(-73, 1, 0, class_272.field_1409, class_272.field_1394, class_272.field_1340);
                }
                break;
            case 3:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 1, 1, class_272.field_1408, class_272.field_1497, class_272.field_1335);
                } else {
                    this.method_2350(var1);
                    this.method_2142();
                    this.method_2377();
                    this.method_2258(-73, 1, 0, class_272.field_1408, class_272.field_1394, class_272.field_1336);
                }
                break;
            case 4:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 1, 1, class_272.field_1429, class_272.field_1497, class_272.field_1473);
                } else {
                    this.method_2350(var1);
                    this.method_2142();
                    this.method_2377();
                    this.method_2258(-73, 1, 0, class_272.field_1429, class_272.field_1394, class_272.field_1472);
                }
                break;
            case 5:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 1, 1, class_272.field_1407, class_272.field_1497, class_272.field_1331);
                } else {
                    this.method_2350(var1);
                    this.method_2142();
                    this.method_2377();
                    this.method_2258(-73, 1, 0, class_272.field_1407, class_272.field_1394, class_272.field_1332);
                }
            case 6:
            default:
                break;
            case 7:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 2, 1, class_272.field_1419, class_272.field_1497, class_272.field_1440);
                } else {
                    this.method_2350(var1);
                    this.method_2143();
                    this.method_2143();
                    this.method_2352();
                    this.method_2258(-73, 2, 0, class_272.field_1419, class_272.field_1394, class_272.field_1439);
                }
                break;
            case 8:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 2, 1, class_272.field_1413, class_272.field_1497, class_272.field_1349);
                } else {
                    this.method_2350(var1);
                    this.method_2143();
                    this.method_2143();
                    this.method_2352();
                    this.method_2258(-73, 2, 0, class_272.field_1413, class_272.field_1394, class_272.field_1348);
                }
                break;
            case 9:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 1, 1, class_272.field_1417, class_272.field_1497, class_272.field_1355);
                } else {
                    this.method_2350(var1);
                    this.method_2142();
                    this.method_2377();
                    this.method_2258(-73, 1, 0, class_272.field_1417, class_272.field_1394, class_272.field_1354);
                }
                break;
            case 10:
                if (this.field_1213 >= 3211264L) {
                    this.method_2258(-72, 1, 1, class_272.field_1418, class_272.field_1497, class_272.field_1398);
                } else {
                    this.method_2350(var1);
                    this.method_2142();
                    this.method_2377();
                    this.method_2258(-73, 1, 0, class_272.field_1418, class_272.field_1394, class_272.field_1395);
                }
        }
    }

    public void method_2177(class_40 var1, class_67 var2) {
        if (var1.method_148() && var1 != class_40.field_187) {
            this.method_2208(var1.field_177);
        } else {
            if (this.field_1213 >= 3211264L) {
                this.method_2312(var1);
            } else {
                class_74 var10000 = new class_74(this);
                class_74 var3 = var10000;
                if (var2 != null) {
                    this.method_2207(var2);
                    this.method_2141();
                    this.method_2243(var3);
                    this.method_2352();
                }
                class_73 var6 = new class_73(this, class_40.field_187);
                class_73 var4 = var6;
                var4.method_449();
                this.method_2311(var1 == class_40.field_187 ? "java.lang.Object" : String.valueOf(var1.method_134()).replace('/', '.'));
                this.method_2259();
                var4.method_448();
                if (var2 != null) {
                    this.method_2141();
                    this.method_2357(var2);
                }
                this.method_2209(var3);
                int var5 = this.field_1210;
                this.method_2355(class_40.field_187);
                var4.method_447();
                this.method_2348();
                this.method_2142();
                this.method_2377();
                this.method_2281();
                this.method_2270();
                this.method_2107();
                var3.method_458();
                this.field_1210 = var5;
            }
        }
    }

    public final void method_2178(String var1) {
        this.method_2347();
        this.method_2141();
        this.method_2311(var1);
        this.method_2267();
        this.method_2107();
    }

    public void method_2179(class_331 var1, int var2) {
        int var3 = (var2 & 255) >> 4;
        if (var3 == 0) {
            var3 = var1.method_3288();
        }
        switch (var3) {
            case 2:
                this.method_2185(var1.method_3260());
                break;
            case 3:
                this.method_2184(var1.method_3258());
                break;
            case 4:
                this.method_2190(var1.method_3286());
                break;
            case 5:
                this.method_2183(var1.method_3257());
            case 6:
            default:
                break;
            case 7:
                this.method_2189(var1.method_3285());
                break;
            case 8:
                this.method_2186(var1.method_3281());
                break;
            case 9:
                this.method_2187(var1.method_3282());
                break;
            case 10:
                this.method_2188(var1.method_3284());
                break;
            case 11:
                this.method_2311(var1.method_3287());
        }
        if ((var2 & 512) != 0) {
            this.method_2176(var3);
        }
    }

    private void method_2180(byte var1, int var2, char[] var3, char[] var4, char[] var5) {
        this.field_1192 = 0;
        switch (var1) {
            case -78:
                if (var2 == 2) {
                    this.field_1210 += 2;
                } else {
                    ++this.field_1210;
                }
                break;
            case -77:
                if (var2 == 2) {
                    this.field_1210 -= 2;
                } else {
                    --this.field_1210;
                }
                break;
            case -76:
                if (var2 == 2) {
                    ++this.field_1210;
                }
                break;
            case -75:
                if (var2 == 2) {
                    this.field_1210 -= 3;
                } else {
                    this.field_1210 -= 2;
                }
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = var1;
        this.method_2387(this.field_1191.method_2471(var3, var4, var5));
    }

    private void method_2181(byte var1, int var2, class_43 var3, char[] var4, class_40 var5) {
        if (var3.method_160()) {
            this.field_1189.method_3012(var3);
        }
        class_40 var6 = var5.method_173();
        if (var6.method_160()) {
            this.field_1189.method_3012(var6);
        }
        this.method_2180(var1, var2, var3.method_134(), var4, var5.method_178());
    }

    public void method_2182(int var1) {
        int var2;
        if ((var1 & 1024) != 0) {
            var2 = var1 & 15;
            this.method_2203(var2);
        }
        switch (var1 & 255) {
            case 35:
            case 36:
            case 42:
                this.method_2212();
            case 37:
            case 38:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 51:
            case 53:
            case 54:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 117:
            case 118:
            case 119:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 133:
            case 134:
            case 136:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 149:
            case 150:
            case 153:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            default:
                break;
            case 39:
                this.method_2301();
                this.method_2212();
                break;
            case 40:
                this.method_2115();
                this.method_2212();
                break;
            case 41:
                this.method_2150();
                this.method_2212();
                break;
            case 50:
            case 52:
            case 58:
                this.method_2211();
                break;
            case 55:
                this.method_2301();
                this.method_2211();
                break;
            case 56:
                this.method_2115();
                this.method_2211();
                break;
            case 57:
                this.method_2150();
                this.method_2211();
                break;
            case 66:
            case 67:
            case 74:
                this.method_2216();
                break;
            case 71:
                this.method_2301();
                this.method_2216();
                break;
            case 72:
                this.method_2115();
                this.method_2216();
                break;
            case 73:
                this.method_2150();
                this.method_2216();
                break;
            case 114:
            case 115:
            case 116:
            case 122:
                this.method_2215();
                break;
            case 120:
                this.method_2116();
                break;
            case 121:
                this.method_2151();
                break;
            case 130:
            case 131:
            case 132:
            case 138:
                this.method_2213();
                break;
            case 135:
                this.method_2299();
                break;
            case 137:
                this.method_2149();
                break;
            case 146:
            case 147:
            case 148:
            case 154:
                this.method_2214();
                break;
            case 151:
                this.method_2300();
                break;
            case 152:
                this.method_2114();
                break;
            case 167:
                this.method_2301();
                break;
            case 168:
                this.method_2115();
                break;
            case 169:
                this.method_2150();
        }
        if ((var1 & 512) != 0) {
            var2 = (var1 & 255) >> 4;
            this.method_2176(var2);
        }
    }

    public void method_2183(boolean var1) {
        if (var1) {
            this.method_2222();
        } else {
            this.method_2221();
        }
    }

    public void method_2184(byte var1) {
        switch (var1) {
            case -1:
                this.method_2227();
                break;
            case 0:
                this.method_2221();
                break;
            case 1:
                this.method_2222();
                break;
            case 2:
                this.method_2223();
                break;
            case 3:
                this.method_2224();
                break;
            case 4:
                this.method_2225();
                break;
            case 5:
                this.method_2226();
                break;
            default:
                if (-128 <= var1 && var1 <= 127) {
                    this.method_2110(var1);
                    return;
                }
        }
    }

    public void method_2185(char var1) {
        switch (var1) {
            case 0:
                this.method_2221();
                break;
            case 1:
                this.method_2222();
                break;
            case 2:
                this.method_2223();
                break;
            case 3:
                this.method_2224();
                break;
            case 4:
                this.method_2225();
                break;
            case 5:
                this.method_2226();
                break;
            default:
                if (6 <= var1 && var1 <= 127) {
                    this.method_2110((byte)var1);
                    return;
                }
                if (128 <= var1 && var1 <= 32767) {
                    this.method_2375(var1);
                    return;
                }
                this.method_2310(var1);
        }
    }

    public void method_2186(double var1) {
        if (var1 == 0.0D) {
            if (Double.doubleToLongBits(var1) != 0L) {
                this.method_2313(var1);
            } else {
                this.method_2122();
            }
        } else if (var1 == 1.0D) {
            this.method_2123();
        } else {
            this.method_2313(var1);
        }
    }

    public void method_2187(float var1) {
        if (var1 == 0.0F) {
            if (Float.floatToIntBits(var1) != 0) {
                this.method_2309(var1);
            } else {
                this.method_2157();
            }
        } else if (var1 == 1.0F) {
            this.method_2158();
        } else if (var1 == 2.0F) {
            this.method_2159();
        } else {
            this.method_2309(var1);
        }
    }

    public void method_2188(int var1) {
        switch (var1) {
            case -1:
                this.method_2227();
                break;
            case 0:
                this.method_2221();
                break;
            case 1:
                this.method_2222();
                break;
            case 2:
                this.method_2223();
                break;
            case 3:
                this.method_2224();
                break;
            case 4:
                this.method_2225();
                break;
            case 5:
                this.method_2226();
                break;
            default:
                if (-128 <= var1 && var1 <= 127) {
                    this.method_2110((byte)var1);
                    return;
                }
                if (-32768 <= var1 && var1 <= 32767) {
                    this.method_2375(var1);
                    return;
                }
                this.method_2310(var1);
        }
    }

    public void method_2189(long var1) {
        if (var1 == 0L) {
            this.method_2307();
        } else if (var1 == 1L) {
            this.method_2308();
        } else {
            this.method_2314(var1);
        }
    }

    public void method_2190(short var1) {
        switch (var1) {
            case -1:
                this.method_2227();
                break;
            case 0:
                this.method_2221();
                break;
            case 1:
                this.method_2222();
                break;
            case 2:
                this.method_2223();
                break;
            case 3:
                this.method_2224();
                break;
            case 4:
                this.method_2225();
                break;
            case 5:
                this.method_2226();
                break;
            default:
                if (-128 <= var1 && var1 <= 127) {
                    this.method_2110((byte)var1);
                    return;
                }
                this.method_2375(var1);
        }
    }

    public void method_2191(Object[] var1, class_89 var2, class_34 var3, class_83 var4) {
        if (var1 == null) {
            if (var3 instanceof class_65) {
                var4.method_644().method_1689(var2);
            } else {
                var4.method_644().method_1707((class_43)var3, var2, false);
            }
        } else if (var1 == class_86.field_401) {
            var4.method_644().method_1707((class_43)var3, var2, true);
        } else if (var1 == class_86.field_402) {
            var4.method_644().method_1707((class_43)var3, var2, false);
        } else if (var1 == class_86.field_400) {
            this.method_2093();
        } else {
            if (var1[0] instanceof class_67) {
                class_67 var5 = (class_67)var1[0];
                this.method_2093();
                this.method_2205(var5);
            } else {
                this.method_2324((class_65)var1[0]);
            }
            int var8 = 1;
            for (int var6 = var1.length; var8 < var6; ++var8) {
                if (var1[var8] instanceof class_67) {
                    class_67 var7 = (class_67)var1[var8];
                    this.method_2205(var7);
                } else {
                    this.method_2273((class_58)var1[var8]);
                }
            }
        }
    }

    public void method_2192(class_126 var1) {
        if (var1 == null) {
            this.method_2371();
        } else {
            int var2 = var1.field_674;
            if ((var2 & 512) != 0) {
                this.method_2098();
                return;
            }
            int var3 = (var2 & 255) >> 4;
            switch (var3) {
                case 5:
                case 10:
                    this.method_2285();
                    break;
                case 6:
                default:
                    this.method_2098();
                    break;
                case 7:
                    this.method_2329();
                    break;
                case 8:
                    this.method_2134();
                    break;
                case 9:
                    this.method_2169();
            }
        }
    }

    public void method_2193(class_86 var1, class_126 var2, class_126 var3) {
        int var4;
        if (var2 == null) {
            this.method_2349();
            this.method_2142();
            this.method_2377();
            this.method_2279(1);
            this.method_2276();
        } else {
            var4 = this.field_1208;
            var2.method_915(var1, this, var2.field_674 & 15);
            this.method_2360(var4, var2.field_444);
        }
        var4 = this.field_1208;
        var3.method_914(var1, this, var3.field_674 & 15);
        this.method_2360(var4, var3.field_444);
        this.method_2277();
    }

    public void method_2194(class_60 var1) {
        this.method_2256(var1);
        class_58 var2 = var1.field_285;
        class_40[] var3 = var2.field_276;
        int var4 = var3.length;
        int var5 = 1;
        this.method_2093();
        class_43 var6 = var2.field_278;
        if (var6.method_138().field_177 == 41 || var6.method_153()) {
            this.method_2094();
            this.method_2249();
            var5 += 2;
        }
        class_55 var7;
        class_66[] var8;
        int var9;
        class_40 var10;
        if (var6.method_160()) {
            var7 = (class_55)var6;
            var8 = var7.method_329();
            for (var9 = 0; var9 < (var8 == null ? 0 : var8.length); ++var9) {
                this.method_2325(var10 = var8[var9].field_301, var5);
                if (var10 != class_40.field_185 && var10 != class_40.field_183) {
                    ++var5;
                } else {
                    var5 += 2;
                }
            }
        }
        for (int var11 = 0; var11 < var4; ++var11) {
            this.method_2325(var3[var11], var5);
            if (var3[var11] != class_40.field_185 && var3[var11] != class_40.field_183) {
                ++var5;
            } else {
                var5 += 2;
            }
        }
        if (var6.method_160()) {
            var7 = (class_55)var6;
            var8 = var7.method_243();
            for (var9 = 0; var9 < (var8 == null ? 0 : var8.length); ++var9) {
                this.method_2325(var10 = var8[var9].field_301, var5);
                if (var10 != class_40.field_185 && var10 != class_40.field_183) {
                    ++var5;
                } else {
                    var5 += 2;
                }
            }
        }
        this.method_2272(var2);
        this.method_2371();
    }

    public void method_2195(class_60 var1) {
        this.method_2256(var1);
        class_43 var2 = var1.field_278;
        this.method_2312(var2);
        this.method_2093();
        this.method_2265(var2);
        this.method_2113(var2);
        this.method_2098();
    }

    public void method_2196(class_60 var1) {
        class_84 var2 = ((class_54)var1.field_278).field_258;
        class_67 var3 = var2.field_376.field_600;
        this.method_2256(var1);
        class_40 var4 = var1.field_275;
        this.method_2207(var3);
        this.method_2141();
        this.method_2103();
        this.method_2221();
        this.method_2093();
        this.method_2101();
        this.method_2141();
        this.method_2291();
        this.method_2345((class_42)var4);
        this.method_2141();
        this.method_2105();
        this.method_2221();
        this.method_2248();
        this.method_2280();
        this.method_2095();
        this.method_2098();
    }

    public void method_2197(class_60 var1) {
        this.method_2256(var1);
        class_67 var2 = var1.field_283;
        if (var2.method_431()) {
            this.method_2207(var2);
        } else {
            this.method_2093();
            this.method_2205(var2);
        }
        switch (var2.field_301.field_177) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                this.method_2285();
                break;
            case 6:
            default:
                this.method_2098();
                break;
            case 7:
                this.method_2329();
                break;
            case 8:
                this.method_2134();
                break;
            case 9:
                this.method_2169();
        }
    }

    public void method_2198(class_60 var1) {
        this.method_2256(var1);
        class_67 var2 = var1.field_284;
        if (var2.method_431()) {
            this.method_2325(var2.field_301, 0);
            this.method_2357(var2);
        } else {
            this.method_2093();
            this.method_2325(var2.field_301, 1);
            this.method_2356(var2);
        }
        this.method_2371();
    }

    public void method_2199(class_60 var1) {
        this.method_2256(var1);
        class_58 var2 = var1.field_285;
        class_40[] var3 = var2.field_276;
        int var4 = var3.length;
        class_40[] var5 = var1.field_287 == 6 ? var1.field_276 : null;
        int var6;
        if (var2.method_370()) {
            var6 = 0;
        } else {
            this.method_2093();
            var6 = 1;
        }
        class_40 var8;
        for (int var7 = 0; var7 < var4; ++var7) {
            var8 = var3[var7];
            if (var5 != null) {
                class_40 var9 = var5[var7];
                this.method_2325(var9, var6);
                if (var9 != var8) {
                    this.method_2113(var8);
                }
            } else {
                this.method_2325(var8, var6);
            }
            if (var8 != class_40.field_185 && var8 != class_40.field_183) {
                ++var6;
            } else {
                var6 += 2;
            }
        }
        if (var2.method_370()) {
            this.method_2273(var2);
        } else if (!var2.method_358() && !var2.method_367() && var1.field_287 != 5) {
            if (var2.field_278.method_157()) {
                this.method_2261(var2);
            } else {
                this.method_2282(var2);
            }
        } else {
            this.method_2272(var2);
        }
        switch (var2.field_275.field_177) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                this.method_2285();
                break;
            case 6:
                this.method_2371();
                break;
            case 7:
                this.method_2329();
                break;
            case 8:
                this.method_2134();
                break;
            case 9:
                this.method_2169();
                break;
            default:
                class_40 var10 = var1.field_275.method_138();
                var8 = var2.field_275.method_140(var10);
                if (var8 == null) {
                    this.method_2113(var10);
                }
                this.method_2098();
        }
    }

    public void method_2200(class_60 var1) {
        class_84 var2 = ((class_54)var1.field_278).field_258;
        this.method_2256(var1);
        class_74 var10000 = new class_74(this);
        class_74 var3 = var10000;
        class_67 var4 = var1.field_283;
        this.method_2207(var4);
        this.method_2141();
        this.method_2244(var3);
        this.method_2098();
        this.method_2354(var4.field_301);
        var3.method_458();
        this.method_2352();
        class_43 var5 = (class_43)var1.field_286;
        class_42 var6 = var2.method_580(var5, 1);
        this.method_2266(var5, var6);
        this.method_2101();
        this.method_2344(10);
        this.method_2103();
        class_65 var15 = new class_65(" tab".toCharArray(), var2.method_580(class_40.field_179, 1), 0, false);
        class_65 var7 = var15;
        this.method_2091(var7);
        class_67[] var8 = var5.method_204();
        if (var8 != null) {
            int var9 = 0;
            for (int var10 = var8.length; var9 < var10; ++var9) {
                class_67 var11 = var8[var9];
                if ((var11.method_425() & 16384) != 0) {
                    var10000 = new class_74(this);
                    class_74 var12 = var10000;
                    class_73 var14 = new class_73(this, class_40.field_183);
                    class_73 var13 = var14;
                    var13.method_449();
                    this.method_2093();
                    this.method_2207(var11);
                    this.method_2260(var5.method_134());
                    this.method_2188(var11.field_304 + 1);
                    this.method_2220();
                    var13.method_448();
                    this.method_2209(var12);
                    this.method_2355(class_40.field_183);
                    var13.method_447();
                    this.method_2352();
                    var12.method_458();
                }
            }
        }
        this.method_2093();
        this.method_2141();
        this.method_2357(var4);
        this.method_2098();
        this.method_2365(var7);
    }

    public void method_2201(class_86 var1, class_43 var2, class_126 var3, class_89 var4) {
        class_43 var5 = var2.method_146() ? (class_43)var2.method_240().method_138() : var2;
        boolean var6 = var3 != null;
        if (var6 && (!var5.method_160() || var5.method_226())) {
            var1.method_644().method_1792(var3, var5);
        } else {
            class_43[] var7;
            if ((var7 = var2.method_242()) != null) {
                class_43 var8 = var5.method_137();
                long var9 = var1.method_577().field_1927;
                boolean var11;
                if (var9 <= 3080192L) {
                    var11 = var4 instanceof class_135;
                } else if (var9 == 3145728L) {
                    var11 = var4 instanceof class_135 || var4 instanceof class_105 && ((class_105)var4).method_1();
                } else {
                    var11 = (var4 instanceof class_135 || var4 instanceof class_105 && ((class_105)var4).method_1()) && !var2.method_158();
                }
                boolean var12 = var9 >= 3145728L;
                int var13 = 0;
                for (int var14 = var7.length; var13 < var14; ++var13) {
                    class_43 var15 = var7[var13];
                    if (var6 && var15 == var8) {
                        var6 = false;
                        var3.method_912(var1, this, true);
                        if (var12) {
                            this.method_2141();
                            this.method_2271();
                            this.method_2352();
                        }
                    } else {
                        Object[] var16 = var1.method_714(var15, false, var11);
                        this.method_2191(var16, var4, var15, var1);
                    }
                }
                if (var6) {
                    var1.method_644().method_1792(var3, var5);
                }
            }
        }
    }

    public void method_2202(class_86 var1, class_43 var2, class_89 var3) {
        class_66[] var4;
        if ((var4 = var2.method_243()) != null) {
            int var5 = 0;
            for (int var6 = var4.length; var5 < var6; ++var5) {
                class_65 var7 = var4[var5].field_312;
                class_64[] var8 = var1.method_713(var7);
                this.method_2191(var8, var3, var7, var1);
            }
        }
    }

    public void method_2203(int var1) {
        switch (var1) {
            case 2:
                this.method_2258(-74, 0, 1, class_272.field_1409, class_272.field_1341, class_272.field_1342);
                break;
            case 3:
                this.method_2258(-74, 0, 1, class_272.field_1408, class_272.field_1337, class_272.field_1338);
                break;
            case 4:
                this.method_2258(-74, 0, 1, class_272.field_1429, class_272.field_1474, class_272.field_1475);
                break;
            case 5:
                this.method_2258(-74, 0, 1, class_272.field_1407, class_272.field_1333, class_272.field_1334);
            case 6:
            default:
                break;
            case 7:
                this.method_2258(-74, 0, 2, class_272.field_1419, class_272.field_1441, class_272.field_1442);
                break;
            case 8:
                this.method_2258(-74, 0, 2, class_272.field_1413, class_272.field_1350, class_272.field_1351);
                break;
            case 9:
                this.method_2258(-74, 0, 1, class_272.field_1417, class_272.field_1356, class_272.field_1357);
                break;
            case 10:
                this.method_2258(-74, 0, 1, class_272.field_1418, class_272.field_1399, class_272.field_1400);
        }
    }

    public void method_2204(byte var1, class_74 var2) {
        class_74 var10000 = new class_74(this);
        class_74 var3 = var10000;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = var1;
        var3.method_452();
        this.method_2210(var2);
        var3.method_458();
    }

    public void method_2205(class_67 var1) {
        byte var2 = 1;
        if (var1.field_301.field_177 == 8 || var1.field_301.field_177 == 7) {
            var2 = 2;
        }
        this.method_2181((byte) - 76, var2, var1.field_314, var1.field_302, var1.field_301);
    }

    protected int method_2206() {
        return this.field_1208;
    }

    public void method_2207(class_67 var1) {
        byte var2 = 1;
        if (var1.field_301.field_177 == 8 || var1.field_301.field_177 == 7) {
            var2 = 2;
        }
        this.method_2181((byte) - 78, var2, var1.field_314, var1.field_302, var1.field_301);
    }

    public void method_2208(int var1) {
        this.field_1192 = 0;
        switch (var1) {
            case 2:
                this.method_2180((byte) - 78, 1, class_272.field_1409, class_272.field_1496, class_272.field_1412);
                break;
            case 3:
                this.method_2180((byte) - 78, 1, class_272.field_1408, class_272.field_1496, class_272.field_1412);
                break;
            case 4:
                this.method_2180((byte) - 78, 1, class_272.field_1429, class_272.field_1496, class_272.field_1412);
                break;
            case 5:
                this.method_2180((byte) - 78, 1, class_272.field_1407, class_272.field_1496, class_272.field_1412);
                break;
            case 6:
                this.method_2180((byte) - 78, 1, class_272.field_1437, class_272.field_1496, class_272.field_1412);
                break;
            case 7:
                this.method_2180((byte) - 78, 1, class_272.field_1419, class_272.field_1496, class_272.field_1412);
                break;
            case 8:
                this.method_2180((byte) - 78, 1, class_272.field_1413, class_272.field_1496, class_272.field_1412);
                break;
            case 9:
                this.method_2180((byte) - 78, 1, class_272.field_1417, class_272.field_1496, class_272.field_1412);
                break;
            case 10:
                this.method_2180((byte) - 78, 1, class_272.field_1418, class_272.field_1496, class_272.field_1412);
        }
    }

    public void method_2209(class_74 var1) {
        if (this.field_1216) {
            this.method_2210(var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            boolean var2 = this.method_2254(var1, this.field_1208);
            if (var2 && this.field_1198 == this.field_1208) {
                if (var1.field_323 != -1) {
                    int[] var3 = var1.method_455();
                    int var4 = 0;
                    for (int var5 = var1.method_454(); var4 < var5; ++var4) {
                        this.method_2382(var1, var3[var4]);
                    }
                    this.field_1192 = 0;
                }
            } else {
                ++this.field_1208;
                this.field_1188[this.field_1190++] = -89;
                var1.method_452();
                this.field_1198 = this.field_1208;
            }
        }
    }

    public void method_2210(class_74 var1) {
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -56;
        var1.method_453();
        this.field_1198 = this.field_1208;
    }

    public void method_2211() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -111;
    }

    public void method_2212() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -110;
    }

    public void method_2213() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -121;
    }

    public void method_2214() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -122;
    }

    public void method_2215() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -123;
    }

    public void method_2216() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -109;
    }

    public void method_2217() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 96;
    }

    public void method_2218() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 46;
    }

    public void method_2219() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 126;
    }

    public void method_2220() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 79;
    }

    public void method_2221() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 3;
    }

    public void method_2222() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 4;
    }

    public void method_2223() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 5;
    }

    public void method_2224() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 6;
    }

    public void method_2225() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 7;
    }

    public void method_2226() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 8;
    }

    public void method_2227() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 2;
    }

    public void method_2228() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 108;
    }

    public void method_2229(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 90, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -91;
            var1.method_452();
        }
    }

    public void method_2230(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 91, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -90;
            var1.method_452();
        }
    }

    public void method_2231(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 96, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -97;
            var1.method_452();
        }
    }

    public void method_2232(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 95, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -94;
            var1.method_452();
        }
    }

    public void method_2233(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 92, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -93;
            var1.method_452();
        }
    }

    public void method_2234(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 93, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -92;
            var1.method_452();
        }
    }

    public void method_2235(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 94, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -95;
            var1.method_452();
        }
    }

    public void method_2236(class_74 var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1216) {
            this.method_2204((byte) - 97, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -96;
            var1.method_452();
        }
    }

    public void method_2237(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 102, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -103;
            var1.method_452();
        }
    }

    public void method_2238(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 101, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -100;
            var1.method_452();
        }
    }

    public void method_2239(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 98, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -99;
            var1.method_452();
        }
    }

    public void method_2240(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 99, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -98;
            var1.method_452();
        }
    }

    public void method_2241(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 100, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -101;
            var1.method_452();
        }
    }

    public void method_2242(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 103, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -102;
            var1.method_452();
        }
    }

    public void method_2243(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 58, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -57;
            var1.method_452();
        }
    }

    public void method_2244(class_74 var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1216) {
            this.method_2204((byte) - 57, var1);
        } else {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -58;
            var1.method_452();
        }
    }

    public final void method_2245(int var1, int var2) {
        this.field_1192 = 0;
        if (var1 <= 255 && var2 >= -128 && var2 <= 127) {
            if (this.field_1190 + 2 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 3;
            this.field_1188[this.field_1190++] = -124;
            this.field_1188[this.field_1190++] = (byte)var1;
            this.field_1188[this.field_1190++] = (byte)var2;
        } else {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = -124;
            this.method_2387(var1);
            this.method_2383(var2);
        }
    }

    public void method_2246(int var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= var1) {
            this.field_1204 = var1 + 1;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 21;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 21;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2247() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 0) {
            this.field_1204 = 1;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 26;
    }

    public void method_2248() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 1) {
            this.field_1204 = 2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 27;
    }

    public void method_2249() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 2) {
            this.field_1204 = 3;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 28;
    }

    public void method_2250() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1204 <= 3) {
            this.field_1204 = 4;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 29;
    }

    public void method_2251() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 104;
    }

    public int method_2252(int var1, int var2) {
        int var3 = var1;
        for (int var4 = this.field_1207; var3 < var4; var3 += 2) {
            if (this.field_1206[var3 + 1] == var2) {
                return var3;
            }
        }
        return -1;
    }

    public void method_2253() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 116;
    }

    public boolean method_2254(class_74 var1, int var2) {
        if (var1.field_329 != null) {
            return false;
        } else {
            int var3 = 0;
            for (int var4 = this.field_1192 - 1; var4 >= 0; --var4) {
                class_74 var5 = this.field_1196[var4];
                if (var5.field_323 != var2) {
                    break;
                }
                if (var5 == var1) {
                    var3 |= 4;
                } else if (var5.method_457()) {
                    if (var5.field_329 == null) {
                        var1.method_451(var5);
                        var3 |= 2;
                    }
                } else {
                    var3 |= 4;
                }
            }
            return (var3 & 6) == 2;
        }
    }

    public void method_2255(class_288 var1) {
        this.field_1189 = var1;
        this.field_1191 = var1.field_1716;
        this.field_1188 = var1.field_1718;
        this.field_1190 = var1.field_1719;
        this.field_1212 = this.field_1190;
        this.field_1207 = 0;
        this.field_1197 = 0;
        int var2 = this.field_1214.length;
        if (field_1185.length < var2) {
            field_1185 = new class_65[var2];
        }
        System.arraycopy(field_1185, 0, this.field_1214, 0, var2);
        this.field_1215 = 0;
        var2 = this.field_1202.length;
        if (field_1184.length < var2) {
            field_1184 = new class_65[var2];
        }
        System.arraycopy(field_1184, 0, this.field_1202, 0, var2);
        this.field_1187 = 0;
        var2 = this.field_1193.length;
        if (field_1182.length < var2) {
            field_1182 = new class_73[var2];
        }
        System.arraycopy(field_1182, 0, this.field_1193, 0, var2);
        this.field_1194 = 0;
        var2 = this.field_1196.length;
        if (field_1183.length < var2) {
            field_1183 = new class_74[var2];
        }
        System.arraycopy(field_1183, 0, this.field_1196, 0, var2);
        this.field_1192 = 0;
        this.field_1198 = -1;
        this.field_1211 = 0;
        this.field_1210 = 0;
        this.field_1204 = 0;
        this.field_1208 = 0;
    }

    public void method_2256(class_58 var1) {
        if (var1 == null) {
            this.field_1204 = 0;
        } else {
            this.field_1204 = var1.method_370() ? 0 : 1;
            if (var1.method_358() && var1.field_278.method_153()) {
                this.field_1204 += 2;
            }
            int var3;
            int var4;
            if (var1.method_358() && var1.field_278.method_160()) {
                class_43[] var2;
                if ((var2 = var1.field_278.method_242()) != null) {
                    var3 = 0;
                    for (var4 = var2.length; var3 < var4; ++var3) {
                        ++this.field_1204;
                    }
                }
                class_66[] var8;
                if ((var8 = var1.field_278.method_243()) != null) {
                    var4 = 0;
                    for (int var5 = var8.length; var4 < var5; ++var4) {
                        class_40 var6;
                        if ((var6 = var8[var4].field_301) != class_40.field_183 && var6 != class_40.field_185) {
                            ++this.field_1204;
                        } else {
                            this.field_1204 += 2;
                        }
                    }
                }
            }
            class_40[] var7 = var1.field_276;
            if (var1.field_276 != null) {
                var3 = 0;
                for (var4 = var7.length; var3 < var4; ++var3) {
                    class_40 var9;
                    if ((var9 = var7[var3]) != class_40.field_183 && var9 != class_40.field_185) {
                        ++this.field_1204;
                    } else {
                        this.field_1204 += 2;
                    }
                }
            }
        }
    }

    public void method_2257(class_40 var1) {
        this.field_1192 = 0;
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -63;
        this.method_2387(this.field_1191.method_2467(var1));
    }

    protected void method_2258(int var1, int var2, int var3, char[] var4, char[] var5, char[] var6) {
        this.field_1192 = 0;
        int var7 = var2;
        switch (var1) {
            case -74:
            case -73:
                if (this.field_1190 + 2 >= this.field_1188.length) {
                    this.method_2369();
                }
                ++this.field_1208;
                this.field_1188[this.field_1190++] = (byte)var1;
                this.method_2387(this.field_1191.method_2468(var4, var5, var6, false));
                var7 = var2 + 1;
                break;
            case -72:
                if (this.field_1190 + 2 >= this.field_1188.length) {
                    this.method_2369();
                }
                ++this.field_1208;
                this.field_1188[this.field_1190++] = -72;
                this.method_2387(this.field_1191.method_2468(var4, var5, var6, false));
                break;
            case -71:
                if (this.field_1190 + 4 >= this.field_1188.length) {
                    this.method_2369();
                }
                this.field_1208 += 3;
                this.field_1188[this.field_1190++] = -71;
                this.method_2387(this.field_1191.method_2468(var4, var5, var6, true));
                var7 = var2 + 1;
                this.field_1188[this.field_1190++] = (byte)var7;
                this.field_1188[this.field_1190++] = 0;
        }
        this.field_1210 += var3 - var7;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2259() {
        this.method_2258(-72, 1, 1, class_272.field_1410, class_272.field_1358, class_272.field_1359);
    }

    public void method_2260(char[] var1) {
        this.method_2258(-74, 0, 1, var1, class_272.field_1449, class_272.field_1450);
    }

    public void method_2261(class_58 var1) {
        this.field_1192 = 0;
        int var2 = 1;
        if (this.field_1190 + 4 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1208 += 3;
        this.field_1188[this.field_1190++] = -71;
        this.method_2387(this.field_1191.method_2469(var1.method_350(), var1.field_274, var1.method_382(this.field_1189), true));
        int var3;
        for (int var4 = var1.field_276.length - 1; var4 >= 0; --var4) {
            if ((var3 = var1.field_276[var4].field_177) != 8 && var3 != 7) {
                ++var2;
            } else {
                var2 += 2;
            }
        }
        this.field_1188[this.field_1190++] = (byte)var2;
        this.field_1188[this.field_1190++] = 0;
        var3 = var1.field_275.field_177;
        if (var1.field_275.field_177 != 8 && var3 != 7) {
            if (var3 == 6) {
                this.field_1210 -= var2;
            } else {
                this.field_1210 += 1 - var2;
            }
        } else {
            this.field_1210 += 2 - var2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2262(int var1) {
        byte var2 = 1;
        char[] var3 = null;
        switch (var1) {
            case 1:
            case 11:
            case 12:
                var3 = class_272.field_1447;
                break;
            case 2:
                var3 = class_272.field_1340;
                break;
            case 3:
            case 4:
            case 10:
                var3 = class_272.field_1395;
                break;
            case 5:
                var3 = class_272.field_1332;
            case 6:
            default:
                break;
            case 7:
                var3 = class_272.field_1439;
                var2 = 2;
                break;
            case 8:
                var3 = class_272.field_1348;
                var2 = 2;
                break;
            case 9:
                var3 = class_272.field_1354;
        }
        this.method_2258(-73, var2, 0, class_272.field_1406, class_272.field_1394, var3);
    }

    public void method_2263() {
        this.method_2258(-73, 0, 0, class_272.field_1406, class_272.field_1394, class_272.field_1344);
    }

    public void method_2264() {
        this.method_2258(-74, 0, 1, class_272.field_1410, class_272.field_1346, class_272.field_1347);
    }

    public void method_2265(class_43 var1) {
        this.method_2258(-72, 2, 1, class_272.field_1414, class_272.field_1497, class_272.field_1505);
    }

    public void method_2266(class_40 var1, class_42 var2) {
        char[] var3 = "()".toCharArray();
        var3 = CharOperation.method_1355(var3, var2.method_134());
        this.method_2258(-72, 0, 1, var1.method_134(), class_17.field_71, var3);
    }

    public void method_2267() {
        this.method_2258(-73, 1, 0, class_272.field_1415, class_272.field_1394, class_272.field_1492);
    }

    public void method_2268() {
        this.method_2258(-71, 0, 1, class_272.field_1438, class_272.field_1392, class_272.field_1393);
    }

    public void method_2269() {
        this.method_2258(-71, 0, 1, class_272.field_1438, class_272.field_1445, class_272.field_1446);
    }

    public void method_2270() {
        this.method_2258(-73, 1, 0, class_272.field_1420, class_272.field_1394, class_272.field_1492);
    }

    public void method_2271() {
        this.method_2258(-74, 0, 1, class_272.field_1422, class_272.field_1378, class_272.field_1379);
    }

    public void method_2272(class_58 var1) {
        this.field_1192 = 0;
        int var2 = 1;
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -73;
        this.method_2387(this.field_1191.method_2469(var1.method_350(), var1.field_274, var1.method_382(this.field_1189), false));
        int var3;
        if (var1.method_358()) {
            class_43 var4 = var1.field_278;
            if (var4.method_160()) {
                class_43[] var5 = var4.method_242();
                int var7;
                if (var5 != null) {
                    int var6 = 0;
                    for (var7 = var5.length; var6 < var7; ++var6) {
                        if ((var3 = var5[var6].field_177) != 8 && var3 != 7) {
                            ++var2;
                        } else {
                            var2 += 2;
                        }
                    }
                }
                class_66[] var10 = var4.method_243();
                if (var10 != null) {
                    var7 = 0;
                    for (int var8 = var10.length; var7 < var8; ++var7) {
                        if ((var3 = var10[var7].field_301.field_177) != 8 && var3 != 7) {
                            ++var2;
                        } else {
                            var2 += 2;
                        }
                    }
                }
            }
            if (var4.method_153()) {
                var2 += 2;
            }
        }
        for (int var9 = var1.field_276.length - 1; var9 >= 0; --var9) {
            if ((var3 = var1.field_276[var9].field_177) != 8 && var3 != 7) {
                ++var2;
            } else {
                var2 += 2;
            }
        }
        var3 = var1.field_275.field_177;
        if (var1.field_275.field_177 != 8 && var3 != 7) {
            if (var3 == 6) {
                this.field_1210 -= var2;
            } else {
                this.field_1210 += 1 - var2;
            }
        } else {
            this.field_1210 += 2 - var2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2273(class_58 var1) {
        this.field_1192 = 0;
        int var2 = 0;
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -72;
        this.method_2387(this.field_1191.method_2469(var1.method_350(), var1.field_274, var1.method_382(this.field_1189), false));
        int var3;
        for (int var4 = var1.field_276.length - 1; var4 >= 0; --var4) {
            if ((var3 = var1.field_276[var4].field_177) != 8 && var3 != 7) {
                ++var2;
            } else {
                var2 += 2;
            }
        }
        var3 = var1.field_275.field_177;
        if (var1.field_275.field_177 != 8 && var3 != 7) {
            if (var3 == 6) {
                this.field_1210 -= var2;
            } else {
                this.field_1210 += 1 - var2;
            }
        } else {
            this.field_1210 += 2 - var2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2274(int var1) {
        byte var2 = 1;
        byte var3 = 1;
        char[] var4 = null;
        char[] var5 = class_272.field_1324;
        char[] var6 = null;
        switch (var1) {
            case 0:
            case 1:
            case 12:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1490;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1482;
                }
                break;
            case 2:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1485;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1477;
                }
                break;
            case 3:
            case 4:
            case 10:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1488;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1480;
                }
                break;
            case 5:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1484;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1476;
                }
            case 6:
            default:
                break;
            case 7:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1489;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1481;
                }
                var2 = 2;
                break;
            case 8:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1486;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1478;
                }
                var2 = 2;
                break;
            case 9:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1487;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1479;
                }
                break;
            case 11:
                if (this.field_1213 >= 3211264L) {
                    var4 = class_272.field_1431;
                    var6 = class_272.field_1491;
                } else {
                    var4 = class_272.field_1430;
                    var6 = class_272.field_1483;
                }
        }
        this.method_2258(-74, var2, var3, var4, var5, var6);
    }

    public void method_2275() {
        char[] var1 = class_272.field_1430;
        if (this.field_1213 >= 3211264L) {
            var1 = class_272.field_1431;
        }
        this.method_2258(-73, 0, 0, var1, class_272.field_1394, class_272.field_1344);
    }

    public void method_2276() {
        char[] var1 = class_272.field_1430;
        if (this.field_1213 >= 3211264L) {
            var1 = class_272.field_1431;
        }
        this.method_2258(-73, 1, 0, var1, class_272.field_1394, class_272.field_1492);
    }

    public void method_2277() {
        char[] var1 = class_272.field_1430;
        if (this.field_1213 >= 3211264L) {
            var1 = class_272.field_1431;
        }
        this.method_2258(-74, 0, 1, var1, class_272.field_1494, class_272.field_1495);
    }

    public void method_2278() {
        this.method_2258(-74, 0, 1, class_272.field_1432, class_272.field_1396, class_272.field_1397);
    }

    public void method_2279(int var1) {
        byte var2 = 1;
        char[] var3 = null;
        switch (var1) {
            case 0:
            case 1:
            case 11:
            case 12:
                var3 = class_272.field_1504;
                break;
            case 2:
                var3 = class_272.field_1499;
                break;
            case 3:
            case 4:
            case 10:
                var3 = class_272.field_1502;
                break;
            case 5:
                var3 = class_272.field_1498;
            case 6:
            default:
                break;
            case 7:
                var3 = class_272.field_1503;
                var2 = 2;
                break;
            case 8:
                var3 = class_272.field_1500;
                var2 = 2;
                break;
            case 9:
                var3 = class_272.field_1501;
        }
        this.method_2258(-72, var2, 1, class_272.field_1432, class_272.field_1497, var3);
    }

    public void method_2280() {
        this.method_2258(-72, 5, 0, class_272.field_1435, class_272.field_1327, class_272.field_1328);
    }

    public void method_2281() {
        this.method_2258(-74, 0, 1, class_272.field_1436, class_272.field_1390, class_272.field_1391);
    }

    public void method_2282(class_58 var1) {
        this.field_1192 = 0;
        int var2 = 1;
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -74;
        this.method_2387(this.field_1191.method_2469(var1.method_350(), var1.field_274, var1.method_382(this.field_1189), false));
        int var3;
        for (int var4 = var1.field_276.length - 1; var4 >= 0; --var4) {
            if ((var3 = var1.field_276[var4].field_177) != 8 && var3 != 7) {
                ++var2;
            } else {
                var2 += 2;
            }
        }
        var3 = var1.field_275.field_177;
        if (var1.field_275.field_177 != 8 && var3 != 7) {
            if (var3 == 6) {
                this.field_1210 -= var2;
            } else {
                this.field_1210 += 1 - var2;
            }
        } else {
            this.field_1210 += 2 - var2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2283() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -128;
    }

    public void method_2284() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 112;
    }

    public void method_2285() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -84;
        this.field_1198 = this.field_1208;
    }

    public boolean method_2286(class_83 var1, int var2, class_65 var3) {
        if ((var3.field_305 & 1024L) != 0L) {
            return true;
        } else if (var2 == -1) {
            return false;
        } else {
            int var4 = var3.field_304 + this.field_1203;
            class_87 var5 = var1.method_635();
            if (var4 < 64) {
                return (var5.field_410[var2] & 1L << var4) != 0L;
            } else {
                long[] var6 = var5.field_411[var2];
                int var7;
                return var6 == null ? false : ((var7 = var4 / 64 - 1) >= var6.length ? false : (var6[var7] & 1L << var4 % 64) != 0L);
            }
        }
    }

    public void method_2287() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 120;
    }

    public void method_2288() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 122;
    }

    public void method_2289(int var1) {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= var1) {
            this.field_1204 = var1 + 1;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 54;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 54;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2290() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 == 0) {
            this.field_1204 = 1;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 59;
    }

    public void method_2291() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 1) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 60;
    }

    public void method_2292() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 2) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 61;
    }

    public void method_2293() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1204 <= 3) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 62;
    }

    public void method_2294() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 100;
    }

    public void method_2295() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 124;
    }

    public void method_2296() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -126;
    }

    public final void method_2297(class_74 var1) {
        if (this.field_1216) {
            this.method_2298(var1);
        } else {
            this.field_1192 = 0;
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = -88;
            var1.method_452();
        }
    }

    public final void method_2298(class_74 var1) {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -55;
        var1.method_453();
    }

    public void method_2299() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -118;
    }

    public void method_2300() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -119;
    }

    public void method_2301() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -120;
    }

    public void method_2302() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 97;
    }

    public void method_2303() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 47;
    }

    public void method_2304() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 127;
    }

    public void method_2305() {
        this.field_1192 = 0;
        this.field_1210 -= 4;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 80;
    }

    public void method_2306() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -108;
    }

    public void method_2307() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 9;
    }

    public void method_2308() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 10;
    }

    public void method_2309(float var1) {
        this.field_1192 = 0;
        int var2 = this.field_1191.method_2462(var1);
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var2 > 255) {
            if (this.field_1190 + 2 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = 19;
            this.method_2387(var2);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 18;
            this.field_1188[this.field_1190++] = (byte)var2;
        }
    }

    public void method_2310(int var1) {
        this.field_1192 = 0;
        int var2 = this.field_1191.method_2463(var1);
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var2 > 255) {
            if (this.field_1190 + 2 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = 19;
            this.method_2387(var2);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 18;
            this.field_1188[this.field_1190++] = (byte)var2;
        }
    }

    public void method_2311(String var1) {
        this.field_1192 = 0;
        int var2 = this.field_1208;
        char[] var3 = var1.toCharArray();
        int var4 = this.field_1191.method_2472(var3);
        if (var4 > 0) {
            this.method_2315(var4, var3);
        } else {
            this.field_1208 = var2;
            int var5 = 0;
            int var6 = 0;
            int var7 = var1.length();
            byte[] var8 = new byte[Math.min(var7 + 100, '\uffff')];
            int var13;
            for (boolean var9 = false; var6 < '\ufffc' && var5 < var7; ++var5) {
                char var10 = var3[var5];
                if (var6 + 3 > (var13 = var8.length)) {
                    System.arraycopy(var8, 0, var8 = new byte[Math.min(var13 + 100, '\uffff')], 0, var6);
                }
                if (var10 >= 1 && var10 <= 127) {
                    var8[var6++] = (byte)var10;
                } else if (var10 > 2047) {
                    var8[var6++] = (byte)(224 | var10 >> 12 & 15);
                    var8[var6++] = (byte)(128 | var10 >> 6 & 63);
                    var8[var6++] = (byte)(128 | var10 & 63);
                } else {
                    var8[var6++] = (byte)(192 | var10 >> 6 & 31);
                    var8[var6++] = (byte)(128 | var10 & 63);
                }
            }
            this.method_2349();
            this.method_2141();
            char[] var14 = new char[var5];
            System.arraycopy(var3, 0, var14, 0, var5);
            System.arraycopy(var8, 0, var8 = new byte[var6], 0, var6);
            var4 = this.field_1191.method_2460(var14, var8);
            this.method_2315(var4, var14);
            this.method_2276();
            while (var5 < var7) {
                var6 = 0;
                var8 = new byte[Math.min(var7 - var5 + 100, '\uffff')];
                int var11;
                for (var11 = var5; var6 < '\ufffc' && var5 < var7; ++var5) {
                    char var12 = var3[var5];
                    if (var6 + 3 > (var13 = var8.length)) {
                        System.arraycopy(var8, 0, var8 = new byte[Math.min(var13 + 100, '\uffff')], 0, var6);
                    }
                    if (var12 >= 1 && var12 <= 127) {
                        var8[var6++] = (byte)var12;
                    } else if (var12 > 2047) {
                        var8[var6++] = (byte)(224 | var12 >> 12 & 15);
                        var8[var6++] = (byte)(128 | var12 >> 6 & 63);
                        var8[var6++] = (byte)(128 | var12 & 63);
                    } else {
                        var8[var6++] = (byte)(192 | var12 >> 6 & 31);
                        var8[var6++] = (byte)(128 | var12 & 63);
                    }
                }
                int var15 = var5 - var11;
                var14 = new char[var15];
                System.arraycopy(var3, var11, var14, 0, var15);
                System.arraycopy(var8, 0, var8 = new byte[var6], 0, var6);
                var4 = this.field_1191.method_2460(var14, var8);
                this.method_2315(var4, var14);
                this.method_2274(11);
            }
            this.method_2277();
            this.method_2278();
        }
    }

    public void method_2312(class_40 var1) {
        this.field_1192 = 0;
        int var2 = this.field_1191.method_2467(var1);
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var2 > 255) {
            if (this.field_1190 + 2 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = 19;
            this.method_2387(var2);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 18;
            this.field_1188[this.field_1190++] = (byte)var2;
        }
    }

    public void method_2313(double var1) {
        this.field_1192 = 0;
        int var3 = this.field_1191.method_2461(var1);
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 20;
        this.method_2387(var3);
    }

    public void method_2314(long var1) {
        this.field_1192 = 0;
        int var3 = this.field_1191.method_2464(var1);
        this.field_1210 += 2;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 20;
        this.method_2387(var3);
    }

    public void method_2315(int var1, char[] var2) {
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var1 > 255) {
            if (this.field_1190 + 2 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = 19;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 18;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2316() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 109;
    }

    public void method_2317(int var1) {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1204 <= var1 + 1) {
            this.field_1204 = var1 + 2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 22;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 22;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2318() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1204 < 2) {
            this.field_1204 = 2;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 30;
    }

    public void method_2319() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1204 < 3) {
            this.field_1204 = 3;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 31;
    }

    public void method_2320() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1204 < 4) {
            this.field_1204 = 4;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 32;
    }

    public void method_2321() {
        this.field_1192 = 0;
        this.field_1210 += 2;
        if (this.field_1204 < 5) {
            this.field_1204 = 5;
        }
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 33;
    }

    public void method_2322() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 105;
    }

    public void method_2323() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 117;
    }

    public final void method_2324(class_65 var1) {
        this.method_2325(var1.field_301, var1.field_306);
    }

    public final void method_2325(class_40 var1, int var2) {
        this.field_1192 = 0;
        switch (var1.field_177) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                switch (var2) {
                    case 0:
                        this.method_2247();
                        return;
                    case 1:
                        this.method_2248();
                        return;
                    case 2:
                        this.method_2249();
                        return;
                    case 3:
                        this.method_2250();
                        return;
                    default:
                        this.method_2246(var2);
                        return;
                }
            case 6:
            default:
                switch (var2) {
                    case 0:
                        this.method_2093();
                        return;
                    case 1:
                        this.method_2094();
                        return;
                    case 2:
                        this.method_2095();
                        return;
                    case 3:
                        this.method_2096();
                        return;
                    default:
                        this.method_2092(var2);
                        return;
                }
            case 7:
                switch (var2) {
                    case 0:
                        this.method_2318();
                        return;
                    case 1:
                        this.method_2319();
                        return;
                    case 2:
                        this.method_2320();
                        return;
                    case 3:
                        this.method_2321();
                        return;
                    default:
                        this.method_2317(var2);
                        return;
                }
            case 8:
                switch (var2) {
                    case 0:
                        this.method_2127();
                        return;
                    case 1:
                        this.method_2128();
                        return;
                    case 2:
                        this.method_2129();
                        return;
                    case 3:
                        this.method_2130();
                        return;
                    default:
                        this.method_2126(var2);
                        return;
                }
            case 9:
                switch (var2) {
                    case 0:
                        this.method_2162();
                        break;
                    case 1:
                        this.method_2163();
                        break;
                    case 2:
                        this.method_2164();
                        break;
                    case 3:
                        this.method_2165();
                        break;
                    default:
                        this.method_2161(var2);
                }
        }
    }

    public void method_2326(class_75 var1, int[] var2, int[] var3, class_75[] var4) {
        this.field_1192 = 0;
        --this.field_1210;
        int var5 = var2.length;
        int var6 = this.field_1208;
        var1.method_459();
        int var7;
        for (var7 = 0; var7 < var5; ++var7) {
            var4[var7].method_459();
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -85;
        for (var7 = 3 - (var6 & 3); var7 > 0; --var7) {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = 0;
        }
        var1.method_452();
        this.method_2385(var5);
        for (var7 = 0; var7 < var5; ++var7) {
            this.method_2385(var2[var3[var7]]);
            var4[var3[var7]].method_452();
        }
    }

    public void method_2327() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -127;
    }

    public void method_2328() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 113;
    }

    public void method_2329() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -83;
        this.field_1198 = this.field_1208;
    }

    public void method_2330() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 121;
    }

    public void method_2331() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 123;
    }

    public void method_2332(int var1) {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 <= var1 + 1) {
            this.field_1204 = var1 + 2;
        }
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = 55;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = 55;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2333() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 2) {
            this.field_1204 = 2;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 63;
    }

    public void method_2334() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 3) {
            this.field_1204 = 3;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 64;
    }

    public void method_2335() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 4) {
            this.field_1204 = 4;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 65;
    }

    public void method_2336() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1204 < 5) {
            this.field_1204 = 5;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 66;
    }

    public void method_2337() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 101;
    }

    public void method_2338() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 125;
    }

    public void method_2339() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -125;
    }

    public void method_2340() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -62;
    }

    public void method_2341() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -61;
    }

    public void method_2342(class_40 var1, int var2) {
        this.field_1192 = 0;
        this.field_1210 += 1 - var2;
        if (this.field_1190 + 3 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1208 += 2;
        this.field_1188[this.field_1190++] = -59;
        this.method_2387(this.field_1191.method_2467(var1));
        this.field_1188[this.field_1190++] = (byte)var2;
    }

    public void method_2343(class_40 var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -69;
        this.method_2387(this.field_1191.method_2467(var1));
    }

    public void method_2344(int var1) {
        this.field_1192 = 0;
        if (this.field_1190 + 1 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1208 += 2;
        this.field_1188[this.field_1190++] = -68;
        this.field_1188[this.field_1190++] = (byte)var1;
    }

    public void method_2345(class_42 var1) {
        class_40 var2 = var1.method_187();
        switch (var2.field_177) {
            case 2:
                this.method_2344(5);
                break;
            case 3:
                this.method_2344(8);
                break;
            case 4:
                this.method_2344(9);
                break;
            case 5:
                this.method_2344(4);
                break;
            case 6:
            default:
                this.method_2097(var2);
                break;
            case 7:
                this.method_2344(11);
                break;
            case 8:
                this.method_2344(7);
                break;
            case 9:
                this.method_2344(6);
                break;
            case 10:
                this.method_2344(10);
        }
    }

    public void method_2346() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -69;
        this.method_2387(this.field_1191.method_2466(class_272.field_1406));
    }

    public void method_2347() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -69;
        this.method_2387(this.field_1191.method_2466(class_272.field_1415));
    }

    public void method_2348() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -69;
        this.method_2387(this.field_1191.method_2466(class_272.field_1420));
    }

    public void method_2349() {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -69;
        if (this.field_1213 >= 3211264L) {
            this.method_2387(this.field_1191.method_2466(class_272.field_1431));
        } else {
            this.method_2387(this.field_1191.method_2466(class_272.field_1430));
        }
    }

    public void method_2350(int var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 + 2 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -69;
        switch (var1) {
            case 2:
                this.method_2387(this.field_1191.method_2466(class_272.field_1409));
                break;
            case 3:
                this.method_2387(this.field_1191.method_2466(class_272.field_1408));
                break;
            case 4:
                this.method_2387(this.field_1191.method_2466(class_272.field_1429));
                break;
            case 5:
                this.method_2387(this.field_1191.method_2466(class_272.field_1407));
                break;
            case 6:
                this.method_2387(this.field_1191.method_2466(class_272.field_1437));
                break;
            case 7:
                this.method_2387(this.field_1191.method_2466(class_272.field_1419));
                break;
            case 8:
                this.method_2387(this.field_1191.method_2466(class_272.field_1413));
                break;
            case 9:
                this.method_2387(this.field_1191.method_2466(class_272.field_1417));
                break;
            case 10:
                this.method_2387(this.field_1191.method_2466(class_272.field_1418));
        }
    }

    public void method_2351(int var1, class_74 var2) {
        for (int var3 = 0; var3 < this.field_1192; ++var3) {
            class_74 var4 = this.field_1196[var3];
            if (var1 == var4.field_323) {
                var4.field_323 = this.field_1208;
                int var7;
                int var8;
                if (var4 instanceof class_75) {
                    int var10 = this.field_1208 - ((class_75)var4).field_331;
                    int[] var11 = var4.method_455();
                    var7 = 0;
                    for (var8 = var4.method_454(); var7 < var8; ++var7) {
                        int var9 = var11[var7];
                        this.method_2386(var9, var10);
                    }
                } else {
                    int[] var5 = var4.method_455();
                    int var6 = 0;
                    for (var7 = var4.method_454(); var6 < var7; ++var6) {
                        var8 = var5[var6];
                        this.method_2382(var2, var8);
                    }
                }
            }
        }
    }

    public void method_2352() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 87;
    }

    public void method_2353() {
        this.field_1192 = 0;
        this.field_1210 -= 2;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 88;
    }

    public void method_2354(class_40 var1) {
        if (++this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2355(class_40 var1) {
        this.field_1210 = 1;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
    }

    public void method_2356(class_67 var1) {
        byte var2 = 1;
        if (var1.field_301.field_177 == 8 || var1.field_301.field_177 == 7) {
            var2 = 2;
        }
        this.method_2181((byte) - 75, var2, var1.field_314, var1.field_302, var1.field_301);
    }

    public void method_2357(class_67 var1) {
        byte var2 = 1;
        if (var1.field_301.field_177 == 8 || var1.field_301.field_177 == 7) {
            var2 = 2;
        }
        this.method_2181((byte) - 77, var2, var1.field_314, var1.field_302, var1.field_301);
    }

    public void method_2358(class_65 var1) {
        if ((this.field_1195 & 28) != 0) {
            if (this.field_1187 == this.field_1202.length) {
                System.arraycopy(this.field_1202, 0, this.field_1202 = new class_65[this.field_1187 + 10], 0, this.field_1187);
            }
            this.field_1202[this.field_1187++] = var1;
            var1.field_310 = new int[4];
            var1.field_311 = 0;
        }
    }

    public void method_2359(class_40 var1) {}

    public void method_2360(int var1, int var2) {
        this.method_2361(var1, var2, false);
    }

    public void method_2361(int var1, int var2, boolean var3) {
        if ((this.field_1195 & 2) != 0 && var2 != 0 && (var1 != this.field_1208 || var3)) {
            if (this.field_1207 + 4 > this.field_1206.length) {
                System.arraycopy(this.field_1206, 0, this.field_1206 = new int[this.field_1207 << 1], 0, this.field_1207);
            }
            int var4;
            if (this.field_1207 > 0) {
                int var5 = this.field_1206[this.field_1207 - 1];
                int var7;
                if (this.field_1200 == this.field_1201) {
                    var4 = this.field_1200;
                } else {
                    int[] var6 = this.field_1199;
                    var7 = var6.length;
                    int var8;
                    int var9;
                    if (var5 == 1) {
                        byte var10;
                        if (var2 < var6[0]) {
                            var10 = 1;
                            if (var1 < this.field_1206[this.field_1207 - 2]) {
                                var8 = method_2081(this.field_1206, this.field_1207, var1);
                                if (var8 != -1 && (var8 <= 1 || this.field_1206[var8 - 1] != var10)) {
                                    if (this.field_1207 > 4 && this.field_1206[this.field_1207 - 4] > var1) {
                                        System.arraycopy(this.field_1206, var8, this.field_1206, var8 + 2, this.field_1207 - 2 - var8);
                                        this.field_1206[var8++] = var1;
                                        this.field_1206[var8] = var10;
                                    } else {
                                        this.field_1206[this.field_1207 - 2] = var1;
                                    }
                                }
                            }
                            this.field_1197 = this.field_1208;
                            return;
                        }
                        if (var7 == 1 || var2 < var6[1]) {
                            var10 = 2;
                            if (var1 <= this.field_1197) {
                                var8 = method_2081(this.field_1206, this.field_1207, var1);
                                if (var8 != -1) {
                                    var9 = this.method_2252(var1, var10);
                                    if (var9 != -1) {
                                        this.field_1206[var9] = var1;
                                    } else if (var8 < 1 || this.field_1206[var8 - 1] != var10) {
                                        System.arraycopy(this.field_1206, var8, this.field_1206, var8 + 2, this.field_1207 - var8);
                                        this.field_1206[var8++] = var1;
                                        this.field_1206[var8] = var10;
                                        this.field_1207 += 2;
                                    }
                                } else if (this.field_1208 != this.field_1197) {
                                    if (this.field_1197 != var1 && this.field_1197 != this.field_1206[this.field_1207 - 2]) {
                                        this.field_1206[this.field_1207++] = this.field_1197;
                                        this.field_1206[this.field_1207++] = var10;
                                    } else {
                                        this.field_1206[this.field_1207 - 1] = var10;
                                    }
                                } else if (this.field_1206[this.field_1207 - 1] < var10 && var3) {
                                    this.field_1206[this.field_1207 - 1] = var10;
                                }
                            } else {
                                this.field_1206[this.field_1207++] = var1;
                                this.field_1206[this.field_1207++] = var10;
                            }
                            this.field_1197 = this.field_1208;
                            return;
                        }
                        var4 = Util.method_1324(var2, this.field_1199, this.field_1200 - 1, this.field_1201 - 1);
                    } else if (var5 < var7) {
                        if (var6[var5 - 2] < var2) {
                            if (var2 < var6[var5 - 1]) {
                                if (var1 < this.field_1206[this.field_1207 - 2]) {
                                    var8 = method_2081(this.field_1206, this.field_1207, var1);
                                    if (var8 != -1 && (var8 <= 1 || this.field_1206[var8 - 1] != var5)) {
                                        if (this.field_1207 > 4 && this.field_1206[this.field_1207 - 4] > var1) {
                                            System.arraycopy(this.field_1206, var8, this.field_1206, var8 + 2, this.field_1207 - 2 - var8);
                                            this.field_1206[var8++] = var1;
                                            this.field_1206[var8] = var5;
                                        } else {
                                            this.field_1206[this.field_1207 - 2] = var1;
                                        }
                                    }
                                }
                                this.field_1197 = this.field_1208;
                                return;
                            }
                            if (var2 < var6[var5]) {
                                var4 = var5 + 1;
                                if (var1 <= this.field_1197) {
                                    var8 = method_2081(this.field_1206, this.field_1207, var1);
                                    if (var8 != -1) {
                                        var9 = this.method_2252(var1, var4);
                                        if (var9 != -1) {
                                            this.field_1206[var9] = var1;
                                        } else if (var8 < 1 || this.field_1206[var8 - 1] != var4) {
                                            System.arraycopy(this.field_1206, var8, this.field_1206, var8 + 2, this.field_1207 - var8);
                                            this.field_1206[var8++] = var1;
                                            this.field_1206[var8] = var4;
                                            this.field_1207 += 2;
                                        }
                                    } else if (this.field_1208 != this.field_1197) {
                                        if (this.field_1197 != var1 && this.field_1197 != this.field_1206[this.field_1207 - 2]) {
                                            this.field_1206[this.field_1207++] = this.field_1197;
                                            this.field_1206[this.field_1207++] = var4;
                                        } else {
                                            this.field_1206[this.field_1207 - 1] = var4;
                                        }
                                    } else if (this.field_1206[this.field_1207 - 1] < var4 && var3) {
                                        this.field_1206[this.field_1207 - 1] = var4;
                                    }
                                } else {
                                    this.field_1206[this.field_1207++] = var1;
                                    this.field_1206[this.field_1207++] = var4;
                                }
                                this.field_1197 = this.field_1208;
                                return;
                            }
                            var4 = Util.method_1324(var2, this.field_1199, this.field_1200 - 1, this.field_1201 - 1);
                        } else {
                            var4 = Util.method_1324(var2, this.field_1199, this.field_1200 - 1, this.field_1201 - 1);
                        }
                    } else {
                        if (var6[var7 - 1] < var2) {
                            var4 = var7 + 1;
                            if (var1 <= this.field_1197) {
                                var8 = method_2081(this.field_1206, this.field_1207, var1);
                                if (var8 != -1) {
                                    var9 = this.method_2252(var1, var4);
                                    if (var9 != -1) {
                                        this.field_1206[var9] = var1;
                                    } else if (var8 < 1 || this.field_1206[var8 - 1] != var4) {
                                        System.arraycopy(this.field_1206, var8, this.field_1206, var8 + 2, this.field_1207 - var8);
                                        this.field_1206[var8++] = var1;
                                        this.field_1206[var8] = var4;
                                        this.field_1207 += 2;
                                    }
                                } else if (this.field_1208 != this.field_1197) {
                                    if (this.field_1197 != var1 && this.field_1197 != this.field_1206[this.field_1207 - 2]) {
                                        this.field_1206[this.field_1207++] = this.field_1197;
                                        this.field_1206[this.field_1207++] = var4;
                                    } else {
                                        this.field_1206[this.field_1207 - 1] = var4;
                                    }
                                } else if (this.field_1206[this.field_1207 - 1] < var4 && var3) {
                                    this.field_1206[this.field_1207 - 1] = var4;
                                }
                            } else {
                                this.field_1206[this.field_1207++] = var1;
                                this.field_1206[this.field_1207++] = var4;
                            }
                            this.field_1197 = this.field_1208;
                            return;
                        }
                        var4 = Util.method_1324(var2, this.field_1199, this.field_1200 - 1, this.field_1201 - 1);
                    }
                }
                int var11;
                if (var5 != var4) {
                    if (var1 <= this.field_1197) {
                        var11 = method_2081(this.field_1206, this.field_1207, var1);
                        if (var11 != -1) {
                            var7 = this.method_2252(var1, var4);
                            if (var7 != -1) {
                                this.field_1206[var7] = var1;
                            } else if (var11 < 1 || this.field_1206[var11 - 1] != var4) {
                                System.arraycopy(this.field_1206, var11, this.field_1206, var11 + 2, this.field_1207 - var11);
                                this.field_1206[var11++] = var1;
                                this.field_1206[var11] = var4;
                                this.field_1207 += 2;
                            }
                        } else if (this.field_1208 != this.field_1197) {
                            if (this.field_1197 != var1 && this.field_1197 != this.field_1206[this.field_1207 - 2]) {
                                this.field_1206[this.field_1207++] = this.field_1197;
                                this.field_1206[this.field_1207++] = var4;
                            } else {
                                this.field_1206[this.field_1207 - 1] = var4;
                            }
                        } else if (this.field_1206[this.field_1207 - 1] < var4 && var3) {
                            this.field_1206[this.field_1207 - 1] = var4;
                        }
                    } else {
                        this.field_1206[this.field_1207++] = var1;
                        this.field_1206[this.field_1207++] = var4;
                    }
                } else if (var1 < this.field_1206[this.field_1207 - 2]) {
                    var11 = method_2081(this.field_1206, this.field_1207, var1);
                    if (var11 != -1 && (var11 <= 1 || this.field_1206[var11 - 1] != var4)) {
                        if (this.field_1207 > 4 && this.field_1206[this.field_1207 - 4] > var1) {
                            System.arraycopy(this.field_1206, var11, this.field_1206, var11 + 2, this.field_1207 - 2 - var11);
                            this.field_1206[var11++] = var1;
                            this.field_1206[var11] = var4;
                        } else {
                            this.field_1206[this.field_1207 - 2] = var1;
                        }
                    }
                }
                this.field_1197 = this.field_1208;
            } else {
                boolean var12 = false;
                if (this.field_1200 == this.field_1201) {
                    var4 = this.field_1200;
                } else {
                    var4 = Util.method_1324(var2, this.field_1199, this.field_1200 - 1, this.field_1201 - 1);
                }
                this.field_1206[this.field_1207++] = var1;
                this.field_1206[this.field_1207++] = var4;
                this.field_1197 = this.field_1208;
            }
        }
    }

    public void method_2362(class_73 var1) {
        int var2;
        if (this.field_1194 == (var2 = this.field_1193.length)) {
            System.arraycopy(this.field_1193, 0, this.field_1193 = new class_73[var2 + 5], 0, var2);
        }
        this.field_1193[this.field_1194++] = var1;
    }

    public void method_2363(class_83 var1, int var2) {
        if ((this.field_1195 & 28) != 0) {
            for (int var3 = 0; var3 < this.field_1215; ++var3) {
                class_65 var4 = this.field_1214[var3];
                if (var4 != null && !this.method_2286(var1, var2, var4) && var4.field_311 > 0) {
                    var4.method_414(this.field_1208);
                }
            }
        }
    }

    public void method_2364() {
        if (this.field_1207 != 0) {
            while (this.field_1207 >= 2 && this.field_1206[this.field_1207 - 2] > this.field_1208) {
                this.field_1207 -= 2;
            }
        }
    }

    public void method_2365(class_65 var1) {
        if (var1 != null) {
            if (var1.field_311 > 0) {
                var1.method_414(this.field_1208);
            }
            for (int var2 = this.field_1215 - 1; var2 >= 0; --var2) {
                class_65 var3 = this.field_1214[var2];
                if (var3 == var1) {
                    this.field_1214[var2] = null;
                    return;
                }
            }
        }
    }

    public void method_2366(class_93 var1, class_288 var2) {
        this.method_2255(var2);
        this.field_1205 = var1;
        int[] var3 = this.field_1199;
        if (var3 != null) {
            int var4 = var3.length;
            int var5 = var4 - 1;
            if (!var1.method_794() && !var1.method_795()) {
                int var6 = Util.method_1324(var1.field_490, var3, 0, var5);
                this.field_1200 = var6;
                if (var6 > var5) {
                    this.field_1201 = var6;
                } else {
                    int var7 = Util.method_1324(var1.field_491, var3, var6 - 1, var5);
                    if (var7 >= var5) {
                        var7 = var4;
                    }
                    this.field_1201 = var7 == 0 ? 1 : var7;
                }
            } else {
                this.field_1200 = 1;
                this.field_1201 = var4 == 0 ? 1 : var4;
            }
        }
        this.field_1209 = var1.field_478.method_577().field_1933;
        this.method_2256(var1.field_488);
    }

    public void method_2367(class_288 var1) {
        this.field_1213 = var1.field_1731;
        int var2 = var1.field_1728;
        this.field_1195 = var2;
        if ((var2 & 2) != 0) {
            this.field_1199 = var1.field_1729.field_258.method_645().field_455.method_2921();
        } else {
            this.field_1199 = null;
        }
    }

    public void method_2368(class_288 var1) {
        this.method_2255(var1);
        this.method_2256((class_58)null);
    }

    private final void method_2369() {
        int var1 = this.field_1188.length;
        int var2 = var1 + var1;
        if (this.field_1190 >= var2) {
            var2 = this.field_1190 + var1;
        }
        System.arraycopy(this.field_1188, 0, this.field_1188 = new byte[var2], 0, var1);
    }

    public final void method_2370(int var1) {
        this.field_1192 = 0;
        if (var1 > 255) {
            if (this.field_1190 + 3 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -60;
            this.field_1188[this.field_1190++] = -87;
            this.method_2387(var1);
        } else {
            if (this.field_1190 + 1 >= this.field_1188.length) {
                this.method_2369();
            }
            this.field_1208 += 2;
            this.field_1188[this.field_1190++] = -87;
            this.field_1188[this.field_1190++] = (byte)var1;
        }
    }

    public void method_2371() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -79;
        this.field_1198 = this.field_1208;
    }

    public void method_2372() {
        this.field_1192 = 0;
        --this.field_1210;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 53;
    }

    public void method_2373() {
        this.field_1192 = 0;
        this.field_1210 -= 3;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 86;
    }

    public void method_2374(int var1, int var2) {
        switch (var2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                switch (var1) {
                    case 2:
                        this.method_2219();
                        break;
                    case 3:
                        this.method_2283();
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 11:
                    case 12:
                    case 18:
                    default:
                        break;
                    case 8:
                        this.method_2296();
                        break;
                    case 9:
                        this.method_2228();
                        break;
                    case 10:
                        this.method_2287();
                        break;
                    case 13:
                        this.method_2294();
                        break;
                    case 14:
                        this.method_2217();
                        break;
                    case 15:
                        this.method_2251();
                        break;
                    case 16:
                        this.method_2284();
                        break;
                    case 17:
                        this.method_2288();
                        break;
                    case 19:
                        this.method_2295();
                }
            case 6:
            default:
                break;
            case 7:
                switch (var1) {
                    case 2:
                        this.method_2304();
                        return;
                    case 3:
                        this.method_2327();
                        return;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 11:
                    case 12:
                    case 18:
                    default:
                        return;
                    case 8:
                        this.method_2339();
                        return;
                    case 9:
                        this.method_2316();
                        return;
                    case 10:
                        this.method_2330();
                        return;
                    case 13:
                        this.method_2337();
                        return;
                    case 14:
                        this.method_2302();
                        return;
                    case 15:
                        this.method_2322();
                        return;
                    case 16:
                        this.method_2328();
                        return;
                    case 17:
                        this.method_2331();
                        return;
                    case 19:
                        this.method_2338();
                        return;
                }
            case 8:
                switch (var1) {
                    case 9:
                        this.method_2124();
                        return;
                    case 10:
                    case 11:
                    case 12:
                    default:
                        return;
                    case 13:
                        this.method_2140();
                        return;
                    case 14:
                        this.method_2117();
                        return;
                    case 15:
                        this.method_2131();
                        return;
                    case 16:
                        this.method_2133();
                        return;
                }
            case 9:
                switch (var1) {
                    case 9:
                        this.method_2160();
                    case 10:
                    case 11:
                    case 12:
                    default:
                        break;
                    case 13:
                        this.method_2175();
                        break;
                    case 14:
                        this.method_2152();
                        break;
                    case 15:
                        this.method_2166();
                        break;
                    case 16:
                        this.method_2168();
                }
        }
    }

    public void method_2375(int var1) {
        this.field_1192 = 0;
        ++this.field_1210;
        if (this.field_1210 > this.field_1211) {
            this.field_1211 = this.field_1210;
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 17;
        this.method_2383(var1);
    }

    public void method_2376(class_65 var1, boolean var2) {
        int var3 = var1.field_306;
        switch (var1.field_301.field_177) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                if (var2) {
                    this.method_2141();
                }
                switch (var3) {
                    case 0:
                        this.method_2290();
                        return;
                    case 1:
                        this.method_2291();
                        return;
                    case 2:
                        this.method_2292();
                        return;
                    case 3:
                        this.method_2293();
                        return;
                    default:
                        this.method_2289(var3);
                        return;
                }
            case 6:
            default:
                if (var2) {
                    this.method_2141();
                }
                switch (var3) {
                    case 0:
                        this.method_2103();
                        return;
                    case 1:
                        this.method_2104();
                        return;
                    case 2:
                        this.method_2105();
                        return;
                    case 3:
                        this.method_2106();
                        return;
                    default:
                        this.method_2102(var3);
                        return;
                }
            case 7:
                if (var2) {
                    this.method_2144();
                }
                switch (var3) {
                    case 0:
                        this.method_2333();
                        return;
                    case 1:
                        this.method_2334();
                        return;
                    case 2:
                        this.method_2335();
                        return;
                    case 3:
                        this.method_2336();
                        return;
                    default:
                        this.method_2332(var3);
                        return;
                }
            case 8:
                if (var2) {
                    this.method_2144();
                }
                switch (var3) {
                    case 0:
                        this.method_2136();
                        return;
                    case 1:
                        this.method_2137();
                        return;
                    case 2:
                        this.method_2138();
                        return;
                    case 3:
                        this.method_2139();
                        return;
                    default:
                        this.method_2135(var3);
                        return;
                }
            case 9:
                if (var2) {
                    this.method_2141();
                }
                switch (var3) {
                    case 0:
                        this.method_2171();
                        break;
                    case 1:
                        this.method_2172();
                        break;
                    case 2:
                        this.method_2173();
                        break;
                    case 3:
                        this.method_2174();
                        break;
                    default:
                        this.method_2170(var3);
                }
        }
    }

    public void method_2377() {
        this.field_1192 = 0;
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = 95;
    }

    public void method_2378(class_75 var1, int var2, int var3, int[] var4, int[] var5, class_75[] var6) {
        this.field_1192 = 0;
        --this.field_1210;
        int var7 = var6.length;
        int var8 = this.field_1208;
        var1.method_459();
        int var9;
        for (var9 = 0; var9 < var7; ++var9) {
            var6[var9].method_459();
        }
        if (this.field_1190 >= this.field_1188.length) {
            this.method_2369();
        }
        ++this.field_1208;
        this.field_1188[this.field_1190++] = -86;
        for (var9 = 3 - (var8 & 3); var9 > 0; --var9) {
            if (this.field_1190 >= this.field_1188.length) {
                this.method_2369();
            }
            ++this.field_1208;
            this.field_1188[this.field_1190++] = 0;
        }
        var1.method_452();
        this.method_2385(var2);
        this.method_2385(var3);
        var9 = var2;
        int var10 = var2;
        while (true) {
            int var11;
            int var12 = var4[var11 = var5[var10 - var2]];
            if (var12 == var9) {
                var6[var11].method_452();
                ++var10;
                if (var9 == var3) {
                    return;
                }
            } else {
                var1.method_452();
            }
            ++var9;
        }
    }

    public void method_2379(class_65 var1) {
        this.method_2324(var1);
        this.method_2107();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer("( position:");
        var1.append(this.field_1208);
        var1.append(",\nstackDepth:");
        var1.append(this.field_1210);
        var1.append(",\nmaxStack:");
        var1.append(this.field_1211);
        var1.append(",\nmaxLocals:");
        var1.append(this.field_1204);
        var1.append(")");
        return var1.toString();
    }

    public void method_2380(class_83 var1, int var2) {
        if ((this.field_1195 & 2) != 0) {
            this.field_1197 = var2;
        }
        if ((this.field_1195 & 28) != 0) {
            int var3 = 0;
            for (int var4 = this.field_1202.length; var3 < var4; ++var3) {
                class_65 var5 = this.field_1202[var3];
                if (var5 != null && var5.field_308 == var1 && var5.field_311 > 0 && var5.field_310[(var5.field_311 - 1 << 1) + 1] == var2) {
                    var5.field_310[(var5.field_311 - 1 << 1) + 1] = this.field_1208;
                }
            }
        }
    }

    protected void method_2381(class_74 var1) {
        int var2 = var1.field_323 - this.field_1208 + 1;
        if (Math.abs(var2) > 32767 && !this.field_1216) {
            class_244 var10000 = new class_244(field_1186, (class_235)null);
            throw var10000;
        } else {
            this.method_2383(var2);
            int[] var3 = var1.method_455();
            int var4 = 0;
            for (int var5 = var1.method_454(); var4 < var5; ++var4) {
                this.method_2382(var1, var3[var4]);
            }
        }
    }

    protected void method_2382(class_74 var1, int var2) {
        int var3 = var1.field_323 - var2 + 1;
        if (Math.abs(var3) > 32767 && !this.field_1216) {
            class_244 var10000 = new class_244(field_1186, (class_235)null);
            throw var10000;
        } else {
            if (this.field_1216) {
                if ((var1.field_330 & 1) != 0) {
                    this.method_2386(var2, var3);
                } else {
                    this.method_2384(var2, var3);
                }
            } else {
                this.method_2384(var2, var3);
            }
        }
    }

    private final void method_2383(int var1) {
        if (this.field_1190 + 1 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1208 += 2;
        this.field_1188[this.field_1190++] = (byte)(var1 >> 8);
        this.field_1188[this.field_1190++] = (byte)var1;
    }

    private final void method_2384(int var1, int var2) {
        int var3 = this.field_1212 + var1;
        if (var3 + 1 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1188[var3] = (byte)(var2 >> 8);
        this.field_1188[var3 + 1] = (byte)var2;
    }

    protected final void method_2385(int var1) {
        if (this.field_1190 + 3 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1208 += 4;
        this.field_1188[this.field_1190++] = (byte)((var1 & -16777216) >> 24);
        this.field_1188[this.field_1190++] = (byte)((var1 & 16711680) >> 16);
        this.field_1188[this.field_1190++] = (byte)((var1 & '\uff00') >> 8);
        this.field_1188[this.field_1190++] = (byte)(var1 & 255);
    }

    protected void method_2386(int var1, int var2) {
        int var3 = this.field_1212 + var1;
        if (var3 + 3 >= this.field_1188.length) {
            this.method_2369();
        }
        this.field_1188[var3++] = (byte)((var2 & -16777216) >> 24);
        this.field_1188[var3++] = (byte)((var2 & 16711680) >> 16);
        this.field_1188[var3++] = (byte)((var2 & '\uff00') >> 8);
        this.field_1188[var3++] = (byte)(var2 & 255);
    }

    private final void method_2387(int var1) {
        this.field_1208 += 2;
        this.field_1188[this.field_1190++] = (byte)(var1 >>> 8);
        this.field_1188[this.field_1190++] = (byte)var1;
    }

    protected void method_2388(class_74 var1) {
        int var2 = var1.field_323;
        int var3 = var2 - this.field_1208 + 1;
        this.method_2385(var3);
        int[] var4 = var1.method_455();
        int var5 = 0;
        for (int var6 = var1.method_454(); var5 < var6; ++var5) {
            int var7 = var4[var5];
            var3 = var2 - var7 + 1;
            this.method_2386(var7, var3);
        }
    }

    static {
        field_1181 = new class_67[0];
        field_1182 = new class_73[5];
        field_1183 = new class_74[5];
        field_1184 = new class_65[10];
        field_1185 = new class_65[10];
        class_284 var10000 = new class_284((String)null, 0, 0, 0);
        field_1186 = var10000;
    }
}
