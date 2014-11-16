package org.eclipse.jdt.internal.compiler.parser;

import java.lang.Character2;

import java.io.DataInputStream;
import java.io.IOException;

import org.eclipse.jdt.core.compiler.InvalidInputException;

public class ScannerHelper {

    public static final long[] Bits;

    private static long[][][] Tables;

    public static final int[] OBVIOUS_IDENT_CHAR_NATURES;

    static Class field_1985;

    public ScannerHelper() {
    }

    private static final boolean isBitSet(long[] var0, int var1) {
        try {
            return (var0[var1 / 64] & Bits[var1 % 64]) != 0L;
        } catch (NullPointerException var3) {
            return false;
        }
    }

    public static boolean method_3333(char var0) {
        return var0 < 128 ? (OBVIOUS_IDENT_CHAR_NATURES[var0] & 8) != 0 : Character2.isJavaIdentifierPart(var0);
    }

    public static boolean method_3334(char var0, char var1) {
        int var2 = toCodePoint(var0, var1);
        switch ((var2 & 2031616) >> 16) {
            case 0:
                return Character2.isJavaIdentifierPart((char)var2);
            case 1:
                return isBitSet(Tables[1][0], var2 & '\uffff');
            case 2:
                return isBitSet(Tables[1][1], var2 & '\uffff');
            case 14:
                return isBitSet(Tables[1][2], var2 & '\uffff');
            default:
                return false;
        }
    }

    public static boolean method_3335(char var0) {
        return var0 < 128 ? (OBVIOUS_IDENT_CHAR_NATURES[var0] & 64) != 0 : Character2.isJavaIdentifierStart(var0);
    }

    public static boolean method_3336(char var0, char var1) {
        int var2 = toCodePoint(var0, var1);
        switch ((var2 & 2031616) >> 16) {
            case 0:
                return Character2.isJavaIdentifierStart((char)var2);
            case 1:
                return isBitSet(Tables[0][0], var2 & '\uffff');
            case 2:
                return isBitSet(Tables[0][1], var2 & '\uffff');
            default:
                return false;
        }
    }

    private static int toCodePoint(char var0, char var1) {
        return (var0 - '\ud800') * 1024 + (var1 - '\udc00') + 65536;
    }

    public static boolean method_3338(char var0) throws InvalidInputException {
        if (var0 < 128) {
            return (OBVIOUS_IDENT_CHAR_NATURES[var0] & 4) != 0;
        } else if (Character.isDigit(var0)) {
            InvalidInputException var10000 = new InvalidInputException("Invalid_Digit");
            throw var10000;
        } else {
            return false;
        }
    }

    public static int digit(char var0, int var1) {
        if (var0 < 128) {
            switch (var1) {
                case 8:
                    if (var0 >= 48 && var0 <= 55) {
                        return var0 - 48;
                    }
                    return -1;
                case 10:
                    if (var0 >= 48 && var0 <= 57) {
                        return var0 - 48;
                    }
                    return -1;
                case 16:
                    if (var0 >= 48 && var0 <= 57) {
                        return var0 - 48;
                    }
                    if (var0 >= 65 && var0 <= 70) {
                        return var0 - 65 + 10;
                    }
                    if (var0 >= 97 && var0 <= 102) {
                        return var0 - 97 + 10;
                    }
                    return -1;
            }
        }
        return Character.digit(var0, var1);
    }

    public static int getNumericValue(char var0) {
        if (var0 < 128) {
            switch (OBVIOUS_IDENT_CHAR_NATURES[var0]) {
                case 4:
                    return var0 - 48;
                case 16:
                    return 10 + var0 - 97;
                case 32:
                    return 10 + var0 - 65;
            }
        }
        return Character2.getNumericValue(var0);
    }

    public static char method_3341(char var0) {
        if (var0 < 128) {
            if ((OBVIOUS_IDENT_CHAR_NATURES[var0] & 16) != 0) {
                return var0;
            }
            if ((OBVIOUS_IDENT_CHAR_NATURES[var0] & 32) != 0) {
                return (char)(32 + var0);
            }
        }
        return Character.toLowerCase(var0);
    }

    public static boolean method_3342(char var0) {
        return var0 < 128 ? (OBVIOUS_IDENT_CHAR_NATURES[var0] & 32) != 0 : Character2.isUpperCase(var0);
    }

    public static boolean method_3343(char var0) {
        return var0 < 128 ? (OBVIOUS_IDENT_CHAR_NATURES[var0] & 1) != 0 : Character2.isWhitespace(var0);
    }

    static Class method_3344(String var0) {
        try {
            return Class.forName(var0);
        } catch (ClassNotFoundException var2) {
            throw new NoClassDefFoundError(var2.getMessage());
        }
    }

    static {
        Bits = new long[] {1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L, 16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, -2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
        OBVIOUS_IDENT_CHAR_NATURES = new int[128];
        OBVIOUS_IDENT_CHAR_NATURES[0] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[1] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[2] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[3] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[4] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[5] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[6] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[7] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[8] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[14] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[15] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[16] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[17] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[18] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[19] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[20] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[21] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[22] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[23] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[24] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[25] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[26] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[27] = 8;
        OBVIOUS_IDENT_CHAR_NATURES[127] = 8;
        int var0;
        for (var0 = 48; var0 <= 57; ++var0) {
            OBVIOUS_IDENT_CHAR_NATURES[var0] = 12;
        }
        for (var0 = 97; var0 <= 122; ++var0) {
            OBVIOUS_IDENT_CHAR_NATURES[var0] = 88;
        }
        for (var0 = 65; var0 <= 90; ++var0) {
            OBVIOUS_IDENT_CHAR_NATURES[var0] = 104;
        }
        OBVIOUS_IDENT_CHAR_NATURES[95] = 200;
        OBVIOUS_IDENT_CHAR_NATURES[36] = 200;
        OBVIOUS_IDENT_CHAR_NATURES[9] = 257;
        OBVIOUS_IDENT_CHAR_NATURES[10] = 257;
        OBVIOUS_IDENT_CHAR_NATURES[11] = 1;
        OBVIOUS_IDENT_CHAR_NATURES[12] = 257;
        OBVIOUS_IDENT_CHAR_NATURES[13] = 257;
        OBVIOUS_IDENT_CHAR_NATURES[28] = 1;
        OBVIOUS_IDENT_CHAR_NATURES[29] = 1;
        OBVIOUS_IDENT_CHAR_NATURES[30] = 1;
        OBVIOUS_IDENT_CHAR_NATURES[31] = 1;
        OBVIOUS_IDENT_CHAR_NATURES[32] = 257;
        OBVIOUS_IDENT_CHAR_NATURES[46] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[58] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[59] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[44] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[91] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[93] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[40] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[41] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[123] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[125] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[43] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[45] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[42] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[47] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[61] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[38] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[124] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[63] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[60] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[62] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[33] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[37] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[94] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[126] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[34] = 2;
        OBVIOUS_IDENT_CHAR_NATURES[39] = 2;
        Tables = new long[2][][];
        Tables[0] = new long[2][];
        Tables[1] = new long[3][];
        long[] var1;
        int var2;
        DataInputStream var8;
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.ScannerHelper")) : field_1985).getResourceAsStream("/batch/start1.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            Tables[0][0] = var1;
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.ScannerHelper")) : field_1985).getResourceAsStream("/batch/start2.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            Tables[0][1] = var1;
        } catch (IOException var6) {
            var6.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.ScannerHelper")) : field_1985).getResourceAsStream("/batch/part1.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            Tables[1][0] = var1;
        } catch (IOException var5) {
            var5.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.ScannerHelper")) : field_1985).getResourceAsStream("/batch/part2.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            Tables[1][1] = var1;
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.ScannerHelper")) : field_1985).getResourceAsStream("/batch/part14.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            Tables[1][2] = var1;
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }
}
