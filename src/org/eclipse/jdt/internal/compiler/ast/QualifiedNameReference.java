package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MissingTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

public class QualifiedNameReference extends NameReference {

    public char[][] tokens;

    public long[] sourcePositions;

    public FieldBinding[] field_756;

    public FieldBinding[] field_757;

    int[] otherDepths;

    public int indexOfFirstFieldBinding;

    public SyntheticMethodBinding syntheticWriteAccessor;

    public SyntheticMethodBinding[] syntheticReadAccessors;

    public TypeBinding genericCast;

    public TypeBinding[] otherGenericCasts;

    public QualifiedNameReference(char[][] var1, long[] var2, int var3, int var4) {
        this.tokens = var1;
        this.sourcePositions = var2;
        this.field_444 = var3;
        this.field_445 = var4;
    }

    public FlowInfo analyseAssignment(BlockScope var1, FlowContext var2, FlowInfo var3, Assignment var4, boolean var5) {
        int var6 = this.field_756 == null ? 0 : this.field_756.length;
        boolean var7 = var6 == 0 || !this.field_756[0].method_431();
        boolean var8 = var1.compilerOptions().field_1927 >= 3145728L;
        FieldBinding var9 = null;
        switch (this.field_446 & 7) {
            case 1:
                var9 = (FieldBinding)this.field_748;
                if (var7 || var8) {
                    this.method_1064(var1, var9, this.actualReceiverType, 0, (FlowInfo)var3);
                }
                if (var9.method_408() && this.field_756 != null && var1.method_716(var9) && !((FlowInfo)var3).method_3082(var9)) {
                    var1.problemReporter().method_1788(var9, this);
                }
                break;
            case 2:
                LocalVariableBinding var10;
                if (!((FlowInfo)var3).method_3083(var10 = (LocalVariableBinding)this.field_748)) {
                    var1.problemReporter().method_1789(var10, this);
                }
                if ((((FlowInfo)var3).tagBits & 1) == 0) {
                    var10.field_307 = 1;
                } else if (var10.field_307 == 0) {
                    var10.field_307 = 2;
                }
                this.checkNPE(var1, var2, (FlowInfo)var3, true);
        }
        if (var7) {
            this.manageEnclosingInstanceAccessIfNecessary(var1, (FlowInfo)var3);
        }
        if (this.field_756 != null) {
            for (int var12 = 0; var12 < var6 - 1; ++var12) {
                var9 = this.field_756[var12];
                var7 = !this.field_756[var12 + 1].method_431();
                if (var7 || var8) {
                    this.method_1064(var1, var9, var12 == 0 ? ((VariableBinding)this.field_748).type : this.field_756[var12 - 1].type, var12 + 1, (FlowInfo)var3);
                }
            }
            var9 = this.field_756[var6 - 1];
        }
        TypeBinding var11;
        if (var5) {
            if (var6 == 0 && var9.method_408() && var1.method_716(var9) && !((FlowInfo)var3).method_3082(var9)) {
                var1.problemReporter().method_1788(var9, this);
            }
            switch (var6) {
                case 0:
                    var11 = this.actualReceiverType;
                    break;
                case 1:
                    var11 = ((VariableBinding)this.field_748).type;
                    break;
                default:
                    var11 = this.field_756[var6 - 2].type;
            }
            this.method_1064(var1, var9, var11, var6, (FlowInfo)var3);
        }
        if (var4.field_688 != null) {
            var3 = var4.field_688.analyseCode(var1, var2, (FlowInfo)var3).method_3109();
        }
        if (var9.method_409()) {
            if (var6 == 0 && this.indexOfFirstFieldBinding == 1 && var9.method_408() && !var5 && var1.method_706(var9)) {
                if (((FlowInfo)var3).method_3087(var9)) {
                    var1.problemReporter().duplicateInitializationOfBlankFinalField(var9, this);
                } else {
                    var2.recordSettingFinal(var9, this, (FlowInfo)var3);
                }
                ((FlowInfo)var3).markAsDefinitelyAssigned(var9);
            } else {
                var1.problemReporter().method_1491(var9, this);
                if (var6 == 0 && var1.method_706(var9)) {
                    ((FlowInfo)var3).markAsDefinitelyAssigned(var9);
                }
            }
        }
        switch (var6) {
            case 0:
                var11 = this.actualReceiverType;
                break;
            case 1:
                var11 = ((VariableBinding)this.field_748).type;
                break;
            default:
                var11 = this.field_756[var6 - 2].type;
        }
        this.method_1064(var1, var9, var11, -1, (FlowInfo)var3);
        return (FlowInfo)var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return this.analyseCode(var1, var2, var3, true);
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3, boolean var4) {
        int var5 = this.field_756 == null ? 0 : this.field_756.length;
        boolean var6 = var5 == 0 ? var4 : !this.field_756[0].method_431();
        boolean var7 = var1.compilerOptions().field_1927 >= 3145728L;
        switch (this.field_446 & 7) {
            case 1:
                if (var6 || var7) {
                    this.method_1064(var1, (FieldBinding)this.field_748, this.actualReceiverType, 0, var3);
                }
                if (this.indexOfFirstFieldBinding == 1) {
                    FieldBinding var11 = (FieldBinding)this.field_748;
                    if (var11.method_408() && var1.method_716(var11) && !var3.method_3082(var11)) {
                        var1.problemReporter().method_1788(var11, this);
                    }
                }
                break;
            case 2:
                LocalVariableBinding var8;
                if (!var3.method_3083(var8 = (LocalVariableBinding)this.field_748)) {
                    var1.problemReporter().method_1789(var8, this);
                }
                if ((var3.tagBits & 1) == 0) {
                    var8.field_307 = 1;
                } else if (var8.field_307 == 0) {
                    var8.field_307 = 2;
                }
                this.checkNPE(var1, var2, var3, true);
        }
        if (var6) {
            this.manageEnclosingInstanceAccessIfNecessary(var1, var3);
        }
        if (this.field_756 != null) {
            for (int var10 = 0; var10 < var5; ++var10) {
                var6 = var10 < var5 - 1 ? !this.field_756[var10 + 1].method_431() : var4;
                if (var6 || var7) {
                    TypeBinding var9 = this.getGenericCast(var10);
                    if (var9 == null) {
                        if (var10 == 0) {
                            var9 = ((VariableBinding)this.field_748).type;
                        } else {
                            var9 = this.field_756[var10 - 1].type;
                        }
                    }
                    this.method_1064(var1, this.field_756[var10], var9, var10 + 1, var3);
                }
            }
        }
        return var3;
    }

    public void checkNPE(BlockScope var1, FlowContext var2, FlowInfo var3, boolean var4) {
        if ((this.field_446 & 7) == 2) {
            LocalVariableBinding var5 = (LocalVariableBinding)this.field_748;
            if (var5 != null && (var5.type.tagBits & 2L) == 0L && (var4 || var5.type.id != 11)) {
                if ((this.field_446 & 131072) == 0) {
                    var2.recordUsingNullReference(var1, var5, this, 3, var3);
                }
                var3.method_3094(var5);
                if (var2.initsOnFinally != null) {
                    var2.initsOnFinally.method_3094(var5);
                }
            }
        }
    }

    public void computeConversion(Scope var1, TypeBinding var2, TypeBinding var3) {
        if (var2 != null && var3 != null) {
            FieldBinding var4 = null;
            int var5 = this.field_756 == null ? 0 : this.field_756.length;
            if (var5 == 0) {
                if ((this.field_446 & 1) != 0 && this.field_748 != null && this.field_748.isValidBinding()) {
                    var4 = (FieldBinding)this.field_748;
                }
            } else {
                var4 = this.field_756[var5 - 1];
            }
            if (var4 != null) {
                FieldBinding var6 = var4.original();
                TypeBinding var7 = var6.type;
                if (var6 != var4 && var7 != var4.type && var2.id != 1 && (var7.tagBits & 536870912L) != 0L) {
                    TypeBinding var8 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    TypeBinding var9 = var7.method_141(var8);
                    this.setGenericCast(var5, var9);
                    if (var9 instanceof ReferenceBinding) {
                        ReferenceBinding var10 = (ReferenceBinding)var9;
                        if (!var10.canBeSeenBy(var1)) {
                            ProblemReporter var10000 = var1.problemReporter();
                            ProblemReferenceBinding var10002 = new ProblemReferenceBinding(CharOperation.method_1385('.', var10.shortReadableName()), var10, 2);
                            var10000.method_1639(this, var10002);
                        }
                    }
                }
            }
            super.computeConversion(var1, var2, var3);
        }
    }

    public void generateAssignment(BlockScope var1, CodeStream var2, Assignment var3, boolean var4) {
        int var5 = var2.field_1208;
        FieldBinding var6 = this.generateReadSequence(var1, var2);
        var2.method_2360(var5, this.field_444);
        var3.field_688.generateCode(var1, var2, true);
        this.method_1037(var2, var6, this.syntheticWriteAccessor, var4);
        if (var4) {
            var2.method_2182(var3.field_674);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.constant != Constant.NotAConstant) {
            if (var3) {
                var2.generateConstant(this.constant, this.field_674);
            }
        } else {
            FieldBinding var5 = this.generateReadSequence(var1, var2);
            if (var5 != null) {
                boolean var6 = var5.method_431();
                Constant var7 = var5.constant();
                if (var7 != Constant.NotAConstant) {
                    if (!var6) {
                        var2.method_2271();
                        var2.method_2352();
                    }
                    if (var3) {
                        var2.generateConstant(var7, this.field_674);
                    }
                } else {
                    boolean var8 = var5 == this.field_748 && (this.indexOfFirstFieldBinding == 1 || var5.declaringClass == var1.method_584()) && this.field_756 == null;
                    TypeBinding var9 = this.getGenericCast(this.field_757 == null ? 0 : this.field_757.length);
                    if (!var3 && (var8 || var1.compilerOptions().field_1927 < 3145728L) && (this.field_674 & 1024) == 0 && var9 == null) {
                        if (!var6) {
                            var2.method_2271();
                            var2.method_2352();
                        }
                    } else {
                        int var10 = var2.field_1208;
                        if (var5.declaringClass == null) {
                            var2.method_2101();
                            if (var3) {
                                var2.method_2182(this.field_674);
                            } else {
                                var2.method_2352();
                            }
                        } else {
                            SyntheticMethodBinding var11 = this.syntheticReadAccessors == null ? null : this.syntheticReadAccessors[this.syntheticReadAccessors.length - 1];
                            if (var11 == null) {
                                if (var6) {
                                    var2.method_2207(var5);
                                } else {
                                    var2.method_2205(var5);
                                }
                            } else {
                                var2.method_2273(var11);
                            }
                            if (var9 != null) {
                                var2.method_2113(var9);
                            }
                            if (var3) {
                                var2.method_2182(this.field_674);
                            } else {
                                boolean var12 = (this.field_674 & 1024) != 0;
                                if (var12) {
                                    var2.method_2182(this.field_674);
                                }
                                switch (var12 ? this.postConversionType(var1).id : var5.type.id) {
                                    case 7:
                                    case 8:
                                        var2.method_2353();
                                        break;
                                    default:
                                        var2.method_2352();
                                }
                            }
                        }
                        int var13 = (int)(this.sourcePositions[this.sourcePositions.length - 1] >>> 32);
                        var2.method_2360(var10, var13);
                    }
                }
            }
        }
        var2.method_2360(var4, this.field_444);
    }

    public void generateCompoundAssignment(BlockScope var1, CodeStream var2, Expression var3, int var4, int var5, boolean var6) {
        FieldBinding var7 = this.generateReadSequence(var1, var2);
        SyntheticMethodBinding var8 = this.syntheticReadAccessors == null ? null : this.syntheticReadAccessors[this.syntheticReadAccessors.length - 1];
        if (var7.method_431()) {
            if (var8 == null) {
                var2.method_2207(var7);
            } else {
                var2.method_2273(var8);
            }
        } else {
            var2.method_2141();
            if (var8 == null) {
                var2.method_2205(var7);
            } else {
                var2.method_2273(var8);
            }
        }
        int var9;
        switch (var9 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.generateStringConcatenationAppend(var1, (Expression)null, var3);
                break;
            default:
                TypeBinding var10 = this.getGenericCast(this.field_757 == null ? 0 : this.field_757.length);
                if (var10 != null) {
                    var2.method_2113(var10);
                }
                var2.method_2182(this.field_674);
                if (var3 == IntLiteral.One) {
                    var2.generateConstant(var3.constant, this.field_674);
                } else {
                    var3.generateCode(var1, var2, true);
                }
                var2.method_2374(var4, var9);
                var2.method_2182(var5);
        }
        this.method_1037(var2, var7, this.syntheticWriteAccessor, var6);
    }

    public void generatePostIncrement(BlockScope var1, CodeStream var2, CompoundAssignment var3, boolean var4) {
        FieldBinding var5 = this.generateReadSequence(var1, var2);
        SyntheticMethodBinding var6 = this.syntheticReadAccessors == null ? null : this.syntheticReadAccessors[this.syntheticReadAccessors.length - 1];
        if (var5.method_431()) {
            if (var6 == null) {
                var2.method_2207(var5);
            } else {
                var2.method_2273(var6);
            }
        } else {
            var2.method_2141();
            if (var6 == null) {
                var2.method_2205(var5);
            } else {
                var2.method_2273(var6);
            }
        }
        if (var4) {
            if (var5.method_431()) {
                if (var5.type != TypeBinding.field_183 && var5.type != TypeBinding.field_185) {
                    var2.method_2141();
                } else {
                    var2.method_2144();
                }
            } else if (var5.type != TypeBinding.field_183 && var5.type != TypeBinding.field_185) {
                var2.method_2142();
            } else {
                var2.method_2145();
            }
        }
        TypeBinding var7 = this.getGenericCast(this.field_757 == null ? 0 : this.field_757.length);
        if (var7 != null) {
            var2.method_2113(var7);
        }
        var2.method_2182(this.field_674);
        var2.generateConstant(var3.field_688.constant, this.field_674);
        var2.method_2374(var3.field_689, this.field_674 & 15);
        var2.method_2182(var3.field_690);
        this.method_1037(var2, var5, this.syntheticWriteAccessor, false);
    }

    public FieldBinding generateReadSequence(BlockScope var1, CodeStream var2) {
        int var3 = this.field_757 == null ? 0 : this.field_757.length;
        boolean var4 = var3 == 0 || !this.field_756[0].method_431();
        FieldBinding var5 = null;
        TypeBinding var6 = null;
        boolean var7 = var1.compilerOptions().field_1927 >= 3145728L;
        int var15;
        switch (this.field_446 & 7) {
            case 1:
                var5 = (FieldBinding)this.field_749;
                var6 = this.genericCast;
                if (var5.constant() == Constant.NotAConstant && (var4 && !var5.method_431() || var6 != null)) {
                    var15 = var2.field_1208;
                    if ((this.field_446 & 8160) != 0) {
                        ReferenceBinding var16 = var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5);
                        Object[] var18 = var1.getEmulationPath(var16, true, false);
                        var2.generateOuterAccess(var18, this, var16, var1);
                    } else {
                        this.generateReceiver(var2);
                    }
                    var2.method_2360(var15, this.field_444);
                }
                break;
            case 2:
                if (var4) {
                    LocalVariableBinding var8 = (LocalVariableBinding)this.field_749;
                    Constant var9 = var8.constant();
                    if (var9 != Constant.NotAConstant) {
                        var2.generateConstant(var9, 0);
                    } else if ((this.field_446 & 8160) != 0) {
                        VariableBinding[] var10 = var1.getEmulationPath(var8);
                        var2.generateOuterAccess(var10, this, var8, var1);
                    } else {
                        var2.load(var8);
                    }
                }
        }
        var15 = this.sourcePositions.length;
        if (this.field_757 != null) {
            for (int var17 = 0; var17 < var3; ++var17) {
                int var19 = var2.field_1208;
                FieldBinding var11 = this.field_757[var17];
                TypeBinding var12 = this.otherGenericCasts == null ? null : this.otherGenericCasts[var17];
                if (var5 != null) {
                    var4 = !var11.method_431();
                    Constant var13 = var5.constant();
                    if (var13 != Constant.NotAConstant) {
                        if (var17 > 0 && !var5.method_431()) {
                            var2.method_2271();
                            var2.method_2352();
                        }
                        if (var4) {
                            var2.generateConstant(var13, 0);
                        }
                    } else {
                        SyntheticMethodBinding var14;
                        if (!var4 && (var17 <= 0 || !var7) && var6 == null) {
                            if (this.field_749 == var5) {
                                if (var5.method_431() && ((FieldBinding)this.field_748).original().declaringClass != this.actualReceiverType.erasure()) {
                                    var14 = this.syntheticReadAccessors == null ? null : this.syntheticReadAccessors[var17];
                                    if (var14 == null) {
                                        var2.method_2207(var5);
                                    } else {
                                        var2.method_2273(var14);
                                    }
                                    var2.method_2352();
                                }
                            } else if (!var5.method_431()) {
                                var2.method_2271();
                                var2.method_2352();
                            }
                        } else {
                            var14 = this.syntheticReadAccessors == null ? null : this.syntheticReadAccessors[var17];
                            if (var14 == null) {
                                if (var5.method_431()) {
                                    var2.method_2207(var5);
                                } else {
                                    var2.method_2205(var5);
                                }
                            } else {
                                var2.method_2273(var14);
                            }
                            if (var6 != null) {
                                var2.method_2113(var6);
                            }
                            if (!var4) {
                                var2.method_2352();
                            }
                        }
                        if (var15 - var3 + var17 - 1 >= 0) {
                            int var20 = (int)(this.sourcePositions[var15 - var3 + var17 - 1] >>> 32);
                            var2.method_2360(var19, var20);
                        }
                    }
                }
                var5 = var11;
                var6 = var12;
            }
        }
        return var5;
    }

    public void generateReceiver(CodeStream var1) {
        var1.method_2093();
    }

    public TypeBinding[] genericTypeArguments() {
        return null;
    }

    protected FieldBinding getCodegenBinding(int var1) {
        return var1 == 0 ? (FieldBinding)this.field_749 : this.field_757[var1 - 1];
    }

    protected TypeBinding getGenericCast(int var1) {
        return var1 == 0 ? this.genericCast : (this.otherGenericCasts == null ? null : this.otherGenericCasts[var1 - 1]);
    }

    public TypeBinding method_1062(BlockScope var1) {
        int var2 = this.tokens.length;
        FieldBinding var3;
        if ((this.field_446 & 1) != 0) {
            var3 = (FieldBinding)this.field_748;
            if (!var3.method_431()) {
                if (this.indexOfFirstFieldBinding > 1 || var1.method_635().field_404) {
                    var1.problemReporter().method_1757(this, var3);
                    return null;
                }
            } else if (this.indexOfFirstFieldBinding > 1 && var3.declaringClass != this.actualReceiverType && var3.declaringClass.canBeSeenBy(var1)) {
                var1.problemReporter().method_1612(this, var3);
            }
            if (this.isFieldUseDeprecated(var3, var1, (this.field_446 & 8192) != 0 && this.indexOfFirstFieldBinding == var2)) {
                var1.problemReporter().method_1514(var3, this);
            }
        } else {
            var3 = null;
        }
        TypeBinding var4 = ((VariableBinding)this.field_748).type;
        int var5 = this.indexOfFirstFieldBinding;
        if (var5 == var2) {
            this.constant = ((FieldBinding)this.field_748).constant();
            return var4 != null && (this.field_446 & 8192) == 0 ? var4.capture(var1, this.field_445) : var4;
        } else {
            int var6 = var2 - var5;
            this.field_757 = this.field_756 = new FieldBinding[var6];
            this.otherDepths = new int[var6];
            this.constant = ((VariableBinding)this.field_748).constant();
            int var7 = (this.field_446 & 8160) >> 5;
            while (true) {
                if (var5 < var2) {
                    char[] var8 = this.tokens[var5];
                    if (var4 == null) {
                        return null;
                    }
                    this.field_446 &= -8161;
                    FieldBinding var9 = var3;
                    var3 = var1.method_601(var4.capture(var1, (int)this.sourcePositions[var5]), var8, this);
                    int var10 = var5 - this.indexOfFirstFieldBinding;
                    this.field_756[var10] = var3;
                    this.otherDepths[var10] = (this.field_446 & 8160) >> 5;
                    if (var3.isValidBinding()) {
                        if (var9 != null) {
                            Object var11 = var4;
                            TypeBinding var12 = var4.erasure();
                            if (var12 instanceof ReferenceBinding && var12.method_140(var3.declaringClass) == null) {
                                var11 = var3.declaringClass;
                            }
                            FieldBinding var13 = var9.original();
                            if ((var13.type.tagBits & 536870912L) != 0L && ((TypeBinding)var11).id != 1) {
                                this.setGenericCast(var5 - 1, var13.type.method_141((TypeBinding)var11));
                            }
                        }
                        if (this.isFieldUseDeprecated(var3, var1, (this.field_446 & 8192) != 0 && var5 + 1 == var2)) {
                            var1.problemReporter().method_1514(var3, this);
                        }
                        if (this.constant != Constant.NotAConstant) {
                            this.constant = var3.constant();
                        }
                        if (var3.method_431()) {
                            ReferenceBinding var15 = var3.declaringClass;
                            if (var15.method_153()) {
                                MethodScope var14 = var1.method_635();
                                SourceTypeBinding var16 = var14.enclosingSourceType();
                                if ((var16 == var15 || var16.superclass == var15) && var3.constant() == Constant.NotAConstant && !var14.field_404 && var14.method_728()) {
                                    var1.problemReporter().method_1543(var3, this);
                                }
                            }
                            var1.problemReporter().nonStaticAccessToStaticField(this, var3, var5);
                            if (var3.declaringClass != var4) {
                                var1.problemReporter().method_1612(this, var3);
                            }
                        }
                        var4 = var3.type;
                        ++var5;
                        continue;
                    }
                    this.constant = Constant.NotAConstant;
                    var1.problemReporter().invalidField(this, var3, var5, var4);
                    this.method_2(var7);
                    return null;
                }
                this.method_2(var7);
                var4 = this.field_756[var6 - 1].type;
                return var4 != null && (this.field_446 & 8192) == 0 ? var4.capture(var1, this.field_445) : var4;
            }
        }
    }

    public void manageEnclosingInstanceAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            if ((this.field_446 & 8160) == 0 || this.constant != Constant.NotAConstant) {
                return;
            }
            if ((this.field_446 & 7) == 2) {
                var1.emulateOuterAccess((LocalVariableBinding)this.field_748);
            }
        }
    }

    public void method_1064(BlockScope var1, FieldBinding var2, TypeBinding var3, int var4, FlowInfo var5) {
        if ((var5.tagBits & 1) == 0) {
            if (var2.constant() == Constant.NotAConstant) {
                FieldBinding var6 = var2.original();
                if (var6 != var2) {
                    this.method_1066(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4, var6);
                }
                if (var2.method_428()) {
                    FieldBinding var7 = this.getCodegenBinding(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4);
                    if (var7.declaringClass != var1.enclosingSourceType()) {
                        this.setSyntheticAccessor(var2, var4, ((SourceTypeBinding)var7.declaringClass).method_298(var7, var4 >= 0));
                        var1.problemReporter().needToEmulateFieldAccess(var7, this, var4 >= 0);
                        return;
                    }
                } else if (var2.method_429()) {
                    int var9 = var4 != 0 && (var4 >= 0 || this.otherDepths != null) ? this.otherDepths[var4 < 0 ? this.otherDepths.length - 1 : var4 - 1] : (this.field_446 & 8160) >> 5;
                    if (var9 > 0 && var2.declaringClass.getPackage() != var1.enclosingSourceType().getPackage()) {
                        FieldBinding var8 = this.getCodegenBinding(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4);
                        this.setSyntheticAccessor(var2, var4, ((SourceTypeBinding)var1.enclosingSourceType().enclosingTypeAt(var9)).method_298(var8, var4 >= 0));
                        var1.problemReporter().needToEmulateFieldAccess(var8, this, var4 >= 0);
                        return;
                    }
                }
                if (var2.declaringClass != var3 && !var3.method_147() && var2.declaringClass != null && var2.constant() == Constant.NotAConstant) {
                    CompilerOptions var10 = var1.compilerOptions();
                    if (var10.field_1929 >= 3014656L && (var10.field_1927 >= 3145728L || var4 > 1 || this.indexOfFirstFieldBinding != 1 || !var2.method_431()) && var2.declaringClass.id != 1 || !var2.declaringClass.canBeSeenBy(var1)) {
                        this.method_1066(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4, var1.enclosingSourceType().method_311(this.getCodegenBinding(var4 < 0 ? (this.field_756 == null ? 0 : this.field_756.length) : var4), (ReferenceBinding)var3.erasure()));
                    }
                }
            }
        }
    }

    public int nullStatus(FlowInfo var1) {
        return 0;
    }

    public Constant optimizedBooleanConstant() {
        switch (this.resolvedType.id) {
            case 5:
            case 33:
                if (this.constant != Constant.NotAConstant) {
                    return this.constant;
                } else {
                    switch (this.field_446 & 7) {
                        case 1:
                            if (this.field_756 == null) {
                                return ((FieldBinding)this.field_748).constant();
                            }
                        case 2:
                            return this.field_756[this.field_756.length - 1].constant();
                    }
                }
            default:
                return Constant.NotAConstant;
        }
    }

    public TypeBinding postConversionType(Scope var1) {
        Object var2 = this.resolvedType;
        TypeBinding var3 = this.getGenericCast(this.field_757 == null ? 0 : this.field_757.length);
        if (var3 != null) {
            var2 = var3;
        }
        int var4 = (this.field_674 & 255) >> 4;
        switch (var4) {
            case 2:
                var2 = TypeBinding.field_182;
                break;
            case 3:
                var2 = TypeBinding.field_180;
                break;
            case 4:
                var2 = TypeBinding.field_181;
                break;
            case 5:
                var2 = TypeBinding.field_186;
            case 6:
            default:
                break;
            case 7:
                var2 = TypeBinding.field_183;
                break;
            case 8:
                var2 = TypeBinding.field_185;
                break;
            case 9:
                var2 = TypeBinding.field_184;
                break;
            case 10:
                var2 = TypeBinding.field_179;
        }
        if ((this.field_674 & 512) != 0) {
            var2 = var1.environment().method_486((TypeBinding)var2);
        }
        return (TypeBinding)var2;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        for (int var3 = 0; var3 < this.tokens.length; ++var3) {
            if (var3 > 0) {
                var2.append('.');
            }
            var2.append(this.tokens[var3]);
        }
        return var2;
    }

    public TypeBinding method_1065(BlockScope var1) {
        if (this.field_748 instanceof ProblemFieldBinding) {
            var1.problemReporter().method_1629(this, (FieldBinding)this.field_748);
        } else if (!(this.field_748 instanceof ProblemReferenceBinding) && !(this.field_748 instanceof MissingTypeBinding)) {
            var1.problemReporter().unresolvableReference(this, this.field_748);
        } else {
            var1.problemReporter().method_1639(this, (TypeBinding)this.field_748);
        }
        return null;
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.actualReceiverType = var1.method_584();
        this.constant = Constant.NotAConstant;
        if ((this.field_749 = this.field_748 = var1.getBinding(this.tokens, this.field_446 & 7, this, true)).isValidBinding()) {
            switch (this.field_446 & 7) {
                case 3:
                case 7:
                    ProblemReporter var10000;
                    ProblemFieldBinding var10002;
                    if (this.field_748 instanceof LocalVariableBinding) {
                        LocalVariableBinding var7 = (LocalVariableBinding)this.field_748;
                        if (!var7.method_409() && (this.field_446 & 8160) != 0) {
                            var1.problemReporter().method_1501((LocalVariableBinding)this.field_748, this);
                        }
                        this.field_446 &= -8;
                        this.field_446 |= 2;
                        if (var7.type != null && (var7.type.tagBits & 128L) != 0L) {
                            return null;
                        }
                        this.resolvedType = this.method_1062(var1);
                        if (this.resolvedType != null && (this.resolvedType.tagBits & 128L) != 0L) {
                            FieldBinding var8 = this.field_756[this.field_756.length - 1];
                            var10000 = var1.problemReporter();
                            var10002 = new ProblemFieldBinding(var8.declaringClass, var8.name, 1);
                            var10000.invalidField(this, var10002, this.tokens.length, this.resolvedType.method_173());
                            return null;
                        }
                        return this.resolvedType;
                    }
                    if (this.field_748 instanceof FieldBinding) {
                        FieldBinding var6 = (FieldBinding)this.field_748;
                        MethodScope var3 = var1.method_635();
                        if (this.indexOfFirstFieldBinding == 1 && var3.enclosingSourceType() == var6.original().declaringClass && var3.field_407 >= 0 && var6.field_304 >= var3.field_407 && (!var6.method_431() || var3.field_404)) {
                            var1.problemReporter().method_1556(this, 0, var3.enclosingSourceType());
                        }
                        if (var6.method_431()) {
                            ReferenceBinding var4 = var6.declaringClass;
                            if (var4.method_153()) {
                                SourceTypeBinding var5 = var3.enclosingSourceType();
                                if ((var5 == var4 || var5.superclass == var4) && var6.constant() == Constant.NotAConstant && !var3.field_404 && var3.method_728()) {
                                    var1.problemReporter().method_1543(var6, this);
                                }
                            }
                        } else if (this.indexOfFirstFieldBinding == 1 && var1.compilerOptions().method_3313(4194304L) != -1) {
                            var1.problemReporter().method_1796(this, var6);
                        }
                        this.field_446 &= -8;
                        this.field_446 |= 1;
                        this.resolvedType = this.method_1062(var1);
                        if (this.resolvedType != null && (this.resolvedType.tagBits & 128L) != 0L) {
                            FieldBinding var9 = this.indexOfFirstFieldBinding == this.tokens.length ? (FieldBinding)this.field_748 : this.field_756[this.field_756.length - 1];
                            var10000 = var1.problemReporter();
                            var10002 = new ProblemFieldBinding(var9.declaringClass, var9.name, 1);
                            var10000.invalidField(this, var10002, this.tokens.length, this.resolvedType.method_173());
                            return null;
                        }
                        return this.resolvedType;
                    }
                    this.field_446 &= -8;
                    this.field_446 |= 4;
                case 4:
                    TypeBinding var2 = (TypeBinding)this.field_748;
                    var2 = var1.environment().convertToRawType(var2, false);
                    return this.resolvedType = var2;
                case 5:
                case 6:
            }
        }
        return this.resolvedType = this.method_1065(var1);
    }

    protected void method_1066(int var1, FieldBinding var2) {
        if (var1 == 0) {
            this.field_749 = var2;
        } else {
            int var3 = this.field_756.length;
            if (this.field_757 == this.field_756) {
                System.arraycopy(this.field_756, 0, this.field_757 = new FieldBinding[var3], 0, var3);
            }
            this.field_757[var1 - 1] = var2;
        }
    }

    public void setFieldIndex(int var1) {
        this.indexOfFirstFieldBinding = var1;
    }

    protected void setGenericCast(int var1, TypeBinding var2) {
        if (var1 == 0) {
            this.genericCast = var2;
        } else {
            if (this.otherGenericCasts == null) {
                this.otherGenericCasts = new TypeBinding[this.field_756.length];
            }
            this.otherGenericCasts[var1 - 1] = var2;
        }
    }

    protected void setSyntheticAccessor(FieldBinding var1, int var2, SyntheticMethodBinding var3) {
        if (var2 < 0) {
            this.syntheticWriteAccessor = var3;
        } else {
            if (this.syntheticReadAccessors == null) {
                this.syntheticReadAccessors = new SyntheticMethodBinding[this.field_756 == null ? 1 : this.field_756.length + 1];
            }
            this.syntheticReadAccessors[var2] = var3;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
