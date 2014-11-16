package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MemberTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;

import java.util.HashMap;

public class ClassScope extends Scope {

    public TypeDeclaration referenceContext;

    public TypeReference superTypeReference;

    public ClassScope(Scope var1, TypeDeclaration var2) {
        super(3, var1);
        this.referenceContext = var2;
    }

    void buildAnonymousTypeBinding(SourceTypeBinding var1, ReferenceBinding var2) {
        LocalTypeBinding var3 = this.buildLocalType(var1, var2, var1.fPackage);
        if (var2.method_157()) {
            var3.superclass = this.method_609();
            var3.field_253 = new ReferenceBinding[] {var2};
        } else {
            var3.superclass = var2;
            var3.field_253 = Binding.field_155;
            TypeReference var4 = this.referenceContext.allocation.type;
            if (var4 != null) {
                if (var2.erasure().id == 41) {
                    this.problemReporter().method_1496(var3, var4, var2);
                    var3.tagBits |= 131072L;
                    var3.superclass = this.method_609();
                } else if (var2.method_221()) {
                    this.problemReporter().method_1478(var4, var2);
                    var3.tagBits |= 131072L;
                    var3.superclass = this.method_609();
                } else if ((var2.tagBits & 1073741824L) != 0L) {
                    this.problemReporter().method_1765(var3, var4, var2);
                    var3.tagBits |= 131072L;
                    var3.superclass = this.method_609();
                }
            }
        }
        this.method_662();
        this.method_650();
        var3.method_306();
        var3.verifyMethods(this.environment().methodVerifier());
    }

    void method_649() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        if (!var1.method_304()) {
            if (this.referenceContext.fields == null) {
                var1.setFields(Binding.field_153);
            } else {
                FieldDeclaration[] var2 = this.referenceContext.fields;
                int var3 = var2.length;
                int var4 = 0;
                int var5 = 0;
                while (var5 < var3) {
                    switch (var2[var5].getKind()) {
                        case 1:
                        case 3:
                            ++var4;
                        default:
                            ++var5;
                    }
                }
                FieldBinding[] var15 = new FieldBinding[var4];
                HashtableOfObject var10000 = new HashtableOfObject(var4);
                HashtableOfObject var6 = var10000;
                boolean var7 = false;
                var4 = 0;
                FieldBinding var10;
                for (int var8 = 0; var8 < var3; ++var8) {
                    FieldDeclaration var9 = var2[var8];
                    if (var9.getKind() == 2) {
                        if (var1.method_157()) {
                            this.problemReporter().method_1621(var1, var9);
                        }
                    } else {
                        FieldBinding var14 = new FieldBinding(var9, (TypeBinding)null, var9.field_656 | 33554432, var1);
                        var10 = var14;
                        var10.field_304 = var4;
                        this.checkAndSetModifiersForField(var10, var9);
                        if (var6.containsKey(var9.name)) {
                            var7 = true;
                            FieldBinding var11 = (FieldBinding)var6.method_3226(var9.name);
                            if (var11 != null) {
                                for (int var12 = 0; var12 < var8; ++var12) {
                                    FieldDeclaration var13 = var2[var12];
                                    if (var13.binding == var11) {
                                        this.problemReporter().method_1524(var1, var13);
                                        var13.binding = null;
                                        break;
                                    }
                                }
                            }
                            var6.put(var9.name, (Object)null);
                            this.problemReporter().method_1524(var1, var9);
                            var9.binding = null;
                        } else {
                            var6.put(var9.name, var10);
                            var15[var4++] = var10;
                        }
                    }
                }
                if (var7) {
                    FieldBinding[] var16 = new FieldBinding[var15.length];
                    var3 = var4;
                    var4 = 0;
                    for (int var17 = 0; var17 < var3; ++var17) {
                        var10 = var15[var17];
                        if (var6.method_3226(var10.name) != null) {
                            var10.field_304 = var4;
                            var16[var4++] = var10;
                        }
                    }
                    var15 = var16;
                }
                if (var4 != var15.length) {
                    System.arraycopy(var15, 0, var15 = new FieldBinding[var4], 0, var4);
                }
                var1.tagBits &= -12289L;
                var1.setFields(var15);
            }
        }
    }

    void method_650() {
        this.method_649();
        this.method_654();
        SourceTypeBinding var1 = this.referenceContext.binding;
        if (var1.method_159() && !var1.method_158()) {
            ((MemberTypeBinding)var1).checkSyntheticArgsAndFields();
        }
        ReferenceBinding[] var2 = var1.field_256;
        int var3 = 0;
        for (int var4 = var2.length; var3 < var4; ++var3) {
            ((SourceTypeBinding)var2[var3]).scope.method_650();
        }
    }

    private LocalTypeBinding buildLocalType(SourceTypeBinding var1, ReferenceBinding var2, PackageBinding var3) {
        this.referenceContext.scope = this;
        TypeDeclaration var10000 = this.referenceContext;
        MethodScope var10001 = new MethodScope(this, this.referenceContext, true);
        var10000.field_589 = var10001;
        var10000 = this.referenceContext;
        var10001 = new MethodScope(this, this.referenceContext, false);
        var10000.field_588 = var10001;
        LocalTypeBinding var15 = new LocalTypeBinding(this, var1, this.innermostSwitchCase(), var2);
        LocalTypeBinding var4 = var15;
        this.referenceContext.binding = var4;
        this.method_657();
        this.method_656();
        ReferenceBinding[] var5 = Binding.field_156;
        if (this.referenceContext.memberTypes != null) {
            int var6 = this.referenceContext.memberTypes.length;
            var5 = new ReferenceBinding[var6];
            int var7 = 0;
            label43:
            for (int var8 = 0; var8 < var6; ++var8) {
                TypeDeclaration var9 = this.referenceContext.memberTypes[var8];
                switch (TypeDeclaration.kind(var9.field_577)) {
                    case 2:
                    case 4:
                        this.problemReporter().method_1573(var9);
                        break;
                    default:
                        Object var10 = var4;
                        do {
                            if (CharOperation.method_1364(((ReferenceBinding)var10).sourceName, var9.name)) {
                                this.problemReporter().method_1772(var9);
                                continue label43;
                            }
                            var10 = ((ReferenceBinding)var10).enclosingType();
                        } while (var10 != null);
                        for (int var11 = 0; var11 < var8; ++var11) {
                            if (CharOperation.method_1364(this.referenceContext.memberTypes[var11].name, var9.name)) {
                                this.problemReporter().method_1534(var9);
                                continue label43;
                            }
                        }
                        ClassScope var14 = new ClassScope(this, this.referenceContext.memberTypes[var8]);
                        ClassScope var16 = var14;
                        LocalTypeBinding var12 = var16.buildLocalType(var4, (ReferenceBinding)null, var3);
                        var12.method_337();
                        var5[var7++] = var12;
                }
            }
            if (var7 != var6) {
                System.arraycopy(var5, 0, var5 = new ReferenceBinding[var7], 0, var7);
            }
        }
        var4.field_256 = var5;
        return var4;
    }

    void buildLocalTypeBinding(SourceTypeBinding var1) {
        LocalTypeBinding var2 = this.buildLocalType(var1, (ReferenceBinding)null, var1.fPackage);
        this.connectTypeHierarchy();
        this.method_650();
        var2.method_306();
        this.referenceContext.binding.verifyMethods(this.environment().methodVerifier());
    }

    private void buildMemberTypes(AccessRestriction var1) {
        SourceTypeBinding var2 = this.referenceContext.binding;
        ReferenceBinding[] var3 = Binding.field_156;
        if (this.referenceContext.memberTypes != null) {
            int var4 = this.referenceContext.memberTypes.length;
            var3 = new ReferenceBinding[var4];
            int var5 = 0;
            label50:
            for (int var6 = 0; var6 < var4; ++var6) {
                TypeDeclaration var7 = this.referenceContext.memberTypes[var6];
                switch (TypeDeclaration.kind(var7.field_577)) {
                    case 2:
                    case 4:
                        if (var2.method_160() && var2.method_151() && !var2.method_226()) {
                            this.problemReporter().method_1573(var7);
                            break;
                        }
                    default:
                        Object var8 = var2;
                        do {
                            if (CharOperation.method_1364(((ReferenceBinding)var8).sourceName, var7.name)) {
                                this.problemReporter().method_1772(var7);
                                continue label50;
                            }
                            var8 = ((ReferenceBinding)var8).enclosingType();
                        } while (var8 != null);
                        for (int var9 = 0; var9 < var6; ++var9) {
                            if (CharOperation.method_1364(this.referenceContext.memberTypes[var9].name, var7.name)) {
                                this.problemReporter().method_1534(var7);
                                continue label50;
                            }
                        }
                        ClassScope var10000 = new ClassScope(this, var7);
                        ClassScope var10 = var10000;
                        var3[var5++] = var10.buildType(var2, var2.fPackage, var1);
                }
            }
            if (var5 != var4) {
                System.arraycopy(var3, 0, var3 = new ReferenceBinding[var5], 0, var5);
            }
        }
        var2.field_256 = var3;
    }

    void method_654() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        if (!var1.method_305()) {
            boolean var2 = TypeDeclaration.kind(this.referenceContext.field_577) == 3;
            if (this.referenceContext.methods == null && !var2) {
                this.referenceContext.binding.setMethods(Binding.field_154);
            } else {
                AbstractMethodDeclaration[] var3 = this.referenceContext.methods;
                int var4 = var3 == null ? 0 : var3.length;
                int var5 = -1;
                int var6;
                for (var6 = 0; var6 < var4; ++var6) {
                    if (var3[var6].method_794()) {
                        var5 = var6;
                        break;
                    }
                }
                var6 = var2 ? 2 : 0;
                MethodBinding[] var7 = new MethodBinding[(var5 == -1 ? var4 : var4 - 1) + var6];
                if (var2) {
                    var7[0] = var1.addSyntheticEnumMethod(TypeConstants.field_71);
                    var7[1] = var1.addSyntheticEnumMethod(TypeConstants.field_72);
                }
                for (int var8 = 0; var8 < var4; ++var8) {
                    if (var8 != var5) {
                        MethodScope var10000 = new MethodScope(this, var3[var8], false);
                        MethodScope var9 = var10000;
                        MethodBinding var10 = var9.createMethod(var3[var8]);
                        if (var10 != null) {
                            var7[var6++] = var10;
                        }
                    }
                }
                if (var6 != var7.length) {
                    System.arraycopy(var7, 0, var7 = new MethodBinding[var6], 0, var6);
                }
                var1.tagBits &= -49153L;
                var1.setMethods(var7);
            }
        }
    }

    SourceTypeBinding buildType(SourceTypeBinding var1, PackageBinding var2, AccessRestriction var3) {
        this.referenceContext.scope = this;
        TypeDeclaration var10000 = this.referenceContext;
        MethodScope var10001 = new MethodScope(this, this.referenceContext, true);
        var10000.field_589 = var10001;
        var10000 = this.referenceContext;
        var10001 = new MethodScope(this, this.referenceContext, false);
        var10000.field_588 = var10001;
        char[][] var4;
        if (var1 == null) {
            var4 = CharOperation.arrayConcat(var2.compoundName, this.referenceContext.name);
            var10000 = this.referenceContext;
            SourceTypeBinding var6 = new SourceTypeBinding(var4, var2, this);
            var10000.binding = var6;
        } else {
            var4 = CharOperation.deepCopy(var1.compoundName);
            var4[var4.length - 1] = CharOperation.concat(var4[var4.length - 1], this.referenceContext.name, '$');
            ReferenceBinding var5 = var2.method_124(var4[var4.length - 1]);
            if (var5 != null && !(var5 instanceof UnresolvedReferenceBinding)) {
                this.parent.problemReporter().method_1534(this.referenceContext);
            }
            var10000 = this.referenceContext;
            MemberTypeBinding var7 = new MemberTypeBinding(var4, this, var1);
            var10000.binding = var7;
        }
        SourceTypeBinding var8 = this.referenceContext.binding;
        this.environment().setAccessRestriction(var8, var3);
        var8.fPackage.addType(var8);
        this.method_657();
        this.method_656();
        this.buildMemberTypes(var3);
        return var8;
    }

    private void method_656() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        TypeParameter[] var2 = this.referenceContext.typeParameters;
        if (var2 != null && this.compilerOptions().field_1928 >= 3211264L) {
            var1.typeVariables = Binding.NO_TYPE_VARIABLES;
            if (var1.id == 1) {
                this.problemReporter().method_1711(this.referenceContext);
            } else {
                var1.typeVariables = this.createTypeVariables(var2, var1);
                var1.modifiers |= 1073741824;
            }
        } else {
            var1.typeVariables = Binding.NO_TYPE_VARIABLES;
        }
    }

    private void method_657() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        int var2 = var1.modifiers;
        if ((var2 & 4194304) != 0) {
            this.problemReporter().method_1532(var1);
        }
        ReferenceBinding var3 = var1.enclosingType();
        boolean var4 = var1.method_159();
        if (var4) {
            var2 |= var3.modifiers & 1073743872;
            if (var3.method_157()) {
                var2 |= 1;
            }
            if (var1.method_153()) {
                if (!var3.method_226()) {
                    this.problemReporter().method_1706(var1);
                } else {
                    var2 |= 8;
                }
            }
            if (var3.method_230() && !var1.method_220()) {
                var2 |= 2097152;
            }
        } else if (var1.method_158()) {
            if (var1.method_153()) {
                this.problemReporter().method_1573(this.referenceContext);
                var1.modifiers = 0;
                return;
            }
            if (var1.method_146()) {
                var2 |= 16;
                if (this.referenceContext.allocation.type == null) {
                    var2 |= 16384;
                }
            }
            Object var5 = this;
            do {
                switch (((Scope)var5).kind) {
                    case 2:
                        MethodScope var6 = (MethodScope)var5;
                        if (var6.method_727()) {
                            SourceTypeBinding var7 = ((TypeDeclaration)var6.referenceContext).binding;
                            if (var6.initializedField != null) {
                                if (var6.initializedField.method_434() && !var1.method_220()) {
                                    var2 |= 2097152;
                                }
                            } else {
                                if (var7.method_227()) {
                                    var2 |= 2048;
                                }
                                if (var7.method_230() && !var1.method_220()) {
                                    var2 |= 2097152;
                                }
                            }
                        } else {
                            MethodBinding var17 = ((AbstractMethodDeclaration)var6.referenceContext).binding;
                            if (var17 != null) {
                                if (var17.method_371()) {
                                    var2 |= 2048;
                                }
                                if (var17.method_375() && !var1.method_220()) {
                                    var2 |= 2097152;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (var3.method_227()) {
                            var2 |= 2048;
                        }
                        if (var3.method_230() && !var1.method_220()) {
                            var2 |= 2097152;
                        }
                }
                var5 = ((Scope)var5).parent;
            } while (var5 != null);
        }
        int var15 = var2 & '\uffff';
        if ((var15 & 512) != 0) {
            if (var4) {
                if ((var15 & -11792) != 0) {
                    if ((var15 & 8192) != 0) {
                        this.problemReporter().method_1578(var1);
                    } else {
                        this.problemReporter().method_1592(var1);
                    }
                }
            } else if ((var15 & -11778) != 0) {
                if ((var15 & 8192) != 0) {
                    this.problemReporter().method_1579(var1);
                } else {
                    this.problemReporter().method_1585(var1);
                }
            }
            if (var1.sourceName == TypeConstants.field_144 && this.compilerOptions().field_1929 > 3211264L) {
                var2 |= 4096;
            }
            var2 |= 1024;
        } else if ((var15 & 16384) != 0) {
            if (var4) {
                if ((var15 & -18448) != 0) {
                    this.problemReporter().method_1591(var1);
                    var2 &= -1025;
                    var15 &= -1025;
                }
            } else if (var1.method_158()) {
                if ((var15 & -18449) != 0) {
                    this.problemReporter().method_1589(var1);
                }
            } else if ((var15 & -18434) != 0) {
                this.problemReporter().method_1581(var1);
            }
            if (!var1.method_146()) {
                label268: {
                    int var8;
                    TypeDeclaration var16;
                    FieldDeclaration[] var19;
                    if ((this.referenceContext.field_446 & 2048) != 0) {
                        var2 |= 1024;
                    } else {
                        var16 = this.referenceContext;
                        var19 = var16.fields;
                        var8 = var19 == null ? 0 : var19.length;
                        if (var8 != 0) {
                            AbstractMethodDeclaration[] var9 = var16.methods;
                            int var10 = var9 == null ? 0 : var9.length;
                            boolean var11 = var16.superInterfaces != null;
                            for (int var12 = 0; var12 < var10 && !var11; ++var12) {
                                var11 = var9[var12].method_792();
                            }
                            if (var11) {
                                boolean var22 = false;
                                int var13 = 0;
                                while (true) {
                                    if (var13 >= var8) {
                                        if (var22) {
                                            var2 |= 1024;
                                        }
                                        break;
                                    }
                                    FieldDeclaration var14 = var19[var13];
                                    if (var14.getKind() == 3) {
                                        if (!(var14.initialization instanceof QualifiedAllocationExpression)) {
                                            break;
                                        }
                                        var22 = true;
                                    }
                                    ++var13;
                                }
                            }
                        }
                    }
                    var16 = this.referenceContext;
                    var19 = var16.fields;
                    if (var19 != null) {
                        var8 = 0;
                        for (int var20 = var19.length; var8 < var20; ++var8) {
                            FieldDeclaration var21 = var19[var8];
                            if (var21.getKind() == 3 && var21.initialization instanceof QualifiedAllocationExpression) {
                                break label268;
                            }
                        }
                    }
                    var2 |= 16;
                }
            }
        } else {
            if (var4) {
                if ((var15 & -3104) != 0) {
                    this.problemReporter().method_1590(var1);
                }
            } else if (var1.method_158()) {
                if ((var15 & -3089) != 0) {
                    this.problemReporter().method_1588(var1);
                }
            } else if ((var15 & -3090) != 0) {
                this.problemReporter().method_1580(var1);
            }
            if ((var15 & 1040) == 1040) {
                this.problemReporter().method_1574(var1);
            }
        }
        if (var4) {
            if (var3.method_157()) {
                if ((var15 & 6) != 0) {
                    this.problemReporter().method_1604(var1);
                    if ((var15 & 4) != 0) {
                        var2 &= -5;
                    }
                    if ((var15 & 2) != 0) {
                        var2 &= -3;
                    }
                }
            } else {
                int var18 = var15 & 7;
                if ((var18 & var18 - 1) > 1) {
                    this.problemReporter().method_1602(var1);
                    if ((var18 & 1) != 0) {
                        if ((var18 & 4) != 0) {
                            var2 &= -5;
                        }
                        if ((var18 & 2) != 0) {
                            var2 &= -3;
                        }
                    } else if ((var18 & 4) != 0 && (var18 & 2) != 0) {
                        var2 &= -3;
                    }
                }
            }
            if ((var15 & 8) == 0) {
                if (var3.method_157()) {
                    var2 |= 8;
                }
            } else if (!var3.method_226()) {
                this.problemReporter().method_1597(var1);
            }
        }
        var1.modifiers = var2;
    }

    private void checkAndSetModifiersForField(FieldBinding var1, FieldDeclaration var2) {
        int var3 = var1.field_300;
        ReferenceBinding var4 = var1.declaringClass;
        if ((var3 & 4194304) != 0) {
            this.problemReporter().method_1530(var4, var2);
        }
        if (var4.method_157()) {
            var3 |= 25;
            if ((var3 & '\uffff') != 25) {
                if ((var4.modifiers & 8192) != 0) {
                    this.problemReporter().method_1576(var2);
                } else {
                    this.problemReporter().method_1586(var2);
                }
            }
            var1.field_300 = var3;
        } else if (var2.getKind() == 3) {
            if ((var3 & '\uffff') != 0) {
                this.problemReporter().method_1582(var4, var2);
            }
            var1.field_300 |= 16409;
        } else {
            int var5 = var3 & '\uffff';
            if ((var5 & -224) != 0) {
                this.problemReporter().method_1584(var4, var2);
                var3 &= -65313;
            }
            int var7 = var5 & 7;
            if ((var7 & var7 - 1) > 1) {
                this.problemReporter().method_1601(var4, var2);
                if ((var7 & 1) != 0) {
                    if ((var7 & 4) != 0) {
                        var3 &= -5;
                    }
                    if ((var7 & 2) != 0) {
                        var3 &= -3;
                    }
                } else if ((var7 & 4) != 0 && (var7 & 2) != 0) {
                    var3 &= -3;
                }
            }
            if ((var5 & 80) == 80) {
                this.problemReporter().method_1575(var4, var2);
            }
            if (var2.initialization == null && (var3 & 16) != 0) {
                var3 |= 67108864;
            }
            var1.field_300 = var3;
        }
    }

    public void method_659() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        ReferenceBinding[] var2 = var1.field_253;
        HashMap var10000 = new HashMap(2);
        HashMap var3 = var10000;
        ReferenceBinding var4 = var1.method_157() ? null : var1.superclass;
        int var5 = 0;
        int var6;
        int var8;
        for (var6 = var2.length; var5 < var6; ++var5) {
            ReferenceBinding var7 = var2[var5];
            if (var7 != null && (var4 == null || !this.method_621(var4, var7, var3, var1, this.referenceContext))) {
                for (var8 = 0; var8 < var5; ++var8) {
                    ReferenceBinding var9 = var2[var8];
                    if (var9 != null && this.method_621(var7, var9, var3, var1, this.referenceContext)) {
                        break;
                    }
                }
            }
        }
        TypeParameter[] var17 = this.referenceContext.typeParameters;
        var6 = 0;
        int var18;
        label91:
        for (var18 = var17 == null ? 0 : var17.length; var6 < var18; ++var6) {
            TypeParameter var20 = var17[var6];
            TypeVariableBinding var21 = var20.binding;
            if (var21 != null && var21.isValidBinding()) {
                TypeReference[] var10 = var20.bounds;
                if (var10 != null) {
                    boolean var11 = var21.firstBound == var21.superclass;
                    int var12 = 0;
                    for (int var13 = var10.length; var12 < var13; ++var12) {
                        TypeReference var14 = var10[var12];
                        TypeBinding var15 = var14.resolvedType;
                        if (var15 != null && var15.isValidBinding()) {
                            if (var11 && this.method_621(var15, var21.superclass, var3, var21, var14)) {
                                break;
                            }
                            int var16 = var21.superInterfaces.length;
                            while (true) {
                                --var16;
                                if (var16 < 0) {
                                    break;
                                }
                                if (this.method_621(var15, var21.superInterfaces[var16], var3, var21, var14)) {
                                    continue label91;
                                }
                            }
                        }
                    }
                }
            }
        }
        ReferenceBinding[] var19 = this.referenceContext.binding.field_256;
        if (var19 != null && var19 != Binding.field_156) {
            var18 = 0;
            for (var8 = var19.length; var18 < var8; ++var18) {
                ((SourceTypeBinding)var19[var18]).scope.method_659();
            }
        }
    }

    private void checkForInheritedMemberTypes(SourceTypeBinding var1) {
        Object var2 = var1;
        ReferenceBinding[] var3 = null;
        int var4 = 0;
        int var6;
        int var9;
        do {
            if (((ReferenceBinding)var2).method_213()) {
                return;
            }
            ReferenceBinding[] var5 = ((ReferenceBinding)var2).superInterfaces();
            if (var5 != null && var5 != Binding.field_155) {
                if (var3 == null) {
                    var3 = var5;
                    var4 = var5.length;
                } else {
                    var6 = var5.length;
                    if (var4 + var6 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var6 + 5], 0, var4);
                    }
                    label108:
                    for (int var7 = 0; var7 < var6; ++var7) {
                        ReferenceBinding var8 = var5[var7];
                        for (var9 = 0; var9 < var4; ++var9) {
                            if (var8 == var3[var9]) {
                                continue label108;
                            }
                        }
                        var3[var4++] = var8;
                    }
                }
            }
        } while ((var2 = ((ReferenceBinding)var2).superclass()) != null && (((ReferenceBinding)var2).tagBits & 65536L) == 0L);
        if (var3 != null) {
            boolean var13 = false;
            for (var6 = 0; var6 < var4; ++var6) {
                ReferenceBinding var14 = var3[var6];
                if ((var14.tagBits & 65536L) == 0L) {
                    if (var14.method_213()) {
                        return;
                    }
                    var13 = true;
                    ReferenceBinding[] var15 = var14.superInterfaces();
                    if (var15 != null && var15 != Binding.field_155) {
                        var9 = var15.length;
                        if (var4 + var9 >= var3.length) {
                            System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var9 + 5], 0, var4);
                        }
                        label84:
                        for (int var10 = 0; var10 < var9; ++var10) {
                            ReferenceBinding var11 = var15[var10];
                            for (int var12 = 0; var12 < var4; ++var12) {
                                if (var11 == var3[var12]) {
                                    continue label84;
                                }
                            }
                            var3[var4++] = var11;
                        }
                    }
                }
            }
            if (var13) {
                for (var6 = 0; var6 < var4; ++var6) {
                    var3[var6].tagBits |= 65536L;
                }
            }
        }
        var2 = var1;
        do {
            ((ReferenceBinding)var2).tagBits |= 65536L;
        } while ((var2 = ((ReferenceBinding)var2).superclass()) != null && (((ReferenceBinding)var2).tagBits & 65536L) == 0L);
    }

    public void method_661() {
        TypeReference var1 = this.referenceContext.superclass;
        if (var1 != null) {
            var1.checkBounds(this);
        }
        TypeReference[] var2 = this.referenceContext.superInterfaces;
        int var4;
        if (var2 != null) {
            int var3 = 0;
            for (var4 = var2.length; var3 < var4; ++var3) {
                var2[var3].checkBounds(this);
            }
        }
        TypeParameter[] var7 = this.referenceContext.typeParameters;
        int var5;
        if (var7 != null) {
            var4 = 0;
            for (var5 = var7.length; var4 < var5; ++var4) {
                var7[var4].checkBounds(this);
            }
        }
        ReferenceBinding[] var8 = this.referenceContext.binding.field_256;
        if (var8 != null && var8 != Binding.field_156) {
            var5 = 0;
            for (int var6 = var8.length; var5 < var6; ++var5) {
                ((SourceTypeBinding)var8[var5]).scope.method_661();
            }
        }
    }

    private void method_662() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        ReferenceBinding[] var2 = var1.field_256;
        if (var2 != null && var2 != Binding.field_156) {
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                ((SourceTypeBinding)var2[var3]).scope.connectTypeHierarchy();
            }
        }
    }

    private boolean method_663() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        if (var1.id == 1) {
            var1.superclass = null;
            var1.field_253 = Binding.field_155;
            if (!var1.method_151()) {
                this.problemReporter().method_1713(var1);
            }
            if (this.referenceContext.superclass != null || this.referenceContext.superInterfaces != null && this.referenceContext.superInterfaces.length > 0) {
                this.problemReporter().method_1712(var1);
            }
            return true;
        } else if (this.referenceContext.superclass == null) {
            if (var1.method_153() && this.compilerOptions().field_1928 >= 3211264L) {
                return this.method_664();
            } else {
                var1.superclass = this.method_609();
                return !this.detectHierarchyCycle(var1, var1.superclass, (TypeReference)null);
            }
        } else {
            TypeReference var2 = this.referenceContext.superclass;
            ReferenceBinding var3 = this.method_670(var2);
            if (var3 != null) {
                if (!var3.method_151() && (var3.tagBits & 128L) == 0L) {
                    this.problemReporter().method_1761(var1, var2, var3);
                } else if (var3.method_221()) {
                    this.problemReporter().method_1508(var1, var2, var3);
                } else if ((var3.tagBits & 1073741824L) != 0L) {
                    this.problemReporter().method_1765(var1, var2, var3);
                } else {
                    if (var3.erasure().id != 41) {
                        if ((var3.tagBits & 131072L) == 0L && var2.resolvedType.isValidBinding()) {
                            var1.superclass = var3;
                            return true;
                        }
                        var1.superclass = var3;
                        var1.tagBits |= 131072L;
                        return var2.resolvedType.isValidBinding();
                    }
                    this.problemReporter().method_1496(var1, var2, var3);
                }
            }
            var1.tagBits |= 131072L;
            var1.superclass = this.method_609();
            if ((var1.superclass.tagBits & 256L) == 0L) {
                this.detectHierarchyCycle(var1, var1.superclass, (TypeReference)null);
            }
            return false;
        }
    }

    private boolean method_664() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        ReferenceBinding var2 = this.method_608();
        boolean var3 = this.detectHierarchyCycle(var1, var2, (TypeReference)null);
        TypeVariableBinding[] var4 = var2.typeVariables();
        if (var4 == Binding.NO_TYPE_VARIABLES) {
            this.problemReporter().nonGenericTypeCannotBeParameterized(0, (ASTNode)null, var2, new TypeBinding[] {var1});
            return false;
        } else if (1 != var4.length) {
            this.problemReporter().incorrectArityForParameterizedType((ASTNode)null, var2, new TypeBinding[] {var1});
            return false;
        } else {
            ParameterizedTypeBinding var5 = this.environment().createParameterizedType(var2, new TypeBinding[] {this.environment().convertToRawType(var1, false)}, (ReferenceBinding)null);
            var1.tagBits |= var5.tagBits & 131072L;
            var1.superclass = var5;
            if (var4[0].boundCheck(var5, var1) != 0) {
                this.problemReporter().typeMismatchError(var2, var4[0], var1, (ASTNode)null);
            }
            return !var3;
        }
    }

    private boolean method_665() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        var1.field_253 = Binding.field_155;
        if (this.referenceContext.superInterfaces == null) {
            if (var1.method_145() && this.compilerOptions().field_1928 >= 3211264L) {
                ReferenceBinding var11 = this.method_604();
                boolean var10 = this.detectHierarchyCycle(var1, var11, (TypeReference)null);
                var1.field_253 = new ReferenceBinding[] {var11};
                return !var10;
            } else {
                return true;
            }
        } else if (var1.id == 1) {
            return true;
        } else {
            boolean var2 = true;
            int var3 = this.referenceContext.superInterfaces.length;
            ReferenceBinding[] var4 = new ReferenceBinding[var3];
            int var5 = 0;
            label77:
            for (int var6 = 0; var6 < var3; ++var6) {
                TypeReference var7 = this.referenceContext.superInterfaces[var6];
                ReferenceBinding var8 = this.method_670(var7);
                if (var8 == null) {
                    var1.tagBits |= 131072L;
                    var2 = false;
                } else {
                    for (int var9 = 0; var9 < var6; ++var9) {
                        if (var4[var9] == var8) {
                            this.problemReporter().method_1535(var1, var7, var8);
                            var1.tagBits |= 131072L;
                            var2 = false;
                            continue label77;
                        }
                    }
                    if (!var8.method_157() && (var8.tagBits & 128L) == 0L) {
                        this.problemReporter().method_1763(var1, var7, var8);
                        var1.tagBits |= 131072L;
                        var2 = false;
                    } else {
                        if (var8.method_145()) {
                            this.problemReporter().method_1473(var1, var7, var8);
                        }
                        if ((var8.tagBits & 1073741824L) != 0L) {
                            this.problemReporter().method_1765(var1, var7, var8);
                            var1.tagBits |= 131072L;
                            var2 = false;
                        } else {
                            if ((var8.tagBits & 131072L) != 0L || !var7.resolvedType.isValidBinding()) {
                                var1.tagBits |= 131072L;
                                var2 &= var7.resolvedType.isValidBinding();
                            }
                            var4[var5++] = var8;
                        }
                    }
                }
            }
            if (var5 > 0) {
                if (var5 != var3) {
                    System.arraycopy(var4, 0, var4 = new ReferenceBinding[var5], 0, var5);
                }
                var1.field_253 = var4;
            }
            return var2;
        }
    }

    void connectTypeHierarchy() {
        SourceTypeBinding var1 = this.referenceContext.binding;
        if ((var1.tagBits & 256L) == 0L) {
            var1.tagBits |= 256L;
            boolean var2 = this.method_663();
            var2 &= this.method_665();
            var1.tagBits |= 512L;
            var2 &= this.connectTypeVariables(this.referenceContext.typeParameters, false);
            var1.tagBits |= 262144L;
            if (var2 && var1.method_156()) {
                this.problemReporter().method_1565(var1);
            }
        }
        this.method_662();
        LookupEnvironment var9 = this.environment();
        try {
            var9.missingClassFileLocation = this.referenceContext;
            this.checkForInheritedMemberTypes(var1);
        } catch (AbortCompilation var7) {
            var7.updateContext(this.referenceContext, this.referenceCompilationUnit().compilationResult);
            throw var7;
        } finally {
            var9.missingClassFileLocation = null;
        }
    }

    private void method_667() {
        if (this.parent instanceof CompilationUnitScope) {
            if (((CompilationUnitScope)this.parent).imports == null) {
                ((CompilationUnitScope)this.parent).method_675();
            }
        } else if (this.parent instanceof ClassScope) {
            ((ClassScope)this.parent).method_667();
        }
        SourceTypeBinding var1 = this.referenceContext.binding;
        if ((var1.tagBits & 256L) == 0L) {
            var1.tagBits |= 256L;
            boolean var2 = this.method_663();
            var2 &= this.method_665();
            var1.tagBits |= 512L;
            var2 &= this.connectTypeVariables(this.referenceContext.typeParameters, false);
            var1.tagBits |= 262144L;
            if (var2 && var1.method_156()) {
                this.problemReporter().method_1565(var1);
            }
        }
    }

    public boolean detectHierarchyCycle(TypeBinding var1, TypeReference var2) {
        if (!(var1 instanceof ReferenceBinding)) {
            return false;
        } else if (var2 == this.superTypeReference) {
            if (((TypeBinding)var1).method_169()) {
                return false;
            } else {
                if (((TypeBinding)var1).method_162()) {
                    var1 = ((ParameterizedTypeBinding)var1).method_286();
                }
                this.compilationUnitScope().method_691((TypeBinding)var1);
                return this.detectHierarchyCycle(this.referenceContext.binding, (ReferenceBinding)var1, var2);
            }
        } else {
            return false;
        }
    }

    private boolean detectHierarchyCycle(SourceTypeBinding var1, ReferenceBinding var2, TypeReference var3) {
        if (var2.method_166()) {
            var2 = ((RawTypeBinding)var2).method_286();
        }
        if (var1 == var2) {
            this.problemReporter().hierarchyCircularity(var1, var2, var3);
            var1.tagBits |= 131072L;
            return true;
        } else {
            if (var2.method_159()) {
                ReferenceBinding var4 = var2.enclosingType();
                do {
                    if (var4.method_222() && var4 == var1) {
                        this.problemReporter().hierarchyCircularity(var1, var4, var3);
                        var1.tagBits |= 131072L;
                        var4.tagBits |= 131072L;
                        return true;
                    }
                } while ((var4 = var4.enclosingType()) != null);
            }
            if (var2.method_218()) {
                boolean var11 = false;
                ReferenceBinding var5 = var2.superclass();
                if (var5 != null) {
                    if (var1 == var5) {
                        this.problemReporter().hierarchyCircularity(var1, var2, var3);
                        var1.tagBits |= 131072L;
                        var2.tagBits |= 131072L;
                        return true;
                    }
                    if (var5.method_162()) {
                        var5 = ((ParameterizedTypeBinding)var5).method_286();
                    }
                    var11 |= this.detectHierarchyCycle(var1, var5, var3);
                    if ((var5.tagBits & 131072L) != 0L) {
                        var1.tagBits |= 131072L;
                        var5.tagBits |= 131072L;
                    }
                }
                ReferenceBinding[] var6 = var2.superInterfaces();
                if (var6 != null && var6 != Binding.field_155) {
                    int var7 = 0;
                    for (int var8 = var6.length; var7 < var8; ++var7) {
                        ReferenceBinding var9 = var6[var7];
                        if (var1 == var9) {
                            this.problemReporter().hierarchyCircularity(var1, var2, var3);
                            var1.tagBits |= 131072L;
                            var2.tagBits |= 131072L;
                            return true;
                        }
                        if (var9.method_162()) {
                            var9 = ((ParameterizedTypeBinding)var9).method_286();
                        }
                        var11 |= this.detectHierarchyCycle(var1, var9, var3);
                        if ((var9.tagBits & 131072L) != 0L) {
                            var1.tagBits |= 131072L;
                            var2.tagBits |= 131072L;
                        }
                    }
                }
                return var11;
            } else {
                if (var2.method_222()) {
                    TypeReference var10 = ((SourceTypeBinding)var2).scope.superTypeReference;
                    if (var10 != null && (var10.resolvedType == null || ((ReferenceBinding)var10.resolvedType).method_222())) {
                        this.problemReporter().hierarchyCircularity(var1, var2, var3);
                        var1.tagBits |= 131072L;
                        var2.tagBits |= 131072L;
                        return true;
                    }
                }
                if ((var2.tagBits & 256L) == 0L) {
                    ((SourceTypeBinding)var2).scope.method_667();
                }
                if ((var2.tagBits & 131072L) != 0L) {
                    var1.tagBits |= 131072L;
                }
                return false;
            }
        }
    }

    private ReferenceBinding method_670(TypeReference var1) {
        CompilationUnitScope var2 = this.compilationUnitScope();
        LookupEnvironment var3 = var2.environment;
        ReferenceBinding var11;
        try {
            var3.missingClassFileLocation = var1;
            var1.method_1006(this);
            var2.recordQualifiedReference(var1.getTypeName());
            this.superTypeReference = var1;
            ReferenceBinding var4 = (ReferenceBinding)var1.method_1016(this);
            var11 = var4;
        } catch (AbortCompilation var9) {
            SourceTypeBinding var5 = this.referenceContext.binding;
            if (var5.field_253 == null) {
                var5.field_253 = Binding.field_155;
            }
            var9.updateContext(var1, this.referenceCompilationUnit().compilationResult);
            throw var9;
        } finally {
            var3.missingClassFileLocation = null;
            this.superTypeReference = null;
        }
        return var11;
    }

    public ProblemReporter problemReporter() {
        MethodScope var1;
        if ((var1 = this.method_641()) == null) {
            ProblemReporter var2 = this.referenceCompilationUnit().problemReporter;
            var2.referenceContext = this.referenceContext;
            return var2;
        } else {
            return var1.problemReporter();
        }
    }

    public TypeDeclaration referenceType() {
        return this.referenceContext;
    }

    public String toString() {
        return this.referenceContext != null ? "--- Class Scope ---\n\n" + this.referenceContext.binding.toString() : "--- Class Scope ---\n\n Binding not initialized";
    }
}
