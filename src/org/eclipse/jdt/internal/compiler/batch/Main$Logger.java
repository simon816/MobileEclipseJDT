package org.eclipse.jdt.internal.compiler.batch;

import java.util.StringTokenizer;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.batch.CompilationUnit;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.eclipse.jdt.internal.compiler.batch.eclipse;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.impl.CompilerStats;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.GenericXMLWriter;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.compiler.util.HashtableOfInt;
import org.eclipse.jdt.internal.compiler.util.Messages;

public class Main$Logger {

    private PrintStream field_926;

    private PrintStream field_927;

    private PrintStream field_928;

    private HashMap field_929;

    int tagBits;

    private static final HashtableOfInt FIELD_TABLE;

    Main field_932;

    public Main$Logger(Main var1, PrintStream var2, PrintStream var3) {
        this.field_932 = var1;
        this.field_928 = var2;
        this.field_926 = var3;
        HashMap var10001 = new HashMap();
        this.field_929 = var10001;
    }

    public String buildFileName(String var1, String var2) {
        char var3 = 47;
        String var4 = "/";
        var1 = var1.replace('/', var3);
        StringBuffer var5 = new StringBuffer(var1);
        if (!var1.endsWith(var4)) {
            var5.append(var4);
        }
        StringTokenizer var10000 = new StringTokenizer(var2, var4);
        StringTokenizer var6 = var10000;
        String var7;
        for (var7 = var6.nextToken(); var6.hasMoreTokens(); var7 = var6.nextToken()) {
            var5.append(var7).append(var4);
        }
        return var5.append(var7).toString();
    }

    public void close() {
        if (this.field_927 != null) {
            if ((this.tagBits & 1) != 0) {
                this.method_1236("compiler");
                this.flush();
            }
            this.field_927.close();
        }
    }

    public void compiling() {
        this.method_1262(this.field_932.bind("progress.compiling"));
    }

    private void method_1231() {
        this.method_1236("extra_problems");
    }

    private void method_1232() {
        this.method_1236("problems");
    }

    public void method_1233() {
        if ((this.tagBits & 1) != 0) {
            this.method_1236("source");
        }
    }

    public void method_1234() {
        if ((this.tagBits & 1) != 0) {
            this.method_1236("sources");
        }
    }

    public void method_1235() {
        if ((this.tagBits & 1) != 0) {
            this.method_1236("tasks");
        }
    }

    private void method_1236(String var1) {
        if (this.field_927 != null) {
            ((GenericXMLWriter)this.field_927).method_1189(var1, true, true);
        }
    }

    private String errorReportSource(CategorizedProblem var1, char[] var2, int var3) {
        int var4 = var1.method_1401();
        int var5 = var1.method_1402();
        if (var2 == null && var1.method_1400() != null) {
            try {
                File var10000 = new File(new String(var1.method_1400()));
                var2 = Util.method_1320(var10000, (String)null);
            } catch (IOException var15) {
                ;
            }
        }
        int var6 = var2 == null ? 0 : var2.length;
        if (var4 <= var5 && (var4 >= 0 || var5 >= 0) && var6 != 0) {
            StringBuffer var7 = new StringBuffer();
            if ((var3 & 2) == 0) {
                var7.append(' ').append(Messages.bind(Messages.field_1876, String.valueOf(var1.method_1403())));
                var7.append(Util.field_981);
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
            var7.append(Util.field_981).append("\t");
            int var14;
            for (var14 = var12; var14 < var4; ++var14) {
                var7.append((char)(var2[var14] == 9 ? '\t' : ' '));
            }
            for (var14 = var4; var14 <= (var5 >= var6 ? var6 - 1 : var5); ++var14) {
                var7.append('^');
            }
            return var7.toString();
        } else {
            return Messages.field_1875;
        }
    }

    private void extractContext(CategorizedProblem var1, char[] var2) {
        int var3 = var1.method_1401();
        int var4 = var1.method_1402();
        if (var2 == null && var1.method_1400() != null) {
            try {
                File var10000 = new File(new String(var1.method_1400()));
                var2 = Util.method_1320(var10000, (String)null);
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
            this.field_929.put("value", String.valueOf(var9));
            this.field_929.put("sourceStart", Integer.toString(var3 - var7));
            this.field_929.put("sourceEnd", Integer.toString(var4 - var7));
            this.method_1266("source_context", this.field_929, true, true);
        } else {
            this.field_929.put("value", Messages.field_1875);
            this.field_929.put("sourceStart", "-1");
            this.field_929.put("sourceEnd", "-1");
            this.method_1266("source_context", this.field_929, true, true);
        }
    }

    public void flush() {
        this.field_928.flush();
        this.field_926.flush();
        if (this.field_927 != null) {
            this.field_927.flush();
        }
    }

    private String method_1240(int var1) {
        return (String)FIELD_TABLE.get(var1 & 16777215);
    }

    private String method_1241(int var1) {
        long var2 = ProblemReporter.method_1457(var1);
        return CompilerOptions.method_3312(var2);
    }

    public void logAverage() {
        Arrays.sort(this.field_932.compilerStats);
        long var1 = this.field_932.compilerStats[0].field_1969;
        int var3 = this.field_932.field_1035;
        long var4 = 0L;
        long var6 = 0L;
        long var8 = 0L;
        long var10 = 0L;
        long var12 = 0L;
        int var14 = 1;
        for (int var15 = var3 - 1; var14 < var15; ++var14) {
            CompilerStats var16 = this.field_932.compilerStats[var14];
            var4 += var16.elapsedTime();
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
        this.method_1262(this.field_932.bind("compile.averageTime", new String[] {String.valueOf(var1), String.valueOf(var24), String.valueOf((double)((int)((double)var1 * 10000.0D / (double)var24)) / 10.0D)}));
        if ((this.field_932.field_1040 & 2) != 0) {
            this.method_1262(this.field_932.bind("compile.detailedTime", new String[] {String.valueOf(var25), String.valueOf((double)((int)((double)var25 * 1000.0D / (double)var24)) / 10.0D), String.valueOf(var18), String.valueOf((double)((int)((double)var18 * 1000.0D / (double)var24)) / 10.0D), String.valueOf(var20), String.valueOf((double)((int)((double)var20 * 1000.0D / (double)var24)) / 10.0D), String.valueOf(var22), String.valueOf((double)((int)((double)var22 * 1000.0D / (double)var24)) / 10.0D)}));
        }
    }

    public void method_1243(boolean var1, String var2, String var3) {
        if ((this.tagBits & 1) != 0) {
            String var4 = null;
            if (var1) {
                var4 = this.buildFileName(var2, var3);
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
            File var10000 = new File(var4);
            File var10 = var10000;
            //try {
            this.field_929.put("path", var10.getAbsolutePath());
            this.method_1266("classfile", this.field_929, true, true);
            //} catch (IOException var9) {
            //   this.logNoClassFileCreated(var2, var3, var9);
            //}
        }
    }

    public void method_1244(Exception var1) {
        String var2 = var1.toString();
        if ((this.tagBits & 1) != 0) {
            StringBuffer var3 = new StringBuffer();
            String var4 = var1.getMessage();
            if (var4 != null) {
                var3.append(var4).append(Util.field_981);
            }
            var3.append(var2).append(Util.field_981);
            var4 = var3.toString();
            this.field_929.put("message", var4);
            this.field_929.put("class", var1.getClass());
            this.method_1266("exception", this.field_929, true, true);
        }
        String var5 = var1.getMessage();
        if (var5 == null) {
            this.method_1261(var2);
        } else {
            this.method_1261(var5);
        }
    }

    private void method_1245(CategorizedProblem var1, int var2, int var3) {
        char[] var4 = var1.method_1400().toCharArray();
        String var5 = var4 == null ? this.field_932.bind("requestor.noFileNameSpecified") : new String(var4);
        String var6;
        if ((this.tagBits & 2) != 0) {
            var6 = var5 + ":" + var1.method_1403() + ": " + (var1.method_1399() ? this.field_932.bind("output.emacs.error") : this.field_932.bind("output.emacs.warning")) + ": " + var1.method_1404();
            this.method_1261(var6);
            String var7 = this.errorReportSource(var1, (char[])null, this.tagBits);
            this.method_1261(var7);
        } else {
            if (var2 == 0) {
                this.method_1261("----------");
            }
            this.method_1259(var1.method_1399() ? this.field_932.bind("requestor.error", Integer.toString(var3), new String(var5)) : this.field_932.bind("requestor.warning", Integer.toString(var3), new String(var5)));
            var6 = this.errorReportSource(var1, (char[])null, 0);
            this.method_1261(var6);
            this.method_1261(var1.method_1404());
            this.method_1261("----------");
        }
    }

    public void loggingExtraProblems(Main var1) {
        ArrayList var2 = this.field_932.field_1043;
        int var3 = var2.size();
        int var4 = 0;
        int var5 = 0;
        if (var3 != 0) {
            int var6 = 0;
            int var7 = 0;
            int var8;
            CategorizedProblem var9;
            for (var8 = 0; var8 < var3; ++var8) {
                var9 = (CategorizedProblem)var2.get(var8);
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
            if ((this.tagBits & 1) != 0 && var6 + var7 != 0) {
                this.startLoggingExtraProblems(var3);
                for (var8 = 0; var8 < var3; ++var8) {
                    var9 = (CategorizedProblem)var2.get(var8);
                    if (var9 != null && var9.method_1398() != 536871362) {
                        this.method_1256(var9, var5, this.field_932.field_1025);
                    }
                }
                this.method_1231();
            }
        }
    }

    public void logNoClassFileCreated(String var1, String var2, IOException var3) {
        if ((this.tagBits & 1) != 0) {
            this.field_929.put("message", this.field_932.bind("output.noClassFileCreated", new String[] {var1, var2, var3.getMessage()}));
            this.method_1266("error", this.field_929, true, true);
        }
        this.method_1261(this.field_932.bind("output.noClassFileCreated", new String[] {var1, var2, var3.getMessage()}));
    }

    public void method_1248(int var1) {
        if ((this.tagBits & 1) != 0) {
            this.field_929.put("value", new Integer(var1));
            this.method_1266("number_of_classfiles", this.field_929, true, true);
        }
        if (var1 == 1) {
            this.method_1262(this.field_932.bind("compile.oneClassFileGenerated"));
        } else {
            this.method_1262(this.field_932.bind("compile.severalClassFilesGenerated", String.valueOf(var1)));
        }
    }

    public void method_1249(String var1) {
        if ((this.tagBits & 1) != 0) {
            this.field_929.put("message", var1);
            this.method_1266("error", this.field_929, true, true);
        }
        this.method_1261(var1);
    }

    private void logProblem(CategorizedProblem var1, int var2, int var3, char[] var4) {
        String var5;
        if ((this.tagBits & 2) != 0) {
            var5 = new String(var1.method_1400()) + ":" + var1.method_1403() + ": " + (var1.method_1399() ? this.field_932.bind("output.emacs.error") : this.field_932.bind("output.emacs.warning")) + ": " + var1.method_1404();
            this.method_1261(var5);
            String var6 = this.errorReportSource(var1, var4, this.tagBits);
            if (var6.length() != 0) {
                this.method_1261(var6);
            }
        } else {
            if (var2 == 0) {
                this.method_1261("----------");
            }
            this.method_1259(var1.method_1399() ? this.field_932.bind("requestor.error", Integer.toString(var3), new String(var1.method_1400())) : this.field_932.bind("requestor.warning", Integer.toString(var3), new String(var1.method_1400())));
            try {
                var5 = this.errorReportSource(var1, var4, 0);
                this.method_1261(var5);
                this.method_1261(var1.method_1404());
            } catch (Exception var7) {
                this.method_1261(this.field_932.bind("requestor.notRetrieveErrorMessage", var1.toString()));
            }
            this.method_1261("----------");
        }
    }

    public int logProblems(CategorizedProblem[] var1, char[] var2, Main var3) {
        int var4 = var1.length;
        int var5 = 0;
        int var6 = 0;
        if (var4 != 0) {
            int var7 = 0;
            int var8 = 0;
            int var9 = 0;
            int var10;
            CategorizedProblem var11;
            for (var10 = 0; var10 < var4; ++var10) {
                var11 = var1[var10];
                if (var11 != null) {
                    ++this.field_932.field_1025;
                    this.logProblem(var11, var6, this.field_932.field_1025, var2);
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
            if ((this.tagBits & 1) != 0) {
                if (var7 + var8 != 0) {
                    this.startLoggingProblems(var7, var8);
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

    public void logProblemsSummary(int var1, int var2, int var3, int var4) {
        if ((this.tagBits & 1) != 0) {
            this.field_929.put("problems", new Integer(var1));
            this.field_929.put("errors", new Integer(var2));
            this.field_929.put("warnings", new Integer(var3));
            this.field_929.put("tasks", new Integer(var4));
            this.method_1266("problem_summary", this.field_929, true, true);
        }
        String var5;
        if (var1 == 1) {
            var5 = null;
            if (var2 == 1) {
                var5 = this.field_932.bind("compile.oneError");
            } else {
                var5 = this.field_932.bind("compile.oneWarning");
            }
            this.method_1259(this.field_932.bind("compile.oneProblem", var5));
        } else {
            var5 = null;
            String var6 = null;
            if (var2 > 0) {
                if (var2 == 1) {
                    var5 = this.field_932.bind("compile.oneError");
                } else {
                    var5 = this.field_932.bind("compile.severalErrors", String.valueOf(var2));
                }
            }
            int var7 = var3 + var4;
            if (var7 > 0) {
                if (var7 == 1) {
                    var6 = this.field_932.bind("compile.oneWarning");
                } else {
                    var6 = this.field_932.bind("compile.severalWarnings", String.valueOf(var7));
                }
            }
            if (var5 != null && var6 != null) {
                this.method_1259(this.field_932.bind("compile.severalProblemsErrorsAndWarnings", new String[] {String.valueOf(var1), var5, var6}));
            } else if (var5 == null) {
                this.method_1259(this.field_932.bind("compile.severalProblemsErrorsOrWarnings", String.valueOf(var1), var6));
            } else {
                this.method_1259(this.field_932.bind("compile.severalProblemsErrorsOrWarnings", String.valueOf(var1), var5));
            }
        }
        if ((this.tagBits & 2) != 0) {
            this.method_1260();
        }
    }

    public void method_1253() {
        this.printOut('.');
    }

    public void logRepetition(int var1, int var2) {
        this.method_1262(this.field_932.bind("compile.repetition", String.valueOf(var1 + 1), String.valueOf(var2)));
    }

    public void logTiming(CompilerStats var1) {
        long var2 = var1.elapsedTime();
        long var4 = var1.field_1969;
        if ((this.tagBits & 1) != 0) {
            this.field_929.put("value", new Long(var2));
            this.method_1266("time", this.field_929, true, true);
            this.field_929.put("value", new Long(var4));
            this.method_1266("number_of_lines", this.field_929, true, true);
        }
        if (var4 != 0L) {
            this.method_1262(this.field_932.bind("compile.instantTime", new String[] {String.valueOf(var4), String.valueOf(var2), String.valueOf((double)((int)((double)var4 * 10000.0D / (double)var2)) / 10.0D)}));
        } else {
            this.method_1262(this.field_932.bind("compile.totalTime", new String[] {String.valueOf(var2)}));
        }
        if ((this.field_932.field_1040 & 2) != 0) {
            this.method_1262(this.field_932.bind("compile.detailedTime", new String[] {String.valueOf(var1.field_1970), String.valueOf((double)((int)((double)var1.field_1970 * 1000.0D / (double)var2)) / 10.0D), String.valueOf(var1.field_1971), String.valueOf((double)((int)((double)var1.field_1971 * 1000.0D / (double)var2)) / 10.0D), String.valueOf(var1.field_1972), String.valueOf((double)((int)((double)var1.field_1972 * 1000.0D / (double)var2)) / 10.0D), String.valueOf(var1.field_1973), String.valueOf((double)((int)((double)var1.field_1973 * 1000.0D / (double)var2)) / 10.0D)}));
        }
    }

    private void method_1256(CategorizedProblem var1, int var2, int var3) {
        int var4 = var1.method_1401();
        int var5 = var1.method_1402();
        boolean var6 = var1.method_1399();
        this.field_929.put("severity", var6 ? "ERROR" : "WARNING");
        this.field_929.put("line", new Integer(var1.method_1403()));
        this.field_929.put("charStart", new Integer(var4));
        this.field_929.put("charEnd", new Integer(var5));
        this.method_1266("extra_problem", this.field_929, true, false);
        this.field_929.put("value", var1.method_1404());
        this.method_1266("message", this.field_929, true, true);
        this.extractContext(var1, (char[])null);
        this.method_1236("extra_problem");
    }

    private void method_1257(CategorizedProblem var1, char[] var2) {
        int var3 = var1.method_1401();
        int var4 = var1.method_1402();
        int var5 = var1.method_1398();
        this.field_929.put("id", this.method_1240(var5));
        this.field_929.put("problemID", new Integer(var5));
        boolean var6 = var1.method_1399();
        int var7 = var6 ? 1 : 0;
        this.field_929.put("severity", var6 ? "ERROR" : "WARNING");
        this.field_929.put("line", new Integer(var1.method_1403()));
        this.field_929.put("charStart", new Integer(var3));
        this.field_929.put("charEnd", new Integer(var4));
        String var8 = this.method_1241(var5);
        if (var8 != null) {
            this.field_929.put("optionKey", var8);
        }
        int var9 = ProblemReporter.getProblemCategory(var7, var5);
        this.field_929.put("categoryID", new Integer(var9));
        this.method_1266("problem", this.field_929, true, false);
        this.field_929.put("value", var1.method_1404());
        this.method_1266("message", this.field_929, true, true);
        this.extractContext(var1, var2);
        String[] var10 = var1.getArguments();
        int var11 = var10.length;
        if (var11 != 0) {
            this.method_1266("arguments", (HashMap)null, true, false);
            for (int var12 = 0; var12 < var11; ++var12) {
                this.field_929.put("value", var10[var12]);
                this.method_1266("argument", this.field_929, true, true);
            }
            this.method_1236("arguments");
        }
        this.method_1236("problem");
    }

    private void method_1258(CategorizedProblem var1, char[] var2) {
        this.field_929.put("line", new Integer(var1.method_1403()));
        this.field_929.put("charStart", new Integer(var1.method_1401()));
        this.field_929.put("charEnd", new Integer(var1.method_1402()));
        String var3 = this.method_1241(var1.method_1398());
        if (var3 != null) {
            this.field_929.put("optionKey", var3);
        }
        this.method_1266("task", this.field_929, true, false);
        this.field_929.put("value", var1.method_1404());
        this.method_1266("message", this.field_929, true, true);
        this.extractContext(var1, var2);
        this.method_1236("task");
    }

    private void method_1259(String var1) {
        eclipse.instance.printErrLn(var1);
        if ((this.tagBits & 1) == 0 && this.field_927 != null) {
            this.field_927.print(var1);
        }
    }

    private void method_1260() {
        this.field_926.println();
        if ((this.tagBits & 1) == 0 && this.field_927 != null) {
            this.field_927.println();
        }
    }

    private void method_1261(String var1) {
        eclipse.instance.printErrLn(var1);
        if ((this.tagBits & 1) == 0 && this.field_927 != null) {
            this.field_927.println(var1);
        }
    }

    private void method_1262(String var1) {
        eclipse.instance.println(var1);
        if ((this.tagBits & 1) == 0 && this.field_927 != null) {
            this.field_927.println(var1);
        }
    }

    public void printNewLine() {
        eclipse.instance.println("");
    }

    private void printOut(char var1) {
        eclipse.instance.print(String.valueOf(var1));
    }

    public void method_1265() {
        Main var10001 = this.field_932;
        boolean var1 = (this.field_932.field_1040 & 1) != 0;
        if ((this.tagBits & 1) != 0) {
            this.method_1266("stats", (HashMap)null, true, false);
        }
        if (var1) {
            CompilerStats var2 = this.field_932.batchCompiler.stats;
            var2.field_1967 = this.field_932.field_1037;
            var2.field_1968 = System.currentTimeMillis();
            this.logTiming(var2);
        }
        if (this.field_932.field_1025 > 0) {
            this.logProblemsSummary(this.field_932.field_1025, this.field_932.field_1024, this.field_932.field_1027, this.field_932.field_1026);
        }
        if (this.field_932.field_1021 != 0 && (this.field_932.field_1036 || var1 || this.field_932.field_1042)) {
            this.method_1248(this.field_932.field_1021);
        }
        if ((this.tagBits & 1) != 0) {
            this.method_1236("stats");
        }
    }

    private void method_1266(String var1, HashMap var2, boolean var3, boolean var4) {
        if (this.field_927 != null) {
            ((GenericXMLWriter)this.field_927).method_1191(var1, this.field_929, true, var3, var4);
        }
        this.field_929.clear();
    }

    private void startLoggingExtraProblems(int var1) {
        this.field_929.put("problems", new Integer(var1));
        this.method_1266("extra_problems", this.field_929, true, false);
    }

    private void startLoggingProblems(int var1, int var2) {
        this.field_929.put("problems", new Integer(var1 + var2));
        this.field_929.put("errors", new Integer(var1));
        this.field_929.put("warnings", new Integer(var2));
        this.method_1266("problems", this.field_929, true, false);
    }

    public void startLoggingSource(CompilationResult var1) {
        if ((this.tagBits & 1) != 0) {
            ICompilationUnit var2 = var1.compilationUnit;
            if (var2 != null) {
                String var3 = var2.method_50();
                File var10000 = new File(var3);
                File var4 = var10000;
                if (var3 != null) {
                    this.field_929.put("path", var4.getPath());
                }
                char[][] var5 = var1.field_1693;
                if (var5 != null) {
                    this.field_929.put("package", new String(CharOperation.concatWith(var5, '/')));
                }
                CompilationUnit var6 = (CompilationUnit)var2;
                String var7 = var6.field_1011;
                if (var7 == null) {
                    var7 = this.field_932.field_1018;
                }
                if (var7 != null) {
                    Main var10001 = this.field_932;
                    if (var7 != "none") {
                        this.field_929.put("output", var7);
                    }
                }
            }
            this.method_1266("source", this.field_929, true, false);
        }
    }

    public void method_1270() {
        if ((this.tagBits & 1) != 0) {
            this.method_1266("sources", (HashMap)null, true, false);
        }
    }

    public void method_1271(int var1) {
        if ((this.tagBits & 1) != 0) {
            this.field_929.put("tasks", new Integer(var1));
            this.method_1266("tasks", this.field_929, true, false);
        }
    }

    static {
        HashtableOfInt var10000 = new HashtableOfInt();
        FIELD_TABLE = var10000;
    }
}
