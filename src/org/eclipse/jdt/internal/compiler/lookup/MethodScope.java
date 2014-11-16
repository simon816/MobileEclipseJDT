package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

public class MethodScope extends BlockScope {

    public ReferenceContext referenceContext;

    public boolean field_404;

    public boolean field_405;

    public FieldBinding initializedField;

    public int field_407;

    public int field_408;

    public int field_409;

    public long[] definiteInits;

    public long[][] extraDefiniteInits;

    public boolean field_412;

    public SyntheticArgumentBinding[] extraSyntheticArguments;

    public MethodScope(ClassScope var1, ReferenceContext var2, boolean var3) {
        super(2, var1);
        this.field_405 = false;
        this.field_407 = -1;
        this.field_409 = 0;
        this.definiteInits = new long[4];
        this.extraDefiniteInits = new long[4][];
        this.field_412 = false;
        this.locals = new LocalVariableBinding[5];
        this.referenceContext = var2;
        this.field_404 = var3;
        this.field_393 = 0;
    }

    String basicToString(int var1) {
        String var2 = "\n";
        int var3 = var1;
        while (true) {
            --var3;
            if (var3 < 0) {
                String var5 = var2 + "--- Method Scope ---";
                var2 = var2 + "\t";
                var5 = var5 + var2 + "locals:";
                for (int var4 = 0; var4 < this.field_392; ++var4) {
                    var5 = var5 + var2 + "\t" + this.locals[var4].toString();
                }
                var5 = var5 + var2 + "startIndex = " + this.field_393;
                var5 = var5 + var2 + "isConstructorCall = " + this.field_405;
                var5 = var5 + var2 + "initializedField = " + this.initializedField;
                var5 = var5 + var2 + "lastVisibleFieldID = " + this.field_407;
                var5 = var5 + var2 + "referenceContext = " + this.referenceContext;
                return var5;
            }
            var2 = var2 + "\t";
        }
    }

    private void method_721(MethodBinding var1) {
        int var2 = var1.modifiers;
        ReferenceBinding var3 = var1.declaringClass;
        if ((var2 & 4194304) != 0) {
            this.problemReporter().method_1531(var3, (AbstractMethodDeclaration)this.referenceContext);
        }
        int var6;
        if ((((ConstructorDeclaration)this.referenceContext).field_446 & 128) != 0 && (var6 = var3.modifiers & 16389) != 0) {
            if ((var6 & 16384) != 0) {
                var2 &= -8;
                var2 |= 2;
            } else {
                var2 &= -8;
                var2 |= var6;
            }
        }
        int var4 = var2 & '\uffff';
        if (var3.method_153() && (((ConstructorDeclaration)this.referenceContext).field_446 & 128) == 0) {
            if ((var4 & -2051) != 0) {
                this.problemReporter().method_1583((AbstractMethodDeclaration)this.referenceContext);
                var2 &= -63486;
            } else if ((((AbstractMethodDeclaration)this.referenceContext).field_482 & 2048) != 0) {
                this.problemReporter().method_1593((AbstractMethodDeclaration)this.referenceContext);
            }
            var2 |= 2;
        } else if ((var4 & -2056) != 0) {
            this.problemReporter().method_1593((AbstractMethodDeclaration)this.referenceContext);
            var2 &= -63481;
        } else if ((((AbstractMethodDeclaration)this.referenceContext).field_482 & 2048) != 0) {
            this.problemReporter().method_1593((AbstractMethodDeclaration)this.referenceContext);
        }
        var6 = var4 & 7;
        if ((var6 & var6 - 1) != 0) {
            this.problemReporter().method_1603(var3, (AbstractMethodDeclaration)this.referenceContext);
            if ((var6 & 1) != 0) {
                if ((var6 & 4) != 0) {
                    var2 &= -5;
                }
                if ((var6 & 2) != 0) {
                    var2 &= -3;
                }
            } else if ((var6 & 4) != 0 && (var6 & 2) != 0) {
                var2 &= -3;
            }
        }
        var1.modifiers = var2;
    }

    private void method_722(MethodBinding var1) {
        int var2 = var1.modifiers;
        ReferenceBinding var3 = var1.declaringClass;
        if ((var2 & 4194304) != 0) {
            this.problemReporter().method_1531(var3, (AbstractMethodDeclaration)this.referenceContext);
        }
        int var4 = var2 & '\uffff';
        if (var3.method_157()) {
            if ((var4 & -1026) != 0) {
                if ((var3.modifiers & 8192) != 0) {
                    this.problemReporter().method_1577((AbstractMethodDeclaration)this.referenceContext);
                } else {
                    this.problemReporter().method_1587((AbstractMethodDeclaration)this.referenceContext);
                }
            }
        } else {
            if ((var4 & -3392) != 0) {
                this.problemReporter().method_1593((AbstractMethodDeclaration)this.referenceContext);
                var2 &= -62145;
            }
            int var6 = var4 & 7;
            if ((var6 & var6 - 1) != 0) {
                this.problemReporter().method_1603(var3, (AbstractMethodDeclaration)this.referenceContext);
                if ((var6 & 1) != 0) {
                    if ((var6 & 4) != 0) {
                        var2 &= -5;
                    }
                    if ((var6 & 2) != 0) {
                        var2 &= -3;
                    }
                } else if ((var6 & 4) != 0 && (var6 & 2) != 0) {
                    var2 &= -3;
                }
            }
            if ((var2 & 1024) != 0) {
                short var7 = 2362;
                if ((var2 & var7) != 0) {
                    this.problemReporter().method_1566(var3, (AbstractMethodDeclaration)this.referenceContext);
                }
                if (!var1.declaringClass.method_217()) {
                    this.problemReporter().method_1462((SourceTypeBinding)var3, (AbstractMethodDeclaration)this.referenceContext);
                }
            }
            if ((var2 & 256) != 0 && (var2 & 2048) != 0) {
                this.problemReporter().method_1688(var3, (AbstractMethodDeclaration)this.referenceContext);
            }
            if ((var4 & 8) != 0 && var3.method_160() && !var3.method_226()) {
                this.problemReporter().method_1785(var3, (AbstractMethodDeclaration)this.referenceContext);
            }
            var1.modifiers = var2;
        }
    }

    public void checkUnusedParameters(MethodBinding var1) {
        if (!var1.method_356() && (!var1.method_363() || this.compilerOptions().field_1941) && (!var1.method_366() || var1.method_363() || this.compilerOptions().field_1942) && !var1.method_364()) {
            int var2 = 0;
            for (int var3 = this.field_392; var2 < var3; ++var2) {
                LocalVariableBinding var4 = this.locals[var2];
                if (var4 == null || (var4.tagBits & 1024L) == 0L) {
                    break;
                }
                if (var4.field_307 == 0 && (var4.declaration.field_446 & 1073741824) != 0) {
                    this.problemReporter().method_1807(var4.declaration);
                }
            }
        }
    }

    public void computeLocalVariablePositions(int var1, CodeStream var2) {
        this.field_394 = var1;
        this.field_395 = var1;
        int var3 = 0;
        for (int var4 = this.field_392; var3 < var4; ++var3) {
            LocalVariableBinding var5 = this.locals[var3];
            if (var5 == null || (var5.tagBits & 1024L) == 0L) {
                break;
            }
            var2.method_2358(var5);
            var5.field_306 = this.field_394;
            if (var5.type != TypeBinding.field_183 && var5.type != TypeBinding.field_185) {
                ++this.field_394;
            } else {
                this.field_394 += 2;
            }
            if (this.field_394 > 255) {
                this.problemReporter().method_1697(var5, var5.declaration);
            }
        }
        if (this.extraSyntheticArguments != null) {
            int var8 = 0;
            for (int var6 = this.extraSyntheticArguments.length; var8 < var6; ++var8) {
                SyntheticArgumentBinding var7 = this.extraSyntheticArguments[var8];
                var7.field_306 = this.field_394;
                if (var7.type != TypeBinding.field_183 && var7.type != TypeBinding.field_185) {
                    ++this.field_394;
                } else {
                    this.field_394 += 2;
                }
                if (this.field_394 > 255) {
                    this.problemReporter().method_1697(var7, (ASTNode)this.referenceContext);
                }
            }
        }
        this.computeLocalVariablePositions(var3, this.field_394, var2);
    }

    MethodBinding createMethod(AbstractMethodDeclaration var1) {
        this.referenceContext = var1;
        var1.scope = this;
        SourceTypeBinding var2 = this.referenceType().binding;
        int var3 = var1.field_482 | 33554432;
        MethodBinding var10001;
        if (var1.method_795()) {
            if (var1.method_796()) {
                var3 |= 67108864;
            }
            var10001 = new MethodBinding(var3, (TypeBinding[])null, (ReferenceBinding[])null, var2);
            var1.binding = var10001;
            this.method_721(var1.binding);
        } else {
            if (var2.method_157()) {
                var3 |= 1025;
            }
            var10001 = new MethodBinding(var3, var1.selector, (TypeBinding)null, (TypeBinding[])null, (ReferenceBinding[])null, var2);
            var1.binding = var10001;
            this.method_722(var1.binding);
        }
        this.field_404 = var1.binding.method_370();
        Argument[] var4 = var1.arguments;
        int var5 = var4 == null ? 0 : var4.length;
        if (var5 > 0 && this.compilerOptions().field_1928 >= 3211264L) {
            --var5;
            if (var4[var5].isVarArgs()) {
                var1.binding.modifiers |= 128;
            }
            while (true) {
                --var5;
                if (var5 < 0) {
                    break;
                }
                if (var4[var5].isVarArgs()) {
                    this.problemReporter().illegalVararg(var4[var5], var1);
                }
            }
        }
        TypeParameter[] var6 = var1.typeParameters();
        if (var6 != null && this.compilerOptions().field_1928 >= 3211264L) {
            var1.binding.typeVariables = this.createTypeVariables(var6, var1.binding);
            var1.binding.modifiers |= 1073741824;
        } else {
            var1.binding.typeVariables = Binding.NO_TYPE_VARIABLES;
        }
        return var1.binding;
    }

    public FieldBinding findField(TypeBinding var1, char[] var2, InvocationSite var3, boolean var4) {
        FieldBinding var5 = super.findField(var1, var2, var3, var4);
        if (var5 == null) {
            return null;
        } else if (!var5.isValidBinding()) {
            return var5;
        } else if (var5.method_431()) {
            return var5;
        } else if (this.field_405 && var1 == this.enclosingSourceType()) {
            ProblemFieldBinding var10000;
            if (var3 instanceof SingleNameReference) {
                var10000 = new ProblemFieldBinding(var5, var5.declaringClass, var2, 6);
                return var10000;
            } else {
                if (var3 instanceof QualifiedNameReference) {
                    QualifiedNameReference var6 = (QualifiedNameReference)var3;
                    if (var6.field_748 == null) {
                        var10000 = new ProblemFieldBinding(var5, var5.declaringClass, var2, 6);
                        return var10000;
                    }
                }
                return var5;
            }
        } else {
            return var5;
        }
    }

    public boolean method_726() {
        return this.referenceContext instanceof ConstructorDeclaration;
    }

    public boolean method_727() {
        return this.referenceContext instanceof TypeDeclaration;
    }

    public boolean method_728() {
        return this.referenceContext instanceof TypeDeclaration || this.referenceContext instanceof ConstructorDeclaration;
    }

    public ProblemReporter problemReporter() {
        MethodScope var1;
        if ((var1 = this.method_641()) == this) {
            ProblemReporter var2 = this.referenceCompilationUnit().problemReporter;
            var2.referenceContext = this.referenceContext;
            return var2;
        } else {
            return var1.problemReporter();
        }
    }

    public final int recordInitializationStates(FlowInfo var1) {
        if ((var1.tagBits & 1) != 0) {
            return -1;
        } else {
            UnconditionalFlowInfo var2 = var1.method_3110();
            long[] var3 = var2.extra == null ? null : var2.extra[0];
            long var4 = var2.field_1787;
            int var6 = this.field_409;
            label55:
            while (true) {
                --var6;
                if (var6 < 0) {
                    if (this.definiteInits.length == this.field_409) {
                        System.arraycopy(this.definiteInits, 0, this.definiteInits = new long[this.field_409 + 20], 0, this.field_409);
                        System.arraycopy(this.extraDefiniteInits, 0, this.extraDefiniteInits = new long[this.field_409 + 20][], 0, this.field_409);
                    }
                    this.definiteInits[this.field_409] = var4;
                    if (var3 != null) {
                        this.extraDefiniteInits[this.field_409] = new long[var3.length];
                        System.arraycopy(var3, 0, this.extraDefiniteInits[this.field_409], 0, var3.length);
                    }
                    return this.field_409++;
                }
                if (this.definiteInits[var6] == var4) {
                    long[] var7 = this.extraDefiniteInits[var6];
                    if (var3 != null && var7 != null) {
                        if (var3.length == var7.length) {
                            int var8 = 0;
                            for (int var9 = var3.length; var8 < var9; ++var8) {
                                if (var3[var8] != var7[var8]) {
                                    continue label55;
                                }
                            }
                            return var6;
                        }
                    } else if (var3 == null && var7 == null) {
                        return var6;
                    }
                }
            }
        }
    }

    public AbstractMethodDeclaration referenceMethod() {
        return this.referenceContext instanceof AbstractMethodDeclaration ? (AbstractMethodDeclaration)this.referenceContext : null;
    }

    public TypeDeclaration referenceType() {
        return ((ClassScope)this.parent).referenceContext;
    }
}
