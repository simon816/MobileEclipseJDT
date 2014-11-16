package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class SynchronizedStatement extends SubRoutineStatement {

    public Expression expression;

    public Block block;

    public BlockScope scope;

    public LocalVariableBinding synchroVariable;

    static final char[] SecretLocalDeclarationName;

    int field_645;

    int field_646;

    public SynchronizedStatement(Expression var1, Block var2, int var3, int var4) {
        this.field_645 = -1;
        this.field_646 = -1;
        this.expression = var1;
        this.block = var2;
        this.field_445 = var4;
        this.field_444 = var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.field_645 = var1.method_635().recordInitializationStates(var3);
        this.synchroVariable.field_307 = 1;
        Block var10000 = this.block;
        BlockScope var10001 = this.scope;
        InsideSubRoutineFlowContext var10002 = new InsideSubRoutineFlowContext(var2, this);
        var3 = var10000.analyseCode(var10001, var10002, this.expression.analyseCode(this.scope, var2, var3));
        this.field_646 = var1.method_635().recordInitializationStates(var3);
        if ((var3.tagBits & 1) != 0) {
            this.field_446 |= 536870912;
        }
        return var3;
    }

    public boolean isSubRoutineEscaping() {
        return false;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            this.anyExceptionLabel = null;
            int var3 = var2.field_1208;
            this.expression.generateCode(this.scope, var2, true);
            if (this.block.isEmptyBlock()) {
                if (this.synchroVariable.type != TypeBinding.field_183 && this.synchroVariable.type != TypeBinding.field_185) {
                    var2.method_2141();
                } else {
                    var2.method_2144();
                }
                var2.method_2340();
                var2.method_2341();
                if (this.scope != var1) {
                    var2.exitUserScope(this.scope);
                }
            } else {
                var2.store(this.synchroVariable, true);
                var2.addVariable(this.synchroVariable);
                var2.method_2340();
                this.enterAnyExceptionHandler(var2);
                this.block.generateCode(this.scope, var2);
                if (this.scope != var1) {
                    var2.exitUserScope(this.scope, this.synchroVariable);
                }
                BranchLabel var10000 = new BranchLabel(var2);
                BranchLabel var4 = var10000;
                if ((this.field_446 & 536870912) == 0) {
                    var2.load(this.synchroVariable);
                    var2.method_2341();
                    this.exitAnyExceptionHandler();
                    var2.method_2209(var4);
                    this.enterAnyExceptionHandler(var2);
                }
                var2.method_2355(this.scope.method_611());
                if (this.field_645 != -1) {
                    var2.method_2363(var1, this.field_645);
                }
                this.method_877();
                var2.load(this.synchroVariable);
                var2.method_2341();
                this.exitAnyExceptionHandler();
                var2.method_2107();
                if (this.field_646 != -1) {
                    var2.method_2363(var1, this.field_646);
                    var2.method_2088(var1, this.field_646);
                }
                if (this.scope != var1) {
                    var2.method_2365(this.synchroVariable);
                }
                if ((this.field_446 & 536870912) == 0) {
                    var4.place();
                }
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public boolean generateSubRoutineInvocation(BlockScope var1, CodeStream var2, Object var3, int var4, LocalVariableBinding var5) {
        var2.load(this.synchroVariable);
        var2.method_2341();
        this.exitAnyExceptionHandler();
        return false;
    }

    public void resolve(BlockScope var1) {
        BlockScope var10001 = new BlockScope(var1);
        this.scope = var10001;
        TypeBinding var2 = this.expression.resolveType(this.scope);
        if (var2 != null) {
            switch (var2.id) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    this.scope.problemReporter().method_1642(this.expression, var2);
                    break;
                case 6:
                    this.scope.problemReporter().method_1605(this.expression);
                case 11:
                default:
                    break;
                case 12:
                    this.scope.problemReporter().method_1633(this.expression);
            }
            LocalVariableBinding var3 = new LocalVariableBinding(SecretLocalDeclarationName, var2, 0, false);
            this.synchroVariable = var3;
            this.scope.addLocalVariable(this.synchroVariable);
            this.synchroVariable.setConstant(Constant.NotAConstant);
            this.expression.computeConversion(this.scope, var2, var2);
            this.block.method_842(this.scope);
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2);
        var2.append("synchronized (");
        this.expression.printExpression(0, var2).append(')');
        var2.append('\n');
        return this.block.printStatement(var1 + 1, var2);
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.expression.traverse(var1, this.scope);
            this.block.traverse(var1, this.scope);
        }
        var1.endVisit(this, var2);
    }

    static {
        SecretLocalDeclarationName = " syncValue".toCharArray();
    }
}
