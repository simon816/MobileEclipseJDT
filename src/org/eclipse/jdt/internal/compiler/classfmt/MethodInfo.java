package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileStruct;
import org.eclipse.jdt.internal.compiler.classfmt.MethodInfoWithAnnotations;
import org.eclipse.jdt.internal.compiler.classfmt.MethodInfoWithParameterAnnotations;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.codegen.ConstantPool;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.env.IBinaryMethod;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.util.Util;

import java.lang.Comparable;

public class MethodInfo extends ClassFileStruct implements Comparable, IBinaryMethod {

    private static final char[][] field_851;

    private static final char[][] field_852;

    protected int field_853;

    protected int field_854;

    protected char[] field_855;

    protected char[][] field_856;

    protected char[] field_857;

    protected char[] field_858;

    protected int field_859;

    protected long tagBits;

    protected char[][] field_861;

    protected int field_862;

    public static MethodInfo createMethod(byte[] var0, int[] var1, int var2) {
        MethodInfo var10000 = new MethodInfo(var0, var1, var2);
        MethodInfo var3 = var10000;
        int var4 = var3.method_1104(6);
        int var5 = 8;
        AnnotationInfo[] var6 = null;
        AnnotationInfo[][] var7 = (AnnotationInfo[][])null;
        for (int var8 = 0; var8 < var4; ++var8) {
            int var9 = var3.constantPoolOffsets[var3.method_1104(var5)] - var3.structOffset;
            char[] var10 = var3.utf8At(var9 + 3, var3.method_1104(var9 + 1));
            if (var10.length > 0) {
                label69:
                switch (var10[0]) {
                    case 82:
                        AnnotationInfo[] var11 = null;
                        AnnotationInfo[][] var12 = (AnnotationInfo[][])null;
                        if (CharOperation.method_1364(var10, AttributeNamesConstants.field_18)) {
                            var11 = decodeMethodAnnotations(var5, true, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_17)) {
                            var11 = decodeMethodAnnotations(var5, false, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_20)) {
                            var12 = decodeParamAnnotations(var5, true, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_19)) {
                            var12 = decodeParamAnnotations(var5, false, var3);
                        }
                        int var13;
                        if (var11 != null) {
                            if (var6 == null) {
                                var6 = var11;
                            } else {
                                var13 = var6.length;
                                AnnotationInfo[] var20 = new AnnotationInfo[var13 + var11.length];
                                System.arraycopy(var6, 0, var20, 0, var13);
                                System.arraycopy(var11, 0, var20, var13, var11.length);
                                var6 = var20;
                            }
                        } else {
                            if (var12 == null) {
                                break;
                            }
                            var13 = var12.length;
                            if (var7 == null) {
                                var7 = var12;
                            } else {
                                int var14 = 0;
                                while (true) {
                                    if (var14 >= var13) {
                                        break label69;
                                    }
                                    int var15 = var12[var14] == null ? 0 : var12[var14].length;
                                    if (var15 > 0) {
                                        if (var7[var14] == null) {
                                            var7[var14] = var12[var14];
                                        } else {
                                            int var16 = var7[var14].length;
                                            AnnotationInfo[] var17 = new AnnotationInfo[var16 + var15];
                                            System.arraycopy(var7[var14], 0, var17, 0, var16);
                                            System.arraycopy(var12[var14], 0, var17, var16, var15);
                                            var7[var14] = var17;
                                        }
                                    }
                                    ++var14;
                                }
                            }
                        }
                        break;
                    case 83:
                        if (CharOperation.method_1364(AttributeNamesConstants.field_13, var10)) {
                            var3.field_859 = var3.constantPoolOffsets[var3.method_1104(var5 + 6)] - var3.structOffset;
                        }
                }
            }
            var5 = (int)((long)var5 + 6L + var3.method_1105(var5 + 2));
        }
        var3.field_854 = var5;
        if (var7 != null) {
            MethodInfoWithParameterAnnotations var19 = new MethodInfoWithParameterAnnotations(var3, var6, var7);
            return var19;
        } else if (var6 != null) {
            MethodInfoWithAnnotations var18 = new MethodInfoWithAnnotations(var3, var6);
            return var18;
        } else {
            return var3;
        }
    }

    static AnnotationInfo[] decodeAnnotations(int var0, boolean var1, int var2, MethodInfo var3) {
        AnnotationInfo[] var4 = new AnnotationInfo[var2];
        int var5 = var0;
        for (int var6 = 0; var6 < var2; ++var6) {
            AnnotationInfo var10002 = new AnnotationInfo(var3.reference, var3.constantPoolOffsets, var5 + var3.structOffset, var1, false);
            var4[var6] = var10002;
            var5 += var4[var6].readOffset;
        }
        return var4;
    }

    static AnnotationInfo[] decodeMethodAnnotations(int var0, boolean var1, MethodInfo var2) {
        int var3 = var2.method_1104(var0 + 6);
        if (var3 <= 0) {
            return null;
        } else {
            AnnotationInfo[] var4 = decodeAnnotations(var0 + 8, var1, var3, var2);
            if (var1) {
                int var5 = 0;
                for (int var6 = 0; var6 < var3; ++var6) {
                    long var7 = var4[var6].standardAnnotationTagBits;
                    var2.tagBits |= var7;
                    if (var7 != 0L) {
                        var4[var6] = null;
                        ++var5;
                    }
                }
                if (var5 != 0) {
                    if (var5 == var3) {
                        return null;
                    }
                    AnnotationInfo[] var9 = new AnnotationInfo[var3 - var5];
                    int var10 = 0;
                    for (int var8 = 0; var8 < var3; ++var8) {
                        if (var4[var8] != null) {
                            var9[var10++] = var4[var8];
                        }
                    }
                    var4 = var9;
                }
            }
            return var4;
        }
    }

    static AnnotationInfo[][] decodeParamAnnotations(int var0, boolean var1, MethodInfo var2) {
        AnnotationInfo[][] var3 = (AnnotationInfo[][])null;
        int var4 = var2.method_1103(var0 + 6);
        if (var4 > 0) {
            int var5 = var0 + 7;
            for (int var6 = 0; var6 < var4; ++var6) {
                int var7 = var2.method_1104(var5);
                var5 += 2;
                if (var7 > 0) {
                    if (var3 == null) {
                        var3 = new AnnotationInfo[var4][];
                    }
                    AnnotationInfo[] var8 = decodeAnnotations(var5, var1, var7, var2);
                    var3[var6] = var8;
                    for (int var9 = 0; var9 < var8.length; ++var9) {
                        var5 += var8[var9].readOffset;
                    }
                }
            }
        }
        return var3;
    }

    protected MethodInfo(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_853 = -1;
        this.field_859 = -1;
    }

    public int compareTo(Object var1) {
        MethodInfo var2 = (MethodInfo)var1;
        int var3 = (new String(this.method_77())).compareTo(new String(var2.method_77()));
        return var3 != 0 ? var3 : (new String(this.method_75())).compareTo(new String(var2.method_75()));
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof MethodInfo)) {
            return false;
        } else {
            MethodInfo var2 = (MethodInfo)var1;
            return CharOperation.method_1364(this.method_77(), var2.method_77()) && CharOperation.method_1364(this.method_75(), var2.method_75());
        }
    }

    public int hashCode() {
        return CharOperation.hashCode(this.method_77()) + CharOperation.hashCode(this.method_75());
    }

    public IBinaryAnnotation[] getAnnotations() {
        return null;
    }

    public char[][] method_1135() {
        if (this.field_861 == null) {
            this.method_1142();
        }
        return this.field_861;
    }

    public Object getDefaultValue() {
        return null;
    }

    public char[][] getExceptionTypeNames() {
        if (this.field_856 == null) {
            this.method_1137();
        }
        return this.field_856;
    }

    public char[] method_74() {
        if (this.field_859 != -1) {
            if (this.field_858 == null) {
                this.field_858 = this.utf8At(this.field_859 + 3, this.method_1104(this.field_859 + 1));
            }
            return this.field_858;
        } else {
            return null;
        }
    }

    public char[] method_75() {
        if (this.field_855 == null) {
            int var1 = this.constantPoolOffsets[this.method_1104(4)] - this.structOffset;
            this.field_855 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_855;
    }

    public int getModifiers() {
        if (this.field_853 == -1) {
            this.field_853 = this.method_1104(0);
            this.method_1138();
        }
        return this.field_853;
    }

    public IBinaryAnnotation[] getParameterAnnotations(int var1) {
        return null;
    }

    public char[] method_77() {
        if (this.field_857 == null) {
            int var1 = this.constantPoolOffsets[this.method_1104(2)] - this.structOffset;
            this.field_857 = this.utf8At(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_857;
    }

    public long getTagBits() {
        return this.tagBits;
    }

    protected void initialize() {
        this.getModifiers();
        this.method_77();
        this.method_75();
        this.getExceptionTypeNames();
        this.method_74();
        this.method_1135();
        this.reset();
    }

    public boolean isConstructor() {
        char[] var1 = this.method_77();
        return var1[0] == 60 && var1.length == 6;
    }

    private void method_1137() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        for (int var3 = 0; var3 < var1; ++var3) {
            int var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
            char[] var5 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
            if (CharOperation.method_1364(var5, AttributeNamesConstants.field_10)) {
                int var6 = this.method_1104(var2 + 6);
                var2 += 8;
                if (var6 == 0) {
                    this.field_856 = field_851;
                } else {
                    this.field_856 = new char[var6][];
                    for (int var7 = 0; var7 < var6; ++var7) {
                        var4 = this.constantPoolOffsets[this.method_1104(this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset + 1)] - this.structOffset;
                        this.field_856[var7] = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
                        var2 += 2;
                    }
                }
            } else {
                var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
            }
        }
        if (this.field_856 == null) {
            this.field_856 = field_851;
        }
    }

    private void method_1138() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        for (int var3 = 0; var3 < var1; ++var3) {
            int var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
            char[] var5 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
            if (var5.length != 0) {
                switch (var5[0]) {
                    case 65:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_16)) {
                            this.field_853 |= 131072;
                        }
                        break;
                    case 68:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_12)) {
                            this.field_853 |= 1048576;
                        }
                        break;
                    case 83:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_4)) {
                            this.field_853 |= 4096;
                        }
                        break;
                    case 86:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_23)) {
                            this.field_853 |= 128;
                        }
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
    }

    public int method_1139() {
        return this.field_854;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        this.toString(var1);
        return var1.toString();
    }

    void toString(StringBuffer var1) {
        var1.append(this.getClass().getName());
        this.toStringContent(var1);
    }

    protected void toStringContent(StringBuffer var1) {
        int var2 = this.getModifiers();
        char[] var3 = this.method_74();
        if (var3 == null) {
            var3 = this.method_75();
        }
        var1.append('{').append(((var2 & 1048576) != 0 ? "deprecated " : Util.field_982) + ((var2 & 1) == 1 ? "public " : Util.field_982) + ((var2 & 2) == 2 ? "private " : Util.field_982) + ((var2 & 4) == 4 ? "protected " : Util.field_982) + ((var2 & 8) == 8 ? "static " : Util.field_982) + ((var2 & 16) == 16 ? "final " : Util.field_982) + ((var2 & 64) == 64 ? "bridge " : Util.field_982) + ((var2 & 128) == 128 ? "varargs " : Util.field_982)).append(this.method_77()).append(var3).append('}');
    }

    private void method_1142() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        if (var1 != 0) {
            for (int var3 = 0; var3 < var1; ++var3) {
                int var4 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
                char[] var5 = this.utf8At(var4 + 3, this.method_1104(var4 + 1));
                if (CharOperation.method_1364(var5, AttributeNamesConstants.field_9)) {
                    this.decodeCodeAttribute(var2);
                    if (this.field_861 == null) {
                        this.field_861 = field_852;
                    }
                    return;
                }
                var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
            }
        }
        this.field_861 = field_852;
    }

    private void decodeCodeAttribute(int var1) {
        int var2 = var1 + 10;
        int var3 = (int)this.method_1105(var2);
        var2 += 4 + var3;
        int var4 = this.method_1104(var2);
        var2 += 2;
        int var5;
        if (var4 != 0) {
            for (var5 = 0; var5 < var4; ++var5) {
                var2 += 8;
            }
        }
        var5 = this.method_1104(var2);
        var2 += 2;
        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = this.constantPoolOffsets[this.method_1104(var2)] - this.structOffset;
            char[] var8 = this.utf8At(var7 + 3, this.method_1104(var7 + 1));
            if (CharOperation.method_1364(var8, AttributeNamesConstants.field_7)) {
                this.decodeLocalVariableAttribute(var2, var3);
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
    }

    private void decodeLocalVariableAttribute(int var1, int var2) {
        int var3 = var1 + 6;
        int var4 = this.method_1104(var3);
        if (var4 != 0) {
            var3 += 2;
            this.field_861 = new char[var4][];
            this.field_862 = 0;
            for (int var5 = 0; var5 < var4; ++var5) {
                int var6 = this.method_1104(var3);
                if (var6 != 0) {
                    break;
                }
                int var7 = this.method_1104(4 + var3);
                int var8 = this.constantPoolOffsets[var7] - this.structOffset;
                char[] var9 = this.utf8At(var8 + 3, this.method_1104(var8 + 1));
                if (!CharOperation.method_1364(var9, ConstantPool.field_1493)) {
                    this.field_861[this.field_862++] = var9;
                }
                var3 += 10;
            }
            if (this.field_862 != this.field_861.length) {
                System.arraycopy(this.field_861, 0, this.field_861 = new char[this.field_862][], 0, this.field_862);
            }
        }
    }

    static {
        field_851 = CharOperation.NO_CHAR_CHAR;
        field_852 = CharOperation.NO_CHAR_CHAR;
    }
}
