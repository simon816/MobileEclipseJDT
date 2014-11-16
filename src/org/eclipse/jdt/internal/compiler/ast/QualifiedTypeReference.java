package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;

public class QualifiedTypeReference extends TypeReference {

    public char[][] tokens;

    public long[] sourcePositions;

    public QualifiedTypeReference(char[][] var1, long[] var2) {
        this.tokens = var1;
        this.sourcePositions = var2;
        this.field_444 = (int)(this.sourcePositions[0] >>> 32);
        this.field_445 = (int)(this.sourcePositions[this.sourcePositions.length - 1] & 4294967295L);
    }

    public TypeReference copyDims(int var1) {
        ArrayQualifiedTypeReference var10000 = new ArrayQualifiedTypeReference(this.tokens, var1, this.sourcePositions);
        return var10000;
    }

    protected TypeBinding method_1030(int var1, Scope var2, PackageBinding var3) {
        LookupEnvironment var4 = var2.environment();
        TypeBinding var5;
        try {
            var4.missingClassFileLocation = this;
            if (this.resolvedType == null) {
                this.resolvedType = var2.getType(this.tokens[var1], var3);
            } else {
                this.resolvedType = var2.getMemberType(this.tokens[var1], (ReferenceBinding)this.resolvedType);
                if (!this.resolvedType.isValidBinding()) {
                    ProblemReferenceBinding var10001 = new ProblemReferenceBinding(CharOperation.subarray(this.tokens, 0, var1 + 1), (ReferenceBinding)this.resolvedType.closestMatch(), this.resolvedType.problemId());
                    this.resolvedType = var10001;
                }
            }
            var5 = this.resolvedType;
        } catch (AbortCompilation var9) {
            var9.updateContext(this, var2.referenceCompilationUnit().compilationResult);
            throw var9;
        } finally {
            var4.missingClassFileLocation = null;
        }
        return var5;
    }

    public char[] getLastToken() {
        return this.tokens[this.tokens.length - 1];
    }

    protected TypeBinding getTypeBinding(Scope var1) {
        if (this.resolvedType != null) {
            return this.resolvedType;
        } else {
            Binding var2 = var1.method_615(this.tokens);
            if (var2 != null && !var2.isValidBinding()) {
                if (var2 instanceof ProblemReferenceBinding && var2.problemId() == 1) {
                    ProblemReferenceBinding var11 = (ProblemReferenceBinding)var2;
                    Binding var12 = var1.method_620(this.tokens);
                    ProblemReferenceBinding var10000 = new ProblemReferenceBinding(var11.compoundName, var12 instanceof PackageBinding ? null : var1.environment().createMissingType((PackageBinding)null, this.tokens), 1);
                    return var10000;
                } else {
                    return (ReferenceBinding)var2;
                }
            } else {
                PackageBinding var3 = var2 == null ? null : (PackageBinding)var2;
                boolean var4 = var1.kind == 3;
                Object var5 = null;
                int var6 = var3 == null ? 0 : var3.compoundName.length;
                int var7 = this.tokens.length;
                for (int var8 = var7 - 1; var6 < var7; ++var6) {
                    this.method_1030(var6, var1, var3);
                    if (!this.resolvedType.isValidBinding()) {
                        return this.resolvedType;
                    }
                    if (var6 == 0 && this.resolvedType.method_169() && ((TypeVariableBinding)this.resolvedType).firstBound == null) {
                        var1.problemReporter().method_1567((TypeVariableBinding)this.resolvedType, this);
                        return null;
                    }
                    if (var6 < var8 && this.isTypeUseDeprecated(this.resolvedType, var1)) {
                        this.reportDeprecatedType(this.resolvedType, var1);
                    }
                    if (var4 && ((ClassScope)var1).detectHierarchyCycle(this.resolvedType, this)) {
                        return null;
                    }
                    ReferenceBinding var9 = (ReferenceBinding)this.resolvedType;
                    if (var5 != null) {
                        if (var9.method_155()) {
                            var5 = var1.environment().createRawType(var9, (ReferenceBinding)var5);
                        } else {
                            boolean var10;
                            if ((var10 = ((ReferenceBinding)var5).method_166()) && !var9.method_226()) {
                                var5 = var1.environment().createRawType((ReferenceBinding)var9.erasure(), (ReferenceBinding)var5);
                            } else if ((var10 || ((ReferenceBinding)var5).method_162()) && ((ReferenceBinding)var5).erasure() == var9.enclosingType().erasure()) {
                                var5 = var1.environment().createParameterizedType((ReferenceBinding)var9.erasure(), (TypeBinding[])null, (ReferenceBinding)var5);
                            } else {
                                var5 = var9;
                            }
                        }
                    } else {
                        var5 = var9.method_155() ? (ReferenceBinding)var1.environment().convertToRawType(var9, false) : var9;
                    }
                }
                this.resolvedType = (TypeBinding)var5;
                return this.resolvedType;
            }
        }
    }

    public char[][] getTypeName() {
        return this.tokens;
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

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
