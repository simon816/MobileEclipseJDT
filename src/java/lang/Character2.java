package java.lang;

public class Character2 {

    public Character2() {
    }

    public static boolean isDigit(char var0) {
        return var0 >= 48 && var0 <= 57;
    }

    public static boolean isJavaIdentifierPart(char var0) {
        return isLetterOrDigit(var0) || var0 >= 0 && var0 <= 8 || var0 >= 14 && var0 <= 27 || var0 == 36 || var0 == 95 || var0 > 1365;
    }

    public static boolean isUpperCase(char var0) {
        return var0 >= 65 && var0 <= 90;
    }

    public static boolean isWhitespace(char var0) {
        return var0 == 32 || var0 == 13 || var0 == 10;
    }

    public static boolean isLetterOrDigit(char var0) {
        return var0 >= 97 && var0 <= 122 || var0 >= 65 && var0 <= 90 || var0 >= 48 && var0 <= 57;
    }

    public static boolean isJavaIdentifierStart(char var0) {
        return !isDigit(var0) && isJavaIdentifierPart(var0);
    }

    public static int getNumericValue(char var0) {
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
