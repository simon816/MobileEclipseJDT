package org.eclipse.jdt.internal.compiler.classfmt;

import java.io.IOException;

import java.io.File;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileStruct;
import org.eclipse.jdt.internal.compiler.classfmt.FieldInfo;
import org.eclipse.jdt.internal.compiler.classfmt.InnerClassInfo;
import org.eclipse.jdt.internal.compiler.classfmt.MethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationMethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;
import org.eclipse.jdt.internal.compiler.env.IBinaryMethod;
import org.eclipse.jdt.internal.compiler.env.IBinaryField;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.util.Util;

public class ClassFileReader extends ClassFileStruct implements IBinaryType {

    private int field_828;

    private String field_829;

    private char[] field_830;

    private int field_831;

    private int field_832;

    private AnnotationInfo[] annotations;

    private FieldInfo[] fields;

    private int field_835;

    private InnerClassInfo innerInfo;

    private int field_837;

    private InnerClassInfo[] innerInfos;

    private char[][] interfaceNames;

    private int field_840;

    private MethodInfo[] methods;

    private int field_842;

    private char[] field_843;

    private char[] field_844;

    private char[] field_845;

    private char[] field_846;

    private long field_847;

    private long field_848;

    private char[] field_849;

    private char[][][] missingTypeNames;

    private static String printTypeModifiers(int var0) {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        PrintStream var2 = new PrintStream(var1);
        if ((var0 & 1) != 0) {
            var2.print("public ");
        }
        if ((var0 & 2) != 0) {
            var2.print("private ");
        }
        if ((var0 & 16) != 0) {
            var2.print("final ");
        }
        if ((var0 & 32) != 0) {
            var2.print("super ");
        }
        if ((var0 & 512) != 0) {
            var2.print("interface ");
        }
        if ((var0 & 1024) != 0) {
            var2.print("abstract ");
        }
        var2.flush();
        return var1.toString();
    }

    public static ClassFileReader method_1121(File var0, boolean var1) throws IOException, ClassFormatException {
        byte[] var2 = Util.method_1319(var0);
        ClassFileReader var10000 = new ClassFileReader(var2, var0.getPath());
        ClassFileReader var3 = var10000;
        if (var1) {
            var3.initialize();
        }
        return var3;
    }

    public static ClassFileReader read(String var0) throws IOException, ClassFormatException {
        return read(var0, false);
    }

    public static ClassFileReader read(String var0, boolean var1) throws IOException, ClassFormatException {
        File var10000 = new File(var0);
        return method_1121(var10000, var1);
    }

    public ClassFileReader(byte[] var1, String var2) throws ClassFormatException {
        this(var1, var2, false);
    }

    public ClassFileReader(byte[] var1, String var2, boolean var3) throws ClassFormatException {
        super(var1, (int[])null, 0);
        this.field_829 = var2;
        int var4 = 10;
        try {
            this.field_848 = ((long)this.method_1104(6) << 16) + (long)this.method_1104(4);
            this.field_832 = this.method_1104(8);
            this.constantPoolOffsets = new int[this.field_832];
            int var5;
            int var6;
            for (var5 = 1; var5 < this.field_832; ++var5) {
                var6 = this.method_1103(var4);
                switch (var6) {
                    case 1:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += this.method_1104(var4 + 1);
                        var4 += 3;
                    case 2:
                    default:
                        break;
                    case 3:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 5;
                        break;
                    case 4:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 5;
                        break;
                    case 5:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 9;
                        ++var5;
                        break;
                    case 6:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 9;
                        ++var5;
                        break;
                    case 7:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 3;
                        break;
                    case 8:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 3;
                        break;
                    case 9:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 5;
                        break;
                    case 10:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 5;
                        break;
                    case 11:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 5;
                        break;
                    case 12:
                        this.constantPoolOffsets[var5] = var4;
                        var4 += 5;
                }
            }
            this.field_828 = this.method_1104(var4);
            var4 += 2;
            this.field_831 = this.method_1104(var4);
            this.field_830 = this.getConstantClassNameAt(this.field_831);
            var4 += 2;
            var5 = this.method_1104(var4);
            var4 += 2;
            if (var5 != 0) {
                this.field_846 = this.getConstantClassNameAt(var5);
            }
            this.field_840 = this.method_1104(var4);
            var4 += 2;
            if (this.field_840 != 0) {
                this.interfaceNames = new char[this.field_840][];
                for (var6 = 0; var6 < this.field_840; ++var6) {
                    this.interfaceNames[var6] = this.getConstantClassNameAt(this.method_1104(var4));
                    var4 += 2;
                }
            }
            this.field_835 = this.method_1104(var4);
            var4 += 2;
            int var7;
            if (this.field_835 != 0) {
                this.fields = new FieldInfo[this.field_835];
                for (var7 = 0; var7 < this.field_835; ++var7) {
                    FieldInfo var17 = FieldInfo.createField(this.reference, this.constantPoolOffsets, var4);
                    this.fields[var7] = var17;
                    var4 += var17.method_1113();
                }
            }
            this.field_842 = this.method_1104(var4);
            var4 += 2;
            if (this.field_842 != 0) {
                this.methods = new MethodInfo[this.field_842];
                boolean var16 = (this.field_828 & 8192) != 0;
                for (var7 = 0; var7 < this.field_842; ++var7) {
                    this.methods[var7] = var16 ? AnnotationMethodInfo.createAnnotationMethod(this.reference, this.constantPoolOffsets, var4) : MethodInfo.createMethod(this.reference, this.constantPoolOffsets, var4);
                    var4 += this.methods[var7].method_1139();
                }
            }
            var6 = this.method_1104(var4);
            var4 += 2;
            for (var7 = 0; var7 < var6; ++var7) {
                int var8 = this.constantPoolOffsets[this.method_1104(var4)];
                char[] var9 = this.utf8At(var8 + 3, this.method_1104(var8 + 1));
                if (var9.length == 0) {
                    var4 = (int)((long)var4 + 6L + this.method_1105(var4 + 2));
                } else {
                    int var10;
                    int var11;
                    int var12;
                    switch (var9[0]) {
                        case 68:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_12)) {
                                this.field_828 |= 1048576;
                            }
                            break;
                        case 69:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_15)) {
                                var8 = this.constantPoolOffsets[this.method_1104(this.constantPoolOffsets[this.method_1104(var4 + 6)] - this.structOffset + 1)] - this.structOffset;
                                this.field_849 = this.utf8At(var8 + 3, this.method_1104(var8 + 1));
                            }
                        case 70:
                        case 71:
                        case 72:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        default:
                            break;
                        case 73:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_8)) {
                                var10 = var4 + 6;
                                var11 = this.method_1104(var10);
                                if (var11 != 0) {
                                    var10 += 2;
                                    this.innerInfos = new InnerClassInfo[var11];
                                    for (var12 = 0; var12 < var11; ++var12) {
                                        InnerClassInfo[] var19 = this.innerInfos;
                                        InnerClassInfo var10002 = new InnerClassInfo(this.reference, this.constantPoolOffsets, var10);
                                        var19[var12] = var10002;
                                        if (this.field_831 == this.innerInfos[var12].field_818) {
                                            this.innerInfo = this.innerInfos[var12];
                                            this.field_837 = var12;
                                        }
                                        var10 += 8;
                                    }
                                    if (this.innerInfo != null) {
                                        char[] var18 = this.innerInfo.method_1116();
                                        if (var18 != null) {
                                            this.field_849 = var18;
                                        }
                                    }
                                }
                            } else if (CharOperation.method_1364(var9, AttributeNamesConstants.field_22)) {
                                this.field_847 |= 131072L;
                            }
                            break;
                        case 77:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_25)) {
                                var10 = var4 + 6;
                                var11 = this.method_1104(var10);
                                if (var11 != 0) {
                                    this.missingTypeNames = new char[var11][][];
                                    var10 += 2;
                                    for (var12 = 0; var12 < var11; ++var12) {
                                        var8 = this.constantPoolOffsets[this.method_1104(this.constantPoolOffsets[this.method_1104(var10)] + 1)];
                                        char[] var13 = this.utf8At(var8 + 3, this.method_1104(var8 + 1));
                                        this.missingTypeNames[var12] = CharOperation.method_1385('/', var13);
                                        var10 += 2;
                                    }
                                }
                            }
                            break;
                        case 82:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_18)) {
                                this.decodeAnnotations(var4, true);
                            } else if (CharOperation.method_1364(var9, AttributeNamesConstants.field_17)) {
                                this.decodeAnnotations(var4, false);
                            }
                            break;
                        case 83:
                            if (var9.length > 2) {
                                switch (var9[1]) {
                                    case 105:
                                        if (CharOperation.method_1364(var9, AttributeNamesConstants.field_13)) {
                                            var8 = this.constantPoolOffsets[this.method_1104(var4 + 6)];
                                            this.field_843 = this.utf8At(var8 + 3, this.method_1104(var8 + 1));
                                        }
                                        break;
                                    case 111:
                                        if (CharOperation.method_1364(var9, AttributeNamesConstants.field_11)) {
                                            var8 = this.constantPoolOffsets[this.method_1104(var4 + 6)];
                                            this.field_845 = this.utf8At(var8 + 3, this.method_1104(var8 + 1));
                                        }
                                        break;
                                    case 121:
                                        if (CharOperation.method_1364(var9, AttributeNamesConstants.field_4)) {
                                            this.field_828 |= 4096;
                                        }
                                }
                            }
                    }
                    var4 = (int)((long)var4 + 6L + this.method_1105(var4 + 2));
                }
            }
            if (var3) {
                this.initialize();
            }
        } catch (ClassFormatException var14) {
            throw var14;
        } catch (Exception var15) {
            ClassFormatException var10000 = new ClassFormatException(21, var4);
            throw var10000;
        }
    }

    public int method_1126() {
        return this.field_828;
    }

    private void decodeAnnotations(int var1, boolean var2) {
        int var3 = this.method_1104(var1 + 6);
        if (var3 > 0) {
            int var4 = var1 + 8;
            AnnotationInfo[] var5 = null;
            int var6 = 0;
            int var7;
            for (var7 = 0; var7 < var3; ++var7) {
                AnnotationInfo var10000 = new AnnotationInfo(this.reference, this.constantPoolOffsets, var4, var2, false);
                AnnotationInfo var8 = var10000;
                var4 += var8.readOffset;
                long var9 = var8.standardAnnotationTagBits;
                if (var9 != 0L) {
                    this.field_847 |= var9;
                } else {
                    if (var5 == null) {
                        var5 = new AnnotationInfo[var3 - var7];
                    }
                    var5[var6++] = var8;
                }
            }
            if (var5 == null) {
                return;
            }
            if (this.annotations == null) {
                if (var6 != var5.length) {
                    System.arraycopy(var5, 0, var5 = new AnnotationInfo[var6], 0, var6);
                }
                this.annotations = var5;
            } else {
                var7 = this.annotations.length;
                AnnotationInfo[] var11 = new AnnotationInfo[var7 + var6];
                System.arraycopy(this.annotations, 0, var11, 0, var7);
                System.arraycopy(var5, 0, var11, var7, var6);
                this.annotations = var11;
            }
        }
    }

    public IBinaryAnnotation[] getAnnotations() {
        return this.annotations;
    }

    private char[] getConstantClassNameAt(int var1) {
        int var2 = this.constantPoolOffsets[this.method_1104(this.constantPoolOffsets[var1] + 1)];
        return this.utf8At(var2 + 3, this.method_1104(var2 + 1));
    }

    public char[] getContents() {
        return this.field_849;
    }

    public IBinaryField[] getFields() {
        return this.fields;
    }

    public String method_50() {
        return this.field_829;
    }

    public char[] method_52() {
        return this.field_843;
    }

    public char[] method_1129() {
        return this.innerInfo != null ? this.innerInfo.method_1118() : null;
    }

    public char[][] getPackageName() {
        return this.interfaceNames;
    }

    public IBinaryNestedType[] getMemberTypes() {
        if (this.innerInfos == null) {
            return null;
        } else {
            int var1 = this.innerInfos.length;
            int var2 = this.innerInfo != null ? this.field_837 + 1 : 0;
            if (var1 != var2) {
                IBinaryNestedType[] var3 = new IBinaryNestedType[var1 - this.field_837];
                int var4 = 0;
                for (int var5 = var2; var5 < var1; ++var5) {
                    InnerClassInfo var6 = this.innerInfos[var5];
                    int var7 = var6.field_819;
                    int var8 = var6.field_820;
                    if (var7 != 0 && var8 != 0 && var7 == this.field_831 && var6.method_1118().length != 0) {
                        var3[var4++] = var6;
                    }
                }
                if (var4 == 0) {
                    return null;
                } else {
                    if (var4 != var3.length) {
                        System.arraycopy(var3, 0, var3 = new IBinaryNestedType[var4], 0, var4);
                    }
                    return var3;
                }
            } else {
                return null;
            }
        }
    }

    public IBinaryMethod[] getMethods() {
        return this.methods;
    }

    public char[][][] getMissingTypeNames() {
        return this.missingTypeNames;
    }

    public int getModifiers() {
        return this.innerInfo != null ? this.innerInfo.getModifiers() | this.field_828 & 1048576 : this.field_828;
    }

    public char[] method_60() {
        return this.field_830;
    }

    public char[] method_61() {
        if (this.field_844 != null) {
            return this.field_844;
        } else {
            char[] var1 = this.method_1129();
            if (var1 == null) {
                var1 = this.method_60();
                int var2;
                if (this.method_64()) {
                    var2 = CharOperation.method_1374('$', var1, CharOperation.method_1376('/', var1) + 1) + 1;
                } else {
                    var2 = CharOperation.method_1376('/', var1) + 1;
                }
                if (var2 > 0) {
                    char[] var3 = new char[var1.length - var2];
                    System.arraycopy(var1, var2, var3, 0, var3.length);
                    var1 = var3;
                }
            }
            return this.field_844 = var1;
        }
    }

    public char[] method_62() {
        return this.field_846;
    }

    public long getTagBits() {
        return this.field_847;
    }

    private void initialize() throws ClassFormatException {
        try {
            int var1 = 0;
            int var2;
            for (var2 = this.field_835; var1 < var2; ++var1) {
                this.fields[var1].initialize();
            }
            var1 = 0;
            for (var2 = this.field_842; var1 < var2; ++var1) {
                this.methods[var1].initialize();
            }
            if (this.innerInfos != null) {
                var1 = 0;
                for (var2 = this.innerInfos.length; var1 < var2; ++var1) {
                    this.innerInfos[var1].initialize();
                }
            }
            if (this.annotations != null) {
                var1 = 0;
                for (var2 = this.annotations.length; var1 < var2; ++var1) {
                    this.annotations[var1].initialize();
                }
            }
            this.reset();
        } catch (RuntimeException var3) {
            ClassFormatException var10000 = new ClassFormatException(var3, this.field_829);
            throw var10000;
        }
    }

    public boolean method_64() {
        if (this.innerInfo == null) {
            return false;
        } else {
            char[] var1 = this.innerInfo.method_1118();
            return var1 == null || var1.length == 0;
        }
    }

    public boolean method_65() {
        if (this.innerInfo == null) {
            return false;
        } else if (this.innerInfo.method_1116() != null) {
            return false;
        } else {
            char[] var1 = this.innerInfo.method_1118();
            return var1 != null && var1.length > 0;
        }
    }

    public boolean method_66() {
        if (this.innerInfo == null) {
            return false;
        } else if (this.innerInfo.method_1116() == null) {
            return false;
        } else {
            char[] var1 = this.innerInfo.method_1118();
            return var1 != null && var1.length > 0;
        }
    }

    public String toString() {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        PrintStream var2 = new PrintStream(var1);
        var2.println(this.getClass().getName() + "{");
        var2.println(" this.className: " + new String(this.method_60()));
        var2.println(" this.superclassName: " + (this.method_62() == null ? "null" : new String(this.method_62())));
        var2.println(" access_flags: " + printTypeModifiers(this.method_1126()) + "(" + this.method_1126() + ")");
        var2.flush();
        return var1.toString();
    }
}
