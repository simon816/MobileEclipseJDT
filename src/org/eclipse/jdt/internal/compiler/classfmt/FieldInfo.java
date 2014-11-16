package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileStruct;
import org.eclipse.jdt.internal.compiler.classfmt.FieldInfoWithAnnotation;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.env.IBinaryField;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.DoubleConstant;
import org.eclipse.jdt.internal.compiler.impl.FloatConstant;
import org.eclipse.jdt.internal.compiler.impl.ShortConstant;
import org.eclipse.jdt.internal.compiler.impl.LongConstant;
import org.eclipse.jdt.internal.compiler.impl.StringConstant;
import org.eclipse.jdt.internal.compiler.impl.IntConstant;
import org.eclipse.jdt.internal.compiler.impl.CharConstant;
import org.eclipse.jdt.internal.compiler.impl.ByteConstant;
import org.eclipse.jdt.internal.compiler.impl.BooleanConstant;
import org.eclipse.jdt.internal.compiler.util.Util;

import java.lang.Comparable;

public class FieldInfo extends ClassFileStruct implements Comparable, IBinaryField {

    protected int field_808;

    protected int field_809;

    protected Constant constant;

    protected char[] field_811;

    protected char[] field_812;

    protected char[] field_813;

    protected int field_814;

    protected long tagBits;

    protected Object wrappedConstantValue;

    public static FieldInfo createField(byte[] var0, int[] var1, int var2) {
        FieldInfo var10000 = new FieldInfo(var0, var1, var2);
        FieldInfo var3 = var10000;
        AnnotationInfo[] var4 = var3.readAttributes();
        if (var4 == null) {
            return var3;
        } else {
            FieldInfoWithAnnotation var5 = new FieldInfoWithAnnotation(var3, var4);
            return var5;
        }
    }

    protected FieldInfo(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_808 = -1;
        this.field_814 = -1;
    }

    private AnnotationInfo[] decodeAnnotations(int var1, boolean var2) {
        int var3 = this.method_1104(var1 + 6);
        if (var3 > 0) {
            int var4 = var1 + 8;
            AnnotationInfo[] var5 = null;
            int var6 = 0;
            for (int var7 = 0; var7 < var3; ++var7) {
                AnnotationInfo var10000 = new AnnotationInfo(this.reference, this.constantPoolOffsets, var4 + this.structOffset, var2, false);
                AnnotationInfo var8 = var10000;
                var4 += var8.readOffset;
                long var9 = var8.standardAnnotationTagBits;
                if (var9 != 0L) {
                    this.tagBits |= var9;
                } else {
                    if (var5 == null) {
                        var5 = new AnnotationInfo[var3 - var7];
                    }
                    var5[var6++] = var8;
                }
            }
            if (var5 != null) {
                if (var6 != var5.length) {
                    System.arraycopy(var5, 0, var5 = new AnnotationInfo[var6], 0, var6);
                }
                return var5;
            }
        }
        return null;
    }

    public int compareTo(Object var1) {
        return (new String(this.method_75())).compareTo(new String(((FieldInfo)var1).method_75()));
    }

    public boolean equals(Object var1) {
        return !(var1 instanceof FieldInfo) ? false : CharOperation.method_1364(this.method_75(), ((FieldInfo)var1).method_75());
    }

    public int hashCode() {
        return CharOperation.hashCode(this.method_75());
    }

    public Constant getConstant() {
        if (this.constant == null) {
            this.method_1111();
        }
        return this.constant;
    }

    public char[] method_74() {
        if (this.field_814 != -1) {
            if (this.field_813 == null) {
                this.field_813 = this.utf8At(this.field_814 + 3, this.method_1104(this.field_814 + 1));
            }
            return this.field_813;
        } else {
            return null;
        }
    }

    public int getModifiers() {
        if (this.field_808 == -1) {
            this.field_808 = this.method_1104(0);
            this.method_1112();
        }
        return this.field_808;
    }

    public char[] method_75() {
        if (this.field_812 == null) {
            int var1 = this.constantPoolOffsets[this.method_1104(2)] - this.structOffset;
            this.field_812 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_812;
    }

    public long getTagBits() {
        return this.tagBits;
    }

    public char[] method_77() {
        if (this.field_811 == null) {
            int var1 = this.constantPoolOffsets[this.method_1104(4)] - this.structOffset;
            this.field_811 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_811;
    }

    public IBinaryAnnotation[] getAnnotations() {
        return null;
    }

    protected void initialize() {
        this.getModifiers();
        this.method_75();
        this.getConstant();
        this.method_77();
        this.method_74();
        this.reset();
    }

    private AnnotationInfo[] readAttributes() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        AnnotationInfo[] var3 = null;
        for (int var4 = 0; var4 < var1; ++var4) {
            int var5 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
            char[] var6 = this.utf8At(var5 + 3, this.method_1104(var5 + 1));
            if (var6.length > 0) {
                switch (var6[0]) {
                    case 82:
                        AnnotationInfo[] var7 = null;
                        if (CharOperation.method_1364(var6, AttributeNamesConstants.field_18)) {
                            var7 = this.decodeAnnotations(var2, true);
                        } else if (CharOperation.method_1364(var6, AttributeNamesConstants.field_17)) {
                            var7 = this.decodeAnnotations(var2, false);
                        }
                        if (var7 != null) {
                            if (var3 == null) {
                                var3 = var7;
                            } else {
                                int var8 = var3.length;
                                AnnotationInfo[] var9 = new AnnotationInfo[var8 + var7.length];
                                System.arraycopy(var3, 0, var9, 0, var8);
                                System.arraycopy(var7, 0, var9, var8, var7.length);
                                var3 = var9;
                            }
                        }
                        break;
                    case 83:
                        if (CharOperation.method_1364(AttributeNamesConstants.field_13, var6)) {
                            this.field_814 = this.constantPoolOffsets[this.method_1104(var2 + 6)] - this.structOffset;
                        }
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
        this.field_809 = var2;
        return var3;
    }

    private void method_1111() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        boolean var3 = false;
        for (int var4 = 0; var4 < var1; ++var4) {
            int var5 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
            char[] var6 = this.utf8At(var5 + 3, this.method_1104(var5 + 1));
            if (CharOperation.method_1364(var6, AttributeNamesConstants.field_5)) {
                var3 = true;
                int var7 = this.constantPoolOffsets[this.method_1104(var2 + 6)] - this.structOffset;
                label35:
                switch (this.method_1103(var7)) {
                    case 3:
                        char[] var8 = this.method_77();
                        if (var8.length == 1) {
                            switch (var8[0]) {
                                case 66:
                                    this.constant = ByteConstant.fromValue((byte)this.method_1100(var7 + 1));
                                    break label35;
                                case 67:
                                    this.constant = CharConstant.fromValue((char)this.method_1100(var7 + 1));
                                    break label35;
                                case 73:
                                    this.constant = IntConstant.fromValue(this.method_1100(var7 + 1));
                                    break label35;
                                case 83:
                                    this.constant = ShortConstant.fromValue((short)this.method_1100(var7 + 1));
                                    break label35;
                                case 90:
                                    this.constant = BooleanConstant.fromValue(this.method_1100(var7 + 1) == 1);
                                    break label35;
                                default:
                                    this.constant = Constant.NotAConstant;
                            }
                        } else {
                            this.constant = Constant.NotAConstant;
                        }
                        break;
                    case 4:
                        this.constant = FloatConstant.fromValue(this.floatAt(var7 + 1));
                        break;
                    case 5:
                        this.constant = LongConstant.fromValue(this.method_1101(var7 + 1));
                        break;
                    case 6:
                        this.constant = DoubleConstant.fromValue(this.doubleAt(var7 + 1));
                    case 7:
                    default:
                        break;
                    case 8:
                        var5 = this.constantPoolOffsets[this.method_1104(var7 + 1)] - this.structOffset;
                        this.constant = StringConstant.fromValue(String.valueOf(this.utf8At(var5 + 3, this.method_1104(var5 + 1))));
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
        if (!var3) {
            this.constant = Constant.NotAConstant;
        }
    }

    private void method_1112() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        for (int var3 = 0; var3 < var1; ++var3) {
            int var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
            char[] var5 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
            if (var5.length != 0) {
                switch (var5[0]) {
                    case 68:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_12)) {
                            this.field_808 |= 1048576;
                        }
                        break;
                    case 83:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_4)) {
                            this.field_808 |= 4096;
                        }
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
    }

    public int method_1113() {
        return this.field_809;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(this.getClass().getName());
        this.toStringContent(var1);
        return var1.toString();
    }

    protected void toStringContent(StringBuffer var1) {
        int var2 = this.getModifiers();
        var1.append('{').append(((var2 & 1048576) != 0 ? "deprecated " : Util.field_982) + ((var2 & 1) == 1 ? "public " : Util.field_982) + ((var2 & 2) == 2 ? "private " : Util.field_982) + ((var2 & 4) == 4 ? "protected " : Util.field_982) + ((var2 & 8) == 8 ? "static " : Util.field_982) + ((var2 & 16) == 16 ? "final " : Util.field_982) + ((var2 & 64) == 64 ? "volatile " : Util.field_982) + ((var2 & 128) == 128 ? "transient " : Util.field_982)).append(this.method_77()).append(' ').append(this.method_75()).append(' ').append(this.getConstant()).append('}').toString();
    }
}
