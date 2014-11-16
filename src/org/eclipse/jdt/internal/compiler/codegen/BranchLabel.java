package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.Label;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;

import java.util.Arrays;

public class BranchLabel extends Label {

    private int[] forwardReferences;

    private int forwardReferenceCount;

    BranchLabel delegate;

    public int tagBits;

    public BranchLabel() {
        this.forwardReferences = new int[10];
        this.forwardReferenceCount = 0;
    }

    public BranchLabel(CodeStream var1) {
        super(var1);
        this.forwardReferences = new int[10];
        this.forwardReferenceCount = 0;
    }

    void addForwardReference(int var1) {
        if (this.delegate != null) {
            this.delegate.addForwardReference(var1);
        } else {
            int var2 = this.forwardReferenceCount;
            int var3;
            if (var2 >= 1) {
                var3 = this.forwardReferences[var2 - 1];
                if (var3 < var1) {
                    int var4;
                    if (var2 >= (var4 = this.forwardReferences.length)) {
                        System.arraycopy(this.forwardReferences, 0, this.forwardReferences = new int[2 * var4], 0, var4);
                    }
                    this.forwardReferences[this.forwardReferenceCount++] = var1;
                } else if (var3 > var1) {
                    int[] var7 = this.forwardReferences;
                    int var5 = 0;
                    for (int var6 = this.forwardReferenceCount; var5 < var6; ++var5) {
                        if (var7[var5] == var1) {
                            return;
                        }
                    }
                    if (var2 >= (var5 = var7.length)) {
                        System.arraycopy(var7, 0, this.forwardReferences = new int[2 * var5], 0, var5);
                    }
                    this.forwardReferences[this.forwardReferenceCount++] = var1;
                    Arrays.sort(this.forwardReferences, 0, this.forwardReferenceCount);
                }
            } else {
                if (var2 >= (var3 = this.forwardReferences.length)) {
                    System.arraycopy(this.forwardReferences, 0, this.forwardReferences = new int[2 * var3], 0, var3);
                }
                this.forwardReferences[this.forwardReferenceCount++] = var1;
            }
        }
    }

    public void becomeDelegateFor(BranchLabel var1) {
        var1.delegate = this;
        int var2 = var1.forwardReferenceCount;
        if (var2 != 0) {
            int[] var3 = new int[this.forwardReferenceCount + var2];
            int var4 = 0;
            int var5 = 0;
            int var6 = 0;
            int var7 = this.forwardReferenceCount;
            int var8 = var1.forwardReferenceCount;
            while (var6 < var7) {
                int var9 = this.forwardReferences[var6];
                while (true) {
                    if (var5 < var8) {
                        int var10 = var1.forwardReferences[var5];
                        if (var9 < var10) {
                            var3[var4++] = var9;
                        } else {
                            if (var9 != var10) {
                                var3[var4++] = var10;
                                ++var5;
                                continue;
                            }
                            var3[var4++] = var9;
                            ++var5;
                        }
                    } else {
                        var3[var4++] = var9;
                    }
                    ++var6;
                    break;
                }
            }
            while (var5 < var8) {
                var3[var4++] = var1.forwardReferences[var5];
                ++var5;
            }
            this.forwardReferences = var3;
            this.forwardReferenceCount = var4;
        }
    }

    void method_452() {
        this.tagBits |= 2;
        if (this.delegate != null) {
            this.delegate.method_452();
        } else {
            if (this.position == -1) {
                this.addForwardReference(this.codeStream.field_1208);
                this.codeStream.field_1208 += 2;
                this.codeStream.field_1190 += 2;
            } else {
                this.codeStream.method_2381(this);
            }
        }
    }

    void method_453() {
        this.tagBits |= 2;
        if (this.delegate != null) {
            this.delegate.method_453();
        } else {
            if (this.position == -1) {
                this.addForwardReference(this.codeStream.field_1208);
                this.tagBits |= 1;
                this.codeStream.field_1208 += 4;
                this.codeStream.field_1190 += 4;
            } else {
                this.codeStream.method_2388(this);
            }
        }
    }

    public int forwardReferenceCount() {
        if (this.delegate != null) {
            this.delegate.forwardReferenceCount();
        }
        return this.forwardReferenceCount;
    }

    public int[] forwardReferences() {
        if (this.delegate != null) {
            this.delegate.forwardReferences();
        }
        return this.forwardReferences;
    }

    public void initialize(CodeStream var1) {
        this.codeStream = var1;
        this.position = -1;
        this.forwardReferenceCount = 0;
        this.delegate = null;
    }

    public boolean method_457() {
        return true;
    }

    public void place() {
        if (this.position == -1) {
            this.position = this.codeStream.field_1208;
            this.codeStream.method_2089(this);
            int var1 = this.position;
            boolean var2 = false;
            if (this.forwardReferenceCount != 0) {
                var2 = this.forwardReferences[this.forwardReferenceCount - 1] + 2 == this.position && this.codeStream.bCodeStream[this.codeStream.field_1190 - 3] == -89;
                if (var2) {
                    if (this.codeStream.field_1198 == this.position) {
                        this.codeStream.field_1198 = -1;
                    }
                    this.codeStream.field_1208 = this.position -= 3;
                    this.codeStream.field_1190 -= 3;
                    --this.forwardReferenceCount;
                    if (this.codeStream.field_1197 == var1) {
                        this.codeStream.field_1197 = this.position;
                    }
                    if ((this.codeStream.field_1195 & 28) != 0) {
                        LocalVariableBinding[] var3 = this.codeStream.field_1202;
                        int var4 = 0;
                        for (int var5 = var3.length; var4 < var5; ++var4) {
                            LocalVariableBinding var6 = var3[var4];
                            if (var6 != null && var6.field_311 > 0) {
                                if (var6.initializationPCs[(var6.field_311 - 1 << 1) + 1] == var1) {
                                    var6.initializationPCs[(var6.field_311 - 1 << 1) + 1] = this.position;
                                }
                                if (var6.initializationPCs[var6.field_311 - 1 << 1] == var1) {
                                    var6.initializationPCs[var6.field_311 - 1 << 1] = this.position;
                                }
                            }
                        }
                    }
                    if ((this.codeStream.field_1195 & 2) != 0) {
                        this.codeStream.method_2364();
                    }
                }
            }
            for (int var7 = 0; var7 < this.forwardReferenceCount; ++var7) {
                this.codeStream.writePosition(this, this.forwardReferences[var7]);
            }
            if (var2) {
                this.codeStream.optimizeBranch(var1, this);
            }
        }
    }

    public String toString() {
        String var1 = this.getClass().getName();
        var1 = var1.substring(var1.lastIndexOf(46) + 1);
        StringBuffer var2 = new StringBuffer(var1);
        var2.append('@').append(Integer.toHexString(this.hashCode()));
        var2.append("(position=").append(this.position);
        if (this.delegate != null) {
            var2.append("delegate=").append(this.delegate);
        }
        var2.append(", forwards = [");
        for (int var3 = 0; var3 < this.forwardReferenceCount - 1; ++var3) {
            var2.append(this.forwardReferences[var3] + ", ");
        }
        if (this.forwardReferenceCount >= 1) {
            var2.append(this.forwardReferences[this.forwardReferenceCount - 1]);
        }
        var2.append("] )");
        return var2.toString();
    }
}
