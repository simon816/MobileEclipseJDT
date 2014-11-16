package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class Statement extends ASTNode {

    public Statement() {
    }

    public abstract FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3);

    public void branchChainTo(BranchLabel var1) {}

    public boolean method_816(FlowInfo var1, BlockScope var2, boolean var3) {
        if ((var1.reachMode() & 1) != 0) {
            this.field_446 &= Integer.MAX_VALUE;
            boolean var4 = var1 == FlowInfo.DEAD_END;
            if (!var3 && var4) {
                var2.problemReporter().unreachableCode(this);
            }
            return var4;
        } else {
            return false;
        }
    }

    public void generateArguments(MethodBinding var1, Expression[] var2, BlockScope var3, CodeStream var4) {
        int var6;
        if (var1.method_374()) {
            TypeBinding[] var5 = var1.parameters;
            var6 = var5.length;
            int var7 = var6 - 1;
            for (int var8 = 0; var8 < var7; ++var8) {
                var2[var8].generateCode(var3, var4, true);
            }
            ArrayBinding var14 = (ArrayBinding)var5[var7];
            ArrayBinding var9 = (ArrayBinding)var1.parameters[var7].erasure();
            int var10 = var14.method_187().id;
            int var11 = var2 == null ? 0 : var2.length;
            if (var11 > var6) {
                var4.method_2188(var11 - var7);
                var4.newArray(var9);
                for (int var12 = var7; var12 < var11; ++var12) {
                    var4.method_2141();
                    var4.method_2188(var12 - var7);
                    var2[var12].generateCode(var3, var4, true);
                    var4.arrayAtPut(var10, false);
                }
            } else if (var11 == var6) {
                TypeBinding var15 = var2[var7].resolvedType;
                if (var15 != TypeBinding.field_187 && (var14.method_136() != var15.method_136() || !var15.isCompatibleWith(var14))) {
                    var4.method_2188(1);
                    var4.newArray(var9);
                    var4.method_2141();
                    var4.method_2188(0);
                    var2[var7].generateCode(var3, var4, true);
                    var4.arrayAtPut(var10, false);
                } else {
                    var2[var7].generateCode(var3, var4, true);
                }
            } else {
                var4.method_2188(0);
                var4.newArray(var9);
            }
        } else if (var2 != null) {
            int var13 = 0;
            for (var6 = var2.length; var13 < var6; ++var13) {
                var2[var13].generateCode(var3, var4, true);
            }
        }
    }

    public abstract void generateCode(BlockScope var1, CodeStream var2);

    public boolean isEmptyBlock() {
        return false;
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        return this.printStatement(var1, var2);
    }

    public abstract StringBuffer printStatement(int var1, StringBuffer var2);

    public abstract void resolve(BlockScope var1);

    public Constant resolveCase(BlockScope var1, TypeBinding var2, SwitchStatement var3) {
        this.resolve(var1);
        return Constant.NotAConstant;
    }
}
