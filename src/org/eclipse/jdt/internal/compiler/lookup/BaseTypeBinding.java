package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public final class BaseTypeBinding extends TypeBinding {

    public char[] simpleName;

    private char[] constantPoolName;

    BaseTypeBinding(int var1, char[] var2, char[] var3) {
        this.tagBits |= 2L;
        this.id = var1;
        this.simpleName = var2;
        this.constantPoolName = var3;
    }

    public char[] constantPoolName() {
        return this.constantPoolName;
    }

    public PackageBinding getPackage() {
        return null;
    }

    public final boolean isCompatibleWith(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else if (!var1.method_148()) {
            return this == TypeBinding.field_187;
        } else {
            switch (var1.id) {
                case 2:
                case 3:
                case 5:
                    return false;
                case 4:
                    return this.id == 3;
                case 6:
                default:
                    return false;
                case 7:
                    switch (this.id) {
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
                    switch (this.id) {
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
                    switch (this.id) {
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
                    switch (this.id) {
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

    public boolean isUncheckedException(boolean var1) {
        return this == TypeBinding.field_187;
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

    public int kind() {
        return 132;
    }

    public char[] method_177() {
        return this.simpleName;
    }

    public char[] readableName() {
        return this.simpleName;
    }

    public char[] shortReadableName() {
        return this.simpleName;
    }

    public char[] method_179() {
        return this.simpleName;
    }

    public String toString() {
        return new String(this.constantPoolName) + " (id=" + this.id + ")";
    }
}
