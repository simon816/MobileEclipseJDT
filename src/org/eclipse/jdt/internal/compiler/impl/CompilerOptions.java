package org.eclipse.jdt.internal.compiler.impl;

import java.util.Map;
import java.util.HashMap;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.util.Util;

public class CompilerOptions {

    public long field_1924;

    public long field_1925;

    public int field_1926;

    public long field_1927;

    public long field_1928;

    public long field_1929;

    public String field_1930;

    public boolean field_1931;

    public boolean field_1932;

    public boolean field_1933;

    public boolean field_1934;

    public int field_1935;

    public char[][] field_1936;

    public char[][] field_1937;

    public boolean field_1938;

    public boolean field_1939;

    public boolean field_1940;

    public boolean field_1941;

    public boolean field_1942;

    public boolean field_1943;

    public boolean field_1944;

    public boolean field_1945;

    public boolean field_1946;

    public boolean field_1947;

    public int field_1948;

    public boolean field_1949;

    public boolean field_1950;

    public boolean field_1951;

    public String field_1952;

    public int field_1953;

    public boolean field_1954;

    public int field_1955;

    public boolean field_1956;

    public boolean field_1957;

    public boolean field_1958;

    public boolean field_1959;

    public boolean field_1960;

    public boolean field_1961;

    public boolean field_1962;

    public boolean field_1963;

    public boolean field_1964;

    public boolean field_1965;

    public static final String[] warningTokens;

    public CompilerOptions() {
        this.field_1924 = 0L;
        this.field_1925 = 27154500175326815L;
        this.field_1926 = 3;
        this.field_1927 = 3145728L;
        this.field_1928 = 3080192L;
        this.field_1929 = 3014656L;
        this.field_1930 = null;
        this.field_1931 = Compiler.DEBUG;
        this.field_1932 = false;
        this.field_1933 = false;
        this.field_1934 = true;
        this.field_1935 = 100;
        this.field_1936 = (char[][])null;
        this.field_1937 = (char[][])null;
        this.field_1938 = true;
        this.field_1939 = false;
        this.field_1940 = false;
        this.field_1941 = false;
        this.field_1942 = false;
        this.field_1943 = true;
        this.field_1944 = false;
        this.field_1945 = true;
        this.field_1946 = true;
        this.field_1947 = false;
        this.field_1948 = 1;
        this.field_1949 = false;
        this.field_1950 = false;
        this.field_1951 = false;
        this.field_1952 = "return_tag";
        this.field_1953 = 1;
        this.field_1954 = false;
        this.field_1955 = 1;
        this.field_1956 = false;
        this.field_1957 = false;
        this.field_1958 = false;
        this.field_1959 = true;
        this.field_1960 = true;
        this.field_1961 = true;
        this.field_1962 = true;
        this.field_1963 = false;
        this.field_1964 = true;
        this.field_1965 = false;
    }

    public CompilerOptions(Map var1) {
        this.field_1924 = 0L;
        this.field_1925 = 27154500175326815L;
        this.field_1926 = 3;
        this.field_1927 = 3145728L;
        this.field_1928 = 3080192L;
        this.field_1929 = 3014656L;
        this.field_1930 = null;
        this.field_1931 = Compiler.DEBUG;
        this.field_1932 = false;
        this.field_1933 = false;
        this.field_1934 = true;
        this.field_1935 = 100;
        this.field_1936 = (char[][])null;
        this.field_1937 = (char[][])null;
        this.field_1938 = true;
        this.field_1939 = false;
        this.field_1940 = false;
        this.field_1941 = false;
        this.field_1942 = false;
        this.field_1943 = true;
        this.field_1944 = false;
        this.field_1945 = true;
        this.field_1946 = true;
        this.field_1947 = false;
        this.field_1948 = 1;
        this.field_1949 = false;
        this.field_1950 = false;
        this.field_1951 = false;
        this.field_1952 = "return_tag";
        this.field_1953 = 1;
        this.field_1954 = false;
        this.field_1955 = 1;
        this.field_1956 = false;
        this.field_1957 = false;
        this.field_1958 = false;
        this.field_1959 = true;
        this.field_1960 = true;
        this.field_1961 = true;
        this.field_1962 = true;
        this.field_1963 = false;
        this.field_1964 = true;
        this.field_1965 = false;
        if (var1 != null) {
            this.method_3316(var1);
        }
    }

    public Map method_3311() {
        HashMap var10000 = new HashMap(30);
        HashMap var1 = var10000;
        var1.put("org.eclipse.jdt.core.compiler.debug.localVariable", (this.field_1926 & 4) != 0 ? "generate" : "do not generate");
        var1.put("org.eclipse.jdt.core.compiler.debug.lineNumber", (this.field_1926 & 2) != 0 ? "generate" : "do not generate");
        var1.put("org.eclipse.jdt.core.compiler.debug.sourceFile", (this.field_1926 & 1) != 0 ? "generate" : "do not generate");
        var1.put("org.eclipse.jdt.core.compiler.codegen.unusedLocal", this.field_1933 ? "preserve" : "optimize out");
        var1.put("org.eclipse.jdt.core.compiler.doc.comment.support", this.field_1958 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.methodWithConstructorName", this.method_3314(1L));
        var1.put("org.eclipse.jdt.core.compiler.problem.overridingPackageDefaultMethod", this.method_3314(2L));
        var1.put("org.eclipse.jdt.core.compiler.problem.deprecation", this.method_3314(4L));
        var1.put("org.eclipse.jdt.core.compiler.problem.deprecationInDeprecatedCode", this.field_1939 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.deprecationWhenOverridingDeprecatedMethod", this.field_1940 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.hiddenCatchBlock", this.method_3314(8L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedLocal", this.method_3314(16L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedParameter", this.method_3314(32L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedImport", this.method_3314(1024L));
        var1.put("org.eclipse.jdt.core.compiler.problem.syntheticAccessEmulation", this.method_3314(128L));
        var1.put("org.eclipse.jdt.core.compiler.problem.noEffectAssignment", this.method_3314(8192L));
        var1.put("org.eclipse.jdt.core.compiler.problem.nonExternalizedStringLiteral", this.method_3314(256L));
        var1.put("org.eclipse.jdt.core.compiler.problem.noImplicitStringConversion", this.method_3314(64L));
        var1.put("org.eclipse.jdt.core.compiler.problem.staticAccessReceiver", this.method_3314(2048L));
        var1.put("org.eclipse.jdt.core.compiler.problem.indirectStaticAccess", this.method_3314(268435456L));
        var1.put("org.eclipse.jdt.core.compiler.problem.incompatibleNonInheritedInterfaceMethod", this.method_3314(16384L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedPrivateMember", this.method_3314(32768L));
        var1.put("org.eclipse.jdt.core.compiler.problem.localVariableHiding", this.method_3314(65536L));
        var1.put("org.eclipse.jdt.core.compiler.problem.fieldHiding", this.method_3314(131072L));
        var1.put("org.eclipse.jdt.core.compiler.problem.typeParameterHiding", this.method_3314(549755813888L));
        var1.put("org.eclipse.jdt.core.compiler.problem.possibleAccidentalBooleanAssignment", this.method_3314(262144L));
        var1.put("org.eclipse.jdt.core.compiler.problem.emptyStatement", this.method_3314(524288L));
        var1.put("org.eclipse.jdt.core.compiler.problem.assertIdentifier", this.method_3314(512L));
        var1.put("org.eclipse.jdt.core.compiler.problem.enumIdentifier", this.method_3314(8589934592L));
        var1.put("org.eclipse.jdt.core.compiler.problem.undocumentedEmptyBlock", this.method_3314(134217728L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unnecessaryTypeCheck", this.method_3314(67108864L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unnecessaryElse", this.method_3314(536870912L));
        var1.put("org.eclipse.jdt.core.compiler.problem.autoboxing", this.method_3314(137438953472L));
        var1.put("org.eclipse.jdt.core.compiler.problem.annotationSuperInterface", this.method_3314(274877906944L));
        var1.put("org.eclipse.jdt.core.compiler.problem.incompleteEnumSwitch", this.method_3314(2199023255552L));
        var1.put("org.eclipse.jdt.core.compiler.problem.finallyBlockNotCompletingNormally", this.method_3314(16777216L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownException", this.method_3314(8388608L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionWhenOverriding", this.field_1944 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionIncludeDocCommentReference", this.field_1945 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionExemptExceptionAndThrowable", this.field_1946 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unqualifiedFieldAccess", this.method_3314(4194304L));
        var1.put("org.eclipse.jdt.core.compiler.problem.uncheckedTypeOperation", this.method_3314(1073741824L));
        var1.put("org.eclipse.jdt.core.compiler.problem.rawTypeReference", this.method_3314(35184372088832L));
        var1.put("org.eclipse.jdt.core.compiler.problem.finalParameterBound", this.method_3314(2147483648L));
        var1.put("org.eclipse.jdt.core.compiler.problem.missingSerialVersion", this.method_3314(4294967296L));
        var1.put("org.eclipse.jdt.core.compiler.problem.forbiddenReference", this.method_3314(17179869184L));
        var1.put("org.eclipse.jdt.core.compiler.problem.discouragedReference", this.method_3314(8796093022208L));
        var1.put("org.eclipse.jdt.core.compiler.problem.varargsArgumentNeedCast", this.method_3314(34359738368L));
        var1.put("org.eclipse.jdt.core.compiler.problem.missingOverrideAnnotation", this.method_3314(1099511627776L));
        var1.put("org.eclipse.jdt.core.compiler.problem.missingDeprecatedAnnotation", this.method_3314(4398046511104L));
        var1.put("org.eclipse.jdt.core.compiler.problem.incompleteEnumSwitch", this.method_3314(2199023255552L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedLabel", this.method_3314(70368744177664L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedTypeArgumentsForMethodInvocation", this.method_3314(9007199254740992L));
        var1.put("org.eclipse.jdt.core.compiler.compliance", method_3319(this.field_1927));
        var1.put("org.eclipse.jdt.core.compiler.source", method_3319(this.field_1928));
        var1.put("org.eclipse.jdt.core.compiler.codegen.targetPlatform", method_3319(this.field_1929));
        var1.put("org.eclipse.jdt.core.compiler.problem.fatalOptionalError", this.field_1960 ? "enabled" : "disabled");
        if (this.field_1930 != null) {
            var1.put("org.eclipse.jdt.core.encoding", this.field_1930);
        }
        var1.put("org.eclipse.jdt.core.compiler.taskTags", this.field_1936 == null ? Util.field_982 : new String(CharOperation.concatWith(this.field_1936, ',')));
        var1.put("org.eclipse.jdt.core.compiler.taskPriorities", this.field_1937 == null ? Util.field_982 : new String(CharOperation.concatWith(this.field_1937, ',')));
        var1.put("org.eclipse.jdt.core.compiler.taskCaseSensitive", this.field_1938 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedParameterWhenImplementingAbstract", this.field_1941 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedParameterWhenOverridingConcrete", this.field_1942 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedParameterIncludeDocCommentReference", this.field_1943 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.specialParameterHidingField", this.field_1947 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.maxProblemPerUnit", String.valueOf(this.field_1935));
        var1.put("org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode", this.field_1957 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.nullReference", this.method_3314(68719476736L));
        var1.put("org.eclipse.jdt.core.compiler.problem.potentialNullReference", this.method_3314(1125899906842624L));
        var1.put("org.eclipse.jdt.core.compiler.problem.redundantNullCheck", this.method_3314(2251799813685248L));
        var1.put("org.eclipse.jdt.core.compiler.problem.suppressWarnings", this.field_1959 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.unhandledWarningToken", this.method_3314(17592186044416L));
        var1.put("org.eclipse.jdt.core.compiler.problem.unusedWarningToken", this.method_3314(18014398509481984L));
        var1.put("org.eclipse.jdt.core.compiler.problem.parameterAssignment", this.method_3314(140737488355328L));
        var1.put("org.eclipse.jdt.core.compiler.problem.fallthroughCase", this.method_3314(281474976710656L));
        var1.put("org.eclipse.jdt.core.compiler.problem.overridingMethodWithoutSuperInvocation", this.method_3314(562949953421312L));
        var1.put("org.eclipse.jdt.core.compiler.generateClassFiles", this.field_1964 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.processAnnotations", this.field_1965 ? "enabled" : "disabled");
        var1.put("org.eclipse.jdt.core.compiler.problem.redundantSuperinterface", this.method_3314(36028797018963968L));
        return var1;
    }

    public static String method_3312(long var0) {
        int var2 = (int)var0;
        if ((long)var2 == var0) {
            switch (var2) {
                case Integer.MIN_VALUE:
                    return "org.eclipse.jdt.core.compiler.problem.finalParameterBound";
                case 1:
                    return "org.eclipse.jdt.core.compiler.problem.methodWithConstructorName";
                case 2:
                    return "org.eclipse.jdt.core.compiler.problem.overridingPackageDefaultMethod";
                case 4:
                case 33554436:
                    return "org.eclipse.jdt.core.compiler.problem.deprecation";
                case 8:
                    return "org.eclipse.jdt.core.compiler.problem.hiddenCatchBlock";
                case 16:
                    return "org.eclipse.jdt.core.compiler.problem.unusedLocal";
                case 32:
                    return "org.eclipse.jdt.core.compiler.problem.unusedParameter";
                case 64:
                    return "org.eclipse.jdt.core.compiler.problem.noImplicitStringConversion";
                case 128:
                    return "org.eclipse.jdt.core.compiler.problem.syntheticAccessEmulation";
                case 256:
                    return "org.eclipse.jdt.core.compiler.problem.nonExternalizedStringLiteral";
                case 512:
                    return "org.eclipse.jdt.core.compiler.problem.assertIdentifier";
                case 1024:
                    return "org.eclipse.jdt.core.compiler.problem.unusedImport";
                case 2048:
                    return "org.eclipse.jdt.core.compiler.problem.staticAccessReceiver";
                case 4096:
                    return "org.eclipse.jdt.core.compiler.taskTags";
                case 8192:
                    return "org.eclipse.jdt.core.compiler.problem.noEffectAssignment";
                case 16384:
                    return "org.eclipse.jdt.core.compiler.problem.incompatibleNonInheritedInterfaceMethod";
                case '\u8000':
                    return "org.eclipse.jdt.core.compiler.problem.unusedPrivateMember";
                case 65536:
                    return "org.eclipse.jdt.core.compiler.problem.localVariableHiding";
                case 131072:
                    return "org.eclipse.jdt.core.compiler.problem.fieldHiding";
                case 262144:
                    return "org.eclipse.jdt.core.compiler.problem.possibleAccidentalBooleanAssignment";
                case 524288:
                    return "org.eclipse.jdt.core.compiler.problem.emptyStatement";
                case 4194304:
                    return "org.eclipse.jdt.core.compiler.problem.unqualifiedFieldAccess";
                case 8388608:
                    return "org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionWhenOverriding";
                case 16777216:
                    return "org.eclipse.jdt.core.compiler.problem.finallyBlockNotCompletingNormally";
                case 67108864:
                    return "org.eclipse.jdt.core.compiler.problem.unnecessaryTypeCheck";
                case 134217728:
                    return "org.eclipse.jdt.core.compiler.problem.undocumentedEmptyBlock";
                case 268435456:
                    return "org.eclipse.jdt.core.compiler.problem.indirectStaticAccess";
                case 536870912:
                    return "org.eclipse.jdt.core.compiler.problem.unnecessaryElse";
                case 1073741824:
                    return "org.eclipse.jdt.core.compiler.problem.uncheckedTypeOperation";
            }
        } else {
            var2 = (int)(var0 >>> 32);
            switch (var2) {
                case 1:
                    return "org.eclipse.jdt.core.compiler.problem.missingSerialVersion";
                case 2:
                    return "org.eclipse.jdt.core.compiler.problem.enumIdentifier";
                case 4:
                    return "org.eclipse.jdt.core.compiler.problem.forbiddenReference";
                case 8:
                    return "org.eclipse.jdt.core.compiler.problem.varargsArgumentNeedCast";
                case 16:
                    return "org.eclipse.jdt.core.compiler.problem.nullReference";
                case 32:
                    return "org.eclipse.jdt.core.compiler.problem.autoboxing";
                case 64:
                    return "org.eclipse.jdt.core.compiler.problem.annotationSuperInterface";
                case 128:
                    return "org.eclipse.jdt.core.compiler.problem.typeParameterHiding";
                case 256:
                    return "org.eclipse.jdt.core.compiler.problem.missingOverrideAnnotation";
                case 512:
                    return "org.eclipse.jdt.core.compiler.problem.incompleteEnumSwitch";
                case 1024:
                    return "org.eclipse.jdt.core.compiler.problem.missingDeprecatedAnnotation";
                case 2048:
                    return "org.eclipse.jdt.core.compiler.problem.discouragedReference";
                case 4096:
                    return "org.eclipse.jdt.core.compiler.problem.unhandledWarningToken";
                case 8192:
                    return "org.eclipse.jdt.core.compiler.problem.rawTypeReference";
                case 16384:
                    return "org.eclipse.jdt.core.compiler.problem.unusedLabel";
                case '\u8000':
                    return "org.eclipse.jdt.core.compiler.problem.parameterAssignment";
                case 65536:
                    return "org.eclipse.jdt.core.compiler.problem.fallthroughCase";
                case 131072:
                    return "org.eclipse.jdt.core.compiler.problem.overridingMethodWithoutSuperInvocation";
                case 262144:
                    return "org.eclipse.jdt.core.compiler.problem.potentialNullReference";
                case 524288:
                    return "org.eclipse.jdt.core.compiler.problem.redundantNullCheck";
                case 2097152:
                    return "org.eclipse.jdt.core.compiler.problem.unusedTypeArgumentsForMethodInvocation";
                case 4194304:
                    return "org.eclipse.jdt.core.compiler.problem.unusedWarningToken";
                case 8388608:
                    return "org.eclipse.jdt.core.compiler.problem.redundantSuperinterface";
            }
        }
        return null;
    }

    public int method_3313(long var1) {
        return (this.field_1924 & var1) != 0L ? ((var1 & 18014398509481984L) != 0L ? 33 : (this.field_1960 ? 161 : 33)) : ((this.field_1925 & var1) != 0L ? 32 : -1);
    }

    public String method_3314(long var1) {
        return (this.field_1924 & var1) != 0L ? "error" : ((this.field_1925 & var1) != 0L ? "warning" : "ignore");
    }

    public String method_3315(int var1) {
        switch (var1 & 7) {
            case 1:
                return "public";
            case 2:
                return "private";
            case 3:
            default:
                return "default";
            case 4:
                return "protected";
        }
    }

    public void method_3316(Map var1) {
        Object var2;
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.debug.localVariable")) != null) {
            if ("generate".equals(var2)) {
                this.field_1926 |= 4;
            } else if ("do not generate".equals(var2)) {
                this.field_1926 &= -5;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.debug.lineNumber")) != null) {
            if ("generate".equals(var2)) {
                this.field_1926 |= 2;
            } else if ("do not generate".equals(var2)) {
                this.field_1926 &= -3;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.debug.sourceFile")) != null) {
            if ("generate".equals(var2)) {
                this.field_1926 |= 1;
            } else if ("do not generate".equals(var2)) {
                this.field_1926 &= -2;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.codegen.unusedLocal")) != null) {
            if ("preserve".equals(var2)) {
                this.field_1933 = true;
            } else if ("optimize out".equals(var2)) {
                this.field_1933 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.deprecationInDeprecatedCode")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1939 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1939 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.deprecationWhenOverridingDeprecatedMethod")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1940 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1940 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionWhenOverriding")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1944 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1944 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionIncludeDocCommentReference")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1945 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1945 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownExceptionExemptExceptionAndThrowable")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1946 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1946 = false;
            }
        }
        long var3;
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.compliance")) != null) {
            var3 = versionToJdkLevel(var2);
            if (var3 != 0L) {
                this.field_1927 = var3;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.source")) != null) {
            var3 = versionToJdkLevel(var2);
            if (var3 != 0L) {
                this.field_1928 = var3;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.codegen.targetPlatform")) != null) {
            var3 = versionToJdkLevel(var2);
            if (var3 != 0L) {
                this.field_1929 = var3;
            }
            if (this.field_1929 >= 3211264L) {
                this.field_1957 = true;
            }
        }
        String var7;
        if ((var2 = var1.get("org.eclipse.jdt.core.encoding")) != null && var2 instanceof String) {
            this.field_1930 = null;
            var7 = (String)var2;
            if (var7.length() > 0) {
                try {
                    new InputStreamReader(new ByteArrayInputStream(new byte[0]), var7);
                    this.field_1930 = var7;
                } catch (UnsupportedEncodingException var6) {
                    ;
                }
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedParameterWhenImplementingAbstract")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1941 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1941 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedParameterWhenOverridingConcrete")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1942 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1942 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedParameterIncludeDocCommentReference")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1943 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1943 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.specialParameterHidingField")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1947 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1947 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.maxProblemPerUnit")) != null && var2 instanceof String) {
            var7 = (String)var2;
            try {
                int var4 = Integer.parseInt(var7);
                if (var4 >= 0) {
                    this.field_1935 = var4;
                }
            } catch (NumberFormatException var5) {
                ;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.taskTags")) != null && var2 instanceof String) {
            var7 = (String)var2;
            if (var7.length() == 0) {
                this.field_1936 = (char[][])null;
            } else {
                this.field_1936 = CharOperation.method_1384(',', var7.toCharArray());
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.taskPriorities")) != null && var2 instanceof String) {
            var7 = (String)var2;
            if (var7.length() == 0) {
                this.field_1937 = (char[][])null;
            } else {
                this.field_1937 = CharOperation.method_1384(',', var7.toCharArray());
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.taskCaseSensitive")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1938 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1938 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.codegen.inlineJsrBytecode")) != null && this.field_1929 < 3211264L) {
            if ("enabled".equals(var2)) {
                this.field_1957 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1957 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.suppressWarnings")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1959 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1959 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.fatalOptionalError")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1960 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1960 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.methodWithConstructorName")) != null) {
            this.method_3317(1L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.overridingPackageDefaultMethod")) != null) {
            this.method_3317(2L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.deprecation")) != null) {
            this.method_3317(4L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.hiddenCatchBlock")) != null) {
            this.method_3317(8L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedLocal")) != null) {
            this.method_3317(16L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedParameter")) != null) {
            this.method_3317(32L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedImport")) != null) {
            this.method_3317(1024L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedPrivateMember")) != null) {
            this.method_3317(32768L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedDeclaredThrownException")) != null) {
            this.method_3317(8388608L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.noImplicitStringConversion")) != null) {
            this.method_3317(64L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.syntheticAccessEmulation")) != null) {
            this.method_3317(128L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.localVariableHiding")) != null) {
            this.method_3317(65536L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.fieldHiding")) != null) {
            this.method_3317(131072L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.typeParameterHiding")) != null) {
            this.method_3317(549755813888L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.possibleAccidentalBooleanAssignment")) != null) {
            this.method_3317(262144L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.emptyStatement")) != null) {
            this.method_3317(524288L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.nonExternalizedStringLiteral")) != null) {
            this.method_3317(256L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.assertIdentifier")) != null) {
            this.method_3317(512L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.enumIdentifier")) != null) {
            this.method_3317(8589934592L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.staticAccessReceiver")) != null) {
            this.method_3317(2048L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.indirectStaticAccess")) != null) {
            this.method_3317(268435456L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.incompatibleNonInheritedInterfaceMethod")) != null) {
            this.method_3317(16384L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.undocumentedEmptyBlock")) != null) {
            this.method_3317(134217728L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unnecessaryTypeCheck")) != null) {
            this.method_3317(67108864L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unnecessaryElse")) != null) {
            this.method_3317(536870912L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.finallyBlockNotCompletingNormally")) != null) {
            this.method_3317(16777216L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unqualifiedFieldAccess")) != null) {
            this.method_3317(4194304L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.noEffectAssignment")) != null) {
            this.method_3317(8192L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.uncheckedTypeOperation")) != null) {
            this.method_3317(1073741824L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.rawTypeReference")) != null) {
            this.method_3317(35184372088832L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.finalParameterBound")) != null) {
            this.method_3317(2147483648L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.missingSerialVersion")) != null) {
            this.method_3317(4294967296L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.forbiddenReference")) != null) {
            this.method_3317(17179869184L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.discouragedReference")) != null) {
            this.method_3317(8796093022208L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.varargsArgumentNeedCast")) != null) {
            this.method_3317(34359738368L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.nullReference")) != null) {
            this.method_3317(68719476736L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.potentialNullReference")) != null) {
            this.method_3317(1125899906842624L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.redundantNullCheck")) != null) {
            this.method_3317(2251799813685248L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.autoboxing")) != null) {
            this.method_3317(137438953472L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.annotationSuperInterface")) != null) {
            this.method_3317(274877906944L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.missingOverrideAnnotation")) != null) {
            this.method_3317(1099511627776L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.missingDeprecatedAnnotation")) != null) {
            this.method_3317(4398046511104L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.incompleteEnumSwitch")) != null) {
            this.method_3317(2199023255552L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unhandledWarningToken")) != null) {
            this.method_3317(17592186044416L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedWarningToken")) != null) {
            this.method_3317(18014398509481984L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedLabel")) != null) {
            this.method_3317(70368744177664L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.parameterAssignment")) != null) {
            this.method_3317(140737488355328L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.fallthroughCase")) != null) {
            this.method_3317(281474976710656L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.overridingMethodWithoutSuperInvocation")) != null) {
            this.method_3317(562949953421312L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.unusedTypeArgumentsForMethodInvocation")) != null) {
            this.method_3317(9007199254740992L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.problem.redundantSuperinterface")) != null) {
            this.method_3317(36028797018963968L, var2);
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.doc.comment.support")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1958 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1958 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.generateClassFiles")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1964 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1964 = false;
            }
        }
        if ((var2 = var1.get("org.eclipse.jdt.core.compiler.processAnnotations")) != null) {
            if ("enabled".equals(var2)) {
                this.field_1965 = true;
                this.field_1963 = true;
                this.field_1958 = true;
            } else if ("disabled".equals(var2)) {
                this.field_1965 = false;
                this.field_1963 = false;
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer("CompilerOptions:");
        var1.append("\n\t- local variables debug attributes: ").append((this.field_1926 & 4) != 0 ? "ON" : " OFF");
        var1.append("\n\t- line number debug attributes: ").append((this.field_1926 & 2) != 0 ? "ON" : " OFF");
        var1.append("\n\t- source debug attributes: ").append((this.field_1926 & 1) != 0 ? "ON" : " OFF");
        var1.append("\n\t- preserve all local variables: ").append(this.field_1933 ? "ON" : " OFF");
        var1.append("\n\t- method with constructor name: ").append(this.method_3314(1L));
        var1.append("\n\t- overridden package default method: ").append(this.method_3314(2L));
        var1.append("\n\t- deprecation: ").append(this.method_3314(4L));
        var1.append("\n\t- masked catch block: ").append(this.method_3314(8L));
        var1.append("\n\t- unused local variable: ").append(this.method_3314(16L));
        var1.append("\n\t- unused parameter: ").append(this.method_3314(32L));
        var1.append("\n\t- unused import: ").append(this.method_3314(1024L));
        var1.append("\n\t- synthetic access emulation: ").append(this.method_3314(128L));
        var1.append("\n\t- assignment with no effect: ").append(this.method_3314(8192L));
        var1.append("\n\t- non externalized string: ").append(this.method_3314(256L));
        var1.append("\n\t- static access receiver: ").append(this.method_3314(2048L));
        var1.append("\n\t- indirect static access: ").append(this.method_3314(268435456L));
        var1.append("\n\t- incompatible non inherited interface method: ").append(this.method_3314(16384L));
        var1.append("\n\t- unused private member: ").append(this.method_3314(32768L));
        var1.append("\n\t- local variable hiding another variable: ").append(this.method_3314(65536L));
        var1.append("\n\t- field hiding another variable: ").append(this.method_3314(131072L));
        var1.append("\n\t- type hiding another type: ").append(this.method_3314(549755813888L));
        var1.append("\n\t- possible accidental boolean assignment: ").append(this.method_3314(262144L));
        var1.append("\n\t- superfluous semicolon: ").append(this.method_3314(524288L));
        var1.append("\n\t- uncommented empty block: ").append(this.method_3314(134217728L));
        var1.append("\n\t- unnecessary type check: ").append(this.method_3314(67108864L));
        var1.append("\n\t- javadoc comment support: ").append(this.field_1958 ? "ON" : " OFF");
        var1.append("\n\t\t+ invalid javadoc: ").append(this.method_3314(33554432L));
        var1.append("\n\t\t+ report invalid javadoc tags: ").append(this.field_1949 ? "enabled" : "disabled");
        var1.append("\n\t\t\t* deprecated references: ").append(this.field_1950 ? "enabled" : "disabled");
        var1.append("\n\t\t\t* not visible references: ").append(this.field_1951 ? "enabled" : "disabled");
        var1.append("\n\t\t+ visibility level to report invalid javadoc tags: ").append(this.method_3315(this.field_1948));
        var1.append("\n\t\t+ missing javadoc tags: ").append(this.method_3314(2097152L));
        var1.append("\n\t\t+ visibility level to report missing javadoc tags: ").append(this.method_3315(this.field_1953));
        var1.append("\n\t\t+ report missing javadoc tags in overriding methods: ").append(this.field_1954 ? "enabled" : "disabled");
        var1.append("\n\t\t+ missing javadoc comments: ").append(this.method_3314(1048576L));
        var1.append("\n\t\t+ report missing tag description option: ").append(this.field_1952);
        var1.append("\n\t\t+ visibility level to report missing javadoc comments: ").append(this.method_3315(this.field_1955));
        var1.append("\n\t\t+ report missing javadoc comments in overriding methods: ").append(this.field_1956 ? "enabled" : "disabled");
        var1.append("\n\t- finally block not completing normally: ").append(this.method_3314(16777216L));
        var1.append("\n\t- report unused declared thrown exception: ").append(this.method_3314(8388608L));
        var1.append("\n\t- report unused declared thrown exception when overriding: ").append(this.field_1944 ? "enabled" : "disabled");
        var1.append("\n\t- report unused declared thrown exception include doc comment reference: ").append(this.field_1945 ? "enabled" : "disabled");
        var1.append("\n\t- report unused declared thrown exception exempt exception and throwable: ").append(this.field_1946 ? "enabled" : "disabled");
        var1.append("\n\t- unnecessary else: ").append(this.method_3314(536870912L));
        var1.append("\n\t- JDK compliance level: " + method_3319(this.field_1927));
        var1.append("\n\t- JDK source level: " + method_3319(this.field_1928));
        var1.append("\n\t- JDK target level: " + method_3319(this.field_1929));
        var1.append("\n\t- verbose : ").append(this.field_1931 ? "ON" : "OFF");
        var1.append("\n\t- produce reference info : ").append(this.field_1932 ? "ON" : "OFF");
        var1.append("\n\t- parse literal expressions as constants : ").append(this.field_1934 ? "ON" : "OFF");
        var1.append("\n\t- encoding : ").append(this.field_1930 == null ? "<default>" : this.field_1930);
        var1.append("\n\t- task tags: ").append(this.field_1936 == null ? Util.field_982 : new String(CharOperation.concatWith(this.field_1936, ',')));
        var1.append("\n\t- task priorities : ").append(this.field_1937 == null ? Util.field_982 : new String(CharOperation.concatWith(this.field_1937, ',')));
        var1.append("\n\t- report deprecation inside deprecated code : ").append(this.field_1939 ? "enabled" : "disabled");
        var1.append("\n\t- report deprecation when overriding deprecated method : ").append(this.field_1940 ? "enabled" : "disabled");
        var1.append("\n\t- report unused parameter when implementing abstract method : ").append(this.field_1941 ? "enabled" : "disabled");
        var1.append("\n\t- report unused parameter when overriding concrete method : ").append(this.field_1942 ? "enabled" : "disabled");
        var1.append("\n\t- report unused parameter include doc comment reference : ").append(this.field_1943 ? "enabled" : "disabled");
        var1.append("\n\t- report constructor/setter parameter hiding existing field : ").append(this.field_1947 ? "enabled" : "disabled");
        var1.append("\n\t- inline JSR bytecode : ").append(this.field_1957 ? "enabled" : "disabled");
        var1.append("\n\t- unsafe type operation: ").append(this.method_3314(1073741824L));
        var1.append("\n\t- unsafe raw type: ").append(this.method_3314(35184372088832L));
        var1.append("\n\t- final bound for type parameter: ").append(this.method_3314(2147483648L));
        var1.append("\n\t- missing serialVersionUID: ").append(this.method_3314(4294967296L));
        var1.append("\n\t- varargs argument need cast: ").append(this.method_3314(34359738368L));
        var1.append("\n\t- forbidden reference to type with access restriction: ").append(this.method_3314(17179869184L));
        var1.append("\n\t- discouraged reference to type with access restriction: ").append(this.method_3314(8796093022208L));
        var1.append("\n\t- null reference: ").append(this.method_3314(68719476736L));
        var1.append("\n\t- potential null reference: ").append(this.method_3314(1125899906842624L));
        var1.append("\n\t- redundant null check: ").append(this.method_3314(2251799813685248L));
        var1.append("\n\t- autoboxing: ").append(this.method_3314(137438953472L));
        var1.append("\n\t- annotation super interface: ").append(this.method_3314(274877906944L));
        var1.append("\n\t- missing @Override annotation: ").append(this.method_3314(1099511627776L));
        var1.append("\n\t- missing @Deprecated annotation: ").append(this.method_3314(4398046511104L));
        var1.append("\n\t- incomplete enum switch: ").append(this.method_3314(2199023255552L));
        var1.append("\n\t- suppress warnings: ").append(this.field_1959 ? "enabled" : "disabled");
        var1.append("\n\t- unhandled warning token: ").append(this.method_3314(17592186044416L));
        var1.append("\n\t- unused warning token: ").append(this.method_3314(18014398509481984L));
        var1.append("\n\t- unused label: ").append(this.method_3314(70368744177664L));
        var1.append("\n\t- treat optional error as fatal: ").append(this.field_1960 ? "enabled" : "disabled");
        var1.append("\n\t- parameter assignment: ").append(this.method_3314(140737488355328L));
        var1.append("\n\t- generate class files: ").append(this.field_1964 ? "enabled" : "disabled");
        var1.append("\n\t- process annotations: ").append(this.field_1965 ? "enabled" : "disabled");
        var1.append("\n\t- unused type arguments for method/constructor invocation: ").append(this.method_3314(9007199254740992L));
        var1.append("\n\t- redundant superinterface: ").append(this.method_3314(36028797018963968L));
        return var1.toString();
    }

    void method_3317(long var1, Object var3) {
        if ("error".equals(var3)) {
            this.field_1924 |= var1;
            this.field_1925 &= ~var1;
        } else if ("warning".equals(var3)) {
            this.field_1924 &= ~var1;
            this.field_1925 |= var1;
        } else if ("ignore".equals(var3)) {
            this.field_1924 &= ~var1;
            this.field_1925 &= ~var1;
        }
    }

    public static long versionToJdkLevel(Object var0) {
        if (var0 instanceof String) {
            String var1 = (String)var0;
            if (var1.length() == 3 && var1.charAt(0) == 49 && var1.charAt(1) == 46) {
                switch (var1.charAt(2)) {
                    case 49:
                        return 2949123L;
                    case 50:
                        return 3014656L;
                    case 51:
                        return 3080192L;
                    case 52:
                        return 3145728L;
                    case 53:
                        return 3211264L;
                    case 54:
                        return 3276800L;
                    case 55:
                        return 3342336L;
                    default:
                        return 0L;
                }
            }
            if ("jsr14".equals(var0)) {
                return 3145728L;
            }
            if ("cldc1.1".equals(var0)) {
                return 2949124L;
            }
        }
        return 0L;
    }

    public static String method_3319(long var0) {
        switch ((int)(var0 >> 16)) {
            case 45:
                if (var0 == 2949123L) {
                    return "1.1";
                }
                break;
            case 46:
                if (var0 == 3014656L) {
                    return "1.2";
                }
                break;
            case 47:
                if (var0 == 3080192L) {
                    return "1.3";
                }
                break;
            case 48:
                if (var0 == 3145728L) {
                    return "1.4";
                }
                break;
            case 49:
                if (var0 == 3211264L) {
                    return "1.5";
                }
                break;
            case 50:
                if (var0 == 3276800L) {
                    return "1.6";
                }
                break;
            case 51:
                if (var0 == 3342336L) {
                    return "1.7";
                }
        }
        return Util.field_982;
    }

    public static long optionKeyToIrritant(String var0) {
        if (var0 != null && var0.length() != 0) {
            switch (var0.charAt(0)) {
                case 97:
                    if ("all".equals(var0)) {
                        return -1L;
                    }
                    break;
                case 98:
                    if ("boxing".equals(var0)) {
                        return 137438953472L;
                    }
                    break;
                case 99:
                    if ("cast".equals(var0)) {
                        return 67108864L;
                    }
                    break;
                case 100:
                    if ("deprecation".equals(var0)) {
                        return 4L;
                    }
                    if ("dep-ann".equals(var0)) {
                        return 4398046511104L;
                    }
                case 101:
                case 103:
                case 106:
                case 107:
                case 108:
                case 109:
                case 111:
                case 112:
                case 113:
                case 116:
                default:
                    break;
                case 102:
                    if ("fallthrough".equals(var0)) {
                        return 281474976710656L;
                    }
                    if ("finally".equals(var0)) {
                        return 16777216L;
                    }
                    break;
                case 104:
                    if ("hiding".equals(var0)) {
                        return 549756010504L;
                    }
                case 105:
                    if ("incomplete-switch".equals(var0)) {
                        return 2199023255552L;
                    }
                    break;
                case 110:
                    if ("nls".equals(var0)) {
                        return 256L;
                    }
                    if ("null".equals(var0)) {
                        return 3377768440004608L;
                    }
                    break;
                case 114:
                    if ("restriction".equals(var0)) {
                        return 8813272891392L;
                    }
                    break;
                case 115:
                    if ("serial".equals(var0)) {
                        return 4294967296L;
                    }
                    if ("static-access".equals(var0)) {
                        return 268437504L;
                    }
                    if ("synthetic-access".equals(var0)) {
                        return 128L;
                    }
                    if ("super".equals(var0)) {
                        return 562949953421312L;
                    }
                    break;
                case 117:
                    if ("unused".equals(var0)) {
                        return 45106365026305072L;
                    }
                    if ("unchecked".equals(var0)) {
                        return 35185445830656L;
                    }
                    if ("unqualified-field-access".equals(var0)) {
                        return 4194304L;
                    }
            }
            return 0L;
        } else {
            return 0L;
        }
    }

    static {
        warningTokens = new String[] {"all", "boxing", "cast", "dep-ann", "deprecation", "fallthrough", "finally", "hiding", "incomplete-switch", "nls", "null", "restriction", "serial", "static-access", "super", "synthetic-access", "unchecked", "unqualified-field-access", "unused"};
    }
}
