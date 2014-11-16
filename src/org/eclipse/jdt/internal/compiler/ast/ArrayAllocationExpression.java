package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ArrayAllocationExpression extends Expression {

    public TypeReference type;

    public Expression[] dimensions;

    public ArrayInitializer initializer;

    public ArrayAllocationExpression() {
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        int var4 = 0;
        for (int var5 = this.dimensions.length; var4 < var5; ++var4) {
            Expression var6;
            if ((var6 = this.dimensions[var4]) != null) {
                var3 = var6.analyseCode(var1, var2, var3);
            }
        }
        if (this.initializer != null) {
            return this.initializer.analyseCode(var1, var2, var3);
        } else {
            return var3;
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.initializer != null) {
            this.initializer.generateCode(var1, var2, var3);
        } else {
            int var5 = 0;
            int var6 = 0;
            Expression var8;
            for (int var7 = this.dimensions.length; var6 < var7 && (var8 = this.dimensions[var6]) != null; ++var6) {
                var8.generateCode(var1, var2, true);
                ++var5;
            }
            if (var5 == 1) {
                var2.newArray((ArrayBinding)this.resolvedType);
            } else {
                var2.multianewarray(this.resolvedType, var5);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            } else {
                var2.method_2352();
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append("new ");
        this.type.print(0, var2);
        for (int var3 = 0; var3 < this.dimensions.length; ++var3) {
            if (this.dimensions[var3] == null) {
                var2.append("[]");
            } else {
                var2.append('[');
                this.dimensions[var3].printExpression(0, var2);
                var2.append(']');
            }
        }
        if (this.initializer != null) {
            this.initializer.printExpression(0, var2);
        }
        return var2;
    }

    public TypeBinding resolveType(BlockScope var1) {
        TypeBinding var2 = this.type.resolveType(var1, true);
        this.constant = Constant.NotAConstant;
        if (var2 == TypeBinding.field_188) {
            var1.problemReporter().method_1490(this);
            var2 = null;
        }
        int var3 = -1;
        int var4 = this.dimensions.length;
        while (true) {
            --var4;
            if (var4 < 0) {
                break;
            }
            if (this.dimensions[var4] != null) {
                if (var3 < 0) {
                    var3 = var4;
                }
            } else if (var3 > 0) {
                var1.problemReporter().incorrectLocationForNonEmptyDimension(this, var3);
                break;
            }
        }
        if (this.initializer == null) {
            if (var3 < 0) {
                var1.problemReporter().method_1685(this);
            }
            if (var2 != null && !var2.method_167()) {
                var1.problemReporter().method_1571(var2, this);
            }
        } else if (var3 >= 0) {
            var1.problemReporter().method_1494(this);
        }
        for (var4 = 0; var4 <= var3; ++var4) {
            Expression var5;
            if ((var5 = this.dimensions[var4]) != null) {
                TypeBinding var6 = var5.resolveTypeExpecting(var1, TypeBinding.field_179);
                if (var6 != null) {
                    this.dimensions[var4].computeConversion(var1, TypeBinding.field_179, var6);
                }
            }
        }
        if (var2 != null) {
            if (this.dimensions.length > 255) {
                var1.problemReporter().method_1768(this);
            }
            this.resolvedType = var1.createArrayType(var2, this.dimensions.length);
            if (this.initializer != null && this.initializer.resolveTypeExpecting(var1, this.resolvedType) != null) {
                this.initializer.binding = (ArrayBinding)this.resolvedType;
            }
            if ((var2.tagBits & 128L) != 0L) {
                return null;
            }
        }
        return this.resolvedType;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            int var3 = this.dimensions.length;
            this.type.traverse(var1, var2);
            for (int var4 = 0; var4 < var3; ++var4) {
                if (this.dimensions[var4] != null) {
                    this.dimensions[var4].traverse(var1, var2);
                }
            }
            if (this.initializer != null) {
                this.initializer.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
