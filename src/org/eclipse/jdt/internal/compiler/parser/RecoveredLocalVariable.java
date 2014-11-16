package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredStatement;

public class RecoveredLocalVariable extends RecoveredStatement {

    public RecoveredAnnotation[] annotations;

    public int field_1119;

    public int field_1120;

    public int field_1121;

    public LocalDeclaration localDeclaration;

    boolean alreadyCompletedLocalInitialization;

    public RecoveredLocalVariable(LocalDeclaration var1, RecoveredElement var2, int var3) {
        super(var1, var2, var3);
        this.localDeclaration = var1;
        this.alreadyCompletedLocalInitialization = var1.initialization != null;
    }

    public RecoveredElement add(Statement var1, int var2) {
        if (!this.alreadyCompletedLocalInitialization && var1 instanceof Expression) {
            this.alreadyCompletedLocalInitialization = true;
            this.localDeclaration.initialization = (Expression)var1;
            this.localDeclaration.field_652 = var1.field_445;
            this.localDeclaration.field_651 = var1.field_445;
            return this;
        } else {
            return super.add(var1, var2);
        }
    }

    public void attach(RecoveredAnnotation[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            Annotation[] var5 = this.localDeclaration.annotations;
            if (var5 != null) {
                this.annotations = new RecoveredAnnotation[var2];
                this.field_1119 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].annotation == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.annotations[this.field_1119++] = var1[var6];
                }
            } else {
                this.annotations = var1;
                this.field_1119 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1120 = var3;
            this.field_1121 = var4;
        }
    }

    public ASTNode parseTree() {
        return this.localDeclaration;
    }

    public String toString(int var1) {
        return this.tabString(var1) + "Recovered local variable:\n" + this.localDeclaration.print(var1 + 1, new StringBuffer(10));
    }

    public Statement method_1876() {
        if (this.field_1120 != 0) {
            this.localDeclaration.field_656 |= this.field_1120;
            if (this.field_1121 < this.localDeclaration.field_653) {
                this.localDeclaration.field_653 = this.field_1121;
            }
        }
        if (this.field_1119 > 0) {
            int var1 = this.localDeclaration.annotations == null ? 0 : this.localDeclaration.annotations.length;
            Annotation[] var2 = new Annotation[var1 + this.field_1119];
            if (var1 > 0) {
                System.arraycopy(this.localDeclaration.annotations, 0, var2, this.field_1119, var1);
            }
            int var3;
            for (var3 = 0; var3 < this.field_1119; ++var3) {
                var2[var3] = this.annotations[var3].updatedAnnotationReference();
            }
            this.localDeclaration.annotations = var2;
            var3 = this.annotations[0].annotation.field_444;
            if (var3 < this.localDeclaration.field_653) {
                this.localDeclaration.field_653 = var3;
            }
        }
        return this.localDeclaration;
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (this.bracketBalance > 0) {
            --this.bracketBalance;
            if (this.bracketBalance == 0) {
                this.alreadyCompletedLocalInitialization = true;
            }
            return this;
        } else {
            return (RecoveredElement)(this.parent != null ? this.parent.updateOnClosingBrace(var1, var2) : this);
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        if (this.localDeclaration.field_652 == 0 && (this.localDeclaration.type instanceof ArrayTypeReference || this.localDeclaration.type instanceof ArrayQualifiedTypeReference) && !this.alreadyCompletedLocalInitialization) {
            ++this.bracketBalance;
            return null;
        } else {
            this.updateSourceEndIfNecessary(var1 - 1, var2 - 1);
            return this.parent.method_1854(var1, var2);
        }
    }

    public void updateParseTree() {
        this.method_1876();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.localDeclaration.field_652 == 0) {
            this.localDeclaration.field_652 = var2;
            this.localDeclaration.field_651 = var2;
        }
    }
}
