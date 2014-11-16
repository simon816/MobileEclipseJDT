package org.eclipse.jdt.internal.compiler.util;

public class FloatUtil {

    public FloatUtil() {
    }

    public static float valueOfHexFloatLiteral(char[] var0) {
        long var1 = convertHexFloatingPointLiteralToBits(var0);
        return Float.intBitsToFloat((int)var1);
    }

    public static double valueOfHexDoubleLiteral(char[] var0) {
        long var1 = convertHexFloatingPointLiteralToBits(var0);
        return Double.longBitsToDouble(var1);
    }

    private static long convertHexFloatingPointLiteralToBits(char[] var0) {
        int var1 = var0.length;
        long var2 = 0L;
        byte var4 = 0;
        char var5 = var0[var4];
        if (var5 != 48) {
            throw new NumberFormatException();
        } else {
            int var23 = var4 + 1;
            var5 = var0[var23];
            if (var5 != 88 && var5 != 120) {
                throw new NumberFormatException();
            } else {
                ++var23;
                int var6 = -1;
                while (true) {
                    var5 = var0[var23];
                    switch (var5) {
                        case 46:
                            var6 = var23++;
                            break;
                        case 48:
                            ++var23;
                            break;
                        default:
                            int var7 = 0;
                            int var8 = -1;
                            while (true) {
                                var5 = var0[var23];
                                int var9;
                                switch (var5) {
                                    case 46:
                                        var6 = var23++;
                                        continue;
                                    case 47:
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
                                        if (var6 < 0) {
                                            var6 = var23;
                                        }
                                        var5 = var0[var23];
                                        if (var5 != 80 && var5 != 112) {
                                            throw new NumberFormatException();
                                        } else {
                                            ++var23;
                                            var9 = 0;
                                            byte var10 = 1;
                                            label136:
                                            while (var23 < var1) {
                                                var5 = var0[var23];
                                                switch (var5) {
                                                    case 43:
                                                        var10 = 1;
                                                        ++var23;
                                                        break;
                                                    case 44:
                                                    case 46:
                                                    case 47:
                                                    default:
                                                        break label136;
                                                    case 45:
                                                        var10 = -1;
                                                        ++var23;
                                                        break;
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
                                                        int var11 = var5 - 48;
                                                        var9 = var9 * 10 + var11;
                                                        ++var23;
                                                }
                                            }
                                            boolean var24 = true;
                                            if (var23 < var1) {
                                                var5 = var0[var23];
                                                switch (var5) {
                                                    case 68:
                                                    case 100:
                                                        var24 = true;
                                                        ++var23;
                                                        break;
                                                    case 70:
                                                    case 102:
                                                        var24 = false;
                                                        ++var23;
                                                        break;
                                                    default:
                                                        throw new NumberFormatException();
                                                }
                                            }
                                            if (var2 == 0L) {
                                                return 0L;
                                            } else {
                                                int var12 = 0;
                                                long var13 = var2 >>> var7 - 4;
                                                if ((var13 & 8L) == 0L) {
                                                    --var7;
                                                    ++var12;
                                                    if ((var13 & 4L) == 0L) {
                                                        --var7;
                                                        ++var12;
                                                        if ((var13 & 2L) == 0L) {
                                                            --var7;
                                                            ++var12;
                                                        }
                                                    }
                                                }
                                                long var15 = 0L;
                                                long var17;
                                                int var19;
                                                long var21;
                                                long var20;
                                                int var25;
                                                if (var24) {
                                                    if (var7 > 53) {
                                                        var19 = var7 - 53;
                                                        var17 = var2 >>> var19 - 1;
                                                        var20 = var17 & 1L;
                                                        var17 += var20;
                                                        var17 >>>= 1;
                                                        if ((var17 & 9007199254740992L) != 0L) {
                                                            var17 >>>= 1;
                                                            --var12;
                                                        }
                                                    } else {
                                                        var17 = var2 << 53 - var7;
                                                    }
                                                    var19 = 0;
                                                    if (var7 > 0) {
                                                        if (var8 < var6) {
                                                            var19 = 4 * (var6 - var8);
                                                            var19 -= var12;
                                                        } else {
                                                            var19 = -4 * (var8 - var6 - 1);
                                                            var19 -= var12;
                                                        }
                                                    }
                                                    var25 = var10 * var9 + var19;
                                                    if (var25 - 1 > 1023) {
                                                        var15 = Double.doubleToLongBits(Double.POSITIVE_INFINITY);
                                                    } else if (var25 - 1 >= -1022) {
                                                        var21 = (long)(var25 - 1 + 1023);
                                                        var15 = var17 & -4503599627370497L;
                                                        var15 |= var21 << 52;
                                                    } else if (var25 - 1 > -1075) {
                                                        var21 = 0L;
                                                        var15 = var17 >>> -1022 - var25 + 1;
                                                        var15 |= var21 << 52;
                                                    } else {
                                                        var15 = Double.doubleToLongBits(Double.NaN);
                                                    }
                                                    return var15;
                                                } else {
                                                    if (var7 > 24) {
                                                        var19 = var7 - 24;
                                                        var17 = var2 >>> var19 - 1;
                                                        var20 = var17 & 1L;
                                                        var17 += var20;
                                                        var17 >>>= 1;
                                                        if ((var17 & 16777216L) != 0L) {
                                                            var17 >>>= 1;
                                                            --var12;
                                                        }
                                                    } else {
                                                        var17 = var2 << 24 - var7;
                                                    }
                                                    var19 = 0;
                                                    if (var7 > 0) {
                                                        if (var8 < var6) {
                                                            var19 = 4 * (var6 - var8);
                                                            var19 -= var12;
                                                        } else {
                                                            var19 = -4 * (var8 - var6 - 1);
                                                            var19 -= var12;
                                                        }
                                                    }
                                                    var25 = var10 * var9 + var19;
                                                    if (var25 - 1 > 127) {
                                                        var15 = (long)Float.floatToIntBits(Float.POSITIVE_INFINITY);
                                                    } else if (var25 - 1 >= -126) {
                                                        var21 = (long)(var25 - 1 + 127);
                                                        var15 = var17 & -8388609L;
                                                        var15 |= var21 << 23;
                                                    } else if (var25 - 1 > -150) {
                                                        var21 = 0L;
                                                        var15 = var17 >>> -126 - var25 + 1;
                                                        var15 |= var21 << 23;
                                                    } else {
                                                        var15 = (long)Float.floatToIntBits(Float.NaN);
                                                    }
                                                    return var15;
                                                }
                                            }
                                        }
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
                                        var9 = var5 - 48;
                                        break;
                                    case 65:
                                    case 66:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                        var9 = var5 - 65 + 10;
                                        break;
                                    case 97:
                                    case 98:
                                    case 99:
                                    case 100:
                                    case 101:
                                    case 102:
                                        var9 = var5 - 97 + 10;
                                }
                                if (var7 == 0) {
                                    var8 = var23;
                                    var2 = (long)var9;
                                    var7 = 4;
                                } else if (var7 < 60) {
                                    var2 <<= 4;
                                    var2 |= (long)var9;
                                    var7 += 4;
                                }
                                ++var23;
                            }
                    }
                }
            }
        }
    }
}
