package org.eclipse.jdt.internal.compiler.parser.diagnose;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.diagnose.LexStream$Token;
import org.eclipse.jdt.internal.compiler.util.Util;

public class LexStream {

    private int field_909;

    private int field_910;

    private LexStream$Token[] tokenCache;

    private int field_912;

    private Scanner scanner;

    private int[] field_914;

    private int[] field_915;

    private int[] field_916;

    private int field_917;

    private int field_918;

    public LexStream(int var1, Scanner var2, int[] var3, int[] var4, int[] var5, int var6, int var7, int var8) {
        this.field_912 = -1;
        this.field_917 = -1;
        this.field_918 = -1;
        this.tokenCache = new LexStream$Token[var1];
        this.field_909 = 0;
        this.field_910 = Integer.MAX_VALUE;
        LexStream$Token[] var10000 = this.tokenCache;
        LexStream$Token var10002 = new LexStream$Token();
        var10000[0] = var10002;
        this.tokenCache[0].field_920 = var6;
        this.tokenCache[0].name = CharOperation.NO_CHAR;
        this.tokenCache[0].field_922 = var7;
        this.tokenCache[0].field_923 = var7;
        this.tokenCache[0].field_924 = 0;
        this.field_914 = var3;
        this.field_915 = var4;
        this.field_916 = var5;
        var2.method_2435(var7, var8);
        this.scanner = var2;
    }

    private void readTokenFromScanner() {
        int var1 = this.tokenCache.length;
        boolean var2 = true;
        while (var2) {
            try {
                int var3 = this.scanner.getNextToken();
                int var4;
                int var5;
                LexStream$Token var10000;
                if (var3 != 68) {
                    var4 = this.scanner.method_2411();
                    var5 = this.scanner.method_2408();
                    int var6 = this.field_918 + 1;
                    if (this.field_914.length != 0 && var6 < this.field_914.length && var4 >= this.field_914[var6]) {
                        this.scanner.method_2435(this.field_915[++this.field_918] + 1, this.scanner.field_1233 - 1);
                    } else {
                        var10000 = new LexStream$Token();
                        LexStream$Token var7 = var10000;
                        var7.field_920 = var3;
                        var7.name = this.scanner.method_2409();
                        var7.field_922 = var4;
                        var7.field_923 = var5;
                        var7.field_924 = Util.getLineNumber(var5, this.scanner.field_1256, 0, this.scanner.field_1257);
                        if (this.field_918 != this.field_917 && (this.field_916[this.field_918] & 2) == 0) {
                            var7.field_925 = 1;
                            if ((this.field_916[this.field_918] & 1) != 0) {
                                var7.field_925 |= 2;
                            }
                        }
                        this.field_917 = this.field_918;
                        this.tokenCache[++this.field_909 % var1] = var7;
                        var2 = false;
                    }
                } else {
                    var4 = this.scanner.method_2411();
                    var5 = this.scanner.method_2408();
                    var10000 = new LexStream$Token();
                    LexStream$Token var9 = var10000;
                    var9.field_920 = var3;
                    var9.name = CharOperation.NO_CHAR;
                    var9.field_922 = var4;
                    var9.field_923 = var5;
                    var9.field_924 = Util.getLineNumber(var5, this.scanner.field_1256, 0, this.scanner.field_1257);
                    this.tokenCache[++this.field_909 % var1] = var9;
                    this.field_910 = this.field_909;
                    var2 = false;
                }
            } catch (InvalidInputException var8) {
                ;
            }
        }
    }

    public LexStream$Token token(int var1) {
        if (var1 < 0) {
            LexStream$Token var5 = new LexStream$Token();
            LexStream$Token var4 = var5;
            var4.field_920 = 68;
            var4.name = CharOperation.NO_CHAR;
            return var4;
        } else if (this.field_910 >= 0 && var1 > this.field_910) {
            return this.token(this.field_910);
        } else {
            int var2 = this.tokenCache.length;
            if (var1 > this.field_909) {
                int var3 = var1 - this.field_909;
                while (var3-- != 0) {
                    this.readTokenFromScanner();
                }
            } else if (this.field_909 - var2 >= var1) {
                return null;
            }
            return this.tokenCache[var1 % var2];
        }
    }

    public int method_1205() {
        return this.field_912 = this.method_1207(this.field_912);
    }

    public int method_1206(int var1) {
        return var1 > 0 ? var1 - 1 : 0;
    }

    public int method_1207(int var1) {
        return var1 < this.field_910 ? var1 + 1 : this.field_910;
    }

    public boolean method_1208(int var1) {
        return var1 < 1 ? true : this.method_1214(var1 - 1) < this.method_1214(var1);
    }

    public void reset() {
        this.field_912 = -1;
    }

    public void reset(int var1) {
        this.field_912 = this.method_1206(var1);
    }

    public int method_1211() {
        return 0;
    }

    public int method_1212(int var1) {
        return this.token(var1).field_920;
    }

    public char[] name(int var1) {
        return this.token(var1).name;
    }

    public int method_1214(int var1) {
        return this.token(var1).field_924;
    }

    public int method_1215(int var1) {
        return this.token(var1).field_922;
    }

    public int method_1216(int var1) {
        return this.token(var1).field_923;
    }

    public boolean method_1217(int var1) {
        return this.field_910 >= 0 && var1 > this.field_910 ? false : (var1 > this.field_909 ? true : this.field_909 - this.tokenCache.length < var1);
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        String var2 = new String(this.scanner.field_1237);
        int var4;
        int var5;
        int var6;
        if (this.field_912 < 0) {
            int var3 = -1;
            for (var4 = 0; var4 < this.field_914.length; ++var4) {
                var5 = this.field_914[var4];
                var6 = this.field_915[var4];
                var1.append(var2.substring(var3 + 1, var5));
                var1.append('<');
                var1.append('@');
                var1.append(var2.substring(var5, var6 + 1));
                var1.append('@');
                var1.append('>');
                var3 = var6;
            }
            var1.append(var2.substring(var3 + 1));
        } else {
            LexStream$Token var11 = this.token(this.field_912);
            var4 = var11.field_920;
            var5 = var11.field_922;
            var6 = var11.field_923;
            int var7 = -1;
            for (int var8 = 0; var8 < this.field_914.length; ++var8) {
                int var9 = this.field_914[var8];
                int var10 = this.field_915[var8];
                if (var5 >= var7 && var6 <= var9) {
                    var1.append(var2.substring(var7 + 1, var5));
                    var1.append('<');
                    var1.append('#');
                    var1.append(var2.substring(var5, var6 + 1));
                    var1.append('#');
                    var1.append('>');
                    var1.append(var2.substring(var6 + 1, var9));
                } else {
                    var1.append(var2.substring(var7 + 1, var9));
                }
                var1.append('<');
                var1.append('@');
                var1.append(var2.substring(var9, var10 + 1));
                var1.append('@');
                var1.append('>');
                var7 = var10;
            }
            if (var5 >= var7) {
                var1.append(var2.substring(var7 + 1, var5));
                var1.append('<');
                var1.append('#');
                if (var4 == 68) {
                    var1.append("EOF#>");
                } else {
                    var1.append(var2.substring(var5, var6 + 1));
                    var1.append('#');
                    var1.append('>');
                    var1.append(var2.substring(var6 + 1));
                }
            } else {
                var1.append(var2.substring(var7 + 1));
            }
        }
        return var1.toString();
    }
}
