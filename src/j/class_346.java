package j;

import b.class_232;
import g.class_305;
import java.io.DataInputStream;
import java.io.IOException;

public class class_346 {

    public static final long[] field_1982;

    private static long[][][] field_1983;

    public static final int[] field_1984;

    static Class field_1985;

    public class_346() {
    }

    private static final boolean method_3332(long[] var0, int var1) {
        try {
            return (var0[var1 / 64] & field_1982[var1 % 64]) != 0L;
        } catch (NullPointerException var3) {
            return false;
        }
    }

    public static boolean method_3333(char var0) {
        return var0 < 128 ? (field_1984[var0] & 8) != 0 : class_305.method_3124(var0);
    }

    public static boolean method_3334(char var0, char var1) {
        int var2 = method_3337(var0, var1);
        switch ((var2 & 2031616) >> 16) {
            case 0:
                return class_305.method_3124((char)var2);
            case 1:
                return method_3332(field_1983[1][0], var2 & '\uffff');
            case 2:
                return method_3332(field_1983[1][1], var2 & '\uffff');
            case 14:
                return method_3332(field_1983[1][2], var2 & '\uffff');
            default:
                return false;
        }
    }

    public static boolean method_3335(char var0) {
        return var0 < 128 ? (field_1984[var0] & 64) != 0 : class_305.method_3128(var0);
    }

    public static boolean method_3336(char var0, char var1) {
        int var2 = method_3337(var0, var1);
        switch ((var2 & 2031616) >> 16) {
            case 0:
                return class_305.method_3128((char)var2);
            case 1:
                return method_3332(field_1983[0][0], var2 & '\uffff');
            case 2:
                return method_3332(field_1983[0][1], var2 & '\uffff');
            default:
                return false;
        }
    }

    private static int method_3337(char var0, char var1) {
        return (var0 - '\ud800') * 1024 + (var1 - '\udc00') + 65536;
    }

    public static boolean method_3338(char var0) throws class_232 {
        if (var0 < 128) {
            return (field_1984[var0] & 4) != 0;
        } else if (Character.isDigit(var0)) {
            class_232 var10000 = new class_232("Invalid_Digit");
            throw var10000;
        } else {
            return false;
        }
    }

    public static int method_3339(char var0, int var1) {
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

    public static int method_3340(char var0) {
        if (var0 < 128) {
            switch (field_1984[var0]) {
                case 4:
                    return var0 - 48;
                case 16:
                    return 10 + var0 - 97;
                case 32:
                    return 10 + var0 - 65;
            }
        }
        return class_305.method_3129(var0);
    }

    public static char method_3341(char var0) {
        if (var0 < 128) {
            if ((field_1984[var0] & 16) != 0) {
                return var0;
            }
            if ((field_1984[var0] & 32) != 0) {
                return (char)(32 + var0);
            }
        }
        return Character.toLowerCase(var0);
    }

    public static boolean method_3342(char var0) {
        return var0 < 128 ? (field_1984[var0] & 32) != 0 : class_305.method_3125(var0);
    }

    public static boolean method_3343(char var0) {
        return var0 < 128 ? (field_1984[var0] & 1) != 0 : class_305.method_3126(var0);
    }

    static Class method_3344(String var0) {
        try {
            return Class.forName(var0);
        } catch (ClassNotFoundException var2) {
            throw new NoClassDefFoundError(var2.getMessage());
        }
    }

    static {
        field_1982 = new long[] {1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L, 16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, -2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
        field_1984 = new int[128];
        field_1984[0] = 8;
        field_1984[1] = 8;
        field_1984[2] = 8;
        field_1984[3] = 8;
        field_1984[4] = 8;
        field_1984[5] = 8;
        field_1984[6] = 8;
        field_1984[7] = 8;
        field_1984[8] = 8;
        field_1984[14] = 8;
        field_1984[15] = 8;
        field_1984[16] = 8;
        field_1984[17] = 8;
        field_1984[18] = 8;
        field_1984[19] = 8;
        field_1984[20] = 8;
        field_1984[21] = 8;
        field_1984[22] = 8;
        field_1984[23] = 8;
        field_1984[24] = 8;
        field_1984[25] = 8;
        field_1984[26] = 8;
        field_1984[27] = 8;
        field_1984[127] = 8;
        int var0;
        for (var0 = 48; var0 <= 57; ++var0) {
            field_1984[var0] = 12;
        }
        for (var0 = 97; var0 <= 122; ++var0) {
            field_1984[var0] = 88;
        }
        for (var0 = 65; var0 <= 90; ++var0) {
            field_1984[var0] = 104;
        }
        field_1984[95] = 200;
        field_1984[36] = 200;
        field_1984[9] = 257;
        field_1984[10] = 257;
        field_1984[11] = 1;
        field_1984[12] = 257;
        field_1984[13] = 257;
        field_1984[28] = 1;
        field_1984[29] = 1;
        field_1984[30] = 1;
        field_1984[31] = 1;
        field_1984[32] = 257;
        field_1984[46] = 2;
        field_1984[58] = 2;
        field_1984[59] = 2;
        field_1984[44] = 2;
        field_1984[91] = 2;
        field_1984[93] = 2;
        field_1984[40] = 2;
        field_1984[41] = 2;
        field_1984[123] = 2;
        field_1984[125] = 2;
        field_1984[43] = 2;
        field_1984[45] = 2;
        field_1984[42] = 2;
        field_1984[47] = 2;
        field_1984[61] = 2;
        field_1984[38] = 2;
        field_1984[124] = 2;
        field_1984[63] = 2;
        field_1984[60] = 2;
        field_1984[62] = 2;
        field_1984[33] = 2;
        field_1984[37] = 2;
        field_1984[94] = 2;
        field_1984[126] = 2;
        field_1984[34] = 2;
        field_1984[39] = 2;
        field_1983 = new long[2][][];
        field_1983[0] = new long[2][];
        field_1983[1] = new long[3][];
        long[] var1;
        int var2;
        DataInputStream var8;
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.class_346")) : field_1985).getResourceAsStream("/batch/start1.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            field_1983[0][0] = var1;
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.class_346")) : field_1985).getResourceAsStream("/batch/start2.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            field_1983[0][1] = var1;
        } catch (IOException var6) {
            var6.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.class_346")) : field_1985).getResourceAsStream("/batch/part1.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            field_1983[1][0] = var1;
        } catch (IOException var5) {
            var5.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.class_346")) : field_1985).getResourceAsStream("/batch/part2.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            field_1983[1][1] = var1;
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        try {
            var8 = new DataInputStream((field_1985 == null ? (field_1985 = method_3344("j.class_346")) : field_1985).getResourceAsStream("/batch/part14.rsc"));
            var1 = new long[1024];
            for (var2 = 0; var2 < 1024; ++var2) {
                var1[var2] = var8.readLong();
            }
            var8.close();
            field_1983[1][2] = var1;
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }
}
