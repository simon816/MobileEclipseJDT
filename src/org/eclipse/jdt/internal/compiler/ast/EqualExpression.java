package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.BooleanConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class EqualExpression extends BinaryExpression {

    public EqualExpression(Expression var1, Expression var2, int var3) {
        super(var1, var2, var3);
    }

    private void checkNullComparison(BlockScope var1, FlowContext var2, FlowInfo var3, FlowInfo var4, FlowInfo var5) {
        LocalVariableBinding var6 = this.field_715.localVariableBinding();
        if (var6 != null && (var6.type.tagBits & 2L) == 0L) {
            this.checkVariableComparison(var1, var2, var3, var4, var5, var6, this.field_716.nullStatus(var3), this.field_715);
        }
        var6 = this.field_716.localVariableBinding();
        if (var6 != null && (var6.type.tagBits & 2L) == 0L) {
            this.checkVariableComparison(var1, var2, var3, var4, var5, var6, this.field_715.nullStatus(var3), this.field_716);
        }
    }

    private void checkVariableComparison(BlockScope var1, FlowContext var2, FlowInfo var3, FlowInfo var4, FlowInfo var5, LocalVariableBinding var6, int var7, Expression var8) {
        switch (var7) {
            case -1:
                if ((this.field_446 & 4032) >> 6 == 18) {
                    var2.recordUsingNullReference(var1, var6, var8, 513, var3);
                    var4.method_3094(var6);
                } else {
                    var2.recordUsingNullReference(var1, var6, var8, 257, var3);
                }
                break;
            case 1:
                if ((this.field_446 & 4032) >> 6 == 18) {
                    var2.recordUsingNullReference(var1, var6, var8, 256, var3);
                    var4.method_3095(var6);
                    var5.method_3094(var6);
                } else {
                    var2.recordUsingNullReference(var1, var6, var8, 512, var3);
                    var4.method_3094(var6);
                    var5.method_3095(var6);
                }
        }
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        Object var4;
        if ((this.field_446 & 4032) >> 6 == 18) {
            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 5) {
                if (this.field_715.constant.booleanValue()) {
                    var4 = this.field_716.analyseCode(var1, var2, var3);
                } else {
                    var4 = this.field_716.analyseCode(var1, var2, var3).asNegatedCondition();
                }
            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 5) {
                if (this.field_716.constant.booleanValue()) {
                    var4 = this.field_715.analyseCode(var1, var2, var3);
                } else {
                    var4 = this.field_715.analyseCode(var1, var2, var3).asNegatedCondition();
                }
            } else {
                var4 = this.field_716.analyseCode(var1, var2, this.field_715.analyseCode(var1, var2, var3).method_3109()).method_3109();
            }
        } else if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 5) {
            if (!this.field_715.constant.booleanValue()) {
                var4 = this.field_716.analyseCode(var1, var2, var3);
            } else {
                var4 = this.field_716.analyseCode(var1, var2, var3).asNegatedCondition();
            }
        } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 5) {
            if (!this.field_716.constant.booleanValue()) {
                var4 = this.field_715.analyseCode(var1, var2, var3);
            } else {
                var4 = this.field_715.analyseCode(var1, var2, var3).asNegatedCondition();
            }
        } else {
            var4 = this.field_716.analyseCode(var1, var2, this.field_715.analyseCode(var1, var2, var3).method_3109()).method_3109();
        }
        if (var4 instanceof UnconditionalFlowInfo && (((FlowInfo)var4).tagBits & 1) == 0) {
            var4 = FlowInfo.conditional(((FlowInfo)var4).method_3078(), ((FlowInfo)var4).method_3078());
        }
        this.checkNullComparison(var1, var2, (FlowInfo)var4, ((FlowInfo)var4).method_3081(), ((FlowInfo)var4).method_3080());
        return (FlowInfo)var4;
    }

    public final void computeConstant(TypeBinding var1, TypeBinding var2) {
        if (this.field_715.constant != Constant.NotAConstant && this.field_716.constant != Constant.NotAConstant) {
            this.constant = Constant.method_3266(this.field_715.constant, var1.id, this.field_716.constant, var2.id);
            if ((this.field_446 & 4032) >> 6 == 29) {
                this.constant = BooleanConstant.fromValue(!this.constant.booleanValue());
            }
        } else {
            this.constant = Constant.NotAConstant;
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.constant != Constant.NotAConstant) {
            if (var3) {
                var2.generateConstant(this.constant, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            if ((this.field_715.field_674 & 15) == 5) {
                this.method_997(var1, var2, var3);
            } else {
                this.method_999(var1, var2, var3);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if (this.constant != Constant.NotAConstant) {
            super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
        } else {
            if ((this.field_446 & 4032) >> 6 == 18) {
                if ((this.field_715.field_674 & 15) == 5) {
                    this.method_998(var1, var2, var3, var4, var5);
                } else {
                    this.method_1000(var1, var2, var3, var4, var5);
                }
            } else if ((this.field_715.field_674 & 15) == 5) {
                this.method_998(var1, var2, var4, var3, var5);
            } else {
                this.method_1000(var1, var2, var4, var3, var5);
            }
        }
    }

    public void method_997(BlockScope var1, CodeStream var2, boolean var3) {
        boolean var4 = (this.field_446 & 4032) >> 6 == 18;
        Constant var5 = this.field_715.optimizedBooleanConstant();
        BranchLabel var7;
        BranchLabel var10000;
        if (var5 != Constant.NotAConstant) {
            Constant var9 = this.field_716.optimizedBooleanConstant();
            if (var9 != Constant.NotAConstant) {
                this.field_715.generateCode(var1, var2, false);
                this.field_716.generateCode(var1, var2, false);
                if (var3) {
                    boolean var10 = var5.booleanValue();
                    boolean var8 = var9.booleanValue();
                    if (var4) {
                        if (var10 == var8) {
                            var2.method_2222();
                        } else {
                            var2.method_2221();
                        }
                    } else if (var10 != var8) {
                        var2.method_2222();
                    } else {
                        var2.method_2221();
                    }
                }
            } else if (var5.booleanValue() == var4) {
                this.field_715.generateCode(var1, var2, false);
                this.field_716.generateCode(var1, var2, var3);
            } else if (var3) {
                var10000 = new BranchLabel(var2);
                var7 = var10000;
                this.field_715.generateCode(var1, var2, false);
                this.field_716.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var7, var3);
                var2.method_2221();
                if ((this.field_446 & 16) != 0) {
                    var2.method_2182(this.field_674);
                    var2.generateReturnBytecode(this);
                    var7.place();
                    var2.method_2222();
                } else {
                    var10000 = new BranchLabel(var2);
                    BranchLabel var11 = var10000;
                    var2.method_2209(var11);
                    var2.method_2125(1);
                    var7.place();
                    var2.method_2222();
                    var11.place();
                }
            } else {
                this.field_715.generateCode(var1, var2, false);
                this.field_716.generateCode(var1, var2, false);
            }
        } else {
            var5 = this.field_716.optimizedBooleanConstant();
            BranchLabel var6;
            if (var5 != Constant.NotAConstant) {
                if (var5.booleanValue() == var4) {
                    this.field_715.generateCode(var1, var2, var3);
                    this.field_716.generateCode(var1, var2, false);
                } else if (var3) {
                    var10000 = new BranchLabel(var2);
                    var6 = var10000;
                    this.field_715.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var6, var3);
                    this.field_716.generateCode(var1, var2, false);
                    var2.method_2221();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.generateReturnBytecode(this);
                        var6.place();
                        var2.method_2222();
                    } else {
                        var10000 = new BranchLabel(var2);
                        var7 = var10000;
                        var2.method_2209(var7);
                        var2.method_2125(1);
                        var6.place();
                        var2.method_2222();
                        var7.place();
                    }
                } else {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, false);
                }
            } else {
                this.field_715.generateCode(var1, var2, var3);
                this.field_716.generateCode(var1, var2, var3);
                if (var3) {
                    if (var4) {
                        BranchLabel var10001 = new BranchLabel(var2);
                        var6 = var10001;
                        var2.method_2236(var10001);
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.generateReturnBytecode(this);
                            var6.place();
                            var2.method_2221();
                        } else {
                            var10000 = new BranchLabel(var2);
                            var7 = var10000;
                            var2.method_2209(var7);
                            var2.method_2125(1);
                            var6.place();
                            var2.method_2221();
                            var7.place();
                        }
                    } else {
                        var2.method_2296();
                    }
                }
            }
        }
    }

    public void method_998(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        boolean var6;
        if (this.field_715.constant != Constant.NotAConstant) {
            var6 = this.field_715.constant.booleanValue();
            this.field_716.generateOptimizedBoolean(var1, var2, var6 ? var3 : var4, var6 ? var4 : var3, var5);
        } else if (this.field_716.constant != Constant.NotAConstant) {
            var6 = this.field_716.constant.booleanValue();
            this.field_715.generateOptimizedBoolean(var1, var2, var6 ? var3 : var4, var6 ? var4 : var3, var5);
        } else {
            this.field_715.generateCode(var1, var2, var5);
            this.field_716.generateCode(var1, var2, var5);
            if (var5) {
                if (var4 == null) {
                    if (var3 != null) {
                        var2.method_2231(var3);
                    }
                } else if (var3 == null) {
                    var2.method_2236(var4);
                }
            }
            var2.method_2380(var1, var2.field_1208);
        }
    }

    public void method_999(BlockScope var1, CodeStream var2, boolean var3) {
        boolean var4 = (this.field_446 & 4032) >> 6 == 18;
        BranchLabel var6;
        BranchLabel var10000;
        if ((this.field_715.field_674 & 255) >> 4 == 10) {
            Constant var5 = this.field_715.constant;
            BranchLabel var7;
            if (this.field_715.constant != Constant.NotAConstant && var5.intValue() == 0) {
                this.field_716.generateCode(var1, var2, var3);
                if (var3) {
                    var10000 = new BranchLabel(var2);
                    var6 = var10000;
                    if (var4) {
                        var2.method_2242(var6);
                    } else {
                        var2.method_2237(var6);
                    }
                    var2.method_2222();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.generateReturnBytecode(this);
                        var6.place();
                        var2.method_2221();
                    } else {
                        var10000 = new BranchLabel(var2);
                        var7 = var10000;
                        var2.method_2209(var7);
                        var2.method_2125(1);
                        var6.place();
                        var2.method_2221();
                        var7.place();
                    }
                }
                return;
            }
            var5 = this.field_716.constant;
            if (this.field_716.constant != Constant.NotAConstant && var5.intValue() == 0) {
                this.field_715.generateCode(var1, var2, var3);
                if (var3) {
                    var10000 = new BranchLabel(var2);
                    var6 = var10000;
                    if (var4) {
                        var2.method_2242(var6);
                    } else {
                        var2.method_2237(var6);
                    }
                    var2.method_2222();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.generateReturnBytecode(this);
                        var6.place();
                        var2.method_2221();
                    } else {
                        var10000 = new BranchLabel(var2);
                        var7 = var10000;
                        var2.method_2209(var7);
                        var2.method_2125(1);
                        var6.place();
                        var2.method_2221();
                        var7.place();
                    }
                }
                return;
            }
        }
        BranchLabel var8;
        if (this.field_716 instanceof NullLiteral) {
            if (this.field_715 instanceof NullLiteral) {
                if (var3) {
                    if (var4) {
                        var2.method_2222();
                    } else {
                        var2.method_2221();
                    }
                }
            } else {
                this.field_715.generateCode(var1, var2, var3);
                if (var3) {
                    var10000 = new BranchLabel(var2);
                    var8 = var10000;
                    if (var4) {
                        var2.method_2243(var8);
                    } else {
                        var2.method_2244(var8);
                    }
                    var2.method_2222();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.generateReturnBytecode(this);
                        var8.place();
                        var2.method_2221();
                    } else {
                        var10000 = new BranchLabel(var2);
                        var6 = var10000;
                        var2.method_2209(var6);
                        var2.method_2125(1);
                        var8.place();
                        var2.method_2221();
                        var6.place();
                    }
                }
            }
        } else if (this.field_715 instanceof NullLiteral) {
            this.field_716.generateCode(var1, var2, var3);
            if (var3) {
                var10000 = new BranchLabel(var2);
                var8 = var10000;
                if (var4) {
                    var2.method_2243(var8);
                } else {
                    var2.method_2244(var8);
                }
                var2.method_2222();
                if ((this.field_446 & 16) != 0) {
                    var2.method_2182(this.field_674);
                    var2.generateReturnBytecode(this);
                    var8.place();
                    var2.method_2221();
                } else {
                    var10000 = new BranchLabel(var2);
                    var6 = var10000;
                    var2.method_2209(var6);
                    var2.method_2125(1);
                    var8.place();
                    var2.method_2221();
                    var6.place();
                }
            }
        } else {
            this.field_715.generateCode(var1, var2, var3);
            this.field_716.generateCode(var1, var2, var3);
            if (var3) {
                var10000 = new BranchLabel(var2);
                var8 = var10000;
                if (var4) {
                    switch ((this.field_715.field_674 & 255) >> 4) {
                        case 7:
                            var2.method_2306();
                            var2.method_2242(var8);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2242(var8);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2242(var8);
                            break;
                        case 10:
                            var2.method_2236(var8);
                            break;
                        default:
                            var2.method_2230(var8);
                    }
                } else {
                    switch ((this.field_715.field_674 & 255) >> 4) {
                        case 7:
                            var2.method_2306();
                            var2.method_2237(var8);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2237(var8);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2237(var8);
                            break;
                        case 10:
                            var2.method_2231(var8);
                            break;
                        default:
                            var2.method_2229(var8);
                    }
                }
                var2.method_2222();
                if ((this.field_446 & 16) != 0) {
                    var2.method_2182(this.field_674);
                    var2.generateReturnBytecode(this);
                    var8.place();
                    var2.method_2221();
                } else {
                    var10000 = new BranchLabel(var2);
                    var6 = var10000;
                    var2.method_2209(var6);
                    var2.method_2125(1);
                    var8.place();
                    var2.method_2221();
                    var6.place();
                }
            }
        }
    }

    public void method_1000(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = var2.field_1208;
        Constant var7 = this.field_716.constant;
        if (this.field_716.constant != Constant.NotAConstant && (this.field_715.field_674 & 255) >> 4 == 10 && var7.intValue() == 0) {
            this.field_715.generateCode(var1, var2, var5);
            if (var5) {
                if (var4 == null) {
                    if (var3 != null) {
                        var2.method_2237(var3);
                    }
                } else if (var3 == null) {
                    var2.method_2242(var4);
                }
            }
            var2.method_2360(var6, this.field_444);
        } else {
            var7 = this.field_715.constant;
            if (this.field_715.constant != Constant.NotAConstant && (this.field_715.field_674 & 255) >> 4 == 10 && var7.intValue() == 0) {
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2237(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2242(var4);
                    }
                }
                var2.method_2360(var6, this.field_444);
            } else if (this.field_716 instanceof NullLiteral) {
                if (this.field_715 instanceof NullLiteral) {
                    if (var5 && var4 == null && var3 != null) {
                        var2.method_2209(var3);
                    }
                } else {
                    this.field_715.generateCode(var1, var2, var5);
                    if (var5) {
                        if (var4 == null) {
                            if (var3 != null) {
                                var2.method_2244(var3);
                            }
                        } else if (var3 == null) {
                            var2.method_2243(var4);
                        }
                    }
                }
                var2.method_2360(var6, this.field_444);
            } else if (this.field_715 instanceof NullLiteral) {
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2244(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2243(var4);
                    }
                }
                var2.method_2360(var6, this.field_444);
            } else {
                this.field_715.generateCode(var1, var2, var5);
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            switch ((this.field_715.field_674 & 255) >> 4) {
                                case 7:
                                    var2.method_2306();
                                    var2.method_2237(var3);
                                    break;
                                case 8:
                                    var2.method_2121();
                                    var2.method_2237(var3);
                                    break;
                                case 9:
                                    var2.method_2156();
                                    var2.method_2237(var3);
                                    break;
                                case 10:
                                    var2.method_2231(var3);
                                    break;
                                default:
                                    var2.method_2229(var3);
                            }
                        }
                    } else if (var3 == null) {
                        switch ((this.field_715.field_674 & 255) >> 4) {
                            case 7:
                                var2.method_2306();
                                var2.method_2242(var4);
                                break;
                            case 8:
                                var2.method_2121();
                                var2.method_2242(var4);
                                break;
                            case 9:
                                var2.method_2156();
                                var2.method_2242(var4);
                                break;
                            case 10:
                                var2.method_2236(var4);
                                break;
                            default:
                                var2.method_2230(var4);
                        }
                    }
                }
                var2.method_2360(var6, this.field_444);
            }
        }
    }

    public boolean isCompactableOperation() {
        return false;
    }

    public TypeBinding resolveType(BlockScope var1) {
        boolean var2;
        if (var2 = this.field_715 instanceof CastExpression) {
            this.field_715.field_446 |= 32;
        }
        TypeBinding var4 = this.field_715.resolveType(var1);
        boolean var3;
        if (var3 = this.field_716 instanceof CastExpression) {
            this.field_716.field_446 |= 32;
        }
        TypeBinding var5 = this.field_716.resolveType(var1);
        if (var4 != null && var5 != null) {
            boolean var6 = var1.compilerOptions().field_1928 >= 3211264L;
            TypeBinding var7 = var4;
            TypeBinding var8 = var5;
            if (var6) {
                if (var4 != TypeBinding.field_187 && var4.method_148()) {
                    if (!var5.method_148()) {
                        var8 = var1.environment().method_486(var5);
                    }
                } else if (var5 != TypeBinding.field_187 && var5.method_148()) {
                    var7 = var1.environment().method_486(var4);
                }
            }
            if (var7.method_148() && var8.method_148()) {
                int var14 = var7.id;
                int var16 = var8.id;
                int var15 = OperatorSignatures[18][(var14 << 4) + var16];
                this.field_715.computeConversion(var1, TypeBinding.wellKnownType(var1, var15 >>> 16 & 15), var4);
                this.field_716.computeConversion(var1, TypeBinding.wellKnownType(var1, var15 >>> 8 & 15), var5);
                this.field_446 |= var15 & 15;
                if ((var15 & 15) == 0) {
                    this.constant = Constant.NotAConstant;
                    var1.problemReporter().invalidOperator(this, var7, var8);
                    return null;
                } else {
                    if (var2 || var3) {
                        CastExpression.checkNeedForArgumentCasts(var1, 18, var15, this.field_715, var7.id, var2, this.field_716, var8.id, var3);
                    }
                    this.computeConstant(var7, var8);
                    return this.resolvedType = TypeBinding.field_186;
                }
            } else if ((!var7.method_148() || var7 == TypeBinding.field_187) && (!var8.method_148() || var8 == TypeBinding.field_187) && (this.checkCastTypesCompatibility(var1, var7, var8, (Expression)null) || this.checkCastTypesCompatibility(var1, var8, var7, (Expression)null))) {
                if (var8.id == 11 && var7.id == 11) {
                    this.computeConstant(var7, var8);
                } else {
                    this.constant = Constant.NotAConstant;
                }
                ReferenceBinding var9 = var1.method_609();
                this.field_715.computeConversion(var1, var9, var7);
                this.field_716.computeConversion(var1, var9, var8);
                boolean var10 = (this.field_715.field_446 & 16384) != 0;
                boolean var11 = (this.field_716.field_446 & 16384) != 0;
                if (var10 || var11) {
                    TypeBinding var12 = var10 ? ((CastExpression)this.field_715).field_684.resolvedType : var7;
                    TypeBinding var13 = var11 ? ((CastExpression)this.field_716).field_684.resolvedType : var8;
                    if (this.checkCastTypesCompatibility(var1, var12, var13, (Expression)null) || this.checkCastTypesCompatibility(var1, var13, var12, (Expression)null)) {
                        if (var10) {
                            var1.problemReporter().unnecessaryCast((CastExpression)this.field_715);
                        }
                        if (var11) {
                            var1.problemReporter().unnecessaryCast((CastExpression)this.field_716);
                        }
                    }
                }
                return this.resolvedType = TypeBinding.field_186;
            } else {
                this.constant = Constant.NotAConstant;
                var1.problemReporter().notCompatibleTypesError(this, var7, var8);
                return null;
            }
        } else {
            this.constant = Constant.NotAConstant;
            return null;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_715.traverse(var1, var2);
            this.field_716.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
