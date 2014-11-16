package org.eclipse.jdt.internal.compiler;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Vector;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile$2;
import org.eclipse.jdt.internal.compiler.ClassFile$1;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AnnotationMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream;
import org.eclipse.jdt.internal.compiler.codegen.ConstantPool;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$ExceptionMarker;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrame;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$StackMarker;
import org.eclipse.jdt.internal.compiler.codegen.ExceptionLabel;
import org.eclipse.jdt.internal.compiler.codegen.VerificationTypeInfo;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$StackDepthMarker;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.StringConstant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.compiler.util.Messages;

public class ClassFile implements TypeConstants {

    private byte[] bytes;

    public CodeStream codeStream;

    public ConstantPool constantPool;

    public int field_1717;

    public byte[] field_1718;

    public int field_1719;

    protected boolean creatingProblemType;

    public ClassFile enclosingClassFile;

    public byte[] field_1722;

    public int field_1723;

    public Vector field_1724;

    public int field_1725;

    public int field_1726;

    boolean isShared;

    public int field_1728;

    public SourceTypeBinding referenceBinding;

    public boolean isNestedType;

    public long targetJDK;

    public List field_1732;

    public static void createProblemType(TypeDeclaration var0, CompilationResult var1) {
        SourceTypeBinding var2 = var0.binding;
        ClassFile var3 = getNewInstance(var2);
        var3.initialize(var2, (ClassFile)null, true);
        int var5;
        if (var2.method_213()) {
            ReferenceBinding[] var4 = var2.field_256;
            var5 = 0;
            for (int var6 = var4.length; var5 < var6; ++var5) {
                var3.recordInnerClasses(var4[var5]);
            }
        }
        if (var2.method_160()) {
            var3.recordInnerClasses(var2);
        }
        FieldBinding[] var13 = var2.fields();
        if (var13 != null && var13 != Binding.field_153) {
            var3.method_2964();
        } else {
            var3.field_1718[var3.field_1719++] = 0;
            var3.field_1718[var3.field_1719++] = 0;
        }
        var3.method_3017();
        CategorizedProblem[] var14 = var1.method_2919();
        if (var14 == null) {
            var14 = new CategorizedProblem[0];
        }
        CategorizedProblem[] var7 = new CategorizedProblem[var5 = var14.length];
        System.arraycopy(var14, 0, var7, 0, var5);
        AbstractMethodDeclaration[] var8 = var0.methods;
        int var9;
        int var10;
        if (var8 != null) {
            AbstractMethodDeclaration var11;
            MethodBinding var12;
            if (var2.method_157()) {
                var3.addProblemClinit(var7);
                var9 = 0;
                for (var10 = var8.length; var9 < var10; ++var9) {
                    var11 = var8[var9];
                    var12 = var11.binding;
                    if (var12 != null && !var12.method_358()) {
                        var3.addAbstractMethod(var11, var12);
                    }
                }
            } else {
                var9 = 0;
                for (var10 = var8.length; var9 < var10; ++var9) {
                    var11 = var8[var9];
                    var12 = var11.binding;
                    if (var12 != null) {
                        if (var12.method_358()) {
                            var3.method_2967(var11, var12, var7);
                        } else {
                            var3.method_2969(var11, var12, var7);
                        }
                    }
                }
            }
            var3.method_2961();
        }
        if (var0.memberTypes != null) {
            var9 = 0;
            for (var10 = var0.memberTypes.length; var9 < var10; ++var9) {
                TypeDeclaration var15 = var0.memberTypes[var9];
                if (var15.binding != null) {
                    createProblemType(var15, var1);
                }
            }
        }
        var3.method_2960();
        var1.record(var2.constantPoolName(), var3);
    }

    public static ClassFile getNewInstance(SourceTypeBinding var0) {
        LookupEnvironment var1 = var0.scope.environment();
        return var1.classFilePool.acquire(var0);
    }

    protected ClassFile() {
        this.isShared = false;
        this.field_1732 = null;
    }

    public ClassFile(SourceTypeBinding var1) {
        this.isShared = false;
        this.field_1732 = null;
        ConstantPool var10001 = new ConstantPool(this);
        this.constantPool = var10001;
        CompilerOptions var2 = var1.scope.compilerOptions();
        this.targetJDK = var2.field_1929;
        this.field_1728 = var2.field_1926;
        this.referenceBinding = var1;
        this.isNestedType = var1.method_160();
        StackMapFrameCodeStream var4;
        if (this.targetJDK >= 3276800L) {
            this.field_1728 |= 8;
            var4 = new StackMapFrameCodeStream(this);
            this.codeStream = var4;
        } else if (this.targetJDK == 2949124L) {
            this.targetJDK = 2949123L;
            this.field_1728 |= 16;
            var4 = new StackMapFrameCodeStream(this);
            this.codeStream = var4;
        } else {
            CodeStream var3 = new CodeStream(this);
            this.codeStream = var3;
        }
        this.initByteArrays();
    }

    public void addAbstractMethod(AbstractMethodDeclaration var1, MethodBinding var2) {
        var2.modifiers = 1025;
        this.generateMethodInfoHeader(var2);
        int var3 = this.field_1719;
        int var4 = this.generateMethodInfoAttribute(var2);
        this.method_2986(var3, var4);
    }

    public void method_2960() {
        this.field_1718[this.field_1726++] = (byte)(this.field_1725 >> 8);
        this.field_1718[this.field_1726] = (byte)this.field_1725;
        int var1 = 0;
        int var2 = this.field_1719;
        this.field_1719 += 2;
        int var4;
        int var5;
        int var6;
        if ((this.field_1728 & 1) != 0) {
            String var3 = new String(this.referenceBinding.scope.referenceCompilationUnit().method_771());
            var3 = var3.replace('\\', '/');
            var4 = var3.lastIndexOf(47);
            if (var4 != -1) {
                var3 = var3.substring(var4 + 1, var3.length());
            }
            if (this.field_1719 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            var5 = this.constantPool.method_2459(AttributeNamesConstants.field_11);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 2;
            var6 = this.constantPool.method_2459(var3.toCharArray());
            this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
            this.field_1718[this.field_1719++] = (byte)var6;
            ++var1;
        }
        if (this.referenceBinding.method_220()) {
            if (this.field_1719 + 6 >= this.field_1718.length) {
                this.resizeContents(6);
            }
            int var14 = this.constantPool.method_2459(AttributeNamesConstants.field_12);
            this.field_1718[this.field_1719++] = (byte)(var14 >> 8);
            this.field_1718[this.field_1719++] = (byte)var14;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            ++var1;
        }
        char[] var15 = this.referenceBinding.method_307();
        if (var15 != null) {
            if (this.field_1719 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            var4 = this.constantPool.method_2459(AttributeNamesConstants.field_13);
            this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
            this.field_1718[this.field_1719++] = (byte)var4;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 2;
            var5 = this.constantPool.method_2459(var15);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            ++var1;
        }
        int var9;
        if (this.targetJDK >= 3211264L && this.referenceBinding.method_160() && !this.referenceBinding.method_159()) {
            if (this.field_1719 + 10 >= this.field_1718.length) {
                this.resizeContents(10);
            }
            var4 = this.constantPool.method_2459(AttributeNamesConstants.field_15);
            this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
            this.field_1718[this.field_1719++] = (byte)var4;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 4;
            var5 = this.constantPool.method_2466(this.referenceBinding.enclosingType().constantPoolName());
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            byte var20 = 0;
            byte var7 = 0;
            if (this.referenceBinding instanceof LocalTypeBinding) {
                MethodBinding var8 = ((LocalTypeBinding)this.referenceBinding).enclosingMethod;
                if (var8 != null) {
                    var9 = this.constantPool.literalIndexForNameAndType(var8.selector, var8.signature(this));
                    var20 = (byte)(var9 >> 8);
                    var7 = (byte)var9;
                }
            }
            this.field_1718[this.field_1719++] = var20;
            this.field_1718[this.field_1719++] = var7;
            ++var1;
        }
        if (this.targetJDK >= 3211264L) {
            TypeDeclaration var17 = this.referenceBinding.scope.referenceContext;
            if (var17 != null) {
                Annotation[] var18 = var17.annotations;
                if (var18 != null) {
                    var1 += this.generateRuntimeAnnotations(var18);
                }
            }
        }
        ReferenceBinding[] var19;
        int var21;
        if (this.referenceBinding.method_156()) {
            ReferenceBinding var16 = this.referenceBinding.superclass;
            if (var16 != null) {
                this.field_1732 = var16.method_132(this.field_1732);
            }
            var19 = this.referenceBinding.superInterfaces();
            var6 = 0;
            for (var21 = var19.length; var6 < var21; ++var6) {
                this.field_1732 = var19[var6].method_132(this.field_1732);
            }
            if (this.field_1719 + 6 >= this.field_1718.length) {
                this.resizeContents(6);
            }
            var6 = this.constantPool.method_2459(AttributeNamesConstants.field_22);
            this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
            this.field_1718[this.field_1719++] = (byte)var6;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            ++var1;
        }
        var4 = this.field_1724 == null ? 0 : this.field_1724.size();
        if (var4 != 0) {
            var19 = new ReferenceBinding[var4];
            this.field_1724.copyInto(var19);
            ClassFile$1 var10001 = new ClassFile$1(this);
            Arrays.sort(var19, var10001);
            var6 = 8 * var4 + 8;
            if (var6 + this.field_1719 >= this.field_1718.length) {
                this.resizeContents(var6);
            }
            var21 = this.constantPool.method_2459(AttributeNamesConstants.field_8);
            this.field_1718[this.field_1719++] = (byte)(var21 >> 8);
            this.field_1718[this.field_1719++] = (byte)var21;
            int var22 = (var4 << 3) + 2;
            this.field_1718[this.field_1719++] = (byte)(var22 >> 24);
            this.field_1718[this.field_1719++] = (byte)(var22 >> 16);
            this.field_1718[this.field_1719++] = (byte)(var22 >> 8);
            this.field_1718[this.field_1719++] = (byte)var22;
            this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
            this.field_1718[this.field_1719++] = (byte)var4;
            for (var9 = 0; var9 < var4; ++var9) {
                ReferenceBinding var10 = var19[var9];
                int var11 = var10.method_205();
                int var12 = this.constantPool.method_2466(var10.constantPoolName());
                this.field_1718[this.field_1719++] = (byte)(var12 >> 8);
                this.field_1718[this.field_1719++] = (byte)var12;
                int var13;
                if (var10.method_159()) {
                    var13 = this.constantPool.method_2466(var10.enclosingType().constantPoolName());
                    this.field_1718[this.field_1719++] = (byte)(var13 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var13;
                } else {
                    this.field_1718[this.field_1719++] = 0;
                    this.field_1718[this.field_1719++] = 0;
                }
                if (!var10.method_146()) {
                    var13 = this.constantPool.method_2459(var10.method_179());
                    this.field_1718[this.field_1719++] = (byte)(var13 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var13;
                } else {
                    this.field_1718[this.field_1719++] = 0;
                    this.field_1718[this.field_1719++] = 0;
                }
                if (var10.method_146()) {
                    var11 &= -17;
                } else if (var10.method_159() && var10.method_157()) {
                    var11 |= 8;
                }
                this.field_1718[this.field_1719++] = (byte)(var11 >> 8);
                this.field_1718[this.field_1719++] = (byte)var11;
            }
            ++var1;
        }
        if (this.field_1732 != null) {
            this.generateMissingTypesAttribute();
            ++var1;
        }
        if (var2 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var2++] = (byte)(var1 >> 8);
        this.field_1718[var2] = (byte)var1;
        this.field_1722 = this.constantPool.poolContent;
        this.field_1723 = this.constantPool.field_1321;
        var5 = this.constantPool.field_1320;
        this.field_1722[this.field_1717++] = (byte)(var5 >> 8);
        this.field_1722[this.field_1717] = (byte)var5;
    }

    public void method_2961() {
        MethodBinding[] var1 = this.referenceBinding.getDefaultAbstractMethods();
        int var2 = 0;
        for (int var3 = var1.length; var2 < var3; ++var2) {
            this.generateMethodInfoHeader(var1[var2]);
            int var4 = this.field_1719;
            int var5 = this.generateMethodInfoAttribute(var1[var2]);
            this.method_2986(var4, var5);
        }
    }

    private int addFieldAttributes(FieldBinding var1, int var2) {
        int var3 = 0;
        Constant var4 = var1.constant();
        int var5;
        int var6;
        int var7;
        if (var4 != Constant.NotAConstant) {
            if (this.field_1719 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            var5 = this.constantPool.method_2459(AttributeNamesConstants.field_5);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 2;
            ++var3;
            switch (var4.typeID()) {
                case 2:
                case 3:
                case 4:
                case 10:
                    var7 = this.constantPool.literalIndex(var4.intValue());
                    this.field_1718[this.field_1719++] = (byte)(var7 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var7;
                    break;
                case 5:
                    var6 = this.constantPool.literalIndex(var4.booleanValue() ? 1 : 0);
                    this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var6;
                case 6:
                default:
                    break;
                case 7:
                    int var10 = this.constantPool.literalIndex(var4.longValue());
                    this.field_1718[this.field_1719++] = (byte)(var10 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var10;
                    break;
                case 8:
                    int var9 = this.constantPool.literalIndex(var4.doubleValue());
                    this.field_1718[this.field_1719++] = (byte)(var9 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var9;
                    break;
                case 9:
                    int var8 = this.constantPool.literalIndex(var4.floatValue());
                    this.field_1718[this.field_1719++] = (byte)(var8 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var8;
                    break;
                case 11:
                    int var11 = this.constantPool.literalIndex(((StringConstant)var4).method_3287());
                    if (var11 == -1) {
                        if (!this.creatingProblemType) {
                            TypeDeclaration var12 = this.referenceBinding.scope.referenceContext;
                            FieldDeclaration[] var13 = var12.fields;
                            int var14 = 0;
                            for (int var15 = var13.length; var14 < var15; ++var14) {
                                if (var13[var14].binding == var1) {
                                    var12.scope.problemReporter().method_1760(var13[var14]);
                                }
                            }
                        } else {
                            this.field_1719 = var2;
                        }
                    } else {
                        this.field_1718[this.field_1719++] = (byte)(var11 >> 8);
                        this.field_1718[this.field_1719++] = (byte)var11;
                    }
            }
        }
        if (this.targetJDK < 3211264L && var1.method_432()) {
            if (this.field_1719 + 6 >= this.field_1718.length) {
                this.resizeContents(6);
            }
            var5 = this.constantPool.method_2459(AttributeNamesConstants.field_4);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            ++var3;
        }
        if (var1.method_427()) {
            if (this.field_1719 + 6 >= this.field_1718.length) {
                this.resizeContents(6);
            }
            var5 = this.constantPool.method_2459(AttributeNamesConstants.field_12);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            ++var3;
        }
        char[] var16 = var1.genericSignature();
        if (var16 != null) {
            if (this.field_1719 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            var6 = this.constantPool.method_2459(AttributeNamesConstants.field_13);
            this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
            this.field_1718[this.field_1719++] = (byte)var6;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 2;
            var7 = this.constantPool.method_2459(var16);
            this.field_1718[this.field_1719++] = (byte)(var7 >> 8);
            this.field_1718[this.field_1719++] = (byte)var7;
            ++var3;
        }
        if (this.targetJDK >= 3211264L) {
            FieldDeclaration var17 = var1.sourceField();
            if (var17 != null) {
                Annotation[] var18 = var17.annotations;
                if (var18 != null) {
                    var3 += this.generateRuntimeAnnotations(var18);
                }
            }
        }
        if ((var1.tagBits & 128L) != 0L) {
            this.field_1732 = var1.type.method_132(this.field_1732);
        }
        return var3;
    }

    private void addFieldInfo(FieldBinding var1) {
        if (this.field_1719 + 8 >= this.field_1718.length) {
            this.resizeContents(8);
        }
        int var2 = var1.method_425();
        if (this.targetJDK < 3211264L) {
            var2 &= -4097;
        }
        this.field_1718[this.field_1719++] = (byte)(var2 >> 8);
        this.field_1718[this.field_1719++] = (byte)var2;
        int var3 = this.constantPool.method_2459(var1.name);
        this.field_1718[this.field_1719++] = (byte)(var3 >> 8);
        this.field_1718[this.field_1719++] = (byte)var3;
        int var4 = this.constantPool.method_2458(var1.type);
        this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
        this.field_1718[this.field_1719++] = (byte)var4;
        int var5 = this.field_1719;
        byte var6 = 0;
        this.field_1719 += 2;
        int var7 = var6 + this.addFieldAttributes(var1, var5);
        if (this.field_1719 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var5++] = (byte)(var7 >> 8);
        this.field_1718[var5] = (byte)var7;
    }

    public void method_2964() {
        SourceTypeBinding var1 = this.referenceBinding;
        FieldBinding[] var2 = var1.syntheticFields();
        int var3 = var1.method_203() + (var2 == null ? 0 : var2.length);
        if (var3 > '\uffff') {
            this.referenceBinding.scope.problemReporter().method_1769(this.referenceBinding.scope.referenceType());
        }
        this.field_1718[this.field_1719++] = (byte)(var3 >> 8);
        this.field_1718[this.field_1719++] = (byte)var3;
        FieldDeclaration[] var4 = var1.scope.referenceContext.fields;
        int var5 = 0;
        int var6;
        for (var6 = var4 == null ? 0 : var4.length; var5 < var6; ++var5) {
            FieldDeclaration var7 = var4[var5];
            if (var7.binding != null) {
                this.addFieldInfo(var7.binding);
            }
        }
        if (var2 != null) {
            var5 = 0;
            for (var6 = var2.length; var5 < var6; ++var5) {
                this.addFieldInfo(var2[var5]);
            }
        }
    }

    private void addMissingAbstractProblemMethod(MethodDeclaration var1, MethodBinding var2, CategorizedProblem var3, CompilationResult var4) {
        this.generateMethodInfoHeader(var2, var2.modifiers & -3329);
        int var5 = this.field_1719;
        int var6 = this.generateMethodInfoAttribute(var2);
        ++var6;
        int var7 = this.field_1719;
        this.method_2989();
        StringBuffer var8 = new StringBuffer(25);
        var8.append("\t" + var3.method_1404() + "\n");
        var8.insert(0, Messages.field_1860);
        String var9 = var8.toString();
        this.codeStream.method_2255(this);
        this.codeStream.field_1209 = true;
        this.codeStream.initializeMaxLocals(var2);
        this.codeStream.generateCodeAttributeForProblemMethod(var9);
        this.completeCodeAttributeForMissingAbstractProblemMethod(var2, var7, var4.getLineSeparatorPositions(), var3.method_1403());
        this.method_2986(var5, var6);
    }

    public void addProblemClinit(CategorizedProblem[] var1) {
        this.method_2997();
        this.field_1719 -= 2;
        int var2 = this.field_1719;
        this.field_1719 += 2;
        byte var3 = 0;
        int var4 = this.field_1719;
        this.method_2989();
        this.codeStream.method_2368(this);
        String var5 = "";
        int var6 = 0;
        if (var1 != null) {
            int var7 = var1.length;
            StringBuffer var8 = new StringBuffer(25);
            int var9 = 0;
            for (int var10 = 0; var10 < var7; ++var10) {
                CategorizedProblem var11 = var1[var10];
                if (var11 != null && var11.method_1399()) {
                    var8.append("\t" + var11.method_1404() + "\n");
                    ++var9;
                    if (var6 == 0) {
                        var6 = var11.method_1403();
                    }
                    var1[var10] = null;
                }
            }
            if (var9 > 1) {
                var8.insert(0, Messages.field_1861);
            } else {
                var8.insert(0, Messages.field_1860);
            }
            var5 = var8.toString();
        }
        this.codeStream.generateCodeAttributeForProblemMethod(var5);
        int var12 = var3 + 1;
        this.method_2981(var4, var6);
        if (this.field_1719 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var2++] = (byte)(var12 >> 8);
        this.field_1718[var2] = (byte)var12;
    }

    public void method_2967(AbstractMethodDeclaration var1, MethodBinding var2, CategorizedProblem[] var3) {
        this.generateMethodInfoHeader(var2, var2.modifiers & -3329);
        int var4 = this.field_1719;
        int var5 = this.generateMethodInfoAttribute(var2);
        ++var5;
        int var6 = this.field_1719;
        this.method_2989();
        this.codeStream.reset(var1, this);
        String var7 = "";
        int var8 = 0;
        if (var3 != null) {
            int var9 = var3.length;
            StringBuffer var10 = new StringBuffer(25);
            int var11 = 0;
            for (int var12 = 0; var12 < var9; ++var12) {
                CategorizedProblem var13 = var3[var12];
                if (var13 != null && var13.method_1399()) {
                    var10.append("\t" + var13.method_1404() + "\n");
                    ++var11;
                    if (var8 == 0) {
                        var8 = var13.method_1403();
                    }
                }
            }
            if (var11 > 1) {
                var10.insert(0, Messages.field_1861);
            } else {
                var10.insert(0, Messages.field_1860);
            }
            var7 = var10.toString();
        }
        this.codeStream.generateCodeAttributeForProblemMethod(var7);
        this.completeCodeAttributeForProblemMethod(var1, var2, var6, ((SourceTypeBinding)var2.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions(), var8);
        this.method_2986(var4, var5);
    }

    public void method_2968(AbstractMethodDeclaration var1, MethodBinding var2, CategorizedProblem[] var3, int var4) {
        this.field_1719 = var4;
        --this.field_1725;
        this.method_2967(var1, var2, var3);
    }

    public void method_2969(AbstractMethodDeclaration var1, MethodBinding var2, CategorizedProblem[] var3) {
        if (var2.method_356() && var2.declaringClass.method_157()) {
            var1.abort(8, (CategorizedProblem)null);
        }
        this.generateMethodInfoHeader(var2, var2.modifiers & -3329);
        int var4 = this.field_1719;
        int var5 = this.generateMethodInfoAttribute(var2);
        ++var5;
        int var6 = this.field_1719;
        this.method_2989();
        this.codeStream.reset(var1, this);
        String var7 = "";
        int var8 = 0;
        if (var3 != null) {
            int var9 = var3.length;
            StringBuffer var10 = new StringBuffer(25);
            int var11 = 0;
            for (int var12 = 0; var12 < var9; ++var12) {
                CategorizedProblem var13 = var3[var12];
                if (var13 != null && var13.method_1399() && var13.method_1401() >= var1.field_480 && var13.method_1402() <= var1.field_481) {
                    var10.append("\t" + var13.method_1404() + "\n");
                    ++var11;
                    if (var8 == 0) {
                        var8 = var13.method_1403();
                    }
                    var3[var12] = null;
                }
            }
            if (var11 > 1) {
                var10.insert(0, Messages.field_1861);
            } else {
                var10.insert(0, Messages.field_1860);
            }
            var7 = var10.toString();
        }
        this.codeStream.generateCodeAttributeForProblemMethod(var7);
        this.completeCodeAttributeForProblemMethod(var1, var2, var6, ((SourceTypeBinding)var2.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions(), var8);
        this.method_2986(var4, var5);
    }

    public void method_2970(AbstractMethodDeclaration var1, MethodBinding var2, CategorizedProblem[] var3, int var4) {
        this.field_1719 = var4;
        --this.field_1725;
        this.method_2969(var1, var2, var3);
    }

    public void method_2971() {
        this.generateMissingAbstractMethods(this.referenceBinding.scope.referenceType().missingAbstractMethods, this.referenceBinding.scope.referenceCompilationUnit().compilationResult);
        MethodBinding[] var1 = this.referenceBinding.getDefaultAbstractMethods();
        int var2 = 0;
        int var3;
        int var4;
        for (var3 = var1.length; var2 < var3; ++var2) {
            this.generateMethodInfoHeader(var1[var2]);
            var4 = this.field_1719;
            int var5 = this.generateMethodInfoAttribute(var1[var2]);
            this.method_2986(var4, var5);
        }
        SyntheticMethodBinding[] var6 = this.referenceBinding.syntheticMethods();
        if (var6 != null) {
            var3 = 0;
            for (var4 = var6.length; var3 < var4; ++var3) {
                SyntheticMethodBinding var7 = var6[var3];
                switch (var7.field_287) {
                    case 1:
                        this.method_2975(var7);
                        break;
                    case 2:
                        this.method_2976(var7);
                        break;
                    case 3:
                    case 5:
                    case 6:
                        this.method_2977(var7);
                        break;
                    case 4:
                        this.method_2972(var7);
                        break;
                    case 7:
                        this.method_2974(var7);
                        break;
                    case 8:
                        this.method_2973(var7);
                        break;
                    case 9:
                        this.method_2978(var7);
                }
            }
        }
    }

    public void method_2972(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2194(var1);
        this.completeCodeAttributeForSyntheticMethod(var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2973(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2195(var1);
        this.completeCodeAttributeForSyntheticMethod(var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2974(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2196(var1);
        this.completeCodeAttributeForSyntheticMethod(var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2975(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2197(var1);
        this.completeCodeAttributeForSyntheticMethod(var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2976(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2198(var1);
        this.completeCodeAttributeForSyntheticMethod(var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2977(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2199(var1);
        this.completeCodeAttributeForSyntheticMethod(var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2978(SyntheticMethodBinding var1) {
        this.generateMethodInfoHeader(var1);
        int var2 = this.field_1719;
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        ++var3;
        this.method_2989();
        this.codeStream.method_2255(this);
        this.codeStream.method_2200(var1);
        this.completeCodeAttributeForSyntheticMethod(true, var1, var4, ((SourceTypeBinding)var1.declaringClass).scope.referenceCompilationUnit().compilationResult.getLineSeparatorPositions());
        this.field_1718[var2++] = (byte)(var3 >> 8);
        this.field_1718[var2] = (byte)var3;
    }

    public void method_2979(int var1) {
        this.field_1718 = this.codeStream.bCodeStream;
        int var2 = this.codeStream.field_1190;
        int var3 = this.codeStream.field_1208;
        if (var3 > '\uffff') {
            this.codeStream.methodDeclaration.scope.problemReporter().method_1488(this.codeStream.methodDeclaration);
        }
        if (var2 + 20 >= this.field_1718.length) {
            this.resizeContents(20);
        }
        int var4 = this.codeStream.field_1211;
        this.field_1718[var1 + 6] = (byte)(var4 >> 8);
        this.field_1718[var1 + 7] = (byte)var4;
        int var5 = this.codeStream.field_1204;
        this.field_1718[var1 + 8] = (byte)(var5 >> 8);
        this.field_1718[var1 + 9] = (byte)var5;
        this.field_1718[var1 + 10] = (byte)(var3 >> 24);
        this.field_1718[var1 + 11] = (byte)(var3 >> 16);
        this.field_1718[var1 + 12] = (byte)(var3 >> 8);
        this.field_1718[var1 + 13] = (byte)var3;
        boolean var6 = (this.field_1728 & 8) != 0;
        ExceptionLabel[] var7 = this.codeStream.exceptionLabels;
        int var8 = 0;
        int var9 = 0;
        int var10;
        for (var10 = this.codeStream.field_1194; var9 < var10; ++var9) {
            var8 += this.codeStream.exceptionLabels[var9].count / 2;
        }
        var9 = var8 * 8 + 2;
        if (var9 + var2 >= this.field_1718.length) {
            this.resizeContents(var9);
        }
        this.field_1718[var2++] = (byte)(var8 >> 8);
        this.field_1718[var2++] = (byte)var8;
        var10 = 0;
        int var11;
        int var13;
        int var14;
        int var15;
        int var17;
        int var16;
        int var42;
        for (var11 = this.codeStream.field_1194; var10 < var11; ++var10) {
            ExceptionLabel var12 = var7[var10];
            if (var12 != null) {
                var13 = 0;
                var14 = var12.count;
                if ((var14 & 1) != 0) {
                    this.codeStream.methodDeclaration.scope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1878, new String(this.codeStream.methodDeclaration.selector)), this.codeStream.methodDeclaration);
                }
                while (var13 < var14) {
                    var15 = var12.ranges[var13++];
                    this.field_1718[var2++] = (byte)(var15 >> 8);
                    this.field_1718[var2++] = (byte)var15;
                    var16 = var12.ranges[var13++];
                    this.field_1718[var2++] = (byte)(var16 >> 8);
                    this.field_1718[var2++] = (byte)var16;
                    var17 = var12.position;
                    if (var6) {
                        StackMapFrameCodeStream var18 = (StackMapFrameCodeStream)this.codeStream;
                        var18.method_2391(var17);
                    }
                    this.field_1718[var2++] = (byte)(var17 >> 8);
                    this.field_1718[var2++] = (byte)var17;
                    if (var12.exceptionType == null) {
                        this.field_1718[var2++] = 0;
                        this.field_1718[var2++] = 0;
                    } else {
                        if (var12.exceptionType == TypeBinding.field_187) {
                            var42 = this.constantPool.method_2466(ConstantPool.field_1411);
                        } else {
                            var42 = this.constantPool.method_2467(var12.exceptionType);
                        }
                        this.field_1718[var2++] = (byte)(var42 >> 8);
                        this.field_1718[var2++] = (byte)var42;
                    }
                }
            }
        }
        var10 = var2;
        var11 = 0;
        var2 += 2;
        if (var2 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        if ((this.field_1728 & 2) != 0) {
            int[] var35 = this.codeStream.field_1206;
            if (this.codeStream.field_1206 != null && this.codeStream.field_1207 != 0) {
                var13 = this.constantPool.method_2459(AttributeNamesConstants.field_6);
                if (var2 + 8 >= this.field_1718.length) {
                    this.resizeContents(8);
                }
                this.field_1718[var2++] = (byte)(var13 >> 8);
                this.field_1718[var2++] = (byte)var13;
                var14 = var2;
                var2 += 6;
                var15 = 0;
                var16 = this.codeStream.field_1207;
                for (var17 = 0; var17 < var16; ++var15) {
                    if (var2 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var42 = var35[var17++];
                    this.field_1718[var2++] = (byte)(var42 >> 8);
                    this.field_1718[var2++] = (byte)var42;
                    int var19 = var35[var17++];
                    this.field_1718[var2++] = (byte)(var19 >> 8);
                    this.field_1718[var2++] = (byte)var19;
                }
                var17 = var15 * 4 + 2;
                this.field_1718[var14++] = (byte)(var17 >> 24);
                this.field_1718[var14++] = (byte)(var17 >> 16);
                this.field_1718[var14++] = (byte)(var17 >> 8);
                this.field_1718[var14++] = (byte)var17;
                this.field_1718[var14++] = (byte)(var15 >> 8);
                this.field_1718[var14++] = (byte)var15;
                ++var11;
            }
        }
        int var20;
        int var23;
        int var22;
        int var24;
        int var29;
        int var28;
        int var31;
        int var30;
        int var32;
        int var36;
        int var46;
        int var51;
        if ((this.field_1728 & 4) != 0) {
            var36 = 0;
            var13 = this.constantPool.method_2459(AttributeNamesConstants.field_7);
            boolean var39 = this.codeStream.methodDeclaration.method_799();
            var15 = 8 + 10 * (var39 ? 0 : 1);
            for (var16 = 0; var16 < this.codeStream.field_1187; ++var16) {
                LocalVariableBinding var41 = this.codeStream.field_1202[var16];
                var15 += 10 * var41.field_311;
            }
            if (var2 + var15 >= this.field_1718.length) {
                this.resizeContents(var15);
            }
            this.field_1718[var2++] = (byte)(var13 >> 8);
            this.field_1718[var2++] = (byte)var13;
            var16 = var2;
            var2 += 6;
            SourceTypeBinding var40 = null;
            if (!var39) {
                ++var36;
                this.field_1718[var2++] = 0;
                this.field_1718[var2++] = 0;
                this.field_1718[var2++] = (byte)(var3 >> 8);
                this.field_1718[var2++] = (byte)var3;
                var17 = this.constantPool.method_2459(ConstantPool.field_1493);
                this.field_1718[var2++] = (byte)(var17 >> 8);
                this.field_1718[var2++] = (byte)var17;
                var40 = (SourceTypeBinding)this.codeStream.methodDeclaration.binding.declaringClass;
                var42 = this.constantPool.method_2459(var40.method_178());
                this.field_1718[var2++] = (byte)(var42 >> 8);
                this.field_1718[var2++] = (byte)var42;
                this.field_1718[var2++] = 0;
                this.field_1718[var2++] = 0;
            }
            var20 = 0;
            LocalVariableBinding[] var21 = null;
            var22 = 0;
            var23 = 0;
            for (var24 = this.codeStream.field_1187; var23 < var24; ++var23) {
                LocalVariableBinding var25 = this.codeStream.field_1202[var23];
                if (var25.declaration != null) {
                    TypeBinding var26 = var25.type;
                    boolean var27 = var26.method_162() || var26.method_169();
                    if (var25.field_311 != 0 && var27) {
                        if (var21 == null) {
                            var21 = new LocalVariableBinding[var24];
                        }
                        var21[var20++] = var25;
                    }
                    for (var28 = 0; var28 < var25.field_311; ++var28) {
                        var29 = var25.initializationPCs[var28 << 1];
                        var30 = var25.initializationPCs[(var28 << 1) + 1];
                        if (var29 != var30) {
                            if (var30 == -1) {
                                var25.declaringScope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1877, new String(var25.name)), (ASTNode)var25.declaringScope.method_635().referenceContext);
                            }
                            if (var27) {
                                ++var22;
                            }
                            ++var36;
                            this.field_1718[var2++] = (byte)(var29 >> 8);
                            this.field_1718[var2++] = (byte)var29;
                            var31 = var30 - var29;
                            this.field_1718[var2++] = (byte)(var31 >> 8);
                            this.field_1718[var2++] = (byte)var31;
                            var17 = this.constantPool.method_2459(var25.name);
                            this.field_1718[var2++] = (byte)(var17 >> 8);
                            this.field_1718[var2++] = (byte)var17;
                            var42 = this.constantPool.method_2459(var26.method_178());
                            this.field_1718[var2++] = (byte)(var42 >> 8);
                            this.field_1718[var2++] = (byte)var42;
                            var32 = var25.field_306;
                            this.field_1718[var2++] = (byte)(var32 >> 8);
                            this.field_1718[var2++] = (byte)var32;
                        }
                    }
                }
            }
            var23 = var36 * 10 + 2;
            this.field_1718[var16++] = (byte)(var23 >> 24);
            this.field_1718[var16++] = (byte)(var23 >> 16);
            this.field_1718[var16++] = (byte)(var23 >> 8);
            this.field_1718[var16++] = (byte)var23;
            this.field_1718[var16++] = (byte)(var36 >> 8);
            this.field_1718[var16] = (byte)var36;
            ++var11;
            boolean var47 = !var39 && var40 != null && var40.typeVariables != Binding.NO_TYPE_VARIABLES;
            if (var20 != 0 || var47) {
                var22 += var47 ? 1 : 0;
                var15 = 8 + var22 * 10;
                if (var2 + var15 >= this.field_1718.length) {
                    this.resizeContents(var15);
                }
                var46 = this.constantPool.method_2459(AttributeNamesConstants.field_14);
                this.field_1718[var2++] = (byte)(var46 >> 8);
                this.field_1718[var2++] = (byte)var46;
                var23 = var22 * 10 + 2;
                this.field_1718[var2++] = (byte)(var23 >> 24);
                this.field_1718[var2++] = (byte)(var23 >> 16);
                this.field_1718[var2++] = (byte)(var23 >> 8);
                this.field_1718[var2++] = (byte)var23;
                this.field_1718[var2++] = (byte)(var22 >> 8);
                this.field_1718[var2++] = (byte)var22;
                if (var47) {
                    this.field_1718[var2++] = 0;
                    this.field_1718[var2++] = 0;
                    this.field_1718[var2++] = (byte)(var3 >> 8);
                    this.field_1718[var2++] = (byte)var3;
                    var17 = this.constantPool.method_2459(ConstantPool.field_1493);
                    this.field_1718[var2++] = (byte)(var17 >> 8);
                    this.field_1718[var2++] = (byte)var17;
                    var42 = this.constantPool.method_2459(var40.genericTypeSignature());
                    this.field_1718[var2++] = (byte)(var42 >> 8);
                    this.field_1718[var2++] = (byte)var42;
                    this.field_1718[var2++] = 0;
                    this.field_1718[var2++] = 0;
                }
                for (var51 = 0; var51 < var20; ++var51) {
                    LocalVariableBinding var52 = var21[var51];
                    for (var28 = 0; var28 < var52.field_311; ++var28) {
                        var29 = var52.initializationPCs[var28 << 1];
                        var30 = var52.initializationPCs[(var28 << 1) + 1];
                        if (var29 != var30) {
                            this.field_1718[var2++] = (byte)(var29 >> 8);
                            this.field_1718[var2++] = (byte)var29;
                            var31 = var30 - var29;
                            this.field_1718[var2++] = (byte)(var31 >> 8);
                            this.field_1718[var2++] = (byte)var31;
                            var17 = this.constantPool.method_2459(var52.name);
                            this.field_1718[var2++] = (byte)(var17 >> 8);
                            this.field_1718[var2++] = (byte)var17;
                            var42 = this.constantPool.method_2459(var52.type.genericTypeSignature());
                            this.field_1718[var2++] = (byte)(var42 >> 8);
                            this.field_1718[var2++] = (byte)var42;
                            var32 = var52.field_306;
                            this.field_1718[var2++] = (byte)(var32 >> 8);
                            this.field_1718[var2++] = (byte)var32;
                        }
                    }
                }
                ++var11;
            }
        }
        ArrayList var38;
        StackMapFrameCodeStream var37;
        StackMapFrame var43;
        ArrayList var10000;
        int var45;
        int var49;
        if (var6) {
            var37 = (StackMapFrameCodeStream)this.codeStream;
            var37.method_2392(var3);
            if (var37.hasFramePositions()) {
                var10000 = new ArrayList();
                var38 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var5, this.field_1718, var1 + 14, var3, var38, false);
                var14 = var38.size();
                if (var14 > 1) {
                    var15 = var2;
                    if (var2 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_21);
                    this.field_1718[var2++] = (byte)(var16 >> 8);
                    this.field_1718[var2++] = (byte)var16;
                    var17 = var2;
                    var2 += 4;
                    if (var2 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var42 = var2;
                    var2 += 2;
                    if (var2 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var43 = (StackMapFrame)var38.get(0);
                    StackMapFrame var44 = null;
                    label458:
                    for (var45 = 1; var45 < var14; ++var45) {
                        var44 = var43;
                        var43 = (StackMapFrame)var38.get(var45);
                        var22 = var43.method_2896(var44);
                        byte var48;
                        VerificationTypeInfo var53;
                        switch (var43.method_2890(var44)) {
                            case 0:
                                if (var2 + 1 >= this.field_1718.length) {
                                    this.resizeContents(1);
                                }
                                this.field_1718[var2++] = (byte)var22;
                                break;
                            case 1:
                                if (var2 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var23 = -var43.method_2894(var44);
                                this.field_1718[var2++] = (byte)(251 - var23);
                                this.field_1718[var2++] = (byte)(var22 >> 8);
                                this.field_1718[var2++] = (byte)var22;
                                break;
                            case 2:
                                if (var2 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var23 = var43.method_2894(var44);
                                this.field_1718[var2++] = (byte)(251 + var23);
                                this.field_1718[var2++] = (byte)(var22 >> 8);
                                this.field_1718[var2++] = (byte)var22;
                                var24 = var43.getIndexOfDifferentLocals(var23);
                                var46 = var43.getNumberOfLocals();
                                var51 = var24;
                                while (true) {
                                    if (var51 >= var43.field_1645.length || var23 <= 0) {
                                        continue label458;
                                    }
                                    if (var2 + 6 >= this.field_1718.length) {
                                        this.resizeContents(6);
                                    }
                                    VerificationTypeInfo var50 = var43.field_1645[var51];
                                    if (var50 == null) {
                                        this.field_1718[var2++] = 0;
                                    } else {
                                        label351:
                                        switch (var50.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var2++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var2++] = (byte)var50.field_336;
                                                switch (var50.field_336) {
                                                    case 7:
                                                        var29 = this.constantPool.method_2466(var50.method_475());
                                                        this.field_1718[var2++] = (byte)(var29 >> 8);
                                                        this.field_1718[var2++] = (byte)var29;
                                                        break label351;
                                                    case 8:
                                                        var28 = var50.field_339;
                                                        this.field_1718[var2++] = (byte)(var28 >> 8);
                                                        this.field_1718[var2++] = (byte)var28;
                                                    default:
                                                        break label351;
                                                }
                                            case 7:
                                                this.field_1718[var2++] = 4;
                                                ++var51;
                                                break;
                                            case 8:
                                                this.field_1718[var2++] = 3;
                                                ++var51;
                                                break;
                                            case 9:
                                                this.field_1718[var2++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var2++] = 5;
                                        }
                                        --var23;
                                    }
                                    ++var51;
                                }
                            case 3:
                                if (var2 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                this.field_1718[var2++] = -5;
                                this.field_1718[var2++] = (byte)(var22 >> 8);
                                this.field_1718[var2++] = (byte)var22;
                                break;
                            case 4:
                            default:
                                if (var2 + 5 >= this.field_1718.length) {
                                    this.resizeContents(5);
                                }
                                this.field_1718[var2++] = -1;
                                this.field_1718[var2++] = (byte)(var22 >> 8);
                                this.field_1718[var2++] = (byte)var22;
                                var51 = var2;
                                var2 += 2;
                                var49 = 0;
                                var46 = var43.getNumberOfLocals();
                                var28 = 0;
                                var29 = var43.field_1645 == null ? 0 : var43.field_1645.length;
                                int var33;
                                for (var30 = 0; var30 < var29 && var49 < var46; ++var30) {
                                    if (var2 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var57 = var43.field_1645[var30];
                                    if (var57 == null) {
                                        this.field_1718[var2++] = 0;
                                    } else {
                                        label318:
                                        switch (var57.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var2++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var2++] = (byte)var57.field_336;
                                                switch (var57.field_336) {
                                                    case 7:
                                                        var33 = this.constantPool.method_2466(var57.method_475());
                                                        this.field_1718[var2++] = (byte)(var33 >> 8);
                                                        this.field_1718[var2++] = (byte)var33;
                                                        break label318;
                                                    case 8:
                                                        var32 = var57.field_339;
                                                        this.field_1718[var2++] = (byte)(var32 >> 8);
                                                        this.field_1718[var2++] = (byte)var32;
                                                    default:
                                                        break label318;
                                                }
                                            case 7:
                                                this.field_1718[var2++] = 4;
                                                ++var30;
                                                break;
                                            case 8:
                                                this.field_1718[var2++] = 3;
                                                ++var30;
                                                break;
                                            case 9:
                                                this.field_1718[var2++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var2++] = 5;
                                        }
                                        ++var49;
                                    }
                                    ++var28;
                                }
                                if (var2 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var51++] = (byte)(var28 >> 8);
                                this.field_1718[var51] = (byte)var28;
                                var30 = var43.field_1643;
                                this.field_1718[var2++] = (byte)(var30 >> 8);
                                this.field_1718[var2++] = (byte)var30;
                                var31 = 0;
                                while (true) {
                                    if (var31 >= var30) {
                                        continue label458;
                                    }
                                    if (var2 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var56 = var43.field_1646[var31];
                                    if (var56 == null) {
                                        this.field_1718[var2++] = 0;
                                    } else {
                                        label308:
                                        switch (var56.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var2++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var2++] = (byte)var56.field_336;
                                                switch (var56.field_336) {
                                                    case 7:
                                                        int var34 = this.constantPool.method_2466(var56.method_475());
                                                        this.field_1718[var2++] = (byte)(var34 >> 8);
                                                        this.field_1718[var2++] = (byte)var34;
                                                        break label308;
                                                    case 8:
                                                        var33 = var56.field_339;
                                                        this.field_1718[var2++] = (byte)(var33 >> 8);
                                                        this.field_1718[var2++] = (byte)var33;
                                                    default:
                                                        break label308;
                                                }
                                            case 7:
                                                this.field_1718[var2++] = 4;
                                                break;
                                            case 8:
                                                this.field_1718[var2++] = 3;
                                                break;
                                            case 9:
                                                this.field_1718[var2++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var2++] = 5;
                                        }
                                    }
                                    ++var31;
                                }
                            case 5:
                                if (var2 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var2++] = (byte)(var22 + 64);
                                if (var43.field_1646[0] == null) {
                                    this.field_1718[var2++] = 0;
                                } else {
                                    switch (var43.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var2++] = 1;
                                            continue;
                                        case 6:
                                        case 11:
                                        default:
                                            var53 = var43.field_1646[0];
                                            var48 = (byte)var53.field_336;
                                            this.field_1718[var2++] = var48;
                                            switch (var48) {
                                                case 7:
                                                    var29 = this.constantPool.method_2466(var53.method_475());
                                                    this.field_1718[var2++] = (byte)(var29 >> 8);
                                                    this.field_1718[var2++] = (byte)var29;
                                                    continue;
                                                case 8:
                                                    var28 = var53.field_339;
                                                    this.field_1718[var2++] = (byte)(var28 >> 8);
                                                    this.field_1718[var2++] = (byte)var28;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var2++] = 4;
                                            continue;
                                        case 8:
                                            this.field_1718[var2++] = 3;
                                            continue;
                                        case 9:
                                            this.field_1718[var2++] = 2;
                                            continue;
                                        case 12:
                                            this.field_1718[var2++] = 5;
                                    }
                                }
                                break;
                            case 6:
                                if (var2 + 6 >= this.field_1718.length) {
                                    this.resizeContents(6);
                                }
                                this.field_1718[var2++] = -9;
                                this.field_1718[var2++] = (byte)(var22 >> 8);
                                this.field_1718[var2++] = (byte)var22;
                                if (var43.field_1646[0] == null) {
                                    this.field_1718[var2++] = 0;
                                } else {
                                    switch (var43.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var2++] = 1;
                                            break;
                                        case 6:
                                        case 11:
                                        default:
                                            var53 = var43.field_1646[0];
                                            var48 = (byte)var53.field_336;
                                            this.field_1718[var2++] = var48;
                                            switch (var48) {
                                                case 7:
                                                    var29 = this.constantPool.method_2466(var53.method_475());
                                                    this.field_1718[var2++] = (byte)(var29 >> 8);
                                                    this.field_1718[var2++] = (byte)var29;
                                                    continue;
                                                case 8:
                                                    var28 = var53.field_339;
                                                    this.field_1718[var2++] = (byte)(var28 >> 8);
                                                    this.field_1718[var2++] = (byte)var28;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var2++] = 4;
                                            break;
                                        case 8:
                                            this.field_1718[var2++] = 3;
                                            break;
                                        case 9:
                                            this.field_1718[var2++] = 2;
                                            break;
                                        case 12:
                                            this.field_1718[var2++] = 5;
                                    }
                                }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var42++] = (byte)(var14 >> 8);
                        this.field_1718[var42] = (byte)var14;
                        var45 = var2 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var45 >> 24);
                        this.field_1718[var17++] = (byte)(var45 >> 16);
                        this.field_1718[var17++] = (byte)(var45 >> 8);
                        this.field_1718[var17] = (byte)var45;
                        ++var11;
                    } else {
                        var2 = var15;
                    }
                }
            }
        }
        if ((this.field_1728 & 16) != 0) {
            var37 = (StackMapFrameCodeStream)this.codeStream;
            var37.method_2392(var3);
            if (var37.hasFramePositions()) {
                var10000 = new ArrayList();
                var38 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var5, this.field_1718, var1 + 14, var3, var38, false);
                var14 = var38.size();
                if (var14 > 1) {
                    var15 = var2;
                    if (var2 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_24);
                    this.field_1718[var2++] = (byte)(var16 >> 8);
                    this.field_1718[var2++] = (byte)var16;
                    var17 = var2;
                    var2 += 4;
                    if (var2 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var42 = var2;
                    var2 += 2;
                    if (var2 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var43 = (StackMapFrame)var38.get(0);
                    for (var20 = 1; var20 < var14; ++var20) {
                        var43 = (StackMapFrame)var38.get(var20);
                        var45 = var43.field_1642;
                        if (var2 + 5 >= this.field_1718.length) {
                            this.resizeContents(5);
                        }
                        this.field_1718[var2++] = (byte)(var45 >> 8);
                        this.field_1718[var2++] = (byte)var45;
                        var22 = var2;
                        var2 += 2;
                        var23 = 0;
                        var24 = var43.getNumberOfLocals();
                        var46 = 0;
                        var51 = var43.field_1645 == null ? 0 : var43.field_1645.length;
                        for (var49 = 0; var49 < var51 && var23 < var24; ++var49) {
                            if (var2 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var55 = var43.field_1645[var49];
                            if (var55 == null) {
                                this.field_1718[var2++] = 0;
                            } else {
                                label288:
                                switch (var55.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var2++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var2++] = (byte)var55.field_336;
                                        switch (var55.field_336) {
                                            case 7:
                                                var30 = this.constantPool.method_2466(var55.method_475());
                                                this.field_1718[var2++] = (byte)(var30 >> 8);
                                                this.field_1718[var2++] = (byte)var30;
                                                break label288;
                                            case 8:
                                                var29 = var55.field_339;
                                                this.field_1718[var2++] = (byte)(var29 >> 8);
                                                this.field_1718[var2++] = (byte)var29;
                                            default:
                                                break label288;
                                        }
                                    case 7:
                                        this.field_1718[var2++] = 4;
                                        ++var49;
                                        break;
                                    case 8:
                                        this.field_1718[var2++] = 3;
                                        ++var49;
                                        break;
                                    case 9:
                                        this.field_1718[var2++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var2++] = 5;
                                }
                                ++var23;
                            }
                            ++var46;
                        }
                        if (var2 + 4 >= this.field_1718.length) {
                            this.resizeContents(4);
                        }
                        this.field_1718[var22++] = (byte)(var46 >> 8);
                        this.field_1718[var22] = (byte)var46;
                        var49 = var43.field_1643;
                        this.field_1718[var2++] = (byte)(var49 >> 8);
                        this.field_1718[var2++] = (byte)var49;
                        for (var28 = 0; var28 < var49; ++var28) {
                            if (var2 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var54 = var43.field_1646[var28];
                            if (var54 == null) {
                                this.field_1718[var2++] = 0;
                            } else {
                                switch (var54.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var2++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var2++] = (byte)var54.field_336;
                                        switch (var54.field_336) {
                                            case 7:
                                                var31 = this.constantPool.method_2466(var54.method_475());
                                                this.field_1718[var2++] = (byte)(var31 >> 8);
                                                this.field_1718[var2++] = (byte)var31;
                                                continue;
                                            case 8:
                                                var30 = var54.field_339;
                                                this.field_1718[var2++] = (byte)(var30 >> 8);
                                                this.field_1718[var2++] = (byte)var30;
                                            default:
                                                continue;
                                        }
                                    case 7:
                                        this.field_1718[var2++] = 4;
                                        break;
                                    case 8:
                                        this.field_1718[var2++] = 3;
                                        break;
                                    case 9:
                                        this.field_1718[var2++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var2++] = 5;
                                }
                            }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var42++] = (byte)(var14 >> 8);
                        this.field_1718[var42] = (byte)var14;
                        var20 = var2 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var20 >> 24);
                        this.field_1718[var17++] = (byte)(var20 >> 16);
                        this.field_1718[var17++] = (byte)(var20 >> 8);
                        this.field_1718[var17] = (byte)var20;
                        ++var11;
                    } else {
                        var2 = var15;
                    }
                }
            }
        }
        this.field_1718[var10++] = (byte)(var11 >> 8);
        this.field_1718[var10] = (byte)var11;
        var36 = var2 - (var1 + 6);
        this.field_1718[var1 + 2] = (byte)(var36 >> 24);
        this.field_1718[var1 + 3] = (byte)(var36 >> 16);
        this.field_1718[var1 + 4] = (byte)(var36 >> 8);
        this.field_1718[var1 + 5] = (byte)var36;
        this.field_1719 = var2;
    }

    public void method_2980(int var1) {
        this.field_1718 = this.codeStream.bCodeStream;
        int var2 = this.codeStream.field_1190;
        int var3 = this.codeStream.field_1208;
        if (var3 > '\uffff') {
            this.codeStream.methodDeclaration.scope.problemReporter().method_1489(this.codeStream.methodDeclaration.scope.referenceType());
        }
        if (var2 + 20 >= this.field_1718.length) {
            this.resizeContents(20);
        }
        int var4 = this.codeStream.field_1211;
        this.field_1718[var1 + 6] = (byte)(var4 >> 8);
        this.field_1718[var1 + 7] = (byte)var4;
        int var5 = this.codeStream.field_1204;
        this.field_1718[var1 + 8] = (byte)(var5 >> 8);
        this.field_1718[var1 + 9] = (byte)var5;
        this.field_1718[var1 + 10] = (byte)(var3 >> 24);
        this.field_1718[var1 + 11] = (byte)(var3 >> 16);
        this.field_1718[var1 + 12] = (byte)(var3 >> 8);
        this.field_1718[var1 + 13] = (byte)var3;
        boolean var6 = (this.field_1728 & 8) != 0;
        ExceptionLabel[] var7 = this.codeStream.exceptionLabels;
        int var8 = 0;
        int var9 = 0;
        int var10;
        for (var10 = this.codeStream.field_1194; var9 < var10; ++var9) {
            var8 += this.codeStream.exceptionLabels[var9].count / 2;
        }
        var9 = var8 * 8 + 2;
        if (var9 + var2 >= this.field_1718.length) {
            this.resizeContents(var9);
        }
        this.field_1718[var2++] = (byte)(var8 >> 8);
        this.field_1718[var2++] = (byte)var8;
        var10 = 0;
        int var11;
        int var13;
        int var14;
        int var15;
        int var17;
        int var16;
        int var39;
        for (var11 = this.codeStream.field_1194; var10 < var11; ++var10) {
            ExceptionLabel var12 = var7[var10];
            if (var12 != null) {
                var13 = 0;
                var14 = var12.count;
                if ((var14 & 1) != 0) {
                    this.codeStream.methodDeclaration.scope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1878, new String(this.codeStream.methodDeclaration.selector)), this.codeStream.methodDeclaration);
                }
                while (var13 < var14) {
                    var15 = var12.ranges[var13++];
                    this.field_1718[var2++] = (byte)(var15 >> 8);
                    this.field_1718[var2++] = (byte)var15;
                    var16 = var12.ranges[var13++];
                    this.field_1718[var2++] = (byte)(var16 >> 8);
                    this.field_1718[var2++] = (byte)var16;
                    var17 = var12.position;
                    this.field_1718[var2++] = (byte)(var17 >> 8);
                    this.field_1718[var2++] = (byte)var17;
                    if (var6) {
                        StackMapFrameCodeStream var18 = (StackMapFrameCodeStream)this.codeStream;
                        var18.method_2391(var17);
                    }
                    if (var12.exceptionType == null) {
                        this.field_1718[var2++] = 0;
                        this.field_1718[var2++] = 0;
                    } else {
                        if (var12.exceptionType == TypeBinding.field_187) {
                            var39 = this.constantPool.method_2466(ConstantPool.field_1411);
                        } else {
                            var39 = this.constantPool.method_2467(var12.exceptionType);
                        }
                        this.field_1718[var2++] = (byte)(var39 >> 8);
                        this.field_1718[var2++] = (byte)var39;
                    }
                }
            }
        }
        var10 = var2;
        var11 = 0;
        var2 += 2;
        if (var2 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        int var19;
        if ((this.field_1728 & 2) != 0) {
            int[] var35 = this.codeStream.field_1206;
            if (this.codeStream.field_1206 != null && this.codeStream.field_1207 != 0) {
                var13 = this.constantPool.method_2459(AttributeNamesConstants.field_6);
                if (var2 + 8 >= this.field_1718.length) {
                    this.resizeContents(8);
                }
                this.field_1718[var2++] = (byte)(var13 >> 8);
                this.field_1718[var2++] = (byte)var13;
                var14 = var2;
                var2 += 6;
                var15 = 0;
                var16 = this.codeStream.field_1207;
                for (var17 = 0; var17 < var16; ++var15) {
                    if (var2 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var39 = var35[var17++];
                    this.field_1718[var2++] = (byte)(var39 >> 8);
                    this.field_1718[var2++] = (byte)var39;
                    var19 = var35[var17++];
                    this.field_1718[var2++] = (byte)(var19 >> 8);
                    this.field_1718[var2++] = (byte)var19;
                }
                var17 = var15 * 4 + 2;
                this.field_1718[var14++] = (byte)(var17 >> 24);
                this.field_1718[var14++] = (byte)(var17 >> 16);
                this.field_1718[var14++] = (byte)(var17 >> 8);
                this.field_1718[var14++] = (byte)var17;
                this.field_1718[var14++] = (byte)(var15 >> 8);
                this.field_1718[var14++] = (byte)var15;
                ++var11;
            }
        }
        int var21;
        int var20;
        int var25;
        int var27;
        int var26;
        int var29;
        int var28;
        int var36;
        int var42;
        int var43;
        if ((this.field_1728 & 4) != 0) {
            var36 = 0;
            if (this.codeStream.field_1206 != null && this.codeStream.field_1207 != 0) {
                var13 = this.constantPool.method_2459(AttributeNamesConstants.field_7);
                if (var2 + 8 >= this.field_1718.length) {
                    this.resizeContents(8);
                }
                this.field_1718[var2++] = (byte)(var13 >> 8);
                this.field_1718[var2++] = (byte)var13;
                var14 = var2;
                var2 += 6;
                var17 = 0;
                LocalVariableBinding[] var41 = null;
                var19 = 0;
                var20 = 0;
                for (var21 = this.codeStream.field_1187; var20 < var21; ++var20) {
                    LocalVariableBinding var22 = this.codeStream.field_1202[var20];
                    if (var22.declaration != null) {
                        TypeBinding var23 = var22.type;
                        boolean var24 = var23.method_162() || var23.method_169();
                        if (var22.field_311 != 0 && var24) {
                            if (var41 == null) {
                                var41 = new LocalVariableBinding[var21];
                            }
                            var41[var17++] = var22;
                        }
                        for (var25 = 0; var25 < var22.field_311; ++var25) {
                            var26 = var22.initializationPCs[var25 << 1];
                            var27 = var22.initializationPCs[(var25 << 1) + 1];
                            if (var26 != var27) {
                                if (var27 == -1) {
                                    var22.declaringScope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1877, new String(var22.name)), (ASTNode)var22.declaringScope.method_635().referenceContext);
                                }
                                if (var2 + 10 >= this.field_1718.length) {
                                    this.resizeContents(10);
                                }
                                ++var36;
                                if (var24) {
                                    ++var19;
                                }
                                this.field_1718[var2++] = (byte)(var26 >> 8);
                                this.field_1718[var2++] = (byte)var26;
                                var28 = var27 - var26;
                                this.field_1718[var2++] = (byte)(var28 >> 8);
                                this.field_1718[var2++] = (byte)var28;
                                var15 = this.constantPool.method_2459(var22.name);
                                this.field_1718[var2++] = (byte)(var15 >> 8);
                                this.field_1718[var2++] = (byte)var15;
                                var16 = this.constantPool.method_2459(var23.method_178());
                                this.field_1718[var2++] = (byte)(var16 >> 8);
                                this.field_1718[var2++] = (byte)var16;
                                var29 = var22.field_306;
                                this.field_1718[var2++] = (byte)(var29 >> 8);
                                this.field_1718[var2++] = (byte)var29;
                            }
                        }
                    }
                }
                var20 = var36 * 10 + 2;
                this.field_1718[var14++] = (byte)(var20 >> 24);
                this.field_1718[var14++] = (byte)(var20 >> 16);
                this.field_1718[var14++] = (byte)(var20 >> 8);
                this.field_1718[var14++] = (byte)var20;
                this.field_1718[var14++] = (byte)(var36 >> 8);
                this.field_1718[var14] = (byte)var36;
                ++var11;
                if (var17 != 0) {
                    var21 = 8 + var19 * 10;
                    if (var2 + var21 >= this.field_1718.length) {
                        this.resizeContents(var21);
                    }
                    var42 = this.constantPool.method_2459(AttributeNamesConstants.field_14);
                    this.field_1718[var2++] = (byte)(var42 >> 8);
                    this.field_1718[var2++] = (byte)var42;
                    var20 = var19 * 10 + 2;
                    this.field_1718[var2++] = (byte)(var20 >> 24);
                    this.field_1718[var2++] = (byte)(var20 >> 16);
                    this.field_1718[var2++] = (byte)(var20 >> 8);
                    this.field_1718[var2++] = (byte)var20;
                    this.field_1718[var2++] = (byte)(var19 >> 8);
                    this.field_1718[var2++] = (byte)var19;
                    for (var43 = 0; var43 < var17; ++var43) {
                        LocalVariableBinding var45 = var41[var43];
                        for (var25 = 0; var25 < var45.field_311; ++var25) {
                            var26 = var45.initializationPCs[var25 << 1];
                            var27 = var45.initializationPCs[(var25 << 1) + 1];
                            if (var26 != var27) {
                                this.field_1718[var2++] = (byte)(var26 >> 8);
                                this.field_1718[var2++] = (byte)var26;
                                var28 = var27 - var26;
                                this.field_1718[var2++] = (byte)(var28 >> 8);
                                this.field_1718[var2++] = (byte)var28;
                                var15 = this.constantPool.method_2459(var45.name);
                                this.field_1718[var2++] = (byte)(var15 >> 8);
                                this.field_1718[var2++] = (byte)var15;
                                var16 = this.constantPool.method_2459(var45.type.genericTypeSignature());
                                this.field_1718[var2++] = (byte)(var16 >> 8);
                                this.field_1718[var2++] = (byte)var16;
                                var29 = var45.field_306;
                                this.field_1718[var2++] = (byte)(var29 >> 8);
                                this.field_1718[var2++] = (byte)var29;
                            }
                        }
                    }
                    ++var11;
                }
            }
        }
        int var30;
        ArrayList var38;
        StackMapFrameCodeStream var37;
        StackMapFrame var40;
        int var46;
        ArrayList var10000;
        int var51;
        if ((this.field_1728 & 8) != 0) {
            var37 = (StackMapFrameCodeStream)this.codeStream;
            var37.method_2392(var3);
            if (var37.hasFramePositions()) {
                var10000 = new ArrayList();
                var38 = var10000;
                this.method_3018((MethodBinding)null, var5, this.field_1718, var1 + 14, var3, var38, true);
                var14 = var38.size();
                if (var14 > 1) {
                    var15 = var2;
                    if (var2 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_21);
                    this.field_1718[var2++] = (byte)(var16 >> 8);
                    this.field_1718[var2++] = (byte)var16;
                    var17 = var2;
                    var2 += 4;
                    if (var2 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var39 = var2;
                    var2 += 2;
                    if (var2 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var40 = (StackMapFrame)var38.get(0);
                    StackMapFrame var44 = null;
                    label441:
                    for (var21 = 1; var21 < var14; ++var21) {
                        var44 = var40;
                        var40 = (StackMapFrame)var38.get(var21);
                        var42 = var40.method_2896(var44);
                        byte var47;
                        VerificationTypeInfo var49;
                        switch (var40.method_2890(var44)) {
                            case 0:
                                if (var2 + 1 >= this.field_1718.length) {
                                    this.resizeContents(1);
                                }
                                this.field_1718[var2++] = (byte)var42;
                                break;
                            case 1:
                                if (var2 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var43 = -var40.method_2894(var44);
                                this.field_1718[var2++] = (byte)(251 - var43);
                                this.field_1718[var2++] = (byte)(var42 >> 8);
                                this.field_1718[var2++] = (byte)var42;
                                break;
                            case 2:
                                if (var2 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var43 = var40.method_2894(var44);
                                this.field_1718[var2++] = (byte)(251 + var43);
                                this.field_1718[var2++] = (byte)(var42 >> 8);
                                this.field_1718[var2++] = (byte)var42;
                                var46 = var40.getIndexOfDifferentLocals(var43);
                                var25 = var40.getNumberOfLocals();
                                var26 = var46;
                                while (true) {
                                    if (var26 >= var40.field_1645.length || var43 <= 0) {
                                        continue label441;
                                    }
                                    if (var2 + 6 >= this.field_1718.length) {
                                        this.resizeContents(6);
                                    }
                                    VerificationTypeInfo var48 = var40.field_1645[var26];
                                    if (var48 == null) {
                                        this.field_1718[var2++] = 0;
                                    } else {
                                        label340:
                                        switch (var48.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var2++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var2++] = (byte)var48.field_336;
                                                switch (var48.field_336) {
                                                    case 7:
                                                        var29 = this.constantPool.method_2466(var48.method_475());
                                                        this.field_1718[var2++] = (byte)(var29 >> 8);
                                                        this.field_1718[var2++] = (byte)var29;
                                                        break label340;
                                                    case 8:
                                                        var28 = var48.field_339;
                                                        this.field_1718[var2++] = (byte)(var28 >> 8);
                                                        this.field_1718[var2++] = (byte)var28;
                                                    default:
                                                        break label340;
                                                }
                                            case 7:
                                                this.field_1718[var2++] = 4;
                                                ++var26;
                                                break;
                                            case 8:
                                                this.field_1718[var2++] = 3;
                                                ++var26;
                                                break;
                                            case 9:
                                                this.field_1718[var2++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var2++] = 5;
                                        }
                                        --var43;
                                    }
                                    ++var26;
                                }
                            case 3:
                                if (var2 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                this.field_1718[var2++] = -5;
                                this.field_1718[var2++] = (byte)(var42 >> 8);
                                this.field_1718[var2++] = (byte)var42;
                                break;
                            case 4:
                            default:
                                if (var2 + 5 >= this.field_1718.length) {
                                    this.resizeContents(5);
                                }
                                this.field_1718[var2++] = -1;
                                this.field_1718[var2++] = (byte)(var42 >> 8);
                                this.field_1718[var2++] = (byte)var42;
                                var26 = var2;
                                var2 += 2;
                                var27 = 0;
                                var25 = var40.getNumberOfLocals();
                                var28 = 0;
                                var29 = var40.field_1645 == null ? 0 : var40.field_1645.length;
                                int var33;
                                for (var30 = 0; var30 < var29 && var27 < var25; ++var30) {
                                    if (var2 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var31 = var40.field_1645[var30];
                                    if (var31 == null) {
                                        this.field_1718[var2++] = 0;
                                    } else {
                                        label307:
                                        switch (var31.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var2++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var2++] = (byte)var31.field_336;
                                                switch (var31.field_336) {
                                                    case 7:
                                                        var33 = this.constantPool.method_2466(var31.method_475());
                                                        this.field_1718[var2++] = (byte)(var33 >> 8);
                                                        this.field_1718[var2++] = (byte)var33;
                                                        break label307;
                                                    case 8:
                                                        int var32 = var31.field_339;
                                                        this.field_1718[var2++] = (byte)(var32 >> 8);
                                                        this.field_1718[var2++] = (byte)var32;
                                                    default:
                                                        break label307;
                                                }
                                            case 7:
                                                this.field_1718[var2++] = 4;
                                                ++var30;
                                                break;
                                            case 8:
                                                this.field_1718[var2++] = 3;
                                                ++var30;
                                                break;
                                            case 9:
                                                this.field_1718[var2++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var2++] = 5;
                                        }
                                        ++var27;
                                    }
                                    ++var28;
                                }
                                if (var2 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var26++] = (byte)(var28 >> 8);
                                this.field_1718[var26] = (byte)var28;
                                var30 = var40.field_1643;
                                this.field_1718[var2++] = (byte)(var30 >> 8);
                                this.field_1718[var2++] = (byte)var30;
                                var51 = 0;
                                while (true) {
                                    if (var51 >= var30) {
                                        continue label441;
                                    }
                                    if (var2 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var53 = var40.field_1646[var51];
                                    if (var53 == null) {
                                        this.field_1718[var2++] = 0;
                                    } else {
                                        label297:
                                        switch (var53.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var2++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var2++] = (byte)var53.field_336;
                                                switch (var53.field_336) {
                                                    case 7:
                                                        int var34 = this.constantPool.method_2466(var53.method_475());
                                                        this.field_1718[var2++] = (byte)(var34 >> 8);
                                                        this.field_1718[var2++] = (byte)var34;
                                                        break label297;
                                                    case 8:
                                                        var33 = var53.field_339;
                                                        this.field_1718[var2++] = (byte)(var33 >> 8);
                                                        this.field_1718[var2++] = (byte)var33;
                                                    default:
                                                        break label297;
                                                }
                                            case 7:
                                                this.field_1718[var2++] = 4;
                                                break;
                                            case 8:
                                                this.field_1718[var2++] = 3;
                                                break;
                                            case 9:
                                                this.field_1718[var2++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var2++] = 5;
                                        }
                                    }
                                    ++var51;
                                }
                            case 5:
                                if (var2 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var2++] = (byte)(var42 + 64);
                                if (var40.field_1646[0] == null) {
                                    this.field_1718[var2++] = 0;
                                } else {
                                    switch (var40.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var2++] = 1;
                                            continue;
                                        case 6:
                                        case 11:
                                        default:
                                            var49 = var40.field_1646[0];
                                            var47 = (byte)var49.field_336;
                                            this.field_1718[var2++] = var47;
                                            switch (var47) {
                                                case 7:
                                                    var29 = this.constantPool.method_2466(var49.method_475());
                                                    this.field_1718[var2++] = (byte)(var29 >> 8);
                                                    this.field_1718[var2++] = (byte)var29;
                                                    continue;
                                                case 8:
                                                    var28 = var49.field_339;
                                                    this.field_1718[var2++] = (byte)(var28 >> 8);
                                                    this.field_1718[var2++] = (byte)var28;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var2++] = 4;
                                            continue;
                                        case 8:
                                            this.field_1718[var2++] = 3;
                                            continue;
                                        case 9:
                                            this.field_1718[var2++] = 2;
                                            continue;
                                        case 12:
                                            this.field_1718[var2++] = 5;
                                    }
                                }
                                break;
                            case 6:
                                if (var2 + 6 >= this.field_1718.length) {
                                    this.resizeContents(6);
                                }
                                this.field_1718[var2++] = -9;
                                this.field_1718[var2++] = (byte)(var42 >> 8);
                                this.field_1718[var2++] = (byte)var42;
                                if (var40.field_1646[0] == null) {
                                    this.field_1718[var2++] = 0;
                                } else {
                                    switch (var40.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var2++] = 1;
                                            break;
                                        case 6:
                                        case 11:
                                        default:
                                            var49 = var40.field_1646[0];
                                            var47 = (byte)var49.field_336;
                                            this.field_1718[var2++] = var47;
                                            switch (var47) {
                                                case 7:
                                                    var29 = this.constantPool.method_2466(var49.method_475());
                                                    this.field_1718[var2++] = (byte)(var29 >> 8);
                                                    this.field_1718[var2++] = (byte)var29;
                                                    continue;
                                                case 8:
                                                    var28 = var49.field_339;
                                                    this.field_1718[var2++] = (byte)(var28 >> 8);
                                                    this.field_1718[var2++] = (byte)var28;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var2++] = 4;
                                            break;
                                        case 8:
                                            this.field_1718[var2++] = 3;
                                            break;
                                        case 9:
                                            this.field_1718[var2++] = 2;
                                            break;
                                        case 12:
                                            this.field_1718[var2++] = 5;
                                    }
                                }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var39++] = (byte)(var14 >> 8);
                        this.field_1718[var39] = (byte)var14;
                        var21 = var2 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var21 >> 24);
                        this.field_1718[var17++] = (byte)(var21 >> 16);
                        this.field_1718[var17++] = (byte)(var21 >> 8);
                        this.field_1718[var17] = (byte)var21;
                        ++var11;
                    } else {
                        var2 = var15;
                    }
                }
            }
        }
        if ((this.field_1728 & 16) != 0) {
            var37 = (StackMapFrameCodeStream)this.codeStream;
            var37.method_2392(var3);
            if (var37.hasFramePositions()) {
                var10000 = new ArrayList();
                var38 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var5, this.field_1718, var1 + 14, var3, var38, false);
                var14 = var38.size();
                if (var14 > 1) {
                    var15 = var2;
                    if (var2 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_24);
                    this.field_1718[var2++] = (byte)(var16 >> 8);
                    this.field_1718[var2++] = (byte)var16;
                    var17 = var2;
                    var2 += 4;
                    if (var2 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var39 = var2;
                    var2 += 2;
                    if (var2 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var40 = (StackMapFrame)var38.get(0);
                    for (var20 = 1; var20 < var14; ++var20) {
                        var40 = (StackMapFrame)var38.get(var20);
                        var21 = var40.field_1642;
                        if (var2 + 5 >= this.field_1718.length) {
                            this.resizeContents(5);
                        }
                        this.field_1718[var2++] = (byte)(var21 >> 8);
                        this.field_1718[var2++] = (byte)var21;
                        var42 = var2;
                        var2 += 2;
                        var43 = 0;
                        var46 = var40.getNumberOfLocals();
                        var25 = 0;
                        var26 = var40.field_1645 == null ? 0 : var40.field_1645.length;
                        for (var27 = 0; var27 < var26 && var43 < var46; ++var27) {
                            if (var2 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var50 = var40.field_1645[var27];
                            if (var50 == null) {
                                this.field_1718[var2++] = 0;
                            } else {
                                label277:
                                switch (var50.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var2++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var2++] = (byte)var50.field_336;
                                        switch (var50.field_336) {
                                            case 7:
                                                var30 = this.constantPool.method_2466(var50.method_475());
                                                this.field_1718[var2++] = (byte)(var30 >> 8);
                                                this.field_1718[var2++] = (byte)var30;
                                                break label277;
                                            case 8:
                                                var29 = var50.field_339;
                                                this.field_1718[var2++] = (byte)(var29 >> 8);
                                                this.field_1718[var2++] = (byte)var29;
                                            default:
                                                break label277;
                                        }
                                    case 7:
                                        this.field_1718[var2++] = 4;
                                        ++var27;
                                        break;
                                    case 8:
                                        this.field_1718[var2++] = 3;
                                        ++var27;
                                        break;
                                    case 9:
                                        this.field_1718[var2++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var2++] = 5;
                                }
                                ++var43;
                            }
                            ++var25;
                        }
                        if (var2 + 4 >= this.field_1718.length) {
                            this.resizeContents(4);
                        }
                        this.field_1718[var42++] = (byte)(var25 >> 8);
                        this.field_1718[var42] = (byte)var25;
                        var27 = var40.field_1643;
                        this.field_1718[var2++] = (byte)(var27 >> 8);
                        this.field_1718[var2++] = (byte)var27;
                        for (var28 = 0; var28 < var27; ++var28) {
                            if (var2 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var52 = var40.field_1646[var28];
                            if (var52 == null) {
                                this.field_1718[var2++] = 0;
                            } else {
                                switch (var52.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var2++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var2++] = (byte)var52.field_336;
                                        switch (var52.field_336) {
                                            case 7:
                                                var51 = this.constantPool.method_2466(var52.method_475());
                                                this.field_1718[var2++] = (byte)(var51 >> 8);
                                                this.field_1718[var2++] = (byte)var51;
                                                continue;
                                            case 8:
                                                var30 = var52.field_339;
                                                this.field_1718[var2++] = (byte)(var30 >> 8);
                                                this.field_1718[var2++] = (byte)var30;
                                            default:
                                                continue;
                                        }
                                    case 7:
                                        this.field_1718[var2++] = 4;
                                        break;
                                    case 8:
                                        this.field_1718[var2++] = 3;
                                        break;
                                    case 9:
                                        this.field_1718[var2++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var2++] = 5;
                                }
                            }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var39++] = (byte)(var14 >> 8);
                        this.field_1718[var39] = (byte)var14;
                        var20 = var2 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var20 >> 24);
                        this.field_1718[var17++] = (byte)(var20 >> 16);
                        this.field_1718[var17++] = (byte)(var20 >> 8);
                        this.field_1718[var17] = (byte)var20;
                        ++var11;
                    } else {
                        var2 = var15;
                    }
                }
            }
        }
        if (var10 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var10++] = (byte)(var11 >> 8);
        this.field_1718[var10] = (byte)var11;
        var36 = var2 - (var1 + 6);
        this.field_1718[var1 + 2] = (byte)(var36 >> 24);
        this.field_1718[var1 + 3] = (byte)(var36 >> 16);
        this.field_1718[var1 + 4] = (byte)(var36 >> 8);
        this.field_1718[var1 + 5] = (byte)var36;
        this.field_1719 = var2;
    }

    public void method_2981(int var1, int var2) {
        this.field_1718 = this.codeStream.bCodeStream;
        int var3 = this.codeStream.field_1190;
        int var4 = this.codeStream.field_1208;
        if (var4 > '\uffff') {
            this.codeStream.methodDeclaration.scope.problemReporter().method_1489(this.codeStream.methodDeclaration.scope.referenceType());
        }
        if (var3 + 20 >= this.field_1718.length) {
            this.resizeContents(20);
        }
        int var5 = this.codeStream.field_1211;
        this.field_1718[var1 + 6] = (byte)(var5 >> 8);
        this.field_1718[var1 + 7] = (byte)var5;
        int var6 = this.codeStream.field_1204;
        this.field_1718[var1 + 8] = (byte)(var6 >> 8);
        this.field_1718[var1 + 9] = (byte)var6;
        this.field_1718[var1 + 10] = (byte)(var4 >> 24);
        this.field_1718[var1 + 11] = (byte)(var4 >> 16);
        this.field_1718[var1 + 12] = (byte)(var4 >> 8);
        this.field_1718[var1 + 13] = (byte)var4;
        this.field_1718[var3++] = 0;
        this.field_1718[var3++] = 0;
        int var7 = var3;
        int var8 = 0;
        var3 += 2;
        if (var3 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        int var9;
        if ((this.field_1728 & 2) != 0) {
            if (var3 + 20 >= this.field_1718.length) {
                this.resizeContents(20);
            }
            var9 = this.constantPool.method_2459(AttributeNamesConstants.field_6);
            this.field_1718[var3++] = (byte)(var9 >> 8);
            this.field_1718[var3++] = (byte)var9;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 6;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 1;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = (byte)(var2 >> 8);
            this.field_1718[var3++] = (byte)var2;
            ++var8;
        }
        if ((this.field_1728 & 4) != 0) {
            var9 = this.constantPool.method_2459(AttributeNamesConstants.field_7);
            if (var3 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            this.field_1718[var3++] = (byte)(var9 >> 8);
            this.field_1718[var3++] = (byte)var9;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 2;
            this.field_1718[var3++] = 0;
            this.field_1718[var3++] = 0;
            ++var8;
        }
        ArrayList var10;
        int var11;
        int var12;
        int var13;
        int var14;
        int var15;
        StackMapFrame var16;
        int var19;
        int var18;
        int var21;
        int var20;
        int var22;
        int var25;
        int var27;
        int var26;
        int var34;
        int var35;
        StackMapFrameCodeStream var32;
        int var38;
        ArrayList var10000;
        if ((this.field_1728 & 8) != 0) {
            var32 = (StackMapFrameCodeStream)this.codeStream;
            var32.method_2392(var4);
            if (var32.hasFramePositions()) {
                var10000 = new ArrayList();
                var10 = var10000;
                this.method_3018((MethodBinding)null, var6, this.field_1718, var1 + 14, var4, var10, true);
                var11 = var10.size();
                if (var11 > 1) {
                    var12 = var3;
                    if (var3 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var13 = this.constantPool.method_2459(AttributeNamesConstants.field_21);
                    this.field_1718[var3++] = (byte)(var13 >> 8);
                    this.field_1718[var3++] = (byte)var13;
                    var14 = var3;
                    var3 += 4;
                    if (var3 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var11 = 0;
                    var15 = var3;
                    var3 += 2;
                    if (var3 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var16 = (StackMapFrame)var10.get(0);
                    StackMapFrame var17 = null;
                    label341:
                    for (var18 = 1; var18 < var11; ++var18) {
                        var17 = var16;
                        var16 = (StackMapFrame)var10.get(var18);
                        ++var11;
                        var19 = var16.method_2896(var17);
                        VerificationTypeInfo var23;
                        byte var24;
                        switch (var16.method_2890(var17)) {
                            case 0:
                                if (var3 + 1 >= this.field_1718.length) {
                                    this.resizeContents(1);
                                }
                                this.field_1718[var3++] = (byte)var19;
                                break;
                            case 1:
                                if (var3 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var20 = -var16.method_2894(var17);
                                this.field_1718[var3++] = (byte)(251 - var20);
                                this.field_1718[var3++] = (byte)(var19 >> 8);
                                this.field_1718[var3++] = (byte)var19;
                                break;
                            case 2:
                                if (var3 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var20 = var16.method_2894(var17);
                                this.field_1718[var3++] = (byte)(251 + var20);
                                this.field_1718[var3++] = (byte)(var19 >> 8);
                                this.field_1718[var3++] = (byte)var19;
                                var21 = var16.getIndexOfDifferentLocals(var20);
                                var22 = var16.getNumberOfLocals();
                                var35 = var21;
                                while (true) {
                                    if (var35 >= var16.field_1645.length || var20 <= 0) {
                                        continue label341;
                                    }
                                    if (var3 + 6 >= this.field_1718.length) {
                                        this.resizeContents(6);
                                    }
                                    VerificationTypeInfo var36 = var16.field_1645[var35];
                                    if (var36 == null) {
                                        this.field_1718[var3++] = 0;
                                    } else {
                                        label271:
                                        switch (var36.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var3++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var3++] = (byte)var36.field_336;
                                                switch (var36.field_336) {
                                                    case 7:
                                                        var26 = this.constantPool.method_2466(var36.method_475());
                                                        this.field_1718[var3++] = (byte)(var26 >> 8);
                                                        this.field_1718[var3++] = (byte)var26;
                                                        break label271;
                                                    case 8:
                                                        var25 = var36.field_339;
                                                        this.field_1718[var3++] = (byte)(var25 >> 8);
                                                        this.field_1718[var3++] = (byte)var25;
                                                    default:
                                                        break label271;
                                                }
                                            case 7:
                                                this.field_1718[var3++] = 4;
                                                ++var35;
                                                break;
                                            case 8:
                                                this.field_1718[var3++] = 3;
                                                ++var35;
                                                break;
                                            case 9:
                                                this.field_1718[var3++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var3++] = 5;
                                        }
                                        --var20;
                                    }
                                    ++var35;
                                }
                            case 3:
                                if (var3 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                this.field_1718[var3++] = -5;
                                this.field_1718[var3++] = (byte)(var19 >> 8);
                                this.field_1718[var3++] = (byte)var19;
                                break;
                            case 4:
                            default:
                                if (var3 + 5 >= this.field_1718.length) {
                                    this.resizeContents(5);
                                }
                                this.field_1718[var3++] = -1;
                                this.field_1718[var3++] = (byte)(var19 >> 8);
                                this.field_1718[var3++] = (byte)var19;
                                var35 = var3;
                                var3 += 2;
                                var34 = 0;
                                var22 = var16.getNumberOfLocals();
                                var25 = 0;
                                var26 = var16.field_1645 == null ? 0 : var16.field_1645.length;
                                int var30;
                                for (var27 = 0; var27 < var26 && var34 < var22; ++var27) {
                                    if (var3 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var28 = var16.field_1645[var27];
                                    if (var28 == null) {
                                        this.field_1718[var3++] = 0;
                                    } else {
                                        label238:
                                        switch (var28.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var3++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var3++] = (byte)var28.field_336;
                                                switch (var28.field_336) {
                                                    case 7:
                                                        var30 = this.constantPool.method_2466(var28.method_475());
                                                        this.field_1718[var3++] = (byte)(var30 >> 8);
                                                        this.field_1718[var3++] = (byte)var30;
                                                        break label238;
                                                    case 8:
                                                        int var29 = var28.field_339;
                                                        this.field_1718[var3++] = (byte)(var29 >> 8);
                                                        this.field_1718[var3++] = (byte)var29;
                                                    default:
                                                        break label238;
                                                }
                                            case 7:
                                                this.field_1718[var3++] = 4;
                                                ++var27;
                                                break;
                                            case 8:
                                                this.field_1718[var3++] = 3;
                                                ++var27;
                                                break;
                                            case 9:
                                                this.field_1718[var3++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var3++] = 5;
                                        }
                                        ++var34;
                                    }
                                    ++var25;
                                }
                                if (var3 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var35++] = (byte)(var25 >> 8);
                                this.field_1718[var35] = (byte)var25;
                                var27 = var16.field_1643;
                                this.field_1718[var3++] = (byte)(var27 >> 8);
                                this.field_1718[var3++] = (byte)var27;
                                var38 = 0;
                                while (true) {
                                    if (var38 >= var27) {
                                        continue label341;
                                    }
                                    if (var3 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var40 = var16.field_1646[var38];
                                    if (var40 == null) {
                                        this.field_1718[var3++] = 0;
                                    } else {
                                        label228:
                                        switch (var40.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var3++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var3++] = (byte)var40.field_336;
                                                switch (var40.field_336) {
                                                    case 7:
                                                        int var31 = this.constantPool.method_2466(var40.method_475());
                                                        this.field_1718[var3++] = (byte)(var31 >> 8);
                                                        this.field_1718[var3++] = (byte)var31;
                                                        break label228;
                                                    case 8:
                                                        var30 = var40.field_339;
                                                        this.field_1718[var3++] = (byte)(var30 >> 8);
                                                        this.field_1718[var3++] = (byte)var30;
                                                    default:
                                                        break label228;
                                                }
                                            case 7:
                                                this.field_1718[var3++] = 4;
                                                break;
                                            case 8:
                                                this.field_1718[var3++] = 3;
                                                break;
                                            case 9:
                                                this.field_1718[var3++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var3++] = 5;
                                        }
                                    }
                                    ++var38;
                                }
                            case 5:
                                if (var3 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var3++] = (byte)(var19 + 64);
                                if (var16.field_1646[0] == null) {
                                    this.field_1718[var3++] = 0;
                                } else {
                                    switch (var16.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var3++] = 1;
                                            continue;
                                        case 6:
                                        case 11:
                                        default:
                                            var23 = var16.field_1646[0];
                                            var24 = (byte)var23.field_336;
                                            this.field_1718[var3++] = var24;
                                            switch (var24) {
                                                case 7:
                                                    var26 = this.constantPool.method_2466(var23.method_475());
                                                    this.field_1718[var3++] = (byte)(var26 >> 8);
                                                    this.field_1718[var3++] = (byte)var26;
                                                    continue;
                                                case 8:
                                                    var25 = var23.field_339;
                                                    this.field_1718[var3++] = (byte)(var25 >> 8);
                                                    this.field_1718[var3++] = (byte)var25;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var3++] = 4;
                                            continue;
                                        case 8:
                                            this.field_1718[var3++] = 3;
                                            continue;
                                        case 9:
                                            this.field_1718[var3++] = 2;
                                            continue;
                                        case 12:
                                            this.field_1718[var3++] = 5;
                                    }
                                }
                                break;
                            case 6:
                                if (var3 + 6 >= this.field_1718.length) {
                                    this.resizeContents(6);
                                }
                                this.field_1718[var3++] = -9;
                                this.field_1718[var3++] = (byte)(var19 >> 8);
                                this.field_1718[var3++] = (byte)var19;
                                if (var16.field_1646[0] == null) {
                                    this.field_1718[var3++] = 0;
                                } else {
                                    switch (var16.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var3++] = 1;
                                            break;
                                        case 6:
                                        case 11:
                                        default:
                                            var23 = var16.field_1646[0];
                                            var24 = (byte)var23.field_336;
                                            this.field_1718[var3++] = var24;
                                            switch (var24) {
                                                case 7:
                                                    var26 = this.constantPool.method_2466(var23.method_475());
                                                    this.field_1718[var3++] = (byte)(var26 >> 8);
                                                    this.field_1718[var3++] = (byte)var26;
                                                    continue;
                                                case 8:
                                                    var25 = var23.field_339;
                                                    this.field_1718[var3++] = (byte)(var25 >> 8);
                                                    this.field_1718[var3++] = (byte)var25;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var3++] = 4;
                                            break;
                                        case 8:
                                            this.field_1718[var3++] = 3;
                                            break;
                                        case 9:
                                            this.field_1718[var3++] = 2;
                                            break;
                                        case 12:
                                            this.field_1718[var3++] = 5;
                                    }
                                }
                        }
                    }
                    if (var11 != 0) {
                        this.field_1718[var15++] = (byte)(var11 >> 8);
                        this.field_1718[var15] = (byte)var11;
                        var18 = var3 - var14 - 4;
                        this.field_1718[var14++] = (byte)(var18 >> 24);
                        this.field_1718[var14++] = (byte)(var18 >> 16);
                        this.field_1718[var14++] = (byte)(var18 >> 8);
                        this.field_1718[var14] = (byte)var18;
                        ++var8;
                    } else {
                        var3 = var12;
                    }
                }
            }
        }
        if ((this.field_1728 & 16) != 0) {
            var32 = (StackMapFrameCodeStream)this.codeStream;
            var32.method_2392(var4);
            if (var32.hasFramePositions()) {
                var10000 = new ArrayList();
                var10 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var6, this.field_1718, var1 + 14, var4, var10, false);
                var11 = var10.size();
                if (var11 > 1) {
                    var12 = var3;
                    if (var3 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var13 = this.constantPool.method_2459(AttributeNamesConstants.field_24);
                    this.field_1718[var3++] = (byte)(var13 >> 8);
                    this.field_1718[var3++] = (byte)var13;
                    var14 = var3;
                    var3 += 4;
                    if (var3 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var15 = var3;
                    var3 += 2;
                    if (var3 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var16 = (StackMapFrame)var10.get(0);
                    int var33;
                    for (var33 = 1; var33 < var11; ++var33) {
                        var16 = (StackMapFrame)var10.get(var33);
                        var18 = var16.field_1642;
                        if (var3 + 5 >= this.field_1718.length) {
                            this.resizeContents(5);
                        }
                        this.field_1718[var3++] = (byte)(var18 >> 8);
                        this.field_1718[var3++] = (byte)var18;
                        var19 = var3;
                        var3 += 2;
                        var20 = 0;
                        var21 = var16.getNumberOfLocals();
                        var22 = 0;
                        var35 = var16.field_1645 == null ? 0 : var16.field_1645.length;
                        for (var34 = 0; var34 < var35 && var20 < var21; ++var34) {
                            if (var3 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var39 = var16.field_1645[var34];
                            if (var39 == null) {
                                this.field_1718[var3++] = 0;
                            } else {
                                label208:
                                switch (var39.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var3++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var3++] = (byte)var39.field_336;
                                        switch (var39.field_336) {
                                            case 7:
                                                var27 = this.constantPool.method_2466(var39.method_475());
                                                this.field_1718[var3++] = (byte)(var27 >> 8);
                                                this.field_1718[var3++] = (byte)var27;
                                                break label208;
                                            case 8:
                                                var26 = var39.field_339;
                                                this.field_1718[var3++] = (byte)(var26 >> 8);
                                                this.field_1718[var3++] = (byte)var26;
                                            default:
                                                break label208;
                                        }
                                    case 7:
                                        this.field_1718[var3++] = 4;
                                        ++var34;
                                        break;
                                    case 8:
                                        this.field_1718[var3++] = 3;
                                        ++var34;
                                        break;
                                    case 9:
                                        this.field_1718[var3++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var3++] = 5;
                                }
                                ++var20;
                            }
                            ++var22;
                        }
                        if (var3 + 4 >= this.field_1718.length) {
                            this.resizeContents(4);
                        }
                        this.field_1718[var19++] = (byte)(var22 >> 8);
                        this.field_1718[var19] = (byte)var22;
                        var34 = var16.field_1643;
                        this.field_1718[var3++] = (byte)(var34 >> 8);
                        this.field_1718[var3++] = (byte)var34;
                        for (var25 = 0; var25 < var34; ++var25) {
                            if (var3 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var37 = var16.field_1646[var25];
                            if (var37 == null) {
                                this.field_1718[var3++] = 0;
                            } else {
                                switch (var37.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var3++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var3++] = (byte)var37.field_336;
                                        switch (var37.field_336) {
                                            case 7:
                                                var38 = this.constantPool.method_2466(var37.method_475());
                                                this.field_1718[var3++] = (byte)(var38 >> 8);
                                                this.field_1718[var3++] = (byte)var38;
                                                continue;
                                            case 8:
                                                var27 = var37.field_339;
                                                this.field_1718[var3++] = (byte)(var27 >> 8);
                                                this.field_1718[var3++] = (byte)var27;
                                            default:
                                                continue;
                                        }
                                    case 7:
                                        this.field_1718[var3++] = 4;
                                        break;
                                    case 8:
                                        this.field_1718[var3++] = 3;
                                        break;
                                    case 9:
                                        this.field_1718[var3++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var3++] = 5;
                                }
                            }
                        }
                    }
                    --var11;
                    if (var11 != 0) {
                        this.field_1718[var15++] = (byte)(var11 >> 8);
                        this.field_1718[var15] = (byte)var11;
                        var33 = var3 - var14 - 4;
                        this.field_1718[var14++] = (byte)(var33 >> 24);
                        this.field_1718[var14++] = (byte)(var33 >> 16);
                        this.field_1718[var14++] = (byte)(var33 >> 8);
                        this.field_1718[var14] = (byte)var33;
                        ++var8;
                    } else {
                        var3 = var12;
                    }
                }
            }
        }
        if (var7 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var7++] = (byte)(var8 >> 8);
        this.field_1718[var7] = (byte)var8;
        var9 = var3 - (var1 + 6);
        this.field_1718[var1 + 2] = (byte)(var9 >> 24);
        this.field_1718[var1 + 3] = (byte)(var9 >> 16);
        this.field_1718[var1 + 4] = (byte)(var9 >> 8);
        this.field_1718[var1 + 5] = (byte)var9;
        this.field_1719 = var3;
    }

    public void completeCodeAttributeForMissingAbstractProblemMethod(MethodBinding var1, int var2, int[] var3, int var4) {
        this.field_1718 = this.codeStream.bCodeStream;
        int var5 = this.codeStream.field_1190;
        int var6 = this.codeStream.field_1211;
        this.field_1718[var2 + 6] = (byte)(var6 >> 8);
        this.field_1718[var2 + 7] = (byte)var6;
        int var7 = this.codeStream.field_1204;
        this.field_1718[var2 + 8] = (byte)(var7 >> 8);
        this.field_1718[var2 + 9] = (byte)var7;
        int var8 = this.codeStream.field_1208;
        this.field_1718[var2 + 10] = (byte)(var8 >> 24);
        this.field_1718[var2 + 11] = (byte)(var8 >> 16);
        this.field_1718[var2 + 12] = (byte)(var8 >> 8);
        this.field_1718[var2 + 13] = (byte)var8;
        if (var5 + 50 >= this.field_1718.length) {
            this.resizeContents(50);
        }
        this.field_1718[var5++] = 0;
        this.field_1718[var5++] = 0;
        int var9 = var5;
        int var10 = 0;
        var5 += 2;
        if (var5 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        int var11;
        if ((this.field_1728 & 2) != 0) {
            if (var5 + 12 >= this.field_1718.length) {
                this.resizeContents(12);
            }
            var11 = this.constantPool.method_2459(AttributeNamesConstants.field_6);
            this.field_1718[var5++] = (byte)(var11 >> 8);
            this.field_1718[var5++] = (byte)var11;
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 6;
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 1;
            if (var4 == 0) {
                var4 = Util.getLineNumber(var1.method_385(), var3, 0, var3.length - 1);
            }
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = (byte)(var4 >> 8);
            this.field_1718[var5++] = (byte)var4;
            ++var10;
        }
        ArrayList var12;
        int var13;
        int var14;
        int var15;
        int var17;
        int var16;
        StackMapFrame var18;
        int var21;
        int var20;
        int var23;
        int var22;
        int var24;
        int var27;
        int var29;
        int var28;
        StackMapFrameCodeStream var34;
        int var39;
        int var36;
        int var40;
        ArrayList var10000;
        if ((this.field_1728 & 8) != 0) {
            var34 = (StackMapFrameCodeStream)this.codeStream;
            var34.method_2392(var8);
            if (var34.hasFramePositions()) {
                var10000 = new ArrayList();
                var12 = var10000;
                this.method_3018(var1, var7, this.field_1718, var2 + 14, var8, var12, false);
                var13 = var12.size();
                if (var13 > 1) {
                    var14 = var5;
                    if (var5 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var15 = this.constantPool.method_2459(AttributeNamesConstants.field_21);
                    this.field_1718[var5++] = (byte)(var15 >> 8);
                    this.field_1718[var5++] = (byte)var15;
                    var16 = var5;
                    var5 += 4;
                    if (var5 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var13 = 0;
                    var17 = var5;
                    var5 += 2;
                    if (var5 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var18 = (StackMapFrame)var12.get(0);
                    StackMapFrame var19 = null;
                    label336:
                    for (var20 = 1; var20 < var13; ++var20) {
                        var19 = var18;
                        var18 = (StackMapFrame)var12.get(var20);
                        ++var13;
                        var21 = var18.method_2896(var19);
                        VerificationTypeInfo var25;
                        byte var26;
                        switch (var18.method_2890(var19)) {
                            case 0:
                                if (var5 + 1 >= this.field_1718.length) {
                                    this.resizeContents(1);
                                }
                                this.field_1718[var5++] = (byte)var21;
                                break;
                            case 1:
                                if (var5 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var22 = -var18.method_2894(var19);
                                this.field_1718[var5++] = (byte)(251 - var22);
                                this.field_1718[var5++] = (byte)(var21 >> 8);
                                this.field_1718[var5++] = (byte)var21;
                                break;
                            case 2:
                                if (var5 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var22 = var18.method_2894(var19);
                                this.field_1718[var5++] = (byte)(251 + var22);
                                this.field_1718[var5++] = (byte)(var21 >> 8);
                                this.field_1718[var5++] = (byte)var21;
                                var23 = var18.getIndexOfDifferentLocals(var22);
                                var24 = var18.getNumberOfLocals();
                                var36 = var23;
                                while (true) {
                                    if (var36 >= var18.field_1645.length || var22 <= 0) {
                                        continue label336;
                                    }
                                    if (var5 + 6 >= this.field_1718.length) {
                                        this.resizeContents(6);
                                    }
                                    VerificationTypeInfo var38 = var18.field_1645[var36];
                                    if (var38 == null) {
                                        this.field_1718[var5++] = 0;
                                    } else {
                                        label267:
                                        switch (var38.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var5++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var5++] = (byte)var38.field_336;
                                                switch (var38.field_336) {
                                                    case 7:
                                                        var28 = this.constantPool.method_2466(var38.method_475());
                                                        this.field_1718[var5++] = (byte)(var28 >> 8);
                                                        this.field_1718[var5++] = (byte)var28;
                                                        break label267;
                                                    case 8:
                                                        var27 = var38.field_339;
                                                        this.field_1718[var5++] = (byte)(var27 >> 8);
                                                        this.field_1718[var5++] = (byte)var27;
                                                    default:
                                                        break label267;
                                                }
                                            case 7:
                                                this.field_1718[var5++] = 4;
                                                ++var36;
                                                break;
                                            case 8:
                                                this.field_1718[var5++] = 3;
                                                ++var36;
                                                break;
                                            case 9:
                                                this.field_1718[var5++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var5++] = 5;
                                        }
                                        --var22;
                                    }
                                    ++var36;
                                }
                            case 3:
                                if (var5 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                this.field_1718[var5++] = -5;
                                this.field_1718[var5++] = (byte)(var21 >> 8);
                                this.field_1718[var5++] = (byte)var21;
                                break;
                            case 4:
                            default:
                                if (var5 + 5 >= this.field_1718.length) {
                                    this.resizeContents(5);
                                }
                                this.field_1718[var5++] = -1;
                                this.field_1718[var5++] = (byte)(var21 >> 8);
                                this.field_1718[var5++] = (byte)var21;
                                var36 = var5;
                                var5 += 2;
                                var39 = 0;
                                var24 = var18.getNumberOfLocals();
                                var27 = 0;
                                var28 = var18.field_1645 == null ? 0 : var18.field_1645.length;
                                int var32;
                                for (var29 = 0; var29 < var28 && var39 < var24; ++var29) {
                                    if (var5 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var30 = var18.field_1645[var29];
                                    if (var30 == null) {
                                        this.field_1718[var5++] = 0;
                                    } else {
                                        label234:
                                        switch (var30.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var5++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var5++] = (byte)var30.field_336;
                                                switch (var30.field_336) {
                                                    case 7:
                                                        var32 = this.constantPool.method_2466(var30.method_475());
                                                        this.field_1718[var5++] = (byte)(var32 >> 8);
                                                        this.field_1718[var5++] = (byte)var32;
                                                        break label234;
                                                    case 8:
                                                        int var31 = var30.field_339;
                                                        this.field_1718[var5++] = (byte)(var31 >> 8);
                                                        this.field_1718[var5++] = (byte)var31;
                                                    default:
                                                        break label234;
                                                }
                                            case 7:
                                                this.field_1718[var5++] = 4;
                                                ++var29;
                                                break;
                                            case 8:
                                                this.field_1718[var5++] = 3;
                                                ++var29;
                                                break;
                                            case 9:
                                                this.field_1718[var5++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var5++] = 5;
                                        }
                                        ++var39;
                                    }
                                    ++var27;
                                }
                                if (var5 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var36++] = (byte)(var27 >> 8);
                                this.field_1718[var36] = (byte)var27;
                                var29 = var18.field_1643;
                                this.field_1718[var5++] = (byte)(var29 >> 8);
                                this.field_1718[var5++] = (byte)var29;
                                var40 = 0;
                                while (true) {
                                    if (var40 >= var29) {
                                        continue label336;
                                    }
                                    if (var5 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var41 = var18.field_1646[var40];
                                    if (var41 == null) {
                                        this.field_1718[var5++] = 0;
                                    } else {
                                        label224:
                                        switch (var41.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var5++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var5++] = (byte)var41.field_336;
                                                switch (var41.field_336) {
                                                    case 7:
                                                        int var33 = this.constantPool.method_2466(var41.method_475());
                                                        this.field_1718[var5++] = (byte)(var33 >> 8);
                                                        this.field_1718[var5++] = (byte)var33;
                                                        break label224;
                                                    case 8:
                                                        var32 = var41.field_339;
                                                        this.field_1718[var5++] = (byte)(var32 >> 8);
                                                        this.field_1718[var5++] = (byte)var32;
                                                    default:
                                                        break label224;
                                                }
                                            case 7:
                                                this.field_1718[var5++] = 4;
                                                break;
                                            case 8:
                                                this.field_1718[var5++] = 3;
                                                break;
                                            case 9:
                                                this.field_1718[var5++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var5++] = 5;
                                        }
                                    }
                                    ++var40;
                                }
                            case 5:
                                if (var5 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var5++] = (byte)(var21 + 64);
                                if (var18.field_1646[0] == null) {
                                    this.field_1718[var5++] = 0;
                                } else {
                                    switch (var18.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var5++] = 1;
                                            continue;
                                        case 6:
                                        case 11:
                                        default:
                                            var25 = var18.field_1646[0];
                                            var26 = (byte)var25.field_336;
                                            this.field_1718[var5++] = var26;
                                            switch (var26) {
                                                case 7:
                                                    var28 = this.constantPool.method_2466(var25.method_475());
                                                    this.field_1718[var5++] = (byte)(var28 >> 8);
                                                    this.field_1718[var5++] = (byte)var28;
                                                    continue;
                                                case 8:
                                                    var27 = var25.field_339;
                                                    this.field_1718[var5++] = (byte)(var27 >> 8);
                                                    this.field_1718[var5++] = (byte)var27;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var5++] = 4;
                                            continue;
                                        case 8:
                                            this.field_1718[var5++] = 3;
                                            continue;
                                        case 9:
                                            this.field_1718[var5++] = 2;
                                            continue;
                                        case 12:
                                            this.field_1718[var5++] = 5;
                                    }
                                }
                                break;
                            case 6:
                                if (var5 + 6 >= this.field_1718.length) {
                                    this.resizeContents(6);
                                }
                                this.field_1718[var5++] = -9;
                                this.field_1718[var5++] = (byte)(var21 >> 8);
                                this.field_1718[var5++] = (byte)var21;
                                if (var18.field_1646[0] == null) {
                                    this.field_1718[var5++] = 0;
                                } else {
                                    switch (var18.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var5++] = 1;
                                            break;
                                        case 6:
                                        case 11:
                                        default:
                                            var25 = var18.field_1646[0];
                                            var26 = (byte)var25.field_336;
                                            this.field_1718[var5++] = var26;
                                            switch (var26) {
                                                case 7:
                                                    var28 = this.constantPool.method_2466(var25.method_475());
                                                    this.field_1718[var5++] = (byte)(var28 >> 8);
                                                    this.field_1718[var5++] = (byte)var28;
                                                    continue;
                                                case 8:
                                                    var27 = var25.field_339;
                                                    this.field_1718[var5++] = (byte)(var27 >> 8);
                                                    this.field_1718[var5++] = (byte)var27;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var5++] = 4;
                                            break;
                                        case 8:
                                            this.field_1718[var5++] = 3;
                                            break;
                                        case 9:
                                            this.field_1718[var5++] = 2;
                                            break;
                                        case 12:
                                            this.field_1718[var5++] = 5;
                                    }
                                }
                        }
                    }
                    if (var13 != 0) {
                        this.field_1718[var17++] = (byte)(var13 >> 8);
                        this.field_1718[var17] = (byte)var13;
                        var20 = var5 - var16 - 4;
                        this.field_1718[var16++] = (byte)(var20 >> 24);
                        this.field_1718[var16++] = (byte)(var20 >> 16);
                        this.field_1718[var16++] = (byte)(var20 >> 8);
                        this.field_1718[var16] = (byte)var20;
                        ++var10;
                    } else {
                        var5 = var14;
                    }
                }
            }
        }
        if ((this.field_1728 & 16) != 0) {
            var34 = (StackMapFrameCodeStream)this.codeStream;
            var34.method_2392(var8);
            if (var34.hasFramePositions()) {
                var10000 = new ArrayList();
                var12 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var7, this.field_1718, var2 + 14, var8, var12, false);
                var13 = var12.size();
                if (var13 > 1) {
                    var14 = var5;
                    if (var5 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var15 = this.constantPool.method_2459(AttributeNamesConstants.field_24);
                    this.field_1718[var5++] = (byte)(var15 >> 8);
                    this.field_1718[var5++] = (byte)var15;
                    var16 = var5;
                    var5 += 4;
                    if (var5 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var17 = var5;
                    var5 += 2;
                    if (var5 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var18 = (StackMapFrame)var12.get(0);
                    int var35;
                    for (var35 = 1; var35 < var13; ++var35) {
                        var18 = (StackMapFrame)var12.get(var35);
                        var20 = var18.field_1642;
                        if (var5 + 5 >= this.field_1718.length) {
                            this.resizeContents(5);
                        }
                        this.field_1718[var5++] = (byte)(var20 >> 8);
                        this.field_1718[var5++] = (byte)var20;
                        var21 = var5;
                        var5 += 2;
                        var22 = 0;
                        var23 = var18.getNumberOfLocals();
                        var24 = 0;
                        var36 = var18.field_1645 == null ? 0 : var18.field_1645.length;
                        for (var39 = 0; var39 < var36 && var22 < var23; ++var39) {
                            if (var5 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var37 = var18.field_1645[var39];
                            if (var37 == null) {
                                this.field_1718[var5++] = 0;
                            } else {
                                label204:
                                switch (var37.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var5++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var5++] = (byte)var37.field_336;
                                        switch (var37.field_336) {
                                            case 7:
                                                var29 = this.constantPool.method_2466(var37.method_475());
                                                this.field_1718[var5++] = (byte)(var29 >> 8);
                                                this.field_1718[var5++] = (byte)var29;
                                                break label204;
                                            case 8:
                                                var28 = var37.field_339;
                                                this.field_1718[var5++] = (byte)(var28 >> 8);
                                                this.field_1718[var5++] = (byte)var28;
                                            default:
                                                break label204;
                                        }
                                    case 7:
                                        this.field_1718[var5++] = 4;
                                        ++var39;
                                        break;
                                    case 8:
                                        this.field_1718[var5++] = 3;
                                        ++var39;
                                        break;
                                    case 9:
                                        this.field_1718[var5++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var5++] = 5;
                                }
                                ++var22;
                            }
                            ++var24;
                        }
                        if (var5 + 4 >= this.field_1718.length) {
                            this.resizeContents(4);
                        }
                        this.field_1718[var21++] = (byte)(var24 >> 8);
                        this.field_1718[var21] = (byte)var24;
                        var39 = var18.field_1643;
                        this.field_1718[var5++] = (byte)(var39 >> 8);
                        this.field_1718[var5++] = (byte)var39;
                        for (var27 = 0; var27 < var39; ++var27) {
                            if (var5 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var42 = var18.field_1646[var27];
                            if (var42 == null) {
                                this.field_1718[var5++] = 0;
                            } else {
                                switch (var42.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var5++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var5++] = (byte)var42.field_336;
                                        switch (var42.field_336) {
                                            case 7:
                                                var40 = this.constantPool.method_2466(var42.method_475());
                                                this.field_1718[var5++] = (byte)(var40 >> 8);
                                                this.field_1718[var5++] = (byte)var40;
                                                continue;
                                            case 8:
                                                var29 = var42.field_339;
                                                this.field_1718[var5++] = (byte)(var29 >> 8);
                                                this.field_1718[var5++] = (byte)var29;
                                            default:
                                                continue;
                                        }
                                    case 7:
                                        this.field_1718[var5++] = 4;
                                        break;
                                    case 8:
                                        this.field_1718[var5++] = 3;
                                        break;
                                    case 9:
                                        this.field_1718[var5++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var5++] = 5;
                                }
                            }
                        }
                    }
                    --var13;
                    if (var13 != 0) {
                        this.field_1718[var17++] = (byte)(var13 >> 8);
                        this.field_1718[var17] = (byte)var13;
                        var35 = var5 - var16 - 4;
                        this.field_1718[var16++] = (byte)(var35 >> 24);
                        this.field_1718[var16++] = (byte)(var35 >> 16);
                        this.field_1718[var16++] = (byte)(var35 >> 8);
                        this.field_1718[var16] = (byte)var35;
                        ++var10;
                    } else {
                        var5 = var14;
                    }
                }
            }
        }
        if (var9 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var9++] = (byte)(var10 >> 8);
        this.field_1718[var9] = (byte)var10;
        var11 = var5 - (var2 + 6);
        this.field_1718[var2 + 2] = (byte)(var11 >> 24);
        this.field_1718[var2 + 3] = (byte)(var11 >> 16);
        this.field_1718[var2 + 4] = (byte)(var11 >> 8);
        this.field_1718[var2 + 5] = (byte)var11;
        this.field_1719 = var5;
    }

    public void completeCodeAttributeForProblemMethod(AbstractMethodDeclaration var1, MethodBinding var2, int var3, int[] var4, int var5) {
        this.field_1718 = this.codeStream.bCodeStream;
        int var6 = this.codeStream.field_1190;
        int var7 = this.codeStream.field_1211;
        this.field_1718[var3 + 6] = (byte)(var7 >> 8);
        this.field_1718[var3 + 7] = (byte)var7;
        int var8 = this.codeStream.field_1204;
        this.field_1718[var3 + 8] = (byte)(var8 >> 8);
        this.field_1718[var3 + 9] = (byte)var8;
        int var9 = this.codeStream.field_1208;
        this.field_1718[var3 + 10] = (byte)(var9 >> 24);
        this.field_1718[var3 + 11] = (byte)(var9 >> 16);
        this.field_1718[var3 + 12] = (byte)(var9 >> 8);
        this.field_1718[var3 + 13] = (byte)var9;
        if (var6 + 50 >= this.field_1718.length) {
            this.resizeContents(50);
        }
        this.field_1718[var6++] = 0;
        this.field_1718[var6++] = 0;
        int var10 = var6;
        int var11 = 0;
        var6 += 2;
        if (var6 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        int var12;
        if ((this.field_1728 & 2) != 0) {
            if (var6 + 20 >= this.field_1718.length) {
                this.resizeContents(20);
            }
            var12 = this.constantPool.method_2459(AttributeNamesConstants.field_6);
            this.field_1718[var6++] = (byte)(var12 >> 8);
            this.field_1718[var6++] = (byte)var12;
            this.field_1718[var6++] = 0;
            this.field_1718[var6++] = 0;
            this.field_1718[var6++] = 0;
            this.field_1718[var6++] = 6;
            this.field_1718[var6++] = 0;
            this.field_1718[var6++] = 1;
            if (var5 == 0) {
                var5 = Util.getLineNumber(var2.method_385(), var4, 0, var4.length - 1);
            }
            this.field_1718[var6++] = 0;
            this.field_1718[var6++] = 0;
            this.field_1718[var6++] = (byte)(var5 >> 8);
            this.field_1718[var6++] = (byte)var5;
            ++var11;
        }
        int var14;
        int var15;
        int var17;
        int var16;
        int var20;
        int var22;
        int var27;
        int var26;
        int var30;
        int var32;
        int var33;
        int var40;
        int var54;
        int var53;
        if ((this.field_1728 & 4) != 0) {
            int var13 = 0;
            var14 = this.constantPool.method_2459(AttributeNamesConstants.field_7);
            if (var6 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            this.field_1718[var6++] = (byte)(var14 >> 8);
            this.field_1718[var6++] = (byte)var14;
            var15 = var6;
            var6 += 6;
            SourceTypeBinding var18 = null;
            boolean var19 = this.codeStream.methodDeclaration.method_799();
            if (!var19) {
                ++var13;
                if (var6 + 10 >= this.field_1718.length) {
                    this.resizeContents(10);
                }
                this.field_1718[var6++] = 0;
                this.field_1718[var6++] = 0;
                this.field_1718[var6++] = (byte)(var9 >> 8);
                this.field_1718[var6++] = (byte)var9;
                var17 = this.constantPool.method_2459(ConstantPool.field_1493);
                this.field_1718[var6++] = (byte)(var17 >> 8);
                this.field_1718[var6++] = (byte)var17;
                var18 = (SourceTypeBinding)this.codeStream.methodDeclaration.binding.declaringClass;
                var16 = this.constantPool.method_2459(var18.method_178());
                this.field_1718[var6++] = (byte)(var16 >> 8);
                this.field_1718[var6++] = (byte)var16;
                this.field_1718[var6++] = 0;
                this.field_1718[var6++] = 0;
            }
            var20 = 0;
            LocalVariableBinding[] var21 = null;
            var22 = 0;
            if (var2.method_358()) {
                ReferenceBinding var23 = var2.declaringClass;
                if (var23.method_160()) {
                    NestedTypeBinding var24 = (NestedTypeBinding)var23;
                    var12 = var24.field_265;
                    SyntheticArgumentBinding[] var25;
                    if ((var25 = var24.method_329()) != null) {
                        var26 = 0;
                        for (var27 = var25.length; var26 < var27; ++var26) {
                            SyntheticArgumentBinding var28 = var25[var26];
                            TypeBinding var29 = var28.type;
                            if (var29.method_162() || var29.method_169()) {
                                if (var21 == null) {
                                    var21 = new LocalVariableBinding[var27];
                                }
                                var21[var20++] = var28;
                                ++var22;
                            }
                            if (var6 + 10 >= this.field_1718.length) {
                                this.resizeContents(10);
                            }
                            ++var13;
                            this.field_1718[var6++] = 0;
                            this.field_1718[var6++] = 0;
                            this.field_1718[var6++] = (byte)(var9 >> 8);
                            this.field_1718[var6++] = (byte)var9;
                            var17 = this.constantPool.method_2459(var28.name);
                            this.field_1718[var6++] = (byte)(var17 >> 8);
                            this.field_1718[var6++] = (byte)var17;
                            var16 = this.constantPool.method_2459(var29.method_178());
                            this.field_1718[var6++] = (byte)(var16 >> 8);
                            this.field_1718[var6++] = (byte)var16;
                            var30 = var28.field_306;
                            this.field_1718[var6++] = (byte)(var30 >> 8);
                            this.field_1718[var6++] = (byte)var30;
                        }
                    }
                } else {
                    var12 = 1;
                }
            } else {
                var12 = var2.method_370() ? 0 : 1;
            }
            var40 = 0;
            int[] var44 = null;
            int[] var43 = null;
            TypeBinding[] var49 = null;
            if (var1.binding != null) {
                TypeBinding[] var51 = var1.binding.parameters;
                Argument[] var48 = var1.arguments;
                if (var51 != null && var48 != null) {
                    var54 = 0;
                    for (var30 = var51.length; var54 < var30; ++var54) {
                        TypeBinding var31 = var51[var54];
                        if (var6 + 10 >= this.field_1718.length) {
                            this.resizeContents(10);
                        }
                        ++var13;
                        this.field_1718[var6++] = 0;
                        this.field_1718[var6++] = 0;
                        this.field_1718[var6++] = (byte)(var9 >> 8);
                        this.field_1718[var6++] = (byte)var9;
                        var17 = this.constantPool.method_2459(var48[var54].name);
                        this.field_1718[var6++] = (byte)(var17 >> 8);
                        this.field_1718[var6++] = (byte)var17;
                        if (var31.method_162() || var31.method_169()) {
                            if (var40 == 0) {
                                var44 = new int[var30];
                                var43 = new int[var30];
                                var49 = new TypeBinding[var30];
                            }
                            var44[var40] = var17;
                            var43[var40] = var12;
                            var49[var40++] = var31;
                        }
                        var16 = this.constantPool.method_2459(var31.method_178());
                        this.field_1718[var6++] = (byte)(var16 >> 8);
                        this.field_1718[var6++] = (byte)var16;
                        if (var31 != TypeBinding.field_183 && var31 != TypeBinding.field_185) {
                            ++var12;
                        } else {
                            var12 += 2;
                        }
                        this.field_1718[var6++] = (byte)(var12 >> 8);
                        this.field_1718[var6++] = (byte)var12;
                    }
                }
            }
            var27 = var13 * 10 + 2;
            this.field_1718[var15++] = (byte)(var27 >> 24);
            this.field_1718[var15++] = (byte)(var27 >> 16);
            this.field_1718[var15++] = (byte)(var27 >> 8);
            this.field_1718[var15++] = (byte)var27;
            this.field_1718[var15++] = (byte)(var13 >> 8);
            this.field_1718[var15] = (byte)var13;
            ++var11;
            boolean var46 = !var19 && var18 != null && var18.typeVariables != Binding.NO_TYPE_VARIABLES;
            if (var20 != 0 || var40 != 0 || var46) {
                var13 = var22 + var40 + (var46 ? 1 : 0);
                var54 = 8 + var13 * 10;
                if (var6 + var54 >= this.field_1718.length) {
                    this.resizeContents(var54);
                }
                var30 = this.constantPool.method_2459(AttributeNamesConstants.field_14);
                this.field_1718[var6++] = (byte)(var30 >> 8);
                this.field_1718[var6++] = (byte)var30;
                var27 = var13 * 10 + 2;
                this.field_1718[var6++] = (byte)(var27 >> 24);
                this.field_1718[var6++] = (byte)(var27 >> 16);
                this.field_1718[var6++] = (byte)(var27 >> 8);
                this.field_1718[var6++] = (byte)var27;
                this.field_1718[var6++] = (byte)(var13 >> 8);
                this.field_1718[var6++] = (byte)var13;
                if (var46) {
                    ++var13;
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = (byte)(var9 >> 8);
                    this.field_1718[var6++] = (byte)var9;
                    var17 = this.constantPool.method_2459(ConstantPool.field_1493);
                    this.field_1718[var6++] = (byte)(var17 >> 8);
                    this.field_1718[var6++] = (byte)var17;
                    var16 = this.constantPool.method_2459(var18.genericTypeSignature());
                    this.field_1718[var6++] = (byte)(var16 >> 8);
                    this.field_1718[var6++] = (byte)var16;
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = 0;
                }
                for (var53 = 0; var53 < var20; ++var53) {
                    LocalVariableBinding var58 = var21[var53];
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = (byte)(var9 >> 8);
                    this.field_1718[var6++] = (byte)var9;
                    var17 = this.constantPool.method_2459(var58.name);
                    this.field_1718[var6++] = (byte)(var17 >> 8);
                    this.field_1718[var6++] = (byte)var17;
                    var16 = this.constantPool.method_2459(var58.type.genericTypeSignature());
                    this.field_1718[var6++] = (byte)(var16 >> 8);
                    this.field_1718[var6++] = (byte)var16;
                    var33 = var58.field_306;
                    this.field_1718[var6++] = (byte)(var33 >> 8);
                    this.field_1718[var6++] = (byte)var33;
                }
                for (var53 = 0; var53 < var40; ++var53) {
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = 0;
                    this.field_1718[var6++] = (byte)(var9 >> 8);
                    this.field_1718[var6++] = (byte)var9;
                    var17 = var44[var53];
                    this.field_1718[var6++] = (byte)(var17 >> 8);
                    this.field_1718[var6++] = (byte)var17;
                    var16 = this.constantPool.method_2459(var49[var53].genericTypeSignature());
                    this.field_1718[var6++] = (byte)(var16 >> 8);
                    this.field_1718[var6++] = (byte)var16;
                    var32 = var43[var53];
                    this.field_1718[var6++] = (byte)(var32 >> 8);
                    this.field_1718[var6++] = (byte)var32;
                }
                ++var11;
            }
        }
        StackMapFrameCodeStream var35;
        StackMapFrame var38;
        ArrayList var36;
        int var37;
        int var42;
        int var41;
        ArrayList var10000;
        int var50;
        int var56;
        if ((this.field_1728 & 8) != 0) {
            var35 = (StackMapFrameCodeStream)this.codeStream;
            var35.method_2392(var9);
            if (var35.hasFramePositions()) {
                var10000 = new ArrayList();
                var36 = var10000;
                this.method_3018(var2, var8, this.field_1718, var3 + 14, var9, var36, false);
                var14 = var36.size();
                if (var14 > 1) {
                    var15 = var6;
                    if (var6 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_21);
                    this.field_1718[var6++] = (byte)(var16 >> 8);
                    this.field_1718[var6++] = (byte)var16;
                    var17 = var6;
                    var6 += 4;
                    if (var6 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var14 = 0;
                    var37 = var6;
                    var6 += 2;
                    if (var6 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var38 = (StackMapFrame)var36.get(0);
                    StackMapFrame var39 = null;
                    label420:
                    for (var41 = 1; var41 < var14; ++var41) {
                        var39 = var38;
                        var38 = (StackMapFrame)var36.get(var41);
                        ++var14;
                        var22 = var38.method_2896(var39);
                        byte var47;
                        VerificationTypeInfo var45;
                        switch (var38.method_2890(var39)) {
                            case 0:
                                if (var6 + 1 >= this.field_1718.length) {
                                    this.resizeContents(1);
                                }
                                this.field_1718[var6++] = (byte)var22;
                                break;
                            case 1:
                                if (var6 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var40 = -var38.method_2894(var39);
                                this.field_1718[var6++] = (byte)(251 - var40);
                                this.field_1718[var6++] = (byte)(var22 >> 8);
                                this.field_1718[var6++] = (byte)var22;
                                break;
                            case 2:
                                if (var6 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var40 = var38.method_2894(var39);
                                this.field_1718[var6++] = (byte)(251 + var40);
                                this.field_1718[var6++] = (byte)(var22 >> 8);
                                this.field_1718[var6++] = (byte)var22;
                                var42 = var38.getIndexOfDifferentLocals(var40);
                                var50 = var38.getNumberOfLocals();
                                var26 = var42;
                                while (true) {
                                    if (var26 >= var38.field_1645.length || var40 <= 0) {
                                        continue label420;
                                    }
                                    if (var6 + 6 >= this.field_1718.length) {
                                        this.resizeContents(6);
                                    }
                                    VerificationTypeInfo var55 = var38.field_1645[var26];
                                    if (var55 == null) {
                                        this.field_1718[var6++] = 0;
                                    } else {
                                        label333:
                                        switch (var55.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var6++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var6++] = (byte)var55.field_336;
                                                switch (var55.field_336) {
                                                    case 7:
                                                        var54 = this.constantPool.method_2466(var55.method_475());
                                                        this.field_1718[var6++] = (byte)(var54 >> 8);
                                                        this.field_1718[var6++] = (byte)var54;
                                                        break label333;
                                                    case 8:
                                                        var56 = var55.field_339;
                                                        this.field_1718[var6++] = (byte)(var56 >> 8);
                                                        this.field_1718[var6++] = (byte)var56;
                                                    default:
                                                        break label333;
                                                }
                                            case 7:
                                                this.field_1718[var6++] = 4;
                                                ++var26;
                                                break;
                                            case 8:
                                                this.field_1718[var6++] = 3;
                                                ++var26;
                                                break;
                                            case 9:
                                                this.field_1718[var6++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var6++] = 5;
                                        }
                                        --var40;
                                    }
                                    ++var26;
                                }
                            case 3:
                                if (var6 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                this.field_1718[var6++] = -5;
                                this.field_1718[var6++] = (byte)(var22 >> 8);
                                this.field_1718[var6++] = (byte)var22;
                                break;
                            case 4:
                            default:
                                if (var6 + 5 >= this.field_1718.length) {
                                    this.resizeContents(5);
                                }
                                this.field_1718[var6++] = -1;
                                this.field_1718[var6++] = (byte)(var22 >> 8);
                                this.field_1718[var6++] = (byte)var22;
                                var26 = var6;
                                var6 += 2;
                                var27 = 0;
                                var50 = var38.getNumberOfLocals();
                                var56 = 0;
                                var54 = var38.field_1645 == null ? 0 : var38.field_1645.length;
                                for (var30 = 0; var30 < var54 && var27 < var50; ++var30) {
                                    if (var6 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var59 = var38.field_1645[var30];
                                    if (var59 == null) {
                                        this.field_1718[var6++] = 0;
                                    } else {
                                        label300:
                                        switch (var59.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var6++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var6++] = (byte)var59.field_336;
                                                switch (var59.field_336) {
                                                    case 7:
                                                        var33 = this.constantPool.method_2466(var59.method_475());
                                                        this.field_1718[var6++] = (byte)(var33 >> 8);
                                                        this.field_1718[var6++] = (byte)var33;
                                                        break label300;
                                                    case 8:
                                                        var32 = var59.field_339;
                                                        this.field_1718[var6++] = (byte)(var32 >> 8);
                                                        this.field_1718[var6++] = (byte)var32;
                                                    default:
                                                        break label300;
                                                }
                                            case 7:
                                                this.field_1718[var6++] = 4;
                                                ++var30;
                                                break;
                                            case 8:
                                                this.field_1718[var6++] = 3;
                                                ++var30;
                                                break;
                                            case 9:
                                                this.field_1718[var6++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var6++] = 5;
                                        }
                                        ++var27;
                                    }
                                    ++var56;
                                }
                                if (var6 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var26++] = (byte)(var56 >> 8);
                                this.field_1718[var26] = (byte)var56;
                                var30 = var38.field_1643;
                                this.field_1718[var6++] = (byte)(var30 >> 8);
                                this.field_1718[var6++] = (byte)var30;
                                var53 = 0;
                                while (true) {
                                    if (var53 >= var30) {
                                        continue label420;
                                    }
                                    if (var6 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var57 = var38.field_1646[var53];
                                    if (var57 == null) {
                                        this.field_1718[var6++] = 0;
                                    } else {
                                        label290:
                                        switch (var57.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var6++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var6++] = (byte)var57.field_336;
                                                switch (var57.field_336) {
                                                    case 7:
                                                        int var34 = this.constantPool.method_2466(var57.method_475());
                                                        this.field_1718[var6++] = (byte)(var34 >> 8);
                                                        this.field_1718[var6++] = (byte)var34;
                                                        break label290;
                                                    case 8:
                                                        var33 = var57.field_339;
                                                        this.field_1718[var6++] = (byte)(var33 >> 8);
                                                        this.field_1718[var6++] = (byte)var33;
                                                    default:
                                                        break label290;
                                                }
                                            case 7:
                                                this.field_1718[var6++] = 4;
                                                break;
                                            case 8:
                                                this.field_1718[var6++] = 3;
                                                break;
                                            case 9:
                                                this.field_1718[var6++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var6++] = 5;
                                        }
                                    }
                                    ++var53;
                                }
                            case 5:
                                if (var6 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var6++] = (byte)(var22 + 64);
                                if (var38.field_1646[0] == null) {
                                    this.field_1718[var6++] = 0;
                                } else {
                                    switch (var38.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var6++] = 1;
                                            continue;
                                        case 6:
                                        case 11:
                                        default:
                                            var45 = var38.field_1646[0];
                                            var47 = (byte)var45.field_336;
                                            this.field_1718[var6++] = var47;
                                            switch (var47) {
                                                case 7:
                                                    var54 = this.constantPool.method_2466(var45.method_475());
                                                    this.field_1718[var6++] = (byte)(var54 >> 8);
                                                    this.field_1718[var6++] = (byte)var54;
                                                    continue;
                                                case 8:
                                                    var56 = var45.field_339;
                                                    this.field_1718[var6++] = (byte)(var56 >> 8);
                                                    this.field_1718[var6++] = (byte)var56;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var6++] = 4;
                                            continue;
                                        case 8:
                                            this.field_1718[var6++] = 3;
                                            continue;
                                        case 9:
                                            this.field_1718[var6++] = 2;
                                            continue;
                                        case 12:
                                            this.field_1718[var6++] = 5;
                                    }
                                }
                                break;
                            case 6:
                                if (var6 + 6 >= this.field_1718.length) {
                                    this.resizeContents(6);
                                }
                                this.field_1718[var6++] = -9;
                                this.field_1718[var6++] = (byte)(var22 >> 8);
                                this.field_1718[var6++] = (byte)var22;
                                if (var38.field_1646[0] == null) {
                                    this.field_1718[var6++] = 0;
                                } else {
                                    switch (var38.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var6++] = 1;
                                            break;
                                        case 6:
                                        case 11:
                                        default:
                                            var45 = var38.field_1646[0];
                                            var47 = (byte)var45.field_336;
                                            this.field_1718[var6++] = var47;
                                            switch (var47) {
                                                case 7:
                                                    var54 = this.constantPool.method_2466(var45.method_475());
                                                    this.field_1718[var6++] = (byte)(var54 >> 8);
                                                    this.field_1718[var6++] = (byte)var54;
                                                    continue;
                                                case 8:
                                                    var56 = var45.field_339;
                                                    this.field_1718[var6++] = (byte)(var56 >> 8);
                                                    this.field_1718[var6++] = (byte)var56;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var6++] = 4;
                                            break;
                                        case 8:
                                            this.field_1718[var6++] = 3;
                                            break;
                                        case 9:
                                            this.field_1718[var6++] = 2;
                                            break;
                                        case 12:
                                            this.field_1718[var6++] = 5;
                                    }
                                }
                        }
                    }
                    if (var14 != 0) {
                        this.field_1718[var37++] = (byte)(var14 >> 8);
                        this.field_1718[var37] = (byte)var14;
                        var41 = var6 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var41 >> 24);
                        this.field_1718[var17++] = (byte)(var41 >> 16);
                        this.field_1718[var17++] = (byte)(var41 >> 8);
                        this.field_1718[var17] = (byte)var41;
                        ++var11;
                    } else {
                        var6 = var15;
                    }
                }
            }
        }
        if ((this.field_1728 & 16) != 0) {
            var35 = (StackMapFrameCodeStream)this.codeStream;
            var35.method_2392(var9);
            if (var35.hasFramePositions()) {
                var10000 = new ArrayList();
                var36 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var8, this.field_1718, var3 + 14, var9, var36, false);
                var14 = var36.size();
                if (var14 > 1) {
                    var15 = var6;
                    if (var6 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_24);
                    this.field_1718[var6++] = (byte)(var16 >> 8);
                    this.field_1718[var6++] = (byte)var16;
                    var17 = var6;
                    var6 += 4;
                    if (var6 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var37 = var6;
                    var6 += 2;
                    if (var6 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var38 = (StackMapFrame)var36.get(0);
                    for (var20 = 1; var20 < var14; ++var20) {
                        var38 = (StackMapFrame)var36.get(var20);
                        var41 = var38.field_1642;
                        if (var6 + 5 >= this.field_1718.length) {
                            this.resizeContents(5);
                        }
                        this.field_1718[var6++] = (byte)(var41 >> 8);
                        this.field_1718[var6++] = (byte)var41;
                        var22 = var6;
                        var6 += 2;
                        var40 = 0;
                        var42 = var38.getNumberOfLocals();
                        var50 = 0;
                        var26 = var38.field_1645 == null ? 0 : var38.field_1645.length;
                        for (var27 = 0; var27 < var26 && var40 < var42; ++var27) {
                            if (var6 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var52 = var38.field_1645[var27];
                            if (var52 == null) {
                                this.field_1718[var6++] = 0;
                            } else {
                                label270:
                                switch (var52.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var6++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var6++] = (byte)var52.field_336;
                                        switch (var52.field_336) {
                                            case 7:
                                                var30 = this.constantPool.method_2466(var52.method_475());
                                                this.field_1718[var6++] = (byte)(var30 >> 8);
                                                this.field_1718[var6++] = (byte)var30;
                                                break label270;
                                            case 8:
                                                var54 = var52.field_339;
                                                this.field_1718[var6++] = (byte)(var54 >> 8);
                                                this.field_1718[var6++] = (byte)var54;
                                            default:
                                                break label270;
                                        }
                                    case 7:
                                        this.field_1718[var6++] = 4;
                                        ++var27;
                                        break;
                                    case 8:
                                        this.field_1718[var6++] = 3;
                                        ++var27;
                                        break;
                                    case 9:
                                        this.field_1718[var6++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var6++] = 5;
                                }
                                ++var40;
                            }
                            ++var50;
                        }
                        if (var6 + 4 >= this.field_1718.length) {
                            this.resizeContents(4);
                        }
                        this.field_1718[var22++] = (byte)(var50 >> 8);
                        this.field_1718[var22] = (byte)var50;
                        var27 = var38.field_1643;
                        this.field_1718[var6++] = (byte)(var27 >> 8);
                        this.field_1718[var6++] = (byte)var27;
                        for (var56 = 0; var56 < var27; ++var56) {
                            if (var6 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var60 = var38.field_1646[var56];
                            if (var60 == null) {
                                this.field_1718[var6++] = 0;
                            } else {
                                switch (var60.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var6++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var6++] = (byte)var60.field_336;
                                        switch (var60.field_336) {
                                            case 7:
                                                var53 = this.constantPool.method_2466(var60.method_475());
                                                this.field_1718[var6++] = (byte)(var53 >> 8);
                                                this.field_1718[var6++] = (byte)var53;
                                                continue;
                                            case 8:
                                                var30 = var60.field_339;
                                                this.field_1718[var6++] = (byte)(var30 >> 8);
                                                this.field_1718[var6++] = (byte)var30;
                                            default:
                                                continue;
                                        }
                                    case 7:
                                        this.field_1718[var6++] = 4;
                                        break;
                                    case 8:
                                        this.field_1718[var6++] = 3;
                                        break;
                                    case 9:
                                        this.field_1718[var6++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var6++] = 5;
                                }
                            }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var37++] = (byte)(var14 >> 8);
                        this.field_1718[var37] = (byte)var14;
                        var20 = var6 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var20 >> 24);
                        this.field_1718[var17++] = (byte)(var20 >> 16);
                        this.field_1718[var17++] = (byte)(var20 >> 8);
                        this.field_1718[var17] = (byte)var20;
                        ++var11;
                    } else {
                        var6 = var15;
                    }
                }
            }
        }
        if (var10 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var10++] = (byte)(var11 >> 8);
        this.field_1718[var10] = (byte)var11;
        var12 = var6 - (var3 + 6);
        this.field_1718[var3 + 2] = (byte)(var12 >> 24);
        this.field_1718[var3 + 3] = (byte)(var12 >> 16);
        this.field_1718[var3 + 4] = (byte)(var12 >> 8);
        this.field_1718[var3 + 5] = (byte)var12;
        this.field_1719 = var6;
    }

    public void completeCodeAttributeForSyntheticMethod(boolean var1, SyntheticMethodBinding var2, int var3, int[] var4) {
        this.field_1718 = this.codeStream.bCodeStream;
        int var5 = this.codeStream.field_1190;
        int var6 = this.codeStream.field_1211;
        this.field_1718[var3 + 6] = (byte)(var6 >> 8);
        this.field_1718[var3 + 7] = (byte)var6;
        int var7 = this.codeStream.field_1204;
        this.field_1718[var3 + 8] = (byte)(var7 >> 8);
        this.field_1718[var3 + 9] = (byte)var7;
        int var8 = this.codeStream.field_1208;
        this.field_1718[var3 + 10] = (byte)(var8 >> 24);
        this.field_1718[var3 + 11] = (byte)(var8 >> 16);
        this.field_1718[var3 + 12] = (byte)(var8 >> 8);
        this.field_1718[var3 + 13] = (byte)var8;
        if (var5 + 40 >= this.field_1718.length) {
            this.resizeContents(40);
        }
        boolean var9 = (this.field_1728 & 8) != 0;
        int var11;
        int var12;
        int var13;
        int var14;
        int var17;
        int var16;
        int var19;
        int var18;
        int var20;
        int var44;
        if (var1) {
            ExceptionLabel[] var10 = this.codeStream.exceptionLabels;
            var11 = 0;
            var12 = 0;
            for (var13 = this.codeStream.field_1194; var12 < var13; ++var12) {
                var11 += this.codeStream.exceptionLabels[var12].count / 2;
            }
            var12 = var11 * 8 + 2;
            if (var12 + var5 >= this.field_1718.length) {
                this.resizeContents(var12);
            }
            this.field_1718[var5++] = (byte)(var11 >> 8);
            this.field_1718[var5++] = (byte)var11;
            var13 = 0;
            for (var14 = this.codeStream.field_1194; var13 < var14; ++var13) {
                ExceptionLabel var15 = var10[var13];
                if (var15 != null) {
                    var16 = 0;
                    var17 = var15.count;
                    if ((var17 & 1) != 0) {
                        this.referenceBinding.scope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1878, new String(var2.selector), this.referenceBinding.scope.problemReporter().referenceContext));
                    }
                    while (var16 < var17) {
                        var18 = var15.ranges[var16++];
                        this.field_1718[var5++] = (byte)(var18 >> 8);
                        this.field_1718[var5++] = (byte)var18;
                        var19 = var15.ranges[var16++];
                        this.field_1718[var5++] = (byte)(var19 >> 8);
                        this.field_1718[var5++] = (byte)var19;
                        var20 = var15.position;
                        if (var9) {
                            StackMapFrameCodeStream var21 = (StackMapFrameCodeStream)this.codeStream;
                            var21.method_2391(var20);
                        }
                        this.field_1718[var5++] = (byte)(var20 >> 8);
                        this.field_1718[var5++] = (byte)var20;
                        if (var15.exceptionType == null) {
                            this.field_1718[var5++] = 0;
                            this.field_1718[var5++] = 0;
                        } else {
                            switch (var15.exceptionType.id) {
                                case 7:
                                    var44 = this.constantPool.method_2466(ConstantPool.field_1421);
                                    break;
                                case 12:
                                    var44 = this.constantPool.method_2466(ConstantPool.field_1411);
                                    break;
                                default:
                                    var44 = this.constantPool.method_2467(var15.exceptionType);
                            }
                            this.field_1718[var5++] = (byte)(var44 >> 8);
                            this.field_1718[var5++] = (byte)var44;
                        }
                    }
                }
            }
        } else {
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 0;
        }
        int var35 = var5;
        var11 = 0;
        var5 += 2;
        if (var5 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        if ((this.field_1728 & 2) != 0) {
            if (var5 + 12 >= this.field_1718.length) {
                this.resizeContents(12);
            }
            boolean var36 = false;
            var13 = this.constantPool.method_2459(AttributeNamesConstants.field_6);
            this.field_1718[var5++] = (byte)(var13 >> 8);
            this.field_1718[var5++] = (byte)var13;
            var14 = var5;
            var5 += 6;
            var12 = Util.getLineNumber(var2.field_288, var4, 0, var4.length - 1);
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = 0;
            this.field_1718[var5++] = (byte)(var12 >> 8);
            this.field_1718[var5++] = (byte)var12;
            this.field_1718[var14++] = 0;
            this.field_1718[var14++] = 0;
            this.field_1718[var14++] = 0;
            this.field_1718[var14++] = 6;
            this.field_1718[var14++] = 0;
            this.field_1718[var14++] = 1;
            ++var11;
        }
        int var25;
        int var27;
        int var26;
        int var29;
        int var28;
        int var37;
        int var42;
        int var43;
        if ((this.field_1728 & 4) != 0) {
            var12 = 0;
            var13 = this.constantPool.method_2459(AttributeNamesConstants.field_7);
            if (var5 + 8 > this.field_1718.length) {
                this.resizeContents(8);
            }
            this.field_1718[var5++] = (byte)(var13 >> 8);
            this.field_1718[var5++] = (byte)var13;
            var14 = var5;
            var5 += 6;
            var17 = 0;
            LocalVariableBinding[] var40 = null;
            var19 = 0;
            var20 = 0;
            for (var44 = this.codeStream.field_1187; var20 < var44; ++var20) {
                LocalVariableBinding var22 = this.codeStream.field_1202[var20];
                if (var22.declaration != null) {
                    TypeBinding var23 = var22.type;
                    boolean var24 = var23.method_162() || var23.method_169();
                    if (var22.field_311 != 0 && var24) {
                        if (var40 == null) {
                            var40 = new LocalVariableBinding[var44];
                        }
                        var40[var17++] = var22;
                    }
                    for (var25 = 0; var25 < var22.field_311; ++var25) {
                        var26 = var22.initializationPCs[var25 << 1];
                        var27 = var22.initializationPCs[(var25 << 1) + 1];
                        if (var26 != var27) {
                            if (var27 == -1) {
                                var22.declaringScope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1877, new String(var22.name)), (ASTNode)var22.declaringScope.method_635().referenceContext);
                            }
                            if (var5 + 10 > this.field_1718.length) {
                                this.resizeContents(10);
                            }
                            ++var12;
                            if (var24) {
                                ++var19;
                            }
                            this.field_1718[var5++] = (byte)(var26 >> 8);
                            this.field_1718[var5++] = (byte)var26;
                            var28 = var27 - var26;
                            this.field_1718[var5++] = (byte)(var28 >> 8);
                            this.field_1718[var5++] = (byte)var28;
                            var37 = this.constantPool.method_2459(var22.name);
                            this.field_1718[var5++] = (byte)(var37 >> 8);
                            this.field_1718[var5++] = (byte)var37;
                            var16 = this.constantPool.method_2459(var23.method_178());
                            this.field_1718[var5++] = (byte)(var16 >> 8);
                            this.field_1718[var5++] = (byte)var16;
                            var29 = var22.field_306;
                            this.field_1718[var5++] = (byte)(var29 >> 8);
                            this.field_1718[var5++] = (byte)var29;
                        }
                    }
                }
            }
            var20 = var12 * 10 + 2;
            this.field_1718[var14++] = (byte)(var20 >> 24);
            this.field_1718[var14++] = (byte)(var20 >> 16);
            this.field_1718[var14++] = (byte)(var20 >> 8);
            this.field_1718[var14++] = (byte)var20;
            this.field_1718[var14++] = (byte)(var12 >> 8);
            this.field_1718[var14] = (byte)var12;
            ++var11;
            if (var17 != 0) {
                var44 = 8 + var19 * 10;
                if (var5 + var44 >= this.field_1718.length) {
                    this.resizeContents(var44);
                }
                var42 = this.constantPool.method_2459(AttributeNamesConstants.field_14);
                this.field_1718[var5++] = (byte)(var42 >> 8);
                this.field_1718[var5++] = (byte)var42;
                var20 = var19 * 10 + 2;
                this.field_1718[var5++] = (byte)(var20 >> 24);
                this.field_1718[var5++] = (byte)(var20 >> 16);
                this.field_1718[var5++] = (byte)(var20 >> 8);
                this.field_1718[var5++] = (byte)var20;
                this.field_1718[var5++] = (byte)(var19 >> 8);
                this.field_1718[var5++] = (byte)var19;
                for (var43 = 0; var43 < var17; ++var43) {
                    LocalVariableBinding var46 = var40[var43];
                    for (var25 = 0; var25 < var46.field_311; ++var25) {
                        var26 = var46.initializationPCs[var25 << 1];
                        var27 = var46.initializationPCs[(var25 << 1) + 1];
                        if (var26 != var27) {
                            this.field_1718[var5++] = (byte)(var26 >> 8);
                            this.field_1718[var5++] = (byte)var26;
                            var28 = var27 - var26;
                            this.field_1718[var5++] = (byte)(var28 >> 8);
                            this.field_1718[var5++] = (byte)var28;
                            var37 = this.constantPool.method_2459(var46.name);
                            this.field_1718[var5++] = (byte)(var37 >> 8);
                            this.field_1718[var5++] = (byte)var37;
                            var16 = this.constantPool.method_2459(var46.type.genericTypeSignature());
                            this.field_1718[var5++] = (byte)(var16 >> 8);
                            this.field_1718[var5++] = (byte)var16;
                            var29 = var46.field_306;
                            this.field_1718[var5++] = (byte)(var29 >> 8);
                            this.field_1718[var5++] = (byte)var29;
                        }
                    }
                }
                ++var11;
            }
        }
        int var30;
        StackMapFrameCodeStream var38;
        ArrayList var39;
        StackMapFrame var41;
        int var47;
        ArrayList var10000;
        int var52;
        if (var9) {
            var38 = (StackMapFrameCodeStream)this.codeStream;
            var38.method_2392(var8);
            if (var38.hasFramePositions()) {
                var10000 = new ArrayList();
                var39 = var10000;
                this.method_3018(var2, var7, this.field_1718, var3 + 14, var8, var39, false);
                var14 = var39.size();
                if (var14 > 1) {
                    var37 = var5;
                    if (var5 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_21);
                    this.field_1718[var5++] = (byte)(var16 >> 8);
                    this.field_1718[var5++] = (byte)var16;
                    var17 = var5;
                    var5 += 4;
                    if (var5 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var18 = var5;
                    var5 += 2;
                    if (var5 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var41 = (StackMapFrame)var39.get(0);
                    StackMapFrame var45 = null;
                    label427:
                    for (var44 = 1; var44 < var14; ++var44) {
                        var45 = var41;
                        var41 = (StackMapFrame)var39.get(var44);
                        var42 = var41.method_2896(var45);
                        VerificationTypeInfo var50;
                        byte var48;
                        switch (var41.method_2890(var45)) {
                            case 0:
                                if (var5 + 1 >= this.field_1718.length) {
                                    this.resizeContents(1);
                                }
                                this.field_1718[var5++] = (byte)var42;
                                break;
                            case 1:
                                if (var5 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var43 = -var41.method_2894(var45);
                                this.field_1718[var5++] = (byte)(251 - var43);
                                this.field_1718[var5++] = (byte)(var42 >> 8);
                                this.field_1718[var5++] = (byte)var42;
                                break;
                            case 2:
                                if (var5 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                var43 = var41.method_2894(var45);
                                this.field_1718[var5++] = (byte)(251 + var43);
                                this.field_1718[var5++] = (byte)(var42 >> 8);
                                this.field_1718[var5++] = (byte)var42;
                                var47 = var41.getIndexOfDifferentLocals(var43);
                                var25 = var41.getNumberOfLocals();
                                var26 = var47;
                                while (true) {
                                    if (var26 >= var41.field_1645.length || var43 <= 0) {
                                        continue label427;
                                    }
                                    if (var5 + 6 >= this.field_1718.length) {
                                        this.resizeContents(6);
                                    }
                                    VerificationTypeInfo var49 = var41.field_1645[var26];
                                    if (var49 == null) {
                                        this.field_1718[var5++] = 0;
                                    } else {
                                        label333:
                                        switch (var49.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var5++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var5++] = (byte)var49.field_336;
                                                switch (var49.field_336) {
                                                    case 7:
                                                        var29 = this.constantPool.method_2466(var49.method_475());
                                                        this.field_1718[var5++] = (byte)(var29 >> 8);
                                                        this.field_1718[var5++] = (byte)var29;
                                                        break label333;
                                                    case 8:
                                                        var28 = var49.field_339;
                                                        this.field_1718[var5++] = (byte)(var28 >> 8);
                                                        this.field_1718[var5++] = (byte)var28;
                                                    default:
                                                        break label333;
                                                }
                                            case 7:
                                                this.field_1718[var5++] = 4;
                                                ++var26;
                                                break;
                                            case 8:
                                                this.field_1718[var5++] = 3;
                                                ++var26;
                                                break;
                                            case 9:
                                                this.field_1718[var5++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var5++] = 5;
                                        }
                                        --var43;
                                    }
                                    ++var26;
                                }
                            case 3:
                                if (var5 + 3 >= this.field_1718.length) {
                                    this.resizeContents(3);
                                }
                                this.field_1718[var5++] = -5;
                                this.field_1718[var5++] = (byte)(var42 >> 8);
                                this.field_1718[var5++] = (byte)var42;
                                break;
                            case 4:
                            default:
                                if (var5 + 5 >= this.field_1718.length) {
                                    this.resizeContents(5);
                                }
                                this.field_1718[var5++] = -1;
                                this.field_1718[var5++] = (byte)(var42 >> 8);
                                this.field_1718[var5++] = (byte)var42;
                                var26 = var5;
                                var5 += 2;
                                var27 = 0;
                                var25 = var41.getNumberOfLocals();
                                var28 = 0;
                                var29 = var41.field_1645 == null ? 0 : var41.field_1645.length;
                                int var33;
                                for (var30 = 0; var30 < var29 && var27 < var25; ++var30) {
                                    if (var5 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var31 = var41.field_1645[var30];
                                    if (var31 == null) {
                                        this.field_1718[var5++] = 0;
                                    } else {
                                        label300:
                                        switch (var31.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var5++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var5++] = (byte)var31.field_336;
                                                switch (var31.field_336) {
                                                    case 7:
                                                        var33 = this.constantPool.method_2466(var31.method_475());
                                                        this.field_1718[var5++] = (byte)(var33 >> 8);
                                                        this.field_1718[var5++] = (byte)var33;
                                                        break label300;
                                                    case 8:
                                                        int var32 = var31.field_339;
                                                        this.field_1718[var5++] = (byte)(var32 >> 8);
                                                        this.field_1718[var5++] = (byte)var32;
                                                    default:
                                                        break label300;
                                                }
                                            case 7:
                                                this.field_1718[var5++] = 4;
                                                ++var30;
                                                break;
                                            case 8:
                                                this.field_1718[var5++] = 3;
                                                ++var30;
                                                break;
                                            case 9:
                                                this.field_1718[var5++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var5++] = 5;
                                        }
                                        ++var27;
                                    }
                                    ++var28;
                                }
                                if (var5 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var26++] = (byte)(var28 >> 8);
                                this.field_1718[var26] = (byte)var28;
                                var30 = var41.field_1643;
                                this.field_1718[var5++] = (byte)(var30 >> 8);
                                this.field_1718[var5++] = (byte)var30;
                                var52 = 0;
                                while (true) {
                                    if (var52 >= var30) {
                                        continue label427;
                                    }
                                    if (var5 + 3 >= this.field_1718.length) {
                                        this.resizeContents(3);
                                    }
                                    VerificationTypeInfo var54 = var41.field_1646[var52];
                                    if (var54 == null) {
                                        this.field_1718[var5++] = 0;
                                    } else {
                                        label290:
                                        switch (var54.method_473()) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 10:
                                                this.field_1718[var5++] = 1;
                                                break;
                                            case 6:
                                            case 11:
                                            default:
                                                this.field_1718[var5++] = (byte)var54.field_336;
                                                switch (var54.field_336) {
                                                    case 7:
                                                        int var34 = this.constantPool.method_2466(var54.method_475());
                                                        this.field_1718[var5++] = (byte)(var34 >> 8);
                                                        this.field_1718[var5++] = (byte)var34;
                                                        break label290;
                                                    case 8:
                                                        var33 = var54.field_339;
                                                        this.field_1718[var5++] = (byte)(var33 >> 8);
                                                        this.field_1718[var5++] = (byte)var33;
                                                    default:
                                                        break label290;
                                                }
                                            case 7:
                                                this.field_1718[var5++] = 4;
                                                break;
                                            case 8:
                                                this.field_1718[var5++] = 3;
                                                break;
                                            case 9:
                                                this.field_1718[var5++] = 2;
                                                break;
                                            case 12:
                                                this.field_1718[var5++] = 5;
                                        }
                                    }
                                    ++var52;
                                }
                            case 5:
                                if (var5 + 4 >= this.field_1718.length) {
                                    this.resizeContents(4);
                                }
                                this.field_1718[var5++] = (byte)(var42 + 64);
                                if (var41.field_1646[0] == null) {
                                    this.field_1718[var5++] = 0;
                                } else {
                                    switch (var41.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var5++] = 1;
                                            continue;
                                        case 6:
                                        case 11:
                                        default:
                                            var50 = var41.field_1646[0];
                                            var48 = (byte)var50.field_336;
                                            this.field_1718[var5++] = var48;
                                            switch (var48) {
                                                case 7:
                                                    var29 = this.constantPool.method_2466(var50.method_475());
                                                    this.field_1718[var5++] = (byte)(var29 >> 8);
                                                    this.field_1718[var5++] = (byte)var29;
                                                    continue;
                                                case 8:
                                                    var28 = var50.field_339;
                                                    this.field_1718[var5++] = (byte)(var28 >> 8);
                                                    this.field_1718[var5++] = (byte)var28;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var5++] = 4;
                                            continue;
                                        case 8:
                                            this.field_1718[var5++] = 3;
                                            continue;
                                        case 9:
                                            this.field_1718[var5++] = 2;
                                            continue;
                                        case 12:
                                            this.field_1718[var5++] = 5;
                                    }
                                }
                                break;
                            case 6:
                                if (var5 + 6 >= this.field_1718.length) {
                                    this.resizeContents(6);
                                }
                                this.field_1718[var5++] = -9;
                                this.field_1718[var5++] = (byte)(var42 >> 8);
                                this.field_1718[var5++] = (byte)var42;
                                if (var41.field_1646[0] == null) {
                                    this.field_1718[var5++] = 0;
                                } else {
                                    switch (var41.field_1646[0].method_473()) {
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 10:
                                            this.field_1718[var5++] = 1;
                                            break;
                                        case 6:
                                        case 11:
                                        default:
                                            var50 = var41.field_1646[0];
                                            var48 = (byte)var50.field_336;
                                            this.field_1718[var5++] = var48;
                                            switch (var48) {
                                                case 7:
                                                    var29 = this.constantPool.method_2466(var50.method_475());
                                                    this.field_1718[var5++] = (byte)(var29 >> 8);
                                                    this.field_1718[var5++] = (byte)var29;
                                                    continue;
                                                case 8:
                                                    var28 = var50.field_339;
                                                    this.field_1718[var5++] = (byte)(var28 >> 8);
                                                    this.field_1718[var5++] = (byte)var28;
                                                default:
                                                    continue;
                                            }
                                        case 7:
                                            this.field_1718[var5++] = 4;
                                            break;
                                        case 8:
                                            this.field_1718[var5++] = 3;
                                            break;
                                        case 9:
                                            this.field_1718[var5++] = 2;
                                            break;
                                        case 12:
                                            this.field_1718[var5++] = 5;
                                    }
                                }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var18++] = (byte)(var14 >> 8);
                        this.field_1718[var18] = (byte)var14;
                        var44 = var5 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var44 >> 24);
                        this.field_1718[var17++] = (byte)(var44 >> 16);
                        this.field_1718[var17++] = (byte)(var44 >> 8);
                        this.field_1718[var17] = (byte)var44;
                        ++var11;
                    } else {
                        var5 = var37;
                    }
                }
            }
        }
        if ((this.field_1728 & 16) != 0) {
            var38 = (StackMapFrameCodeStream)this.codeStream;
            var38.method_2392(var8);
            if (var38.hasFramePositions()) {
                var10000 = new ArrayList();
                var39 = var10000;
                this.method_3018(this.codeStream.methodDeclaration.binding, var7, this.field_1718, var3 + 14, var8, var39, false);
                var14 = var39.size();
                if (var14 > 1) {
                    var37 = var5;
                    if (var5 + 8 >= this.field_1718.length) {
                        this.resizeContents(8);
                    }
                    var16 = this.constantPool.method_2459(AttributeNamesConstants.field_24);
                    this.field_1718[var5++] = (byte)(var16 >> 8);
                    this.field_1718[var5++] = (byte)var16;
                    var17 = var5;
                    var5 += 4;
                    if (var5 + 4 >= this.field_1718.length) {
                        this.resizeContents(4);
                    }
                    var18 = var5;
                    var5 += 2;
                    if (var5 + 2 >= this.field_1718.length) {
                        this.resizeContents(2);
                    }
                    var41 = (StackMapFrame)var39.get(0);
                    for (var20 = 1; var20 < var14; ++var20) {
                        var41 = (StackMapFrame)var39.get(var20);
                        var44 = var41.field_1642;
                        if (var5 + 5 >= this.field_1718.length) {
                            this.resizeContents(5);
                        }
                        this.field_1718[var5++] = (byte)(var44 >> 8);
                        this.field_1718[var5++] = (byte)var44;
                        var42 = var5;
                        var5 += 2;
                        var43 = 0;
                        var47 = var41.getNumberOfLocals();
                        var25 = 0;
                        var26 = var41.field_1645 == null ? 0 : var41.field_1645.length;
                        for (var27 = 0; var27 < var26 && var43 < var47; ++var27) {
                            if (var5 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var51 = var41.field_1645[var27];
                            if (var51 == null) {
                                this.field_1718[var5++] = 0;
                            } else {
                                label270:
                                switch (var51.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var5++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var5++] = (byte)var51.field_336;
                                        switch (var51.field_336) {
                                            case 7:
                                                var30 = this.constantPool.method_2466(var51.method_475());
                                                this.field_1718[var5++] = (byte)(var30 >> 8);
                                                this.field_1718[var5++] = (byte)var30;
                                                break label270;
                                            case 8:
                                                var29 = var51.field_339;
                                                this.field_1718[var5++] = (byte)(var29 >> 8);
                                                this.field_1718[var5++] = (byte)var29;
                                            default:
                                                break label270;
                                        }
                                    case 7:
                                        this.field_1718[var5++] = 4;
                                        ++var27;
                                        break;
                                    case 8:
                                        this.field_1718[var5++] = 3;
                                        ++var27;
                                        break;
                                    case 9:
                                        this.field_1718[var5++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var5++] = 5;
                                }
                                ++var43;
                            }
                            ++var25;
                        }
                        if (var5 + 4 >= this.field_1718.length) {
                            this.resizeContents(4);
                        }
                        this.field_1718[var42++] = (byte)(var25 >> 8);
                        this.field_1718[var42] = (byte)var25;
                        var27 = var41.field_1643;
                        this.field_1718[var5++] = (byte)(var27 >> 8);
                        this.field_1718[var5++] = (byte)var27;
                        for (var28 = 0; var28 < var27; ++var28) {
                            if (var5 + 3 >= this.field_1718.length) {
                                this.resizeContents(3);
                            }
                            VerificationTypeInfo var53 = var41.field_1646[var28];
                            if (var53 == null) {
                                this.field_1718[var5++] = 0;
                            } else {
                                switch (var53.method_473()) {
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 10:
                                        this.field_1718[var5++] = 1;
                                        break;
                                    case 6:
                                    case 11:
                                    default:
                                        this.field_1718[var5++] = (byte)var53.field_336;
                                        switch (var53.field_336) {
                                            case 7:
                                                var52 = this.constantPool.method_2466(var53.method_475());
                                                this.field_1718[var5++] = (byte)(var52 >> 8);
                                                this.field_1718[var5++] = (byte)var52;
                                                continue;
                                            case 8:
                                                var30 = var53.field_339;
                                                this.field_1718[var5++] = (byte)(var30 >> 8);
                                                this.field_1718[var5++] = (byte)var30;
                                            default:
                                                continue;
                                        }
                                    case 7:
                                        this.field_1718[var5++] = 4;
                                        break;
                                    case 8:
                                        this.field_1718[var5++] = 3;
                                        break;
                                    case 9:
                                        this.field_1718[var5++] = 2;
                                        break;
                                    case 12:
                                        this.field_1718[var5++] = 5;
                                }
                            }
                        }
                    }
                    --var14;
                    if (var14 != 0) {
                        this.field_1718[var18++] = (byte)(var14 >> 8);
                        this.field_1718[var18] = (byte)var14;
                        var20 = var5 - var17 - 4;
                        this.field_1718[var17++] = (byte)(var20 >> 24);
                        this.field_1718[var17++] = (byte)(var20 >> 16);
                        this.field_1718[var17++] = (byte)(var20 >> 8);
                        this.field_1718[var17] = (byte)var20;
                        ++var11;
                    } else {
                        var5 = var37;
                    }
                }
            }
        }
        if (var35 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        this.field_1718[var35++] = (byte)(var11 >> 8);
        this.field_1718[var35] = (byte)var11;
        var12 = var5 - (var3 + 6);
        this.field_1718[var3 + 2] = (byte)(var12 >> 24);
        this.field_1718[var3 + 3] = (byte)(var12 >> 16);
        this.field_1718[var3 + 4] = (byte)(var12 >> 8);
        this.field_1718[var3 + 5] = (byte)var12;
        this.field_1719 = var5;
    }

    public void completeCodeAttributeForSyntheticMethod(SyntheticMethodBinding var1, int var2, int[] var3) {
        this.completeCodeAttributeForSyntheticMethod(false, var1, var2, var3);
    }

    public void method_2986(int var1, int var2) {
        this.field_1718[var1++] = (byte)(var2 >> 8);
        this.field_1718[var1] = (byte)var2;
    }

    public char[] fileName() {
        return this.constantPool.UTF8Cache.returnKeyFor(2);
    }

    private void generateAnnotation(Annotation var1, int var2) {
        int var3 = var2;
        if (this.field_1719 + 4 >= this.field_1718.length) {
            this.resizeContents(4);
        }
        TypeBinding var4 = var1.resolvedType;
        if (var4 == null) {
            this.field_1719 = var2;
        } else {
            int var5 = this.constantPool.method_2459(var4.method_178());
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            if (var1 instanceof NormalAnnotation) {
                NormalAnnotation var6 = (NormalAnnotation)var1;
                MemberValuePair[] var7 = var6.memberValuePairs;
                if (var7 != null) {
                    int var8 = var7.length;
                    this.field_1718[this.field_1719++] = (byte)(var8 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var8;
                    for (int var9 = 0; var9 < var8; ++var9) {
                        MemberValuePair var10 = var7[var9];
                        if (this.field_1719 + 2 >= this.field_1718.length) {
                            this.resizeContents(2);
                        }
                        int var11 = this.constantPool.method_2459(var10.name);
                        this.field_1718[this.field_1719++] = (byte)(var11 >> 8);
                        this.field_1718[this.field_1719++] = (byte)var11;
                        MethodBinding var12 = var10.binding;
                        if (var12 == null) {
                            this.field_1719 = var3;
                        } else {
                            try {
                                this.generateElementValue(var10.value, var12.returnType, var3);
                            } catch (ClassCastException var16) {
                                this.field_1719 = var3;
                            } catch (ShouldNotImplement var17) {
                                this.field_1719 = var3;
                            }
                        }
                    }
                } else {
                    this.field_1718[this.field_1719++] = 0;
                    this.field_1718[this.field_1719++] = 0;
                }
            } else if (var1 instanceof SingleMemberAnnotation) {
                SingleMemberAnnotation var18 = (SingleMemberAnnotation)var1;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 1;
                if (this.field_1719 + 2 >= this.field_1718.length) {
                    this.resizeContents(2);
                }
                int var19 = this.constantPool.method_2459(field_70);
                this.field_1718[this.field_1719++] = (byte)(var19 >> 8);
                this.field_1718[this.field_1719++] = (byte)var19;
                MethodBinding var20 = var18.memberValuePairs()[0].binding;
                if (var20 == null) {
                    this.field_1719 = var2;
                } else {
                    try {
                        this.generateElementValue(var18.memberValue, var20.returnType, var3);
                    } catch (ClassCastException var14) {
                        this.field_1719 = var2;
                    } catch (ShouldNotImplement var15) {
                        this.field_1719 = var2;
                    }
                }
            } else {
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
            }
        }
    }

    public void method_2989() {
        if (this.field_1719 + 20 >= this.field_1718.length) {
            this.resizeContents(20);
        }
        int var1 = this.constantPool.method_2459(AttributeNamesConstants.field_9);
        this.field_1718[this.field_1719++] = (byte)(var1 >> 8);
        this.field_1718[this.field_1719++] = (byte)var1;
        this.field_1719 += 12;
    }

    private void generateElementValue(Expression var1, TypeBinding var2, int var3) {
        Constant var4 = var1.constant;
        TypeBinding var5 = var1.resolvedType;
        if (var5 == null) {
            this.field_1719 = var3;
        } else {
            if (var2.method_147() && !var5.method_147()) {
                if (this.field_1719 + 3 >= this.field_1718.length) {
                    this.resizeContents(3);
                }
                this.field_1718[this.field_1719++] = 91;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 1;
            }
            if (var4 != null && var4 != Constant.NotAConstant) {
                this.generateElementValue(var3, var1, var4, var2.method_173());
            } else {
                this.generateElementValueForNonConstantExpression(var1, var3, var5);
            }
        }
    }

    private void generateElementValue(int var1, Expression var2, Constant var3, TypeBinding var4) {
        if (this.field_1719 + 3 >= this.field_1718.length) {
            this.resizeContents(3);
        }
        int var6;
        switch (var4.id) {
            case 2:
                this.field_1718[this.field_1719++] = 67;
                var6 = this.constantPool.literalIndex(var3.intValue());
                this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
                this.field_1718[this.field_1719++] = (byte)var6;
                break;
            case 3:
                this.field_1718[this.field_1719++] = 66;
                var6 = this.constantPool.literalIndex(var3.intValue());
                this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
                this.field_1718[this.field_1719++] = (byte)var6;
                break;
            case 4:
                this.field_1718[this.field_1719++] = 83;
                var6 = this.constantPool.literalIndex(var3.intValue());
                this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
                this.field_1718[this.field_1719++] = (byte)var6;
                break;
            case 5:
                this.field_1718[this.field_1719++] = 90;
                int var5 = this.constantPool.literalIndex(var3.booleanValue() ? 1 : 0);
                this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
                this.field_1718[this.field_1719++] = (byte)var5;
            case 6:
            default:
                break;
            case 7:
                this.field_1718[this.field_1719++] = 74;
                int var9 = this.constantPool.literalIndex(var3.longValue());
                this.field_1718[this.field_1719++] = (byte)(var9 >> 8);
                this.field_1718[this.field_1719++] = (byte)var9;
                break;
            case 8:
                this.field_1718[this.field_1719++] = 68;
                int var8 = this.constantPool.literalIndex(var3.doubleValue());
                this.field_1718[this.field_1719++] = (byte)(var8 >> 8);
                this.field_1718[this.field_1719++] = (byte)var8;
                break;
            case 9:
                this.field_1718[this.field_1719++] = 70;
                int var7 = this.constantPool.literalIndex(var3.floatValue());
                this.field_1718[this.field_1719++] = (byte)(var7 >> 8);
                this.field_1718[this.field_1719++] = (byte)var7;
                break;
            case 10:
                this.field_1718[this.field_1719++] = 73;
                var6 = this.constantPool.literalIndex(var3.intValue());
                this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
                this.field_1718[this.field_1719++] = (byte)var6;
                break;
            case 11:
                this.field_1718[this.field_1719++] = 115;
                int var10 = this.constantPool.method_2459(((StringConstant)var3).method_3287().toCharArray());
                if (var10 == -1) {
                    if (!this.creatingProblemType) {
                        TypeDeclaration var11 = this.referenceBinding.scope.referenceContext;
                        var11.scope.problemReporter().method_1760(var2);
                    } else {
                        this.field_1719 = var1;
                    }
                } else {
                    this.field_1718[this.field_1719++] = (byte)(var10 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var10;
                }
        }
    }

    private void generateElementValueForNonConstantExpression(Expression var1, int var2, TypeBinding var3) {
        if (var3 != null) {
            int var6;
            int var9;
            if (var3.method_153()) {
                if (this.field_1719 + 5 >= this.field_1718.length) {
                    this.resizeContents(5);
                }
                this.field_1718[this.field_1719++] = 101;
                FieldBinding var4 = null;
                if (var1 instanceof QualifiedNameReference) {
                    QualifiedNameReference var5 = (QualifiedNameReference)var1;
                    var4 = (FieldBinding)var5.field_748;
                } else if (var1 instanceof SingleNameReference) {
                    SingleNameReference var7 = (SingleNameReference)var1;
                    var4 = (FieldBinding)var7.field_748;
                } else {
                    this.field_1719 = var2;
                }
                if (var4 != null) {
                    var9 = this.constantPool.method_2459(var4.type.method_178());
                    var6 = this.constantPool.method_2459(var4.name);
                    this.field_1718[this.field_1719++] = (byte)(var9 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var9;
                    this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var6;
                }
            } else if (var3.method_145()) {
                if (this.field_1719 + 1 >= this.field_1718.length) {
                    this.resizeContents(1);
                }
                this.field_1718[this.field_1719++] = 64;
                this.generateAnnotation((Annotation)var1, var2);
            } else if (var3.method_147()) {
                if (this.field_1719 + 3 >= this.field_1718.length) {
                    this.resizeContents(3);
                }
                this.field_1718[this.field_1719++] = 91;
                if (var1 instanceof ArrayInitializer) {
                    ArrayInitializer var8 = (ArrayInitializer)var1;
                    var9 = var8.expressions != null ? var8.expressions.length : 0;
                    this.field_1718[this.field_1719++] = (byte)(var9 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var9;
                    for (var6 = 0; var6 < var9; ++var6) {
                        this.generateElementValue(var8.expressions[var6], var3.method_173(), var2);
                    }
                } else {
                    this.field_1719 = var2;
                }
            } else {
                if (this.field_1719 + 3 >= this.field_1718.length) {
                    this.resizeContents(3);
                }
                this.field_1718[this.field_1719++] = 99;
                if (var1 instanceof ClassLiteralAccess) {
                    ClassLiteralAccess var10 = (ClassLiteralAccess)var1;
                    var9 = this.constantPool.method_2459(var10.targetType.method_178());
                    this.field_1718[this.field_1719++] = (byte)(var9 >> 8);
                    this.field_1718[this.field_1719++] = (byte)var9;
                } else {
                    this.field_1719 = var2;
                }
            }
        } else {
            this.field_1719 = var2;
        }
    }

    public int generateMethodInfoAttribute(MethodBinding var1) {
        this.field_1719 += 2;
        if (this.field_1719 + 2 >= this.field_1718.length) {
            this.resizeContents(2);
        }
        int var3 = 0;
        ReferenceBinding[] var2 = var1.thrownExceptions;
        int var4;
        int var5;
        int var6;
        if (var1.thrownExceptions != Binding.field_151) {
            var4 = var2.length;
            var5 = 8 + var4 * 2;
            if (var5 + this.field_1719 >= this.field_1718.length) {
                this.resizeContents(var5);
            }
            var6 = this.constantPool.method_2459(AttributeNamesConstants.field_10);
            this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
            this.field_1718[this.field_1719++] = (byte)var6;
            int var7 = var4 * 2 + 2;
            this.field_1718[this.field_1719++] = (byte)(var7 >> 24);
            this.field_1718[this.field_1719++] = (byte)(var7 >> 16);
            this.field_1718[this.field_1719++] = (byte)(var7 >> 8);
            this.field_1718[this.field_1719++] = (byte)var7;
            this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
            this.field_1718[this.field_1719++] = (byte)var4;
            for (int var8 = 0; var8 < var4; ++var8) {
                int var9 = this.constantPool.method_2467(var2[var8]);
                this.field_1718[this.field_1719++] = (byte)(var9 >> 8);
                this.field_1718[this.field_1719++] = (byte)var9;
            }
            ++var3;
        }
        if (var1.method_361()) {
            if (this.field_1719 + 6 >= this.field_1718.length) {
                this.resizeContents(6);
            }
            var4 = this.constantPool.method_2459(AttributeNamesConstants.field_12);
            this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
            this.field_1718[this.field_1719++] = (byte)var4;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            ++var3;
        }
        if (this.targetJDK < 3211264L) {
            if (var1.method_372()) {
                if (this.field_1719 + 6 >= this.field_1718.length) {
                    this.resizeContents(6);
                }
                var4 = this.constantPool.method_2459(AttributeNamesConstants.field_4);
                this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
                this.field_1718[this.field_1719++] = (byte)var4;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
                ++var3;
            }
            if (var1.method_374()) {
                if (this.field_1719 + 6 >= this.field_1718.length) {
                    this.resizeContents(6);
                }
                var4 = this.constantPool.method_2459(AttributeNamesConstants.field_23);
                this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
                this.field_1718[this.field_1719++] = (byte)var4;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
                this.field_1718[this.field_1719++] = 0;
                ++var3;
            }
        }
        char[] var10 = var1.method_351();
        if (var10 != null) {
            if (this.field_1719 + 8 >= this.field_1718.length) {
                this.resizeContents(8);
            }
            var5 = this.constantPool.method_2459(AttributeNamesConstants.field_13);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 0;
            this.field_1718[this.field_1719++] = 2;
            var6 = this.constantPool.method_2459(var10);
            this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
            this.field_1718[this.field_1719++] = (byte)var6;
            ++var3;
        }
        if (this.targetJDK >= 3211264L) {
            AbstractMethodDeclaration var11 = var1.sourceMethod();
            if (var11 != null) {
                Annotation[] var12 = var11.annotations;
                if (var12 != null) {
                    var3 += this.generateRuntimeAnnotations(var12);
                }
                if ((var1.tagBits & 1024L) != 0L) {
                    Argument[] var13 = var11.arguments;
                    if (var13 != null) {
                        var3 += this.generateRuntimeAnnotationsForParameters(var13);
                    }
                }
            }
        }
        if ((var1.tagBits & 128L) != 0L) {
            this.field_1732 = var1.method_348(this.field_1732);
        }
        return var3;
    }

    public int generateMethodInfoAttribute(MethodBinding var1, AnnotationMethodDeclaration var2) {
        int var3 = this.generateMethodInfoAttribute(var1);
        int var4 = this.field_1719;
        if ((var2.field_482 & 131072) != 0) {
            int var5 = this.constantPool.method_2459(AttributeNamesConstants.field_16);
            this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
            this.field_1718[this.field_1719++] = (byte)var5;
            int var6 = this.field_1719;
            this.field_1719 += 4;
            if (this.field_1719 + 4 >= this.field_1718.length) {
                this.resizeContents(4);
            }
            this.generateElementValue(var2.defaultValue, var2.binding.returnType, var4);
            if (this.field_1719 != var4) {
                int var7 = this.field_1719 - var6 - 4;
                this.field_1718[var6++] = (byte)(var7 >> 24);
                this.field_1718[var6++] = (byte)(var7 >> 16);
                this.field_1718[var6++] = (byte)(var7 >> 8);
                this.field_1718[var6++] = (byte)var7;
                ++var3;
            }
        }
        return var3;
    }

    public void generateMethodInfoHeader(MethodBinding var1) {
        this.generateMethodInfoHeader(var1, var1.modifiers);
    }

    public void generateMethodInfoHeader(MethodBinding var1, int var2) {
        ++this.field_1725;
        if (this.field_1719 + 10 >= this.field_1718.length) {
            this.resizeContents(10);
        }
        if (this.targetJDK < 3211264L) {
            var2 &= -4225;
        }
        if ((var1.tagBits & 1024L) != 0L) {
            var2 &= -3;
        }
        this.field_1718[this.field_1719++] = (byte)(var2 >> 8);
        this.field_1718[this.field_1719++] = (byte)var2;
        int var3 = this.constantPool.method_2459(var1.selector);
        this.field_1718[this.field_1719++] = (byte)(var3 >> 8);
        this.field_1718[this.field_1719++] = (byte)var3;
        int var4 = this.constantPool.method_2459(var1.signature(this));
        this.field_1718[this.field_1719++] = (byte)(var4 >> 8);
        this.field_1718[this.field_1719++] = (byte)var4;
    }

    public void method_2997() {
        ++this.field_1725;
        if (this.field_1719 + 10 >= this.field_1718.length) {
            this.resizeContents(10);
        }
        this.field_1718[this.field_1719++] = 0;
        this.field_1718[this.field_1719++] = 8;
        int var1 = this.constantPool.method_2459(ConstantPool.field_1343);
        this.field_1718[this.field_1719++] = (byte)(var1 >> 8);
        this.field_1718[this.field_1719++] = (byte)var1;
        int var2 = this.constantPool.method_2459(ConstantPool.field_1345);
        this.field_1718[this.field_1719++] = (byte)(var2 >> 8);
        this.field_1718[this.field_1719++] = (byte)var2;
        this.field_1718[this.field_1719++] = 0;
        this.field_1718[this.field_1719++] = 1;
    }

    public void generateMissingAbstractMethods(MethodDeclaration[] var1, CompilationResult var2) {
        if (var1 != null) {
            TypeDeclaration var3 = this.referenceBinding.scope.referenceContext;
            int var4 = var3.method_5();
            int var5 = var3.method_6();
            int var6 = 0;
            for (int var7 = var1.length; var6 < var7; ++var6) {
                MethodDeclaration var8 = var1[var6];
                MethodBinding var9 = var8.binding;
                String var10 = new String(var9.readableName());
                CategorizedProblem[] var11 = var2.field_1673;
                int var12 = var2.field_1675;
                for (int var13 = 0; var13 < var12; ++var13) {
                    CategorizedProblem var14 = var11[var13];
                    if (var14 != null && var14.method_1398() == 67109264 && var14.method_1404().indexOf(var10) != -1 && var14.method_1401() >= var4 && var14.method_1402() <= var5) {
                        this.addMissingAbstractProblemMethod(var8, var9, var14, var2);
                    }
                }
            }
        }
    }

    private void generateMissingTypesAttribute() {
        int var1 = this.field_1732.size();
        int[] var2 = new int[var1];
        int var3 = 0;
        if (var1 > 1) {
            List var10000 = this.field_1732;
            ClassFile$2 var10001 = new ClassFile$2(this);
            Arrays.sort(var10000, var10001);
        }
        int var4 = 0;
        int var5;
        int var6;
        for (var5 = 0; var5 < var1; ++var5) {
            var6 = this.constantPool.method_2467((TypeBinding)this.field_1732.get(var5));
            if (var4 != var6) {
                var4 = var6;
                var2[var3++] = var6;
            }
        }
        var5 = var3 * 2 + 2;
        if (this.field_1719 + var5 + 6 >= this.field_1718.length) {
            this.resizeContents(var5 + 6);
        }
        var6 = this.constantPool.method_2459(AttributeNamesConstants.field_25);
        this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
        this.field_1718[this.field_1719++] = (byte)var6;
        this.field_1718[this.field_1719++] = (byte)(var5 >> 24);
        this.field_1718[this.field_1719++] = (byte)(var5 >> 16);
        this.field_1718[this.field_1719++] = (byte)(var5 >> 8);
        this.field_1718[this.field_1719++] = (byte)var5;
        this.field_1718[this.field_1719++] = (byte)(var3 >> 8);
        this.field_1718[this.field_1719++] = (byte)var3;
        for (int var7 = 0; var7 < var3; ++var7) {
            int var8 = var2[var7];
            this.field_1718[this.field_1719++] = (byte)(var8 >> 8);
            this.field_1718[this.field_1719++] = (byte)var8;
        }
    }

    private int generateRuntimeAnnotations(Annotation[] var1) {
        int var2 = 0;
        int var3 = var1.length;
        int var4 = 0;
        int var5 = 0;
        int var6;
        for (var6 = 0; var6 < var3; ++var6) {
            Annotation var7 = var1[var6];
            if (this.method_3009(var7)) {
                ++var5;
            } else if (this.method_3010(var7)) {
                ++var4;
            }
        }
        var6 = this.field_1719;
        int var8;
        int var9;
        int var10;
        int var11;
        Annotation var12;
        int var13;
        int var14;
        if (var5 != 0) {
            if (this.field_1719 + 10 >= this.field_1718.length) {
                this.resizeContents(10);
            }
            var14 = this.constantPool.method_2459(AttributeNamesConstants.field_17);
            this.field_1718[this.field_1719++] = (byte)(var14 >> 8);
            this.field_1718[this.field_1719++] = (byte)var14;
            var8 = this.field_1719;
            this.field_1719 += 4;
            var9 = this.field_1719;
            this.field_1719 += 2;
            var10 = 0;
            for (var11 = 0; var11 < var3 && var5 != 0; ++var11) {
                var12 = var1[var11];
                if (this.method_3009(var12)) {
                    var13 = this.field_1719;
                    this.generateAnnotation(var12, var13);
                    --var5;
                    if (this.field_1719 != var13) {
                        ++var10;
                    }
                }
            }
            if (var10 != 0) {
                this.field_1718[var9++] = (byte)(var10 >> 8);
                this.field_1718[var9++] = (byte)var10;
                var11 = this.field_1719 - var8 - 4;
                this.field_1718[var8++] = (byte)(var11 >> 24);
                this.field_1718[var8++] = (byte)(var11 >> 16);
                this.field_1718[var8++] = (byte)(var11 >> 8);
                this.field_1718[var8++] = (byte)var11;
                ++var2;
            } else {
                this.field_1719 = var6;
            }
        }
        var6 = this.field_1719;
        if (var4 != 0) {
            if (this.field_1719 + 10 >= this.field_1718.length) {
                this.resizeContents(10);
            }
            var14 = this.constantPool.method_2459(AttributeNamesConstants.field_18);
            this.field_1718[this.field_1719++] = (byte)(var14 >> 8);
            this.field_1718[this.field_1719++] = (byte)var14;
            var8 = this.field_1719;
            this.field_1719 += 4;
            var9 = this.field_1719;
            this.field_1719 += 2;
            var10 = 0;
            for (var11 = 0; var11 < var3 && var4 != 0; ++var11) {
                var12 = var1[var11];
                if (this.method_3010(var12)) {
                    --var4;
                    var13 = this.field_1719;
                    this.generateAnnotation(var12, var13);
                    if (this.field_1719 != var13) {
                        ++var10;
                    }
                }
            }
            if (var10 != 0) {
                this.field_1718[var9++] = (byte)(var10 >> 8);
                this.field_1718[var9++] = (byte)var10;
                var11 = this.field_1719 - var8 - 4;
                this.field_1718[var8++] = (byte)(var11 >> 24);
                this.field_1718[var8++] = (byte)(var11 >> 16);
                this.field_1718[var8++] = (byte)(var11 >> 8);
                this.field_1718[var8++] = (byte)var11;
                ++var2;
            } else {
                this.field_1719 = var6;
            }
        }
        return var2;
    }

    private int generateRuntimeAnnotationsForParameters(Argument[] var1) {
        int var2 = var1.length;
        int var5 = 0;
        int var6 = 0;
        int[][] var7 = new int[var2][2];
        int var8;
        int var11;
        int var12;
        for (var8 = 0; var8 < var2; ++var8) {
            Argument var9 = var1[var8];
            Annotation[] var10 = var9.annotations;
            if (var10 != null) {
                var11 = 0;
                for (var12 = var10.length; var11 < var12; ++var11) {
                    Annotation var13 = var10[var11];
                    if (this.method_3009(var13)) {
                        ++var7[var8][1];
                        ++var5;
                    } else if (this.method_3010(var13)) {
                        ++var7[var8][0];
                        ++var6;
                    }
                }
            }
        }
        var8 = 0;
        int var23 = this.field_1719;
        int var14;
        int var15;
        Argument var17;
        int var16;
        int var19;
        Annotation[] var18;
        Annotation var21;
        int var20;
        int var22;
        int var25;
        int var24;
        if (var5 != 0) {
            var24 = 0;
            if (this.field_1719 + 7 >= this.field_1718.length) {
                this.resizeContents(7);
            }
            var11 = this.constantPool.method_2459(AttributeNamesConstants.field_19);
            this.field_1718[this.field_1719++] = (byte)(var11 >> 8);
            this.field_1718[this.field_1719++] = (byte)var11;
            var12 = this.field_1719;
            this.field_1719 += 4;
            this.field_1718[this.field_1719++] = (byte)var2;
            for (var25 = 0; var25 < var2; ++var25) {
                if (this.field_1719 + 2 >= this.field_1718.length) {
                    this.resizeContents(2);
                }
                if (var5 == 0) {
                    this.field_1718[this.field_1719++] = 0;
                    this.field_1718[this.field_1719++] = 0;
                } else {
                    var14 = var7[var25][1];
                    var15 = this.field_1719;
                    this.field_1719 += 2;
                    var16 = 0;
                    if (var14 != 0) {
                        var17 = var1[var25];
                        var18 = var17.annotations;
                        var19 = 0;
                        for (var20 = var18.length; var19 < var20; ++var19) {
                            var21 = var18[var19];
                            if (this.method_3009(var21)) {
                                var22 = this.field_1719;
                                this.generateAnnotation(var21, var22);
                                if (this.field_1719 != var22) {
                                    ++var16;
                                    ++var24;
                                }
                                --var5;
                            }
                        }
                    }
                    this.field_1718[var15++] = (byte)(var16 >> 8);
                    this.field_1718[var15] = (byte)var16;
                }
            }
            if (var24 != 0) {
                var25 = this.field_1719 - var12 - 4;
                this.field_1718[var12++] = (byte)(var25 >> 24);
                this.field_1718[var12++] = (byte)(var25 >> 16);
                this.field_1718[var12++] = (byte)(var25 >> 8);
                this.field_1718[var12++] = (byte)var25;
                ++var8;
            } else {
                this.field_1719 = var23;
            }
        }
        if (var6 != 0) {
            var24 = 0;
            if (this.field_1719 + 7 >= this.field_1718.length) {
                this.resizeContents(7);
            }
            var11 = this.constantPool.method_2459(AttributeNamesConstants.field_20);
            this.field_1718[this.field_1719++] = (byte)(var11 >> 8);
            this.field_1718[this.field_1719++] = (byte)var11;
            var12 = this.field_1719;
            this.field_1719 += 4;
            this.field_1718[this.field_1719++] = (byte)var2;
            for (var25 = 0; var25 < var2; ++var25) {
                if (this.field_1719 + 2 >= this.field_1718.length) {
                    this.resizeContents(2);
                }
                if (var6 == 0) {
                    this.field_1718[this.field_1719++] = 0;
                    this.field_1718[this.field_1719++] = 0;
                } else {
                    var14 = var7[var25][0];
                    var15 = this.field_1719;
                    this.field_1719 += 2;
                    var16 = 0;
                    if (var14 != 0) {
                        var17 = var1[var25];
                        var18 = var17.annotations;
                        var19 = 0;
                        for (var20 = var18.length; var19 < var20; ++var19) {
                            var21 = var18[var19];
                            if (this.method_3010(var21)) {
                                var22 = this.field_1719;
                                this.generateAnnotation(var21, var22);
                                if (this.field_1719 != var22) {
                                    ++var16;
                                    ++var24;
                                }
                                --var6;
                            }
                        }
                    }
                    this.field_1718[var15++] = (byte)(var16 >> 8);
                    this.field_1718[var15] = (byte)var16;
                }
            }
            if (var24 != 0) {
                var25 = this.field_1719 - var12 - 4;
                this.field_1718[var12++] = (byte)(var25 >> 24);
                this.field_1718[var12++] = (byte)(var25 >> 16);
                this.field_1718[var12++] = (byte)(var25 >> 8);
                this.field_1718[var12++] = (byte)var25;
                ++var8;
            } else {
                this.field_1719 = var23;
            }
        }
        return var8;
    }

    private int getParametersCount(char[] var1) {
        int var2 = CharOperation.method_1371('(', var1);
        ++var2;
        char var3 = var1[var2];
        if (var3 == 41) {
            return 0;
        } else {
            int var4 = 0;
            while (true) {
                var3 = var1[var2];
                if (var3 == 41) {
                    return var4;
                }
                int var5;
                switch (var3) {
                    case 66:
                    case 67:
                    case 68:
                    case 70:
                    case 73:
                    case 74:
                    case 83:
                    case 90:
                        ++var4;
                        ++var2;
                        break;
                    case 69:
                    case 71:
                    case 72:
                    case 75:
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
                    default:
                        throw new IllegalArgumentException();
                    case 76:
                        var5 = CharOperation.method_1374(';', var1, var2 + 1);
                        ++var4;
                        var2 = var5 + 1;
                        break;
                    case 91:
                        var5 = this.scanType(var1, var2 + 1);
                        ++var4;
                        var2 = var5 + 1;
                }
            }
        }
    }

    private char[] getReturnType(char[] var1) {
        int var2 = CharOperation.method_1376(')', var1);
        return CharOperation.subarray(var1, var2 + 1, var1.length);
    }

    private final int method_3004(byte[] var1, int var2, int var3) {
        int var4 = var2 + var3;
        return ((var1[var4++] & 255) << 24) + ((var1[var4++] & 255) << 16) + ((var1[var4++] & 255) << 8) + (var1[var4] & 255);
    }

    protected void initByteArrays() {
        int var1 = this.referenceBinding.methods().length + this.referenceBinding.fields().length;
        this.field_1722 = new byte[1500];
        this.field_1718 = new byte[var1 < 15 ? 400 : 1500];
    }

    public void initialize(SourceTypeBinding var1, ClassFile var2, boolean var3) {
        this.field_1722[this.field_1723++] = -54;
        this.field_1722[this.field_1723++] = -2;
        this.field_1722[this.field_1723++] = -70;
        this.field_1722[this.field_1723++] = -66;
        long var4 = this.targetJDK;
        if (var4 == 3342336L) {
            var4 = 3276800L;
        }
        this.field_1722[this.field_1723++] = (byte)((int)(var4 >> 8));
        this.field_1722[this.field_1723++] = (byte)((int)(var4 >> 0));
        this.field_1722[this.field_1723++] = (byte)((int)(var4 >> 24));
        this.field_1722[this.field_1723++] = (byte)((int)(var4 >> 16));
        this.field_1717 = this.field_1723;
        this.field_1723 += 2;
        this.constantPool.initialize(this);
        int var6 = var1.method_205();
        if (var1.method_223()) {
            var6 &= -2;
        }
        if (var1.method_224()) {
            var6 |= 1;
        }
        var6 &= -2351;
        if (!var1.method_157()) {
            var6 |= 32;
        }
        this.enclosingClassFile = var2;
        this.field_1718[this.field_1719++] = (byte)(var6 >> 8);
        this.field_1718[this.field_1719++] = (byte)var6;
        int var7 = this.constantPool.method_2467(var1);
        this.field_1718[this.field_1719++] = (byte)(var7 >> 8);
        this.field_1718[this.field_1719++] = (byte)var7;
        int var8;
        if (var1.method_157()) {
            var8 = this.constantPool.method_2466(ConstantPool.field_1422);
        } else {
            var8 = var1.superclass == null ? 0 : this.constantPool.method_2467(var1.superclass);
        }
        this.field_1718[this.field_1719++] = (byte)(var8 >> 8);
        this.field_1718[this.field_1719++] = (byte)var8;
        ReferenceBinding[] var9 = var1.superInterfaces();
        int var10 = var9.length;
        this.field_1718[this.field_1719++] = (byte)(var10 >> 8);
        this.field_1718[this.field_1719++] = (byte)var10;
        for (int var11 = 0; var11 < var10; ++var11) {
            int var12 = this.constantPool.method_2467(var9[var11]);
            this.field_1718[this.field_1719++] = (byte)(var12 >> 8);
            this.field_1718[this.field_1719++] = (byte)var12;
        }
        this.creatingProblemType = var3;
        if (this.enclosingClassFile == null) {
            this.codeStream.field_1203 = var1.scope.referenceType().field_591;
        } else {
            ClassFile var13 = this.outerMostEnclosingClassFile();
            this.codeStream.field_1203 = var13.codeStream.field_1203;
        }
    }

    private void initializeDefaultLocals(StackMapFrame var1, MethodBinding var2, int var3, int var4) {
        if (var3 != 0) {
            int var5 = 0;
            boolean var6 = var2.method_358();
            LocalVariableBinding var7;
            LocalVariableBinding var10000;
            VerificationTypeInfo var10002;
            if (var6) {
                var10000 = new LocalVariableBinding("this".toCharArray(), var2.declaringClass, 0, false);
                var7 = var10000;
                var7.field_306 = 0;
                this.codeStream.method_2358(var7);
                var7.method_415(0);
                var7.method_414(var4);
                var10002 = new VerificationTypeInfo(6, var2.declaringClass);
                var1.method_2899(var5, var10002);
                ++var5;
            } else if (!var2.method_370()) {
                var10000 = new LocalVariableBinding("this".toCharArray(), var2.declaringClass, 0, false);
                var7 = var10000;
                var7.field_306 = 0;
                this.codeStream.method_2358(var7);
                var7.method_415(0);
                var7.method_414(var4);
                var10002 = new VerificationTypeInfo(7, var2.declaringClass);
                var1.method_2899(var5, var10002);
                ++var5;
            }
            int var8;
            int var9;
            TypeBinding[] var15;
            TypeBinding var19;
            if (var6) {
                if (var2.declaringClass.method_153()) {
                    var10000 = new LocalVariableBinding(" name".toCharArray(), this.referenceBinding.scope.method_610(), 0, false);
                    var7 = var10000;
                    var7.field_306 = var5;
                    this.codeStream.method_2358(var7);
                    var7.method_415(0);
                    var7.method_414(var4);
                    var10002 = new VerificationTypeInfo(11, ConstantPool.field_1432);
                    var1.method_2899(var5, var10002);
                    ++var5;
                    var10000 = new LocalVariableBinding(" ordinal".toCharArray(), TypeBinding.field_179, 0, false);
                    var7 = var10000;
                    var7.field_306 = var5;
                    this.codeStream.method_2358(var7);
                    var7.method_415(0);
                    var7.method_414(var4);
                    var10002 = new VerificationTypeInfo(TypeBinding.field_179);
                    var1.method_2899(var5, var10002);
                    ++var5;
                }
                if (var2.declaringClass.method_160()) {
                    ReferenceBinding[] var16;
                    if ((var16 = var2.declaringClass.syntheticEnclosingInstanceTypes()) != null) {
                        var8 = 0;
                        for (var9 = var16.length; var8 < var9; ++var8) {
                            var10000 = new LocalVariableBinding((" enclosingType" + var8).toCharArray(), var16[var8], 0, false);
                            LocalVariableBinding var10 = var10000;
                            var10.field_306 = var5;
                            this.codeStream.method_2358(var10);
                            var10.method_415(0);
                            var10.method_414(var4);
                            var10002 = new VerificationTypeInfo(var16[var8]);
                            var1.method_2899(var5, var10002);
                            ++var5;
                        }
                    }
                    TypeBinding[] var14 = var2.parameters;
                    int var20;
                    if (var2.parameters != null) {
                        var9 = 0;
                        for (var20 = var14.length; var9 < var20; ++var9) {
                            TypeBinding var11 = var14[var9];
                            var10002 = new VerificationTypeInfo(var11);
                            var1.method_2899(var5, var10002);
                            switch (var11.id) {
                                case 7:
                                case 8:
                                    var5 += 2;
                                    break;
                                default:
                                    ++var5;
                            }
                        }
                    }
                    SyntheticArgumentBinding[] var17;
                    if ((var17 = var2.declaringClass.syntheticOuterLocalVariables()) != null) {
                        var20 = 0;
                        for (int var18 = var17.length; var20 < var18; ++var20) {
                            TypeBinding var12 = var17[var20].type;
                            var10000 = new LocalVariableBinding((" synthetic" + var20).toCharArray(), var12, 0, false);
                            LocalVariableBinding var13 = var10000;
                            var13.field_306 = var5;
                            this.codeStream.method_2358(var13);
                            var13.method_415(0);
                            var13.method_414(var4);
                            var10002 = new VerificationTypeInfo(var12);
                            var1.method_2899(var5, var10002);
                            switch (var12.id) {
                                case 7:
                                case 8:
                                    var5 += 2;
                                    break;
                                default:
                                    ++var5;
                            }
                        }
                    }
                } else {
                    var15 = var2.parameters;
                    if (var2.parameters != null) {
                        var8 = 0;
                        for (var9 = var15.length; var8 < var9; ++var8) {
                            var19 = var15[var8];
                            var10002 = new VerificationTypeInfo(var19);
                            var1.method_2899(var5, var10002);
                            switch (var19.id) {
                                case 7:
                                case 8:
                                    var5 += 2;
                                    break;
                                default:
                                    ++var5;
                            }
                        }
                    }
                }
            } else {
                var15 = var2.parameters;
                if (var2.parameters != null) {
                    var8 = 0;
                    for (var9 = var15.length; var8 < var9; ++var8) {
                        var19 = var15[var8];
                        var10002 = new VerificationTypeInfo(var19);
                        var1.method_2899(var5, var10002);
                        switch (var19.id) {
                            case 7:
                            case 8:
                                var5 += 2;
                                break;
                            default:
                                ++var5;
                        }
                    }
                }
            }
        }
    }

    private void initializeLocals(boolean var1, int var2, StackMapFrame var3) {
        VerificationTypeInfo[] var4 = var3.field_1645;
        int var5 = var4.length;
        int var6 = 0;
        if (!var1) {
            var6 = 1;
        }
        while (var6 < var5) {
            var4[var6] = null;
            ++var6;
        }
        var6 = 0;
        for (int var7 = this.codeStream.field_1187; var6 < var7; ++var6) {
            LocalVariableBinding var8 = this.codeStream.field_1202[var6];
            if (var8 != null) {
                int var9 = var8.field_306;
                TypeBinding var10 = var8.type;
                for (int var11 = 0; var11 < var8.field_311; ++var11) {
                    int var12 = var8.initializationPCs[var11 << 1];
                    int var13 = var8.initializationPCs[(var11 << 1) + 1];
                    if (var2 >= var12 && var2 < var13) {
                        if (var3.field_1645[var9] == null) {
                            VerificationTypeInfo[] var10000 = var3.field_1645;
                            VerificationTypeInfo var10002 = new VerificationTypeInfo(var10);
                            var10000[var9] = var10002;
                        }
                        break;
                    }
                }
            }
        }
    }

    private boolean method_3009(Annotation var1) {
        TypeBinding var2 = var1.resolvedType;
        if (var2 == null) {
            return false;
        } else {
            long var3 = var2.getAnnotationTagBits();
            return (var3 & 52776558133248L) == 0L ? true : (var3 & 52776558133248L) == 35184372088832L;
        }
    }

    private boolean method_3010(Annotation var1) {
        TypeBinding var2 = var1.resolvedType;
        if (var2 == null) {
            return false;
        } else {
            long var3 = var2.getAnnotationTagBits();
            return (var3 & 52776558133248L) == 0L ? false : (var3 & 52776558133248L) == 52776558133248L;
        }
    }

    public ClassFile outerMostEnclosingClassFile() {
        ClassFile var1;
        for (var1 = this; var1.enclosingClassFile != null; var1 = var1.enclosingClassFile) {
            ;
        }
        return var1;
    }

    public void recordInnerClasses(TypeBinding var1) {
        if (this.field_1724 == null) {
            this.field_1724 = new Vector(5);
        }
        ReferenceBinding var2 = (ReferenceBinding)var1;
        this.field_1724.addElement(var2.erasure());
        for (ReferenceBinding var3 = var2.enclosingType(); var3 != null && var3.method_160(); var3 = var3.enclosingType()) {
            this.field_1724.addElement(var3.erasure());
        }
    }

    public void reset(SourceTypeBinding var1) {
        CompilerOptions var2 = var1.scope.compilerOptions();
        this.referenceBinding = var1;
        this.isNestedType = var1.method_160();
        this.targetJDK = var2.field_1929;
        this.field_1728 = var2.field_1926;
        if (this.targetJDK >= 3276800L) {
            this.field_1728 |= 8;
        } else if (this.targetJDK == 2949124L) {
            this.targetJDK = 2949123L;
            this.field_1728 |= 16;
        }
        this.bytes = null;
        this.constantPool.reset();
        this.codeStream.method_2367(this);
        this.field_1717 = 0;
        this.field_1719 = 0;
        this.creatingProblemType = false;
        this.enclosingClassFile = null;
        this.field_1723 = 0;
        this.field_1725 = 0;
        this.field_1726 = 0;
        if (this.field_1724 != null) {
            this.field_1724.removeAllElements();
        }
        this.field_1732 = null;
    }

    private final void resizeContents(int var1) {
        int var2 = this.field_1718.length;
        int var3 = var2;
        if (var2 < var1) {
            var3 = var1;
        }
        System.arraycopy(this.field_1718, 0, this.field_1718 = new byte[var2 + var3], 0, var2);
    }

    private VerificationTypeInfo retrieveLocal(int var1, int var2) {
        int var3 = 0;
        for (int var4 = this.codeStream.field_1187; var3 < var4; ++var3) {
            LocalVariableBinding var5 = this.codeStream.field_1202[var3];
            if (var5 != null && var2 == var5.field_306) {
                for (int var6 = 0; var6 < var5.field_311; ++var6) {
                    int var7 = var5.initializationPCs[var6 << 1];
                    int var8 = var5.initializationPCs[(var6 << 1) + 1];
                    if (var1 >= var7 && var1 < var8) {
                        VerificationTypeInfo var10000 = new VerificationTypeInfo(var5.type);
                        return var10000;
                    }
                }
            }
        }
        return null;
    }

    private int scanType(char[] var1, int var2) {
        switch (var1[var2]) {
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
                return var2;
            case 69:
            case 71:
            case 72:
            case 75:
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
            default:
                throw new IllegalArgumentException();
            case 76:
                return CharOperation.method_1374(';', var1, var2 + 1);
            case 91:
                return this.scanType(var1, var2 + 1);
        }
    }

    public void method_3017() {
        this.field_1726 = this.field_1719;
        this.field_1719 += 2;
    }

    public void method_3018(MethodBinding var1, int var2, byte[] var3, int var4, int var5, ArrayList var6, boolean var7) {
        StackMapFrameCodeStream var8 = (StackMapFrameCodeStream)this.codeStream;
        int[] var9 = var8.getFramePositions();
        int var10 = var4;
        int[] var12 = this.constantPool.offsets;
        byte[] var13 = this.constantPool.poolContent;
        int var14 = 0;
        int var15 = var9.length;
        int var16 = var9[0];
        int var17 = 0;
        StackMapFrameCodeStream$StackDepthMarker[] var18 = var8.getStackDepthMarkers();
        int var19 = var18 == null ? 0 : var18.length;
        boolean var20 = var19 != 0;
        StackMapFrameCodeStream$StackDepthMarker var21 = null;
        if (var20) {
            var21 = var18[0];
        }
        int var22 = 0;
        StackMapFrameCodeStream$StackMarker[] var23 = var8.getStackMarkers();
        int var24 = var23 == null ? 0 : var23.length;
        boolean var25 = var24 != 0;
        StackMapFrameCodeStream$StackMarker var26 = null;
        if (var25) {
            var26 = var23[0];
        }
        int var27 = 0;
        StackMapFrameCodeStream$ExceptionMarker[] var28 = var8.getExceptionMarkers();
        int var29 = var28 == null ? 0 : var28.length;
        boolean var30 = var29 != 0;
        StackMapFrameCodeStream$ExceptionMarker var31 = null;
        if (var30) {
            var31 = var28[0];
        }
        StackMapFrame var10000 = new StackMapFrame(var2);
        StackMapFrame var32 = var10000;
        if (!var7) {
            this.initializeDefaultLocals(var32, var1, var2, var5);
        }
        var32.field_1642 = -1;
        var6.add(var32.duplicate());
        do {
            int var33 = var10 - var4;
            VerificationTypeInfo[] var34;
            if (var25 && var26.field_319 == var33) {
                var34 = var32.field_1646;
                VerificationTypeInfo[] var35 = new VerificationTypeInfo[var32.field_1643];
                System.arraycopy(var34, 0, var35, 0, var32.field_1643);
                var26.setInfos(var35);
            } else if (var25 && var26.field_320 == var33) {
                var34 = var26.infos;
                var32.field_1646 = var34;
                var32.field_1643 = var34.length;
                ++var22;
                if (var22 < var24) {
                    var26 = var23[var22];
                } else {
                    var25 = false;
                }
            }
            VerificationTypeInfo var10001;
            VerificationTypeInfo var10002;
            VerificationTypeInfo[] var68;
            int var67;
            if (var20 && var21.field_340 == var33) {
                TypeBinding var62 = var21.typeBinding;
                if (var62 != null) {
                    if (var21.field_341 > 0) {
                        var10001 = new VerificationTypeInfo(var62);
                        var32.addStackItem(var10001);
                    } else {
                        var68 = var32.field_1646;
                        var67 = var32.field_1643 - 1;
                        var10002 = new VerificationTypeInfo(var62);
                        var68[var67] = var10002;
                    }
                } else {
                    --var32.field_1643;
                }
                ++var17;
                if (var17 < var19) {
                    var21 = var18[var17];
                } else {
                    var20 = false;
                }
            }
            if (var30 && var31.pc == var33) {
                var32.field_1643 = 0;
                var10001 = new VerificationTypeInfo(0, 7, var31.constantPoolName);
                var32.addStackItem(var10001);
                ++var27;
                if (var27 < var29) {
                    var31 = var28[var27];
                } else {
                    var30 = false;
                }
            }
            if (var16 < var33) {
                do {
                    ++var14;
                    if (var14 >= var15) {
                        return;
                    }
                    var16 = var9[var14];
                } while (var16 < var33);
            }
            if (var16 == var33) {
                StackMapFrame var59 = var32.duplicate();
                var59.field_1642 = var33;
                this.initializeLocals(var7 ? true : var1.method_370(), var33, var59);
                var6.add(var59);
                ++var14;
                if (var14 >= var15) {
                    return;
                }
                var16 = var9[var14];
            }
            byte var61 = (byte)this.method_3019(var3, 0, var10);
            int var11;
            VerificationTypeInfo var42;
            VerificationTypeInfo var43;
            int var40;
            VerificationTypeInfo var41;
            int var47;
            char[] var51;
            char[] var49;
            int var48;
            int var55;
            char[] var54;
            char[] var52;
            int var58;
            char[] var63;
            VerificationTypeInfo var60;
            switch (var61) {
                case -128:
                case -127:
                case -126:
                case -125:
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
                case 114:
                case 115:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                    --var32.field_1643;
                    ++var10;
                    break;
                case -124:
                    var10 += 3;
                    break;
                case -123:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_183);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -122:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_184);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -121:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_185);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -120:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_179);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -119:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_184);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -118:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_185);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -117:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_179);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -116:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_183);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -115:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_185);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -114:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_179);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -113:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_183);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -112:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_184);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -111:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_180);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -110:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_182);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -109:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_181);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -108:
                case -107:
                case -106:
                case -105:
                case -104:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_179);
                    ++var10;
                    break;
                case -103:
                case -102:
                case -101:
                case -100:
                case -99:
                case -98:
                    --var32.field_1643;
                    var10 += 3;
                    break;
                case -97:
                case -96:
                case -95:
                case -94:
                case -93:
                case -92:
                case -91:
                case -90:
                    var32.field_1643 -= 2;
                    var10 += 3;
                    break;
                case -89:
                    var10 += 3;
                    break;
                case -88:
                case -87:
                case -70:
                case -55:
                case -54:
                case -53:
                case -52:
                case -51:
                case -50:
                case -49:
                case -48:
                case -47:
                case -46:
                case -45:
                case -44:
                case -43:
                case -42:
                case -41:
                case -40:
                case -39:
                case -38:
                case -37:
                case -36:
                case -35:
                case -34:
                case -33:
                case -32:
                case -31:
                case -30:
                case -29:
                case -28:
                case -27:
                case -26:
                case -25:
                case -24:
                case -23:
                case -22:
                case -21:
                case -20:
                case -19:
                case -18:
                case -17:
                case -16:
                case -15:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                case -3:
                case -2:
                case -1:
                default:
                    this.codeStream.methodDeclaration.scope.problemReporter().abortDueToInternalError(Messages.bind(Messages.field_1881, new Object[] {new Byte(var61), new Integer(var10), new String(var1.shortReadableName())}), this.codeStream.methodDeclaration);
                    break;
                case -86:
                    ++var10;
                    while ((var10 - var4 & 3) != 0) {
                        ++var10;
                    }
                    var10 += 4;
                    int var64 = this.method_3004(var3, 0, var10);
                    var10 += 4;
                    int var65 = this.method_3004(var3, 0, var10);
                    var10 += 4;
                    int var45 = var65 - var64 + 1;
                    var10 += var45 * 4;
                    --var32.field_1643;
                    break;
                case -85:
                    ++var10;
                    while ((var10 - var4 & 3) != 0) {
                        ++var10;
                    }
                    var10 += 4;
                    int var46 = (int)this.u4At(var3, 0, var10);
                    var10 += 4 + var46 * 8;
                    --var32.field_1643;
                    break;
                case -84:
                case -83:
                case -82:
                case -81:
                case -80:
                    --var32.field_1643;
                    ++var10;
                    break;
                case -79:
                    ++var10;
                    break;
                case -78:
                    var11 = this.method_3020(var3, 1, var10);
                    var47 = this.method_3020(var13, 3, var12[var11]);
                    var48 = this.method_3020(var13, 3, var12[var47]);
                    var49 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    if (var49.length == 1) {
                        switch (var49[0]) {
                            case 66:
                                var32.addStackItem(TypeBinding.field_180);
                                break;
                            case 67:
                                var32.addStackItem(TypeBinding.field_182);
                                break;
                            case 68:
                                var32.addStackItem(TypeBinding.field_185);
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
                            default:
                                break;
                            case 70:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 73:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 74:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 83:
                                var32.addStackItem(TypeBinding.field_181);
                                break;
                            case 90:
                                var32.addStackItem(TypeBinding.field_186);
                        }
                    } else if (var49[0] == 91) {
                        var10001 = new VerificationTypeInfo(0, var49);
                        var32.addStackItem(var10001);
                    } else {
                        var10001 = new VerificationTypeInfo(0, CharOperation.subarray(var49, 1, var49.length - 1));
                        var32.addStackItem(var10001);
                    }
                    var10 += 3;
                    break;
                case -77:
                    --var32.field_1643;
                    var10 += 3;
                    break;
                case -76:
                    var11 = this.method_3020(var3, 1, var10);
                    var47 = this.method_3020(var13, 3, var12[var11]);
                    var48 = this.method_3020(var13, 3, var12[var47]);
                    var49 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    --var32.field_1643;
                    if (var49.length == 1) {
                        switch (var49[0]) {
                            case 66:
                                var32.addStackItem(TypeBinding.field_180);
                                break;
                            case 67:
                                var32.addStackItem(TypeBinding.field_182);
                                break;
                            case 68:
                                var32.addStackItem(TypeBinding.field_185);
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
                            default:
                                break;
                            case 70:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 73:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 74:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 83:
                                var32.addStackItem(TypeBinding.field_181);
                                break;
                            case 90:
                                var32.addStackItem(TypeBinding.field_186);
                        }
                    } else if (var49[0] == 91) {
                        var10001 = new VerificationTypeInfo(0, var49);
                        var32.addStackItem(var10001);
                    } else {
                        var10001 = new VerificationTypeInfo(0, CharOperation.subarray(var49, 1, var49.length - 1));
                        var32.addStackItem(var10001);
                    }
                    var10 += 3;
                    break;
                case -75:
                    var32.field_1643 -= 2;
                    var10 += 3;
                    break;
                case -74:
                    var11 = this.method_3020(var3, 1, var10);
                    var47 = this.method_3020(var13, 3, var12[var11]);
                    var48 = this.method_3020(var13, 3, var12[var47]);
                    var49 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var48 = this.method_3020(var13, 1, var12[var47]);
                    this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var32.field_1643 -= this.getParametersCount(var49) + 1;
                    var51 = this.getReturnType(var49);
                    if (var51.length == 1) {
                        switch (var51[0]) {
                            case 66:
                                var32.addStackItem(TypeBinding.field_180);
                                break;
                            case 67:
                                var32.addStackItem(TypeBinding.field_182);
                                break;
                            case 68:
                                var32.addStackItem(TypeBinding.field_185);
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
                            default:
                                break;
                            case 70:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 73:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 74:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 83:
                                var32.addStackItem(TypeBinding.field_181);
                                break;
                            case 90:
                                var32.addStackItem(TypeBinding.field_186);
                        }
                    } else if (var51[0] == 91) {
                        var10001 = new VerificationTypeInfo(0, var51);
                        var32.addStackItem(var10001);
                    } else {
                        var10001 = new VerificationTypeInfo(0, CharOperation.subarray(var51, 1, var51.length - 1));
                        var32.addStackItem(var10001);
                    }
                    var10 += 3;
                    break;
                case -73:
                    var11 = this.method_3020(var3, 1, var10);
                    var47 = this.method_3020(var13, 3, var12[var11]);
                    var48 = this.method_3020(var13, 3, var12[var47]);
                    var49 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var48 = this.method_3020(var13, 1, var12[var47]);
                    char[] var50 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var32.field_1643 -= this.getParametersCount(var49);
                    if (CharOperation.method_1364(ConstantPool.field_1394, var50)) {
                        var32.field_1646[var32.field_1643 - 1].field_336 = 7;
                    }
                    --var32.field_1643;
                    var51 = this.getReturnType(var49);
                    if (var51.length == 1) {
                        switch (var51[0]) {
                            case 66:
                                var32.addStackItem(TypeBinding.field_180);
                                break;
                            case 67:
                                var32.addStackItem(TypeBinding.field_182);
                                break;
                            case 68:
                                var32.addStackItem(TypeBinding.field_185);
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
                            default:
                                break;
                            case 70:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 73:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 74:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 83:
                                var32.addStackItem(TypeBinding.field_181);
                                break;
                            case 90:
                                var32.addStackItem(TypeBinding.field_186);
                        }
                    } else if (var51[0] == 91) {
                        var10001 = new VerificationTypeInfo(0, var51);
                        var32.addStackItem(var10001);
                    } else {
                        var10001 = new VerificationTypeInfo(0, CharOperation.subarray(var51, 1, var51.length - 1));
                        var32.addStackItem(var10001);
                    }
                    var10 += 3;
                    break;
                case -72:
                    var11 = this.method_3020(var3, 1, var10);
                    var47 = this.method_3020(var13, 3, var12[var11]);
                    var48 = this.method_3020(var13, 3, var12[var47]);
                    var49 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var48 = this.method_3020(var13, 1, var12[var47]);
                    this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var32.field_1643 -= this.getParametersCount(var49);
                    var51 = this.getReturnType(var49);
                    if (var51.length == 1) {
                        switch (var51[0]) {
                            case 66:
                                var32.addStackItem(TypeBinding.field_180);
                                break;
                            case 67:
                                var32.addStackItem(TypeBinding.field_182);
                                break;
                            case 68:
                                var32.addStackItem(TypeBinding.field_185);
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
                            default:
                                break;
                            case 70:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 73:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 74:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 83:
                                var32.addStackItem(TypeBinding.field_181);
                                break;
                            case 90:
                                var32.addStackItem(TypeBinding.field_186);
                        }
                    } else if (var51[0] == 91) {
                        var10001 = new VerificationTypeInfo(0, var51);
                        var32.addStackItem(var10001);
                    } else {
                        var10001 = new VerificationTypeInfo(0, CharOperation.subarray(var51, 1, var51.length - 1));
                        var32.addStackItem(var10001);
                    }
                    var10 += 3;
                    break;
                case -71:
                    var11 = this.method_3020(var3, 1, var10);
                    var47 = this.method_3020(var13, 3, var12[var11]);
                    var48 = this.method_3020(var13, 3, var12[var47]);
                    var49 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var48 = this.method_3020(var13, 1, var12[var47]);
                    this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var32.field_1643 -= this.getParametersCount(var49) + 1;
                    var51 = this.getReturnType(var49);
                    if (var51.length == 1) {
                        switch (var51[0]) {
                            case 66:
                                var32.addStackItem(TypeBinding.field_180);
                                break;
                            case 67:
                                var32.addStackItem(TypeBinding.field_182);
                                break;
                            case 68:
                                var32.addStackItem(TypeBinding.field_185);
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
                            default:
                                break;
                            case 70:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 73:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 74:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 83:
                                var32.addStackItem(TypeBinding.field_181);
                                break;
                            case 90:
                                var32.addStackItem(TypeBinding.field_186);
                        }
                    } else if (var51[0] == 91) {
                        var10001 = new VerificationTypeInfo(0, var51);
                        var32.addStackItem(var10001);
                    } else {
                        var10001 = new VerificationTypeInfo(0, CharOperation.subarray(var51, 1, var51.length - 1));
                        var32.addStackItem(var10001);
                    }
                    var10 += 5;
                    break;
                case -69:
                    var11 = this.method_3020(var3, 1, var10);
                    var48 = this.method_3020(var13, 1, var12[var11]);
                    var52 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    VerificationTypeInfo var66 = new VerificationTypeInfo(0, 8, var52);
                    VerificationTypeInfo var53 = var66;
                    var53.field_339 = var33;
                    var32.addStackItem(var53);
                    var10 += 3;
                    break;
                case -68:
                    var54 = null;
                    switch (this.method_3019(var3, 1, var10)) {
                        case 4:
                            var54 = new char[] {'[', 'Z'};
                            break;
                        case 5:
                            var54 = new char[] {'[', 'C'};
                            break;
                        case 6:
                            var54 = new char[] {'[', 'F'};
                            break;
                        case 7:
                            var54 = new char[] {'[', 'D'};
                            break;
                        case 8:
                            var54 = new char[] {'[', 'B'};
                            break;
                        case 9:
                            var54 = new char[] {'[', 'S'};
                            break;
                        case 10:
                            var54 = new char[] {'[', 'I'};
                            break;
                        case 11:
                            var54 = new char[] {'[', 'J'};
                    }
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(1, var54);
                    var68[var67] = var10002;
                    var10 += 2;
                    break;
                case -67:
                    var11 = this.method_3020(var3, 1, var10);
                    var48 = this.method_3020(var13, 1, var12[var11]);
                    var52 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var55 = var52.length;
                    System.arraycopy(var52, 0, var54 = new char[var55 + 3], 2, var55);
                    var54[0] = 91;
                    var54[1] = 76;
                    var54[var55 + 2] = 59;
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(0, var54);
                    var68[var67] = var10002;
                    var10 += 3;
                    break;
                case -66:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_179);
                    var68[var67] = var10002;
                    ++var10;
                    break;
                case -65:
                    --var32.field_1643;
                    ++var10;
                    break;
                case -64:
                    var11 = this.method_3020(var3, 1, var10);
                    var48 = this.method_3020(var13, 1, var12[var11]);
                    var52 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(0, var52);
                    var68[var67] = var10002;
                    var10 += 3;
                    break;
                case -63:
                    var68 = var32.field_1646;
                    var67 = var32.field_1643 - 1;
                    var10002 = new VerificationTypeInfo(TypeBinding.field_179);
                    var68[var67] = var10002;
                    var10 += 3;
                    break;
                case -62:
                case -61:
                    --var32.field_1643;
                    ++var10;
                    break;
                case -60:
                    var61 = (byte)this.method_3019(var3, 1, var10);
                    if (var61 == -124) {
                        var10 += 6;
                    } else {
                        var11 = this.method_3020(var3, 2, var10);
                        switch (var61) {
                            case 21:
                                var32.addStackItem(TypeBinding.field_179);
                                break;
                            case 22:
                                var32.addStackItem(TypeBinding.field_183);
                                break;
                            case 23:
                                var32.addStackItem(TypeBinding.field_184);
                                break;
                            case 24:
                                var32.addStackItem(TypeBinding.field_185);
                                break;
                            case 25:
                                var60 = var32.field_1645[var11];
                                if (var60 == null) {
                                    var60 = this.retrieveLocal(var33, var11);
                                }
                                var32.addStackItem(var60);
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            default:
                                break;
                            case 54:
                                --var32.field_1643;
                                break;
                            case 55:
                                --var32.field_1643;
                                break;
                            case 56:
                                --var32.field_1643;
                                break;
                            case 57:
                                --var32.field_1643;
                                break;
                            case 58:
                                var32.field_1645[var11] = var32.field_1646[var32.field_1643 - 1];
                                --var32.field_1643;
                        }
                        var10 += 4;
                    }
                    break;
                case -59:
                    var11 = this.method_3020(var3, 1, var10);
                    var48 = this.method_3020(var13, 1, var12[var11]);
                    var52 = this.utf8At(var13, var12[var48] + 3, this.method_3020(var13, 1, var12[var48]));
                    int var56 = this.method_3019(var3, 3, var10);
                    var32.field_1643 -= var56;
                    var55 = var52.length;
                    var54 = new char[var55 + var56];
                    for (int var57 = 0; var57 < var56; ++var57) {
                        var54[var57] = 91;
                    }
                    System.arraycopy(var52, 0, var54, var56, var55);
                    var10001 = new VerificationTypeInfo(0, var54);
                    var32.addStackItem(var10001);
                    var10 += 4;
                    break;
                case -58:
                case -57:
                    --var32.field_1643;
                    var10 += 3;
                    break;
                case -56:
                    var10 += 5;
                    break;
                case 0:
                    ++var10;
                    break;
                case 1:
                    var32.addStackItem(TypeBinding.field_187);
                    ++var10;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    var32.addStackItem(TypeBinding.field_179);
                    ++var10;
                    break;
                case 9:
                case 10:
                    var32.addStackItem(TypeBinding.field_183);
                    ++var10;
                    break;
                case 11:
                case 12:
                case 13:
                    var32.addStackItem(TypeBinding.field_184);
                    ++var10;
                    break;
                case 14:
                case 15:
                    var32.addStackItem(TypeBinding.field_185);
                    ++var10;
                    break;
                case 16:
                    var32.addStackItem(TypeBinding.field_180);
                    var10 += 2;
                    break;
                case 17:
                    var32.addStackItem(TypeBinding.field_181);
                    var10 += 3;
                    break;
                case 18:
                    var11 = this.method_3019(var3, 1, var10);
                    switch (this.method_3019(var13, 0, var12[var11])) {
                        case 3:
                            var32.addStackItem(TypeBinding.field_179);
                            break;
                        case 4:
                            var32.addStackItem(TypeBinding.field_184);
                        case 5:
                        case 6:
                        default:
                            break;
                        case 7:
                            var58 = this.method_3020(var13, 1, var12[var11]);
                            var63 = this.utf8At(var13, var12[var58] + 3, this.method_3020(var13, 1, var12[var58]));
                            var10001 = new VerificationTypeInfo(0, var63);
                            var32.addStackItem(var10001);
                            break;
                        case 8:
                            var10001 = new VerificationTypeInfo(11, ConstantPool.field_1432);
                            var32.addStackItem(var10001);
                    }
                    var10 += 2;
                    break;
                case 19:
                    var11 = this.method_3020(var3, 1, var10);
                    switch (this.method_3019(var13, 0, var12[var11])) {
                        case 3:
                            var32.addStackItem(TypeBinding.field_179);
                            break;
                        case 4:
                            var32.addStackItem(TypeBinding.field_184);
                        case 5:
                        case 6:
                        default:
                            break;
                        case 7:
                            var58 = this.method_3020(var13, 1, var12[var11]);
                            var63 = this.utf8At(var13, var12[var58] + 3, this.method_3020(var13, 1, var12[var58]));
                            var10001 = new VerificationTypeInfo(0, var63);
                            var32.addStackItem(var10001);
                            break;
                        case 8:
                            var10001 = new VerificationTypeInfo(11, ConstantPool.field_1432);
                            var32.addStackItem(var10001);
                    }
                    var10 += 3;
                    break;
                case 20:
                    var11 = this.method_3020(var3, 1, var10);
                    switch (this.method_3019(var13, 0, var12[var11])) {
                        case 5:
                            var32.addStackItem(TypeBinding.field_183);
                            break;
                        case 6:
                            var32.addStackItem(TypeBinding.field_185);
                    }
                    var10 += 3;
                    break;
                case 21:
                    var32.addStackItem(TypeBinding.field_179);
                    var10 += 2;
                    break;
                case 22:
                    var32.addStackItem(TypeBinding.field_183);
                    var10 += 2;
                    break;
                case 23:
                    var32.addStackItem(TypeBinding.field_184);
                    var10 += 2;
                    break;
                case 24:
                    var32.addStackItem(TypeBinding.field_185);
                    var10 += 2;
                    break;
                case 25:
                    var11 = this.method_3019(var3, 1, var10);
                    var60 = var32.field_1645[var11];
                    if (var60 == null) {
                        var60 = this.retrieveLocal(var33, var11);
                    }
                    var32.addStackItem(var60);
                    var10 += 2;
                    break;
                case 26:
                case 27:
                case 28:
                case 29:
                    var32.addStackItem(TypeBinding.field_179);
                    ++var10;
                    break;
                case 30:
                case 31:
                case 32:
                case 33:
                    var32.addStackItem(TypeBinding.field_183);
                    ++var10;
                    break;
                case 34:
                case 35:
                case 36:
                case 37:
                    var32.addStackItem(TypeBinding.field_184);
                    ++var10;
                    break;
                case 38:
                case 39:
                case 40:
                case 41:
                    var32.addStackItem(TypeBinding.field_185);
                    ++var10;
                    break;
                case 42:
                    VerificationTypeInfo var36 = var32.field_1645[0];
                    if (var36 == null) {
                        var36 = this.retrieveLocal(var33, 0);
                    }
                    var32.addStackItem(var36);
                    ++var10;
                    break;
                case 43:
                    VerificationTypeInfo var37 = this.retrieveLocal(var33, 1);
                    var32.addStackItem(var37);
                    ++var10;
                    break;
                case 44:
                    VerificationTypeInfo var38 = this.retrieveLocal(var33, 2);
                    var32.addStackItem(var38);
                    ++var10;
                    break;
                case 45:
                    VerificationTypeInfo var39 = this.retrieveLocal(var33, 3);
                    var32.addStackItem(var39);
                    ++var10;
                    break;
                case 46:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_179);
                    ++var10;
                    break;
                case 47:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_183);
                    ++var10;
                    break;
                case 48:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_184);
                    ++var10;
                    break;
                case 49:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_185);
                    ++var10;
                    break;
                case 50:
                    --var32.field_1643;
                    var32.replaceWithElementType();
                    ++var10;
                    break;
                case 51:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_180);
                    ++var10;
                    break;
                case 52:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_182);
                    ++var10;
                    break;
                case 53:
                    var32.field_1643 -= 2;
                    var32.addStackItem(TypeBinding.field_181);
                    ++var10;
                    break;
                case 54:
                case 55:
                case 56:
                case 57:
                    --var32.field_1643;
                    var10 += 2;
                    break;
                case 58:
                    this.method_3019(var3, 1, var10);
                    --var32.field_1643;
                    var10 += 2;
                    break;
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 76:
                case 77:
                case 78:
                    --var32.field_1643;
                    ++var10;
                    break;
                case 75:
                    var32.field_1645[0] = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    ++var10;
                    break;
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                    var32.field_1643 -= 3;
                    ++var10;
                    break;
                case 87:
                    --var32.field_1643;
                    ++var10;
                    break;
                case 88:
                    var40 = var32.field_1643;
                    switch (var32.field_1646[var40 - 1].method_473()) {
                        case 7:
                        case 8:
                            --var32.field_1643;
                            break;
                        default:
                            var32.field_1643 -= 2;
                    }
                    ++var10;
                    break;
                case 89:
                    var32.addStackItem(var32.field_1646[var32.field_1643 - 1]);
                    ++var10;
                    break;
                case 90:
                    var41 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    var42 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    var32.addStackItem(var41);
                    var32.addStackItem(var42);
                    var32.addStackItem(var41);
                    ++var10;
                    break;
                case 91:
                    var41 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    var42 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    switch (var42.method_473()) {
                        case 7:
                        case 8:
                            var32.addStackItem(var41);
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                            break;
                        default:
                            var40 = var32.field_1643;
                            var43 = var32.field_1646[var40 - 1];
                            --var32.field_1643;
                            var32.addStackItem(var41);
                            var32.addStackItem(var43);
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                    }
                    ++var10;
                    break;
                case 92:
                    var41 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    switch (var41.method_473()) {
                        case 7:
                        case 8:
                            var32.addStackItem(var41);
                            var32.addStackItem(var41);
                            break;
                        default:
                            var42 = var32.field_1646[var32.field_1643 - 1];
                            --var32.field_1643;
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                    }
                    ++var10;
                    break;
                case 93:
                    var41 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    var42 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    switch (var41.method_473()) {
                        case 7:
                        case 8:
                            var32.addStackItem(var41);
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                            break;
                        default:
                            var43 = var32.field_1646[var32.field_1643 - 1];
                            --var32.field_1643;
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                            var32.addStackItem(var43);
                            var32.addStackItem(var42);
                            var32.addStackItem(var41);
                    }
                    ++var10;
                    break;
                case 94:
                    var40 = var32.field_1643;
                    var41 = var32.field_1646[var40 - 1];
                    --var32.field_1643;
                    var42 = var32.field_1646[var32.field_1643 - 1];
                    --var32.field_1643;
                    label374:
                    switch (var41.method_473()) {
                        case 7:
                        case 8:
                            switch (var42.method_473()) {
                                case 7:
                                case 8:
                                    var32.addStackItem(var41);
                                    var32.addStackItem(var42);
                                    var32.addStackItem(var41);
                                    break label374;
                                default:
                                    var40 = var32.field_1643;
                                    var43 = var32.field_1646[var40 - 1];
                                    --var32.field_1643;
                                    var32.addStackItem(var41);
                                    var32.addStackItem(var43);
                                    var32.addStackItem(var42);
                                    var32.addStackItem(var41);
                                    break label374;
                            }
                        default:
                            var40 = var32.field_1643;
                            var43 = var32.field_1646[var40 - 1];
                            --var32.field_1643;
                            switch (var43.method_473()) {
                                case 7:
                                case 8:
                                    var32.addStackItem(var42);
                                    var32.addStackItem(var41);
                                    var32.addStackItem(var43);
                                    var32.addStackItem(var42);
                                    var32.addStackItem(var41);
                                    break;
                                default:
                                    var40 = var32.field_1643;
                                    VerificationTypeInfo var44 = var32.field_1646[var40 - 1];
                                    --var32.field_1643;
                                    var32.addStackItem(var42);
                                    var32.addStackItem(var41);
                                    var32.addStackItem(var44);
                                    var32.addStackItem(var43);
                                    var32.addStackItem(var42);
                                    var32.addStackItem(var41);
                            }
                    }
                    ++var10;
                    break;
                case 95:
                    var40 = var32.field_1643;
                    var41 = var32.field_1646[var40 - 1];
                    var42 = var32.field_1646[var40 - 2];
                    var32.field_1646[var40 - 1] = var42;
                    var32.field_1646[var40 - 2] = var41;
                    ++var10;
                    break;
                case 116:
                case 117:
                case 118:
                case 119:
                    ++var10;
            }
        } while (var10 < var5 + var4);
    }

    private final int method_3019(byte[] var1, int var2, int var3) {
        return var1[var2 + var3] & 255;
    }

    private final int method_3020(byte[] var1, int var2, int var3) {
        int var4 = var2 + var3;
        return ((var1[var4++] & 255) << 8) + (var1[var4] & 255);
    }

    private final long u4At(byte[] var1, int var2, int var3) {
        int var4 = var2 + var3;
        return (((long)var1[var4++] & 255L) << 24) + (long)((var1[var4++] & 255) << 16) + (long)((var1[var4++] & 255) << 8) + (long)(var1[var4] & 255);
    }

    public char[] utf8At(byte[] var1, int var2, int var3) {
        int var4 = var3;
        char[] var5 = new char[var3];
        int var6 = 0;
        int var8;
        for (int var7 = var2; var4 != 0; var5[var6++] = (char)var8) {
            var8 = var1[var7++] & 255;
            --var4;
            if ((128 & var8) != 0) {
                if ((var8 & 32) != 0) {
                    var4 -= 2;
                    var8 = (var8 & 15) << 12 | (var1[var7++] & 63) << 6 | var1[var7++] & 63;
                } else {
                    --var4;
                    var8 = (var8 & 31) << 6 | var1[var7++] & 63;
                }
            }
        }
        if (var6 != var3) {
            System.arraycopy(var5, 0, var5 = new char[var6], 0, var6);
        }
        return var5;
    }
}
