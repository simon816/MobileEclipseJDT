package batch;

import a.class_341;
import a.class_342;
import b.class_232;
import b.class_233;
import b.class_234;
import batch.class_208;
import batch.class_211;
import batch.class_214;
import batch.class_217;
import batch.class_221;
import batch.class_237;
import batch.class_239;
import batch.class_4;
import batch.eclipse;
import c.class_284;
import c.class_286;
import c.class_288;
import c.class_7;
import c.class_8;
import c.class_9;
import f.class_2;
import f.class_226;
import f.class_325;
import f.class_329;
import g.class_14;
import g.class_15;
import g.class_16;
import g.class_308;
import g.class_309;
import g.class_313;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import k.class_19;
import k.class_343;
import n.class_246;

// $FF: renamed from: batch.d
public class class_238 implements class_2 {

    // $FF: renamed from: a boolean
    boolean field_1012;
    // $FF: renamed from: a c.f
    public class_286 field_1013;
    // $FF: renamed from: a java.util.Hashtable
    public static Hashtable field_1014;
    // $FF: renamed from: a batch.a[]
    protected class_4[] field_1015;
    // $FF: renamed from: a a.c
    public class_341 field_1016;
    // $FF: renamed from: a b.b
    public class_234 field_1017;
    // $FF: renamed from: a java.lang.String
    public String field_1018;
    // $FF: renamed from: h boolean
    private boolean field_1019;
    // $FF: renamed from: i boolean
    private boolean field_1020;
    // $FF: renamed from: a int
    public int field_1021;
    // $FF: renamed from: a java.lang.String[]
    public String[] field_1022;
    // $FF: renamed from: b java.lang.String[]
    public String[] field_1023;
    // $FF: renamed from: b int
    public int field_1024;
    // $FF: renamed from: c int
    public int field_1025;
    // $FF: renamed from: d int
    public int field_1026;
    // $FF: renamed from: e int
    public int field_1027;
    // $FF: renamed from: a batch.e
    public class_217 field_1028;
    // $FF: renamed from: a g.m
    public class_14 field_1029;
    // $FF: renamed from: a java.io.PrintStream
    protected PrintStream field_1030;
    // $FF: renamed from: b boolean
    public boolean field_1031;
    // $FF: renamed from: c boolean
    public boolean field_1032;
    // $FF: renamed from: d boolean
    public boolean field_1033;
    // $FF: renamed from: f int
    public int field_1034;
    // $FF: renamed from: g int
    public int field_1035;
    // $FF: renamed from: e boolean
    public boolean field_1036;
    // $FF: renamed from: a long
    public long field_1037;
    // $FF: renamed from: a g.p
    public class_313 field_1038;
    // $FF: renamed from: f boolean
    public boolean field_1039;
    // $FF: renamed from: h int
    public int field_1040;
    // $FF: renamed from: a a.b[]
    public class_342[] field_1041;
    // $FF: renamed from: g boolean
    public boolean field_1042;
    // $FF: renamed from: b g.p
    class_313 field_1043;

    // $FF: renamed from: a (java.lang.String[]) void
    public static void method_1409(String[] var0) {
        class_238 var10000 = new class_238(System.out, System.err, true, (class_14)null, (class_234)null);
        var10000.method_1415(var0);
    }

    // $FF: renamed from: <init> (java.io.PrintStream, java.io.PrintStream, boolean, g.m, b.b) void
    public class_238(PrintStream var1, PrintStream var2, boolean var3, class_14 var4, class_234 var5) {
        this.field_1031 = true;
        this.field_1032 = false;
        this.field_1033 = false;
        this.field_1039 = true;
        this.field_1040 = 0;
        this.field_1042 = true;
        this.method_1423(var1, var2, var3, var4, var5);
        field_1014 = class_214.method_1219();
    }

    // $FF: renamed from: a (java.lang.String) java.lang.String
    public String method_1411(String var1) {
        return this.method_1414(var1, (String[])null);
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) java.lang.String
    public String method_1412(String var1, String var2) {
        return this.method_1414(var1, new String[] {var2});
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.String) java.lang.String
    public String method_1413(String var1, String var2, String var3) {
        return this.method_1414(var1, new String[] {var2, var3});
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String[]) java.lang.String
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

    // $FF: renamed from: a (java.lang.String[]) boolean
    public boolean method_1415(String[] var1) {
        boolean var3;
        try {
            this.method_1416(var1);
            if (this.field_1017 != null) {
                this.field_1017.method_1392(this.field_1022 == null ? 0 : this.field_1022.length * this.field_1035);
            }
            if (this.field_1031) {
                if (this.field_1042) {
                    eclipse var10000 = eclipse.field_427;
                    class_341 var10002 = new class_341(this.field_1029);
                    var10000.method_734(this.field_1016 = var10002);
                }
                if (this.field_1036) {
                    this.field_1028.method_1230();
                }
                for (this.field_1034 = 0; this.field_1034 < this.field_1035; ++this.field_1034) {
                    this.field_1025 = 0;
                    this.field_1024 = 0;
                    this.field_1027 = 0;
                    this.field_1026 = 0;
                    this.field_1021 = 0;
                    if (this.field_1035 > 1) {
                        this.field_1028.method_1239();
                        this.field_1028.method_1254(this.field_1034, this.field_1035);
                    }
                    this.method_1425();
                }
                if (this.field_1041 != null) {
                    this.field_1028.method_1242();
                }
                if (this.field_1036) {
                    this.field_1028.method_1263();
                }
            }
            if (this.field_1039) {
                this.field_1028.method_1239();
                this.field_1028.method_1229();
            }
            return this.field_1024 == 0 && (this.field_1017 == null || !this.field_1017.method_1394());
        } catch (class_232 var8) {
            var8.printStackTrace();
            if (this.field_1039) {
                this.field_1028.method_1239();
                this.field_1028.method_1229();
            }
            var3 = false;
        } catch (RuntimeException var9) {
            this.field_1028.method_1244(var9);
            if (this.field_1039) {
                this.field_1028.method_1239();
                this.field_1028.method_1229();
                throw var9;
            }
            var3 = false;
            return var3;
        } finally {
            this.field_1028.method_1239();
            this.field_1028.method_1229();
            if (this.field_1017 != null) {
                this.field_1017.method_1393();
            }
        }
        return var3;
    }

    // $FF: renamed from: b (java.lang.String[]) void
    public void method_1416(String[] var1) {
        class_308 var10001 = new class_308(var1[0]);
        this.field_1022 = method_1426(var10001, "JAVA");
        this.field_1018 = var1[2];
        class_4[] var4 = new class_4[1];
        class_221 var10004 = new class_221((class_343)null, (String)null);
        var4[0] = var10004;
        this.field_1015 = var4;
        this.field_1032 = true;
        this.field_1040 = 3;
        this.field_1033 = true;
        this.field_1029.method_39("org.eclipse.jdt.core.compiler.debug.localVariable", "generate");
        this.field_1029.method_39("org.eclipse.jdt.core.compiler.debug.lineNumber", "generate");
        this.field_1029.method_39("org.eclipse.jdt.core.compiler.debug.sourceFile", "generate");
        this.field_1029.method_39("org.eclipse.jdt.core.encoding", "utf-8");
        this.field_1029.method_39("org.eclipse.jdt.core.compiler.codegen.targetPlatform", "1.1");
        this.field_1029.method_39("org.eclipse.jdt.core.compiler.source", "1.2");
        this.field_1012 = false;
        if (this.field_1035 == 0) {
            this.field_1035 = 1;
        }
        if (this.field_1035 >= 3 && (this.field_1040 & 1) != 0) {
            this.field_1041 = new class_342[this.field_1035];
        }
        if (this.field_1038 != null) {
            class_16 var2 = this.field_1038.method_31();
            while (var2.method_47()) {
                String var3 = (String)var2.method_48();
                this.field_1028.method_1249(var3);
            }
            this.field_1038 = null;
        }
    }

    // $FF: renamed from: a (c.h) java.lang.String
    public String method_1417(class_284 var1) {
        class_19 var2 = var1.field_1677;
        if (var2 != null) {
            char[] var3 = var2.method_50().toCharArray();
            int var4 = class_233.method_1376('/', var3);
            if (var4 != -1) {
                String var5 = new String(var3, 0, var4);
                class_308 var10000 = new class_308(var5);
                class_308 var6 = var10000;
                if (var6.method_3144() && var6.method_3146()) {
                    return var5;
                }
            }
        }
        return null;
    }

    // $FF: renamed from: a () c.k
    public class_9 method_1418() {
        class_208 var10000 = new class_208(this);
        return var10000;
    }

    // $FF: renamed from: a () batch.c[]
    public class_237[] method_1419() throws class_232 {
        int var1 = this.field_1022.length;
        class_237[] var2 = new class_237[var1];
        class_325 var10000 = new class_325(var1);
        class_325 var3 = var10000;
        for (int var4 = 0; var4 < var1; ++var4) {
            char[] var5 = this.field_1022[var4].toCharArray();
            class_232 var8;
            if (var3.method_3226(var5) != null) {
                var8 = new class_232(this.method_1412("unit.more", this.field_1022[var4]));
                throw var8;
            }
            var3.method_3227(var5, var5);
            class_308 var7 = new class_308(this.field_1022[var4]);
            class_308 var6 = var7;
            if (!var6.method_3144()) {
                var8 = new class_232(this.method_1412("unit.missing", this.field_1022[var4]));
                throw var8;
            }
            class_237 var10002 = new class_237((char[])null, this.field_1022[var4], (String)null, (String)null);
            var2[var4] = var10002;
        }
        return var2;
    }

    // $FF: renamed from: a () c.l
    public class_7 method_1420() {
        class_211 var10000 = new class_211(this);
        return var10000;
    }

    // $FF: renamed from: a () batch.b
    public class_239 method_1421() {
        class_239 var10000 = new class_239(this.field_1015, this.field_1022);
        return var10000;
    }

    // $FF: renamed from: a () c.o
    public class_8 method_1422() {
        class_246 var10000 = new class_246();
        return var10000;
    }

    // $FF: renamed from: a (java.io.PrintStream, java.io.PrintStream, boolean, g.m, b.b) void
    protected void method_1423(PrintStream var1, PrintStream var2, boolean var3, class_14 var4, class_234 var5) {
        class_217 var10001 = new class_217(this, var1, var2);
        this.field_1028 = var10001;
        this.field_1031 = true;
        this.field_1030 = var1;
        this.field_1039 = var3;
        class_341 var8 = new class_341();
        this.field_1029 = var8.method_3311();
        this.field_1017 = var5;
        if (var4 != null) {
            this.field_1019 = var4.method_38("org.eclipse.jdt.core.compiler.source") != null;
            this.field_1020 = var4.method_38("org.eclipse.jdt.core.compiler.codegen.targetPlatform") != null;
            class_16 var6 = var4.method_44().method_31();
            while (var6.method_47()) {
                class_15 var7 = (class_15)var6.method_48();
                this.field_1029.method_39(var7.method_45(), var7.method_46());
            }
        } else {
            this.field_1019 = false;
            this.field_1020 = false;
        }
        this.field_1023 = null;
    }

    // $FF: renamed from: a (c.h) void
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
                    System.arraycopy(class_2.field_0, 0, var11, var10, 6);
                    class_233.method_1382(var11, '/', '/');
                    String var12 = new String(var11);
                    try {
                        if (this.field_1016.field_1931) {
                            this.field_1030.println(class_329.method_3253(class_329.field_1865, new String[] {String.valueOf(this.field_1021 + 1), var12}));
                        }
                        class_226.method_1330(var4, var3, var12, var8);
                        this.field_1028.method_1243(var4, var3, var12);
                        ++this.field_1021;
                    } catch (IOException var14) {
                        this.field_1028.method_1247(var3, var12, var14);
                    }
                }
                this.field_1013.field_1707.method_517(var2);
            }
        }
    }

    // $FF: renamed from: a () void
    public void method_1425() throws class_232 {
        this.field_1037 = System.currentTimeMillis();
        class_239 var1 = this.method_1421();
        this.field_1016.field_1961 = false;
        this.field_1016.field_1962 = false;
        class_286 var10001 = new class_286(var1, this.method_1420(), this.field_1016, this.method_1418(), this.method_1422(), this.field_1030, this.field_1017);
        this.field_1013 = var10001;
        this.field_1013.field_1704 = this.field_1035 - this.field_1034;
        this.field_1013.field_1712 = true;
        this.field_1016.field_1931 = this.field_1042;
        this.field_1016.field_1932 = this.field_1033;
        try {
            this.field_1028.method_1270();
            this.field_1013.method_2944(this.method_1419());
        } finally {
            this.field_1028.method_1234();
        }
        if (this.field_1043 != null) {
            this.field_1028.method_1246(this);
            this.field_1043 = null;
        }
        if (this.field_1041 != null) {
            this.field_1041[this.field_1034] = this.field_1013.field_1702;
        }
        this.field_1028.method_1265();
        var1.method_16();
    }

    // $FF: renamed from: a (g.g, java.lang.String) java.lang.String[]
    public static String[] method_1426(class_308 var0, String var1) {
        class_313 var10000 = new class_313();
        class_313 var2 = var10000;
        method_1427(var0, var1, var2);
        String[] var3 = new String[var2.method_29()];
        var2.method_33(var3);
        return var3;
    }

    // $FF: renamed from: a (g.g, java.lang.String, g.p) void
    private static void method_1427(class_308 var0, String var1, class_313 var2) {
        if (var0.method_3146()) {
            class_308[] var3 = null;
            try {
                var3 = var0.method_3149();
            } catch (IOException var7) {
                ;
            }
            if (var3 == null) {
                return;
            }
            int var4 = 0;
            for (int var5 = var3.length; var4 < var5; ++var4) {
                class_308 var6 = var3[var4];
                if (var6.method_3146()) {
                    method_1427(var6, var1, var2);
                } else if (var6.method_3145().toUpperCase().endsWith(var1)) {
                    var2.method_34(var6.method_3143());
                }
            }
        }
    }
}
