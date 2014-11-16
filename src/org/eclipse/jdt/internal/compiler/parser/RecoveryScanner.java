package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScannerData;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class RecoveryScanner extends Scanner {

    public static final char[] FAKE_IDENTIFIER;

    private RecoveryScannerData data;

    private int[] pendingTokens;

    private int field_1304;

    private char[] fakeTokenSource;

    private boolean field_1306;

    private boolean field_1307;

    private int field_1308;

    public boolean record;

    public RecoveryScanner(Scanner var1, RecoveryScannerData var2) {
        super(false, var1.field_1236, var1.field_1292, var1.field_1223, var1.field_1224, var1.field_1252, var1.field_1253, var1.field_1254);
        this.field_1304 = -1;
        this.fakeTokenSource = null;
        this.field_1306 = true;
        this.field_1307 = false;
        this.field_1308 = -1;
        this.record = true;
        this.setData(var2);
    }

    public void method_2446(int var1, int var2, int var3) {
        this.method_2448(new int[] {var1}, var2, var3);
    }

    private int[] reverse(int[] var1) {
        int var2 = var1.length;
        int var3 = 0;
        for (int var4 = var2 / 2; var3 < var4; ++var3) {
            int var5 = var1[var3];
            var1[var3] = var1[var2 - var3 - 1];
            var1[var2 - var3 - 1] = var5;
        }
        return var1;
    }

    public void method_2448(int[] var1, int var2, int var3) {
        if (this.record) {
            if (var2 <= -1 || Parser.field_1544[var2] == 0) {
                ++this.data.field_1168;
                if (this.data.field_1169 == null) {
                    this.data.field_1169 = new int[10][];
                    this.data.field_1170 = new int[10];
                    this.data.field_1171 = new boolean[10];
                } else if (this.data.field_1169.length == this.data.field_1168) {
                    int var4 = this.data.field_1169.length;
                    System.arraycopy(this.data.field_1169, 0, this.data.field_1169 = new int[var4 * 2][], 0, var4);
                    System.arraycopy(this.data.field_1170, 0, this.data.field_1170 = new int[var4 * 2], 0, var4);
                    System.arraycopy(this.data.field_1171, 0, this.data.field_1171 = new boolean[var4 * 2], 0, var4);
                }
                this.data.field_1169[this.data.field_1168] = this.reverse(var1);
                this.data.field_1170[this.data.field_1168] = var3;
                this.data.field_1171[this.data.field_1168] = false;
            }
        }
    }

    public void method_2449(int var1, int var2, int var3) {
        this.method_2450(new int[] {var1}, var2, var3);
    }

    public void method_2450(int[] var1, int var2, int var3) {
        if (this.record) {
            ++this.data.field_1172;
            if (this.data.field_1174 == null) {
                this.data.field_1173 = new int[10][];
                this.data.field_1174 = new int[10];
                this.data.field_1175 = new int[10];
                this.data.field_1176 = new boolean[10];
            } else if (this.data.field_1174.length == this.data.field_1172) {
                int var4 = this.data.field_1174.length;
                System.arraycopy(this.data.field_1173, 0, this.data.field_1173 = new int[var4 * 2][], 0, var4);
                System.arraycopy(this.data.field_1174, 0, this.data.field_1174 = new int[var4 * 2], 0, var4);
                System.arraycopy(this.data.field_1175, 0, this.data.field_1175 = new int[var4 * 2], 0, var4);
                System.arraycopy(this.data.field_1176, 0, this.data.field_1176 = new boolean[var4 * 2], 0, var4);
            }
            this.data.field_1173[this.data.field_1172] = this.reverse(var1);
            this.data.field_1174[this.data.field_1172] = var2;
            this.data.field_1175[this.data.field_1172] = var3;
            this.data.field_1176[this.data.field_1172] = false;
        }
    }

    public void removeTokens(int var1, int var2) {
        if (this.record) {
            ++this.data.field_1177;
            if (this.data.field_1178 == null) {
                this.data.field_1178 = new int[10];
                this.data.field_1179 = new int[10];
                this.data.field_1180 = new boolean[10];
            } else if (this.data.field_1178.length == this.data.field_1177) {
                int var3 = this.data.field_1178.length;
                System.arraycopy(this.data.field_1178, 0, this.data.field_1178 = new int[var3 * 2], 0, var3);
                System.arraycopy(this.data.field_1179, 0, this.data.field_1179 = new int[var3 * 2], 0, var3);
                System.arraycopy(this.data.field_1180, 0, this.data.field_1180 = new boolean[var3 * 2], 0, var3);
            }
            this.data.field_1178[this.data.field_1177] = var1;
            this.data.field_1179[this.data.field_1177] = var2;
            this.data.field_1180[this.data.field_1177] = false;
        }
    }

    public int getNextToken() throws InvalidInputException {
        int var1;
        if (this.field_1304 > -1) {
            var1 = this.pendingTokens[this.field_1304--];
            if (var1 == 26) {
                this.fakeTokenSource = FAKE_IDENTIFIER;
            } else {
                this.fakeTokenSource = CharOperation.NO_CHAR;
            }
            return var1;
        } else {
            this.fakeTokenSource = null;
            this.field_1307 = false;
            int var2;
            if (this.data.field_1169 != null) {
                for (var1 = 0; var1 <= this.data.field_1168; ++var1) {
                    if (this.data.field_1170[var1] == this.field_1231 - 1 && var1 > this.field_1308) {
                        this.data.field_1171[var1] = true;
                        this.pendingTokens = this.data.field_1169[var1];
                        this.field_1304 = this.data.field_1169[var1].length - 1;
                        this.field_1306 = true;
                        this.field_1230 = this.field_1231;
                        this.field_1308 = var1;
                        var2 = this.pendingTokens[this.field_1304--];
                        if (var2 == 26) {
                            this.fakeTokenSource = FAKE_IDENTIFIER;
                        } else {
                            this.fakeTokenSource = CharOperation.NO_CHAR;
                        }
                        return var2;
                    }
                }
                this.field_1308 = -1;
            }
            var1 = this.field_1231;
            var2 = super.getNextToken();
            int var3;
            if (this.data.field_1173 != null) {
                for (var3 = 0; var3 <= this.data.field_1172; ++var3) {
                    if (this.data.field_1174[var3] >= var1 && this.data.field_1174[var3] <= this.field_1230 && this.data.field_1175[var3] >= this.field_1231 - 1) {
                        this.data.field_1176[var3] = true;
                        this.pendingTokens = this.data.field_1173[var3];
                        this.field_1304 = this.data.field_1173[var3].length - 1;
                        this.fakeTokenSource = FAKE_IDENTIFIER;
                        this.field_1306 = false;
                        this.field_1231 = this.data.field_1175[var3] + 1;
                        int var4 = this.pendingTokens[this.field_1304--];
                        if (var4 == 26) {
                            this.fakeTokenSource = FAKE_IDENTIFIER;
                        } else {
                            this.fakeTokenSource = CharOperation.NO_CHAR;
                        }
                        return var4;
                    }
                }
            }
            if (this.data.field_1178 != null) {
                for (var3 = 0; var3 <= this.data.field_1177; ++var3) {
                    if (this.data.field_1178[var3] >= var1 && this.data.field_1178[var3] <= this.field_1230 && this.data.field_1179[var3] >= this.field_1231 - 1) {
                        this.data.field_1180[var3] = true;
                        this.field_1231 = this.data.field_1179[var3] + 1;
                        this.field_1307 = false;
                        return this.getNextToken();
                    }
                }
            }
            return var2;
        }
    }

    public char[] method_2407() {
        return this.fakeTokenSource != null ? this.fakeTokenSource : super.method_2407();
    }

    public char[] method_2410() {
        return this.fakeTokenSource != null ? this.fakeTokenSource : super.method_2410();
    }

    public char[] method_2409() {
        return this.fakeTokenSource != null ? this.fakeTokenSource : super.method_2409();
    }

    public RecoveryScannerData getData() {
        return this.data;
    }

    public void setData(RecoveryScannerData var1) {
        if (var1 == null) {
            RecoveryScannerData var10001 = new RecoveryScannerData();
            this.data = var10001;
        } else {
            this.data = var1;
        }
    }

    public void setPendingTokens(int[] var1) {
        this.pendingTokens = var1;
        this.field_1304 = var1.length - 1;
    }

    static {
        FAKE_IDENTIFIER = "$missing$".toCharArray();
    }
}
