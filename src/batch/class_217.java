package batch;

import a.class_341;
import a.class_342;
import b.class_233;
import b.class_235;
import batch.class_237;
import batch.class_238;
import batch.eclipse;
import c.class_284;
import f.class_206;
import f.class_226;
import f.class_323;
import f.class_329;
import g.class_307;
import g.class_308;
import g.class_312;
import g.class_313;
import g.class_316;
import java.io.IOException;
import java.io.PrintStream;
import k.class_19;
import n.class_248;

// $FF: renamed from: batch.e
public class class_217 {

    // $FF: renamed from: a java.io.PrintStream
    private PrintStream field_926;
    // $FF: renamed from: b java.io.PrintStream
    private PrintStream field_927;
    // $FF: renamed from: c java.io.PrintStream
    private PrintStream field_928;
    // $FF: renamed from: a g.j
    private class_312 field_929;
    // $FF: renamed from: a int
    int field_930;
    // $FF: renamed from: a f.g
    private static final class_323 field_931;
    // $FF: renamed from: a batch.d
    class_238 field_932;

    // $FF: renamed from: <init> (batch.d, java.io.PrintStream, java.io.PrintStream) void
    public class_217(class_238 var1, PrintStream var2, PrintStream var3) {
        this.field_932 = var1;
        this.field_928 = var2;
        this.field_926 = var3;
        class_312 var10001 = new class_312();
        this.field_929 = var10001;
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) java.lang.String
    public String method_1228(String var1, String var2) {
        char var3 = 47;
        String var4 = "/";
        var1 = var1.replace('/', var3);
        StringBuffer var5 = new StringBuffer(var1);
        if (!var1.endsWith(var4)) {
            var5.append(var4);
        }
        class_307 var10000 = new class_307(var2, var4);
        class_307 var6 = var10000;
        String var7;
        for (var7 = var6.method_3140(); var6.method_3139(); var7 = var6.method_3140()) {
            var5.append(var7).append(var4);
        }
        return var5.append(var7).toString();
    }

    // $FF: renamed from: a () void
    public void method_1229() {
        if (this.field_927 != null) {
            if ((this.field_930 & 1) != 0) {
                this.method_1236("compiler");
                this.method_1239();
            }
            this.field_927.close();
        }
    }

    // $FF: renamed from: b () void
    public void method_1230() {
        this.method_1262(this.field_932.method_1411("progress.compiling"));
    }

    // $FF: renamed from: l () void
    private void method_1231() {
        this.method_1236("extra_problems");
    }

    // $FF: renamed from: m () void
    private void method_1232() {
        this.method_1236("problems");
    }

    // $FF: renamed from: c () void
    public void method_1233() {
        if ((this.field_930 & 1) != 0) {
            this.method_1236("source");
        }
    }

    // $FF: renamed from: d () void
    public void method_1234() {
        if ((this.field_930 & 1) != 0) {
            this.method_1236("sources");
        }
    }

    // $FF: renamed from: e () void
    public void method_1235() {
        if ((this.field_930 & 1) != 0) {
            this.method_1236("tasks");
        }
    }

    // $FF: renamed from: b (java.lang.String) void
    private void method_1236(String var1) {
        if (this.field_927 != null) {
            ((class_206)this.field_927).method_1189(var1, true, true);
        }
    }

    // $FF: renamed from: a (b.e, char[], int) java.lang.String
    private String method_1237(class_235 var1, char[] var2, int var3) {
        int var4 = var1.method_1401();
        int var5 = var1.method_1402();
        if (var2 == null && var1.method_1400() != null) {
            try {
                class_308 var10000 = new class_308(new String(var1.method_1400()));
                var2 = class_226.method_1320(var10000, (String)null);
            } catch (IOException var15) {
                ;
            }
        }
        int var6 = var2 == null ? 0 : var2.length;
        if (var4 <= var5 && (var4 >= 0 || var5 >= 0) && var6 != 0) {
            StringBuffer var7 = new StringBuffer();
            if ((var3 & 2) == 0) {
                var7.append(' ').append(class_329.method_3251(class_329.field_1876, String.valueOf(var1.method_1403())));
                var7.append(class_226.field_981);
            }
            var7.append('\t');
            char var8;
            int var12;
            for (var12 = var4 >= var6 ? var6 - 1 : var4; var12 > 0 && (var8 = var2[var12 - 1]) != 10 && var8 != 13; --var12) {
                ;
            }
            int var13;
            for (var13 = var5 >= var6 ? var6 - 1 : var5; var13 + 1 < var6 && (var8 = var2[var13 + 1]) != 13 && var8 != 10; ++var13) {
                ;
            }
            while ((var8 = var2[var12]) == 32 || var8 == 9) {
                ++var12;
            }
            var7.append(var2, var12, var13 - var12 + 1);
            var7.append(class_226.field_981).append("\t");
            int var14;
            for (var14 = var12; var14 < var4; ++var14) {
                var7.append((char)(var2[var14] == 9 ? '\t' : ' '));
            }
            for (var14 = var4; var14 <= (var5 >= var6 ? var6 - 1 : var5); ++var14) {
                var7.append('^');
            }
            return var7.toString();
        } else {
            return class_329.field_1875;
        }
    }

    // $FF: renamed from: a (b.e, char[]) void
    private void method_1238(class_235 var1, char[] var2) {
        int var3 = var1.method_1401();
        int var4 = var1.method_1402();
        if (var2 == null && var1.method_1400() != null) {
            try {
                class_308 var10000 = new class_308(new String(var1.method_1400()));
                var2 = class_226.method_1320(var10000, (String)null);
            } catch (IOException var10) {
                ;
            }
        }
        int var5 = var2 == null ? 0 : var2.length;
        if (var3 <= var4 && (var3 >= 0 || var4 >= 0) && var5 > 0 && var4 <= var5) {
            char var6;
            int var7;
            for (var7 = var3 >= var5 ? var5 - 1 : var3; var7 > 0 && (var6 = var2[var7 - 1]) != 10 && var6 != 13; --var7) {
                ;
            }
            int var8;
            for (var8 = var4 >= var5 ? var5 - 1 : var4; var8 + 1 < var5 && (var6 = var2[var8 + 1]) != 13 && var6 != 10; ++var8) {
                ;
            }
            while ((var6 = var2[var7]) == 32 || var6 == 9) {
                ++var7;
            }
            while ((var6 = var2[var8]) == 32 || var6 == 9) {
                --var8;
            }
            StringBuffer var9 = new StringBuffer();
            var9.append(var2, var7, var8 - var7 + 1);
            this.field_929.method_39("value", String.valueOf(var9));
            this.field_929.method_39("sourceStart", Integer.toString(var3 - var7));
            this.field_929.method_39("sourceEnd", Integer.toString(var4 - var7));
            this.method_1266("source_context", this.field_929, true, true);
        } else {
            this.field_929.method_39("value", class_329.field_1875);
            this.field_929.method_39("sourceStart", "-1");
            this.field_929.method_39("sourceEnd", "-1");
            this.method_1266("source_context", this.field_929, true, true);
        }
    }

    // $FF: renamed from: f () void
    public void method_1239() {
        this.field_928.flush();
        this.field_926.flush();
        if (this.field_927 != null) {
            this.field_927.flush();
        }
    }

    // $FF: renamed from: a (int) java.lang.String
    private String method_1240(int var1) {
        return (String)field_931.method_3214(var1 & 16777215);
    }

    // $FF: renamed from: b (int) java.lang.String
    private String method_1241(int var1) {
        long var2 = class_248.method_1457(var1);
        return class_341.method_3312(var2);
    }

    // $FF: renamed from: g () void
    public void method_1242() {
        class_316.method_3171(this.field_932.field_1041);
        long var1 = this.field_932.field_1041[0].field_1969;
        int var3 = this.field_932.field_1035;
        long var4 = 0L;
        long var6 = 0L;
        long var8 = 0L;
        long var10 = 0L;
        long var12 = 0L;
        int var14 = 1;
        for (int var15 = var3 - 1; var14 < var15; ++var14) {
            class_342 var16 = this.field_932.field_1041[var14];
            var4 += var16.method_3323();
            var6 += var16.field_1970;
            var8 += var16.field_1971;
            var10 += var16.field_1972;
            var12 += var16.field_1973;
        }
        long var24 = var4 / (long)(var3 - 2);
        long var25 = var6 / (long)(var3 - 2);
        long var18 = var8 / (long)(var3 - 2);
        long var20 = var10 / (long)(var3 - 2);
        long var22 = var12 / (long)(var3 - 2);
        this.method_1262(this.field_932.method_1414("compile.averageTime", new String[] {String.valueOf(var1), String.valueOf(var24), String.valueOf((double)((int)((double)var1 * 10000.0D / (double)var24)) / 10.0D)}));
        if ((this.field_932.field_1040 & 2) != 0) {
            this.method_1262(this.field_932.method_1414("compile.detailedTime", new String[] {String.valueOf(var25), String.valueOf((double)((int)((double)var25 * 1000.0D / (double)var24)) / 10.0D), String.valueOf(var18), String.valueOf((double)((int)((double)var18 * 1000.0D / (double)var24)) / 10.0D), String.valueOf(var20), String.valueOf((double)((int)((double)var20 * 1000.0D / (double)var24)) / 10.0D), String.valueOf(var22), String.valueOf((double)((int)((double)var22 * 1000.0D / (double)var24)) / 10.0D)}));
        }
    }

    // $FF: renamed from: a (boolean, java.lang.String, java.lang.String) void
    public void method_1243(boolean var1, String var2, String var3) {
        if ((this.field_930 & 1) != 0) {
            String var4 = null;
            if (var1) {
                var4 = this.method_1228(var2, var3);
            } else {
                char var5 = 47;
                String var6 = "/";
                var2 = var2.replace('/', var5);
                int var7 = var3.lastIndexOf(var5);
                if (var7 == -1) {
                    if (var2.endsWith(var6)) {
                        var4 = var2 + var3;
                    } else {
                        var4 = var2 + var6 + var3;
                    }
                } else {
                    int var8 = var3.length();
                    if (var2.endsWith(var6)) {
                        var4 = var2 + var3.substring(var7 + 1, var8);
                    } else {
                        var4 = var2 + var6 + var3.substring(var7 + 1, var8);
                    }
                }
            }
            class_308 var10000 = new class_308(var4);
            class_308 var10 = var10000;
            //try {
            this.field_929.method_39("path", var10.method_3152());
            this.method_1266("classfile", this.field_929, true, true);
            //} catch (IOException var9) {
            //   this.method_1247(var2, var3, var9);
            //}
        }
    }

    // $FF: renamed from: a (java.lang.Exception) void
    public void method_1244(Exception var1) {
        String var2 = var1.toString();
        if ((this.field_930 & 1) != 0) {
            StringBuffer var3 = new StringBuffer();
            String var4 = var1.getMessage();
            if (var4 != null) {
                var3.append(var4).append(class_226.field_981);
            }
            var3.append(var2).append(class_226.field_981);
            var4 = var3.toString();
            this.field_929.method_39("message", var4);
            this.field_929.method_39("class", var1.getClass());
            this.method_1266("exception", this.field_929, true, true);
        }
        String var5 = var1.getMessage();
        if (var5 == null) {
            this.method_1261(var2);
        } else {
            this.method_1261(var5);
        }
    }

    // $FF: renamed from: a (b.e, int, int) void
    private void method_1245(class_235 var1, int var2, int var3) {
        char[] var4 = var1.method_1400().toCharArray();
        String var5 = var4 == null ? this.field_932.method_1411("requestor.noFileNameSpecified") : new String(var4);
        String var6;
        if ((this.field_930 & 2) != 0) {
            var6 = var5 + ":" + var1.method_1403() + ": " + (var1.method_1399() ? this.field_932.method_1411("output.emacs.error") : this.field_932.method_1411("output.emacs.warning")) + ": " + var1.method_1404();
            this.method_1261(var6);
            String var7 = this.method_1237(var1, (char[])null, this.field_930);
            this.method_1261(var7);
        } else {
            if (var2 == 0) {
                this.method_1261("----------");
            }
            this.method_1259(var1.method_1399() ? this.field_932.method_1413("requestor.error", Integer.toString(var3), new String(var5)) : this.field_932.method_1413("requestor.warning", Integer.toString(var3), new String(var5)));
            var6 = this.method_1237(var1, (char[])null, 0);
            this.method_1261(var6);
            this.method_1261(var1.method_1404());
            this.method_1261("----------");
        }
    }

    // $FF: renamed from: a (batch.d) void
    public void method_1246(class_238 var1) {
        class_313 var2 = this.field_932.field_1043;
        int var3 = var2.method_29();
        int var4 = 0;
        int var5 = 0;
        if (var3 != 0) {
            int var6 = 0;
            int var7 = 0;
            int var8;
            class_235 var9;
            for (var8 = 0; var8 < var3; ++var8) {
                var9 = (class_235)var2.method_36(var8);
                if (var9 != null) {
                    ++this.field_932.field_1025;
                    this.method_1245(var9, var5, this.field_932.field_1025);
                    ++var5;
                    if (var9.method_1399()) {
                        ++var4;
                        ++var6;
                        ++this.field_932.field_1024;
                    } else if (var9.method_10()) {
                        ++this.field_932.field_1027;
                        ++var7;
                    }
                }
            }
            if ((this.field_930 & 1) != 0 && var6 + var7 != 0) {
                this.method_1267(var3);
                for (var8 = 0; var8 < var3; ++var8) {
                    var9 = (class_235)var2.method_36(var8);
                    if (var9 != null && var9.method_1398() != 536871362) {
                        this.method_1256(var9, var5, this.field_932.field_1025);
                    }
                }
                this.method_1231();
            }
        }
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.io.IOException) void
    public void method_1247(String var1, String var2, IOException var3) {
        if ((this.field_930 & 1) != 0) {
            this.field_929.method_39("message", this.field_932.method_1414("output.noClassFileCreated", new String[] {var1, var2, var3.getMessage()}));
            this.method_1266("error", this.field_929, true, true);
        }
        this.method_1261(this.field_932.method_1414("output.noClassFileCreated", new String[] {var1, var2, var3.getMessage()}));
    }

    // $FF: renamed from: a (int) void
    public void method_1248(int var1) {
        if ((this.field_930 & 1) != 0) {
            this.field_929.method_39("value", new Integer(var1));
            this.method_1266("number_of_classfiles", this.field_929, true, true);
        }
        if (var1 == 1) {
            this.method_1262(this.field_932.method_1411("compile.oneClassFileGenerated"));
        } else {
            this.method_1262(this.field_932.method_1412("compile.severalClassFilesGenerated", String.valueOf(var1)));
        }
    }

    // $FF: renamed from: a (java.lang.String) void
    public void method_1249(String var1) {
        if ((this.field_930 & 1) != 0) {
            this.field_929.method_39("message", var1);
            this.method_1266("error", this.field_929, true, true);
        }
        this.method_1261(var1);
    }

    // $FF: renamed from: a (b.e, int, int, char[]) void
    private void method_1250(class_235 var1, int var2, int var3, char[] var4) {
        String var5;
        if ((this.field_930 & 2) != 0) {
            var5 = new String(var1.method_1400()) + ":" + var1.method_1403() + ": " + (var1.method_1399() ? this.field_932.method_1411("output.emacs.error") : this.field_932.method_1411("output.emacs.warning")) + ": " + var1.method_1404();
            this.method_1261(var5);
            String var6 = this.method_1237(var1, var4, this.field_930);
            if (var6.length() != 0) {
                this.method_1261(var6);
            }
        } else {
            if (var2 == 0) {
                this.method_1261("----------");
            }
            this.method_1259(var1.method_1399() ? this.field_932.method_1413("requestor.error", Integer.toString(var3), new String(var1.method_1400())) : this.field_932.method_1413("requestor.warning", Integer.toString(var3), new String(var1.method_1400())));
            try {
                var5 = this.method_1237(var1, var4, 0);
                this.method_1261(var5);
                this.method_1261(var1.method_1404());
            } catch (Exception var7) {
                this.method_1261(this.field_932.method_1412("requestor.notRetrieveErrorMessage", var1.toString()));
            }
            this.method_1261("----------");
        }
    }

    // $FF: renamed from: a (b.e[], char[], batch.d) int
    public int method_1251(class_235[] var1, char[] var2, class_238 var3) {
        int var4 = var1.length;
        int var5 = 0;
        int var6 = 0;
        if (var4 != 0) {
            int var7 = 0;
            int var8 = 0;
            int var9 = 0;
            int var10;
            class_235 var11;
            for (var10 = 0; var10 < var4; ++var10) {
                var11 = var1[var10];
                if (var11 != null) {
                    ++this.field_932.field_1025;
                    this.method_1250(var11, var6, this.field_932.field_1025, var2);
                    ++var6;
                    if (var11.method_1399()) {
                        ++var5;
                        ++var7;
                        ++this.field_932.field_1024;
                    } else if (var11.method_1398() == 536871362) {
                        ++this.field_932.field_1026;
                        ++var9;
                    } else {
                        ++this.field_932.field_1027;
                        ++var8;
                    }
                }
            }
            if ((this.field_930 & 1) != 0) {
                if (var7 + var8 != 0) {
                    this.method_1268(var7, var8);
                    for (var10 = 0; var10 < var4; ++var10) {
                        var11 = var1[var10];
                        if (var11 != null && var11.method_1398() != 536871362) {
                            this.method_1257(var11, var2);
                        }
                    }
                    this.method_1232();
                }
                if (var9 != 0) {
                    this.method_1271(var9);
                    for (var10 = 0; var10 < var4; ++var10) {
                        var11 = var1[var10];
                        if (var11 != null && var11.method_1398() == 536871362) {
                            this.method_1258(var11, var2);
                        }
                    }
                    this.method_1235();
                }
            }
        }
        return var5;
    }

    // $FF: renamed from: a (int, int, int, int) void
    public void method_1252(int var1, int var2, int var3, int var4) {
        if ((this.field_930 & 1) != 0) {
            this.field_929.method_39("problems", new Integer(var1));
            this.field_929.method_39("errors", new Integer(var2));
            this.field_929.method_39("warnings", new Integer(var3));
            this.field_929.method_39("tasks", new Integer(var4));
            this.method_1266("problem_summary", this.field_929, true, true);
        }
        String var5;
        if (var1 == 1) {
            var5 = null;
            if (var2 == 1) {
                var5 = this.field_932.method_1411("compile.oneError");
            } else {
                var5 = this.field_932.method_1411("compile.oneWarning");
            }
            this.method_1259(this.field_932.method_1412("compile.oneProblem", var5));
        } else {
            var5 = null;
            String var6 = null;
            if (var2 > 0) {
                if (var2 == 1) {
                    var5 = this.field_932.method_1411("compile.oneError");
                } else {
                    var5 = this.field_932.method_1412("compile.severalErrors", String.valueOf(var2));
                }
            }
            int var7 = var3 + var4;
            if (var7 > 0) {
                if (var7 == 1) {
                    var6 = this.field_932.method_1411("compile.oneWarning");
                } else {
                    var6 = this.field_932.method_1412("compile.severalWarnings", String.valueOf(var7));
                }
            }
            if (var5 != null && var6 != null) {
                this.method_1259(this.field_932.method_1414("compile.severalProblemsErrorsAndWarnings", new String[] {String.valueOf(var1), var5, var6}));
            } else if (var5 == null) {
                this.method_1259(this.field_932.method_1413("compile.severalProblemsErrorsOrWarnings", String.valueOf(var1), var6));
            } else {
                this.method_1259(this.field_932.method_1413("compile.severalProblemsErrorsOrWarnings", String.valueOf(var1), var5));
            }
        }
        if ((this.field_930 & 2) != 0) {
            this.method_1260();
        }
    }

    // $FF: renamed from: h () void
    public void method_1253() {
        this.method_1264('.');
    }

    // $FF: renamed from: a (int, int) void
    public void method_1254(int var1, int var2) {
        this.method_1262(this.field_932.method_1413("compile.repetition", String.valueOf(var1 + 1), String.valueOf(var2)));
    }

    // $FF: renamed from: a (a.b) void
    public void method_1255(class_342 var1) {
        long var2 = var1.method_3323();
        long var4 = var1.field_1969;
        if ((this.field_930 & 1) != 0) {
            this.field_929.method_39("value", new Long(var2));
            this.method_1266("time", this.field_929, true, true);
            this.field_929.method_39("value", new Long(var4));
            this.method_1266("number_of_lines", this.field_929, true, true);
        }
        if (var4 != 0L) {
            this.method_1262(this.field_932.method_1414("compile.instantTime", new String[] {String.valueOf(var4), String.valueOf(var2), String.valueOf((double)((int)((double)var4 * 10000.0D / (double)var2)) / 10.0D)}));
        } else {
            this.method_1262(this.field_932.method_1414("compile.totalTime", new String[] {String.valueOf(var2)}));
        }
        if ((this.field_932.field_1040 & 2) != 0) {
            this.method_1262(this.field_932.method_1414("compile.detailedTime", new String[] {String.valueOf(var1.field_1970), String.valueOf((double)((int)((double)var1.field_1970 * 1000.0D / (double)var2)) / 10.0D), String.valueOf(var1.field_1971), String.valueOf((double)((int)((double)var1.field_1971 * 1000.0D / (double)var2)) / 10.0D), String.valueOf(var1.field_1972), String.valueOf((double)((int)((double)var1.field_1972 * 1000.0D / (double)var2)) / 10.0D), String.valueOf(var1.field_1973), String.valueOf((double)((int)((double)var1.field_1973 * 1000.0D / (double)var2)) / 10.0D)}));
        }
    }

    // $FF: renamed from: b (b.e, int, int) void
    private void method_1256(class_235 var1, int var2, int var3) {
        int var4 = var1.method_1401();
        int var5 = var1.method_1402();
        boolean var6 = var1.method_1399();
        this.field_929.method_39("severity", var6 ? "ERROR" : "WARNING");
        this.field_929.method_39("line", new Integer(var1.method_1403()));
        this.field_929.method_39("charStart", new Integer(var4));
        this.field_929.method_39("charEnd", new Integer(var5));
        this.method_1266("extra_problem", this.field_929, true, false);
        this.field_929.method_39("value", var1.method_1404());
        this.method_1266("message", this.field_929, true, true);
        this.method_1238(var1, (char[])null);
        this.method_1236("extra_problem");
    }

    // $FF: renamed from: b (b.e, char[]) void
    private void method_1257(class_235 var1, char[] var2) {
        int var3 = var1.method_1401();
        int var4 = var1.method_1402();
        int var5 = var1.method_1398();
        this.field_929.method_39("id", this.method_1240(var5));
        this.field_929.method_39("problemID", new Integer(var5));
        boolean var6 = var1.method_1399();
        int var7 = var6 ? 1 : 0;
        this.field_929.method_39("severity", var6 ? "ERROR" : "WARNING");
        this.field_929.method_39("line", new Integer(var1.method_1403()));
        this.field_929.method_39("charStart", new Integer(var3));
        this.field_929.method_39("charEnd", new Integer(var4));
        String var8 = this.method_1241(var5);
        if (var8 != null) {
            this.field_929.method_39("optionKey", var8);
        }
        int var9 = class_248.method_1458(var7, var5);
        this.field_929.method_39("categoryID", new Integer(var9));
        this.method_1266("problem", this.field_929, true, false);
        this.field_929.method_39("value", var1.method_1404());
        this.method_1266("message", this.field_929, true, true);
        this.method_1238(var1, var2);
        String[] var10 = var1.method_9();
        int var11 = var10.length;
        if (var11 != 0) {
            this.method_1266("arguments", (class_312)null, true, false);
            for (int var12 = 0; var12 < var11; ++var12) {
                this.field_929.method_39("value", var10[var12]);
                this.method_1266("argument", this.field_929, true, true);
            }
            this.method_1236("arguments");
        }
        this.method_1236("problem");
    }

    // $FF: renamed from: c (b.e, char[]) void
    private void method_1258(class_235 var1, char[] var2) {
        this.field_929.method_39("line", new Integer(var1.method_1403()));
        this.field_929.method_39("charStart", new Integer(var1.method_1401()));
        this.field_929.method_39("charEnd", new Integer(var1.method_1402()));
        String var3 = this.method_1241(var1.method_1398());
        if (var3 != null) {
            this.field_929.method_39("optionKey", var3);
        }
        this.method_1266("task", this.field_929, true, false);
        this.field_929.method_39("value", var1.method_1404());
        this.method_1266("message", this.field_929, true, true);
        this.method_1238(var1, var2);
        this.method_1236("task");
    }

    // $FF: renamed from: c (java.lang.String) void
    private void method_1259(String var1) {
        eclipse.field_427.method_737(var1);
        if ((this.field_930 & 1) == 0 && this.field_927 != null) {
            this.field_927.print(var1);
        }
    }

    // $FF: renamed from: n () void
    private void method_1260() {
        this.field_926.println();
        if ((this.field_930 & 1) == 0 && this.field_927 != null) {
            this.field_927.println();
        }
    }

    // $FF: renamed from: d (java.lang.String) void
    private void method_1261(String var1) {
        eclipse.field_427.method_737(var1);
        if ((this.field_930 & 1) == 0 && this.field_927 != null) {
            this.field_927.println(var1);
        }
    }

    // $FF: renamed from: e (java.lang.String) void
    private void method_1262(String var1) {
        eclipse.field_427.method_733(var1);
        if ((this.field_930 & 1) == 0 && this.field_927 != null) {
            this.field_927.println(var1);
        }
    }

    // $FF: renamed from: i () void
    public void method_1263() {
        eclipse.field_427.method_733("");
    }

    // $FF: renamed from: a (char) void
    private void method_1264(char var1) {
        eclipse.field_427.method_744(String.valueOf(var1));
    }

    // $FF: renamed from: j () void
    public void method_1265() {
        class_238 var10001 = this.field_932;
        boolean var1 = (this.field_932.field_1040 & 1) != 0;
        if ((this.field_930 & 1) != 0) {
            this.method_1266("stats", (class_312)null, true, false);
        }
        if (var1) {
            class_342 var2 = this.field_932.field_1013.field_1702;
            var2.field_1967 = this.field_932.field_1037;
            var2.field_1968 = System.currentTimeMillis();
            this.method_1255(var2);
        }
        if (this.field_932.field_1025 > 0) {
            this.method_1252(this.field_932.field_1025, this.field_932.field_1024, this.field_932.field_1027, this.field_932.field_1026);
        }
        if (this.field_932.field_1021 != 0 && (this.field_932.field_1036 || var1 || this.field_932.field_1042)) {
            this.method_1248(this.field_932.field_1021);
        }
        if ((this.field_930 & 1) != 0) {
            this.method_1236("stats");
        }
    }

    // $FF: renamed from: a (java.lang.String, g.j, boolean, boolean) void
    private void method_1266(String var1, class_312 var2, boolean var3, boolean var4) {
        if (this.field_927 != null) {
            ((class_206)this.field_927).method_1191(var1, this.field_929, true, var3, var4);
        }
        this.field_929.method_41();
    }

    // $FF: renamed from: c (int) void
    private void method_1267(int var1) {
        this.field_929.method_39("problems", new Integer(var1));
        this.method_1266("extra_problems", this.field_929, true, false);
    }

    // $FF: renamed from: b (int, int) void
    private void method_1268(int var1, int var2) {
        this.field_929.method_39("problems", new Integer(var1 + var2));
        this.field_929.method_39("errors", new Integer(var1));
        this.field_929.method_39("warnings", new Integer(var2));
        this.method_1266("problems", this.field_929, true, false);
    }

    // $FF: renamed from: a (c.h) void
    public void method_1269(class_284 var1) {
        if ((this.field_930 & 1) != 0) {
            class_19 var2 = var1.field_1677;
            if (var2 != null) {
                String var3 = var2.method_50();
                class_308 var10000 = new class_308(var3);
                class_308 var4 = var10000;
                if (var3 != null) {
                    this.field_929.method_39("path", var4.method_3143());
                }
                char[][] var5 = var1.field_1693;
                if (var5 != null) {
                    this.field_929.method_39("package", new String(class_233.method_1361(var5, '/')));
                }
                class_237 var6 = (class_237)var2;
                String var7 = var6.field_1011;
                if (var7 == null) {
                    var7 = this.field_932.field_1018;
                }
                if (var7 != null) {
                    class_238 var10001 = this.field_932;
                    if (var7 != "none") {
                        this.field_929.method_39("output", var7);
                    }
                }
            }
            this.method_1266("source", this.field_929, true, false);
        }
    }

    // $FF: renamed from: k () void
    public void method_1270() {
        if ((this.field_930 & 1) != 0) {
            this.method_1266("sources", (class_312)null, true, false);
        }
    }

    // $FF: renamed from: b (int) void
    public void method_1271(int var1) {
        if ((this.field_930 & 1) != 0) {
            this.field_929.method_39("tasks", new Integer(var1));
            this.method_1266("tasks", this.field_929, true, false);
        }
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_323 var10000 = new class_323();
        field_931 = var10000;
    }
}
