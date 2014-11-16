package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class RecoveredField extends RecoveredElement {

    public FieldDeclaration fieldDeclaration;

    boolean alreadyCompletedFieldInitialization;

    public RecoveredAnnotation[] annotations;

    public int field_1076;

    public int field_1077;

    public int field_1078;

    public RecoveredType[] anonymousTypes;

    public int field_1080;

    public RecoveredField(FieldDeclaration var1, RecoveredElement var2, int var3) {
        this(var1, var2, var3, (Parser)null);
    }

    public RecoveredField(FieldDeclaration var1, RecoveredElement var2, int var3, Parser var4) {
        super(var2, var3, var4);
        this.fieldDeclaration = var1;
        this.alreadyCompletedFieldInitialization = var1.initialization != null;
    }

    public RecoveredElement add(Statement var1, int var2) {
        if (!this.alreadyCompletedFieldInitialization && var1 instanceof Expression) {
            this.alreadyCompletedFieldInitialization = true;
            this.fieldDeclaration.initialization = (Expression)var1;
            this.fieldDeclaration.field_652 = var1.field_445;
            this.fieldDeclaration.field_651 = var1.field_445;
            return this;
        } else {
            return super.add(var1, var2);
        }
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        if (!this.alreadyCompletedFieldInitialization && (var1.field_446 & 512) != 0 && (this.fieldDeclaration.field_652 == 0 || var1.field_444 <= this.fieldDeclaration.field_652)) {
            if (this.anonymousTypes == null) {
                this.anonymousTypes = new RecoveredType[5];
                this.field_1080 = 0;
            } else if (this.field_1080 == this.anonymousTypes.length) {
                System.arraycopy(this.anonymousTypes, 0, this.anonymousTypes = new RecoveredType[2 * this.field_1080], 0, this.field_1080);
            }
            RecoveredType var10000 = new RecoveredType(var1, this, var2);
            RecoveredType var3 = var10000;
            this.anonymousTypes[this.field_1080++] = var3;
            return var3;
        } else {
            return super.add(var1, var2);
        }
    }

    public void attach(RecoveredAnnotation[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            Annotation[] var5 = this.fieldDeclaration.annotations;
            if (var5 != null) {
                this.annotations = new RecoveredAnnotation[var2];
                this.field_1076 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].annotation == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.annotations[this.field_1076++] = var1[var6];
                }
            } else {
                this.annotations = var1;
                this.field_1076 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1077 = var3;
            this.field_1078 = var4;
        }
    }

    public ASTNode parseTree() {
        return this.fieldDeclaration;
    }

    public String toString(int var1) {
        StringBuffer var2 = new StringBuffer(this.tabString(var1));
        var2.append("Recovered field:\n");
        this.fieldDeclaration.print(var1 + 1, var2);
        int var3;
        if (this.annotations != null) {
            for (var3 = 0; var3 < this.field_1076; ++var3) {
                var2.append("\n");
                var2.append(this.annotations[var3].toString(var1 + 1));
            }
        }
        if (this.anonymousTypes != null) {
            for (var3 = 0; var3 < this.field_1080; ++var3) {
                var2.append("\n");
                var2.append(this.anonymousTypes[var3].toString(var1 + 1));
            }
        }
        return var2.toString();
    }

    public FieldDeclaration method_1863() {
        if (this.field_1077 != 0) {
            this.fieldDeclaration.field_656 |= this.field_1077;
            if (this.field_1078 < this.fieldDeclaration.field_653) {
                this.fieldDeclaration.field_653 = this.field_1078;
            }
        }
        int var1;
        if (this.field_1076 > 0) {
            var1 = this.fieldDeclaration.annotations == null ? 0 : this.fieldDeclaration.annotations.length;
            Annotation[] var2 = new Annotation[var1 + this.field_1076];
            if (var1 > 0) {
                System.arraycopy(this.fieldDeclaration.annotations, 0, var2, this.field_1076, var1);
            }
            int var3;
            for (var3 = 0; var3 < this.field_1076; ++var3) {
                var2[var3] = this.annotations[var3].updatedAnnotationReference();
            }
            this.fieldDeclaration.annotations = var2;
            var3 = this.annotations[0].annotation.field_444;
            if (var3 < this.fieldDeclaration.field_653) {
                this.fieldDeclaration.field_653 = var3;
            }
        }
        if (this.anonymousTypes != null) {
            RecoveredType var6;
            TypeDeclaration var7;
            if (this.fieldDeclaration.initialization == null) {
                for (var1 = 0; var1 < this.field_1080; ++var1) {
                    var6 = this.anonymousTypes[var1];
                    var7 = var6.typeDeclaration;
                    if (var7.field_593 == 0) {
                        var7.field_593 = this.fieldDeclaration.field_652;
                        var7.field_595 = this.fieldDeclaration.field_652;
                    }
                    if (var6.field_1135) {
                        TypeDeclaration var4 = var6.method_1884();
                        this.fieldDeclaration.initialization = var4.allocation;
                        if (this.fieldDeclaration.field_652 == 0) {
                            int var5 = var4.field_593;
                            this.fieldDeclaration.field_652 = var5;
                            this.fieldDeclaration.field_651 = var5;
                        }
                    }
                }
                if (this.field_1080 > 0) {
                    this.fieldDeclaration.field_446 |= 2;
                }
            } else if (this.fieldDeclaration.getKind() == 3) {
                for (var1 = 0; var1 < this.field_1080; ++var1) {
                    var6 = this.anonymousTypes[var1];
                    var7 = var6.typeDeclaration;
                    if (var7.field_593 == 0) {
                        var7.field_593 = this.fieldDeclaration.field_652;
                        var7.field_595 = this.fieldDeclaration.field_652;
                    }
                    var6.method_1884();
                }
            }
        }
        return this.fieldDeclaration;
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (this.bracketBalance > 0) {
            --this.bracketBalance;
            if (this.bracketBalance == 0) {
                if (this.fieldDeclaration.getKind() == 3) {
                    this.method_1857(var2 - 1);
                    return this.parent;
                }
                this.alreadyCompletedFieldInitialization = true;
            }
            return this;
        } else {
            if (this.bracketBalance == 0) {
                this.alreadyCompletedFieldInitialization = true;
                this.method_1857(var2 - 1);
            }
            return (RecoveredElement)(this.parent != null ? this.parent.updateOnClosingBrace(var1, var2) : this);
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        if (this.fieldDeclaration.field_652 == 0 && (this.fieldDeclaration.type instanceof ArrayTypeReference || this.fieldDeclaration.type instanceof ArrayQualifiedTypeReference) && !this.alreadyCompletedFieldInitialization) {
            ++this.bracketBalance;
            return null;
        } else if (this.fieldDeclaration.field_652 == 0 && this.fieldDeclaration.getKind() == 3) {
            ++this.bracketBalance;
            return null;
        } else {
            this.updateSourceEndIfNecessary(var1 - 1, var2 - 1);
            return this.parent.method_1854(var1, var2);
        }
    }

    public void updateParseTree() {
        this.method_1863();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.fieldDeclaration.field_652 == 0) {
            this.fieldDeclaration.field_652 = var2;
            this.fieldDeclaration.field_651 = var2;
        }
    }
}
