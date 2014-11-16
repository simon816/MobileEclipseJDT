package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.classfmt.MethodInfo;
import org.eclipse.jdt.internal.compiler.classfmt.MethodInfoWithAnnotations;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationMethodInfoWithAnnotations;
import org.eclipse.jdt.internal.compiler.classfmt.AnnotationInfo;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;

public class AnnotationMethodInfo extends MethodInfo {

    protected Object defaultValue;

    public static MethodInfo createAnnotationMethod(byte[] var0, int[] var1, int var2) {
        MethodInfo var10000 = new MethodInfo(var0, var1, var2);
        MethodInfo var3 = var10000;
        int var4 = var3.method_1104(6);
        int var5 = 8;
        AnnotationInfo[] var6 = null;
        Object var7 = null;
        for (int var8 = 0; var8 < var4; ++var8) {
            int var9 = var3.constantPoolOffsets[var3.method_1104(var5)] - var3.structOffset;
            char[] var10 = var3.utf8At(var9 + 3, var3.method_1104(var9 + 1));
            if (var10.length > 0) {
                switch (var10[0]) {
                    case 65:
                        if (CharOperation.method_1364(var10, AttributeNamesConstants.field_16)) {
                            AnnotationInfo var16 = new AnnotationInfo(var3.reference, var3.constantPoolOffsets, var5 + 6 + var3.structOffset);
                            AnnotationInfo var18 = var16;
                            var7 = var18.decodeDefaultValue();
                        }
                        break;
                    case 82:
                        AnnotationInfo[] var11 = null;
                        if (CharOperation.method_1364(var10, AttributeNamesConstants.field_18)) {
                            var11 = decodeMethodAnnotations(var5, true, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_17)) {
                            var11 = decodeMethodAnnotations(var5, false, var3);
                        }
                        if (var11 != null) {
                            if (var6 == null) {
                                var6 = var11;
                            } else {
                                int var12 = var6.length;
                                AnnotationInfo[] var13 = new AnnotationInfo[var12 + var11.length];
                                System.arraycopy(var6, 0, var13, 0, var12);
                                System.arraycopy(var11, 0, var13, var12, var11.length);
                                var6 = var13;
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
            if (var6 != null) {
                AnnotationMethodInfoWithAnnotations var15 = new AnnotationMethodInfoWithAnnotations(var3, var7, var6);
                return var15;
            } else {
                AnnotationMethodInfo var14 = new AnnotationMethodInfo(var3, var7);
                return var14;
            }
        } else if (var6 != null) {
            MethodInfoWithAnnotations var17 = new MethodInfoWithAnnotations(var3, var6);
            return var17;
        } else {
            return var3;
        }
    }

    AnnotationMethodInfo(MethodInfo var1, Object var2) {
        super(var1.reference, var1.constantPoolOffsets, var1.structOffset);
        this.defaultValue = null;
        this.defaultValue = var2;
        this.field_853 = var1.field_853;
        this.field_854 = var1.field_854;
        this.field_855 = var1.field_855;
        this.field_856 = var1.field_856;
        this.field_857 = var1.field_857;
        this.field_858 = var1.field_858;
        this.field_859 = var1.field_859;
        this.tagBits = var1.tagBits;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    protected void toStringContent(StringBuffer var1) {
        super.toStringContent(var1);
        if (this.defaultValue != null) {
            var1.append(" default ");
            if (this.defaultValue instanceof Object[]) {
                var1.append('{');
                Object[] var2 = (Object[])((Object[])this.defaultValue);
                int var3 = 0;
                for (int var4 = var2.length; var3 < var4; ++var3) {
                    if (var3 > 0) {
                        var1.append(", ");
                    }
                    var1.append(var2[var3]);
                }
                var1.append('}');
            } else {
                var1.append(this.defaultValue);
            }
            var1.append('\n');
        }
    }
}
