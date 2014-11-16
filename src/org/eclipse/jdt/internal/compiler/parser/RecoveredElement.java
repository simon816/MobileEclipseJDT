package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredInitializer;
import org.eclipse.jdt.internal.compiler.parser.RecoveredMethod;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;
import org.eclipse.jdt.internal.compiler.parser.RecoveredBlock;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.util.Util;

public class RecoveredElement {

    public RecoveredElement parent;

    public int bracketBalance;

    public boolean foundOpeningBrace;

    protected Parser recoveringParser;

    public RecoveredElement(RecoveredElement var1, int var2) {
        this(var1, var2, (Parser)null);
    }

    public RecoveredElement(RecoveredElement var1, int var2, Parser var3) {
        this.parent = var1;
        this.bracketBalance = var2;
        this.recoveringParser = var3;
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var3 - 1));
            return this.parent.addAnnotationName(var1, var2, var3, var4);
        }
    }

    public RecoveredElement add(AbstractMethodDeclaration var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_480 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(Block var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_444 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(FieldDeclaration var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_653 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(ImportReference var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_470 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(LocalDeclaration var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_653 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(Statement var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_444 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        this.resetPendingModifiers();
        if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_592 - 1));
            return this.parent.add(var1, var2);
        }
    }

    protected void addBlockStatement(RecoveredBlock var1) {
        Block var2 = var1.blockDeclaration;
        if (var2.statements != null) {
            Statement[] var3 = var2.statements;
            for (int var4 = 0; var4 < var3.length; ++var4) {
                var1.add(var3[var4], 0);
            }
        }
    }

    public void addModifier(int var1, int var2) {}

    public RecoveredInitializer enclosingInitializer() {
        for (RecoveredElement var1 = this; var1 != null; var1 = var1.parent) {
            if (var1 instanceof RecoveredInitializer) {
                return (RecoveredInitializer)var1;
            }
        }
        return null;
    }

    public RecoveredMethod enclosingMethod() {
        for (RecoveredElement var1 = this; var1 != null; var1 = var1.parent) {
            if (var1 instanceof RecoveredMethod) {
                return (RecoveredMethod)var1;
            }
        }
        return null;
    }

    public RecoveredType enclosingType() {
        for (RecoveredElement var1 = this; var1 != null; var1 = var1.parent) {
            if (var1 instanceof RecoveredType) {
                return (RecoveredType)var1;
            }
        }
        return null;
    }

    public Parser parser() {
        for (RecoveredElement var1 = this; var1 != null; var1 = var1.parent) {
            if (var1.recoveringParser != null) {
                return var1.recoveringParser;
            }
        }
        return null;
    }

    public ASTNode parseTree() {
        return null;
    }

    public void resetPendingModifiers() {}

    public int previousAvailableLineEnd(int var1) {
        Parser var2 = this.parser();
        if (var2 == null) {
            return var1;
        } else {
            Scanner var3 = var2.scanner;
            if (var3.field_1256 == null) {
                return var1;
            } else {
                int var4 = Util.getLineNumber(var1, var3.field_1256, 0, var3.field_1257);
                if (var4 < 2) {
                    return var1;
                } else {
                    int var5 = var3.field_1256[var4 - 2];
                    char[] var6 = var3.field_1237;
                    for (int var7 = var5 + 1; var7 < var1; ++var7) {
                        if (var6[var7] != 32 && var6[var7] != 9) {
                            return var1;
                        }
                    }
                    return var5;
                }
            }
        }
    }

    protected String tabString(int var1) {
        StringBuffer var2 = new StringBuffer();
        for (int var3 = var1; var3 > 0; --var3) {
            var2.append("  ");
        }
        return var2.toString();
    }

    public RecoveredElement topElement() {
        RecoveredElement var1;
        for (var1 = this; var1.parent != null; var1 = var1.parent) {
            ;
        }
        return var1;
    }

    public String toString() {
        return this.toString(0);
    }

    public String toString(int var1) {
        return super.toString();
    }

    public void updateBodyStart(int var1) {
        this.foundOpeningBrace = true;
    }

    public void method_1852() {}

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (--this.bracketBalance <= 0 && this.parent != null) {
            this.updateSourceEndIfNecessary(var1, var2);
            return this.parent;
        } else {
            return this;
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        if (this.bracketBalance++ == 0) {
            this.updateBodyStart(var2 + 1);
            return this;
        } else {
            return null;
        }
    }

    public void updateParseTree() {}

    public void updateSourceEndIfNecessary(int var1, int var2) {}

    public void method_1857(int var1) {
        this.updateSourceEndIfNecessary(var1 + 1, var1);
    }
}
