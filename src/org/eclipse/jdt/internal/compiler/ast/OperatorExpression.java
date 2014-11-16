package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;

public abstract class OperatorExpression extends Expression {

    public static int[][] OperatorSignatures;

    public OperatorExpression() {
    }

    public static final void classInitialize() {
        OperatorSignatures[2] = method_956();
        OperatorSignatures[0] = method_957();
        OperatorSignatures[9] = method_958();
        OperatorSignatures[18] = method_959();
        OperatorSignatures[6] = method_960();
        OperatorSignatures[7] = method_961();
        OperatorSignatures[10] = method_962();
        OperatorSignatures[4] = method_963();
        OperatorSignatures[5] = method_964();
        OperatorSignatures[13] = method_965();
        OperatorSignatures[15] = method_966();
        OperatorSignatures[3] = method_967();
        OperatorSignatures[1] = method_968();
        OperatorSignatures[14] = method_969();
        OperatorSignatures[16] = method_970();
        OperatorSignatures[17] = method_971();
        OperatorSignatures[19] = method_972();
        OperatorSignatures[8] = method_973();
    }

    public static final int[] method_956() {
        int[] var0 = new int[256];
        var0[51] = 670266;
        var0[55] = 472951;
        var0[52] = 670282;
        var0[50] = 670250;
        var0[58] = 670378;
        var0[115] = 489271;
        var0[119] = 489335;
        var0[116] = 489287;
        var0[114] = 489255;
        var0[122] = 489383;
        var0[67] = 674362;
        var0[71] = 477047;
        var0[68] = 674378;
        var0[66] = 674346;
        var0[74] = 674474;
        var0[85] = 349525;
        var0[35] = 666170;
        var0[39] = 468855;
        var0[36] = 666186;
        var0[34] = 666154;
        var0[42] = 666282;
        var0[163] = 698938;
        var0[167] = 501623;
        var0[164] = 698954;
        var0[162] = 698922;
        var0[170] = 699050;
        return var0;
    }

    public static final int[] method_957() {
        int[] var0 = new int[256];
        var0[85] = 349525;
        return var0;
    }

    public static final int[] method_958() {
        return method_965();
    }

    public static final int[] method_959() {
        int[] var0 = new int[256];
        var0[51] = 670261;
        var0[55] = 472949;
        var0[52] = 670277;
        var0[56] = 538757;
        var0[57] = 604565;
        var0[50] = 670245;
        var0[58] = 670373;
        var0[115] = 489269;
        var0[119] = 489333;
        var0[116] = 489285;
        var0[120] = 555141;
        var0[121] = 620949;
        var0[114] = 489253;
        var0[122] = 489381;
        var0[67] = 674357;
        var0[71] = 477045;
        var0[68] = 674373;
        var0[72] = 542853;
        var0[73] = 608661;
        var0[66] = 674341;
        var0[74] = 674469;
        var0[187] = 111029;
        var0[177] = 110869;
        var0[188] = 111045;
        var0[27] = 70069;
        var0[17] = 69909;
        var0[28] = 70085;
        var0[131] = 559157;
        var0[135] = 559221;
        var0[132] = 559173;
        var0[136] = 559237;
        var0[137] = 559253;
        var0[130] = 559141;
        var0[138] = 559269;
        var0[147] = 629045;
        var0[151] = 629109;
        var0[148] = 629061;
        var0[152] = 563333;
        var0[153] = 629141;
        var0[146] = 629029;
        var0[154] = 629157;
        var0[85] = 349525;
        var0[35] = 666165;
        var0[39] = 468853;
        var0[36] = 666181;
        var0[40] = 534661;
        var0[41] = 600469;
        var0[34] = 666149;
        var0[42] = 666277;
        var0[163] = 698933;
        var0[167] = 501621;
        var0[164] = 698949;
        var0[168] = 567429;
        var0[169] = 633237;
        var0[162] = 698917;
        var0[170] = 699045;
        var0[203] = 115125;
        var0[193] = 114965;
        var0[204] = 115141;
        return var0;
    }

    public static final int[] method_960() {
        return method_963();
    }

    public static final int[] method_961() {
        return method_963();
    }

    public static final int[] method_962() {
        int[] var0 = new int[256];
        var0[51] = 670266;
        var0[55] = 670330;
        var0[52] = 670282;
        var0[50] = 670250;
        var0[58] = 670378;
        var0[115] = 490039;
        var0[119] = 490103;
        var0[116] = 490055;
        var0[114] = 490023;
        var0[122] = 490151;
        var0[67] = 674362;
        var0[71] = 674426;
        var0[68] = 674378;
        var0[66] = 674346;
        var0[74] = 674474;
        var0[35] = 666170;
        var0[39] = 666234;
        var0[36] = 666186;
        var0[34] = 666154;
        var0[42] = 666282;
        var0[163] = 698938;
        var0[167] = 699002;
        var0[164] = 698954;
        var0[162] = 698922;
        var0[170] = 699050;
        return var0;
    }

    public static final int[] method_963() {
        int[] var0 = new int[256];
        var0[51] = 670261;
        var0[55] = 472949;
        var0[52] = 670277;
        var0[56] = 538757;
        var0[57] = 604565;
        var0[50] = 670245;
        var0[58] = 670373;
        var0[115] = 489269;
        var0[119] = 489333;
        var0[116] = 489285;
        var0[120] = 555141;
        var0[121] = 620949;
        var0[114] = 489253;
        var0[122] = 489381;
        var0[67] = 674357;
        var0[71] = 477045;
        var0[68] = 674373;
        var0[72] = 542853;
        var0[73] = 608661;
        var0[66] = 674341;
        var0[74] = 674469;
        var0[131] = 559157;
        var0[135] = 559221;
        var0[132] = 559173;
        var0[136] = 559237;
        var0[137] = 559253;
        var0[130] = 559141;
        var0[138] = 559269;
        var0[147] = 629045;
        var0[151] = 629109;
        var0[148] = 629061;
        var0[152] = 563333;
        var0[153] = 629141;
        var0[146] = 629029;
        var0[154] = 629157;
        var0[35] = 666165;
        var0[39] = 468853;
        var0[36] = 666181;
        var0[40] = 534661;
        var0[41] = 600469;
        var0[34] = 666149;
        var0[42] = 666277;
        var0[163] = 698933;
        var0[167] = 501621;
        var0[164] = 698949;
        var0[168] = 567429;
        var0[169] = 633237;
        var0[162] = 698917;
        var0[170] = 699045;
        return var0;
    }

    public static final int[] method_964() {
        return method_963();
    }

    public static final int[] method_965() {
        int[] var0 = method_969();
        var0[179] = 0;
        var0[183] = 0;
        var0[180] = 0;
        var0[182] = 0;
        var0[187] = 0;
        var0[177] = 0;
        var0[184] = 0;
        var0[185] = 0;
        var0[181] = 0;
        var0[178] = 0;
        var0[186] = 0;
        var0[188] = 0;
        var0[59] = 0;
        var0[123] = 0;
        var0[75] = 0;
        var0[107] = 0;
        var0[27] = 0;
        var0[139] = 0;
        var0[155] = 0;
        var0[91] = 0;
        var0[43] = 0;
        var0[171] = 0;
        var0[203] = 0;
        var0[204] = 0;
        return var0;
    }

    public static final int[] method_966() {
        return method_965();
    }

    public static final int[] method_967() {
        return method_956();
    }

    public static final int[] method_968() {
        return method_957();
    }

    public static final int[] method_969() {
        int[] var0 = new int[256];
        var0[51] = 670266;
        var0[55] = 472951;
        var0[52] = 670282;
        var0[59] = 211899;
        var0[56] = 538760;
        var0[57] = 604569;
        var0[50] = 670250;
        var0[58] = 670378;
        var0[115] = 489271;
        var0[119] = 489335;
        var0[116] = 489287;
        var0[123] = 490427;
        var0[120] = 555144;
        var0[121] = 620953;
        var0[114] = 489255;
        var0[122] = 489383;
        var0[67] = 674362;
        var0[71] = 477047;
        var0[68] = 674378;
        var0[75] = 281531;
        var0[72] = 542856;
        var0[73] = 608665;
        var0[66] = 674346;
        var0[74] = 674474;
        var0[179] = 766779;
        var0[183] = 767867;
        var0[180] = 767051;
        var0[187] = 768955;
        var0[177] = 766235;
        var0[184] = 768139;
        var0[185] = 768411;
        var0[181] = 767323;
        var0[178] = 766507;
        var0[186] = 768683;
        var0[188] = 769227;
        var0[27] = 72635;
        var0[131] = 559160;
        var0[135] = 559224;
        var0[132] = 559176;
        var0[139] = 560059;
        var0[136] = 559240;
        var0[137] = 559256;
        var0[130] = 559144;
        var0[138] = 559272;
        var0[147] = 629049;
        var0[151] = 629113;
        var0[148] = 629065;
        var0[155] = 629691;
        var0[152] = 563336;
        var0[153] = 629145;
        var0[146] = 629033;
        var0[154] = 629161;
        var0[91] = 351163;
        var0[35] = 666170;
        var0[39] = 468855;
        var0[36] = 666186;
        var0[43] = 142267;
        var0[40] = 534664;
        var0[41] = 600473;
        var0[34] = 666154;
        var0[42] = 666282;
        var0[163] = 698938;
        var0[167] = 501623;
        var0[164] = 698954;
        var0[171] = 699323;
        var0[168] = 567432;
        var0[169] = 633241;
        var0[162] = 698922;
        var0[170] = 699050;
        var0[203] = 838587;
        return var0;
    }

    public static final int[] method_970() {
        return method_965();
    }

    public static final int[] method_971() {
        return method_962();
    }

    public static final int[] method_972() {
        return method_962();
    }

    public static final int[] method_973() {
        return method_956();
    }

    public String operatorToString() {
        switch ((this.field_446 & 4032) >> 6) {
            case 0:
                return "&&";
            case 1:
                return "||";
            case 2:
                return "&";
            case 3:
                return "|";
            case 4:
                return "<";
            case 5:
                return "<=";
            case 6:
                return ">";
            case 7:
                return ">=";
            case 8:
                return "^";
            case 9:
                return "/";
            case 10:
                return "<<";
            case 11:
                return "!";
            case 12:
                return "~";
            case 13:
                return "-";
            case 14:
                return "+";
            case 15:
                return "*";
            case 16:
                return "%";
            case 17:
                return ">>";
            case 18:
                return "==";
            case 19:
                return ">>>";
            case 20:
            case 21:
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            default:
                return "unknown operator";
            case 23:
                return "?:";
            case 29:
                return "!=";
            case 30:
                return "=";
        }
    }

    public int nullStatus(FlowInfo var1) {
        return -1;
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append('(');
        return this.printExpressionNoParenthesis(0, var2).append(')');
    }

    public abstract StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2);

    static {
        OperatorSignatures = new int[20][];
        classInitialize();
    }
}
