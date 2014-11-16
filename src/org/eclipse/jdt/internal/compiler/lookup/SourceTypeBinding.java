package org.eclipse.jdt.internal.compiler.lookup;

import java.util.Iterator;
import java.util.HashMap;

import java.util.Hashtable;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodVerifier;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable;

public class SourceTypeBinding extends ReferenceBinding {

    public ReferenceBinding superclass;

    public ReferenceBinding[] field_253;

    private FieldBinding[] fields;

    private MethodBinding[] methods;

    public ReferenceBinding[] field_256;

    public TypeVariableBinding[] typeVariables;

    public ClassScope scope;

    HashMap[] field_259;

    char[] genericReferenceTypeSignature;

    private SimpleLookupTable storedAnnotations;

    public SourceTypeBinding(char[][] var1, PackageBinding var2, ClassScope var3) {
        this.storedAnnotations = null;
        this.compoundName = var1;
        this.fPackage = var2;
        this.field_201 = var3.referenceCompilationUnit().method_771();
        this.modifiers = var3.referenceContext.field_577;
        this.sourceName = var3.referenceContext.name;
        this.scope = var3;
        this.fields = Binding.field_160;
        this.methods = Binding.field_161;
        this.computeId();
    }

    private void addDefaultAbstractMethods() {
        if ((this.tagBits & 1024L) == 0L) {
            this.tagBits |= 1024L;
            if (this.method_151() && this.method_217()) {
                if (this.scope.compilerOptions().field_1929 >= 3014656L) {
                    return;
                }
                ReferenceBinding[] var1 = this.superInterfaces();
                if (var1 != Binding.field_155) {
                    MethodBinding[] var2 = null;
                    int var3 = 0;
                    ReferenceBinding[] var4 = var1;
                    int var5 = var1.length;
                    int var6;
                    for (var6 = 0; var6 < var5; ++var6) {
                        ReferenceBinding var7 = var4[var6];
                        if (var7.isValidBinding()) {
                            MethodBinding[] var8 = var7.methods();
                            int var9 = var8.length;
                            label85:
                            while (true) {
                                --var9;
                                if (var9 < 0) {
                                    if ((var1 = var7.superInterfaces()) != Binding.field_155) {
                                        var9 = var1.length;
                                        if (var5 + var9 >= var4.length) {
                                            System.arraycopy(var4, 0, var4 = new ReferenceBinding[var5 + var9 + 5], 0, var5);
                                        }
                                        label67:
                                        for (int var13 = 0; var13 < var9; ++var13) {
                                            ReferenceBinding var16 = var1[var13];
                                            for (int var14 = 0; var14 < var5; ++var14) {
                                                if (var16 == var4[var14]) {
                                                    continue label67;
                                                }
                                            }
                                            var4[var5++] = var16;
                                        }
                                    }
                                    break;
                                }
                                MethodBinding var10 = var8[var9];
                                if (!this.implementsMethod(var10)) {
                                    if (var3 == 0) {
                                        var2 = new MethodBinding[5];
                                    } else {
                                        for (int var11 = 0; var11 < var3; ++var11) {
                                            MethodBinding var12 = var2[var11];
                                            if (CharOperation.method_1364(var12.selector, var10.selector) && var12.method_344(var10)) {
                                                continue label85;
                                            }
                                        }
                                    }
                                    MethodBinding var10000 = new MethodBinding(var10.modifiers | 524288 | 4096, var10.selector, var10.returnType, var10.parameters, var10.thrownExceptions, this);
                                    MethodBinding var15 = var10000;
                                    if (var3 == var2.length) {
                                        System.arraycopy(var2, 0, var2 = new MethodBinding[2 * var3], 0, var3);
                                    }
                                    var2[var3++] = var15;
                                }
                            }
                        }
                    }
                    if (var3 > 0) {
                        var6 = this.methods.length;
                        System.arraycopy(this.methods, 0, this.methods = new MethodBinding[var6 + var3], 0, var6);
                        System.arraycopy(var2, 0, this.methods, var6, var3);
                        var6 += var3;
                        if (var6 > 1) {
                            ReferenceBinding.sortMethods(this.methods, 0, var6);
                        }
                    }
                }
            }
        }
    }

    public FieldBinding method_293(LocalVariableBinding var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var2 = (FieldBinding)this.field_259[1].get(var1);
        if (var2 == null) {
            SyntheticFieldBinding var11 = new SyntheticFieldBinding(CharOperation.concat(TypeConstants.field_141, var1.name), var1.type, 4114, this, Constant.NotAConstant, this.field_259[1].size());
            var2 = var11;
            this.field_259[1].put(var1, var2);
        }
        int var4 = 1;
        boolean var3;
        do {
            var3 = false;
            FieldBinding var5;
            if ((var5 = this.getField(((FieldBinding)var2).name, true)) != null) {
                TypeDeclaration var6 = this.scope.referenceContext;
                int var7 = 0;
                for (int var8 = var6.fields.length; var7 < var8; ++var7) {
                    FieldDeclaration var9 = var6.fields[var7];
                    if (var9.binding == var5) {
                        ((FieldBinding)var2).name = CharOperation.method_1356(TypeConstants.field_141, var1.name, ("$" + String.valueOf(var4++)).toCharArray());
                        var3 = true;
                        break;
                    }
                }
            }
        } while (var3);
        return (FieldBinding)var2;
    }

    public FieldBinding addSyntheticFieldForInnerclass(ReferenceBinding var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var2 = (FieldBinding)this.field_259[1].get(var1);
        if (var2 == null) {
            SyntheticFieldBinding var9 = new SyntheticFieldBinding(CharOperation.concat(TypeConstants.field_142, String.valueOf(var1.method_199()).toCharArray()), var1, 4112, this, Constant.NotAConstant, this.field_259[1].size());
            var2 = var9;
            this.field_259[1].put(var1, var2);
        }
        boolean var3;
        do {
            var3 = false;
            FieldBinding var4;
            if ((var4 = this.getField(((FieldBinding)var2).name, true)) != null) {
                TypeDeclaration var5 = this.scope.referenceContext;
                int var6 = 0;
                for (int var7 = var5.fields.length; var6 < var7; ++var6) {
                    FieldDeclaration var8 = var5.fields[var6];
                    if (var8.binding == var4) {
                        if (this.scope.compilerOptions().field_1927 >= 3211264L) {
                            ((FieldBinding)var2).name = CharOperation.concat(((FieldBinding)var2).name, "$".toCharArray());
                            var3 = true;
                        } else {
                            this.scope.problemReporter().method_1524(this, var8);
                        }
                        break;
                    }
                }
            }
        } while (var3);
        return (FieldBinding)var2;
    }

    public FieldBinding addSyntheticFieldForClassLiteral(TypeBinding var1, BlockScope var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[2] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[2] = var10002;
        }
        Object var3 = (FieldBinding)this.field_259[2].get(var1);
        if (var3 == null) {
            SyntheticFieldBinding var9 = new SyntheticFieldBinding(CharOperation.concat(TypeConstants.field_140, String.valueOf(this.field_259[2].size()).toCharArray()), var2.method_606(), 4104, this, Constant.NotAConstant, this.field_259[2].size());
            var3 = var9;
            this.field_259[2].put(var1, var3);
        }
        FieldBinding var4;
        if ((var4 = this.getField(((FieldBinding)var3).name, true)) != null) {
            TypeDeclaration var5 = var2.referenceType();
            int var6 = 0;
            for (int var7 = var5.fields.length; var6 < var7; ++var6) {
                FieldDeclaration var8 = var5.fields[var6];
                if (var8.binding == var4) {
                    var2.problemReporter().method_1524(this, var8);
                    break;
                }
            }
        }
        return (FieldBinding)var3;
    }

    public FieldBinding addSyntheticFieldForAssert(BlockScope var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var2 = (FieldBinding)this.field_259[1].get("assertionEmulation");
        if (var2 == null) {
            SyntheticFieldBinding var11 = new SyntheticFieldBinding(TypeConstants.field_139, TypeBinding.field_186, 4120, this, Constant.NotAConstant, this.field_259[1].size());
            var2 = var11;
            this.field_259[1].put("assertionEmulation", var2);
        }
        int var4 = 0;
        boolean var3;
        do {
            var3 = false;
            FieldBinding var5;
            if ((var5 = this.getField(((FieldBinding)var2).name, true)) != null) {
                TypeDeclaration var6 = this.scope.referenceContext;
                int var7 = 0;
                for (int var8 = var6.fields.length; var7 < var8; ++var7) {
                    FieldDeclaration var9 = var6.fields[var7];
                    if (var9.binding == var5) {
                        ((FieldBinding)var2).name = CharOperation.concat(TypeConstants.field_139, ("_" + String.valueOf(var4++)).toCharArray());
                        var3 = true;
                        break;
                    }
                }
            }
        } while (var3);
        return (FieldBinding)var2;
    }

    public FieldBinding addSyntheticFieldForEnumValues() {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var1 = (FieldBinding)this.field_259[1].get("enumConstantValues");
        if (var1 == null) {
            SyntheticFieldBinding var10 = new SyntheticFieldBinding(TypeConstants.field_138, this.scope.createArrayType(this, 1), 4122, this, Constant.NotAConstant, this.field_259[1].size());
            var1 = var10;
            this.field_259[1].put("enumConstantValues", var1);
        }
        int var3 = 0;
        boolean var2;
        do {
            var2 = false;
            FieldBinding var4;
            if ((var4 = this.getField(((FieldBinding)var1).name, true)) != null) {
                TypeDeclaration var5 = this.scope.referenceContext;
                int var6 = 0;
                for (int var7 = var5.fields.length; var6 < var7; ++var6) {
                    FieldDeclaration var8 = var5.fields[var6];
                    if (var8.binding == var4) {
                        ((FieldBinding)var1).name = CharOperation.concat(TypeConstants.field_138, ("_" + String.valueOf(var3++)).toCharArray());
                        var2 = true;
                        break;
                    }
                }
            }
        } while (var2);
        return (FieldBinding)var1;
    }

    public SyntheticMethodBinding method_298(FieldBinding var1, boolean var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        SyntheticMethodBinding var3 = null;
        SyntheticMethodBinding[] var4 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var1));
        SyntheticMethodBinding var5;
        if (var4 == null) {
            var5 = new SyntheticMethodBinding(var1, var2, this);
            var3 = var5;
            this.field_259[0].put(var1, var4 = new SyntheticMethodBinding[2]);
            var4[var2 ? 0 : 1] = var3;
        } else if ((var3 = var4[var2 ? 0 : 1]) == null) {
            var5 = new SyntheticMethodBinding(var1, var2, this);
            var3 = var5;
            var4[var2 ? 0 : 1] = var3;
        }
        return var3;
    }

    public SyntheticMethodBinding addSyntheticEnumMethod(char[] var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        SyntheticMethodBinding var2 = null;
        SyntheticMethodBinding[] var3 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var1));
        SyntheticMethodBinding var4;
        if (var3 == null) {
            var4 = new SyntheticMethodBinding(this, var1);
            var2 = var4;
            this.field_259[0].put(var1, var3 = new SyntheticMethodBinding[2]);
            var3[0] = var2;
        } else if ((var2 = var3[0]) == null) {
            var4 = new SyntheticMethodBinding(this, var1);
            var2 = var4;
            var3[0] = var2;
        }
        return var2;
    }

    public SyntheticFieldBinding addSyntheticFieldForSwitchEnum(char[] var1, String var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        SyntheticFieldBinding var3 = (SyntheticFieldBinding)this.field_259[1].get(var2);
        if (var3 == null) {
            SyntheticFieldBinding var12 = new SyntheticFieldBinding(var1, this.scope.createArrayType(TypeBinding.field_179, 1), 4106, this, Constant.NotAConstant, this.field_259[1].size());
            var3 = var12;
            this.field_259[1].put(var2, var3);
        }
        int var5 = 0;
        boolean var4;
        do {
            var4 = false;
            FieldBinding var6;
            if ((var6 = this.getField(var3.name, true)) != null) {
                TypeDeclaration var7 = this.scope.referenceContext;
                int var8 = 0;
                for (int var9 = var7.fields.length; var8 < var9; ++var8) {
                    FieldDeclaration var10 = var7.fields[var8];
                    if (var10.binding == var6) {
                        var3.name = CharOperation.concat(var1, ("_" + String.valueOf(var5++)).toCharArray());
                        var4 = true;
                        break;
                    }
                }
            }
        } while (var4);
        return var3;
    }

    public SyntheticMethodBinding addSyntheticMethodForSwitchEnum(TypeBinding var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        SyntheticMethodBinding var2 = null;
        char[] var3 = CharOperation.concat(TypeConstants.field_137, var1.constantPoolName());
        CharOperation.replace(var3, '/', '$');
        String var4 = new String(var3);
        SyntheticMethodBinding[] var5 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var4));
        SyntheticFieldBinding var6;
        SyntheticMethodBinding var7;
        if (var5 == null) {
            var6 = this.addSyntheticFieldForSwitchEnum(var3, var4);
            var7 = new SyntheticMethodBinding(var6, this, var1, var3);
            var2 = var7;
            this.field_259[0].put(var4, var5 = new SyntheticMethodBinding[2]);
            var5[0] = var2;
        } else if ((var2 = var5[0]) == null) {
            var6 = this.addSyntheticFieldForSwitchEnum(var3, var4);
            var7 = new SyntheticMethodBinding(var6, this, var1, var3);
            var2 = var7;
            var5[0] = var2;
        }
        return var2;
    }

    public SyntheticMethodBinding addSyntheticMethod(MethodBinding var1, boolean var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        SyntheticMethodBinding var3 = null;
        SyntheticMethodBinding[] var4 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var1));
        SyntheticMethodBinding var5;
        if (var4 == null) {
            var5 = new SyntheticMethodBinding(var1, var2, this);
            var3 = var5;
            this.field_259[0].put(var1, var4 = new SyntheticMethodBinding[2]);
            var4[var2 ? 0 : 1] = var3;
        } else if ((var3 = var4[var2 ? 0 : 1]) == null) {
            var5 = new SyntheticMethodBinding(var1, var2, this);
            var3 = var5;
            var4[var2 ? 0 : 1] = var3;
        }
        return var3;
    }

    public SyntheticMethodBinding method_303(MethodBinding var1, MethodBinding var2) {
        if (this.method_157()) {
            return null;
        } else if (var1.returnType.erasure() == var2.returnType.erasure() && var1.method_342(var2)) {
            return null;
        } else {
            if (this.field_259 == null) {
                this.field_259 = new HashMap[4];
            }
            Iterator var3;
            if (this.field_259[0] == null) {
                HashMap[] var10000 = this.field_259;
                HashMap var10002 = new HashMap(5);
                var10000[0] = var10002;
            } else {
                var3 = this.field_259[0].keySet().iterator();
                while (var3.hasNext()) {
                    Object var4 = var3.next();
                    if (var4 instanceof MethodBinding) {
                        MethodBinding var5 = (MethodBinding)var4;
                        if (CharOperation.method_1364(var1.selector, var5.selector) && var1.returnType.erasure() == var5.returnType.erasure() && var1.method_342(var5)) {
                            return null;
                        }
                    }
                }
            }
            var3 = null;
            SyntheticMethodBinding[] var8 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var1));
            SyntheticMethodBinding var6;
            SyntheticMethodBinding var7;
            if (var8 == null) {
                var7 = new SyntheticMethodBinding(var1, var2, this);
                var6 = var7;
                this.field_259[0].put(var1, var8 = new SyntheticMethodBinding[2]);
                var8[1] = var6;
            } else if ((var6 = var8[1]) == null) {
                var7 = new SyntheticMethodBinding(var1, var2, this);
                var6 = var7;
                var8[1] = var6;
            }
            return var6;
        }
    }

    boolean method_304() {
        return this.fields != Binding.field_160;
    }

    boolean method_305() {
        return this.methods != Binding.field_161;
    }

    public int kind() {
        return this.typeVariables != Binding.NO_TYPE_VARIABLES ? 2052 : 4;
    }

    void method_306() {
        this.getAnnotationTagBits();
        ReferenceBinding var1 = this.enclosingType();
        if (var1 != null && var1.method_230() && !this.method_220()) {
            this.modifiers |= 2097152;
        }
        this.fields();
        this.methods();
        int var2 = 0;
        for (int var3 = this.field_256.length; var2 < var3; ++var2) {
            ((SourceTypeBinding)this.field_256[var2]).method_306();
        }
    }

    public FieldBinding[] fields() {
        if ((this.tagBits & 8192L) != 0L) {
            return this.fields;
        } else {
            int var1 = 0;
            FieldBinding[] var2 = this.fields;
            try {
                int var3;
                if ((this.tagBits & 4096L) == 0L) {
                    var3 = this.fields.length;
                    if (var3 > 1) {
                        ReferenceBinding.sortFields(this.fields, 0, var3);
                    }
                    this.tagBits |= 4096L;
                }
                var3 = 0;
                for (int var4 = this.fields.length; var3 < var4; ++var3) {
                    if (this.method_313(this.fields[var3]) == null) {
                        if (var2 == this.fields) {
                            System.arraycopy(this.fields, 0, var2 = new FieldBinding[var4], 0, var4);
                        }
                        var2[var3] = null;
                        ++var1;
                    }
                }
            } finally {
                if (var1 > 0) {
                    int var7 = var2.length - var1;
                    if (var7 == 0) {
                        return this.fields = Binding.field_153;
                    }
                    FieldBinding[] var8 = new FieldBinding[var7];
                    int var9 = 0;
                    int var10 = 0;
                    for (int var11 = var2.length; var9 < var11; ++var9) {
                        if (var2[var9] != null) {
                            var8[var10++] = var2[var9];
                        }
                    }
                    this.fields = var8;
                }
            }
            this.tagBits |= 8192L;
            return this.fields;
        }
    }

    public char[] genericTypeSignature() {
        if (this.genericReferenceTypeSignature == null) {
            this.genericReferenceTypeSignature = this.computeGenericTypeSignature(this.typeVariables);
        }
        return this.genericReferenceTypeSignature;
    }

    public char[] method_307() {
        StringBuffer var1 = null;
        int var2;
        int var3;
        if (this.typeVariables != Binding.NO_TYPE_VARIABLES) {
            var1 = new StringBuffer(10);
            var1.append('<');
            var2 = 0;
            for (var3 = this.typeVariables.length; var2 < var3; ++var2) {
                var1.append(this.typeVariables[var2].method_256());
            }
            var1.append('>');
        } else {
            if (this.superclass == null || !this.superclass.method_162()) {
                var2 = 0;
                var3 = this.field_253.length;
                while (true) {
                    if (var2 >= var3) {
                        return null;
                    }
                    if (this.field_253[var2].method_162()) {
                        break;
                    }
                    ++var2;
                }
            }
            var1 = new StringBuffer(10);
        }
        if (this.superclass != null) {
            var1.append(this.superclass.genericTypeSignature());
        } else {
            var1.append(this.scope.method_609().genericTypeSignature());
        }
        var2 = 0;
        for (var3 = this.field_253.length; var2 < var3; ++var2) {
            var1.append(this.field_253[var2].genericTypeSignature());
        }
        return var1.toString().toCharArray();
    }

    public long getAnnotationTagBits() {
        if ((this.tagBits & 8589934592L) == 0L && this.scope != null) {
            TypeDeclaration var1 = this.scope.referenceContext;
            boolean var2 = var1.field_589.field_412;
            try {
                var1.field_589.field_412 = true;
                ASTNode.method_761(var1.field_589, var1.annotations, this);
            } finally {
                var1.field_589.field_412 = var2;
            }
            if ((this.tagBits & 70368744177664L) != 0L) {
                this.modifiers |= 1048576;
            }
        }
        return this.tagBits;
    }

    public MethodBinding[] getDefaultAbstractMethods() {
        int var1 = 0;
        int var2 = this.methods.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                if (var1 == 0) {
                    return Binding.field_154;
                }
                MethodBinding[] var4 = new MethodBinding[var1];
                var1 = 0;
                int var3 = this.methods.length;
                while (true) {
                    --var3;
                    if (var3 < 0) {
                        return var4;
                    }
                    if (this.methods[var3].method_360()) {
                        var4[var1++] = this.methods[var3];
                    }
                }
            }
            if (this.methods[var2].method_360()) {
                ++var1;
            }
        }
    }

    public MethodBinding getExactConstructor(TypeBinding[] var1) {
        int var2 = var1.length;
        long var3;
        int var5;
        int var6;
        MethodBinding var7;
        TypeBinding[] var8;
        int var9;
        if ((this.tagBits & 32768L) != 0L) {
            if ((var3 = ReferenceBinding.binarySearch(TypeConstants.field_135, this.methods)) >= 0L) {
                var5 = (int)var3;
                label60:
                for (var6 = (int)(var3 >> 32); var5 <= var6; ++var5) {
                    var7 = this.methods[var5];
                    if (var7.parameters.length == var2) {
                        var8 = var7.parameters;
                        for (var9 = 0; var9 < var2; ++var9) {
                            if (var8[var9] != var1[var9]) {
                                continue label60;
                            }
                        }
                        return var7;
                    }
                }
            }
        } else {
            if ((this.tagBits & 16384L) == 0L) {
                int var10 = this.methods.length;
                if (var10 > 1) {
                    ReferenceBinding.sortMethods(this.methods, 0, var10);
                }
                this.tagBits |= 16384L;
            }
            if ((var3 = ReferenceBinding.binarySearch(TypeConstants.field_135, this.methods)) >= 0L) {
                var5 = (int)var3;
                label69:
                for (var6 = (int)(var3 >> 32); var5 <= var6; ++var5) {
                    var7 = this.methods[var5];
                    if (this.resolveTypesFor(var7) == null || var7.returnType == null) {
                        this.methods();
                        return this.getExactConstructor(var1);
                    }
                    if (var7.parameters.length == var2) {
                        var8 = var7.parameters;
                        for (var9 = 0; var9 < var2; ++var9) {
                            if (var8[var9] != var1[var9]) {
                                continue label69;
                            }
                        }
                        return var7;
                    }
                }
            }
        }
        return null;
    }

    public MethodBinding getExactMethod(char[] var1, TypeBinding[] var2, CompilationUnitScope var3) {
        int var4 = var2.length;
        boolean var5 = true;
        long var6;
        int var8;
        int var9;
        if ((this.tagBits & 32768L) != 0L) {
            if ((var6 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
                var8 = (int)var6;
                label119:
                for (var9 = (int)(var6 >> 32); var8 <= var9; ++var8) {
                    MethodBinding var10 = this.methods[var8];
                    var5 = false;
                    if (var10.parameters.length == var4) {
                        TypeBinding[] var11 = var10.parameters;
                        for (int var12 = 0; var12 < var4; ++var12) {
                            if (var11[var12] != var2[var12]) {
                                continue label119;
                            }
                        }
                        return var10;
                    }
                }
            }
        } else {
            if ((this.tagBits & 16384L) == 0L) {
                int var16 = this.methods.length;
                if (var16 > 1) {
                    ReferenceBinding.sortMethods(this.methods, 0, var16);
                }
                this.tagBits |= 16384L;
            }
            if ((var6 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
                var8 = (int)var6;
                var9 = (int)(var6 >> 32);
                int var18 = var8;
                label128:
                while (true) {
                    if (var18 <= var9) {
                        MethodBinding var21 = this.methods[var18];
                        if (this.resolveTypesFor(var21) != null && var21.returnType != null) {
                            ++var18;
                            continue;
                        }
                        this.methods();
                        return this.getExactMethod(var1, var2, var3);
                    }
                    boolean var19 = this.scope.compilerOptions().field_1928 >= 3211264L;
                    int var17;
                    MethodBinding var20;
                    for (var17 = var8; var17 <= var9; ++var17) {
                        var20 = this.methods[var17];
                        for (int var13 = var9; var13 > var17; --var13) {
                            MethodBinding var14 = this.methods[var13];
                            boolean var15 = var19 ? var20.method_342(var14) : var20.method_344(var14);
                            if (var15) {
                                this.methods();
                                return this.getExactMethod(var1, var2, var3);
                            }
                        }
                    }
                    var17 = var8;
                    while (true) {
                        if (var17 > var9) {
                            break label128;
                        }
                        var20 = this.methods[var17];
                        TypeBinding[] var22 = var20.parameters;
                        if (var22.length == var4) {
                            int var23 = 0;
                            while (true) {
                                if (var23 >= var4) {
                                    return var20;
                                }
                                if (var22[var23] != var2[var23]) {
                                    break;
                                }
                                ++var23;
                            }
                        }
                        ++var17;
                    }
                }
            }
        }
        if (var5) {
            if (this.method_157()) {
                if (this.field_253.length == 1) {
                    if (var3 != null) {
                        var3.method_693(this.field_253[0]);
                    }
                    return this.field_253[0].getExactMethod(var1, var2, var3);
                }
            } else if (this.superclass != null) {
                if (var3 != null) {
                    var3.method_693(this.superclass);
                }
                return this.superclass.getExactMethod(var1, var2, var3);
            }
        }
        return null;
    }

    public FieldBinding getField(char[] var1, boolean var2) {
        if ((this.tagBits & 8192L) != 0L) {
            return ReferenceBinding.binarySearch(var1, this.fields);
        } else {
            if ((this.tagBits & 4096L) == 0L) {
                int var3 = this.fields.length;
                if (var3 > 1) {
                    ReferenceBinding.sortFields(this.fields, 0, var3);
                }
                this.tagBits |= 4096L;
            }
            FieldBinding var16 = ReferenceBinding.binarySearch(var1, this.fields);
            if (var16 != null) {
                FieldBinding var4 = null;
                FieldBinding var5;
                try {
                    var4 = (FieldBinding) this.method_313(var16);
                    var5 = var4;
                } finally {
                    if (var4 == null) {
                        int var8 = this.fields.length - 1;
                        if (var8 == 0) {
                            this.fields = Binding.field_153;
                        } else {
                            FieldBinding[] var9 = new FieldBinding[var8];
                            int var10 = 0;
                            int var11 = 0;
                            for (int var12 = this.fields.length; var11 < var12; ++var11) {
                                FieldBinding var13 = this.fields[var11];
                                if (var13 != var16) {
                                    var9[var10++] = var13;
                                }
                            }
                            this.fields = var9;
                        }
                    }
                }
                return var5;
            } else {
                return null;
            }
        }
    }

    public MethodBinding[] getMethods(char[] var1) {
        int var5;
        int var6;
        if ((this.tagBits & 32768L) != 0L) {
            long var12;
            if ((var12 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
                int var4 = (int)var12;
                var5 = (int)(var12 >> 32);
                var6 = var5 - var4 + 1;
                MethodBinding[] var14;
                System.arraycopy(this.methods, var4, var14 = new MethodBinding[var6], 0, var6);
                return var14;
            } else {
                return Binding.field_154;
            }
        } else {
            if ((this.tagBits & 16384L) == 0L) {
                int var2 = this.methods.length;
                if (var2 > 1) {
                    ReferenceBinding.sortMethods(this.methods, 0, var2);
                }
                this.tagBits |= 16384L;
            }
            long var3;
            if ((var3 = ReferenceBinding.binarySearch(var1, this.methods)) < 0L) {
                return Binding.field_154;
            } else {
                var5 = (int)var3;
                var6 = (int)(var3 >> 32);
                int var7;
                MethodBinding var8;
                for (var7 = var5; var7 <= var6; ++var7) {
                    var8 = this.methods[var7];
                    if (this.resolveTypesFor(var8) == null || var8.returnType == null) {
                        this.methods();
                        return this.getMethods(var1);
                    }
                }
                var7 = var6 - var5 + 1;
                MethodBinding[] var11;
                System.arraycopy(this.methods, var5, var11 = new MethodBinding[var7], 0, var7);
                boolean var13 = this.scope.compilerOptions().field_1928 >= 3211264L;
                var6 = 0;
                for (var7 = var11.length - 1; var6 < var7; ++var6) {
                    var8 = var11[var6];
                    for (int var9 = var7; var9 > var6; --var9) {
                        boolean var10 = var13 ? var8.method_342(var11[var9]) : var8.method_344(var11[var9]);
                        if (var10) {
                            this.methods();
                            return this.getMethods(var1);
                        }
                    }
                }
                return var11;
            }
        }
    }

    public FieldBinding method_309(LocalVariableBinding var1) {
        return this.field_259 != null && this.field_259[1] != null ? (FieldBinding)this.field_259[1].get(var1) : null;
    }

    public FieldBinding getSyntheticField(ReferenceBinding var1, boolean var2) {
        if (this.field_259 != null && this.field_259[1] != null) {
            FieldBinding var3 = (FieldBinding)this.field_259[1].get(var1);
            if (var3 != null) {
                return var3;
            } else {
                if (!var2) {
                    Iterator var4 = this.field_259[1].values().iterator();
                    while (var4.hasNext()) {
                        var3 = (FieldBinding)var4.next();
                        if (CharOperation.method_1381(TypeConstants.field_142, var3.name) && var3.type.method_140(var1) != null) {
                            return var3;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public void initializeDeprecatedAnnotationTagBits() {
        if ((this.tagBits & 17179869184L) == 0L) {
            TypeDeclaration var1 = this.scope.referenceContext;
            boolean var2 = var1.field_589.field_412;
            try {
                var1.field_589.field_412 = true;
                ASTNode.method_762(var1.field_589, var1.annotations, this);
                this.tagBits |= 17179869184L;
            } finally {
                var1.field_589.field_412 = var2;
            }
            if ((this.tagBits & 70368744177664L) != 0L) {
                this.modifiers |= 1048576;
            }
        }
    }

    void initializeForStaticImports() {
        if (this.scope != null) {
            if (this.field_253 == null) {
                this.scope.connectTypeHierarchy();
            }
            this.scope.method_649();
            this.scope.method_654();
        }
    }

    public boolean isEquivalentTo(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.kind()) {
                case 260:
                    if ((var1.tagBits & 1073741824L) == 0L && (!this.method_159() || !var1.method_159())) {
                        return false;
                    } else {
                        ParameterizedTypeBinding var2 = (ParameterizedTypeBinding)var1;
                        if (this != var2.method_286()) {
                            return false;
                        } else {
                            if (!this.method_226()) {
                                ReferenceBinding var3 = this.enclosingType();
                                if (var3 != null) {
                                    ReferenceBinding var4 = var2.enclosingType();
                                    if (var4 == null) {
                                        return false;
                                    }
                                    if ((var4.tagBits & 1073741824L) == 0L) {
                                        if (var3 != var4) {
                                            return false;
                                        }
                                    } else if (!var3.isEquivalentTo(var2.enclosingType())) {
                                        return false;
                                    }
                                }
                            }
                            int var7 = this.typeVariables == null ? 0 : this.typeVariables.length;
                            TypeBinding[] var8 = var2.arguments;
                            int var5 = var8 == null ? 0 : var8.length;
                            if (var5 != var7) {
                                return false;
                            } else {
                                for (int var6 = 0; var6 < var7; ++var6) {
                                    if (!this.typeVariables[var6].method_168(var8[var6])) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                case 516:
                case 8196:
                    return ((WildcardBinding)var1).boundCheck(this);
                case 1028:
                    return var1.erasure() == this;
                default:
                    return false;
            }
        }
    }

    public boolean method_155() {
        return this.typeVariables != Binding.NO_TYPE_VARIABLES;
    }

    public ReferenceBinding[] memberTypes() {
        return this.field_256;
    }

    public FieldBinding method_311(FieldBinding var1, ReferenceBinding var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[3] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[3] = var10002;
        }
        Hashtable var3 = (Hashtable)this.field_259[3].get(var1);
        if (var3 == null) {
            var3 = new Hashtable(5);
            this.field_259[3].put(var1, var3);
        }
        FieldBinding var4 = (FieldBinding)var3.get(var2);
        if (var4 == null) {
            FieldBinding var5 = new FieldBinding(var1, var2);
            var4 = var5;
            var3.put(var2, var4);
        }
        return var4;
    }

    public MethodBinding method_312(MethodBinding var1, ReferenceBinding var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[3] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[3] = var10002;
        }
        Hashtable var3 = (Hashtable)this.field_259[3].get(var1);
        if (var3 == null) {
            var3 = new Hashtable(5);
            this.field_259[3].put(var1, var3);
        }
        MethodBinding var4 = (MethodBinding)var3.get(var2);
        if (var4 == null) {
            MethodBinding var5 = new MethodBinding(var1, var2);
            var4 = var5;
            var3.put(var2, var4);
        }
        return var4;
    }

    public boolean method_213() {
        return this.field_256.length > 0;
    }

    public MethodBinding[] methods() {
        if ((this.tagBits & 32768L) != 0L) {
            return this.methods;
        } else {
            int var1;
            if ((this.tagBits & 16384L) == 0L) {
                var1 = this.methods.length;
                if (var1 > 1) {
                    ReferenceBinding.sortMethods(this.methods, 0, var1);
                }
                this.tagBits |= 16384L;
            }
            var1 = 0;
            MethodBinding[] var2 = this.methods;
            try {
                int var3 = 0;
                int var4;
                for (var4 = this.methods.length; var3 < var4; ++var3) {
                    if (this.resolveTypesFor(this.methods[var3]) == null) {
                        if (var2 == this.methods) {
                            System.arraycopy(this.methods, 0, var2 = new MethodBinding[var4], 0, var4);
                        }
                        var2[var3] = null;
                        ++var1;
                    }
                }
                boolean var30 = this.scope.compilerOptions().field_1928 >= 3211264L;
                var4 = 0;
                for (int var5 = this.methods.length; var4 < var5; ++var4) {
                    MethodBinding var6 = var2[var4];
                    if (var6 != null) {
                        char[] var7 = var6.selector;
                        AbstractMethodDeclaration var8 = null;
                        for (int var9 = var4 + 1; var9 < var5; ++var9) {
                            MethodBinding var10 = var2[var9];
                            if (var10 != null) {
                                if (!CharOperation.method_1364(var7, var10.selector)) {
                                    break;
                                }
                                if (var30 && var6.returnType != null && var10.returnType != null) {
                                    TypeBinding[] var11 = var6.parameters;
                                    TypeBinding[] var12 = var10.parameters;
                                    int var13 = var11.length;
                                    if (var13 != var12.length) {
                                        continue;
                                    }
                                    TypeVariableBinding[] var14 = var6.typeVariables;
                                    TypeVariableBinding[] var15 = var10.typeVariables;
                                    boolean var16 = var14 == var15;
                                    MethodBinding var17 = var10;
                                    if (!var16) {
                                        MethodBinding var18 = var6.computeSubstitutedMethod(var10, this.scope.environment());
                                        if (var18 != null) {
                                            var16 = true;
                                            var17 = var18;
                                        }
                                    }
                                    boolean var33 = var6.method_344(var17);
                                    if ((!var33 || !var16) && (var6.returnType.erasure() != var17.returnType.erasure() || !var33 && !var6.method_342(var10))) {
                                        if (!var16 && var14 != Binding.NO_TYPE_VARIABLES && var15 != Binding.NO_TYPE_VARIABLES) {
                                            continue;
                                        }
                                        if (var13 > 0) {
                                            int var19 = var13;
                                            while (true) {
                                                --var19;
                                                if (var19 < 0 || var11[var19] != var12[var19].erasure()) {
                                                    break;
                                                }
                                                if (var11[var19] == var12[var19]) {
                                                    TypeBinding var20 = var11[var19].method_173();
                                                    if (var20 instanceof SourceTypeBinding && var20.typeVariables() != Binding.NO_TYPE_VARIABLES) {
                                                        var19 = var13;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (var19 >= 0 && var19 < var13) {
                                                var19 = var13;
                                                do {
                                                    --var19;
                                                } while (var19 >= 0 && var11[var19].erasure() == var12[var19]);
                                            }
                                            if (var19 >= 0) {
                                                continue;
                                            }
                                        }
                                    }
                                } else if (!var6.method_344(var10)) {
                                    continue;
                                }
                                boolean var31 = this.method_153() && (CharOperation.method_1364(var7, TypeConstants.field_72) || CharOperation.method_1364(var7, TypeConstants.field_71));
                                if (var8 == null) {
                                    var8 = var6.sourceMethod();
                                    if (var8 != null && var8.binding != null) {
                                        if (var31) {
                                            this.scope.problemReporter().method_1523(this, var8);
                                        } else {
                                            this.scope.problemReporter().duplicateMethodInType(this, var8, var6.method_344(var10));
                                        }
                                        var8.binding = null;
                                        if (var2 == this.methods) {
                                            System.arraycopy(this.methods, 0, var2 = new MethodBinding[var5], 0, var5);
                                        }
                                        var2[var4] = null;
                                        ++var1;
                                    }
                                }
                                AbstractMethodDeclaration var32 = var10.sourceMethod();
                                if (var32 != null && var32.binding != null) {
                                    if (var31) {
                                        this.scope.problemReporter().method_1523(this, var32);
                                    } else {
                                        this.scope.problemReporter().duplicateMethodInType(this, var32, var6.method_344(var10));
                                    }
                                    var32.binding = null;
                                    if (var2 == this.methods) {
                                        System.arraycopy(this.methods, 0, var2 = new MethodBinding[var5], 0, var5);
                                    }
                                    var2[var9] = null;
                                    ++var1;
                                }
                            }
                        }
                        if (var6.returnType == null && var8 == null) {
                            var8 = var6.sourceMethod();
                            if (var8 != null) {
                                var8.binding = null;
                            }
                            if (var2 == this.methods) {
                                System.arraycopy(this.methods, 0, var2 = new MethodBinding[var5], 0, var5);
                            }
                            var2[var4] = null;
                            ++var1;
                        }
                    }
                }
            } finally {
                if (var1 > 0) {
                    int var23 = var2.length - var1;
                    if (var23 == 0) {
                        this.methods = Binding.field_154;
                    } else {
                        MethodBinding[] var24 = new MethodBinding[var23];
                        int var25 = 0;
                        int var26 = 0;
                        for (int var27 = var2.length; var25 < var27; ++var25) {
                            if (var2[var25] != null) {
                                var24[var26++] = var2[var25];
                            }
                        }
                        this.methods = var24;
                    }
                }
                this.addDefaultAbstractMethods();
                this.tagBits |= 32768L;
            }
            return this.methods;
        }
    }

    private Binding method_313(FieldBinding var1) {
        if ((var1.field_300 & 33554432) == 0) {
            return var1;
        } else {
            if (this.scope.compilerOptions().field_1928 >= 3211264L && (var1.getAnnotationTagBits() & 70368744177664L) != 0L) {
                var1.field_300 |= 1048576;
            }
            if (this.method_230() && !var1.method_427()) {
                var1.field_300 |= 2097152;
            }
            if (this.method_214()) {
                var1.field_300 |= 262144;
            }
            FieldDeclaration[] var2 = this.scope.referenceContext.fields;
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                if (var2[var3].binding == var1) {
                    MethodScope var5 = var1.method_431() ? this.scope.referenceContext.field_589 : this.scope.referenceContext.field_588;
                    FieldBinding var6 = var5.initializedField;
                    TypeBinding var9;
                    try {
                        var5.initializedField = var1;
                        FieldDeclaration var7 = var2[var3];
                        TypeBinding var8 = var7.getKind() == 3 ? var5.environment().convertToRawType(this, false) : var7.type.resolveType(var5, true);
                        var1.type = var8;
                        var1.field_300 &= -33554433;
                        if (var8 == null) {
                            var7.binding = null;
                            var9 = null;
                            return var9;
                        }
                        if (var8 == TypeBinding.field_188) {
                            this.scope.problemReporter().method_1821(var7);
                            var7.binding = null;
                            var9 = null;
                            return var9;
                        }
                        if (!var8.method_147() || ((ArrayBinding)var8).leafComponentType != TypeBinding.field_188) {
                            if ((var8.tagBits & 128L) != 0L) {
                                var1.tagBits |= 128L;
                            }
                            var9 = var8.method_173();
                            if (var9 instanceof ReferenceBinding && (((ReferenceBinding)var9).modifiers & 1073741824) != 0) {
                                var1.field_300 |= 1073741824;
                            }
                            return var1;
                        }
                        this.scope.problemReporter().method_1822(var7);
                        var7.binding = null;
                        var9 = null;
                    } finally {
                        var5.initializedField = var6;
                    }
                    return var9;
                }
            }
            return null;
        }
    }

    public MethodBinding resolveTypesFor(MethodBinding var1) {
        if ((var1.modifiers & 33554432) == 0) {
            return var1;
        } else {
            if (this.scope.compilerOptions().field_1928 >= 3211264L && (var1.getAnnotationTagBits() & 70368744177664L) != 0L) {
                var1.modifiers |= 1048576;
            }
            if (this.method_230() && !var1.method_361()) {
                var1.modifiers |= 2097152;
            }
            if (this.method_214()) {
                var1.modifiers |= 262144;
            }
            AbstractMethodDeclaration var2 = var1.sourceMethod();
            if (var2 == null) {
                return null;
            } else {
                TypeParameter[] var3 = var2.typeParameters();
                int var5;
                if (var3 != null) {
                    var2.scope.connectTypeVariables(var3, true);
                    int var4 = 0;
                    for (var5 = var3.length; var4 < var5; ++var4) {
                        var3[var4].checkBounds(var2.scope);
                    }
                }
                TypeReference[] var14 = var2.thrownExceptions;
                int var8;
                if (var14 != null) {
                    var5 = var14.length;
                    var1.thrownExceptions = new ReferenceBinding[var5];
                    int var6 = 0;
                    for (var8 = 0; var8 < var5; ++var8) {
                        ReferenceBinding var7 = (ReferenceBinding)var14[var8].resolveType(var2.scope, true);
                        if (var7 != null) {
                            if (var7.method_149()) {
                                var2.scope.problemReporter().method_1637(var7, var14[var8]);
                            } else if (var7.findSuperTypeOriginatingFrom(21, true) == null && var7.isValidBinding()) {
                                var2.scope.problemReporter().method_1504(var14[var8], var7);
                            } else {
                                if ((var7.tagBits & 128L) != 0L) {
                                    var1.tagBits |= 128L;
                                }
                                var1.modifiers |= var7.modifiers & 1073741824;
                                var1.thrownExceptions[var6++] = var7;
                            }
                        }
                    }
                    if (var6 < var5) {
                        System.arraycopy(var1.thrownExceptions, 0, var1.thrownExceptions = new ReferenceBinding[var6], 0, var6);
                    }
                }
                boolean var15 = false;
                Argument[] var16 = var2.arguments;
                int var9;
                if (var16 != null) {
                    int var17 = var16.length;
                    var1.parameters = Binding.field_150;
                    TypeBinding[] var19 = new TypeBinding[var17];
                    for (var9 = 0; var9 < var17; ++var9) {
                        Argument var10 = var16[var9];
                        if (var10.annotations != null) {
                            var1.tagBits |= 1024L;
                        }
                        TypeBinding var11 = var10.type.resolveType(var2.scope, true);
                        if (var11 == null) {
                            var15 = true;
                        } else if (var11 == TypeBinding.field_188) {
                            var2.scope.problemReporter().argumentTypeCannotBeVoid(this, var2, var10);
                            var15 = true;
                        } else {
                            if ((var11.tagBits & 128L) != 0L) {
                                var1.tagBits |= 128L;
                            }
                            TypeBinding var12 = var11.method_173();
                            if (var12 instanceof ReferenceBinding && (((ReferenceBinding)var12).modifiers & 1073741824) != 0) {
                                var1.modifiers |= 1073741824;
                            }
                            var19[var9] = var11;
                            LocalVariableBinding var13 = new LocalVariableBinding(var10, var11, var10.field_656, true);
                            var10.binding = var13;
                        }
                    }
                    if (!var15) {
                        var1.parameters = var19;
                    }
                }
                boolean var18 = false;
                if (!var1.method_358()) {
                    TypeReference var20 = var2 instanceof MethodDeclaration ? ((MethodDeclaration)var2).returnType : null;
                    if (var20 == null) {
                        var2.scope.problemReporter().method_1680(var2);
                        var1.returnType = null;
                        var18 = true;
                    } else {
                        TypeBinding var21 = var20.resolveType(var2.scope, true);
                        if (var21 == null) {
                            var18 = true;
                        } else if (var21.method_147() && ((ArrayBinding)var21).leafComponentType == TypeBinding.field_188) {
                            var2.scope.problemReporter().method_1752((MethodDeclaration)var2);
                            var18 = true;
                        } else {
                            if ((var21.tagBits & 128L) != 0L) {
                                var1.tagBits |= 128L;
                            }
                            var1.returnType = var21;
                            TypeBinding var22 = var21.method_173();
                            if (var22 instanceof ReferenceBinding && (((ReferenceBinding)var22).modifiers & 1073741824) != 0) {
                                var1.modifiers |= 1073741824;
                            }
                        }
                    }
                }
                if (!var15) {
                    if (var18) {
                        return var1;
                    } else {
                        var1.modifiers &= -33554433;
                        return var1;
                    }
                } else {
                    var2.binding = null;
                    var1.parameters = Binding.field_150;
                    if (var3 != null) {
                        var8 = 0;
                        for (var9 = var3.length; var8 < var9; ++var8) {
                            var3[var8].binding = null;
                        }
                    }
                    return null;
                }
            }
        }
    }

    public AnnotationHolder retrieveAnnotationHolder(Binding var1, boolean var2) {
        if (var2) {
            var1.getAnnotationTagBits();
        }
        return super.retrieveAnnotationHolder(var1, false);
    }

    public void setFields(FieldBinding[] var1) {
        this.fields = var1;
    }

    public void setMethods(MethodBinding[] var1) {
        this.methods = var1;
    }

    public final int method_317() {
        return this.scope.referenceContext.field_445;
    }

    public final int method_318() {
        return this.scope.referenceContext.field_444;
    }

    SimpleLookupTable storedAnnotations(boolean var1) {
        if (var1 && this.storedAnnotations == null && this.scope != null) {
            this.scope.referenceCompilationUnit().compilationResult.field_1683 = true;
            if (!this.scope.environment().globalOptions.field_1963) {
                return null;
            }
            SimpleLookupTable var10001 = new SimpleLookupTable(3);
            this.storedAnnotations = var10001;
        }
        return this.storedAnnotations;
    }

    public ReferenceBinding superclass() {
        return this.superclass;
    }

    public ReferenceBinding[] superInterfaces() {
        return this.field_253;
    }

    public SyntheticMethodBinding[] syntheticMethods() {
        if (this.field_259 != null && this.field_259[0] != null && this.field_259[0].size() != 0) {
            int var1 = 0;
            SyntheticMethodBinding[] var2 = new SyntheticMethodBinding[1];
            Iterator var3 = this.field_259[0].keySet().iterator();
            SyntheticMethodBinding[] var5;
            int var6;
            while (var3.hasNext()) {
                Object var4 = var3.next();
                if (var4 instanceof MethodBinding) {
                    var5 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var4));
                    var6 = 0;
                    if (var5[0] != null) {
                        ++var6;
                    }
                    if (var5[1] != null) {
                        ++var6;
                    }
                    if (var1 + var6 > var2.length) {
                        System.arraycopy(var2, 0, var2 = new SyntheticMethodBinding[var1 + var6], 0, var1);
                    }
                    if (var5[0] != null) {
                        var2[var1++] = var5[0];
                    }
                    if (var5[1] != null) {
                        var2[var1++] = var5[1];
                    }
                } else {
                    var5 = (SyntheticMethodBinding[])((SyntheticMethodBinding[])this.field_259[0].get(var4));
                    var6 = 0;
                    if (var5[0] != null) {
                        ++var6;
                    }
                    if (var5[1] != null) {
                        ++var6;
                    }
                    if (var1 + var6 > var2.length) {
                        System.arraycopy(var2, 0, var2 = new SyntheticMethodBinding[var1 + var6], 0, var1);
                    }
                    if (var5[0] != null) {
                        var2[var1++] = var5[0];
                    }
                    if (var5[1] != null) {
                        var2[var1++] = var5[1];
                    }
                }
            }
            int var8;
            var5 = new SyntheticMethodBinding[var8 = var2.length];
            for (var6 = 0; var6 < var8; ++var6) {
                SyntheticMethodBinding var7 = var2[var6];
                var5[var7.field_289] = var7;
            }
            return var5;
        } else {
            return null;
        }
    }

    public FieldBinding[] syntheticFields() {
        if (this.field_259 == null) {
            return null;
        } else {
            int var1 = this.field_259[1] == null ? 0 : this.field_259[1].size();
            int var2 = this.field_259[2] == null ? 0 : this.field_259[2].size();
            int var3 = var1 + var2;
            if (var3 == 0) {
                return null;
            } else {
                FieldBinding[] var4 = new FieldBinding[var3];
                Iterator var5;
                int var6;
                SyntheticFieldBinding var7;
                if (this.field_259[1] != null) {
                    var5 = this.field_259[1].values().iterator();
                    for (var6 = 0; var6 < var1; ++var6) {
                        var7 = (SyntheticFieldBinding)var5.next();
                        var4[var7.index] = var7;
                    }
                }
                if (this.field_259[2] != null) {
                    var5 = this.field_259[2].values().iterator();
                    for (var6 = 0; var6 < var2; ++var6) {
                        var7 = (SyntheticFieldBinding)var5.next();
                        var4[var1 + var7.index] = var7;
                    }
                }
                return var4;
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(30);
        var1.append("(id=");
        if (this.id == Integer.MAX_VALUE) {
            var1.append("NoId");
        } else {
            var1.append(this.id);
        }
        var1.append(")\n");
        if (this.method_220()) {
            var1.append("deprecated ");
        }
        if (this.method_225()) {
            var1.append("public ");
        }
        if (this.method_224()) {
            var1.append("protected ");
        }
        if (this.method_223()) {
            var1.append("private ");
        }
        if (this.method_217() && this.method_151()) {
            var1.append("abstract ");
        }
        if (this.method_226() && this.method_160()) {
            var1.append("static ");
        }
        if (this.method_221()) {
            var1.append("final ");
        }
        if (this.method_153()) {
            var1.append("enum ");
        } else if (this.method_145()) {
            var1.append("@interface ");
        } else if (this.method_151()) {
            var1.append("class ");
        } else {
            var1.append("interface ");
        }
        var1.append(this.compoundName != null ? CharOperation.toString(this.compoundName) : "UNNAMED TYPE");
        int var2;
        int var3;
        if (this.typeVariables == null) {
            var1.append("<NULL TYPE VARIABLES>");
        } else if (this.typeVariables != Binding.NO_TYPE_VARIABLES) {
            var1.append("\n\t<");
            var2 = 0;
            for (var3 = this.typeVariables.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.typeVariables[var2] != null ? this.typeVariables[var2].toString() : "NULL TYPE VARIABLE");
            }
            var1.append(">");
        }
        var1.append("\n\textends ");
        var1.append(this.superclass != null ? this.superclass.debugName() : "NULL TYPE");
        if (this.field_253 != null) {
            if (this.field_253 != Binding.field_155) {
                var1.append("\n\timplements : ");
                var2 = 0;
                for (var3 = this.field_253.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.field_253[var2] != null ? this.field_253[var2].debugName() : "NULL TYPE");
                }
            }
        } else {
            var1.append("NULL SUPERINTERFACES");
        }
        if (this.enclosingType() != null) {
            var1.append("\n\tenclosing type : ");
            var1.append(this.enclosingType().debugName());
        }
        if (this.fields != null) {
            if (this.fields != Binding.field_153) {
                var1.append("\n/*   fields   */");
                var2 = 0;
                for (var3 = this.fields.length; var2 < var3; ++var2) {
                    var1.append('\n').append(this.fields[var2] != null ? this.fields[var2].toString() : "NULL FIELD");
                }
            }
        } else {
            var1.append("NULL FIELDS");
        }
        if (this.methods != null) {
            if (this.methods != Binding.field_154) {
                var1.append("\n/*   methods   */");
                var2 = 0;
                for (var3 = this.methods.length; var2 < var3; ++var2) {
                    var1.append('\n').append(this.methods[var2] != null ? this.methods[var2].toString() : "NULL METHOD");
                }
            }
        } else {
            var1.append("NULL METHODS");
        }
        if (this.field_256 != null) {
            if (this.field_256 != Binding.field_156) {
                var1.append("\n/*   members   */");
                var2 = 0;
                for (var3 = this.field_256.length; var2 < var3; ++var2) {
                    var1.append('\n').append(this.field_256[var2] != null ? this.field_256[var2].toString() : "NULL TYPE");
                }
            }
        } else {
            var1.append("NULL MEMBER TYPES");
        }
        var1.append("\n\n");
        return var1.toString();
    }

    public TypeVariableBinding[] typeVariables() {
        return this.typeVariables;
    }

    void verifyMethods(MethodVerifier var1) {
        var1.verify(this);
        int var2 = this.field_256.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return;
            }
            ((SourceTypeBinding)this.field_256[var2]).verifyMethods(var1);
        }
    }
}
