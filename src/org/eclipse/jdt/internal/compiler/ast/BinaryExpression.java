package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.OperatorExpression;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class BinaryExpression extends OperatorExpression {

    public Expression field_715;

    public Expression field_716;

    public Constant optimizedBooleanConstant;

    public BinaryExpression(Expression var1, Expression var2, int var3) {
        this.field_715 = var1;
        this.field_716 = var2;
        this.field_446 |= var3 << 6;
        this.field_444 = var1.field_444;
        this.field_445 = var2.field_445;
    }

    public BinaryExpression(BinaryExpression var1) {
        this.field_715 = var1.field_715;
        this.field_716 = var1.field_716;
        this.field_446 = var1.field_446;
        this.field_444 = var1.field_444;
        this.field_445 = var1.field_445;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.resolvedType.id == 11) {
            return this.field_716.analyseCode(var1, var2, this.field_715.analyseCode(var1, var2, var3).method_3109()).method_3109();
        } else {
            this.field_715.checkNPE(var1, var2, var3);
            UnconditionalFlowInfo var4 = this.field_715.analyseCode(var1, var2, var3).method_3109();
            this.field_716.checkNPE(var1, var2, var4);
            return this.field_716.analyseCode(var1, var2, var4).method_3109();
        }
    }

    public void computeConstant(BlockScope var1, int var2, int var3) {
        if (this.field_715.constant != Constant.NotAConstant && this.field_716.constant != Constant.NotAConstant) {
            try {
                this.constant = Constant.computeConstantOperation(this.field_715.constant, var2, (this.field_446 & 4032) >> 6, this.field_716.constant, var3);
            } catch (ArithmeticException var5) {
                this.constant = Constant.NotAConstant;
            }
        } else {
            this.constant = Constant.NotAConstant;
            this.optimizedBooleanConstant(var2, (this.field_446 & 4032) >> 6, var3);
        }
    }

    public Constant optimizedBooleanConstant() {
        return this.optimizedBooleanConstant == null ? this.constant : this.optimizedBooleanConstant;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.constant != Constant.NotAConstant) {
            if (var3) {
                var2.generateConstant(this.constant, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            BranchLabel var5;
            BranchLabel var6;
            BranchLabel var10004;
            BranchLabel var10001;
            label314:
            switch ((this.field_446 & 4032) >> 6) {
                case 2:
                    switch (this.field_446 & 15) {
                        case 5:
                            this.method_986(var1, var2, var3);
                            break label314;
                        case 7:
                            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 7 && this.field_715.constant.longValue() == 0L) {
                                this.field_716.generateCode(var1, var2, false);
                                if (var3) {
                                    var2.method_2307();
                                }
                            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 7 && this.field_716.constant.longValue() == 0L) {
                                this.field_715.generateCode(var1, var2, false);
                                if (var3) {
                                    var2.method_2307();
                                }
                            } else {
                                this.field_715.generateCode(var1, var2, var3);
                                this.field_716.generateCode(var1, var2, var3);
                                if (var3) {
                                    var2.method_2304();
                                }
                            }
                            break label314;
                        case 10:
                            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 10 && this.field_715.constant.intValue() == 0) {
                                this.field_716.generateCode(var1, var2, false);
                                if (var3) {
                                    var2.method_2221();
                                }
                            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 10 && this.field_716.constant.intValue() == 0) {
                                this.field_715.generateCode(var1, var2, false);
                                if (var3) {
                                    var2.method_2221();
                                }
                            } else {
                                this.field_715.generateCode(var1, var2, var3);
                                this.field_716.generateCode(var1, var2, var3);
                                if (var3) {
                                    var2.method_2219();
                                }
                            }
                        default:
                            break label314;
                    }
                case 3:
                    switch (this.field_446 & 15) {
                        case 5:
                            this.method_987(var1, var2, var3);
                            break label314;
                        case 7:
                            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 7 && this.field_715.constant.longValue() == 0L) {
                                this.field_716.generateCode(var1, var2, var3);
                            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 7 && this.field_716.constant.longValue() == 0L) {
                                this.field_715.generateCode(var1, var2, var3);
                            } else {
                                this.field_715.generateCode(var1, var2, var3);
                                this.field_716.generateCode(var1, var2, var3);
                                if (var3) {
                                    var2.method_2327();
                                }
                            }
                            break label314;
                        case 10:
                            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 10 && this.field_715.constant.intValue() == 0) {
                                this.field_716.generateCode(var1, var2, var3);
                            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 10 && this.field_716.constant.intValue() == 0) {
                                this.field_715.generateCode(var1, var2, var3);
                            } else {
                                this.field_715.generateCode(var1, var2, var3);
                                this.field_716.generateCode(var1, var2, var3);
                                if (var3) {
                                    var2.method_2283();
                                }
                            }
                        default:
                            break label314;
                    }
                case 4:
                    var10004 = new BranchLabel(var2);
                    var5 = var10004;
                    this.method_984(var1, var2, (BranchLabel)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.generateReturnBytecode(this);
                            var5.place();
                            var2.method_2221();
                        } else {
                            var10001 = new BranchLabel(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.place();
                            var2.method_2221();
                            var6.place();
                        }
                    }
                    break;
                case 5:
                    var10004 = new BranchLabel(var2);
                    var5 = var10004;
                    this.method_985(var1, var2, (BranchLabel)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.generateReturnBytecode(this);
                            var5.place();
                            var2.method_2221();
                        } else {
                            var10001 = new BranchLabel(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.place();
                            var2.method_2221();
                            var6.place();
                        }
                    }
                    break;
                case 6:
                    var10004 = new BranchLabel(var2);
                    var5 = var10004;
                    this.method_982(var1, var2, (BranchLabel)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.generateReturnBytecode(this);
                            var5.place();
                            var2.method_2221();
                        } else {
                            var10001 = new BranchLabel(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.place();
                            var2.method_2221();
                            var6.place();
                        }
                    }
                    break;
                case 7:
                    var10004 = new BranchLabel(var2);
                    var5 = var10004;
                    this.method_983(var1, var2, (BranchLabel)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.generateReturnBytecode(this);
                            var5.place();
                            var2.method_2221();
                        } else {
                            var10001 = new BranchLabel(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.place();
                            var2.method_2221();
                            var6.place();
                        }
                    }
                    break;
                case 8:
                    switch (this.field_446 & 15) {
                        case 5:
                            this.method_988(var1, var2, var3);
                            break label314;
                        case 7:
                            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 7 && this.field_715.constant.longValue() == 0L) {
                                this.field_716.generateCode(var1, var2, var3);
                            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 7 && this.field_716.constant.longValue() == 0L) {
                                this.field_715.generateCode(var1, var2, var3);
                            } else {
                                this.field_715.generateCode(var1, var2, var3);
                                this.field_716.generateCode(var1, var2, var3);
                                if (var3) {
                                    var2.method_2339();
                                }
                            }
                            break label314;
                        case 10:
                            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.typeID() == 10 && this.field_715.constant.intValue() == 0) {
                                this.field_716.generateCode(var1, var2, var3);
                            } else if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.typeID() == 10 && this.field_716.constant.intValue() == 0) {
                                this.field_715.generateCode(var1, var2, var3);
                            } else {
                                this.field_715.generateCode(var1, var2, var3);
                                this.field_716.generateCode(var1, var2, var3);
                                if (var3) {
                                    var2.method_2296();
                                }
                            }
                        default:
                            break label314;
                    }
                case 9:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, true);
                            this.field_716.generateCode(var1, var2, true);
                            var2.method_2316();
                            if (!var3) {
                                var2.method_2353();
                            }
                            break label314;
                        case 8:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2124();
                            }
                            break label314;
                        case 9:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2160();
                            }
                            break label314;
                        case 10:
                            this.field_715.generateCode(var1, var2, true);
                            this.field_716.generateCode(var1, var2, true);
                            var2.method_2228();
                            if (!var3) {
                                var2.method_2352();
                            }
                        default:
                            break label314;
                    }
                case 10:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2330();
                            }
                            break;
                        case 10:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2287();
                            }
                    }
                case 11:
                case 12:
                case 18:
                default:
                    break;
                case 13:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2337();
                            }
                            break label314;
                        case 8:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2140();
                            }
                            break label314;
                        case 9:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2175();
                            }
                            break label314;
                        case 10:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2294();
                            }
                        default:
                            break label314;
                    }
                case 14:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2302();
                            }
                            break label314;
                        case 8:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2117();
                            }
                            break label314;
                        case 9:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2152();
                            }
                            break label314;
                        case 10:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2217();
                            }
                            break label314;
                        case 11:
                            var2.generateStringConcatenationAppend(var1, this.field_715, this.field_716);
                            if (!var3) {
                                var2.method_2352();
                            }
                        default:
                            break label314;
                    }
                case 15:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2322();
                            }
                            break label314;
                        case 8:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2131();
                            }
                            break label314;
                        case 9:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2166();
                            }
                            break label314;
                        case 10:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2251();
                            }
                        default:
                            break label314;
                    }
                case 16:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, true);
                            this.field_716.generateCode(var1, var2, true);
                            var2.method_2328();
                            if (!var3) {
                                var2.method_2353();
                            }
                            break label314;
                        case 8:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2133();
                            }
                            break label314;
                        case 9:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2168();
                            }
                            break label314;
                        case 10:
                            this.field_715.generateCode(var1, var2, true);
                            this.field_716.generateCode(var1, var2, true);
                            var2.method_2284();
                            if (!var3) {
                                var2.method_2352();
                            }
                        default:
                            break label314;
                    }
                case 17:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2331();
                            }
                            break label314;
                        case 10:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2288();
                            }
                        default:
                            break label314;
                    }
                case 19:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2338();
                            }
                            break;
                        case 10:
                            this.field_715.generateCode(var1, var2, var3);
                            this.field_716.generateCode(var1, var2, var3);
                            if (var3) {
                                var2.method_2295();
                            }
                    }
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if (this.constant != Constant.NotAConstant && this.constant.typeID() == 5) {
            super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
        } else {
            switch ((this.field_446 & 4032) >> 6) {
                case 2:
                    this.method_989(var1, var2, var3, var4, var5);
                    return;
                case 3:
                    this.method_990(var1, var2, var3, var4, var5);
                    return;
                case 4:
                    this.method_984(var1, var2, var3, var4, var5);
                    return;
                case 5:
                    this.method_985(var1, var2, var3, var4, var5);
                    return;
                case 6:
                    this.method_982(var1, var2, var3, var4, var5);
                    return;
                case 7:
                    this.method_983(var1, var2, var3, var4, var5);
                    return;
                case 8:
                    this.method_991(var1, var2, var3, var4, var5);
                    return;
                default:
                    super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
            }
        }
    }

    public void method_982(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.intValue() == 0) {
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2241(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2238(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.intValue() == 0) {
                this.field_715.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2239(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2240(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2239(var3);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2239(var3);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2239(var3);
                            break;
                        case 10:
                            var2.method_2233(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2240(var4);
                        break;
                    case 8:
                        var2.method_2121();
                        var2.method_2240(var4);
                        break;
                    case 9:
                        var2.method_2156();
                        var2.method_2240(var4);
                        break;
                    case 10:
                        var2.method_2234(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_983(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.intValue() == 0) {
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2240(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2239(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.intValue() == 0) {
                this.field_715.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2238(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2241(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2238(var3);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2238(var3);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2238(var3);
                            break;
                        case 10:
                            var2.method_2232(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2241(var4);
                        break;
                    case 8:
                        var2.method_2121();
                        var2.method_2241(var4);
                        break;
                    case 9:
                        var2.method_2156();
                        var2.method_2241(var4);
                        break;
                    case 10:
                        var2.method_2235(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_984(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.intValue() == 0) {
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2239(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2240(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.intValue() == 0) {
                this.field_715.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2241(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2238(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2241(var3);
                            break;
                        case 8:
                            var2.method_2120();
                            var2.method_2241(var3);
                            break;
                        case 9:
                            var2.method_2155();
                            var2.method_2241(var3);
                            break;
                        case 10:
                            var2.method_2235(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2238(var4);
                        break;
                    case 8:
                        var2.method_2120();
                        var2.method_2238(var4);
                        break;
                    case 9:
                        var2.method_2155();
                        var2.method_2238(var4);
                        break;
                    case 10:
                        var2.method_2232(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_985(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.constant != Constant.NotAConstant && this.field_715.constant.intValue() == 0) {
                this.field_716.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2238(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2241(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.constant != Constant.NotAConstant && this.field_716.constant.intValue() == 0) {
                this.field_715.generateCode(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2240(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2239(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2240(var3);
                            break;
                        case 8:
                            var2.method_2120();
                            var2.method_2240(var3);
                            break;
                        case 9:
                            var2.method_2155();
                            var2.method_2240(var3);
                            break;
                        case 10:
                            var2.method_2234(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2239(var4);
                        break;
                    case 8:
                        var2.method_2120();
                        var2.method_2239(var4);
                        break;
                    case 9:
                        var2.method_2155();
                        var2.method_2239(var4);
                        break;
                    case 10:
                        var2.method_2233(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_986(BlockScope var1, CodeStream var2, boolean var3) {
        if ((this.field_715.field_674 & 15) == 5) {
            Constant var4;
            if ((var4 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var4.booleanValue()) {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, var3);
                } else {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2221();
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
            if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var4.booleanValue()) {
                    this.field_715.generateCode(var1, var2, var3);
                    this.field_716.generateCode(var1, var2, false);
                } else {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2221();
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var3);
        this.field_716.generateCode(var1, var2, var3);
        if (var3) {
            var2.method_2219();
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_987(BlockScope var1, CodeStream var2, boolean var3) {
        if ((this.field_715.field_674 & 15) == 5) {
            Constant var4;
            if ((var4 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var4.booleanValue()) {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, var3);
                }
                return;
            }
            if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var4.booleanValue()) {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.generateCode(var1, var2, var3);
                    this.field_716.generateCode(var1, var2, false);
                }
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var3);
        this.field_716.generateCode(var1, var2, var3);
        if (var3) {
            var2.method_2283();
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_988(BlockScope var1, CodeStream var2, boolean var3) {
        if ((this.field_715.field_674 & 15) == 5) {
            Constant var4;
            if ((var4 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var4.booleanValue()) {
                    this.field_715.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                    this.field_716.generateCode(var1, var2, var3);
                    if (var3) {
                        var2.method_2296();
                        var2.method_2380(var1, var2.field_1208);
                    }
                } else {
                    this.field_715.generateCode(var1, var2, false);
                    this.field_716.generateCode(var1, var2, var3);
                }
                return;
            }
            if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var4.booleanValue()) {
                    this.field_715.generateCode(var1, var2, var3);
                    this.field_716.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                        var2.method_2296();
                        var2.method_2380(var1, var2.field_1208);
                    }
                } else {
                    this.field_715.generateCode(var1, var2, var3);
                    this.field_716.generateCode(var1, var2, false);
                }
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var3);
        this.field_716.generateCode(var1, var2, var3);
        if (var3) {
            var2.method_2296();
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_989(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if ((this.field_715.field_674 & 15) == 5) {
            Constant var6;
            if ((var6 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var6.booleanValue()) {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                } else {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    if (var5 && var4 != null) {
                        var2.method_2209(var4);
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
            if ((var6 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var6.booleanValue()) {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                } else {
                    BranchLabel var10000 = new BranchLabel(var2);
                    BranchLabel var7 = var10000;
                    this.field_715.generateOptimizedBoolean(var1, var2, var7, var4, false);
                    var7.place();
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    if (var5 && var4 != null) {
                        var2.method_2209(var4);
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            var2.method_2219();
            if (var4 == null) {
                if (var3 != null) {
                    var2.method_2242(var3);
                }
            } else if (var3 == null) {
                var2.method_2237(var4);
            }
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_990(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if ((this.field_715.field_674 & 15) == 5) {
            Constant var6;
            BranchLabel var7;
            BranchLabel var10000;
            if ((var6 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var6.booleanValue()) {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    var10000 = new BranchLabel(var2);
                    var7 = var10000;
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var7, false);
                    var7.place();
                    if (var5 && var3 != null) {
                        var2.method_2209(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                }
                return;
            }
            if ((var6 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var6.booleanValue()) {
                    var10000 = new BranchLabel(var2);
                    var7 = var10000;
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var7, false);
                    var7.place();
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    if (var5 && var3 != null) {
                        var2.method_2209(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                }
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            var2.method_2283();
            if (var4 == null) {
                if (var3 != null) {
                    var2.method_2242(var3);
                }
            } else if (var3 == null) {
                var2.method_2237(var4);
            }
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_991(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if ((this.field_715.field_674 & 15) == 5) {
            Constant var6;
            if ((var6 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var6.booleanValue()) {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    this.field_716.generateOptimizedBoolean(var1, var2, var4, var3, var5);
                } else {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, false);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                }
                return;
            }
            if ((var6 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                if (var6.booleanValue()) {
                    this.field_715.generateOptimizedBoolean(var1, var2, var4, var3, var5);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                } else {
                    this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                    this.field_716.generateOptimizedBoolean(var1, var2, var3, var4, false);
                }
                return;
            }
        }
        this.field_715.generateCode(var1, var2, var5);
        this.field_716.generateCode(var1, var2, var5);
        if (var5) {
            var2.method_2296();
            if (var4 == null) {
                if (var3 != null) {
                    var2.method_2242(var3);
                }
            } else if (var3 == null) {
                var2.method_2237(var4);
            }
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_914(BlockScope var1, CodeStream var2, int var3) {
        if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11) {
            if (this.constant != Constant.NotAConstant) {
                var2.generateConstant(this.constant, this.field_674);
                var2.method_2274(this.field_674 & 15);
            } else {
                int var4 = var2.field_1208;
                this.field_715.method_914(var1, var2, this.field_715.field_674 & 15);
                var2.method_2360(var4, this.field_715.field_444);
                var4 = var2.field_1208;
                this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
                var2.method_2360(var4, this.field_716.field_444);
            }
        } else {
            super.method_914(var1, var2, var3);
        }
    }

    public void method_915(BlockScope var1, CodeStream var2, int var3) {
        if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11) {
            if (this.constant != Constant.NotAConstant) {
                var2.method_2349();
                var2.method_2141();
                var2.ldc(this.constant.method_3287());
                var2.method_2276();
            } else {
                int var4 = var2.field_1208;
                this.field_715.method_915(var1, var2, this.field_715.field_674 & 15);
                var2.method_2360(var4, this.field_715.field_444);
                var4 = var2.field_1208;
                this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
                var2.method_2360(var4, this.field_716.field_444);
            }
        } else {
            super.method_915(var1, var2, var3);
        }
    }

    public boolean isCompactableOperation() {
        return true;
    }

    void nonRecursiveResolveTypeUpwards(BlockScope var1) {
        TypeBinding var4 = this.field_715.resolvedType;
        boolean var3;
        if (var3 = this.field_716 instanceof CastExpression) {
            this.field_716.field_446 |= 32;
        }
        TypeBinding var5 = this.field_716.resolveType(var1);
        if (var4 != null && var5 != null) {
            int var6 = var4.id;
            int var7 = var5.id;
            boolean var8 = var1.compilerOptions().field_1928 >= 3211264L;
            if (var8) {
                if (!var4.method_148() && var7 != 11 && var7 != 12) {
                    var6 = var1.environment().method_486(var4).id;
                }
                if (!var5.method_148() && var6 != 11 && var6 != 12) {
                    var7 = var1.environment().method_486(var5).id;
                }
            }
            if (var6 > 15 || var7 > 15) {
                if (var6 == 11) {
                    var7 = 1;
                } else {
                    if (var7 != 11) {
                        this.constant = Constant.NotAConstant;
                        var1.problemReporter().invalidOperator(this, var4, var5);
                        return;
                    }
                    var6 = 1;
                }
            }
            if ((this.field_446 & 4032) >> 6 == 14) {
                if (var6 == 11) {
                    this.field_715.computeConversion(var1, var4, var4);
                    if (var5.method_147() && ((ArrayBinding)var5).method_187() == TypeBinding.field_182) {
                        var1.problemReporter().method_1755(this.field_716);
                    }
                }
                if (var7 == 11) {
                    this.field_716.computeConversion(var1, var5, var5);
                    if (var4.method_147() && ((ArrayBinding)var4).method_187() == TypeBinding.field_182) {
                        var1.problemReporter().method_1755(this.field_715);
                    }
                }
            }
            int var9 = (this.field_446 & 4032) >> 6;
            int var10 = OperatorExpression.OperatorSignatures[var9][(var6 << 4) + var7];
            this.field_715.computeConversion(var1, TypeBinding.wellKnownType(var1, var10 >>> 16 & 15), var4);
            this.field_716.computeConversion(var1, TypeBinding.wellKnownType(var1, var10 >>> 8 & 15), var5);
            this.field_446 |= var10 & 15;
            switch (var10 & 15) {
                case 2:
                    this.resolvedType = TypeBinding.field_182;
                    break;
                case 3:
                    this.resolvedType = TypeBinding.field_180;
                    break;
                case 4:
                case 6:
                default:
                    this.constant = Constant.NotAConstant;
                    var1.problemReporter().invalidOperator(this, var4, var5);
                    return;
                case 5:
                    this.resolvedType = TypeBinding.field_186;
                    break;
                case 7:
                    this.resolvedType = TypeBinding.field_183;
                    break;
                case 8:
                    this.resolvedType = TypeBinding.field_185;
                    break;
                case 9:
                    this.resolvedType = TypeBinding.field_184;
                    break;
                case 10:
                    this.resolvedType = TypeBinding.field_179;
                    break;
                case 11:
                    this.resolvedType = var1.method_610();
            }
            boolean var2;
            if ((var2 = this.field_715 instanceof CastExpression) || var3) {
                CastExpression.checkNeedForArgumentCasts(var1, var9, var10, this.field_715, var6, var2, this.field_716, var7, var3);
            }
            this.computeConstant(var1, var6, var7);
        } else {
            this.constant = Constant.NotAConstant;
        }
    }

    public void optimizedBooleanConstant(int var1, int var2, int var3) {
        Constant var4;
        switch (var2) {
            case 2:
                if (var1 != 5 || var3 != 5) {
                    return;
                }
            case 0:
                if ((var4 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                    if (!var4.booleanValue()) {
                        this.optimizedBooleanConstant = var4;
                        return;
                    }
                    if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                        this.optimizedBooleanConstant = var4;
                    }
                    return;
                }
                if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant && !var4.booleanValue()) {
                    this.optimizedBooleanConstant = var4;
                }
                return;
            case 3:
                if (var1 != 5 || var3 != 5) {
                    return;
                }
            case 1:
                if ((var4 = this.field_715.optimizedBooleanConstant()) != Constant.NotAConstant) {
                    if (var4.booleanValue()) {
                        this.optimizedBooleanConstant = var4;
                        return;
                    }
                    if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant) {
                        this.optimizedBooleanConstant = var4;
                    }
                    return;
                } else if ((var4 = this.field_716.optimizedBooleanConstant()) != Constant.NotAConstant && var4.booleanValue()) {
                    this.optimizedBooleanConstant = var4;
                }
            default:
        }
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        this.field_715.printExpression(var1, var2).append(' ').append(this.operatorToString()).append(' ');
        return this.field_716.printExpression(0, var2);
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
            int var6 = var4.id;
            int var7 = var5.id;
            boolean var8 = var1.compilerOptions().field_1928 >= 3211264L;
            if (var8) {
                if (!var4.method_148() && var7 != 11 && var7 != 12) {
                    var6 = var1.environment().method_486(var4).id;
                }
                if (!var5.method_148() && var6 != 11 && var6 != 12) {
                    var7 = var1.environment().method_486(var5).id;
                }
            }
            if (var6 > 15 || var7 > 15) {
                if (var6 == 11) {
                    var7 = 1;
                } else {
                    if (var7 != 11) {
                        this.constant = Constant.NotAConstant;
                        var1.problemReporter().invalidOperator(this, var4, var5);
                        return null;
                    }
                    var6 = 1;
                }
            }
            if ((this.field_446 & 4032) >> 6 == 14) {
                if (var6 == 11) {
                    this.field_715.computeConversion(var1, var4, var4);
                    if (var5.method_147() && ((ArrayBinding)var5).method_187() == TypeBinding.field_182) {
                        var1.problemReporter().method_1755(this.field_716);
                    }
                }
                if (var7 == 11) {
                    this.field_716.computeConversion(var1, var5, var5);
                    if (var4.method_147() && ((ArrayBinding)var4).method_187() == TypeBinding.field_182) {
                        var1.problemReporter().method_1755(this.field_715);
                    }
                }
            }
            int var9 = (this.field_446 & 4032) >> 6;
            int var10 = OperatorExpression.OperatorSignatures[var9][(var6 << 4) + var7];
            this.field_715.computeConversion(var1, TypeBinding.wellKnownType(var1, var10 >>> 16 & 15), var4);
            this.field_716.computeConversion(var1, TypeBinding.wellKnownType(var1, var10 >>> 8 & 15), var5);
            this.field_446 |= var10 & 15;
            switch (var10 & 15) {
                case 2:
                    this.resolvedType = TypeBinding.field_182;
                    break;
                case 3:
                    this.resolvedType = TypeBinding.field_180;
                    break;
                case 4:
                case 6:
                default:
                    this.constant = Constant.NotAConstant;
                    var1.problemReporter().invalidOperator(this, var4, var5);
                    return null;
                case 5:
                    this.resolvedType = TypeBinding.field_186;
                    break;
                case 7:
                    this.resolvedType = TypeBinding.field_183;
                    break;
                case 8:
                    this.resolvedType = TypeBinding.field_185;
                    break;
                case 9:
                    this.resolvedType = TypeBinding.field_184;
                    break;
                case 10:
                    this.resolvedType = TypeBinding.field_179;
                    break;
                case 11:
                    this.resolvedType = var1.method_610();
            }
            if (var2 || var3) {
                CastExpression.checkNeedForArgumentCasts(var1, var9, var10, this.field_715, var6, var2, this.field_716, var7, var3);
            }
            this.computeConstant(var1, var6, var7);
            return this.resolvedType;
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
