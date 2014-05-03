package g;

// $FF: renamed from: g.c
public class class_305 {

    // $FF: renamed from: <init> () void
    public class_305() {
    }

    // $FF: renamed from: a (char) boolean
    public static boolean method_3123(char var0) {
        return var0 >= 48 && var0 <= 57;
    }

    // $FF: renamed from: b (char) boolean
    public static boolean method_3124(char var0) {
        return method_3127(var0) || var0 >= 0 && var0 <= 8 || var0 >= 14 && var0 <= 27 || var0 == 36 || var0 == 95 || var0 > 1365;
    }

    // $FF: renamed from: c (char) boolean
    public static boolean method_3125(char var0) {
        return var0 >= 65 && var0 <= 90;
    }

    // $FF: renamed from: d (char) boolean
    public static boolean method_3126(char var0) {
        return var0 == 32 || var0 == 13 || var0 == 10;
    }

    // $FF: renamed from: e (char) boolean
    public static boolean method_3127(char var0) {
        return var0 >= 97 && var0 <= 122 || var0 >= 65 && var0 <= 90 || var0 >= 48 && var0 <= 57;
    }

    // $FF: renamed from: f (char) boolean
    public static boolean method_3128(char var0) {
        return !method_3123(var0) && method_3124(var0);
    }

    // $FF: renamed from: a (char) int
    public static int method_3129(char var0) {
        switch (var0) {
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
                return var0 - 48;
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
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
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            default:
                throw new RuntimeException();
            case 65:
            case 97:
                return 10;
            case 66:
            case 98:
                return 11;
            case 67:
            case 99:
                return 12;
            case 68:
            case 100:
                return 13;
            case 69:
            case 101:
                return 14;
            case 70:
            case 102:
                return 15;
        }
    }
}
