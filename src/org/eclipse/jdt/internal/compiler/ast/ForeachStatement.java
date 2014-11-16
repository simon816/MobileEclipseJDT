package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.LoopingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ForeachStatement extends Statement {

    public LocalDeclaration elementVariable;

    public int elementVariableImplicitWidening;

    public Expression collection;

    public Statement action;

    private int kind;

    private TypeBinding field_517;

    private TypeBinding field_518;

    private BranchLabel field_519;

    private BranchLabel field_520;

    public BlockScope scope;

    public LocalVariableBinding field_522;

    public LocalVariableBinding field_523;

    public LocalVariableBinding field_524;

    private static final char[] field_525;

    private static final char[] field_526;

    private static final char[] field_527;

    int field_528;

    int field_529;

    public ForeachStatement(LocalDeclaration var1, int var2) {
        this.elementVariableImplicitWidening = -1;
        this.field_528 = -1;
        this.field_529 = -1;
        this.elementVariable = var1;
        this.field_444 = var2;
        this.kind = -1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        BranchLabel var10001 = new BranchLabel();
        this.field_519 = var10001;
        var10001 = new BranchLabel();
        this.field_520 = var10001;
        this.collection.checkNPE(var1, var2, var3);
        var3 = this.elementVariable.analyseCode(this.scope, var2, var3);
        FlowInfo var4 = this.collection.analyseCode(this.scope, var2, var3.method_3078());
        var4.method_3099(this.elementVariable.binding);
        this.field_528 = var1.method_635().recordInitializationStates(var4);
        LoopingFlowContext var10000 = new LoopingFlowContext(var2, var3, this, this.field_519, this.field_520, this.scope);
        LoopingFlowContext var5 = var10000;
        UnconditionalFlowInfo var6 = var4.method_3106();
        var6.method_3100(this.elementVariable.binding);
        FlowInfo var7;
        if (this.action != null && (!this.action.isEmptyBlock() || var1.compilerOptions().field_1927 > 3080192L)) {
            if (!this.action.method_816(var6, this.scope, false)) {
                var6 = this.action.analyseCode(this.scope, var5, var6).method_3107();
            }
            var7 = var3.method_3107().method_3071(var4.method_3080());
            if ((var6.tagBits & var5.initsOnContinue.tagBits & 1) != 0) {
                this.field_520 = null;
            } else {
                var6 = var6.mergedWith(var5.initsOnContinue);
                var5.method_3057(this.scope, var6);
                var7.method_3072(var6);
            }
        } else {
            var7 = var4.method_3080();
        }
        boolean var8 = this.action == null || this.action.isEmptyBlock() || (this.action.field_446 & 1) != 0;
        switch (this.kind) {
            case 0:
                if (!var8 || this.elementVariable.binding.field_306 != -1) {
                    this.field_523.field_307 = 1;
                    if (this.field_520 != null) {
                        this.field_522.field_307 = 1;
                        this.field_524.field_307 = 1;
                    }
                }
                break;
            case 1:
            case 2:
                this.field_522.field_307 = 1;
        }
        var5.method_3058(var1, var6);
        UnconditionalFlowInfo var9 = FlowInfo.mergedOptimizedBranches((FlowInfo)((var5.initsOnBreak.tagBits & 1) != 0 ? var5.initsOnBreak : var3.method_3071(var5.initsOnBreak)), false, var7, false, true);
        this.field_529 = var1.method_635().recordInitializationStates(var9);
        return var9;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            boolean var4 = this.action == null || this.action.isEmptyBlock() || (this.action.field_446 & 1) != 0;
            if (var4 && this.elementVariable.binding.field_306 == -1 && this.kind == 0) {
                this.collection.generateCode(this.scope, var2, false);
                var2.exitUserScope(this.scope);
                if (this.field_529 != -1) {
                    var2.method_2363(var1, this.field_529);
                    var2.method_2088(var1, this.field_529);
                }
                var2.method_2360(var3, this.field_444);
            } else {
                switch (this.kind) {
                    case 0:
                        this.collection.generateCode(this.scope, var2, true);
                        var2.store(this.field_523, true);
                        var2.addVariable(this.field_523);
                        if (this.field_520 != null) {
                            var2.method_2101();
                            var2.store(this.field_524, false);
                            var2.addVariable(this.field_524);
                            var2.method_2221();
                            var2.store(this.field_522, false);
                            var2.addVariable(this.field_522);
                        }
                        break;
                    case 1:
                    case 2:
                        this.collection.generateCode(this.scope, var2, true);
                        MethodBinding var10000 = new MethodBinding(1, "iterator".toCharArray(), this.scope.method_612(), Binding.field_150, Binding.field_151, (ReferenceBinding)this.field_517.erasure());
                        MethodBinding var5 = var10000;
                        if (this.field_517.method_157()) {
                            var2.method_2261(var5);
                        } else {
                            var2.method_2282(var5);
                        }
                        var2.store(this.field_522, false);
                        var2.addVariable(this.field_522);
                }
                BranchLabel var8 = new BranchLabel(var2);
                BranchLabel var9 = var8;
                var9.tagBits |= 2;
                var8 = new BranchLabel(var2);
                BranchLabel var6 = var8;
                var6.tagBits |= 2;
                this.field_519.initialize(var2);
                int var7;
                if (this.field_520 == null) {
                    var6.place();
                    var7 = var2.field_1208;
                    switch (this.kind) {
                        case 0:
                            var2.method_2101();
                            var2.method_2237(this.field_519);
                            break;
                        case 1:
                        case 2:
                            var2.load(this.field_522);
                            var2.method_2268();
                            var2.method_2237(this.field_519);
                    }
                    var2.method_2360(var7, this.elementVariable.field_444);
                } else {
                    this.field_520.initialize(var2);
                    this.field_520.tagBits |= 2;
                    var2.method_2209(var6);
                }
                var9.place();
                switch (this.kind) {
                    case 0:
                        if (this.elementVariable.binding.field_306 != -1) {
                            var2.load(this.field_523);
                            if (this.field_520 == null) {
                                var2.method_2221();
                            } else {
                                var2.load(this.field_522);
                            }
                            var2.method_2099(this.field_518.id);
                            if (this.elementVariableImplicitWidening != -1) {
                                var2.method_2182(this.elementVariableImplicitWidening);
                            }
                            var2.store(this.elementVariable.binding, false);
                            var2.method_2090(this.elementVariable.binding);
                            if (this.field_528 != -1) {
                                var2.method_2088(var1, this.field_528);
                            }
                        }
                        break;
                    case 1:
                    case 2:
                        var2.load(this.field_522);
                        var2.method_2269();
                        if (this.elementVariable.binding.type.id != 1) {
                            if (this.elementVariableImplicitWidening != -1) {
                                var2.method_2113(this.field_518);
                                var2.method_2182(this.elementVariableImplicitWidening);
                            } else {
                                var2.method_2113(this.elementVariable.binding.type);
                            }
                        }
                        if (this.elementVariable.binding.field_306 == -1) {
                            var2.method_2352();
                        } else {
                            var2.store(this.elementVariable.binding, false);
                            var2.method_2090(this.elementVariable.binding);
                            if (this.field_528 != -1) {
                                var2.method_2088(var1, this.field_528);
                            }
                        }
                }
                if (!var4) {
                    this.action.generateCode(this.scope, var2);
                }
                var2.method_2365(this.elementVariable.binding);
                if (this.field_528 != -1) {
                    var2.method_2363(var1, this.field_528);
                }
                if (this.field_520 != null) {
                    this.field_520.place();
                    var7 = var2.field_1208;
                    switch (this.kind) {
                        case 0:
                            if (!var4 || this.elementVariable.binding.field_306 >= 0) {
                                var2.iinc(this.field_522.field_306, 1);
                            }
                            var6.place();
                            var2.load(this.field_522);
                            var2.load(this.field_524);
                            var2.method_2235(var9);
                            break;
                        case 1:
                        case 2:
                            var6.place();
                            var2.load(this.field_522);
                            var2.method_2268();
                            var2.method_2242(var9);
                    }
                    var2.method_2360(var7, this.elementVariable.field_444);
                }
                switch (this.kind) {
                    case 0:
                        var2.method_2365(this.field_522);
                        var2.method_2365(this.field_524);
                        var2.method_2365(this.field_523);
                        break;
                    case 1:
                    case 2:
                        var2.method_2365(this.field_522);
                }
                var2.exitUserScope(this.scope);
                if (this.field_529 != -1) {
                    var2.method_2363(var1, this.field_529);
                    var2.method_2088(var1, this.field_529);
                }
                this.field_519.place();
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("for (");
        this.elementVariable.method_888(0, var2);
        var2.append(" : ");
        this.collection.print(0, var2).append(") ");
        if (this.action == null) {
            var2.append(';');
        } else {
            var2.append('\n');
            this.action.printStatement(var1 + 1, var2);
        }
        return var2;
    }

    public void resolve(BlockScope var1) {
        BlockScope var10001 = new BlockScope(var1);
        this.scope = var10001;
        this.elementVariable.resolve(this.scope);
        TypeBinding var2 = this.elementVariable.type.resolvedType;
        TypeBinding var3 = this.collection == null ? null : this.collection.resolveType(this.scope);
        if (var2 != null && var3 != null) {
            if (var3.method_147()) {
                this.kind = 0;
                this.collection.computeConversion(this.scope, var3, var3);
                this.field_518 = ((ArrayBinding)var3).method_187();
                if (!this.field_518.isCompatibleWith(var2) && !this.scope.isBoxingCompatibleWith(this.field_518, var2)) {
                    this.scope.problemReporter().method_1710(this.collection, this.field_518, var2);
                }
                int var4 = this.field_518.id;
                if (var2.method_148()) {
                    if (!this.field_518.method_148()) {
                        var4 = this.scope.environment().method_486(this.field_518).id;
                        this.elementVariableImplicitWidening = 1024;
                        if (var2.method_148()) {
                            this.elementVariableImplicitWidening |= (var2.id << 4) + var4;
                            this.scope.problemReporter().method_1485(this.collection, this.field_518, var2);
                        }
                    } else {
                        this.elementVariableImplicitWidening = (var2.id << 4) + var4;
                    }
                } else if (this.field_518.method_148()) {
                    int var5 = this.scope.environment().method_486(this.field_518).id;
                    this.elementVariableImplicitWidening = 512 | var4 << 4 | var4;
                    this.scope.problemReporter().method_1485(this.collection, this.field_518, var2);
                }
            } else if (var3 instanceof ReferenceBinding) {
                ReferenceBinding var9 = ((ReferenceBinding)var3).findSuperTypeOriginatingFrom(38, false);
                if (var9 != null) {
                    label90: {
                        this.field_517 = var3.erasure();
                        if (((ReferenceBinding)this.field_517).findSuperTypeOriginatingFrom(38, false) == null) {
                            this.field_517 = var9;
                            this.collection.computeConversion(this.scope, var9, var3);
                        } else {
                            this.collection.computeConversion(this.scope, var3, var3);
                        }
                        Object var10 = null;
                        switch (var9.kind()) {
                            case 260:
                                var10 = ((ParameterizedTypeBinding)var9).arguments;
                                break;
                            case 1028:
                                this.kind = 1;
                                this.field_518 = this.scope.method_609();
                                if (!this.field_518.isCompatibleWith(var2) && !this.scope.isBoxingCompatibleWith(this.field_518, var2)) {
                                    this.scope.problemReporter().method_1710(this.collection, this.field_518, var2);
                                }
                                break label90;
                            case 2052:
                                var10 = var9.typeVariables();
                                break;
                            default:
                                break label90;
                        }
                        if (((Object[])var10).length == 1) {
                            this.kind = 2;
                            this.field_518 = (TypeBinding)((Object[])var10)[0];
                            if (!this.field_518.isCompatibleWith(var2) && !this.scope.isBoxingCompatibleWith(this.field_518, var2)) {
                                this.scope.problemReporter().method_1710(this.collection, this.field_518, var2);
                            }
                            int var6 = this.field_518.id;
                            if (var2.method_148()) {
                                if (!this.field_518.method_148()) {
                                    var6 = this.scope.environment().method_486(this.field_518).id;
                                    this.elementVariableImplicitWidening = 1024;
                                    if (var2.method_148()) {
                                        this.elementVariableImplicitWidening |= (var2.id << 4) + var6;
                                    }
                                } else {
                                    this.elementVariableImplicitWidening = (var2.id << 4) + var6;
                                }
                            } else if (this.field_518.method_148()) {
                                int var7 = this.scope.environment().method_486(this.field_518).id;
                                this.elementVariableImplicitWidening = 512 | var6 << 4 | var6;
                            }
                        }
                    }
                }
            }
            LocalVariableBinding var8;
            switch (this.kind) {
                case 0:
                    var8 = new LocalVariableBinding(field_525, TypeBinding.field_179, 0, false);
                    this.field_522 = var8;
                    this.scope.addLocalVariable(this.field_522);
                    this.field_522.setConstant(Constant.NotAConstant);
                    var8 = new LocalVariableBinding(field_527, TypeBinding.field_179, 0, false);
                    this.field_524 = var8;
                    this.scope.addLocalVariable(this.field_524);
                    this.field_524.setConstant(Constant.NotAConstant);
                    var8 = new LocalVariableBinding(field_526, var3, 0, false);
                    this.field_523 = var8;
                    this.scope.addLocalVariable(this.field_523);
                    this.field_523.setConstant(Constant.NotAConstant);
                    break;
                case 1:
                case 2:
                    var8 = new LocalVariableBinding(field_525, this.scope.method_612(), 0, false);
                    this.field_522 = var8;
                    this.scope.addLocalVariable(this.field_522);
                    this.field_522.setConstant(Constant.NotAConstant);
                    break;
                default:
                    this.scope.problemReporter().method_1640(this.collection);
            }
        }
        if (this.action != null) {
            this.action.resolve(this.scope);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.elementVariable.traverse(var1, this.scope);
            this.collection.traverse(var1, this.scope);
            if (this.action != null) {
                this.action.traverse(var1, this.scope);
            }
        }
        var1.endVisit(this, var2);
    }

    static {
        field_525 = " index".toCharArray();
        field_526 = " collection".toCharArray();
        field_527 = " max".toCharArray();
    }
}
