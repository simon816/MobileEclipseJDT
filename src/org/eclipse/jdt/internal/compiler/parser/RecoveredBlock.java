package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredInitializer;
import org.eclipse.jdt.internal.compiler.parser.RecoveredMethod;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredStatement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredLocalVariable;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;

public class RecoveredBlock extends RecoveredStatement {

    public Block blockDeclaration;

    public RecoveredStatement[] statements;

    public int statementCount;

    public boolean preserveContent;

    public RecoveredLocalVariable pendingArgument;

    int field_1149;

    int field_1150;

    RecoveredAnnotation[] pendingAnnotations;

    int field_1152;

    public RecoveredBlock(Block var1, RecoveredElement var2, int var3) {
        super(var1, var2, var3);
        this.preserveContent = false;
        this.field_1150 = -1;
        this.blockDeclaration = var1;
        this.foundOpeningBrace = true;
        this.preserveContent = this.parser().field_1621 || this.parser().field_1622;
    }

    public RecoveredElement add(AbstractMethodDeclaration var1, int var2) {
        if (this.parent != null && this.parent instanceof RecoveredMethod) {
            RecoveredMethod var3 = (RecoveredMethod)this.parent;
            if (var3.methodBody == this && var3.parent == null) {
                this.resetPendingModifiers();
                return this;
            }
        }
        return super.add(var1, var2);
    }

    public RecoveredElement add(Block var1, int var2) {
        this.resetPendingModifiers();
        if (this.blockDeclaration.field_445 != 0 && var1.field_444 > this.blockDeclaration.field_445) {
            return this.parent.add(var1, var2);
        } else {
            RecoveredBlock var10000 = new RecoveredBlock(var1, this, var2);
            RecoveredBlock var3 = var10000;
            if (this.pendingArgument != null) {
                var3.attach(this.pendingArgument);
                this.pendingArgument = null;
            }
            if (this.parser().field_1622) {
                this.addBlockStatement(var3);
            }
            this.attach(var3);
            return var1.field_445 == 0 ? var3 : this;
        }
    }

    public RecoveredElement add(LocalDeclaration var1, int var2) {
        return this.add(var1, var2, false);
    }

    public RecoveredElement add(LocalDeclaration var1, int var2, boolean var3) {
        if (this.blockDeclaration.field_445 != 0 && var1.field_653 > this.blockDeclaration.field_445) {
            this.resetPendingModifiers();
            return (RecoveredElement)(var3 ? this : this.parent.add(var1, var2));
        } else {
            RecoveredLocalVariable var10000 = new RecoveredLocalVariable(var1, this, var2);
            RecoveredLocalVariable var4 = var10000;
            if (this.field_1152 > 0) {
                var4.attach(this.pendingAnnotations, this.field_1152, this.field_1149, this.field_1150);
            }
            this.resetPendingModifiers();
            if (var1 instanceof Argument) {
                this.pendingArgument = var4;
                return this;
            } else {
                this.attach(var4);
                if (var1.field_652 == 0) {
                    return var4;
                }
                return this;
            }
        }
    }

    public RecoveredElement add(Statement var1, int var2) {
        return this.add(var1, var2, false);
    }

    public RecoveredElement add(Statement var1, int var2, boolean var3) {
        this.resetPendingModifiers();
        if (this.blockDeclaration.field_445 != 0 && var1.field_444 > this.blockDeclaration.field_445) {
            return (RecoveredElement)(var3 ? this : this.parent.add(var1, var2));
        } else {
            RecoveredStatement var10000 = new RecoveredStatement(var1, this, var2);
            RecoveredStatement var4 = var10000;
            this.attach(var4);
            if (var1.field_445 == 0) {
                return var4;
            }
            return this;
        }
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        return this.add(var1, var2, false);
    }

    public RecoveredElement add(TypeDeclaration var1, int var2, boolean var3) {
        if (this.blockDeclaration.field_445 != 0 && var1.field_592 > this.blockDeclaration.field_445) {
            this.resetPendingModifiers();
            return (RecoveredElement)(var3 ? this : this.parent.add(var1, var2));
        } else {
            RecoveredType var10000 = new RecoveredType(var1, this, var2);
            RecoveredType var4 = var10000;
            if (this.field_1152 > 0) {
                var4.attach(this.pendingAnnotations, this.field_1152, this.field_1149, this.field_1150);
            }
            this.resetPendingModifiers();
            this.attach(var4);
            if (var1.field_593 == 0) {
                return var4;
            }
            return this;
        }
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        if (this.pendingAnnotations == null) {
            this.pendingAnnotations = new RecoveredAnnotation[5];
            this.field_1152 = 0;
        } else if (this.field_1152 == this.pendingAnnotations.length) {
            System.arraycopy(this.pendingAnnotations, 0, this.pendingAnnotations = new RecoveredAnnotation[2 * this.field_1152], 0, this.field_1152);
        }
        RecoveredAnnotation var10000 = new RecoveredAnnotation(var1, var2, var3, this, var4);
        RecoveredAnnotation var5 = var10000;
        this.pendingAnnotations[this.field_1152++] = var5;
        return var5;
    }

    public void addModifier(int var1, int var2) {
        this.field_1149 |= var1;
        if (this.field_1150 < 0) {
            this.field_1150 = var2;
        }
    }

    void attach(RecoveredStatement var1) {
        if (this.statements == null) {
            this.statements = new RecoveredStatement[5];
            this.statementCount = 0;
        } else if (this.statementCount == this.statements.length) {
            System.arraycopy(this.statements, 0, this.statements = new RecoveredStatement[2 * this.statementCount], 0, this.statementCount);
        }
        this.statements[this.statementCount++] = var1;
    }

    void attachPendingModifiers(RecoveredAnnotation[] var1, int var2, int var3, int var4) {
        this.pendingAnnotations = var1;
        this.field_1152 = var2;
        this.field_1149 = var3;
        this.field_1150 = var4;
    }

    public ASTNode parseTree() {
        return this.blockDeclaration;
    }

    public void resetPendingModifiers() {
        this.pendingAnnotations = null;
        this.field_1152 = 0;
        this.field_1149 = 0;
        this.field_1150 = -1;
    }

    public String toString(int var1) {
        StringBuffer var2 = new StringBuffer(this.tabString(var1));
        var2.append("Recovered block:\n");
        this.blockDeclaration.print(var1 + 1, var2);
        if (this.statements != null) {
            for (int var3 = 0; var3 < this.statementCount; ++var3) {
                var2.append("\n");
                var2.append(this.statements[var3].toString(var1 + 1));
            }
        }
        return var2.toString();
    }

    public Block method_1891() {
        if (this.preserveContent && this.statementCount != 0) {
            Statement[] var1 = new Statement[this.statementCount];
            int var2 = 0;
            RecoveredStatement var3 = this.statements[this.statementCount - 1];
            RecoveredMethod var4 = this.enclosingMethod();
            RecoveredInitializer var5 = this.enclosingInitializer();
            boolean var6 = false;
            int var11;
            if (var4 != null) {
                var11 = var4.methodDeclaration.field_491;
                if (var5 != null && var4.methodDeclaration.field_444 < var5.fieldDeclaration.field_444) {
                    var11 = var5.fieldDeclaration.field_652;
                }
            } else if (var5 != null) {
                var11 = var5.fieldDeclaration.field_652;
            } else {
                var11 = this.blockDeclaration.field_445 - 1;
            }
            if (var3 instanceof RecoveredLocalVariable) {
                RecoveredLocalVariable var7 = (RecoveredLocalVariable)var3;
                if (var7.localDeclaration.field_652 == 0) {
                    var7.localDeclaration.field_652 = var11;
                    var7.localDeclaration.field_651 = var11;
                }
            } else if (var3 instanceof RecoveredBlock) {
                RecoveredBlock var12 = (RecoveredBlock)var3;
                if (var12.blockDeclaration.field_445 == 0) {
                    var12.blockDeclaration.field_445 = var11;
                }
            } else if (!(var3 instanceof RecoveredType) && var3.statement.field_445 == 0) {
                var3.statement.field_445 = var11;
            }
            int var13 = this.blockDeclaration.field_444;
            for (int var8 = 0; var8 < this.statementCount; ++var8) {
                Statement var9 = this.statements[var8].method_1876();
                if (var9 != null) {
                    var1[var2++] = var9;
                    if (var9 instanceof LocalDeclaration) {
                        LocalDeclaration var10 = (LocalDeclaration)var9;
                        if (var10.field_652 > var13) {
                            var13 = var10.field_652;
                        }
                    } else if (var9 instanceof TypeDeclaration) {
                        TypeDeclaration var14 = (TypeDeclaration)var9;
                        if (var14.field_593 > var13) {
                            var13 = var14.field_593;
                        }
                    } else if (var9.field_445 > var13) {
                        var13 = var9.field_445;
                    }
                }
            }
            if (var2 == 0) {
                return null;
            } else {
                if (var2 != this.statementCount) {
                    this.blockDeclaration.statements = new Statement[var2];
                    System.arraycopy(var1, 0, this.blockDeclaration.statements, 0, var2);
                } else {
                    this.blockDeclaration.statements = var1;
                }
                if (this.blockDeclaration.field_445 == 0) {
                    if (var13 < var11) {
                        this.blockDeclaration.field_445 = var11;
                    } else {
                        this.blockDeclaration.field_445 = var13;
                    }
                }
                return this.blockDeclaration;
            }
        } else {
            return null;
        }
    }

    public Statement method_1876() {
        return this.method_1891();
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (--this.bracketBalance <= 0 && this.parent != null) {
            this.updateSourceEndIfNecessary(var1, var2);
            RecoveredMethod var3 = this.enclosingMethod();
            if (var3 != null && var3.methodBody == this) {
                return this.parent.updateOnClosingBrace(var1, var2);
            } else {
                RecoveredInitializer var4 = this.enclosingInitializer();
                return var4 != null && var4.initializerBody == this ? this.parent.updateOnClosingBrace(var1, var2) : this.parent;
            }
        } else {
            return this;
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        Block var10000 = new Block(0);
        Block var3 = var10000;
        var3.field_444 = this.parser().scanner.field_1230;
        return this.add(var3, 1);
    }

    public void updateParseTree() {
        this.method_1891();
    }

    public RecoveredElement add(FieldDeclaration var1, int var2) {
        this.resetPendingModifiers();
        char[][] var3;
        if ((var1.field_656 & -17) == 0 && var1.type != null && ((var3 = var1.type.getTypeName()).length != 1 || !CharOperation.method_1364(var3[0], TypeBinding.field_188.method_179()))) {
            return (RecoveredElement)(this.blockDeclaration.field_445 != 0 && var1.field_653 > this.blockDeclaration.field_445 ? this.parent.add(var1, var2) : this);
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_653 - 1));
            return this.parent.add(var1, var2);
        }
    }
}
