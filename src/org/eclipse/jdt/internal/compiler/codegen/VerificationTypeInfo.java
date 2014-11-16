package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public class VerificationTypeInfo {

    public int field_336;

    private int id;

    private char[] constantPoolName;

    public int field_339;

    private VerificationTypeInfo() {
    }

    public VerificationTypeInfo(int var1, char[] var2) {
        this(var1, 7, var2);
    }

    public VerificationTypeInfo(int var1, int var2, char[] var3) {
        this.id = var1;
        this.field_336 = var2;
        this.constantPoolName = var3;
    }

    public VerificationTypeInfo(int var1, TypeBinding var2) {
        this(var2);
        this.field_336 = var1;
    }

    public VerificationTypeInfo(TypeBinding var1) {
        this.id = var1.id;
        switch (var1.id) {
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
                this.constantPoolName = var1.constantPoolName();
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
        return this.id;
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

    public VerificationTypeInfo duplicate() {
        VerificationTypeInfo var10000 = new VerificationTypeInfo();
        VerificationTypeInfo var1 = var10000;
        var1.id = this.id;
        var1.field_336 = this.field_336;
        var1.constantPoolName = this.constantPoolName;
        var1.field_339 = this.field_339;
        return var1;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof VerificationTypeInfo)) {
            return false;
        } else {
            VerificationTypeInfo var2 = (VerificationTypeInfo)var1;
            return var2.field_336 == this.field_336 && CharOperation.method_1364(var2.method_475(), this.method_475());
        }
    }

    public int hashCode() {
        return this.field_336 + this.id + this.constantPoolName.length + this.field_339;
    }

    public char[] method_475() {
        return this.constantPoolName;
    }

    public char[] method_476() {
        return this.constantPoolName;
    }

    public void replaceWithElementType() {
        if (this.constantPoolName[1] == 76) {
            this.constantPoolName = CharOperation.subarray(this.constantPoolName, 2, this.constantPoolName.length - 1);
        } else {
            this.constantPoolName = CharOperation.subarray(this.constantPoolName, 1, this.constantPoolName.length);
            if (this.constantPoolName.length == 1) {
                switch (this.constantPoolName[0]) {
                    case 66:
                        this.id = 3;
                        break;
                    case 67:
                        this.id = 2;
                        break;
                    case 68:
                        this.id = 8;
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
                        this.id = 9;
                        break;
                    case 73:
                        this.id = 10;
                        break;
                    case 74:
                        this.id = 7;
                        break;
                    case 78:
                        this.id = 12;
                        break;
                    case 83:
                        this.id = 4;
                        break;
                    case 86:
                        this.id = 6;
                        break;
                    case 90:
                        this.id = 5;
                }
            }
        }
    }
}
