package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ArrayReference extends Reference {

    public Expression field_744;

    public Expression field_745;

    public ArrayReference(Expression var1, Expression var2) {
        this.field_744 = var1;
        this.field_745 = var2;
        this.field_444 = var1.field_444;
    }

    public FlowInfo analyseAssignment(BlockScope var1, FlowContext var2, FlowInfo var3, Assignment var4, boolean var5) {
        return var4.field_688 == null ? this.analyseCode(var1, var2, var3) : var4.field_688.analyseCode(var1, var2, this.analyseCode(var1, var2, var3).method_3109());
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        this.field_744.checkNPE(var1, var2, var3);
        var3 = this.field_744.analyseCode(var1, var2, var3);
        return this.field_745.analyseCode(var1, var2, var3);
    }

    public void generateAssignment(BlockScope var1, CodeStream var2, Assignment var3, boolean var4) {
        int var5 = var2.field_1208;
        this.field_744.generateCode(var1, var2, true);
        if (this.field_744 instanceof CastExpression && ((CastExpression)this.field_744).innermostCastedExpression().resolvedType == TypeBinding.field_187) {
            var2.method_2113(this.field_744.resolvedType);
        }
        var2.method_2360(var5, this.field_444);
        this.field_745.generateCode(var1, var2, true);
        var3.field_688.generateCode(var1, var2, true);
        var2.arrayAtPut(this.resolvedType.id, var4);
        if (var4) {
            var2.method_2182(var3.field_674);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        this.field_744.generateCode(var1, var2, true);
        if (this.field_744 instanceof CastExpression && ((CastExpression)this.field_744).innermostCastedExpression().resolvedType == TypeBinding.field_187) {
            var2.method_2113(this.field_744.resolvedType);
        }
        this.field_745.generateCode(var1, var2, true);
        var2.method_2099(this.resolvedType.id);
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            boolean var5 = (this.field_674 & 1024) != 0;
            if (var5) {
                var2.method_2182(this.field_674);
            }
            switch (var5 ? this.postConversionType(var1).id : this.resolvedType.id) {
                case 7:
                case 8:
                    var2.method_2353();
                    break;
                default:
                    var2.method_2352();
            }
        }
        var2.method_2360(var4, this.field_444);
    }

    public void generateCompoundAssignment(BlockScope var1, CodeStream var2, Expression var3, int var4, int var5, boolean var6) {
        this.field_744.generateCode(var1, var2, true);
        if (this.field_744 instanceof CastExpression && ((CastExpression)this.field_744).innermostCastedExpression().resolvedType == TypeBinding.field_187) {
            var2.method_2113(this.field_744.resolvedType);
        }
        this.field_745.generateCode(var1, var2, true);
        var2.method_2144();
        var2.method_2099(this.resolvedType.id);
        int var7;
        switch (var7 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.generateStringConcatenationAppend(var1, (Expression)null, var3);
                break;
            default:
                var2.method_2182(this.field_674);
                if (var3 == IntLiteral.One) {
                    var2.generateConstant(var3.constant, this.field_674);
                } else {
                    var3.generateCode(var1, var2, true);
                }
                var2.method_2374(var4, var7);
                var2.method_2182(var5);
        }
        var2.arrayAtPut(this.resolvedType.id, var6);
    }

    public void generatePostIncrement(BlockScope var1, CodeStream var2, CompoundAssignment var3, boolean var4) {
        this.field_744.generateCode(var1, var2, true);
        if (this.field_744 instanceof CastExpression && ((CastExpression)this.field_744).innermostCastedExpression().resolvedType == TypeBinding.field_187) {
            var2.method_2113(this.field_744.resolvedType);
        }
        this.field_745.generateCode(var1, var2, true);
        var2.method_2144();
        var2.method_2099(this.resolvedType.id);
        if (var4) {
            if (this.resolvedType != TypeBinding.field_183 && this.resolvedType != TypeBinding.field_185) {
                var2.method_2143();
            } else {
                var2.method_2146();
            }
        }
        var2.method_2182(this.field_674);
        var2.generateConstant(var3.field_688.constant, this.field_674);
        var2.method_2374(var3.field_689, this.field_674 & 15);
        var2.method_2182(var3.field_690);
        var2.arrayAtPut(this.resolvedType.id, false);
    }

    public int nullStatus(FlowInfo var1) {
        return 0;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        this.field_744.printExpression(0, var2).append('[');
        return this.field_745.printExpression(0, var2).append(']');
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        if (this.field_744 instanceof CastExpression && ((CastExpression)this.field_744).innermostCastedExpression() instanceof NullLiteral) {
            this.field_744.field_446 |= 32;
        }
        TypeBinding var2 = this.field_744.resolveType(var1);
        TypeBinding var3;
        if (var2 != null) {
            this.field_744.computeConversion(var1, var2, var2);
            if (var2.method_147()) {
                var3 = ((ArrayBinding)var2).method_187();
                this.resolvedType = (this.field_446 & 8192) == 0 ? var3.capture(var1, this.field_445) : var3;
            } else {
                var1.problemReporter().referenceMustBeArrayTypeAt(var2, this);
            }
        }
        var3 = this.field_745.resolveTypeExpecting(var1, TypeBinding.field_179);
        if (var3 != null) {
            this.field_745.computeConversion(var1, TypeBinding.field_179, var3);
        }
        return this.resolvedType;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_744.traverse(var1, var2);
            this.field_745.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
