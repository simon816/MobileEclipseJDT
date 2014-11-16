package org.eclipse.jdt.internal.compiler.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ReadManager;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.DoStatement;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.ForStatement;
import org.eclipse.jdt.internal.compiler.ast.LabeledStatement;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.eclipse.jdt.internal.compiler.ast.WhileStatement;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.ContinueStatement;
import org.eclipse.jdt.internal.compiler.ast.BreakStatement;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.PostfixExpression;
import org.eclipse.jdt.internal.compiler.ast.PrefixExpression;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;
import org.eclipse.jdt.internal.compiler.ast.CombinedBinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.OR_OR_Expression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedSuperReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.eclipse.jdt.internal.compiler.ast.FloatLiteral;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.IntLiteralMinValue;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.LongLiteralMinValue;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AnnotationMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.EmptyStatement;
import org.eclipse.jdt.internal.compiler.batch.eclipse;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredField;
import org.eclipse.jdt.internal.compiler.parser.RecoveredInitializer;
import org.eclipse.jdt.internal.compiler.parser.RecoveredMethod;
import org.eclipse.jdt.internal.compiler.parser.RecoveredUnit;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredLocalVariable;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;
import org.eclipse.jdt.internal.compiler.parser.RecoveredBlock;
import org.eclipse.jdt.internal.compiler.parser.Parser$1$MethodVisitor;
import org.eclipse.jdt.internal.compiler.parser.Parser$1$TypeVisitor;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScannerData;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScanner;
import org.eclipse.jdt.internal.compiler.parser.NLSTag;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;
import org.eclipse.jdt.internal.compiler.parser.diagnose.DiagnoseParser;
import org.eclipse.jdt.internal.compiler.parser.diagnose.RangeUtil;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblemFactory;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.compiler.util.Messages;

public class Parser {

    public static char[] field_1529;

    public static char[] field_1530;

    public static char[] field_1531;

    public static short[] check_table;

    public static char[] field_1533;

    public static char[] field_1534;

    public static String[] field_1535;

    public static char[] field_1536;

    public static char[] field_1537;

    public static char[] field_1538;

    public static String[] field_1539;

    public static byte[] field_1540;

    public static int[] reverse_index;

    public static char[] field_1542;

    public static char[] field_1543;

    public static char[] field_1544;

    public static long[] rules_compliance;

    public static byte[] field_1546;

    public static char[] field_1547;

    public static char[] field_1548;

    public static char[] field_1549;

    public static char[] field_1550;

    public static char[] field_1551;

    public static char[] field_1552;

    public static char[] field_1553;

    public static byte[] field_1554;

    public static char[] field_1555;

    public static boolean VERBOSE_RECOVERY;

    protected int field_1557;

    protected int[] field_1558;

    protected int field_1559;

    protected ASTNode[] field_1560;

    public CompilationUnitDeclaration compilationUnit;

    protected RecoveredElement currentElement;

    public int field_1563;

    protected boolean field_1564;

    protected int field_1565;

    protected int field_1566;

    protected int field_1567;

    protected int field_1568;

    protected int[] field_1569;

    protected int field_1570;

    protected Expression[] expressionStack;

    public int field_1572;

    protected int field_1573;

    protected int[] field_1574;

    protected int field_1575;

    protected int[] field_1576;

    protected int field_1577;

    protected ASTNode[] field_1578;

    protected boolean field_1579;

    protected boolean field_1580;

    protected int field_1581;

    protected int[] field_1582;

    protected long[] identifierPositionStack;

    protected int field_1584;

    protected char[][] identifierStack;

    protected boolean field_1586;

    protected int field_1587;

    protected int[] field_1588;

    public int field_1589;

    protected int field_1590;

    protected int field_1591;

    protected int field_1592;

    protected int field_1593;

    protected int field_1594;

    protected int field_1595;

    protected int field_1596;

    protected int field_1597;

    protected int field_1598;

    protected int field_1599;

    protected int field_1600;

    protected int[] field_1601;

    protected int field_1602;

    protected int field_1603;

    ASTNode[] noAstNodes;

    Expression[] noExpressions;

    protected boolean field_1606;

    protected CompilerOptions options;

    protected ProblemReporter problemReporter;

    protected int field_1609;

    protected int field_1610;

    protected int field_1611;

    protected int field_1612;

    protected int[] field_1613;

    protected int field_1614;

    public ReferenceContext referenceContext;

    public boolean field_1616;

    public boolean field_1617;

    protected boolean field_1618;

    protected boolean field_1619;

    protected int field_1620;

    public boolean field_1621;

    protected boolean field_1622;

    protected TypeDeclaration[] recoveredTypes;

    protected int field_1624;

    protected int field_1625;

    protected TypeDeclaration pendingRecoveredType;

    public RecoveryScanner recoveryScanner;

    public Scanner scanner;

    protected int[] field_1629;

    protected int field_1630;

    protected int field_1631;

    protected int[] field_1632;

    protected boolean field_1633;

    protected boolean field_1634;

    protected int field_1635;

    public ReadManager readManager;

    static Class field_1637;

    public static int method_2504(int var0) {
        return field_1529[original_state(var0)];
    }

    public static final short base_check(int var0) {
        return check_table[var0 - 701];
    }

    public static int method_2506(int var0) {
        return field_1533[original_state(var0)];
    }

    public static final void initTables() throws IOException {
        byte var1 = 0;
        StringBuffer var10000 = (new StringBuffer()).append("/batch/parser");
        int var4 = var1 + 1;
        field_1534 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        char[] var2 = method_2515(var10000.append(var4).append(".rsc").toString());
        check_table = new short[var2.length];
        for (int var3 = var2.length; var3-- > 0; check_table[var3] = (short)(var2[var3] - '\u8000')) {
            ;
        }
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1529 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1530 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1536 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1537 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1555 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1538 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1553 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1548 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1552 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1547 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1551 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1549 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1550 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1533 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1540 = method_2512(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1554 = method_2512(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1546 = method_2512(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1535 = readNameTable(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        rules_compliance = method_2516(var10000.append(var4).append(".rsc").toString());
        field_1539 = method_2514("/batch/readableNames.txt");
        reverse_index = computeReverseTable(field_1555, field_1538, field_1535);
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1542 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1543 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1544 = method_2515(var10000.append(var4).append(".rsc").toString());
        field_1531 = field_1534;
    }

    public static int method_2508(int var0) {
        return field_1536[original_state(var0)];
    }

    public static int method_2509(int var0, int var1) {
        return field_1531[var0 + var1];
    }

    protected static int original_state(int var0) {
        return -base_check(var0);
    }

    protected static int[] computeReverseTable(char[] var0, char[] var1, String[] var2) {
        int[] var3 = new int[var2.length];
        int var4 = 0;
        while (var4 < var2.length) {
            int var5 = 0;
            while (true) {
                if (var5 < var0.length) {
                    if (var0[var5] != var4) {
                        ++var5;
                        continue;
                    }
                    var3[var4] = var5;
                } else {
                    for (var5 = 0; var5 < var1.length; ++var5) {
                        if (var1[var5] == var4) {
                            var3[var4] = -var5;
                            break;
                        }
                    }
                }
                ++var4;
                break;
            }
        }
        return var3;
    }

    protected static byte[] method_2512(String var0) throws IOException {
        InputStream var1 = (field_1637 == null ? (field_1637 = method_2886("j.Parser")) : field_1637).getResourceAsStream(var0);
        if (var1 == null) {
            throw new IOException(Messages.bind(Messages.field_1887, var0));
        } else {
            Object var2 = null;
            byte[] var11;
            try {
                var11 = Util.getInputStreamAsByteArray(var1, -1);
            } finally {
                try {
                    var1.close();
                } catch (IOException var9) {
                    ;
                }
            }
            return var11;
        }
    }

    protected static String[] readNameTable(String var0) throws IOException {
        char[] var1 = method_2515(var0);
        char[][] var2 = CharOperation.method_1385('\n', var1);
        String[] var3 = new String[var2.length + 1];
        var3[0] = null;
        for (int var4 = 0; var4 < var2.length; ++var4) {
            var3[var4 + 1] = new String(var2[var4]);
        }
        return var3;
    }

    protected static String[] method_2514(String var0) {
        String[] var1 = new String[field_1535.length];
        Hashtable var2 = new Hashtable();
        InputStream var3 = var0.getClass().getResourceAsStream(var0);
        label62:
        while (true) {
            try {
                while (true) {
                    if (var3.available() <= 0) {
                        break label62;
                    }
                    String var4 = DefaultProblemFactory.method_1446(var3);
                    int var5 = var4.indexOf(61);
                    if (!var4.startsWith("#") && var5 >= 0) {
                        var2.put(var4.substring(0, var5), var4.substring(var5 + 1));
                    }
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }
        try {
            var3.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }
        int var9;
        for (var9 = 0; var9 < 111; ++var9) {
            var1[var9] = field_1535[var9];
        }
        for (var9 = 110; var9 < field_1535.length; ++var9) {
            try {
                String var10 = (String)var2.get(field_1535[var9]);
                if (var10 != null && var10.length() > 0) {
                    var1[var9] = var10;
                } else {
                    var1[var9] = field_1535[var9];
                }
            } catch (Exception var7) {
                var1[var9] = field_1535[var9];
            }
        }
        return var1;
    }

    protected static char[] method_2515(String var0) throws IOException {
        InputStream var1 = (field_1637 == null ? (field_1637 = method_2886("j.Parser")) : field_1637).getResourceAsStream(var0);
        if (var1 == null) {
            throw new IOException(Messages.bind(Messages.field_1887, var0));
        } else {
            Object var2 = null;
            byte[] var12;
            try {
                var12 = Util.getInputStreamAsByteArray(var1, -1);
            } finally {
                try {
                    var1.close();
                } catch (IOException var10) {
                    ;
                }
            }
            int var3 = var12.length;
            if ((var3 & 1) != 0) {
                throw new IOException(Messages.bind(Messages.field_1888, var0));
            } else {
                char[] var4 = new char[var3 / 2];
                int var5 = 0;
                int var6 = 0;
                do {
                    var4[var6++] = (char)(((var12[var5++] & 255) << 8) + (var12[var5++] & 255));
                } while (var5 != var3);
                return var4;
            }
        }
    }

    protected static long[] method_2516(String var0) throws IOException {
        InputStream var1 = (field_1637 == null ? (field_1637 = method_2886("j.Parser")) : field_1637).getResourceAsStream(var0);
        if (var1 == null) {
            throw new IOException(Messages.bind(Messages.field_1887, var0));
        } else {
            Object var2 = null;
            byte[] var12;
            try {
                var12 = Util.getInputStreamAsByteArray(var1, -1);
            } finally {
                try {
                    var1.close();
                } catch (IOException var10) {
                    ;
                }
            }
            int var3 = var12.length;
            if (var3 % 8 != 0) {
                throw new IOException(Messages.bind(Messages.field_1888, var0));
            } else {
                long[] var4 = new long[var3 / 8];
                int var5 = 0;
                int var6 = 0;
                do {
                    var4[var6++] = ((long)(var12[var5++] & 255) << 56) + ((long)(var12[var5++] & 255) << 48) + ((long)(var12[var5++] & 255) << 40) + ((long)(var12[var5++] & 255) << 32) + ((long)(var12[var5++] & 255) << 24) + ((long)(var12[var5++] & 255) << 16) + ((long)(var12[var5++] & 255) << 8) + (long)(var12[var5++] & 255);
                } while (var5 != var3);
                return var4;
            }
        }
    }

    public static int method_2517(int var0, int var1) {
        return field_1553[field_1554[field_1531[var0] + var1] == var1 ? field_1531[var0] + var1 : field_1531[var0]];
    }

    public Parser(ProblemReporter var1, boolean var2) {
        this.field_1560 = new ASTNode[100];
        this.field_1564 = false;
        this.field_1565 = 0;
        this.expressionStack = new Expression[100];
        this.field_1574 = new int[10];
        this.field_1576 = new int[10];
        this.field_1578 = new ASTNode[10];
        this.field_1592 = -1;
        this.noAstNodes = new ASTNode[100];
        this.noExpressions = new Expression[100];
        this.field_1606 = true;
        this.field_1616 = false;
        this.field_1617 = true;
        this.field_1619 = true;
        this.field_1621 = false;
        this.field_1622 = false;
        this.field_1629 = new int[255];
        this.problemReporter = var1;
        this.options = var1.options;
        this.field_1606 = var2;
        this.method_2846();
        this.field_1558 = new int[50];
        this.field_1569 = new int[30];
        this.field_1588 = new int[50];
        this.identifierStack = new char[30][];
        this.field_1582 = new int[30];
        this.field_1601 = new int[30];
        this.field_1613 = new int[30];
        this.identifierPositionStack = new long[30];
        this.field_1632 = new int[30];
    }

    protected void method_2519(int var1, int var2) {
        if (this.field_1590 < var2) {
            this.field_1590 = var2 + 1;
        }
    }

    public void arrayInitializer(int var1) {
        ArrayInitializer var10000 = new ArrayInitializer();
        ArrayInitializer var2 = var10000;
        if (var1 != 0) {
            this.field_1570 -= var1;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var2.expressions = new Expression[var1], 0, var1);
        }
        this.method_2867(var2);
        var2.field_445 = this.field_1567;
        var2.field_444 = this.field_1588[this.field_1587--];
    }

    protected void method_2521() {
        ++this.field_1613[this.field_1612];
    }

    public RecoveredElement buildInitialRecoveryState() {
        this.field_1590 = 0;
        this.field_1592 = this.scanner.field_1231;
        Object var1 = null;
        if (this.referenceContext instanceof CompilationUnitDeclaration) {
            RecoveredUnit var8 = new RecoveredUnit(this.compilationUnit, 0, this);
            RecoveredUnit var17 = var8;
            this.compilationUnit.currentPackage = null;
            this.compilationUnit.imports = null;
            this.compilationUnit.types = null;
            this.field_1563 = 0;
            this.field_1595 = 0;
            this.field_1596 = 0;
            this.field_1566 = 0;
            this.field_1567 = 0;
            return var17;
        } else {
            FieldDeclaration var4;
            if (this.referenceContext instanceof AbstractMethodDeclaration) {
                RecoveredMethod var10000 = new RecoveredMethod((AbstractMethodDeclaration)this.referenceContext, (RecoveredElement)null, 0, this);
                var1 = var10000;
                this.field_1590 = ((AbstractMethodDeclaration)this.referenceContext).field_490;
                if (this.field_1622) {
                    Block var10001 = new Block(0);
                    var1 = ((RecoveredElement)var1).add(var10001, 0);
                }
            } else if (this.referenceContext instanceof TypeDeclaration) {
                TypeDeclaration var2 = (TypeDeclaration)this.referenceContext;
                for (int var3 = 0; var3 < var2.fields.length; ++var3) {
                    var4 = var2.fields[var3];
                    if (var4 != null && var4.getKind() == 2 && ((Initializer)var4).block != null && var4.field_653 <= this.scanner.field_1232 && this.scanner.field_1232 <= var4.field_652 && this.scanner.field_1233 <= var4.field_652 + 1) {
                        RecoveredInitializer var7 = new RecoveredInitializer(var4, (RecoveredElement)null, 1, this);
                        var1 = var7;
                        this.field_1590 = var4.field_653;
                        break;
                    }
                }
            }
            if (var1 == null) {
                return (RecoveredElement)var1;
            } else {
                for (int var5 = 0; var5 <= this.field_1559; ++var5) {
                    ASTNode var6 = this.field_1560[var5];
                    if (var6 instanceof AbstractMethodDeclaration) {
                        AbstractMethodDeclaration var9 = (AbstractMethodDeclaration)var6;
                        if (var9.field_481 == 0) {
                            var1 = ((RecoveredElement)var1).add(var9, 0);
                            this.field_1590 = var9.field_490;
                        } else {
                            var1 = ((RecoveredElement)var1).add(var9, 0);
                            this.field_1590 = var9.field_481 + 1;
                        }
                    } else if (var6 instanceof Initializer) {
                        Initializer var10 = (Initializer)var6;
                        if (var10.block != null) {
                            if (var10.field_652 == 0) {
                                var1 = ((RecoveredElement)var1).add(var10, 1);
                                this.field_1590 = var10.field_444;
                            } else {
                                var1 = ((RecoveredElement)var1).add(var10, 0);
                                this.field_1590 = var10.field_652 + 1;
                            }
                        }
                    } else if (var6 instanceof FieldDeclaration) {
                        var4 = (FieldDeclaration)var6;
                        if (var4.field_652 == 0) {
                            var1 = ((RecoveredElement)var1).add(var4, 0);
                            if (var4.initialization == null) {
                                this.field_1590 = var4.field_445 + 1;
                            } else {
                                this.field_1590 = var4.initialization.field_445 + 1;
                            }
                        } else {
                            var1 = ((RecoveredElement)var1).add(var4, 0);
                            this.field_1590 = var4.field_652 + 1;
                        }
                    } else if (var6 instanceof TypeDeclaration) {
                        TypeDeclaration var11 = (TypeDeclaration)var6;
                        if (var11.field_593 == 0) {
                            var1 = ((RecoveredElement)var1).add(var11, 0);
                            this.field_1590 = var11.field_594;
                        } else {
                            var1 = ((RecoveredElement)var1).add(var11, 0);
                            this.field_1590 = var11.field_593 + 1;
                        }
                    } else {
                        if (var6 instanceof ImportReference) {
                            ImportReference var13 = (ImportReference)var6;
                            var1 = ((RecoveredElement)var1).add(var13, 0);
                            this.field_1590 = var13.field_471 + 1;
                        }
                        if (this.field_1622) {
                            if (var6 instanceof Block) {
                                Block var12 = (Block)var6;
                                var1 = ((RecoveredElement)var1).add(var12, 0);
                                this.field_1590 = var12.field_445 + 1;
                            } else if (var6 instanceof LocalDeclaration) {
                                LocalDeclaration var15 = (LocalDeclaration)var6;
                                var1 = ((RecoveredElement)var1).add(var15, 0);
                                this.field_1590 = var15.field_445 + 1;
                            } else if (var6 instanceof Expression) {
                                if (var6 instanceof Assignment || var6 instanceof PrefixExpression || var6 instanceof PostfixExpression || var6 instanceof MessageSend || var6 instanceof AllocationExpression) {
                                    Expression var14 = (Expression)var6;
                                    var1 = ((RecoveredElement)var1).add(var14, 0);
                                    if (var14.field_673 != -1) {
                                        this.field_1590 = var14.field_673 + 1;
                                    } else {
                                        this.field_1590 = var14.field_445 + 1;
                                    }
                                }
                            } else if (var6 instanceof Statement) {
                                Statement var16 = (Statement)var6;
                                var1 = ((RecoveredElement)var1).add(var16, 0);
                                this.field_1590 = var16.field_445 + 1;
                            }
                        }
                    }
                }
                if (this.field_1622 && this.pendingRecoveredType != null && this.scanner.field_1230 - 1 <= this.pendingRecoveredType.field_593) {
                    var1 = ((RecoveredElement)var1).add(this.pendingRecoveredType, 0);
                    this.field_1590 = this.pendingRecoveredType.field_593 + 1;
                    this.pendingRecoveredType = null;
                }
                return (RecoveredElement)var1;
            }
        }
    }

    protected void method_2523(int var1) {
        if ((this.field_1599 & var1) != 0) {
            this.field_1599 |= 4194304;
        }
        this.field_1599 |= var1;
        if (this.field_1600 < 0) {
            this.field_1600 = this.scanner.field_1230;
        }
        if (this.currentElement != null && this.field_1619) {
            this.currentElement.addModifier(var1, this.field_1600);
        }
    }

    public void method_2524() {
        if ((!this.field_1564 || this.field_1565 != 0) && this.scanner.field_1245 >= 0) {
            this.flushCommentsDefinedPriorTo(this.field_1567);
        }
        int var1 = this.scanner.field_1245;
        if (this.field_1600 >= 0) {
            while (var1 >= 0 && this.scanner.field_1243[var1] > this.field_1600) {
                --var1;
            }
        }
        if (var1 >= 0) {
            for (this.field_1600 = this.scanner.field_1243[0]; var1 >= 0 && this.scanner.field_1242[var1] < 0; --var1) {
                ;
            }
        }
    }

    protected void checkNonNLSAfterBodyEnd(int var1) {
        if (this.scanner.field_1231 - 1 <= var1) {
            this.scanner.field_1233 = var1 < Integer.MAX_VALUE ? var1 + 1 : var1;
            try {
                while (true) {
                    if (this.scanner.getNextToken() != 68) {
                        continue;
                    }
                }
            } catch (InvalidInputException var3) {
                ;
            }
        }
    }

    protected void method_2526(boolean var1) {
        int var3;
        if ((var3 = this.field_1558[this.field_1557--]) == 1 && this.field_1560[this.field_1559] == null) {
            --this.field_1559;
            Object var2;
            if (var1) {
                QualifiedAllocationExpression var10000 = new QualifiedAllocationExpression();
                var2 = var10000;
            } else {
                AllocationExpression var5 = new AllocationExpression();
                var2 = var5;
            }
            ((AllocationExpression)var2).field_445 = this.field_1566;
            if ((var3 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var3;
                System.arraycopy(this.expressionStack, this.field_1570 + 1, ((AllocationExpression)var2).arguments = new Expression[var3], 0, var3);
            }
            ((AllocationExpression)var2).type = this.getTypeReference(0);
            ((AllocationExpression)var2).field_444 = this.field_1588[this.field_1587--];
            this.method_2867((Expression)var2);
        } else {
            this.method_2828(var3);
            TypeDeclaration var4 = (TypeDeclaration)this.field_1560[this.field_1559];
            var4.field_593 = this.field_1567;
            var4.field_595 = this.field_1567;
            if (var4.allocation != null) {
                var4.allocation.field_445 = this.field_1567;
            }
            if (var3 == 0 && !this.containsComment(var4.field_594, var4.field_595)) {
                var4.field_446 |= 8;
            }
            --this.field_1559;
            --this.field_1557;
        }
    }

    protected void method_2527() {
        ++this.field_1569[--this.field_1568];
    }

    protected void method_2528() {
        this.field_1576[this.field_1575 - 1] += this.field_1576[this.field_1575--];
    }

    protected void method_2529() {
        this.field_1558[this.field_1557 - 1] += this.field_1558[this.field_1557--];
    }

    protected void method_2530() {
        this.method_2869(this.getTypeReference(this.field_1588[this.field_1587--]));
    }

    protected void method_2531() {}

    protected void method_2532() {
        this.method_2528();
    }

    protected void method_2533() {
        this.method_2528();
    }

    protected void method_2534() {
        if (this.currentElement != null) {
            if (this.field_1563 == 69) {
                TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
                TypeDeclaration var1 = var10000;
                var1.name = CharOperation.NO_CHAR;
                var1.field_446 |= 768;
                var1.field_444 = this.field_1588[this.field_1587--];
                var1.field_445 = this.field_1598;
                QualifiedAllocationExpression var3 = new QualifiedAllocationExpression(var1);
                QualifiedAllocationExpression var2 = var3;
                var2.type = this.getTypeReference(0);
                var2.field_444 = var1.field_444;
                var2.field_445 = var1.field_445;
                this.field_1590 = var1.field_594 = this.scanner.field_1231;
                this.currentElement = this.currentElement.add(var1, 0);
                this.field_1593 = -1;
                this.field_1563 = 0;
            } else {
                this.field_1590 = this.scanner.field_1230;
                this.field_1618 = true;
            }
        }
    }

    protected void method_2535() {
        Expression var1 = this.expressionStack[this.field_1570];
        int var2 = var1.field_444;
        if (this.field_1600 < 0) {
            this.field_1600 = var2;
        }
    }

    protected void method_2536() {
        if (this.currentElement != null) {
            int var1 = this.field_1588[this.field_1587];
            int var2 = (int)(this.identifierPositionStack[this.field_1584] & 4294967295L);
            this.method_2519(var1, var2);
            if (this.field_1619) {
                this.currentElement = this.currentElement.addAnnotationName(this.field_1584, this.field_1581, var1, 0);
            }
        }
        this.field_1634 = false;
    }

    protected void method_2537() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2828(var1);
        }
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        var2.checkConstructors(this);
        if (this.scanner.field_1226) {
            var2.field_446 |= 1;
        }
        var2.addClinit();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.containsComment(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2538() {
        if (this.currentElement != null) {
            this.field_1618 = true;
        }
        this.scanner.field_1245 = -1;
    }

    protected void method_2539() {
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var2 = this.identifierPositionStack[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        --this.field_1587;
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 8192 | 512;
        int var4;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
            --this.field_1587;
        } else {
            var4 = this.field_1588[this.field_1587--];
            var1.field_592 = var4;
        }
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.compilationUnit != null && !CharOperation.method_1364(var1.name, this.compilationUnit.method_772())) {
            var1.field_446 |= 4096;
        }
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var4) + 1, var1.annotations = new Annotation[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1646(var1);
        }
        if (this.currentElement != null) {
            this.field_1590 = var1.field_594;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2540() {
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var1 = var10000;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeParameters = new TypeParameter[var2], 0, var2);
        this.problemReporter().method_1652(var1);
        var1.field_594 = var1.typeParameters[var2 - 1].field_652 + 1;
        this.field_1596 = 0;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var3 = this.identifierPositionStack[this.field_1584];
        var1.field_445 = (int)var3;
        var1.field_444 = (int)(var3 >>> 32);
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        --this.field_1587;
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 8192 | 512;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
            --this.field_1587;
        } else {
            int var5 = this.field_1588[this.field_1587--];
            var1.field_592 = var5;
        }
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.compilationUnit != null && !CharOperation.method_1364(var1.name, this.compilationUnit.method_772())) {
            var1.field_446 |= 4096;
        }
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var2) + 1, var1.annotations = new Annotation[var2], 0, var2);
        }
        this.method_2866(var1);
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1646(var1);
        }
        if (this.currentElement != null) {
            this.field_1590 = var1.field_594;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2541() {
        AnnotationMethodDeclaration var1 = (AnnotationMethodDeclaration)this.field_1560[this.field_1559];
        var1.field_482 |= 16777216;
        int var2 = this.flushCommentsDefinedPriorTo(this.field_1567);
        var1.field_490 = this.field_1567;
        var1.field_491 = var2;
        var1.field_481 = var2;
    }

    protected void method_2542() {
        this.method_2529();
    }

    protected void method_2543() {
        this.method_2527();
    }

    protected void method_2544() {
        this.method_2872(this.field_1598);
    }

    protected void method_2545(boolean var1) {
        ArrayReference var2;
        int var10001;
        Expression[] var10000;
        ArrayReference var10002;
        if (var1) {
            var10000 = this.expressionStack;
            var10001 = this.field_1570;
            var10002 = new ArrayReference(this.method_2839(), this.expressionStack[this.field_1570]);
            var2 = (ArrayReference)(var10000[var10001] = var10002);
        } else {
            --this.field_1570;
            --this.field_1568;
            var10000 = this.expressionStack;
            var10001 = this.field_1570;
            var10002 = new ArrayReference(this.expressionStack[this.field_1570], this.expressionStack[this.field_1570 + 1]);
            var2 = (ArrayReference)(var10000[var10001] = var10002);
        }
        var2.field_445 = this.field_1567;
    }

    protected void method_2546() {
        ArrayAllocationExpression var10000 = new ArrayAllocationExpression();
        ArrayAllocationExpression var2 = var10000;
        --this.field_1568;
        var2.initializer = (ArrayInitializer)this.expressionStack[this.field_1570--];
        var2.type = this.getTypeReference(0);
        var2.type.field_446 |= 1073741824;
        int var1 = this.field_1569[this.field_1568--];
        this.field_1570 -= var1;
        System.arraycopy(this.expressionStack, this.field_1570 + 1, var2.dimensions = new Expression[var1], 0, var1);
        var2.field_444 = this.field_1588[this.field_1587--];
        if (var2.initializer == null) {
            var2.field_445 = this.field_1567;
        } else {
            var2.field_445 = var2.initializer.field_445;
        }
        this.method_2867(var2);
    }

    protected void method_2547() {
        ArrayAllocationExpression var10000 = new ArrayAllocationExpression();
        ArrayAllocationExpression var2 = var10000;
        var2.type = this.getTypeReference(0);
        var2.type.field_446 |= 1073741824;
        int var1 = this.field_1569[this.field_1568--];
        this.field_1570 -= var1;
        System.arraycopy(this.expressionStack, this.field_1570 + 1, var2.dimensions = new Expression[var1], 0, var1);
        var2.field_444 = this.field_1588[this.field_1587--];
        if (var2.initializer == null) {
            var2.field_445 = this.field_1567;
        } else {
            var2.field_445 = var2.initializer.field_445;
        }
        this.method_2867(var2);
    }

    protected void method_2548() {}

    protected void method_2549() {
        this.arrayInitializer(this.field_1569[this.field_1568--]);
    }

    protected void method_2550() {
        this.field_1574[this.field_1573] += this.field_1582[this.field_1581];
        this.method_2871(0);
    }

    protected void method_2551() {
        this.field_1568 -= 2;
        AssertStatement var10001 = new AssertStatement(this.expressionStack[this.field_1570--], this.expressionStack[this.field_1570--], this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2552() {
        int var1 = this.field_1588[this.field_1587--];
        --this.field_1570;
        --this.field_1568;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        Object var10002;
        if (var1 != 30) {
            var10002 = new CompoundAssignment(this.expressionStack[this.field_1570], this.expressionStack[this.field_1570 + 1], var1, this.scanner.field_1230 - 1);
        } else {
            var10002 = new Assignment(this.expressionStack[this.field_1570], this.expressionStack[this.field_1570 + 1], this.scanner.field_1230 - 1);
        }
        var10000[var10001] = (Expression)var10002;
        if (this.pendingRecoveredType != null) {
            if (this.pendingRecoveredType.allocation != null && this.scanner.field_1230 - 1 <= this.pendingRecoveredType.field_593) {
                this.expressionStack[this.field_1570] = this.pendingRecoveredType.allocation;
                this.pendingRecoveredType = null;
                return;
            }
            this.pendingRecoveredType = null;
        }
    }

    protected void method_2553(int var1) {
        this.method_2872(var1);
    }

    protected void method_2554(int var1) {
        --this.field_1570;
        --this.field_1568;
        Expression var2 = this.expressionStack[this.field_1570];
        Expression var3 = this.expressionStack[this.field_1570 + 1];
        int var10001;
        Expression[] var10000;
        BinaryExpression var10002;
        switch (var1) {
            case 0:
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                AND_AND_Expression var9 = new AND_AND_Expression(var2, var3, var1);
                var10000[var10001] = var9;
                break;
            case 1:
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                OR_OR_Expression var5 = new OR_OR_Expression(var2, var3, var1);
                var10000[var10001] = var5;
                break;
            case 4:
                --this.field_1587;
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                var10002 = new BinaryExpression(var2, var3, var1);
                var10000[var10001] = var10002;
                break;
            case 14:
                CombinedBinaryExpression var4;
                CombinedBinaryExpression var6;
                BinaryExpression var7;
                CombinedBinaryExpression var8;
                if (this.field_1606) {
                    if (var2 instanceof StringLiteral) {
                        if ((var2.field_446 & 534773760) >> 21 == 0) {
                            if (var3 instanceof CharLiteral) {
                                this.expressionStack[this.field_1570] = ((StringLiteral)var2).extendWith((CharLiteral)var3);
                            } else if (var3 instanceof StringLiteral) {
                                this.expressionStack[this.field_1570] = ((StringLiteral)var2).extendWith((StringLiteral)var3);
                            } else {
                                var10000 = this.expressionStack;
                                var10001 = this.field_1570;
                                var10002 = new BinaryExpression(var2, var3, 14);
                                var10000[var10001] = var10002;
                            }
                        } else {
                            var10000 = this.expressionStack;
                            var10001 = this.field_1570;
                            var10002 = new BinaryExpression(var2, var3, 14);
                            var10000[var10001] = var10002;
                        }
                    } else if (var2 instanceof CombinedBinaryExpression) {
                        if ((var4 = (CombinedBinaryExpression)var2).field_720 < var4.field_721) {
                            var7 = new BinaryExpression(var4);
                            var4.field_715 = var7;
                            ++var4.field_720;
                        } else {
                            var8 = new CombinedBinaryExpression(var4);
                            var4.field_715 = var8;
                            var4.field_720 = 0;
                            var4.tuneArityMax();
                        }
                        var4.field_716 = var3;
                        var4.field_445 = var3.field_445;
                        this.expressionStack[this.field_1570] = var4;
                    } else if (var2 instanceof BinaryExpression && (var2.field_446 & 4032) >> 6 == 14) {
                        var10000 = this.expressionStack;
                        var10001 = this.field_1570;
                        var6 = new CombinedBinaryExpression(var2, var3, 14, 1);
                        var10000[var10001] = var6;
                    } else {
                        var10000 = this.expressionStack;
                        var10001 = this.field_1570;
                        var10002 = new BinaryExpression(var2, var3, 14);
                        var10000[var10001] = var10002;
                    }
                } else if (var2 instanceof StringLiteral) {
                    if (var3 instanceof StringLiteral && (var2.field_446 & 534773760) >> 21 == 0) {
                        this.expressionStack[this.field_1570] = ((StringLiteral)var2).extendsWith((StringLiteral)var3);
                    } else {
                        var10000 = this.expressionStack;
                        var10001 = this.field_1570;
                        var10002 = new BinaryExpression(var2, var3, 14);
                        var10000[var10001] = var10002;
                    }
                } else if (var2 instanceof CombinedBinaryExpression) {
                    if ((var4 = (CombinedBinaryExpression)var2).field_720 < var4.field_721) {
                        var7 = new BinaryExpression(var4);
                        var4.field_715 = var7;
                        var4.field_446 &= -534773761;
                        ++var4.field_720;
                    } else {
                        var8 = new CombinedBinaryExpression(var4);
                        var4.field_715 = var8;
                        var4.field_446 &= -534773761;
                        var4.field_720 = 0;
                        var4.tuneArityMax();
                    }
                    var4.field_716 = var3;
                    var4.field_445 = var3.field_445;
                    this.expressionStack[this.field_1570] = var4;
                } else if (var2 instanceof BinaryExpression && (var2.field_446 & 4032) >> 6 == 14) {
                    var10000 = this.expressionStack;
                    var10001 = this.field_1570;
                    var6 = new CombinedBinaryExpression(var2, var3, 14, 1);
                    var10000[var10001] = var6;
                } else {
                    var10000 = this.expressionStack;
                    var10001 = this.field_1570;
                    var10002 = new BinaryExpression(var2, var3, 14);
                    var10000[var10001] = var10002;
                }
                break;
            default:
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                var10002 = new BinaryExpression(var2, var3, var1);
                var10000[var10001] = var10002;
        }
    }

    protected void method_2555(int var1) {
        this.method_2867(this.method_2839());
        --this.field_1570;
        --this.field_1568;
        Expression var2 = this.expressionStack[this.field_1570 + 1];
        Expression var3 = this.expressionStack[this.field_1570];
        int var10001;
        Expression[] var10000;
        BinaryExpression var10002;
        switch (var1) {
            case 0:
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                AND_AND_Expression var5 = new AND_AND_Expression(var2, var3, var1);
                var10000[var10001] = var5;
                break;
            case 1:
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                OR_OR_Expression var4 = new OR_OR_Expression(var2, var3, var1);
                var10000[var10001] = var4;
                break;
            case 4:
                --this.field_1587;
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                var10002 = new BinaryExpression(var2, var3, var1);
                var10000[var10001] = var10002;
                break;
            case 14:
                if (this.field_1606) {
                    if (var2 instanceof StringLiteral && (var2.field_446 & 534773760) >> 21 == 0) {
                        if (var3 instanceof CharLiteral) {
                            this.expressionStack[this.field_1570] = ((StringLiteral)var2).extendWith((CharLiteral)var3);
                        } else if (var3 instanceof StringLiteral) {
                            this.expressionStack[this.field_1570] = ((StringLiteral)var2).extendWith((StringLiteral)var3);
                        } else {
                            var10000 = this.expressionStack;
                            var10001 = this.field_1570;
                            var10002 = new BinaryExpression(var2, var3, 14);
                            var10000[var10001] = var10002;
                        }
                    } else {
                        var10000 = this.expressionStack;
                        var10001 = this.field_1570;
                        var10002 = new BinaryExpression(var2, var3, 14);
                        var10000[var10001] = var10002;
                    }
                } else if (var2 instanceof StringLiteral) {
                    if (var3 instanceof StringLiteral && (var2.field_446 & 534773760) >> 21 == 0) {
                        this.expressionStack[this.field_1570] = ((StringLiteral)var2).extendsWith((StringLiteral)var3);
                    } else {
                        var10000 = this.expressionStack;
                        var10001 = this.field_1570;
                        var10002 = new BinaryExpression(var2, var3, var1);
                        var10000[var10001] = var10002;
                    }
                } else {
                    var10000 = this.expressionStack;
                    var10001 = this.field_1570;
                    var10002 = new BinaryExpression(var2, var3, var1);
                    var10000[var10001] = var10002;
                }
                break;
            default:
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                var10002 = new BinaryExpression(var2, var3, var1);
                var10000[var10001] = var10002;
        }
    }

    protected void method_2556() {
        int var1 = this.field_1558[this.field_1557--];
        Block var2;
        Block var10000;
        if (var1 == 0) {
            var10000 = new Block(0);
            var2 = var10000;
            var2.field_444 = this.field_1588[this.field_1587--];
            var2.field_445 = this.field_1567;
            if (!this.containsComment(var2.field_444, var2.field_445)) {
                var2.field_446 |= 8;
            }
            --this.field_1612;
        } else {
            var10000 = new Block(this.field_1613[this.field_1612--]);
            var2 = var10000;
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, var2.statements = new Statement[var1], 0, var1);
            var2.field_444 = this.field_1588[this.field_1587--];
            var2.field_445 = this.field_1567;
        }
        this.method_2866(var2);
    }

    protected void method_2557() {
        this.method_2529();
    }

    protected void method_2558() {
        --this.field_1568;
        Expression var1 = this.expressionStack[this.field_1570--];
        CaseStatement var10001 = new CaseStatement(var1, var1.field_445, this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2559() {
        --this.field_1570;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        Expression var2;
        CastExpression var10002 = new CastExpression(var2 = this.expressionStack[this.field_1570 + 1], this.getTypeReference(this.expressionStack[this.field_1570]));
        CastExpression var1 = var10002;
        var10000[var10001] = var10002;
        --this.field_1568;
        this.method_2885(var1);
        var1.field_445 = var2.field_445;
    }

    protected void method_2560() {
        int var4 = this.field_1588[this.field_1587--];
        int var5 = this.field_1588[this.field_1587--];
        this.method_2870(this.field_1582[this.field_1581]);
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        Expression var1;
        TypeReference var3;
        CastExpression var10002 = new CastExpression(var1 = this.expressionStack[this.field_1570], var3 = this.getTypeReference(var5));
        CastExpression var2 = var10002;
        var10000[var10001] = var10002;
        --this.field_1587;
        var3.field_445 = var4 - 1;
        var3.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected void method_2561() {
        int var4 = this.field_1588[this.field_1587--];
        this.method_2871(0);
        this.method_2870(this.field_1582[this.field_1581]);
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        Expression var1;
        TypeReference var3;
        CastExpression var10002 = new CastExpression(var1 = this.expressionStack[this.field_1570], var3 = this.getTypeReference(this.field_1588[this.field_1587--]));
        CastExpression var2 = var10002;
        var10000[var10001] = var10002;
        var3.field_445 = var4 - 1;
        var3.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected void method_2562() {
        int var4 = this.field_1588[this.field_1587--];
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        Expression var1;
        TypeReference var3;
        CastExpression var10002 = new CastExpression(var1 = this.expressionStack[this.field_1570], var3 = this.getTypeReference(this.field_1588[this.field_1587--]));
        CastExpression var2 = var10002;
        var10000[var10001] = var10002;
        var3.field_445 = var4 - 1;
        var3.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected ParameterizedQualifiedTypeReference computeQualifiedGenericsFromRightSide(TypeReference var1, int var2) {
        int var3 = this.field_1582[this.field_1581];
        int var4 = var3;
        if (var1 instanceof ParameterizedSingleTypeReference) {
            var4 = var3 + 1;
        } else if (var1 instanceof SingleTypeReference) {
            var4 = var3 + 1;
        } else if (var1 instanceof ParameterizedQualifiedTypeReference) {
            var4 = var3 + ((QualifiedTypeReference)var1).tokens.length;
        } else if (var1 instanceof QualifiedTypeReference) {
            var4 = var3 + ((QualifiedTypeReference)var1).tokens.length;
        }
        TypeReference[][] var5 = new TypeReference[var4][];
        char[][] var6 = new char[var4][];
        long[] var7 = new long[var4];
        if (var1 instanceof ParameterizedSingleTypeReference) {
            ParameterizedSingleTypeReference var8 = (ParameterizedSingleTypeReference)var1;
            var6[var3] = var8.token;
            var7[var3] = ((long)var8.field_444 << 32) + (long)var8.field_445;
            var5[var3] = var8.typeArguments;
        } else if (var1 instanceof SingleTypeReference) {
            SingleTypeReference var13 = (SingleTypeReference)var1;
            var6[var3] = var13.token;
            var7[var3] = ((long)var13.field_444 << 32) + (long)var13.field_445;
        } else if (var1 instanceof ParameterizedQualifiedTypeReference) {
            ParameterizedQualifiedTypeReference var12 = (ParameterizedQualifiedTypeReference)var1;
            TypeReference[][] var9 = var12.typeArguments;
            System.arraycopy(var9, 0, var5, var3, var9.length);
            char[][] var10 = var12.tokens;
            System.arraycopy(var10, 0, var6, var3, var10.length);
            long[] var11 = var12.sourcePositions;
            System.arraycopy(var11, 0, var7, var3, var11.length);
        } else if (var1 instanceof QualifiedTypeReference) {
            QualifiedTypeReference var16 = (QualifiedTypeReference)var1;
            char[][] var15 = var16.tokens;
            System.arraycopy(var15, 0, var6, var3, var15.length);
            long[] var18 = var16.sourcePositions;
            System.arraycopy(var18, 0, var7, var3, var18.length);
        }
        int var14 = this.field_1576[this.field_1575--];
        TypeReference[] var17 = new TypeReference[var14];
        this.field_1577 -= var14;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var17, 0, var14);
        if (var3 == 1) {
            var6[0] = this.identifierStack[this.field_1584];
            var7[0] = this.identifierPositionStack[this.field_1584--];
            var5[0] = var17;
        } else {
            this.field_1584 -= var3;
            System.arraycopy(this.identifierStack, this.field_1584 + 1, var6, 0, var3);
            System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var7, 0, var3);
            var5[var3 - 1] = var17;
        }
        --this.field_1581;
        ParameterizedQualifiedTypeReference var10000 = new ParameterizedQualifiedTypeReference(var6, var5, var2, var7);
        return var10000;
    }

    protected void method_2564() {
        int var4 = this.field_1588[this.field_1587--];
        int var5 = this.field_1588[this.field_1587--];
        TypeReference var6 = this.getTypeReference(0);
        ParameterizedQualifiedTypeReference var7 = this.computeQualifiedGenericsFromRightSide(var6, var5);
        --this.field_1587;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        Expression var1;
        CastExpression var10002 = new CastExpression(var1 = this.expressionStack[this.field_1570], var7);
        CastExpression var2 = var10002;
        var10000[var10001] = var10002;
        var7.field_445 = var4 - 1;
        var7.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected void method_2565() {
        this.method_2853();
    }

    protected void method_2566() {
        if (this.currentElement != null) {
            if (!(this.currentElement instanceof RecoveredBlock)) {
                if (!(this.currentElement instanceof RecoveredMethod)) {
                    return;
                }
                RecoveredMethod var1 = (RecoveredMethod)this.currentElement;
                if (var1.methodBody != null || var1.bracketBalance <= 0) {
                    return;
                }
            }
            Argument var3 = (Argument)this.field_1560[this.field_1559--];
            LocalDeclaration var10000 = new LocalDeclaration(var3.name, var3.field_444, var3.field_445);
            LocalDeclaration var2 = var10000;
            var2.type = var3.type;
            var2.field_653 = var3.field_653;
            var2.field_652 = var3.field_652;
            this.currentElement = this.currentElement.add(var2, 0);
            this.field_1590 = this.scanner.field_1230;
            this.field_1618 = true;
            this.field_1593 = -1;
        }
    }

    protected void method_2567() {
        --this.field_1601[this.field_1602];
        Block var1 = (Block)this.field_1560[this.field_1559--];
        --this.field_1557;
        if (this.field_1564) {
            var1.field_446 &= -9;
        }
        Initializer var2 = (Initializer)this.field_1560[this.field_1559];
        var2.field_653 = var2.field_444 = var1.field_444;
        var2.block = var1;
        --this.field_1587;
        var2.field_666 = this.field_1588[this.field_1587--];
        --this.field_1612;
        int var3 = this.field_1588[this.field_1587--];
        if (var3 != -1) {
            var2.field_653 = var3;
        }
        var2.field_667 = this.field_1566;
        var2.field_445 = this.field_1567;
        var2.field_652 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2568() {
        this.method_2529();
    }

    protected void method_2569() {
        --this.field_1602;
    }

    protected void method_2570() {
        --this.field_1602;
    }

    protected void method_2571() {
        this.method_2866((ASTNode)null);
        this.field_1566 = this.field_1598;
    }

    protected void method_2572() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2828(var1);
        }
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        boolean var3 = var2.checkConstructors(this);
        if (!var3) {
            switch (TypeDeclaration.kind(var2.field_577)) {
                case 1:
                case 3:
                    boolean var4 = false;
                    if (this.field_1564) {
                        for (int var5 = this.field_1602; var5 > 0; --var5) {
                            if (this.field_1632[var5] > 0) {
                                var4 = true;
                                break;
                            }
                        }
                    }
                    var2.createDefaultConstructor(!this.field_1564 || var4, true);
            }
        }
        if (this.scanner.field_1226) {
            var2.field_446 |= 1;
        }
        var2.addClinit();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.containsComment(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2573() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_594 = this.scanner.field_1231;
        }
        if (this.currentElement != null) {
            this.field_1618 = true;
        }
        this.scanner.field_1245 = -1;
    }

    protected void method_2574() {
        TypeReference var1 = this.getTypeReference(0);
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        var2.superclass = var1;
        var1.field_446 |= 16;
        var2.field_594 = var2.superclass.field_445 + 1;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_594;
        }
    }

    protected void method_2575() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        System.arraycopy(this.field_1560, this.field_1559 + 1, var2.superInterfaces = new TypeReference[var1], 0, var1);
        int var3 = 0;
        for (int var4 = var2.superInterfaces.length; var3 < var4; ++var3) {
            var2.superInterfaces[var3].field_446 |= 16;
        }
        var2.field_594 = var2.superInterfaces[var1 - 1].field_445 + 1;
        this.field_1595 = 0;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_594;
        }
    }

    protected void method_2576() {
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var2 = this.identifierPositionStack[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--];
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.compilationUnit != null && !CharOperation.method_1364(var1.name, this.compilationUnit.method_772())) {
            var1.field_446 |= 4096;
        }
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var4) + 1, var1.annotations = new Annotation[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (this.currentElement != null) {
            this.field_1590 = var1.field_594;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2577() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeParameters = new TypeParameter[var2], 0, var2);
        var1.field_594 = var1.typeParameters[var2 - 1].field_652 + 1;
        this.field_1596 = 0;
        if (this.currentElement != null) {
            RecoveredType var3 = (RecoveredType)this.currentElement;
            var3.pendingTypeParameters = null;
            this.field_1590 = var1.field_594;
        }
    }

    protected void method_2578() {
        this.method_2526(false);
    }

    protected void method_2579() {
        this.method_2867(this.method_2839());
    }

    protected void method_2580() {
        this.method_2526(true);
        --this.field_1568;
        QualifiedAllocationExpression var1 = (QualifiedAllocationExpression)this.expressionStack[this.field_1570--];
        var1.enclosingInstance = this.expressionStack[this.field_1570];
        this.expressionStack[this.field_1570] = var1;
        var1.field_444 = var1.enclosingInstance.field_444;
    }

    protected void method_2581() {
        int var2;
        if ((var2 = this.field_1558[this.field_1557--]) == 1 && this.field_1560[this.field_1559] == null) {
            --this.field_1559;
            QualifiedAllocationExpression var10000 = new QualifiedAllocationExpression();
            QualifiedAllocationExpression var1 = var10000;
            var1.field_445 = this.field_1566;
            if ((var2 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var2;
                System.arraycopy(this.expressionStack, this.field_1570 + 1, var1.arguments = new Expression[var2], 0, var2);
            }
            var1.type = this.getTypeReference(0);
            var2 = this.field_1576[this.field_1575--];
            this.field_1577 -= var2;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeArguments = new TypeReference[var2], 0, var2);
            --this.field_1587;
            var1.field_444 = this.field_1588[this.field_1587--];
            this.method_2867(var1);
        } else {
            this.method_2828(var2);
            TypeDeclaration var3 = (TypeDeclaration)this.field_1560[this.field_1559];
            var3.field_593 = this.field_1567;
            var3.field_595 = this.field_1567;
            if (var2 == 0 && !this.containsComment(var3.field_594, var3.field_595)) {
                var3.field_446 |= 8;
            }
            --this.field_1559;
            --this.field_1557;
            QualifiedAllocationExpression var4 = var3.allocation;
            if (var4 != null) {
                var4.field_445 = this.field_1567;
                var2 = this.field_1576[this.field_1575--];
                this.field_1577 -= var2;
                System.arraycopy(this.field_1578, this.field_1577 + 1, var4.typeArguments = new TypeReference[var2], 0, var2);
                var4.field_444 = this.field_1588[this.field_1587--];
            }
        }
        --this.field_1568;
        QualifiedAllocationExpression var5 = (QualifiedAllocationExpression)this.expressionStack[this.field_1570--];
        var5.enclosingInstance = this.expressionStack[this.field_1570];
        this.expressionStack[this.field_1570] = var5;
        var5.field_444 = var5.enclosingInstance.field_444;
    }

    protected void method_2582() {
        int var2;
        if ((var2 = this.field_1558[this.field_1557--]) == 1 && this.field_1560[this.field_1559] == null) {
            --this.field_1559;
            AllocationExpression var10000 = new AllocationExpression();
            AllocationExpression var1 = var10000;
            var1.field_445 = this.field_1566;
            if ((var2 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var2;
                System.arraycopy(this.expressionStack, this.field_1570 + 1, var1.arguments = new Expression[var2], 0, var2);
            }
            var1.type = this.getTypeReference(0);
            var2 = this.field_1576[this.field_1575--];
            this.field_1577 -= var2;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeArguments = new TypeReference[var2], 0, var2);
            --this.field_1587;
            var1.field_444 = this.field_1588[this.field_1587--];
            this.method_2867(var1);
        } else {
            this.method_2828(var2);
            TypeDeclaration var3 = (TypeDeclaration)this.field_1560[this.field_1559];
            var3.field_593 = this.field_1567;
            var3.field_595 = this.field_1567;
            if (var2 == 0 && !this.containsComment(var3.field_594, var3.field_595)) {
                var3.field_446 |= 8;
            }
            --this.field_1559;
            --this.field_1557;
            QualifiedAllocationExpression var4 = var3.allocation;
            if (var4 != null) {
                var4.field_445 = this.field_1567;
                var2 = this.field_1576[this.field_1575--];
                this.field_1577 -= var2;
                System.arraycopy(this.field_1578, this.field_1577 + 1, var4.typeArguments = new TypeReference[var2], 0, var2);
                var4.field_444 = this.field_1588[this.field_1587--];
            }
        }
    }

    protected void method_2583() {
        this.field_1574[this.field_1573] += this.field_1582[this.field_1581];
        this.method_2871(0);
    }

    protected void method_2584() {
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
    }

    protected void method_2585() {
        this.method_2866(this.getTypeReference(0));
        ++this.field_1595;
    }

    protected void method_2586() {
        this.method_2853();
    }

    protected void method_2587() {}

    protected void method_2588(int var1) {
        this.field_1587 -= 2;
        this.field_1570 -= 2;
        this.field_1568 -= 2;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        ConditionalExpression var10002 = new ConditionalExpression(this.expressionStack[this.field_1570], this.expressionStack[this.field_1570 + 1], this.expressionStack[this.field_1570 + 2]);
        var10000[var10001] = var10002;
    }

    protected void method_2589(int var1) {
        this.field_1587 -= 2;
        this.method_2867(this.method_2839());
        this.field_1570 -= 2;
        this.field_1568 -= 2;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        ConditionalExpression var10002 = new ConditionalExpression(this.expressionStack[this.field_1570 + 2], this.expressionStack[this.field_1570], this.expressionStack[this.field_1570 + 1]);
        var10000[var10001] = var10002;
    }

    protected void method_2590() {
        --this.field_1587;
        --this.field_1587;
        --this.field_1612;
        ExplicitConstructorCall var2 = null;
        Statement[] var3 = null;
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
            if (this.field_1560[this.field_1559 + 1] instanceof ExplicitConstructorCall) {
                System.arraycopy(this.field_1560, this.field_1559 + 2, var3 = new Statement[var1 - 1], 0, var1 - 1);
                var2 = (ExplicitConstructorCall)this.field_1560[this.field_1559 + 1];
            } else {
                System.arraycopy(this.field_1560, this.field_1559 + 1, var3 = new Statement[var1], 0, var1);
                var2 = SuperReference.implicitSuperConstructorCall();
            }
        } else {
            boolean var4 = false;
            if (this.field_1564) {
                for (int var5 = this.field_1602; var5 > 0; --var5) {
                    if (this.field_1632[var5] > 0) {
                        var4 = true;
                        break;
                    }
                }
            }
            if (!this.field_1564 || var4) {
                var2 = SuperReference.implicitSuperConstructorCall();
            }
        }
        ConstructorDeclaration var6 = (ConstructorDeclaration)this.field_1560[this.field_1559];
        var6.constructorCall = var2;
        var6.statements = var3;
        if (var2 != null && var6.constructorCall.field_445 == 0) {
            var6.constructorCall.field_445 = var6.field_445;
            var6.constructorCall.field_444 = var6.field_444;
        }
        if ((!this.field_1564 || this.field_1565 != 0) && var3 == null && (var2 == null || var2.method_831()) && !this.containsComment(var6.field_490, this.field_1566)) {
            var6.field_446 |= 8;
        }
        var6.field_491 = this.field_1566;
        var6.field_481 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2591() {
        AbstractMethodDeclaration var1 = (AbstractMethodDeclaration)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_490 = this.scanner.field_1231;
        }
        if (this.currentElement != null) {
            if (this.field_1563 == 27) {
                var1.field_482 |= 16777216;
                var1.field_481 = this.scanner.field_1231 - 1;
                var1.field_491 = this.scanner.field_1231 - 1;
                if (this.currentElement.parseTree() == var1 && this.currentElement.parent != null) {
                    this.currentElement = this.currentElement.parent;
                }
            }
            this.field_1618 = true;
        }
    }

    protected void method_2592() {
        if (this.currentElement != null && this.field_1593 == 43) {
            this.field_1590 = this.scanner.field_1230;
            this.field_1618 = true;
        } else {
            ConstructorDeclaration var10000 = new ConstructorDeclaration(this.compilationUnit.compilationResult);
            ConstructorDeclaration var1 = var10000;
            var1.selector = this.identifierStack[this.field_1584];
            long var2 = this.identifierPositionStack[this.field_1584--];
            --this.field_1581;
            var1.field_480 = this.field_1588[this.field_1587--];
            var1.field_482 = this.field_1588[this.field_1587--];
            int var4;
            if ((var4 = this.field_1569[this.field_1568--]) != 0) {
                System.arraycopy(this.expressionStack, (this.field_1570 -= var4) + 1, var1.annotations = new Annotation[var4], 0, var4);
            }
            var1.field_444 = (int)(var2 >>> 32);
            this.method_2866(var1);
            var1.field_445 = this.field_1597;
            var1.field_490 = this.field_1597 + 1;
            this.field_1595 = 0;
            if (this.currentElement != null) {
                this.field_1590 = var1.field_490;
                if (this.currentElement instanceof RecoveredType && this.field_1593 != 3 || var1.field_482 != 0) {
                    this.currentElement = this.currentElement.add(var1, 0);
                    this.field_1593 = -1;
                }
            }
        }
    }

    protected void method_2593() {
        if (this.currentElement != null && this.field_1593 == 43) {
            this.field_1590 = this.scanner.field_1230;
            this.field_1618 = true;
        } else {
            ConstructorDeclaration var10000 = new ConstructorDeclaration(this.compilationUnit.compilationResult);
            ConstructorDeclaration var1 = var10000;
            var1.selector = this.identifierStack[this.field_1584];
            long var2 = this.identifierPositionStack[this.field_1584--];
            --this.field_1581;
            int var4 = this.field_1576[this.field_1575--];
            this.field_1577 -= var4;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeParameters = new TypeParameter[var4], 0, var4);
            var1.field_480 = this.field_1588[this.field_1587--];
            var1.field_482 = this.field_1588[this.field_1587--];
            if ((var4 = this.field_1569[this.field_1568--]) != 0) {
                System.arraycopy(this.expressionStack, (this.field_1570 -= var4) + 1, var1.annotations = new Annotation[var4], 0, var4);
            }
            var1.field_444 = (int)(var2 >>> 32);
            this.method_2866(var1);
            var1.field_445 = this.field_1597;
            var1.field_490 = this.field_1597 + 1;
            this.field_1595 = 0;
            if (this.currentElement != null) {
                this.field_1590 = var1.field_490;
                if (this.currentElement instanceof RecoveredType && this.field_1593 != 3 || var1.field_482 != 0) {
                    this.currentElement = this.currentElement.add(var1, 0);
                    this.field_1593 = -1;
                }
            }
        }
    }

    protected void method_2594() {
        CaseStatement var10001 = new CaseStatement((Expression)null, this.field_1588[this.field_1587--], this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2595() {
        Initializer var10001 = new Initializer((Block)null, 0);
        this.method_2866(var10001);
    }

    protected void method_2596() {
        this.method_2524();
        this.method_2872(this.field_1599);
        this.method_2872(this.field_1600 >= 0 ? this.field_1600 : this.scanner.field_1230);
        this.method_2879();
        this.method_2868(0);
    }

    protected void method_2597() {
        this.method_2524();
        this.method_2872(this.field_1600);
        this.method_2879();
        this.method_2847();
    }

    protected void method_2598() {
        this.method_2872(this.field_1603);
        this.field_1603 = 0;
    }

    protected void method_2599() {
        this.method_2867((Expression)null);
        if (this.currentElement != null && this.field_1563 == 69) {
            this.field_1586 = true;
            ++this.currentElement.bracketBalance;
        }
    }

    protected void method_2600() {
        this.method_2527();
    }

    protected void method_2601() {
        this.method_2865(0);
    }

    protected void method_2602() {
        this.method_2868(0);
    }

    protected void method_2603() {
        FieldDeclaration var1 = (FieldDeclaration)this.field_1560[this.field_1559];
        this.method_2872(var1.field_445);
        this.method_2868(0);
    }

    protected void method_2604() {
        this.arrayInitializer(0);
    }

    protected void method_2605() {
        this.method_2865(0);
    }

    protected void method_2606() {
        this.method_2865(0);
    }

    protected void method_2607() {
        this.method_2865(0);
    }

    protected void method_2608() {
        AbstractMethodDeclaration var1 = (AbstractMethodDeclaration)this.field_1560[this.field_1559];
        if (var1.method_793()) {
            this.method_2868(0);
        }
        this.field_1634 = true;
    }

    protected void method_2609() {
        this.method_2872(0);
    }

    protected void method_2610() {
        this.method_2865(0);
    }

    protected void method_2611() {
        this.method_2868(0);
    }

    protected void method_2612() {
        this.method_2865(0);
    }

    protected void method_2613() {
        this.method_2868(0);
    }

    protected void method_2614() {
        this.method_2865(0);
    }

    protected void method_2615() {
        if (this.compilationUnit.method_773()) {
            this.compilationUnit.types = new TypeDeclaration[1];
            TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
            TypeDeclaration var1 = var10000;
            var1.name = TypeConstants.field_144;
            var1.field_577 = 512;
            this.compilationUnit.types[0] = var1;
        }
    }

    protected void method_2616() {
        this.method_2865(0);
    }

    protected void method_2617() {
        this.arrayInitializer(0);
    }

    protected void method_2618() {
        char[] var1 = this.scanner.field_1237;
        EmptyStatement var10001;
        if (var1[this.field_1567] == 59) {
            var10001 = new EmptyStatement(this.field_1567, this.field_1567);
            this.method_2866(var10001);
        } else {
            if (var1.length > 5) {
                boolean var2 = false;
                boolean var3 = false;
                boolean var4 = false;
                boolean var5 = false;
                int var6;
                for (var6 = this.field_1567 - 4; var1[var6] == 117; --var6) {
                    ;
                }
                int var7;
                int var8;
                int var9;
                int var10;
                if (var1[var6] == 92 && (var7 = ScannerHelper.getNumericValue(var1[this.field_1567 - 3])) <= 15 && var7 >= 0 && (var8 = ScannerHelper.getNumericValue(var1[this.field_1567 - 2])) <= 15 && var8 >= 0 && (var9 = ScannerHelper.getNumericValue(var1[this.field_1567 - 1])) <= 15 && var9 >= 0 && (var10 = ScannerHelper.getNumericValue(var1[this.field_1567])) <= 15 && var10 >= 0 && (char)(((var7 * 16 + var8) * 16 + var9) * 16 + var10) == 59) {
                    var10001 = new EmptyStatement(var6, this.field_1567);
                    this.method_2866(var10001);
                    return;
                }
            }
            var10001 = new EmptyStatement(this.field_1567, this.field_1567);
            this.method_2866(var10001);
        }
    }

    protected void method_2619() {
        this.method_2865(0);
    }

    protected void method_2620() {
        this.method_2865(0);
        if (!this.field_1622) {
            this.problemReporter().method_1762(this.field_1566 + 1, this.field_1567);
        }
        this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2621(boolean var1) {
        char[] var3 = this.identifierStack[this.field_1584];
        long var4 = this.identifierPositionStack[this.field_1584];
        LocalDeclaration var6 = this.createLocalDeclaration(var3, (int)(var4 >>> 32), (int)var4);
        var6.field_652 = var6.field_651;
        int var7 = this.field_1588[this.field_1587--];
        --this.field_1584;
        --this.field_1581;
        int var8 = 0;
        int var9 = 0;
        if (var1) {
            var8 = this.field_1588[this.field_1587--];
            var9 = this.field_1588[this.field_1587--];
        } else {
            this.field_1587 -= 2;
        }
        TypeReference var2 = this.getTypeReference(this.field_1588[this.field_1587--] + var7);
        int var10;
        if ((var10 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var10) + 1, var6.annotations = new Annotation[var10], 0, var10);
        }
        if (var1) {
            var6.field_653 = var8;
            var6.field_656 = var9;
        } else {
            var6.field_653 = var2.field_444;
        }
        var6.type = var2;
        ForeachStatement var10000 = new ForeachStatement(var6, this.field_1588[this.field_1587--]);
        ForeachStatement var11 = var10000;
        this.method_2866(var11);
        var11.field_445 = var6.field_652;
    }

    protected void method_2622() {
        ForeachStatement var1 = (ForeachStatement)this.field_1560[this.field_1559];
        --this.field_1568;
        Expression var2 = this.expressionStack[this.field_1570--];
        var1.collection = var2;
        var1.field_445 = this.field_1598;
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().invalidUsageOfForeachStatements(var1.elementVariable, var2);
        }
    }

    protected void method_2623() {
        --this.field_1557;
        Statement var1 = (Statement)this.field_1560[this.field_1559--];
        ForeachStatement var2 = (ForeachStatement)this.field_1560[this.field_1559];
        var2.action = var1;
        if (var1 instanceof EmptyStatement) {
            var1.field_446 |= 1;
        }
        var2.field_445 = this.field_1567;
    }

    protected void method_2624() {
        TypeReference var1 = this.getTypeReference(0);
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var2 = var10000;
        var2.name = CharOperation.NO_CHAR;
        var2.field_446 |= 768;
        QualifiedAllocationExpression var5 = new QualifiedAllocationExpression(var2);
        QualifiedAllocationExpression var3 = var5;
        this.method_2849();
        this.method_2866(var2);
        var3.field_445 = this.field_1598;
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var4;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var3.arguments = new Expression[var4], 0, var4);
        }
        var3.type = var1;
        var2.field_445 = var3.field_445;
        var2.field_444 = var2.field_592 = var3.type.field_444;
        var3.field_444 = this.field_1588[this.field_1587--];
        this.method_2867(var3);
        var2.field_594 = this.scanner.field_1231;
        this.field_1595 = 0;
        this.scanner.field_1245 = -1;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_594;
            this.currentElement = this.currentElement.add(var2, 0);
            if (!(this.currentElement instanceof RecoveredAnnotation)) {
                this.field_1563 = 0;
            } else {
                this.field_1586 = true;
                ++this.currentElement.bracketBalance;
            }
            this.field_1593 = -1;
        }
    }

    protected void method_2625() {}

    protected void method_2626() {
        if (this.currentElement != null && this.currentElement instanceof RecoveredAnnotation) {
            RecoveredAnnotation var1 = (RecoveredAnnotation)this.currentElement;
            var1.hasPendingMemberValueName = true;
        }
    }

    protected void method_2627() {
        if (this.currentElement != null) {
            this.field_1586 = true;
            ++this.currentElement.bracketBalance;
        }
    }

    protected void method_2628() {
        char[] var1 = this.identifierStack[this.field_1584];
        long var2 = this.identifierPositionStack[this.field_1584];
        int var4 = this.field_1588[this.field_1587--];
        boolean var6 = this.field_1601[this.field_1602] != 0;
        Object var5;
        if (var6) {
            var5 = this.createLocalDeclaration(var1, (int)(var2 >>> 32), (int)var2);
        } else {
            var5 = this.createFieldDeclaration(var1, (int)(var2 >>> 32), (int)var2);
        }
        --this.field_1584;
        --this.field_1581;
        int var8 = this.field_1632[this.field_1602];
        boolean var9 = false;
        TypeReference var7;
        int var10;
        int var13;
        if (var8 == 0) {
            if (var6) {
                ((AbstractVariableDeclaration)var5).field_653 = this.field_1588[this.field_1587--];
                ((AbstractVariableDeclaration)var5).field_656 = this.field_1588[this.field_1587--];
                if ((var10 = this.field_1569[this.field_1568--]) != 0) {
                    System.arraycopy(this.expressionStack, (this.field_1570 -= var10) + 1, ((AbstractVariableDeclaration)var5).annotations = new Annotation[var10], 0, var10);
                }
                var7 = this.getTypeReference(var13 = this.field_1588[this.field_1587--]);
                if (((AbstractVariableDeclaration)var5).field_653 == -1) {
                    ((AbstractVariableDeclaration)var5).field_653 = var7.field_444;
                }
                this.method_2866(var7);
            } else {
                var7 = this.getTypeReference(var13 = this.field_1588[this.field_1587--]);
                this.method_2866(var7);
                ((AbstractVariableDeclaration)var5).field_653 = this.field_1588[this.field_1587--];
                ((AbstractVariableDeclaration)var5).field_656 = this.field_1588[this.field_1587--];
                if ((var10 = this.field_1569[this.field_1568--]) != 0) {
                    System.arraycopy(this.expressionStack, (this.field_1570 -= var10) + 1, ((AbstractVariableDeclaration)var5).annotations = new Annotation[var10], 0, var10);
                }
            }
        } else {
            var7 = (TypeReference)this.field_1560[this.field_1559 - var8];
            var13 = var7.dimensions();
            AbstractVariableDeclaration var15 = (AbstractVariableDeclaration)this.field_1560[this.field_1559];
            ((AbstractVariableDeclaration)var5).field_653 = var15.field_653;
            ((AbstractVariableDeclaration)var5).field_656 = var15.field_656;
            Annotation[] var11 = var15.annotations;
            if (var11 != null) {
                int var12 = var11.length;
                System.arraycopy(var11, 0, ((AbstractVariableDeclaration)var5).annotations = new Annotation[var12], 0, var12);
            }
        }
        if (var4 == 0) {
            ((AbstractVariableDeclaration)var5).type = var7;
        } else {
            var10 = var13 + var4;
            ((AbstractVariableDeclaration)var5).type = this.copyDims(var7, var10);
        }
        ++this.field_1632[this.field_1602];
        this.method_2866((ASTNode)var5);
        if (this.currentElement != null) {
            if (!(this.currentElement instanceof RecoveredType) && (this.field_1563 == 3 || Util.getLineNumber(((AbstractVariableDeclaration)var5).type.field_444, this.scanner.field_1256, 0, this.scanner.field_1257) != Util.getLineNumber((int)(var2 >>> 32), this.scanner.field_1256, 0, this.scanner.field_1257))) {
                this.field_1590 = (int)(var2 >>> 32);
                this.field_1618 = true;
                return;
            }
            if (var6) {
                LocalDeclaration var14 = (LocalDeclaration)this.field_1560[this.field_1559];
                this.field_1590 = var14.field_445 + 1;
                this.currentElement = this.currentElement.add(var14, 0);
            } else {
                FieldDeclaration var16 = (FieldDeclaration)this.field_1560[this.field_1559];
                this.field_1590 = var16.field_445 + 1;
                this.currentElement = this.currentElement.add(var16, 0);
            }
            this.field_1593 = -1;
        }
    }

    protected void method_2629() {}

    protected void method_2630() {
        this.method_2529();
    }

    protected void method_2631() {
        if (this.currentElement != null && (!(this.currentElement instanceof RecoveredType) && (!(this.currentElement instanceof RecoveredField) || ((RecoveredField)this.currentElement).fieldDeclaration.type != null) || this.field_1593 == 3)) {
            this.field_1590 = this.scanner.field_1230;
            this.field_1618 = true;
        } else {
            long var1 = this.identifierPositionStack[this.field_1584];
            char[] var3 = this.identifierStack[this.field_1584];
            int var4 = (int)var1;
            FieldDeclaration var5 = this.createFieldDeclaration(var3, (int)(var1 >>> 32), var4);
            --this.field_1584;
            --this.field_1581;
            var5.field_657 = this.field_1588[this.field_1587--];
            var5.field_656 = this.field_1588[this.field_1587--];
            var5.field_653 = var5.field_657;
            if ((var5.field_446 & 1024) == 0 && (var5.field_446 & 256) == 0 && this.compilationUnit != null && !CharOperation.method_1364(var5.name, this.compilationUnit.method_772())) {
                var5.field_446 |= 4096;
            }
            int var6;
            if ((var6 = this.field_1569[this.field_1568--]) != 0) {
                System.arraycopy(this.expressionStack, (this.field_1570 -= var6) + 1, var5.annotations = new Annotation[var6], 0, var6);
            }
            this.method_2866(var5);
            if (this.currentElement != null) {
                this.field_1590 = var5.field_445 + 1;
                this.currentElement = this.currentElement.add(var5, 0);
            }
        }
    }

    protected void method_2632() {
        FieldDeclaration var1 = (FieldDeclaration)this.field_1560[this.field_1559];
        boolean var2 = this.field_1563 == 69;
        TypeDeclaration var3;
        int var4;
        if (var2) {
            TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
            var3 = var10000;
            var3.name = CharOperation.NO_CHAR;
            var3.field_446 |= 768;
            var4 = this.scanner.field_1230;
            var3.field_592 = var4;
            var3.field_444 = var4;
            var3.field_445 = var4;
            var3.field_577 = 0;
            var3.field_594 = this.scanner.field_1231;
            this.method_2849();
            this.method_2866(var3);
            QualifiedAllocationExpression var8 = new QualifiedAllocationExpression(var3);
            QualifiedAllocationExpression var5 = var8;
            var5.enumConstant = var1;
            int var6;
            if ((var6 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var6;
                System.arraycopy(this.expressionStack, this.field_1570 + 1, var5.arguments = new Expression[var6], 0, var6);
            }
            var1.initialization = var5;
        } else {
            AllocationExpression var9 = new AllocationExpression();
            AllocationExpression var7 = var9;
            var7.enumConstant = var1;
            if ((var4 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var4;
                System.arraycopy(this.expressionStack, this.field_1570 + 1, var7.arguments = new Expression[var4], 0, var4);
            }
            var1.initialization = var7;
        }
        if (this.currentElement != null) {
            if (var2) {
                var3 = (TypeDeclaration)this.field_1560[this.field_1559];
                this.currentElement = this.currentElement.add(var3, 0);
                this.field_1590 = var3.field_594;
                this.field_1593 = -1;
                this.field_1563 = 0;
            } else {
                if (this.field_1563 == 27) {
                    RecoveredType var10 = this.currentRecoveryType();
                    if (var10 != null) {
                        var10.field_1137 = false;
                    }
                }
                this.field_1590 = this.scanner.field_1230;
                this.field_1593 = -1;
                this.field_1618 = true;
            }
        }
    }

    protected void method_2633() {
        int var1 = this.field_1588[this.field_1587--];
        FieldDeclaration var2 = (FieldDeclaration)this.field_1560[this.field_1559];
        var2.field_651 = var1;
        var2.field_652 = var1;
    }

    protected void method_2634() {
        this.method_2529();
    }

    protected void method_2635() {
        this.method_2828(this.field_1558[this.field_1557--]);
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559--];
        --this.field_1557;
        var1.field_595 = this.field_1566;
        var1.field_593 = this.flushCommentsDefinedPriorTo(this.field_1567);
        FieldDeclaration var2 = (FieldDeclaration)this.field_1560[this.field_1559];
        var2.field_651 = this.field_1567;
        var2.field_652 = var1.field_593;
        --this.field_1587;
    }

    protected void method_2636() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2829(var1);
        }
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        boolean var3 = var2.checkConstructors(this);
        if (!var3) {
            boolean var4 = false;
            if (this.field_1564) {
                for (int var5 = this.field_1602; var5 > 0; --var5) {
                    if (this.field_1632[var5] > 0) {
                        var4 = true;
                        break;
                    }
                }
            }
            var2.createDefaultConstructor(!this.field_1564 || var4, true);
        }
        if (this.scanner.field_1226) {
            var2.field_446 |= 1;
        }
        var2.addClinit();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.containsComment(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2637() {}

    protected void method_2638() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_594 = this.scanner.field_1231;
        }
        if (this.currentElement != null) {
            this.field_1618 = true;
        }
        this.scanner.field_1245 = -1;
    }

    protected void method_2639() {
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            this.method_2521();
        }
        long var2 = this.identifierPositionStack[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 16384;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var4) + 1, var1.annotations = new Annotation[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1647(var1);
        }
        if (this.currentElement != null) {
            this.field_1590 = var1.field_594;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2640() {
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var1 = var10000;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeParameters = new TypeParameter[var2], 0, var2);
        this.problemReporter().method_1653(var1);
        var1.field_594 = var1.typeParameters[var2 - 1].field_652 + 1;
        this.field_1596 = 0;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            this.method_2521();
        }
        long var3 = this.identifierPositionStack[this.field_1584];
        var1.field_445 = (int)var3;
        var1.field_444 = (int)(var3 >>> 32);
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 16384;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var2) + 1, var1.annotations = new Annotation[var2], 0, var2);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1647(var1);
        }
        if (this.currentElement != null) {
            this.field_1590 = var1.field_594;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2641(int var1) {
        --this.field_1570;
        --this.field_1568;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        EqualExpression var10002 = new EqualExpression(this.expressionStack[this.field_1570], this.expressionStack[this.field_1570 + 1], var1);
        var10000[var10001] = var10002;
    }

    protected void method_2642(int var1) {
        this.method_2867(this.method_2839());
        --this.field_1570;
        --this.field_1568;
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        EqualExpression var10002 = new EqualExpression(this.expressionStack[this.field_1570 + 1], this.expressionStack[this.field_1570], var1);
        var10000[var10001] = var10002;
    }

    protected void method_2643() {
        if (this.currentElement != null && this.currentElement instanceof RecoveredAnnotation) {
            RecoveredAnnotation var1 = (RecoveredAnnotation)this.currentElement;
            var1.hasPendingMemberValueName = false;
            var1.memberValuPairEqualEnd = -1;
        }
    }

    protected void method_2644() {
        if (this.currentElement != null) {
            this.field_1618 = true;
        }
    }

    protected void method_2645() {
        --this.field_1568;
        AbstractVariableDeclaration var1 = (AbstractVariableDeclaration)this.field_1560[this.field_1559];
        var1.initialization = this.expressionStack[this.field_1570--];
        var1.field_652 = var1.initialization.field_445;
        var1.field_651 = var1.initialization.field_445;
        this.method_2875();
    }

    protected void method_2646() {
        AbstractVariableDeclaration var1 = (AbstractVariableDeclaration)this.field_1560[this.field_1559];
        var1.field_652 = var1.field_651;
        if (this.currentElement != null && this.currentElement instanceof RecoveredField && this.field_1567 > var1.field_445) {
            this.currentElement.method_1857(this.field_1567);
        }
        this.method_2875();
    }

    protected void method_2647(int var1, int var2) {
        int var3 = this.field_1588[this.field_1587--];
        ExplicitConstructorCall var10000 = new ExplicitConstructorCall(var2);
        ExplicitConstructorCall var4 = var10000;
        int var5;
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var5;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var4.arguments = new Expression[var5], 0, var5);
        }
        switch (var1) {
            case 0:
                var4.field_444 = var3;
                break;
            case 1:
                --this.field_1568;
                var4.field_444 = (var4.qualification = this.expressionStack[this.field_1570--]).field_444;
                break;
            case 2:
                var4.field_444 = (var4.qualification = this.method_2839()).field_444;
        }
        this.method_2866(var4);
        var4.field_445 = this.field_1567;
    }

    protected void method_2648(int var1, int var2) {
        int var3 = this.field_1588[this.field_1587--];
        ExplicitConstructorCall var10000 = new ExplicitConstructorCall(var2);
        ExplicitConstructorCall var4 = var10000;
        int var5;
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var5;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var4.arguments = new Expression[var5], 0, var5);
        }
        var5 = this.field_1576[this.field_1575--];
        this.field_1577 -= var5;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var4.typeArguments = new TypeReference[var5], 0, var5);
        var4.field_554 = this.field_1588[this.field_1587--];
        switch (var1) {
            case 0:
                var4.field_444 = var3;
                break;
            case 1:
                --this.field_1568;
                var4.field_444 = (var4.qualification = this.expressionStack[this.field_1570--]).field_444;
                break;
            case 2:
                var4.field_444 = (var4.qualification = this.method_2839()).field_444;
        }
        this.method_2866(var4);
        var4.field_445 = this.field_1567;
    }

    protected void method_2649() {
        --this.field_1568;
        Expression var1 = this.expressionStack[this.field_1570--];
        var1.field_673 = this.field_1567;
        this.method_2866(var1);
    }

    protected void method_2650(boolean var1) {
        FieldReference var10000 = new FieldReference(this.identifierStack[this.field_1584], this.identifierPositionStack[this.field_1584--]);
        FieldReference var2 = var10000;
        --this.field_1581;
        if (var1) {
            var2.field_444 = this.field_1588[this.field_1587--];
            SuperReference var10001 = new SuperReference(var2.field_444, this.field_1566);
            var2.receiver = var10001;
            this.method_2867(var2);
        } else {
            var2.receiver = this.expressionStack[this.field_1570];
            var2.field_444 = var2.receiver.field_444;
            this.expressionStack[this.field_1570] = var2;
        }
    }

    protected void method_2651() {
        int var1 = this.field_1558[this.field_1557];
        int var2;
        for (var2 = var1 - 1; var2 >= 0; --var2) {
            FieldDeclaration var3 = (FieldDeclaration)this.field_1560[this.field_1559 - var2];
            var3.field_652 = this.field_1567;
            var3.field_651 = this.field_1567;
        }
        this.method_2884(var1);
        var2 = this.flushCommentsDefinedPriorTo(this.field_1567);
        int var5;
        if (var2 != this.field_1567) {
            for (var5 = 0; var5 < var1; ++var5) {
                FieldDeclaration var4 = (FieldDeclaration)this.field_1560[this.field_1559 - var5];
                var4.field_652 = var2;
            }
        }
        var5 = this.field_1559 - this.field_1632[this.field_1602] + 1;
        System.arraycopy(this.field_1560, var5, this.field_1560, var5 - 1, var1);
        --this.field_1559;
        this.field_1558[--this.field_1557] = var1;
        if (this.currentElement != null) {
            this.field_1590 = var2 + 1;
            if (this.currentElement.parent != null && this.currentElement instanceof RecoveredField && !(this.currentElement instanceof RecoveredInitializer)) {
                this.currentElement = this.currentElement.parent;
            }
            this.field_1618 = true;
        }
        this.field_1632[this.field_1602] = 0;
    }

    protected void method_2652() {
        ++this.field_1565;
    }

    protected void method_2653() {
        this.method_2865(-1);
    }

    protected void method_2654(boolean var1) {
        --this.field_1581;
        char[] var2 = this.identifierStack[this.field_1584];
        long var3 = this.identifierPositionStack[this.field_1584--];
        int var5 = this.field_1588[this.field_1587--];
        int var6 = 0;
        if (var1) {
            var6 = this.field_1588[this.field_1587--];
        }
        int var7 = this.field_1588[this.field_1587--];
        int var8 = var7 + var5;
        TypeReference var9 = this.getTypeReference(var8);
        if (var1) {
            var9 = this.copyDims(var9, var8 + 1);
            if (var5 == 0) {
                var9.field_445 = var6;
            }
            var9.field_446 |= 16384;
        }
        int var10 = this.field_1588[this.field_1587--];
        --this.field_1587;
        Argument var10000 = new Argument(var2, var3, var9, this.field_1588[this.field_1587 + 1] & -1048577);
        Argument var11 = var10000;
        var11.field_653 = var10;
        int var12;
        if ((var12 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var12) + 1, var11.annotations = new Annotation[var12], 0, var12);
        }
        this.method_2866(var11);
        ++this.field_1595;
        if (var1) {
            if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
                this.problemReporter().method_1654(var11);
            } else if (!this.field_1622 && var5 > 0) {
                this.problemReporter().method_1570(var11);
            }
        }
    }

    protected void method_2655() {
        this.method_2853();
    }

    protected void method_2656() {
        this.method_2865(0);
    }

    protected void method_2657() {}

    protected void method_2658() {}

    protected void method_2659() {}

    protected void method_2660() {
        ImportReference var1 = (ImportReference)this.field_1560[this.field_1559];
        var1.field_469 = this.field_1567;
        var1.field_471 = this.flushCommentsDefinedPriorTo(var1.field_471);
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2661() {
        this.method_2853();
    }

    protected void method_2662() {}

    protected void method_2663() {
        this.method_2867(this.method_2839());
    }

    protected void method_2664() {}

    protected void method_2665() {
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        InstanceOfExpression var10002 = new InstanceOfExpression(this.expressionStack[this.field_1570], this.getTypeReference(this.field_1588[this.field_1587--]));
        InstanceOfExpression var1 = var10002;
        var10000[var10001] = var10002;
        if (var1.field_445 == 0) {
            var1.field_445 = this.scanner.field_1230 - 1;
        }
    }

    protected void method_2666() {
        TypeReference var1 = this.getTypeReference(this.field_1588[this.field_1587--]);
        this.method_2867(this.method_2839());
        Expression[] var10000 = this.expressionStack;
        int var10001 = this.field_1570;
        InstanceOfExpression var10002 = new InstanceOfExpression(this.expressionStack[this.field_1570], var1);
        InstanceOfExpression var2 = var10002;
        var10000[var10001] = var10002;
        if (var2.field_445 == 0) {
            var2.field_445 = this.scanner.field_1230 - 1;
        }
    }

    protected void method_2667() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2828(var1);
        }
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        var2.checkConstructors(this);
        if (this.scanner.field_1226) {
            var2.field_446 |= 1;
        }
        var2.addClinit();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.containsComment(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2668() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_594 = this.scanner.field_1231;
        }
        if (this.currentElement != null) {
            this.field_1618 = true;
        }
        this.scanner.field_1245 = -1;
    }

    protected void method_2669() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        TypeDeclaration var2 = (TypeDeclaration)this.field_1560[this.field_1559];
        System.arraycopy(this.field_1560, this.field_1559 + 1, var2.superInterfaces = new TypeReference[var1], 0, var1);
        int var3 = 0;
        for (int var4 = var2.superInterfaces.length; var3 < var4; ++var3) {
            var2.superInterfaces[var3].field_446 |= 16;
        }
        var2.field_594 = var2.superInterfaces[var1 - 1].field_445 + 1;
        this.field_1595 = 0;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_594;
        }
    }

    protected void method_2670() {
        TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
        TypeDeclaration var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var2 = this.identifierPositionStack[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 512;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.compilationUnit != null && !CharOperation.method_1364(var1.name, this.compilationUnit.method_772())) {
            var1.field_446 |= 4096;
        }
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var4) + 1, var1.annotations = new Annotation[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (this.currentElement != null) {
            this.field_1590 = var1.field_594;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2671() {
        this.method_2529();
    }

    protected void method_2672() {
        --this.field_1602;
    }

    protected void method_2673() {
        this.method_2866(this.getTypeReference(0));
        ++this.field_1595;
    }

    protected void method_2674() {
        this.method_2853();
    }

    protected void method_2675() {
        if (this.compilationUnit.method_773()) {
            this.compilationUnit.types = new TypeDeclaration[1];
            TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
            TypeDeclaration var1 = var10000;
            var1.name = TypeConstants.field_144;
            var1.field_577 = 512;
            this.compilationUnit.types[0] = var1;
        }
    }

    protected void method_2676() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            if (this.compilationUnit.method_773()) {
                this.compilationUnit.types = new TypeDeclaration[var1 + 1];
                this.field_1559 -= var1;
                System.arraycopy(this.field_1560, this.field_1559 + 1, this.compilationUnit.types, 1, var1);
                TypeDeclaration var10000 = new TypeDeclaration(this.compilationUnit.compilationResult);
                TypeDeclaration var2 = var10000;
                var2.name = TypeConstants.field_144;
                var2.field_577 = 512;
                this.compilationUnit.types[0] = var2;
            } else {
                this.compilationUnit.types = new TypeDeclaration[var1];
                this.field_1559 -= var1;
                System.arraycopy(this.field_1560, this.field_1559 + 1, this.compilationUnit.types, 0, var1);
            }
        }
    }

    protected void method_2677() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        if (!this.field_1622) {
            this.problemReporter().method_1573(var1);
        }
        --this.field_1559;
        this.method_2865(-1);
        this.method_2529();
    }

    protected void method_2678() {
        ConstructorDeclaration var1 = (ConstructorDeclaration)this.field_1560[this.field_1559];
        var1.field_491 = this.field_1566;
        var1.field_481 = this.flushCommentsDefinedPriorTo(this.field_1567);
        var1.field_482 |= 16777216;
    }

    protected void method_2679(boolean var1) {
        if (var1) {
            --this.field_1587;
        }
        if (var1) {
            --this.field_1612;
        }
        int var2;
        if (var1 && (var2 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var2;
        }
        ConstructorDeclaration var3 = (ConstructorDeclaration)this.field_1560[this.field_1559];
        var3.field_491 = this.field_1567;
        var3.field_481 = this.flushCommentsDefinedPriorTo(this.field_1567);
        if (!var1) {
            var3.field_482 |= 16777216;
        }
    }

    protected void method_2680() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        if (!this.field_1622) {
            this.problemReporter().method_1573(var1);
        }
        --this.field_1559;
        this.method_2865(-1);
        this.method_2529();
    }

    protected void method_2681() {
        TypeDeclaration var1 = (TypeDeclaration)this.field_1560[this.field_1559];
        if (!this.field_1622) {
            this.problemReporter().method_1573(var1);
        }
        --this.field_1559;
        this.method_2865(-1);
        this.method_2529();
    }

    protected void method_2682() {
        --this.field_1587;
        --this.field_1612;
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
        }
        MethodDeclaration var2 = (MethodDeclaration)this.field_1560[this.field_1559];
        var2.field_491 = this.field_1566;
        var2.field_481 = this.flushCommentsDefinedPriorTo(this.field_1567);
        if (!this.field_1622) {
            this.problemReporter().method_1464(var2);
        }
    }

    protected void method_2683() {}

    protected void method_2684() {
        this.method_2872(this.field_1597);
    }

    protected void method_2685() {
        int var1 = this.field_1558[this.field_1557];
        int var2 = this.field_1559 - this.field_1632[this.field_1602] + 1;
        System.arraycopy(this.field_1560, var2, this.field_1560, var2 - 1, var1);
        --this.field_1559;
        this.field_1558[--this.field_1557] = var1;
        this.field_1632[this.field_1602] = 0;
    }

    protected void method_2686() {
        ++this.field_1613[this.field_1612];
        int var1 = this.field_1558[this.field_1557];
        for (int var2 = var1 - 1; var2 >= 0; --var2) {
            LocalDeclaration var3 = (LocalDeclaration)this.field_1560[this.field_1559 - var2];
            var3.field_652 = this.field_1567;
            var3.field_651 = this.field_1567;
        }
    }

    protected void method_2687() {
        MarkerAnnotation var1 = null;
        int var2 = this.field_1584;
        TypeReference var3 = this.getAnnotationType();
        MarkerAnnotation var10000 = new MarkerAnnotation(var3, this.field_1588[this.field_1587--]);
        var1 = var10000;
        var1.declarationSourceEnd = var1.field_445;
        this.method_2867(var1);
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1645(var1);
        }
        this.field_1634 = true;
        if (this.currentElement != null && this.currentElement instanceof RecoveredAnnotation) {
            this.currentElement = ((RecoveredAnnotation)this.currentElement).addAnnotation(var1, var2);
        }
    }

    protected void method_2688() {
        this.arrayInitializer(this.field_1569[this.field_1568--]);
    }

    protected void method_2689() {
        this.method_2867(this.method_2839());
    }

    protected void method_2690() {
        char[] var1 = this.identifierStack[this.field_1584];
        long var2 = this.identifierPositionStack[this.field_1584--];
        --this.field_1581;
        int var4 = (int)var2;
        int var5 = (int)(var2 >>> 32);
        Expression var6 = this.expressionStack[this.field_1570--];
        --this.field_1568;
        MemberValuePair var10000 = new MemberValuePair(var1, var5, var4, var6);
        MemberValuePair var7 = var10000;
        this.method_2866(var7);
        if (this.currentElement != null && this.currentElement instanceof RecoveredAnnotation) {
            RecoveredAnnotation var8 = (RecoveredAnnotation)this.currentElement;
            var8.setKind(1);
        }
    }

    protected void method_2691() {
        this.method_2529();
    }

    protected void method_2692() {
        this.method_2527();
    }

    protected void method_2693() {
        --this.field_1601[this.field_1602];
    }

    protected void method_2694(boolean var1) {
        if (var1) {
            --this.field_1587;
            --this.field_1587;
        }
        int var3 = 0;
        Statement[] var4 = null;
        if (var1) {
            var3 = this.field_1613[this.field_1612--];
            int var2;
            if ((var2 = this.field_1558[this.field_1557--]) != 0) {
                System.arraycopy(this.field_1560, (this.field_1559 -= var2) + 1, var4 = new Statement[var2], 0, var2);
            }
        }
        MethodDeclaration var5 = (MethodDeclaration)this.field_1560[this.field_1559];
        var5.statements = var4;
        var5.field_487 = var3;
        if (!var1) {
            var5.field_482 |= 16777216;
        } else if ((!this.field_1564 || this.field_1565 != 0) && var4 == null && !this.containsComment(var5.field_490, this.field_1566)) {
            var5.field_446 |= 8;
        }
        var5.field_491 = this.field_1566;
        var5.field_481 = this.flushCommentsDefinedPriorTo(this.field_1567);
    }

    protected void method_2695() {
        AbstractMethodDeclaration var1 = (AbstractMethodDeclaration)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_490 = this.scanner.field_1231;
        }
        if (this.currentElement != null) {
            if (this.field_1563 == 27) {
                var1.field_482 |= 16777216;
                var1.field_481 = this.scanner.field_1231 - 1;
                var1.field_491 = this.scanner.field_1231 - 1;
                if (this.currentElement.parseTree() == var1 && this.currentElement.parent != null) {
                    this.currentElement = this.currentElement.parent;
                }
            } else if (this.field_1563 == 69 && this.currentElement instanceof RecoveredMethod && ((RecoveredMethod)this.currentElement).methodDeclaration != var1) {
                this.field_1586 = true;
                ++this.currentElement.bracketBalance;
            }
            this.field_1618 = true;
        }
    }

    protected void method_2696() {
        MethodDeclaration var1 = (MethodDeclaration)this.field_1560[this.field_1559];
        int var2 = this.field_1569[this.field_1568--];
        if (var2 == 1) {
            --this.field_1587;
            --this.field_1587;
            if (var1.method_793()) {
                ((AnnotationMethodDeclaration)var1).defaultValue = this.expressionStack[this.field_1570];
                var1.field_482 |= 131072;
            }
            --this.field_1570;
            this.field_1634 = true;
        }
        if (this.currentElement != null && var1.method_793()) {
            this.currentElement.method_1857(((AnnotationMethodDeclaration)var1).defaultValue.field_445);
        }
    }

    protected void method_2697() {
        MethodDeclaration var1 = (MethodDeclaration)this.field_1560[this.field_1559];
        int var2 = this.field_1588[this.field_1587--];
        if (var1.method_793()) {
            ((AnnotationMethodDeclaration)var1).extendedDimensions = var2;
        }
        if (var2 != 0) {
            TypeReference var3 = var1.returnType;
            var1.field_445 = this.field_1566;
            int var4 = var3.dimensions() + var2;
            var1.returnType = this.copyDims(var3, var4);
            if (this.field_1563 == 69) {
                var1.field_490 = this.field_1566 + 1;
            }
            if (this.currentElement != null) {
                this.field_1590 = var1.field_490;
            }
        }
    }

    protected void method_2698(boolean var1) {
        Object var2 = null;
        if (var1) {
            AnnotationMethodDeclaration var10000 = new AnnotationMethodDeclaration(this.compilationUnit.compilationResult);
            var2 = var10000;
            this.field_1634 = false;
        } else {
            MethodDeclaration var6 = new MethodDeclaration(this.compilationUnit.compilationResult);
            var2 = var6;
        }
        ((MethodDeclaration)var2).selector = this.identifierStack[this.field_1584];
        long var3 = this.identifierPositionStack[this.field_1584--];
        --this.field_1581;
        ((MethodDeclaration)var2).returnType = this.getTypeReference(this.field_1588[this.field_1587--]);
        ((MethodDeclaration)var2).field_480 = this.field_1588[this.field_1587--];
        ((MethodDeclaration)var2).field_482 = this.field_1588[this.field_1587--];
        int var5;
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var5) + 1, ((MethodDeclaration)var2).annotations = new Annotation[var5], 0, var5);
        }
        ((MethodDeclaration)var2).field_444 = (int)(var3 >>> 32);
        this.method_2866((ASTNode)var2);
        ((MethodDeclaration)var2).field_445 = this.field_1597;
        ((MethodDeclaration)var2).field_490 = this.field_1597 + 1;
        this.field_1595 = 0;
        if (this.currentElement != null) {
            if (!(this.currentElement instanceof RecoveredType) && Util.getLineNumber(((MethodDeclaration)var2).returnType.field_444, this.scanner.field_1256, 0, this.scanner.field_1257) != Util.getLineNumber(((MethodDeclaration)var2).field_444, this.scanner.field_1256, 0, this.scanner.field_1257)) {
                this.field_1590 = ((MethodDeclaration)var2).field_444;
                this.field_1618 = true;
            } else {
                this.field_1590 = ((MethodDeclaration)var2).field_490;
                this.currentElement = this.currentElement.add((AbstractMethodDeclaration)var2, 0);
                this.field_1593 = -1;
            }
        }
    }

    protected void method_2699(boolean var1) {
        Object var2 = null;
        if (var1) {
            AnnotationMethodDeclaration var10000 = new AnnotationMethodDeclaration(this.compilationUnit.compilationResult);
            var2 = var10000;
            this.field_1634 = false;
        } else {
            MethodDeclaration var7 = new MethodDeclaration(this.compilationUnit.compilationResult);
            var2 = var7;
        }
        ((MethodDeclaration)var2).selector = this.identifierStack[this.field_1584];
        long var3 = this.identifierPositionStack[this.field_1584--];
        --this.field_1581;
        ((MethodDeclaration)var2).returnType = this.getTypeReference(this.field_1588[this.field_1587--]);
        int var5 = this.field_1576[this.field_1575--];
        this.field_1577 -= var5;
        System.arraycopy(this.field_1578, this.field_1577 + 1, ((MethodDeclaration)var2).typeParameters = new TypeParameter[var5], 0, var5);
        ((MethodDeclaration)var2).field_480 = this.field_1588[this.field_1587--];
        ((MethodDeclaration)var2).field_482 = this.field_1588[this.field_1587--];
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var5) + 1, ((MethodDeclaration)var2).annotations = new Annotation[var5], 0, var5);
        }
        ((MethodDeclaration)var2).field_444 = (int)(var3 >>> 32);
        this.method_2866((ASTNode)var2);
        ((MethodDeclaration)var2).field_445 = this.field_1597;
        ((MethodDeclaration)var2).field_490 = this.field_1597 + 1;
        this.field_1595 = 0;
        if (this.currentElement != null) {
            boolean var6;
            if (!(var6 = this.currentElement instanceof RecoveredType) && Util.getLineNumber(((MethodDeclaration)var2).returnType.field_444, this.scanner.field_1256, 0, this.scanner.field_1257) != Util.getLineNumber(((MethodDeclaration)var2).field_444, this.scanner.field_1256, 0, this.scanner.field_1257)) {
                this.field_1590 = ((MethodDeclaration)var2).field_444;
                this.field_1618 = true;
            } else {
                if (var6) {
                    ((RecoveredType)this.currentElement).pendingTypeParameters = null;
                }
                this.field_1590 = ((MethodDeclaration)var2).field_490;
                this.currentElement = this.currentElement.add((AbstractMethodDeclaration)var2, 0);
                this.field_1593 = -1;
            }
        }
    }

    protected void method_2700() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        AbstractMethodDeclaration var2 = (AbstractMethodDeclaration)this.field_1560[this.field_1559];
        var2.field_445 = this.field_1598;
        if (var1 != 0) {
            System.arraycopy(this.field_1560, this.field_1559 + 1, var2.arguments = new Argument[var1], 0, var1);
        }
        var2.field_490 = this.field_1598 + 1;
        this.field_1595 = 0;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_490;
            if (this.currentElement.parseTree() == var2) {
                return;
            }
            if (var2.method_795() && (var1 != 0 || this.field_1563 == 69 || this.field_1563 == 105)) {
                this.currentElement = this.currentElement.add(var2, 0);
                this.field_1593 = -1;
            }
        }
    }

    protected void method_2701() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        AbstractMethodDeclaration var2 = (AbstractMethodDeclaration)this.field_1560[this.field_1559];
        System.arraycopy(this.field_1560, this.field_1559 + 1, var2.thrownExceptions = new TypeReference[var1], 0, var1);
        var2.field_445 = var2.thrownExceptions[var1 - 1].field_445;
        var2.field_490 = var2.thrownExceptions[var1 - 1].field_445 + 1;
        this.field_1595 = 0;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_490;
        }
    }

    protected void method_2702() {
        MessageSend var1 = this.method_2851();
        var1.field_445 = this.field_1598;
        var1.field_444 = (int)((var1.nameSourcePosition = this.identifierPositionStack[this.field_1584]) >>> 32);
        var1.selector = this.identifierStack[this.field_1584--];
        if (this.field_1582[this.field_1581] == 1) {
            var1.receiver = ThisReference.implicitThis();
            --this.field_1581;
        } else {
            --this.field_1582[this.field_1581];
            var1.receiver = this.method_2838();
            var1.field_444 = var1.receiver.field_444;
        }
        this.method_2867(var1);
    }

    protected void method_2703() {
        MessageSend var1 = this.method_2852();
        var1.field_445 = this.field_1598;
        var1.field_444 = (int)((var1.nameSourcePosition = this.identifierPositionStack[this.field_1584]) >>> 32);
        var1.selector = this.identifierStack[this.field_1584--];
        --this.field_1581;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeArguments = new TypeReference[var2], 0, var2);
        --this.field_1587;
        var1.receiver = this.method_2838();
        var1.field_444 = var1.receiver.field_444;
        this.method_2867(var1);
    }

    protected void method_2704() {
        MessageSend var1 = this.method_2851();
        var1.field_444 = (int)((var1.nameSourcePosition = this.identifierPositionStack[this.field_1584]) >>> 32);
        var1.selector = this.identifierStack[this.field_1584--];
        --this.field_1581;
        var1.receiver = this.expressionStack[this.field_1570];
        var1.field_444 = var1.receiver.field_444;
        var1.field_445 = this.field_1598;
        this.expressionStack[this.field_1570] = var1;
    }

    protected void method_2705() {
        MessageSend var1 = this.method_2852();
        var1.field_444 = (int)((var1.nameSourcePosition = this.identifierPositionStack[this.field_1584]) >>> 32);
        var1.selector = this.identifierStack[this.field_1584--];
        --this.field_1581;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeArguments = new TypeReference[var2], 0, var2);
        --this.field_1587;
        var1.receiver = this.expressionStack[this.field_1570];
        var1.field_444 = var1.receiver.field_444;
        var1.field_445 = this.field_1598;
        this.expressionStack[this.field_1570] = var1;
    }

    protected void method_2706() {
        MessageSend var1 = this.method_2851();
        var1.field_444 = this.field_1588[this.field_1587--];
        var1.field_445 = this.field_1598;
        var1.nameSourcePosition = this.identifierPositionStack[this.field_1584];
        var1.selector = this.identifierStack[this.field_1584--];
        --this.field_1581;
        SuperReference var10001 = new SuperReference(var1.field_444, this.field_1566);
        var1.receiver = var10001;
        this.method_2867(var1);
    }

    protected void method_2707() {
        MessageSend var1 = this.method_2852();
        --this.field_1587;
        var1.field_445 = this.field_1598;
        var1.nameSourcePosition = this.identifierPositionStack[this.field_1584];
        var1.selector = this.identifierStack[this.field_1584--];
        --this.field_1581;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.typeArguments = new TypeReference[var2], 0, var2);
        var1.field_444 = this.field_1588[this.field_1587--];
        SuperReference var10001 = new SuperReference(var1.field_444, this.field_1566);
        var1.receiver = var10001;
        this.method_2867(var1);
    }

    protected void method_2708() {
        int var1 = this.field_1600;
        this.method_2524();
        this.method_2872(this.field_1599);
        if (this.field_1600 >= var1) {
            this.field_1600 = var1;
        }
        this.method_2872(this.field_1600);
        this.method_2879();
    }

    protected void method_2709() {
        this.field_1569[this.field_1568 - 1] += this.field_1569[this.field_1568--];
    }

    protected void method_2710() {
        this.method_2871(0);
        this.method_2870(this.field_1582[this.field_1581]);
    }

    protected void method_2711() {
        this.method_2847();
        ++this.field_1601[this.field_1602];
        this.method_2872(this.scanner.field_1231);
        this.method_2718();
    }

    protected void method_2712() {
        int var1 = this.field_1601.length;
        if (++this.field_1602 >= var1) {
            System.arraycopy(this.field_1601, 0, this.field_1601 = new int[var1 + 30], 0, var1);
            System.arraycopy(this.field_1632, 0, this.field_1632 = new int[var1 + 30], 0, var1);
        }
        this.field_1601[this.field_1602] = 0;
        this.field_1632[this.field_1602] = 0;
    }

    protected void method_2713() {
        NormalAnnotation var1 = null;
        int var2 = this.field_1584;
        TypeReference var3 = this.getAnnotationType();
        NormalAnnotation var10000 = new NormalAnnotation(var3, this.field_1588[this.field_1587--]);
        var1 = var10000;
        int var4;
        if ((var4 = this.field_1558[this.field_1557--]) != 0) {
            System.arraycopy(this.field_1560, (this.field_1559 -= var4) + 1, var1.memberValuePairs = new MemberValuePair[var4], 0, var4);
        }
        var1.declarationSourceEnd = this.field_1598;
        this.method_2867(var1);
        if (this.currentElement != null) {
            this.method_2519(var1.field_444, var1.declarationSourceEnd);
            if (this.currentElement instanceof RecoveredAnnotation) {
                this.currentElement = ((RecoveredAnnotation)this.currentElement).addAnnotation(var1, var2);
            }
        }
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1645(var1);
        }
        this.field_1634 = true;
    }

    protected void method_2714() {
        ++this.field_1603;
    }

    protected void method_2715() {
        this.method_2872(this.field_1631);
        this.method_2879();
        --this.field_1568;
    }

    protected void method_2716() {
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            int var1 = this.field_1576[this.field_1575];
            this.problemReporter().invalidUsageOfTypeArguments((TypeReference)this.field_1578[this.field_1577 - var1 + 1], (TypeReference)this.field_1578[this.field_1577]);
        }
    }

    protected void method_2717() {}

    protected void method_2718() {
        this.method_2872(this.scanner.field_1230);
        int var1 = this.field_1613.length;
        if (++this.field_1612 >= var1) {
            System.arraycopy(this.field_1613, 0, this.field_1613 = new int[var1 + 255], 0, var1);
        }
        this.field_1613[this.field_1612] = 0;
    }

    protected void method_2719() {
        if (this.options.field_1928 >= 3211264L) {
            this.method_2524();
            this.method_2879();
        }
    }

    protected void method_2720() {
        ImportReference var1 = this.compilationUnit.currentPackage;
        var1.field_469 = this.field_1567;
        var1.field_471 = this.flushCommentsDefinedPriorTo(var1.field_471);
    }

    protected void method_2721() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.identifierStack, ++this.field_1584, var3, 0, var2);
        System.arraycopy(this.identifierPositionStack, this.field_1584--, var4, 0, var2);
        ImportReference var10000 = new ImportReference(var3, var4, true, 0);
        ImportReference var1 = var10000;
        this.compilationUnit.currentPackage = var1;
        if (this.field_1563 == 27) {
            var1.field_471 = this.scanner.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1618 = true;
        }
    }

    protected void method_2722() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.identifierStack, ++this.field_1584, var3, 0, var2);
        System.arraycopy(this.identifierPositionStack, this.field_1584--, var4, 0, var2);
        int var5 = this.field_1588[this.field_1587--];
        int var6 = this.field_1588[this.field_1587--];
        ImportReference var10000 = new ImportReference(var3, var4, true, var6);
        ImportReference var1 = var10000;
        this.compilationUnit.currentPackage = var1;
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.expressionStack, (this.field_1570 -= var2) + 1, var1.annotations = new Annotation[var2], 0, var2);
            var1.field_470 = var5;
            --this.field_1587;
        } else {
            var1.field_470 = this.field_1588[this.field_1587--];
        }
        if (this.field_1563 == 27) {
            var1.field_471 = this.scanner.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1618 = true;
        }
    }

    protected void method_2723() {
        this.method_2867(this.method_2839());
    }

    protected void method_2724() {
        Expression var1 = this.expressionStack[this.field_1570];
        this.method_2885(var1);
        int var2 = (var1.field_446 & 534773760) >> 21;
        var1.field_446 &= -534773761;
        var1.field_446 |= var2 + 1 << 21;
    }

    protected void method_2725() {
        --this.field_1587;
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        ClassLiteralAccess var10001 = new ClassLiteralAccess(this.field_1588[this.field_1587--], this.getTypeReference(this.field_1588[this.field_1587--]));
        this.method_2867(var10001);
    }

    protected void method_2726() {
        --this.field_1587;
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        TypeReference var1 = this.getTypeReference(0);
        ClassLiteralAccess var10001 = new ClassLiteralAccess(this.field_1588[this.field_1587--], var1);
        this.method_2867(var10001);
    }

    protected void method_2727() {
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        TypeReference var1 = this.getTypeReference(0);
        QualifiedSuperReference var10001 = new QualifiedSuperReference(var1, this.field_1588[this.field_1587--], this.field_1566);
        this.method_2867(var10001);
    }

    protected void method_2728() {
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        TypeReference var1 = this.getTypeReference(0);
        QualifiedThisReference var10001 = new QualifiedThisReference(var1, this.field_1588[this.field_1587--], this.field_1566);
        this.method_2867(var10001);
    }

    protected void method_2729() {
        --this.field_1587;
        ClassLiteralAccess var10001 = new ClassLiteralAccess(this.field_1588[this.field_1587--], this.getTypeReference(this.field_1588[this.field_1587--]));
        this.method_2867(var10001);
    }

    protected void method_2730() {
        --this.field_1587;
        ClassLiteralAccess var10001 = new ClassLiteralAccess(this.field_1588[this.field_1587--], this.getTypeReference(0));
        this.method_2867(var10001);
    }

    protected void method_2731() {
        ThisReference var10001 = new ThisReference(this.field_1588[this.field_1587--], this.field_1566);
        this.method_2867(var10001);
    }

    protected void method_2732() {
        this.method_2867(this.method_2839());
        Expression var1 = this.expressionStack[this.field_1570];
        this.method_2885(var1);
        int var2 = (var1.field_446 & 534773760) >> 21;
        var1.field_446 &= -534773761;
        var1.field_446 |= var2 + 1 << 21;
    }

    protected void method_2733() {}

    protected void method_2734() {
        this.method_2872(0);
    }

    protected void method_2735() {
        this.method_2872(this.field_1566);
    }

    protected void method_2736() {
        this.method_2524();
        this.method_2872(this.field_1599);
        this.method_2872(this.field_1600);
        this.method_2879();
    }

    protected void method_2737() {
        this.method_2872(this.field_1599);
        this.method_2872(this.field_1600);
        this.method_2879();
        this.method_2868(0);
    }

    protected void method_2738() {
        this.method_2524();
        this.method_2872(this.field_1599);
        this.method_2872(this.field_1600);
        this.method_2879();
        this.method_2868(0);
    }

    protected void method_2739() {
        this.method_2872(this.field_1566);
    }

    protected void method_2740() {
        ++this.field_1582[--this.field_1581];
    }

    protected void method_2741() {
        boolean var1 = false;
        if (this.currentElement instanceof RecoveredType) {
            var1 = (((RecoveredType)this.currentElement).typeDeclaration.field_577 & 8192) != 0;
        } else {
            RecoveredType var2 = this.currentElement.enclosingType();
            if (var2 != null) {
                var1 = (var2.typeDeclaration.field_577 & 8192) != 0;
            }
        }
        this.method_2698(var1);
    }

    protected void method_2742() {
        boolean var1 = false;
        if (this.currentElement instanceof RecoveredType) {
            var1 = (((RecoveredType)this.currentElement).typeDeclaration.field_577 & 8192) != 0;
        } else {
            RecoveredType var2 = this.currentElement.enclosingType();
            if (var2 != null) {
                var1 = (var2.typeDeclaration.field_577 & 8192) != 0;
            }
        }
        this.method_2699(var1);
    }

    protected void method_2743() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, this.compilationUnit.imports = new ImportReference[var1], 0, var1);
        }
    }

    protected void method_2744() {
        this.method_2872(0);
    }

    protected void method_2745() {
        this.method_2869(this.getTypeReference(this.field_1588[this.field_1587--]));
    }

    protected void method_2746() {
        this.method_2869(this.getTypeReference(this.field_1588[this.field_1587--]));
    }

    protected void method_2747() {
        this.method_2869(this.getTypeReference(this.field_1588[this.field_1587--]));
    }

    protected void method_2748() {
        --this.field_1565;
    }

    protected void method_2749() {
        this.method_2872(this.field_1598);
    }

    protected void method_2750(int var1) {
        switch (var1) {
            case 30:
                this.method_2734();
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
            case 46:
            case 47:
            case 56:
            case 57:
            case 58:
            case 59:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 88:
            case 90:
            case 96:
            case 97:
            case 98:
            case 99:
            case 104:
            case 105:
            case 107:
            case 108:
            case 109:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 126:
            case 130:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 150:
            case 151:
            case 153:
            case 155:
            case 156:
            case 162:
            case 163:
            case 164:
            case 165:
            case 177:
            case 181:
            case 205:
            case 208:
            case 209:
            case 212:
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 227:
            case 231:
            case 233:
            case 234:
            case 235:
            case 245:
            case 246:
            case 247:
            case 248:
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
            case 256:
            case 257:
            case 258:
            case 259:
            case 260:
            case 261:
            case 262:
            case 263:
            case 264:
            case 265:
            case 266:
            case 267:
            case 268:
            case 269:
            case 275:
            case 276:
            case 277:
            case 278:
            case 279:
            case 280:
            case 281:
            case 282:
            case 288:
            case 289:
            case 291:
            case 294:
            case 304:
            case 305:
            case 306:
            case 320:
            case 322:
            case 325:
            case 328:
            case 329:
            case 330:
            case 331:
            case 335:
            case 336:
            case 343:
            case 344:
            case 354:
            case 356:
            case 364:
            case 366:
            case 369:
            case 370:
            case 383:
            case 385:
            case 386:
            case 390:
            case 391:
            case 394:
            case 397:
            case 400:
            case 410:
            case 414:
            case 417:
            case 421:
            case 426:
            case 428:
            case 431:
            case 433:
            case 435:
            case 437:
            case 439:
            case 441:
            case 443:
            case 444:
            case 446:
            case 460:
            case 461:
            case 462:
            case 464:
            case 465:
            case 466:
            case 467:
            case 473:
            case 475:
            case 477:
            case 478:
            case 479:
            case 481:
            case 482:
            case 483:
            case 488:
            case 490:
            case 491:
            case 492:
            case 494:
            case 503:
            case 511:
            case 514:
            case 526:
            case 528:
            case 531:
            case 532:
            case 533:
            case 536:
            case 538:
            case 539:
            case 542:
            case 544:
            case 545:
            case 565:
            case 567:
            case 570:
            case 573:
            case 578:
            case 581:
            case 582:
            case 583:
            case 584:
            case 585:
            case 588:
            case 589:
            case 592:
            case 593:
            case 600:
            case 605:
            case 612:
            case 621:
            case 624:
            case 629:
            case 632:
            case 635:
            case 638:
            case 641:
            case 644:
            case 647:
            case 648:
            case 649:
            case 656:
            case 659:
            case 667:
            case 668:
            case 669:
            case 670:
            case 671:
            case 672:
            case 673:
            case 677:
            case 678:
            case 683:
            case 685:
            case 686:
            case 692:
            default:
                break;
            case 44:
                this.method_2744();
                break;
            case 48:
                this.method_2584();
                break;
            case 49:
                this.method_2583();
                break;
            case 50:
                this.method_2657();
                break;
            case 51:
                this.method_2550();
                break;
            case 52:
                this.method_2733();
                break;
            case 53:
                this.method_2710();
                break;
            case 54:
                this.method_2659();
                break;
            case 55:
                this.method_2658();
                break;
            case 60:
                this.method_2740();
                break;
            case 61:
                this.method_2587();
                break;
            case 62:
                this.method_2675();
                break;
            case 63:
                this.method_2675();
                break;
            case 64:
                this.method_2676();
                break;
            case 65:
                this.method_2676();
                break;
            case 66:
                this.method_2675();
                break;
            case 67:
                this.method_2676();
                break;
            case 68:
                this.method_2676();
                break;
            case 69:
                this.method_2615();
                break;
            case 70:
                this.method_2743();
                break;
            case 71:
                this.method_2625();
                break;
            case 87:
                this.method_2566();
                break;
            case 89:
                this.method_2661();
                break;
            case 91:
                this.method_2789();
                break;
            case 92:
                this.method_2720();
                break;
            case 93:
                this.method_2722();
                break;
            case 94:
                this.method_2721();
                break;
            case 95:
                this.method_2719();
                break;
            case 100:
                this.method_2660();
                break;
            case 101:
                this.method_2755();
                break;
            case 102:
                this.method_2660();
                break;
            case 103:
                this.method_2790();
                break;
            case 106:
                this.method_2620();
                break;
            case 110:
                this.method_2709();
                break;
            case 122:
                this.method_2535();
                break;
            case 123:
                this.method_2572();
                break;
            case 124:
                this.method_2573();
                break;
            case 125:
                this.method_2577();
                break;
            case 127:
                this.method_2576();
                break;
            case 128:
                this.method_2574();
                break;
            case 129:
                this.method_2575();
                break;
            case 131:
                this.method_2674();
                break;
            case 132:
                this.method_2673();
                break;
            case 135:
                this.method_2568();
                break;
            case 139:
                this.method_2567();
                break;
            case 140:
                this.method_2597();
                break;
            case 141:
                this.method_2567();
                break;
            case 142:
                this.method_2595();
                break;
            case 149:
                this.method_2620();
                break;
            case 152:
                this.method_2651();
                break;
            case 154:
                this.method_2802();
                break;
            case 157:
                this.method_2628();
                break;
            case 158:
                this.method_2645();
                break;
            case 159:
                this.method_2646();
                break;
            case 160:
                this.method_2652();
                break;
            case 161:
                this.method_2748();
                break;
            case 166:
                this.method_2694(true);
                break;
            case 167:
                this.method_2694(false);
                break;
            case 168:
                this.method_2695();
                break;
            case 169:
                this.method_2699(false);
                break;
            case 170:
                this.method_2698(false);
                break;
            case 171:
                this.method_2700();
                break;
            case 172:
                this.method_2697();
                break;
            case 173:
                this.method_2701();
                break;
            case 174:
                this.method_2591();
                break;
            case 175:
                this.method_2593();
                break;
            case 176:
                this.method_2592();
                break;
            case 178:
                this.method_2655();
                break;
            case 179:
                this.method_2654(false);
                break;
            case 180:
                this.method_2654(true);
                break;
            case 182:
                this.method_2586();
                break;
            case 183:
                this.method_2585();
                break;
            case 184:
                this.method_2693();
                break;
            case 185:
                this.method_2711();
                break;
            case 186:
                this.method_2774();
                break;
            case 187:
                this.method_2775();
                break;
            case 188:
                this.method_2590();
                break;
            case 189:
                this.method_2678();
                break;
            case 190:
                this.method_2647(0, 3);
                break;
            case 191:
                this.method_2648(0, 3);
                break;
            case 192:
                this.method_2647(0, 2);
                break;
            case 193:
                this.method_2648(0, 2);
                break;
            case 194:
                this.method_2647(1, 2);
                break;
            case 195:
                this.method_2648(1, 2);
                break;
            case 196:
                this.method_2647(2, 2);
                break;
            case 197:
                this.method_2648(2, 2);
                break;
            case 198:
                this.method_2647(1, 3);
                break;
            case 199:
                this.method_2648(1, 3);
                break;
            case 200:
                this.method_2647(2, 3);
                break;
            case 201:
                this.method_2648(2, 3);
                break;
            case 202:
                this.method_2667();
                break;
            case 203:
                this.method_2668();
                break;
            case 204:
                this.method_2577();
                break;
            case 206:
                this.method_2670();
                break;
            case 207:
                this.method_2669();
                break;
            case 210:
                this.method_2671();
                break;
            case 211:
                this.method_2620();
                break;
            case 213:
                this.method_2682();
                break;
            case 214:
                this.method_2679(true);
                break;
            case 215:
                this.method_2679(false);
                break;
            case 223:
                this.method_2735();
                break;
            case 224:
                this.method_2604();
                break;
            case 225:
                this.method_2549();
                break;
            case 226:
                this.method_2549();
                break;
            case 228:
                this.method_2803();
                break;
            case 229:
                this.method_2556();
                break;
            case 230:
                this.method_2718();
                break;
            case 232:
                this.method_2557();
                break;
            case 236:
                this.method_2680();
                break;
            case 237:
                this.method_2677();
                break;
            case 238:
                this.method_2681();
                break;
            case 239:
                this.method_2686();
                break;
            case 240:
                this.method_2685();
                break;
            case 241:
                this.method_2685();
                break;
            case 242:
                this.method_2737();
                break;
            case 243:
                this.method_2738();
                break;
            case 244:
                this.method_2736();
                break;
            case 270:
                this.method_2618();
                break;
            case 271:
                this.method_2766();
                break;
            case 272:
                this.method_2766();
                break;
            case 273:
                this.method_2683();
                break;
            case 274:
                this.method_2649();
                break;
            case 283:
                this.method_2764();
                break;
            case 284:
                this.method_2765();
                break;
            case 285:
                this.method_2765();
                break;
            case 286:
                this.method_2768();
                break;
            case 287:
                this.method_2619();
                break;
            case 290:
                this.method_2776();
                break;
            case 292:
                this.method_2778();
                break;
            case 293:
                this.method_2777();
                break;
            case 295:
                this.method_2779();
                break;
            case 296:
                this.method_2558();
                break;
            case 297:
                this.method_2594();
                break;
            case 298:
                this.method_2772();
                break;
            case 299:
                this.method_2772();
                break;
            case 300:
                this.method_2761();
                break;
            case 301:
                this.method_2763();
                break;
            case 302:
                this.method_2763();
                break;
            case 303:
                this.method_2653();
                break;
            case 307:
                this.method_2762();
                break;
            case 308:
                this.method_2751();
                break;
            case 309:
                this.method_2551();
                break;
            case 310:
                this.method_2756();
                break;
            case 311:
                this.method_2757();
                break;
            case 312:
                this.method_2759();
                break;
            case 313:
                this.method_2760();
                break;
            case 314:
                this.method_2767();
                break;
            case 315:
                this.method_2770();
                break;
            case 316:
                this.method_2769();
                break;
            case 317:
                this.method_2715();
                break;
            case 318:
                this.method_2771(false);
                break;
            case 319:
                this.method_2771(true);
                break;
            case 321:
                this.method_2644();
                break;
            case 323:
                this.method_2565();
                break;
            case 324:
                this.method_2758();
                break;
            case 326:
                this.method_2684();
                break;
            case 327:
                this.method_2749();
                break;
            case 332:
                this.method_2731();
                break;
            case 333:
                this.method_2724();
                break;
            case 334:
                this.method_2732();
                break;
            case 337:
                this.method_2728();
                break;
            case 338:
                this.method_2727();
                break;
            case 339:
                this.method_2726();
                break;
            case 340:
                this.method_2725();
                break;
            case 341:
                this.method_2729();
                break;
            case 342:
                this.method_2730();
                break;
            case 345:
                this.method_2534();
                break;
            case 346:
                this.method_2582();
                break;
            case 347:
                this.method_2578();
                break;
            case 348:
                this.method_2581();
                break;
            case 349:
                this.method_2580();
                break;
            case 350:
                this.method_2580();
                break;
            case 351:
                this.method_2581();
                break;
            case 352:
                this.method_2579();
                break;
            case 353:
                this.method_2571();
                break;
            case 355:
                this.method_2624();
                break;
            case 357:
                this.method_2543();
                break;
            case 358:
                this.method_2548();
                break;
            case 359:
                this.method_2548();
                break;
            case 360:
                this.method_2547();
                break;
            case 361:
                this.method_2546();
                break;
            case 362:
                this.method_2547();
                break;
            case 363:
                this.method_2546();
                break;
            case 365:
                this.method_2600();
                break;
            case 367:
                this.method_2599();
                break;
            case 368:
                this.method_2598();
                break;
            case 371:
                this.method_2714();
                break;
            case 372:
                this.method_2650(false);
                break;
            case 373:
                this.method_2650(true);
                break;
            case 374:
                this.method_2702();
                break;
            case 375:
                this.method_2703();
                break;
            case 376:
                this.method_2705();
                break;
            case 377:
                this.method_2704();
                break;
            case 378:
                this.method_2707();
                break;
            case 379:
                this.method_2706();
                break;
            case 380:
                this.method_2545(true);
                break;
            case 381:
                this.method_2545(false);
                break;
            case 382:
                this.method_2545(false);
                break;
            case 384:
                this.method_2723();
                break;
            case 387:
                this.consumeUnaryExpression(14, true);
                break;
            case 388:
                this.consumeUnaryExpression(13, true);
                break;
            case 389:
                this.method_2739();
                break;
            case 392:
                this.method_2800(14);
                break;
            case 393:
                this.method_2800(13);
                break;
            case 395:
                this.consumeUnaryExpression(14, false);
                break;
            case 396:
                this.consumeUnaryExpression(13, false);
                break;
            case 398:
                this.method_2800(12);
                break;
            case 399:
                this.method_2800(11);
                break;
            case 401:
                this.method_2562();
                break;
            case 402:
                this.method_2560();
                break;
            case 403:
                this.method_2564();
                break;
            case 404:
                this.method_2559();
                break;
            case 405:
                this.method_2561();
                break;
            case 406:
                this.method_2717();
                break;
            case 407:
                this.method_2662();
                break;
            case 408:
                this.method_2663();
                break;
            case 409:
                this.method_2664();
                break;
            case 411:
                this.method_2554(15);
                break;
            case 412:
                this.method_2554(9);
                break;
            case 413:
                this.method_2554(16);
                break;
            case 415:
                this.method_2554(14);
                break;
            case 416:
                this.method_2554(13);
                break;
            case 418:
                this.method_2554(10);
                break;
            case 419:
                this.method_2554(17);
                break;
            case 420:
                this.method_2554(19);
                break;
            case 422:
                this.method_2554(4);
                break;
            case 423:
                this.method_2554(6);
                break;
            case 424:
                this.method_2554(5);
                break;
            case 425:
                this.method_2554(7);
                break;
            case 427:
                this.method_2665();
                break;
            case 429:
                this.method_2641(18);
                break;
            case 430:
                this.method_2641(29);
                break;
            case 432:
                this.method_2554(2);
                break;
            case 434:
                this.method_2554(8);
                break;
            case 436:
                this.method_2554(3);
                break;
            case 438:
                this.method_2554(0);
                break;
            case 440:
                this.method_2554(1);
                break;
            case 442:
                this.method_2588(23);
                break;
            case 445:
                this.method_2552();
                break;
            case 447:
                this.method_2843();
                break;
            case 448:
                this.method_2553(30);
                break;
            case 449:
                this.method_2553(15);
                break;
            case 450:
                this.method_2553(9);
                break;
            case 451:
                this.method_2553(16);
                break;
            case 452:
                this.method_2553(14);
                break;
            case 453:
                this.method_2553(13);
                break;
            case 454:
                this.method_2553(10);
                break;
            case 455:
                this.method_2553(17);
                break;
            case 456:
                this.method_2553(19);
                break;
            case 457:
                this.method_2553(2);
                break;
            case 458:
                this.method_2553(8);
                break;
            case 459:
                this.method_2553(3);
                break;
            case 463:
                this.method_2611();
                break;
            case 468:
                this.method_2607();
                break;
            case 469:
                this.method_2569();
                break;
            case 470:
                this.method_2596();
                break;
            case 471:
                this.method_2708();
                break;
            case 472:
                this.method_2605();
                break;
            case 474:
                this.method_2609();
                break;
            case 476:
                this.method_2602();
                break;
            case 480:
                this.method_2656();
                break;
            case 484:
                this.method_2614();
                break;
            case 485:
                this.method_2672();
                break;
            case 486:
                this.method_2712();
                break;
            case 487:
                this.method_2612();
                break;
            case 489:
                this.method_2613();
                break;
            case 493:
                this.method_2606();
                break;
            case 495:
                this.method_2636();
                break;
            case 496:
                this.method_2638();
                break;
            case 497:
                this.method_2639();
                break;
            case 498:
                this.method_2640();
                break;
            case 499:
                this.method_2629();
                break;
            case 500:
                this.method_2629();
                break;
            case 501:
                this.method_2630();
                break;
            case 502:
                this.method_2630();
                break;
            case 504:
                this.method_2634();
                break;
            case 505:
                this.method_2631();
                break;
            case 506:
                this.method_2632();
                break;
            case 507:
                this.method_2635();
                break;
            case 508:
                this.method_2633();
                break;
            case 509:
                this.method_2544();
                break;
            case 510:
                this.method_2603();
                break;
            case 512:
                this.method_2637();
                break;
            case 513:
                this.method_2610();
                break;
            case 515:
                this.method_2623();
                break;
            case 516:
                this.method_2623();
                break;
            case 517:
                this.method_2621(false);
                break;
            case 518:
                this.method_2621(true);
                break;
            case 519:
                this.method_2622();
                break;
            case 520:
                this.method_2660();
                break;
            case 521:
                this.method_2754();
                break;
            case 522:
                this.method_2660();
                break;
            case 523:
                this.method_2773();
                break;
            case 524:
                this.method_2788();
                break;
            case 525:
                this.method_2716();
                break;
            case 527:
                this.method_2783();
                break;
            case 529:
                this.method_2782();
                break;
            case 530:
                this.method_2781();
                break;
            case 534:
                this.method_2745();
                break;
            case 535:
                this.method_2786();
                break;
            case 537:
                this.method_2784();
                break;
            case 540:
                this.method_2746();
                break;
            case 541:
                this.method_2787();
                break;
            case 543:
                this.method_2785();
                break;
            case 546:
                this.method_2747();
                break;
            case 547:
                this.method_2804();
                break;
            case 548:
                this.method_2819();
                break;
            case 549:
                this.method_2817();
                break;
            case 550:
                this.method_2818();
                break;
            case 551:
                this.method_2805();
                break;
            case 552:
                this.method_2806();
                break;
            case 553:
                this.method_2811();
                break;
            case 554:
                this.method_2812();
                break;
            case 555:
                this.method_2807();
                break;
            case 556:
                this.method_2808();
                break;
            case 557:
                this.method_2813();
                break;
            case 558:
                this.method_2814();
                break;
            case 559:
                this.method_2809();
                break;
            case 560:
                this.method_2810();
                break;
            case 561:
                this.method_2815();
                break;
            case 562:
                this.method_2816();
                break;
            case 563:
                this.method_2791();
                break;
            case 564:
                this.method_2797();
                break;
            case 566:
                this.method_2795();
                break;
            case 568:
                this.method_2798();
                break;
            case 569:
                this.method_2799();
                break;
            case 571:
                this.method_2532();
                break;
            case 572:
                this.method_2530();
                break;
            case 574:
                this.method_2796();
                break;
            case 575:
                this.method_2792();
                break;
            case 576:
                this.method_2793();
                break;
            case 577:
                this.method_2794();
                break;
            case 579:
                this.method_2533();
                break;
            case 580:
                this.method_2531();
                break;
            case 586:
                this.method_2800(14);
                break;
            case 587:
                this.method_2800(13);
                break;
            case 590:
                this.method_2800(12);
                break;
            case 591:
                this.method_2800(11);
                break;
            case 594:
                this.method_2554(15);
                break;
            case 595:
                this.method_2555(15);
                break;
            case 596:
                this.method_2554(9);
                break;
            case 597:
                this.method_2555(9);
                break;
            case 598:
                this.method_2554(16);
                break;
            case 599:
                this.method_2555(16);
                break;
            case 601:
                this.method_2554(14);
                break;
            case 602:
                this.method_2555(14);
                break;
            case 603:
                this.method_2554(13);
                break;
            case 604:
                this.method_2555(13);
                break;
            case 606:
                this.method_2554(10);
                break;
            case 607:
                this.method_2555(10);
                break;
            case 608:
                this.method_2554(17);
                break;
            case 609:
                this.method_2555(17);
                break;
            case 610:
                this.method_2554(19);
                break;
            case 611:
                this.method_2555(19);
                break;
            case 613:
                this.method_2554(4);
                break;
            case 614:
                this.method_2555(4);
                break;
            case 615:
                this.method_2554(6);
                break;
            case 616:
                this.method_2555(6);
                break;
            case 617:
                this.method_2554(5);
                break;
            case 618:
                this.method_2555(5);
                break;
            case 619:
                this.method_2554(7);
                break;
            case 620:
                this.method_2555(7);
                break;
            case 622:
                this.method_2666();
                break;
            case 623:
                this.method_2665();
                break;
            case 625:
                this.method_2641(18);
                break;
            case 626:
                this.method_2642(18);
                break;
            case 627:
                this.method_2641(29);
                break;
            case 628:
                this.method_2642(29);
                break;
            case 630:
                this.method_2554(2);
                break;
            case 631:
                this.method_2555(2);
                break;
            case 633:
                this.method_2554(8);
                break;
            case 634:
                this.method_2555(8);
                break;
            case 636:
                this.method_2554(3);
                break;
            case 637:
                this.method_2555(3);
                break;
            case 639:
                this.method_2554(0);
                break;
            case 640:
                this.method_2555(0);
                break;
            case 642:
                this.method_2554(1);
                break;
            case 643:
                this.method_2555(1);
                break;
            case 645:
                this.method_2588(23);
                break;
            case 646:
                this.method_2589(23);
                break;
            case 650:
                this.method_2539();
                break;
            case 651:
                this.method_2540();
                break;
            case 652:
                this.method_2540();
                break;
            case 653:
                this.method_2539();
                break;
            case 654:
                this.method_2538();
                break;
            case 655:
                this.method_2537();
                break;
            case 657:
                this.method_2601();
                break;
            case 658:
                this.method_2570();
                break;
            case 660:
                this.method_2542();
                break;
            case 661:
                this.method_2699(true);
                break;
            case 662:
                this.method_2698(true);
                break;
            case 663:
                this.method_2608();
                break;
            case 664:
                this.method_2696();
                break;
            case 665:
                this.method_2695();
                break;
            case 666:
                this.method_2541();
                break;
            case 674:
                this.method_2536();
                break;
            case 675:
                this.method_2713();
                break;
            case 676:
                this.method_2616();
                break;
            case 679:
                this.method_2691();
                break;
            case 680:
                this.method_2690();
                break;
            case 681:
                this.method_2626();
                break;
            case 682:
                this.method_2643();
                break;
            case 684:
                this.method_2689();
                break;
            case 687:
                this.method_2688();
                break;
            case 688:
                this.method_2688();
                break;
            case 689:
                this.method_2617();
                break;
            case 690:
                this.method_2617();
                break;
            case 691:
                this.method_2627();
                break;
            case 693:
                this.method_2692();
                break;
            case 694:
                this.method_2687();
                break;
            case 695:
                this.method_2753();
                break;
            case 696:
                this.method_2752();
                break;
            case 697:
                this.method_2742();
                break;
            case 698:
                this.method_2741();
                break;
            case 699:
                this.method_2695();
                break;
            case 700:
                this.method_2695();
        }
    }

    protected void method_2751() {
        --this.field_1568;
        AssertStatement var10001 = new AssertStatement(this.expressionStack[this.field_1570--], this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2752() {
        SingleMemberAnnotation var1 = null;
        int var2 = this.field_1584;
        TypeReference var3 = this.getAnnotationType();
        SingleMemberAnnotation var10000 = new SingleMemberAnnotation(var3, this.field_1588[this.field_1587--]);
        var1 = var10000;
        var1.memberValue = this.expressionStack[this.field_1570--];
        --this.field_1568;
        var1.declarationSourceEnd = this.field_1598;
        this.method_2867(var1);
        if (this.currentElement != null) {
            this.method_2519(var1.field_444, var1.declarationSourceEnd);
            if (this.currentElement instanceof RecoveredAnnotation) {
                this.currentElement = ((RecoveredAnnotation)this.currentElement).addAnnotation(var1, var2);
            }
        }
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            this.problemReporter().method_1645(var1);
        }
        this.field_1634 = true;
    }

    protected void method_2753() {
        if (this.currentElement != null && this.currentElement instanceof RecoveredAnnotation) {
            RecoveredAnnotation var1 = (RecoveredAnnotation)this.currentElement;
            var1.setKind(2);
        }
    }

    protected void method_2754() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.identifierStack, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var4, 0, var2);
        ImportReference var10001 = new ImportReference(var3, var4, false, 8);
        ImportReference var1 = var10001;
        this.method_2866(var10001);
        this.field_1599 = 0;
        this.field_1600 = -1;
        if (this.field_1563 == 27) {
            var1.field_471 = this.scanner.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            var1.field_472 = 0;
            this.problemReporter().method_1649(var1);
        }
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2755() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.identifierStack, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var4, 0, var2);
        ImportReference var10001 = new ImportReference(var3, var4, false, 0);
        ImportReference var1 = var10001;
        this.method_2866(var10001);
        if (this.field_1563 == 27) {
            var1.field_471 = this.scanner.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2756() {
        BreakStatement var10001 = new BreakStatement((char[])null, this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
        if (this.pendingRecoveredType != null) {
            if (this.pendingRecoveredType.allocation == null && this.field_1566 <= this.pendingRecoveredType.field_593) {
                this.field_1560[this.field_1559] = this.pendingRecoveredType;
                this.pendingRecoveredType = null;
                return;
            }
            this.pendingRecoveredType = null;
        }
    }

    protected void method_2757() {
        BreakStatement var10001 = new BreakStatement(this.identifierStack[this.field_1584--], this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
        --this.field_1581;
    }

    protected void method_2758() {
        --this.field_1557;
        this.field_1595 = 0;
    }

    protected void method_2759() {
        ContinueStatement var10001 = new ContinueStatement((char[])null, this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
    }

    protected void method_2760() {
        ContinueStatement var10001 = new ContinueStatement(this.identifierStack[this.field_1584--], this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
        --this.field_1581;
    }

    protected void method_2761() {
        --this.field_1587;
        Statement var1 = (Statement)this.field_1560[this.field_1559];
        --this.field_1568;
        ASTNode[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        DoStatement var10002 = new DoStatement(this.expressionStack[this.field_1570--], var1, this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2762() {
        this.method_2527();
    }

    protected void method_2763() {
        Expression var2 = null;
        boolean var5 = true;
        --this.field_1557;
        Statement var6 = (Statement)this.field_1560[this.field_1559--];
        int var1;
        Statement[] var4;
        if ((var1 = this.field_1569[this.field_1568--]) == 0) {
            var4 = null;
        } else {
            this.field_1570 -= var1;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var4 = new Statement[var1], 0, var1);
        }
        if (this.field_1569[this.field_1568--] != 0) {
            var2 = this.expressionStack[this.field_1570--];
        }
        Statement[] var3;
        if ((var1 = this.field_1558[this.field_1557--]) == 0) {
            var3 = null;
            var5 = false;
        } else if (var1 == -1) {
            var5 = false;
            var1 = this.field_1569[this.field_1568--];
            this.field_1570 -= var1;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var3 = new Statement[var1], 0, var1);
        } else {
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, var3 = new Statement[var1], 0, var1);
        }
        ForStatement var7 = new ForStatement(var3, var2, var4, var6, var5, this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var7);
    }

    protected void method_2764() {
        --this.field_1568;
        Statement var1 = (Statement)this.field_1560[this.field_1559];
        ASTNode[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        IfStatement var10002 = new IfStatement(this.expressionStack[this.field_1570--], var1, this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2765() {
        --this.field_1568;
        --this.field_1557;
        ASTNode[] var10000 = this.field_1560;
        int var10001 = --this.field_1559;
        IfStatement var10002 = new IfStatement(this.expressionStack[this.field_1570--], (Statement)this.field_1560[this.field_1559], (Statement)this.field_1560[this.field_1559 + 1], this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2766() {
        Statement var1 = (Statement)this.field_1560[this.field_1559];
        ASTNode[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        LabeledStatement var10002 = new LabeledStatement(this.identifierStack[this.field_1584], var1, this.identifierPositionStack[this.field_1584--], this.field_1567);
        var10000[var10001] = var10002;
        --this.field_1581;
    }

    protected void method_2767() {
        ReturnStatement var1;
        if (this.field_1569[this.field_1568--] != 0) {
            var1 = new ReturnStatement(this.expressionStack[this.field_1570--], this.field_1588[this.field_1587--], this.field_1567);
            this.method_2866(var1);
        } else {
            var1 = new ReturnStatement((Expression)null, this.field_1588[this.field_1587--], this.field_1567);
            this.method_2866(var1);
        }
    }

    protected void method_2768() {
        SwitchStatement var10000 = new SwitchStatement();
        SwitchStatement var2 = var10000;
        --this.field_1568;
        var2.expression = this.expressionStack[this.field_1570--];
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, var2.statements = new Statement[var1], 0, var1);
        }
        var2.field_605 = this.field_1613[this.field_1612--];
        this.method_2866(var2);
        var2.field_609 = this.field_1588[this.field_1587--];
        var2.field_444 = this.field_1588[this.field_1587--];
        var2.field_445 = this.field_1567;
        if (var1 == 0 && !this.containsComment(var2.field_609, var2.field_445)) {
            var2.field_446 |= 8;
        }
    }

    protected void method_2769() {
        int var10001;
        ASTNode[] var10000;
        SynchronizedStatement var10002;
        if (this.field_1558[this.field_1557] == 0) {
            this.field_1558[this.field_1557] = 1;
            --this.field_1568;
            var10000 = this.field_1560;
            var10001 = ++this.field_1559;
            var10002 = new SynchronizedStatement(this.expressionStack[this.field_1570--], (Block)null, this.field_1588[this.field_1587--], this.field_1567);
            var10000[var10001] = var10002;
        } else {
            --this.field_1568;
            var10000 = this.field_1560;
            var10001 = this.field_1559;
            var10002 = new SynchronizedStatement(this.expressionStack[this.field_1570--], (Block)this.field_1560[this.field_1559], this.field_1588[this.field_1587--], this.field_1567);
            var10000[var10001] = var10002;
        }
        this.method_2879();
    }

    protected void method_2770() {
        --this.field_1568;
        ThrowStatement var10001 = new ThrowStatement(this.expressionStack[this.field_1570--], this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
    }

    protected void method_2771(boolean var1) {
        TryStatement var10000 = new TryStatement();
        TryStatement var3 = var10000;
        if (var1) {
            --this.field_1557;
            var3.field_622 = (Block)this.field_1560[this.field_1559--];
        }
        int var2;
        if ((var2 = this.field_1558[this.field_1557--]) != 0) {
            if (var2 == 1) {
                var3.catchBlocks = new Block[] {(Block)this.field_1560[this.field_1559--]};
                var3.catchArguments = new Argument[] {(Argument)this.field_1560[this.field_1559--]};
            } else {
                Block[] var4 = var3.catchBlocks = new Block[var2];
                for (Argument[] var5 = var3.catchArguments = new Argument[var2]; var2-- > 0; var5[var2] = (Argument)this.field_1560[this.field_1559--]) {
                    var4[var2] = (Block)this.field_1560[this.field_1559--];
                }
            }
        }
        --this.field_1557;
        var3.field_619 = (Block)this.field_1560[this.field_1559--];
        var3.field_445 = this.field_1567;
        var3.field_444 = this.field_1588[this.field_1587--];
        this.method_2866(var3);
    }

    protected void method_2772() {
        --this.field_1568;
        Statement var1 = (Statement)this.field_1560[this.field_1559];
        ASTNode[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        WhileStatement var10002 = new WhileStatement(this.expressionStack[this.field_1570--], var1, this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2773() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.identifierStack, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var4, 0, var2);
        ImportReference var10001 = new ImportReference(var3, var4, true, 8);
        ImportReference var1 = var10001;
        this.method_2866(var10001);
        this.field_1599 = 0;
        this.field_1600 = -1;
        if (this.field_1563 == 27) {
            var1.field_471 = this.scanner.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            var1.field_472 = 0;
            this.problemReporter().method_1649(var1);
        }
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2774() {
        Block var1 = (Block)this.field_1560[this.field_1559];
        if (this.field_1564) {
            var1.field_446 &= -9;
        }
        Initializer var10000 = new Initializer(var1, 8);
        Initializer var2 = var10000;
        this.field_1560[this.field_1559] = var2;
        var2.field_445 = this.field_1567;
        var2.field_652 = this.flushCommentsDefinedPriorTo(this.field_1567);
        --this.field_1601[this.field_1602];
        var2.field_653 = this.field_1588[this.field_1587--];
        var2.field_666 = this.field_1588[this.field_1587--];
        var2.field_667 = this.field_1566;
        if (this.currentElement != null) {
            this.field_1590 = var2.field_652;
            this.currentElement = this.currentElement.add(var2, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2775() {
        int var1 = this.field_1600;
        this.method_2524();
        if (this.field_1600 >= var1) {
            this.field_1600 = var1;
        }
        this.method_2872(this.scanner.field_1231);
        this.method_2872(this.field_1600 >= 0 ? this.field_1600 : this.scanner.field_1230);
        this.method_2847();
        ++this.field_1601[this.field_1602];
        this.method_2879();
        --this.field_1568;
        if (this.currentElement != null) {
            this.field_1614 = this.field_1588[this.field_1587];
        }
    }

    protected void method_2776() {
        this.method_2529();
    }

    protected void method_2777() {
        this.method_2529();
    }

    protected void method_2778() {
        this.method_2529();
    }

    protected void method_2779() {
        this.method_2853();
    }

    protected void method_2780(int var1) {
        switch (var1) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case 30:
            case 65:
            case 68:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 99:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            default:
                break;
            case 7:
                this.method_2872(this.scanner.field_1230);
                break;
            case 8:
            case 9:
                this.field_1566 = this.scanner.field_1230;
                this.field_1567 = this.scanner.field_1231 - 1;
                break;
            case 23:
                this.method_2872(this.scanner.field_1230);
                this.method_2872(this.scanner.field_1231 - 1);
                break;
            case 26:
                this.method_2863();
                long var10;
                if (this.scanner.field_1225 && this.field_1592 < this.scanner.field_1231) {
                    var10 = this.identifierPositionStack[this.field_1584];
                    if (!this.field_1622) {
                        this.problemReporter().method_1817((int)(var10 >>> 32), (int)var10);
                    }
                }
                if (this.scanner.field_1227 && this.field_1592 < this.scanner.field_1231) {
                    var10 = this.identifierPositionStack[this.field_1584];
                    if (!this.field_1622) {
                        this.problemReporter().method_1818((int)(var10 >>> 32), (int)var10);
                    }
                }
                break;
            case 27:
            case 31:
                this.field_1567 = this.scanner.field_1231 - 1;
                this.field_1566 = this.scanner.field_1230 - 1;
                break;
            case 28:
                this.field_1597 = this.scanner.field_1230;
                break;
            case 29:
                this.field_1598 = this.scanner.field_1231 - 1;
                break;
            case 32:
                this.method_2864(-5);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 33:
                this.method_2864(-3);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 34:
                this.method_2864(-2);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 35:
                this.method_2864(-8);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 36:
                this.method_2864(-9);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 37:
                this.method_2864(-10);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 38:
                this.method_2864(-7);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 39:
                this.method_2864(-4);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 40:
                this.method_2864(-6);
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 41:
            case 42:
                this.field_1566 = this.scanner.field_1231 - 1;
                this.method_2872(this.scanner.field_1230);
                break;
            case 43:
                this.method_2879();
                this.method_2872(this.scanner.field_1230);
                break;
            case 44:
                FalseLiteral var5 = new FalseLiteral(this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var5);
                break;
            case 45:
                NullLiteral var4 = new NullLiteral(this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var4);
                break;
            case 46:
                TrueLiteral var7 = new TrueLiteral(this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var7);
                break;
            case 47:
                IntLiteral var6 = new IntLiteral(this.scanner.method_2409(), this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var6);
                break;
            case 48:
                LongLiteral var9 = new LongLiteral(this.scanner.method_2409(), this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var9);
                break;
            case 49:
                FloatLiteral var8 = new FloatLiteral(this.scanner.method_2409(), this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var8);
                break;
            case 50:
                DoubleLiteral var11 = new DoubleLiteral(this.scanner.method_2409(), this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var11);
                break;
            case 51:
                CharLiteral var10001 = new CharLiteral(this.scanner.method_2409(), this.scanner.field_1230, this.scanner.field_1231 - 1);
                this.method_2867(var10001);
                break;
            case 52:
                StringLiteral var2;
                if (this.field_1634 && this.field_1633 && this.field_1620 < this.scanner.field_1231 && !this.field_1622) {
                    var2 = this.createStringLiteral(this.scanner.method_2410(), this.scanner.field_1230, this.scanner.field_1231 - 1, Util.getLineNumber(this.scanner.field_1230, this.scanner.field_1256, 0, this.scanner.field_1257));
                    this.compilationUnit.recordStringLiteral(var2, this.currentElement != null);
                } else {
                    var2 = this.createStringLiteral(this.scanner.method_2410(), this.scanner.field_1230, this.scanner.field_1231 - 1, 0);
                }
                this.method_2867(var2);
                break;
            case 53:
                this.method_2872(this.scanner.field_1230);
                break;
            case 54:
                this.method_2523(8);
                this.method_2868(0);
                break;
            case 55:
                this.field_1631 = this.scanner.field_1230;
                this.method_2523(32);
                this.method_2868(0);
                break;
            case 56:
                this.method_2523(1024);
                this.method_2868(0);
                break;
            case 57:
                this.method_2523(16);
                this.method_2868(0);
                break;
            case 58:
                this.method_2523(256);
                this.method_2868(0);
                break;
            case 59:
                this.method_2523(2);
                this.method_2868(0);
                break;
            case 60:
                this.method_2523(4);
                this.method_2868(0);
                break;
            case 61:
                this.method_2523(1);
                this.method_2868(0);
                break;
            case 62:
                this.method_2523(2048);
                this.method_2868(0);
                break;
            case 63:
                this.method_2523(128);
                this.method_2868(0);
                break;
            case 64:
                this.method_2523(64);
                this.method_2868(0);
                break;
            case 69:
                this.field_1567 = this.scanner.field_1231 - 1;
            case 1:
            case 2:
            case 66:
            case 67:
                this.field_1566 = this.scanner.field_1230;
                break;
            case 70:
                this.field_1566 = this.scanner.field_1230;
                this.field_1567 = this.scanner.field_1231 - 1;
                break;
            case 71:
                if (this.currentElement != null && this.currentElement instanceof RecoveredAnnotation) {
                    RecoveredAnnotation var3 = (RecoveredAnnotation)this.currentElement;
                    if (var3.memberValuPairEqualEnd == -1) {
                        var3.memberValuPairEqualEnd = this.scanner.field_1231 - 1;
                    }
                }
                break;
            case 72:
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 96:
            case 100:
            case 101:
                this.method_2872(this.scanner.field_1230);
                break;
            case 95:
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 97:
                this.method_2872(this.scanner.field_1230);
                this.method_2872(this.scanner.field_1231 - 1);
                break;
            case 98:
                this.method_2872(this.scanner.field_1231 - 1);
                this.method_2872(this.scanner.field_1230);
                break;
            case 107:
                this.method_2872(this.scanner.field_1231 - 1);
        }
    }

    protected void method_2781() {
        this.method_2869(this.getTypeReference(this.field_1588[this.field_1587--]));
    }

    protected void method_2782() {
        this.method_2528();
    }

    protected void method_2783() {
        this.method_2528();
    }

    protected void method_2784() {
        this.method_2528();
    }

    protected void method_2785() {
        this.method_2528();
    }

    protected void method_2786() {
        this.method_2528();
        this.method_2869(this.getTypeReference(0));
        --this.field_1587;
    }

    protected void method_2787() {
        this.method_2528();
        this.method_2869(this.getTypeReference(0));
        --this.field_1587;
    }

    protected void method_2788() {
        this.method_2528();
        --this.field_1587;
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            int var1 = this.field_1576[this.field_1575];
            this.problemReporter().invalidUsageOfTypeArguments((TypeReference)this.field_1578[this.field_1577 - var1 + 1], (TypeReference)this.field_1578[this.field_1577]);
        }
    }

    protected void method_2789() {
        this.method_2529();
    }

    protected void method_2790() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.identifierStack, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var4, 0, var2);
        ImportReference var10001 = new ImportReference(var3, var4, true, 0);
        ImportReference var1 = var10001;
        this.method_2866(var10001);
        if (this.field_1563 == 27) {
            var1.field_471 = this.scanner.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (this.currentElement != null) {
            this.field_1590 = var1.field_471 + 1;
            this.currentElement = this.currentElement.add(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2791() {
        TypeParameter var10000 = new TypeParameter();
        TypeParameter var1 = var10000;
        long var2 = this.identifierPositionStack[this.field_1584];
        int var4 = (int)var2;
        var1.field_652 = var4;
        var1.field_445 = var4;
        int var5 = (int)(var2 >>> 32);
        var1.field_653 = var5;
        var1.field_444 = var5;
        var1.name = this.identifierStack[this.field_1584--];
        --this.field_1581;
        this.method_2869(var1);
        ++this.field_1596;
    }

    protected void method_2792() {}

    protected void method_2793() {
        TypeReference var1 = (TypeReference)this.field_1578[this.field_1577--];
        --this.field_1575;
        TypeParameter var2 = (TypeParameter)this.field_1578[this.field_1577];
        var2.field_652 = var1.field_445;
        var2.type = var1;
        var1.field_446 |= 16;
        this.field_1578[this.field_1577] = var2;
    }

    protected void method_2794() {
        int var1 = this.field_1576[this.field_1575--];
        TypeReference[] var2 = new TypeReference[var1];
        this.field_1577 -= var1;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var2, 0, var1);
        TypeReference var3 = this.getTypeReference(this.field_1588[this.field_1587--]);
        TypeParameter var4 = (TypeParameter)this.field_1578[this.field_1577];
        var4.field_652 = var2[var1 - 1].field_445;
        var4.type = var3;
        var3.field_446 |= 16;
        var4.bounds = var2;
        int var5 = 0;
        for (int var6 = var2.length; var5 < var6; ++var5) {
            var2[var5].field_446 |= 16;
        }
    }

    protected void method_2795() {
        this.method_2528();
    }

    protected void method_2796() {
        this.method_2528();
    }

    protected void method_2797() {
        int var1 = this.field_1588[this.field_1587--];
        if (this.currentElement != null && this.currentElement instanceof RecoveredType) {
            RecoveredType var2 = (RecoveredType)this.currentElement;
            int var3 = this.field_1576[this.field_1575];
            TypeParameter[] var4 = new TypeParameter[var3];
            System.arraycopy(this.field_1578, this.field_1577 - var3 + 1, var4, 0, var3);
            var2.add(var4, var1);
        }
        if (!this.field_1622 && this.options.field_1928 < 3211264L && this.field_1592 < this.scanner.field_1231) {
            int var5 = this.field_1576[this.field_1575];
            this.problemReporter().invalidUsageOfTypeParameters((TypeParameter)this.field_1578[this.field_1577 - var5 + 1], (TypeParameter)this.field_1578[this.field_1577]);
        }
    }

    protected void method_2798() {
        TypeReference var1 = this.getTypeReference(this.field_1588[this.field_1587--]);
        TypeParameter var2 = (TypeParameter)this.field_1578[this.field_1577];
        var2.field_652 = var1.field_445;
        var2.type = var1;
        var1.field_446 |= 16;
    }

    protected void method_2799() {
        int var1 = this.field_1576[this.field_1575--];
        TypeReference[] var2 = new TypeReference[var1];
        this.field_1577 -= var1;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var2, 0, var1);
        TypeReference var3 = this.getTypeReference(this.field_1588[this.field_1587--]);
        TypeParameter var4 = (TypeParameter)this.field_1578[this.field_1577];
        var4.type = var3;
        var3.field_446 |= 16;
        var4.bounds = var2;
        var4.field_652 = var2[var1 - 1].field_445;
        int var5 = 0;
        for (int var6 = var2.length; var5 < var6; ++var5) {
            var2[var5].field_446 |= 16;
        }
    }

    protected void method_2800(int var1) {
        Expression var3 = this.expressionStack[this.field_1570];
        Object var2;
        int var10001;
        Expression[] var10000;
        UnaryExpression var10002;
        if (var1 == 13) {
            if (var3 instanceof IntLiteral && ((IntLiteral)var3).mayRepresentMIN_VALUE()) {
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                IntLiteralMinValue var5 = new IntLiteralMinValue();
                var2 = var10000[var10001] = var5;
            } else if (var3 instanceof LongLiteral && ((LongLiteral)var3).mayRepresentMIN_VALUE()) {
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                LongLiteralMinValue var4 = new LongLiteralMinValue();
                var2 = var10000[var10001] = var4;
            } else {
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                var10002 = new UnaryExpression(var3, var1);
                var2 = var10000[var10001] = var10002;
            }
        } else {
            var10000 = this.expressionStack;
            var10001 = this.field_1570;
            var10002 = new UnaryExpression(var3, var1);
            var2 = var10000[var10001] = var10002;
        }
        ((Expression)var2).field_444 = this.field_1588[this.field_1587--];
        ((Expression)var2).field_445 = var3.field_445;
    }

    protected void consumeUnaryExpression(int var1, boolean var2) {
        Expression var3 = this.expressionStack[this.field_1570];
        if (var3 instanceof Reference) {
            int var10001;
            Expression[] var10000;
            if (var2) {
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                PostfixExpression var10002 = new PostfixExpression(var3, IntLiteral.One, var1, this.field_1567);
                var10000[var10001] = var10002;
            } else {
                var10000 = this.expressionStack;
                var10001 = this.field_1570;
                PrefixExpression var4 = new PrefixExpression(var3, IntLiteral.One, var1, this.field_1588[this.field_1587--]);
                var10000[var10001] = var4;
            }
        } else {
            if (!var2) {
                --this.field_1587;
            }
            if (!this.field_1622) {
                this.problemReporter().method_1644(var3);
            }
        }
    }

    protected void method_2802() {
        this.method_2853();
    }

    protected void method_2803() {
        this.method_2527();
    }

    protected void method_2804() {
        Wildcard var10000 = new Wildcard(0);
        Wildcard var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2805() {
        Wildcard var10000 = new Wildcard(0);
        Wildcard var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2806() {}

    protected void method_2807() {
        Wildcard var10000 = new Wildcard(0);
        Wildcard var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2808() {}

    protected void method_2809() {
        Wildcard var10000 = new Wildcard(0);
        Wildcard var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2810() {}

    protected void method_2811() {
        Wildcard var10000 = new Wildcard(1);
        Wildcard var1 = var10000;
        var1.bound = (TypeReference)this.field_1578[this.field_1577];
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2812() {
        Wildcard var10000 = new Wildcard(2);
        Wildcard var1 = var10000;
        var1.bound = (TypeReference)this.field_1578[this.field_1577];
        --this.field_1587;
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2813() {
        Wildcard var10000 = new Wildcard(1);
        Wildcard var1 = var10000;
        var1.bound = (TypeReference)this.field_1578[this.field_1577];
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2814() {
        Wildcard var10000 = new Wildcard(2);
        Wildcard var1 = var10000;
        var1.bound = (TypeReference)this.field_1578[this.field_1577];
        --this.field_1587;
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2815() {
        Wildcard var10000 = new Wildcard(1);
        Wildcard var1 = var10000;
        var1.bound = (TypeReference)this.field_1578[this.field_1577];
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2816() {
        Wildcard var10000 = new Wildcard(2);
        Wildcard var1 = var10000;
        var1.bound = (TypeReference)this.field_1578[this.field_1577];
        --this.field_1587;
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2817() {
        Wildcard var10000 = new Wildcard(1);
        Wildcard var1 = var10000;
        var1.bound = this.getTypeReference(this.field_1588[this.field_1587--]);
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2818() {
        Wildcard var10000 = new Wildcard(2);
        Wildcard var1 = var10000;
        var1.bound = this.getTypeReference(this.field_1588[this.field_1587--]);
        --this.field_1587;
        var1.field_445 = var1.bound.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2819() {}

    public boolean containsComment(int var1, int var2) {
        for (int var3 = this.scanner.field_1245; var3 >= 0; --var3) {
            int var4 = this.scanner.field_1243[var3];
            if (var4 >= var1 && var4 <= var2) {
                return true;
            }
        }
        return false;
    }

    public MethodDeclaration convertToMethodDeclaration(ConstructorDeclaration var1, CompilationResult var2) {
        MethodDeclaration var10000 = new MethodDeclaration(var2);
        MethodDeclaration var3 = var10000;
        var3.typeParameters = var1.typeParameters;
        var3.field_444 = var1.field_444;
        var3.field_445 = var1.field_445;
        var3.field_490 = var1.field_490;
        var3.field_491 = var1.field_491;
        var3.field_481 = var1.field_481;
        var3.field_480 = var1.field_480;
        var3.selector = var1.selector;
        var3.statements = var1.statements;
        var3.field_482 = var1.field_482;
        var3.annotations = var1.annotations;
        var3.arguments = var1.arguments;
        var3.thrownExceptions = var1.thrownExceptions;
        var3.field_487 = var1.field_487;
        var3.returnType = null;
        return var3;
    }

    protected TypeReference copyDims(TypeReference var1, int var2) {
        return var1.copyDims(var2);
    }

    protected FieldDeclaration createFieldDeclaration(char[] var1, int var2, int var3) {
        FieldDeclaration var10000 = new FieldDeclaration(var1, var2, var3);
        return var10000;
    }

    protected LocalDeclaration createLocalDeclaration(char[] var1, int var2, int var3) {
        LocalDeclaration var10000 = new LocalDeclaration(var1, var2, var3);
        return var10000;
    }

    protected StringLiteral createStringLiteral(char[] var1, int var2, int var3, int var4) {
        StringLiteral var10000 = new StringLiteral(var1, var2, var3, var4);
        return var10000;
    }

    protected RecoveredType currentRecoveryType() {
        return this.currentElement != null ? (this.currentElement instanceof RecoveredType ? (RecoveredType)this.currentElement : this.currentElement.enclosingType()) : null;
    }

    public CompilationUnitDeclaration dietParse(ICompilationUnit var1, CompilationResult var2) {
        boolean var4 = this.field_1564;
        CompilationUnitDeclaration var3;
        try {
            this.field_1564 = true;
            var3 = this.parse(var1, var2);
        } finally {
            this.field_1564 = var4;
        }
        return var3;
    }

    protected void method_2828(int var1) {
        if (var1 != 0) {
            int[] var2 = new int[var1 + 1];
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            boolean var6 = false;
            for (int var7 = var1 - 1; var7 >= 0; --var7) {
                ASTNode var8 = this.field_1560[this.field_1559--];
                if (var8 instanceof AbstractMethodDeclaration) {
                    var2[var7] = 2;
                    ++var4;
                    if (((AbstractMethodDeclaration)var8).method_792()) {
                        var6 = true;
                    }
                } else if (var8 instanceof TypeDeclaration) {
                    var2[var7] = 3;
                    ++var5;
                } else {
                    var2[var7] = 1;
                    ++var3;
                }
            }
            TypeDeclaration var12 = (TypeDeclaration)this.field_1560[this.field_1559];
            if (var3 != 0) {
                var12.fields = new FieldDeclaration[var3];
            }
            if (var4 != 0) {
                var12.methods = new AbstractMethodDeclaration[var4];
                if (var6) {
                    var12.field_446 |= 2048;
                }
            }
            if (var5 != 0) {
                var12.memberTypes = new TypeDeclaration[var5];
            }
            var5 = 0;
            var4 = 0;
            var3 = 0;
            int var13 = var2[0];
            int var9 = 0;
            int var11;
            for (var11 = 0; var11 <= var1; ++var11) {
                if (var13 != var2[var11]) {
                    int var10;
                    switch (var13) {
                        case 1:
                            var3 += var10 = var11 - var9;
                            System.arraycopy(this.field_1560, this.field_1559 + var9 + 1, var12.fields, var3 - var10, var10);
                            break;
                        case 2:
                            var4 += var10 = var11 - var9;
                            System.arraycopy(this.field_1560, this.field_1559 + var9 + 1, var12.methods, var4 - var10, var10);
                            break;
                        case 3:
                            var5 += var10 = var11 - var9;
                            System.arraycopy(this.field_1560, this.field_1559 + var9 + 1, var12.memberTypes, var5 - var10, var10);
                    }
                    var9 = var11;
                    var13 = var2[var11];
                }
            }
            if (var12.memberTypes != null) {
                for (var11 = var12.memberTypes.length - 1; var11 >= 0; --var11) {
                    var12.memberTypes[var11].enclosingType = var12;
                }
            }
        }
    }

    protected void method_2829(int var1) {
        if (var1 != 0) {
            int[] var2 = new int[var1 + 1];
            int var3 = 0;
            int var4 = 0;
            int var5 = 0;
            TypeDeclaration var6 = (TypeDeclaration)this.field_1560[this.field_1559 - var1];
            boolean var7 = false;
            int var8;
            for (var8 = var1 - 1; var8 >= 0; --var8) {
                ASTNode var9 = this.field_1560[this.field_1559--];
                if (var9 instanceof AbstractMethodDeclaration) {
                    var2[var8] = 2;
                    ++var4;
                    if (((AbstractMethodDeclaration)var9).method_792()) {
                        var7 = true;
                    }
                } else if (var9 instanceof TypeDeclaration) {
                    var2[var8] = 3;
                    ++var5;
                } else if (var9 instanceof FieldDeclaration) {
                    var2[var8] = 1;
                    ++var3;
                }
            }
            if (var3 != 0) {
                var6.fields = new FieldDeclaration[var3];
            }
            if (var4 != 0) {
                var6.methods = new AbstractMethodDeclaration[var4];
                if (var7) {
                    var6.field_446 |= 2048;
                }
            }
            if (var5 != 0) {
                var6.memberTypes = new TypeDeclaration[var5];
            }
            var5 = 0;
            var4 = 0;
            var3 = 0;
            var8 = var2[0];
            int var12 = 0;
            int var11;
            for (var11 = 0; var11 <= var1; ++var11) {
                if (var8 != var2[var11]) {
                    int var10;
                    switch (var8) {
                        case 1:
                            var3 += var10 = var11 - var12;
                            System.arraycopy(this.field_1560, this.field_1559 + var12 + 1, var6.fields, var3 - var10, var10);
                            break;
                        case 2:
                            var4 += var10 = var11 - var12;
                            System.arraycopy(this.field_1560, this.field_1559 + var12 + 1, var6.methods, var4 - var10, var10);
                            break;
                        case 3:
                            var5 += var10 = var11 - var12;
                            System.arraycopy(this.field_1560, this.field_1559 + var12 + 1, var6.memberTypes, var5 - var10, var10);
                    }
                    var12 = var11;
                    var8 = var2[var11];
                }
            }
            if (var6.memberTypes != null) {
                for (var11 = var6.memberTypes.length - 1; var11 >= 0; --var11) {
                    var6.memberTypes[var11].enclosingType = var6;
                }
            }
        }
    }

    protected CompilationUnitDeclaration endParse(int var1) {
        this.field_1589 = var1;
        if (this.field_1622) {
            RecoveredElement var2 = this.buildInitialRecoveryState();
            if (var2 != null) {
                var2.topElement().updateParseTree();
            }
            if (this.field_1579) {
                this.method_2880();
            }
        } else if (this.currentElement != null) {
            if (VERBOSE_RECOVERY) {
                eclipse.instance.print(Messages.field_1885);
                eclipse.instance.println("--------------------------");
                eclipse.instance.println(this.compilationUnit);
                eclipse.instance.println("----------------------------------");
            }
            this.currentElement.topElement().updateParseTree();
        } else if (this.field_1564 & VERBOSE_RECOVERY) {
            eclipse.instance.print(Messages.field_1886);
            eclipse.instance.println("--------------------------");
            eclipse.instance.println(this.compilationUnit);
            eclipse.instance.println("----------------------------------");
        }
        this.method_2861();
        for (int var3 = 0; var3 < this.scanner.field_1251; ++var3) {
            if (!this.field_1622) {
                this.problemReporter().method_1767(new String(this.scanner.field_1247[var3]), new String(this.scanner.field_1248[var3]), this.scanner.field_1249[var3] == null ? null : new String(this.scanner.field_1249[var3]), this.scanner.foundTaskPositions[var3][0], this.scanner.foundTaskPositions[var3][1]);
            }
        }
        return this.compilationUnit;
    }

    public int flushCommentsDefinedPriorTo(int var1) {
        int var2 = this.scanner.field_1245;
        if (var2 < 0) {
            return var1;
        } else {
            int var3 = var2;
            int var4;
            int var5;
            for (var4 = 0; var3 >= 0; ++var4) {
                var5 = this.scanner.field_1242[var3];
                if (var5 < 0) {
                    var5 = -var5;
                }
                if (var5 <= var1) {
                    break;
                }
                --var3;
            }
            if (var4 > 0) {
                var5 = -this.scanner.field_1242[var3 + 1];
                if (var5 > 0) {
                    --var5;
                    if (Util.getLineNumber(var1, this.scanner.field_1256, 0, this.scanner.field_1257) == Util.getLineNumber(var5, this.scanner.field_1256, 0, this.scanner.field_1257)) {
                        var1 = var5;
                        --var4;
                        ++var3;
                    }
                }
            }
            if (var3 < 0) {
                return var1;
            } else {
                switch (var4) {
                    case 0:
                        break;
                    case 1:
                        this.scanner.field_1243[0] = this.scanner.field_1243[var3 + 1];
                        this.scanner.field_1242[0] = this.scanner.field_1242[var3 + 1];
                        this.scanner.field_1244[0] = this.scanner.field_1244[var3 + 1];
                        break;
                    case 2:
                        this.scanner.field_1243[0] = this.scanner.field_1243[var3 + 1];
                        this.scanner.field_1242[0] = this.scanner.field_1242[var3 + 1];
                        this.scanner.field_1244[0] = this.scanner.field_1244[var3 + 1];
                        this.scanner.field_1243[1] = this.scanner.field_1243[var3 + 2];
                        this.scanner.field_1242[1] = this.scanner.field_1242[var3 + 2];
                        this.scanner.field_1244[1] = this.scanner.field_1244[var3 + 2];
                        break;
                    default:
                        System.arraycopy(this.scanner.field_1243, var3 + 1, this.scanner.field_1243, 0, var4);
                        System.arraycopy(this.scanner.field_1242, var3 + 1, this.scanner.field_1242, 0, var4);
                        System.arraycopy(this.scanner.field_1244, var3 + 1, this.scanner.field_1244, 0, var4);
                }
                this.scanner.field_1245 = var4 - 1;
                return var1;
            }
        }
    }

    protected TypeReference getAnnotationType() {
        int var1 = this.field_1582[this.field_1581--];
        if (var1 == 1) {
            SingleTypeReference var4 = new SingleTypeReference(this.identifierStack[this.field_1584], this.identifierPositionStack[this.field_1584--]);
            return var4;
        } else {
            char[][] var2 = new char[var1][];
            this.field_1584 -= var1;
            long[] var3 = new long[var1];
            System.arraycopy(this.identifierStack, this.field_1584 + 1, var2, 0, var1);
            System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var3, 0, var1);
            QualifiedTypeReference var10000 = new QualifiedTypeReference(var2, var3);
            return var10000;
        }
    }

    public int getFirstToken() {
        return this.field_1572;
    }

    public void getMethodBodies(CompilationUnitDeclaration var1) {
        if (var1 != null) {
            if (var1.field_452) {
                var1.field_451 = true;
            } else if ((var1.field_446 & 16) == 0) {
                int[] var2 = this.scanner.field_1256;
                int var3 = this.scanner.field_1257;
                CompilationResult var4 = var1.compilationResult;
                char[] var5 = this.readManager != null ? this.readManager.getContents(var4.compilationUnit) : var4.compilationUnit.getContents();
                this.scanner.setSource(var5, var4);
                if (var1.types != null) {
                    int var6 = 0;
                    for (int var7 = var1.types.length; var6 < var7; ++var6) {
                        var1.types[var6].parseMethods(this, var1);
                    }
                }
                var1.field_446 |= 16;
                this.scanner.field_1256 = var2;
                this.scanner.field_1257 = var3;
            }
        }
    }

    protected Expression getTypeReference(Expression var1) {
        var1.field_446 &= -8;
        var1.field_446 |= 4;
        return var1;
    }

    protected TypeReference getTypeReference(int var1) {
        int var3 = this.field_1582[this.field_1581--];
        Object var2;
        if (var3 < 0) {
            var2 = TypeReference.baseTypeReference(-var3, var1);
            ((TypeReference)var2).field_444 = this.field_1588[this.field_1587--];
            if (var1 == 0) {
                ((TypeReference)var2).field_445 = this.field_1588[this.field_1587--];
            } else {
                --this.field_1587;
                ((TypeReference)var2).field_445 = this.field_1566;
            }
        } else {
            int var4 = this.field_1574[this.field_1573--];
            if (var3 == var4 && this.field_1576[this.field_1575] == 0) {
                if (var3 == 1) {
                    --this.field_1575;
                    if (var1 == 0) {
                        SingleTypeReference var10000 = new SingleTypeReference(this.identifierStack[this.field_1584], this.identifierPositionStack[this.field_1584--]);
                        var2 = var10000;
                    } else {
                        ArrayTypeReference var8 = new ArrayTypeReference(this.identifierStack[this.field_1584], var1, this.identifierPositionStack[this.field_1584--]);
                        var2 = var8;
                        ((TypeReference)var2).field_445 = this.field_1566;
                    }
                } else {
                    --this.field_1575;
                    char[][] var5 = new char[var3][];
                    this.field_1584 -= var3;
                    long[] var6 = new long[var3];
                    System.arraycopy(this.identifierStack, this.field_1584 + 1, var5, 0, var3);
                    System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var6, 0, var3);
                    if (var1 == 0) {
                        QualifiedTypeReference var9 = new QualifiedTypeReference(var5, var6);
                        var2 = var9;
                    } else {
                        ArrayQualifiedTypeReference var7 = new ArrayQualifiedTypeReference(var5, var1, var6);
                        var2 = var7;
                        ((TypeReference)var2).field_445 = this.field_1566;
                    }
                }
            } else {
                var2 = this.getTypeReferenceForGenericType(var1, var3, var4);
            }
        }
        return (TypeReference)var2;
    }

    protected TypeReference getTypeReferenceForGenericType(int var1, int var2, int var3) {
        if (var2 == 1 && var3 == 1) {
            int var11 = this.field_1576[this.field_1575--];
            TypeReference[] var12 = new TypeReference[var11];
            this.field_1577 -= var11;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var12, 0, var11);
            ParameterizedSingleTypeReference var10 = new ParameterizedSingleTypeReference(this.identifierStack[this.field_1584], var12, var1, this.identifierPositionStack[this.field_1584--]);
            ParameterizedSingleTypeReference var13 = var10;
            if (var1 != 0) {
                var13.field_445 = this.field_1567;
            }
            return var13;
        } else {
            TypeReference[][] var4 = new TypeReference[var3][];
            char[][] var5 = new char[var3][];
            long[] var6 = new long[var3];
            int var7 = var3;
            int var8 = var2;
            while (var7 > 0) {
                int var9 = this.field_1576[this.field_1575--];
                if (var9 != 0) {
                    this.field_1577 -= var9;
                    System.arraycopy(this.field_1578, this.field_1577 + 1, var4[var7 - 1] = new TypeReference[var9], 0, var9);
                }
                switch (var8) {
                    case 1:
                        var5[var7 - 1] = this.identifierStack[this.field_1584];
                        var6[var7 - 1] = this.identifierPositionStack[this.field_1584--];
                        break;
                    default:
                        this.field_1584 -= var8;
                        System.arraycopy(this.identifierStack, this.field_1584 + 1, var5, var7 - var8, var8);
                        System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var6, var7 - var8, var8);
                }
                var7 -= var8;
                if (var7 > 0) {
                    var8 = this.field_1582[this.field_1581--];
                }
            }
            ParameterizedQualifiedTypeReference var10000 = new ParameterizedQualifiedTypeReference(var5, var4, var1, var6);
            ParameterizedQualifiedTypeReference var14 = var10000;
            if (var1 != 0) {
                var14.field_445 = this.field_1567;
            }
            return var14;
        }
    }

    protected NameReference method_2838() {
        int var1;
        Object var2;
        if ((var1 = this.field_1582[this.field_1581--]) == 1) {
            SingleNameReference var10000 = new SingleNameReference(this.identifierStack[this.field_1584], this.identifierPositionStack[this.field_1584--]);
            var2 = var10000;
        } else {
            char[][] var3 = new char[var1][];
            this.field_1584 -= var1;
            System.arraycopy(this.identifierStack, this.field_1584 + 1, var3, 0, var1);
            long[] var4 = new long[var1];
            System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var4, 0, var1);
            QualifiedNameReference var5 = new QualifiedNameReference(var3, var4, (int)(this.identifierPositionStack[this.field_1584 + 1] >> 32), (int)this.identifierPositionStack[this.field_1584 + var1]);
            var2 = var5;
        }
        return (NameReference)var2;
    }

    protected NameReference method_2839() {
        int var1;
        if ((var1 = this.field_1582[this.field_1581--]) == 1) {
            SingleNameReference var6 = new SingleNameReference(this.identifierStack[this.field_1584], this.identifierPositionStack[this.field_1584--]);
            SingleNameReference var5 = var6;
            var5.field_446 &= -8;
            var5.field_446 |= 3;
            return var5;
        } else {
            char[][] var3 = new char[var1][];
            this.field_1584 -= var1;
            System.arraycopy(this.identifierStack, this.field_1584 + 1, var3, 0, var1);
            long[] var4 = new long[var1];
            System.arraycopy(this.identifierPositionStack, this.field_1584 + 1, var4, 0, var1);
            QualifiedNameReference var10000 = new QualifiedNameReference(var3, var4, (int)(this.identifierPositionStack[this.field_1584 + 1] >> 32), (int)this.identifierPositionStack[this.field_1584 + var1]);
            QualifiedNameReference var2 = var10000;
            var2.field_446 &= -8;
            var2.field_446 |= 3;
            return var2;
        }
    }

    public void method_2840() {
        this.field_1572 = 67;
        this.scanner.field_1228 = false;
    }

    public void method_2841() {
        this.field_1572 = 8;
        this.scanner.field_1251 = 0;
        this.scanner.field_1228 = true;
    }

    public void method_2842() {
        RecoveredType var1 = this.currentRecoveryType();
        if (var1 != null && var1.field_1137) {
            this.field_1572 = 66;
        } else {
            this.field_1572 = 11;
        }
        this.scanner.field_1228 = true;
    }

    protected void method_2843() {
        --this.field_1587;
        ArrayInitializer var1 = (ArrayInitializer)this.expressionStack[this.field_1570--];
        --this.field_1568;
        if (!this.field_1622) {
            this.problemReporter().method_1480(var1.field_444, var1.field_445);
        }
    }

    public void method_2844() {
        this.method_2845(false);
    }

    public void method_2845(boolean var1) {
        this.field_1559 = -1;
        this.field_1557 = -1;
        this.field_1570 = -1;
        this.field_1568 = -1;
        this.field_1584 = -1;
        this.field_1581 = -1;
        this.field_1587 = -1;
        this.field_1601[this.field_1602 = 0] = 0;
        this.field_1632[this.field_1602] = 0;
        this.field_1603 = 0;
        this.field_1612 = -1;
        this.compilationUnit = null;
        this.referenceContext = null;
        this.field_1567 = 0;
        int var2 = this.field_1560.length;
        if (this.noAstNodes.length < var2) {
            this.noAstNodes = new ASTNode[var2];
        }
        System.arraycopy(this.noAstNodes, 0, this.field_1560, 0, var2);
        int var3 = this.expressionStack.length;
        if (this.noExpressions.length < var3) {
            this.noExpressions = new Expression[var3];
        }
        System.arraycopy(this.noExpressions, 0, this.expressionStack, 0, var3);
        this.scanner.field_1245 = -1;
        this.scanner.field_1251 = 0;
        this.scanner.field_1233 = Integer.MAX_VALUE;
        this.field_1634 = true;
        boolean var4 = this.options.method_3313(256L) != -1;
        this.field_1633 = var4;
        this.scanner.field_1292 = var1 && var4;
        this.scanner.field_1293 = -1;
        this.method_2879();
        this.field_1590 = -1;
        this.currentElement = null;
        this.field_1618 = false;
        this.field_1580 = false;
        this.field_1614 = 0;
        this.field_1593 = -1;
        this.field_1591 = -1;
        this.field_1592 = -1;
        this.field_1635 = -1;
        this.field_1595 = 0;
        this.field_1596 = 0;
        this.field_1620 = -1;
        this.field_1609 = 0;
        this.field_1610 = 0;
        this.field_1611 = 0;
        this.field_1573 = -1;
        this.field_1575 = -1;
        this.field_1577 = -1;
    }

    public void method_2846() {
        Scanner var10001 = new Scanner(false, false, false, this.options.field_1928, this.options.field_1927, this.options.field_1936, this.options.field_1937, this.options.field_1938);
        this.scanner = var10001;
    }

    public void method_2847() {
        if (this.field_1564 && this.field_1565 == 0) {
            this.scanner.field_1255 = true;
        }
    }

    private void jumpOverType() {
        if (this.recoveredTypes != null && this.field_1625 > -1 && this.field_1625 < this.scanner.field_1231) {
            TypeDeclaration var1 = this.recoveredTypes[this.field_1624];
            boolean var2 = var1.allocation != null;
            this.scanner.field_1230 = var1.field_593 + 1;
            this.scanner.field_1231 = var1.field_593 + 1;
            this.scanner.field_1255 = false;
            if (!var2) {
                ((RecoveryScanner)this.scanner).setPendingTokens(new int[] {27, 75});
            } else {
                ((RecoveryScanner)this.scanner).setPendingTokens(new int[] {26, 71, 26});
            }
            this.pendingRecoveredType = var1;
            try {
                this.field_1563 = this.scanner.getNextToken();
            } catch (InvalidInputException var4) {
                ;
            }
            if (++this.field_1624 < this.recoveredTypes.length) {
                TypeDeclaration var3 = this.recoveredTypes[this.field_1624];
                this.field_1625 = var3.allocation == null ? var3.field_592 : var3.allocation.field_444;
            } else {
                this.field_1625 = Integer.MAX_VALUE;
            }
        }
    }

    protected void method_2849() {
        if (this.currentElement == null) {
            for (int var1 = this.field_1559; var1 >= 0; --var1) {
                ASTNode var2 = this.field_1560[var1];
                if (var2 instanceof AbstractMethodDeclaration || var2 instanceof FieldDeclaration || var2 instanceof TypeDeclaration && ((TypeDeclaration)var2).field_593 == 0) {
                    var2.field_446 |= 2;
                    return;
                }
            }
            if (this.referenceContext instanceof AbstractMethodDeclaration || this.referenceContext instanceof TypeDeclaration) {
                ((ASTNode)this.referenceContext).field_446 |= 2;
            }
        }
    }

    protected boolean moveRecoveryCheckpoint() {
        int var1 = this.field_1590;
        this.scanner.field_1230 = var1;
        this.scanner.field_1231 = var1;
        this.scanner.field_1255 = false;
        if (this.field_1618) {
            this.field_1593 = -1;
            this.scanner.field_1300 = true;
            return true;
        } else {
            this.field_1593 = this.field_1594;
            this.field_1594 = -1;
            do {
                try {
                    this.field_1594 = this.scanner.getNextToken();
                    if (this.scanner.field_1231 == this.scanner.field_1230) {
                        ++this.scanner.field_1231;
                        this.field_1594 = -1;
                    }
                } catch (InvalidInputException var3) {
                    var1 = this.scanner.field_1231;
                }
            } while (this.field_1594 < 0);
            if (this.field_1594 == 68 && this.field_1563 == 68) {
                return false;
            } else {
                this.field_1590 = this.scanner.field_1231;
                this.scanner.field_1230 = var1;
                this.scanner.field_1231 = var1;
                this.scanner.field_1245 = -1;
                this.scanner.field_1251 = 0;
                return true;
            }
        }
    }

    protected MessageSend method_2851() {
        MessageSend var10000 = new MessageSend();
        MessageSend var1 = var10000;
        int var2;
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var2;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var1.arguments = new Expression[var2], 0, var2);
        }
        return var1;
    }

    protected MessageSend method_2852() {
        MessageSend var10000 = new MessageSend();
        MessageSend var1 = var10000;
        int var2;
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var2;
            System.arraycopy(this.expressionStack, this.field_1570 + 1, var1.arguments = new Expression[var2], 0, var2);
        }
        return var1;
    }

    protected void method_2853() {
        ++this.field_1558[--this.field_1557];
    }

    protected void parse() {
        boolean var1 = this.field_1564;
        int var2 = this.getFirstToken();
        this.field_1579 = false;
        this.field_1580 = false;
        int var3 = 731;
        this.field_1630 = -1;
        this.field_1563 = this.getFirstToken();
        while (true) {
            int var4 = this.field_1629.length;
            if (++this.field_1630 >= var4) {
                System.arraycopy(this.field_1629, 0, this.field_1629 = new int[var4 + 255], 0, var4);
            }
            this.field_1629[this.field_1630] = var3;
            var3 = method_2517(var3, this.field_1563);
            if (var3 != 12828 && !this.field_1618) {
                if (var3 <= 700) {
                    --this.field_1630;
                } else {
                    boolean var10;
                    if (var3 <= 12828) {
                        if (var3 >= 12827) {
                            break;
                        }
                        this.method_2780(this.field_1563);
                        if (this.currentElement != null) {
                            var10 = this.field_1634;
                            this.field_1634 = false;
                            this.method_2876();
                            this.field_1634 = var10;
                        }
                        try {
                            this.field_1563 = this.scanner.getNextToken();
                        } catch (InvalidInputException var8) {
                            if (!this.field_1580) {
                                this.problemReporter().scannerError(this, var8.getMessage());
                                this.field_1580 = true;
                            }
                            this.field_1590 = this.scanner.field_1231;
                            this.field_1618 = true;
                        }
                        if (this.field_1622) {
                            this.jumpOverType();
                        }
                        continue;
                    }
                    this.method_2780(this.field_1563);
                    if (this.currentElement != null) {
                        var10 = this.field_1634;
                        this.field_1634 = false;
                        this.method_2876();
                        this.field_1634 = var10;
                    }
                    try {
                        this.field_1563 = this.scanner.getNextToken();
                    } catch (InvalidInputException var7) {
                        if (!this.field_1580) {
                            this.problemReporter().scannerError(this, var7.getMessage());
                            this.field_1580 = true;
                        }
                        this.field_1590 = this.scanner.field_1231;
                        this.field_1618 = true;
                    }
                    if (this.field_1622) {
                        this.jumpOverType();
                    }
                    var3 -= 12828;
                }
                while (true) {
                    this.method_2750(var3);
                    this.field_1630 -= field_1540[var3] - 1;
                    var3 = method_2509(this.field_1629[this.field_1630], field_1534[var3]);
                    if (var3 > 700) {
                        break;
                    }
                }
            } else {
                int var5 = this.scanner.field_1231 - 1;
                if (!this.field_1580) {
                    this.field_1579 = true;
                }
                int var6 = this.field_1563;
                if (!this.method_2882()) {
                    var3 = 12828;
                    break;
                }
                if (var3 == 12828 && var6 != 0) {
                    this.field_1591 = var5;
                }
                var3 = 731;
                this.field_1630 = -1;
                this.field_1563 = this.getFirstToken();
            }
        }
        this.endParse(var3);
        NLSTag[] var9 = this.scanner.getNLSTags();
        if (var9 != null) {
            this.compilationUnit.nlsTags = var9;
        }
        this.scanner.field_1292 = false;
        if (this.field_1617 && this.field_1579 && !this.field_1622) {
            if (!this.options.field_1962) {
                this.reportSyntaxErrors(var1, var2);
            } else {
                RecoveryScannerData var11 = this.referenceContext.compilationResult().recoveryScannerData;
                if (this.recoveryScanner == null) {
                    RecoveryScanner var10001 = new RecoveryScanner(this.scanner, var11);
                    this.recoveryScanner = var10001;
                } else {
                    this.recoveryScanner.setData(var11);
                }
                this.recoveryScanner.setSource(this.scanner.field_1237);
                this.recoveryScanner.field_1256 = this.scanner.field_1256;
                this.recoveryScanner.field_1257 = this.scanner.field_1257;
                this.reportSyntaxErrors(var1, var2);
                if (var11 == null) {
                    this.referenceContext.compilationResult().recoveryScannerData = this.recoveryScanner.getData();
                }
                if (this.field_1621 && this.options.field_1962) {
                    this.field_1621 = false;
                    this.method_2874();
                    this.field_1621 = true;
                    this.field_1589 = 12828;
                }
            }
        }
    }

    public void parse(ConstructorDeclaration var1, CompilationUnitDeclaration var2, boolean var3) {
        boolean var4 = this.field_1621;
        if (this.options.field_1961) {
            this.field_1621 = true;
        }
        this.method_2844();
        this.method_2840();
        if (var3) {
            this.scanner.field_1228 = true;
        }
        ++this.field_1601[this.field_1602];
        this.method_2873(0);
        this.referenceContext = var1;
        this.compilationUnit = var2;
        this.scanner.method_2435(var1.field_490, var1.field_491);
        try {
            this.parse();
        } catch (AbortCompilation var9) {
            this.field_1589 = 12828;
        } finally {
            --this.field_1601[this.field_1602];
            if (this.options.field_1962) {
                this.field_1621 = var4;
            }
        }
        this.checkNonNLSAfterBodyEnd(var1.field_481);
        if (this.field_1589 == 12828) {
            this.method_2844();
        } else {
            var1.field_487 = this.field_1613[this.field_1612--];
            int var5;
            if (this.field_1557 > -1 && (var5 = this.field_1558[this.field_1557--]) != 0) {
                this.field_1559 -= var5;
                if (this.field_1560[this.field_1559 + 1] instanceof ExplicitConstructorCall) {
                    System.arraycopy(this.field_1560, this.field_1559 + 2, var1.statements = new Statement[var5 - 1], 0, var5 - 1);
                    var1.constructorCall = (ExplicitConstructorCall)this.field_1560[this.field_1559 + 1];
                } else {
                    System.arraycopy(this.field_1560, this.field_1559 + 1, var1.statements = new Statement[var5], 0, var5);
                    var1.constructorCall = SuperReference.implicitSuperConstructorCall();
                }
            } else {
                var1.constructorCall = SuperReference.implicitSuperConstructorCall();
                if (!this.containsComment(var1.field_490, var1.field_491)) {
                    var1.field_446 |= 8;
                }
            }
            if (var1.constructorCall.field_445 == 0) {
                var1.constructorCall.field_445 = var1.field_445;
                var1.constructorCall.field_444 = var1.field_444;
            }
        }
    }

    public CompilationUnitDeclaration parse(ICompilationUnit var1, CompilationResult var2) {
        return this.parse(var1, var2, -1, -1);
    }

    public CompilationUnitDeclaration parse(ICompilationUnit var1, CompilationResult var2, int var3, int var4) {
        CompilationUnitDeclaration var5;
        try {
            this.method_2845(true);
            this.method_2841();
            CompilationUnitDeclaration var10002 = new CompilationUnitDeclaration(this.problemReporter, var2, 0);
            this.referenceContext = this.compilationUnit = var10002;
            char[] var6;
            try {
                var6 = this.readManager != null ? this.readManager.getContents(var1) : var1.getContents();
            } catch (AbortCompilationUnit var11) {
                this.problemReporter().cannotReadSource(this.compilationUnit, var11, this.options.field_1931);
                var6 = CharOperation.NO_CHAR;
            }
            this.scanner.setSource(var6);
            this.compilationUnit.field_445 = this.scanner.field_1237.length - 1;
            if (var4 != -1) {
                this.scanner.method_2435(var3, var4);
            }
            this.parse();
        } finally {
            var5 = this.compilationUnit;
            this.compilationUnit = null;
            if (!this.field_1564) {
                var5.field_446 |= 16;
            }
        }
        return var5;
    }

    public void parse(Initializer var1, TypeDeclaration var2, CompilationUnitDeclaration var3) {
        boolean var4 = this.field_1621;
        if (this.options.field_1961) {
            this.field_1621 = true;
        }
        this.method_2844();
        this.method_2840();
        ++this.field_1601[this.field_1602];
        this.method_2873(0);
        this.referenceContext = var2;
        this.compilationUnit = var3;
        this.scanner.method_2435(var1.field_666, var1.field_667);
        try {
            this.parse();
        } catch (AbortCompilation var9) {
            this.field_1589 = 12828;
        } finally {
            --this.field_1601[this.field_1602];
            if (this.options.field_1962) {
                this.field_1621 = var4;
            }
        }
        this.checkNonNLSAfterBodyEnd(var1.field_652);
        if (this.field_1589 != 12828) {
            var1.block.explicitDeclarations = this.field_1613[this.field_1612--];
            int var5;
            if (this.field_1557 > -1 && (var5 = this.field_1558[this.field_1557--]) > 0) {
                System.arraycopy(this.field_1560, (this.field_1559 -= var5) + 1, var1.block.statements = new Statement[var5], 0, var5);
            } else if (!this.containsComment(var1.block.field_444, var1.block.field_445)) {
                var1.block.field_446 |= 8;
            }
            if ((var2.field_446 & 2) != 0) {
                var1.field_446 |= 2;
            }
        }
    }

    public void parse(MethodDeclaration var1, CompilationUnitDeclaration var2) {
        if (!var1.method_792()) {
            if (!var1.method_798()) {
                if ((var1.field_482 & 16777216) == 0) {
                    boolean var3 = this.field_1621;
                    if (this.options.field_1961) {
                        this.field_1621 = true;
                        this.field_1598 = var1.field_445;
                    }
                    this.method_2844();
                    this.method_2840();
                    ++this.field_1601[this.field_1602];
                    this.method_2873(0);
                    this.referenceContext = var1;
                    this.compilationUnit = var2;
                    this.scanner.method_2435(var1.field_490, var1.field_491);
                    try {
                        this.parse();
                    } catch (AbortCompilation var8) {
                        this.field_1589 = 12828;
                    } finally {
                        --this.field_1601[this.field_1602];
                        if (this.options.field_1962) {
                            this.field_1621 = var3;
                        }
                    }
                    this.checkNonNLSAfterBodyEnd(var1.field_481);
                    if (this.field_1589 != 12828) {
                        var1.field_487 = this.field_1613[this.field_1612--];
                        int var4;
                        if (this.field_1557 > -1 && (var4 = this.field_1558[this.field_1557--]) != 0) {
                            System.arraycopy(this.field_1560, (this.field_1559 -= var4) + 1, var1.statements = new Statement[var4], 0, var4);
                        } else if (!this.containsComment(var1.field_490, var1.field_491)) {
                            var1.field_446 |= 8;
                        }
                    }
                }
            }
        }
    }

    public void parseStatements(ReferenceContext var1, int var2, int var3, TypeDeclaration[] var4, CompilationUnitDeclaration var5) {
        boolean var6 = this.field_1622;
        this.field_1622 = true;
        this.method_2844();
        this.method_2840();
        ++this.field_1601[this.field_1602];
        this.method_2873(0);
        this.method_2865(0);
        this.referenceContext = var1;
        this.compilationUnit = var5;
        this.pendingRecoveredType = null;
        if (var4 != null && var4.length > 0) {
            this.recoveredTypes = var4;
            this.field_1624 = 0;
            this.field_1625 = this.recoveredTypes[0].allocation == null ? this.recoveredTypes[0].field_592 : this.recoveredTypes[0].allocation.field_444;
        } else {
            this.recoveredTypes = null;
            this.field_1624 = -1;
            this.field_1625 = -1;
        }
        this.scanner.method_2435(var2, var3);
        this.field_1590 = this.scanner.field_1232;
        this.field_1630 = -1;
        try {
            this.parse();
        } catch (AbortCompilation var11) {
            this.field_1589 = 12828;
        } finally {
            --this.field_1601[this.field_1602];
            this.recoveredTypes = null;
            this.field_1622 = var6;
        }
        this.checkNonNLSAfterBodyEnd(var3);
    }

    public void method_2861() {
        if (this.scanner.field_1228) {
            this.compilationUnit.compilationResult.lineSeparatorPositions = this.scanner.getLineEnds();
        }
    }

    public ProblemReporter problemReporter() {
        if (this.scanner.field_1228) {
            this.compilationUnit.compilationResult.lineSeparatorPositions = this.scanner.getLineEnds();
        }
        this.problemReporter.referenceContext = this.referenceContext;
        return this.problemReporter;
    }

    protected void method_2863() {
        int var1 = this.identifierStack.length;
        if (++this.field_1584 >= var1) {
            System.arraycopy(this.identifierStack, 0, this.identifierStack = new char[var1 + 20][], 0, var1);
            System.arraycopy(this.identifierPositionStack, 0, this.identifierPositionStack = new long[var1 + 20], 0, var1);
        }
        this.identifierStack[this.field_1584] = this.scanner.method_2407();
        this.identifierPositionStack[this.field_1584] = ((long)this.scanner.field_1230 << 32) + (long)(this.scanner.field_1231 - 1);
        var1 = this.field_1582.length;
        if (++this.field_1581 >= var1) {
            System.arraycopy(this.field_1582, 0, this.field_1582 = new int[var1 + 10], 0, var1);
        }
        this.field_1582[this.field_1581] = 1;
    }

    protected void method_2864(int var1) {
        int var2 = this.field_1582.length;
        if (++this.field_1581 >= var2) {
            System.arraycopy(this.field_1582, 0, this.field_1582 = new int[var2 + 10], 0, var2);
        }
        this.field_1582[this.field_1581] = var1;
    }

    protected void method_2865(int var1) {
        int var2 = this.field_1558.length;
        if (++this.field_1557 >= var2) {
            System.arraycopy(this.field_1558, 0, this.field_1558 = new int[var2 + 255], 0, var2);
        }
        this.field_1558[this.field_1557] = var1;
    }

    protected void method_2866(ASTNode var1) {
        int var2 = this.field_1560.length;
        if (++this.field_1559 >= var2) {
            System.arraycopy(this.field_1560, 0, this.field_1560 = new ASTNode[var2 + 100], 0, var2);
            this.field_1559 = var2;
        }
        this.field_1560[this.field_1559] = var1;
        var2 = this.field_1558.length;
        if (++this.field_1557 >= var2) {
            System.arraycopy(this.field_1558, 0, this.field_1558 = new int[var2 + 100], 0, var2);
        }
        this.field_1558[this.field_1557] = 1;
    }

    protected void method_2867(Expression var1) {
        int var2 = this.expressionStack.length;
        if (++this.field_1570 >= var2) {
            System.arraycopy(this.expressionStack, 0, this.expressionStack = new Expression[var2 + 100], 0, var2);
        }
        this.expressionStack[this.field_1570] = var1;
        var2 = this.field_1569.length;
        if (++this.field_1568 >= var2) {
            System.arraycopy(this.field_1569, 0, this.field_1569 = new int[var2 + 100], 0, var2);
        }
        this.field_1569[this.field_1568] = 1;
    }

    protected void method_2868(int var1) {
        int var2 = this.field_1569.length;
        if (++this.field_1568 >= var2) {
            System.arraycopy(this.field_1569, 0, this.field_1569 = new int[var2 + 255], 0, var2);
        }
        this.field_1569[this.field_1568] = var1;
    }

    protected void method_2869(ASTNode var1) {
        int var2 = this.field_1578.length;
        if (++this.field_1577 >= var2) {
            System.arraycopy(this.field_1578, 0, this.field_1578 = new ASTNode[var2 + 10], 0, var2);
        }
        this.field_1578[this.field_1577] = var1;
        var2 = this.field_1576.length;
        if (++this.field_1575 >= var2) {
            System.arraycopy(this.field_1576, 0, this.field_1576 = new int[var2 + 10], 0, var2);
        }
        this.field_1576[this.field_1575] = 1;
    }

    protected void method_2870(int var1) {
        int var2 = this.field_1574.length;
        if (++this.field_1573 >= var2) {
            System.arraycopy(this.field_1574, 0, this.field_1574 = new int[var2 + 10], 0, var2);
        }
        this.field_1574[this.field_1573] = var1;
    }

    protected void method_2871(int var1) {
        int var2 = this.field_1576.length;
        if (++this.field_1575 >= var2) {
            System.arraycopy(this.field_1576, 0, this.field_1576 = new int[var2 + 10], 0, var2);
        }
        this.field_1576[this.field_1575] = var1;
    }

    protected void method_2872(int var1) {
        int var2 = this.field_1588.length;
        if (++this.field_1587 >= var2) {
            System.arraycopy(this.field_1588, 0, this.field_1588 = new int[var2 + 255], 0, var2);
        }
        this.field_1588[this.field_1587] = var1;
    }

    protected void method_2873(int var1) {
        int var2 = this.field_1613.length;
        if (++this.field_1612 >= var2) {
            System.arraycopy(this.field_1613, 0, this.field_1613 = new int[var2 + 255], 0, var2);
        }
        this.field_1613[this.field_1612] = var1;
    }

    protected void method_2874() {
        Parser$1$MethodVisitor var10000 = new Parser$1$MethodVisitor(this);
        Parser$1$MethodVisitor var1 = var10000;
        Parser$1$TypeVisitor var8 = new Parser$1$TypeVisitor(this);
        Parser$1$TypeVisitor var2 = var8;
        var1.typeVisitor = var2;
        var2.methodVisitor = var1;
        if (this.referenceContext instanceof AbstractMethodDeclaration) {
            ((AbstractMethodDeclaration)this.referenceContext).traverse(var1, (ClassScope)null);
        } else if (this.referenceContext instanceof TypeDeclaration) {
            TypeDeclaration var3 = (TypeDeclaration)this.referenceContext;
            int var4 = var3.fields.length;
            int var5 = 0;
            while (var5 < var4) {
                FieldDeclaration var6 = var3.fields[var5];
                switch (var6.getKind()) {
                    case 2:
                        Initializer var7 = (Initializer)var6;
                        if (var7.block != null) {
                            var1.enclosingType = var3;
                            var7.traverse(var1, (MethodScope)null);
                        }
                    default:
                        ++var5;
                }
            }
        }
    }

    public void method_2875() {
        if (this.currentElement != null && this.currentElement.parent != null) {
            int var1;
            if (this.currentElement instanceof RecoveredLocalVariable) {
                var1 = ((RecoveredLocalVariable)this.currentElement).localDeclaration.field_445;
                this.currentElement.method_1857(var1);
                this.currentElement = this.currentElement.parent;
            } else if (this.currentElement instanceof RecoveredField && !(this.currentElement instanceof RecoveredInitializer)) {
                var1 = ((RecoveredField)this.currentElement).fieldDeclaration.field_445;
                this.currentElement.method_1857(var1);
                this.currentElement = this.currentElement.parent;
            }
        }
    }

    public void method_2876() {
        RecoveredElement var1;
        switch (this.field_1563) {
            case 27:
                this.field_1567 = this.scanner.field_1231 - 1;
                this.field_1566 = this.scanner.field_1230 - 1;
                RecoveredType var2 = this.currentRecoveryType();
                if (var2 != null) {
                    var2.field_1137 = false;
                }
            case 31:
                this.field_1609 = this.scanner.field_1230 - 1;
                this.field_1610 = this.scanner.field_1231 - 1;
                this.field_1566 = this.flushCommentsDefinedPriorTo(this.field_1610);
                var1 = this.currentElement.updateOnClosingBrace(this.scanner.field_1230, this.field_1610);
                this.field_1590 = this.scanner.field_1231;
                if (var1 != this.currentElement) {
                    this.currentElement = var1;
                }
                break;
            case 52:
                if (this.field_1634 && this.field_1633 && this.field_1620 < this.scanner.field_1231 && !this.field_1622) {
                    StringLiteral var3 = this.createStringLiteral(this.scanner.method_2410(), this.scanner.field_1230, this.scanner.field_1231 - 1, Util.getLineNumber(this.scanner.field_1230, this.scanner.field_1256, 0, this.scanner.field_1257));
                    this.compilationUnit.recordStringLiteral(var3, this.currentElement != null);
                }
                break;
            case 69:
                var1 = null;
                if (!this.field_1586) {
                    var1 = this.currentElement.method_1854(this.scanner.field_1230 - 1, this.scanner.field_1231 - 1);
                }
                this.field_1590 = this.scanner.field_1231;
                if (var1 != null) {
                    this.field_1618 = true;
                    this.currentElement = var1;
                }
                break;
            default:
                if (this.field_1610 > this.field_1611 && this.scanner.field_1231 != this.scanner.field_1230) {
                    this.field_1611 = this.scanner.field_1230;
                }
        }
        this.field_1586 = false;
    }

    protected void reportSyntaxErrors(boolean var1, int var2) {
        if (this.referenceContext instanceof MethodDeclaration) {
            MethodDeclaration var3 = (MethodDeclaration)this.referenceContext;
            if ((var3.field_446 & 32) != 0) {
                return;
            }
        }
        this.compilationUnit.compilationResult.lineSeparatorPositions = this.scanner.getLineEnds();
        this.scanner.field_1228 = false;
        int var8 = this.scanner.field_1232;
        int var4 = this.scanner.field_1233 == Integer.MAX_VALUE ? this.scanner.field_1233 : this.scanner.field_1233 - 1;
        DiagnoseParser var10000;
        if (var1) {
            TypeDeclaration[] var5 = this.compilationUnit.types;
            int[][] var6 = RangeUtil.computeDietRange(var5);
            var10000 = new DiagnoseParser(this, var2, var8, var4, var6[0], var6[1], var6[2], this.options);
            DiagnoseParser var7 = var10000;
            var7.diagnoseParse(false);
            this.reportSyntaxErrorsForSkippedMethod(var5);
            this.scanner.method_2435(var8, var4);
        } else {
            var10000 = new DiagnoseParser(this, var2, var8, var4, this.options);
            DiagnoseParser var9 = var10000;
            var9.diagnoseParse(this.options.field_1962);
        }
    }

    private void reportSyntaxErrorsForSkippedMethod(TypeDeclaration[] var1) {
        if (var1 != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                TypeDeclaration[] var3 = var1[var2].memberTypes;
                if (var3 != null) {
                    this.reportSyntaxErrorsForSkippedMethod(var3);
                }
                AbstractMethodDeclaration[] var4 = var1[var2].methods;
                DiagnoseParser var10000;
                if (var4 != null) {
                    for (int var5 = 0; var5 < var4.length; ++var5) {
                        AbstractMethodDeclaration var6 = var4[var5];
                        if ((var6.field_446 & 32) != 0) {
                            DiagnoseParser var7;
                            if (var6.method_793()) {
                                var10000 = new DiagnoseParser(this, 23, var6.field_480, var6.field_481, this.options);
                                var7 = var10000;
                                var7.diagnoseParse(this.options.field_1962);
                            } else {
                                var10000 = new DiagnoseParser(this, 6, var6.field_480, var6.field_481, this.options);
                                var7 = var10000;
                                var7.diagnoseParse(this.options.field_1962);
                            }
                        }
                    }
                }
                FieldDeclaration[] var10 = var1[var2].fields;
                if (var10 != null) {
                    int var11 = var10.length;
                    for (int var12 = 0; var12 < var11; ++var12) {
                        if (var10[var12] instanceof Initializer) {
                            Initializer var8 = (Initializer)var10[var12];
                            if ((var8.field_446 & 32) != 0) {
                                var10000 = new DiagnoseParser(this, 10, var8.field_653, var8.field_652, this.options);
                                DiagnoseParser var9 = var10000;
                                var9.diagnoseParse(this.options.field_1962);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void method_2879() {
        this.field_1599 = 0;
        this.field_1600 = -1;
        this.scanner.field_1245 = -1;
    }

    protected void method_2880() {
        this.field_1559 = -1;
        this.field_1557 = -1;
        this.field_1570 = -1;
        this.field_1568 = -1;
        this.field_1584 = -1;
        this.field_1581 = -1;
        this.field_1587 = -1;
        this.field_1601[this.field_1602 = 0] = 0;
        this.field_1632[this.field_1602] = 0;
        this.field_1603 = 0;
        this.field_1613[this.field_1612 = 0] = 0;
        this.field_1614 = 0;
        this.field_1595 = 0;
        this.field_1596 = 0;
        this.field_1573 = -1;
        this.field_1575 = -1;
        this.field_1577 = -1;
    }

    protected boolean method_2881() {
        if (!this.field_1621 && !this.field_1622) {
            this.method_2880();
            this.method_2879();
            if (!this.moveRecoveryCheckpoint()) {
                return false;
            } else if (this.referenceContext instanceof CompilationUnitDeclaration) {
                this.method_2842();
                this.field_1564 = true;
                return true;
            } else {
                return false;
            }
        } else if (!this.field_1622) {
            this.method_2880();
            this.method_2879();
            if (!this.moveRecoveryCheckpoint()) {
                return false;
            } else {
                this.method_2842();
                return true;
            }
        } else {
            return false;
        }
    }

    protected boolean method_2882() {
        if (this.currentElement == null) {
            if (this.field_1622) {
                return false;
            }
            this.currentElement = this.buildInitialRecoveryState();
        }
        if (this.currentElement == null) {
            return false;
        } else {
            if (this.field_1618) {
                this.field_1618 = false;
            }
            this.method_2883();
            if (this.field_1620 < this.scanner.field_1231) {
                this.field_1620 = this.scanner.field_1231;
                this.scanner.field_1293 = this.scanner.field_1231;
            }
            return this.method_2881();
        }
    }

    public String toString() {
        String var1 = "lastCheckpoint : int = " + String.valueOf(this.field_1590) + "\n";
        var1 = var1 + "identifierStack : char[" + (this.field_1584 + 1) + "][] = {";
        int var2;
        for (var2 = 0; var2 <= this.field_1584; ++var2) {
            var1 = var1 + "\"" + this.identifierStack[var2] + "\",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "identifierLengthStack : int[" + (this.field_1581 + 1) + "] = {";
        for (var2 = 0; var2 <= this.field_1581; ++var2) {
            var1 = var1 + this.field_1582[var2] + ",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "astLengthStack : int[" + (this.field_1557 + 1) + "] = {";
        for (var2 = 0; var2 <= this.field_1557; ++var2) {
            var1 = var1 + this.field_1558[var2] + ",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "astPtr : int = " + this.field_1559 + "\n";
        var1 = var1 + "intStack : int[" + (this.field_1587 + 1) + "] = {";
        for (var2 = 0; var2 <= this.field_1587; ++var2) {
            var1 = var1 + this.field_1588[var2] + ",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "expressionLengthStack : int[" + (this.field_1568 + 1) + "] = {";
        for (var2 = 0; var2 <= this.field_1568; ++var2) {
            var1 = var1 + this.field_1569[var2] + ",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "expressionPtr : int = " + this.field_1570 + "\n";
        var1 = var1 + "genericsIdentifiersLengthStack : int[" + (this.field_1573 + 1) + "] = {";
        for (var2 = 0; var2 <= this.field_1573; ++var2) {
            var1 = var1 + this.field_1574[var2] + ",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "genericsLengthStack : int[" + (this.field_1575 + 1) + "] = {";
        for (var2 = 0; var2 <= this.field_1575; ++var2) {
            var1 = var1 + this.field_1576[var2] + ",";
        }
        var1 = var1 + "}\n";
        var1 = var1 + "genericsPtr : int = " + this.field_1577 + "\n";
        var1 = var1 + "\n\n\n----------------Scanner--------------\n" + this.scanner.toString();
        return var1;
    }

    protected void method_2883() {
        this.currentElement.method_1852();
        this.method_2876();
    }

    protected void method_2884(int var1) {
        int var3 = -1 + this.field_1560[this.field_1559 - var1 + 1].field_444;
        FieldDeclaration var2;
        for (int var4 = 0; var4 < var1 - 1; ++var4) {
            var2 = (FieldDeclaration)this.field_1560[this.field_1559 - var4 - 1];
            var2.field_662 = var3;
            var2.field_663 = -1 + this.field_1560[this.field_1559 - var4].field_444;
        }
        (var2 = (FieldDeclaration)this.field_1560[this.field_1559]).field_662 = var3;
        var2.field_663 = var2.field_652;
    }

    protected void method_2885(Expression var1) {
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
    }

    static Class method_2886(String var0) {
        try {
            return Class.forName(var0);
        } catch (ClassNotFoundException var2) {
            throw new NoClassDefFoundError(var2.getMessage());
        }
    }

    static {
        field_1529 = null;
        field_1530 = null;
        field_1531 = null;
        check_table = null;
        field_1533 = null;
        field_1534 = null;
        field_1535 = null;
        field_1536 = null;
        field_1537 = null;
        field_1538 = null;
        field_1539 = null;
        field_1540 = null;
        reverse_index = null;
        field_1542 = null;
        field_1543 = null;
        field_1544 = null;
        rules_compliance = null;
        field_1546 = null;
        field_1547 = null;
        field_1548 = null;
        field_1549 = null;
        field_1550 = null;
        field_1551 = null;
        field_1552 = null;
        field_1553 = null;
        field_1554 = null;
        field_1555 = null;
        VERBOSE_RECOVERY = false;
        try {
            initTables();
        } catch (IOException var1) {
            throw new RuntimeException(var1.getMessage());
        }
    }
}
