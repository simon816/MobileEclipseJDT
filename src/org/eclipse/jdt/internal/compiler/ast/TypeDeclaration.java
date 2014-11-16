package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.InitializationFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.AbortType;
import org.eclipse.jdt.internal.compiler.problem.AbortMethod;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Util;

public class TypeDeclaration extends Statement implements ReferenceContext {

    public int field_577;

    public int field_578;

    public Annotation[] annotations;

    public char[] name;

    public TypeReference superclass;

    public TypeReference[] superInterfaces;

    public FieldDeclaration[] fields;

    public AbstractMethodDeclaration[] methods;

    public TypeDeclaration[] memberTypes;

    public SourceTypeBinding binding;

    public ClassScope scope;

    public MethodScope field_588;

    public MethodScope field_589;

    public boolean field_590;

    public int field_591;

    public int field_592;

    public int field_593;

    public int field_594;

    public int field_595;

    public CompilationResult compilationResult;

    public MethodDeclaration[] missingAbstractMethods;

    public QualifiedAllocationExpression allocation;

    public TypeDeclaration enclosingType;

    public FieldBinding enumValuesSyntheticfield;

    public TypeParameter[] typeParameters;

    public TypeDeclaration(CompilationResult var1) {
        this.field_577 = 0;
        this.field_590 = false;
        this.compilationResult = var1;
    }

    public void abort(int var1, CategorizedProblem var2) {
        switch (var1) {
            case 2:
                AbortCompilation var5 = new AbortCompilation(this.compilationResult, var2);
                throw var5;
            case 4:
                AbortCompilationUnit var4 = new AbortCompilationUnit(this.compilationResult, var2);
                throw var4;
            case 16:
                AbortMethod var10000 = new AbortMethod(this.compilationResult, var2);
                throw var10000;
            default:
                AbortType var3 = new AbortType(this.compilationResult, var2);
                throw var3;
        }
    }

    public final void addClinit() {
        if (this.needClassInitMethod()) {
            AbstractMethodDeclaration[] var2 = this.methods;
            if (this.methods == null) {
                boolean var1 = false;
                var2 = new AbstractMethodDeclaration[1];
            } else {
                int var4 = var2.length;
                System.arraycopy(var2, 0, var2 = new AbstractMethodDeclaration[var4 + 1], 1, var4);
            }
            Clinit var10000 = new Clinit(this.compilationResult);
            Clinit var3 = var10000;
            var2[0] = var3;
            var3.field_480 = var3.field_444 = this.field_444;
            var3.field_481 = var3.field_445 = this.field_445;
            var3.field_491 = this.field_445;
            this.methods = var2;
        }
    }

    public MethodDeclaration addMissingAbstractMethodFor(MethodBinding var1) {
        TypeBinding[] var2 = var1.parameters;
        int var3 = var2.length;
        MethodDeclaration var10000 = new MethodDeclaration(this.compilationResult);
        MethodDeclaration var4 = var10000;
        var4.selector = var1.selector;
        var4.field_444 = this.field_444;
        var4.field_445 = this.field_445;
        var4.field_482 = var1.method_352() & -1025;
        if (var3 > 0) {
            String var5 = "arg";
            Argument[] var6 = var4.arguments = new Argument[var3];
            int var7 = var3;
            while (true) {
                --var7;
                if (var7 < 0) {
                    break;
                }
                Argument var10002 = new Argument((var5 + var7).toCharArray(), 0L, (TypeReference)null, 0);
                var6[var7] = var10002;
            }
        }
        if (this.missingAbstractMethods == null) {
            this.missingAbstractMethods = new MethodDeclaration[] {var4};
        } else {
            MethodDeclaration[] var9;
            System.arraycopy(this.missingAbstractMethods, 0, var9 = new MethodDeclaration[this.missingAbstractMethods.length + 1], 1, this.missingAbstractMethods.length);
            var9[0] = var4;
            this.missingAbstractMethods = var9;
        }
        MethodBinding var10001 = new MethodBinding(var4.field_482 | 4096, var1.selector, var1.returnType, var3 == 0 ? Binding.field_150 : var2, var1.thrownExceptions, this.binding);
        var4.binding = var10001;
        MethodScope var8 = new MethodScope(this.scope, var4, true);
        var4.scope = var8;
        var4.method_787();
        return var4;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.field_590) {
            return var3;
        } else {
            try {
                if ((var3.tagBits & 1) == 0) {
                    this.field_446 |= Integer.MIN_VALUE;
                    LocalTypeBinding var4 = (LocalTypeBinding)this.binding;
                    var4.setConstantPoolName(var1.compilationUnitScope().computeConstantPoolName(var4));
                }
                this.manageEnclosingInstanceAccessIfNecessary(var1, var3);
                this.updateMaxFieldCount();
                this.internalAnalyseCode(var2, var3);
            } catch (AbortType var5) {
                this.field_590 = true;
            }
            return var3;
        }
    }

    public void analyseCode(ClassScope var1) {
        if (!this.field_590) {
            try {
                this.updateMaxFieldCount();
                this.internalAnalyseCode((FlowContext)null, FlowInfo.initial(this.field_591));
            } catch (AbortType var3) {
                this.field_590 = true;
            }
        }
    }

    public void analyseCode(ClassScope var1, FlowContext var2, FlowInfo var3) {
        if (!this.field_590) {
            try {
                if ((var3.tagBits & 1) == 0) {
                    this.field_446 |= Integer.MIN_VALUE;
                    LocalTypeBinding var4 = (LocalTypeBinding)this.binding;
                    var4.setConstantPoolName(var1.compilationUnitScope().computeConstantPoolName(var4));
                }
                this.manageEnclosingInstanceAccessIfNecessary(var1, var3);
                this.updateMaxFieldCount();
                this.internalAnalyseCode(var2, var3);
            } catch (AbortType var5) {
                this.field_590 = true;
            }
        }
    }

    public void analyseCode(CompilationUnitScope var1) {
        if (!this.field_590) {
            try {
                this.internalAnalyseCode((FlowContext)null, FlowInfo.initial(this.field_591));
            } catch (AbortType var3) {
                this.field_590 = true;
            }
        }
    }

    public boolean checkConstructors(Parser var1) {
        boolean var2 = false;
        if (this.methods != null) {
            int var3 = this.methods.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    break;
                }
                AbstractMethodDeclaration var4;
                if ((var4 = this.methods[var3]).method_795()) {
                    if (!CharOperation.method_1364(var4.selector, this.name)) {
                        ConstructorDeclaration var5 = (ConstructorDeclaration)var4;
                        if (var5.constructorCall == null || var5.constructorCall.method_831()) {
                            MethodDeclaration var6 = var1.convertToMethodDeclaration(var5, this.compilationResult);
                            this.methods[var3] = var6;
                        }
                    } else {
                        switch (kind(this.field_577)) {
                            case 2:
                                var1.problemReporter().method_1620((ConstructorDeclaration)var4);
                                break;
                            case 4:
                                var1.problemReporter().method_1470((ConstructorDeclaration)var4);
                        }
                        var2 = true;
                    }
                }
            }
        }
        return var2;
    }

    public CompilationResult compilationResult() {
        return this.compilationResult;
    }

    public ConstructorDeclaration createDefaultConstructor(boolean var1, boolean var2) {
        ConstructorDeclaration var10000 = new ConstructorDeclaration(this.compilationResult);
        ConstructorDeclaration var3 = var10000;
        var3.field_446 |= 128;
        var3.selector = this.name;
        var3.field_482 = this.field_577 & 7;
        var3.field_480 = var3.field_444 = this.field_444;
        var3.field_481 = var3.field_445 = var3.field_491 = this.field_445;
        if (var1) {
            var3.constructorCall = SuperReference.implicitSuperConstructorCall();
            var3.constructorCall.field_444 = this.field_444;
            var3.constructorCall.field_445 = this.field_445;
        }
        if (var2) {
            if (this.methods == null) {
                this.methods = new AbstractMethodDeclaration[] {var3};
            } else {
                AbstractMethodDeclaration[] var4;
                System.arraycopy(this.methods, 0, var4 = new AbstractMethodDeclaration[this.methods.length + 1], 1, this.methods.length);
                var4[0] = var3;
                this.methods = var4;
            }
        }
        return var3;
    }

    public MethodBinding method_852(MethodBinding var1) {
        String var2 = "$anonymous";
        TypeBinding[] var3 = var1.parameters;
        int var4 = var3.length;
        ConstructorDeclaration var10000 = new ConstructorDeclaration(this.compilationResult);
        ConstructorDeclaration var5 = var10000;
        var5.selector = new char[] {'x'};
        var5.field_444 = this.field_444;
        var5.field_445 = this.field_445;
        int var6 = this.field_577 & 7;
        if (var1.method_374()) {
            var6 |= 128;
        }
        var5.field_482 = var6;
        var5.field_446 |= 128;
        int var8;
        if (var4 > 0) {
            Argument[] var7 = var5.arguments = new Argument[var4];
            var8 = var4;
            while (true) {
                --var8;
                if (var8 < 0) {
                    break;
                }
                Argument var10002 = new Argument((var2 + var8).toCharArray(), 0L, (TypeReference)null, 0);
                var7[var8] = var10002;
            }
        }
        var5.constructorCall = SuperReference.implicitSuperConstructorCall();
        var5.constructorCall.field_444 = this.field_444;
        var5.constructorCall.field_445 = this.field_445;
        if (var4 > 0) {
            Expression[] var12 = var5.constructorCall.arguments = new Expression[var4];
            var8 = var4;
            while (true) {
                --var8;
                if (var8 < 0) {
                    break;
                }
                SingleNameReference var10 = new SingleNameReference((var2 + var8).toCharArray(), 0L);
                var12[var8] = var10;
            }
        }
        if (this.methods == null) {
            this.methods = new AbstractMethodDeclaration[] {var5};
        } else {
            AbstractMethodDeclaration[] var14;
            System.arraycopy(this.methods, 0, var14 = new AbstractMethodDeclaration[this.methods.length + 1], 1, this.methods.length);
            var14[0] = var5;
            this.methods = var14;
        }
        SourceTypeBinding var13 = this.binding;
        MethodBinding var10001 = new MethodBinding(var5.field_482, var4 == 0 ? Binding.field_150 : var3, var1.thrownExceptions, var13);
        var5.binding = var10001;
        var5.binding.tagBits |= var1.tagBits & 128L;
        var5.binding.modifiers |= 67108864;
        MethodScope var11 = new MethodScope(this.scope, var5, true);
        var5.scope = var11;
        var5.method_787();
        var5.constructorCall.resolve(var5.scope);
        MethodBinding[] var15 = var13.methods();
        int var9;
        System.arraycopy(var15, 0, var15 = new MethodBinding[(var9 = var15.length) + 1], 1, var9);
        var15[0] = var5.binding;
        ++var9;
        if (var9 > 1) {
            ReferenceBinding.sortMethods(var15, 0, var9);
        }
        var13.setMethods(var15);
        return var5.binding;
    }

    public FieldDeclaration declarationOf(FieldBinding var1) {
        if (var1 != null && this.fields != null) {
            int var2 = 0;
            for (int var3 = this.fields.length; var2 < var3; ++var2) {
                FieldDeclaration var4;
                if ((var4 = this.fields[var2]).binding == var1) {
                    return var4;
                }
            }
        }
        return null;
    }

    public AbstractMethodDeclaration declarationOf(MethodBinding var1) {
        if (var1 != null && this.methods != null) {
            int var2 = 0;
            for (int var3 = this.methods.length; var2 < var3; ++var2) {
                AbstractMethodDeclaration var4;
                if ((var4 = this.methods[var2]).binding == var1) {
                    return var4;
                }
            }
        }
        return null;
    }

    public void generateCode(ClassFile var1) {
        if ((this.field_446 & 8192) == 0) {
            this.field_446 |= 8192;
            if (this.field_590) {
                if (this.binding != null) {
                    ClassFile.createProblemType(this, this.scope.referenceCompilationUnit().compilationResult);
                }
            } else {
                try {
                    ClassFile var2 = ClassFile.getNewInstance(this.binding);
                    var2.initialize(this.binding, var1, false);
                    if (this.binding.method_159()) {
                        var2.recordInnerClasses(this.binding);
                    } else if (this.binding.method_158()) {
                        var1.recordInnerClasses(this.binding);
                        var2.recordInnerClasses(this.binding);
                    }
                    var2.method_2964();
                    int var3;
                    int var4;
                    if (this.memberTypes != null) {
                        var3 = 0;
                        for (var4 = this.memberTypes.length; var3 < var4; ++var3) {
                            TypeDeclaration var5 = this.memberTypes[var3];
                            var2.recordInnerClasses(var5.binding);
                            var5.generateCode(this.scope, var2);
                        }
                    }
                    var2.method_3017();
                    if (this.methods != null) {
                        var3 = 0;
                        for (var4 = this.methods.length; var3 < var4; ++var3) {
                            this.methods[var3].generateCode(this.scope, var2);
                        }
                    }
                    var2.method_2971();
                    if (this.field_590) {
                        AbortType var10000 = new AbortType(this.scope.referenceCompilationUnit().compilationResult, (CategorizedProblem)null);
                        throw var10000;
                    }
                    var2.method_2960();
                    this.scope.referenceCompilationUnit().compilationResult.record(this.binding.constantPoolName(), var2);
                } catch (AbortType var6) {
                    if (this.binding == null) {
                        return;
                    }
                    ClassFile.createProblemType(this, this.scope.referenceCompilationUnit().compilationResult);
                }
            }
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            if ((this.field_446 & 8192) == 0) {
                int var3 = var2.field_1208;
                if (this.binding != null) {
                    ((NestedTypeBinding)this.binding).method_327();
                }
                this.generateCode(var2.classFile);
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public void generateCode(ClassScope var1, ClassFile var2) {
        if ((this.field_446 & 8192) == 0) {
            if (this.binding != null) {
                ((NestedTypeBinding)this.binding).method_327();
            }
            this.generateCode(var2);
        }
    }

    public void method_857(CompilationUnitScope var1) {
        this.generateCode((ClassFile)null);
    }

    public boolean hasErrors() {
        return this.field_590;
    }

    private void internalAnalyseCode(FlowContext var1, FlowInfo var2) {
        if ((this.binding.method_223() || (this.binding.tagBits & 48L) == 16L) && !this.binding.method_229() && !this.scope.referenceCompilationUnit().compilationResult.field_1692) {
            this.scope.problemReporter().method_1815(this);
        }
        InitializationFlowContext var10000 = new InitializationFlowContext((FlowContext)null, this, this.field_588);
        InitializationFlowContext var3 = var10000;
        var10000 = new InitializationFlowContext((FlowContext)null, this, this.field_589);
        InitializationFlowContext var4 = var10000;
        Object var5 = var2.method_3108();
        Object var6 = var2.method_3108();
        int var7;
        int var8;
        if (this.fields != null) {
            var7 = 0;
            for (var8 = this.fields.length; var7 < var8; ++var7) {
                FieldDeclaration var9 = this.fields[var7];
                if (var9.isStatic()) {
                    if ((((FlowInfo)var6).tagBits & 1) != 0) {
                        var9.field_446 &= Integer.MAX_VALUE;
                    }
                    var4.handledExceptions = Binding.field_152;
                    var6 = var9.analyseCode(this.field_589, var4, (FlowInfo)var6);
                    if (var6 == FlowInfo.DEAD_END) {
                        this.field_589.problemReporter().method_1618(var9);
                        var6 = FlowInfo.initial(this.field_591).setReachMode(1);
                    }
                } else {
                    if ((((FlowInfo)var5).tagBits & 1) != 0) {
                        var9.field_446 &= Integer.MAX_VALUE;
                    }
                    var3.handledExceptions = Binding.field_152;
                    var5 = var9.analyseCode(this.field_588, var3, (FlowInfo)var5);
                    if (var5 == FlowInfo.DEAD_END) {
                        this.field_588.problemReporter().method_1618(var9);
                        var5 = FlowInfo.initial(this.field_591).setReachMode(1);
                    }
                }
            }
        }
        if (this.memberTypes != null) {
            var7 = 0;
            for (var8 = this.memberTypes.length; var7 < var8; ++var7) {
                if (var1 != null) {
                    this.memberTypes[var7].analyseCode(this.scope, var1, ((FlowInfo)var5).method_3078().setReachMode(var2.reachMode()));
                } else {
                    this.memberTypes[var7].analyseCode(this.scope);
                }
            }
        }
        if (this.methods != null) {
            UnconditionalFlowInfo var13 = var2.method_3108();
            FlowInfo var12 = ((FlowInfo)var5).method_3109().method_3115().method_3071(var13);
            int var14 = 0;
            for (int var10 = this.methods.length; var14 < var10; ++var14) {
                AbstractMethodDeclaration var11 = this.methods[var14];
                if (!var11.ignoreFurtherInvestigation) {
                    if (var11.method_797()) {
                        if (var11.method_799()) {
                            var11.analyseCode(this.scope, var4, ((FlowInfo)var6).method_3109().method_3115().method_3071(var13));
                        } else {
                            ((ConstructorDeclaration)var11).analyseCode(this.scope, var3, var12.method_3078(), var2.reachMode());
                        }
                    } else {
                        var11.analyseCode(this.scope, (InitializationFlowContext)null, var2.method_3078());
                    }
                }
            }
        }
        if (this.binding.method_153() && !this.binding.method_146()) {
            this.enumValuesSyntheticfield = this.binding.addSyntheticFieldForEnumValues();
        }
    }

    public static final int kind(int var0) {
        switch (var0 & 25088) {
            case 512:
                return 2;
            case 8704:
                return 4;
            case 16384:
                return 3;
            default:
                return 1;
        }
    }

    public void manageEnclosingInstanceAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            NestedTypeBinding var3 = (NestedTypeBinding)this.binding;
            MethodScope var4 = var1.method_635();
            if (!var4.field_404 && !var4.field_405) {
                var3.method_326(var3.enclosingType());
            }
            if (var3.method_146()) {
                ReferenceBinding var5 = (ReferenceBinding)var3.superclass.erasure();
                if (var5.enclosingType() != null && !var5.method_226() && (!var5.method_158() || ((NestedTypeBinding)var5).getSyntheticField(var5.enclosingType(), true) != null)) {
                    var3.method_324(var5.enclosingType());
                }
                if (!var4.field_404 && var4.field_405 && var1.compilerOptions().field_1927 >= 3211264L) {
                    ReferenceBinding var6 = var3.enclosingType();
                    if (var6.method_160()) {
                        NestedTypeBinding var7 = (NestedTypeBinding)var6;
                        SyntheticArgumentBinding var8 = var7.getSyntheticArgument(var7.enclosingType(), true);
                        if (var8 != null) {
                            var3.method_325(var8);
                        }
                    }
                }
            }
        }
    }

    public void manageEnclosingInstanceAccessIfNecessary(ClassScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            NestedTypeBinding var3 = (NestedTypeBinding)this.binding;
            var3.method_326(this.binding.enclosingType());
        }
    }

    public final boolean needClassInitMethod() {
        if ((this.field_446 & 1) != 0) {
            return true;
        } else {
            switch (kind(this.field_577)) {
                case 2:
                case 4:
                    return this.fields != null;
                case 3:
                    return true;
                default:
                    if (this.fields != null) {
                        int var1 = this.fields.length;
                        while (true) {
                            --var1;
                            if (var1 < 0) {
                                break;
                            }
                            FieldDeclaration var2 = this.fields[var1];
                            if ((var2.field_656 & 8) != 0) {
                                return true;
                            }
                        }
                    }
                    return false;
            }
        }
    }

    public void parseMethods(Parser var1, CompilationUnitDeclaration var2) {
        if (!var2.field_452) {
            int var3;
            int var4;
            if (this.memberTypes != null) {
                var3 = this.memberTypes.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.memberTypes[var4].parseMethods(var1, var2);
                }
            }
            if (this.methods != null) {
                var3 = this.methods.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.methods[var4].parseStatements(var1, var2);
                }
            }
            if (this.fields != null) {
                var3 = this.fields.length;
                var4 = 0;
                while (var4 < var3) {
                    FieldDeclaration var5 = this.fields[var4];
                    switch (var5.getKind()) {
                        case 2:
                            ((Initializer)var5).parseStatements(var1, this, var2);
                        default:
                            ++var4;
                    }
                }
            }
        }
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        if ((this.field_446 & 512) == 0) {
            method_759(var1, var2);
            this.method_865(0, var2);
        }
        return this.method_864(var1, var2);
    }

    public StringBuffer method_864(int var1, StringBuffer var2) {
        var2.append(" {");
        int var3;
        if (this.memberTypes != null) {
            for (var3 = 0; var3 < this.memberTypes.length; ++var3) {
                if (this.memberTypes[var3] != null) {
                    var2.append('\n');
                    this.memberTypes[var3].print(var1 + 1, var2);
                }
            }
        }
        if (this.fields != null) {
            for (var3 = 0; var3 < this.fields.length; ++var3) {
                if (this.fields[var3] != null) {
                    var2.append('\n');
                    this.fields[var3].print(var1 + 1, var2);
                }
            }
        }
        if (this.methods != null) {
            for (var3 = 0; var3 < this.methods.length; ++var3) {
                if (this.methods[var3] != null) {
                    var2.append('\n');
                    this.methods[var3].print(var1 + 1, var2);
                }
            }
        }
        var2.append('\n');
        return method_759(var1, var2).append('}');
    }

    public StringBuffer method_865(int var1, StringBuffer var2) {
        method_760(this.field_577, var2);
        if (this.annotations != null) {
            printAnnotations(this.annotations, var2);
        }
        switch (kind(this.field_577)) {
            case 1:
                var2.append("class ");
                break;
            case 2:
                var2.append("interface ");
                break;
            case 3:
                var2.append("enum ");
                break;
            case 4:
                var2.append("@interface ");
        }
        var2.append(this.name);
        int var3;
        if (this.typeParameters != null) {
            var2.append("<");
            for (var3 = 0; var3 < this.typeParameters.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.typeParameters[var3].print(0, var2);
            }
            var2.append(">");
        }
        if (this.superclass != null) {
            var2.append(" extends ");
            this.superclass.print(0, var2);
        }
        if (this.superInterfaces != null && this.superInterfaces.length > 0) {
            switch (kind(this.field_577)) {
                case 1:
                case 3:
                    var2.append(" implements ");
                    break;
                case 2:
                case 4:
                    var2.append(" extends ");
            }
            for (var3 = 0; var3 < this.superInterfaces.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.superInterfaces[var3].print(0, var2);
            }
        }
        return var2;
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        return this.print(var1, var2);
    }

    public void resolve() {
        SourceTypeBinding var1 = this.binding;
        if (var1 == null) {
            this.field_590 = true;
        } else {
            try {
                boolean var2 = this.field_589.field_412;
                try {
                    this.field_589.field_412 = true;
                    method_761(this.field_589, this.annotations, var1);
                } finally {
                    this.field_589.field_412 = var2;
                }
                if ((var1.getAnnotationTagBits() & 70368744177664L) == 0L && (var1.modifiers & 1048576) != 0 && this.scope.compilerOptions().field_1928 >= 3211264L) {
                    this.scope.problemReporter().method_1677(this);
                }
                if ((this.field_446 & 8) != 0) {
                    this.scope.problemReporter().method_1783(this.field_594 - 1, this.field_595);
                }
                boolean var3 = this.scope.compilerOptions().method_3313(4294967296L) != -1 && var1.method_151() && var1.findSuperTypeOriginatingFrom(56, false) == null && var1.findSuperTypeOriginatingFrom(37, false) != null;
                if (var3) {
                    CompilationUnitScope var4;
                    MethodBinding var5;
                    ReferenceBinding[] var6;
                    boolean var10000;
                    label617: {
                        var4 = this.scope.compilationUnitScope();
                        var5 = var1.getExactMethod(TypeConstants.field_40, new TypeBinding[0], var4);
                        if (var5 != null && var5.isValidBinding() && var5.returnType.id == 1) {
                            var6 = var5.thrownExceptions;
                            if (var5.thrownExceptions.length == 1 && var6[0].id == 57) {
                                var10000 = false;
                                break label617;
                            }
                        }
                        var10000 = true;
                    }
                    var3 = var10000;
                    if (var3) {
                        boolean var7 = false;
                        boolean var8 = false;
                        TypeBinding var9 = this.scope.getType(TypeConstants.field_133, 3);
                        if (var9.isValidBinding()) {
                            label606: {
                                var5 = var1.getExactMethod(TypeConstants.field_42, new TypeBinding[] {var9}, var4);
                                if (var5 != null && var5.isValidBinding() && var5.modifiers == 2 && var5.returnType == TypeBinding.field_188) {
                                    var6 = var5.thrownExceptions;
                                    if (var5.thrownExceptions.length == 1 && var6[0].id == 58) {
                                        var10000 = true;
                                        break label606;
                                    }
                                }
                                var10000 = false;
                            }
                            var7 = var10000;
                        }
                        var9 = this.scope.getType(TypeConstants.field_134, 3);
                        if (var9.isValidBinding()) {
                            label595: {
                                var5 = var1.getExactMethod(TypeConstants.field_41, new TypeBinding[] {var9}, var4);
                                if (var5 != null && var5.isValidBinding() && var5.modifiers == 2 && var5.returnType == TypeBinding.field_188) {
                                    var6 = var5.thrownExceptions;
                                    if (var5.thrownExceptions.length == 1 && var6[0].id == 58) {
                                        var10000 = true;
                                        break label595;
                                    }
                                }
                                var10000 = false;
                            }
                            var8 = var10000;
                        }
                        var3 = !var7 || !var8;
                    }
                }
                if (var1.findSuperTypeOriginatingFrom(21, true) != null) {
                    Object var17 = var1;
                    do {
                        if (((ReferenceBinding)var17).method_155()) {
                            this.scope.problemReporter().method_1558(this);
                            break;
                        }
                        if (((ReferenceBinding)var17).method_226()) {
                            break;
                        }
                        if (((ReferenceBinding)var17).method_158()) {
                            NestedTypeBinding var19 = (NestedTypeBinding)((ReferenceBinding)var17).erasure();
                            if (var19.scope.method_635().field_404) {
                                break;
                            }
                        }
                    } while ((var17 = ((ReferenceBinding)var17).enclosingType()) != null);
                }
                this.field_591 = 0;
                int var18 = -1;
                boolean var20 = false;
                FieldDeclaration[] var21 = null;
                int var23;
                int var22;
                if (this.typeParameters != null) {
                    var22 = 0;
                    for (var23 = this.typeParameters.length; var22 < var23; ++var22) {
                        this.typeParameters[var22].resolve(this.scope);
                    }
                }
                if (this.memberTypes != null) {
                    var22 = 0;
                    for (var23 = this.memberTypes.length; var22 < var23; ++var22) {
                        this.memberTypes[var22].resolve(this.scope);
                    }
                }
                if (this.fields != null) {
                    var22 = 0;
                    for (var23 = this.fields.length; var22 < var23; ++var22) {
                        FieldDeclaration var25 = this.fields[var22];
                        switch (var25.getKind()) {
                            case 2:
                                ((Initializer)var25).field_665 = var18 + 1;
                                break;
                            case 3:
                                var20 = true;
                                if (!(var25.initialization instanceof QualifiedAllocationExpression)) {
                                    if (var21 == null) {
                                        var21 = new FieldDeclaration[var23];
                                    }
                                    var21[var22] = var25;
                                }
                            case 1:
                                FieldBinding var10 = var25.binding;
                                if (var10 == null) {
                                    if (var25.initialization != null) {
                                        var25.initialization.resolve(var25.isStatic() ? this.field_589 : this.field_588);
                                    }
                                    this.field_590 = true;
                                    continue;
                                }
                                if (var3 && (var10.field_300 & 24) == 24 && CharOperation.method_1364(TypeConstants.field_37, var10.name) && TypeBinding.field_183 == var10.type) {
                                    var3 = false;
                                }
                                ++this.field_591;
                                var18 = var25.binding.field_304;
                        }
                        var25.resolve(var25.isStatic() ? this.field_589 : this.field_588);
                    }
                }
                if (var3) {
                    this.scope.problemReporter().method_1681(this);
                }
                int var11;
                int var27;
                switch (kind(this.field_577)) {
                    case 3:
                        if (this.binding.method_217()) {
                            AbstractMethodDeclaration var24;
                            if (!var20) {
                                var22 = 0;
                                for (var23 = this.methods.length; var22 < var23; ++var22) {
                                    var24 = this.methods[var22];
                                    if (var24.method_792() && var24.binding != null) {
                                        this.scope.problemReporter().method_1540(var24);
                                    }
                                }
                            } else if (var21 != null) {
                                var22 = 0;
                                for (var23 = this.methods.length; var22 < var23; ++var22) {
                                    var24 = this.methods[var22];
                                    if (var24.method_792() && var24.binding != null) {
                                        var27 = 0;
                                        for (var11 = var21.length; var27 < var11; ++var27) {
                                            if (var21[var27] != null) {
                                                this.scope.problemReporter().enumConstantMustImplementAbstractMethod(var24, var21[var27]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        if (this.superclass != null) {
                            this.scope.problemReporter().method_1471(this);
                        }
                        if (this.superInterfaces != null) {
                            this.scope.problemReporter().method_1472(this);
                        }
                }
                var22 = this.missingAbstractMethods == null ? 0 : this.missingAbstractMethods.length;
                var23 = this.methods == null ? 0 : this.methods.length;
                if (var23 + var22 > '\uffff') {
                    this.scope.problemReporter().method_1770(this);
                }
                int var28;
                if (this.methods != null) {
                    var28 = 0;
                    for (var27 = this.methods.length; var28 < var27; ++var28) {
                        this.methods[var28].resolve(this.scope);
                    }
                }
                if (!var1.method_158()) {
                    var28 = var1.modifiers & 7;
                    ProblemReporter var26 = this.scope.problemReporter();
                    var11 = var26.computeSeverity(-1610612250);
                    if (var11 != -1) {
                        if (this.enclosingType != null) {
                            var28 = Util.computeOuterMostVisibility(this.enclosingType, var28);
                        }
                        int var12 = this.binding.modifiers & -8 | var28;
                    }
                }
            } catch (AbortType var16) {
                this.field_590 = true;
            }
        }
    }

    public void resolve(BlockScope var1) {
        if ((this.field_446 & 512) == 0) {
            TypeBinding var2 = var1.getType(this.name);
            if (var2 instanceof ReferenceBinding && var2 != this.binding && var2.isValidBinding()) {
                ReferenceBinding var3 = (ReferenceBinding)var2;
                if (var3 instanceof TypeVariableBinding) {
                    var1.problemReporter().typeHiding(this, (TypeVariableBinding)var3);
                } else if (var3 instanceof LocalTypeBinding && ((LocalTypeBinding)var3).scope.method_635() == var1.method_635()) {
                    var1.problemReporter().method_1534(this);
                } else if (var1.method_628(var3)) {
                    var1.problemReporter().method_1772(this);
                } else if (var1.method_627(var3)) {
                    var1.problemReporter().typeHiding(this, var3);
                }
            }
            var1.addLocalType(this);
        }
        if (this.binding != null) {
            var1.referenceCompilationUnit().record((LocalTypeBinding)this.binding);
            this.resolve();
            this.updateMaxFieldCount();
        }
    }

    public void resolve(ClassScope var1) {
        if (this.binding != null && this.binding instanceof LocalTypeBinding) {
            var1.referenceCompilationUnit().record((LocalTypeBinding)this.binding);
        }
        this.resolve();
        this.updateMaxFieldCount();
    }

    public void method_868(CompilationUnitScope var1) {
        this.resolve();
        this.updateMaxFieldCount();
    }

    public void tagAsHavingErrors() {
        this.field_590 = true;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        try {
            if (var1.visit(this, var2)) {
                int var3;
                int var4;
                if (this.annotations != null) {
                    var3 = this.annotations.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.annotations[var4].traverse(var1, this.field_589);
                    }
                }
                if (this.superclass != null) {
                    this.superclass.traverse(var1, this.scope);
                }
                if (this.superInterfaces != null) {
                    var3 = this.superInterfaces.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.superInterfaces[var4].traverse(var1, this.scope);
                    }
                }
                if (this.typeParameters != null) {
                    var3 = this.typeParameters.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.typeParameters[var4].traverse(var1, this.scope);
                    }
                }
                if (this.memberTypes != null) {
                    var3 = this.memberTypes.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.memberTypes[var4].traverse(var1, this.scope);
                    }
                }
                if (this.fields != null) {
                    var3 = this.fields.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        FieldDeclaration var5;
                        if (!(var5 = this.fields[var4]).isStatic()) {
                            var5.traverse(var1, this.field_588);
                        }
                    }
                }
                if (this.methods != null) {
                    var3 = this.methods.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.methods[var4].traverse(var1, this.scope);
                    }
                }
            }
            var1.endVisit(this, var2);
        } catch (AbortType var6) {
            ;
        }
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        try {
            if (var1.visit(this, var2)) {
                int var3;
                int var4;
                if (this.annotations != null) {
                    var3 = this.annotations.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.annotations[var4].traverse(var1, this.field_589);
                    }
                }
                if (this.superclass != null) {
                    this.superclass.traverse(var1, this.scope);
                }
                if (this.superInterfaces != null) {
                    var3 = this.superInterfaces.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.superInterfaces[var4].traverse(var1, this.scope);
                    }
                }
                if (this.typeParameters != null) {
                    var3 = this.typeParameters.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.typeParameters[var4].traverse(var1, this.scope);
                    }
                }
                if (this.memberTypes != null) {
                    var3 = this.memberTypes.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.memberTypes[var4].traverse(var1, this.scope);
                    }
                }
                if (this.fields != null) {
                    var3 = this.fields.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        FieldDeclaration var5;
                        if ((var5 = this.fields[var4]).isStatic()) {
                            var5.traverse(var1, this.field_589);
                        } else {
                            var5.traverse(var1, this.field_588);
                        }
                    }
                }
                if (this.methods != null) {
                    var3 = this.methods.length;
                    for (var4 = 0; var4 < var3; ++var4) {
                        this.methods[var4].traverse(var1, this.scope);
                    }
                }
            }
            var1.endVisit(this, var2);
        } catch (AbortType var6) {
            ;
        }
    }

    void updateMaxFieldCount() {
        if (this.binding != null) {
            TypeDeclaration var1 = this.scope.method_640().referenceType();
            if (this.field_591 > var1.field_591) {
                var1.field_591 = this.field_591;
            } else {
                this.field_591 = var1.field_591;
            }
        }
    }
}
