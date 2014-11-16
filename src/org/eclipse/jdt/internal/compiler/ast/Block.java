package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class Block extends Statement {

    public Statement[] statements;

    public int explicitDeclarations;

    public BlockScope scope;

    public Block(int var1) {
        this.explicitDeclarations = var1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.statements == null) {
            return var3;
        } else {
            boolean var4 = false;
            int var5 = 0;
            for (int var6 = this.statements.length; var5 < var6; ++var5) {
                Statement var7 = this.statements[var5];
                if (!var7.method_816(var3, this.scope, var4)) {
                    var3 = var7.analyseCode(this.scope, var2, var3);
                } else {
                    var4 = true;
                }
            }
            return var3;
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.statements != null) {
                int var4 = 0;
                for (int var5 = this.statements.length; var4 < var5; ++var4) {
                    this.statements[var4].generateCode(this.scope, var2);
                }
            }
            if (this.scope != var1) {
                var2.exitUserScope(this.scope);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public boolean isEmptyBlock() {
        return this.statements == null;
    }

    public StringBuffer method_841(int var1, StringBuffer var2) {
        if (this.statements == null) {
            return var2;
        } else {
            for (int var3 = 0; var3 < this.statements.length; ++var3) {
                this.statements[var3].printStatement(var1 + 1, var2);
                var2.append('\n');
            }
            return var2;
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2);
        var2.append("{\n");
        this.method_841(var1, var2);
        return method_759(var1, var2).append('}');
    }

    public void resolve(BlockScope var1) {
        if ((this.field_446 & 8) != 0) {
            var1.problemReporter().method_1783(this.field_444, this.field_445);
        }
        if (this.statements != null) {
            BlockScope var10001;
            if (this.explicitDeclarations == 0) {
                var10001 = var1;
            } else {
                var10001 = new BlockScope(var1, this.explicitDeclarations);
            }
            this.scope = var10001;
            int var2 = 0;
            for (int var3 = this.statements.length; var2 < var3; ++var2) {
                this.statements[var2].resolve(this.scope);
            }
        }
    }

    public void method_842(BlockScope var1) {
        if ((this.field_446 & 8) != 0) {
            var1.problemReporter().method_1783(this.field_444, this.field_445);
        }
        this.scope = var1;
        if (this.statements != null) {
            int var2 = 0;
            for (int var3 = this.statements.length; var2 < var3; ++var2) {
                this.statements[var2].resolve(this.scope);
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.statements != null) {
            int var3 = 0;
            for (int var4 = this.statements.length; var3 < var4; ++var3) {
                this.statements[var3].traverse(var1, this.scope);
            }
        }
        var1.endVisit(this, var2);
    }

    public void branchChainTo(BranchLabel var1) {
        if (this.statements != null) {
            this.statements[this.statements.length - 1].branchChainTo(var1);
        }
    }
}
