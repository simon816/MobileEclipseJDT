package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileStruct;
import org.eclipse.jdt.internal.compiler.classfmt.ElementValuePairInfo;
import org.eclipse.jdt.internal.compiler.codegen.ConstantPool;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.env.IBinaryElementValuePair;
import org.eclipse.jdt.internal.compiler.env.ClassSignature;
import org.eclipse.jdt.internal.compiler.env.EnumConstantSignature;
import org.eclipse.jdt.internal.compiler.impl.DoubleConstant;
import org.eclipse.jdt.internal.compiler.impl.FloatConstant;
import org.eclipse.jdt.internal.compiler.impl.ShortConstant;
import org.eclipse.jdt.internal.compiler.impl.LongConstant;
import org.eclipse.jdt.internal.compiler.impl.StringConstant;
import org.eclipse.jdt.internal.compiler.impl.IntConstant;
import org.eclipse.jdt.internal.compiler.impl.CharConstant;
import org.eclipse.jdt.internal.compiler.impl.ByteConstant;
import org.eclipse.jdt.internal.compiler.impl.BooleanConstant;

public class AnnotationInfo extends ClassFileStruct implements IBinaryAnnotation {

    private char[] typename;

    private ElementValuePairInfo[] pairs;

    long standardAnnotationTagBits;

    int readOffset;

    static Object[] EmptyValueArray;

    AnnotationInfo(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.standardAnnotationTagBits = 0L;
        this.readOffset = 0;
    }

    AnnotationInfo(byte[] var1, int[] var2, int var3, boolean var4, boolean var5) {
        this(var1, var2, var3);
        if (var5) {
            this.decodeAnnotation();
        } else {
            this.readOffset = this.scanAnnotation(0, var4, true);
        }
    }

    private void decodeAnnotation() {
        this.readOffset = 0;
        int var1 = this.constantPoolOffsets[this.method_1104(0)] - this.structOffset;
        this.typename = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
        int var2 = this.method_1104(2);
        this.readOffset += 4;
        this.pairs = var2 == 0 ? ElementValuePairInfo.NoMembers : new ElementValuePairInfo[var2];
        for (int var3 = 0; var3 < var2; ++var3) {
            var1 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
            char[] var4 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
            this.readOffset += 2;
            Object var5 = this.decodeDefaultValue();
            ElementValuePairInfo[] var10000 = this.pairs;
            ElementValuePairInfo var10002 = new ElementValuePairInfo(var4, var5);
            var10000[var3] = var10002;
        }
    }

    Object decodeDefaultValue() {
        Object var1 = null;
        int var2 = this.method_1103(this.readOffset);
        ++this.readOffset;
        boolean var3 = true;
        int var10;
        switch (var2) {
            case 64:
                AnnotationInfo var12 = new AnnotationInfo(this.reference, this.constantPoolOffsets, this.readOffset + this.structOffset, false, true);
                var1 = var12;
                this.readOffset += ((AnnotationInfo)var1).readOffset;
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
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
            case 114:
            default:
                throw new IllegalStateException("Unrecognized tag " + (char)var2);
            case 66:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = ByteConstant.fromValue((byte)this.method_1100(var10 + 1));
                this.readOffset += 2;
                break;
            case 67:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = CharConstant.fromValue((char)this.method_1100(var10 + 1));
                this.readOffset += 2;
                break;
            case 68:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = DoubleConstant.fromValue(this.doubleAt(var10 + 1));
                this.readOffset += 2;
                break;
            case 70:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = FloatConstant.fromValue(this.floatAt(var10 + 1));
                this.readOffset += 2;
                break;
            case 73:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = IntConstant.fromValue(this.method_1100(var10 + 1));
                this.readOffset += 2;
                break;
            case 74:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = LongConstant.fromValue(this.method_1101(var10 + 1));
                this.readOffset += 2;
                break;
            case 83:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = ShortConstant.fromValue((short)this.method_1100(var10 + 1));
                this.readOffset += 2;
                break;
            case 90:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = BooleanConstant.fromValue(this.method_1100(var10 + 1) == 1);
                this.readOffset += 2;
                break;
            case 91:
                int var7 = this.method_1104(this.readOffset);
                this.readOffset += 2;
                if (var7 == 0) {
                    var1 = EmptyValueArray;
                    break;
                } else {
                    Object[] var8 = new Object[var7];
                    var1 = var8;
                    for (int var9 = 0; var9 < var7; ++var9) {
                        var8[var9] = this.decodeDefaultValue();
                    }
                    return var1;
                }
            case 99:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                char[] var6 = this.utf8At(var10 + 3, this.method_1104(var10 + 1));
                ClassSignature var11 = new ClassSignature(var6);
                var1 = var11;
                this.readOffset += 2;
                break;
            case 101:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                char[] var4 = this.utf8At(var10 + 3, this.method_1104(var10 + 1));
                this.readOffset += 2;
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                char[] var5 = this.utf8At(var10 + 3, this.method_1104(var10 + 1));
                this.readOffset += 2;
                EnumConstantSignature var10000 = new EnumConstantSignature(var4, var5);
                var1 = var10000;
                break;
            case 115:
                var10 = this.constantPoolOffsets[this.method_1104(this.readOffset)] - this.structOffset;
                var1 = StringConstant.fromValue(String.valueOf(this.utf8At(var10 + 3, this.method_1104(var10 + 1))));
                this.readOffset += 2;
        }
        return var1;
    }

    public IBinaryElementValuePair[] getElementValuePairs() {
        if (this.pairs == null) {
            this.initialize();
        }
        return this.pairs;
    }

    public char[] getTypeName() {
        return this.typename;
    }

    void initialize() {
        if (this.pairs == null) {
            this.decodeAnnotation();
        }
    }

    private int method_1155(int var1) {
        int var3 = this.method_1103(var1);
        int var2 = var1 + 1;
        switch (var3) {
            case 64:
                var2 = this.scanAnnotation(var2, false, false);
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
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
            case 114:
            default:
                throw new IllegalStateException();
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
            case 99:
            case 115:
                var2 += 2;
                break;
            case 91:
                int var8 = this.method_1104(var2);
                var2 += 2;
                for (int var7 = 0; var7 < var8; ++var7) {
                    var2 = this.method_1158(var2);
                }
                return var2;
            case 101:
                int var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
                char[] var5 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
                var2 += 2;
                if (var5.length == 38 && CharOperation.method_1364(var5, ConstantPool.field_1509)) {
                    var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
                    char[] var6 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
                    this.standardAnnotationTagBits |= Annotation.method_1069(var6);
                }
                var2 += 2;
        }
        return var2;
    }

    private int method_1156(int var1) {
        int var3 = this.method_1103(var1);
        int var2 = var1 + 1;
        switch (var3) {
            case 64:
                var2 = this.scanAnnotation(var2, false, false);
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
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
            case 114:
            default:
                throw new IllegalStateException();
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
            case 99:
            case 115:
                var2 += 2;
                break;
            case 91:
                int var8 = this.method_1104(var2);
                var2 += 2;
                if (var8 == 0) {
                    this.standardAnnotationTagBits |= 34359738368L;
                    break;
                } else {
                    for (int var7 = 0; var7 < var8; ++var7) {
                        var2 = this.method_1156(var2);
                    }
                    return var2;
                }
            case 101:
                int var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
                char[] var5 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
                var2 += 2;
                if (var5.length == 34 && CharOperation.method_1364(var5, ConstantPool.field_1507)) {
                    var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
                    char[] var6 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
                    this.standardAnnotationTagBits |= Annotation.method_1070(var6);
                }
                var2 += 2;
        }
        return var2;
    }

    private int scanAnnotation(int var1, boolean var2, boolean var3) {
        int var5 = this.constantPoolOffsets[this.method_1104(var1)] - this.structOffset;
        char[] var6 = this.utf8At(var5 + 3, this.method_1104(var5 + 1));
        if (var3) {
            this.typename = var6;
        }
        int var7 = this.method_1104(var1 + 2);
        int var4 = var1 + 4;
        if (var2 && var3) {
            switch (var6.length) {
                case 22:
                    if (CharOperation.method_1364(var6, ConstantPool.field_1511)) {
                        this.standardAnnotationTagBits |= 70368744177664L;
                        return var4;
                    }
                    break;
                case 29:
                    if (CharOperation.method_1364(var6, ConstantPool.field_1510)) {
                        var4 += 2;
                        return this.method_1156(var4);
                    }
                    break;
                case 32:
                    if (CharOperation.method_1364(var6, ConstantPool.field_1508)) {
                        var4 += 2;
                        return this.method_1155(var4);
                    }
                    if (CharOperation.method_1364(var6, ConstantPool.field_1512)) {
                        this.standardAnnotationTagBits |= 281474976710656L;
                        return var4;
                    }
                    break;
                case 33:
                    if (CharOperation.method_1364(var6, ConstantPool.field_1506)) {
                        this.standardAnnotationTagBits |= 140737488355328L;
                        return var4;
                    }
            }
        }
        for (int var8 = 0; var8 < var7; ++var8) {
            var4 += 2;
            var4 = this.method_1158(var4);
        }
        return var4;
    }

    private int method_1158(int var1) {
        int var3 = this.method_1103(var1);
        int var2 = var1 + 1;
        switch (var3) {
            case 64:
                var2 = this.scanAnnotation(var2, false, false);
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
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
            case 114:
            default:
                throw new IllegalStateException();
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
            case 99:
            case 115:
                var2 += 2;
                break;
            case 91:
                int var4 = this.method_1104(var2);
                var2 += 2;
                for (int var5 = 0; var5 < var4; ++var5) {
                    var2 = this.method_1158(var2);
                }
                return var2;
            case 101:
                var2 += 4;
        }
        return var2;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append('@');
        var1.append(this.typename);
        if (this.pairs != null) {
            var1.append('(');
            var1.append("\n\t");
            int var2 = 0;
            for (int var3 = this.pairs.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(",\n\t");
                }
                var1.append(this.pairs[var2]);
            }
            var1.append(')');
        }
        return var1.toString();
    }

    static {
        EmptyValueArray = new Object[0];
    }
}
