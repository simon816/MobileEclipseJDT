package org.eclipse.jdt.internal.compiler.batch;

import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.batch.Main;

class Main$1 implements ICompilerRequestor {

    int field_899;

    private final Main field_900;

    Main$1(Main var1) {
        this.field_900 = var1;
        this.field_899 = 0;
    }

    public void method_26(CompilationResult var1) {
        int var2;
        if (var1.field_1684 != null) {
            var2 = var1.field_1684.length;
            this.field_899 += var2;
            if (this.field_900.field_1036 && this.field_899 > 2000) {
                this.field_900.logger.method_1253();
                this.field_899 = 0;
            }
        }
        this.field_900.logger.method_1269(var1);
        if (var1.method_2925() || var1.method_2926()) {
            var2 = this.field_900.logger.method_1251(var1.method_2916(), var1.field_1677.method_51(), this.field_900);
            if (this.field_900.field_1039 && !this.field_900.field_1032 && var2 > 0) {
                CompilationUnitDeclaration[] var3 = this.field_900.batchCompiler.field_1705;
                int var4 = 0;
                for (int var5 = this.field_900.batchCompiler.field_1706; var4 < var5; ++var4) {
                    CompilationUnitDeclaration var6 = var3[var4];
                    if (var6 != null) {
                        CompilationResult var7 = var6.field_455;
                        if (var7.method_2925() && !var7.field_1689) {
                            this.field_900.logger.method_1251(var7.method_2916(), var7.field_1677.method_51(), this.field_900);
                        }
                    }
                }
                this.field_900.logger.method_1233();
                this.field_900.logger.method_1234();
                this.field_900.logger.method_1265();
                this.field_900.logger.flush();
                this.field_900.logger.close();
                throw new RuntimeException("-1");
            }
        }
        this.field_900.method_1424(var1);
        this.field_900.logger.method_1233();
    }
}
