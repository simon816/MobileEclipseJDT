package org.eclipse.jdt.internal.compiler.batch;

import java.io.File;

import java.io.IOException;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.util.Util;

public class CompilationUnit implements ICompilationUnit {

    public char[] field_1007;

    public String field_1008;

    public char[] field_1009;

    String encoding;

    public String field_1011;

    public CompilationUnit(char[] var1, String var2, String var3, String var4) {
        this.field_1007 = var1;
        char[] var5 = var2.toCharArray();
        switch (47) {
            case 47:
                if (CharOperation.method_1371('\\', var5) != -1) {
                    CharOperation.replace(var5, '\\', '/');
                }
                break;
            case 92:
                if (CharOperation.method_1371('/', var5) != -1) {
                    CharOperation.replace(var5, '/', '\\');
                }
        }
        this.field_1008 = var2;
        int var6 = CharOperation.method_1376('/', var5) + 1;
        int var7 = CharOperation.method_1376('.', var5);
        if (var7 == -1) {
            var7 = var5.length;
        }
        this.field_1009 = CharOperation.subarray(var5, var6, var7);
        this.encoding = var3;
        this.field_1011 = var4;
    }

    public char[] getContents() {
        if (this.field_1007 != null) {
            return this.field_1007;
        } else {
            try {
                File var3 = new File(this.field_1008);
                return Util.method_1320(var3, this.encoding);
            } catch (IOException var2) {
                this.field_1007 = CharOperation.NO_CHAR;
                AbortCompilationUnit var10000 = new AbortCompilationUnit((CompilationResult)null, var2, this.encoding);
                throw var10000;
            }
        }
    }

    public String method_50() {
        return this.field_1008;
    }

    public char[] method_52() {
        return this.field_1009;
    }

    public char[][] getPackageName() {
        return (char[][])null;
    }

    public String toString() {
        return "CompilationUnit[" + this.field_1008 + "]";
    }
}
