package org.eclipse.jdt.internal.compiler.batch;

import java.util.Map;
import java.util.Map$Entry;
import java.util.Iterator;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CompilationProgress;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.IProblemFactory;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.batch.Main$1;
import org.eclipse.jdt.internal.compiler.batch.Main$2;
import org.eclipse.jdt.internal.compiler.batch.Main$ResourceBundleFactory;
import org.eclipse.jdt.internal.compiler.batch.Main$Logger;
import org.eclipse.jdt.internal.compiler.batch.ClasspathJar;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.batch.FileSystem;
import org.eclipse.jdt.internal.compiler.batch.FileSystem$Classpath;
import org.eclipse.jdt.internal.compiler.batch.eclipse;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.impl.CompilerStats;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.jdt.internal.compiler.util.SuffixConstants;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;
import org.eclipse.jdt.internal.compiler.util.Messages;

public class Main implements SuffixConstants {

    boolean field_1012;

    public Compiler batchCompiler;

    public static Hashtable field_1014;

    protected FileSystem$Classpath[] field_1015;

    public CompilerOptions field_1016;

    public CompilationProgress field_1017;

    public String field_1018;

    private boolean field_1019;

    private boolean field_1020;

    public int field_1021;

    public String[] field_1022;

    public String[] field_1023;

    public int field_1024;

    public int field_1025;

    public int field_1026;

    public int field_1027;

    public Main$Logger logger;

    public Map options;

    protected PrintStream field_1030;

    public boolean field_1031;

    public boolean field_1032;

    public boolean field_1033;

    public int field_1034;

    public int field_1035;

    public boolean field_1036;

    public long field_1037;

    public ArrayList field_1038;

    public boolean field_1039;

    public int field_1040;

    public CompilerStats[] field_1041;

    public boolean field_1042;

    ArrayList field_1043;

    public static void main(String[] var0) {
        Main var10000 = new Main(System.out, System.err, true, (Map)null, (CompilationProgress)null);
        var10000.compile(var0);
    }

    public Main(PrintStream var1, PrintStream var2, boolean var3, Map var4, CompilationProgress var5) {
        this.field_1031 = true;
        this.field_1032 = false;
        this.field_1033 = false;
        this.field_1039 = true;
        this.field_1040 = 0;
        this.field_1042 = true;
        this.method_1423(var1, var2, var3, var4, var5);
        field_1014 = Main$ResourceBundleFactory.method_1219();
    }

    public String method_1411(String var1) {
        return this.method_1414(var1, (String[])null);
    }

    public String method_1412(String var1, String var2) {
        return this.method_1414(var1, new String[] {var2});
    }

    public String method_1413(String var1, String var2, String var3) {
        return this.method_1414(var1, new String[] {var2, var3});
    }

    public String method_1414(String var1, String[] var2) {
        if (var1 == null) {
            return "No message available";
        } else {
            String var3 = null;
            try {
                var3 = (String)field_1014.get(String.valueOf(var1));
            } catch (Exception var5) {
                var5.printStackTrace();
            }
            return MessageFormat.format(var3, var2);
        }
    }

    public boolean compile(String[] var1) {
        boolean var3;
        try {
            try {
                this.configure(var1);
                if (this.field_1017 != null) {
                    this.field_1017.method_1392(this.field_1022 == null ? 0 : this.field_1022.length * this.field_1035);
                }
                if (this.field_1031) {
                    if (this.field_1042) {
                        eclipse var10000 = eclipse.instance;
                        CompilerOptions var10002 = new CompilerOptions(this.options);
                        var10000.println(this.field_1016 = var10002);
                    }
                    if (this.field_1036) {
                        this.logger.compiling();
                    }
                    for (this.field_1034 = 0; this.field_1034 < this.field_1035; ++this.field_1034) {
                        this.field_1025 = 0;
                        this.field_1024 = 0;
                        this.field_1027 = 0;
                        this.field_1026 = 0;
                        this.field_1021 = 0;
                        if (this.field_1035 > 1) {
                            this.logger.flush();
                            this.logger.logRepetition(this.field_1034, this.field_1035);
                        }
                        this.method_1425();
                    }
                    if (this.field_1041 != null) {
                        this.logger.logAverage();
                    }
                    if (this.field_1036) {
                        this.logger.printNewLine();
                    }
                }
                if (this.field_1039) {
                    this.logger.flush();
                    this.logger.close();
                }
                return this.field_1024 == 0 && (this.field_1017 == null || !this.field_1017.method_1394());
            } catch (InvalidInputException var8) {
                var8.printStackTrace();
                if (this.field_1039) {
                    this.logger.flush();
                    this.logger.close();
                }
                var3 = false;
                return var3;
            } catch (RuntimeException var9) {
                this.logger.method_1244(var9);
                if (this.field_1039) {
                    this.logger.flush();
                    this.logger.close();
                    throw var9;
                }
            }
            var3 = false;
        } finally {
            this.logger.flush();
            this.logger.close();
            if (this.field_1017 != null) {
                this.field_1017.method_1393();
            }
        }
        return var3;
    }

    public void configure(String[] var1) {
        File var10001 = new File(var1[0]);
        this.field_1022 = method_1426(var10001, "JAVA");
        this.field_1018 = var1[2];
        FileSystem$Classpath[] var4 = new FileSystem$Classpath[1];
        ClasspathJar var10004 = new ClasspathJar((AccessRuleSet)null, (String)null);
        var4[0] = var10004;
        this.field_1015 = var4;
        this.field_1032 = true;
        this.field_1040 = 3;
        this.field_1033 = true;
        this.options.put("org.eclipse.jdt.core.compiler.debug.localVariable", "generate");
        this.options.put("org.eclipse.jdt.core.compiler.debug.lineNumber", "generate");
        this.options.put("org.eclipse.jdt.core.compiler.debug.sourceFile", "generate");
        this.options.put("org.eclipse.jdt.core.encoding", "utf-8");
        this.options.put("org.eclipse.jdt.core.compiler.codegen.targetPlatform", "1.1");
        this.options.put("org.eclipse.jdt.core.compiler.source", "1.2");
        this.field_1012 = false;
        if (this.field_1035 == 0) {
            this.field_1035 = 1;
        }
        if (this.field_1035 >= 3 && (this.field_1040 & 1) != 0) {
            this.field_1041 = new CompilerStats[this.field_1035];
        }
        if (this.field_1038 != null) {
            Iterator var2 = this.field_1038.iterator();
            while (var2.hasNext()) {
                String var3 = (String)var2.next();
                this.logger.method_1249(var3);
            }
            this.field_1038 = null;
        }
    }

    public String method_1417(CompilationResult var1) {
        ICompilationUnit var2 = var1.field_1677;
        if (var2 != null) {
            char[] var3 = var2.method_50().toCharArray();
            int var4 = CharOperation.method_1376('/', var3);
            if (var4 != -1) {
                String var5 = new String(var3, 0, var4);
                File var10000 = new File(var5);
                File var6 = var10000;
                if (var6.exists() && var6.isDirectory()) {
                    return var5;
                }
            }
        }
        return null;
    }

    public ICompilerRequestor method_1418() {
        Main$1 var10000 = new Main$1(this);
        return var10000;
    }

    public CompilationUnit[] method_1419() throws InvalidInputException {
        int var1 = this.field_1022.length;
        CompilationUnit[] var2 = new CompilationUnit[var1];
        HashtableOfObject var10000 = new HashtableOfObject(var1);
        HashtableOfObject var3 = var10000;
        for (int var4 = 0; var4 < var1; ++var4) {
            char[] var5 = this.field_1022[var4].toCharArray();
            InvalidInputException var8;
            if (var3.method_3226(var5) != null) {
                var8 = new InvalidInputException(this.method_1412("unit.more", this.field_1022[var4]));
                throw var8;
            }
            var3.method_3227(var5, var5);
            File var7 = new File(this.field_1022[var4]);
            File var6 = var7;
            if (!var6.exists()) {
                var8 = new InvalidInputException(this.method_1412("unit.missing", this.field_1022[var4]));
                throw var8;
            }
            CompilationUnit var10002 = new CompilationUnit((char[])null, this.field_1022[var4], (String)null, (String)null);
            var2[var4] = var10002;
        }
        return var2;
    }

    public IErrorHandlingPolicy method_1420() {
        Main$2 var10000 = new Main$2(this);
        return var10000;
    }

    public FileSystem method_1421() {
        FileSystem var10000 = new FileSystem(this.field_1015, this.field_1022);
        return var10000;
    }

    public IProblemFactory method_1422() {
        DefaultProblemFactory var10000 = new DefaultProblemFactory();
        return var10000;
    }

    protected void method_1423(PrintStream var1, PrintStream var2, boolean var3, Map var4, CompilationProgress var5) {
        Main$Logger var10001 = new Main$Logger(this, var1, var2);
        this.logger = var10001;
        this.field_1031 = true;
        this.field_1030 = var1;
        this.field_1039 = var3;
        CompilerOptions var8 = new CompilerOptions();
        this.options = var8.method_3311();
        this.field_1017 = var5;
        if (var4 != null) {
            this.field_1019 = var4.get("org.eclipse.jdt.core.compiler.source") != null;
            this.field_1020 = var4.get("org.eclipse.jdt.core.compiler.codegen.targetPlatform") != null;
            Iterator var6 = var4.entrySet().iterator();
            while (var6.hasNext()) {
                Map$Entry var7 = (Map$Entry)var6.next();
                this.options.put(var7.getKey(), var7.getValue());
            }
        } else {
            this.field_1019 = false;
            this.field_1020 = false;
        }
        this.field_1023 = null;
    }

    public void method_1424(CompilationResult var1) {
        if (var1 != null && (!var1.method_2924() || this.field_1032)) {
            ClassFile[] var2 = var1.method_2917();
            String var3 = null;
            boolean var4 = false;
            CompilationUnit var5 = (CompilationUnit)var1.field_1677;
            if (var5.field_1011 == null) {
                if (this.field_1018 == null) {
                    var3 = this.method_1417(var1);
                } else if (this.field_1018 != "none") {
                    var3 = this.field_1018;
                    var4 = true;
                }
            } else if (var5.field_1011 != "none") {
                var3 = var5.field_1011;
                var4 = true;
            }
            if (var3 != null) {
                int var6 = 0;
                for (int var7 = var2.length; var6 < var7; ++var6) {
                    ClassFile var8 = var2[var6];
                    char[] var9 = var8.method_2987();
                    int var10 = var9.length;
                    char[] var11 = new char[var10 + 6];
                    System.arraycopy(var9, 0, var11, 0, var10);
                    System.arraycopy(SuffixConstants.field_0, 0, var11, var10, 6);
                    CharOperation.method_1382(var11, '/', '/');
                    String var12 = new String(var11);
                    try {
                        if (this.field_1016.field_1931) {
                            this.field_1030.println(Messages.method_3253(Messages.field_1865, new String[] {String.valueOf(this.field_1021 + 1), var12}));
                        }
                        Util.method_1330(var4, var3, var12, var8);
                        this.logger.method_1243(var4, var3, var12);
                        ++this.field_1021;
                    } catch (IOException var14) {
                        this.logger.method_1247(var3, var12, var14);
                    }
                }
                this.batchCompiler.field_1707.method_517(var2);
            }
        }
    }

    public void method_1425() throws InvalidInputException {
        this.field_1037 = System.currentTimeMillis();
        FileSystem var1 = this.method_1421();
        this.field_1016.field_1961 = false;
        this.field_1016.field_1962 = false;
        Compiler var10001 = new Compiler(var1, this.method_1420(), this.field_1016, this.method_1418(), this.method_1422(), this.field_1030, this.field_1017);
        this.batchCompiler = var10001;
        this.batchCompiler.field_1704 = this.field_1035 - this.field_1034;
        this.batchCompiler.field_1712 = true;
        this.field_1016.field_1931 = this.field_1042;
        this.field_1016.field_1932 = this.field_1033;
        try {
            this.logger.method_1270();
            this.batchCompiler.method_2944(this.method_1419());
        } finally {
            this.logger.method_1234();
        }
        if (this.field_1043 != null) {
            this.logger.method_1246(this);
            this.field_1043 = null;
        }
        if (this.field_1041 != null) {
            this.field_1041[this.field_1034] = this.batchCompiler.field_1702;
        }
        this.logger.method_1265();
        var1.method_16();
    }

    public static String[] method_1426(File var0, String var1) {
        ArrayList var10000 = new ArrayList();
        ArrayList var2 = var10000;
        method_1427(var0, var1, var2);
        String[] var3 = new String[var2.size()];
        var2.toArray(var3);
        return var3;
    }

    private static void method_1427(File var0, String var1, ArrayList var2) {
        if (var0.isDirectory()) {
            File[] var3 = null;
            try {
                var3 = var0.listFiles();
            } catch (IOException var7) {
                ;
            }
            if (var3 == null) {
                return;
            }
            int var4 = 0;
            for (int var5 = var3.length; var4 < var5; ++var4) {
                File var6 = var3[var4];
                if (var6.isDirectory()) {
                    method_1427(var6, var1, var2);
                } else if (var6.getName().toUpperCase().endsWith(var1)) {
                    var2.add(var6.getPath());
                }
            }
        }
    }
}
