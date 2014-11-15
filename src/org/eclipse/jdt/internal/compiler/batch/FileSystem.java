package org.eclipse.jdt.internal.compiler.batch;

import java.util.Vector;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.batch.ClasspathDirectory;
import org.eclipse.jdt.internal.compiler.batch.ClasspathJar;
import org.eclipse.jdt.internal.compiler.batch.FileSystem$Classpath;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.util.SuffixConstants;
import org.eclipse.jdt.internal.compiler.util.Util;

public class FileSystem implements SuffixConstants, INameEnvironment {

    FileSystem$Classpath[] field_1044;

    Vector field_1045;

    FileSystem(FileSystem$Classpath[] var1, String[] var2) {
        int var3 = var1.length;
        int var4 = 0;
        this.field_1044 = new FileSystem$Classpath[var3];
        for (int var5 = 0; var5 < var3; ++var5) {
            FileSystem$Classpath var6 = var1[var5];
            var6.method_18();
            this.field_1044[var4++] = var6;
        }
        if (var4 != var3) {
            System.arraycopy(this.field_1044, 0, this.field_1044 = new FileSystem$Classpath[var4], 0, var4);
        }
        this.method_1429(var2);
    }

    private void method_1429(String[] var1) {
        if (var1 == null) {
            this.field_1045 = new Vector(0);
        } else {
            this.field_1045 = new Vector(var1.length * 2);
            int var2 = var1.length;
            while (true) {
                --var2;
                if (var2 < 0) {
                    return;
                }
                char[] var3 = var1[var2].toCharArray();
                char[] var4 = null;
                int var5 = CharOperation.method_1376('.', var3);
                if (var5 != -1) {
                    var3 = CharOperation.method_1388(var3, 0, var5);
                }
                CharOperation.method_1382(var3, '\\', '/');
                for (int var6 = 0; var6 < this.field_1044.length; ++var6) {
                    char[] var7 = this.field_1044[var6].method_17();
                    if (this.field_1044[var6] instanceof ClasspathDirectory && CharOperation.method_1381(var7, var3) && (var4 == null || var7.length < var4.length)) {
                        var4 = var7;
                    }
                }
                if (var4 == null) {
                    this.field_1045.addElement(new String(var3));
                } else {
                    this.field_1045.addElement(new String(CharOperation.method_1388(var3, var4.length, var3.length)));
                }
                Object var8 = null;
            }
        }
    }

    public void method_16() {
        int var1 = 0;
        for (int var2 = this.field_1044.length; var1 < var2; ++var1) {
            this.field_1044[var1].method_16();
        }
    }

    private NameEnvironmentAnswer method_1430(String var1, char[] var2, boolean var3) {
        if (this.field_1045.contains(var1)) {
            return null;
        } else {
            String var4 = var1 + ".class";
            String var5 = var1.length() == var2.length ? Util.field_982 : var4.substring(0, var1.length() - var2.length - 1);
            String var6 = var5;
            NameEnvironmentAnswer var7 = null;
            int var9;
            if (var5 == var5) {
                int var8 = 0;
                for (var9 = this.field_1044.length; var8 < var9; ++var8) {
                    NameEnvironmentAnswer var10 = this.field_1044[var8].method_14(var2, var5, var4, var3);
                    if (var10 != null) {
                        if (!var10.method_3190()) {
                            if (var10.method_3191(var7)) {
                                return var10;
                            }
                        } else if (var10.method_3191(var7)) {
                            var7 = var10;
                        }
                    }
                }
            } else {
                String var13 = var4.replace('/', '/');
                var9 = 0;
                for (int var14 = this.field_1044.length; var9 < var14; ++var9) {
                    FileSystem$Classpath var11 = this.field_1044[var9];
                    NameEnvironmentAnswer var12 = var11 instanceof ClasspathJar ? var11.method_14(var2, var5, var4, var3) : var11.method_14(var2, var6, var13, var3);
                    if (var12 != null) {
                        if (!var12.method_3190()) {
                            if (var12.method_3191(var7)) {
                                return var12;
                            }
                        } else if (var12.method_3191(var7)) {
                            var7 = var12;
                        }
                    }
                }
            }
            return var7 != null ? var7 : null;
        }
    }

    public NameEnvironmentAnswer method_80(char[][] var1) {
        return var1 != null ? this.method_1430(new String(CharOperation.method_1361(var1, '/')), var1[var1.length - 1], false) : null;
    }

    public NameEnvironmentAnswer method_81(char[] var1, char[][] var2) {
        return var1 != null ? this.method_1430(new String(CharOperation.method_1360(var2, var1, '/')), var1, false) : null;
    }

    public boolean method_82(char[][] var1, char[] var2) {
        String var3 = new String(CharOperation.method_1360(var1, var2, '/'));
        String var4 = var3;
        int var5;
        int var6;
        if (var3 == var3) {
            var5 = 0;
            for (var6 = this.field_1044.length; var5 < var6; ++var5) {
                if (this.field_1044[var5].method_15(var3)) {
                    return true;
                }
            }
        } else {
            var5 = 0;
            for (var6 = this.field_1044.length; var5 < var6; ++var5) {
                FileSystem$Classpath var7 = this.field_1044[var5];
                if (var7 instanceof ClasspathJar) {
                    if (var7.method_15(var3)) {
                        return true;
                    }
                } else if (var7.method_15(var4)) {
                    return true;
                }
            }
        }
        return false;
    }
}
