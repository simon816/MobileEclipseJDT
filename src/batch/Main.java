package batch;

import a.CompilerOptions;
import a.class_342;
import b.InvalidInputException;
import b.CharOperation;
import b.class_234;
import batch.class_208;
import batch.class_211;
import batch.class_214;
import batch.Logger;
import batch.class_221;
import batch.class_237;
import batch.class_239;
import batch.class_4;
import batch.eclipse;
import c.class_284;
import c.Compiler;
import c.class_288;
import c.class_7;
import c.class_8;
import c.class_9;
import f.SuffixConstants;
import f.Util;
import f.class_325;
import f.class_329;
import java.util.Map;
import g.class_15;
import java.util.Iterator;
import java.io.File;
import g.class_309;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import k.class_19;
import k.class_343;
import n.class_246;

public class Main implements SuffixConstants {

    boolean field_1012;

    public Compiler batchCompiler;

    public static Hashtable field_1014;

    protected class_4[] field_1015;

    public CompilerOptions field_1016;

    public class_234 field_1017;

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

    public Logger logger;

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

    public class_342[] field_1041;

    public boolean field_1042;

    ArrayList field_1043;

    public static void main(String[] var0) {
        Main var10000 = new Main(System.out, System.err, true, (Map)null, (class_234)null);
        var10000.compile(var0);
    }

    public Main(PrintStream var1, PrintStream var2, boolean var3, Map var4, class_234 var5) {
        this.field_1031 = true;
        this.field_1032 = false;
        this.field_1033 = false;
        this.field_1039 = true;
        this.field_1040 = 0;
        this.field_1042 = true;
        this.method_1423(var1, var2, var3, var4, var5);
        field_1014 = class_214.method_1219();
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
            return class_309.method_3156(var3, var2);
        }
    }

    public boolean compile(String[] var1) {
        boolean var3;
        try {
            this.configure(var1);
            if (this.field_1017 != null) {
                this.field_1017.method_1392(this.field_1022 == null ? 0 : this.field_1022.length * this.field_1035);
            }
            if (this.field_1031) {
                if (this.field_1042) {
                    eclipse var10000 = eclipse.instance;
                    CompilerOptions var10002 = new CompilerOptions(this.options);
                    var10000.print(this.field_1016 = var10002);
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
        } catch (RuntimeException var9) {
            this.logger.method_1244(var9);
            if (this.field_1039) {
                this.logger.flush();
                this.logger.close();
                throw var9;
            }
            var3 = false;
            return var3;
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
        class_4[] var4 = new class_4[1];
        class_221 var10004 = new class_221((class_343)null, (String)null);
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
            this.field_1041 = new class_342[this.field_1035];
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

    public String method_1417(class_284 var1) {
        class_19 var2 = var1.field_1677;
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

    public class_9 method_1418() {
        class_208 var10000 = new class_208(this);
        return var10000;
    }

    public class_237[] method_1419() throws InvalidInputException {
        int var1 = this.field_1022.length;
        class_237[] var2 = new class_237[var1];
        class_325 var10000 = new class_325(var1);
        class_325 var3 = var10000;
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
            class_237 var10002 = new class_237((char[])null, this.field_1022[var4], (String)null, (String)null);
            var2[var4] = var10002;
        }
        return var2;
    }

    public class_7 method_1420() {
        class_211 var10000 = new class_211(this);
        return var10000;
    }

    public class_239 method_1421() {
        class_239 var10000 = new class_239(this.field_1015, this.field_1022);
        return var10000;
    }

    public class_8 method_1422() {
        class_246 var10000 = new class_246();
        return var10000;
    }

    protected void method_1423(PrintStream var1, PrintStream var2, boolean var3, Map var4, class_234 var5) {
        Logger var10001 = new Logger(this, var1, var2);
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
                class_15 var7 = (class_15)var6.next();
                this.options.put(var7.method_45(), var7.method_46());
            }
        } else {
            this.field_1019 = false;
            this.field_1020 = false;
        }
        this.field_1023 = null;
    }

    public void method_1424(class_284 var1) {
        if (var1 != null && (!var1.method_2924() || this.field_1032)) {
            class_288[] var2 = var1.method_2917();
            String var3 = null;
            boolean var4 = false;
            class_237 var5 = (class_237)var1.field_1677;
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
                    class_288 var8 = var2[var6];
                    char[] var9 = var8.method_2987();
                    int var10 = var9.length;
                    char[] var11 = new char[var10 + 6];
                    System.arraycopy(var9, 0, var11, 0, var10);
                    System.arraycopy(SuffixConstants.field_0, 0, var11, var10, 6);
                    CharOperation.method_1382(var11, '/', '/');
                    String var12 = new String(var11);
                    try {
                        if (this.field_1016.field_1931) {
                            this.field_1030.println(class_329.method_3253(class_329.field_1865, new String[] {String.valueOf(this.field_1021 + 1), var12}));
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
        class_239 var1 = this.method_1421();
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
