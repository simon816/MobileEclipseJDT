package j;

import b.InvalidInputException;
import b.CharOperation;
import c.class_284;
import f.Util;
import j.class_279;
import j.class_346;

public class Scanner {

    public long field_1223;

    public long field_1224;

    public boolean field_1225;

    public boolean field_1226;

    public boolean field_1227;

    public boolean field_1228;

    public char field_1229;

    public int field_1230;

    public int field_1231;

    public int field_1232;

    public int field_1233;

    public boolean field_1234;

    public boolean field_1235;

    public boolean field_1236;

    public char[] field_1237;

    public char[] field_1238;

    public int field_1239;

    public boolean field_1240;

    public boolean field_1241;

    public int[] field_1242;

    public int[] field_1243;

    public int[] field_1244;

    public int field_1245;

    protected int field_1246;

    public char[][] field_1247;

    public char[][] field_1248;

    public char[][] field_1249;

    public int[][] field_1250;

    public int field_1251;

    public char[][] field_1252;

    public char[][] field_1253;

    public boolean field_1254;

    public boolean field_1255;

    public int[] field_1256;

    public int field_1257;

    public boolean field_1258;

    private static final int[] field_1259;

    static final char[] field_1260;

    static final char[] field_1261;

    static final char[] field_1262;

    static final char[] field_1263;

    static final char[] field_1264;

    static final char[] field_1265;

    static final char[] field_1266;

    static final char[] field_1267;

    static final char[] field_1268;

    static final char[] field_1269;

    static final char[] field_1270;

    static final char[] field_1271;

    static final char[] field_1272;

    static final char[] field_1273;

    static final char[] field_1274;

    static final char[] field_1275;

    static final char[] field_1276;

    static final char[] field_1277;

    static final char[] field_1278;

    static final char[] field_1279;

    static final char[] field_1280;

    static final char[] field_1281;

    static final char[] field_1282;

    static final char[] field_1283;

    static final char[] field_1284;

    static final char[] field_1285;

    static final char[] field_1286;

    public final char[][][][] field_1287;

    public static final char[] field_1288;

    public static final int field_1289;

    private class_279[] field_1290;

    protected int field_1291;

    public boolean field_1292;

    protected int field_1293;

    public boolean field_1294;

    int field_1295;

    int field_1296;

    int field_1297;

    int field_1298;

    int field_1299;

    public boolean field_1300;

    public Scanner() {
        this(false, false, false, 3080192L, (char[][])null, (char[][])null, true);
    }

    public Scanner(boolean var1, boolean var2, boolean var3, long var4, long var6, char[][] var8, char[][] var9, boolean var10) {
        this.field_1225 = false;
        this.field_1226 = false;
        this.field_1227 = false;
        this.field_1228 = false;
        this.field_1234 = false;
        this.field_1235 = false;
        this.field_1236 = false;
        this.field_1240 = false;
        this.field_1241 = false;
        this.field_1242 = new int[30];
        this.field_1243 = new int[30];
        this.field_1244 = new int[30];
        this.field_1245 = -1;
        this.field_1246 = -1;
        this.field_1247 = (char[][])null;
        this.field_1249 = (char[][])null;
        this.field_1251 = 0;
        this.field_1252 = (char[][])null;
        this.field_1253 = (char[][])null;
        this.field_1254 = true;
        this.field_1255 = false;
        this.field_1256 = new int[250];
        this.field_1257 = -1;
        this.field_1258 = false;
        this.field_1287 = new char[7][30][6][];
        this.field_1290 = null;
        this.field_1294 = false;
        int var11;
        int var13;
        for (var11 = 0; var11 < 6; ++var11) {
            for (int var12 = 0; var12 < 30; ++var12) {
                for (var13 = 0; var13 < 6; ++var13) {
                    this.field_1287[var11][var12][var13] = field_1286;
                }
            }
        }
        this.field_1295 = 0;
        this.field_1296 = 0;
        this.field_1297 = 0;
        this.field_1298 = 0;
        this.field_1299 = 0;
        this.field_1300 = false;
        this.field_1233 = Integer.MAX_VALUE;
        this.field_1235 = var1;
        this.field_1236 = var2;
        this.field_1223 = var4;
        this.field_1224 = var6;
        this.field_1292 = var3;
        if (var8 != null) {
            var11 = var8.length;
            if (var9 != null) {
                int[] var15 = new int[var11];
                for (var13 = 0; var13 < var11; var15[var13] = var13++) {
                    ;
                }
                Util.method_1326(var8, 0, var8.length - 1, var15);
                char[][] var16 = new char[var11][];
                for (int var14 = 0; var14 < var11; ++var14) {
                    var16[var14] = var9[var15[var14]];
                }
                this.field_1253 = var16;
            } else {
                Util.method_1325(var8, 0, var8.length - 1);
            }
            this.field_1252 = var8;
            this.field_1254 = var10;
        }
    }

    public Scanner(boolean var1, boolean var2, boolean var3, long var4, char[][] var6, char[][] var7, boolean var8) {
        this(var1, var2, var3, var4, var4, var6, var7, var8);
    }

    public final boolean method_2405() {
        return this.field_1233 <= this.field_1231;
    }

    public void method_2406(int var1, int var2) {
        char[] var3 = this.field_1237;
        if (this.field_1251 <= 0 || this.field_1250[this.field_1251 - 1][0] < var1) {
            int var4 = this.field_1251;
            char var5 = var3[var1 + 1];
            int var9;
            int var10;
            for (int var6 = var1 + 2; var6 < var2 && var6 < this.field_1233; ++var6) {
                Object var7 = null;
                Object var8 = null;
                if (var5 != 64) {
                    label188:
                    for (var9 = 0; var9 < this.field_1252.length; ++var9) {
                        char[] var16 = this.field_1252[var9];
                        var10 = var16.length;
                        if (var10 != 0 && (!class_346.method_3335(var16[0]) || !class_346.method_3333(var5))) {
                            for (int var11 = 0; var11 < var10; ++var11) {
                                int var14 = var6 + var11;
                                char var12;
                                char var13;
                                if (var14 >= this.field_1233 || var14 >= var2 || (var12 = var3[var6 + var11]) != (var13 = var16[var11]) && (this.field_1254 || class_346.method_3341(var12) != class_346.method_3341(var13))) {
                                    continue label188;
                                }
                            }
                            if (var6 + var10 >= var2 || !class_346.method_3333(var3[var6 + var10 - 1]) || !class_346.method_3333(var3[var6 + var10])) {
                                if (this.field_1247 == null) {
                                    this.field_1247 = new char[5][];
                                    this.field_1248 = new char[5][];
                                    this.field_1249 = new char[5][];
                                    this.field_1250 = new int[5][];
                                } else if (this.field_1251 == this.field_1247.length) {
                                    System.arraycopy(this.field_1247, 0, this.field_1247 = new char[this.field_1251 * 2][], 0, this.field_1251);
                                    System.arraycopy(this.field_1248, 0, this.field_1248 = new char[this.field_1251 * 2][], 0, this.field_1251);
                                    System.arraycopy(this.field_1249, 0, this.field_1249 = new char[this.field_1251 * 2][], 0, this.field_1251);
                                    System.arraycopy(this.field_1250, 0, this.field_1250 = new int[this.field_1251 * 2][], 0, this.field_1251);
                                }
                                char[] var19 = this.field_1253 != null && var9 < this.field_1253.length ? this.field_1253[var9] : null;
                                this.field_1247[this.field_1251] = var16;
                                this.field_1249[this.field_1251] = var19;
                                this.field_1250[this.field_1251] = new int[] {var6, var6 + var10 - 1};
                                this.field_1248[this.field_1251] = CharOperation.field_994;
                                ++this.field_1251;
                                var6 += var10 - 1;
                                break;
                            }
                        }
                    }
                }
                var5 = var3[var6];
            }
            boolean var15 = false;
            int var17 = var4;
            int var18;
            while (var17 < this.field_1251) {
                var18 = this.field_1250[var17][0] + this.field_1247[var17].length;
                var9 = var17 + 1 < this.field_1251 ? this.field_1250[var17 + 1][0] - 1 : var2 - 1;
                if (var9 < var18) {
                    var9 = var18;
                }
                var10 = -1;
                int var20 = var18;
                while (true) {
                    if (var20 < var9) {
                        char var21;
                        if ((var21 = var3[var20]) != 10 && var21 != 13) {
                            ++var20;
                            continue;
                        }
                        var10 = var20 - 1;
                    }
                    if (var10 == -1) {
                        for (var20 = var9; var20 > var18; --var20) {
                            if (var3[var20] == 42) {
                                var10 = var20 - 1;
                                break;
                            }
                        }
                        if (var10 == -1) {
                            var10 = var9;
                        }
                    }
                    if (var18 == var10) {
                        var15 = true;
                    } else {
                        while (CharOperation.method_1370(var3[var10]) && var18 <= var10) {
                            --var10;
                        }
                        while (CharOperation.method_1370(var3[var18]) && var18 <= var10) {
                            ++var18;
                        }
                        this.field_1250[var17][1] = var10;
                        var20 = var10 - var18 + 1;
                        char[] var22 = new char[var20];
                        System.arraycopy(var3, var18, var22, 0, var20);
                        this.field_1248[var17] = var22;
                    }
                    ++var17;
                    break;
                }
            }
            if (var15) {
                var17 = var4;
                for (var18 = this.field_1251; var17 < var18; ++var17) {
                    if (this.field_1248[var17].length == 0) {
                        for (var9 = var17 + 1; var9 < var18; ++var9) {
                            if (this.field_1248[var9].length != 0) {
                                this.field_1248[var17] = this.field_1248[var9];
                                this.field_1250[var17][1] = this.field_1250[var9][1];
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public char[] method_2407() {
        char[] var1;
        if (this.field_1239 != 0) {
            System.arraycopy(this.field_1238, 1, var1 = new char[this.field_1239], 0, this.field_1239);
        } else {
            int var2 = this.field_1231 - this.field_1230;
            if (var2 == this.field_1233) {
                return this.field_1237;
            }
            switch (var2) {
                case 1:
                    return this.method_2424();
                case 2:
                    return this.method_2425();
                case 3:
                    return this.method_2426();
                case 4:
                    return this.method_2427();
                case 5:
                    return this.method_2428();
                case 6:
                    return this.method_2429();
                default:
                    System.arraycopy(this.field_1237, this.field_1230, var1 = new char[var2], 0, var2);
            }
        }
        return var1;
    }

    public int method_2408() {
        return this.field_1231 - 1;
    }

    public char[] method_2409() {
        char[] var1;
        if (this.field_1239 != 0) {
            System.arraycopy(this.field_1238, 1, var1 = new char[this.field_1239], 0, this.field_1239);
        } else {
            int var2;
            System.arraycopy(this.field_1237, this.field_1230, var1 = new char[var2 = this.field_1231 - this.field_1230], 0, var2);
        }
        return var1;
    }

    public char[] method_2410() {
        char[] var1;
        if (this.field_1239 != 0) {
            System.arraycopy(this.field_1238, 2, var1 = new char[this.field_1239 - 2], 0, this.field_1239 - 2);
        } else {
            int var2;
            System.arraycopy(this.field_1237, this.field_1230 + 1, var1 = new char[var2 = this.field_1231 - this.field_1230 - 2], 0, var2);
        }
        return var1;
    }

    public int method_2411() {
        return this.field_1230;
    }

    public final int[] method_2412() {
        if (this.field_1257 == -1) {
            return field_1259;
        } else {
            int[] var1;
            System.arraycopy(this.field_1256, 0, var1 = new int[this.field_1257 + 1], 0, this.field_1257 + 1);
            return var1;
        }
    }

    public final int method_2413() {
        try {
            if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                this.method_2420();
            } else {
                this.field_1240 = false;
                if (this.field_1239 != 0) {
                    this.method_2443();
                }
            }
            return this.field_1229;
        } catch (IndexOutOfBoundsException var2) {
            return -1;
        } catch (InvalidInputException var3) {
            return -1;
        }
    }

    public final boolean method_2414(char var1) {
        if (this.field_1231 >= this.field_1233) {
            this.field_1240 = false;
            return false;
        } else {
            int var2 = this.field_1231;
            try {
                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                    this.method_2420();
                    if (this.field_1229 != var1) {
                        this.field_1231 = var2;
                        --this.field_1239;
                        return false;
                    } else {
                        return true;
                    }
                } else if (this.field_1229 != var1) {
                    this.field_1231 = var2;
                    return false;
                } else {
                    this.field_1240 = false;
                    if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    return true;
                }
            } catch (IndexOutOfBoundsException var4) {
                this.field_1240 = false;
                this.field_1231 = var2;
                return false;
            } catch (InvalidInputException var5) {
                this.field_1240 = false;
                this.field_1231 = var2;
                return false;
            }
        }
    }

    public final int method_2415(char var1, char var2) {
        if (this.field_1231 >= this.field_1233) {
            return -1;
        } else {
            int var3 = this.field_1231;
            try {
                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                    this.method_2420();
                    byte var7;
                    if (this.field_1229 == var1) {
                        var7 = 0;
                    } else if (this.field_1229 == var2) {
                        var7 = 1;
                    } else {
                        this.field_1231 = var3;
                        --this.field_1239;
                        var7 = -1;
                    }
                    return var7;
                } else {
                    byte var4;
                    if (this.field_1229 == var1) {
                        var4 = 0;
                    } else {
                        if (this.field_1229 != var2) {
                            this.field_1231 = var3;
                            return -1;
                        }
                        var4 = 1;
                    }
                    if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    return var4;
                }
            } catch (IndexOutOfBoundsException var5) {
                this.field_1231 = var3;
                return -1;
            } catch (InvalidInputException var6) {
                this.field_1231 = var3;
                return -1;
            }
        }
    }

    public final boolean method_2416() {
        if (this.field_1231 >= this.field_1233) {
            return false;
        } else {
            int var1 = this.field_1231;
            try {
                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                    this.method_2420();
                    if (!class_346.method_3338(this.field_1229)) {
                        this.field_1231 = var1;
                        --this.field_1239;
                        return false;
                    } else {
                        return true;
                    }
                } else if (!class_346.method_3338(this.field_1229)) {
                    this.field_1231 = var1;
                    return false;
                } else {
                    if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    return true;
                }
            } catch (IndexOutOfBoundsException var3) {
                this.field_1231 = var1;
                return false;
            } catch (InvalidInputException var4) {
                this.field_1231 = var1;
                return false;
            }
        }
    }

    public final boolean method_2417(int var1) {
        if (this.field_1231 >= this.field_1233) {
            return false;
        } else {
            int var2 = this.field_1231;
            try {
                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                    this.method_2420();
                    if (class_346.method_3339(this.field_1229, var1) == -1) {
                        this.field_1231 = var2;
                        --this.field_1239;
                        return false;
                    } else {
                        return true;
                    }
                } else if (class_346.method_3339(this.field_1229, var1) == -1) {
                    this.field_1231 = var2;
                    return false;
                } else {
                    if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    return true;
                }
            } catch (IndexOutOfBoundsException var4) {
                this.field_1231 = var2;
                return false;
            } catch (InvalidInputException var5) {
                this.field_1231 = var2;
                return false;
            }
        }
    }

    public boolean method_2418() {
        int var1 = this.field_1231;
        if (this.field_1231 >= this.field_1233) {
            return false;
        } else {
            int var2 = this.field_1239;
            try {
                boolean var3 = false;
                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                    this.method_2420();
                    var3 = true;
                }
                char var4 = this.field_1229;
                boolean var5 = false;
                if (var4 >= '\ud800' && var4 <= '\udbff') {
                    if (this.field_1224 < 3211264L) {
                        this.field_1231 = var1;
                        this.field_1239 = var2;
                        return false;
                    }
                    char var6 = (char)this.method_2413();
                    if (var6 < '\udc00' || var6 > '\udfff') {
                        this.field_1231 = var1;
                        this.field_1239 = var2;
                        return false;
                    }
                    var5 = class_346.method_3334(var4, var6);
                } else {
                    if (var4 >= '\udc00' && var4 <= '\udfff') {
                        this.field_1231 = var1;
                        this.field_1239 = var2;
                        return false;
                    }
                    var5 = class_346.method_3333(var4);
                }
                if (var3) {
                    if (!var5) {
                        this.field_1231 = var1;
                        this.field_1239 = var2;
                        return false;
                    } else {
                        return true;
                    }
                } else if (!var5) {
                    this.field_1231 = var1;
                    return false;
                } else {
                    if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    return true;
                }
            } catch (IndexOutOfBoundsException var7) {
                this.field_1231 = var1;
                this.field_1239 = var2;
                return false;
            } catch (InvalidInputException var8) {
                this.field_1231 = var1;
                this.field_1239 = var2;
                return false;
            }
        }
    }

    public int method_2419() throws InvalidInputException {
        this.field_1258 = false;
        if (this.field_1255) {
            this.method_2422();
            this.field_1255 = false;
            return this.field_1231 > this.field_1233 ? 68 : 31;
        } else {
            byte var1 = 0;
            try {
                while (true) {
                    this.field_1239 = 0;
                    int var22 = this.field_1231;
                    boolean var3 = false;
                    boolean var6 = false;
                    boolean var2;
                    int var4;
                    int var5;
                    do {
                        var5 = this.field_1239;
                        var4 = this.field_1231;
                        this.field_1230 = this.field_1231;
                        try {
                            var6 = (this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117;
                        } catch (IndexOutOfBoundsException var18) {
                            if (this.field_1236 && var22 != this.field_1231 - 1) {
                                --this.field_1231;
                                this.field_1230 = var22;
                                return 1000;
                            }
                            if (this.field_1231 > this.field_1233) {
                                return 68;
                            }
                        }
                        if (this.field_1231 > this.field_1233) {
                            return 68;
                        }
                        if (var6) {
                            var2 = this.method_2423();
                            var4 = this.field_1231 - var4;
                        } else {
                            var4 = this.field_1231 - var4;
                            if ((this.field_1229 == 13 || this.field_1229 == 10) && this.field_1228) {
                                this.method_2432();
                            }
                            switch (this.field_1229) {
                                case 9:
                                case 10:
                                case 12:
                                case 13:
                                case 32:
                                    var2 = true;
                                    break;
                                default:
                                    var2 = false;
                            }
                        }
                        if (var2) {
                            var3 = true;
                        }
                    } while (var2);
                    if (var3) {
                        if (this.field_1236) {
                            this.field_1231 -= var4;
                            this.field_1230 = var22;
                            if (var6) {
                                this.field_1239 = var5;
                            }
                            return 1000;
                        }
                        if (var6) {
                            this.field_1239 = 0;
                            this.method_2443();
                        } else {
                            this.field_1239 = 0;
                        }
                    }
                    int var8;
                    boolean var9;
                    InvalidInputException var10000;
                    int var26;
                    switch (this.field_1229) {
                        case 26:
                            if (this.method_2405()) {
                                return 68;
                            }
                            var10000 = new InvalidInputException("Ctrl-Z");
                            throw var10000;
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 35:
                        case 36:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
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
                        case 92:
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
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        default:
                            char var27 = this.field_1229;
                            if (var27 < 128) {
                                if ((class_346.field_1984[var27] & 64) != 0) {
                                    return this.method_2437();
                                }
                                if ((class_346.field_1984[var27] & 4) != 0) {
                                    return this.method_2439(false);
                                }
                                return 110;
                            }
                            if (var27 >= '\ud800' && var27 <= '\udbff') {
                                if (this.field_1224 < 3211264L) {
                                    var10000 = new InvalidInputException("Invalid_Unicode_Escape");
                                    throw var10000;
                                }
                                char var23 = (char)this.method_2413();
                                if (var23 < '\udc00' || var23 > '\udfff') {
                                    var10000 = new InvalidInputException("Invalid_Low_Surrogate");
                                    throw var10000;
                                }
                                var9 = class_346.method_3336(var27, var23);
                            } else {
                                if (var27 >= '\udc00' && var27 <= '\udfff') {
                                    if (this.field_1224 < 3211264L) {
                                        var10000 = new InvalidInputException("Invalid_Unicode_Escape");
                                        throw var10000;
                                    }
                                    var10000 = new InvalidInputException("Invalid_High_Surrogate");
                                    throw var10000;
                                }
                                var9 = class_346.method_3335(var27);
                            }
                            if (var9) {
                                return this.method_2437();
                            }
                            if (class_346.method_3338(this.field_1229)) {
                                return this.method_2439(false);
                            }
                            return 110;
                        case 33:
                            if (this.method_2414('=')) {
                                return 19;
                            }
                            return 66;
                        case 34:
                            try {
                                this.field_1240 = false;
                                boolean var24 = false;
                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                    this.method_2420();
                                    var24 = true;
                                } else if (this.field_1239 != 0) {
                                    this.method_2443();
                                }
                                while (this.field_1229 != 34) {
                                    if (this.field_1229 == 10 || this.field_1229 == 13) {
                                        if (var24) {
                                            var26 = this.field_1231;
                                            for (int var25 = 0; var25 < 50; ++var25) {
                                                if (this.field_1231 >= this.field_1233) {
                                                    this.field_1231 = var26;
                                                    break;
                                                }
                                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                                    var24 = true;
                                                    this.method_2420();
                                                } else {
                                                    var24 = false;
                                                }
                                                if (!var24 && this.field_1229 == 10) {
                                                    --this.field_1231;
                                                    break;
                                                }
                                                if (this.field_1229 == 34) {
                                                    var10000 = new InvalidInputException("Invalid_Char_In_String");
                                                    throw var10000;
                                                }
                                            }
                                        } else {
                                            --this.field_1231;
                                        }
                                        var10000 = new InvalidInputException("Invalid_Char_In_String");
                                        throw var10000;
                                    }
                                    if (this.field_1229 == 92) {
                                        if (this.field_1240) {
                                            --this.field_1239;
                                            this.field_1240 = false;
                                            if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                                this.method_2420();
                                                var24 = true;
                                                --this.field_1239;
                                            } else {
                                                var24 = false;
                                            }
                                        } else {
                                            if (this.field_1239 == 0) {
                                                this.method_2442(this.field_1231 - this.field_1230);
                                            }
                                            --this.field_1239;
                                            this.field_1229 = this.field_1237[this.field_1231++];
                                        }
                                        this.method_2436();
                                        if (this.field_1239 != 0) {
                                            this.method_2443();
                                        }
                                    }
                                    this.field_1240 = false;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                        var24 = true;
                                    } else {
                                        var24 = false;
                                        if (this.field_1239 != 0) {
                                            this.method_2443();
                                        }
                                    }
                                }
                            } catch (IndexOutOfBoundsException var16) {
                                --this.field_1231;
                                var10000 = new InvalidInputException("Unterminated_String");
                                throw var10000;
                            } catch (InvalidInputException var17) {
                                if (var17.getMessage().equals("Invalid_Escape")) {
                                    for (var26 = 0; var26 < 50 && this.field_1231 + var26 != this.field_1233 && this.field_1237[this.field_1231 + var26] != 10; ++var26) {
                                        if (this.field_1237[this.field_1231 + var26] == 34) {
                                            this.field_1231 += var26 + 1;
                                            break;
                                        }
                                    }
                                }
                                throw var17;
                            }
                            return 52;
                        case 37:
                            if (this.method_2414('=')) {
                                return 91;
                            }
                            return 5;
                        case 38:
                            if ((var8 = this.method_2415('&', '=')) == 0) {
                                return 24;
                            }
                            if (var8 > 0) {
                                return 88;
                            }
                            return 20;
                        case 39:
                            if ((var8 = this.method_2415('\n', '\r')) == 0) {
                                var10000 = new InvalidInputException("Invalid_Character_Constant");
                                throw var10000;
                            }
                            if (var8 > 0) {
                                for (var26 = 0; var26 < 3 && this.field_1231 + var26 != this.field_1233 && this.field_1237[this.field_1231 + var26] != 10; ++var26) {
                                    if (this.field_1237[this.field_1231 + var26] == 39) {
                                        this.field_1231 += var26 + 1;
                                        break;
                                    }
                                }
                                var10000 = new InvalidInputException("Invalid_Character_Constant");
                                throw var10000;
                            }
                            if (this.method_2414('\'')) {
                                for (var8 = 0; var8 < 3 && this.field_1231 + var8 != this.field_1233 && this.field_1237[this.field_1231 + var8] != 10; ++var8) {
                                    if (this.field_1237[this.field_1231 + var8] == 39) {
                                        this.field_1231 += var8 + 1;
                                        break;
                                    }
                                }
                                var10000 = new InvalidInputException("Invalid_Character_Constant");
                                throw var10000;
                            }
                            if (this.method_2414('\\')) {
                                if (this.field_1240) {
                                    this.field_1240 = false;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                    } else if (this.field_1239 != 0) {
                                        this.method_2443();
                                    }
                                } else {
                                    this.field_1229 = this.field_1237[this.field_1231++];
                                }
                                this.method_2436();
                            } else {
                                this.field_1240 = false;
                                var6 = false;
                                try {
                                    var6 = (this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117;
                                } catch (IndexOutOfBoundsException var15) {
                                    --this.field_1231;
                                    var10000 = new InvalidInputException("Invalid_Character_Constant");
                                    throw var10000;
                                }
                                if (var6) {
                                    this.method_2420();
                                } else if (this.field_1239 != 0) {
                                    this.method_2443();
                                }
                            }
                            if (this.method_2414('\'')) {
                                return 51;
                            }
                            for (var8 = 0; var8 < 20 && this.field_1231 + var8 != this.field_1233 && this.field_1237[this.field_1231 + var8] != 10; ++var8) {
                                if (this.field_1237[this.field_1231 + var8] == 39) {
                                    this.field_1231 += var8 + 1;
                                    break;
                                }
                            }
                            var10000 = new InvalidInputException("Invalid_Character_Constant");
                            throw var10000;
                        case 40:
                            return 28;
                        case 41:
                            return 29;
                        case 42:
                            if (this.method_2414('=')) {
                                return 86;
                            }
                            return 4;
                        case 43:
                            if ((var8 = this.method_2415('+', '=')) == 0) {
                                return 8;
                            }
                            if (var8 > 0) {
                                return 84;
                            }
                            return 1;
                        case 44:
                            return 30;
                        case 45:
                            if ((var8 = this.method_2415('-', '=')) == 0) {
                                return 9;
                            }
                            if (var8 > 0) {
                                return 85;
                            }
                            return 2;
                        case 46:
                            if (this.method_2416()) {
                                return this.method_2439(true);
                            }
                            int var7 = this.field_1231;
                            if (this.method_2414('.')) {
                                if (this.method_2414('.')) {
                                    return 107;
                                }
                                this.field_1231 = var7;
                                return 3;
                            }
                            this.field_1231 = var7;
                            return 3;
                        case 47:
                            if (this.field_1234) {
                                return this.method_2414('=') ? 87 : 6;
                            }
                            var8 = this.method_2415('/', '*');
                            if (var8 == 0) {
                                this.field_1246 = this.field_1231;
                                try {
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                    }
                                    if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                        ++this.field_1231;
                                    }
                                    var9 = false;
                                    while (this.field_1229 != 13 && this.field_1229 != 10) {
                                        this.field_1246 = this.field_1231;
                                        var9 = false;
                                        if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                            this.method_2420();
                                            var9 = true;
                                        }
                                        if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                            ++this.field_1231;
                                        }
                                    }
                                    if (this.field_1229 == 13 && this.field_1233 > this.field_1231) {
                                        if (this.field_1237[this.field_1231] == 10) {
                                            ++this.field_1231;
                                            this.field_1229 = 10;
                                        } else if (this.field_1237[this.field_1231] == 92 && this.field_1237[this.field_1231 + 1] == 117) {
                                            this.method_2420();
                                            var9 = true;
                                        }
                                    }
                                    this.method_2434(1001);
                                    if (this.field_1252 != null) {
                                        this.method_2406(this.field_1230, this.field_1231);
                                    }
                                    if (this.field_1229 == 13 || this.field_1229 == 10) {
                                        if (this.field_1292 && this.field_1293 < this.field_1231) {
                                            this.method_2430();
                                        }
                                        if (this.field_1228) {
                                            if (var9) {
                                                this.method_2433();
                                            } else {
                                                this.method_2432();
                                            }
                                        }
                                    }
                                    if (this.field_1235) {
                                        return 1001;
                                    }
                                } catch (IndexOutOfBoundsException var19) {
                                    --this.field_1231;
                                    this.method_2434(1001);
                                    if (this.field_1252 != null) {
                                        this.method_2406(this.field_1230, this.field_1231);
                                    }
                                    if (this.field_1292 && this.field_1293 < this.field_1231) {
                                        this.method_2430();
                                    }
                                    if (this.field_1235) {
                                        return 1001;
                                    }
                                    ++this.field_1231;
                                }
                            } else {
                                if (var8 <= 0) {
                                    return this.method_2414('=') ? 87 : 6;
                                }
                                try {
                                    var9 = false;
                                    boolean var10 = false;
                                    boolean var11 = false;
                                    this.field_1240 = false;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                        var11 = true;
                                    } else {
                                        var11 = false;
                                        if (this.field_1239 != 0) {
                                            this.method_2443();
                                        }
                                    }
                                    if (this.field_1229 == 42) {
                                        var9 = true;
                                        var10 = true;
                                    }
                                    if ((this.field_1229 == 13 || this.field_1229 == 10) && this.field_1228) {
                                        if (var11) {
                                            this.method_2433();
                                        } else {
                                            this.method_2432();
                                        }
                                    }
                                    var11 = false;
                                    int var12 = this.field_1231;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                        var11 = true;
                                    } else {
                                        var11 = false;
                                    }
                                    if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                        ++this.field_1231;
                                    }
                                    if (this.field_1229 == 47) {
                                        var9 = false;
                                    }
                                    int var13 = 0;
                                    while (this.field_1229 != 47 || !var10) {
                                        if ((this.field_1229 == 13 || this.field_1229 == 10) && this.field_1228) {
                                            if (var11) {
                                                this.method_2433();
                                            } else {
                                                this.method_2432();
                                            }
                                        }
                                        switch (this.field_1229) {
                                            case 42:
                                                var10 = true;
                                                break;
                                            case 64:
                                                if (var13 == 0) {
                                                    var13 = var12;
                                                }
                                            default:
                                                var10 = false;
                                        }
                                        var12 = this.field_1231;
                                        if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                            this.method_2420();
                                            var11 = true;
                                        } else {
                                            var11 = false;
                                        }
                                        if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                            ++this.field_1231;
                                        }
                                    }
                                    int var14 = var9 ? 1003 : 1002;
                                    this.method_2434(var14);
                                    this.field_1244[this.field_1245] = var13;
                                    if (this.field_1252 != null) {
                                        this.method_2406(this.field_1230, this.field_1231);
                                    }
                                    if (this.field_1235) {
                                        return var14;
                                    }
                                } catch (IndexOutOfBoundsException var20) {
                                    --this.field_1231;
                                    var10000 = new InvalidInputException("Unterminated_Comment");
                                    throw var10000;
                                }
                            }
                            break;
                        case 58:
                            return 65;
                        case 59:
                            return 27;
                        case 60:
                            if ((var8 = this.method_2415('=', '<')) == 0) {
                                return 15;
                            }
                            if (var8 > 0) {
                                if (this.method_2414('=')) {
                                    return 92;
                                }
                                return 17;
                            }
                            return 7;
                        case 61:
                            if (this.method_2414('=')) {
                                return 18;
                            }
                            return 71;
                        case 62:
                            if (this.field_1294) {
                                return 13;
                            }
                            if ((var8 = this.method_2415('=', '>')) == 0) {
                                return 16;
                            }
                            if (var8 > 0) {
                                if ((var8 = this.method_2415('=', '>')) == 0) {
                                    return 93;
                                }
                                if (var8 > 0) {
                                    if (this.method_2414('=')) {
                                        return 94;
                                    }
                                    return 11;
                                }
                                return 10;
                            }
                            return 13;
                        case 63:
                            return 23;
                        case 64:
                            return 53;
                        case 91:
                            return 14;
                        case 93:
                            return 70;
                        case 94:
                            if (this.method_2414('=')) {
                                return 90;
                            }
                            return 21;
                        case 123:
                            return 69;
                        case 124:
                            if ((var8 = this.method_2415('|', '=')) == 0) {
                                return 25;
                            }
                            if (var8 > 0) {
                                return 89;
                            }
                            return 22;
                        case 125:
                            return 31;
                        case 126:
                            return 67;
                    }
                }
            } catch (IndexOutOfBoundsException var21) {
                if (this.field_1236 && var1 != this.field_1231 - 1) {
                    --this.field_1231;
                    this.field_1230 = var1;
                    return 1000;
                } else {
                    return 68;
                }
            }
        }
    }

    public void method_2420() throws InvalidInputException {
        boolean var1 = false;
        boolean var2 = false;
        boolean var3 = false;
        boolean var4 = false;
        int var5 = 6;
        ++this.field_1231;
        InvalidInputException var10000;
        if (this.field_1231 < this.field_1233) {
            while (this.field_1237[this.field_1231] == 117) {
                ++this.field_1231;
                if (this.field_1231 >= this.field_1233) {
                    --this.field_1231;
                    var10000 = new InvalidInputException("Invalid_Unicode_Escape");
                    throw var10000;
                }
                ++var5;
            }
            if (this.field_1231 + 4 > this.field_1233) {
                this.field_1231 += this.field_1233 - this.field_1231;
                var10000 = new InvalidInputException("Invalid_Unicode_Escape");
                throw var10000;
            } else {
                int var6;
                int var7;
                int var8;
                int var9;
                if ((var6 = class_346.method_3340(this.field_1237[this.field_1231++])) <= 15 && var6 >= 0 && (var7 = class_346.method_3340(this.field_1237[this.field_1231++])) <= 15 && var7 >= 0 && (var8 = class_346.method_3340(this.field_1237[this.field_1231++])) <= 15 && var8 >= 0 && (var9 = class_346.method_3340(this.field_1237[this.field_1231++])) <= 15 && var9 >= 0) {
                    this.field_1229 = (char)(((var6 * 16 + var7) * 16 + var8) * 16 + var9);
                    if (this.field_1239 == 0) {
                        this.method_2442(this.field_1231 - var5 - this.field_1230);
                    }
                    this.method_2443();
                    this.field_1240 = this.field_1229 == 92;
                } else {
                    var10000 = new InvalidInputException("Invalid_Unicode_Escape");
                    throw var10000;
                }
            }
        } else {
            --this.field_1231;
            var10000 = new InvalidInputException("Invalid_Unicode_Escape");
            throw var10000;
        }
    }

    public class_279[] method_2421() {
        int var1 = this.field_1291;
        if (var1 != 0) {
            class_279[] var2 = new class_279[var1];
            System.arraycopy(this.field_1290, 0, var2, 0, var1);
            this.field_1291 = 0;
            return var2;
        } else {
            return null;
        }
    }

    public final void method_2422() {
        this.field_1258 = false;
        int var1 = 1;
        try {
            label401:
            while (true) {
                this.field_1239 = 0;
                boolean var2;
                do {
                    this.field_1230 = this.field_1231;
                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                        var2 = this.method_2423();
                    } else {
                        if (this.field_1228 && (this.field_1229 == 13 || this.field_1229 == 10)) {
                            this.method_2432();
                        }
                        var2 = CharOperation.method_1370(this.field_1229);
                    }
                } while (var2);
                boolean var4;
                switch (this.field_1229) {
                    case 34:
                        try {
                            try {
                                this.field_1240 = false;
                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                    this.method_2420();
                                } else if (this.field_1239 != 0) {
                                    this.method_2443();
                                }
                            } catch (InvalidInputException var15) {
                                ;
                            }
                            while (true) {
                                if (this.field_1229 == 34) {
                                    continue label401;
                                }
                                if (this.field_1229 == 13) {
                                    if (this.field_1237[this.field_1231] == 10) {
                                        ++this.field_1231;
                                    }
                                    continue label401;
                                }
                                if (this.field_1229 == 10) {
                                    continue label401;
                                }
                                if (this.field_1229 == 92) {
                                    try {
                                        if (this.field_1240) {
                                            this.field_1240 = false;
                                            if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                                this.method_2420();
                                            } else if (this.field_1239 != 0) {
                                                this.method_2443();
                                            }
                                        } else {
                                            this.field_1229 = this.field_1237[this.field_1231++];
                                        }
                                        this.method_2436();
                                    } catch (InvalidInputException var13) {
                                        ;
                                    }
                                }
                                try {
                                    this.field_1240 = false;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                    } else if (this.field_1239 != 0) {
                                        this.method_2443();
                                    }
                                } catch (InvalidInputException var14) {
                                    ;
                                }
                            }
                        } catch (IndexOutOfBoundsException var16) {
                            return;
                        }
                    case 39:
                        boolean var20 = this.method_2414('\\');
                        if (var20) {
                            try {
                                if (this.field_1240) {
                                    this.field_1240 = false;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                    } else if (this.field_1239 != 0) {
                                        this.method_2443();
                                    }
                                } else {
                                    this.field_1229 = this.field_1237[this.field_1231++];
                                }
                                this.method_2436();
                            } catch (InvalidInputException var12) {
                                ;
                            }
                        } else {
                            try {
                                this.field_1240 = false;
                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                    this.method_2420();
                                } else if (this.field_1239 != 0) {
                                    this.method_2443();
                                }
                            } catch (InvalidInputException var11) {
                                ;
                            }
                        }
                        this.method_2414('\'');
                        break;
                    case 47:
                        int var3;
                        if ((var3 = this.method_2415('/', '*')) == 0) {
                            try {
                                this.field_1246 = this.field_1231;
                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                    this.method_2420();
                                }
                                if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                    ++this.field_1231;
                                }
                                var4 = false;
                                while (this.field_1229 != 13 && this.field_1229 != 10) {
                                    this.field_1246 = this.field_1231;
                                    var4 = false;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        var4 = true;
                                        this.method_2420();
                                    }
                                    if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                        ++this.field_1231;
                                    }
                                }
                                if (this.field_1229 == 13 && this.field_1233 > this.field_1231) {
                                    if (this.field_1237[this.field_1231] == 10) {
                                        ++this.field_1231;
                                        this.field_1229 = 10;
                                    } else if (this.field_1237[this.field_1231] == 92 && this.field_1237[this.field_1231 + 1] == 117) {
                                        var4 = true;
                                        this.method_2420();
                                    }
                                }
                                this.method_2434(1001);
                                if (!this.field_1228 || this.field_1229 != 13 && this.field_1229 != 10) {
                                    continue;
                                }
                                if (this.field_1292 && this.field_1293 < this.field_1231) {
                                    this.method_2430();
                                }
                                if (this.field_1228) {
                                    if (var4) {
                                        this.method_2433();
                                    } else {
                                        this.method_2432();
                                    }
                                }
                            } catch (IndexOutOfBoundsException var9) {
                                --this.field_1231;
                                this.method_2434(1001);
                                if (this.field_1292 && this.field_1293 < this.field_1231) {
                                    this.method_2430();
                                }
                                if (!this.field_1235) {
                                    ++this.field_1231;
                                }
                            }
                        } else {
                            if (var3 <= 0) {
                                continue;
                            }
                            var4 = false;
                            try {
                                boolean var5 = false;
                                boolean var7 = false;
                                this.field_1240 = false;
                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                    this.method_2420();
                                    var7 = true;
                                } else {
                                    var7 = false;
                                    if (this.field_1239 != 0) {
                                        this.method_2443();
                                    }
                                }
                                if (this.field_1229 == 42) {
                                    var4 = true;
                                    var5 = true;
                                }
                                if ((this.field_1229 == 13 || this.field_1229 == 10) && this.field_1228) {
                                    if (var7) {
                                        this.method_2433();
                                    } else {
                                        this.method_2432();
                                    }
                                }
                                var7 = false;
                                int var6 = this.field_1231;
                                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                    this.method_2420();
                                    var7 = true;
                                } else {
                                    var7 = false;
                                }
                                if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                    ++this.field_1231;
                                }
                                if (this.field_1229 == 47) {
                                    var4 = false;
                                }
                                int var8 = 0;
                                while (this.field_1229 != 47 || !var5) {
                                    if ((this.field_1229 == 13 || this.field_1229 == 10) && this.field_1228) {
                                        if (var7) {
                                            this.method_2433();
                                        } else {
                                            this.method_2432();
                                        }
                                    }
                                    switch (this.field_1229) {
                                        case 42:
                                            var5 = true;
                                            break;
                                        case 64:
                                            if (var8 == 0) {
                                                var8 = var6;
                                            }
                                        default:
                                            var5 = false;
                                    }
                                    var6 = this.field_1231;
                                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                                        this.method_2420();
                                        var7 = true;
                                    } else {
                                        var7 = false;
                                    }
                                    if (this.field_1229 == 92 && this.field_1237[this.field_1231] == 92) {
                                        ++this.field_1231;
                                    }
                                }
                                this.method_2434(var4 ? 1003 : 1002);
                                this.field_1244[this.field_1245] = var8;
                            } catch (IndexOutOfBoundsException var10) {
                                return;
                            }
                        }
                        break;
                    case 123:
                        ++var1;
                        break;
                    case 125:
                        --var1;
                        if (var1 == 0) {
                            return;
                        }
                        break;
                    default:
                        try {
                            char var21 = this.field_1229;
                            if (var21 < 128) {
                                if ((class_346.field_1984[var21] & 64) != 0) {
                                    this.method_2437();
                                } else if ((class_346.field_1984[var21] & 4) != 0) {
                                    this.method_2439(false);
                                }
                            } else {
                                if (var21 >= '\ud800' && var21 <= '\udbff') {
                                    if (this.field_1224 < 3211264L) {
                                        InvalidInputException var10000 = new InvalidInputException("Invalid_Unicode_Escape");
                                        throw var10000;
                                    }
                                    char var22 = (char)this.method_2413();
                                    if (var22 < '\udc00' || var22 > '\udfff') {
                                        continue;
                                    }
                                    var4 = class_346.method_3336(var21, var22);
                                } else {
                                    if (var21 >= '\udc00' && var21 <= '\udfff') {
                                        continue;
                                    }
                                    var4 = class_346.method_3335(var21);
                                }
                                if (var4) {
                                    this.method_2437();
                                }
                            }
                        } catch (InvalidInputException var17) {
                            ;
                        }
                }
            }
        } catch (IndexOutOfBoundsException var18) {
            ;
        } catch (InvalidInputException var19) {
            ;
        }
    }

    public final boolean method_2423() throws InvalidInputException {
        this.field_1258 = false;
        this.method_2420();
        return CharOperation.method_1370(this.field_1229);
    }

    final char[] method_2424() {
        char var1 = this.field_1237[this.field_1230];
        switch (var1) {
            case 97:
                return field_1260;
            case 98:
                return field_1261;
            case 99:
                return field_1262;
            case 100:
                return field_1263;
            case 101:
                return field_1264;
            case 102:
                return field_1265;
            case 103:
                return field_1266;
            case 104:
                return field_1267;
            case 105:
                return field_1268;
            case 106:
                return field_1269;
            case 107:
                return field_1270;
            case 108:
                return field_1271;
            case 109:
                return field_1272;
            case 110:
                return field_1273;
            case 111:
                return field_1274;
            case 112:
                return field_1275;
            case 113:
                return field_1276;
            case 114:
                return field_1277;
            case 115:
                return field_1278;
            case 116:
                return field_1279;
            case 117:
                return field_1280;
            case 118:
                return field_1281;
            case 119:
                return field_1282;
            case 120:
                return field_1283;
            case 121:
                return field_1284;
            case 122:
                return field_1285;
            default:
                return new char[] {var1};
        }
    }

    final char[] method_2425() {
        char[] var1 = this.field_1237;
        int var2 = this.field_1230;
        char var3;
        char var4;
        int var5 = (((var3 = var1[var2]) << 6) + (var4 = var1[var2 + 1])) % 30;
        char[][] var6 = this.field_1287[0][var5];
        int var7 = this.field_1295;
        char[] var8;
        do {
            ++var7;
            if (var7 >= 6) {
                var7 = -1;
                int var10 = this.field_1295;
                char[] var9;
                do {
                    ++var7;
                    if (var7 > var10) {
                        ++var10;
                        if (var10 >= 6) {
                            var10 = 0;
                        }
                        System.arraycopy(var1, var2, var9 = new char[2], 0, 2);
                        return var6[this.field_1295 = var10] = var9;
                    }
                    var9 = var6[var7];
                } while (var3 != var9[0] || var4 != var9[1]);
                return var9;
            }
            var8 = var6[var7];
        } while (var3 != var8[0] || var4 != var8[1]);
        return var8;
    }

    final char[] method_2426() {
        char[] var1 = this.field_1237;
        int var2 = this.field_1230;
        char var4 = var1[var2 + 1];
        char var3;
        char var5;
        int var6 = (((var3 = var1[var2]) << 6) + (var5 = var1[var2 + 2])) % 30;
        char[][] var7 = this.field_1287[1][var6];
        int var8 = this.field_1296;
        char[] var9;
        do {
            ++var8;
            if (var8 >= 6) {
                var8 = -1;
                int var11 = this.field_1296;
                char[] var10;
                do {
                    ++var8;
                    if (var8 > var11) {
                        ++var11;
                        if (var11 >= 6) {
                            var11 = 0;
                        }
                        System.arraycopy(var1, var2, var10 = new char[3], 0, 3);
                        return var7[this.field_1296 = var11] = var10;
                    }
                    var10 = var7[var8];
                } while (var3 != var10[0] || var4 != var10[1] || var5 != var10[2]);
                return var10;
            }
            var9 = var7[var8];
        } while (var3 != var9[0] || var4 != var9[1] || var5 != var9[2]);
        return var9;
    }

    final char[] method_2427() {
        char[] var1 = this.field_1237;
        int var2 = this.field_1230;
        char var4 = var1[var2 + 1];
        char var6 = var1[var2 + 3];
        char var3;
        char var5;
        int var7 = (((var3 = var1[var2]) << 6) + (var5 = var1[var2 + 2])) % 30;
        char[][] var8 = this.field_1287[2][var7];
        int var9 = this.field_1297;
        char[] var10;
        do {
            ++var9;
            if (var9 >= 6) {
                var9 = -1;
                int var12 = this.field_1297;
                char[] var11;
                do {
                    ++var9;
                    if (var9 > var12) {
                        ++var12;
                        if (var12 >= 6) {
                            var12 = 0;
                        }
                        System.arraycopy(var1, var2, var11 = new char[4], 0, 4);
                        return var8[this.field_1297 = var12] = var11;
                    }
                    var11 = var8[var9];
                } while (var3 != var11[0] || var4 != var11[1] || var5 != var11[2] || var6 != var11[3]);
                return var11;
            }
            var10 = var8[var9];
        } while (var3 != var10[0] || var4 != var10[1] || var5 != var10[2] || var6 != var10[3]);
        return var10;
    }

    final char[] method_2428() {
        char[] var1 = this.field_1237;
        int var2 = this.field_1230;
        char var4 = var1[var2 + 1];
        char var6 = var1[var2 + 3];
        char var3;
        char var5;
        char var7;
        int var8 = (((var3 = var1[var2]) << 12) + ((var5 = var1[var2 + 2]) << 6) + (var7 = var1[var2 + 4])) % 30;
        char[][] var9 = this.field_1287[3][var8];
        int var10 = this.field_1298;
        char[] var11;
        do {
            ++var10;
            if (var10 >= 6) {
                var10 = -1;
                int var13 = this.field_1298;
                char[] var12;
                do {
                    ++var10;
                    if (var10 > var13) {
                        ++var13;
                        if (var13 >= 6) {
                            var13 = 0;
                        }
                        System.arraycopy(var1, var2, var12 = new char[5], 0, 5);
                        return var9[this.field_1298 = var13] = var12;
                    }
                    var12 = var9[var10];
                } while (var3 != var12[0] || var4 != var12[1] || var5 != var12[2] || var6 != var12[3] || var7 != var12[4]);
                return var12;
            }
            var11 = var9[var10];
        } while (var3 != var11[0] || var4 != var11[1] || var5 != var11[2] || var6 != var11[3] || var7 != var11[4]);
        return var11;
    }

    final char[] method_2429() {
        char[] var1 = this.field_1237;
        int var2 = this.field_1230;
        char var4 = var1[var2 + 1];
        char var6 = var1[var2 + 3];
        char var8 = var1[var2 + 5];
        char var3;
        char var5;
        char var7;
        int var9 = (((var3 = var1[var2]) << 12) + ((var5 = var1[var2 + 2]) << 6) + (var7 = var1[var2 + 4])) % 30;
        char[][] var10 = this.field_1287[4][var9];
        int var11 = this.field_1299;
        char[] var12;
        do {
            ++var11;
            if (var11 >= 6) {
                var11 = -1;
                int var14 = this.field_1299;
                char[] var13;
                do {
                    ++var11;
                    if (var11 > var14) {
                        ++var14;
                        if (var14 >= 6) {
                            var14 = 0;
                        }
                        System.arraycopy(var1, var2, var13 = new char[6], 0, 6);
                        return var10[this.field_1299 = var14] = var13;
                    }
                    var13 = var10[var11];
                } while (var3 != var13[0] || var4 != var13[1] || var5 != var13[2] || var6 != var13[3] || var7 != var13[4] || var8 != var13[5]);
                return var13;
            }
            var12 = var10[var11];
        } while (var3 != var12[0] || var4 != var12[1] || var5 != var12[2] || var6 != var12[3] || var7 != var12[4] || var8 != var12[5]);
        return var12;
    }

    private void method_2430() {
        int var1 = 0;
        int var2 = this.field_1230;
        int var3 = this.field_1257;
        if (var3 >= 0) {
            var1 = this.field_1256[var3] + 1;
        }
        while (class_346.method_3343(this.field_1237[var1])) {
            ++var1;
        }
        if (var2 != var1) {
            Object var4 = null;
            int var5 = this.field_1231;
            int var6 = var2;
            int var7 = 0;
            char[] var15;
            if (this.field_1239 != 0) {
                System.arraycopy(this.field_1238, 1, var15 = new char[this.field_1239], 0, this.field_1239);
                var5 = this.field_1239;
                var6 = 1;
                var7 = var2;
            } else {
                var15 = this.field_1237;
            }
            int var8 = CharOperation.method_1373(field_1288, var15, true, var6, var5);
            if (var8 != -1) {
                if (this.field_1290 == null) {
                    this.field_1290 = new class_279[10];
                    this.field_1291 = 0;
                }
                int var10;
                for (; var8 != -1; var8 = CharOperation.method_1373(field_1288, var15, true, var10, var5)) {
                    int var9 = var8 + field_1289;
                    var10 = CharOperation.method_1375('$', var15, var9, var5);
                    if (var10 != -1) {
                        class_279 var11 = null;
                        int var12 = var3 + 1;
                        class_279 var10000;
                        try {
                            var10000 = new class_279(var8 + var7, var10 + var7, var12, this.method_2431(var15, var9, var10));
                            var11 = var10000;
                        } catch (NumberFormatException var14) {
                            var10000 = new class_279(var8 + var7, var10 + var7, var12, -1);
                            var11 = var10000;
                        }
                        if (this.field_1291 == this.field_1290.length) {
                            System.arraycopy(this.field_1290, 0, this.field_1290 = new class_279[this.field_1291 + 10], 0, this.field_1291);
                        }
                        this.field_1290[this.field_1291++] = var11;
                    } else {
                        var10 = var9;
                    }
                }
            }
        }
    }

    private int method_2431(char[] var1, int var2, int var3) {
        int var4 = 0;
        for (int var5 = var2; var5 < var3; ++var5) {
            char var6 = var1[var5];
            boolean var7 = false;
            byte var8;
            switch (var6) {
                case 48:
                    var8 = 0;
                    break;
                case 49:
                    var8 = 1;
                    break;
                case 50:
                    var8 = 2;
                    break;
                case 51:
                    var8 = 3;
                    break;
                case 52:
                    var8 = 4;
                    break;
                case 53:
                    var8 = 5;
                    break;
                case 54:
                    var8 = 6;
                    break;
                case 55:
                    var8 = 7;
                    break;
                case 56:
                    var8 = 8;
                    break;
                case 57:
                    var8 = 9;
                    break;
                default:
                    throw new NumberFormatException();
            }
            var4 *= 10;
            if (var8 < 0) {
                throw new NumberFormatException();
            }
            var4 += var8;
        }
        return var4;
    }

    public final void method_2432() {
        int var2;
        int var3;
        if (this.field_1229 == 13) {
            var2 = this.field_1231 - 1;
            if (this.field_1257 >= 0 && this.field_1256[this.field_1257] >= var2) {
                return;
            }
            var3 = this.field_1256.length;
            if (++this.field_1257 >= var3) {
                System.arraycopy(this.field_1256, 0, this.field_1256 = new int[var3 + 250], 0, var3);
            }
            this.field_1256[this.field_1257] = var2;
            try {
                if (this.field_1237[this.field_1231] == 10) {
                    this.field_1256[this.field_1257] = this.field_1231++;
                    this.field_1258 = false;
                } else {
                    this.field_1258 = true;
                }
            } catch (IndexOutOfBoundsException var5) {
                this.field_1258 = true;
            }
        } else if (this.field_1229 == 10) {
            if (this.field_1258 && this.field_1256[this.field_1257] == this.field_1231 - 2) {
                this.field_1256[this.field_1257] = this.field_1231 - 1;
            } else {
                var2 = this.field_1231 - 1;
                if (this.field_1257 >= 0 && this.field_1256[this.field_1257] >= var2) {
                    return;
                }
                var3 = this.field_1256.length;
                if (++this.field_1257 >= var3) {
                    System.arraycopy(this.field_1256, 0, this.field_1256 = new int[var3 + 250], 0, var3);
                }
                this.field_1256[this.field_1257] = var2;
            }
            this.field_1258 = false;
        }
    }

    public final void method_2433() {
        if (this.field_1229 == 13) {
            if (this.field_1237[this.field_1231] == 10) {
                this.field_1258 = false;
            } else {
                this.field_1258 = true;
            }
        } else if (this.field_1229 == 10) {
            this.field_1258 = false;
        }
    }

    public void method_2434(int var1) {
        int var2 = this.field_1231;
        switch (var1) {
            case 1001:
                var2 = -this.field_1246;
                break;
            case 1002:
                var2 = -this.field_1231;
        }
        int var3 = this.field_1242.length;
        if (++this.field_1245 >= var3) {
            int var4 = var3 + 300;
            System.arraycopy(this.field_1242, 0, this.field_1242 = new int[var4], 0, var3);
            System.arraycopy(this.field_1243, 0, this.field_1243 = new int[var4], 0, var3);
            System.arraycopy(this.field_1244, 0, this.field_1244 = new int[var4], 0, var3);
        }
        this.field_1242[this.field_1245] = var2;
        this.field_1243[this.field_1245] = this.field_1230;
    }

    public void method_2435(int var1, int var2) {
        this.field_1255 = false;
        this.field_1232 = this.field_1230 = this.field_1231 = var1;
        if (this.field_1237 != null && this.field_1237.length < var2) {
            this.field_1233 = this.field_1237.length;
        } else {
            this.field_1233 = var2 < Integer.MAX_VALUE ? var2 + 1 : var2;
        }
        this.field_1245 = -1;
        this.field_1251 = 0;
    }

    public final void method_2436() throws InvalidInputException {
        switch (this.field_1229) {
            case 34:
                this.field_1229 = 34;
                break;
            case 39:
                this.field_1229 = 39;
                break;
            case 92:
                this.field_1229 = 92;
                break;
            case 98:
                this.field_1229 = 8;
                break;
            case 102:
                this.field_1229 = 12;
                break;
            case 110:
                this.field_1229 = 10;
                break;
            case 114:
                this.field_1229 = 13;
                break;
            case 116:
                this.field_1229 = 9;
                break;
            default:
                int var1 = class_346.method_3340(this.field_1229);
                InvalidInputException var10000;
                if (var1 < 0 || var1 > 7) {
                    var10000 = new InvalidInputException("Invalid_Escape");
                    throw var10000;
                }
                boolean var2 = var1 > 3;
                if (class_346.method_3338(this.field_1229 = this.field_1237[this.field_1231++])) {
                    int var3 = class_346.method_3340(this.field_1229);
                    if (var3 >= 0 && var3 <= 7) {
                        var1 = var1 * 8 + var3;
                        if (class_346.method_3338(this.field_1229 = this.field_1237[this.field_1231++])) {
                            if (var2) {
                                --this.field_1231;
                            } else {
                                var3 = class_346.method_3340(this.field_1229);
                                if (var3 >= 0 && var3 <= 7) {
                                    var1 = var1 * 8 + var3;
                                } else {
                                    --this.field_1231;
                                }
                            }
                        } else {
                            --this.field_1231;
                        }
                    } else {
                        --this.field_1231;
                    }
                } else {
                    --this.field_1231;
                }
                if (var1 > 255) {
                    var10000 = new InvalidInputException("Invalid_Escape");
                    throw var10000;
                }
                this.field_1229 = (char)var1;
        }
    }

    public int method_2437() {
        this.field_1225 = false;
        this.field_1227 = false;
        char[] var1 = this.field_1237;
        int var3 = this.field_1233;
        int var2;
        label49:
        while (true) {
            var2 = this.field_1231;
            if (this.field_1231 >= var3) {
                break;
            }
            char var4 = var1[var2];
            if (var4 < 128) {
                if ((class_346.field_1984[var4] & 60) != 0) {
                    if (this.field_1239 != 0) {
                        this.field_1229 = var4;
                        this.method_2443();
                    }
                    ++this.field_1231;
                    continue;
                }
                if ((class_346.field_1984[var4] & 258) != 0) {
                    this.field_1229 = var4;
                } else {
                    while (true) {
                        if (this.method_2418()) {
                            continue;
                        }
                    }
                }
                break;
            }
            while (true) {
                if (this.method_2418()) {
                    continue;
                }
                break label49;
            }
        }
        char[] var5;
        if (this.field_1239 == 0) {
            if ((var3 = this.field_1231 - this.field_1230) == 1) {
                return 26;
            }
            var5 = this.field_1237;
            var2 = this.field_1230;
        } else {
            var3 = this.field_1239;
            if (this.field_1239 == 1) {
                return 26;
            }
            var5 = this.field_1238;
            var2 = 1;
        }
        return this.method_2438(var2, var3, var5);
    }

    private int method_2438(int var1, int var2, char[] var3) {
        switch (var3[var1]) {
            case 97:
                switch (var2) {
                    case 6:
                        ++var1;
                        if (var3[var1] == 115) {
                            ++var1;
                            if (var3[var1] == 115) {
                                ++var1;
                                if (var3[var1] == 101) {
                                    ++var1;
                                    if (var3[var1] == 114) {
                                        ++var1;
                                        if (var3[var1] == 116) {
                                            if (this.field_1223 >= 3145728L) {
                                                this.field_1226 = true;
                                                return 74;
                                            }
                                            this.field_1225 = true;
                                            return 26;
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 8:
                        ++var1;
                        if (var3[var1] == 98) {
                            ++var1;
                            if (var3[var1] == 115) {
                                ++var1;
                                if (var3[var1] == 116) {
                                    ++var1;
                                    if (var3[var1] == 114) {
                                        ++var1;
                                        if (var3[var1] == 97) {
                                            ++var1;
                                            if (var3[var1] == 99) {
                                                ++var1;
                                                if (var3[var1] == 116) {
                                                    return 56;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    default:
                        return 26;
                }
            case 98:
                switch (var2) {
                    case 4:
                        ++var1;
                        if (var3[var1] == 121) {
                            ++var1;
                            if (var3[var1] == 116) {
                                ++var1;
                                if (var3[var1] == 101) {
                                    return 33;
                                }
                            }
                        }
                        return 26;
                    case 5:
                        ++var1;
                        if (var3[var1] == 114) {
                            ++var1;
                            if (var3[var1] == 101) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 107) {
                                        return 75;
                                    }
                                }
                            }
                        }
                        return 26;
                    case 6:
                    default:
                        return 26;
                    case 7:
                        ++var1;
                        if (var3[var1] == 111) {
                            ++var1;
                            if (var3[var1] == 111) {
                                ++var1;
                                if (var3[var1] == 108) {
                                    ++var1;
                                    if (var3[var1] == 101) {
                                        ++var1;
                                        if (var3[var1] == 97) {
                                            ++var1;
                                            if (var3[var1] == 110) {
                                                return 32;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 99:
                switch (var2) {
                    case 4:
                        ++var1;
                        if (var3[var1] == 97) {
                            ++var1;
                            if (var3[var1] == 115) {
                                ++var1;
                                if (var3[var1] == 101) {
                                    return 101;
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 104) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 114) {
                                        return 34;
                                    }
                                }
                            }
                            return 26;
                        }
                    case 5:
                        ++var1;
                        if (var3[var1] == 97) {
                            ++var1;
                            if (var3[var1] == 116) {
                                ++var1;
                                if (var3[var1] == 99) {
                                    ++var1;
                                    if (var3[var1] == 104) {
                                        return 102;
                                    }
                                }
                            }
                            return 26;
                        } else if (var3[var1] == 108) {
                            ++var1;
                            if (var3[var1] == 97) {
                                ++var1;
                                if (var3[var1] == 115) {
                                    ++var1;
                                    if (var3[var1] == 115) {
                                        return 72;
                                    }
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 111) {
                                ++var1;
                                if (var3[var1] == 110) {
                                    ++var1;
                                    if (var3[var1] == 115) {
                                        ++var1;
                                        if (var3[var1] == 116) {
                                            return 108;
                                        }
                                    }
                                }
                            }
                            return 26;
                        }
                    case 6:
                    case 7:
                    default:
                        return 26;
                    case 8:
                        ++var1;
                        if (var3[var1] == 111) {
                            ++var1;
                            if (var3[var1] == 110) {
                                ++var1;
                                if (var3[var1] == 116) {
                                    ++var1;
                                    if (var3[var1] == 105) {
                                        ++var1;
                                        if (var3[var1] == 110) {
                                            ++var1;
                                            if (var3[var1] == 117) {
                                                ++var1;
                                                if (var3[var1] == 101) {
                                                    return 76;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 100:
                switch (var2) {
                    case 2:
                        ++var1;
                        if (var3[var1] == 111) {
                            return 77;
                        }
                        return 26;
                    case 6:
                        ++var1;
                        if (var3[var1] == 111) {
                            ++var1;
                            if (var3[var1] == 117) {
                                ++var1;
                                if (var3[var1] == 98) {
                                    ++var1;
                                    if (var3[var1] == 108) {
                                        ++var1;
                                        if (var3[var1] == 101) {
                                            return 35;
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 7:
                        ++var1;
                        if (var3[var1] == 101) {
                            ++var1;
                            if (var3[var1] == 102) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 117) {
                                        ++var1;
                                        if (var3[var1] == 108) {
                                            ++var1;
                                            if (var3[var1] == 116) {
                                                return 97;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    default:
                        return 26;
                }
            case 101:
                switch (var2) {
                    case 4:
                        ++var1;
                        if (var3[var1] == 108) {
                            ++var1;
                            if (var3[var1] == 115) {
                                ++var1;
                                if (var3[var1] == 101) {
                                    return 103;
                                }
                            }
                        }
                        if (var3[var1] == 110) {
                            ++var1;
                            if (var3[var1] == 117) {
                                ++var1;
                                if (var3[var1] == 109) {
                                    if (this.field_1223 >= 3211264L) {
                                        return 98;
                                    }
                                    this.field_1227 = true;
                                    return 26;
                                }
                            }
                        }
                        return 26;
                    case 7:
                        ++var1;
                        if (var3[var1] == 120) {
                            ++var1;
                            if (var3[var1] == 116) {
                                ++var1;
                                if (var3[var1] == 101) {
                                    ++var1;
                                    if (var3[var1] == 110) {
                                        ++var1;
                                        if (var3[var1] == 100) {
                                            ++var1;
                                            if (var3[var1] == 115) {
                                                return 99;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    default:
                        return 26;
                }
            case 102:
                switch (var2) {
                    case 3:
                        ++var1;
                        if (var3[var1] == 111) {
                            ++var1;
                            if (var3[var1] == 114) {
                                return 78;
                            }
                        }
                        return 26;
                    case 4:
                    case 6:
                    default:
                        return 26;
                    case 5:
                        ++var1;
                        if (var3[var1] == 105) {
                            ++var1;
                            if (var3[var1] == 110) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 108) {
                                        return 57;
                                    }
                                }
                            }
                            return 26;
                        } else if (var3[var1] == 108) {
                            ++var1;
                            if (var3[var1] == 111) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 116) {
                                        return 36;
                                    }
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 97) {
                                ++var1;
                                if (var3[var1] == 108) {
                                    ++var1;
                                    if (var3[var1] == 115) {
                                        ++var1;
                                        if (var3[var1] == 101) {
                                            return 44;
                                        }
                                    }
                                }
                            }
                            return 26;
                        }
                    case 7:
                        ++var1;
                        if (var3[var1] == 105) {
                            ++var1;
                            if (var3[var1] == 110) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 108) {
                                        ++var1;
                                        if (var3[var1] == 108) {
                                            ++var1;
                                            if (var3[var1] == 121) {
                                                return 104;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 103:
                if (var2 == 4) {
                    ++var1;
                    if (var3[var1] == 111) {
                        ++var1;
                        if (var3[var1] == 116) {
                            ++var1;
                            if (var3[var1] == 111) {
                                return 109;
                            }
                        }
                    }
                }
                return 26;
            case 104:
            case 106:
            case 107:
            case 109:
            case 111:
            case 113:
            case 117:
            default:
                return 26;
            case 105:
                switch (var2) {
                    case 2:
                        ++var1;
                        if (var3[var1] == 102) {
                            return 79;
                        }
                        return 26;
                    case 3:
                        ++var1;
                        if (var3[var1] == 110) {
                            ++var1;
                            if (var3[var1] == 116) {
                                return 37;
                            }
                        }
                        return 26;
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    default:
                        return 26;
                    case 6:
                        ++var1;
                        if (var3[var1] == 109) {
                            ++var1;
                            if (var3[var1] == 112) {
                                ++var1;
                                if (var3[var1] == 111) {
                                    ++var1;
                                    if (var3[var1] == 114) {
                                        ++var1;
                                        if (var3[var1] == 116) {
                                            return 100;
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 9:
                        ++var1;
                        if (var3[var1] == 110) {
                            ++var1;
                            if (var3[var1] == 116) {
                                ++var1;
                                if (var3[var1] == 101) {
                                    ++var1;
                                    if (var3[var1] == 114) {
                                        ++var1;
                                        if (var3[var1] == 102) {
                                            ++var1;
                                            if (var3[var1] == 97) {
                                                ++var1;
                                                if (var3[var1] == 99) {
                                                    ++var1;
                                                    if (var3[var1] == 101) {
                                                        return 95;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 10:
                        ++var1;
                        if (var3[var1] == 109) {
                            ++var1;
                            if (var3[var1] == 112) {
                                ++var1;
                                if (var3[var1] == 108) {
                                    ++var1;
                                    if (var3[var1] == 101) {
                                        ++var1;
                                        if (var3[var1] == 109) {
                                            ++var1;
                                            if (var3[var1] == 101) {
                                                ++var1;
                                                if (var3[var1] == 110) {
                                                    ++var1;
                                                    if (var3[var1] == 116) {
                                                        ++var1;
                                                        if (var3[var1] == 115) {
                                                            return 106;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 110) {
                                ++var1;
                                if (var3[var1] == 115) {
                                    ++var1;
                                    if (var3[var1] == 116) {
                                        ++var1;
                                        if (var3[var1] == 97) {
                                            ++var1;
                                            if (var3[var1] == 110) {
                                                ++var1;
                                                if (var3[var1] == 99) {
                                                    ++var1;
                                                    if (var3[var1] == 101) {
                                                        ++var1;
                                                        if (var3[var1] == 111) {
                                                            ++var1;
                                                            if (var3[var1] == 102) {
                                                                return 12;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return 26;
                        }
                }
            case 108:
                if (var2 == 4) {
                    ++var1;
                    if (var3[var1] == 111) {
                        ++var1;
                        if (var3[var1] == 110) {
                            ++var1;
                            if (var3[var1] == 103) {
                                return 38;
                            }
                        }
                    }
                }
                return 26;
            case 110:
                switch (var2) {
                    case 3:
                        ++var1;
                        if (var3[var1] == 101) {
                            ++var1;
                            if (var3[var1] == 119) {
                                return 43;
                            }
                        }
                        return 26;
                    case 4:
                        ++var1;
                        if (var3[var1] == 117) {
                            ++var1;
                            if (var3[var1] == 108) {
                                ++var1;
                                if (var3[var1] == 108) {
                                    return 45;
                                }
                            }
                        }
                        return 26;
                    case 5:
                    default:
                        return 26;
                    case 6:
                        ++var1;
                        if (var3[var1] == 97) {
                            ++var1;
                            if (var3[var1] == 116) {
                                ++var1;
                                if (var3[var1] == 105) {
                                    ++var1;
                                    if (var3[var1] == 118) {
                                        ++var1;
                                        if (var3[var1] == 101) {
                                            return 58;
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 112:
                switch (var2) {
                    case 6:
                        ++var1;
                        if (var3[var1] == 117) {
                            ++var1;
                            if (var3[var1] == 98) {
                                ++var1;
                                if (var3[var1] == 108) {
                                    ++var1;
                                    if (var3[var1] == 105) {
                                        ++var1;
                                        if (var3[var1] == 99) {
                                            return 61;
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 7:
                        ++var1;
                        if (var3[var1] == 97) {
                            ++var1;
                            if (var3[var1] == 99) {
                                ++var1;
                                if (var3[var1] == 107) {
                                    ++var1;
                                    if (var3[var1] == 97) {
                                        ++var1;
                                        if (var3[var1] == 103) {
                                            ++var1;
                                            if (var3[var1] == 101) {
                                                return 96;
                                            }
                                        }
                                    }
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 114) {
                                ++var1;
                                if (var3[var1] == 105) {
                                    ++var1;
                                    if (var3[var1] == 118) {
                                        ++var1;
                                        if (var3[var1] == 97) {
                                            ++var1;
                                            if (var3[var1] == 116) {
                                                ++var1;
                                                if (var3[var1] == 101) {
                                                    return 59;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return 26;
                        }
                    case 8:
                    default:
                        return 26;
                    case 9:
                        ++var1;
                        if (var3[var1] == 114) {
                            ++var1;
                            if (var3[var1] == 111) {
                                ++var1;
                                if (var3[var1] == 116) {
                                    ++var1;
                                    if (var3[var1] == 101) {
                                        ++var1;
                                        if (var3[var1] == 99) {
                                            ++var1;
                                            if (var3[var1] == 116) {
                                                ++var1;
                                                if (var3[var1] == 101) {
                                                    ++var1;
                                                    if (var3[var1] == 100) {
                                                        return 60;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 114:
                if (var2 == 6) {
                    ++var1;
                    if (var3[var1] == 101) {
                        ++var1;
                        if (var3[var1] == 116) {
                            ++var1;
                            if (var3[var1] == 117) {
                                ++var1;
                                if (var3[var1] == 114) {
                                    ++var1;
                                    if (var3[var1] == 110) {
                                        return 80;
                                    }
                                }
                            }
                        }
                    }
                }
                return 26;
            case 115:
                switch (var2) {
                    case 5:
                        ++var1;
                        if (var3[var1] == 104) {
                            ++var1;
                            if (var3[var1] == 111) {
                                ++var1;
                                if (var3[var1] == 114) {
                                    ++var1;
                                    if (var3[var1] == 116) {
                                        return 39;
                                    }
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 117) {
                                ++var1;
                                if (var3[var1] == 112) {
                                    ++var1;
                                    if (var3[var1] == 101) {
                                        ++var1;
                                        if (var3[var1] == 114) {
                                            return 41;
                                        }
                                    }
                                }
                            }
                            return 26;
                        }
                    case 6:
                        ++var1;
                        if (var3[var1] == 116) {
                            ++var1;
                            if (var3[var1] == 97) {
                                ++var1;
                                if (var3[var1] == 116) {
                                    ++var1;
                                    if (var3[var1] == 105) {
                                        ++var1;
                                        if (var3[var1] == 99) {
                                            return 54;
                                        }
                                    }
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 119) {
                                ++var1;
                                if (var3[var1] == 105) {
                                    ++var1;
                                    if (var3[var1] == 116) {
                                        ++var1;
                                        if (var3[var1] == 99) {
                                            ++var1;
                                            if (var3[var1] == 104) {
                                                return 81;
                                            }
                                        }
                                    }
                                }
                            }
                            return 26;
                        }
                    case 7:
                    case 9:
                    case 10:
                    case 11:
                    default:
                        return 26;
                    case 8:
                        ++var1;
                        if (var3[var1] == 116) {
                            ++var1;
                            if (var3[var1] == 114) {
                                ++var1;
                                if (var3[var1] == 105) {
                                    ++var1;
                                    if (var3[var1] == 99) {
                                        ++var1;
                                        if (var3[var1] == 116) {
                                            ++var1;
                                            if (var3[var1] == 102) {
                                                ++var1;
                                                if (var3[var1] == 112) {
                                                    return 62;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 12:
                        ++var1;
                        if (var3[var1] == 121) {
                            ++var1;
                            if (var3[var1] == 110) {
                                ++var1;
                                if (var3[var1] == 99) {
                                    ++var1;
                                    if (var3[var1] == 104) {
                                        ++var1;
                                        if (var3[var1] == 114) {
                                            ++var1;
                                            if (var3[var1] == 111) {
                                                ++var1;
                                                if (var3[var1] == 110) {
                                                    ++var1;
                                                    if (var3[var1] == 105) {
                                                        ++var1;
                                                        if (var3[var1] == 122) {
                                                            ++var1;
                                                            if (var3[var1] == 101) {
                                                                ++var1;
                                                                if (var3[var1] == 100) {
                                                                    return 55;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 116:
                switch (var2) {
                    case 3:
                        ++var1;
                        if (var3[var1] == 114) {
                            ++var1;
                            if (var3[var1] == 121) {
                                return 83;
                            }
                        }
                        return 26;
                    case 4:
                        ++var1;
                        if (var3[var1] == 104) {
                            ++var1;
                            if (var3[var1] == 105) {
                                ++var1;
                                if (var3[var1] == 115) {
                                    return 42;
                                }
                            }
                            return 26;
                        } else {
                            if (var3[var1] == 114) {
                                ++var1;
                                if (var3[var1] == 117) {
                                    ++var1;
                                    if (var3[var1] == 101) {
                                        return 46;
                                    }
                                }
                            }
                            return 26;
                        }
                    case 5:
                        ++var1;
                        if (var3[var1] == 104) {
                            ++var1;
                            if (var3[var1] == 114) {
                                ++var1;
                                if (var3[var1] == 111) {
                                    ++var1;
                                    if (var3[var1] == 119) {
                                        return 82;
                                    }
                                }
                            }
                        }
                        return 26;
                    case 6:
                        ++var1;
                        if (var3[var1] == 104) {
                            ++var1;
                            if (var3[var1] == 114) {
                                ++var1;
                                if (var3[var1] == 111) {
                                    ++var1;
                                    if (var3[var1] == 119) {
                                        ++var1;
                                        if (var3[var1] == 115) {
                                            return 105;
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    case 7:
                    case 8:
                    default:
                        return 26;
                    case 9:
                        ++var1;
                        if (var3[var1] == 114) {
                            ++var1;
                            if (var3[var1] == 97) {
                                ++var1;
                                if (var3[var1] == 110) {
                                    ++var1;
                                    if (var3[var1] == 115) {
                                        ++var1;
                                        if (var3[var1] == 105) {
                                            ++var1;
                                            if (var3[var1] == 101) {
                                                ++var1;
                                                if (var3[var1] == 110) {
                                                    ++var1;
                                                    if (var3[var1] == 116) {
                                                        return 63;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                }
            case 118:
                switch (var2) {
                    case 4:
                        ++var1;
                        if (var3[var1] == 111) {
                            ++var1;
                            if (var3[var1] == 105) {
                                ++var1;
                                if (var3[var1] == 100) {
                                    return 40;
                                }
                            }
                        }
                        return 26;
                    case 8:
                        ++var1;
                        if (var3[var1] == 111) {
                            ++var1;
                            if (var3[var1] == 108) {
                                ++var1;
                                if (var3[var1] == 97) {
                                    ++var1;
                                    if (var3[var1] == 116) {
                                        ++var1;
                                        if (var3[var1] == 105) {
                                            ++var1;
                                            if (var3[var1] == 108) {
                                                ++var1;
                                                if (var3[var1] == 101) {
                                                    return 64;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 26;
                    default:
                        return 26;
                }
            case 119:
                switch (var2) {
                    case 5:
                        ++var1;
                        if (var3[var1] == 104) {
                            ++var1;
                            if (var3[var1] == 105) {
                                ++var1;
                                if (var3[var1] == 108) {
                                    ++var1;
                                    if (var3[var1] == 101) {
                                        return 73;
                                    }
                                }
                            }
                        }
                        return 26;
                    default:
                        return 26;
                }
        }
    }

    public int method_2439(boolean var1) throws InvalidInputException {
        boolean var2 = var1;
        InvalidInputException var10000;
        if (!var1 && this.field_1229 == 48) {
            if (this.method_2415('x', 'X') >= 0) {
                int var6 = this.field_1231;
                while (this.method_2417(16)) {
                    ;
                }
                int var4 = this.field_1231;
                if (this.method_2415('l', 'L') >= 0) {
                    if (var4 == var6) {
                        var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                        throw var10000;
                    }
                    return 48;
                }
                if (this.method_2414('.')) {
                    if (this.field_1223 < 3211264L) {
                        if (var4 == var6) {
                            var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                            throw var10000;
                        }
                        this.field_1231 = var4;
                        return 47;
                    }
                    boolean var5 = var4 == var6;
                    var6 = this.field_1231;
                    while (this.method_2417(16)) {
                        ;
                    }
                    var4 = this.field_1231;
                    if (var5 && var4 == var6) {
                        var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                        throw var10000;
                    }
                    if (this.method_2415('p', 'P') < 0) {
                        var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                        throw var10000;
                    }
                    this.field_1240 = false;
                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                        this.method_2420();
                    } else if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    if (this.field_1229 == 45 || this.field_1229 == 43) {
                        this.field_1240 = false;
                        if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                            this.method_2420();
                        } else if (this.field_1239 != 0) {
                            this.method_2443();
                        }
                    }
                    if (!class_346.method_3338(this.field_1229)) {
                        var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                        throw var10000;
                    }
                    while (this.method_2416()) {
                        ;
                    }
                    if (this.method_2415('f', 'F') >= 0) {
                        return 49;
                    }
                    if (this.method_2415('d', 'D') >= 0) {
                        return 50;
                    }
                    if (this.method_2415('l', 'L') >= 0) {
                        var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                        throw var10000;
                    }
                    return 50;
                }
                if (this.method_2415('p', 'P') >= 0) {
                    if (this.field_1223 < 3211264L) {
                        this.field_1231 = var4;
                        return 47;
                    }
                    this.field_1240 = false;
                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                        this.method_2420();
                    } else if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    if (this.field_1229 == 45 || this.field_1229 == 43) {
                        this.field_1240 = false;
                        if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                            this.method_2420();
                        } else if (this.field_1239 != 0) {
                            this.method_2443();
                        }
                    }
                    if (!class_346.method_3338(this.field_1229)) {
                        var10000 = new InvalidInputException("Invalid_Float_Literal");
                        throw var10000;
                    }
                    while (this.method_2416()) {
                        ;
                    }
                    if (this.method_2415('f', 'F') >= 0) {
                        return 49;
                    }
                    if (this.method_2415('d', 'D') >= 0) {
                        return 50;
                    }
                    if (this.method_2415('l', 'L') >= 0) {
                        var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                        throw var10000;
                    }
                    return 50;
                }
                if (var4 == var6) {
                    var10000 = new InvalidInputException("Invalid_Hexa_Literal");
                    throw var10000;
                }
                return 47;
            }
            if (this.method_2416()) {
                while (this.method_2416()) {
                    ;
                }
                if (this.method_2415('l', 'L') >= 0) {
                    return 48;
                }
                if (this.method_2415('f', 'F') >= 0) {
                    return 49;
                }
                if (this.method_2415('d', 'D') >= 0) {
                    return 50;
                }
                boolean var3 = true;
                if (this.method_2414('.')) {
                    var3 = false;
                    while (true) {
                        if (this.method_2416()) {
                            continue;
                        }
                    }
                }
                if (this.method_2415('e', 'E') >= 0) {
                    var3 = false;
                    this.field_1240 = false;
                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                        this.method_2420();
                    } else if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                    if (this.field_1229 == 45 || this.field_1229 == 43) {
                        this.field_1240 = false;
                        if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                            this.method_2420();
                        } else if (this.field_1239 != 0) {
                            this.method_2443();
                        }
                    }
                    if (!class_346.method_3338(this.field_1229)) {
                        var10000 = new InvalidInputException("Invalid_Float_Literal");
                        throw var10000;
                    }
                    while (true) {
                        if (this.method_2416()) {
                            continue;
                        }
                    }
                }
                if (this.method_2415('f', 'F') >= 0) {
                    return 49;
                }
                if (this.method_2415('d', 'D') < 0 && var3) {
                    return 47;
                }
                return 50;
            }
        }
        while (this.method_2416()) {
            ;
        }
        if (!var1 && this.method_2415('l', 'L') >= 0) {
            return 48;
        } else {
            if (!var1 && this.method_2414('.')) {
                while (true) {
                    if (!this.method_2416()) {
                        var2 = true;
                        break;
                    }
                }
            }
            if (this.method_2415('e', 'E') >= 0) {
                var2 = true;
                this.field_1240 = false;
                if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                    this.method_2420();
                } else if (this.field_1239 != 0) {
                    this.method_2443();
                }
                if (this.field_1229 == 45 || this.field_1229 == 43) {
                    this.field_1240 = false;
                    if ((this.field_1229 = this.field_1237[this.field_1231++]) == 92 && this.field_1237[this.field_1231] == 117) {
                        this.method_2420();
                    } else if (this.field_1239 != 0) {
                        this.method_2443();
                    }
                }
                if (!class_346.method_3338(this.field_1229)) {
                    var10000 = new InvalidInputException("Invalid_Float_Literal");
                    throw var10000;
                }
                while (true) {
                    if (this.method_2416()) {
                        continue;
                    }
                }
            }
            return this.method_2415('d', 'D') >= 0 ? 50 : (this.method_2415('f', 'F') >= 0 ? 49 : (var2 ? 50 : 47));
        }
    }

    public final void method_2440(char[] var1) {
        int var2;
        if (var1 == null) {
            this.field_1237 = CharOperation.field_994;
            var2 = 0;
        } else {
            this.field_1237 = var1;
            var2 = var1.length;
        }
        this.field_1230 = -1;
        this.field_1233 = var2;
        this.field_1232 = this.field_1231 = 0;
        this.field_1226 = false;
        this.field_1257 = -1;
    }

    public final void method_2441(char[] var1, class_284 var2) {
        if (var1 == null) {
            char[] var3 = var2.field_1677.method_51();
            this.method_2440(var3);
        } else {
            this.method_2440(var1);
        }
        int[] var4 = var2.field_1684;
        if (var4 != null) {
            this.field_1256 = var4;
            this.field_1257 = var4.length - 1;
        }
    }

    public String toString() {
        if (this.field_1230 == this.field_1233) {
            return "EOF\n\n" + new String(this.field_1237);
        } else if (this.field_1231 > this.field_1233) {
            return "behind the EOF\n\n" + new String(this.field_1237);
        } else if (this.field_1231 <= 0) {
            return "NOT started!\n\n" + new String(this.field_1237);
        } else {
            char[] var1 = new char[this.field_1230];
            System.arraycopy(this.field_1237, 0, var1, 0, this.field_1230);
            int var2 = this.field_1231 - 1 - this.field_1230 + 1;
            char[] var3;
            if (var2 > -1) {
                var3 = new char[var2];
                System.arraycopy(this.field_1237, this.field_1230, var3, 0, var2);
            } else {
                var3 = CharOperation.field_994;
            }
            char[] var4 = new char[this.field_1233 - (this.field_1231 - 1)];
            System.arraycopy(this.field_1237, this.field_1231 - 1 + 1, var4, 0, this.field_1233 - (this.field_1231 - 1) - 1);
            return new String(var1) + "\n===============================\nStarts here -->" + new String(var3) + "<-- Ends here\n===============================\n" + new String(var4);
        }
    }

    public void method_2442(int var1) {
        this.field_1239 = var1;
        if (this.field_1238 == null) {
            this.field_1238 = new char[var1 + 11];
        }
        int var2 = this.field_1238.length;
        if (1 + var1 >= var2) {
            System.arraycopy(this.field_1238, 0, this.field_1238 = new char[var1 + 11], 0, var2);
        }
        System.arraycopy(this.field_1237, this.field_1230, this.field_1238, 1, var1);
    }

    public void method_2443() {
        int var1 = ++this.field_1239;
        if (this.field_1238 == null) {
            this.field_1238 = new char[10];
        }
        int var2 = this.field_1238.length;
        if (var1 == var2) {
            System.arraycopy(this.field_1238, 0, this.field_1238 = new char[var2 * 2], 0, var2);
        }
        this.field_1238[var1] = this.field_1229;
    }

    static {
        field_1259 = Util.field_983;
        field_1260 = new char[] {'a'};
        field_1261 = new char[] {'b'};
        field_1262 = new char[] {'c'};
        field_1263 = new char[] {'d'};
        field_1264 = new char[] {'e'};
        field_1265 = new char[] {'f'};
        field_1266 = new char[] {'g'};
        field_1267 = new char[] {'h'};
        field_1268 = new char[] {'i'};
        field_1269 = new char[] {'j'};
        field_1270 = new char[] {'k'};
        field_1271 = new char[] {'l'};
        field_1272 = new char[] {'m'};
        field_1273 = new char[] {'n'};
        field_1274 = new char[] {'o'};
        field_1275 = new char[] {'p'};
        field_1276 = new char[] {'q'};
        field_1277 = new char[] {'r'};
        field_1278 = new char[] {'s'};
        field_1279 = new char[] {'t'};
        field_1280 = new char[] {'u'};
        field_1281 = new char[] {'v'};
        field_1282 = new char[] {'w'};
        field_1283 = new char[] {'x'};
        field_1284 = new char[] {'y'};
        field_1285 = new char[] {'z'};
        field_1286 = new char[] {'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        field_1288 = "//$NON-NLS-".toCharArray();
        field_1289 = field_1288.length;
    }
}
