package org.eclipse.jdt.internal.compiler.parser.diagnose;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.batch.eclipse;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;
import org.eclipse.jdt.internal.compiler.parser.diagnose.class_207;
import org.eclipse.jdt.internal.compiler.parser.diagnose.class_210;
import org.eclipse.jdt.internal.compiler.parser.diagnose.LexStream;
import org.eclipse.jdt.internal.compiler.parser.diagnose.class_224;
import org.eclipse.jdt.internal.compiler.parser.diagnose.class_227;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Util;

public class class_222 {

    private boolean field_947;

    private CompilerOptions field_948;

    private LexStream field_949;

    private int field_950;

    private int field_951;

    private int field_952;

    private int field_953;

    private int field_954;

    private int[] field_955;

    private int[] field_956;

    private int[] field_957;

    private int field_958;

    private int[] field_959;

    private int field_960;

    private int[] field_961;

    private int field_962;

    private int[] field_963;

    private int field_964;

    private int[] field_965;

    private int[] field_966;

    int[] field_967;

    int[] field_968;

    int[] field_969;

    int field_970;

    class_210[] field_971;

    private Parser field_972;

    private RecoveryScanner field_973;

    private boolean field_974;

    public class_222(Parser var1, int var2, int var3, int var4, CompilerOptions var5) {
        this(var1, var2, var3, var4, Util.field_983, Util.field_983, Util.field_983, var5);
    }

    public class_222(Parser var1, int var2, int var3, int var4, int[] var5, int[] var6, int[] var7, CompilerOptions var8) {
        this.field_947 = false;
        this.field_952 = 0;
        this.field_967 = new int[422];
        this.field_968 = new int[32];
        this.field_972 = var1;
        this.field_948 = var8;
        LexStream var10001 = new LexStream(32, var1.field_1628, var5, var6, var7, var2, var3, var4);
        this.field_949 = var10001;
        this.field_973 = var1.field_1627;
    }

    private ProblemReporter method_1286() {
        return this.field_972.method_2862();
    }

    private void method_1287() {
        int var1 = this.field_953;
        this.field_953 += 256;
        if (var1 == 0) {
            this.field_955 = new int[this.field_953];
            this.field_956 = new int[this.field_953];
            this.field_957 = new int[this.field_953];
            this.field_959 = new int[this.field_953];
            this.field_961 = new int[this.field_953];
            this.field_963 = new int[this.field_953];
            this.field_965 = new int[this.field_953];
            this.field_966 = new int[this.field_953];
        } else {
            System.arraycopy(this.field_955, 0, this.field_955 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_956, 0, this.field_956 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_957, 0, this.field_957 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_959, 0, this.field_959 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_961, 0, this.field_961 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_963, 0, this.field_963 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_965, 0, this.field_965 = new int[this.field_953], 0, var1);
            System.arraycopy(this.field_966, 0, this.field_966 = new int[this.field_953], 0, var1);
        }
    }

    public void method_1288(boolean var1) {
        this.field_974 = true;
        boolean var2 = false;
        if (this.field_973 != null) {
            var2 = this.field_973.field_1309;
            this.field_973.field_1309 = var1;
        }
        try {
            this.field_949.method_1209();
            this.field_952 = this.field_949.method_1205();
            int var6 = 731;
            this.method_1287();
            this.field_954 = 0;
            this.field_955[this.field_954] = var6;
            int var7 = this.field_949.method_1212(this.field_952);
            this.field_956[this.field_954] = this.field_952;
            this.field_957[this.field_954] = this.field_949.method_1215(this.field_952);
            boolean var8 = false;
            do {
                int var3 = -1;
                this.field_960 = -1;
                int var5 = -1;
                this.field_962 = -1;
                int var4 = this.field_954;
                this.field_958 = this.field_954 - 1;
                int var9;
                for (var9 = 0; var9 <= this.field_954; ++var9) {
                    this.field_959[var9] = this.field_955[var9];
                }
                for (var6 = Parser.method_2517(var6, var7); var6 <= 700; var6 = Parser.method_2517(var6, var7)) {
                    do {
                        this.field_958 -= Parser.field_1540[var6] - 1;
                        var6 = Parser.method_2509(this.field_959[this.field_958], Parser.field_1534[var6]);
                    } while (var6 <= 700);
                    if (this.field_958 + 1 >= this.field_953) {
                        this.method_1287();
                    }
                    var4 = var4 < this.field_958 ? var4 : this.field_958;
                    this.field_959[this.field_958 + 1] = var6;
                }
                while (var6 > 12828 || var6 < 12827) {
                    this.field_962 = this.field_958 + 1;
                    for (var9 = var5 + 1; var9 <= this.field_962; ++var9) {
                        this.field_963[var9] = this.field_959[var9];
                    }
                    for (var9 = var4 + 1; var9 <= this.field_962; ++var9) {
                        this.field_956[var9] = this.field_956[this.field_954];
                        this.field_957[var9] = this.field_957[this.field_954];
                    }
                    if (var6 > 12828) {
                        var6 -= 12828;
                        do {
                            this.field_962 -= Parser.field_1540[var6] - 1;
                            var6 = Parser.method_2509(this.field_963[this.field_962], Parser.field_1534[var6]);
                        } while (var6 <= 700);
                        var4 = var4 < this.field_962 ? var4 : this.field_962;
                    }
                    if (this.field_962 + 1 >= this.field_953) {
                        this.method_1287();
                    }
                    this.field_958 = this.field_962;
                    this.field_963[++this.field_962] = var6;
                    var5 = this.field_962;
                    this.field_952 = this.field_949.method_1205();
                    var7 = this.field_949.method_1212(this.field_952);
                    for (var6 = Parser.method_2517(var6, var7); var6 <= 700; var6 = Parser.method_2517(var6, var7)) {
                        do {
                            char var14 = Parser.field_1534[var6];
                            this.field_958 -= Parser.field_1540[var6] - 1;
                            var6 = this.field_958 > var5 ? this.field_959[this.field_958] : this.field_963[this.field_958];
                            var6 = Parser.method_2509(var6, var14);
                        } while (var6 <= 700);
                        if (this.field_958 + 1 >= this.field_953) {
                            this.method_1287();
                        }
                        var5 = var5 < this.field_958 ? var5 : this.field_958;
                        this.field_959[this.field_958 + 1] = var6;
                    }
                    if (var6 != 12828) {
                        this.field_960 = this.field_954;
                        for (var9 = var3 + 1; var9 <= this.field_960; ++var9) {
                            this.field_961[var9] = this.field_955[var9];
                        }
                        var3 = var4;
                        this.field_954 = this.field_962;
                        for (var9 = var4 + 1; var9 <= this.field_954; ++var9) {
                            this.field_955[var9] = this.field_963[var9];
                        }
                        this.field_956[this.field_954] = this.field_952;
                        this.field_957[this.field_954] = this.field_949.method_1215(this.field_952);
                        var4 = var5;
                    }
                }
                if (var6 == 12828) {
                    class_227 var15 = this.method_1290(this.field_952, var8);
                    var8 = false;
                    if (this.field_972.field_1616) {
                        return;
                    }
                    if (this.field_972.method_2862().field_1064.field_1935 < this.field_972.field_1561.field_455.field_1675) {
                        if (this.field_973 == null || !this.field_973.field_1309) {
                            return;
                        }
                        this.field_974 = false;
                    }
                    var6 = this.field_955[this.field_954];
                    if (var15.field_984 == 0) {
                        break;
                    }
                    if (var15.field_984 > 110) {
                        int var10 = var15.field_984 - 110;
                        for (var6 = Parser.method_2509(var6, var10); var6 <= 700; var6 = Parser.method_2509(this.field_955[this.field_954], Parser.field_1534[var6])) {
                            this.field_954 -= Parser.field_1540[var6] - 1;
                        }
                        this.field_955[++this.field_954] = var6;
                        this.field_952 = this.field_949.method_1205();
                        var7 = this.field_949.method_1212(this.field_952);
                        this.field_956[this.field_954] = this.field_952;
                        this.field_957[this.field_954] = this.field_949.method_1215(this.field_952);
                    } else {
                        var7 = var15.field_984;
                        this.field_956[this.field_954] = var15.field_985;
                        this.field_957[this.field_954] = this.field_949.method_1215(var15.field_985);
                    }
                }
            } while (var6 != 12827);
        } finally {
            if (this.field_973 != null) {
                this.field_973.field_1309 = var2;
            }
        }
    }

    private static char[] method_1289(char[] var0, int var1, int var2) {
        StringBuffer var3 = new StringBuffer();
        int var4;
        for (var4 = 0; var4 < var1; ++var4) {
            var3.append(var0[var4]);
        }
        for (var4 = var1; var4 < var2; ++var4) {
            char var5 = var0[var4];
            switch (var5) {
                case 8:
                    var3.append("\\b");
                    break;
                case 9:
                    var3.append("\t");
                    break;
                case 10:
                    var3.append("\\n");
                    break;
                case 12:
                    var3.append("\\f");
                    break;
                case 13:
                    var3.append("\\r");
                    break;
                case 34:
                    var3.append("\\\"");
                    break;
                case 39:
                    var3.append("\\\'");
                    break;
                case 92:
                    var3.append("\\\\");
                    break;
                default:
                    var3.append(var5);
            }
        }
        for (var4 = var2; var4 < var0.length; ++var4) {
            var3.append(var0[var4]);
        }
        return var3.toString().toCharArray();
    }

    private class_227 method_1290(int var1, boolean var2) {
        this.field_950 = var1;
        this.field_951 = this.field_949.method_1215(var1);
        int var3 = this.field_949.method_1206(var1);
        int var4 = this.field_949.method_1212(var3);
        if (var2) {
            char var8 = Parser.field_1555[69];
            this.method_1307(3, var8, var3, var3);
            class_227 var10000 = new class_227();
            class_227 var9 = var10000;
            var9.field_984 = 69;
            var9.field_985 = var1;
            this.field_949.method_1210(var1);
            this.field_954 = this.field_962;
            for (int var7 = 0; var7 <= this.field_954; ++var7) {
                this.field_955[var7] = this.field_963[var7];
            }
            this.field_956[this.field_954] = var1;
            this.field_957[this.field_954] = this.field_949.method_1215(var1);
            return var9;
        } else {
            class_227 var5 = this.method_1291(var1);
            if (var5.field_984 != 0) {
                return var5;
            } else {
                var5 = this.method_1302(var1);
                if (var5.field_984 != 0) {
                    return var5;
                } else if (this.field_949.method_1212(var1) == 68) {
                    this.method_1307(11, Parser.field_1555[68], var3, var3);
                    var5.field_984 = 0;
                    var5.field_985 = var1;
                    return var5;
                } else {
                    while (this.field_949.method_1212(this.field_968[31]) != 68) {
                        var5 = this.method_1302(this.field_968[29]);
                        if (var5.field_984 != 0) {
                            return var5;
                        }
                    }
                    int var6;
                    for (var6 = 31; this.field_949.method_1212(this.field_968[var6]) == 68; --var6) {
                        ;
                    }
                    this.method_1307(6, Parser.field_1555[var4], var1, this.field_968[var6]);
                    var5.field_984 = 0;
                    var5.field_985 = this.field_968[var6];
                    return var5;
                }
            }
        }
    }

    private class_227 method_1291(int var1) {
        class_224 var10000 = new class_224();
        class_224 var2 = var10000;
        class_227 var7 = new class_227();
        class_227 var3 = var7;
        int var4 = this.field_962 >= 0 ? 3 : 2;
        this.field_968[var4] = var1;
        int var5;
        for (var5 = var4; var5 > 0; --var5) {
            this.field_968[var5 - 1] = this.field_949.method_1206(this.field_968[var5]);
        }
        for (var5 = var4 + 1; var5 < 32; ++var5) {
            this.field_968[var5] = this.field_949.method_1207(this.field_968[var5 - 1]);
        }
        if (this.field_962 >= 0) {
            var2.field_978 = 3;
            var2 = this.method_1293(this.field_963, this.field_962, var2);
        }
        class_224 var8 = var2.method_1314();
        var8.field_978 = 2;
        var8 = this.method_1293(this.field_955, this.field_954, var8);
        if (var8.field_975 > var2.field_975 || var8.field_976 > var2.field_976) {
            var2 = var8;
        }
        if (this.field_960 >= 0) {
            var8 = var2.method_1314();
            var8.field_978 = 1;
            var8 = this.method_1293(this.field_961, this.field_960, var8);
            if (var8.field_975 > var2.field_975 || var8.field_976 > var2.field_976) {
                var2 = var8;
            }
        }
        if (this.field_962 >= 0) {
            if (this.method_1301(this.field_963, this.field_962, 3, var2.field_975)) {
                return var3;
            }
        } else if (this.method_1301(this.field_955, this.field_954, 2, var2.field_975)) {
            return var3;
        }
        var2.field_975 = var2.field_975 - var2.field_978 + 1;
        if (var2.field_977 == 4 || var2.field_977 == 6 || var2.field_977 == 5 || var2.field_977 == 7) {
            --var2.field_975;
        }
        if (var2.field_975 < 3) {
            return var3;
        } else {
            if (var2.field_977 == 3 && this.field_968[var2.field_978 - 1] == 0) {
                var2.field_977 = 2;
            }
            int var6;
            if (var2.field_978 == 1) {
                this.field_954 = this.field_960;
                for (var6 = 0; var6 <= this.field_954; ++var6) {
                    this.field_955[var6] = this.field_961[var6];
                }
            } else if (this.field_962 >= 0 && var2.field_978 >= 3) {
                this.field_954 = this.field_962;
                for (var6 = 0; var6 <= this.field_954; ++var6) {
                    this.field_955[var6] = this.field_963[var6];
                }
                this.field_956[this.field_954] = this.field_968[3];
                this.field_957[this.field_954] = this.field_949.method_1215(this.field_968[3]);
            }
            return this.method_1294(var2);
        }
    }

    private int method_1292(int var1, int var2) {
        char[] var3 = this.field_949.method_1213(this.field_968[var2]);
        char[] var4 = this.field_949.method_1213(this.field_968[var2 + 1]);
        int var5 = var3.length + var4.length;
        char[] var6 = CharOperation.method_1355(var3, var4);
        for (int var7 = Parser.method_2504(var1); Parser.field_1530[var7] != 0; ++var7) {
            char var8 = Parser.field_1555[Parser.field_1530[var7]];
            if (var5 == Parser.field_1535[var8].length()) {
                char[] var9 = Parser.field_1535[var8].toCharArray();
                if (CharOperation.method_1367(var6, var9, false)) {
                    return Parser.field_1530[var7];
                }
            }
        }
        return 0;
    }

    private class_224 method_1293(int[] var1, int var2, class_224 var3) {
        class_224 var13 = this.method_1299(var1, var2, var3.method_1314());
        if (var13.field_975 > var3.field_975) {
            var3 = var13;
        }
        int var5;
        int var11;
        if (this.field_968[var3.field_978] != 0 && this.field_968[var3.field_978 + 1] != 0) {
            var11 = this.method_1292(var1[var2], var3.field_978);
            if (var11 != 0) {
                var5 = this.method_1306(var1, var2, var11, var3.field_978 + 2);
                if (var5 > var3.field_975 || var5 == var3.field_975 && var3.field_976 < 10) {
                    var3.field_976 = 10;
                    var3.field_979 = var11;
                    var3.field_975 = var5;
                    var3.field_977 = 7;
                }
            }
        }
        var5 = this.method_1306(var1, var2, this.field_949.method_1212(this.field_968[var3.field_978 + 1]), var3.field_978 + 2);
        byte var6;
        if (this.field_949.method_1212(this.field_968[var3.field_978]) == 68 && this.field_949.method_1208(this.field_968[var3.field_978 + 1])) {
            var6 = 10;
        } else {
            var6 = 0;
        }
        if (var5 > var3.field_975 || var5 == var3.field_975 && var6 > var3.field_976) {
            var3.field_976 = var6;
            var3.field_977 = 6;
            var3.field_975 = var5;
        }
        int var7 = var1[var2];
        int var8 = var2;
        this.field_958 = var2 - 1;
        int var12 = this.field_949.method_1212(this.field_968[var3.field_978]);
        this.field_949.method_1210(this.field_968[var3.field_978 + 1]);
        char var15;
        for (int var9 = Parser.method_2517(var7, var12); var9 <= 700; var9 = Parser.method_2517(var9, var12)) {
            do {
                this.field_958 -= Parser.field_1540[var9] - 1;
                var15 = Parser.field_1534[var9];
                var9 = this.field_958 > var8 ? this.field_959[this.field_958] : var1[this.field_958];
                var9 = Parser.method_2509(var9, var15);
            } while (var9 <= 700);
            var8 = var8 < this.field_958 ? var8 : this.field_958;
            this.field_959[this.field_958 + 1] = var9;
            var7 = var9;
        }
        char var10 = 0;
        int var4;
        for (var4 = Parser.method_2504(var7); Parser.field_1530[var4] != 0; ++var4) {
            var15 = Parser.field_1530[var4];
            if (var15 != 68 && var15 != 110) {
                if (var10 == 0) {
                    this.field_967[var15] = var15;
                } else {
                    this.field_967[var15] = this.field_967[var10];
                    this.field_967[var10] = var15;
                }
                var10 = var15;
            }
        }
        if (var1[var2] != var7) {
            for (var4 = Parser.method_2504(var1[var2]); Parser.field_1530[var4] != 0; ++var4) {
                var15 = Parser.field_1530[var4];
                if (var15 != 68 && var15 != 110 && this.field_967[var15] == 0) {
                    if (var10 == 0) {
                        this.field_967[var15] = var15;
                    } else {
                        this.field_967[var15] = this.field_967[var10];
                        this.field_967[var10] = var15;
                    }
                    var10 = var15;
                }
            }
        }
        var4 = this.field_967[var10];
        this.field_967[var10] = 0;
        for (var11 = var4; var11 != 0; var11 = this.field_967[var11]) {
            if (var11 == 68 && this.field_949.method_1208(this.field_968[var3.field_978])) {
                var6 = 10;
            } else {
                var6 = 0;
            }
            var5 = this.method_1306(var1, var2, var11, var3.field_978);
            if (var5 > var3.field_975) {
                var3.field_976 = var6;
                var3.field_975 = var5;
                var3.field_979 = var11;
                var3.field_977 = 3;
            } else if (var5 == var3.field_975 && var6 > var3.field_976) {
                var3.field_976 = var6;
                var3.field_975 = var5;
                var3.field_979 = var11;
                var3.field_977 = 3;
            } else if (var5 == var3.field_975 && var6 == var3.field_976 && this.method_1297(var11, var3.field_979)) {
                var3.field_976 = var6;
                var3.field_975 = var5;
                var3.field_979 = var11;
                var3.field_977 = 3;
            }
        }
        var11 = var4;
        if (this.field_968[var3.field_978] != 0) {
            while (var11 != 0) {
                int var14;
                if (var11 == 68 && this.field_949.method_1208(this.field_968[var3.field_978 + 1])) {
                    var14 = 10;
                } else {
                    var14 = this.method_1298(var11, this.field_968[var3.field_978]);
                }
                var5 = this.method_1306(var1, var2, var11, var3.field_978 + 1);
                if (var5 > var3.field_975) {
                    var3.field_976 = var14;
                    var3.field_975 = var5;
                    var3.field_979 = var11;
                    var3.field_977 = 5;
                } else if (var5 == var3.field_975 && var14 > var3.field_976) {
                    var3.field_976 = var14;
                    var3.field_979 = var11;
                    var3.field_977 = 5;
                } else if (var5 == var3.field_975 && var14 > var3.field_976 && this.method_1297(var11, var3.field_979)) {
                    var3.field_976 = var14;
                    var3.field_979 = var11;
                    var3.field_977 = 5;
                }
                var4 = var11;
                var11 = this.field_967[var11];
                this.field_967[var4] = 0;
            }
        }
        for (var4 = Parser.method_2508(var1[var2]); Parser.field_1537[var4] != 0; ++var4) {
            var11 = Parser.field_1537[var4] + 110;
            var5 = this.method_1306(var1, var2, var11, var3.field_978 + 1);
            if (var5 > var3.field_975) {
                var3.field_976 = 0;
                var3.field_975 = var5;
                var3.field_979 = var11;
                var3.field_977 = 4;
            }
            var5 = this.method_1306(var1, var2, var11, var3.field_978);
            if (var5 > var3.field_975 || var5 == var3.field_975 && var3.field_977 == 4) {
                var3.field_976 = 0;
                var3.field_975 = var5;
                var3.field_979 = var11;
                var3.field_977 = 3;
            }
        }
        return var3;
    }

    private class_227 method_1294(class_224 var1) {
        int var3 = this.field_968[var1.field_978 - 1];
        int var4 = this.field_968[var1.field_978];
        int var2;
        int var5;
        switch (var1.field_977) {
            case 2:
            case 3:
                if (var1.field_979 > 110) {
                    var2 = this.method_1296(this.field_955[this.field_954], var1.field_979, var1.field_978);
                } else {
                    var2 = this.method_1295(this.field_955, this.field_954, var1.field_979, var1.field_978);
                }
                var5 = var1.field_977 == 3 ? var3 : var4;
                this.method_1307(var1.field_977, var2, var5, var5);
                break;
            case 4:
                var2 = this.method_1296(this.field_955[this.field_954], var1.field_979, var1.field_978 + 1);
                this.method_1307(var1.field_977, var2, var4, var4);
                break;
            case 5:
                if (var1.field_976 >= 6) {
                    var2 = Parser.field_1555[var1.field_979];
                } else {
                    var2 = this.method_1295(this.field_955, this.field_954, var1.field_979, var1.field_978 + 1);
                    if (var2 != Parser.field_1555[var1.field_979]) {
                        var1.field_977 = 4;
                    }
                }
                this.method_1307(var1.field_977, var2, var4, var4);
                break;
            case 6:
            case 8:
            default:
                this.method_1307(var1.field_977, Parser.field_1555[110], var4, var4);
                break;
            case 7:
                this.method_1307(var1.field_977, Parser.field_1555[var1.field_979], var4, this.field_949.method_1207(var4));
                break;
            case 9:
                for (var5 = 0; var5 < this.field_964; ++var5) {
                    this.method_1308(var1.field_977, -this.field_965[var5], this.field_956[this.field_966[var5]], var3, Parser.field_1538[Parser.field_1547[this.field_965[var5]]]);
                }
                var1.field_979 = Parser.field_1547[this.field_965[this.field_964]] + 110;
                this.field_954 = this.field_966[this.field_964];
                this.method_1308(var1.field_977, -this.field_965[this.field_964], this.field_956[this.field_966[this.field_964]], var3, this.method_1296(this.field_955[this.field_954], var1.field_979, var1.field_978));
        }
        class_227 var10000 = new class_227();
        class_227 var6 = var10000;
        switch (var1.field_977) {
            case 2:
            case 3:
            case 9:
                var6.field_984 = var1.field_979;
                var6.field_985 = this.field_968[var1.field_978];
                this.field_949.method_1210(this.field_968[var1.field_978]);
                break;
            case 4:
            case 5:
                var6.field_984 = var1.field_979;
                var6.field_985 = this.field_968[var1.field_978];
                this.field_949.method_1210(this.field_968[var1.field_978 + 1]);
                break;
            case 6:
            case 8:
            default:
                var6.field_985 = this.field_968[var1.field_978 + 1];
                var6.field_984 = this.field_949.method_1212(this.field_968[var1.field_978 + 1]);
                this.field_949.method_1210(this.field_968[var1.field_978 + 2]);
                break;
            case 7:
                var6.field_984 = var1.field_979;
                var6.field_985 = this.field_968[var1.field_978];
                this.field_949.method_1210(this.field_968[var1.field_978 + 2]);
        }
        return var6;
    }

    private int method_1295(int[] var1, int var2, int var3, int var4) {
        int var5 = var1[var2];
        int var6 = var2;
        int var7 = var3;
        this.field_958 = var2 - 1;
        this.field_949.method_1210(this.field_968[var4]);
        for (var5 = Parser.method_2517(var5, var3); var5 <= 700; var5 = Parser.method_2517(var5, var3)) {
            do {
                this.field_958 -= Parser.field_1540[var5] - 1;
                char var8 = Parser.field_1534[var5];
                var5 = this.field_958 > var6 ? this.field_959[this.field_958] : var1[this.field_958];
                var5 = Parser.method_2509(var5, var8);
            } while (var5 <= 700);
            var6 = var6 < this.field_958 ? var6 : this.field_958;
            this.field_959[this.field_958 + 1] = var5;
        }
        ++this.field_958;
        int var10 = this.field_958;
        var3 = this.field_949.method_1212(this.field_968[var4]);
        this.field_949.method_1210(this.field_968[var4 + 1]);
        if (var5 > 12828) {
            var5 -= 12828;
        } else {
            this.field_959[this.field_958 + 1] = var5;
            var5 = Parser.method_2517(var5, var3);
        }
        while (var5 <= 700) {
            do {
                this.field_958 -= Parser.field_1540[var5] - 1;
                if (this.field_958 < var10) {
                    return var7 > 110 ? Parser.field_1538[var7 - 110] : Parser.field_1555[var7];
                }
                char var9 = Parser.field_1534[var5];
                if (this.field_958 == var10) {
                    var7 = var9 + 110;
                }
                var5 = this.field_958 > var6 ? this.field_959[this.field_958] : var1[this.field_958];
                var5 = Parser.method_2509(var5, var9);
            } while (var5 <= 700);
            this.field_959[this.field_958 + 1] = var5;
            var5 = Parser.method_2517(var5, var3);
        }
        return var7 > 110 ? Parser.field_1538[var7 - 110] : Parser.field_1555[var7];
    }

    private int method_1296(int var1, int var2, int var3) {
        int var4 = var2 - 110;
        int var5 = this.field_949.method_1212(this.field_968[var3]);
        this.field_949.method_1210(this.field_968[var3 + 1]);
        this.field_958 = 0;
        this.field_959[this.field_958] = var1;
        int var6 = Parser.method_2509(var1, var4);
        if (var6 > 700) {
            this.field_959[this.field_958 + 1] = var6;
            var6 = Parser.method_2517(var6, var5);
        }
        while (var6 <= 700) {
            do {
                this.field_958 -= Parser.field_1540[var6] - 1;
                if (this.field_958 < 0) {
                    return Parser.field_1538[var4];
                }
                if (this.field_958 == 0) {
                    var4 = Parser.field_1534[var6];
                }
                var6 = Parser.method_2509(this.field_959[this.field_958], Parser.field_1534[var6]);
            } while (var6 <= 700);
            this.field_959[this.field_958 + 1] = var6;
            var6 = Parser.method_2517(var6, var5);
        }
        return Parser.field_1538[var4];
    }

    private boolean method_1297(int var1, int var2) {
        return false;
    }

    private int method_1298(int var1, int var2) {
        char[] var3 = Parser.field_1535[Parser.field_1555[var1]].toCharArray();
        int var4 = var3.length;
        char[] var5 = new char[var4 + 1];
        for (int var6 = 0; var6 < var4; ++var6) {
            char var7 = var3[var6];
            var5[var6] = ScannerHelper.method_3341(var7);
        }
        var5[var4] = 0;
        char[] var15 = this.field_949.method_1213(var2);
        int var16 = var15.length;
        int var8 = var16 < 41 ? var16 : 41;
        char[] var9 = new char[var8 + 1];
        int var10;
        for (var10 = 0; var10 < var8; ++var10) {
            char var11 = var15[var10];
            var9[var10] = ScannerHelper.method_3341(var11);
        }
        var9[var8] = 0;
        if (var4 == 1 && var8 == 1 && (var5[0] == 59 && var9[0] == 44 || var5[0] == 44 && var9[0] == 59 || var5[0] == 59 && var9[0] == 58 || var5[0] == 58 && var9[0] == 59 || var5[0] == 46 && var9[0] == 44 || var5[0] == 44 && var9[0] == 46 || var5[0] == 39 && var9[0] == 34 || var5[0] == 34 && var9[0] == 39)) {
            return 3;
        } else {
            var10 = 0;
            int var17 = 0;
            int var12 = 0;
            int var13 = 0;
            int var14 = 0;
            while (var13 < var4 && var14 < var8) {
                if (var5[var13] == var9[var14]) {
                    ++var10;
                    ++var13;
                    ++var14;
                    if (var12 == 0) {
                        ++var17;
                    }
                } else if (var5[var13 + 1] == var9[var14] && var5[var13] == var9[var14 + 1]) {
                    var10 += 2;
                    var13 += 2;
                    var14 += 2;
                    ++var12;
                } else if (var5[var13 + 1] == var9[var14 + 1]) {
                    ++var13;
                    ++var14;
                    ++var12;
                } else {
                    if (var4 - var13 > var8 - var14) {
                        ++var13;
                    } else if (var8 - var14 > var4 - var13) {
                        ++var14;
                    } else {
                        ++var13;
                        ++var14;
                    }
                    ++var12;
                }
            }
            if (var13 < var4 || var14 < var8) {
                ++var12;
            }
            if (var12 > (var4 < var8 ? var4 : var8) / 6 + 1) {
                var10 = var17;
            }
            return var10 * 10 / ((var4 < var16 ? var16 : var4) + var12);
        }
    }

    private class_224 method_1299(int[] var1, int var2, class_224 var3) {
        this.field_969 = new int[this.field_953];
        for (int var4 = 0; var4 < this.field_953; ++var4) {
            this.field_969[var4] = -1;
        }
        this.field_970 = 0;
        this.field_971 = new class_210[this.field_953];
        this.method_1300(var1, var2, var3, 0);
        this.field_969 = null;
        this.field_970 = 0;
        var3.field_977 = 9;
        var3.field_976 = 10;
        return var3;
    }

    private void method_1300(int[] var1, int var2, class_224 var3, int var4) {
        if (var4 <= 20) {
            int var5 = var1[var2];
            int var6;
            for (var6 = this.field_969[var2]; var6 != -1; var6 = this.field_971[var6].field_903) {
                if (this.field_971[var6].field_902 == var5) {
                    return;
                }
            }
            var6 = this.field_970++;
            if (this.field_970 >= this.field_971.length) {
                System.arraycopy(this.field_971, 0, this.field_971 = new class_210[this.field_970 * 2], 0, this.field_970);
            }
            class_210[] var10000 = this.field_971;
            class_210 var10002 = new class_210(var5, this.field_969[var2]);
            var10000[var6] = var10002;
            this.field_969[var2] = var6;
            label134:
            for (int var7 = 0; var7 < 134; ++var7) {
                var5 = var1[var2];
                this.field_958 = var2 - 1;
                int var8 = var2;
                byte var9 = Parser.field_1546[var7];
                this.field_949.method_1210(this.field_968[var3.field_978]);
                for (var5 = Parser.method_2517(var5, var9); var5 <= 700; var5 = Parser.method_2517(var5, var9)) {
                    do {
                        this.field_958 -= Parser.field_1540[var5] - 1;
                        char var10 = Parser.field_1534[var5];
                        var5 = this.field_958 > var8 ? this.field_959[this.field_958] : var1[this.field_958];
                        var5 = Parser.method_2509(var5, var10);
                    } while (var5 <= 700);
                    if (this.field_958 + 1 >= this.field_953) {
                        return;
                    }
                    var8 = var8 < this.field_958 ? var8 : this.field_958;
                    this.field_959[this.field_958 + 1] = var5;
                }
                if (var5 != 12828) {
                    int var11 = Parser.field_1548[var7];
                    int var17;
                    for (var17 = this.field_958 + 1; var17 >= var8 + 1 && Parser.method_2506(this.field_959[var17]) == Parser.field_1549[var11]; --var17) {
                        ++var11;
                    }
                    if (var17 == var8) {
                        for (var17 = var8; var17 >= 1 && Parser.method_2506(var1[var17]) == Parser.field_1549[var11]; --var17) {
                            ++var11;
                        }
                    }
                    int var12 = var8 < var2 ? var8 + 1 : var2;
                    if (Parser.field_1549[var11] == 0 && var17 < var12) {
                        int var13 = var17;
                        for (var17 = Parser.field_1551[var7]; var1[var13] != Parser.field_1550[var17] && Parser.field_1550[var17] != 0; ++var17) {
                            ;
                        }
                        if (Parser.field_1550[var17] != 0) {
                            int var14 = var3.field_975;
                            int var15 = this.method_1306(var1, var13, Parser.field_1547[var7] + 110, var3.field_978);
                            if (var15 - var3.field_978 + 1 < 3) {
                                int var16 = var13;
                                for (var5 = Parser.method_2509(var1[var13], Parser.field_1547[var7]); var5 <= 700; var5 = Parser.method_2509(var1[var16], Parser.field_1534[var5])) {
                                    if (Parser.field_1545[var5] > this.field_948.field_1928) {
                                        continue label134;
                                    }
                                    var16 -= Parser.field_1540[var5] - 1;
                                }
                                ++var16;
                                var17 = var5;
                                var5 = var1[var16];
                                var1[var16] = var17;
                                this.method_1300(var1, var16, var3, var4 + 1);
                                var1[var16] = var5;
                            } else if (var15 > var3.field_975) {
                                this.field_964 = var4;
                                var3.field_975 = var15;
                            }
                            if (this.field_949.method_1212(this.field_968[var3.field_978]) == 68 && var3.field_975 == var14) {
                                this.field_964 = var4;
                                var3.field_975 = 30;
                            }
                            if (var3.field_975 > var14) {
                                this.field_965[var4] = var7;
                                this.field_966[var4] = var13;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean method_1301(int[] var1, int var2, int var3, int var4) {
        for (int var5 = var2 - 1; var5 >= 0; --var5) {
            int var6 = this.method_1306(var1, var5, this.field_949.method_1212(this.field_968[var3]), var3 + 1);
            if (var6 - var3 + 1 > 3 && var6 > var4) {
                return true;
            }
        }
        class_224 var10000 = new class_224();
        class_224 var7 = var10000;
        var7.field_978 = var3 + 1;
        var7.field_975 = var4;
        var7 = this.method_1299(var1, var2, var7);
        if (var7.field_975 - var3 > 3 && var7.field_975 > var4) {
            return true;
        } else {
            return false;
        }
    }

    private class_227 method_1302(int var1) {
        class_207 var10000 = new class_207();
        class_207 var2 = var10000;
        var10000 = new class_207();
        class_207 var3 = var10000;
        class_227 var15 = new class_227();
        class_227 var4 = var15;
        int var9 = 0;
        var4.field_984 = 0;
        var2.field_892 = 0;
        var2.field_893 = 0;
        var2.field_898 = false;
        var3.field_893 = 0;
        var3.field_898 = false;
        int var7;
        if (this.field_962 >= 0) {
            this.field_968[2] = var1;
            this.field_968[1] = this.field_949.method_1206(this.field_968[2]);
            this.field_968[0] = this.field_949.method_1206(this.field_968[1]);
            for (var7 = 3; var7 < 31; ++var7) {
                this.field_968[var7] = this.field_949.method_1207(this.field_968[var7 - 1]);
            }
            this.field_968[31] = this.field_949.method_1211();
            for (var9 = 29; var9 >= 1 && this.field_949.method_1212(this.field_968[var9]) == 68; --var9) {
                ;
            }
            ++var9;
            int var11 = this.field_956[this.field_962];
            int var12 = this.field_957[this.field_962];
            this.field_956[this.field_962] = this.field_968[2];
            this.field_957[this.field_962] = this.field_949.method_1215(this.field_968[2]);
            var3.field_896 = this.field_962;
            var3 = this.method_1303(this.field_963, this.field_962, var9, var3, true);
            if (var3.field_898) {
                ++var3.field_893;
            }
            var2.field_896 = this.field_962 + 31;
            var2 = this.method_1304(this.field_963, this.field_962, var9, var2, true);
            if (var2.field_898) {
                ++var2.field_893;
            }
            this.field_956[this.field_962] = var11;
            this.field_957[this.field_962] = var12;
        } else {
            var3.field_896 = this.field_954;
            var2.field_896 = this.field_954 + 31;
        }
        this.field_968[3] = var1;
        this.field_968[2] = this.field_949.method_1206(this.field_968[3]);
        this.field_968[1] = this.field_949.method_1206(this.field_968[2]);
        this.field_968[0] = this.field_949.method_1206(this.field_968[1]);
        for (var7 = 4; var7 < 32; ++var7) {
            this.field_968[var7] = this.field_949.method_1207(this.field_968[var7 - 1]);
        }
        int var10;
        for (var10 = 29; var10 >= 1 && this.field_949.method_1212(this.field_968[var10]) == 68; --var10) {
            ;
        }
        ++var10;
        var3 = this.method_1303(this.field_955, this.field_954, var10, var3, false);
        var2 = this.method_1304(this.field_955, this.field_954, var10, var2, false);
        if (var3.field_893 > 3 && (var3.field_896 <= var2.field_896 || var3.field_893 - var3.field_896 >= var2.field_893 - var2.field_896)) {
            var2.field_892 = 8;
            var2.field_895 = var3.field_895;
            var2.field_894 = 2;
            var2.field_896 = var3.field_896;
            var2.field_893 = var3.field_893;
            var2.field_898 = var3.field_898;
        }
        int var5;
        if (var2.field_898) {
            this.field_954 = this.field_962;
            for (var5 = 0; var5 <= this.field_954; ++var5) {
                this.field_955[var5] = this.field_963[var5];
            }
            this.field_968[2] = var1;
            this.field_968[1] = this.field_949.method_1206(this.field_968[2]);
            this.field_968[0] = this.field_949.method_1206(this.field_968[1]);
            for (var7 = 3; var7 < 31; ++var7) {
                this.field_968[var7] = this.field_949.method_1207(this.field_968[var7 - 1]);
            }
            this.field_968[31] = this.field_949.method_1211();
            this.field_956[this.field_962] = this.field_968[2];
            this.field_957[this.field_962] = this.field_949.method_1215(this.field_968[2]);
            var10 = var9;
        }
        class_224 var13;
        class_224 var14;
        if (var2.field_892 == 10 || var2.field_892 == 6) {
            var14 = new class_224();
            var13 = var14;
            var13.field_975 = 0;
            for (var13.field_978 = 2; var13.field_978 <= var2.field_894 && var2.field_892 != 9; ++var13.field_978) {
                var13 = this.method_1299(this.field_955, this.field_954, var13);
                int var6 = var13.field_975 == 30 ? var10 : var13.field_975;
                var7 = var13.field_978 - 1;
                if (var6 - var7 > 3 && var6 - var7 > var2.field_893 - var2.field_896) {
                    var2.field_892 = 9;
                    var5 = this.field_965[this.field_964];
                    var2.field_897 = Parser.field_1547[var5] + 110;
                    var2.field_895 = this.field_954;
                    var2.field_894 = var13.field_978;
                }
            }
        }
        if (var2.field_892 == 0 && this.field_949.method_1212(this.field_968[var10]) == 68) {
            var14 = new class_224();
            var13 = var14;
            var13.field_978 = var10;
            var13.field_975 = 0;
            for (int var8 = this.field_954; var8 >= 0 && var2.field_892 == 0; --var8) {
                var13 = this.method_1299(this.field_955, var8, var13);
                if (var13.field_975 > 0) {
                    var2.field_892 = 9;
                    var5 = this.field_965[this.field_964];
                    var2.field_897 = Parser.field_1547[var5] + 110;
                    var2.field_895 = var8;
                    var2.field_894 = var13.field_978;
                }
            }
        }
        if (var2.field_892 == 0) {
            return var4;
        } else {
            this.method_1305(var2);
            switch (var2.field_892) {
                case 6:
                    var4.field_985 = this.field_968[var2.field_894];
                    var4.field_984 = this.field_949.method_1212(this.field_968[var2.field_894]);
                    this.field_949.method_1210(this.field_949.method_1207(this.field_968[var2.field_894]));
                    break;
                case 8:
                    var4.field_985 = this.field_968[2];
                    var4.field_984 = this.field_949.method_1212(this.field_968[2]);
                    this.field_949.method_1210(this.field_949.method_1207(this.field_968[2]));
                    break;
                default:
                    var4.field_984 = var2.field_897;
                    var4.field_985 = this.field_968[var2.field_894];
                    this.field_949.method_1210(this.field_968[var2.field_894]);
            }
            return var4;
        }
    }

    private class_207 method_1303(int[] var1, int var2, int var3, class_207 var4, boolean var5) {
        int var6 = this.field_968[2];
        int var7 = 0;
        for (int var8 = var2 - 1; var8 >= 0; --var8) {
            if (this.field_956[var8] < var6) {
                ++var7;
            }
            var6 = this.field_956[var8];
            int var9 = this.method_1306(var1, var8, this.field_949.method_1212(this.field_968[2]), 3);
            if (var9 == 30) {
                var9 = var3;
            }
            if (var9 > 3 && var9 - var7 > var4.field_893 - var4.field_896) {
                var4.field_895 = var8;
                var4.field_893 = var9;
                var4.field_896 = var7;
                var4.field_898 = var5;
            }
        }
        return var4;
    }

    private class_207 method_1304(int[] var1, int var2, int var3, class_207 var4, boolean var5) {
        int var7 = 0;
        int var6 = this.field_968[2];
        for (int var8 = var2; var8 >= 0 && var4.field_896 >= var7; --var8) {
            if (this.field_956[var8] < var6) {
                ++var7;
            }
            var6 = this.field_956[var8];
            for (int var9 = 2; var9 <= var3 - 3 + 1 && var4.field_896 >= var7 + var9 - 1; ++var9) {
                int var10 = this.method_1306(var1, var8, this.field_949.method_1212(this.field_968[var9]), var9 + 1);
                if (var10 == 30) {
                    var10 = var3;
                }
                int var11;
                if (var10 - var9 + 1 > 3) {
                    var11 = var7 + var9 - 1;
                    if (var11 < var4.field_896 || var10 - var11 > var4.field_893 - var4.field_896 || var4.field_892 == 10 && var10 - var11 == var4.field_893 - var4.field_896) {
                        var4.field_892 = 6;
                        var4.field_893 = var10;
                        var4.field_895 = var8;
                        var4.field_894 = var9;
                        var4.field_896 = var11;
                        var4.field_898 = var5;
                    }
                }
                for (var11 = Parser.method_2508(var1[var8]); var11 >= 0 && Parser.field_1537[var11] != 0; ++var11) {
                    int var12 = Parser.field_1537[var11] + 110;
                    var10 = this.method_1306(var1, var8, var12, var9);
                    if (var10 == 30) {
                        var10 = var3;
                    }
                    if (var10 - var9 + 1 > 3) {
                        int var13 = var7 + var9 - 1;
                        if (var13 < var4.field_896 || var10 - var13 > var4.field_893 - var4.field_896) {
                            var4.field_892 = 10;
                            var4.field_897 = var12;
                            var4.field_893 = var10;
                            var4.field_895 = var8;
                            var4.field_894 = var9;
                            var4.field_896 = var13;
                            var4.field_898 = var5;
                        }
                    }
                }
            }
        }
        return var4;
    }

    private void method_1305(class_207 var1) {
        switch (var1.field_892) {
            case 9:
                if (var1.field_895 < this.field_954) {
                    this.method_1307(6, Parser.field_1555[110], this.field_956[var1.field_895], this.field_968[1]);
                }
                for (int var2 = 0; var2 < this.field_964; ++var2) {
                    this.method_1308(9, -this.field_965[var2], this.field_956[this.field_966[var2]], this.field_968[1], Parser.field_1538[Parser.field_1547[this.field_965[var2]]]);
                }
                var1.field_897 = Parser.field_1547[this.field_965[this.field_964]] + 110;
                this.field_954 = this.field_966[this.field_964];
                this.method_1308(9, -this.field_965[this.field_964], this.field_956[this.field_966[this.field_964]], this.field_968[1], this.method_1296(this.field_955[this.field_954], var1.field_897, var1.field_894));
                break;
            default:
                this.method_1307(var1.field_892, var1.field_892 == 10 ? this.method_1296(this.field_955[var1.field_895], var1.field_897, var1.field_894) : Parser.field_1555[110], this.field_956[var1.field_895], this.field_968[var1.field_894 - 1]);
                this.field_954 = var1.field_895;
        }
    }

    private int method_1306(int[] var1, int var2, int var3, int var4) {
        int var8 = var1[var2];
        int var5;
        int var6;
        int var7;
        char var10;
        if (var3 > 110) {
            this.field_958 = var2;
            if (this.field_947) {
                eclipse.instance.method_736(this.field_958);
            }
            var5 = var2;
            var6 = var4;
            var7 = this.field_949.method_1212(this.field_968[var4]);
            this.field_949.method_1210(this.field_949.method_1207(this.field_968[var4]));
            int var9 = var3 - 110;
            var8 = Parser.method_2509(var8, var9);
            if (var8 <= 700) {
                while (true) {
                    this.field_958 -= Parser.field_1540[var8] - 1;
                    if (this.field_947) {
                        eclipse.instance.method_743(this.field_958);
                        eclipse.instance.method_744(" (");
                        eclipse.instance.method_743(-(Parser.field_1540[var8] - 1));
                        eclipse.instance.method_744(") [max:");
                        eclipse.instance.method_743(var5);
                        eclipse.instance.method_744("]\tprocess_non_terminal\t");
                        eclipse.instance.method_743(var8);
                        eclipse.instance.method_744("\t");
                        eclipse.instance.method_744(Parser.field_1535[Parser.field_1538[Parser.field_1534[var8]]]);
                        eclipse.instance.newLine();
                    }
                    if (Parser.field_1545[var8] > this.field_948.field_1928) {
                        return 0;
                    }
                    var10 = Parser.field_1534[var8];
                    var8 = this.field_958 > var5 ? this.field_959[this.field_958] : var1[this.field_958];
                    var8 = Parser.method_2509(var8, var10);
                    if (var8 > 700) {
                        var5 = var5 < this.field_958 ? var5 : this.field_958;
                        break;
                    }
                }
            }
        } else {
            this.field_958 = var2 - 1;
            if (this.field_947) {
                eclipse.instance.method_736(this.field_958);
            }
            var5 = this.field_958;
            var6 = var4 - 1;
            var7 = var3;
            this.field_949.method_1210(this.field_968[var4]);
        }
        while (true) {
            if (this.field_947) {
                eclipse.instance.method_743(this.field_958 + 1);
                eclipse.instance.method_744(" (+1) [max:");
                eclipse.instance.method_743(var5);
                eclipse.instance.method_744("]\tprocess_terminal    \t");
                eclipse.instance.method_743(var7);
                eclipse.instance.method_744("\t");
                eclipse.instance.method_744(Parser.field_1535[Parser.field_1555[var7]]);
                eclipse.instance.newLine();
            }
            if (++this.field_958 >= this.field_953) {
                return var6;
            }
            this.field_959[this.field_958] = var8;
            var8 = Parser.method_2517(var8, var7);
            if (var8 <= 700) {
                --this.field_958;
                if (this.field_947) {
                    eclipse.instance.method_743(this.field_958);
                    eclipse.instance.method_744(" (-1) [max:");
                    eclipse.instance.method_743(var5);
                    eclipse.instance.method_744("]\treduce");
                    eclipse.instance.newLine();
                }
            } else {
                if (var8 >= 12827 && var8 <= 12828) {
                    if (var8 == 12827) {
                        return 30;
                    }
                    return var6;
                }
                if (var6 == 30) {
                    return var6;
                }
                ++var6;
                var7 = this.field_949.method_1212(this.field_968[var6]);
                this.field_949.method_1210(this.field_949.method_1207(this.field_968[var6]));
                if (var8 <= 12828) {
                    if (this.field_947) {
                        eclipse.instance.print("\tshift");
                    }
                    continue;
                }
                var8 -= 12828;
                if (this.field_947) {
                    eclipse.instance.method_743(this.field_958);
                    eclipse.instance.method_744("\tshift reduce");
                    eclipse.instance.newLine();
                }
            }
            do {
                this.field_958 -= Parser.field_1540[var8] - 1;
                if (this.field_947) {
                    eclipse.instance.method_743(this.field_958);
                    eclipse.instance.method_744(" (");
                    eclipse.instance.method_743(-(Parser.field_1540[var8] - 1));
                    eclipse.instance.method_744(") [max:");
                    eclipse.instance.method_743(var5);
                    eclipse.instance.method_744("]\tprocess_non_terminal\t");
                    eclipse.instance.method_743(var8);
                    eclipse.instance.method_744("\t");
                    eclipse.instance.method_744(Parser.field_1535[Parser.field_1538[Parser.field_1534[var8]]]);
                    eclipse.instance.newLine();
                }
                if (var8 <= 700 && Parser.field_1545[var8] > this.field_948.field_1928) {
                    return 0;
                }
                var10 = Parser.field_1534[var8];
                var8 = this.field_958 > var5 ? this.field_959[this.field_958] : var1[this.field_958];
                var8 = Parser.method_2509(var8, var10);
            } while (var8 <= 700);
            var5 = var5 < this.field_958 ? var5 : this.field_958;
        }
    }

    private void method_1307(int var1, int var2, int var3, int var4) {
        this.method_1308(var1, var2, var3, var4, 0);
    }

    private void method_1308(int var1, int var2, int var3, int var4, int var5) {
        int var6 = var3 > var4 ? var4 : var3;
        if (var6 < var4) {
            this.method_1310(var1, var2, var6, var4, var5);
        } else {
            this.method_1309(var1, var2, var4, var5);
        }
    }

    private void method_1309(int var1, int var2, int var3, int var4) {
        String var5;
        if (var2 >= 0) {
            var5 = Parser.field_1539[var2];
        } else {
            var5 = Util.field_982;
        }
        int var6 = this.field_949.method_1215(var3);
        int var7 = this.field_949.method_1216(var3);
        int var8 = this.field_949.method_1212(var3);
        String var9 = Parser.field_1535[Parser.field_1555[this.field_949.method_1212(var3)]];
        char[] var10 = this.field_949.method_1213(var3);
        if (var8 == 52) {
            var10 = method_1289(var10, 1, var10.length - 1);
        }
        int var11 = -1;
        if (this.field_973 != null && var2 >= 0) {
            var11 = Parser.field_1541[var2];
        }
        int[] var21;
        int[] var20;
        switch (var1) {
            case 2:
                if (this.field_973 != null) {
                    if (var11 > -1) {
                        this.field_973.method_2446(var11, -1, var6);
                    } else {
                        var20 = this.method_1311(-var11);
                        if (var20 != null) {
                            this.field_973.method_2448(var20, -1, var6);
                        }
                    }
                }
                if (this.field_974) {
                    this.method_1286().method_1726(var6, var7, var8, var10, var9, var5);
                }
                break;
            case 3:
                if (this.field_973 != null) {
                    if (var11 > -1) {
                        this.field_973.method_2446(var11, -1, var7);
                    } else {
                        var20 = this.method_1311(-var11);
                        if (var20 != null) {
                            this.field_973.method_2448(var20, -1, var7);
                        }
                    }
                }
                if (this.field_974) {
                    this.method_1286().method_1725(var6, var7, var8, var10, var9, var5);
                }
                break;
            case 4:
                if (var5.length() == 0) {
                    if (this.field_973 != null) {
                        this.field_973.method_2451(var6, var7);
                    }
                    if (this.field_974) {
                        this.method_1286().method_1735(var6, var7, var8, var10, var9, var5);
                    }
                } else {
                    if (this.field_973 != null) {
                        if (var11 > -1) {
                            this.field_973.method_2449(var11, var6, var7);
                        } else {
                            var20 = this.method_1311(-var11);
                            if (var20 != null) {
                                this.field_973.method_2450(var20, var6, var7);
                            }
                        }
                    }
                    if (this.field_974) {
                        this.method_1286().method_1730(var6, var7, var8, var10, var9, var5);
                    }
                }
                break;
            case 5:
                if (this.field_973 != null) {
                    if (var11 > -1) {
                        this.field_973.method_2449(var11, var6, var7);
                    } else {
                        var20 = this.method_1311(-var11);
                        if (var20 != null) {
                            this.field_973.method_2450(var20, var6, var7);
                        }
                    }
                }
                if (this.field_974) {
                    this.method_1286().method_1735(var6, var7, var8, var10, var9, var5);
                }
                break;
            case 6:
                if (this.field_973 != null) {
                    this.field_973.method_2451(var6, var7);
                }
                if (this.field_974) {
                    this.method_1286().method_1723(var6, var7, var8, var10, var9);
                }
                break;
            case 7:
                if (this.field_973 != null) {
                    if (var11 > -1) {
                        this.field_973.method_2449(var11, var6, var7);
                    } else {
                        var21 = this.method_1311(-var11);
                        if (var21 != null) {
                            this.field_973.method_2450(var21, var6, var7);
                        }
                    }
                }
                if (this.field_974) {
                    this.method_1286().method_1731(var6, var7, var5);
                }
                break;
            case 8:
                if (this.field_973 != null) {
                    this.field_973.method_2451(var6, var7);
                }
                if (this.field_974) {
                    this.method_1286().method_1732(var6, var7);
                }
                break;
            case 9:
                StringBuffer var12 = new StringBuffer();
                int[] var13 = null;
                int var14 = 0;
                if (this.field_973 != null) {
                    var13 = new int[Parser.field_1549.length - Parser.field_1552[-var2]];
                }
                int var15;
                for (var15 = Parser.field_1552[-var2]; Parser.field_1549[var15] != 0; ++var15) {
                    var12.append(Parser.field_1539[Parser.field_1549[var15]]);
                    if (Parser.field_1549[var15 + 1] != 0) {
                        var12.append(' ');
                    }
                    if (var13 != null) {
                        int var16 = Parser.field_1541[Parser.field_1549[var15]];
                        if (var16 > -1) {
                            int var17 = var13.length;
                            if (var14 == var17) {
                                System.arraycopy(var13, 0, var13 = new int[var17 * 2], 0, var17);
                            }
                            var13[var14++] = var16;
                        } else {
                            int[] var22 = this.method_1311(-var16);
                            if (var22 != null) {
                                for (int var18 = 0; var18 < var22.length; ++var18) {
                                    int var19 = var13.length;
                                    if (var14 == var19) {
                                        System.arraycopy(var13, 0, var13 = new int[var19 * 2], 0, var19);
                                    }
                                    var13[var14++] = var22[var18];
                                }
                            } else {
                                var14 = 0;
                                var13 = null;
                            }
                        }
                    }
                }
                if (var14 > 0) {
                    System.arraycopy(var13, 0, var13 = new int[var14], 0, var14);
                    var15 = -1;
                    if (var4 != 0) {
                        var15 = -Parser.field_1541[var4];
                    }
                    this.field_973.method_2448(var13, var15, var7);
                }
                if (var4 != 0) {
                    if (this.field_974) {
                        this.method_1286().method_1727(var6, var7, var12.toString(), Parser.field_1539[var4]);
                    }
                } else if (this.field_974) {
                    this.method_1286().method_1729(var6, var7, var12.toString());
                }
                break;
            case 10:
            default:
                if (var5.length() == 0) {
                    if (this.field_973 != null) {
                        this.field_973.method_2451(var6, var7);
                    }
                    if (this.field_974) {
                        this.method_1286().method_1733(var6, var7, var8, var10, var9);
                    }
                } else {
                    if (this.field_973 != null) {
                        if (var11 > -1) {
                            this.field_973.method_2449(var11, var6, var7);
                        } else {
                            var21 = this.method_1311(-var11);
                            if (var21 != null) {
                                this.field_973.method_2450(var21, var6, var7);
                            }
                        }
                    }
                    if (this.field_974) {
                        this.method_1286().method_1735(var6, var7, var8, var10, var9, var5);
                    }
                }
                break;
            case 11:
                if (this.field_974) {
                    this.method_1286().method_1737(var6, var7);
                }
        }
    }

    private void method_1310(int var1, int var2, int var3, int var4, int var5) {
        String var6;
        if (var2 >= 0) {
            var6 = Parser.field_1539[var2];
        } else {
            var6 = Util.field_982;
        }
        int var7 = -1;
        int var8;
        if (this.field_949.method_1217(var3)) {
            if (var3 == 0) {
                var7 = this.field_949.method_1215(var3 + 1);
            } else {
                var7 = this.field_949.method_1215(var3);
            }
        } else {
            if (var3 == this.field_950) {
                var7 = this.field_951;
            } else {
                for (var8 = 0; var8 <= this.field_954; ++var8) {
                    if (this.field_956[var8] == var3) {
                        var7 = this.field_957[var8];
                    }
                }
            }
            if (var7 == -1) {
                var7 = this.field_949.method_1215(var4);
            }
        }
        var8 = this.field_949.method_1216(var4);
        int var9 = -1;
        if (this.field_973 != null && var2 >= 0) {
            var9 = Parser.field_1541[var2];
        }
        int[] var19;
        switch (var1) {
            case 6:
                if (this.field_973 != null) {
                    this.field_973.method_2451(var7, var8);
                }
                if (this.field_974) {
                    this.method_1286().method_1724(var7, var8);
                }
                break;
            case 7:
                if (this.field_973 != null) {
                    if (var9 > -1) {
                        this.field_973.method_2449(var9, var7, var8);
                    } else {
                        var19 = this.method_1311(-var9);
                        if (var19 != null) {
                            this.field_973.method_2450(var19, var7, var8);
                        }
                    }
                }
                if (this.field_974) {
                    this.method_1286().method_1731(var7, var8, var6);
                }
                break;
            case 8:
                if (this.field_973 != null) {
                    this.field_973.method_2451(var7, var8);
                }
                if (this.field_974) {
                    this.method_1286().method_1732(var7, var8);
                }
                break;
            case 9:
                var7 = this.field_949.method_1215(var4);
                StringBuffer var10 = new StringBuffer();
                int[] var11 = null;
                int var12 = 0;
                if (this.field_973 != null) {
                    var11 = new int[Parser.field_1549.length - Parser.field_1552[-var2]];
                }
                int var13;
                for (var13 = Parser.field_1552[-var2]; Parser.field_1549[var13] != 0; ++var13) {
                    var10.append(Parser.field_1539[Parser.field_1549[var13]]);
                    if (Parser.field_1549[var13 + 1] != 0) {
                        var10.append(' ');
                    }
                    if (var11 != null) {
                        int var14 = Parser.field_1541[Parser.field_1549[var13]];
                        if (var14 > -1) {
                            int var15 = var11.length;
                            if (var12 == var15) {
                                System.arraycopy(var11, 0, var11 = new int[var15 * 2], 0, var15);
                            }
                            var11[var12++] = var14;
                        } else {
                            int[] var18 = this.method_1311(-var14);
                            if (var18 != null) {
                                for (int var16 = 0; var16 < var18.length; ++var16) {
                                    int var17 = var11.length;
                                    if (var12 == var17) {
                                        System.arraycopy(var11, 0, var11 = new int[var17 * 2], 0, var17);
                                    }
                                    var11[var12++] = var18[var16];
                                }
                            } else {
                                var12 = 0;
                                var11 = null;
                            }
                        }
                    }
                }
                if (var12 > 0) {
                    System.arraycopy(var11, 0, var11 = new int[var12], 0, var12);
                    var13 = -1;
                    if (var5 != 0) {
                        var13 = -Parser.field_1541[var5];
                    }
                    this.field_973.method_2448(var11, var13, var8);
                }
                if (var5 != 0) {
                    if (this.field_974) {
                        this.method_1286().method_1727(var7, var8, var10.toString(), Parser.field_1539[var5]);
                    }
                } else if (this.field_974) {
                    this.method_1286().method_1728(var7, var8, var10.toString());
                }
                break;
            default:
                if (var6.length() == 0) {
                    if (this.field_973 != null) {
                        this.field_973.method_2451(var7, var8);
                    }
                    if (this.field_974) {
                        this.method_1286().method_1734(var7, var8);
                    }
                } else {
                    if (this.field_973 != null) {
                        if (var9 > -1) {
                            this.field_973.method_2449(var9, var7, var8);
                        } else {
                            var19 = this.method_1311(-var9);
                            if (var19 != null) {
                                this.field_973.method_2450(var19, var7, var8);
                            }
                        }
                    }
                    if (this.field_974) {
                        this.method_1286().method_1736(var7, var8, var6);
                    }
                }
        }
    }

    private int[] method_1311(int var1) {
        char var2 = Parser.field_1542[var1];
        if (var2 <= 0) {
            return null;
        } else {
            int[] var3 = new int[Parser.field_1543.length];
            int var4 = 0;
            for (int var5 = var2; Parser.field_1543[var5] != 0; ++var5) {
                var3[var4++] = Parser.field_1543[var5];
            }
            System.arraycopy(var3, 0, var3 = new int[var4], 0, var4);
            return var3;
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(this.field_949.toString());
        return var1.toString();
    }
}
