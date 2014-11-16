package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.impl.DoubleConstant;
import org.eclipse.jdt.internal.compiler.impl.FloatConstant;
import org.eclipse.jdt.internal.compiler.impl.ShortConstant;
import org.eclipse.jdt.internal.compiler.impl.LongConstant;
import org.eclipse.jdt.internal.compiler.impl.StringConstant;
import org.eclipse.jdt.internal.compiler.impl.IntConstant;
import org.eclipse.jdt.internal.compiler.impl.CharConstant;
import org.eclipse.jdt.internal.compiler.impl.ByteConstant;
import org.eclipse.jdt.internal.compiler.impl.BooleanConstant;
import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;
import org.eclipse.jdt.internal.compiler.util.Messages;

public abstract class Constant {

    public static final Constant NotAConstant;

    public Constant() {
    }

    public boolean booleanValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "boolean"}));
        throw var10000;
    }

    public byte byteValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "byte"}));
        throw var10000;
    }

    public final Constant castTo(int var1) {
        if (this == NotAConstant) {
            return NotAConstant;
        } else {
            switch (var1) {
                case 0:
                    return this;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 37:
                case 38:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 53:
                case 54:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
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
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 133:
                case 134:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 149:
                case 150:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 165:
                case 166:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                default:
                    return NotAConstant;
                case 34:
                    return this;
                case 35:
                    return CharConstant.fromValue((char)this.byteValue());
                case 36:
                    return CharConstant.fromValue((char)this.shortValue());
                case 39:
                    return CharConstant.fromValue((char)((int)this.longValue()));
                case 40:
                    return CharConstant.fromValue((char)((int)this.doubleValue()));
                case 41:
                    return CharConstant.fromValue((char)((int)this.floatValue()));
                case 42:
                    return CharConstant.fromValue((char)this.intValue());
                case 50:
                    return ByteConstant.fromValue((byte)this.charValue());
                case 51:
                    return this;
                case 52:
                    return ByteConstant.fromValue((byte)this.shortValue());
                case 55:
                    return ByteConstant.fromValue((byte)((int)this.longValue()));
                case 56:
                    return ByteConstant.fromValue((byte)((int)this.doubleValue()));
                case 57:
                    return ByteConstant.fromValue((byte)((int)this.floatValue()));
                case 58:
                    return ByteConstant.fromValue((byte)this.intValue());
                case 66:
                    return ShortConstant.fromValue((short)this.charValue());
                case 67:
                    return ShortConstant.fromValue((short)this.byteValue());
                case 68:
                    return this;
                case 71:
                    return ShortConstant.fromValue((short)((int)this.longValue()));
                case 72:
                    return ShortConstant.fromValue((short)((int)this.doubleValue()));
                case 73:
                    return ShortConstant.fromValue((short)((int)this.floatValue()));
                case 74:
                    return ShortConstant.fromValue((short)this.intValue());
                case 85:
                    return this;
                case 114:
                    return LongConstant.fromValue((long)this.charValue());
                case 115:
                    return LongConstant.fromValue((long)this.byteValue());
                case 116:
                    return LongConstant.fromValue((long)this.shortValue());
                case 119:
                    return this;
                case 120:
                    return LongConstant.fromValue((long)this.doubleValue());
                case 121:
                    return LongConstant.fromValue((long)this.floatValue());
                case 122:
                    return LongConstant.fromValue((long)this.intValue());
                case 130:
                    return DoubleConstant.fromValue((double)this.charValue());
                case 131:
                    return DoubleConstant.fromValue((double)this.byteValue());
                case 132:
                    return DoubleConstant.fromValue((double)this.shortValue());
                case 135:
                    return DoubleConstant.fromValue((double)this.longValue());
                case 136:
                    return this;
                case 137:
                    return DoubleConstant.fromValue((double)this.floatValue());
                case 138:
                    return DoubleConstant.fromValue((double)this.intValue());
                case 146:
                    return FloatConstant.fromValue((float)this.charValue());
                case 147:
                    return FloatConstant.fromValue((float)this.byteValue());
                case 148:
                    return FloatConstant.fromValue((float)this.shortValue());
                case 151:
                    return FloatConstant.fromValue((float)this.longValue());
                case 152:
                    return FloatConstant.fromValue((float)this.doubleValue());
                case 153:
                    return this;
                case 154:
                    return FloatConstant.fromValue((float)this.intValue());
                case 162:
                    return IntConstant.fromValue(this.charValue());
                case 163:
                    return IntConstant.fromValue(this.byteValue());
                case 164:
                    return IntConstant.fromValue(this.shortValue());
                case 167:
                    return IntConstant.fromValue((int)this.longValue());
                case 168:
                    return IntConstant.fromValue((int)this.doubleValue());
                case 169:
                    return IntConstant.fromValue((int)this.floatValue());
                case 170:
                    return this;
                case 187:
                    return this;
            }
        }
    }

    public char charValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "char"}));
        throw var10000;
    }

    public static final Constant computeConstantOperation(Constant var0, int var1, int var2) {
        switch (var2) {
            case 11:
                return BooleanConstant.fromValue(!var0.booleanValue());
            case 12:
                switch (var1) {
                    case 2:
                        return IntConstant.fromValue(~var0.charValue());
                    case 3:
                        return IntConstant.fromValue(~var0.byteValue());
                    case 4:
                        return IntConstant.fromValue(~var0.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(~var0.longValue());
                    case 10:
                        return IntConstant.fromValue(~var0.intValue());
                }
            case 13:
                switch (var1) {
                    case 8:
                        double var4;
                        if ((var4 = var0.doubleValue()) == 0.0D) {
                            if (Double.doubleToLongBits(var4) == 0L) {
                                return DoubleConstant.fromValue(-0.0D);
                            }
                            return DoubleConstant.fromValue(0.0D);
                        }
                        break;
                    case 9:
                        float var3;
                        if ((var3 = var0.floatValue()) == 0.0F) {
                            if (Float.floatToIntBits(var3) == 0) {
                                return FloatConstant.fromValue(-0.0F);
                            }
                            return FloatConstant.fromValue(0.0F);
                        }
                }
                return method_3272(IntConstant.fromValue(0), 10, var0, var1);
            case 14:
                return method_3276(IntConstant.fromValue(0), 10, var0, var1);
            default:
                return NotAConstant;
        }
    }

    public static final Constant computeConstantOperation(Constant var0, int var1, int var2, Constant var3, int var4) {
        switch (var2) {
            case 0:
                return method_3264(var0, var1, var3, var4);
            case 1:
                return method_3275(var0, var1, var3, var4);
            case 2:
                return method_3263(var0, var1, var3, var4);
            case 3:
                return method_3274(var0, var1, var3, var4);
            case 4:
                return method_3270(var0, var1, var3, var4);
            case 5:
                return method_3271(var0, var1, var3, var4);
            case 6:
                return method_3267(var0, var1, var3, var4);
            case 7:
                return method_3268(var0, var1, var3, var4);
            case 8:
                return method_3280(var0, var1, var3, var4);
            case 9:
                return method_3265(var0, var1, var3, var4);
            case 10:
                return method_3269(var0, var1, var3, var4);
            case 11:
            case 12:
            case 18:
            default:
                return NotAConstant;
            case 13:
                return method_3272(var0, var1, var3, var4);
            case 14:
                return method_3276(var0, var1, var3, var4);
            case 15:
                return method_3273(var0, var1, var3, var4);
            case 16:
                return method_3277(var0, var1, var3, var4);
            case 17:
                return method_3278(var0, var1, var3, var4);
            case 19:
                return method_3279(var0, var1, var3, var4);
        }
    }

    public static final Constant method_3263(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() & var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() & var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() & var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() & var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() & var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() & var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() & var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() & var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() & var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() & var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() & var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() & var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() & var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() & var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() & var2.intValue());
                }
            case 5:
                return BooleanConstant.fromValue(var0.booleanValue() & var2.booleanValue());
            case 6:
            case 8:
            case 9:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() & (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() & (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() & (long)var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() & var2.longValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() & (long)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() & var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() & var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() & var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() & var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() & var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3264(Constant var0, int var1, Constant var2, int var3) {
        return BooleanConstant.fromValue(var0.booleanValue() && var2.booleanValue());
    }

    public static final Constant method_3265(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() / var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() / var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() / var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() / var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.charValue() / var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.charValue() / var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() / var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() / var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() / var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() / var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() / var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.byteValue() / var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.byteValue() / var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() / var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() / var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() / var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() / var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() / var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.shortValue() / var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.shortValue() / var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() / var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() / (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() / (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() / (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() / var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.longValue() / var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.longValue() / var2.floatValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() / (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return DoubleConstant.fromValue(var0.doubleValue() / (double)var2.charValue());
                    case 3:
                        return DoubleConstant.fromValue(var0.doubleValue() / (double)var2.byteValue());
                    case 4:
                        return DoubleConstant.fromValue(var0.doubleValue() / (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return DoubleConstant.fromValue(var0.doubleValue() / (double)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue(var0.doubleValue() / var2.doubleValue());
                    case 9:
                        return DoubleConstant.fromValue(var0.doubleValue() / (double)var2.floatValue());
                    case 10:
                        return DoubleConstant.fromValue(var0.doubleValue() / (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return FloatConstant.fromValue(var0.floatValue() / (float)var2.charValue());
                    case 3:
                        return FloatConstant.fromValue(var0.floatValue() / (float)var2.byteValue());
                    case 4:
                        return FloatConstant.fromValue(var0.floatValue() / (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return FloatConstant.fromValue(var0.floatValue() / (float)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.floatValue() / var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue(var0.floatValue() / var2.floatValue());
                    case 10:
                        return FloatConstant.fromValue(var0.floatValue() / (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() / var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() / var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() / var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() / var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.intValue() / var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.intValue() / var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() / var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3266(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.charValue() == var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.charValue() == var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.charValue() == var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue((long)var0.charValue() == var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.charValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.charValue() == var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.charValue() == var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.byteValue() == var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.byteValue() == var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.byteValue() == var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue((long)var0.byteValue() == var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.byteValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.byteValue() == var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.byteValue() == var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.shortValue() == var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.shortValue() == var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.shortValue() == var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue((long)var0.shortValue() == var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.shortValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.shortValue() == var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.shortValue() == var2.intValue());
                }
            case 5:
                if (var3 == 5) {
                    return BooleanConstant.fromValue(var0.booleanValue() == var2.booleanValue());
                }
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.longValue() == (long)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.longValue() == (long)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.longValue() == (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue(var0.longValue() == var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.longValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.longValue() == var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.longValue() == (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.doubleValue() == (double)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.doubleValue() == (double)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.doubleValue() == (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue(var0.doubleValue() == (double)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue(var0.doubleValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.doubleValue() == (double)var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.doubleValue() == (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.floatValue() == (float)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.floatValue() == (float)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.floatValue() == (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue(var0.floatValue() == (float)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.floatValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.floatValue() == var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.floatValue() == (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.intValue() == var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.intValue() == var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.intValue() == var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return BooleanConstant.fromValue(false);
                    case 7:
                        return BooleanConstant.fromValue((long)var0.intValue() == var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.intValue() == var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.intValue() == var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.intValue() == var2.intValue());
                }
            case 11:
                if (var3 == 11) {
                    return BooleanConstant.fromValue(((StringConstant)var0).hasSameValue(var2));
                }
                break;
            case 12:
                if (var3 == 11) {
                    return BooleanConstant.fromValue(false);
                }
                if (var3 == 12) {
                    return BooleanConstant.fromValue(true);
                }
        }
        return BooleanConstant.fromValue(false);
    }

    public static final Constant method_3267(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.charValue() > var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.charValue() > var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.charValue() > var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.charValue() > var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.charValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.charValue() > var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.charValue() > var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.byteValue() > var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.byteValue() > var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.byteValue() > var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.byteValue() > var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.byteValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.byteValue() > var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.byteValue() > var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.shortValue() > var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.shortValue() > var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.shortValue() > var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.shortValue() > var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.shortValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.shortValue() > var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.shortValue() > var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.longValue() > (long)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.longValue() > (long)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.longValue() > (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.longValue() > var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.longValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.longValue() > var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.longValue() > (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.doubleValue() > (double)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.doubleValue() > (double)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.doubleValue() > (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.doubleValue() > (double)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue(var0.doubleValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.doubleValue() > (double)var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.doubleValue() > (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.floatValue() > (float)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.floatValue() > (float)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.floatValue() > (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.floatValue() > (float)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.floatValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.floatValue() > var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.floatValue() > (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.intValue() > var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.intValue() > var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.intValue() > var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.intValue() > var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.intValue() > var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.intValue() > var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.intValue() > var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3268(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.charValue() >= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.charValue() >= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.charValue() >= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.charValue() >= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.charValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.charValue() >= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.charValue() >= var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.byteValue() >= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.byteValue() >= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.byteValue() >= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.byteValue() >= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.byteValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.byteValue() >= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.byteValue() >= var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.shortValue() >= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.shortValue() >= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.shortValue() >= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.shortValue() >= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.shortValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.shortValue() >= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.shortValue() >= var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.longValue() >= (long)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.longValue() >= (long)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.longValue() >= (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.longValue() >= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.longValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.longValue() >= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.longValue() >= (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.doubleValue() >= (double)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.doubleValue() >= (double)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.doubleValue() >= (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.doubleValue() >= (double)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue(var0.doubleValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.doubleValue() >= (double)var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.doubleValue() >= (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.floatValue() >= (float)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.floatValue() >= (float)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.floatValue() >= (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.floatValue() >= (float)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.floatValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.floatValue() >= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.floatValue() >= (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.intValue() >= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.intValue() >= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.intValue() >= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.intValue() >= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.intValue() >= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.intValue() >= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.intValue() >= var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3269(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() << var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() << var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() << var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return IntConstant.fromValue(var0.charValue() << (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() << var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() << var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() << var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() << var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return IntConstant.fromValue(var0.byteValue() << (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() << var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() << var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() << var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() << var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return IntConstant.fromValue(var0.shortValue() << (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() << var2.intValue());
                }
            case 5:
            case 6:
            case 8:
            case 9:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() << var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() << var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() << var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() << (int)var2.longValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() << var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() << var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() << var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() << var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return IntConstant.fromValue(var0.intValue() << (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() << var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3270(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.charValue() < var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.charValue() < var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.charValue() < var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.charValue() < var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.charValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.charValue() < var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.charValue() < var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.byteValue() < var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.byteValue() < var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.byteValue() < var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.byteValue() < var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.byteValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.byteValue() < var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.byteValue() < var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.shortValue() < var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.shortValue() < var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.shortValue() < var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.shortValue() < var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.shortValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.shortValue() < var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.shortValue() < var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.longValue() < (long)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.longValue() < (long)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.longValue() < (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.longValue() < var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.longValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.longValue() < var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.longValue() < (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.doubleValue() < (double)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.doubleValue() < (double)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.doubleValue() < (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.doubleValue() < (double)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue(var0.doubleValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.doubleValue() < (double)var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.doubleValue() < (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.floatValue() < (float)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.floatValue() < (float)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.floatValue() < (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.floatValue() < (float)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.floatValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.floatValue() < var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.floatValue() < (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.intValue() < var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.intValue() < var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.intValue() < var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.intValue() < var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.intValue() < var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.intValue() < var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.intValue() < var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3271(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.charValue() <= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.charValue() <= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.charValue() <= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.charValue() <= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.charValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.charValue() <= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.charValue() <= var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.byteValue() <= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.byteValue() <= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.byteValue() <= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.byteValue() <= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.byteValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.byteValue() <= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.byteValue() <= var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.shortValue() <= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.shortValue() <= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.shortValue() <= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.shortValue() <= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.shortValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.shortValue() <= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.shortValue() <= var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.longValue() <= (long)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.longValue() <= (long)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.longValue() <= (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.longValue() <= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.longValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.longValue() <= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.longValue() <= (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.doubleValue() <= (double)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.doubleValue() <= (double)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.doubleValue() <= (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.doubleValue() <= (double)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue(var0.doubleValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.doubleValue() <= (double)var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.doubleValue() <= (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.floatValue() <= (float)var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.floatValue() <= (float)var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.floatValue() <= (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return BooleanConstant.fromValue(var0.floatValue() <= (float)var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.floatValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue(var0.floatValue() <= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.floatValue() <= (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return BooleanConstant.fromValue(var0.intValue() <= var2.charValue());
                    case 3:
                        return BooleanConstant.fromValue(var0.intValue() <= var2.byteValue());
                    case 4:
                        return BooleanConstant.fromValue(var0.intValue() <= var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return BooleanConstant.fromValue((long)var0.intValue() <= var2.longValue());
                    case 8:
                        return BooleanConstant.fromValue((double)var0.intValue() <= var2.doubleValue());
                    case 9:
                        return BooleanConstant.fromValue((float)var0.intValue() <= var2.floatValue());
                    case 10:
                        return BooleanConstant.fromValue(var0.intValue() <= var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3272(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() - var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() - var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() - var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() - var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.charValue() - var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.charValue() - var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() - var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() - var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() - var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() - var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() - var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.byteValue() - var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.byteValue() - var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() - var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() - var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() - var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() - var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() - var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.shortValue() - var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.shortValue() - var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() - var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() - (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() - (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() - (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() - var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.longValue() - var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.longValue() - var2.floatValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() - (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return DoubleConstant.fromValue(var0.doubleValue() - (double)var2.charValue());
                    case 3:
                        return DoubleConstant.fromValue(var0.doubleValue() - (double)var2.byteValue());
                    case 4:
                        return DoubleConstant.fromValue(var0.doubleValue() - (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return DoubleConstant.fromValue(var0.doubleValue() - (double)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue(var0.doubleValue() - var2.doubleValue());
                    case 9:
                        return DoubleConstant.fromValue(var0.doubleValue() - (double)var2.floatValue());
                    case 10:
                        return DoubleConstant.fromValue(var0.doubleValue() - (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return FloatConstant.fromValue(var0.floatValue() - (float)var2.charValue());
                    case 3:
                        return FloatConstant.fromValue(var0.floatValue() - (float)var2.byteValue());
                    case 4:
                        return FloatConstant.fromValue(var0.floatValue() - (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return FloatConstant.fromValue(var0.floatValue() - (float)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.floatValue() - var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue(var0.floatValue() - var2.floatValue());
                    case 10:
                        return FloatConstant.fromValue(var0.floatValue() - (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() - var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() - var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() - var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() - var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.intValue() - var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.intValue() - var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() - var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3273(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() * var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() * var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() * var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() * var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.charValue() * var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.charValue() * var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() * var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() * var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() * var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() * var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() * var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.byteValue() * var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.byteValue() * var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() * var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() * var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() * var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() * var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() * var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.shortValue() * var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.shortValue() * var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() * var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() * (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() * (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() * (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() * var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.longValue() * var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.longValue() * var2.floatValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() * (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return DoubleConstant.fromValue(var0.doubleValue() * (double)var2.charValue());
                    case 3:
                        return DoubleConstant.fromValue(var0.doubleValue() * (double)var2.byteValue());
                    case 4:
                        return DoubleConstant.fromValue(var0.doubleValue() * (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return DoubleConstant.fromValue(var0.doubleValue() * (double)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue(var0.doubleValue() * var2.doubleValue());
                    case 9:
                        return DoubleConstant.fromValue(var0.doubleValue() * (double)var2.floatValue());
                    case 10:
                        return DoubleConstant.fromValue(var0.doubleValue() * (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return FloatConstant.fromValue(var0.floatValue() * (float)var2.charValue());
                    case 3:
                        return FloatConstant.fromValue(var0.floatValue() * (float)var2.byteValue());
                    case 4:
                        return FloatConstant.fromValue(var0.floatValue() * (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return FloatConstant.fromValue(var0.floatValue() * (float)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.floatValue() * var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue(var0.floatValue() * var2.floatValue());
                    case 10:
                        return FloatConstant.fromValue(var0.floatValue() * (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() * var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() * var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() * var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() * var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.intValue() * var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.intValue() * var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() * var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3274(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() | var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() | var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() | var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() | var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() | var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() | var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() | var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() | var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() | var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() | var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() | var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() | var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() | var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() | var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() | var2.intValue());
                }
            case 5:
                return BooleanConstant.fromValue(var0.booleanValue() | var2.booleanValue());
            case 6:
            case 8:
            case 9:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() | (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() | (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() | (long)var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() | var2.longValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() | (long)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() | var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() | var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() | var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() | var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() | var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3275(Constant var0, int var1, Constant var2, int var3) {
        return BooleanConstant.fromValue(var0.booleanValue() || var2.booleanValue());
    }

    public static final Constant method_3276(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 1:
                if (var3 == 11) {
                    return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() + var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() + var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() + var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() + var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.charValue() + var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.charValue() + var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() + var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() + var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() + var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() + var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() + var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.byteValue() + var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.byteValue() + var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() + var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() + var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() + var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() + var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() + var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.shortValue() + var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.shortValue() + var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() + var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 5:
                if (var3 == 11) {
                    return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() + (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() + (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() + (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() + var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.longValue() + var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.longValue() + var2.floatValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() + (long)var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return DoubleConstant.fromValue(var0.doubleValue() + (double)var2.charValue());
                    case 3:
                        return DoubleConstant.fromValue(var0.doubleValue() + (double)var2.byteValue());
                    case 4:
                        return DoubleConstant.fromValue(var0.doubleValue() + (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return DoubleConstant.fromValue(var0.doubleValue() + (double)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue(var0.doubleValue() + var2.doubleValue());
                    case 9:
                        return DoubleConstant.fromValue(var0.doubleValue() + (double)var2.floatValue());
                    case 10:
                        return DoubleConstant.fromValue(var0.doubleValue() + (double)var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return FloatConstant.fromValue(var0.floatValue() + (float)var2.charValue());
                    case 3:
                        return FloatConstant.fromValue(var0.floatValue() + (float)var2.byteValue());
                    case 4:
                        return FloatConstant.fromValue(var0.floatValue() + (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return FloatConstant.fromValue(var0.floatValue() + (float)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.floatValue() + var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue(var0.floatValue() + var2.floatValue());
                    case 10:
                        return FloatConstant.fromValue(var0.floatValue() + (float)var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() + var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() + var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() + var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() + var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.intValue() + var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.intValue() + var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() + var2.intValue());
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
            case 11:
                switch (var3) {
                    case 2:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.charValue()));
                    case 3:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.byteValue()));
                    case 4:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.shortValue()));
                    case 5:
                        return StringConstant.fromValue(var0.method_3287() + var2.booleanValue());
                    case 6:
                    default:
                        break;
                    case 7:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.longValue()));
                    case 8:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.doubleValue()));
                    case 9:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.floatValue()));
                    case 10:
                        return StringConstant.fromValue(var0.method_3287() + String.valueOf(var2.intValue()));
                    case 11:
                        return StringConstant.fromValue(var0.method_3287() + var2.method_3287());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3277(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() % var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() % var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() % var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() % var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.charValue() % var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.charValue() % var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() % var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() % var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() % var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() % var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() % var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.byteValue() % var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.byteValue() % var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() % var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() % var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() % var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() % var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() % var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.shortValue() % var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.shortValue() % var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() % var2.intValue());
                }
            case 5:
            case 6:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() % (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() % (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() % (long)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() % var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.longValue() % var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.longValue() % var2.floatValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() % (long)var2.intValue());
                }
            case 8:
                switch (var3) {
                    case 2:
                        return DoubleConstant.fromValue(var0.doubleValue() % (double)var2.charValue());
                    case 3:
                        return DoubleConstant.fromValue(var0.doubleValue() % (double)var2.byteValue());
                    case 4:
                        return DoubleConstant.fromValue(var0.doubleValue() % (double)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return DoubleConstant.fromValue(var0.doubleValue() % (double)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue(var0.doubleValue() % var2.doubleValue());
                    case 9:
                        return DoubleConstant.fromValue(var0.doubleValue() % (double)var2.floatValue());
                    case 10:
                        return DoubleConstant.fromValue(var0.doubleValue() % (double)var2.intValue());
                }
            case 9:
                switch (var3) {
                    case 2:
                        return FloatConstant.fromValue(var0.floatValue() % (float)var2.charValue());
                    case 3:
                        return FloatConstant.fromValue(var0.floatValue() % (float)var2.byteValue());
                    case 4:
                        return FloatConstant.fromValue(var0.floatValue() % (float)var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        return NotAConstant;
                    case 7:
                        return FloatConstant.fromValue(var0.floatValue() % (float)var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.floatValue() % var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue(var0.floatValue() % var2.floatValue());
                    case 10:
                        return FloatConstant.fromValue(var0.floatValue() % (float)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() % var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() % var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() % var2.shortValue());
                    case 5:
                    case 6:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() % var2.longValue());
                    case 8:
                        return DoubleConstant.fromValue((double)var0.intValue() % var2.doubleValue());
                    case 9:
                        return FloatConstant.fromValue((float)var0.intValue() % var2.floatValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() % var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3278(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() >> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() >> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() >> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return IntConstant.fromValue(var0.charValue() >> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() >> var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() >> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() >> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() >> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return IntConstant.fromValue(var0.byteValue() >> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() >> var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() >> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() >> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() >> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return IntConstant.fromValue(var0.shortValue() >> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() >> var2.intValue());
                }
            case 5:
            case 6:
            case 8:
            case 9:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() >> var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() >> var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() >> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() >> (int)var2.longValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() >> var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() >> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() >> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() >> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return IntConstant.fromValue(var0.intValue() >> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() >> var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3279(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() >>> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() >>> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() >>> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return IntConstant.fromValue(var0.charValue() >>> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() >>> var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() >>> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() >>> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() >>> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return IntConstant.fromValue(var0.byteValue() >>> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() >>> var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() >>> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() >>> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() >>> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return IntConstant.fromValue(var0.shortValue() >>> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() >>> var2.intValue());
                }
            case 5:
            case 6:
            case 8:
            case 9:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() >>> var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() >>> var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() >>> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() >>> (int)var2.longValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() >>> var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() >>> var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() >>> var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() >>> var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return IntConstant.fromValue(var0.intValue() >>> (int)var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() >>> var2.intValue());
                }
        }
        return NotAConstant;
    }

    public static final Constant method_3280(Constant var0, int var1, Constant var2, int var3) {
        switch (var1) {
            case 2:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.charValue() ^ var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.charValue() ^ var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.charValue() ^ var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.charValue() ^ var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.charValue() ^ var2.intValue());
                }
            case 3:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.byteValue() ^ var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.byteValue() ^ var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.byteValue() ^ var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.byteValue() ^ var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.byteValue() ^ var2.intValue());
                }
            case 4:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.shortValue() ^ var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.shortValue() ^ var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.shortValue() ^ var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue((long)var0.shortValue() ^ var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.shortValue() ^ var2.intValue());
                }
            case 5:
                return BooleanConstant.fromValue(var0.booleanValue() ^ var2.booleanValue());
            case 6:
            case 8:
            case 9:
            default:
                break;
            case 7:
                switch (var3) {
                    case 2:
                        return LongConstant.fromValue(var0.longValue() ^ (long)var2.charValue());
                    case 3:
                        return LongConstant.fromValue(var0.longValue() ^ (long)var2.byteValue());
                    case 4:
                        return LongConstant.fromValue(var0.longValue() ^ (long)var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        return NotAConstant;
                    case 7:
                        return LongConstant.fromValue(var0.longValue() ^ var2.longValue());
                    case 10:
                        return LongConstant.fromValue(var0.longValue() ^ (long)var2.intValue());
                }
            case 10:
                switch (var3) {
                    case 2:
                        return IntConstant.fromValue(var0.intValue() ^ var2.charValue());
                    case 3:
                        return IntConstant.fromValue(var0.intValue() ^ var2.byteValue());
                    case 4:
                        return IntConstant.fromValue(var0.intValue() ^ var2.shortValue());
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 7:
                        return LongConstant.fromValue((long)var0.intValue() ^ var2.longValue());
                    case 10:
                        return IntConstant.fromValue(var0.intValue() ^ var2.intValue());
                }
        }
        return NotAConstant;
    }

    public double doubleValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "double"}));
        throw var10000;
    }

    public float floatValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "float"}));
        throw var10000;
    }

    public boolean hasSameValue(Constant var1) {
        if (this == var1) {
            return true;
        } else {
            int var2;
            if ((var2 = this.typeID()) != var1.typeID()) {
                return false;
            } else {
                switch (var2) {
                    case 2:
                        return this.charValue() == var1.charValue();
                    case 3:
                        return this.byteValue() == var1.byteValue();
                    case 4:
                        return this.shortValue() == var1.shortValue();
                    case 5:
                        return this.booleanValue() == var1.booleanValue();
                    case 6:
                    default:
                        return false;
                    case 7:
                        return this.longValue() == var1.longValue();
                    case 8:
                        return this.doubleValue() == var1.doubleValue();
                    case 9:
                        return this.floatValue() == var1.floatValue();
                    case 10:
                        return this.intValue() == var1.intValue();
                    case 11:
                        String var3 = this.method_3287();
                        return var3 == null ? var1.method_3287() == null : var3.equals(var1.method_3287());
                }
            }
        }
    }

    public int intValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "int"}));
        throw var10000;
    }

    public long longValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1894, new String[] {this.method_3289(), "long"}));
        throw var10000;
    }

    public short shortValue() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1895, new String[] {this.method_3289(), "short"}));
        throw var10000;
    }

    public String method_3287() {
        ShouldNotImplement var10000 = new ShouldNotImplement(Messages.bind(Messages.field_1895, new String[] {this.method_3289(), "String"}));
        throw var10000;
    }

    public String toString() {
        return this == NotAConstant ? "(Constant) NotAConstant" : super.toString();
    }

    public abstract int typeID();

    public String method_3289() {
        switch (this.typeID()) {
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "boolean";
            case 6:
            default:
                return "unknown";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                return "float";
            case 10:
                return "int";
            case 11:
                return "java.lang.String";
            case 12:
                return "null";
        }
    }

    static {
        NotAConstant = DoubleConstant.fromValue(Double.NaN);
    }
}
