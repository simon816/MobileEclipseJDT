package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.env.IDependent;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding$3;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding$2;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding$1;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable;

import java.util.Comparator;
import java.util.Arrays;

public abstract class ReferenceBinding extends TypeBinding implements IDependent {

    public char[][] compoundName;

    public char[] sourceName;

    public int modifiers;

    public PackageBinding fPackage;

    String field_201;

    char[] field_202;

    char[] field_203;

    private SimpleLookupTable compatibleCache;

    public static ReferenceBinding field_205;

    private static final Comparator field_206;

    private static final Comparator field_207;

    public ReferenceBinding() {
    }

    public static FieldBinding binarySearch(char[] var0, FieldBinding[] var1) {
        if (var1 == null) {
            return null;
        } else {
            int var2 = var1.length;
            if (var2 == 0) {
                return null;
            } else {
                int var3 = 0;
                int var4 = var2 - 1;
                int var5 = var0.length;
                boolean var6 = false;
                while (var3 <= var4) {
                    int var9 = var3 + (var4 - var3) / 2;
                    char[] var7;
                    int var8 = compare(var0, var7 = var1[var9].name, var5, var7.length);
                    if (var8 < 0) {
                        var4 = var9 - 1;
                    } else {
                        if (var8 <= 0) {
                            return var1[var9];
                        }
                        var3 = var9 + 1;
                    }
                }
                return null;
            }
        }
    }

    public static long binarySearch(char[] var0, MethodBinding[] var1) {
        if (var1 == null) {
            return -1L;
        } else {
            int var2 = var1.length;
            if (var2 == 0) {
                return -1L;
            } else {
                int var3 = 0;
                int var4 = var2 - 1;
                int var5 = var0.length;
                boolean var6 = false;
                while (var3 <= var4) {
                    int var11 = var3 + (var4 - var3) / 2;
                    char[] var7;
                    int var8 = compare(var0, var7 = var1[var11].selector, var5, var7.length);
                    if (var8 < 0) {
                        var4 = var11 - 1;
                    } else {
                        if (var8 <= 0) {
                            int var9 = var11;
                            int var10;
                            for (var10 = var11; var9 > var3 && CharOperation.method_1364(var1[var9 - 1].selector, var0); --var9) {
                                ;
                            }
                            while (var10 < var4 && CharOperation.method_1364(var1[var10 + 1].selector, var0)) {
                                ++var10;
                            }
                            return (long)var9 + ((long)var10 << 32);
                        }
                        var3 = var11 + 1;
                    }
                }
                return -1L;
            }
        }
    }

    static int compare(char[] var0, char[] var1, int var2, int var3) {
        int var4 = Math.min(var2, var3);
        int var5 = 0;
        char var6;
        char var7;
        do {
            if (var4-- == 0) {
                return var2 - var3;
            }
            var6 = var0[var5];
            var7 = var1[var5++];
        } while (var6 == var7);
        return var6 - var7;
    }

    public static void sortFields(FieldBinding[] var0, int var1, int var2) {
        Arrays.sort(var0, var1, var2, field_206);
    }

    public static void sortMethods(MethodBinding[] var0, int var1, int var2) {
        Arrays.sort(var0, var1, var2, field_207);
    }

    public boolean method_129() {
        return (this.modifiers & 26112) == 0;
    }

    public final boolean canBeSeenBy(PackageBinding var1) {
        return this.method_225() ? true : (this.method_223() ? false : var1 == this.fPackage);
    }

    public final boolean canBeSeenBy(ReferenceBinding var1, ReferenceBinding var2) {
        if (this.method_225()) {
            return true;
        } else if (var2 == this && var2 == var1) {
            return true;
        } else if (this.method_224()) {
            if (var2 == this) {
                return true;
            } else if (var2.fPackage == this.fPackage) {
                return true;
            } else {
                Object var7 = var2.erasure();
                TypeBinding var9 = this.enclosingType().erasure();
                if (var9 == var2) {
                    return true;
                } else if (var9 == null) {
                    return false;
                } else {
                    while (((TypeBinding)var7).method_140(var9) == null) {
                        var7 = ((TypeBinding)var7).enclosingType();
                        if (var7 == null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else {
            ReferenceBinding var4;
            ReferenceBinding var6;
            if (!this.method_223()) {
                if (var2.fPackage != this.fPackage) {
                    return false;
                } else {
                    var6 = var1;
                    var4 = this.enclosingType() == null ? this : this.enclosingType();
                    do {
                        if (var4 == var6) {
                            return true;
                        }
                        PackageBinding var8 = var6.fPackage;
                        if (var8 != null && var8 != this.fPackage) {
                            return false;
                        }
                    } while ((var6 = var6.superclass()) != null);
                    return false;
                }
            } else {
                if (var1 != this && var1 != this.enclosingType()) {
                    label103: {
                        if (var1.method_169()) {
                            TypeVariableBinding var3 = (TypeVariableBinding)var1;
                            if (var3.isErasureBoundTo(this.erasure()) || var3.isErasureBoundTo(this.enclosingType().erasure())) {
                                break label103;
                            }
                        }
                        return false;
                    }
                }
                if (var2 != this) {
                    var6 = var2;
                    for (var4 = var2.enclosingType(); var4 != null; var4 = var4.enclosingType()) {
                        var6 = var4;
                    }
                    ReferenceBinding var5 = (ReferenceBinding)this.erasure();
                    for (var4 = var5.enclosingType(); var4 != null; var4 = var4.enclosingType()) {
                        var5 = var4;
                    }
                    if (var6 != var5) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final boolean canBeSeenBy(Scope var1) {
        if (this.method_225()) {
            return true;
        } else {
            SourceTypeBinding var2 = var1.enclosingSourceType();
            if (var2 == this) {
                return true;
            } else if (var2 == null) {
                return !this.method_223() && var1.getCurrentPackage() == this.fPackage;
            } else {
                Object var3;
                if (this.method_224()) {
                    if (var2.fPackage == this.fPackage) {
                        return true;
                    } else {
                        var3 = var2.erasure();
                        TypeBinding var6 = this.enclosingType().erasure();
                        if (var6 == null) {
                            return false;
                        } else {
                            while (var6 != var2) {
                                if (((TypeBinding)var3).method_140(var6) != null) {
                                    return true;
                                }
                                var3 = ((TypeBinding)var3).enclosingType();
                                if (var3 == null) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                } else if (!this.method_223()) {
                    return var2.fPackage == this.fPackage;
                } else {
                    var3 = var2;
                    ReferenceBinding var4;
                    for (var4 = var2.enclosingType(); var4 != null; var4 = var4.enclosingType()) {
                        var3 = var4;
                    }
                    ReferenceBinding var5 = (ReferenceBinding)this.erasure();
                    for (var4 = var5.enclosingType(); var4 != null; var4 = var4.enclosingType()) {
                        var5 = var4;
                    }
                    return var3 == var5;
                }
            }
        }
    }

    public char[] computeGenericTypeSignature(TypeVariableBinding[] var1) {
        boolean var2 = this.method_159() && (this.enclosingType().modifiers & 1073741824) != 0;
        if (var1 == Binding.NO_TYPE_VARIABLES && !var2) {
            return this.method_178();
        } else {
            StringBuffer var3 = new StringBuffer(10);
            char[] var4;
            if (var2) {
                var4 = this.enclosingType().genericTypeSignature();
                var3.append(var4, 0, var4.length - 1);
                var3.append('.');
                var3.append(this.sourceName);
            } else {
                var4 = this.method_178();
                var3.append(var4, 0, var4.length - 1);
            }
            int var6;
            if (var1 == Binding.NO_TYPE_VARIABLES) {
                var3.append(';');
            } else {
                var3.append('<');
                var6 = 0;
                for (int var5 = var1.length; var6 < var5; ++var6) {
                    var3.append(var1[var6].genericTypeSignature());
                }
                var3.append(">;");
            }
            var6 = var3.length();
            char[] var7 = new char[var6];
            var3.getChars(0, var6, var7, 0);
            return var7;
        }
    }

    public void computeId() {
        char[] var1;
        switch (this.compoundName.length) {
            case 3:
                if (!CharOperation.method_1364(TypeConstants.field_26, this.compoundName[0])) {
                    return;
                }
                if (!CharOperation.method_1364(TypeConstants.field_27, this.compoundName[1])) {
                    if (CharOperation.method_1364(TypeConstants.field_28, this.compoundName[1])) {
                        if (CharOperation.method_1364(TypeConstants.field_107[2], this.compoundName[2])) {
                            this.id = 53;
                        } else if (CharOperation.method_1364(TypeConstants.field_108[2], this.compoundName[2])) {
                            this.id = 37;
                        } else if (CharOperation.method_1364(TypeConstants.field_131[2], this.compoundName[2])) {
                            this.id = 56;
                        } else if (CharOperation.method_1364(TypeConstants.field_130[2], this.compoundName[2])) {
                            this.id = 57;
                        } else if (CharOperation.method_1364(TypeConstants.field_132[2], this.compoundName[2])) {
                            this.id = 58;
                        }
                    } else if (CharOperation.method_1364(TypeConstants.field_29, this.compoundName[1]) && CharOperation.method_1364(TypeConstants.field_118[2], this.compoundName[2])) {
                        this.id = 39;
                    }
                    return;
                }
                var1 = this.compoundName[2];
                if (var1.length == 0) {
                    return;
                }
                switch (var1[0]) {
                    case 65:
                        if (CharOperation.method_1364(var1, TypeConstants.field_89[2])) {
                            this.id = 35;
                        }
                        return;
                    case 66:
                        if (CharOperation.method_1364(var1, TypeConstants.field_116[2])) {
                            this.id = 33;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_109[2])) {
                            this.id = 26;
                        }
                        return;
                    case 67:
                        if (CharOperation.method_1364(var1, TypeConstants.field_111[2])) {
                            this.id = 28;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_90[2])) {
                            this.id = 16;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_91[2])) {
                            this.id = 23;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_92[2])) {
                            this.id = 36;
                        }
                        return;
                    case 68:
                        if (CharOperation.method_1364(var1, TypeConstants.field_115[2])) {
                            this.id = 32;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_119[2])) {
                            this.id = 44;
                        }
                        return;
                    case 69:
                        if (CharOperation.method_1364(var1, TypeConstants.field_95[2])) {
                            this.id = 19;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_94[2])) {
                            this.id = 25;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_93[2])) {
                            this.id = 41;
                        }
                        return;
                    case 70:
                        if (CharOperation.method_1364(var1, TypeConstants.field_114[2])) {
                            this.id = 31;
                        }
                        return;
                    case 71:
                    case 72:
                    case 74:
                    case 75:
                    case 77:
                    case 80:
                    case 81:
                    case 85:
                    default:
                        return;
                    case 73:
                        if (CharOperation.method_1364(var1, TypeConstants.field_112[2])) {
                            this.id = 29;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_97[2])) {
                            this.id = 38;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_96[2])) {
                            this.id = 42;
                        }
                        return;
                    case 76:
                        if (CharOperation.method_1364(var1, TypeConstants.field_113[2])) {
                            this.id = 30;
                        }
                        return;
                    case 78:
                        if (CharOperation.method_1364(var1, TypeConstants.field_98[2])) {
                            this.id = 22;
                        }
                        return;
                    case 79:
                        if (CharOperation.method_1364(var1, TypeConstants.field_99[2])) {
                            this.id = 1;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_122[2])) {
                            this.id = 47;
                        }
                        return;
                    case 82:
                        if (CharOperation.method_1364(var1, TypeConstants.field_104[2])) {
                            this.id = 24;
                        }
                        return;
                    case 83:
                        if (CharOperation.method_1364(var1, TypeConstants.field_100[2])) {
                            this.id = 11;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_101[2])) {
                            this.id = 17;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_102[2])) {
                            this.id = 40;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_103[2])) {
                            this.id = 18;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_110[2])) {
                            this.id = 27;
                        } else if (CharOperation.method_1364(var1, TypeConstants.field_124[2])) {
                            this.id = 49;
                        }
                        return;
                    case 84:
                        if (CharOperation.method_1364(var1, TypeConstants.field_105[2])) {
                            this.id = 21;
                        }
                        return;
                    case 86:
                        if (CharOperation.method_1364(var1, TypeConstants.field_117[2])) {
                            this.id = 34;
                        }
                        return;
                }
            case 4:
                if (!CharOperation.method_1364(TypeConstants.field_26, this.compoundName[0])) {
                    return;
                }
                if (!CharOperation.method_1364(TypeConstants.field_27, this.compoundName[1])) {
                    return;
                }
                char[] var2 = this.compoundName[2];
                if (var2.length == 0) {
                    return;
                }
                var1 = this.compoundName[3];
                if (var1.length == 0) {
                    return;
                }
                if (CharOperation.method_1364(var2, TypeConstants.field_31)) {
                    if (CharOperation.method_1364(var1, TypeConstants.field_106[3])) {
                        this.id = 20;
                    } else if (CharOperation.method_1364(var1, TypeConstants.field_128[3])) {
                        this.id = 54;
                    } else if (CharOperation.method_1364(var1, TypeConstants.field_129[3])) {
                        this.id = 55;
                    }
                    return;
                }
                if (CharOperation.method_1364(var2, TypeConstants.field_30)) {
                    switch (var1[0]) {
                        case 65:
                            if (CharOperation.method_1364(var1, TypeConstants.field_88[3])) {
                                this.id = 43;
                            }
                            return;
                        case 66:
                        case 67:
                        case 70:
                        case 71:
                        case 72:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 83:
                        default:
                            break;
                        case 68:
                            if (CharOperation.method_1364(var1, TypeConstants.field_120[3])) {
                                this.id = 45;
                            }
                            return;
                        case 69:
                            if (CharOperation.method_1364(var1, TypeConstants.field_127[3])) {
                                this.id = 52;
                            }
                            return;
                        case 73:
                            if (CharOperation.method_1364(var1, TypeConstants.field_121[3])) {
                                this.id = 46;
                            }
                            return;
                        case 82:
                            if (CharOperation.method_1364(var1, TypeConstants.field_123[3])) {
                                this.id = 48;
                            } else if (CharOperation.method_1364(var1, TypeConstants.field_126[3])) {
                                this.id = 51;
                            }
                            return;
                        case 84:
                            if (CharOperation.method_1364(var1, TypeConstants.field_125[3])) {
                                this.id = 50;
                            }
                            return;
                    }
                }
        }
    }

    public char[] constantPoolName() {
        return this.field_202 != null ? this.field_202 : (this.field_202 = CharOperation.concatWith(this.compoundName, '/'));
    }

    public String debugName() {
        return this.compoundName != null ? new String(this.readableName()) : "UNNAMED TYPE";
    }

    public final int method_199() {
        int var1 = 0;
        for (ReferenceBinding var2 = this; (var2 = var2.enclosingType()) != null; ++var1) {
            ;
        }
        return var1;
    }

    public boolean method_200() {
        if ((this.tagBits & 4294967296L) != 0L) {
            return false;
        } else if ((this.tagBits & 2147483648L) != 0L) {
            return true;
        } else {
            this.tagBits |= 2147483648L;
            MethodBinding[] var1 = this.methods();
            boolean var2 = false;
            int var3 = 0;
            for (int var4 = var1.length; var3 < var4; ++var3) {
                TypeBinding var5 = var1[var3].returnType.method_173();
                MethodDeclaration var6;
                if (this == var5) {
                    if (this instanceof SourceTypeBinding) {
                        var6 = (MethodDeclaration)var1[var3].sourceMethod();
                        ((SourceTypeBinding)this).scope.problemReporter().annotationCircularity(this, this, var6 != null ? var6.returnType : null);
                    }
                } else if (var5.method_145() && ((ReferenceBinding)var5).method_200()) {
                    if (this instanceof SourceTypeBinding) {
                        var6 = (MethodDeclaration)var1[var3].sourceMethod();
                        ((SourceTypeBinding)this).scope.problemReporter().annotationCircularity(this, var5, var6 != null ? var6.returnType : null);
                    }
                    var2 = true;
                }
            }
            if (var2) {
                return true;
            } else {
                this.tagBits |= 4294967296L;
                return false;
            }
        }
    }

    public final ReferenceBinding enclosingTypeAt(int var1) {
        ReferenceBinding var2;
        for (var2 = this; var1-- > 0 && var2 != null; var2 = var2.enclosingType()) {
            ;
        }
        return var2;
    }

    public int method_202() {
        int var1 = 0;
        FieldBinding[] var2 = this.fields();
        int var3 = 0;
        for (int var4 = var2.length; var3 < var4; ++var3) {
            if ((var2[var3].field_300 & 16384) != 0) {
                ++var1;
            }
        }
        return var1;
    }

    public int method_203() {
        return this.fields().length;
    }

    public FieldBinding[] fields() {
        return Binding.field_153;
    }

    public final int method_205() {
        return this.modifiers & '\uffff';
    }

    public long getAnnotationTagBits() {
        return this.tagBits;
    }

    public MethodBinding getExactConstructor(TypeBinding[] var1) {
        return null;
    }

    public MethodBinding getExactMethod(char[] var1, TypeBinding[] var2, CompilationUnitScope var3) {
        return null;
    }

    public FieldBinding getField(char[] var1, boolean var2) {
        return null;
    }

    public String method_50() {
        return this.field_201;
    }

    public ReferenceBinding getMemberType(char[] var1) {
        ReferenceBinding[] var2 = this.memberTypes();
        int var3 = var2.length;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
        } while (!CharOperation.method_1364(var2[var3].sourceName, var1));
        return var2[var3];
    }

    public MethodBinding[] getMethods(char[] var1) {
        return Binding.field_154;
    }

    public PackageBinding getPackage() {
        return this.fPackage;
    }

    public TypeVariableBinding getTypeVariable(char[] var1) {
        TypeVariableBinding[] var2 = this.typeVariables();
        int var3 = var2.length;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
        } while (!CharOperation.method_1364(var2[var3].sourceName, var1));
        return var2[var3];
    }

    public int hashCode() {
        return this.compoundName != null && this.compoundName.length != 0 ? CharOperation.hashCode(this.compoundName[this.compoundName.length - 1]) : super.hashCode();
    }

    public boolean method_212(ReferenceBinding var1) {
        if (this == var1) {
            return false;
        } else {
            ReferenceBinding[] var2 = null;
            int var3 = 0;
            ReferenceBinding var4 = this;
            TypeBinding var5;
            int var8;
            do {
                var5 = var1.method_140(var4);
                if (var5 != null && var5.method_164(var4)) {
                    return true;
                }
                ReferenceBinding[] var6 = var4.superInterfaces();
                if (var6 != null && var6 != Binding.field_155) {
                    if (var2 == null) {
                        var2 = var6;
                        var3 = var6.length;
                    } else {
                        int var7 = var6.length;
                        if (var3 + var7 >= var2.length) {
                            System.arraycopy(var2, 0, var2 = new ReferenceBinding[var3 + var7 + 5], 0, var3);
                        }
                        var8 = 0;
                        while (var8 < var7) {
                            ReferenceBinding var9 = var6[var8];
                            int var10 = 0;
                            while (true) {
                                if (var10 < var3) {
                                    if (var9 != var2[var10]) {
                                        ++var10;
                                        continue;
                                    }
                                } else {
                                    var2[var3++] = var9;
                                }
                                ++var8;
                                break;
                            }
                        }
                    }
                }
            } while ((var4 = var4.superclass()) != null);
            for (int var12 = 0; var12 < var3; ++var12) {
                var4 = var2[var12];
                if (var4 == var1) {
                    return false;
                }
                var5 = var1.method_140(var4);
                if (var5 != null && var5.method_164(var4)) {
                    return true;
                }
                ReferenceBinding[] var13 = var4.superInterfaces();
                if (var13 != null && var13 != Binding.field_155) {
                    var8 = var13.length;
                    if (var3 + var8 >= var2.length) {
                        System.arraycopy(var2, 0, var2 = new ReferenceBinding[var3 + var8 + 5], 0, var3);
                    }
                    int var14 = 0;
                    while (var14 < var8) {
                        ReferenceBinding var15 = var13[var14];
                        int var11 = 0;
                        while (true) {
                            if (var11 < var3) {
                                if (var15 != var2[var11]) {
                                    ++var11;
                                    continue;
                                }
                            } else {
                                var2[var3++] = var15;
                            }
                            ++var14;
                            break;
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean method_213() {
        return false;
    }

    public final boolean method_214() {
        return (this.modifiers & 262144) != 0;
    }

    public boolean implementsInterface(ReferenceBinding var1, boolean var2) {
        if (this == var1) {
            return true;
        } else {
            ReferenceBinding[] var3 = null;
            int var4 = 0;
            ReferenceBinding var5 = this;
            int var8;
            do {
                ReferenceBinding[] var6 = var5.superInterfaces();
                if (var6 != null && var6 != Binding.field_155) {
                    if (var3 == null) {
                        var3 = var6;
                        var4 = var6.length;
                    } else {
                        int var7 = var6.length;
                        if (var4 + var7 >= var3.length) {
                            System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var7 + 5], 0, var4);
                        }
                        label80:
                        for (var8 = 0; var8 < var7; ++var8) {
                            ReferenceBinding var9 = var6[var8];
                            for (int var10 = 0; var10 < var4; ++var10) {
                                if (var9 == var3[var10]) {
                                    continue label80;
                                }
                            }
                            var3[var4++] = var9;
                        }
                    }
                }
            } while (var2 && (var5 = var5.superclass()) != null);
            for (int var12 = 0; var12 < var4; ++var12) {
                var5 = var3[var12];
                if (var5.isEquivalentTo(var1)) {
                    return true;
                }
                ReferenceBinding[] var13 = var5.superInterfaces();
                if (var13 != null && var13 != Binding.field_155) {
                    var8 = var13.length;
                    if (var4 + var8 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var8 + 5], 0, var4);
                    }
                    int var14 = 0;
                    while (var14 < var8) {
                        ReferenceBinding var15 = var13[var14];
                        int var11 = 0;
                        while (true) {
                            if (var11 < var4) {
                                if (var15 != var3[var11]) {
                                    ++var11;
                                    continue;
                                }
                            } else {
                                var3[var4++] = var15;
                            }
                            ++var14;
                            break;
                        }
                    }
                }
            }
            return false;
        }
    }

    boolean implementsMethod(MethodBinding var1) {
        char[] var2 = var1.selector;
        for (ReferenceBinding var3 = this; var3 != null; var3 = var3.superclass()) {
            MethodBinding[] var4 = var3.methods();
            long var5;
            if ((var5 = binarySearch(var2, var4)) >= 0L) {
                int var7 = (int)var5;
                int var8 = (int)(var5 >> 32);
                for (int var9 = var7; var9 <= var8; ++var9) {
                    if (var4[var9].method_344(var1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean method_217() {
        return (this.modifiers & 1024) != 0;
    }

    public boolean method_145() {
        return (this.modifiers & 8192) != 0;
    }

    public final boolean method_218() {
        return (this.tagBits & 64L) != 0L;
    }

    public boolean method_151() {
        return (this.modifiers & 25088) == 0;
    }

    public boolean isCompatibleWith(TypeBinding var1) {
        if (var1 == this) {
            return true;
        } else if (var1.id == 1) {
            return true;
        } else {
            Object var2;
            if (this.compatibleCache == null) {
                SimpleLookupTable var10001 = new SimpleLookupTable(3);
                this.compatibleCache = var10001;
                var2 = null;
            } else {
                var2 = this.compatibleCache.method_3241(var1);
                if (var2 != null) {
                    return var2 == Boolean.TRUE;
                }
            }
            this.compatibleCache.put(var1, Boolean.FALSE);
            if (this.isCompatibleWith0(var1)) {
                this.compatibleCache.put(var1, Boolean.TRUE);
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean isCompatibleWith0(TypeBinding var1) {
        if (var1 == this) {
            return true;
        } else if (var1.id == 1) {
            return true;
        } else if (this.isEquivalentTo(var1)) {
            return true;
        } else {
            switch (var1.kind()) {
                case 516:
                case 8196:
                    return false;
                case 4100:
                    if (var1.isCapture()) {
                        CaptureBinding var2 = (CaptureBinding)var1;
                        TypeBinding var3 = var2.lowerBound;
                        if (var2.lowerBound != null) {
                            if (var3.method_147()) {
                                return false;
                            }
                            return this.isCompatibleWith(var3);
                        }
                    }
                case 4:
                case 260:
                case 1028:
                case 2052:
                    switch (this.kind()) {
                        case 260:
                        case 1028:
                        case 2052:
                            if (this.erasure() == var1.erasure()) {
                                return false;
                            }
                        default:
                            ReferenceBinding var4 = (ReferenceBinding)var1;
                            if (var4.method_157()) {
                                return this.implementsInterface(var4, true);
                            } else {
                                if (this.method_157()) {
                                    return false;
                                }
                                return var4.isSuperclassOf(this);
                            }
                    }
                default:
                    return false;
            }
        }
    }

    public final boolean method_220() {
        return (this.modifiers & 1048576) != 0;
    }

    public boolean method_153() {
        return (this.modifiers & 16384) != 0;
    }

    public final boolean method_221() {
        return (this.modifiers & 16) != 0;
    }

    public boolean method_222() {
        return (this.tagBits & 512L) == 0L && (this.tagBits & 256L) != 0L;
    }

    public boolean method_157() {
        return (this.modifiers & 512) != 0;
    }

    public final boolean method_223() {
        return (this.modifiers & 2) != 0;
    }

    public final boolean method_224() {
        return (this.modifiers & 4) != 0;
    }

    public final boolean method_225() {
        return (this.modifiers & 1) != 0;
    }

    public final boolean method_226() {
        return (this.modifiers & 520) != 0 || (this.tagBits & 4L) == 0L;
    }

    public final boolean method_227() {
        return (this.modifiers & 2048) != 0;
    }

    public boolean isSuperclassOf(ReferenceBinding var1) {
        while (true) {
            if ((var1 = var1.superclass()) != null) {
                if (!var1.isEquivalentTo(this)) {
                    continue;
                }
                return true;
            }
            return false;
        }
    }

    public boolean isUncheckedException(boolean var1) {
        switch (this.id) {
            case 19:
            case 24:
                return true;
            case 20:
            case 22:
            case 23:
            default:
                ReferenceBinding var2 = this;
                while ((var2 = var2.superclass()) != null) {
                    switch (var2.id) {
                        case 19:
                        case 24:
                            return true;
                        case 20:
                        case 22:
                        case 23:
                        default:
                            break;
                        case 21:
                        case 25:
                            return false;
                    }
                }
                return false;
            case 21:
            case 25:
                return var1;
        }
    }

    public final boolean method_229() {
        return (this.modifiers & 134217728) != 0;
    }

    public final boolean method_230() {
        return (this.modifiers & 3145728) != 0 || (this.getPackage().tagBits & 70368744177664L) != 0L;
    }

    public ReferenceBinding[] memberTypes() {
        return Binding.field_156;
    }

    public MethodBinding[] methods() {
        return Binding.field_154;
    }

    public final ReferenceBinding outermostEnclosingType() {
        ReferenceBinding var1 = this;
        ReferenceBinding var2;
        do {
            var2 = var1;
        } while ((var1 = var1.enclosingType()) != null);
        return var2;
    }

    public char[] method_177() {
        return this.method_159() ? CharOperation.concat(this.enclosingType().method_177(), this.method_179(), '.') : this.method_179();
    }

    public char[] readableName() {
        char[] var1;
        if (this.method_159()) {
            var1 = CharOperation.concat(this.enclosingType().readableName(), this.sourceName, '.');
        } else {
            var1 = CharOperation.concatWith(this.compoundName, '.');
        }
        TypeVariableBinding[] var2;
        if ((var2 = this.typeVariables()) != Binding.NO_TYPE_VARIABLES) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].readableName());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    public AnnotationHolder retrieveAnnotationHolder(Binding var1, boolean var2) {
        SimpleLookupTable var3 = this.storedAnnotations(false);
        return var3 == null ? null : (AnnotationHolder)var3.method_3241(var1);
    }

    AnnotationBinding[] retrieveAnnotations(Binding var1) {
        AnnotationHolder var2 = this.retrieveAnnotationHolder(var1, true);
        return var2 == null ? Binding.NO_ANNOTATIONS : var2.getAnnotations();
    }

    public void setAnnotations(AnnotationBinding[] var1) {
        this.storeAnnotations(this, var1);
    }

    public char[] shortReadableName() {
        char[] var1;
        if (this.method_159()) {
            var1 = CharOperation.concat(this.enclosingType().shortReadableName(), this.sourceName, '.');
        } else {
            var1 = this.sourceName;
        }
        TypeVariableBinding[] var2;
        if ((var2 = this.typeVariables()) != Binding.NO_TYPE_VARIABLES) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].shortReadableName());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    public char[] method_178() {
        return this.field_203 != null ? this.field_203 : (this.field_203 = CharOperation.concat('L', this.constantPoolName(), ';'));
    }

    public char[] method_179() {
        return this.sourceName;
    }

    void storeAnnotationHolder(Binding var1, AnnotationHolder var2) {
        SimpleLookupTable var3;
        if (var2 == null) {
            var3 = this.storedAnnotations(false);
            if (var3 != null) {
                var3.method_3243(var1);
            }
        } else {
            var3 = this.storedAnnotations(true);
            if (var3 != null) {
                var3.put(var1, var2);
            }
        }
    }

    void storeAnnotations(Binding var1, AnnotationBinding[] var2) {
        AnnotationHolder var3 = null;
        SimpleLookupTable var4;
        if (var2 != null && var2.length != 0) {
            var4 = this.storedAnnotations(true);
            if (var4 == null) {
                return;
            }
            var3 = (AnnotationHolder)var4.method_3241(var1);
            if (var3 == null) {
                AnnotationHolder var10000 = new AnnotationHolder();
                var3 = var10000;
            }
        } else {
            var4 = this.storedAnnotations(false);
            if (var4 != null) {
                var3 = (AnnotationHolder)var4.method_3241(var1);
            }
            if (var3 == null) {
                return;
            }
        }
        this.storeAnnotationHolder(var1, var3.setAnnotations(var2));
    }

    SimpleLookupTable storedAnnotations(boolean var1) {
        return null;
    }

    public ReferenceBinding superclass() {
        return null;
    }

    public ReferenceBinding[] superInterfaces() {
        return Binding.field_155;
    }

    public ReferenceBinding[] syntheticEnclosingInstanceTypes() {
        if (this.method_226()) {
            return null;
        } else {
            ReferenceBinding var1 = this.enclosingType();
            return var1 == null ? null : new ReferenceBinding[] {var1};
        }
    }

    public SyntheticArgumentBinding[] syntheticOuterLocalVariables() {
        return null;
    }

    MethodBinding[] unResolvedMethods() {
        return this.methods();
    }

    static {
        ReferenceBinding$1 var10000 = new ReferenceBinding$1();
        field_205 = var10000;
        ReferenceBinding$2 var0 = new ReferenceBinding$2();
        field_206 = var0;
        ReferenceBinding$3 var1 = new ReferenceBinding$3();
        field_207 = var1;
    }
}
