package org.eclipse.jdt.internal.compiler.batch;

import java.io.File;

import java.util.Hashtable;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.batch.ClasspathLocation;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;
import org.eclipse.jdt.internal.compiler.util.Util;

public class ClasspathDirectory extends ClasspathLocation {

    protected ClasspathDirectory(AccessRuleSet var1, String var2) {
        super(var1, var2);
    }

    private Hashtable directoryCache;

    private String[] missingPackageHolder;

    private int mode;

    private String encoding;

    String[] directoryList(String var1) {
        String[] var2 = (String[])((String[])this.directoryCache.get(var1));
        if (var2 == this.missingPackageHolder) {
            return null;
        } else if (var2 != null) {
            return var2;
        } else {
            File var10000 = new File(this.path + var1);
            File var3 = var10000;
            if (var3.isDirectory()) {
                label46: {
                    int var4 = var1.length();
                    int var5 = var1.lastIndexOf(47);
                    do {
                        --var4;
                    } while (var4 > var5 && !ScannerHelper.method_3342(var1.charAt(var4)));
                    if (var4 > var5) {
                        if (var5 == -1) {
                            if (!this.doesFileExist(var1, Util.field_982)) {
                                break label46;
                            }
                        } else {
                            String var6 = var1.substring(var5 + 1);
                            String var7 = var1.substring(0, var5);
                            if (!this.doesFileExist(var6, var7)) {
                                break label46;
                            }
                        }
                    }
                    if ((var2 = var3.list()) == null) {
                        var2 = CharOperation.NO_STRINGS;
                    }
                    this.directoryCache.put(var1, var2);
                    return var2;
                }
            }
            this.directoryCache.put(var1, this.missingPackageHolder);
            return null;
        }
    }

    boolean doesFileExist(String var1, String var2) {
        String[] var3 = this.directoryList(var2);
        if (var3 == null) {
            return false;
        } else {
            int var4 = var3.length;
            do {
                --var4;
                if (var4 < 0) {
                    return false;
                }
            } while (!var1.equals(var3[var4]));
            return true;
        }
    }

    public NameEnvironmentAnswer findClass(char[] var1, String var2, String var3, boolean var4) {
        if (!this.isPackage(var2)) {
            return null;
        } else {
            String var5 = new String(var1);
            boolean var6 = (this.mode & 2) != 0 && this.doesFileExist(var5 + ".class", var2);
            boolean var7 = (this.mode & 1) != 0 && this.doesFileExist(var5 + ".java", var2);
            NameEnvironmentAnswer var15;
            if (var7 && !var4) {
                String var8 = this.path + var3.substring(0, var3.length() - 6) + ".java";
                CompilationUnit var10002;
                if (!var6) {
                    var10002 = new CompilationUnit((char[])null, var8, this.encoding, this.destinationPath);
                    var15 = new NameEnvironmentAnswer(var10002, this.fetchAccessRestriction(var3));
                    return var15;
                }
                String var9 = this.path + var3;
                File var10000 = new File(var9);
                long var10 = var10000.lastModified();
                var10000 = new File(var8);
                long var12 = var10000.lastModified();
                if (var12 > var10) {
                    var10002 = new CompilationUnit((char[])null, var8, this.encoding, this.destinationPath);
                    var15 = new NameEnvironmentAnswer(var10002, this.fetchAccessRestriction(var3));
                    return var15;
                }
            }
            if (var6) {
                try {
                    ClassFileReader var16 = ClassFileReader.read(this.path + var3);
                    if (var16 != null) {
                        var15 = new NameEnvironmentAnswer(var16, this.fetchAccessRestriction(var3));
                        return var15;
                    }
                } catch (Exception var14) {
                    ;
                }
            }
            return null;
        }
    }

    public void reset() {}

    public boolean isPackage(String var1) {
        return this.directoryList(var1) != null;
    }

    public void cleanup() {
        this.directoryCache = new Hashtable(11);
    }

    public String toString() {
        return "ClasspathDirectory " + this.path;
    }

    public char[] normalizedPath() {
        if (this.normalizedPath == null) {
            this.normalizedPath = this.path.toCharArray();
        }
        return this.normalizedPath;
    }
}
