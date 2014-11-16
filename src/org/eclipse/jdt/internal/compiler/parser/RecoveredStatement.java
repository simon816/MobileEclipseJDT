package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;

public class RecoveredStatement extends RecoveredElement {

    public Statement statement;

    public RecoveredStatement(Statement var1, RecoveredElement var2, int var3) {
        super(var2, var3);
        this.statement = var1;
    }

    public ASTNode parseTree() {
        return this.statement;
    }

    public String toString(int var1) {
        return this.tabString(var1) + "Recovered statement:\n" + this.statement.print(var1 + 1, new StringBuffer(10));
    }

    public Statement method_1876() {
        return this.statement;
    }

    public void updateParseTree() {
        this.method_1876();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.statement.field_445 == 0) {
            this.statement.field_445 = var2;
        }
    }
}
