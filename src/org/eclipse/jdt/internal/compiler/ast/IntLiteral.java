package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.DoubleConstant;
import org.eclipse.jdt.internal.compiler.impl.IntConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

public class IntLiteral extends NumberLiteral {

    public int value;

    public static final IntLiteral One;

    static final Constant field_798;

    public IntLiteral(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public IntLiteral(char[] var1, int var2, int var3, int var4) {
        this(var1, var2, var3);
        this.value = var4;
    }

    public void computeConstant() {
        long var1 = 2147483647L;
        if (this == One) {
            this.constant = IntConstant.fromValue(1);
        } else {
            int var3 = this.source.length;
            long var4 = 0L;
            if (this.source[0] == 48) {
                var1 = 4294967295L;
                if (var3 == 1) {
                    this.constant = IntConstant.fromValue(0);
                    return;
                }
                byte var6;
                byte var7;
                int var8;
                if (this.source[1] != 120 && this.source[1] != 88) {
                    var6 = 3;
                    var8 = 1;
                    var7 = 8;
                } else {
                    var6 = 4;
                    var8 = 2;
                    var7 = 16;
                }
                while (this.source[var8] == 48) {
                    ++var8;
                    if (var8 == var3) {
                        this.constant = IntConstant.fromValue(this.value = (int)var4);
                        return;
                    }
                }
                while (var8 < var3) {
                    int var9;
                    if ((var9 = ScannerHelper.digit(this.source[var8++], var7)) < 0) {
                        this.constant = field_798;
                        return;
                    }
                    var4 = var4 << var6 | (long)var9;
                    if (var4 > var1) {
                        return;
                    }
                }
            } else {
                for (int var10 = 0; var10 < var3; ++var10) {
                    int var11;
                    if ((var11 = ScannerHelper.digit(this.source[var10], 10)) < 0) {
                        this.constant = field_798;
                        return;
                    }
                    var4 = 10L * var4 + (long)var11;
                    if (var4 > var1) {
                        return;
                    }
                }
            }
            this.constant = IntConstant.fromValue(this.value = (int)var4);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.generateConstant(this.constant, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public TypeBinding literalType(BlockScope var1) {
        return TypeBinding.field_179;
    }

    public final boolean mayRepresentMIN_VALUE() {
        return this.source.length == 10 && this.source[0] == 50 && this.source[1] == 49 && this.source[2] == 52 && this.source[3] == 55 && this.source[4] == 52 && this.source[5] == 56 && this.source[6] == 51 && this.source[7] == 54 && this.source[8] == 52 && this.source[9] == 56 && (this.field_446 & 534773760) >> 21 == 0;
    }

    public TypeBinding resolveType(BlockScope var1) {
        TypeBinding var2 = super.resolveType(var1);
        if (this.constant == field_798) {
            this.constant = Constant.NotAConstant;
            var1.problemReporter().method_1511(this);
            this.resolvedType = null;
            return null;
        } else {
            return var2;
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return this.source == null ? var2.append(String.valueOf(this.value)) : super.printExpression(var1, var2);
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    static {
        IntLiteral var10000 = new IntLiteral(new char[] {'1'}, 0, 0, 1);
        One = var10000;
        field_798 = DoubleConstant.fromValue(Double.POSITIVE_INFINITY);
    }
}
