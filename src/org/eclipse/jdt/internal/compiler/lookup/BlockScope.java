package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemBinding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

public class BlockScope extends Scope {

    public LocalVariableBinding[] locals;

    public int field_392;

    public int field_393;

    public int field_394;

    public int field_395;

    public BlockScope[] shiftScopes;

    public Scope[] subscopes;

    public int field_398;

    public CaseStatement enclosingCase;

    public static final VariableBinding[] field_400;

    public static final VariableBinding[] field_401;

    public static final VariableBinding[] field_402;

    public BlockScope(BlockScope var1) {
        this(var1, true);
    }

    public BlockScope(BlockScope var1, boolean var2) {
        this(1, var1);
        this.locals = new LocalVariableBinding[5];
        if (var2) {
            var1.addSubscope(this);
        }
        this.field_393 = var1.field_392;
    }

    public BlockScope(BlockScope var1, int var2) {
        this(1, var1);
        this.locals = new LocalVariableBinding[var2];
        var1.addSubscope(this);
        this.field_393 = var1.field_392;
    }

    protected BlockScope(int var1, Scope var2) {
        super(var1, var2);
        this.subscopes = new Scope[1];
        this.field_398 = 0;
    }

    public final void addAnonymousType(TypeDeclaration var1, ReferenceBinding var2) {
        ClassScope var10000 = new ClassScope(this, var1);
        ClassScope var3 = var10000;
        var3.buildAnonymousTypeBinding(this.enclosingSourceType(), var2);
    }

    public final void addLocalType(TypeDeclaration var1) {
        ClassScope var10000 = new ClassScope(this, var1);
        ClassScope var2 = var10000;
        this.addSubscope(var2);
        var2.buildLocalTypeBinding(this.enclosingSourceType());
    }

    public final void addLocalVariable(LocalVariableBinding var1) {
        this.checkAndSetModifiersForVariable(var1);
        if (this.field_392 == this.locals.length) {
            System.arraycopy(this.locals, 0, this.locals = new LocalVariableBinding[this.field_392 * 2], 0, this.field_392);
        }
        this.locals[this.field_392++] = var1;
        var1.declaringScope = this;
        MethodScope var10001 = this.method_641();
        int var10003 = var10001.field_408;
        MethodScope var10002 = var10001;
        int var2 = var10001.field_408;
        var10002.field_408 = var10003 + 1;
        var1.field_304 = var2;
    }

    public void addSubscope(Scope var1) {
        if (this.field_398 == this.subscopes.length) {
            System.arraycopy(this.subscopes, 0, this.subscopes = new Scope[this.field_398 * 2], 0, this.field_398);
        }
        this.subscopes[this.field_398++] = var1;
    }

    public final boolean method_706(FieldBinding var1) {
        if (this.method_584() != var1.declaringClass) {
            return false;
        } else {
            MethodScope var2 = this.method_635();
            return var2.field_404 != var1.method_431() ? false : var2.method_727() || ((AbstractMethodDeclaration)var2.referenceContext).method_797();
        }
    }

    String basicToString(int var1) {
        String var2 = "\n";
        int var3 = var1;
        while (true) {
            --var3;
            if (var3 < 0) {
                String var5 = var2 + "--- Block Scope ---";
                var2 = var2 + "\t";
                var5 = var5 + var2 + "locals:";
                for (int var4 = 0; var4 < this.field_392; ++var4) {
                    var5 = var5 + var2 + "\t" + this.locals[var4].toString();
                }
                var5 = var5 + var2 + "startIndex = " + this.field_393;
                return var5;
            }
            var2 = var2 + "\t";
        }
    }

    private void checkAndSetModifiersForVariable(LocalVariableBinding var1) {
        int var2 = var1.field_300;
        if ((var2 & 4194304) != 0 && var1.declaration != null) {
            this.problemReporter().method_1533(var1.declaration, this instanceof MethodScope);
        }
        int var3 = var2 & '\uffff';
        byte var4 = -17;
        if ((var3 & var4) != 0 && var1.declaration != null) {
            this.problemReporter().method_1594(var1.declaration, this instanceof MethodScope);
        }
        var1.field_300 = var2;
    }

    void computeLocalVariablePositions(int var1, int var2, CodeStream var3) {
        this.field_394 = var2;
        this.field_395 = var2;
        int var4 = this.field_392;
        boolean var5 = var1 < var4;
        int var6 = 0;
        int var7 = this.field_398;
        boolean var8 = var7 > 0;
        while (var5 || var8) {
            if (var8 && (!var5 || this.subscopes[var6].startIndex() <= var1)) {
                if (this.subscopes[var6] instanceof BlockScope) {
                    BlockScope var11 = (BlockScope)this.subscopes[var6];
                    int var12 = var11.shiftScopes == null ? this.field_394 : var11.method_715();
                    var11.computeLocalVariablePositions(0, var12, var3);
                    if (var11.field_395 > this.field_395) {
                        this.field_395 = var11.field_395;
                    }
                }
                ++var6;
                var8 = var6 < var7;
            } else {
                LocalVariableBinding var9 = this.locals[var1];
                boolean var10 = var9.field_307 == 1 && var9.constant() == Constant.NotAConstant;
                if (var9.field_307 == 0 && var9.declaration != null && (var9.declaration.field_446 & 1073741824) != 0 && !(var9.declaration instanceof Argument)) {
                    this.problemReporter().method_1811(var9.declaration);
                }
                if (!var10 && var9.declaration != null && this.compilerOptions().field_1933) {
                    var10 = true;
                    var9.field_307 = 1;
                }
                if (var10) {
                    if (var9.declaration != null) {
                        var3.method_2358(var9);
                    }
                    var9.field_306 = this.field_394;
                    if (var9.type != TypeBinding.field_183 && var9.type != TypeBinding.field_185) {
                        ++this.field_394;
                    } else {
                        this.field_394 += 2;
                    }
                    if (this.field_394 > '\uffff') {
                        this.problemReporter().method_1699(var9, (ASTNode)(var9.declaration == null ? (ASTNode)this.method_635().referenceContext : var9.declaration));
                    }
                } else {
                    var9.field_306 = -1;
                }
                ++var1;
                var5 = var1 < var4;
            }
        }
        if (this.field_394 > this.field_395) {
            this.field_395 = this.field_394;
        }
    }

    public void emulateOuterAccess(LocalVariableBinding var1) {
        BlockScope var2 = var1.declaringScope;
        if (var2 != null) {
            MethodScope var3 = this.method_635();
            if (var2.method_635() != var3) {
                NestedTypeBinding var4 = (NestedTypeBinding)this.enclosingSourceType();
                if (!var4.method_158()) {
                    return;
                }
                if (!var3.method_728()) {
                    var4.method_325(var1);
                } else {
                    var4.method_323(var1);
                }
            }
        }
    }

    public final ReferenceBinding findLocalType(char[] var1) {
        long var2 = this.compilerOptions().field_1927;
        for (int var4 = this.field_398 - 1; var4 >= 0; --var4) {
            if (this.subscopes[var4] instanceof ClassScope) {
                LocalTypeBinding var5 = (LocalTypeBinding)((ClassScope)this.subscopes[var4]).referenceContext.binding;
                if ((var2 < 3145728L || var5.enclosingCase == null || this.isInsideCase(var5.enclosingCase)) && CharOperation.method_1364(var5.method_179(), var1)) {
                    return var5;
                }
            }
        }
        return null;
    }

    public LocalVariableBinding findVariable(char[] var1) {
        int var2 = var1.length;
        for (int var3 = this.field_392 - 1; var3 >= 0; --var3) {
            LocalVariableBinding var4;
            char[] var5;
            if ((var5 = (var4 = this.locals[var3]).name).length == var2 && CharOperation.method_1364(var5, var1)) {
                return var4;
            }
        }
        return null;
    }

    public Binding getBinding(char[][] var1, int var2, InvocationSite var3, boolean var4) {
        Binding var5 = this.getBinding(var1[0], var2 | 4 | 16, var3, var4);
        var3.setFieldIndex(1);
        if (var5 instanceof VariableBinding) {
            return var5;
        } else {
            CompilationUnitScope var6 = this.compilationUnitScope();
            var6.recordQualifiedReference(var1);
            if (!var5.isValidBinding()) {
                return var5;
            } else {
                int var7 = var1.length;
                int var8 = 1;
                ProblemReferenceBinding var10000;
                ProblemBinding var13;
                if (var5 instanceof PackageBinding) {
                    PackageBinding var9 = (PackageBinding)var5;
                    while (true) {
                        if (var8 >= var7) {
                            var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var8), (ReferenceBinding)null, 1);
                            return var10000;
                        }
                        var6.recordReference(var9.compoundName, var1[var8]);
                        var5 = var9.getTypeOrPackage(var1[var8++]);
                        var3.setFieldIndex(var8);
                        if (var5 == null) {
                            if (var8 == var7) {
                                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var8), (ReferenceBinding)null, 1);
                                return var10000;
                            }
                            var13 = new ProblemBinding(CharOperation.subarray(var1, 0, var8), 1);
                            return var13;
                        }
                        if (var5 instanceof ReferenceBinding) {
                            if (!var5.isValidBinding()) {
                                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var8), (ReferenceBinding)((ReferenceBinding)var5).closestMatch(), var5.problemId());
                                return var10000;
                            }
                            if (!((ReferenceBinding)var5).canBeSeenBy(this)) {
                                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var8), (ReferenceBinding)var5, 2);
                                return var10000;
                            }
                            break;
                        }
                        var9 = (PackageBinding)var5;
                    }
                }
                ReferenceBinding var15 = (ReferenceBinding)var5;
                Object var14 = this.environment().convertToRawType(var15, false);
                if (var3 instanceof ASTNode) {
                    ASTNode var10 = (ASTNode)var3;
                    if (var10.isTypeUseDeprecated(var15, this)) {
                        this.problemReporter().method_1516(var15, var10);
                    }
                }
                ProblemFieldBinding var12;
                while (var8 < var7) {
                    var15 = (ReferenceBinding)var14;
                    char[] var16 = var1[var8++];
                    var3.setFieldIndex(var8);
                    var3.setActualReceiverType(var15);
                    if ((var2 & 1) != 0 && (var14 = this.findField(var15, var16, var3, true)) != null) {
                        if (!((Binding)var14).isValidBinding()) {
                            var12 = new ProblemFieldBinding(((ProblemFieldBinding)var14).closestMatch, ((ProblemFieldBinding)var14).declaringClass, CharOperation.concatWith(CharOperation.subarray(var1, 0, var8), '.'), ((Binding)var14).problemId());
                            return var12;
                        }
                        break;
                    }
                    if ((var14 = this.method_591(var16, var15)) == null) {
                        if ((var2 & 1) != 0) {
                            var13 = new ProblemBinding(CharOperation.subarray(var1, 0, var8), var15, 1);
                            return var13;
                        }
                        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var8), var15, 1);
                        return var10000;
                    }
                    if (!((Binding)var14).isValidBinding()) {
                        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var8), (ReferenceBinding)((ReferenceBinding)var14).closestMatch(), ((Binding)var14).problemId());
                        return var10000;
                    }
                    if (var3 instanceof ASTNode) {
                        var15 = (ReferenceBinding)var14;
                        ASTNode var11 = (ASTNode)var3;
                        if (var11.isTypeUseDeprecated(var15, this)) {
                            this.problemReporter().method_1516(var15, var11);
                        }
                    }
                }
                if ((var2 & 1) != 0 && var14 instanceof FieldBinding) {
                    FieldBinding var17 = (FieldBinding)var14;
                    if (!var17.method_431()) {
                        var12 = new ProblemFieldBinding(var17, var17.declaringClass, CharOperation.concatWith(CharOperation.subarray(var1, 0, var8), '.'), 7);
                        return var12;
                    } else {
                        return (Binding)var14;
                    }
                } else if ((var2 & 4) != 0 && var14 instanceof ReferenceBinding) {
                    return (Binding)var14;
                } else {
                    var13 = new ProblemBinding(CharOperation.subarray(var1, 0, var8), 1);
                    return var13;
                }
            }
        }
    }

    public VariableBinding[] getEmulationPath(LocalVariableBinding var1) {
        MethodScope var2 = this.method_635();
        SourceTypeBinding var3 = var2.enclosingSourceType();
        BlockScope var4 = var1.declaringScope;
        SyntheticArgumentBinding var5;
        FieldBinding var6;
        return var4 != null && var2 != var4.method_635() ? (var2.method_728() && var3.method_160() && (var5 = ((NestedTypeBinding)var3).method_328(var1)) != null ? new VariableBinding[] {var5}: (!var2.field_404 && (var6 = var3.method_309(var1)) != null ? new VariableBinding[] {var6}: null)): new VariableBinding[] {var1};
    }

    public Object[] getEmulationPath(ReferenceBinding var1, boolean var2, boolean var3) {
        MethodScope var4 = this.method_635();
        SourceTypeBinding var5 = var4.enclosingSourceType();
        if (!var4.field_404 && !var4.field_405 && (var5 == var1 || !var2 && var5.method_140(var1) != null)) {
            return field_400;
        } else if (var5.method_160() && !var5.method_226()) {
            boolean var6 = var4.method_728();
            SyntheticArgumentBinding var7;
            if (var6 && (var7 = ((NestedTypeBinding)var5).getSyntheticArgument(var1, var2)) != null) {
                return (Object[])(var3 && var4.field_405 && (var5 == var1 || !var2 && var5.method_140(var1) != null) ? field_401 : new Object[] {var7});
            } else if (var4.field_404) {
                return field_402;
            } else {
                if (var5.method_146()) {
                    ReferenceBinding var12 = var5.enclosingType();
                    if (var12.method_160()) {
                        NestedTypeBinding var8 = (NestedTypeBinding)var12;
                        SyntheticArgumentBinding var9 = var8.getSyntheticArgument(var8.enclosingType(), var2);
                        if (var9 != null) {
                            FieldBinding var10 = var5.method_309(var9);
                            if (var10 != null && (var10.type == var1 || !var2 && ((ReferenceBinding)var10.type).method_140(var1) != null)) {
                                return new Object[] {var10};
                            }
                        }
                    }
                }
                FieldBinding var13 = var5.getSyntheticField(var1, var2);
                if (var13 != null) {
                    return (Object[])(var4.field_405 ? field_401 : new Object[] {var13});
                } else {
                    Object[] var14 = new Object[2];
                    ReferenceBinding var15 = var5.enclosingType();
                    if (var6) {
                        var14[0] = ((NestedTypeBinding)var5).getSyntheticArgument(var15, var2);
                    } else {
                        if (var4.field_405) {
                            return field_401;
                        }
                        var14[0] = var5.getSyntheticField(var15, var2);
                    }
                    if (var14[0] != null) {
                        ReferenceBinding var11;
                        for (int var16 = 1; (var11 = var15.enclosingType()) != null && var15 != var1 && (var2 || var15.method_140(var1) == null); var15 = var11) {
                            if (var4 != null) {
                                var4 = var4.method_583();
                                if (var4 != null && var4.field_405) {
                                    return field_401;
                                }
                                if (var4 != null && var4.field_404) {
                                    return field_402;
                                }
                            }
                            var13 = ((NestedTypeBinding)var15).getSyntheticField(var11, var2);
                            if (var13 == null) {
                                break;
                            }
                            if (var16 == var14.length) {
                                System.arraycopy(var14, 0, var14 = new Object[var16 + 1], 0, var16);
                            }
                            var14[var16++] = ((SourceTypeBinding)var13.declaringClass).method_298(var13, true);
                        }
                        if (var15 == var1 || !var2 && var15.method_140(var1) != null) {
                            return var14;
                        }
                    }
                    return null;
                }
            }
        } else {
            return var4.field_405 ? field_401 : (var4.field_404 ? field_402 : null);
        }
    }

    public int method_715() {
        int var1 = -1;
        if (this.shiftScopes != null) {
            int var2 = 0;
            for (int var3 = this.shiftScopes.length; var2 < var3; ++var2) {
                int var4 = this.shiftScopes[var2].field_395;
                if (var4 > var1) {
                    var1 = var4;
                }
            }
        }
        return var1;
    }

    public final boolean method_716(FieldBinding var1) {
        boolean var2 = var1.method_431();
        ReferenceBinding var3 = var1.declaringClass;
        for (MethodScope var4 = this.method_635(); var4 != null; var4 = var4.method_583()) {
            if (var4.field_404 != var2) {
                return false;
            }
            if (!var4.method_727() && !((AbstractMethodDeclaration)var4.referenceContext).method_797()) {
                return false;
            }
            if (var3 == var4.method_584()) {
                return true;
            }
        }
        return false;
    }

    public ProblemReporter problemReporter() {
        return this.method_641().problemReporter();
    }

    public void propagateInnerEmulation(ReferenceBinding var1, boolean var2) {
        SyntheticArgumentBinding[] var3;
        if ((var3 = var1.syntheticOuterLocalVariables()) != null) {
            int var4 = 0;
            for (int var5 = var3.length; var4 < var5; ++var4) {
                SyntheticArgumentBinding var6 = var3[var4];
                if (!var2 || var6.type != var1.enclosingType()) {
                    this.emulateOuterAccess(var6.actualOuterLocalVariable);
                }
            }
        }
    }

    public TypeDeclaration referenceType() {
        return this.method_635().referenceType();
    }

    int startIndex() {
        return this.field_393;
    }

    public String toString() {
        return this.toString(0);
    }

    public String toString(int var1) {
        String var2 = this.basicToString(var1);
        for (int var3 = 0; var3 < this.field_398; ++var3) {
            if (this.subscopes[var3] instanceof BlockScope) {
                var2 = var2 + ((BlockScope)this.subscopes[var3]).toString(var1 + 1) + "\n";
            }
        }
        return var2;
    }

    static {
        field_400 = new VariableBinding[0];
        field_401 = new VariableBinding[0];
        field_402 = new VariableBinding[0];
    }
}
