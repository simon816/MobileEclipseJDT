package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.OperatorExpression;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class CompoundAssignment extends Assignment {

    public int field_689;

    public int field_690;

    public CompoundAssignment(Expression var1, Expression var2, int var3, int var4) {
        super(var1, var2, var4);
        var1.field_446 &= -8193;
        var1.field_446 |= 65536;
        this.field_689 = var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.resolvedType.id != 11) {
            this.field_687.checkNPE(var1, var2, var3);
        }
        return ((Reference)this.field_687).analyseAssignment(var1, var2, var3, this, true).method_3109();
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        ((Reference)this.field_687).generateCompoundAssignment(var1, var2, this.field_688, this.field_689, this.field_690, var3);
        if (var3) {
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public int nullStatus(FlowInfo var1) {
        return -1;
    }

    public String operatorToString() {
        switch (this.field_689) {
            case 2:
                return "&=";
            case 3:
                return "|=";
            case 4:
            case 5:
            case 6:
            case 7:
            case 11:
            case 12:
            case 18:
            default:
                return "unknown operator";
            case 8:
                return "^=";
            case 9:
                return "/=";
            case 10:
                return "<<=";
            case 13:
                return "-=";
            case 14:
                return "+=";
            case 15:
                return "*=";
            case 16:
                return "%=";
            case 17:
                return ">>=";
            case 19:
                return ">>>=";
        }
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        this.field_687.printExpression(var1, var2).append(' ').append(this.operatorToString()).append(' ');
        return this.field_688.printExpression(0, var2);
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        if (this.field_687 instanceof Reference && !this.field_687.method_755()) {
            TypeBinding var2 = this.field_687.resolveType(var1);
            TypeBinding var3 = this.field_688.resolveType(var1);
            if (var2 != null && var3 != null) {
                LookupEnvironment var4 = var1.environment();
                TypeBinding var5 = var2;
                TypeBinding var6 = var3;
                boolean var7 = var1.compilerOptions().field_1928 >= 3211264L;
                boolean var8 = false;
                if (var7) {
                    if (!var2.method_148() && var3.id != 11 && var3.id != 12) {
                        TypeBinding var9 = var4.method_486(var2);
                        if (var9 != var2) {
                            var5 = var9;
                            var8 = true;
                        }
                    }
                    if (!var3.method_148() && var5.id != 11 && var5.id != 12) {
                        var6 = var4.method_486(var3);
                    }
                }
                if (this.restrainUsageToNumericTypes() && !var5.method_161()) {
                    var1.problemReporter().method_1714(this, var5, var6);
                    return null;
                } else {
                    int var12 = var5.id;
                    int var10 = var6.id;
                    if (var12 > 15 || var10 > 15) {
                        if (var12 != 11) {
                            var1.problemReporter().method_1635(this, var5, var6);
                            return null;
                        }
                        var10 = 1;
                    }
                    int var11 = OperatorExpression.OperatorSignatures[this.field_689][(var12 << 4) + var10];
                    if (var11 == 0) {
                        var1.problemReporter().method_1635(this, var5, var6);
                        return null;
                    } else {
                        if (this.field_689 == 14) {
                            if (var12 == 1) {
                                var1.problemReporter().method_1635(this, var5, var6);
                                return null;
                            }
                            if ((var5.method_161() || var12 == 5) && !var6.method_161()) {
                                var1.problemReporter().method_1635(this, var5, var6);
                                return null;
                            }
                        }
                        this.field_687.computeConversion(var1, TypeBinding.wellKnownType(var1, var11 >>> 16 & 15), var2);
                        this.field_688.computeConversion(var1, TypeBinding.wellKnownType(var1, var11 >>> 8 & 15), var3);
                        this.field_690 = (var8 ? 512 : 0) | var12 << 4 | var11 & 15;
                        if (var8) {
                            var1.problemReporter().method_1485(this, var5, var2);
                        }
                        return this.resolvedType = var2;
                    }
                }
            } else {
                return null;
            }
        } else {
            var1.problemReporter().method_1547(this.field_687);
            return null;
        }
    }

    public boolean restrainUsageToNumericTypes() {
        return false;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_687.traverse(var1, var2);
            this.field_688.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
