package org.eclipse.jdt.internal.compiler.problem;

import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.IProblemFactory;
import org.eclipse.jdt.internal.compiler.ast.LabeledStatement;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.BranchStatement;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.AbstractVariableDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;
import org.eclipse.jdt.internal.compiler.ast.UnaryExpression;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.Literal;
import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AnnotationMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.ProblemHandler;
import org.eclipse.jdt.internal.compiler.util.Messages;

import java.util.List;

public class ProblemReporter extends ProblemHandler {

    public ReferenceContext referenceContext;

    private Scanner positionScanner;

    private static int getElaborationId(int var0, byte var1) {
        return var0 << 8 | var1;
    }

    public static long method_1457(int var0) {
        switch (var0) {
            case -1610612274:
            case -1610612273:
            case -1610612272:
            case -1610612271:
            case -1610612270:
            case -1610612269:
            case -1610612268:
            case -1610612267:
            case -1610612266:
            case -1610612264:
            case -1610612263:
            case -1610612262:
            case -1610612260:
            case -1610612258:
            case -1610612257:
            case -1610612256:
            case -1610612255:
            case -1610612254:
            case -1610612253:
            case -1610612252:
            case -1610612251:
            case -1610612249:
            case -1610612248:
            case -1610612247:
            case -1610612246:
            case -1610612245:
            case -1610612244:
            case -1610612243:
            case -1610612242:
            case -1610612241:
            case -1610612240:
            case -1610612239:
            case -1610612238:
            case -1610612237:
            case -1610612236:
            case -1610612235:
            case -1610612234:
            case -1610612233:
            case -1610612232:
            case -1610612231:
            case -1610612230:
            case -1610612229:
            case -1610612228:
            case -1610612227:
            case -1610612226:
            case -1610612225:
            case -1610612224:
            case -1610612223:
            case -1610612221:
            case -1610612220:
            case -1610612219:
            case -1610612218:
            case -1610612217:
            case -1610611886:
            case -1610611885:
            case -1610611884:
            case -1610611883:
            case -1610611882:
            case -1610611881:
            case -1610611880:
            case -1610611879:
            case -1610611878:
            case -1610611877:
                return 33554432L;
            case -1610612265:
            case -1610612261:
            case -1610612259:
                return 2097152L;
            case -1610612250:
                return 1048576L;
            case 16777221:
            case 33554505:
            case 67108967:
            case 67109276:
            case 134217861:
                return 4L;
            case 16777249:
            case 16777787:
            case 16777792:
            case 16777793:
                return 549755813888L;
            case 16777381:
                return 8L;
            case 16777496:
                return 8796093022208L;
            case 16777523:
                return 17179869184L;
            case 16777547:
                return 36028797018963968L;
            case 16777746:
            case 16777747:
            case 16777748:
            case 16777752:
            case 16777761:
            case 16777785:
            case 16777786:
            case 67109423:
            case 67109438:
                return 1073741824L;
            case 16777753:
                return 2147483648L;
            case 16777788:
                return 35184372088832L;
            case 16777842:
                return 274877906944L;
            case 33554622:
            case 33554623:
            case 67109056:
            case 67109057:
                return 128L;
            case 33555193:
                return 2199023255552L;
            case 67108974:
                return 1L;
            case 67109274:
                return 2L;
            case 67109277:
            case 67109278:
                return 16384L;
            case 67109280:
                return 562949953421312L;
            case 67109443:
            case 67109524:
                return 9007199254740992L;
            case 67109491:
                return 1099511627776L;
            case 67109665:
            case 134218530:
                return 34359738368L;
            case 268435844:
                return 1024L;
            case 536870971:
                return 140737488355328L;
            case 536870973:
                return 16L;
            case 536870974:
                return 32L;
            case 536871002:
            case 536871006:
            case 536871007:
            case 570425435:
                return 65536L;
            case 536871008:
                return 4294967296L;
            case 536871063:
                return 64L;
            case 536871090:
                return 8192L;
            case 536871091:
                return 262144L;
            case 536871092:
            case 553648316:
                return 524288L;
            case 536871096:
                return 16777216L;
            case 536871097:
            case 536871098:
                return 8388608L;
            case 536871101:
                return 536870912L;
            case 536871106:
                return 281474976710656L;
            case 536871111:
                return 70368744177664L;
            case 536871173:
            case 536871177:
                return 256L;
            case 536871352:
                return 512L;
            case 536871353:
                return 8589934592L;
            case 536871363:
                return 68719476736L;
            case 536871364:
                return 1125899906842624L;
            case 536871365:
            case 536871366:
            case 536871367:
            case 536871368:
            case 536871369:
            case 536871370:
                return 2251799813685248L;
            case 536871372:
                return 134217728L;
            case 536871540:
            case 536871541:
            case 536871542:
                return 4398046511104L;
            case 536871543:
                return 17592186044416L;
            case 536871547:
                return 18014398509481984L;
            case 536871632:
            case 536871633:
                return 137438953472L;
            case 553648135:
            case 570425421:
            case 603979894:
            case 603979910:
                return 32768L;
            case 553648146:
            case 570425422:
            case 603979895:
                return 268435456L;
            case 553648309:
            case 553648311:
                return 67108864L;
            case 570425420:
            case 603979893:
                return 2048L;
            case 570425423:
                return 4194304L;
            case 570425436:
            case 570425437:
                return 131072L;
            default:
                return 0L;
        }
    }

    public static int getProblemCategory(int var0, int var1) {
        if ((var0 & 128) == 0) {
            long var2 = method_1457(var1);
            int var4 = (int)var2;
            if ((long)var4 == var2) {
                switch (var4) {
                    case 1:
                    case 128:
                    case 512:
                    case 2048:
                    case 4194304:
                    case 134217728:
                    case 268435456:
                        return 80;
                    case 2:
                    case 16384:
                    case 65536:
                    case 131072:
                        return 100;
                    case 4:
                        return 110;
                    case 8:
                    case 64:
                    case 8192:
                    case 262144:
                    case 524288:
                    case 16777216:
                        return 90;
                    case 16:
                    case 32:
                    case 1024:
                    case '\u8000':
                    case 8388608:
                    case 67108864:
                    case 536870912:
                        return 120;
                    case 256:
                        return 140;
                    case 4096:
                        return 0;
                    case 1048576:
                    case 2097152:
                    case 33554432:
                    case 33554436:
                        return 70;
                    case 1073741824:
                        return 130;
                }
            } else {
                var4 = (int)(var2 >>> 32);
                switch (var4) {
                    case 0:
                    case 2:
                    case 32:
                    case 64:
                    case 256:
                    case 1024:
                    case '\u8000':
                        return 80;
                    case 1:
                    case 8:
                    case 16:
                    case 512:
                    case 65536:
                    case 131072:
                    case 262144:
                    case 524288:
                        return 90;
                    case 4:
                    case 2048:
                        return 150;
                    case 128:
                        return 100;
                    case 4096:
                    case 16384:
                    case 4194304:
                    case 8388608:
                        return 120;
                    case 8192:
                        return 130;
                }
            }
        }
        switch (var1) {
            case 16777540:
            case 536871612:
                return 10;
            default:
                return (var1 & 1073741824) != 0 ? 20 : ((var1 & 268435456) != 0 ? 30 : ((var1 & 16777216) != 0 ? 40 : ((var1 & 234881024) != 0 ? 50 : 60)));
        }
    }

    public ProblemReporter(IErrorHandlingPolicy var1, CompilerOptions var2, IProblemFactory var3) {
        super(var1, var2, var3);
    }

    public void abortDueToInternalError(String var1) {
        this.abortDueToInternalError(var1, (ASTNode)null);
    }

    public void abortDueToInternalError(String var1, ASTNode var2) {
        String[] var3 = new String[] {var1};
        this.handle(0, var3, var3, 159, var2 == null ? 0 : var2.field_444, var2 == null ? 0 : var2.field_445);
    }

    public void method_1461(SourceTypeBinding var1, MethodBinding var2) {
        this.handle(67109275, new String[] {new String(var1.method_179()), new String(CharOperation.concat(var2.declaringClass.readableName(), var2.readableName(), '.'))}, new String[] {new String(var1.method_179()), new String(CharOperation.concat(var2.declaringClass.shortReadableName(), var2.shortReadableName(), '.'))}, var1.method_318(), var1.method_317());
    }

    public void method_1462(SourceTypeBinding var1, AbstractMethodDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_179()), new String(var2.selector)};
        this.handle(67109227, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1463(SourceTypeBinding var1, MethodBinding var2) {
        if (var1.method_153() && var1.method_158()) {
            FieldBinding var3 = var1.scope.method_583().initializedField;
            FieldDeclaration var4 = var3.sourceField();
            this.handle(67109627, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var4.name)}, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var4.name)}, var4.method_5(), var4.method_6());
        } else {
            this.handle(67109264, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var2.declaringClass.readableName()), new String(var1.readableName())}, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var2.declaringClass.shortReadableName()), new String(var1.shortReadableName())}, var1.method_318(), var1.method_317());
        }
    }

    public void method_1464(AbstractMethodDeclaration var1) {
        this.handle(603979889, NoArgument, NoArgument, var1.field_444, var1.field_445, var1, var1.compilationResult());
    }

    public void alreadyDefinedLabel(char[] var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1)};
        this.handle(536871083, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1466(MethodBinding var1, MethodBinding var2) {
        AbstractMethodDeclaration var3 = var1.sourceMethod();
        this.handle(67109480, new String[] {new String(var1.declaringClass.readableName()), new String(var2.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var1.declaringClass.shortReadableName()), new String(var2.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, var3.field_444, var3.field_445);
    }

    public void annotationCircularity(TypeBinding var1, TypeBinding var2, TypeReference var3) {
        if (var1 == var2) {
            this.handle(16777822, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var3.field_444, var3.field_445);
        } else {
            this.handle(16777823, new String[] {new String(var1.readableName()), new String(var2.readableName())}, new String[] {new String(var1.shortReadableName()), new String(var2.shortReadableName())}, var3.field_444, var3.field_445);
        }
    }

    public void method_1468(AnnotationMethodDeclaration var1) {
        this.handle(1610613353, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1469(AnnotationMethodDeclaration var1) {
        this.handle(1610613354, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1470(ConstructorDeclaration var1) {
        this.handle(1610613360, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1471(TypeDeclaration var1) {
        this.handle(1610613355, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1472(TypeDeclaration var1) {
        this.handle(1610613356, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1473(SourceTypeBinding var1, TypeReference var2, ReferenceBinding var3) {
        this.handle(16777842, new String[] {new String(var3.readableName()), new String(var1.method_179())}, new String[] {new String(var3.shortReadableName()), new String(var1.method_179())}, var2.field_444, var2.field_445);
    }

    public void annotationValueMustBeAnnotation(TypeBinding var1, char[] var2, Expression var3, TypeBinding var4) {
        String var5 = new String(var2);
        this.handle(536871537, new String[] {new String(var1.readableName()), var5, new String(var4.readableName())}, new String[] {new String(var1.shortReadableName()), var5, new String(var4.readableName())}, var3.field_444, var3.field_445);
    }

    public void method_1475(TypeBinding var1, char[] var2, Expression var3) {
        String var4 = new String(var2);
        this.handle(536871544, new String[] {new String(var1.readableName()), var4}, new String[] {new String(var1.shortReadableName()), var4}, var3.field_444, var3.field_445);
    }

    public void method_1476(TypeBinding var1, char[] var2, Expression var3) {
        String var4 = new String(var2);
        this.handle(536871524, new String[] {new String(var1.readableName()), var4}, new String[] {new String(var1.shortReadableName()), var4}, var3.field_444, var3.field_445);
    }

    public void annotationValueMustBeConstant(TypeBinding var1, char[] var2, Expression var3, boolean var4) {
        String var5 = new String(var2);
        if (var4) {
            this.handle(536871545, new String[] {new String(var1.readableName()), var5}, new String[] {new String(var1.shortReadableName()), var5}, var3.field_444, var3.field_445);
        } else {
            this.handle(536871525, new String[] {new String(var1.readableName()), var5}, new String[] {new String(var1.shortReadableName()), var5}, var3.field_444, var3.field_445);
        }
    }

    public void method_1478(TypeReference var1, TypeBinding var2) {
        this.handle(16777245, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void argumentTypeCannotBeVoid(SourceTypeBinding var1, AbstractMethodDeclaration var2, Argument var3) {
        String[] var4 = new String[] {new String(var2.selector), new String(var3.name)};
        this.handle(67109228, var4, var4, var2.field_444, var2.field_445);
    }

    public void method_1480(int var1, int var2) {
        this.handle(1610612944, NoArgument, NoArgument, var1, var2);
    }

    public void assignmentHasNoEffect(AbstractVariableDeclaration var1, char[] var2) {
        int var3 = this.computeSeverity(536871090);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var2)};
            int var5 = var1.field_444;
            int var6 = var1.field_445;
            if (var1.initialization != null) {
                var6 = var1.initialization.field_445;
            }
            this.handle(536871090, var4, var4, var3, var5, var6);
        }
    }

    public void assignmentHasNoEffect(Assignment var1, char[] var2) {
        int var3 = this.computeSeverity(536871090);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var2)};
            this.handle(536871090, var4, var4, var3, var1.field_444, var1.field_445);
        }
    }

    public void attemptToReturnNonVoidExpression(ReturnStatement var1, TypeBinding var2) {
        this.handle(67108969, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void attemptToReturnVoidValue(ReturnStatement var1) {
        this.handle(67108970, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1485(Expression var1, TypeBinding var2, TypeBinding var3) {
        if (this.options.method_3313(137438953472L) != -1) {
            this.handle(var2.method_148() ? 536871632 : 536871633, new String[] {new String(var2.readableName()), new String(var3.readableName())}, new String[] {new String(var2.shortReadableName()), new String(var3.shortReadableName())}, var1.field_444, var1.field_445);
        }
    }

    public void method_1486(ASTNode var1, TypeBinding var2) {
        this.handle(16777784, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1487(ASTNode var1, TypeBinding var2) {
        this.handle(16777745, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1488(AbstractMethodDeclaration var1) {
        MethodBinding var2 = var1.binding;
        if (var1.method_795()) {
            this.handle(536870981, new String[] {new String(var1.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var1.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, 159, var1.field_444, var1.field_445);
        } else {
            this.handle(536870975, new String[] {new String(var1.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var1.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, 159, var1.field_444, var1.field_445);
        }
    }

    public void method_1489(TypeDeclaration var1) {
        this.handle(536870976, NoArgument, NoArgument, 159, var1.field_444, var1.field_445);
    }

    public void method_1490(Expression var1) {
        this.handle(536870966, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1491(FieldBinding var1, ASTNode var2) {
        this.handle(33554512, new String[] {var1.declaringClass == null ? "array" : new String(var1.declaringClass.readableName()), new String(var1.readableName())}, new String[] {var1.declaringClass == null ? "array" : new String(var1.declaringClass.shortReadableName()), new String(var1.shortReadableName())}, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1492(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(536870970, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1493(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(536870972, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1494(ArrayAllocationExpression var1) {
        this.handle(536871070, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1495(MessageSend var1, MethodBinding var2) {
        this.handle(67108968, new String[] {new String(var2.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, var1.field_444, var1.field_445);
    }

    public void method_1496(SourceTypeBinding var1, TypeReference var2, TypeBinding var3) {
        String var4 = new String(var1.method_179());
        String var5 = new String(var3.readableName());
        String var6 = new String(var3.shortReadableName());
        if (var6.equals(var4)) {
            var6 = var5;
        }
        this.handle(16777972, new String[] {var5, var4}, new String[] {var6, var4}, var2.field_444, var2.field_445);
    }

    public void method_1497(ImportReference var1) {
        String[] var2 = new String[] {CharOperation.toString(var1.tokens)};
        this.handle(268435843, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1498(TypeReference var1, TypeBinding var2) {
        this.handle(16777373, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void cannotInvokeSuperConstructorInEnum(ExplicitConstructorCall var1, MethodBinding var2) {
        this.handle(67109621, new String[] {new String(var2.declaringClass.method_179()), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var2.declaringClass.method_179()), this.typesAsString(var2.method_374(), var2.parameters, true)}, var1.field_444, var1.field_445);
    }

    public void cannotReadSource(CompilationUnitDeclaration var1, AbortCompilationUnit var2, boolean var3) {
        String var4 = new String(var1.compilationResult.field_1690);
        var2.exception.printStackTrace();
        String[] var5 = new String[] {var4, var2.exception.getClass().getName() + ": " + var2.exception.getMessage()};
        this.handle(536871614, var5, var5, 0, 0);
    }

    public void method_1501(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(536870937, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1502(ASTNode var1) {
        this.handle(536871074, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1503(ASTNode var1) {
        this.handle(536871089, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1504(ASTNode var1, TypeBinding var2) {
        this.handle(16777536, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1505(Reference var1, FieldBinding var2) {
        this.handle(33555187, new String[] {String.valueOf(var2.declaringClass.readableName()), String.valueOf(var2.name)}, new String[] {String.valueOf(var2.declaringClass.shortReadableName()), String.valueOf(var2.name)}, this.method_1695(var2, var1), this.method_1693(var2, var1));
    }

    public void method_1506(ASTNode var1) {
        this.handle(16777217, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1507(Expression var1) {
        this.handle(536871065, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1508(SourceTypeBinding var1, TypeReference var2, TypeBinding var3) {
        String var4 = new String(var1.method_179());
        String var5 = new String(var3.readableName());
        String var6 = new String(var3.shortReadableName());
        if (var6.equals(var4)) {
            var6 = var5;
        }
        this.handle(16777529, new String[] {var5, var4}, new String[] {var6, var4}, var2.field_444, var2.field_445);
    }

    public int computeSeverity(int var1) {
        switch (var1) {
            case -1610612273:
                if (!"all_standard_tags".equals(this.options.field_1952)) {
                    return -1;
                }
                break;
            case -1610612271:
            case -1610612247:
            case -1610612243:
            case -1610612239:
            case -1610612232:
                if (!this.options.field_1949 || !this.options.field_1951) {
                    return -1;
                }
                break;
            case -1610612270:
            case -1610612268:
            case -1610612264:
            case -1610612263:
            case -1610612262:
            case -1610612258:
            case -1610612256:
            case -1610612255:
            case -1610612254:
            case -1610612248:
            case -1610612246:
            case -1610612244:
            case -1610612242:
            case -1610612240:
            case -1610612238:
            case -1610612236:
            case -1610612235:
            case -1610612234:
            case -1610612233:
            case -1610612231:
            case -1610612229:
            case -1610612228:
            case -1610612227:
            case -1610612226:
            case -1610612225:
            case -1610612219:
            case -1610611886:
            case -1610611885:
            case -1610611884:
            case -1610611883:
            case -1610611882:
            case -1610611881:
            case -1610611880:
            case -1610611879:
            case -1610611878:
            case -1610611877:
                if (!this.options.field_1949) {
                    return -1;
                }
                break;
            case -1610612245:
            case -1610612241:
            case -1610612237:
            case -1610612230:
                if (!this.options.field_1949 || !this.options.field_1950) {
                    return -1;
                }
                break;
            case -1610612220:
                if ("no_tag".equals(this.options.field_1952)) {
                    return -1;
                }
                break;
            case 16777538:
                return 0;
            case 67109667:
                return 0;
            case 536871362:
                return 0;
        }
        long var2 = method_1457(var1);
        return var2 != 0L ? ((var1 & Integer.MIN_VALUE) != 0 && !this.options.field_1958 ? -1 : this.options.method_3313(var2)) : 129;
    }

    public void conditionalArgumentsIncompatibleTypes(ConditionalExpression var1, TypeBinding var2, TypeBinding var3) {
        this.handle(16777232, new String[] {new String(var2.readableName()), new String(var3.readableName())}, new String[] {new String(var2.method_179()), new String(var3.method_179())}, var1.field_444, var1.field_445);
    }

    public void method_1510(ImportReference var1) {
        String[] var2 = new String[] {CharOperation.toString(var1.tokens)};
        this.handle(268435841, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1511(NumberLiteral var1) {
        if (var1 instanceof LongLiteral || var1 instanceof IntLiteral) {
            char[] var2 = var1.source();
            try {
                String var3;
                byte var4;
                if (var2[1] != 120 && var2[1] != 88) {
                    var4 = 8;
                    var3 = "Octal";
                } else {
                    var4 = 16;
                    var3 = "Hex";
                }
                int var5 = -1;
                for (int var6 = var4 == 8 ? 1 : 2; var6 < var2.length; ++var6) {
                    if (ScannerHelper.digit(var2[var6], var4) == -1) {
                        var5 = var6;
                        break;
                    }
                }
                String[] var8 = new String[] {new String(var1.literalType((BlockScope)null).readableName()), var3 + " " + new String(var2) + " (digit " + new String(new char[]{var2[var5]}) + ")"};
                this.handle(536871066, var8, var8, var1.field_444, var1.field_445);
                return;
            } catch (IndexOutOfBoundsException var7) {
                this.constantOutOfRange(var1, var1.literalType((BlockScope)null));
            }
        }
    }

    public void constantOutOfRange(Literal var1, TypeBinding var2) {
        String[] var3 = new String[] {new String(var2.readableName()), new String(var1.source())};
        this.handle(536871066, var3, var3, var1.field_444, var1.field_445);
    }

    public void corruptedSignature(TypeBinding var1, char[] var2, int var3) {
        this.handle(536871612, new String[] {new String(var1.readableName()), new String(var2), String.valueOf(var3)}, new String[] {new String(var1.shortReadableName()), new String(var2), String.valueOf(var3)}, 159, 0, 0);
    }

    public void method_1514(FieldBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(33554505);
        if (var3 != -1) {
            this.handle(33554505, new String[] {new String(var1.declaringClass.readableName()), new String(var1.name)}, new String[] {new String(var1.declaringClass.shortReadableName()), new String(var1.name)}, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1515(MethodBinding var1, ASTNode var2) {
        boolean var3 = var1.method_358();
        int var4 = this.computeSeverity(var3 ? 134217861 : 67108967);
        if (var4 != -1) {
            if (var3) {
                this.handle(134217861, new String[] {new String(var1.declaringClass.readableName()), this.typesAsString(var1.method_374(), var1.parameters, false)}, new String[] {new String(var1.declaringClass.shortReadableName()), this.typesAsString(var1.method_374(), var1.parameters, true)}, var4, var2.field_444, var2.field_445);
            } else {
                this.handle(67108967, new String[] {new String(var1.declaringClass.readableName()), new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, false)}, new String[] {new String(var1.declaringClass.shortReadableName()), new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, true)}, var4, var2.field_444, var2.field_445);
            }
        }
    }

    public void method_1516(TypeBinding var1, ASTNode var2) {
        if (var2 != null) {
            int var3 = this.computeSeverity(16777221);
            if (var3 != -1) {
                var1 = var1.method_173();
                this.handle(16777221, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var3, var2.field_444, this.method_1693((Binding)null, var2));
            }
        }
    }

    public void method_1517(Annotation var1) {
        this.handle(16777838, new String[] {new String(var1.resolvedType.readableName())}, new String[] {new String(var1.resolvedType.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1518(Annotation var1) {
        this.handle(16777824, new String[] {new String(var1.resolvedType.readableName())}, new String[] {new String(var1.resolvedType.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1519(TypeBinding var1, MemberValuePair var2) {
        String var3 = new String(var2.name);
        this.handle(536871522, new String[] {var3, new String(var1.readableName())}, new String[] {var3, new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1520(ASTNode var1, TypeBinding var2) {
        this.handle(16777783, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1521(CaseStatement var1) {
        this.handle(33554602, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1522(ASTNode var1) {
        this.handle(536871078, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1523(SourceTypeBinding var1, AbstractMethodDeclaration var2) {
        MethodBinding var3 = var2.binding;
        this.handle(67109618, new String[] {new String(var2.selector), new String(var3.declaringClass.readableName()), this.typesAsString(var3.method_374(), var3.parameters, false)}, new String[] {new String(var2.selector), new String(var3.declaringClass.shortReadableName()), this.typesAsString(var3.method_374(), var3.parameters, true)}, var2.field_444, var2.field_445);
    }

    public void method_1524(SourceTypeBinding var1, FieldDeclaration var2) {
        this.handle(33554772, new String[] {new String(var1.method_179()), new String(var2.name)}, new String[] {new String(var1.shortReadableName()), new String(var2.name)}, var2.field_444, var2.field_445);
    }

    public void method_1525(ImportReference var1) {
        String[] var2 = new String[] {CharOperation.toString(var1.tokens)};
        this.handle(268435842, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1526(SourceTypeBinding var1, MethodBinding var2, MethodBinding var3) {
        this.handle(67109429, new String[] {new String(var2.selector), new String(var2.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.original().parameters, false), this.typesAsString(var3.method_374(), var3.original().parameters, false)}, new String[] {new String(var2.selector), new String(var2.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.original().parameters, true), this.typesAsString(var3.method_374(), var3.original().parameters, true)}, var1.method_318(), var1.method_317());
    }

    public void duplicateInitializationOfBlankFinalField(FieldBinding var1, Reference var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(33554514, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1528(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(536870969, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void duplicateMethodInType(SourceTypeBinding var1, AbstractMethodDeclaration var2, boolean var3) {
        MethodBinding var4 = var2.binding;
        if (var3) {
            this.handle(67109219, new String[] {new String(var2.selector), new String(var4.declaringClass.readableName()), this.typesAsString(var4.method_374(), var4.parameters, false)}, new String[] {new String(var2.selector), new String(var4.declaringClass.shortReadableName()), this.typesAsString(var4.method_374(), var4.parameters, true)}, var2.field_444, var2.field_445);
        } else {
            int var5 = var4.parameters.length;
            TypeBinding[] var6 = new TypeBinding[var5];
            for (int var7 = 0; var7 < var5; ++var7) {
                var6[var7] = var4.parameters[var7].erasure();
            }
            this.handle(16777743, new String[] {new String(var2.selector), new String(var4.declaringClass.readableName()), this.typesAsString(var4.method_374(), var4.parameters, false), this.typesAsString(var4.method_374(), var6, false)}, new String[] {new String(var2.selector), new String(var4.declaringClass.shortReadableName()), this.typesAsString(var4.method_374(), var4.parameters, true), this.typesAsString(var4.method_374(), var6, true)}, var2.field_444, var2.field_445);
        }
    }

    public void method_1530(ReferenceBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var2.name)};
        this.handle(33554773, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1531(ReferenceBinding var1, AbstractMethodDeclaration var2) {
        this.handle(67109221, new String[] {new String(var1.method_179()), new String(var2.selector)}, new String[] {new String(var1.shortReadableName()), new String(var2.selector)}, var2.field_444, var2.field_445);
    }

    public void method_1532(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777517, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1533(LocalDeclaration var1, boolean var2) {
        String[] var3 = new String[] {new String(var1.name)};
        this.handle(var2 ? 67109232 : 67109259, var3, var3, var1.field_444, var1.field_445);
    }

    public void method_1534(TypeDeclaration var1) {
        String[] var2 = new String[] {new String(var1.name)};
        this.handle(16777535, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1535(SourceTypeBinding var1, TypeReference var2, ReferenceBinding var3) {
        this.handle(16777530, new String[] {new String(var3.readableName()), new String(var1.method_179())}, new String[] {new String(var3.shortReadableName()), new String(var1.method_179())}, var2.field_444, var2.field_445);
    }

    public void duplicateTargetInTargetAnnotation(TypeBinding var1, NameReference var2) {
        FieldBinding var3 = var2.fieldBinding();
        String var4 = new String(var3.name);
        this.handle(536871533, new String[] {var4, new String(var1.readableName())}, new String[] {var4, new String(var1.shortReadableName())}, this.method_1695(var3, var2), this.method_1693(var3, var2));
    }

    public void duplicateTypeParameterInType(TypeParameter var1) {
        this.handle(536871432, new String[] {new String(var1.name)}, new String[] {new String(var1.name)}, var1.field_444, var1.field_445);
    }

    public void method_1538(CompilationUnitDeclaration var1, TypeDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_771()), new String(var2.name)};
        this.referenceContext = var2;
        this.handle(16777539, var3, var3, var2.field_444, var2.field_445, var1.compilationResult);
    }

    public void method_1539(int var1, int var2) {
        this.handle(553648316, NoArgument, NoArgument, var1, var2);
    }

    public void method_1540(AbstractMethodDeclaration var1) {
        MethodBinding var2 = var1.binding;
        this.handle(67109622, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var2.declaringClass.readableName())}, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var2.declaringClass.shortReadableName())}, var1.method_5(), var1.method_6());
    }

    public void enumConstantMustImplementAbstractMethod(AbstractMethodDeclaration var1, FieldDeclaration var2) {
        MethodBinding var3 = var1.binding;
        this.handle(67109627, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, false), new String(var2.name)}, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, true), new String(var2.name)}, var2.method_5(), var2.method_6());
    }

    public void method_1542(Expression var1) {
        this.handle(1610613178, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1543(FieldBinding var1, ASTNode var2) {
        this.handle(33555194, new String[] {new String(var1.declaringClass.readableName()), new String(var1.name)}, new String[] {new String(var1.declaringClass.shortReadableName()), new String(var1.name)}, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1544(Reference var1, FieldBinding var2) {
        this.handle(33555191, new String[] {String.valueOf(var2.declaringClass.readableName()), String.valueOf(var2.name)}, new String[] {String.valueOf(var2.declaringClass.shortReadableName()), String.valueOf(var2.name)}, this.method_1695(var2, var1), this.method_1693(var2, var1));
    }

    public void errorNoMethodFor(MessageSend var1, TypeBinding var2, TypeBinding[] var3) {
        StringBuffer var4 = new StringBuffer();
        StringBuffer var5 = new StringBuffer();
        int var6 = 0;
        for (int var7 = var3.length; var6 < var7; ++var6) {
            if (var6 != 0) {
                var4.append(", ");
                var5.append(", ");
            }
            var4.append(new String(var3[var6].readableName()));
            var5.append(new String(var3[var6].shortReadableName()));
        }
        var6 = var2.method_147() ? 67108980 : 67108978;
        this.handle(var6, new String[] {new String(var2.readableName()), new String(var1.selector), var4.toString()}, new String[] {new String(var2.shortReadableName()), new String(var1.selector), var5.toString()}, var1.field_444, var1.field_445);
    }

    public void method_1546(ASTNode var1) {
        String[] var2 = new String[] {var1.method_754() ? "super" : "this"};
        this.handle(536871112, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1547(Expression var1) {
        this.handle(1610612959, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void fieldHiding(FieldDeclaration var1, Binding var2) {
        FieldBinding var3 = var1.binding;
        if (!CharOperation.method_1364(TypeConstants.field_37, var3.name) || !var3.method_431() || !var3.method_409() || TypeBinding.field_183 != var3.type) {
            if (!CharOperation.method_1364(TypeConstants.field_38, var3.name) || !var3.method_431() || !var3.method_409() || var3.type.method_136() != 1 || !CharOperation.method_1364(TypeConstants.field_48, var3.type.method_173().readableName())) {
                boolean var4 = var2 instanceof LocalVariableBinding;
                int var5 = this.computeSeverity(var4 ? 570425436 : 570425437);
                if (var5 != -1) {
                    if (var4) {
                        this.handle(570425436, new String[] {new String(var3.declaringClass.readableName()), new String(var3.name)}, new String[] {new String(var3.declaringClass.shortReadableName()), new String(var3.name)}, var5, this.method_1695(var2, var1), this.method_1693(var2, var1));
                    } else if (var2 instanceof FieldBinding) {
                        FieldBinding var6 = (FieldBinding)var2;
                        this.handle(570425437, new String[] {new String(var3.declaringClass.readableName()), new String(var3.name), new String(var6.declaringClass.readableName())}, new String[] {new String(var3.declaringClass.shortReadableName()), new String(var3.name), new String(var6.declaringClass.shortReadableName())}, var5, this.method_1695(var6, var1), this.method_1693(var6, var1));
                    }
                }
            }
        }
    }

    public void fieldsOrThisBeforeConstructorInvocation(ThisReference var1) {
        this.handle(134217866, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void finallyMustCompleteNormally(Block var1) {
        this.handle(536871096, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1551(MethodBinding var1, MethodBinding var2) {
        this.handle(67109265, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
    }

    public void finalVariableBound(TypeVariableBinding var1, TypeReference var2) {
        int var3 = this.computeSeverity(16777753);
        if (var3 != -1) {
            this.handle(16777753, new String[] {new String(var1.sourceName), new String(var2.resolvedType.readableName())}, new String[] {new String(var1.sourceName), new String(var2.resolvedType.shortReadableName())}, var3, var2.field_444, var2.field_445);
        }
    }

    public void forbiddenReference(FieldBinding var1, ASTNode var2, byte var3, String var4, int var5) {
        int var6 = this.computeSeverity(var5);
        if (var6 != -1) {
            this.handle(var5, new String[] {new String(var1.readableName())}, getElaborationId(16777523, (byte)(4 | var3)), new String[] {var4, new String(var1.shortReadableName()), new String(var1.declaringClass.shortReadableName())}, var6, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void forbiddenReference(MethodBinding var1, ASTNode var2, byte var3, String var4, int var5) {
        int var6 = this.computeSeverity(var5);
        if (var6 != -1) {
            if (var1.method_358()) {
                this.handle(var5, new String[] {new String(var1.readableName())}, getElaborationId(16777523, (byte)(8 | var3)), new String[] {var4, new String(var1.shortReadableName())}, var6, var2.field_444, var2.field_445);
            } else {
                this.handle(var5, new String[] {new String(var1.readableName())}, getElaborationId(16777523, (byte)(12 | var3)), new String[] {var4, new String(var1.shortReadableName()), new String(var1.declaringClass.shortReadableName())}, var6, var2.field_444, var2.field_445);
            }
        }
    }

    public void forbiddenReference(TypeBinding var1, ASTNode var2, byte var3, String var4, int var5) {
        if (var2 != null) {
            int var6 = this.computeSeverity(var5);
            if (var6 != -1) {
                this.handle(var5, new String[] {new String(var1.readableName())}, getElaborationId(16777523, var3), new String[] {var4, new String(var1.shortReadableName())}, var6, var2.field_444, var2.field_445);
            }
        }
    }

    public void method_1556(Reference var1, int var2, TypeBinding var3) {
        this.handle(570425419, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void forwardTypeVariableReference(ASTNode var1, TypeVariableBinding var2) {
        this.handle(16777744, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1558(TypeDeclaration var1) {
        TypeReference var2 = var1.binding.method_146() ? var1.allocation.type : var1.superclass;
        this.handle(16777773, new String[] {new String(var1.binding.readableName())}, new String[] {new String(var1.binding.shortReadableName())}, var2.field_444, var2.field_445);
    }

    private void handle(int var1, String[] var2, int var3, String[] var4, int var5, int var6, int var7) {
        this.handle(var1, var2, var3, var4, var5, var6, var7, this.referenceContext, this.referenceContext == null ? null : this.referenceContext.compilationResult());
        this.referenceContext = null;
    }

    private void handle(int var1, String[] var2, String[] var3, int var4, int var5) {
        this.handle(var1, var2, var3, var4, var5, this.referenceContext, this.referenceContext == null ? null : this.referenceContext.compilationResult());
        this.referenceContext = null;
    }

    private void handle(int var1, String[] var2, String[] var3, int var4, int var5, CompilationResult var6) {
        this.handle(var1, var2, var3, var4, var5, this.referenceContext, var6);
        this.referenceContext = null;
    }

    private void handle(int var1, String[] var2, String[] var3, int var4, int var5, int var6) {
        this.handle(var1, var2, 0, var3, var4, var5, var6);
    }

    public void method_1563(ReferenceBinding var1, ASTNode var2) {
        this.handle(16777381, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void hierarchyCircularity(SourceTypeBinding var1, ReferenceBinding var2, TypeReference var3) {
        boolean var4 = false;
        boolean var5 = false;
        int var6;
        int var7;
        if (var3 == null) {
            var6 = var1.method_318();
            var7 = var1.method_317();
        } else {
            var6 = var3.field_444;
            var7 = var3.field_445;
        }
        if (var1 == var2) {
            this.handle(16777532, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var6, var7);
        } else {
            this.handle(16777533, new String[] {new String(var1.readableName()), new String(var2.readableName())}, new String[] {new String(var1.shortReadableName()), new String(var2.shortReadableName())}, var6, var7);
        }
    }

    public void method_1565(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777543, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1566(ReferenceBinding var1, AbstractMethodDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_179()), new String(var2.selector)};
        this.handle(67109226, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1567(TypeVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.sourceName)};
        this.handle(16777791, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1568(TypeVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.sourceName)};
        this.handle(16777774, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1569(AnnotationMethodDeclaration var1) {
        this.handle(67109465, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1570(Argument var1) {
        this.handle(1610613536, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1571(TypeBinding var1, ASTNode var2) {
        this.handle(16777751, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1572(TypeBinding var1, ASTNode var2) {
        if (var1.method_169()) {
            this.handle(536871459, new String[] {new String(var1.readableName()), new String(var1.erasure().readableName())}, new String[] {new String(var1.shortReadableName()), new String(var1.erasure().shortReadableName())}, var2.field_444, var2.field_445);
        } else {
            this.handle(536871458, new String[] {new String(var1.readableName()), new String(var1.erasure().method_179())}, new String[] {new String(var1.shortReadableName()), new String(var1.erasure().method_179())}, var2.field_444, var2.field_445);
        }
    }

    public void method_1573(TypeDeclaration var1) {
        if (!this.isRecoveredName(var1.name)) {
            int var2 = 0;
            if ((var1.field_577 & 16384) != 0) {
                var2 = 536870943;
            } else if ((var1.field_577 & 8192) != 0) {
                var2 = 536870942;
            } else if ((var1.field_577 & 512) != 0) {
                var2 = 536870938;
            }
            if (var2 != 0) {
                String[] var3 = new String[] {new String(var1.name)};
                this.handle(var2, var3, var3, var1.field_444, var1.field_445);
            }
        }
    }

    public void method_1574(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777524, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1575(ReferenceBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var2.name)};
        this.handle(33554777, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1576(FieldDeclaration var1) {
        String var2 = new String(var1.name);
        this.handle(536871527, new String[] {new String(var1.binding.declaringClass.readableName()), var2}, new String[] {new String(var1.binding.declaringClass.shortReadableName()), var2}, var1.field_444, var1.field_445);
    }

    public void method_1577(AbstractMethodDeclaration var1) {
        this.handle(67109464, new String[] {new String(var1.binding.declaringClass.readableName()), new String(var1.selector)}, new String[] {new String(var1.binding.declaringClass.shortReadableName()), new String(var1.selector)}, var1.field_444, var1.field_445);
    }

    public void method_1578(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777820, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1579(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777819, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1580(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777518, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1581(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777966, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1582(ReferenceBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var2.name)};
        this.handle(33555183, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1583(AbstractMethodDeclaration var1) {
        this.handle(67109624, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1584(ReferenceBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var2.name)};
        this.handle(33554774, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1585(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777519, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1586(FieldDeclaration var1) {
        String var2 = new String(var1.name);
        this.handle(33554775, new String[] {new String(var1.binding.declaringClass.readableName()), var2}, new String[] {new String(var1.binding.declaringClass.shortReadableName()), var2}, var1.field_444, var1.field_445);
    }

    public void method_1587(AbstractMethodDeclaration var1) {
        this.handle(67109223, new String[] {new String(var1.binding.declaringClass.readableName()), new String(var1.selector), this.typesAsString(var1.binding.method_374(), var1.binding.parameters, false)}, new String[] {new String(var1.binding.declaringClass.shortReadableName()), new String(var1.selector), this.typesAsString(var1.binding.method_374(), var1.binding.parameters, true)}, var1.field_444, var1.field_445);
    }

    public void method_1588(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777522, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1589(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777968, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1590(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777520, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1591(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777969, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1592(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777521, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1593(AbstractMethodDeclaration var1) {
        this.handle(67109222, new String[] {new String(var1.selector), this.typesAsString(var1.binding.method_374(), var1.binding.parameters, false), new String(var1.binding.declaringClass.readableName())}, new String[] {new String(var1.selector), this.typesAsString(var1.binding.method_374(), var1.binding.parameters, true), new String(var1.binding.declaringClass.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1594(LocalDeclaration var1, boolean var2) {
        String[] var3 = new String[] {new String(var1.name)};
        this.handle(var2 ? 67109220 : 67109260, var3, var3, var1.field_444, var1.field_445);
    }

    public void method_1595(TypeBinding var1, ASTNode var2) {
        this.handle(16777243, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1596(TypeReference var1, TypeBinding var2) {
        this.handle(16777782, new String[] {new String(var2.readableName()), new String(var2.enclosingType().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var2.enclosingType().shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1597(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777527, var2, var2, var1.method_318(), var1.method_317());
    }

    public void illegalUsageOfQualifiedTypeReference(QualifiedTypeReference var1) {
        StringBuffer var2 = new StringBuffer();
        char[][] var3 = var1.tokens;
        for (int var4 = 0; var4 < var3.length; ++var4) {
            if (var4 > 0) {
                var2.append('.');
            }
            var2.append(var3[var4]);
        }
        String[] var5 = new String[] {String.valueOf(var2)};
        this.handle(1610612934, var5, var5, var1.field_444, var1.field_445);
    }

    public void method_1599(TypeReference var1) {
        this.handle(1610613314, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void illegalVararg(Argument var1, AbstractMethodDeclaration var2) {
        String[] var3 = new String[] {CharOperation.toString(var1.type.getTypeName()), new String(var2.selector)};
        this.handle(67109279, var3, var3, var1.field_444, var1.field_445);
    }

    public void method_1601(ReferenceBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var2.name)};
        this.handle(33554776, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1602(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777526, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1603(ReferenceBinding var1, AbstractMethodDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_179()), new String(var2.selector)};
        this.handle(67109224, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1604(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(16777525, var2, var2, var1.method_318(), var1.method_317());
    }

    public void method_1605(ASTNode var1) {
        this.handle(536871076, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void importProblem(ImportReference var1, Binding var2) {
        if (var2 instanceof FieldBinding) {
            int var7 = 33554502;
            FieldBinding var8 = (FieldBinding)var2;
            String[] var5 = null;
            String[] var6 = null;
            switch (var2.problemId()) {
                case 2:
                    var7 = 33554503;
                    var5 = new String[] {CharOperation.toString(var1.tokens), new String(var8.declaringClass.readableName())};
                    var6 = new String[] {CharOperation.toString(var1.tokens), new String(var8.declaringClass.shortReadableName())};
                    break;
                case 3:
                    var7 = 33554504;
                    var5 = new String[] {new String(var8.readableName())};
                    var6 = new String[] {new String(var8.readableName())};
                    break;
                case 8:
                    var7 = 16777219;
                    var5 = new String[] {new String(var8.declaringClass.method_173().readableName())};
                    var6 = new String[] {new String(var8.declaringClass.method_173().shortReadableName())};
            }
            this.handle(var7, var5, var6, this.method_1695(var8, var1), this.method_1693(var8, var1));
        } else {
            char[][] var3;
            String[] var4;
            if (var2.problemId() == 1) {
                var3 = var2 instanceof ProblemReferenceBinding ? ((ProblemReferenceBinding)var2).compoundName : var1.tokens;
                var4 = new String[] {CharOperation.toString(var3)};
                this.handle(268435846, var4, var4, var1.field_444, (int)var1.sourcePositions[var3.length - 1]);
            } else if (var2.problemId() == 14) {
                var3 = var1.tokens;
                var4 = new String[] {CharOperation.toString(var3)};
                this.handle(268435847, var4, var4, var1.field_444, (int)var1.sourcePositions[var3.length - 1]);
            } else {
                this.method_1639(var1, (TypeBinding)var2);
            }
        }
    }

    public void incompatibleExceptionInThrowsClause(SourceTypeBinding var1, MethodBinding var2, MethodBinding var3, ReferenceBinding var4) {
        if (var1 == var2.declaringClass) {
            int var5;
            if (var2.declaringClass.method_157() && !var3.method_369()) {
                var5 = 67109278;
            } else {
                var5 = 67109266;
            }
            this.handle(var5, new String[] {new String(var4.method_179()), new String(CharOperation.concat(var3.declaringClass.readableName(), var3.readableName(), '.'))}, new String[] {new String(var4.method_179()), new String(CharOperation.concat(var3.declaringClass.shortReadableName(), var3.shortReadableName(), '.'))}, var2.method_385(), var2.method_383());
        } else {
            this.handle(67109267, new String[] {new String(var4.method_179()), new String(CharOperation.concat(var2.declaringClass.method_179(), var2.readableName(), '.')), new String(CharOperation.concat(var3.declaringClass.readableName(), var3.readableName(), '.'))}, new String[] {new String(var4.method_179()), new String(CharOperation.concat(var2.declaringClass.method_179(), var2.shortReadableName(), '.')), new String(CharOperation.concat(var3.declaringClass.shortReadableName(), var3.shortReadableName(), '.'))}, var1.method_318(), var1.method_317());
        }
    }

    public void method_1608(MethodBinding var1, MethodBinding var2) {
        StringBuffer var3 = new StringBuffer();
        var3.append(var2.declaringClass.readableName()).append('.').append(var2.readableName());
        StringBuffer var4 = new StringBuffer();
        var4.append(var2.declaringClass.shortReadableName()).append('.').append(var2.shortReadableName());
        ReferenceBinding var6 = var1.declaringClass;
        int var5;
        if (var6.method_157() && !var2.method_369()) {
            var5 = 67109277;
        } else {
            var5 = 67109268;
        }
        AbstractMethodDeclaration var7 = var1.sourceMethod();
        int var8 = 0;
        int var9 = 0;
        if (var7 == null) {
            if (var6 instanceof SourceTypeBinding) {
                SourceTypeBinding var10 = (SourceTypeBinding)var6;
                var8 = var10.method_318();
                var9 = var10.method_317();
            }
        } else if (var7.method_795()) {
            var8 = var7.field_444;
            var9 = var7.field_445;
        } else {
            TypeReference var14 = ((MethodDeclaration)var7).returnType;
            var8 = var14.field_444;
            if (var14 instanceof ParameterizedSingleTypeReference) {
                ParameterizedSingleTypeReference var11 = (ParameterizedSingleTypeReference)var14;
                TypeReference[] var12 = var11.typeArguments;
                if (var12[var12.length - 1].field_445 > var11.field_445) {
                    var9 = this.method_1749(var11.field_445);
                } else {
                    var9 = var14.field_445;
                }
            } else if (var14 instanceof ParameterizedQualifiedTypeReference) {
                ParameterizedQualifiedTypeReference var13 = (ParameterizedQualifiedTypeReference)var14;
                var9 = this.method_1749(var13.field_445);
            } else {
                var9 = var14.field_445;
            }
        }
        this.handle(var5, new String[] {var3.toString()}, new String[] {var4.toString()}, var8, var9);
    }

    public void incorrectArityForParameterizedType(ASTNode var1, TypeBinding var2, TypeBinding[] var3) {
        if (var1 == null) {
            this.handle(16777741, new String[] {new String(var2.readableName()), this.typesAsString(false, var3, false)}, new String[] {new String(var2.shortReadableName()), this.typesAsString(false, var3, true)}, 131, 0, 0);
        } else {
            this.handle(16777741, new String[] {new String(var2.readableName()), this.typesAsString(false, var3, false)}, new String[] {new String(var2.shortReadableName()), this.typesAsString(false, var3, true)}, var1.field_444, var1.field_445);
        }
    }

    public void incorrectLocationForNonEmptyDimension(ArrayAllocationExpression var1, int var2) {
        this.handle(536871114, NoArgument, NoArgument, var1.dimensions[var2].field_444, var1.dimensions[var2].field_445);
    }

    public void method_1611(Expression var1, TypeBinding var2) {
        this.handle(16777385, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1612(ASTNode var1, FieldBinding var2) {
        int var3 = this.computeSeverity(570425422);
        if (var3 != -1) {
            this.handle(570425422, new String[] {new String(var2.declaringClass.readableName()), new String(var2.name)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.name)}, var3, this.method_1695(var2, var1), this.method_1693(var2, var1));
        }
    }

    public void method_1613(ASTNode var1, MethodBinding var2) {
        int var3 = this.computeSeverity(603979895);
        if (var3 != -1) {
            this.handle(603979895, new String[] {new String(var2.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, var3, var1.field_444, var1.field_445);
        }
    }

    public void method_1614(SourceTypeBinding var1, MethodBinding var2, MethodBinding[] var3) {
        StringBuffer var4 = new StringBuffer();
        var4.append(var2.declaringClass.readableName()).append('.').append(var2.readableName());
        StringBuffer var5 = new StringBuffer();
        var5.append(var2.declaringClass.shortReadableName()).append('.').append(var2.shortReadableName());
        this.handle(67109269, new String[] {var4.toString(), new String(var3[0].declaringClass.readableName())}, new String[] {new String(var5.toString()), new String(var3[0].declaringClass.shortReadableName())}, var1.method_318(), var1.method_317());
    }

    public void inheritedMethodsHaveIncompatibleReturnTypes(ASTNode var1, MethodBinding[] var2, int var3) {
        StringBuffer var4 = new StringBuffer();
        StringBuffer var5 = new StringBuffer();
        int var6 = var3;
        while (true) {
            --var6;
            if (var6 < 0) {
                this.handle(67109268, new String[] {var4.toString()}, new String[] {var5.toString()}, var1.field_444, var1.field_445);
                return;
            }
            var4.append(var2[var6].declaringClass.readableName()).append('.').append(var2[var6].readableName());
            var5.append(var2[var6].declaringClass.shortReadableName()).append('.').append(var2[var6].shortReadableName());
            if (var6 != 0) {
                var4.append(", ");
                var5.append(", ");
            }
        }
    }

    public void inheritedMethodsHaveIncompatibleReturnTypes(SourceTypeBinding var1, MethodBinding[] var2, int var3) {
        StringBuffer var4 = new StringBuffer();
        StringBuffer var5 = new StringBuffer();
        int var6 = var3;
        while (true) {
            --var6;
            if (var6 < 0) {
                this.handle(67109268, new String[] {var4.toString()}, new String[] {var5.toString()}, var1.method_318(), var1.method_317());
                return;
            }
            var4.append(var2[var6].declaringClass.readableName()).append('.').append(var2[var6].readableName());
            var5.append(var2[var6].declaringClass.shortReadableName()).append('.').append(var2[var6].shortReadableName());
            if (var6 != 0) {
                var4.append(", ");
                var5.append(", ");
            }
        }
    }

    public void method_1617(SourceTypeBinding var1, MethodBinding var2, MethodBinding var3) {
        this.handle(67109424, new String[] {new String(var2.selector), this.typesAsString(var2.original().method_374(), var2.original().parameters, false), new String(var2.declaringClass.readableName()), this.typesAsString(var3.original().method_374(), var3.original().parameters, false), new String(var3.declaringClass.readableName())}, new String[] {new String(var2.selector), this.typesAsString(var2.original().method_374(), var2.original().parameters, true), new String(var2.declaringClass.shortReadableName()), this.typesAsString(var3.original().method_374(), var3.original().parameters, true), new String(var3.declaringClass.shortReadableName())}, var1.method_318(), var1.method_317());
    }

    public void method_1618(FieldDeclaration var1) {
        this.handle(536871075, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void innerTypesCannotDeclareStaticInitializers(ReferenceBinding var1, Initializer var2) {
        this.handle(536870936, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_444);
    }

    public void method_1620(ConstructorDeclaration var1) {
        this.handle(1610612943, NoArgument, NoArgument, var1.field_444, var1.field_445, var1, var1.compilationResult());
    }

    public void method_1621(SourceTypeBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_179())};
        this.handle(16777516, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1622(MethodDeclaration var1) {
        this.handle(16777821, new String[] {new String(var1.binding.returnType.readableName()), new String(var1.selector), new String(var1.binding.declaringClass.readableName())}, new String[] {new String(var1.binding.returnType.shortReadableName()), new String(var1.selector), new String(var1.binding.declaringClass.shortReadableName())}, var1.returnType.field_444, var1.returnType.field_445);
    }

    public void method_1623(ASTNode var1) {
        this.handle(536871084, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void invalidConstructor(Statement var1, MethodBinding var2) {
        boolean var3 = this.referenceContext instanceof ConstructorDeclaration && ((ConstructorDeclaration)this.referenceContext).method_796();
        boolean var4 = var1 instanceof ExplicitConstructorCall && ((ExplicitConstructorCall)var1).field_551 == 1;
        int var5 = var1.field_444;
        int var6 = var1.field_445;
        if (var1 instanceof AllocationExpression) {
            AllocationExpression var7 = (AllocationExpression)var1;
            if (var7.enumConstant != null) {
                var5 = var7.enumConstant.field_444;
                var6 = var7.enumConstant.field_445;
            }
        }
        int var15 = 134217858;
        MethodBinding var8 = var2;
        ProblemMethodBinding var9;
        switch (var2.problemId()) {
            case 0:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                this.method_1689(var1);
                break;
            case 1:
                var9 = (ProblemMethodBinding)var2;
                if (var9.closestMatch != null && (var9.closestMatch.tagBits & 128L) != 0L) {
                    this.method_1682(var1, var9.closestMatch);
                    return;
                }
                if (var3) {
                    var15 = 134217868;
                } else if (var4) {
                    var15 = 134217871;
                } else {
                    var15 = 134217858;
                }
                break;
            case 2:
                if (var3) {
                    var15 = 134217869;
                } else if (var4) {
                    var15 = 134217872;
                } else {
                    var15 = 134217859;
                }
                var9 = (ProblemMethodBinding)var2;
                if (var9.closestMatch != null) {
                    var8 = var9.closestMatch.original();
                }
                break;
            case 3:
                if (var3) {
                    var15 = 134217870;
                } else if (var4) {
                    var15 = 134217873;
                } else {
                    var15 = 134217860;
                }
                break;
            case 10:
                var9 = (ProblemMethodBinding)var2;
                ParameterizedGenericMethodBinding var10 = (ParameterizedGenericMethodBinding)var9.closestMatch;
                var8 = var10.original();
                int var11 = var9.parameters.length;
                TypeBinding var12 = var9.parameters[var11 - 2];
                TypeVariableBinding var13 = (TypeVariableBinding)var9.parameters[var11 - 1];
                TypeBinding[] var14 = new TypeBinding[var11 - 2];
                System.arraycopy(var9.parameters, 0, var14, 0, var11 - 2);
                this.handle(16777760, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, false), new String(var8.declaringClass.readableName()), this.typesAsString(false, var14, false), new String(var12.readableName()), new String(var13.sourceName), this.parameterBoundAsString(var13, false)}, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, true), new String(var8.declaringClass.shortReadableName()), this.typesAsString(false, var14, true), new String(var12.shortReadableName()), new String(var13.sourceName), this.parameterBoundAsString(var13, true)}, var5, var6);
                return;
            case 11:
                var9 = (ProblemMethodBinding)var2;
                var8 = var9.closestMatch;
                if (var8.typeVariables == Binding.NO_TYPE_VARIABLES) {
                    this.handle(16777767, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, false), new String(var8.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, true), new String(var8.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true)}, var5, var6);
                } else {
                    this.handle(16777768, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, false), new String(var8.declaringClass.readableName()), this.typesAsString(false, var8.typeVariables, false), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, true), new String(var8.declaringClass.shortReadableName()), this.typesAsString(false, var8.typeVariables, true), this.typesAsString(var2.method_374(), var2.parameters, true)}, var5, var6);
                }
                return;
            case 12:
                var9 = (ProblemMethodBinding)var2;
                var8 = var9.closestMatch;
                this.handle(16777769, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, false), new String(var8.declaringClass.readableName()), this.typesAsString(false, ((ParameterizedGenericMethodBinding)var8).typeArguments, false), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, true), new String(var8.declaringClass.shortReadableName()), this.typesAsString(false, ((ParameterizedGenericMethodBinding)var8).typeArguments, true), this.typesAsString(var2.method_374(), var2.parameters, true)}, var5, var6);
                return;
            case 13:
                var9 = (ProblemMethodBinding)var2;
                var8 = var9.closestMatch;
                this.handle(16777771, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, false), new String(var8.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var8.declaringClass.method_179()), this.typesAsString(var8.method_374(), var8.parameters, true), new String(var8.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true)}, var5, var6);
                return;
        }
        this.handle(var15, new String[] {new String(var2.declaringClass.readableName()), this.typesAsString(var8.method_374(), var8.parameters, false)}, new String[] {new String(var2.declaringClass.shortReadableName()), this.typesAsString(var8.method_374(), var8.parameters, true)}, var5, var6);
    }

    public void method_1625(ASTNode var1) {
        this.handle(536871085, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void invalidEnclosingType(Expression var1, TypeBinding var2, ReferenceBinding var3) {
        if (var3.method_146()) {
            var3 = var3.superclass();
        }
        if (var3.sourceName == null || var3.sourceName.length != 0) {
            int var4 = 16777218;
            switch (var2.problemId()) {
                case 0:
                default:
                    this.method_1689(var1);
                    break;
                case 1:
                    var4 = 16777218;
                    break;
                case 2:
                    var4 = 16777219;
                    break;
                case 3:
                    var4 = 16777220;
                    break;
                case 4:
                    var4 = 16777222;
            }
            this.handle(var4, new String[] {new String(var3.readableName()) + "." + new String(var2.readableName())}, new String[] {new String(var3.shortReadableName()) + "." + new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
        }
    }

    public void method_1627(ASTNode var1) {
        this.handle(1207959691, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void invalidField(FieldReference var1, TypeBinding var2) {
        if (!this.isRecoveredName(var1.token)) {
            int var3 = 33554502;
            FieldBinding var4 = var1.binding;
            switch (var4.problemId()) {
                case 0:
                case 4:
                default:
                    this.method_1689(var1);
                    break;
                case 1:
                    if ((var2.tagBits & 128L) != 0L) {
                        this.handle(16777218, new String[] {new String(var2.method_173().readableName())}, new String[] {new String(var2.method_173().shortReadableName())}, var1.receiver.field_444, var1.receiver.field_445);
                        return;
                    }
                    var3 = 33554502;
                    break;
                case 2:
                    this.handle(33554503, new String[] {new String(var1.token), new String(var4.declaringClass.readableName())}, new String[] {new String(var1.token), new String(var4.declaringClass.shortReadableName())}, this.method_1695(var4, var1), this.method_1693(var4, var1));
                    return;
                case 3:
                    var3 = 33554504;
                    break;
                case 5:
                    var3 = 33554628;
                    break;
                case 6:
                    var3 = 134217863;
                    break;
                case 7:
                    var3 = 33554506;
                    break;
                case 8:
                    this.handle(16777219, new String[] {new String(var2.method_173().readableName())}, new String[] {new String(var2.method_173().shortReadableName())}, var1.receiver.field_444, var1.receiver.field_445);
                    return;
            }
            String[] var5 = new String[] {new String(var4.readableName())};
            this.handle(var3, var5, var5, this.method_1695(var4, var1), this.method_1693(var4, var1));
        }
    }

    public void method_1629(NameReference var1, FieldBinding var2) {
        if (var1 instanceof QualifiedNameReference) {
            QualifiedNameReference var3 = (QualifiedNameReference)var1;
            if (this.isRecoveredName(var3.tokens)) {
                return;
            }
        } else {
            SingleNameReference var6 = (SingleNameReference)var1;
            if (this.isRecoveredName(var6.token)) {
                return;
            }
        }
        int var7 = 33554502;
        switch (var2.problemId()) {
            case 0:
            case 4:
            default:
                this.method_1689(var1);
                break;
            case 1:
                ReferenceBinding var4 = var2.declaringClass;
                if (var4 != null && (var4.tagBits & 128L) != 0L) {
                    this.handle(16777218, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.field_444, var1.field_445);
                    return;
                }
                var7 = 33554502;
                break;
            case 2:
                char[] var5 = var2.readableName();
                var5 = CharOperation.method_1377(var5, '.');
                this.handle(33554503, new String[] {new String(var5), new String(var2.declaringClass.readableName())}, new String[] {new String(var5), new String(var2.declaringClass.shortReadableName())}, this.method_1695(var2, var1), this.method_1693(var2, var1));
                return;
            case 3:
                var7 = 33554504;
                break;
            case 5:
                var7 = 33554628;
                break;
            case 6:
                var7 = 134217863;
                break;
            case 7:
                var7 = 33554506;
                break;
            case 8:
                this.handle(16777219, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.field_444, var1.field_445);
                return;
        }
        String[] var8 = new String[] {new String(var2.readableName())};
        this.handle(var7, var8, var8, var1.field_444, var1.field_445);
    }

    public void invalidField(QualifiedNameReference var1, FieldBinding var2, int var3, TypeBinding var4) {
        if (!this.isRecoveredName(var1.tokens)) {
            if (var4.method_148()) {
                this.handle(33554653, new String[] {new String(var4.readableName()), CharOperation.toString(CharOperation.subarray(var1.tokens, 0, var3)), new String(var1.tokens[var3])}, new String[] {new String(var4.method_179()), CharOperation.toString(CharOperation.subarray(var1.tokens, 0, var3)), new String(var1.tokens[var3])}, var1.field_444, (int)var1.sourcePositions[var3]);
            } else {
                int var5 = 33554502;
                switch (var2.problemId()) {
                    case 0:
                    case 4:
                    default:
                        this.method_1689(var1);
                        break;
                    case 1:
                        if ((var4.tagBits & 128L) != 0L) {
                            this.handle(16777218, new String[] {new String(var4.method_173().readableName())}, new String[] {new String(var4.method_173().shortReadableName())}, var1.field_444, (int)var1.sourcePositions[var3 - 1]);
                            return;
                        }
                        var5 = 33554502;
                        break;
                    case 2:
                        String var6 = new String(var1.tokens[var3]);
                        this.handle(33554503, new String[] {var6, new String(var2.declaringClass.readableName())}, new String[] {var6, new String(var2.declaringClass.shortReadableName())}, this.method_1695(var2, var1), this.method_1693(var2, var1));
                        return;
                    case 3:
                        var5 = 33554504;
                        break;
                    case 5:
                        var5 = 33554628;
                        break;
                    case 6:
                        var5 = 134217863;
                        break;
                    case 7:
                        var5 = 33554506;
                        break;
                    case 8:
                        this.handle(16777219, new String[] {new String(var4.method_173().readableName())}, new String[] {new String(var4.method_173().shortReadableName())}, var1.field_444, (int)var1.sourcePositions[var3 - 1]);
                        return;
                }
                String[] var7 = new String[] {CharOperation.toString(CharOperation.subarray(var1.tokens, 0, var3 + 1))};
                this.handle(var5, var7, var7, var1.field_444, (int)var1.sourcePositions[var3]);
            }
        }
    }

    public void method_1631(Annotation var1) {
        this.handle(1610613338, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1632(MessageSend var1, MethodBinding var2) {
        if (!this.isRecoveredName(var1.selector)) {
            int var3 = 67108964;
            MethodBinding var4 = var2;
            ProblemMethodBinding var5;
            switch (var2.problemId()) {
                case 0:
                case 4:
                case 9:
                default:
                    this.method_1689(var1);
                    break;
                case 1:
                    if ((var2.declaringClass.tagBits & 128L) != 0L) {
                        this.handle(16777218, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.receiver.field_444, var1.receiver.field_445);
                        return;
                    }
                    var3 = 67108964;
                    var5 = (ProblemMethodBinding)var2;
                    if (var5.closestMatch != null) {
                        var4 = var5.closestMatch;
                        if ((var4.tagBits & 128L) != 0L) {
                            this.method_1683(var1, var4);
                            return;
                        }
                        String var11 = this.typesAsString(var4.method_374(), var4.parameters, false);
                        String var12 = this.typesAsString(false, var5.parameters, false);
                        String var13 = this.typesAsString(var4.method_374(), var4.parameters, true);
                        String var14 = this.typesAsString(false, var5.parameters, true);
                        this.handle(67108979, new String[] {new String(var4.declaringClass.readableName()), new String(var4.selector), var11, var12}, new String[] {new String(var4.declaringClass.shortReadableName()), new String(var4.selector), var13, var14}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
                        return;
                    }
                    break;
                case 2:
                    var3 = 67108965;
                    var5 = (ProblemMethodBinding)var2;
                    if (var5.closestMatch != null) {
                        var4 = var5.closestMatch.original();
                    }
                    break;
                case 3:
                    var3 = 67108966;
                    break;
                case 5:
                    var3 = 67109059;
                    break;
                case 6:
                    var3 = 134217864;
                    break;
                case 7:
                    var3 = 603979977;
                    break;
                case 8:
                    this.handle(16777219, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.receiver.field_444, var1.receiver.field_445);
                    return;
                case 10:
                    var5 = (ProblemMethodBinding)var2;
                    ParameterizedGenericMethodBinding var6 = (ParameterizedGenericMethodBinding)var5.closestMatch;
                    var4 = var6.original();
                    int var7 = var5.parameters.length;
                    TypeBinding var8 = var5.parameters[var7 - 2];
                    TypeVariableBinding var9 = (TypeVariableBinding)var5.parameters[var7 - 1];
                    TypeBinding[] var10 = new TypeBinding[var7 - 2];
                    System.arraycopy(var5.parameters, 0, var10, 0, var7 - 2);
                    this.handle(16777759, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, false), new String(var4.declaringClass.readableName()), this.typesAsString(false, var10, false), new String(var8.readableName()), new String(var9.sourceName), this.parameterBoundAsString(var9, false)}, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, true), new String(var4.declaringClass.shortReadableName()), this.typesAsString(false, var10, true), new String(var8.shortReadableName()), new String(var9.sourceName), this.parameterBoundAsString(var9, true)}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
                    return;
                case 11:
                    var5 = (ProblemMethodBinding)var2;
                    var4 = var5.closestMatch;
                    if (var4.typeVariables == Binding.NO_TYPE_VARIABLES) {
                        this.handle(16777764, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, false), new String(var4.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, true), new String(var4.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true)}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
                    } else {
                        this.handle(16777765, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, false), new String(var4.declaringClass.readableName()), this.typesAsString(false, var4.typeVariables, false), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, true), new String(var4.declaringClass.shortReadableName()), this.typesAsString(false, var4.typeVariables, true), this.typesAsString(var2.method_374(), var2.parameters, true)}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
                    }
                    return;
                case 12:
                    var5 = (ProblemMethodBinding)var2;
                    var4 = var5.closestMatch;
                    this.handle(16777766, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, false), new String(var4.declaringClass.readableName()), this.typesAsString(false, ((ParameterizedGenericMethodBinding)var4).typeArguments, false), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, true), new String(var4.declaringClass.shortReadableName()), this.typesAsString(false, ((ParameterizedGenericMethodBinding)var4).typeArguments, true), this.typesAsString(var2.method_374(), var2.parameters, true)}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
                    return;
                case 13:
                    var5 = (ProblemMethodBinding)var2;
                    var4 = var5.closestMatch;
                    this.handle(16777770, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, false), new String(var4.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, true), new String(var4.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true)}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
                    return;
            }
            this.handle(var3, new String[] {new String(var2.declaringClass.readableName()), new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, false)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var4.selector), this.typesAsString(var4.method_374(), var4.parameters, true)}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
        }
    }

    public void method_1633(Expression var1) {
        this.handle(536871088, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void invalidOperator(BinaryExpression var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(536871072, new String[] {var1.operatorToString(), var4 + ", " + var5}, new String[] {var1.operatorToString(), var6 + ", " + var7}, var1.field_444, var1.field_445);
    }

    public void method_1635(CompoundAssignment var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(536871072, new String[] {var1.operatorToString(), var4 + ", " + var5}, new String[] {var1.operatorToString(), var6 + ", " + var7}, var1.field_444, var1.field_445);
    }

    public void invalidOperator(UnaryExpression var1, TypeBinding var2) {
        this.handle(536871072, new String[] {var1.operatorToString(), new String(var2.readableName())}, new String[] {var1.operatorToString(), new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1637(TypeBinding var1, ASTNode var2) {
        this.handle(16777750, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1638(ASTNode var1) {
        this.handle(1610612961, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1639(ASTNode var1, TypeBinding var2) {
        if (var2 instanceof ReferenceBinding) {
            if (this.isRecoveredName(((ReferenceBinding)var2).compoundName)) {
                return;
            }
        } else if (var2 instanceof ArrayBinding) {
            TypeBinding var3 = ((ArrayBinding)var2).leafComponentType;
            if (var3 instanceof ReferenceBinding && this.isRecoveredName(((ReferenceBinding)var3).compoundName)) {
                return;
            }
        }
        int var8 = 16777218;
        switch (var2.problemId()) {
            case 0:
            case 6:
            case 8:
            default:
                this.method_1689(var1);
                break;
            case 1:
                var8 = 16777218;
                break;
            case 2:
                var8 = 16777219;
                break;
            case 3:
                var8 = 16777220;
                break;
            case 4:
                var8 = 16777222;
                break;
            case 5:
                var8 = 16777413;
                break;
            case 7:
                var8 = 536871434;
                break;
            case 9:
                var8 = 536871433;
        }
        int var4 = var1.field_445;
        if (var1 instanceof QualifiedNameReference) {
            QualifiedNameReference var5 = (QualifiedNameReference)var1;
            if (this.isRecoveredName(var5.tokens)) {
                return;
            }
            if (var5.indexOfFirstFieldBinding >= 1) {
                var4 = (int)var5.sourcePositions[var5.indexOfFirstFieldBinding - 1];
            }
        } else {
            char[][] var6;
            if (var1 instanceof ParameterizedQualifiedTypeReference) {
                ParameterizedQualifiedTypeReference var9 = (ParameterizedQualifiedTypeReference)var1;
                if (this.isRecoveredName(var9.tokens)) {
                    return;
                }
                if (var2 instanceof ReferenceBinding) {
                    var6 = ((ReferenceBinding)var2).compoundName;
                    var4 = (int)var9.sourcePositions[var6.length - 1];
                }
            } else if (var1 instanceof ArrayQualifiedTypeReference) {
                ArrayQualifiedTypeReference var11 = (ArrayQualifiedTypeReference)var1;
                if (this.isRecoveredName(var11.tokens)) {
                    return;
                }
                TypeBinding var14 = var2.method_173();
                if (var14 instanceof ReferenceBinding) {
                    char[][] var7 = ((ReferenceBinding)var14).compoundName;
                    var4 = (int)var11.sourcePositions[var7.length - 1];
                } else {
                    long[] var15 = var11.sourcePositions;
                    var4 = (int)var15[var15.length - 1];
                }
            } else if (var1 instanceof QualifiedTypeReference) {
                QualifiedTypeReference var10 = (QualifiedTypeReference)var1;
                if (this.isRecoveredName(var10.tokens)) {
                    return;
                }
                if (var2 instanceof ReferenceBinding) {
                    var6 = ((ReferenceBinding)var2).compoundName;
                    if (var6.length <= var10.sourcePositions.length) {
                        var4 = (int)var10.sourcePositions[var6.length - 1];
                    }
                }
            } else if (var1 instanceof ImportReference) {
                ImportReference var13 = (ImportReference)var1;
                if (this.isRecoveredName(var13.tokens)) {
                    return;
                }
                if (var2 instanceof ReferenceBinding) {
                    var6 = ((ReferenceBinding)var2).compoundName;
                    var4 = (int)var13.sourcePositions[var6.length - 1];
                }
            } else if (var1 instanceof ArrayTypeReference) {
                ArrayTypeReference var12 = (ArrayTypeReference)var1;
                if (this.isRecoveredName(var12.token)) {
                    return;
                }
                var4 = var12.field_730;
            }
        }
        this.handle(var8, new String[] {new String(var2.method_173().readableName())}, new String[] {new String(var2.method_173().shortReadableName())}, var1.field_444, var4);
    }

    public void method_1640(Expression var1) {
        this.handle(536871493, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1641(Expression var1) {
        this.handle(536871115, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1642(Expression var1, TypeBinding var2) {
        this.handle(536871087, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1643(TypeBinding var1, ASTNode var2) {
        this.handle(16777749, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1644(Expression var1) {
        this.handle(1610612942, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1645(Annotation var1) {
        this.handle(1610613332, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1646(TypeDeclaration var1) {
        this.handle(1610613333, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1647(TypeDeclaration var1) {
        this.handle(1610613330, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void invalidUsageOfForeachStatements(LocalDeclaration var1, Expression var2) {
        this.handle(1610613328, NoArgument, NoArgument, var1.field_653, var2.field_445);
    }

    public void method_1649(ImportReference var1) {
        this.handle(1610613327, NoArgument, NoArgument, var1.field_470, var1.field_471);
    }

    public void invalidUsageOfTypeArguments(TypeReference var1, TypeReference var2) {
        this.handle(1610613329, NoArgument, NoArgument, var1.field_444, var2.field_445);
    }

    public void invalidUsageOfTypeParameters(TypeParameter var1, TypeParameter var2) {
        this.handle(1610613326, NoArgument, NoArgument, var1.field_653, var2.field_652);
    }

    public void method_1652(TypeDeclaration var1) {
        TypeParameter[] var2 = var1.typeParameters;
        int var3 = var2.length;
        this.handle(1610613334, NoArgument, NoArgument, var2[0].field_653, var2[var3 - 1].field_652);
    }

    public void method_1653(TypeDeclaration var1) {
        TypeParameter[] var2 = var1.typeParameters;
        int var3 = var2.length;
        this.handle(1610613335, NoArgument, NoArgument, var2[0].field_653, var2[var3 - 1].field_652);
    }

    public void method_1654(Argument var1) {
        this.handle(1610613331, NoArgument, NoArgument, var1.type.field_444, var1.field_445);
    }

    public void isClassPathCorrect(char[][] var1, CompilationUnitDeclaration var2, Object var3) {
        this.referenceContext = var2;
        String[] var4 = new String[] {CharOperation.toString(var1)};
        int var5 = 0;
        int var6 = 0;
        if (var3 != null) {
            if (var3 instanceof InvocationSite) {
                InvocationSite var7 = (InvocationSite)var3;
                var5 = var7.method_5();
                var6 = var7.method_6();
            } else if (var3 instanceof ASTNode) {
                ASTNode var8 = (ASTNode)var3;
                var5 = var8.method_5();
                var6 = var8.method_6();
            }
        }
        this.handle(16777540, var4, var4, var5, var6);
    }

    private boolean method_1656(int var1) {
        return var1 == 26;
    }

    private boolean method_1657(int var1) {
        switch (var1) {
            case 12:
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
            case 44:
            case 45:
            case 46:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
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
            case 95:
            case 96:
            case 97:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
                return true;
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
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
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
            case 98:
            default:
                return false;
        }
    }

    private boolean method_1658(int var1) {
        switch (var1) {
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                return true;
            default:
                return false;
        }
    }

    private boolean isRecoveredName(char[] var1) {
        return var1 == RecoveryScanner.FAKE_IDENTIFIER;
    }

    private boolean isRecoveredName(char[][] var1) {
        if (var1 == null) {
            return false;
        } else {
            for (int var2 = 0; var2 < var1.length; ++var2) {
                if (var1[var2] == RecoveryScanner.FAKE_IDENTIFIER) {
                    return true;
                }
            }
            return false;
        }
    }

    public void localVariableHiding(LocalDeclaration var1, Binding var2, boolean var3) {
        int var4;
        int var5;
        if (var2 instanceof LocalVariableBinding) {
            var4 = var1 instanceof Argument ? 536871006 : 536871002;
            var5 = this.computeSeverity(var4);
            if (var5 == -1) {
                return;
            }
            String[] var6 = new String[] {new String(var1.name)};
            this.handle(var4, var6, var6, var5, this.method_1695(var2, var1), this.method_1693(var2, var1));
        } else if (var2 instanceof FieldBinding) {
            if (var3 && !this.options.field_1947) {
                return;
            }
            var4 = var1 instanceof Argument ? 536871007 : 570425435;
            var5 = this.computeSeverity(var4);
            if (var5 == -1) {
                return;
            }
            FieldBinding var7 = (FieldBinding)var2;
            this.handle(var4, new String[] {new String(var1.name), new String(var7.declaringClass.readableName())}, new String[] {new String(var1.name), new String(var7.declaringClass.shortReadableName())}, var5, var1.field_444, var1.field_445);
        }
    }

    public void method_1662(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871370);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871370, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1663(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871366);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871366, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1664(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871368);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871368, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1665(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871363);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871363, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1666(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871364);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871364, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1667(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871369);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871369, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1668(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871365);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871365, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1669(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536871367);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.name)};
            this.handle(536871367, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1670(AbstractMethodDeclaration var1) {
        MethodBinding var2 = var1.binding;
        this.handle(this.options.field_1928 == 3211264L ? 67109487 : 67109498, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var2.declaringClass.readableName())}, new String[] {new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var2.declaringClass.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void method_1671(MethodBinding var1, MethodBinding var2) {
        this.handle(67109424, new String[] {new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, false), new String(var1.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var2.declaringClass.readableName())}, new String[] {new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, true), new String(var1.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
    }

    public void method_1672(AbstractMethodDeclaration var1) {
        this.handle(603979883, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1673(MethodDeclaration var1) {
        this.handle((var1.field_482 & 256) != 0 ? 603979888 : 603979889, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1674(MethodDeclaration var1) {
        this.handle(67108974, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1675(FieldDeclaration var1) {
        int var2 = this.computeSeverity(536871540);
        if (var2 != -1) {
            FieldBinding var3 = var1.binding;
            this.handle(536871540, new String[] {new String(var3.declaringClass.readableName()), new String(var3.name)}, new String[] {new String(var3.declaringClass.shortReadableName()), new String(var3.name)}, var2, this.method_1695(var3, var1), this.method_1693(var3, var1));
        }
    }

    public void method_1676(AbstractMethodDeclaration var1) {
        int var2 = this.computeSeverity(536871541);
        if (var2 != -1) {
            MethodBinding var3 = var1.binding;
            this.handle(536871541, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, false), new String(var3.declaringClass.readableName())}, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, true), new String(var3.declaringClass.shortReadableName())}, var2, var1.field_444, var1.field_445);
        }
    }

    public void method_1677(TypeDeclaration var1) {
        int var2 = this.computeSeverity(536871542);
        if (var2 != -1) {
            SourceTypeBinding var3 = var1.binding;
            this.handle(536871542, new String[] {new String(var3.readableName())}, new String[] {new String(var3.shortReadableName())}, var2, var1.field_444, var1.field_445);
        }
    }

    public void missingEnumConstantCase(SwitchStatement var1, FieldBinding var2) {
        this.handle(33555193, new String[] {new String(var2.declaringClass.readableName()), new String(var2.name)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.name)}, var1.expression.field_444, var1.expression.field_445);
    }

    public void method_1679(AbstractMethodDeclaration var1) {
        int var2 = this.computeSeverity(67109491);
        if (var2 != -1) {
            MethodBinding var3 = var1.binding;
            this.handle(67109491, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, false), new String(var3.declaringClass.readableName())}, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, true), new String(var3.declaringClass.shortReadableName())}, var2, var1.field_444, var1.field_445);
        }
    }

    public void method_1680(AbstractMethodDeclaration var1) {
        this.handle(16777327, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1681(TypeDeclaration var1) {
        String[] var2 = new String[] {new String(var1.name)};
        this.handle(536871008, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1682(ASTNode var1, MethodBinding var2) {
        List var3 = var2.method_348((List)null);
        TypeBinding var4 = (TypeBinding)var3.get(0);
        int var5 = var1.field_444;
        int var6 = var1.field_445;
        if (var1 instanceof QualifiedAllocationExpression) {
            QualifiedAllocationExpression var7 = (QualifiedAllocationExpression)var1;
            if (var7.anonymousType != null) {
                var5 = var7.anonymousType.field_444;
                var6 = var7.anonymousType.field_445;
            }
        }
        this.handle(134217857, new String[] {new String(var2.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var4.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var4.shortReadableName())}, var5, var6);
    }

    public void method_1683(MessageSend var1, MethodBinding var2) {
        List var3 = var2.method_348((List)null);
        TypeBinding var4 = (TypeBinding)var3.get(0);
        this.handle(67108984, new String[] {new String(var2.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var4.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var4.shortReadableName())}, (int)(var1.nameSourcePosition >>> 32), (int)var1.nameSourcePosition);
    }

    public void missingValueForAnnotationMember(Annotation var1, char[] var2) {
        String var3 = new String(var2);
        this.handle(16777825, new String[] {new String(var1.resolvedType.readableName()), var3}, new String[] {new String(var1.resolvedType.shortReadableName()), var3}, var1.field_444, var1.field_445);
    }

    public void method_1685(ArrayAllocationExpression var1) {
        this.handle(536871071, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1686(CompilationUnitDeclaration var1) {
        String[] var2 = new String[] {new String(var1.method_771())};
        this.handle(536871238, var2, var2, var1.field_444, var1.field_444 + 1);
    }

    public void method_1687(MessageSend var1, MethodBinding var2) {
        this.handle(603979977, new String[] {new String(var2.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, var1.field_444, var1.field_445);
    }

    public void method_1688(ReferenceBinding var1, AbstractMethodDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_179()), new String(var2.selector)};
        this.handle(67109231, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1689(ASTNode var1) {
        this.abortDueToInternalError(Messages.field_1879, var1);
    }

    public void needToEmulateFieldAccess(FieldBinding var1, ASTNode var2, boolean var3) {
        int var4 = var3 ? 33554622 : 33554623;
        int var5 = this.computeSeverity(var4);
        if (var5 != -1) {
            this.handle(var4, new String[] {new String(var1.declaringClass.readableName()), new String(var1.name)}, new String[] {new String(var1.declaringClass.shortReadableName()), new String(var1.name)}, var5, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    public void method_1691(MethodBinding var1, ASTNode var2) {
        int var3;
        if (var1.method_358()) {
            var3 = this.computeSeverity(67109057);
            if (var3 != -1) {
                if (!var1.declaringClass.method_153()) {
                    this.handle(67109057, new String[] {new String(var1.declaringClass.readableName()), this.typesAsString(var1.method_374(), var1.parameters, false)}, new String[] {new String(var1.declaringClass.shortReadableName()), this.typesAsString(var1.method_374(), var1.parameters, true)}, var3, var2.field_444, var2.field_445);
                }
            }
        } else {
            var3 = this.computeSeverity(67109056);
            if (var3 != -1) {
                this.handle(67109056, new String[] {new String(var1.declaringClass.readableName()), new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, false)}, new String[] {new String(var1.declaringClass.shortReadableName()), new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, true)}, var3, var2.field_444, var2.field_445);
            }
        }
    }

    public void method_1692(TypeReference var1) {
        this.handle(16777789, new String[] {new String(var1.resolvedType.readableName())}, new String[] {new String(var1.resolvedType.shortReadableName())}, var1.field_444, var1.field_445);
    }

    private int method_1693(Binding var1, ASTNode var2) {
        return this.method_1694(var1, var2, 0);
    }

    private int method_1694(Binding var1, ASTNode var2, int var3) {
        if (var2 instanceof ArrayTypeReference) {
            return ((ArrayTypeReference)var2).field_730;
        } else {
            if (var2 instanceof QualifiedNameReference) {
                QualifiedNameReference var4 = (QualifiedNameReference)var2;
                if (var4.field_748 == var1) {
                    if (var3 == 0) {
                        return (int)var4.sourcePositions[var4.indexOfFirstFieldBinding - 1];
                    }
                    return (int)var4.sourcePositions[var3];
                }
                FieldBinding[] var5 = var4.field_756;
                if (var5 != null) {
                    int var6 = var4.indexOfFirstFieldBinding;
                    int var7;
                    int var8;
                    if (var3 != 0) {
                        var7 = 0;
                        for (var8 = var5.length; var7 < var8; ++var7) {
                            if (var5[var7] == var1 && var7 + var6 == var3) {
                                return (int)var4.sourcePositions[var7 + var6];
                            }
                        }
                    } else {
                        var7 = 0;
                        for (var8 = var5.length; var7 < var8; ++var7) {
                            if (var5[var7] == var1) {
                                return (int)var4.sourcePositions[var7 + var6];
                            }
                        }
                    }
                }
            } else if (var2 instanceof ParameterizedQualifiedTypeReference) {
                ParameterizedQualifiedTypeReference var9 = (ParameterizedQualifiedTypeReference)var2;
                if (var3 < var9.sourcePositions.length) {
                    return (int)var9.sourcePositions[var3];
                }
            } else if (var2 instanceof ArrayQualifiedTypeReference) {
                ArrayQualifiedTypeReference var10 = (ArrayQualifiedTypeReference)var2;
                int var11 = var10.sourcePositions.length;
                return (int)var10.sourcePositions[var11 - 1];
            }
            return var2.field_445;
        }
    }

    private int method_1695(Binding var1, ASTNode var2) {
        return this.method_1696(var1, var2, 0);
    }

    private int method_1696(Binding var1, ASTNode var2, int var3) {
        if (var2 instanceof FieldReference) {
            FieldReference var10 = (FieldReference)var2;
            return (int)(var10.nameSourcePosition >> 32);
        } else {
            if (var2 instanceof QualifiedNameReference) {
                QualifiedNameReference var4 = (QualifiedNameReference)var2;
                if (var4.field_748 == var1) {
                    if (var3 == 0) {
                        return (int)(var4.sourcePositions[var4.indexOfFirstFieldBinding - 1] >> 32);
                    }
                    return (int)(var4.sourcePositions[var3] >> 32);
                }
                FieldBinding[] var5 = var4.field_756;
                if (var5 != null) {
                    int var6 = var4.indexOfFirstFieldBinding;
                    int var7;
                    int var8;
                    if (var3 != 0) {
                        var7 = 0;
                        for (var8 = var5.length; var7 < var8; ++var7) {
                            if (var5[var7] == var1 && var7 + var6 == var3) {
                                return (int)(var4.sourcePositions[var7 + var6] >> 32);
                            }
                        }
                    } else {
                        var7 = 0;
                        for (var8 = var5.length; var7 < var8; ++var7) {
                            if (var5[var7] == var1) {
                                return (int)(var4.sourcePositions[var7 + var6] >> 32);
                            }
                        }
                    }
                }
            } else if (var2 instanceof ParameterizedQualifiedTypeReference) {
                ParameterizedQualifiedTypeReference var9 = (ParameterizedQualifiedTypeReference)var2;
                return (int)(var9.sourcePositions[0] >>> 32);
            }
            return var2.field_444;
        }
    }

    public void method_1697(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.name)};
        this.handle(var1 instanceof SyntheticArgumentBinding ? 536870979 : 536870977, var3, var3, 159, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1698(TypeDeclaration var1) {
        this.handle(536871343, new String[] {new String(var1.binding.readableName())}, new String[] {new String(var1.binding.shortReadableName())}, 159, var1.field_444, var1.field_445);
    }

    public void method_1699(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.name)};
        this.handle(536870978, var3, var3, 159, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1700(TypeDeclaration var1) {
        this.handle(536871342, new String[] {new String(var1.binding.readableName())}, new String[] {new String(var1.binding.shortReadableName())}, 159, var1.field_444, var1.field_445);
    }

    public void method_1701(ASTNode var1) {
        this.handle(536871173, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void nonGenericTypeCannotBeParameterized(int var1, ASTNode var2, TypeBinding var3, TypeBinding[] var4) {
        if (var2 == null) {
            this.handle(16777740, new String[] {new String(var3.readableName()), this.typesAsString(false, var4, false)}, new String[] {new String(var3.shortReadableName()), this.typesAsString(false, var4, true)}, 131, 0, 0);
        } else {
            this.handle(16777740, new String[] {new String(var3.readableName()), this.typesAsString(false, var4, false)}, new String[] {new String(var3.shortReadableName()), this.typesAsString(false, var4, true)}, this.method_1695((Binding)null, var2), this.method_1694((Binding)null, var2, var1));
        }
    }

    public void method_1703(ASTNode var1, FieldBinding var2) {
        this.nonStaticAccessToStaticField(var1, var2, -1);
    }

    public void nonStaticAccessToStaticField(ASTNode var1, FieldBinding var2, int var3) {
        int var4 = this.computeSeverity(570425420);
        if (var4 != -1) {
            this.handle(570425420, new String[] {new String(var2.declaringClass.readableName()), new String(var2.name)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.name)}, var4, this.method_1696(var2, var1, var3), this.method_1694(var2, var1, var3));
        }
    }

    public void method_1705(ASTNode var1, MethodBinding var2) {
        this.handle(603979893, new String[] {new String(var2.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, false)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.method_374(), var2.parameters, true)}, var1.field_444, var1.field_445);
    }

    public void method_1706(SourceTypeBinding var1) {
        String[] var2 = new String[] {new String(var1.method_179())};
        this.handle(536870944, var2, var2, var1.method_318(), var1.method_317());
    }

    public void noSuchEnclosingInstance(TypeBinding var1, ASTNode var2, boolean var3) {
        int var4;
        if (var3) {
            var4 = 536870940;
        } else if (var2 instanceof ExplicitConstructorCall && ((ExplicitConstructorCall)var2).field_551 == 1) {
            var4 = 16777236;
        } else if (var2 instanceof AllocationExpression && (((AllocationExpression)var2).binding.declaringClass.method_159() || ((AllocationExpression)var2).binding.declaringClass.method_146() && ((AllocationExpression)var2).binding.declaringClass.superclass().method_159())) {
            var4 = 16777237;
        } else {
            var4 = 16777238;
        }
        this.handle(var4, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void notCompatibleTypesError(EqualExpression var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(16777231, new String[] {var4, var5}, new String[] {var6, var7}, var1.field_444, var1.field_445);
    }

    public void notCompatibleTypesError(InstanceOfExpression var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(16777232, new String[] {var4, var5}, new String[] {var6, var7}, var1.field_444, var1.field_445);
    }

    public void method_1710(Expression var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(16777796, new String[] {var4, var5}, new String[] {var6, var7}, var1.field_444, var1.field_445);
    }

    public void method_1711(TypeDeclaration var1) {
        this.handle(536871435, NoArgument, NoArgument, var1.typeParameters[0].field_444, var1.typeParameters[var1.typeParameters.length - 1].field_445);
    }

    public void method_1712(SourceTypeBinding var1) {
        this.handle(536871241, NoArgument, NoArgument, var1.method_318(), var1.method_317());
    }

    public void method_1713(SourceTypeBinding var1) {
        this.handle(536871242, NoArgument, NoArgument, var1.method_318(), var1.method_317());
    }

    public void method_1714(CompoundAssignment var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(16777233, new String[] {var4, var5}, new String[] {var6, var7}, var1.field_444, var1.field_445);
    }

    public void method_1715(MethodBinding var1, MethodBinding var2) {
        this.handle(67109276, new String[] {new String(CharOperation.concat(var1.declaringClass.readableName(), var1.readableName(), '.')), new String(var2.declaringClass.readableName())}, new String[] {new String(CharOperation.concat(var1.declaringClass.shortReadableName(), var1.shortReadableName(), '.')), new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
    }

    public void overridesMethodWithoutSuperInvocation(MethodBinding var1) {
        this.handle(67109280, new String[] {new String(CharOperation.concat(var1.declaringClass.readableName(), var1.readableName(), '.'))}, new String[] {new String(CharOperation.concat(var1.declaringClass.shortReadableName(), var1.shortReadableName(), '.'))}, var1.method_385(), var1.method_383());
    }

    public void method_1717(MethodBinding var1, MethodBinding var2) {
        this.handle(67109274, new String[] {new String(CharOperation.concat(var1.declaringClass.readableName(), var1.readableName(), '.')), new String(var2.declaringClass.readableName())}, new String[] {new String(CharOperation.concat(var1.declaringClass.shortReadableName(), var1.shortReadableName(), '.')), new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
    }

    public void method_1718(CompilationUnitDeclaration var1) {
        String[] var2 = new String[] {CharOperation.toString(var1.currentPackage.tokens)};
        this.handle(16777537, var2, var2, var1.currentPackage.field_444, var1.currentPackage.field_445);
    }

    public void method_1719(CompilationUnitDeclaration var1) {
        String[] var2 = new String[] {CharOperation.toString(var1.compilationResult.compilationUnit.getPackageName()), var1.currentPackage == null ? "" : CharOperation.toString(var1.currentPackage.tokens)};
        this.handle(536871240, var2, var2, var1.currentPackage == null ? 0 : var1.currentPackage.field_444, var1.currentPackage == null ? 0 : var1.currentPackage.field_445);
    }

    public void method_1720(LocalVariableBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(536870971);
        if (var3 != -1) {
            String[] var4 = new String[] {new String(var1.readableName())};
            this.handle(536870971, var4, var4, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
        }
    }

    private String parameterBoundAsString(TypeVariableBinding var1, boolean var2) {
        StringBuffer var3 = new StringBuffer(10);
        if (var1.firstBound == var1.superclass) {
            var3.append(var2 ? var1.superclass.shortReadableName() : var1.superclass.readableName());
        }
        int var4;
        if ((var4 = var1.superInterfaces.length) > 0) {
            for (int var5 = 0; var5 < var4; ++var5) {
                if (var5 > 0 || var1.firstBound == var1.superclass) {
                    var3.append(" & ");
                }
                var3.append(var2 ? var1.superInterfaces[var5].shortReadableName() : var1.superInterfaces[var5].readableName());
            }
        }
        return var3.toString();
    }

    public void method_1722(ASTNode var1, TypeBinding var2) {
        if (var1 == null) {
            this.handle(16777778, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, 131, 0, 0);
        } else {
            this.handle(16777778, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
        }
    }

    public void method_1723(int var1, int var2, int var3, char[] var4, String var5) {
        this.syntaxError(1610612968, var1, var2, var3, var4, var5, (String)null);
    }

    public void method_1724(int var1, int var2) {
        this.handle(1610612969, NoArgument, NoArgument, var1, var2);
    }

    public void method_1725(int var1, int var2, int var3, char[] var4, String var5, String var6) {
        this.syntaxError(1610612967, var1, var2, var3, var4, var5, var6);
    }

    public void method_1726(int var1, int var2, int var3, char[] var4, String var5, String var6) {
        this.syntaxError(1610612966, var1, var2, var3, var4, var5, var6);
    }

    public void parseErrorInsertToComplete(int var1, int var2, String var3, String var4) {
        String[] var5 = new String[] {var3, var4};
        this.handle(1610612976, var5, var5, var1, var2);
    }

    public void method_1728(int var1, int var2, String var3) {
        String[] var4 = new String[] {var3};
        this.handle(1610612978, var4, var4, var1, var2);
    }

    public void method_1729(int var1, int var2, String var3) {
        String[] var4 = new String[] {var3};
        this.handle(1610612977, var4, var4, var1, var2);
    }

    public void method_1730(int var1, int var2, int var3, char[] var4, String var5, String var6) {
        this.syntaxError(1610612971, var1, var2, var3, var4, var5, var6);
    }

    public void method_1731(int var1, int var2, String var3) {
        String[] var4 = new String[] {var3};
        this.handle(1610612970, var4, var4, var1, var2);
    }

    public void method_1732(int var1, int var2) {
        this.handle(1610612972, NoArgument, NoArgument, var1, var2);
    }

    public void method_1733(int var1, int var2, int var3, char[] var4, String var5) {
        this.syntaxError(1610612941, var1, var2, var3, var4, var5, (String)null);
    }

    public void method_1734(int var1, int var2) {
        this.handle(1610612974, NoArgument, NoArgument, var1, var2);
    }

    public void method_1735(int var1, int var2, int var3, char[] var4, String var5, String var6) {
        this.syntaxError(1610612940, var1, var2, var3, var4, var5, var6);
    }

    public void method_1736(int var1, int var2, String var3) {
        String[] var4 = new String[] {var3};
        this.handle(1610612973, var4, var4, var1, var2);
    }

    public void method_1737(int var1, int var2) {
        String[] var3;
        if (this.referenceContext instanceof ConstructorDeclaration) {
            var3 = new String[] {Messages.field_1890};
        } else if (this.referenceContext instanceof MethodDeclaration) {
            var3 = new String[] {Messages.field_1891};
        } else if (this.referenceContext instanceof TypeDeclaration) {
            var3 = new String[] {Messages.field_1892};
        } else {
            var3 = new String[] {Messages.field_1889};
        }
        this.handle(1610612975, var3, var3, var1, var2);
    }

    public void possibleAccidentalBooleanAssignment(Assignment var1) {
        this.handle(536871091, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1739(CaseStatement var1) {
        this.handle(536871106, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1740(CompilationUnitDeclaration var1, TypeDeclaration var2) {
        this.referenceContext = var2;
        String[] var3 = new String[] {new String(var1.method_771()), new String(var2.name)};
        this.handle(16777541, var3, var3, var2.field_444, var2.field_445, var1.compilationResult);
    }

    public void rawMemberTypeCannotBeParameterized(ASTNode var1, ReferenceBinding var2, TypeBinding[] var3) {
        if (var1 == null) {
            this.handle(16777777, new String[] {new String(var2.readableName()), this.typesAsString(false, var3, false), new String(var2.enclosingType().readableName())}, new String[] {new String(var2.shortReadableName()), this.typesAsString(false, var3, true), new String(var2.enclosingType().shortReadableName())}, 131, 0, 0);
        } else {
            this.handle(16777777, new String[] {new String(var2.readableName()), this.typesAsString(false, var3, false), new String(var2.enclosingType().readableName())}, new String[] {new String(var2.shortReadableName()), this.typesAsString(false, var3, true), new String(var2.enclosingType().shortReadableName())}, var1.field_444, var1.field_445);
        }
    }

    public void method_1742(ASTNode var1, TypeBinding var2) {
        var2 = var2.method_173();
        this.handle(16777788, new String[] {new String(var2.readableName()), new String(var2.erasure().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var2.erasure().shortReadableName())}, var1.field_444, this.method_1693((Binding)null, var1));
    }

    public void recursiveConstructorInvocation(ExplicitConstructorCall var1) {
        this.handle(134217865, new String[] {new String(var1.binding.declaringClass.readableName()), this.typesAsString(var1.binding.method_374(), var1.binding.parameters, false)}, new String[] {new String(var1.binding.declaringClass.shortReadableName()), this.typesAsString(var1.binding.method_374(), var1.binding.parameters, true)}, var1.field_444, var1.field_445);
    }

    public void method_1744(Argument var1) {
        String[] var2 = new String[] {new String(var1.name)};
        this.handle(536870968, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1745(LocalDeclaration var1) {
        String[] var2 = new String[] {new String(var1.name)};
        this.handle(536870967, var2, var2, var1.field_444, var1.field_445);
    }

    public void redundantSuperInterface(SourceTypeBinding var1, TypeReference var2, ReferenceBinding var3, ReferenceBinding var4) {
        int var5 = this.computeSeverity(16777547);
        if (var5 != -1) {
            this.handle(16777547, new String[] {new String(var3.readableName()), new String(var1.readableName()), new String(var4.readableName())}, new String[] {new String(var3.shortReadableName()), new String(var1.shortReadableName()), new String(var4.shortReadableName())}, var5, var2.field_444, var2.field_445);
        }
    }

    public void referenceMustBeArrayTypeAt(TypeBinding var1, ArrayReference var2) {
        this.handle(536871062, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void reset() {
        this.positionScanner = null;
    }

    private int method_1749(int var1) {
        if (this.referenceContext == null) {
            return var1;
        } else {
            CompilationResult var2 = this.referenceContext.compilationResult();
            if (var2 == null) {
                return var1;
            } else {
                ICompilationUnit var3 = var2.getCompilationUnit();
                if (var3 == null) {
                    return var1;
                } else {
                    char[] var4 = var3.getContents();
                    if (var4.length == 0) {
                        return var1;
                    } else {
                        if (this.positionScanner == null) {
                            Scanner var10001 = new Scanner(false, false, false, this.options.field_1928, this.options.field_1927, (char[][])null, (char[][])null, false);
                            this.positionScanner = var10001;
                            this.positionScanner.field_1294 = true;
                        }
                        this.positionScanner.setSource(var4);
                        this.positionScanner.method_2435(var1, var4.length);
                        int var5 = var1;
                        int var6 = 0;
                        int var7;
                        try {
                            while ((var7 = this.positionScanner.getNextToken()) != 68) {
                                switch (var7) {
                                    case 7:
                                        ++var6;
                                        break;
                                    case 13:
                                        --var6;
                                        if (var6 != 0) {
                                            break;
                                        }
                                        var5 = this.positionScanner.field_1231 - 1;
                                        return var5;
                                    case 69:
                                        return var5;
                                }
                            }
                        } catch (InvalidInputException var8) {
                            ;
                        }
                        return var5;
                    }
                }
            }
        }
    }

    private int method_1750(int var1, int var2, int var3) {
        if (this.referenceContext == null) {
            return var2;
        } else {
            CompilationResult var4 = this.referenceContext.compilationResult();
            if (var4 == null) {
                return var2;
            } else {
                ICompilationUnit var5 = var4.getCompilationUnit();
                if (var5 == null) {
                    return var2;
                } else {
                    char[] var6 = var5.getContents();
                    if (var6.length == 0) {
                        return var2;
                    } else {
                        if (this.positionScanner == null) {
                            Scanner var10001 = new Scanner(false, false, false, this.options.field_1928, this.options.field_1927, (char[][])null, (char[][])null, false);
                            this.positionScanner = var10001;
                        }
                        this.positionScanner.setSource(var6);
                        this.positionScanner.method_2435(var1, var2);
                        try {
                            int var8 = var2;
                            int var7;
                            while ((var7 = this.positionScanner.getNextToken()) != 68) {
                                switch (var7) {
                                    case 29:
                                        return var8;
                                    default:
                                        var8 = this.positionScanner.field_1231 - 1;
                                }
                            }
                        } catch (InvalidInputException var9) {
                            ;
                        }
                        return var2;
                    }
                }
            }
        }
    }

    private int method_1751(int var1, int var2, int var3) {
        if (this.referenceContext == null) {
            return var1;
        } else {
            CompilationResult var4 = this.referenceContext.compilationResult();
            if (var4 == null) {
                return var1;
            } else {
                ICompilationUnit var5 = var4.getCompilationUnit();
                if (var5 == null) {
                    return var1;
                } else {
                    char[] var6 = var5.getContents();
                    if (var6.length == 0) {
                        return var1;
                    } else {
                        if (this.positionScanner == null) {
                            Scanner var10001 = new Scanner(false, false, false, this.options.field_1928, this.options.field_1927, (char[][])null, (char[][])null, false);
                            this.positionScanner = var10001;
                        }
                        this.positionScanner.setSource(var6);
                        this.positionScanner.method_2435(var1, var2);
                        int var7 = 0;
                        int var8;
                        try {
                            while ((var8 = this.positionScanner.getNextToken()) != 68) {
                                switch (var8) {
                                    case 28:
                                        ++var7;
                                        if (var7 == var3) {
                                            this.positionScanner.getNextToken();
                                            return this.positionScanner.field_1230;
                                        }
                                }
                            }
                        } catch (InvalidInputException var9) {
                            ;
                        }
                        return var1;
                    }
                }
            }
        }
    }

    public void method_1752(MethodDeclaration var1) {
        this.handle(536870966, NoArgument, NoArgument, var1.returnType.field_444, var1.returnType.field_445);
    }

    public void scannerError(Parser var1, String var2) {
        Scanner var3 = var1.scanner;
        int var4 = 1610612941;
        int var5 = var3.field_1230;
        int var6 = var3.field_1231 - 1;
        if (var2.equals("End_Of_Source")) {
            var4 = 1610612986;
        } else if (var2.equals("Invalid_Hexa_Literal")) {
            var4 = 1610612987;
        } else if (var2.equals("Invalid_Octal_Literal")) {
            var4 = 1610612988;
        } else if (var2.equals("Invalid_Character_Constant")) {
            var4 = 1610612989;
        } else if (var2.equals("Invalid_Escape")) {
            var4 = 1610612990;
        } else {
            char[] var7;
            int var8;
            if (var2.equals("Invalid_Unicode_Escape")) {
                var4 = 1610612992;
                var7 = var3.field_1237;
                var8 = var3.field_1231 - 1;
                if (var8 >= var7.length) {
                    var8 = var7.length - 1;
                }
                while (var8 >= var5 && var7[var8] != 92) {
                    --var8;
                }
                var5 = var8;
            } else if (var2.equals("Invalid_Low_Surrogate")) {
                var4 = 1610612999;
            } else if (var2.equals("Invalid_High_Surrogate")) {
                var4 = 1610613000;
                var7 = var3.field_1237;
                for (var8 = var3.field_1230 + 1; var8 <= var6 && var7[var8] != 92; ++var8) {
                    ;
                }
                var6 = var8 - 1;
            } else if (var2.equals("Invalid_Float_Literal")) {
                var4 = 1610612993;
            } else if (var2.equals("Unterminated_String")) {
                var4 = 1610612995;
            } else if (var2.equals("Unterminated_Comment")) {
                var4 = 1610612996;
            } else if (var2.equals("Invalid_Char_In_String")) {
                var4 = 1610612995;
            } else if (var2.equals("Invalid_Digit")) {
                var4 = 1610612998;
            }
        }
        String[] var9 = var4 == 1610612941 ? new String[] {var2}: NoArgument;
        this.handle(var4, var9, var9, var5, var6, var1.compilationUnit.compilationResult);
    }

    public void method_1754(TypeBinding var1, ASTNode var2) {
        this.handle(603979884, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1755(Expression var1) {
        this.handle(536871063, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1756(MethodBinding var1, MethodBinding var2) {
        if (var1.method_370()) {
            this.handle(67109271, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
        } else {
            this.handle(67109270, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
        }
    }

    public void method_1757(ASTNode var1, FieldBinding var2) {
        String[] var3 = new String[] {new String(var2.readableName())};
        this.handle(33554506, var3, var3, this.method_1695(var2, var1), this.method_1693(var2, var1));
    }

    public void method_1758(SourceTypeBinding var1, MethodBinding var2, MethodBinding[] var3) {
        this.handle(67109272, new String[] {new String(var2.readableName()), new String(var3[0].declaringClass.readableName())}, new String[] {new String(var2.readableName()), new String(var3[0].declaringClass.shortReadableName())}, var1.method_318(), var1.method_317());
    }

    public void staticMemberOfParameterizedType(ASTNode var1, ReferenceBinding var2) {
        if (var1 == null) {
            this.handle(16777779, new String[] {new String(var2.readableName()), new String(var2.enclosingType().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var2.enclosingType().shortReadableName())}, 131, 0, 0);
        } else {
            int var3 = var1.field_445;
            this.handle(16777779, new String[] {new String(var2.readableName()), new String(var2.enclosingType().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var2.enclosingType().shortReadableName())}, var1.field_444, var3);
        }
    }

    public void method_1760(ASTNode var1) {
        this.handle(536871064, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1761(SourceTypeBinding var1, TypeReference var2, ReferenceBinding var3) {
        this.handle(16777528, new String[] {new String(var3.readableName()), new String(var1.method_179())}, new String[] {new String(var3.shortReadableName()), new String(var1.method_179())}, var2.field_444, var2.field_445);
    }

    public void method_1762(int var1, int var2) {
        this.handle(536871092, NoArgument, NoArgument, var1, var2);
    }

    public void method_1763(SourceTypeBinding var1, TypeReference var2, ReferenceBinding var3) {
        this.handle(16777531, new String[] {new String(var3.readableName()), new String(var1.method_179())}, new String[] {new String(var3.shortReadableName()), new String(var1.method_179())}, var2.field_444, var2.field_445);
    }

    public void superinterfacesCollide(TypeBinding var1, ASTNode var2, TypeBinding var3, TypeBinding var4) {
        this.handle(16777755, new String[] {new String(var3.readableName()), new String(var4.readableName()), new String(var1.method_179())}, new String[] {new String(var3.shortReadableName()), new String(var4.shortReadableName()), new String(var1.method_179())}, var2.field_444, var2.field_445);
    }

    public void method_1765(SourceTypeBinding var1, TypeReference var2, TypeBinding var3) {
        String var4 = new String(var1.method_179());
        String var5 = new String(var3.readableName());
        String var6 = new String(var3.shortReadableName());
        if (var6.equals(var4)) {
            var6 = var5;
        }
        this.handle(16777772, new String[] {var5, var4}, new String[] {var6, var4}, var2.field_444, var2.field_445);
    }

    private void syntaxError(int var1, int var2, int var3, int var4, char[] var5, String var6, String var7) {
        String var8;
        if (!this.method_1657(var4) && !this.method_1658(var4) && !this.method_1656(var4)) {
            var8 = var6;
        } else {
            var8 = new String(var5);
        }
        String[] var9;
        if (var7 != null) {
            var9 = new String[] {var8, var7};
        } else {
            var9 = new String[] {var8};
        }
        this.handle(var1, var9, var9, var2, var3);
    }

    public void method_1767(String var1, String var2, String var3, int var4, int var5) {
        this.handle(536871362, new String[] {var1, var2, var3}, new String[] {var1, var2, var3}, var4, var5);
    }

    public void method_1768(ASTNode var1) {
        this.handle(536870980, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void method_1769(TypeDeclaration var1) {
        this.handle(536871344, new String[] {new String(var1.binding.readableName())}, new String[] {new String(var1.binding.shortReadableName())}, 159, var1.field_444, var1.field_445);
    }

    public void method_1770(TypeDeclaration var1) {
        this.handle(536871345, new String[] {new String(var1.binding.readableName())}, new String[] {new String(var1.binding.shortReadableName())}, 159, var1.field_444, var1.field_445);
    }

    public void typeCastError(CastExpression var1, TypeBinding var2, TypeBinding var3) {
        String var4 = new String(var2.readableName());
        String var5 = new String(var3.readableName());
        String var6 = new String(var2.shortReadableName());
        String var7 = new String(var3.shortReadableName());
        if (var6.equals(var7)) {
            var6 = var4;
            var7 = var5;
        }
        this.handle(16777372, new String[] {var5, var4}, new String[] {var7, var6}, var1.field_444, var1.field_445);
    }

    public void method_1772(TypeDeclaration var1) {
        String[] var2 = new String[] {new String(var1.name)};
        this.handle(16777534, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1773(CompilationUnitDeclaration var1, TypeDeclaration var2) {
        this.referenceContext = var2;
        String[] var3 = new String[] {new String(var1.method_771()), new String(var2.name)};
        this.handle(16777538, var3, var3, var2.field_444, var2.field_445, var1.compilationResult);
    }

    public void typeHiding(TypeDeclaration var1, TypeBinding var2) {
        int var3 = this.computeSeverity(16777249);
        if (var3 != -1) {
            this.handle(16777249, new String[] {new String(var1.name), new String(var2.shortReadableName())}, new String[] {new String(var1.name), new String(var2.readableName())}, var3, var1.field_444, var1.field_445);
        }
    }

    public void typeHiding(TypeDeclaration var1, TypeVariableBinding var2) {
        int var3 = this.computeSeverity(16777792);
        if (var3 != -1) {
            if (var2.declaringElement instanceof TypeBinding) {
                TypeBinding var4 = (TypeBinding)var2.declaringElement;
                this.handle(16777792, new String[] {new String(var1.name), new String(var2.readableName()), new String(var4.readableName())}, new String[] {new String(var1.name), new String(var2.shortReadableName()), new String(var4.shortReadableName())}, var3, var1.field_444, var1.field_445);
            } else {
                MethodBinding var5 = (MethodBinding)var2.declaringElement;
                this.handle(16777793, new String[] {new String(var1.name), new String(var2.readableName()), new String(var5.selector), this.typesAsString(var5.method_374(), var5.parameters, false), new String(var5.declaringClass.readableName())}, new String[] {new String(var1.name), new String(var2.shortReadableName()), new String(var5.selector), this.typesAsString(var5.method_374(), var5.parameters, true), new String(var5.declaringClass.shortReadableName())}, var3, var1.field_444, var1.field_445);
            }
        }
    }

    public void typeHiding(TypeParameter var1, Binding var2) {
        int var3 = this.computeSeverity(16777787);
        if (var3 != -1) {
            TypeBinding var4 = (TypeBinding)var2;
            this.handle(16777787, new String[] {new String(var1.name), new String(var4.readableName())}, new String[] {new String(var1.name), new String(var4.shortReadableName())}, var3, var1.field_444, var1.field_445);
        }
    }

    public void typeMismatchError(TypeBinding var1, TypeBinding var2, ASTNode var3, ASTNode var4) {
        if (var1 != null && (var1.tagBits & 128L) != 0L) {
            this.handle(16777218, new String[] {new String(var1.method_173().readableName())}, new String[] {new String(var1.method_173().shortReadableName())}, var3.field_444, var3.field_445);
        } else if (var4 != null && (var2.tagBits & 128L) != 0L) {
            this.handle(16777218, new String[] {new String(var2.method_173().readableName())}, new String[] {new String(var2.method_173().shortReadableName())}, var4.field_444, var4.field_445);
        } else {
            this.handle(16777233, new String[] {new String(var1.readableName()), new String(var2.readableName())}, new String[] {new String(var1.shortReadableName()), new String(var2.shortReadableName())}, var3.field_444, var3.field_445);
        }
    }

    public void typeMismatchError(TypeBinding var1, TypeVariableBinding var2, ReferenceBinding var3, ASTNode var4) {
        if (var4 == null) {
            this.handle(16777742, new String[] {new String(var1.readableName()), new String(var3.readableName()), new String(var2.sourceName), this.parameterBoundAsString(var2, false)}, new String[] {new String(var1.shortReadableName()), new String(var3.shortReadableName()), new String(var2.sourceName), this.parameterBoundAsString(var2, true)}, 131, 0, 0);
        } else {
            this.handle(16777742, new String[] {new String(var1.readableName()), new String(var3.readableName()), new String(var2.sourceName), this.parameterBoundAsString(var2, false)}, new String[] {new String(var1.shortReadableName()), new String(var3.shortReadableName()), new String(var2.sourceName), this.parameterBoundAsString(var2, true)}, var4.field_444, var4.field_445);
        }
    }

    private String typesAsString(boolean var1, TypeBinding[] var2, boolean var3) {
        StringBuffer var4 = new StringBuffer(10);
        int var5 = 0;
        for (int var6 = var2.length; var5 < var6; ++var5) {
            if (var5 != 0) {
                var4.append(", ");
            }
            TypeBinding var7 = var2[var5];
            boolean var8 = var1 && var5 == var6 - 1;
            if (var8) {
                var7 = ((ArrayBinding)var7).method_187();
            }
            var4.append(new String(var3 ? var7.shortReadableName() : var7.readableName()));
            if (var8) {
                var4.append("...");
            }
        }
        return var4.toString();
    }

    public void method_1780(TypeBinding var1, MemberValuePair var2) {
        if (!this.isRecoveredName(var2.name)) {
            String var3 = new String(var2.name);
            this.handle(67109475, new String[] {var3, new String(var1.readableName())}, new String[] {var3, new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
        }
    }

    public void undefinedLabel(BranchStatement var1) {
        if (!this.isRecoveredName(var1.label)) {
            String[] var2 = new String[] {new String(var1.label)};
            this.handle(536871086, var2, var2, var1.field_444, var1.field_445);
        }
    }

    public void undefinedTypeVariableSignature(char[] var1, ReferenceBinding var2) {
        this.handle(536871450, new String[] {new String(var1), new String(var2.readableName())}, new String[] {new String(var1), new String(var2.shortReadableName())}, 131, 0, 0);
    }

    public void method_1783(int var1, int var2) {
        this.handle(536871372, NoArgument, NoArgument, var1, var2);
    }

    public void method_1784(SourceTypeBinding var1, FieldDeclaration var2) {
        String[] var3 = new String[] {new String(var2.name)};
        this.handle(33554778, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1785(ReferenceBinding var1, AbstractMethodDeclaration var2) {
        String[] var3 = new String[] {new String(var1.method_179()), new String(var2.selector)};
        this.handle(67109225, var3, var3, var2.field_444, var2.field_445);
    }

    public void method_1786(TypeBinding var1, ASTNode var2) {
        boolean var3 = this.referenceContext instanceof ConstructorDeclaration && ((ConstructorDeclaration)this.referenceContext).method_796();
        boolean var4 = var2 instanceof ExplicitConstructorCall && ((ExplicitConstructorCall)var2).field_551 == 1;
        this.handle(var3 ? 16777362 : (var4 ? 134217871 : 16777384), new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void method_1787(Expression var1) {
        String[] var2 = new String[] {var1.constant.method_3287()};
        this.handle(536871543, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1788(FieldBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(33554513, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void method_1789(LocalVariableBinding var1, ASTNode var2) {
        String[] var3 = new String[] {new String(var1.readableName())};
        this.handle(536870963, var3, var3, this.method_1695(var1, var2), this.method_1693(var1, var2));
    }

    public void unnecessaryCast(CastExpression var1) {
        int var2 = this.computeSeverity(553648309);
        if (var2 != -1) {
            TypeBinding var3 = var1.field_684.resolvedType;
            this.handle(553648309, new String[] {new String(var3.readableName()), new String(var1.field_685.resolvedType.readableName())}, new String[] {new String(var3.shortReadableName()), new String(var1.field_685.resolvedType.shortReadableName())}, var2, var1.field_444, var1.field_445);
        }
    }

    public void method_1791(ASTNode var1) {
        this.handle(536871101, NoArgument, NoArgument, var1.field_444, var1.field_445);
    }

    public void unnecessaryEnclosingInstanceSpecification(Expression var1, ReferenceBinding var2) {
        this.handle(16777239, new String[] {new String(var2.readableName())}, new String[] {new String(var2.shortReadableName())}, var1.field_444, var1.field_445);
    }

    public void unnecessaryInstanceof(InstanceOfExpression var1, TypeBinding var2) {
        int var3 = this.computeSeverity(553648311);
        if (var3 != -1) {
            TypeBinding var4 = var1.expression.resolvedType;
            this.handle(553648311, new String[] {new String(var4.readableName()), new String(var2.readableName())}, new String[] {new String(var4.shortReadableName()), new String(var2.shortReadableName())}, var3, var1.field_444, var1.field_445);
        }
    }

    public void method_1794(int var1, int var2) {
        this.handle(536871177, NoArgument, NoArgument, var1, var2);
    }

    public void unnecessaryTypeArgumentsForMethodInvocation(MethodBinding var1, TypeBinding[] var2, TypeReference[] var3) {
        String var4 = var1.method_358() ? new String(var1.declaringClass.shortReadableName()) : new String(var1.selector);
        this.handle(var1.method_358() ? 67109524 : 67109443, new String[] {var4, this.typesAsString(var1.method_374(), var1.parameters, false), new String(var1.declaringClass.readableName()), this.typesAsString(var1.method_374(), var2, false)}, new String[] {var4, this.typesAsString(var1.method_374(), var1.parameters, true), new String(var1.declaringClass.shortReadableName()), this.typesAsString(var1.method_374(), var2, true)}, var3[0].field_444, var3[var3.length - 1].field_445);
    }

    public void method_1796(NameReference var1, FieldBinding var2) {
        int var3 = var1.field_444;
        int var4 = var1.field_445;
        if (var1 instanceof SingleNameReference) {
            int var5 = (var1.field_446 & 534773760) >> 21;
            if (var5 != 0) {
                var3 = this.method_1751(var3, var4, var5);
                var4 = this.method_1750(var3, var4, var5);
            } else {
                var3 = this.method_1695(var2, var1);
                var4 = this.method_1693(var2, var1);
            }
        } else {
            var3 = this.method_1695(var2, var1);
            var4 = this.method_1693(var2, var1);
        }
        this.handle(570425423, new String[] {new String(var2.declaringClass.readableName()), new String(var2.name)}, new String[] {new String(var2.declaringClass.shortReadableName()), new String(var2.name)}, var3, var4);
    }

    public void method_1797(ReferenceBinding var1, ASTNode var2) {
        this.handle(83886247, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var2.field_444, var2.field_445);
    }

    public void unreachableCode(Statement var1) {
        int var2 = var1.field_444;
        int var3 = var1.field_445;
        if (var1 instanceof LocalDeclaration) {
            LocalDeclaration var4 = (LocalDeclaration)var1;
            var2 = var4.field_653;
            var3 = var4.field_652;
        } else if (var1 instanceof Expression) {
            int var5 = ((Expression)var1).field_673;
            if (var5 != -1) {
                var3 = var5;
            }
        }
        this.handle(536871073, NoArgument, NoArgument, var2, var3);
    }

    public void unresolvableReference(NameReference var1, Binding var2) {
        String[] var3 = new String[] {new String(var2.readableName())};
        int var4 = var1.field_445;
        if (var1 instanceof QualifiedNameReference) {
            QualifiedNameReference var5 = (QualifiedNameReference)var1;
            if (this.isRecoveredName(var5.tokens)) {
                return;
            }
            if (var5.indexOfFirstFieldBinding >= 1) {
                var4 = (int)var5.sourcePositions[var5.indexOfFirstFieldBinding - 1];
            }
        } else {
            SingleNameReference var6 = (SingleNameReference)var1;
            if (this.isRecoveredName(var6.token)) {
                return;
            }
        }
        this.handle(570425394, var3, var3, var1.field_444, var4);
    }

    public void unsafeCast(CastExpression var1, Scope var2) {
        int var3 = this.computeSeverity(16777761);
        if (var3 != -1) {
            TypeBinding var4 = var1.field_684.resolvedType;
            TypeBinding var5 = var1.resolvedType;
            this.handle(16777761, new String[] {new String(var4.readableName()), new String(var5.readableName())}, new String[] {new String(var4.shortReadableName()), new String(var5.shortReadableName())}, var3, var1.field_444, var1.field_445);
        }
    }

    public void method_1801(TypeBinding var1, ASTNode var2) {
        int var3 = this.computeSeverity(67109438);
        if (var3 != -1) {
            this.handle(67109438, new String[] {new String(var1.readableName())}, new String[] {new String(var1.shortReadableName())}, var3, var2.field_444, var2.field_445);
        }
    }

    public void unsafeRawFieldAssignment(FieldBinding var1, TypeBinding var2, ASTNode var3) {
        int var4 = this.computeSeverity(16777752);
        if (var4 != -1) {
            this.handle(16777752, new String[] {new String(var2.readableName()), new String(var1.name), new String(var1.declaringClass.readableName()), new String(var1.declaringClass.erasure().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var1.name), new String(var1.declaringClass.shortReadableName()), new String(var1.declaringClass.erasure().shortReadableName())}, var4, this.method_1695(var1, var3), this.method_1693(var1, var3));
        }
    }

    public void method_1803(ASTNode var1, MethodBinding var2) {
        boolean var3 = var2.method_358();
        int var4 = this.computeSeverity(var3 ? 16777785 : 16777786);
        if (var4 != -1) {
            if (var3) {
                this.handle(16777785, new String[] {new String(var2.declaringClass.method_179()), this.typesAsString(var2.original().method_374(), var2.original().parameters, false), new String(var2.declaringClass.readableName()), this.typesAsString(var2.original().method_374(), var2.parameters, false)}, new String[] {new String(var2.declaringClass.method_179()), this.typesAsString(var2.original().method_374(), var2.original().parameters, true), new String(var2.declaringClass.shortReadableName()), this.typesAsString(var2.original().method_374(), var2.parameters, true)}, var4, var1.field_444, var1.field_445);
            } else {
                this.handle(16777786, new String[] {new String(var2.selector), this.typesAsString(var2.original().method_374(), var2.original().parameters, false), new String(var2.declaringClass.readableName()), this.typesAsString(var2.original().method_374(), var2.parameters, false)}, new String[] {new String(var2.selector), this.typesAsString(var2.original().method_374(), var2.original().parameters, true), new String(var2.declaringClass.shortReadableName()), this.typesAsString(var2.original().method_374(), var2.parameters, true)}, var4, var1.field_444, var1.field_445);
            }
        }
    }

    public void method_1804(ASTNode var1, MethodBinding var2) {
        boolean var3 = var2.method_358();
        int var4 = this.computeSeverity(var3 ? 16777746 : 16777747);
        if (var4 != -1) {
            if (var3) {
                this.handle(16777746, new String[] {new String(var2.declaringClass.readableName()), this.typesAsString(var2.original().method_374(), var2.parameters, false), new String(var2.declaringClass.erasure().readableName())}, new String[] {new String(var2.declaringClass.shortReadableName()), this.typesAsString(var2.original().method_374(), var2.parameters, true), new String(var2.declaringClass.erasure().shortReadableName())}, var4, var1.field_444, var1.field_445);
            } else {
                this.handle(16777747, new String[] {new String(var2.selector), this.typesAsString(var2.original().method_374(), var2.parameters, false), new String(var2.declaringClass.readableName()), new String(var2.declaringClass.erasure().readableName())}, new String[] {new String(var2.selector), this.typesAsString(var2.original().method_374(), var2.parameters, true), new String(var2.declaringClass.shortReadableName()), new String(var2.declaringClass.erasure().shortReadableName())}, var4, var1.field_444, var1.field_445);
            }
        }
    }

    public void method_1805(MethodBinding var1, MethodBinding var2, SourceTypeBinding var3) {
        int var4 = this.computeSeverity(67109423);
        if (var4 != -1) {
            int var5 = var3.method_318();
            int var6 = var3.method_317();
            if (var1.declaringClass == var3) {
                TypeReference var7 = ((MethodDeclaration)var1.sourceMethod()).returnType;
                var5 = var7.method_5();
                var6 = var7.method_6();
            }
            this.handle(67109423, new String[] {new String(var1.returnType.readableName()), new String(var1.selector), this.typesAsString(var1.original().method_374(), var1.original().parameters, false), new String(var1.declaringClass.readableName()), new String(var2.returnType.readableName()), new String(var2.declaringClass.readableName())}, new String[] {new String(var1.returnType.shortReadableName()), new String(var1.selector), this.typesAsString(var1.original().method_374(), var1.original().parameters, true), new String(var1.declaringClass.shortReadableName()), new String(var2.returnType.shortReadableName()), new String(var2.declaringClass.shortReadableName())}, var4, var5, var6);
        }
    }

    public void method_1806(Expression var1, TypeBinding var2, TypeBinding var3) {
        int var4 = this.computeSeverity(16777748);
        if (var4 != -1) {
            this.handle(16777748, new String[] {new String(var2.readableName()), new String(var3.readableName()), new String(var3.erasure().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var3.shortReadableName()), new String(var3.erasure().shortReadableName())}, var4, var1.field_444, var1.field_445);
        }
    }

    public void method_1807(LocalDeclaration var1) {
        int var2 = this.computeSeverity(536870974);
        if (var2 != -1) {
            String[] var3 = new String[] {new String(var1.name)};
            this.handle(536870974, var3, var3, var2, var1.field_444, var1.field_445);
        }
    }

    public void unusedDeclaredThrownException(ReferenceBinding var1, AbstractMethodDeclaration var2, ASTNode var3) {
        boolean var4 = var2.method_795();
        int var5 = this.computeSeverity(var4 ? 536871098 : 536871097);
        if (var5 != -1) {
            if (var4) {
                this.handle(536871098, new String[] {new String(var2.binding.declaringClass.readableName()), this.typesAsString(var2.binding.method_374(), var2.binding.parameters, false), new String(var1.readableName())}, new String[] {new String(var2.binding.declaringClass.shortReadableName()), this.typesAsString(var2.binding.method_374(), var2.binding.parameters, true), new String(var1.shortReadableName())}, var5, var3.field_444, var3.field_445);
            } else {
                this.handle(536871097, new String[] {new String(var2.binding.declaringClass.readableName()), new String(var2.selector), this.typesAsString(var2.binding.method_374(), var2.binding.parameters, false), new String(var1.readableName())}, new String[] {new String(var2.binding.declaringClass.shortReadableName()), new String(var2.selector), this.typesAsString(var2.binding.method_374(), var2.binding.parameters, true), new String(var1.shortReadableName())}, var5, var3.field_444, var3.field_445);
            }
        }
    }

    public void method_1809(ImportReference var1) {
        int var2 = this.computeSeverity(268435844);
        if (var2 != -1) {
            String[] var3 = new String[] {CharOperation.toString(var1.tokens)};
            this.handle(268435844, var3, var3, var2, var1.field_444, var1.field_445);
        }
    }

    public void unusedLabel(LabeledStatement var1) {
        int var2 = this.computeSeverity(536871111);
        if (var2 != -1) {
            String[] var3 = new String[] {new String(var1.label)};
            this.handle(536871111, var3, var3, var2, var1.field_444, var1.labelEnd);
        }
    }

    public void method_1811(LocalDeclaration var1) {
        int var2 = this.computeSeverity(536870973);
        if (var2 != -1) {
            String[] var3 = new String[] {new String(var1.name)};
            this.handle(536870973, var3, var3, var2, var1.field_444, var1.field_445);
        }
    }

    public void method_1812(ConstructorDeclaration var1) {
        int var2 = this.computeSeverity(603979910);
        if (var2 != -1) {
            MethodBinding var3 = var1.binding;
            this.handle(603979910, new String[] {new String(var3.declaringClass.readableName()), this.typesAsString(var3.method_374(), var3.parameters, false)}, new String[] {new String(var3.declaringClass.shortReadableName()), this.typesAsString(var3.method_374(), var3.parameters, true)}, var2, var1.field_444, var1.field_445);
        }
    }

    public void method_1813(FieldDeclaration var1) {
        int var2 = this.computeSeverity(570425421);
        if (var2 != -1) {
            FieldBinding var3 = var1.binding;
            if (!CharOperation.method_1364(TypeConstants.field_37, var3.name) || !var3.method_431() || !var3.method_409() || TypeBinding.field_183 != var3.type) {
                if (!CharOperation.method_1364(TypeConstants.field_38, var3.name) || !var3.method_431() || !var3.method_409() || var3.type.method_136() != 1 || !CharOperation.method_1364(TypeConstants.field_48, var3.type.method_173().readableName())) {
                    this.handle(570425421, new String[] {new String(var3.declaringClass.readableName()), new String(var3.name)}, new String[] {new String(var3.declaringClass.shortReadableName()), new String(var3.name)}, var2, this.method_1695(var3, var1), this.method_1693(var3, var1));
                }
            }
        }
    }

    public void method_1814(AbstractMethodDeclaration var1) {
        int var2 = this.computeSeverity(603979894);
        if (var2 != -1) {
            MethodBinding var3 = var1.binding;
            if (var3.method_370() || TypeBinding.field_188 != var3.returnType || var3.parameters.length != 1 || var3.parameters[0].method_136() != 0 || !CharOperation.method_1364(var3.selector, TypeConstants.field_41) || !CharOperation.method_1364(TypeConstants.field_46, var3.parameters[0].readableName())) {
                if (var3.method_370() || TypeBinding.field_188 != var3.returnType || var3.parameters.length != 1 || var3.parameters[0].method_136() != 0 || !CharOperation.method_1364(var3.selector, TypeConstants.field_42) || !CharOperation.method_1364(TypeConstants.field_47, var3.parameters[0].readableName())) {
                    if (var3.method_370() || 1 != var3.returnType.id || var3.parameters.length != 0 || !CharOperation.method_1364(var3.selector, TypeConstants.field_39)) {
                        if (var3.method_370() || 1 != var3.returnType.id || var3.parameters.length != 0 || !CharOperation.method_1364(var3.selector, TypeConstants.field_40)) {
                            this.handle(603979894, new String[] {new String(var3.declaringClass.readableName()), new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, false)}, new String[] {new String(var3.declaringClass.shortReadableName()), new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, true)}, var2, var1.field_444, var1.field_445);
                        }
                    }
                }
            }
        }
    }

    public void method_1815(TypeDeclaration var1) {
        int var2 = this.computeSeverity(553648135);
        if (var2 != -1) {
            SourceTypeBinding var3 = var1.binding;
            this.handle(553648135, new String[] {new String(var3.readableName())}, new String[] {new String(var3.shortReadableName())}, var2, var1.field_444, var1.field_445);
        }
    }

    public void method_1816(Expression var1) {
        String[] var2 = new String[] {var1.constant.method_3287()};
        this.handle(536871547, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1817(int var1, int var2) {
        this.handle(536871352, NoArgument, NoArgument, var1, var2);
    }

    public void method_1818(int var1, int var2) {
        this.handle(536871353, NoArgument, NoArgument, var1, var2);
    }

    public void varargsArgumentNeedCast(MethodBinding var1, TypeBinding var2, InvocationSite var3) {
        int var4 = this.options.method_3313(34359738368L);
        if (var4 != -1) {
            ArrayBinding var5 = (ArrayBinding)var1.parameters[var1.parameters.length - 1];
            if (var1.method_358()) {
                this.handle(134218530, new String[] {new String(var2.readableName()), new String(var5.readableName()), new String(var1.declaringClass.readableName()), this.typesAsString(var1.method_374(), var1.parameters, false), new String(var5.method_187().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var5.shortReadableName()), new String(var1.declaringClass.shortReadableName()), this.typesAsString(var1.method_374(), var1.parameters, true), new String(var5.method_187().shortReadableName())}, var4, var3.method_5(), var3.method_6());
            } else {
                this.handle(67109665, new String[] {new String(var2.readableName()), new String(var5.readableName()), new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, false), new String(var1.declaringClass.readableName()), new String(var5.method_187().readableName())}, new String[] {new String(var2.shortReadableName()), new String(var5.shortReadableName()), new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, true), new String(var1.declaringClass.shortReadableName()), new String(var5.method_187().shortReadableName())}, var4, var3.method_5(), var3.method_6());
            }
        }
    }

    public void method_1820(MethodBinding var1, MethodBinding var2, SourceTypeBinding var3) {
        this.handle(67109667, new String[] {new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, false), new String(var1.declaringClass.readableName()), this.typesAsString(var2.method_374(), var2.parameters, false), new String(var2.declaringClass.readableName())}, new String[] {new String(var1.selector), this.typesAsString(var1.method_374(), var1.parameters, true), new String(var1.declaringClass.shortReadableName()), this.typesAsString(var2.method_374(), var2.parameters, true), new String(var2.declaringClass.shortReadableName())}, var1.declaringClass == var3 ? var1.method_385() : var3.method_318(), var1.declaringClass == var3 ? var1.method_383() : var3.method_317());
    }

    public void method_1821(AbstractVariableDeclaration var1) {
        String[] var2 = new String[] {new String(var1.name)};
        this.handle(536870964, var2, var2, var1.field_444, var1.field_445);
    }

    public void method_1822(AbstractVariableDeclaration var1) {
        this.handle(536870966, NoArgument, NoArgument, var1.type.field_444, var1.type.field_445);
    }

    public void method_1823(MethodBinding var1, MethodBinding var2) {
        this.handle(67109273, new String[] {new String(var2.declaringClass.readableName())}, new String[] {new String(var2.declaringClass.shortReadableName())}, var1.method_385(), var1.method_383());
    }

    public void wildcardAssignment(TypeBinding var1, TypeBinding var2, ASTNode var3) {
        this.handle(16777758, new String[] {new String(var2.readableName()), new String(var1.readableName())}, new String[] {new String(var2.shortReadableName()), new String(var1.shortReadableName())}, var3.field_444, var3.field_445);
    }

    public void wildcardInvocation(ASTNode var1, TypeBinding var2, MethodBinding var3, TypeBinding[] var4) {
        TypeBinding var5 = null;
        TypeBinding var6 = null;
        int var7 = 0;
        for (int var8 = var3.parameters.length; var7 < var8; ++var7) {
            TypeBinding var9 = var3.parameters[var7];
            if (var9.method_172() && ((WildcardBinding)var9).field_215 != 2) {
                var6 = var9;
                var5 = var4[var7];
                break;
            }
        }
        if (var3.method_358()) {
            this.handle(16777756, new String[] {new String(var2.method_179()), this.typesAsString(var3.method_374(), var3.parameters, false), new String(var2.readableName()), this.typesAsString(false, var4, false), new String(var5.readableName()), new String(var6.readableName())}, new String[] {new String(var2.method_179()), this.typesAsString(var3.method_374(), var3.parameters, true), new String(var2.shortReadableName()), this.typesAsString(false, var4, true), new String(var5.shortReadableName()), new String(var6.shortReadableName())}, var1.field_444, var1.field_445);
        } else {
            this.handle(16777757, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, false), new String(var2.readableName()), this.typesAsString(false, var4, false), new String(var5.readableName()), new String(var6.readableName())}, new String[] {new String(var3.selector), this.typesAsString(var3.method_374(), var3.parameters, true), new String(var2.shortReadableName()), this.typesAsString(false, var4, true), new String(var5.shortReadableName()), new String(var6.shortReadableName())}, var1.field_444, var1.field_445);
        }
    }

    public void wrongSequenceOfExceptionTypesError(TryStatement var1, TypeBinding var2, int var3, TypeBinding var4) {
        TypeReference var5 = var1.catchArguments[var3].type;
        this.handle(553648315, new String[] {new String(var2.readableName()), new String(var4.readableName())}, new String[] {new String(var2.shortReadableName()), new String(var4.shortReadableName())}, var5.field_444, var5.field_445);
    }
}
