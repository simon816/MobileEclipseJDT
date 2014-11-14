package org.eclipse.jdt.internal.compiler.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.class_283;
import org.eclipse.jdt.internal.compiler.class_284;
import org.eclipse.jdt.internal.compiler.ast.class_100;
import org.eclipse.jdt.internal.compiler.ast.class_101;
import org.eclipse.jdt.internal.compiler.ast.class_102;
import org.eclipse.jdt.internal.compiler.ast.class_103;
import org.eclipse.jdt.internal.compiler.ast.class_104;
import org.eclipse.jdt.internal.compiler.ast.class_105;
import org.eclipse.jdt.internal.compiler.ast.class_106;
import org.eclipse.jdt.internal.compiler.ast.class_107;
import org.eclipse.jdt.internal.compiler.ast.class_108;
import org.eclipse.jdt.internal.compiler.ast.class_110;
import org.eclipse.jdt.internal.compiler.ast.class_111;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_113;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_115;
import org.eclipse.jdt.internal.compiler.ast.class_117;
import org.eclipse.jdt.internal.compiler.ast.class_118;
import org.eclipse.jdt.internal.compiler.ast.class_119;
import org.eclipse.jdt.internal.compiler.ast.class_120;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_122;
import org.eclipse.jdt.internal.compiler.ast.class_123;
import org.eclipse.jdt.internal.compiler.ast.class_124;
import org.eclipse.jdt.internal.compiler.ast.class_125;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_127;
import org.eclipse.jdt.internal.compiler.ast.class_128;
import org.eclipse.jdt.internal.compiler.ast.class_129;
import org.eclipse.jdt.internal.compiler.ast.class_130;
import org.eclipse.jdt.internal.compiler.ast.class_131;
import org.eclipse.jdt.internal.compiler.ast.class_132;
import org.eclipse.jdt.internal.compiler.ast.class_133;
import org.eclipse.jdt.internal.compiler.ast.class_134;
import org.eclipse.jdt.internal.compiler.ast.class_135;
import org.eclipse.jdt.internal.compiler.ast.class_136;
import org.eclipse.jdt.internal.compiler.ast.class_138;
import org.eclipse.jdt.internal.compiler.ast.class_139;
import org.eclipse.jdt.internal.compiler.ast.class_140;
import org.eclipse.jdt.internal.compiler.ast.class_141;
import org.eclipse.jdt.internal.compiler.ast.class_142;
import org.eclipse.jdt.internal.compiler.ast.class_143;
import org.eclipse.jdt.internal.compiler.ast.class_144;
import org.eclipse.jdt.internal.compiler.ast.class_145;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_147;
import org.eclipse.jdt.internal.compiler.ast.class_148;
import org.eclipse.jdt.internal.compiler.ast.class_149;
import org.eclipse.jdt.internal.compiler.ast.class_150;
import org.eclipse.jdt.internal.compiler.ast.class_151;
import org.eclipse.jdt.internal.compiler.ast.class_152;
import org.eclipse.jdt.internal.compiler.ast.class_153;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.ast.class_155;
import org.eclipse.jdt.internal.compiler.ast.class_156;
import org.eclipse.jdt.internal.compiler.ast.class_157;
import org.eclipse.jdt.internal.compiler.ast.class_158;
import org.eclipse.jdt.internal.compiler.ast.class_159;
import org.eclipse.jdt.internal.compiler.ast.class_160;
import org.eclipse.jdt.internal.compiler.ast.class_161;
import org.eclipse.jdt.internal.compiler.ast.class_162;
import org.eclipse.jdt.internal.compiler.ast.class_163;
import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.ast.class_165;
import org.eclipse.jdt.internal.compiler.ast.class_166;
import org.eclipse.jdt.internal.compiler.ast.class_167;
import org.eclipse.jdt.internal.compiler.ast.class_168;
import org.eclipse.jdt.internal.compiler.ast.class_170;
import org.eclipse.jdt.internal.compiler.ast.class_174;
import org.eclipse.jdt.internal.compiler.ast.class_175;
import org.eclipse.jdt.internal.compiler.ast.class_176;
import org.eclipse.jdt.internal.compiler.ast.class_178;
import org.eclipse.jdt.internal.compiler.ast.class_179;
import org.eclipse.jdt.internal.compiler.ast.class_180;
import org.eclipse.jdt.internal.compiler.ast.class_181;
import org.eclipse.jdt.internal.compiler.ast.class_182;
import org.eclipse.jdt.internal.compiler.ast.class_183;
import org.eclipse.jdt.internal.compiler.ast.class_184;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.ast.class_90;
import org.eclipse.jdt.internal.compiler.ast.class_91;
import org.eclipse.jdt.internal.compiler.ast.class_92;
import org.eclipse.jdt.internal.compiler.ast.class_93;
import org.eclipse.jdt.internal.compiler.ast.class_94;
import org.eclipse.jdt.internal.compiler.ast.class_96;
import org.eclipse.jdt.internal.compiler.ast.class_97;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.ast.class_99;
import org.eclipse.jdt.internal.compiler.batch.eclipse;
import org.eclipse.jdt.internal.compiler.env.class_19;
import org.eclipse.jdt.internal.compiler.impl.class_33;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_87;
import org.eclipse.jdt.internal.compiler.parser.class_251;
import org.eclipse.jdt.internal.compiler.parser.class_253;
import org.eclipse.jdt.internal.compiler.parser.class_254;
import org.eclipse.jdt.internal.compiler.parser.class_255;
import org.eclipse.jdt.internal.compiler.parser.class_256;
import org.eclipse.jdt.internal.compiler.parser.class_257;
import org.eclipse.jdt.internal.compiler.parser.class_259;
import org.eclipse.jdt.internal.compiler.parser.class_260;
import org.eclipse.jdt.internal.compiler.parser.class_261;
import org.eclipse.jdt.internal.compiler.parser.class_265;
import org.eclipse.jdt.internal.compiler.parser.class_266;
import org.eclipse.jdt.internal.compiler.parser.class_267;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScanner;
import org.eclipse.jdt.internal.compiler.parser.class_279;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;
import org.eclipse.jdt.internal.compiler.parser.diagnose.class_222;
import org.eclipse.jdt.internal.compiler.parser.diagnose.class_230;
import org.eclipse.jdt.internal.compiler.problem.class_241;
import org.eclipse.jdt.internal.compiler.problem.class_242;
import org.eclipse.jdt.internal.compiler.problem.class_246;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Util;
import org.eclipse.jdt.internal.compiler.util.class_329;

public class Parser {

    public static char[] field_1529;

    public static char[] field_1530;

    public static char[] field_1531;

    public static short[] field_1532;

    public static char[] field_1533;

    public static char[] field_1534;

    public static String[] field_1535;

    public static char[] field_1536;

    public static char[] field_1537;

    public static char[] field_1538;

    public static String[] field_1539;

    public static byte[] field_1540;

    public static int[] field_1541;

    public static char[] field_1542;

    public static char[] field_1543;

    public static char[] field_1544;

    public static long[] field_1545;

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

    public static boolean field_1556;

    protected int field_1557;

    protected int[] field_1558;

    protected int field_1559;

    protected class_89[] field_1560;

    public class_90 field_1561;

    protected class_251 field_1562;

    public int field_1563;

    protected boolean field_1564;

    protected int field_1565;

    protected int field_1566;

    protected int field_1567;

    protected int field_1568;

    protected int[] field_1569;

    protected int field_1570;

    protected class_126[] field_1571;

    public int field_1572;

    protected int field_1573;

    protected int[] field_1574;

    protected int field_1575;

    protected int[] field_1576;

    protected int field_1577;

    protected class_89[] field_1578;

    protected boolean field_1579;

    protected boolean field_1580;

    protected int field_1581;

    protected int[] field_1582;

    protected long[] field_1583;

    protected int field_1584;

    protected char[][] field_1585;

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

    class_89[] field_1604;

    class_126[] field_1605;

    protected boolean field_1606;

    protected CompilerOptions field_1607;

    protected ProblemReporter field_1608;

    protected int field_1609;

    protected int field_1610;

    protected int field_1611;

    protected int field_1612;

    protected int[] field_1613;

    protected int field_1614;

    public class_33 field_1615;

    public boolean field_1616;

    public boolean field_1617;

    protected boolean field_1618;

    protected boolean field_1619;

    protected int field_1620;

    public boolean field_1621;

    protected boolean field_1622;

    protected class_114[] field_1623;

    protected int field_1624;

    protected int field_1625;

    protected class_114 field_1626;

    public RecoveryScanner field_1627;

    public Scanner field_1628;

    protected int[] field_1629;

    protected int field_1630;

    protected int field_1631;

    protected int[] field_1632;

    protected boolean field_1633;

    protected boolean field_1634;

    protected int field_1635;

    public class_283 field_1636;

    static Class field_1637;

    public static int method_2504(int var0) {
        return field_1529[method_2510(var0)];
    }

    public static final short method_2505(int var0) {
        return field_1532[var0 - 701];
    }

    public static int method_2506(int var0) {
        return field_1533[method_2510(var0)];
    }

    public static final void method_2507() throws IOException {
        byte var1 = 0;
        StringBuffer var10000 = (new StringBuffer()).append("/batch/parser");
        int var4 = var1 + 1;
        field_1534 = method_2515(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        char[] var2 = method_2515(var10000.append(var4).append(".rsc").toString());
        field_1532 = new short[var2.length];
        for (int var3 = var2.length; var3-- > 0; field_1532[var3] = (short)(var2[var3] - '\u8000')) {
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
        field_1535 = method_2513(var10000.append(var4).append(".rsc").toString());
        var10000 = (new StringBuffer()).append("/batch/parser");
        ++var4;
        field_1545 = method_2516(var10000.append(var4).append(".rsc").toString());
        field_1539 = method_2514("/batch/readableNames.txt");
        field_1541 = method_2511(field_1555, field_1538, field_1535);
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
        return field_1536[method_2510(var0)];
    }

    public static int method_2509(int var0, int var1) {
        return field_1531[var0 + var1];
    }

    protected static int method_2510(int var0) {
        return -method_2505(var0);
    }

    protected static int[] method_2511(char[] var0, char[] var1, String[] var2) {
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
            throw new IOException(class_329.method_3251(class_329.field_1887, var0));
        } else {
            Object var2 = null;
            byte[] var11;
            try {
                var11 = Util.method_1322(var1, -1);
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

    protected static String[] method_2513(String var0) throws IOException {
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
                    String var4 = class_246.method_1446(var3);
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
            throw new IOException(class_329.method_3251(class_329.field_1887, var0));
        } else {
            Object var2 = null;
            byte[] var12;
            try {
                var12 = Util.method_1322(var1, -1);
            } finally {
                try {
                    var1.close();
                } catch (IOException var10) {
                    ;
                }
            }
            int var3 = var12.length;
            if ((var3 & 1) != 0) {
                throw new IOException(class_329.method_3251(class_329.field_1888, var0));
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
            throw new IOException(class_329.method_3251(class_329.field_1887, var0));
        } else {
            Object var2 = null;
            byte[] var12;
            try {
                var12 = Util.method_1322(var1, -1);
            } finally {
                try {
                    var1.close();
                } catch (IOException var10) {
                    ;
                }
            }
            int var3 = var12.length;
            if (var3 % 8 != 0) {
                throw new IOException(class_329.method_3251(class_329.field_1888, var0));
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
        this.field_1560 = new class_89[100];
        this.field_1564 = false;
        this.field_1565 = 0;
        this.field_1571 = new class_126[100];
        this.field_1574 = new int[10];
        this.field_1576 = new int[10];
        this.field_1578 = new class_89[10];
        this.field_1592 = -1;
        this.field_1604 = new class_89[100];
        this.field_1605 = new class_126[100];
        this.field_1606 = true;
        this.field_1616 = false;
        this.field_1617 = true;
        this.field_1619 = true;
        this.field_1621 = false;
        this.field_1622 = false;
        this.field_1629 = new int[255];
        this.field_1608 = var1;
        this.field_1607 = var1.field_1064;
        this.field_1606 = var2;
        this.method_2846();
        this.field_1558 = new int[50];
        this.field_1569 = new int[30];
        this.field_1588 = new int[50];
        this.field_1585 = new char[30][];
        this.field_1582 = new int[30];
        this.field_1601 = new int[30];
        this.field_1613 = new int[30];
        this.field_1583 = new long[30];
        this.field_1632 = new int[30];
    }

    protected void method_2519(int var1, int var2) {
        if (this.field_1590 < var2) {
            this.field_1590 = var2 + 1;
        }
    }

    public void method_2520(int var1) {
        class_128 var10000 = new class_128();
        class_128 var2 = var10000;
        if (var1 != 0) {
            this.field_1570 -= var1;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var2.field_679 = new class_126[var1], 0, var1);
        }
        this.method_2867(var2);
        var2.field_445 = this.field_1567;
        var2.field_444 = this.field_1588[this.field_1587--];
    }

    protected void method_2521() {
        ++this.field_1613[this.field_1612];
    }

    public class_251 method_2522() {
        this.field_1590 = 0;
        this.field_1592 = this.field_1628.field_1231;
        Object var1 = null;
        if (this.field_1615 instanceof class_90) {
            class_256 var8 = new class_256(this.field_1561, 0, this);
            class_256 var17 = var8;
            this.field_1561.field_448 = null;
            this.field_1561.field_449 = null;
            this.field_1561.field_450 = null;
            this.field_1563 = 0;
            this.field_1595 = 0;
            this.field_1596 = 0;
            this.field_1566 = 0;
            this.field_1567 = 0;
            return var17;
        } else {
            class_121 var4;
            if (this.field_1615 instanceof class_93) {
                class_255 var10000 = new class_255((class_93)this.field_1615, (class_251)null, 0, this);
                var1 = var10000;
                this.field_1590 = ((class_93)this.field_1615).field_490;
                if (this.field_1622) {
                    class_112 var10001 = new class_112(0);
                    var1 = ((class_251)var1).method_1833(var10001, 0);
                }
            } else if (this.field_1615 instanceof class_114) {
                class_114 var2 = (class_114)this.field_1615;
                for (int var3 = 0; var3 < var2.field_583.length; ++var3) {
                    var4 = var2.field_583[var3];
                    if (var4 != null && var4.method_887() == 2 && ((class_122)var4).field_664 != null && var4.field_653 <= this.field_1628.field_1232 && this.field_1628.field_1232 <= var4.field_652 && this.field_1628.field_1233 <= var4.field_652 + 1) {
                        class_254 var7 = new class_254(var4, (class_251)null, 1, this);
                        var1 = var7;
                        this.field_1590 = var4.field_653;
                        break;
                    }
                }
            }
            if (var1 == null) {
                return (class_251)var1;
            } else {
                for (int var5 = 0; var5 <= this.field_1559; ++var5) {
                    class_89 var6 = this.field_1560[var5];
                    if (var6 instanceof class_93) {
                        class_93 var9 = (class_93)var6;
                        if (var9.field_481 == 0) {
                            var1 = ((class_251)var1).method_1832(var9, 0);
                            this.field_1590 = var9.field_490;
                        } else {
                            var1 = ((class_251)var1).method_1832(var9, 0);
                            this.field_1590 = var9.field_481 + 1;
                        }
                    } else if (var6 instanceof class_122) {
                        class_122 var10 = (class_122)var6;
                        if (var10.field_664 != null) {
                            if (var10.field_652 == 0) {
                                var1 = ((class_251)var1).method_1834(var10, 1);
                                this.field_1590 = var10.field_444;
                            } else {
                                var1 = ((class_251)var1).method_1834(var10, 0);
                                this.field_1590 = var10.field_652 + 1;
                            }
                        }
                    } else if (var6 instanceof class_121) {
                        var4 = (class_121)var6;
                        if (var4.field_652 == 0) {
                            var1 = ((class_251)var1).method_1834(var4, 0);
                            if (var4.field_655 == null) {
                                this.field_1590 = var4.field_445 + 1;
                            } else {
                                this.field_1590 = var4.field_655.field_445 + 1;
                            }
                        } else {
                            var1 = ((class_251)var1).method_1834(var4, 0);
                            this.field_1590 = var4.field_652 + 1;
                        }
                    } else if (var6 instanceof class_114) {
                        class_114 var11 = (class_114)var6;
                        if (var11.field_593 == 0) {
                            var1 = ((class_251)var1).method_1838(var11, 0);
                            this.field_1590 = var11.field_594;
                        } else {
                            var1 = ((class_251)var1).method_1838(var11, 0);
                            this.field_1590 = var11.field_593 + 1;
                        }
                    } else {
                        if (var6 instanceof class_91) {
                            class_91 var13 = (class_91)var6;
                            var1 = ((class_251)var1).method_1835(var13, 0);
                            this.field_1590 = var13.field_471 + 1;
                        }
                        if (this.field_1622) {
                            if (var6 instanceof class_112) {
                                class_112 var12 = (class_112)var6;
                                var1 = ((class_251)var1).method_1833(var12, 0);
                                this.field_1590 = var12.field_445 + 1;
                            } else if (var6 instanceof class_124) {
                                class_124 var15 = (class_124)var6;
                                var1 = ((class_251)var1).method_1836(var15, 0);
                                this.field_1590 = var15.field_445 + 1;
                            } else if (var6 instanceof class_126) {
                                if (var6 instanceof class_131 || var6 instanceof class_134 || var6 instanceof class_133 || var6 instanceof class_168 || var6 instanceof class_135) {
                                    class_126 var14 = (class_126)var6;
                                    var1 = ((class_251)var1).method_1837(var14, 0);
                                    if (var14.field_673 != -1) {
                                        this.field_1590 = var14.field_673 + 1;
                                    } else {
                                        this.field_1590 = var14.field_445 + 1;
                                    }
                                }
                            } else if (var6 instanceof class_98) {
                                class_98 var16 = (class_98)var6;
                                var1 = ((class_251)var1).method_1837(var16, 0);
                                this.field_1590 = var16.field_445 + 1;
                            }
                        }
                    }
                }
                if (this.field_1622 && this.field_1626 != null && this.field_1628.field_1230 - 1 <= this.field_1626.field_593) {
                    var1 = ((class_251)var1).method_1838(this.field_1626, 0);
                    this.field_1590 = this.field_1626.field_593 + 1;
                    this.field_1626 = null;
                }
                return (class_251)var1;
            }
        }
    }

    protected void method_2523(int var1) {
        if ((this.field_1599 & var1) != 0) {
            this.field_1599 |= 4194304;
        }
        this.field_1599 |= var1;
        if (this.field_1600 < 0) {
            this.field_1600 = this.field_1628.field_1230;
        }
        if (this.field_1562 != null && this.field_1619) {
            this.field_1562.method_1840(var1, this.field_1600);
        }
    }

    public void method_2524() {
        if ((!this.field_1564 || this.field_1565 != 0) && this.field_1628.field_1245 >= 0) {
            this.method_2831(this.field_1567);
        }
        int var1 = this.field_1628.field_1245;
        if (this.field_1600 >= 0) {
            while (var1 >= 0 && this.field_1628.field_1243[var1] > this.field_1600) {
                --var1;
            }
        }
        if (var1 >= 0) {
            for (this.field_1600 = this.field_1628.field_1243[0]; var1 >= 0 && this.field_1628.field_1242[var1] < 0; --var1) {
                ;
            }
        }
    }

    protected void method_2525(int var1) {
        if (this.field_1628.field_1231 - 1 <= var1) {
            this.field_1628.field_1233 = var1 < Integer.MAX_VALUE ? var1 + 1 : var1;
            try {
                while (true) {
                    if (this.field_1628.method_2419() != 68) {
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
                class_136 var10000 = new class_136();
                var2 = var10000;
            } else {
                class_135 var5 = new class_135();
                var2 = var5;
            }
            ((class_135)var2).field_445 = this.field_1566;
            if ((var3 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var3;
                System.arraycopy(this.field_1571, this.field_1570 + 1, ((class_135)var2).field_692 = new class_126[var3], 0, var3);
            }
            ((class_135)var2).field_691 = this.method_2836(0);
            ((class_135)var2).field_444 = this.field_1588[this.field_1587--];
            this.method_2867((class_126)var2);
        } else {
            this.method_2828(var3);
            class_114 var4 = (class_114)this.field_1560[this.field_1559];
            var4.field_593 = this.field_1567;
            var4.field_595 = this.field_1567;
            if (var4.field_598 != null) {
                var4.field_598.field_445 = this.field_1567;
            }
            if (var3 == 0 && !this.method_2820(var4.field_594, var4.field_595)) {
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
        this.method_2869(this.method_2836(this.field_1588[this.field_1587--]));
    }

    protected void method_2531() {}

    protected void method_2532() {
        this.method_2528();
    }

    protected void method_2533() {
        this.method_2528();
    }

    protected void method_2534() {
        if (this.field_1562 != null) {
            if (this.field_1563 == 69) {
                class_114 var10000 = new class_114(this.field_1561.field_455);
                class_114 var1 = var10000;
                var1.field_580 = CharOperation.field_994;
                var1.field_446 |= 768;
                var1.field_444 = this.field_1588[this.field_1587--];
                var1.field_445 = this.field_1598;
                class_136 var3 = new class_136(var1);
                class_136 var2 = var3;
                var2.field_691 = this.method_2836(0);
                var2.field_444 = var1.field_444;
                var2.field_445 = var1.field_445;
                this.field_1590 = var1.field_594 = this.field_1628.field_1231;
                this.field_1562 = this.field_1562.method_1838(var1, 0);
                this.field_1593 = -1;
                this.field_1563 = 0;
            } else {
                this.field_1590 = this.field_1628.field_1230;
                this.field_1618 = true;
            }
        }
    }

    protected void method_2535() {
        class_126 var1 = this.field_1571[this.field_1570];
        int var2 = var1.field_444;
        if (this.field_1600 < 0) {
            this.field_1600 = var2;
        }
    }

    protected void method_2536() {
        if (this.field_1562 != null) {
            int var1 = this.field_1588[this.field_1587];
            int var2 = (int)(this.field_1583[this.field_1584] & 4294967295L);
            this.method_2519(var1, var2);
            if (this.field_1619) {
                this.field_1562 = this.field_1562.method_1831(this.field_1584, this.field_1581, var1, 0);
            }
        }
        this.field_1634 = false;
    }

    protected void method_2537() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2828(var1);
        }
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        var2.method_850(this);
        if (this.field_1628.field_1226) {
            var2.field_446 |= 1;
        }
        var2.method_845();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.method_2820(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.method_2831(this.field_1567);
    }

    protected void method_2538() {
        if (this.field_1562 != null) {
            this.field_1618 = true;
        }
        this.field_1628.field_1245 = -1;
    }

    protected void method_2539() {
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var2 = this.field_1583[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.field_580 = this.field_1585[this.field_1584--];
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
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.field_1561 != null && !CharOperation.method_1364(var1.field_580, this.field_1561.method_772())) {
            var1.field_446 |= 4096;
        }
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var4) + 1, var1.field_579 = new class_164[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1646(var1);
        }
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_594;
            this.field_1562 = this.field_1562.method_1838(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2540() {
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var1 = var10000;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_601 = new class_123[var2], 0, var2);
        this.method_2862().method_1652(var1);
        var1.field_594 = var1.field_601[var2 - 1].field_652 + 1;
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
        long var3 = this.field_1583[this.field_1584];
        var1.field_445 = (int)var3;
        var1.field_444 = (int)(var3 >>> 32);
        var1.field_580 = this.field_1585[this.field_1584--];
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
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.field_1561 != null && !CharOperation.method_1364(var1.field_580, this.field_1561.method_772())) {
            var1.field_446 |= 4096;
        }
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var2) + 1, var1.field_579 = new class_164[var2], 0, var2);
        }
        this.method_2866(var1);
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1646(var1);
        }
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_594;
            this.field_1562 = this.field_1562.method_1838(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2541() {
        class_97 var1 = (class_97)this.field_1560[this.field_1559];
        var1.field_482 |= 16777216;
        int var2 = this.method_2831(this.field_1567);
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
        class_156 var2;
        int var10001;
        class_126[] var10000;
        class_156 var10002;
        if (var1) {
            var10000 = this.field_1571;
            var10001 = this.field_1570;
            var10002 = new class_156(this.method_2839(), this.field_1571[this.field_1570]);
            var2 = (class_156)(var10000[var10001] = var10002);
        } else {
            --this.field_1570;
            --this.field_1568;
            var10000 = this.field_1571;
            var10001 = this.field_1570;
            var10002 = new class_156(this.field_1571[this.field_1570], this.field_1571[this.field_1570 + 1]);
            var2 = (class_156)(var10000[var10001] = var10002);
        }
        var2.field_445 = this.field_1567;
    }

    protected void method_2546() {
        class_127 var10000 = new class_127();
        class_127 var2 = var10000;
        --this.field_1568;
        var2.field_678 = (class_128)this.field_1571[this.field_1570--];
        var2.field_676 = this.method_2836(0);
        var2.field_676.field_446 |= 1073741824;
        int var1 = this.field_1569[this.field_1568--];
        this.field_1570 -= var1;
        System.arraycopy(this.field_1571, this.field_1570 + 1, var2.field_677 = new class_126[var1], 0, var1);
        var2.field_444 = this.field_1588[this.field_1587--];
        if (var2.field_678 == null) {
            var2.field_445 = this.field_1567;
        } else {
            var2.field_445 = var2.field_678.field_445;
        }
        this.method_2867(var2);
    }

    protected void method_2547() {
        class_127 var10000 = new class_127();
        class_127 var2 = var10000;
        var2.field_676 = this.method_2836(0);
        var2.field_676.field_446 |= 1073741824;
        int var1 = this.field_1569[this.field_1568--];
        this.field_1570 -= var1;
        System.arraycopy(this.field_1571, this.field_1570 + 1, var2.field_677 = new class_126[var1], 0, var1);
        var2.field_444 = this.field_1588[this.field_1587--];
        if (var2.field_678 == null) {
            var2.field_445 = this.field_1567;
        } else {
            var2.field_445 = var2.field_678.field_445;
        }
        this.method_2867(var2);
    }

    protected void method_2548() {}

    protected void method_2549() {
        this.method_2520(this.field_1569[this.field_1568--]);
    }

    protected void method_2550() {
        this.field_1574[this.field_1573] += this.field_1582[this.field_1581];
        this.method_2871(0);
    }

    protected void method_2551() {
        this.field_1568 -= 2;
        class_106 var10001 = new class_106(this.field_1571[this.field_1570--], this.field_1571[this.field_1570--], this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2552() {
        int var1 = this.field_1588[this.field_1587--];
        --this.field_1570;
        --this.field_1568;
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        Object var10002;
        if (var1 != 30) {
            var10002 = new class_132(this.field_1571[this.field_1570], this.field_1571[this.field_1570 + 1], var1, this.field_1628.field_1230 - 1);
        } else {
            var10002 = new class_131(this.field_1571[this.field_1570], this.field_1571[this.field_1570 + 1], this.field_1628.field_1230 - 1);
        }
        var10000[var10001] = (class_126)var10002;
        if (this.field_1626 != null) {
            if (this.field_1626.field_598 != null && this.field_1628.field_1230 - 1 <= this.field_1626.field_593) {
                this.field_1571[this.field_1570] = this.field_1626.field_598;
                this.field_1626 = null;
                return;
            }
            this.field_1626 = null;
        }
    }

    protected void method_2553(int var1) {
        this.method_2872(var1);
    }

    protected void method_2554(int var1) {
        --this.field_1570;
        --this.field_1568;
        class_126 var2 = this.field_1571[this.field_1570];
        class_126 var3 = this.field_1571[this.field_1570 + 1];
        int var10001;
        class_126[] var10000;
        class_141 var10002;
        switch (var1) {
            case 0:
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_143 var9 = new class_143(var2, var3, var1);
                var10000[var10001] = var9;
                break;
            case 1:
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_145 var5 = new class_145(var2, var3, var1);
                var10000[var10001] = var5;
                break;
            case 4:
                --this.field_1587;
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                var10002 = new class_141(var2, var3, var1);
                var10000[var10001] = var10002;
                break;
            case 14:
                class_144 var4;
                class_144 var6;
                class_141 var7;
                class_144 var8;
                if (this.field_1606) {
                    if (var2 instanceof class_170) {
                        if ((var2.field_446 & 534773760) >> 21 == 0) {
                            if (var3 instanceof class_182) {
                                this.field_1571[this.field_1570] = ((class_170)var2).method_1085((class_182)var3);
                            } else if (var3 instanceof class_170) {
                                this.field_1571[this.field_1570] = ((class_170)var2).method_1086((class_170)var3);
                            } else {
                                var10000 = this.field_1571;
                                var10001 = this.field_1570;
                                var10002 = new class_141(var2, var3, 14);
                                var10000[var10001] = var10002;
                            }
                        } else {
                            var10000 = this.field_1571;
                            var10001 = this.field_1570;
                            var10002 = new class_141(var2, var3, 14);
                            var10000[var10001] = var10002;
                        }
                    } else if (var2 instanceof class_144) {
                        if ((var4 = (class_144)var2).field_720 < var4.field_721) {
                            var7 = new class_141(var4);
                            var4.field_715 = var7;
                            ++var4.field_720;
                        } else {
                            var8 = new class_144(var4);
                            var4.field_715 = var8;
                            var4.field_720 = 0;
                            var4.method_1004();
                        }
                        var4.field_716 = var3;
                        var4.field_445 = var3.field_445;
                        this.field_1571[this.field_1570] = var4;
                    } else if (var2 instanceof class_141 && (var2.field_446 & 4032) >> 6 == 14) {
                        var10000 = this.field_1571;
                        var10001 = this.field_1570;
                        var6 = new class_144(var2, var3, 14, 1);
                        var10000[var10001] = var6;
                    } else {
                        var10000 = this.field_1571;
                        var10001 = this.field_1570;
                        var10002 = new class_141(var2, var3, 14);
                        var10000[var10001] = var10002;
                    }
                } else if (var2 instanceof class_170) {
                    if (var3 instanceof class_170 && (var2.field_446 & 534773760) >> 21 == 0) {
                        this.field_1571[this.field_1570] = ((class_170)var2).method_1087((class_170)var3);
                    } else {
                        var10000 = this.field_1571;
                        var10001 = this.field_1570;
                        var10002 = new class_141(var2, var3, 14);
                        var10000[var10001] = var10002;
                    }
                } else if (var2 instanceof class_144) {
                    if ((var4 = (class_144)var2).field_720 < var4.field_721) {
                        var7 = new class_141(var4);
                        var4.field_715 = var7;
                        var4.field_446 &= -534773761;
                        ++var4.field_720;
                    } else {
                        var8 = new class_144(var4);
                        var4.field_715 = var8;
                        var4.field_446 &= -534773761;
                        var4.field_720 = 0;
                        var4.method_1004();
                    }
                    var4.field_716 = var3;
                    var4.field_445 = var3.field_445;
                    this.field_1571[this.field_1570] = var4;
                } else if (var2 instanceof class_141 && (var2.field_446 & 4032) >> 6 == 14) {
                    var10000 = this.field_1571;
                    var10001 = this.field_1570;
                    var6 = new class_144(var2, var3, 14, 1);
                    var10000[var10001] = var6;
                } else {
                    var10000 = this.field_1571;
                    var10001 = this.field_1570;
                    var10002 = new class_141(var2, var3, 14);
                    var10000[var10001] = var10002;
                }
                break;
            default:
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                var10002 = new class_141(var2, var3, var1);
                var10000[var10001] = var10002;
        }
    }

    protected void method_2555(int var1) {
        this.method_2867(this.method_2839());
        --this.field_1570;
        --this.field_1568;
        class_126 var2 = this.field_1571[this.field_1570 + 1];
        class_126 var3 = this.field_1571[this.field_1570];
        int var10001;
        class_126[] var10000;
        class_141 var10002;
        switch (var1) {
            case 0:
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_143 var5 = new class_143(var2, var3, var1);
                var10000[var10001] = var5;
                break;
            case 1:
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_145 var4 = new class_145(var2, var3, var1);
                var10000[var10001] = var4;
                break;
            case 4:
                --this.field_1587;
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                var10002 = new class_141(var2, var3, var1);
                var10000[var10001] = var10002;
                break;
            case 14:
                if (this.field_1606) {
                    if (var2 instanceof class_170 && (var2.field_446 & 534773760) >> 21 == 0) {
                        if (var3 instanceof class_182) {
                            this.field_1571[this.field_1570] = ((class_170)var2).method_1085((class_182)var3);
                        } else if (var3 instanceof class_170) {
                            this.field_1571[this.field_1570] = ((class_170)var2).method_1086((class_170)var3);
                        } else {
                            var10000 = this.field_1571;
                            var10001 = this.field_1570;
                            var10002 = new class_141(var2, var3, 14);
                            var10000[var10001] = var10002;
                        }
                    } else {
                        var10000 = this.field_1571;
                        var10001 = this.field_1570;
                        var10002 = new class_141(var2, var3, 14);
                        var10000[var10001] = var10002;
                    }
                } else if (var2 instanceof class_170) {
                    if (var3 instanceof class_170 && (var2.field_446 & 534773760) >> 21 == 0) {
                        this.field_1571[this.field_1570] = ((class_170)var2).method_1087((class_170)var3);
                    } else {
                        var10000 = this.field_1571;
                        var10001 = this.field_1570;
                        var10002 = new class_141(var2, var3, var1);
                        var10000[var10001] = var10002;
                    }
                } else {
                    var10000 = this.field_1571;
                    var10001 = this.field_1570;
                    var10002 = new class_141(var2, var3, var1);
                    var10000[var10001] = var10002;
                }
                break;
            default:
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                var10002 = new class_141(var2, var3, var1);
                var10000[var10001] = var10002;
        }
    }

    protected void method_2556() {
        int var1 = this.field_1558[this.field_1557--];
        class_112 var2;
        class_112 var10000;
        if (var1 == 0) {
            var10000 = new class_112(0);
            var2 = var10000;
            var2.field_444 = this.field_1588[this.field_1587--];
            var2.field_445 = this.field_1567;
            if (!this.method_2820(var2.field_444, var2.field_445)) {
                var2.field_446 |= 8;
            }
            --this.field_1612;
        } else {
            var10000 = new class_112(this.field_1613[this.field_1612--]);
            var2 = var10000;
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, var2.field_572 = new class_98[var1], 0, var1);
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
        class_126 var1 = this.field_1571[this.field_1570--];
        class_108 var10001 = new class_108(var1, var1.field_445, this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2559() {
        --this.field_1570;
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_126 var2;
        class_130 var10002 = new class_130(var2 = this.field_1571[this.field_1570 + 1], this.method_2835(this.field_1571[this.field_1570]));
        class_130 var1 = var10002;
        var10000[var10001] = var10002;
        --this.field_1568;
        this.method_2885(var1);
        var1.field_445 = var2.field_445;
    }

    protected void method_2560() {
        int var4 = this.field_1588[this.field_1587--];
        int var5 = this.field_1588[this.field_1587--];
        this.method_2870(this.field_1582[this.field_1581]);
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_126 var1;
        class_146 var3;
        class_130 var10002 = new class_130(var1 = this.field_1571[this.field_1570], var3 = this.method_2836(var5));
        class_130 var2 = var10002;
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
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_126 var1;
        class_146 var3;
        class_130 var10002 = new class_130(var1 = this.field_1571[this.field_1570], var3 = this.method_2836(this.field_1588[this.field_1587--]));
        class_130 var2 = var10002;
        var10000[var10001] = var10002;
        var3.field_445 = var4 - 1;
        var3.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected void method_2562() {
        int var4 = this.field_1588[this.field_1587--];
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_126 var1;
        class_146 var3;
        class_130 var10002 = new class_130(var1 = this.field_1571[this.field_1570], var3 = this.method_2836(this.field_1588[this.field_1587--]));
        class_130 var2 = var10002;
        var10000[var10001] = var10002;
        var3.field_445 = var4 - 1;
        var3.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected class_153 method_2563(class_146 var1, int var2) {
        int var3 = this.field_1582[this.field_1581];
        int var4 = var3;
        if (var1 instanceof class_150) {
            var4 = var3 + 1;
        } else if (var1 instanceof class_147) {
            var4 = var3 + 1;
        } else if (var1 instanceof class_153) {
            var4 = var3 + ((class_151)var1).field_732.length;
        } else if (var1 instanceof class_151) {
            var4 = var3 + ((class_151)var1).field_732.length;
        }
        class_146[][] var5 = new class_146[var4][];
        char[][] var6 = new char[var4][];
        long[] var7 = new long[var4];
        if (var1 instanceof class_150) {
            class_150 var8 = (class_150)var1;
            var6[var3] = var8.field_726;
            var7[var3] = ((long)var8.field_444 << 32) + (long)var8.field_445;
            var5[var3] = var8.field_731;
        } else if (var1 instanceof class_147) {
            class_147 var13 = (class_147)var1;
            var6[var3] = var13.field_726;
            var7[var3] = ((long)var13.field_444 << 32) + (long)var13.field_445;
        } else if (var1 instanceof class_153) {
            class_153 var12 = (class_153)var1;
            class_146[][] var9 = var12.field_735;
            System.arraycopy(var9, 0, var5, var3, var9.length);
            char[][] var10 = var12.field_732;
            System.arraycopy(var10, 0, var6, var3, var10.length);
            long[] var11 = var12.field_733;
            System.arraycopy(var11, 0, var7, var3, var11.length);
        } else if (var1 instanceof class_151) {
            class_151 var16 = (class_151)var1;
            char[][] var15 = var16.field_732;
            System.arraycopy(var15, 0, var6, var3, var15.length);
            long[] var18 = var16.field_733;
            System.arraycopy(var18, 0, var7, var3, var18.length);
        }
        int var14 = this.field_1576[this.field_1575--];
        class_146[] var17 = new class_146[var14];
        this.field_1577 -= var14;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var17, 0, var14);
        if (var3 == 1) {
            var6[0] = this.field_1585[this.field_1584];
            var7[0] = this.field_1583[this.field_1584--];
            var5[0] = var17;
        } else {
            this.field_1584 -= var3;
            System.arraycopy(this.field_1585, this.field_1584 + 1, var6, 0, var3);
            System.arraycopy(this.field_1583, this.field_1584 + 1, var7, 0, var3);
            var5[var3 - 1] = var17;
        }
        --this.field_1581;
        class_153 var10000 = new class_153(var6, var5, var2, var7);
        return var10000;
    }

    protected void method_2564() {
        int var4 = this.field_1588[this.field_1587--];
        int var5 = this.field_1588[this.field_1587--];
        class_146 var6 = this.method_2836(0);
        class_153 var7 = this.method_2563(var6, var5);
        --this.field_1587;
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_126 var1;
        class_130 var10002 = new class_130(var1 = this.field_1571[this.field_1570], var7);
        class_130 var2 = var10002;
        var10000[var10001] = var10002;
        var7.field_445 = var4 - 1;
        var7.field_444 = (var2.field_444 = this.field_1588[this.field_1587--]) + 1;
        var2.field_445 = var1.field_445;
    }

    protected void method_2565() {
        this.method_2853();
    }

    protected void method_2566() {
        if (this.field_1562 != null) {
            if (!(this.field_1562 instanceof class_261)) {
                if (!(this.field_1562 instanceof class_255)) {
                    return;
                }
                class_255 var1 = (class_255)this.field_1562;
                if (var1.field_1095 != null || var1.field_1069 <= 0) {
                    return;
                }
            }
            class_125 var3 = (class_125)this.field_1560[this.field_1559--];
            class_124 var10000 = new class_124(var3.field_659, var3.field_444, var3.field_445);
            class_124 var2 = var10000;
            var2.field_660 = var3.field_660;
            var2.field_653 = var3.field_653;
            var2.field_652 = var3.field_652;
            this.field_1562 = this.field_1562.method_1836(var2, 0);
            this.field_1590 = this.field_1628.field_1230;
            this.field_1618 = true;
            this.field_1593 = -1;
        }
    }

    protected void method_2567() {
        --this.field_1601[this.field_1602];
        class_112 var1 = (class_112)this.field_1560[this.field_1559--];
        --this.field_1557;
        if (this.field_1564) {
            var1.field_446 &= -9;
        }
        class_122 var2 = (class_122)this.field_1560[this.field_1559];
        var2.field_653 = var2.field_444 = var1.field_444;
        var2.field_664 = var1;
        --this.field_1587;
        var2.field_666 = this.field_1588[this.field_1587--];
        --this.field_1612;
        int var3 = this.field_1588[this.field_1587--];
        if (var3 != -1) {
            var2.field_653 = var3;
        }
        var2.field_667 = this.field_1566;
        var2.field_445 = this.field_1567;
        var2.field_652 = this.method_2831(this.field_1567);
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
        this.method_2866((class_89)null);
        this.field_1566 = this.field_1598;
    }

    protected void method_2572() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2828(var1);
        }
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        boolean var3 = var2.method_850(this);
        if (!var3) {
            switch (class_114.method_859(var2.field_577)) {
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
                    var2.method_851(!this.field_1564 || var4, true);
            }
        }
        if (this.field_1628.field_1226) {
            var2.field_446 |= 1;
        }
        var2.method_845();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.method_2820(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.method_2831(this.field_1567);
    }

    protected void method_2573() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_594 = this.field_1628.field_1231;
        }
        if (this.field_1562 != null) {
            this.field_1618 = true;
        }
        this.field_1628.field_1245 = -1;
    }

    protected void method_2574() {
        class_146 var1 = this.method_2836(0);
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        var2.field_581 = var1;
        var1.field_446 |= 16;
        var2.field_594 = var2.field_581.field_445 + 1;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_594;
        }
    }

    protected void method_2575() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        System.arraycopy(this.field_1560, this.field_1559 + 1, var2.field_582 = new class_146[var1], 0, var1);
        int var3 = 0;
        for (int var4 = var2.field_582.length; var3 < var4; ++var3) {
            var2.field_582[var3].field_446 |= 16;
        }
        var2.field_594 = var2.field_582[var1 - 1].field_445 + 1;
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_594;
        }
    }

    protected void method_2576() {
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var2 = this.field_1583[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.field_580 = this.field_1585[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--];
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.field_1561 != null && !CharOperation.method_1364(var1.field_580, this.field_1561.method_772())) {
            var1.field_446 |= 4096;
        }
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var4) + 1, var1.field_579 = new class_164[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_594;
            this.field_1562 = this.field_1562.method_1838(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2577() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_601 = new class_123[var2], 0, var2);
        var1.field_594 = var1.field_601[var2 - 1].field_652 + 1;
        this.field_1596 = 0;
        if (this.field_1562 != null) {
            class_260 var3 = (class_260)this.field_1562;
            var3.field_1138 = null;
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
        class_136 var1 = (class_136)this.field_1571[this.field_1570--];
        var1.field_699 = this.field_1571[this.field_1570];
        this.field_1571[this.field_1570] = var1;
        var1.field_444 = var1.field_699.field_444;
    }

    protected void method_2581() {
        int var2;
        if ((var2 = this.field_1558[this.field_1557--]) == 1 && this.field_1560[this.field_1559] == null) {
            --this.field_1559;
            class_136 var10000 = new class_136();
            class_136 var1 = var10000;
            var1.field_445 = this.field_1566;
            if ((var2 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var2;
                System.arraycopy(this.field_1571, this.field_1570 + 1, var1.field_692 = new class_126[var2], 0, var2);
            }
            var1.field_691 = this.method_2836(0);
            var2 = this.field_1576[this.field_1575--];
            this.field_1577 -= var2;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_696 = new class_146[var2], 0, var2);
            --this.field_1587;
            var1.field_444 = this.field_1588[this.field_1587--];
            this.method_2867(var1);
        } else {
            this.method_2828(var2);
            class_114 var3 = (class_114)this.field_1560[this.field_1559];
            var3.field_593 = this.field_1567;
            var3.field_595 = this.field_1567;
            if (var2 == 0 && !this.method_2820(var3.field_594, var3.field_595)) {
                var3.field_446 |= 8;
            }
            --this.field_1559;
            --this.field_1557;
            class_136 var4 = var3.field_598;
            if (var4 != null) {
                var4.field_445 = this.field_1567;
                var2 = this.field_1576[this.field_1575--];
                this.field_1577 -= var2;
                System.arraycopy(this.field_1578, this.field_1577 + 1, var4.field_696 = new class_146[var2], 0, var2);
                var4.field_444 = this.field_1588[this.field_1587--];
            }
        }
        --this.field_1568;
        class_136 var5 = (class_136)this.field_1571[this.field_1570--];
        var5.field_699 = this.field_1571[this.field_1570];
        this.field_1571[this.field_1570] = var5;
        var5.field_444 = var5.field_699.field_444;
    }

    protected void method_2582() {
        int var2;
        if ((var2 = this.field_1558[this.field_1557--]) == 1 && this.field_1560[this.field_1559] == null) {
            --this.field_1559;
            class_135 var10000 = new class_135();
            class_135 var1 = var10000;
            var1.field_445 = this.field_1566;
            if ((var2 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var2;
                System.arraycopy(this.field_1571, this.field_1570 + 1, var1.field_692 = new class_126[var2], 0, var2);
            }
            var1.field_691 = this.method_2836(0);
            var2 = this.field_1576[this.field_1575--];
            this.field_1577 -= var2;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_696 = new class_146[var2], 0, var2);
            --this.field_1587;
            var1.field_444 = this.field_1588[this.field_1587--];
            this.method_2867(var1);
        } else {
            this.method_2828(var2);
            class_114 var3 = (class_114)this.field_1560[this.field_1559];
            var3.field_593 = this.field_1567;
            var3.field_595 = this.field_1567;
            if (var2 == 0 && !this.method_2820(var3.field_594, var3.field_595)) {
                var3.field_446 |= 8;
            }
            --this.field_1559;
            --this.field_1557;
            class_136 var4 = var3.field_598;
            if (var4 != null) {
                var4.field_445 = this.field_1567;
                var2 = this.field_1576[this.field_1575--];
                this.field_1577 -= var2;
                System.arraycopy(this.field_1578, this.field_1577 + 1, var4.field_696 = new class_146[var2], 0, var2);
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
        this.method_2866(this.method_2836(0));
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
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_138 var10002 = new class_138(this.field_1571[this.field_1570], this.field_1571[this.field_1570 + 1], this.field_1571[this.field_1570 + 2]);
        var10000[var10001] = var10002;
    }

    protected void method_2589(int var1) {
        this.field_1587 -= 2;
        this.method_2867(this.method_2839());
        this.field_1570 -= 2;
        this.field_1568 -= 2;
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_138 var10002 = new class_138(this.field_1571[this.field_1570 + 2], this.field_1571[this.field_1570], this.field_1571[this.field_1570 + 1]);
        var10000[var10001] = var10002;
    }

    protected void method_2590() {
        --this.field_1587;
        --this.field_1587;
        --this.field_1612;
        class_105 var2 = null;
        class_98[] var3 = null;
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
            if (this.field_1560[this.field_1559 + 1] instanceof class_105) {
                System.arraycopy(this.field_1560, this.field_1559 + 2, var3 = new class_98[var1 - 1], 0, var1 - 1);
                var2 = (class_105)this.field_1560[this.field_1559 + 1];
            } else {
                System.arraycopy(this.field_1560, this.field_1559 + 1, var3 = new class_98[var1], 0, var1);
                var2 = class_158.method_1047();
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
                var2 = class_158.method_1047();
            }
        }
        class_94 var6 = (class_94)this.field_1560[this.field_1559];
        var6.field_493 = var2;
        var6.field_486 = var3;
        if (var2 != null && var6.field_493.field_445 == 0) {
            var6.field_493.field_445 = var6.field_445;
            var6.field_493.field_444 = var6.field_444;
        }
        if ((!this.field_1564 || this.field_1565 != 0) && var3 == null && (var2 == null || var2.method_831()) && !this.method_2820(var6.field_490, this.field_1566)) {
            var6.field_446 |= 8;
        }
        var6.field_491 = this.field_1566;
        var6.field_481 = this.method_2831(this.field_1567);
    }

    protected void method_2591() {
        class_93 var1 = (class_93)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_490 = this.field_1628.field_1231;
        }
        if (this.field_1562 != null) {
            if (this.field_1563 == 27) {
                var1.field_482 |= 16777216;
                var1.field_481 = this.field_1628.field_1231 - 1;
                var1.field_491 = this.field_1628.field_1231 - 1;
                if (this.field_1562.method_1845() == var1 && this.field_1562.field_1068 != null) {
                    this.field_1562 = this.field_1562.field_1068;
                }
            }
            this.field_1618 = true;
        }
    }

    protected void method_2592() {
        if (this.field_1562 != null && this.field_1593 == 43) {
            this.field_1590 = this.field_1628.field_1230;
            this.field_1618 = true;
        } else {
            class_94 var10000 = new class_94(this.field_1561.field_455);
            class_94 var1 = var10000;
            var1.field_479 = this.field_1585[this.field_1584];
            long var2 = this.field_1583[this.field_1584--];
            --this.field_1581;
            var1.field_480 = this.field_1588[this.field_1587--];
            var1.field_482 = this.field_1588[this.field_1587--];
            int var4;
            if ((var4 = this.field_1569[this.field_1568--]) != 0) {
                System.arraycopy(this.field_1571, (this.field_1570 -= var4) + 1, var1.field_483 = new class_164[var4], 0, var4);
            }
            var1.field_444 = (int)(var2 >>> 32);
            this.method_2866(var1);
            var1.field_445 = this.field_1597;
            var1.field_490 = this.field_1597 + 1;
            this.field_1595 = 0;
            if (this.field_1562 != null) {
                this.field_1590 = var1.field_490;
                if (this.field_1562 instanceof class_260 && this.field_1593 != 3 || var1.field_482 != 0) {
                    this.field_1562 = this.field_1562.method_1832(var1, 0);
                    this.field_1593 = -1;
                }
            }
        }
    }

    protected void method_2593() {
        if (this.field_1562 != null && this.field_1593 == 43) {
            this.field_1590 = this.field_1628.field_1230;
            this.field_1618 = true;
        } else {
            class_94 var10000 = new class_94(this.field_1561.field_455);
            class_94 var1 = var10000;
            var1.field_479 = this.field_1585[this.field_1584];
            long var2 = this.field_1583[this.field_1584--];
            --this.field_1581;
            int var4 = this.field_1576[this.field_1575--];
            this.field_1577 -= var4;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_494 = new class_123[var4], 0, var4);
            var1.field_480 = this.field_1588[this.field_1587--];
            var1.field_482 = this.field_1588[this.field_1587--];
            if ((var4 = this.field_1569[this.field_1568--]) != 0) {
                System.arraycopy(this.field_1571, (this.field_1570 -= var4) + 1, var1.field_483 = new class_164[var4], 0, var4);
            }
            var1.field_444 = (int)(var2 >>> 32);
            this.method_2866(var1);
            var1.field_445 = this.field_1597;
            var1.field_490 = this.field_1597 + 1;
            this.field_1595 = 0;
            if (this.field_1562 != null) {
                this.field_1590 = var1.field_490;
                if (this.field_1562 instanceof class_260 && this.field_1593 != 3 || var1.field_482 != 0) {
                    this.field_1562 = this.field_1562.method_1832(var1, 0);
                    this.field_1593 = -1;
                }
            }
        }
    }

    protected void method_2594() {
        class_108 var10001 = new class_108((class_126)null, this.field_1588[this.field_1587--], this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2595() {
        class_122 var10001 = new class_122((class_112)null, 0);
        this.method_2866(var10001);
    }

    protected void method_2596() {
        this.method_2524();
        this.method_2872(this.field_1599);
        this.method_2872(this.field_1600 >= 0 ? this.field_1600 : this.field_1628.field_1230);
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
        this.method_2867((class_126)null);
        if (this.field_1562 != null && this.field_1563 == 69) {
            this.field_1586 = true;
            ++this.field_1562.field_1069;
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
        class_121 var1 = (class_121)this.field_1560[this.field_1559];
        this.method_2872(var1.field_445);
        this.method_2868(0);
    }

    protected void method_2604() {
        this.method_2520(0);
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
        class_93 var1 = (class_93)this.field_1560[this.field_1559];
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
        if (this.field_1561.method_773()) {
            this.field_1561.field_450 = new class_114[1];
            class_114 var10000 = new class_114(this.field_1561.field_455);
            class_114 var1 = var10000;
            var1.field_580 = class_17.field_144;
            var1.field_577 = 512;
            this.field_1561.field_450[0] = var1;
        }
    }

    protected void method_2616() {
        this.method_2865(0);
    }

    protected void method_2617() {
        this.method_2520(0);
    }

    protected void method_2618() {
        char[] var1 = this.field_1628.field_1237;
        class_99 var10001;
        if (var1[this.field_1567] == 59) {
            var10001 = new class_99(this.field_1567, this.field_1567);
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
                if (var1[var6] == 92 && (var7 = ScannerHelper.method_3340(var1[this.field_1567 - 3])) <= 15 && var7 >= 0 && (var8 = ScannerHelper.method_3340(var1[this.field_1567 - 2])) <= 15 && var8 >= 0 && (var9 = ScannerHelper.method_3340(var1[this.field_1567 - 1])) <= 15 && var9 >= 0 && (var10 = ScannerHelper.method_3340(var1[this.field_1567])) <= 15 && var10 >= 0 && (char)(((var7 * 16 + var8) * 16 + var9) * 16 + var10) == 59) {
                    var10001 = new class_99(var6, this.field_1567);
                    this.method_2866(var10001);
                    return;
                }
            }
            var10001 = new class_99(this.field_1567, this.field_1567);
            this.method_2866(var10001);
        }
    }

    protected void method_2619() {
        this.method_2865(0);
    }

    protected void method_2620() {
        this.method_2865(0);
        if (!this.field_1622) {
            this.method_2862().method_1762(this.field_1566 + 1, this.field_1567);
        }
        this.method_2831(this.field_1567);
    }

    protected void method_2621(boolean var1) {
        char[] var3 = this.field_1585[this.field_1584];
        long var4 = this.field_1583[this.field_1584];
        class_124 var6 = this.method_2824(var3, (int)(var4 >>> 32), (int)var4);
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
        class_146 var2 = this.method_2836(this.field_1588[this.field_1587--] + var7);
        int var10;
        if ((var10 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var10) + 1, var6.field_658 = new class_164[var10], 0, var10);
        }
        if (var1) {
            var6.field_653 = var8;
            var6.field_656 = var9;
        } else {
            var6.field_653 = var2.field_444;
        }
        var6.field_660 = var2;
        class_102 var10000 = new class_102(var6, this.field_1588[this.field_1587--]);
        class_102 var11 = var10000;
        this.method_2866(var11);
        var11.field_445 = var6.field_652;
    }

    protected void method_2622() {
        class_102 var1 = (class_102)this.field_1560[this.field_1559];
        --this.field_1568;
        class_126 var2 = this.field_1571[this.field_1570--];
        var1.field_514 = var2;
        var1.field_445 = this.field_1598;
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1648(var1.field_512, var2);
        }
    }

    protected void method_2623() {
        --this.field_1557;
        class_98 var1 = (class_98)this.field_1560[this.field_1559--];
        class_102 var2 = (class_102)this.field_1560[this.field_1559];
        var2.field_515 = var1;
        if (var1 instanceof class_99) {
            var1.field_446 |= 1;
        }
        var2.field_445 = this.field_1567;
    }

    protected void method_2624() {
        class_146 var1 = this.method_2836(0);
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var2 = var10000;
        var2.field_580 = CharOperation.field_994;
        var2.field_446 |= 768;
        class_136 var5 = new class_136(var2);
        class_136 var3 = var5;
        this.method_2849();
        this.method_2866(var2);
        var3.field_445 = this.field_1598;
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var4;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var3.field_692 = new class_126[var4], 0, var4);
        }
        var3.field_691 = var1;
        var2.field_445 = var3.field_445;
        var2.field_444 = var2.field_592 = var3.field_691.field_444;
        var3.field_444 = this.field_1588[this.field_1587--];
        this.method_2867(var3);
        var2.field_594 = this.field_1628.field_1231;
        this.field_1595 = 0;
        this.field_1628.field_1245 = -1;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_594;
            this.field_1562 = this.field_1562.method_1838(var2, 0);
            if (!(this.field_1562 instanceof class_257)) {
                this.field_1563 = 0;
            } else {
                this.field_1586 = true;
                ++this.field_1562.field_1069;
            }
            this.field_1593 = -1;
        }
    }

    protected void method_2625() {}

    protected void method_2626() {
        if (this.field_1562 != null && this.field_1562 instanceof class_257) {
            class_257 var1 = (class_257)this.field_1562;
            var1.field_1114 = true;
        }
    }

    protected void method_2627() {
        if (this.field_1562 != null) {
            this.field_1586 = true;
            ++this.field_1562.field_1069;
        }
    }

    protected void method_2628() {
        char[] var1 = this.field_1585[this.field_1584];
        long var2 = this.field_1583[this.field_1584];
        int var4 = this.field_1588[this.field_1587--];
        boolean var6 = this.field_1601[this.field_1602] != 0;
        Object var5;
        if (var6) {
            var5 = this.method_2824(var1, (int)(var2 >>> 32), (int)var2);
        } else {
            var5 = this.method_2823(var1, (int)(var2 >>> 32), (int)var2);
        }
        --this.field_1584;
        --this.field_1581;
        int var8 = this.field_1632[this.field_1602];
        boolean var9 = false;
        class_146 var7;
        int var10;
        int var13;
        if (var8 == 0) {
            if (var6) {
                ((class_120)var5).field_653 = this.field_1588[this.field_1587--];
                ((class_120)var5).field_656 = this.field_1588[this.field_1587--];
                if ((var10 = this.field_1569[this.field_1568--]) != 0) {
                    System.arraycopy(this.field_1571, (this.field_1570 -= var10) + 1, ((class_120)var5).field_658 = new class_164[var10], 0, var10);
                }
                var7 = this.method_2836(var13 = this.field_1588[this.field_1587--]);
                if (((class_120)var5).field_653 == -1) {
                    ((class_120)var5).field_653 = var7.field_444;
                }
                this.method_2866(var7);
            } else {
                var7 = this.method_2836(var13 = this.field_1588[this.field_1587--]);
                this.method_2866(var7);
                ((class_120)var5).field_653 = this.field_1588[this.field_1587--];
                ((class_120)var5).field_656 = this.field_1588[this.field_1587--];
                if ((var10 = this.field_1569[this.field_1568--]) != 0) {
                    System.arraycopy(this.field_1571, (this.field_1570 -= var10) + 1, ((class_120)var5).field_658 = new class_164[var10], 0, var10);
                }
            }
        } else {
            var7 = (class_146)this.field_1560[this.field_1559 - var8];
            var13 = var7.method_1009();
            class_120 var15 = (class_120)this.field_1560[this.field_1559];
            ((class_120)var5).field_653 = var15.field_653;
            ((class_120)var5).field_656 = var15.field_656;
            class_164[] var11 = var15.field_658;
            if (var11 != null) {
                int var12 = var11.length;
                System.arraycopy(var11, 0, ((class_120)var5).field_658 = new class_164[var12], 0, var12);
            }
        }
        if (var4 == 0) {
            ((class_120)var5).field_660 = var7;
        } else {
            var10 = var13 + var4;
            ((class_120)var5).field_660 = this.method_2822(var7, var10);
        }
        ++this.field_1632[this.field_1602];
        this.method_2866((class_89)var5);
        if (this.field_1562 != null) {
            if (!(this.field_1562 instanceof class_260) && (this.field_1563 == 3 || Util.method_1324(((class_120)var5).field_660.field_444, this.field_1628.field_1256, 0, this.field_1628.field_1257) != Util.method_1324((int)(var2 >>> 32), this.field_1628.field_1256, 0, this.field_1628.field_1257))) {
                this.field_1590 = (int)(var2 >>> 32);
                this.field_1618 = true;
                return;
            }
            if (var6) {
                class_124 var14 = (class_124)this.field_1560[this.field_1559];
                this.field_1590 = var14.field_445 + 1;
                this.field_1562 = this.field_1562.method_1836(var14, 0);
            } else {
                class_121 var16 = (class_121)this.field_1560[this.field_1559];
                this.field_1590 = var16.field_445 + 1;
                this.field_1562 = this.field_1562.method_1834(var16, 0);
            }
            this.field_1593 = -1;
        }
    }

    protected void method_2629() {}

    protected void method_2630() {
        this.method_2529();
    }

    protected void method_2631() {
        if (this.field_1562 != null && (!(this.field_1562 instanceof class_260) && (!(this.field_1562 instanceof class_253) || ((class_253)this.field_1562).field_1073.field_660 != null) || this.field_1593 == 3)) {
            this.field_1590 = this.field_1628.field_1230;
            this.field_1618 = true;
        } else {
            long var1 = this.field_1583[this.field_1584];
            char[] var3 = this.field_1585[this.field_1584];
            int var4 = (int)var1;
            class_121 var5 = this.method_2823(var3, (int)(var1 >>> 32), var4);
            --this.field_1584;
            --this.field_1581;
            var5.field_657 = this.field_1588[this.field_1587--];
            var5.field_656 = this.field_1588[this.field_1587--];
            var5.field_653 = var5.field_657;
            if ((var5.field_446 & 1024) == 0 && (var5.field_446 & 256) == 0 && this.field_1561 != null && !CharOperation.method_1364(var5.field_659, this.field_1561.method_772())) {
                var5.field_446 |= 4096;
            }
            int var6;
            if ((var6 = this.field_1569[this.field_1568--]) != 0) {
                System.arraycopy(this.field_1571, (this.field_1570 -= var6) + 1, var5.field_658 = new class_164[var6], 0, var6);
            }
            this.method_2866(var5);
            if (this.field_1562 != null) {
                this.field_1590 = var5.field_445 + 1;
                this.field_1562 = this.field_1562.method_1834(var5, 0);
            }
        }
    }

    protected void method_2632() {
        class_121 var1 = (class_121)this.field_1560[this.field_1559];
        boolean var2 = this.field_1563 == 69;
        class_114 var3;
        int var4;
        if (var2) {
            class_114 var10000 = new class_114(this.field_1561.field_455);
            var3 = var10000;
            var3.field_580 = CharOperation.field_994;
            var3.field_446 |= 768;
            var4 = this.field_1628.field_1230;
            var3.field_592 = var4;
            var3.field_444 = var4;
            var3.field_445 = var4;
            var3.field_577 = 0;
            var3.field_594 = this.field_1628.field_1231;
            this.method_2849();
            this.method_2866(var3);
            class_136 var8 = new class_136(var3);
            class_136 var5 = var8;
            var5.field_698 = var1;
            int var6;
            if ((var6 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var6;
                System.arraycopy(this.field_1571, this.field_1570 + 1, var5.field_692 = new class_126[var6], 0, var6);
            }
            var1.field_655 = var5;
        } else {
            class_135 var9 = new class_135();
            class_135 var7 = var9;
            var7.field_698 = var1;
            if ((var4 = this.field_1569[this.field_1568--]) != 0) {
                this.field_1570 -= var4;
                System.arraycopy(this.field_1571, this.field_1570 + 1, var7.field_692 = new class_126[var4], 0, var4);
            }
            var1.field_655 = var7;
        }
        if (this.field_1562 != null) {
            if (var2) {
                var3 = (class_114)this.field_1560[this.field_1559];
                this.field_1562 = this.field_1562.method_1838(var3, 0);
                this.field_1590 = var3.field_594;
                this.field_1593 = -1;
                this.field_1563 = 0;
            } else {
                if (this.field_1563 == 27) {
                    class_260 var10 = this.method_2826();
                    if (var10 != null) {
                        var10.field_1137 = false;
                    }
                }
                this.field_1590 = this.field_1628.field_1230;
                this.field_1593 = -1;
                this.field_1618 = true;
            }
        }
    }

    protected void method_2633() {
        int var1 = this.field_1588[this.field_1587--];
        class_121 var2 = (class_121)this.field_1560[this.field_1559];
        var2.field_651 = var1;
        var2.field_652 = var1;
    }

    protected void method_2634() {
        this.method_2529();
    }

    protected void method_2635() {
        this.method_2828(this.field_1558[this.field_1557--]);
        class_114 var1 = (class_114)this.field_1560[this.field_1559--];
        --this.field_1557;
        var1.field_595 = this.field_1566;
        var1.field_593 = this.method_2831(this.field_1567);
        class_121 var2 = (class_121)this.field_1560[this.field_1559];
        var2.field_651 = this.field_1567;
        var2.field_652 = var1.field_593;
        --this.field_1587;
    }

    protected void method_2636() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2829(var1);
        }
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        boolean var3 = var2.method_850(this);
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
            var2.method_851(!this.field_1564 || var4, true);
        }
        if (this.field_1628.field_1226) {
            var2.field_446 |= 1;
        }
        var2.method_845();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.method_2820(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.method_2831(this.field_1567);
    }

    protected void method_2637() {}

    protected void method_2638() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_594 = this.field_1628.field_1231;
        }
        if (this.field_1562 != null) {
            this.field_1618 = true;
        }
        this.field_1628.field_1245 = -1;
    }

    protected void method_2639() {
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            this.method_2521();
        }
        long var2 = this.field_1583[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.field_580 = this.field_1585[this.field_1584--];
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
            System.arraycopy(this.field_1571, (this.field_1570 -= var4) + 1, var1.field_579 = new class_164[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1647(var1);
        }
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_594;
            this.field_1562 = this.field_1562.method_1838(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2640() {
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var1 = var10000;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_601 = new class_123[var2], 0, var2);
        this.method_2862().method_1653(var1);
        var1.field_594 = var1.field_601[var2 - 1].field_652 + 1;
        this.field_1596 = 0;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            this.method_2521();
        }
        long var3 = this.field_1583[this.field_1584];
        var1.field_445 = (int)var3;
        var1.field_444 = (int)(var3 >>> 32);
        var1.field_580 = this.field_1585[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 16384;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var2) + 1, var1.field_579 = new class_164[var2], 0, var2);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1647(var1);
        }
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_594;
            this.field_1562 = this.field_1562.method_1838(var1, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2641(int var1) {
        --this.field_1570;
        --this.field_1568;
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_142 var10002 = new class_142(this.field_1571[this.field_1570], this.field_1571[this.field_1570 + 1], var1);
        var10000[var10001] = var10002;
    }

    protected void method_2642(int var1) {
        this.method_2867(this.method_2839());
        --this.field_1570;
        --this.field_1568;
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_142 var10002 = new class_142(this.field_1571[this.field_1570 + 1], this.field_1571[this.field_1570], var1);
        var10000[var10001] = var10002;
    }

    protected void method_2643() {
        if (this.field_1562 != null && this.field_1562 instanceof class_257) {
            class_257 var1 = (class_257)this.field_1562;
            var1.field_1114 = false;
            var1.field_1115 = -1;
        }
    }

    protected void method_2644() {
        if (this.field_1562 != null) {
            this.field_1618 = true;
        }
    }

    protected void method_2645() {
        --this.field_1568;
        class_120 var1 = (class_120)this.field_1560[this.field_1559];
        var1.field_655 = this.field_1571[this.field_1570--];
        var1.field_652 = var1.field_655.field_445;
        var1.field_651 = var1.field_655.field_445;
        this.method_2875();
    }

    protected void method_2646() {
        class_120 var1 = (class_120)this.field_1560[this.field_1559];
        var1.field_652 = var1.field_651;
        if (this.field_1562 != null && this.field_1562 instanceof class_253 && this.field_1567 > var1.field_445) {
            this.field_1562.method_1857(this.field_1567);
        }
        this.method_2875();
    }

    protected void method_2647(int var1, int var2) {
        int var3 = this.field_1588[this.field_1587--];
        class_105 var10000 = new class_105(var2);
        class_105 var4 = var10000;
        int var5;
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var5;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var4.field_546 = new class_126[var5], 0, var5);
        }
        switch (var1) {
            case 0:
                var4.field_444 = var3;
                break;
            case 1:
                --this.field_1568;
                var4.field_444 = (var4.field_547 = this.field_1571[this.field_1570--]).field_444;
                break;
            case 2:
                var4.field_444 = (var4.field_547 = this.method_2839()).field_444;
        }
        this.method_2866(var4);
        var4.field_445 = this.field_1567;
    }

    protected void method_2648(int var1, int var2) {
        int var3 = this.field_1588[this.field_1587--];
        class_105 var10000 = new class_105(var2);
        class_105 var4 = var10000;
        int var5;
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var5;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var4.field_546 = new class_126[var5], 0, var5);
        }
        var5 = this.field_1576[this.field_1575--];
        this.field_1577 -= var5;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var4.field_552 = new class_146[var5], 0, var5);
        var4.field_554 = this.field_1588[this.field_1587--];
        switch (var1) {
            case 0:
                var4.field_444 = var3;
                break;
            case 1:
                --this.field_1568;
                var4.field_444 = (var4.field_547 = this.field_1571[this.field_1570--]).field_444;
                break;
            case 2:
                var4.field_444 = (var4.field_547 = this.method_2839()).field_444;
        }
        this.method_2866(var4);
        var4.field_445 = this.field_1567;
    }

    protected void method_2649() {
        --this.field_1568;
        class_126 var1 = this.field_1571[this.field_1570--];
        var1.field_673 = this.field_1567;
        this.method_2866(var1);
    }

    protected void method_2650(boolean var1) {
        class_155 var10000 = new class_155(this.field_1585[this.field_1584], this.field_1583[this.field_1584--]);
        class_155 var2 = var10000;
        --this.field_1581;
        if (var1) {
            var2.field_444 = this.field_1588[this.field_1587--];
            class_158 var10001 = new class_158(var2.field_444, this.field_1566);
            var2.field_736 = var10001;
            this.method_2867(var2);
        } else {
            var2.field_736 = this.field_1571[this.field_1570];
            var2.field_444 = var2.field_736.field_444;
            this.field_1571[this.field_1570] = var2;
        }
    }

    protected void method_2651() {
        int var1 = this.field_1558[this.field_1557];
        int var2;
        for (var2 = var1 - 1; var2 >= 0; --var2) {
            class_121 var3 = (class_121)this.field_1560[this.field_1559 - var2];
            var3.field_652 = this.field_1567;
            var3.field_651 = this.field_1567;
        }
        this.method_2884(var1);
        var2 = this.method_2831(this.field_1567);
        int var5;
        if (var2 != this.field_1567) {
            for (var5 = 0; var5 < var1; ++var5) {
                class_121 var4 = (class_121)this.field_1560[this.field_1559 - var5];
                var4.field_652 = var2;
            }
        }
        var5 = this.field_1559 - this.field_1632[this.field_1602] + 1;
        System.arraycopy(this.field_1560, var5, this.field_1560, var5 - 1, var1);
        --this.field_1559;
        this.field_1558[--this.field_1557] = var1;
        if (this.field_1562 != null) {
            this.field_1590 = var2 + 1;
            if (this.field_1562.field_1068 != null && this.field_1562 instanceof class_253 && !(this.field_1562 instanceof class_254)) {
                this.field_1562 = this.field_1562.field_1068;
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
        char[] var2 = this.field_1585[this.field_1584];
        long var3 = this.field_1583[this.field_1584--];
        int var5 = this.field_1588[this.field_1587--];
        int var6 = 0;
        if (var1) {
            var6 = this.field_1588[this.field_1587--];
        }
        int var7 = this.field_1588[this.field_1587--];
        int var8 = var7 + var5;
        class_146 var9 = this.method_2836(var8);
        if (var1) {
            var9 = this.method_2822(var9, var8 + 1);
            if (var5 == 0) {
                var9.field_445 = var6;
            }
            var9.field_446 |= 16384;
        }
        int var10 = this.field_1588[this.field_1587--];
        --this.field_1587;
        class_125 var10000 = new class_125(var2, var3, var9, this.field_1588[this.field_1587 + 1] & -1048577);
        class_125 var11 = var10000;
        var11.field_653 = var10;
        int var12;
        if ((var12 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var12) + 1, var11.field_658 = new class_164[var12], 0, var12);
        }
        this.method_2866(var11);
        ++this.field_1595;
        if (var1) {
            if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
                this.method_2862().method_1654(var11);
            } else if (!this.field_1622 && var5 > 0) {
                this.method_2862().method_1570(var11);
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
        class_91 var1 = (class_91)this.field_1560[this.field_1559];
        var1.field_469 = this.field_1567;
        var1.field_471 = this.method_2831(var1.field_471);
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1562 = this.field_1562.method_1835(var1, 0);
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
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_139 var10002 = new class_139(this.field_1571[this.field_1570], this.method_2836(this.field_1588[this.field_1587--]));
        class_139 var1 = var10002;
        var10000[var10001] = var10002;
        if (var1.field_445 == 0) {
            var1.field_445 = this.field_1628.field_1230 - 1;
        }
    }

    protected void method_2666() {
        class_146 var1 = this.method_2836(this.field_1588[this.field_1587--]);
        this.method_2867(this.method_2839());
        class_126[] var10000 = this.field_1571;
        int var10001 = this.field_1570;
        class_139 var10002 = new class_139(this.field_1571[this.field_1570], var1);
        class_139 var2 = var10002;
        var10000[var10001] = var10002;
        if (var2.field_445 == 0) {
            var2.field_445 = this.field_1628.field_1230 - 1;
        }
    }

    protected void method_2667() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.method_2828(var1);
        }
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        var2.method_850(this);
        if (this.field_1628.field_1226) {
            var2.field_446 |= 1;
        }
        var2.method_845();
        var2.field_595 = this.field_1567;
        if (var1 == 0 && !this.method_2820(var2.field_594, var2.field_595)) {
            var2.field_446 |= 8;
        }
        var2.field_593 = this.method_2831(this.field_1567);
    }

    protected void method_2668() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_594 = this.field_1628.field_1231;
        }
        if (this.field_1562 != null) {
            this.field_1618 = true;
        }
        this.field_1628.field_1245 = -1;
    }

    protected void method_2669() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        class_114 var2 = (class_114)this.field_1560[this.field_1559];
        System.arraycopy(this.field_1560, this.field_1559 + 1, var2.field_582 = new class_146[var1], 0, var1);
        int var3 = 0;
        for (int var4 = var2.field_582.length; var3 < var4; ++var3) {
            var2.field_582[var3].field_446 |= 16;
        }
        var2.field_594 = var2.field_582[var1 - 1].field_445 + 1;
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_594;
        }
    }

    protected void method_2670() {
        class_114 var10000 = new class_114(this.field_1561.field_455);
        class_114 var1 = var10000;
        if (this.field_1601[this.field_1602] == 0) {
            if (this.field_1602 != 0) {
                var1.field_446 |= 1024;
            }
        } else {
            var1.field_446 |= 256;
            this.method_2849();
            this.method_2521();
        }
        long var2 = this.field_1583[this.field_1584];
        var1.field_445 = (int)var2;
        var1.field_444 = (int)(var2 >>> 32);
        var1.field_580 = this.field_1585[this.field_1584--];
        --this.field_1581;
        var1.field_592 = this.field_1588[this.field_1587--];
        --this.field_1587;
        var1.field_578 = this.field_1588[this.field_1587--];
        var1.field_577 = this.field_1588[this.field_1587--] | 512;
        if (var1.field_578 >= 0) {
            var1.field_592 = var1.field_578;
        }
        if ((var1.field_446 & 1024) == 0 && (var1.field_446 & 256) == 0 && this.field_1561 != null && !CharOperation.method_1364(var1.field_580, this.field_1561.method_772())) {
            var1.field_446 |= 4096;
        }
        int var4;
        if ((var4 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var4) + 1, var1.field_579 = new class_164[var4], 0, var4);
        }
        var1.field_594 = var1.field_445 + 1;
        this.method_2866(var1);
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_594;
            this.field_1562 = this.field_1562.method_1838(var1, 0);
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
        this.method_2866(this.method_2836(0));
        ++this.field_1595;
    }

    protected void method_2674() {
        this.method_2853();
    }

    protected void method_2675() {
        if (this.field_1561.method_773()) {
            this.field_1561.field_450 = new class_114[1];
            class_114 var10000 = new class_114(this.field_1561.field_455);
            class_114 var1 = var10000;
            var1.field_580 = class_17.field_144;
            var1.field_577 = 512;
            this.field_1561.field_450[0] = var1;
        }
    }

    protected void method_2676() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            if (this.field_1561.method_773()) {
                this.field_1561.field_450 = new class_114[var1 + 1];
                this.field_1559 -= var1;
                System.arraycopy(this.field_1560, this.field_1559 + 1, this.field_1561.field_450, 1, var1);
                class_114 var10000 = new class_114(this.field_1561.field_455);
                class_114 var2 = var10000;
                var2.field_580 = class_17.field_144;
                var2.field_577 = 512;
                this.field_1561.field_450[0] = var2;
            } else {
                this.field_1561.field_450 = new class_114[var1];
                this.field_1559 -= var1;
                System.arraycopy(this.field_1560, this.field_1559 + 1, this.field_1561.field_450, 0, var1);
            }
        }
    }

    protected void method_2677() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        if (!this.field_1622) {
            this.method_2862().method_1573(var1);
        }
        --this.field_1559;
        this.method_2865(-1);
        this.method_2529();
    }

    protected void method_2678() {
        class_94 var1 = (class_94)this.field_1560[this.field_1559];
        var1.field_491 = this.field_1566;
        var1.field_481 = this.method_2831(this.field_1567);
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
        class_94 var3 = (class_94)this.field_1560[this.field_1559];
        var3.field_491 = this.field_1567;
        var3.field_481 = this.method_2831(this.field_1567);
        if (!var1) {
            var3.field_482 |= 16777216;
        }
    }

    protected void method_2680() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        if (!this.field_1622) {
            this.method_2862().method_1573(var1);
        }
        --this.field_1559;
        this.method_2865(-1);
        this.method_2529();
    }

    protected void method_2681() {
        class_114 var1 = (class_114)this.field_1560[this.field_1559];
        if (!this.field_1622) {
            this.method_2862().method_1573(var1);
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
        class_96 var2 = (class_96)this.field_1560[this.field_1559];
        var2.field_491 = this.field_1566;
        var2.field_481 = this.method_2831(this.field_1567);
        if (!this.field_1622) {
            this.method_2862().method_1464(var2);
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
            class_124 var3 = (class_124)this.field_1560[this.field_1559 - var2];
            var3.field_652 = this.field_1567;
            var3.field_651 = this.field_1567;
        }
    }

    protected void method_2687() {
        class_166 var1 = null;
        int var2 = this.field_1584;
        class_146 var3 = this.method_2832();
        class_166 var10000 = new class_166(var3, this.field_1588[this.field_1587--]);
        var1 = var10000;
        var1.field_765 = var1.field_445;
        this.method_2867(var1);
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1645(var1);
        }
        this.field_1634 = true;
        if (this.field_1562 != null && this.field_1562 instanceof class_257) {
            this.field_1562 = ((class_257)this.field_1562).method_1872(var1, var2);
        }
    }

    protected void method_2688() {
        this.method_2520(this.field_1569[this.field_1568--]);
    }

    protected void method_2689() {
        this.method_2867(this.method_2839());
    }

    protected void method_2690() {
        char[] var1 = this.field_1585[this.field_1584];
        long var2 = this.field_1583[this.field_1584--];
        --this.field_1581;
        int var4 = (int)var2;
        int var5 = (int)(var2 >>> 32);
        class_126 var6 = this.field_1571[this.field_1570--];
        --this.field_1568;
        class_92 var10000 = new class_92(var1, var5, var4, var6);
        class_92 var7 = var10000;
        this.method_2866(var7);
        if (this.field_1562 != null && this.field_1562 instanceof class_257) {
            class_257 var8 = (class_257)this.field_1562;
            var8.method_1873(1);
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
        class_98[] var4 = null;
        if (var1) {
            var3 = this.field_1613[this.field_1612--];
            int var2;
            if ((var2 = this.field_1558[this.field_1557--]) != 0) {
                System.arraycopy(this.field_1560, (this.field_1559 -= var2) + 1, var4 = new class_98[var2], 0, var2);
            }
        }
        class_96 var5 = (class_96)this.field_1560[this.field_1559];
        var5.field_486 = var4;
        var5.field_487 = var3;
        if (!var1) {
            var5.field_482 |= 16777216;
        } else if ((!this.field_1564 || this.field_1565 != 0) && var4 == null && !this.method_2820(var5.field_490, this.field_1566)) {
            var5.field_446 |= 8;
        }
        var5.field_491 = this.field_1566;
        var5.field_481 = this.method_2831(this.field_1567);
    }

    protected void method_2695() {
        class_93 var1 = (class_93)this.field_1560[this.field_1559];
        if (this.field_1563 == 69) {
            var1.field_490 = this.field_1628.field_1231;
        }
        if (this.field_1562 != null) {
            if (this.field_1563 == 27) {
                var1.field_482 |= 16777216;
                var1.field_481 = this.field_1628.field_1231 - 1;
                var1.field_491 = this.field_1628.field_1231 - 1;
                if (this.field_1562.method_1845() == var1 && this.field_1562.field_1068 != null) {
                    this.field_1562 = this.field_1562.field_1068;
                }
            } else if (this.field_1563 == 69 && this.field_1562 instanceof class_255 && ((class_255)this.field_1562).field_1088 != var1) {
                this.field_1586 = true;
                ++this.field_1562.field_1069;
            }
            this.field_1618 = true;
        }
    }

    protected void method_2696() {
        class_96 var1 = (class_96)this.field_1560[this.field_1559];
        int var2 = this.field_1569[this.field_1568--];
        if (var2 == 1) {
            --this.field_1587;
            --this.field_1587;
            if (var1.method_793()) {
                ((class_97)var1).field_499 = this.field_1571[this.field_1570];
                var1.field_482 |= 131072;
            }
            --this.field_1570;
            this.field_1634 = true;
        }
        if (this.field_1562 != null && var1.method_793()) {
            this.field_1562.method_1857(((class_97)var1).field_499.field_445);
        }
    }

    protected void method_2697() {
        class_96 var1 = (class_96)this.field_1560[this.field_1559];
        int var2 = this.field_1588[this.field_1587--];
        if (var1.method_793()) {
            ((class_97)var1).field_500 = var2;
        }
        if (var2 != 0) {
            class_146 var3 = var1.field_497;
            var1.field_445 = this.field_1566;
            int var4 = var3.method_1009() + var2;
            var1.field_497 = this.method_2822(var3, var4);
            if (this.field_1563 == 69) {
                var1.field_490 = this.field_1566 + 1;
            }
            if (this.field_1562 != null) {
                this.field_1590 = var1.field_490;
            }
        }
    }

    protected void method_2698(boolean var1) {
        Object var2 = null;
        if (var1) {
            class_97 var10000 = new class_97(this.field_1561.field_455);
            var2 = var10000;
            this.field_1634 = false;
        } else {
            class_96 var6 = new class_96(this.field_1561.field_455);
            var2 = var6;
        }
        ((class_96)var2).field_479 = this.field_1585[this.field_1584];
        long var3 = this.field_1583[this.field_1584--];
        --this.field_1581;
        ((class_96)var2).field_497 = this.method_2836(this.field_1588[this.field_1587--]);
        ((class_96)var2).field_480 = this.field_1588[this.field_1587--];
        ((class_96)var2).field_482 = this.field_1588[this.field_1587--];
        int var5;
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var5) + 1, ((class_96)var2).field_483 = new class_164[var5], 0, var5);
        }
        ((class_96)var2).field_444 = (int)(var3 >>> 32);
        this.method_2866((class_89)var2);
        ((class_96)var2).field_445 = this.field_1597;
        ((class_96)var2).field_490 = this.field_1597 + 1;
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            if (!(this.field_1562 instanceof class_260) && Util.method_1324(((class_96)var2).field_497.field_444, this.field_1628.field_1256, 0, this.field_1628.field_1257) != Util.method_1324(((class_96)var2).field_444, this.field_1628.field_1256, 0, this.field_1628.field_1257)) {
                this.field_1590 = ((class_96)var2).field_444;
                this.field_1618 = true;
            } else {
                this.field_1590 = ((class_96)var2).field_490;
                this.field_1562 = this.field_1562.method_1832((class_93)var2, 0);
                this.field_1593 = -1;
            }
        }
    }

    protected void method_2699(boolean var1) {
        Object var2 = null;
        if (var1) {
            class_97 var10000 = new class_97(this.field_1561.field_455);
            var2 = var10000;
            this.field_1634 = false;
        } else {
            class_96 var7 = new class_96(this.field_1561.field_455);
            var2 = var7;
        }
        ((class_96)var2).field_479 = this.field_1585[this.field_1584];
        long var3 = this.field_1583[this.field_1584--];
        --this.field_1581;
        ((class_96)var2).field_497 = this.method_2836(this.field_1588[this.field_1587--]);
        int var5 = this.field_1576[this.field_1575--];
        this.field_1577 -= var5;
        System.arraycopy(this.field_1578, this.field_1577 + 1, ((class_96)var2).field_498 = new class_123[var5], 0, var5);
        ((class_96)var2).field_480 = this.field_1588[this.field_1587--];
        ((class_96)var2).field_482 = this.field_1588[this.field_1587--];
        if ((var5 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var5) + 1, ((class_96)var2).field_483 = new class_164[var5], 0, var5);
        }
        ((class_96)var2).field_444 = (int)(var3 >>> 32);
        this.method_2866((class_89)var2);
        ((class_96)var2).field_445 = this.field_1597;
        ((class_96)var2).field_490 = this.field_1597 + 1;
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            boolean var6;
            if (!(var6 = this.field_1562 instanceof class_260) && Util.method_1324(((class_96)var2).field_497.field_444, this.field_1628.field_1256, 0, this.field_1628.field_1257) != Util.method_1324(((class_96)var2).field_444, this.field_1628.field_1256, 0, this.field_1628.field_1257)) {
                this.field_1590 = ((class_96)var2).field_444;
                this.field_1618 = true;
            } else {
                if (var6) {
                    ((class_260)this.field_1562).field_1138 = null;
                }
                this.field_1590 = ((class_96)var2).field_490;
                this.field_1562 = this.field_1562.method_1832((class_93)var2, 0);
                this.field_1593 = -1;
            }
        }
    }

    protected void method_2700() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        class_93 var2 = (class_93)this.field_1560[this.field_1559];
        var2.field_445 = this.field_1598;
        if (var1 != 0) {
            System.arraycopy(this.field_1560, this.field_1559 + 1, var2.field_484 = new class_125[var1], 0, var1);
        }
        var2.field_490 = this.field_1598 + 1;
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_490;
            if (this.field_1562.method_1845() == var2) {
                return;
            }
            if (var2.method_795() && (var1 != 0 || this.field_1563 == 69 || this.field_1563 == 105)) {
                this.field_1562 = this.field_1562.method_1832(var2, 0);
                this.field_1593 = -1;
            }
        }
    }

    protected void method_2701() {
        int var1 = this.field_1558[this.field_1557--];
        this.field_1559 -= var1;
        class_93 var2 = (class_93)this.field_1560[this.field_1559];
        System.arraycopy(this.field_1560, this.field_1559 + 1, var2.field_485 = new class_146[var1], 0, var1);
        var2.field_445 = var2.field_485[var1 - 1].field_445;
        var2.field_490 = var2.field_485[var1 - 1].field_445 + 1;
        this.field_1595 = 0;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_490;
        }
    }

    protected void method_2702() {
        class_168 var1 = this.method_2851();
        var1.field_445 = this.field_1598;
        var1.field_444 = (int)((var1.field_779 = this.field_1583[this.field_1584]) >>> 32);
        var1.field_773 = this.field_1585[this.field_1584--];
        if (this.field_1582[this.field_1581] == 1) {
            var1.field_772 = class_157.method_1044();
            --this.field_1581;
        } else {
            --this.field_1582[this.field_1581];
            var1.field_772 = this.method_2838();
            var1.field_444 = var1.field_772.field_444;
        }
        this.method_2867(var1);
    }

    protected void method_2703() {
        class_168 var1 = this.method_2852();
        var1.field_445 = this.field_1598;
        var1.field_444 = (int)((var1.field_779 = this.field_1583[this.field_1584]) >>> 32);
        var1.field_773 = this.field_1585[this.field_1584--];
        --this.field_1581;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_783 = new class_146[var2], 0, var2);
        --this.field_1587;
        var1.field_772 = this.method_2838();
        var1.field_444 = var1.field_772.field_444;
        this.method_2867(var1);
    }

    protected void method_2704() {
        class_168 var1 = this.method_2851();
        var1.field_444 = (int)((var1.field_779 = this.field_1583[this.field_1584]) >>> 32);
        var1.field_773 = this.field_1585[this.field_1584--];
        --this.field_1581;
        var1.field_772 = this.field_1571[this.field_1570];
        var1.field_444 = var1.field_772.field_444;
        var1.field_445 = this.field_1598;
        this.field_1571[this.field_1570] = var1;
    }

    protected void method_2705() {
        class_168 var1 = this.method_2852();
        var1.field_444 = (int)((var1.field_779 = this.field_1583[this.field_1584]) >>> 32);
        var1.field_773 = this.field_1585[this.field_1584--];
        --this.field_1581;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_783 = new class_146[var2], 0, var2);
        --this.field_1587;
        var1.field_772 = this.field_1571[this.field_1570];
        var1.field_444 = var1.field_772.field_444;
        var1.field_445 = this.field_1598;
        this.field_1571[this.field_1570] = var1;
    }

    protected void method_2706() {
        class_168 var1 = this.method_2851();
        var1.field_444 = this.field_1588[this.field_1587--];
        var1.field_445 = this.field_1598;
        var1.field_779 = this.field_1583[this.field_1584];
        var1.field_773 = this.field_1585[this.field_1584--];
        --this.field_1581;
        class_158 var10001 = new class_158(var1.field_444, this.field_1566);
        var1.field_772 = var10001;
        this.method_2867(var1);
    }

    protected void method_2707() {
        class_168 var1 = this.method_2852();
        --this.field_1587;
        var1.field_445 = this.field_1598;
        var1.field_779 = this.field_1583[this.field_1584];
        var1.field_773 = this.field_1585[this.field_1584--];
        --this.field_1581;
        int var2 = this.field_1576[this.field_1575--];
        this.field_1577 -= var2;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var1.field_783 = new class_146[var2], 0, var2);
        var1.field_444 = this.field_1588[this.field_1587--];
        class_158 var10001 = new class_158(var1.field_444, this.field_1566);
        var1.field_772 = var10001;
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
        this.method_2872(this.field_1628.field_1231);
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
        class_167 var1 = null;
        int var2 = this.field_1584;
        class_146 var3 = this.method_2832();
        class_167 var10000 = new class_167(var3, this.field_1588[this.field_1587--]);
        var1 = var10000;
        int var4;
        if ((var4 = this.field_1558[this.field_1557--]) != 0) {
            System.arraycopy(this.field_1560, (this.field_1559 -= var4) + 1, var1.field_771 = new class_92[var4], 0, var4);
        }
        var1.field_765 = this.field_1598;
        this.method_2867(var1);
        if (this.field_1562 != null) {
            this.method_2519(var1.field_444, var1.field_765);
            if (this.field_1562 instanceof class_257) {
                this.field_1562 = ((class_257)this.field_1562).method_1872(var1, var2);
            }
        }
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1645(var1);
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
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            int var1 = this.field_1576[this.field_1575];
            this.method_2862().method_1650((class_146)this.field_1578[this.field_1577 - var1 + 1], (class_146)this.field_1578[this.field_1577]);
        }
    }

    protected void method_2717() {}

    protected void method_2718() {
        this.method_2872(this.field_1628.field_1230);
        int var1 = this.field_1613.length;
        if (++this.field_1612 >= var1) {
            System.arraycopy(this.field_1613, 0, this.field_1613 = new int[var1 + 255], 0, var1);
        }
        this.field_1613[this.field_1612] = 0;
    }

    protected void method_2719() {
        if (this.field_1607.field_1928 >= 3211264L) {
            this.method_2524();
            this.method_2879();
        }
    }

    protected void method_2720() {
        class_91 var1 = this.field_1561.field_448;
        var1.field_469 = this.field_1567;
        var1.field_471 = this.method_2831(var1.field_471);
    }

    protected void method_2721() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.field_1585, ++this.field_1584, var3, 0, var2);
        System.arraycopy(this.field_1583, this.field_1584--, var4, 0, var2);
        class_91 var10000 = new class_91(var3, var4, true, 0);
        class_91 var1 = var10000;
        this.field_1561.field_448 = var1;
        if (this.field_1563 == 27) {
            var1.field_471 = this.field_1628.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1618 = true;
        }
    }

    protected void method_2722() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.field_1585, ++this.field_1584, var3, 0, var2);
        System.arraycopy(this.field_1583, this.field_1584--, var4, 0, var2);
        int var5 = this.field_1588[this.field_1587--];
        int var6 = this.field_1588[this.field_1587--];
        class_91 var10000 = new class_91(var3, var4, true, var6);
        class_91 var1 = var10000;
        this.field_1561.field_448 = var1;
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            System.arraycopy(this.field_1571, (this.field_1570 -= var2) + 1, var1.field_473 = new class_164[var2], 0, var2);
            var1.field_470 = var5;
            --this.field_1587;
        } else {
            var1.field_470 = this.field_1588[this.field_1587--];
        }
        if (this.field_1563 == 27) {
            var1.field_471 = this.field_1628.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1618 = true;
        }
    }

    protected void method_2723() {
        this.method_2867(this.method_2839());
    }

    protected void method_2724() {
        class_126 var1 = this.field_1571[this.field_1570];
        this.method_2885(var1);
        int var2 = (var1.field_446 & 534773760) >> 21;
        var1.field_446 &= -534773761;
        var1.field_446 |= var2 + 1 << 21;
    }

    protected void method_2725() {
        --this.field_1587;
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        class_129 var10001 = new class_129(this.field_1588[this.field_1587--], this.method_2836(this.field_1588[this.field_1587--]));
        this.method_2867(var10001);
    }

    protected void method_2726() {
        --this.field_1587;
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        class_146 var1 = this.method_2836(0);
        class_129 var10001 = new class_129(this.field_1588[this.field_1587--], var1);
        this.method_2867(var10001);
    }

    protected void method_2727() {
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        class_146 var1 = this.method_2836(0);
        class_160 var10001 = new class_160(var1, this.field_1588[this.field_1587--], this.field_1566);
        this.method_2867(var10001);
    }

    protected void method_2728() {
        this.method_2870(this.field_1582[this.field_1581]);
        this.method_2871(0);
        class_146 var1 = this.method_2836(0);
        class_159 var10001 = new class_159(var1, this.field_1588[this.field_1587--], this.field_1566);
        this.method_2867(var10001);
    }

    protected void method_2729() {
        --this.field_1587;
        class_129 var10001 = new class_129(this.field_1588[this.field_1587--], this.method_2836(this.field_1588[this.field_1587--]));
        this.method_2867(var10001);
    }

    protected void method_2730() {
        --this.field_1587;
        class_129 var10001 = new class_129(this.field_1588[this.field_1587--], this.method_2836(0));
        this.method_2867(var10001);
    }

    protected void method_2731() {
        class_157 var10001 = new class_157(this.field_1588[this.field_1587--], this.field_1566);
        this.method_2867(var10001);
    }

    protected void method_2732() {
        this.method_2867(this.method_2839());
        class_126 var1 = this.field_1571[this.field_1570];
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
        if (this.field_1562 instanceof class_260) {
            var1 = (((class_260)this.field_1562).field_1124.field_577 & 8192) != 0;
        } else {
            class_260 var2 = this.field_1562.method_1843();
            if (var2 != null) {
                var1 = (var2.field_1124.field_577 & 8192) != 0;
            }
        }
        this.method_2698(var1);
    }

    protected void method_2742() {
        boolean var1 = false;
        if (this.field_1562 instanceof class_260) {
            var1 = (((class_260)this.field_1562).field_1124.field_577 & 8192) != 0;
        } else {
            class_260 var2 = this.field_1562.method_1843();
            if (var2 != null) {
                var1 = (var2.field_1124.field_577 & 8192) != 0;
            }
        }
        this.method_2699(var1);
    }

    protected void method_2743() {
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, this.field_1561.field_449 = new class_91[var1], 0, var1);
        }
    }

    protected void method_2744() {
        this.method_2872(0);
    }

    protected void method_2745() {
        this.method_2869(this.method_2836(this.field_1588[this.field_1587--]));
    }

    protected void method_2746() {
        this.method_2869(this.method_2836(this.field_1588[this.field_1587--]));
    }

    protected void method_2747() {
        this.method_2869(this.method_2836(this.field_1588[this.field_1587--]));
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
                this.method_2801(14, true);
                break;
            case 388:
                this.method_2801(13, true);
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
                this.method_2801(14, false);
                break;
            case 396:
                this.method_2801(13, false);
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
        class_106 var10001 = new class_106(this.field_1571[this.field_1570--], this.field_1588[this.field_1587--]);
        this.method_2866(var10001);
    }

    protected void method_2752() {
        class_165 var1 = null;
        int var2 = this.field_1584;
        class_146 var3 = this.method_2832();
        class_165 var10000 = new class_165(var3, this.field_1588[this.field_1587--]);
        var1 = var10000;
        var1.field_769 = this.field_1571[this.field_1570--];
        --this.field_1568;
        var1.field_765 = this.field_1598;
        this.method_2867(var1);
        if (this.field_1562 != null) {
            this.method_2519(var1.field_444, var1.field_765);
            if (this.field_1562 instanceof class_257) {
                this.field_1562 = ((class_257)this.field_1562).method_1872(var1, var2);
            }
        }
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            this.method_2862().method_1645(var1);
        }
        this.field_1634 = true;
    }

    protected void method_2753() {
        if (this.field_1562 != null && this.field_1562 instanceof class_257) {
            class_257 var1 = (class_257)this.field_1562;
            var1.method_1873(2);
        }
    }

    protected void method_2754() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.field_1585, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.field_1583, this.field_1584 + 1, var4, 0, var2);
        class_91 var10001 = new class_91(var3, var4, false, 8);
        class_91 var1 = var10001;
        this.method_2866(var10001);
        this.field_1599 = 0;
        this.field_1600 = -1;
        if (this.field_1563 == 27) {
            var1.field_471 = this.field_1628.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            var1.field_472 = 0;
            this.method_2862().method_1649(var1);
        }
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1562 = this.field_1562.method_1835(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2755() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.field_1585, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.field_1583, this.field_1584 + 1, var4, 0, var2);
        class_91 var10001 = new class_91(var3, var4, false, 0);
        class_91 var1 = var10001;
        this.method_2866(var10001);
        if (this.field_1563 == 27) {
            var1.field_471 = this.field_1628.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1562 = this.field_1562.method_1835(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2756() {
        class_111 var10001 = new class_111((char[])null, this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
        if (this.field_1626 != null) {
            if (this.field_1626.field_598 == null && this.field_1566 <= this.field_1626.field_593) {
                this.field_1560[this.field_1559] = this.field_1626;
                this.field_1626 = null;
                return;
            }
            this.field_1626 = null;
        }
    }

    protected void method_2757() {
        class_111 var10001 = new class_111(this.field_1585[this.field_1584--], this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
        --this.field_1581;
    }

    protected void method_2758() {
        --this.field_1557;
        this.field_1595 = 0;
    }

    protected void method_2759() {
        class_110 var10001 = new class_110((char[])null, this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
    }

    protected void method_2760() {
        class_110 var10001 = new class_110(this.field_1585[this.field_1584--], this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
        --this.field_1581;
    }

    protected void method_2761() {
        --this.field_1587;
        class_98 var1 = (class_98)this.field_1560[this.field_1559];
        --this.field_1568;
        class_89[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        class_100 var10002 = new class_100(this.field_1571[this.field_1570--], var1, this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2762() {
        this.method_2527();
    }

    protected void method_2763() {
        class_126 var2 = null;
        boolean var5 = true;
        --this.field_1557;
        class_98 var6 = (class_98)this.field_1560[this.field_1559--];
        int var1;
        class_98[] var4;
        if ((var1 = this.field_1569[this.field_1568--]) == 0) {
            var4 = null;
        } else {
            this.field_1570 -= var1;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var4 = new class_98[var1], 0, var1);
        }
        if (this.field_1569[this.field_1568--] != 0) {
            var2 = this.field_1571[this.field_1570--];
        }
        class_98[] var3;
        if ((var1 = this.field_1558[this.field_1557--]) == 0) {
            var3 = null;
            var5 = false;
        } else if (var1 == -1) {
            var5 = false;
            var1 = this.field_1569[this.field_1568--];
            this.field_1570 -= var1;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var3 = new class_98[var1], 0, var1);
        } else {
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, var3 = new class_98[var1], 0, var1);
        }
        class_103 var7 = new class_103(var3, var2, var4, var6, var5, this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var7);
    }

    protected void method_2764() {
        --this.field_1568;
        class_98 var1 = (class_98)this.field_1560[this.field_1559];
        class_89[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        class_101 var10002 = new class_101(this.field_1571[this.field_1570--], var1, this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2765() {
        --this.field_1568;
        --this.field_1557;
        class_89[] var10000 = this.field_1560;
        int var10001 = --this.field_1559;
        class_101 var10002 = new class_101(this.field_1571[this.field_1570--], (class_98)this.field_1560[this.field_1559], (class_98)this.field_1560[this.field_1559 + 1], this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2766() {
        class_98 var1 = (class_98)this.field_1560[this.field_1559];
        class_89[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        class_104 var10002 = new class_104(this.field_1585[this.field_1584], var1, this.field_1583[this.field_1584--], this.field_1567);
        var10000[var10001] = var10002;
        --this.field_1581;
    }

    protected void method_2767() {
        class_119 var1;
        if (this.field_1569[this.field_1568--] != 0) {
            var1 = new class_119(this.field_1571[this.field_1570--], this.field_1588[this.field_1587--], this.field_1567);
            this.method_2866(var1);
        } else {
            var1 = new class_119((class_126)null, this.field_1588[this.field_1587--], this.field_1567);
            this.method_2866(var1);
        }
    }

    protected void method_2768() {
        class_115 var10000 = new class_115();
        class_115 var2 = var10000;
        --this.field_1568;
        var2.field_602 = this.field_1571[this.field_1570--];
        int var1;
        if ((var1 = this.field_1558[this.field_1557--]) != 0) {
            this.field_1559 -= var1;
            System.arraycopy(this.field_1560, this.field_1559 + 1, var2.field_603 = new class_98[var1], 0, var1);
        }
        var2.field_605 = this.field_1613[this.field_1612--];
        this.method_2866(var2);
        var2.field_609 = this.field_1588[this.field_1587--];
        var2.field_444 = this.field_1588[this.field_1587--];
        var2.field_445 = this.field_1567;
        if (var1 == 0 && !this.method_2820(var2.field_609, var2.field_445)) {
            var2.field_446 |= 8;
        }
    }

    protected void method_2769() {
        int var10001;
        class_89[] var10000;
        class_118 var10002;
        if (this.field_1558[this.field_1557] == 0) {
            this.field_1558[this.field_1557] = 1;
            --this.field_1568;
            var10000 = this.field_1560;
            var10001 = ++this.field_1559;
            var10002 = new class_118(this.field_1571[this.field_1570--], (class_112)null, this.field_1588[this.field_1587--], this.field_1567);
            var10000[var10001] = var10002;
        } else {
            --this.field_1568;
            var10000 = this.field_1560;
            var10001 = this.field_1559;
            var10002 = new class_118(this.field_1571[this.field_1570--], (class_112)this.field_1560[this.field_1559], this.field_1588[this.field_1587--], this.field_1567);
            var10000[var10001] = var10002;
        }
        this.method_2879();
    }

    protected void method_2770() {
        --this.field_1568;
        class_113 var10001 = new class_113(this.field_1571[this.field_1570--], this.field_1588[this.field_1587--], this.field_1567);
        this.method_2866(var10001);
    }

    protected void method_2771(boolean var1) {
        class_117 var10000 = new class_117();
        class_117 var3 = var10000;
        if (var1) {
            --this.field_1557;
            var3.field_622 = (class_112)this.field_1560[this.field_1559--];
        }
        int var2;
        if ((var2 = this.field_1558[this.field_1557--]) != 0) {
            if (var2 == 1) {
                var3.field_620 = new class_112[] {(class_112)this.field_1560[this.field_1559--]};
                var3.field_621 = new class_125[] {(class_125)this.field_1560[this.field_1559--]};
            } else {
                class_112[] var4 = var3.field_620 = new class_112[var2];
                for (class_125[] var5 = var3.field_621 = new class_125[var2]; var2-- > 0; var5[var2] = (class_125)this.field_1560[this.field_1559--]) {
                    var4[var2] = (class_112)this.field_1560[this.field_1559--];
                }
            }
        }
        --this.field_1557;
        var3.field_619 = (class_112)this.field_1560[this.field_1559--];
        var3.field_445 = this.field_1567;
        var3.field_444 = this.field_1588[this.field_1587--];
        this.method_2866(var3);
    }

    protected void method_2772() {
        --this.field_1568;
        class_98 var1 = (class_98)this.field_1560[this.field_1559];
        class_89[] var10000 = this.field_1560;
        int var10001 = this.field_1559;
        class_107 var10002 = new class_107(this.field_1571[this.field_1570--], var1, this.field_1588[this.field_1587--], this.field_1567);
        var10000[var10001] = var10002;
    }

    protected void method_2773() {
        int var2;
        char[][] var3 = new char[var2 = this.field_1582[this.field_1581--]][];
        this.field_1584 -= var2;
        long[] var4 = new long[var2];
        System.arraycopy(this.field_1585, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.field_1583, this.field_1584 + 1, var4, 0, var2);
        class_91 var10001 = new class_91(var3, var4, true, 8);
        class_91 var1 = var10001;
        this.method_2866(var10001);
        this.field_1599 = 0;
        this.field_1600 = -1;
        if (this.field_1563 == 27) {
            var1.field_471 = this.field_1628.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            var1.field_472 = 0;
            this.method_2862().method_1649(var1);
        }
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1562 = this.field_1562.method_1835(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2774() {
        class_112 var1 = (class_112)this.field_1560[this.field_1559];
        if (this.field_1564) {
            var1.field_446 &= -9;
        }
        class_122 var10000 = new class_122(var1, 8);
        class_122 var2 = var10000;
        this.field_1560[this.field_1559] = var2;
        var2.field_445 = this.field_1567;
        var2.field_652 = this.method_2831(this.field_1567);
        --this.field_1601[this.field_1602];
        var2.field_653 = this.field_1588[this.field_1587--];
        var2.field_666 = this.field_1588[this.field_1587--];
        var2.field_667 = this.field_1566;
        if (this.field_1562 != null) {
            this.field_1590 = var2.field_652;
            this.field_1562 = this.field_1562.method_1834(var2, 0);
            this.field_1593 = -1;
        }
    }

    protected void method_2775() {
        int var1 = this.field_1600;
        this.method_2524();
        if (this.field_1600 >= var1) {
            this.field_1600 = var1;
        }
        this.method_2872(this.field_1628.field_1231);
        this.method_2872(this.field_1600 >= 0 ? this.field_1600 : this.field_1628.field_1230);
        this.method_2847();
        ++this.field_1601[this.field_1602];
        this.method_2879();
        --this.field_1568;
        if (this.field_1562 != null) {
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
                this.method_2872(this.field_1628.field_1230);
                break;
            case 8:
            case 9:
                this.field_1566 = this.field_1628.field_1230;
                this.field_1567 = this.field_1628.field_1231 - 1;
                break;
            case 23:
                this.method_2872(this.field_1628.field_1230);
                this.method_2872(this.field_1628.field_1231 - 1);
                break;
            case 26:
                this.method_2863();
                long var10;
                if (this.field_1628.field_1225 && this.field_1592 < this.field_1628.field_1231) {
                    var10 = this.field_1583[this.field_1584];
                    if (!this.field_1622) {
                        this.method_2862().method_1817((int)(var10 >>> 32), (int)var10);
                    }
                }
                if (this.field_1628.field_1227 && this.field_1592 < this.field_1628.field_1231) {
                    var10 = this.field_1583[this.field_1584];
                    if (!this.field_1622) {
                        this.method_2862().method_1818((int)(var10 >>> 32), (int)var10);
                    }
                }
                break;
            case 27:
            case 31:
                this.field_1567 = this.field_1628.field_1231 - 1;
                this.field_1566 = this.field_1628.field_1230 - 1;
                break;
            case 28:
                this.field_1597 = this.field_1628.field_1230;
                break;
            case 29:
                this.field_1598 = this.field_1628.field_1231 - 1;
                break;
            case 32:
                this.method_2864(-5);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 33:
                this.method_2864(-3);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 34:
                this.method_2864(-2);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 35:
                this.method_2864(-8);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 36:
                this.method_2864(-9);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 37:
                this.method_2864(-10);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 38:
                this.method_2864(-7);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 39:
                this.method_2864(-4);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 40:
                this.method_2864(-6);
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 41:
            case 42:
                this.field_1566 = this.field_1628.field_1231 - 1;
                this.method_2872(this.field_1628.field_1230);
                break;
            case 43:
                this.method_2879();
                this.method_2872(this.field_1628.field_1230);
                break;
            case 44:
                class_174 var5 = new class_174(this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var5);
                break;
            case 45:
                class_176 var4 = new class_176(this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var4);
                break;
            case 46:
                class_175 var7 = new class_175(this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var7);
                break;
            case 47:
                class_180 var6 = new class_180(this.field_1628.method_2409(), this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var6);
                break;
            case 48:
                class_183 var9 = new class_183(this.field_1628.method_2409(), this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var9);
                break;
            case 49:
                class_179 var8 = new class_179(this.field_1628.method_2409(), this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var8);
                break;
            case 50:
                class_178 var11 = new class_178(this.field_1628.method_2409(), this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var11);
                break;
            case 51:
                class_182 var10001 = new class_182(this.field_1628.method_2409(), this.field_1628.field_1230, this.field_1628.field_1231 - 1);
                this.method_2867(var10001);
                break;
            case 52:
                class_170 var2;
                if (this.field_1634 && this.field_1633 && this.field_1620 < this.field_1628.field_1231 && !this.field_1622) {
                    var2 = this.method_2825(this.field_1628.method_2410(), this.field_1628.field_1230, this.field_1628.field_1231 - 1, Util.method_1324(this.field_1628.field_1230, this.field_1628.field_1256, 0, this.field_1628.field_1257));
                    this.field_1561.method_775(var2, this.field_1562 != null);
                } else {
                    var2 = this.method_2825(this.field_1628.method_2410(), this.field_1628.field_1230, this.field_1628.field_1231 - 1, 0);
                }
                this.method_2867(var2);
                break;
            case 53:
                this.method_2872(this.field_1628.field_1230);
                break;
            case 54:
                this.method_2523(8);
                this.method_2868(0);
                break;
            case 55:
                this.field_1631 = this.field_1628.field_1230;
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
                this.field_1567 = this.field_1628.field_1231 - 1;
            case 1:
            case 2:
            case 66:
            case 67:
                this.field_1566 = this.field_1628.field_1230;
                break;
            case 70:
                this.field_1566 = this.field_1628.field_1230;
                this.field_1567 = this.field_1628.field_1231 - 1;
                break;
            case 71:
                if (this.field_1562 != null && this.field_1562 instanceof class_257) {
                    class_257 var3 = (class_257)this.field_1562;
                    if (var3.field_1115 == -1) {
                        var3.field_1115 = this.field_1628.field_1231 - 1;
                    }
                }
                break;
            case 72:
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
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
                this.method_2872(this.field_1628.field_1230);
                break;
            case 95:
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 97:
                this.method_2872(this.field_1628.field_1230);
                this.method_2872(this.field_1628.field_1231 - 1);
                break;
            case 98:
                this.method_2872(this.field_1628.field_1231 - 1);
                this.method_2872(this.field_1628.field_1230);
                break;
            case 107:
                this.method_2872(this.field_1628.field_1231 - 1);
        }
    }

    protected void method_2781() {
        this.method_2869(this.method_2836(this.field_1588[this.field_1587--]));
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
        this.method_2869(this.method_2836(0));
        --this.field_1587;
    }

    protected void method_2787() {
        this.method_2528();
        this.method_2869(this.method_2836(0));
        --this.field_1587;
    }

    protected void method_2788() {
        this.method_2528();
        --this.field_1587;
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            int var1 = this.field_1576[this.field_1575];
            this.method_2862().method_1650((class_146)this.field_1578[this.field_1577 - var1 + 1], (class_146)this.field_1578[this.field_1577]);
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
        System.arraycopy(this.field_1585, this.field_1584 + 1, var3, 0, var2);
        System.arraycopy(this.field_1583, this.field_1584 + 1, var4, 0, var2);
        class_91 var10001 = new class_91(var3, var4, true, 0);
        class_91 var1 = var10001;
        this.method_2866(var10001);
        if (this.field_1563 == 27) {
            var1.field_471 = this.field_1628.field_1231 - 1;
        } else {
            var1.field_471 = var1.field_445;
        }
        var1.field_469 = var1.field_471;
        var1.field_470 = this.field_1588[this.field_1587--];
        if (this.field_1562 != null) {
            this.field_1590 = var1.field_471 + 1;
            this.field_1562 = this.field_1562.method_1835(var1, 0);
            this.field_1593 = -1;
            this.field_1618 = true;
        }
    }

    protected void method_2791() {
        class_123 var10000 = new class_123();
        class_123 var1 = var10000;
        long var2 = this.field_1583[this.field_1584];
        int var4 = (int)var2;
        var1.field_652 = var4;
        var1.field_445 = var4;
        int var5 = (int)(var2 >>> 32);
        var1.field_653 = var5;
        var1.field_444 = var5;
        var1.field_659 = this.field_1585[this.field_1584--];
        --this.field_1581;
        this.method_2869(var1);
        ++this.field_1596;
    }

    protected void method_2792() {}

    protected void method_2793() {
        class_146 var1 = (class_146)this.field_1578[this.field_1577--];
        --this.field_1575;
        class_123 var2 = (class_123)this.field_1578[this.field_1577];
        var2.field_652 = var1.field_445;
        var2.field_660 = var1;
        var1.field_446 |= 16;
        this.field_1578[this.field_1577] = var2;
    }

    protected void method_2794() {
        int var1 = this.field_1576[this.field_1575--];
        class_146[] var2 = new class_146[var1];
        this.field_1577 -= var1;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var2, 0, var1);
        class_146 var3 = this.method_2836(this.field_1588[this.field_1587--]);
        class_123 var4 = (class_123)this.field_1578[this.field_1577];
        var4.field_652 = var2[var1 - 1].field_445;
        var4.field_660 = var3;
        var3.field_446 |= 16;
        var4.field_669 = var2;
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
        if (this.field_1562 != null && this.field_1562 instanceof class_260) {
            class_260 var2 = (class_260)this.field_1562;
            int var3 = this.field_1576[this.field_1575];
            class_123[] var4 = new class_123[var3];
            System.arraycopy(this.field_1578, this.field_1577 - var3 + 1, var4, 0, var3);
            var2.method_1880(var4, var1);
        }
        if (!this.field_1622 && this.field_1607.field_1928 < 3211264L && this.field_1592 < this.field_1628.field_1231) {
            int var5 = this.field_1576[this.field_1575];
            this.method_2862().method_1651((class_123)this.field_1578[this.field_1577 - var5 + 1], (class_123)this.field_1578[this.field_1577]);
        }
    }

    protected void method_2798() {
        class_146 var1 = this.method_2836(this.field_1588[this.field_1587--]);
        class_123 var2 = (class_123)this.field_1578[this.field_1577];
        var2.field_652 = var1.field_445;
        var2.field_660 = var1;
        var1.field_446 |= 16;
    }

    protected void method_2799() {
        int var1 = this.field_1576[this.field_1575--];
        class_146[] var2 = new class_146[var1];
        this.field_1577 -= var1;
        System.arraycopy(this.field_1578, this.field_1577 + 1, var2, 0, var1);
        class_146 var3 = this.method_2836(this.field_1588[this.field_1587--]);
        class_123 var4 = (class_123)this.field_1578[this.field_1577];
        var4.field_660 = var3;
        var3.field_446 |= 16;
        var4.field_669 = var2;
        var4.field_652 = var2[var1 - 1].field_445;
        int var5 = 0;
        for (int var6 = var2.length; var5 < var6; ++var5) {
            var2[var5].field_446 |= 16;
        }
    }

    protected void method_2800(int var1) {
        class_126 var3 = this.field_1571[this.field_1570];
        Object var2;
        int var10001;
        class_126[] var10000;
        class_140 var10002;
        if (var1 == 13) {
            if (var3 instanceof class_180 && ((class_180)var3).method_1093()) {
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_181 var5 = new class_181();
                var2 = var10000[var10001] = var5;
            } else if (var3 instanceof class_183 && ((class_183)var3).method_1095()) {
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_184 var4 = new class_184();
                var2 = var10000[var10001] = var4;
            } else {
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                var10002 = new class_140(var3, var1);
                var2 = var10000[var10001] = var10002;
            }
        } else {
            var10000 = this.field_1571;
            var10001 = this.field_1570;
            var10002 = new class_140(var3, var1);
            var2 = var10000[var10001] = var10002;
        }
        ((class_126)var2).field_444 = this.field_1588[this.field_1587--];
        ((class_126)var2).field_445 = var3.field_445;
    }

    protected void method_2801(int var1, boolean var2) {
        class_126 var3 = this.field_1571[this.field_1570];
        if (var3 instanceof class_154) {
            int var10001;
            class_126[] var10000;
            if (var2) {
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_133 var10002 = new class_133(var3, class_180.field_797, var1, this.field_1567);
                var10000[var10001] = var10002;
            } else {
                var10000 = this.field_1571;
                var10001 = this.field_1570;
                class_134 var4 = new class_134(var3, class_180.field_797, var1, this.field_1588[this.field_1587--]);
                var10000[var10001] = var4;
            }
        } else {
            if (!var2) {
                --this.field_1587;
            }
            if (!this.field_1622) {
                this.method_2862().method_1644(var3);
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
        class_148 var10000 = new class_148(0);
        class_148 var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2805() {
        class_148 var10000 = new class_148(0);
        class_148 var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2806() {}

    protected void method_2807() {
        class_148 var10000 = new class_148(0);
        class_148 var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2808() {}

    protected void method_2809() {
        class_148 var10000 = new class_148(0);
        class_148 var1 = var10000;
        var1.field_445 = this.field_1588[this.field_1587--];
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2810() {}

    protected void method_2811() {
        class_148 var10000 = new class_148(1);
        class_148 var1 = var10000;
        var1.field_727 = (class_146)this.field_1578[this.field_1577];
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2812() {
        class_148 var10000 = new class_148(2);
        class_148 var1 = var10000;
        var1.field_727 = (class_146)this.field_1578[this.field_1577];
        --this.field_1587;
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2813() {
        class_148 var10000 = new class_148(1);
        class_148 var1 = var10000;
        var1.field_727 = (class_146)this.field_1578[this.field_1577];
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2814() {
        class_148 var10000 = new class_148(2);
        class_148 var1 = var10000;
        var1.field_727 = (class_146)this.field_1578[this.field_1577];
        --this.field_1587;
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2815() {
        class_148 var10000 = new class_148(1);
        class_148 var1 = var10000;
        var1.field_727 = (class_146)this.field_1578[this.field_1577];
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2816() {
        class_148 var10000 = new class_148(2);
        class_148 var1 = var10000;
        var1.field_727 = (class_146)this.field_1578[this.field_1577];
        --this.field_1587;
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.field_1578[this.field_1577] = var1;
    }

    protected void method_2817() {
        class_148 var10000 = new class_148(1);
        class_148 var1 = var10000;
        var1.field_727 = this.method_2836(this.field_1588[this.field_1587--]);
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2818() {
        class_148 var10000 = new class_148(2);
        class_148 var1 = var10000;
        var1.field_727 = this.method_2836(this.field_1588[this.field_1587--]);
        --this.field_1587;
        var1.field_445 = var1.field_727.field_445;
        --this.field_1587;
        var1.field_444 = this.field_1588[this.field_1587--];
        this.method_2869(var1);
    }

    protected void method_2819() {}

    public boolean method_2820(int var1, int var2) {
        for (int var3 = this.field_1628.field_1245; var3 >= 0; --var3) {
            int var4 = this.field_1628.field_1243[var3];
            if (var4 >= var1 && var4 <= var2) {
                return true;
            }
        }
        return false;
    }

    public class_96 method_2821(class_94 var1, class_284 var2) {
        class_96 var10000 = new class_96(var2);
        class_96 var3 = var10000;
        var3.field_498 = var1.field_494;
        var3.field_444 = var1.field_444;
        var3.field_445 = var1.field_445;
        var3.field_490 = var1.field_490;
        var3.field_491 = var1.field_491;
        var3.field_481 = var1.field_481;
        var3.field_480 = var1.field_480;
        var3.field_479 = var1.field_479;
        var3.field_486 = var1.field_486;
        var3.field_482 = var1.field_482;
        var3.field_483 = var1.field_483;
        var3.field_484 = var1.field_484;
        var3.field_485 = var1.field_485;
        var3.field_487 = var1.field_487;
        var3.field_497 = null;
        return var3;
    }

    protected class_146 method_2822(class_146 var1, int var2) {
        return var1.method_1008(var2);
    }

    protected class_121 method_2823(char[] var1, int var2, int var3) {
        class_121 var10000 = new class_121(var1, var2, var3);
        return var10000;
    }

    protected class_124 method_2824(char[] var1, int var2, int var3) {
        class_124 var10000 = new class_124(var1, var2, var3);
        return var10000;
    }

    protected class_170 method_2825(char[] var1, int var2, int var3, int var4) {
        class_170 var10000 = new class_170(var1, var2, var3, var4);
        return var10000;
    }

    protected class_260 method_2826() {
        return this.field_1562 != null ? (this.field_1562 instanceof class_260 ? (class_260)this.field_1562 : this.field_1562.method_1843()) : null;
    }

    public class_90 method_2827(class_19 var1, class_284 var2) {
        boolean var4 = this.field_1564;
        class_90 var3;
        try {
            this.field_1564 = true;
            var3 = this.method_2856(var1, var2);
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
                class_89 var8 = this.field_1560[this.field_1559--];
                if (var8 instanceof class_93) {
                    var2[var7] = 2;
                    ++var4;
                    if (((class_93)var8).method_792()) {
                        var6 = true;
                    }
                } else if (var8 instanceof class_114) {
                    var2[var7] = 3;
                    ++var5;
                } else {
                    var2[var7] = 1;
                    ++var3;
                }
            }
            class_114 var12 = (class_114)this.field_1560[this.field_1559];
            if (var3 != 0) {
                var12.field_583 = new class_121[var3];
            }
            if (var4 != 0) {
                var12.field_584 = new class_93[var4];
                if (var6) {
                    var12.field_446 |= 2048;
                }
            }
            if (var5 != 0) {
                var12.field_585 = new class_114[var5];
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
                            System.arraycopy(this.field_1560, this.field_1559 + var9 + 1, var12.field_583, var3 - var10, var10);
                            break;
                        case 2:
                            var4 += var10 = var11 - var9;
                            System.arraycopy(this.field_1560, this.field_1559 + var9 + 1, var12.field_584, var4 - var10, var10);
                            break;
                        case 3:
                            var5 += var10 = var11 - var9;
                            System.arraycopy(this.field_1560, this.field_1559 + var9 + 1, var12.field_585, var5 - var10, var10);
                    }
                    var9 = var11;
                    var13 = var2[var11];
                }
            }
            if (var12.field_585 != null) {
                for (var11 = var12.field_585.length - 1; var11 >= 0; --var11) {
                    var12.field_585[var11].field_599 = var12;
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
            class_114 var6 = (class_114)this.field_1560[this.field_1559 - var1];
            boolean var7 = false;
            int var8;
            for (var8 = var1 - 1; var8 >= 0; --var8) {
                class_89 var9 = this.field_1560[this.field_1559--];
                if (var9 instanceof class_93) {
                    var2[var8] = 2;
                    ++var4;
                    if (((class_93)var9).method_792()) {
                        var7 = true;
                    }
                } else if (var9 instanceof class_114) {
                    var2[var8] = 3;
                    ++var5;
                } else if (var9 instanceof class_121) {
                    var2[var8] = 1;
                    ++var3;
                }
            }
            if (var3 != 0) {
                var6.field_583 = new class_121[var3];
            }
            if (var4 != 0) {
                var6.field_584 = new class_93[var4];
                if (var7) {
                    var6.field_446 |= 2048;
                }
            }
            if (var5 != 0) {
                var6.field_585 = new class_114[var5];
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
                            System.arraycopy(this.field_1560, this.field_1559 + var12 + 1, var6.field_583, var3 - var10, var10);
                            break;
                        case 2:
                            var4 += var10 = var11 - var12;
                            System.arraycopy(this.field_1560, this.field_1559 + var12 + 1, var6.field_584, var4 - var10, var10);
                            break;
                        case 3:
                            var5 += var10 = var11 - var12;
                            System.arraycopy(this.field_1560, this.field_1559 + var12 + 1, var6.field_585, var5 - var10, var10);
                    }
                    var12 = var11;
                    var8 = var2[var11];
                }
            }
            if (var6.field_585 != null) {
                for (var11 = var6.field_585.length - 1; var11 >= 0; --var11) {
                    var6.field_585[var11].field_599 = var6;
                }
            }
        }
    }

    protected class_90 method_2830(int var1) {
        this.field_1589 = var1;
        if (this.field_1622) {
            class_251 var2 = this.method_2522();
            if (var2 != null) {
                var2.method_1849().method_1855();
            }
            if (this.field_1579) {
                this.method_2880();
            }
        } else if (this.field_1562 != null) {
            if (field_1556) {
                eclipse.instance.method_744(class_329.field_1885);
                eclipse.instance.print("--------------------------");
                eclipse.instance.print(this.field_1561);
                eclipse.instance.print("----------------------------------");
            }
            this.field_1562.method_1849().method_1855();
        } else if (this.field_1564 & field_1556) {
            eclipse.instance.method_744(class_329.field_1886);
            eclipse.instance.print("--------------------------");
            eclipse.instance.print(this.field_1561);
            eclipse.instance.print("----------------------------------");
        }
        this.method_2861();
        for (int var3 = 0; var3 < this.field_1628.field_1251; ++var3) {
            if (!this.field_1622) {
                this.method_2862().method_1767(new String(this.field_1628.field_1247[var3]), new String(this.field_1628.field_1248[var3]), this.field_1628.field_1249[var3] == null ? null : new String(this.field_1628.field_1249[var3]), this.field_1628.field_1250[var3][0], this.field_1628.field_1250[var3][1]);
            }
        }
        return this.field_1561;
    }

    public int method_2831(int var1) {
        int var2 = this.field_1628.field_1245;
        if (var2 < 0) {
            return var1;
        } else {
            int var3 = var2;
            int var4;
            int var5;
            for (var4 = 0; var3 >= 0; ++var4) {
                var5 = this.field_1628.field_1242[var3];
                if (var5 < 0) {
                    var5 = -var5;
                }
                if (var5 <= var1) {
                    break;
                }
                --var3;
            }
            if (var4 > 0) {
                var5 = -this.field_1628.field_1242[var3 + 1];
                if (var5 > 0) {
                    --var5;
                    if (Util.method_1324(var1, this.field_1628.field_1256, 0, this.field_1628.field_1257) == Util.method_1324(var5, this.field_1628.field_1256, 0, this.field_1628.field_1257)) {
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
                        this.field_1628.field_1243[0] = this.field_1628.field_1243[var3 + 1];
                        this.field_1628.field_1242[0] = this.field_1628.field_1242[var3 + 1];
                        this.field_1628.field_1244[0] = this.field_1628.field_1244[var3 + 1];
                        break;
                    case 2:
                        this.field_1628.field_1243[0] = this.field_1628.field_1243[var3 + 1];
                        this.field_1628.field_1242[0] = this.field_1628.field_1242[var3 + 1];
                        this.field_1628.field_1244[0] = this.field_1628.field_1244[var3 + 1];
                        this.field_1628.field_1243[1] = this.field_1628.field_1243[var3 + 2];
                        this.field_1628.field_1242[1] = this.field_1628.field_1242[var3 + 2];
                        this.field_1628.field_1244[1] = this.field_1628.field_1244[var3 + 2];
                        break;
                    default:
                        System.arraycopy(this.field_1628.field_1243, var3 + 1, this.field_1628.field_1243, 0, var4);
                        System.arraycopy(this.field_1628.field_1242, var3 + 1, this.field_1628.field_1242, 0, var4);
                        System.arraycopy(this.field_1628.field_1244, var3 + 1, this.field_1628.field_1244, 0, var4);
                }
                this.field_1628.field_1245 = var4 - 1;
                return var1;
            }
        }
    }

    protected class_146 method_2832() {
        int var1 = this.field_1582[this.field_1581--];
        if (var1 == 1) {
            class_147 var4 = new class_147(this.field_1585[this.field_1584], this.field_1583[this.field_1584--]);
            return var4;
        } else {
            char[][] var2 = new char[var1][];
            this.field_1584 -= var1;
            long[] var3 = new long[var1];
            System.arraycopy(this.field_1585, this.field_1584 + 1, var2, 0, var1);
            System.arraycopy(this.field_1583, this.field_1584 + 1, var3, 0, var1);
            class_151 var10000 = new class_151(var2, var3);
            return var10000;
        }
    }

    public int method_2833() {
        return this.field_1572;
    }

    public void method_2834(class_90 var1) {
        if (var1 != null) {
            if (var1.field_452) {
                var1.field_451 = true;
            } else if ((var1.field_446 & 16) == 0) {
                int[] var2 = this.field_1628.field_1256;
                int var3 = this.field_1628.field_1257;
                class_284 var4 = var1.field_455;
                char[] var5 = this.field_1636 != null ? this.field_1636.method_2910(var4.field_1677) : var4.field_1677.method_51();
                this.field_1628.method_2441(var5, var4);
                if (var1.field_450 != null) {
                    int var6 = 0;
                    for (int var7 = var1.field_450.length; var6 < var7; ++var6) {
                        var1.field_450[var6].method_863(this, var1);
                    }
                }
                var1.field_446 |= 16;
                this.field_1628.field_1256 = var2;
                this.field_1628.field_1257 = var3;
            }
        }
    }

    protected class_126 method_2835(class_126 var1) {
        var1.field_446 &= -8;
        var1.field_446 |= 4;
        return var1;
    }

    protected class_146 method_2836(int var1) {
        int var3 = this.field_1582[this.field_1581--];
        Object var2;
        if (var3 < 0) {
            var2 = class_146.method_1005(-var3, var1);
            ((class_146)var2).field_444 = this.field_1588[this.field_1587--];
            if (var1 == 0) {
                ((class_146)var2).field_445 = this.field_1588[this.field_1587--];
            } else {
                --this.field_1587;
                ((class_146)var2).field_445 = this.field_1566;
            }
        } else {
            int var4 = this.field_1574[this.field_1573--];
            if (var3 == var4 && this.field_1576[this.field_1575] == 0) {
                if (var3 == 1) {
                    --this.field_1575;
                    if (var1 == 0) {
                        class_147 var10000 = new class_147(this.field_1585[this.field_1584], this.field_1583[this.field_1584--]);
                        var2 = var10000;
                    } else {
                        class_149 var8 = new class_149(this.field_1585[this.field_1584], var1, this.field_1583[this.field_1584--]);
                        var2 = var8;
                        ((class_146)var2).field_445 = this.field_1566;
                    }
                } else {
                    --this.field_1575;
                    char[][] var5 = new char[var3][];
                    this.field_1584 -= var3;
                    long[] var6 = new long[var3];
                    System.arraycopy(this.field_1585, this.field_1584 + 1, var5, 0, var3);
                    System.arraycopy(this.field_1583, this.field_1584 + 1, var6, 0, var3);
                    if (var1 == 0) {
                        class_151 var9 = new class_151(var5, var6);
                        var2 = var9;
                    } else {
                        class_152 var7 = new class_152(var5, var1, var6);
                        var2 = var7;
                        ((class_146)var2).field_445 = this.field_1566;
                    }
                }
            } else {
                var2 = this.method_2837(var1, var3, var4);
            }
        }
        return (class_146)var2;
    }

    protected class_146 method_2837(int var1, int var2, int var3) {
        if (var2 == 1 && var3 == 1) {
            int var11 = this.field_1576[this.field_1575--];
            class_146[] var12 = new class_146[var11];
            this.field_1577 -= var11;
            System.arraycopy(this.field_1578, this.field_1577 + 1, var12, 0, var11);
            class_150 var10 = new class_150(this.field_1585[this.field_1584], var12, var1, this.field_1583[this.field_1584--]);
            class_150 var13 = var10;
            if (var1 != 0) {
                var13.field_445 = this.field_1567;
            }
            return var13;
        } else {
            class_146[][] var4 = new class_146[var3][];
            char[][] var5 = new char[var3][];
            long[] var6 = new long[var3];
            int var7 = var3;
            int var8 = var2;
            while (var7 > 0) {
                int var9 = this.field_1576[this.field_1575--];
                if (var9 != 0) {
                    this.field_1577 -= var9;
                    System.arraycopy(this.field_1578, this.field_1577 + 1, var4[var7 - 1] = new class_146[var9], 0, var9);
                }
                switch (var8) {
                    case 1:
                        var5[var7 - 1] = this.field_1585[this.field_1584];
                        var6[var7 - 1] = this.field_1583[this.field_1584--];
                        break;
                    default:
                        this.field_1584 -= var8;
                        System.arraycopy(this.field_1585, this.field_1584 + 1, var5, var7 - var8, var8);
                        System.arraycopy(this.field_1583, this.field_1584 + 1, var6, var7 - var8, var8);
                }
                var7 -= var8;
                if (var7 > 0) {
                    var8 = this.field_1582[this.field_1581--];
                }
            }
            class_153 var10000 = new class_153(var5, var4, var1, var6);
            class_153 var14 = var10000;
            if (var1 != 0) {
                var14.field_445 = this.field_1567;
            }
            return var14;
        }
    }

    protected class_161 method_2838() {
        int var1;
        Object var2;
        if ((var1 = this.field_1582[this.field_1581--]) == 1) {
            class_162 var10000 = new class_162(this.field_1585[this.field_1584], this.field_1583[this.field_1584--]);
            var2 = var10000;
        } else {
            char[][] var3 = new char[var1][];
            this.field_1584 -= var1;
            System.arraycopy(this.field_1585, this.field_1584 + 1, var3, 0, var1);
            long[] var4 = new long[var1];
            System.arraycopy(this.field_1583, this.field_1584 + 1, var4, 0, var1);
            class_163 var5 = new class_163(var3, var4, (int)(this.field_1583[this.field_1584 + 1] >> 32), (int)this.field_1583[this.field_1584 + var1]);
            var2 = var5;
        }
        return (class_161)var2;
    }

    protected class_161 method_2839() {
        int var1;
        if ((var1 = this.field_1582[this.field_1581--]) == 1) {
            class_162 var6 = new class_162(this.field_1585[this.field_1584], this.field_1583[this.field_1584--]);
            class_162 var5 = var6;
            var5.field_446 &= -8;
            var5.field_446 |= 3;
            return var5;
        } else {
            char[][] var3 = new char[var1][];
            this.field_1584 -= var1;
            System.arraycopy(this.field_1585, this.field_1584 + 1, var3, 0, var1);
            long[] var4 = new long[var1];
            System.arraycopy(this.field_1583, this.field_1584 + 1, var4, 0, var1);
            class_163 var10000 = new class_163(var3, var4, (int)(this.field_1583[this.field_1584 + 1] >> 32), (int)this.field_1583[this.field_1584 + var1]);
            class_163 var2 = var10000;
            var2.field_446 &= -8;
            var2.field_446 |= 3;
            return var2;
        }
    }

    public void method_2840() {
        this.field_1572 = 67;
        this.field_1628.field_1228 = false;
    }

    public void method_2841() {
        this.field_1572 = 8;
        this.field_1628.field_1251 = 0;
        this.field_1628.field_1228 = true;
    }

    public void method_2842() {
        class_260 var1 = this.method_2826();
        if (var1 != null && var1.field_1137) {
            this.field_1572 = 66;
        } else {
            this.field_1572 = 11;
        }
        this.field_1628.field_1228 = true;
    }

    protected void method_2843() {
        --this.field_1587;
        class_128 var1 = (class_128)this.field_1571[this.field_1570--];
        --this.field_1568;
        if (!this.field_1622) {
            this.method_2862().method_1480(var1.field_444, var1.field_445);
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
        this.field_1561 = null;
        this.field_1615 = null;
        this.field_1567 = 0;
        int var2 = this.field_1560.length;
        if (this.field_1604.length < var2) {
            this.field_1604 = new class_89[var2];
        }
        System.arraycopy(this.field_1604, 0, this.field_1560, 0, var2);
        int var3 = this.field_1571.length;
        if (this.field_1605.length < var3) {
            this.field_1605 = new class_126[var3];
        }
        System.arraycopy(this.field_1605, 0, this.field_1571, 0, var3);
        this.field_1628.field_1245 = -1;
        this.field_1628.field_1251 = 0;
        this.field_1628.field_1233 = Integer.MAX_VALUE;
        this.field_1634 = true;
        boolean var4 = this.field_1607.method_3313(256L) != -1;
        this.field_1633 = var4;
        this.field_1628.field_1292 = var1 && var4;
        this.field_1628.field_1293 = -1;
        this.method_2879();
        this.field_1590 = -1;
        this.field_1562 = null;
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
        Scanner var10001 = new Scanner(false, false, false, this.field_1607.field_1928, this.field_1607.field_1927, this.field_1607.field_1936, this.field_1607.field_1937, this.field_1607.field_1938);
        this.field_1628 = var10001;
    }

    public void method_2847() {
        if (this.field_1564 && this.field_1565 == 0) {
            this.field_1628.field_1255 = true;
        }
    }

    private void method_2848() {
        if (this.field_1623 != null && this.field_1625 > -1 && this.field_1625 < this.field_1628.field_1231) {
            class_114 var1 = this.field_1623[this.field_1624];
            boolean var2 = var1.field_598 != null;
            this.field_1628.field_1230 = var1.field_593 + 1;
            this.field_1628.field_1231 = var1.field_593 + 1;
            this.field_1628.field_1255 = false;
            if (!var2) {
                ((RecoveryScanner)this.field_1628).method_2454(new int[] {27, 75});
            } else {
                ((RecoveryScanner)this.field_1628).method_2454(new int[] {26, 71, 26});
            }
            this.field_1626 = var1;
            try {
                this.field_1563 = this.field_1628.method_2419();
            } catch (InvalidInputException var4) {
                ;
            }
            if (++this.field_1624 < this.field_1623.length) {
                class_114 var3 = this.field_1623[this.field_1624];
                this.field_1625 = var3.field_598 == null ? var3.field_592 : var3.field_598.field_444;
            } else {
                this.field_1625 = Integer.MAX_VALUE;
            }
        }
    }

    protected void method_2849() {
        if (this.field_1562 == null) {
            for (int var1 = this.field_1559; var1 >= 0; --var1) {
                class_89 var2 = this.field_1560[var1];
                if (var2 instanceof class_93 || var2 instanceof class_121 || var2 instanceof class_114 && ((class_114)var2).field_593 == 0) {
                    var2.field_446 |= 2;
                    return;
                }
            }
            if (this.field_1615 instanceof class_93 || this.field_1615 instanceof class_114) {
                ((class_89)this.field_1615).field_446 |= 2;
            }
        }
    }

    protected boolean method_2850() {
        int var1 = this.field_1590;
        this.field_1628.field_1230 = var1;
        this.field_1628.field_1231 = var1;
        this.field_1628.field_1255 = false;
        if (this.field_1618) {
            this.field_1593 = -1;
            this.field_1628.field_1300 = true;
            return true;
        } else {
            this.field_1593 = this.field_1594;
            this.field_1594 = -1;
            do {
                try {
                    this.field_1594 = this.field_1628.method_2419();
                    if (this.field_1628.field_1231 == this.field_1628.field_1230) {
                        ++this.field_1628.field_1231;
                        this.field_1594 = -1;
                    }
                } catch (InvalidInputException var3) {
                    var1 = this.field_1628.field_1231;
                }
            } while (this.field_1594 < 0);
            if (this.field_1594 == 68 && this.field_1563 == 68) {
                return false;
            } else {
                this.field_1590 = this.field_1628.field_1231;
                this.field_1628.field_1230 = var1;
                this.field_1628.field_1231 = var1;
                this.field_1628.field_1245 = -1;
                this.field_1628.field_1251 = 0;
                return true;
            }
        }
    }

    protected class_168 method_2851() {
        class_168 var10000 = new class_168();
        class_168 var1 = var10000;
        int var2;
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var2;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var1.field_774 = new class_126[var2], 0, var2);
        }
        return var1;
    }

    protected class_168 method_2852() {
        class_168 var10000 = new class_168();
        class_168 var1 = var10000;
        int var2;
        if ((var2 = this.field_1569[this.field_1568--]) != 0) {
            this.field_1570 -= var2;
            System.arraycopy(this.field_1571, this.field_1570 + 1, var1.field_774 = new class_126[var2], 0, var2);
        }
        return var1;
    }

    protected void method_2853() {
        ++this.field_1558[--this.field_1557];
    }

    protected void method_2854() {
        boolean var1 = this.field_1564;
        int var2 = this.method_2833();
        this.field_1579 = false;
        this.field_1580 = false;
        int var3 = 731;
        this.field_1630 = -1;
        this.field_1563 = this.method_2833();
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
                        if (this.field_1562 != null) {
                            var10 = this.field_1634;
                            this.field_1634 = false;
                            this.method_2876();
                            this.field_1634 = var10;
                        }
                        try {
                            this.field_1563 = this.field_1628.method_2419();
                        } catch (InvalidInputException var8) {
                            if (!this.field_1580) {
                                this.method_2862().method_1753(this, var8.getMessage());
                                this.field_1580 = true;
                            }
                            this.field_1590 = this.field_1628.field_1231;
                            this.field_1618 = true;
                        }
                        if (this.field_1622) {
                            this.method_2848();
                        }
                        continue;
                    }
                    this.method_2780(this.field_1563);
                    if (this.field_1562 != null) {
                        var10 = this.field_1634;
                        this.field_1634 = false;
                        this.method_2876();
                        this.field_1634 = var10;
                    }
                    try {
                        this.field_1563 = this.field_1628.method_2419();
                    } catch (InvalidInputException var7) {
                        if (!this.field_1580) {
                            this.method_2862().method_1753(this, var7.getMessage());
                            this.field_1580 = true;
                        }
                        this.field_1590 = this.field_1628.field_1231;
                        this.field_1618 = true;
                    }
                    if (this.field_1622) {
                        this.method_2848();
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
                int var5 = this.field_1628.field_1231 - 1;
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
                this.field_1563 = this.method_2833();
            }
        }
        this.method_2830(var3);
        class_279[] var9 = this.field_1628.method_2421();
        if (var9 != null) {
            this.field_1561.field_459 = var9;
        }
        this.field_1628.field_1292 = false;
        if (this.field_1617 && this.field_1579 && !this.field_1622) {
            if (!this.field_1607.field_1962) {
                this.method_2877(var1, var2);
            } else {
                class_267 var11 = this.field_1615.method_94().field_1685;
                if (this.field_1627 == null) {
                    RecoveryScanner var10001 = new RecoveryScanner(this.field_1628, var11);
                    this.field_1627 = var10001;
                } else {
                    this.field_1627.method_2453(var11);
                }
                this.field_1627.method_2440(this.field_1628.field_1237);
                this.field_1627.field_1256 = this.field_1628.field_1256;
                this.field_1627.field_1257 = this.field_1628.field_1257;
                this.method_2877(var1, var2);
                if (var11 == null) {
                    this.field_1615.method_94().field_1685 = this.field_1627.method_2452();
                }
                if (this.field_1621 && this.field_1607.field_1962) {
                    this.field_1621 = false;
                    this.method_2874();
                    this.field_1621 = true;
                    this.field_1589 = 12828;
                }
            }
        }
    }

    public void method_2855(class_94 var1, class_90 var2, boolean var3) {
        boolean var4 = this.field_1621;
        if (this.field_1607.field_1961) {
            this.field_1621 = true;
        }
        this.method_2844();
        this.method_2840();
        if (var3) {
            this.field_1628.field_1228 = true;
        }
        ++this.field_1601[this.field_1602];
        this.method_2873(0);
        this.field_1615 = var1;
        this.field_1561 = var2;
        this.field_1628.method_2435(var1.field_490, var1.field_491);
        try {
            this.method_2854();
        } catch (class_241 var9) {
            this.field_1589 = 12828;
        } finally {
            --this.field_1601[this.field_1602];
            if (this.field_1607.field_1962) {
                this.field_1621 = var4;
            }
        }
        this.method_2525(var1.field_481);
        if (this.field_1589 == 12828) {
            this.method_2844();
        } else {
            var1.field_487 = this.field_1613[this.field_1612--];
            int var5;
            if (this.field_1557 > -1 && (var5 = this.field_1558[this.field_1557--]) != 0) {
                this.field_1559 -= var5;
                if (this.field_1560[this.field_1559 + 1] instanceof class_105) {
                    System.arraycopy(this.field_1560, this.field_1559 + 2, var1.field_486 = new class_98[var5 - 1], 0, var5 - 1);
                    var1.field_493 = (class_105)this.field_1560[this.field_1559 + 1];
                } else {
                    System.arraycopy(this.field_1560, this.field_1559 + 1, var1.field_486 = new class_98[var5], 0, var5);
                    var1.field_493 = class_158.method_1047();
                }
            } else {
                var1.field_493 = class_158.method_1047();
                if (!this.method_2820(var1.field_490, var1.field_491)) {
                    var1.field_446 |= 8;
                }
            }
            if (var1.field_493.field_445 == 0) {
                var1.field_493.field_445 = var1.field_445;
                var1.field_493.field_444 = var1.field_444;
            }
        }
    }

    public class_90 method_2856(class_19 var1, class_284 var2) {
        return this.method_2857(var1, var2, -1, -1);
    }

    public class_90 method_2857(class_19 var1, class_284 var2, int var3, int var4) {
        class_90 var5;
        try {
            this.method_2845(true);
            this.method_2841();
            class_90 var10002 = new class_90(this.field_1608, var2, 0);
            this.field_1615 = this.field_1561 = var10002;
            char[] var6;
            try {
                var6 = this.field_1636 != null ? this.field_1636.method_2910(var1) : var1.method_51();
            } catch (class_242 var11) {
                this.method_2862().method_1500(this.field_1561, var11, this.field_1607.field_1931);
                var6 = CharOperation.field_994;
            }
            this.field_1628.method_2440(var6);
            this.field_1561.field_445 = this.field_1628.field_1237.length - 1;
            if (var4 != -1) {
                this.field_1628.method_2435(var3, var4);
            }
            this.method_2854();
        } finally {
            var5 = this.field_1561;
            this.field_1561 = null;
            if (!this.field_1564) {
                var5.field_446 |= 16;
            }
        }
        return var5;
    }

    public void method_2858(class_122 var1, class_114 var2, class_90 var3) {
        boolean var4 = this.field_1621;
        if (this.field_1607.field_1961) {
            this.field_1621 = true;
        }
        this.method_2844();
        this.method_2840();
        ++this.field_1601[this.field_1602];
        this.method_2873(0);
        this.field_1615 = var2;
        this.field_1561 = var3;
        this.field_1628.method_2435(var1.field_666, var1.field_667);
        try {
            this.method_2854();
        } catch (class_241 var9) {
            this.field_1589 = 12828;
        } finally {
            --this.field_1601[this.field_1602];
            if (this.field_1607.field_1962) {
                this.field_1621 = var4;
            }
        }
        this.method_2525(var1.field_652);
        if (this.field_1589 != 12828) {
            var1.field_664.field_573 = this.field_1613[this.field_1612--];
            int var5;
            if (this.field_1557 > -1 && (var5 = this.field_1558[this.field_1557--]) > 0) {
                System.arraycopy(this.field_1560, (this.field_1559 -= var5) + 1, var1.field_664.field_572 = new class_98[var5], 0, var5);
            } else if (!this.method_2820(var1.field_664.field_444, var1.field_664.field_445)) {
                var1.field_664.field_446 |= 8;
            }
            if ((var2.field_446 & 2) != 0) {
                var1.field_446 |= 2;
            }
        }
    }

    public void method_2859(class_96 var1, class_90 var2) {
        if (!var1.method_792()) {
            if (!var1.method_798()) {
                if ((var1.field_482 & 16777216) == 0) {
                    boolean var3 = this.field_1621;
                    if (this.field_1607.field_1961) {
                        this.field_1621 = true;
                        this.field_1598 = var1.field_445;
                    }
                    this.method_2844();
                    this.method_2840();
                    ++this.field_1601[this.field_1602];
                    this.method_2873(0);
                    this.field_1615 = var1;
                    this.field_1561 = var2;
                    this.field_1628.method_2435(var1.field_490, var1.field_491);
                    try {
                        this.method_2854();
                    } catch (class_241 var8) {
                        this.field_1589 = 12828;
                    } finally {
                        --this.field_1601[this.field_1602];
                        if (this.field_1607.field_1962) {
                            this.field_1621 = var3;
                        }
                    }
                    this.method_2525(var1.field_481);
                    if (this.field_1589 != 12828) {
                        var1.field_487 = this.field_1613[this.field_1612--];
                        int var4;
                        if (this.field_1557 > -1 && (var4 = this.field_1558[this.field_1557--]) != 0) {
                            System.arraycopy(this.field_1560, (this.field_1559 -= var4) + 1, var1.field_486 = new class_98[var4], 0, var4);
                        } else if (!this.method_2820(var1.field_490, var1.field_491)) {
                            var1.field_446 |= 8;
                        }
                    }
                }
            }
        }
    }

    public void method_2860(class_33 var1, int var2, int var3, class_114[] var4, class_90 var5) {
        boolean var6 = this.field_1622;
        this.field_1622 = true;
        this.method_2844();
        this.method_2840();
        ++this.field_1601[this.field_1602];
        this.method_2873(0);
        this.method_2865(0);
        this.field_1615 = var1;
        this.field_1561 = var5;
        this.field_1626 = null;
        if (var4 != null && var4.length > 0) {
            this.field_1623 = var4;
            this.field_1624 = 0;
            this.field_1625 = this.field_1623[0].field_598 == null ? this.field_1623[0].field_592 : this.field_1623[0].field_598.field_444;
        } else {
            this.field_1623 = null;
            this.field_1624 = -1;
            this.field_1625 = -1;
        }
        this.field_1628.method_2435(var2, var3);
        this.field_1590 = this.field_1628.field_1232;
        this.field_1630 = -1;
        try {
            this.method_2854();
        } catch (class_241 var11) {
            this.field_1589 = 12828;
        } finally {
            --this.field_1601[this.field_1602];
            this.field_1623 = null;
            this.field_1622 = var6;
        }
        this.method_2525(var3);
    }

    public void method_2861() {
        if (this.field_1628.field_1228) {
            this.field_1561.field_455.field_1684 = this.field_1628.method_2412();
        }
    }

    public ProblemReporter method_2862() {
        if (this.field_1628.field_1228) {
            this.field_1561.field_455.field_1684 = this.field_1628.method_2412();
        }
        this.field_1608.field_1065 = this.field_1615;
        return this.field_1608;
    }

    protected void method_2863() {
        int var1 = this.field_1585.length;
        if (++this.field_1584 >= var1) {
            System.arraycopy(this.field_1585, 0, this.field_1585 = new char[var1 + 20][], 0, var1);
            System.arraycopy(this.field_1583, 0, this.field_1583 = new long[var1 + 20], 0, var1);
        }
        this.field_1585[this.field_1584] = this.field_1628.method_2407();
        this.field_1583[this.field_1584] = ((long)this.field_1628.field_1230 << 32) + (long)(this.field_1628.field_1231 - 1);
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

    protected void method_2866(class_89 var1) {
        int var2 = this.field_1560.length;
        if (++this.field_1559 >= var2) {
            System.arraycopy(this.field_1560, 0, this.field_1560 = new class_89[var2 + 100], 0, var2);
            this.field_1559 = var2;
        }
        this.field_1560[this.field_1559] = var1;
        var2 = this.field_1558.length;
        if (++this.field_1557 >= var2) {
            System.arraycopy(this.field_1558, 0, this.field_1558 = new int[var2 + 100], 0, var2);
        }
        this.field_1558[this.field_1557] = 1;
    }

    protected void method_2867(class_126 var1) {
        int var2 = this.field_1571.length;
        if (++this.field_1570 >= var2) {
            System.arraycopy(this.field_1571, 0, this.field_1571 = new class_126[var2 + 100], 0, var2);
        }
        this.field_1571[this.field_1570] = var1;
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

    protected void method_2869(class_89 var1) {
        int var2 = this.field_1578.length;
        if (++this.field_1577 >= var2) {
            System.arraycopy(this.field_1578, 0, this.field_1578 = new class_89[var2 + 10], 0, var2);
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
        class_265 var10000 = new class_265(this);
        class_265 var1 = var10000;
        class_266 var8 = new class_266(this);
        class_266 var2 = var8;
        var1.field_1159 = var2;
        var2.field_1164 = var1;
        if (this.field_1615 instanceof class_93) {
            ((class_93)this.field_1615).method_806(var1, (class_84)null);
        } else if (this.field_1615 instanceof class_114) {
            class_114 var3 = (class_114)this.field_1615;
            int var4 = var3.field_583.length;
            int var5 = 0;
            while (var5 < var4) {
                class_121 var6 = var3.field_583[var5];
                switch (var6.method_887()) {
                    case 2:
                        class_122 var7 = (class_122)var6;
                        if (var7.field_664 != null) {
                            var1.field_1160 = var3;
                            var7.method_893(var1, (class_87)null);
                        }
                    default:
                        ++var5;
                }
            }
        }
    }

    public void method_2875() {
        if (this.field_1562 != null && this.field_1562.field_1068 != null) {
            int var1;
            if (this.field_1562 instanceof class_259) {
                var1 = ((class_259)this.field_1562).field_1122.field_445;
                this.field_1562.method_1857(var1);
                this.field_1562 = this.field_1562.field_1068;
            } else if (this.field_1562 instanceof class_253 && !(this.field_1562 instanceof class_254)) {
                var1 = ((class_253)this.field_1562).field_1073.field_445;
                this.field_1562.method_1857(var1);
                this.field_1562 = this.field_1562.field_1068;
            }
        }
    }

    public void method_2876() {
        class_251 var1;
        switch (this.field_1563) {
            case 27:
                this.field_1567 = this.field_1628.field_1231 - 1;
                this.field_1566 = this.field_1628.field_1230 - 1;
                class_260 var2 = this.method_2826();
                if (var2 != null) {
                    var2.field_1137 = false;
                }
            case 31:
                this.field_1609 = this.field_1628.field_1230 - 1;
                this.field_1610 = this.field_1628.field_1231 - 1;
                this.field_1566 = this.method_2831(this.field_1610);
                var1 = this.field_1562.method_1853(this.field_1628.field_1230, this.field_1610);
                this.field_1590 = this.field_1628.field_1231;
                if (var1 != this.field_1562) {
                    this.field_1562 = var1;
                }
                break;
            case 52:
                if (this.field_1634 && this.field_1633 && this.field_1620 < this.field_1628.field_1231 && !this.field_1622) {
                    class_170 var3 = this.method_2825(this.field_1628.method_2410(), this.field_1628.field_1230, this.field_1628.field_1231 - 1, Util.method_1324(this.field_1628.field_1230, this.field_1628.field_1256, 0, this.field_1628.field_1257));
                    this.field_1561.method_775(var3, this.field_1562 != null);
                }
                break;
            case 69:
                var1 = null;
                if (!this.field_1586) {
                    var1 = this.field_1562.method_1854(this.field_1628.field_1230 - 1, this.field_1628.field_1231 - 1);
                }
                this.field_1590 = this.field_1628.field_1231;
                if (var1 != null) {
                    this.field_1618 = true;
                    this.field_1562 = var1;
                }
                break;
            default:
                if (this.field_1610 > this.field_1611 && this.field_1628.field_1231 != this.field_1628.field_1230) {
                    this.field_1611 = this.field_1628.field_1230;
                }
        }
        this.field_1586 = false;
    }

    protected void method_2877(boolean var1, int var2) {
        if (this.field_1615 instanceof class_96) {
            class_96 var3 = (class_96)this.field_1615;
            if ((var3.field_446 & 32) != 0) {
                return;
            }
        }
        this.field_1561.field_455.field_1684 = this.field_1628.method_2412();
        this.field_1628.field_1228 = false;
        int var8 = this.field_1628.field_1232;
        int var4 = this.field_1628.field_1233 == Integer.MAX_VALUE ? this.field_1628.field_1233 : this.field_1628.field_1233 - 1;
        class_222 var10000;
        if (var1) {
            class_114[] var5 = this.field_1561.field_450;
            int[][] var6 = class_230.method_1341(var5);
            var10000 = new class_222(this, var2, var8, var4, var6[0], var6[1], var6[2], this.field_1607);
            class_222 var7 = var10000;
            var7.method_1288(false);
            this.method_2878(var5);
            this.field_1628.method_2435(var8, var4);
        } else {
            var10000 = new class_222(this, var2, var8, var4, this.field_1607);
            class_222 var9 = var10000;
            var9.method_1288(this.field_1607.field_1962);
        }
    }

    private void method_2878(class_114[] var1) {
        if (var1 != null) {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                class_114[] var3 = var1[var2].field_585;
                if (var3 != null) {
                    this.method_2878(var3);
                }
                class_93[] var4 = var1[var2].field_584;
                class_222 var10000;
                if (var4 != null) {
                    for (int var5 = 0; var5 < var4.length; ++var5) {
                        class_93 var6 = var4[var5];
                        if ((var6.field_446 & 32) != 0) {
                            class_222 var7;
                            if (var6.method_793()) {
                                var10000 = new class_222(this, 23, var6.field_480, var6.field_481, this.field_1607);
                                var7 = var10000;
                                var7.method_1288(this.field_1607.field_1962);
                            } else {
                                var10000 = new class_222(this, 6, var6.field_480, var6.field_481, this.field_1607);
                                var7 = var10000;
                                var7.method_1288(this.field_1607.field_1962);
                            }
                        }
                    }
                }
                class_121[] var10 = var1[var2].field_583;
                if (var10 != null) {
                    int var11 = var10.length;
                    for (int var12 = 0; var12 < var11; ++var12) {
                        if (var10[var12] instanceof class_122) {
                            class_122 var8 = (class_122)var10[var12];
                            if ((var8.field_446 & 32) != 0) {
                                var10000 = new class_222(this, 10, var8.field_653, var8.field_652, this.field_1607);
                                class_222 var9 = var10000;
                                var9.method_1288(this.field_1607.field_1962);
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
        this.field_1628.field_1245 = -1;
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
            if (!this.method_2850()) {
                return false;
            } else if (this.field_1615 instanceof class_90) {
                this.method_2842();
                this.field_1564 = true;
                return true;
            } else {
                return false;
            }
        } else if (!this.field_1622) {
            this.method_2880();
            this.method_2879();
            if (!this.method_2850()) {
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
        if (this.field_1562 == null) {
            if (this.field_1622) {
                return false;
            }
            this.field_1562 = this.method_2522();
        }
        if (this.field_1562 == null) {
            return false;
        } else {
            if (this.field_1618) {
                this.field_1618 = false;
            }
            this.method_2883();
            if (this.field_1620 < this.field_1628.field_1231) {
                this.field_1620 = this.field_1628.field_1231;
                this.field_1628.field_1293 = this.field_1628.field_1231;
            }
            return this.method_2881();
        }
    }

    public String toString() {
        String var1 = "lastCheckpoint : int = " + String.valueOf(this.field_1590) + "\n";
        var1 = var1 + "identifierStack : char[" + (this.field_1584 + 1) + "][] = {";
        int var2;
        for (var2 = 0; var2 <= this.field_1584; ++var2) {
            var1 = var1 + "\"" + this.field_1585[var2] + "\",";
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
        var1 = var1 + "\n\n\n----------------Scanner--------------\n" + this.field_1628.toString();
        return var1;
    }

    protected void method_2883() {
        this.field_1562.method_1852();
        this.method_2876();
    }

    protected void method_2884(int var1) {
        int var3 = -1 + this.field_1560[this.field_1559 - var1 + 1].field_444;
        class_121 var2;
        for (int var4 = 0; var4 < var1 - 1; ++var4) {
            var2 = (class_121)this.field_1560[this.field_1559 - var4 - 1];
            var2.field_662 = var3;
            var2.field_663 = -1 + this.field_1560[this.field_1559 - var4].field_444;
        }
        (var2 = (class_121)this.field_1560[this.field_1559]).field_662 = var3;
        var2.field_663 = var2.field_652;
    }

    protected void method_2885(class_126 var1) {
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
        field_1532 = null;
        field_1533 = null;
        field_1534 = null;
        field_1535 = null;
        field_1536 = null;
        field_1537 = null;
        field_1538 = null;
        field_1539 = null;
        field_1540 = null;
        field_1541 = null;
        field_1542 = null;
        field_1543 = null;
        field_1544 = null;
        field_1545 = null;
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
        field_1556 = false;
        try {
            method_2507();
        } catch (IOException var1) {
            throw new RuntimeException(var1.getMessage());
        }
    }
}
