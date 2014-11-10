package m;

import m.class_38;
import m.class_40;

public final class class_41 extends class_40 {

    public char[] field_189;

    private char[] field_190;

    class_41(int var1, char[] var2, char[] var3) {
        this.field_178 |= 2L;
        this.field_177 = var1;
        this.field_189 = var2;
        this.field_190 = var3;
    }

    public char[] method_134() {
        return this.field_190;
    }

    public class_38 method_143() {
        return null;
    }

    public final boolean method_152(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (!var1.method_148()) {
            return this == class_40.field_187;
        } else {
            switch (var1.field_177) {
                case 2:
                case 3:
                case 5:
                    return false;
                case 4:
                    return this.field_177 == 3;
                case 6:
                default:
                    return false;
                case 7:
                    switch (this.field_177) {
                        case 2:
                        case 3:
                        case 4:
                        case 10:
                            return true;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        default:
                            return false;
                    }
                case 8:
                    switch (this.field_177) {
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                        case 9:
                        case 10:
                            return true;
                        case 5:
                        case 6:
                        case 8:
                        default:
                            return false;
                    }
                case 9:
                    switch (this.field_177) {
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                        case 10:
                            return true;
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        default:
                            return false;
                    }
                case 10:
                    switch (this.field_177) {
                        case 2:
                        case 3:
                        case 4:
                            return true;
                        default:
                            return false;
                    }
            }
        }
    }

    public static final boolean method_184(int var0, int var1) {
        switch (var0) {
            case 2:
            case 3:
                if (var1 == 3) {
                    return true;
                }
            case 4:
                if (var1 == 4) {
                    return true;
                } else if (var1 == 2) {
                    return true;
                }
            case 5:
                return var1 == 5;
            case 10:
                if (var1 == 10) {
                    return true;
                }
            case 7:
                if (var1 == 7) {
                    return true;
                }
            case 9:
                if (var1 == 9) {
                    return true;
                }
            case 8:
                if (var1 == 8) {
                    return true;
                }
            case 6:
            default:
                return false;
        }
    }

    public boolean method_171(boolean var1) {
        return this == class_40.field_187;
    }

    public static final boolean method_185(int var0, int var1) {
        switch (var0) {
            case 2:
                return var1 == 2;
            case 5:
                return var1 == 5;
            case 8:
                if (var1 == 8) {
                    return true;
                }
            case 9:
                if (var1 == 9) {
                    return true;
                }
            case 7:
                if (var1 == 7) {
                    return true;
                }
            case 10:
                if (var1 == 10) {
                    return true;
                } else if (var1 == 2) {
                    return true;
                }
            case 4:
                if (var1 == 4) {
                    return true;
                }
            case 3:
                if (var1 == 3) {
                    return true;
                }
            case 6:
            default:
                return false;
        }
    }

    public int method_98() {
        return 132;
    }

    public char[] method_177() {
        return this.field_189;
    }

    public char[] method_103() {
        return this.field_189;
    }

    public char[] method_104() {
        return this.field_189;
    }

    public char[] method_179() {
        return this.field_189;
    }

    public String toString() {
        return new String(this.field_190) + " (id=" + this.field_177 + ")";
    }
}
