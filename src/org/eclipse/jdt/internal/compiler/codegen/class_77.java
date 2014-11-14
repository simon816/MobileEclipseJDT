package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_40;

public class class_77 {

    public int field_336;

    private int field_337;

    private char[] field_338;

    public int field_339;

    private class_77() {
    }

    public class_77(int var1, char[] var2) {
        this(var1, 7, var2);
    }

    public class_77(int var1, int var2, char[] var3) {
        this.field_337 = var1;
        this.field_336 = var2;
        this.field_338 = var3;
    }

    public class_77(int var1, class_40 var2) {
        this(var2);
        this.field_336 = var1;
    }

    public class_77(class_40 var1) {
        this.field_337 = var1.field_177;
        switch (var1.field_177) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 10:
                this.field_336 = 1;
                break;
            case 6:
            case 11:
            default:
                this.field_336 = 7;
                this.field_338 = var1.method_134();
                break;
            case 7:
                this.field_336 = 4;
                break;
            case 8:
                this.field_336 = 3;
                break;
            case 9:
                this.field_336 = 2;
                break;
            case 12:
                this.field_336 = 5;
        }
    }

    public int method_473() {
        return this.field_337;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        switch (this.field_336) {
            case 0:
                var1.append("top");
                break;
            case 1:
                var1.append('I');
                break;
            case 2:
                var1.append('F');
                break;
            case 3:
                var1.append('D');
                break;
            case 4:
                var1.append('J');
                break;
            case 5:
                var1.append("null");
                break;
            case 6:
                var1.append("uninitialized_this(").append(this.method_476()).append(")");
                break;
            case 7:
                var1.append(this.method_476());
                break;
            case 8:
                var1.append("uninitialized(").append(this.method_476()).append(")");
        }
        return String.valueOf(var1);
    }

    public class_77 method_474() {
        class_77 var10000 = new class_77();
        class_77 var1 = var10000;
        var1.field_337 = this.field_337;
        var1.field_336 = this.field_336;
        var1.field_338 = this.field_338;
        var1.field_339 = this.field_339;
        return var1;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class_77)) {
            return false;
        } else {
            class_77 var2 = (class_77)var1;
            return var2.field_336 == this.field_336 && CharOperation.method_1364(var2.method_475(), this.method_475());
        }
    }

    public int hashCode() {
        return this.field_336 + this.field_337 + this.field_338.length + this.field_339;
    }

    public char[] method_475() {
        return this.field_338;
    }

    public char[] method_476() {
        return this.field_338;
    }

    public void method_477() {
        if (this.field_338[1] == 76) {
            this.field_338 = CharOperation.method_1388(this.field_338, 2, this.field_338.length - 1);
        } else {
            this.field_338 = CharOperation.method_1388(this.field_338, 1, this.field_338.length);
            if (this.field_338.length == 1) {
                switch (this.field_338[0]) {
                    case 66:
                        this.field_337 = 3;
                        break;
                    case 67:
                        this.field_337 = 2;
                        break;
                    case 68:
                        this.field_337 = 8;
                    case 69:
                    case 71:
                    case 72:
                    case 75:
                    case 76:
                    case 77:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 84:
                    case 85:
                    case 87:
                    case 88:
                    case 89:
                    default:
                        break;
                    case 70:
                        this.field_337 = 9;
                        break;
                    case 73:
                        this.field_337 = 10;
                        break;
                    case 74:
                        this.field_337 = 7;
                        break;
                    case 78:
                        this.field_337 = 12;
                        break;
                    case 83:
                        this.field_337 = 4;
                        break;
                    case 86:
                        this.field_337 = 6;
                        break;
                    case 90:
                        this.field_337 = 5;
                }
            }
        }
    }
}
