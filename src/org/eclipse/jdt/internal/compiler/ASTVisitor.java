package org.eclipse.jdt.internal.compiler;

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
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
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
import org.eclipse.jdt.internal.compiler.ast.OR_OR_Expression;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedSuperReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.ExtendedStringLiteral;
import org.eclipse.jdt.internal.compiler.ast.StringLiteralConcatenation;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.DoubleLiteral;
import org.eclipse.jdt.internal.compiler.ast.FloatLiteral;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.CharLiteral;
import org.eclipse.jdt.internal.compiler.ast.LongLiteral;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AnnotationMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.EmptyStatement;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public abstract class ASTVisitor {

    public ASTVisitor() {
    }

    public void endVisit(AllocationExpression var1, BlockScope var2) {}

    public void endVisit(AND_AND_Expression var1, BlockScope var2) {}

    public void endVisit(AnnotationMethodDeclaration var1, ClassScope var2) {}

    public void endVisit(Argument var1, BlockScope var2) {}

    public void endVisit(ArrayAllocationExpression var1, BlockScope var2) {}

    public void endVisit(ArrayInitializer var1, BlockScope var2) {}

    public void endVisit(ArrayQualifiedTypeReference var1, BlockScope var2) {}

    public void endVisit(ArrayQualifiedTypeReference var1, ClassScope var2) {}

    public void endVisit(ArrayReference var1, BlockScope var2) {}

    public void endVisit(ArrayTypeReference var1, BlockScope var2) {}

    public void endVisit(ArrayTypeReference var1, ClassScope var2) {}

    public void endVisit(AssertStatement var1, BlockScope var2) {}

    public void endVisit(Assignment var1, BlockScope var2) {}

    public void endVisit(BinaryExpression var1, BlockScope var2) {}

    public void endVisit(Block var1, BlockScope var2) {}

    public void endVisit(BreakStatement var1, BlockScope var2) {}

    public void endVisit(CaseStatement var1, BlockScope var2) {}

    public void endVisit(CastExpression var1, BlockScope var2) {}

    public void endVisit(CharLiteral var1, BlockScope var2) {}

    public void endVisit(ClassLiteralAccess var1, BlockScope var2) {}

    public void endVisit(Clinit var1, ClassScope var2) {}

    public void endVisit(CompoundAssignment var1, BlockScope var2) {}

    public void endVisit(ConditionalExpression var1, BlockScope var2) {}

    public void endVisit(ConstructorDeclaration var1, ClassScope var2) {}

    public void endVisit(ContinueStatement var1, BlockScope var2) {}

    public void endVisit(DoStatement var1, BlockScope var2) {}

    public void endVisit(DoubleLiteral var1, BlockScope var2) {}

    public void endVisit(EmptyStatement var1, BlockScope var2) {}

    public void endVisit(EqualExpression var1, BlockScope var2) {}

    public void endVisit(ExplicitConstructorCall var1, BlockScope var2) {}

    public void endVisit(ExtendedStringLiteral var1, BlockScope var2) {}

    public void endVisit(FalseLiteral var1, BlockScope var2) {}

    public void endVisit(FieldDeclaration var1, MethodScope var2) {}

    public void endVisit(FieldReference var1, BlockScope var2) {}

    public void endVisit(FloatLiteral var1, BlockScope var2) {}

    public void endVisit(ForeachStatement var1, BlockScope var2) {}

    public void endVisit(ForStatement var1, BlockScope var2) {}

    public void endVisit(IfStatement var1, BlockScope var2) {}

    public void endVisit(Initializer var1, MethodScope var2) {}

    public void endVisit(InstanceOfExpression var1, BlockScope var2) {}

    public void endVisit(IntLiteral var1, BlockScope var2) {}

    public void endVisit(LabeledStatement var1, BlockScope var2) {}

    public void endVisit(LocalDeclaration var1, BlockScope var2) {}

    public void endVisit(LongLiteral var1, BlockScope var2) {}

    public void endVisit(MarkerAnnotation var1, BlockScope var2) {}

    public void endVisit(MemberValuePair var1, BlockScope var2) {}

    public void endVisit(MessageSend var1, BlockScope var2) {}

    public void endVisit(MethodDeclaration var1, ClassScope var2) {}

    public void endVisit(StringLiteralConcatenation var1, BlockScope var2) {}

    public void endVisit(NormalAnnotation var1, BlockScope var2) {}

    public void endVisit(NullLiteral var1, BlockScope var2) {}

    public void endVisit(OR_OR_Expression var1, BlockScope var2) {}

    public void endVisit(ParameterizedQualifiedTypeReference var1, BlockScope var2) {}

    public void endVisit(ParameterizedQualifiedTypeReference var1, ClassScope var2) {}

    public void endVisit(ParameterizedSingleTypeReference var1, BlockScope var2) {}

    public void endVisit(ParameterizedSingleTypeReference var1, ClassScope var2) {}

    public void endVisit(PostfixExpression var1, BlockScope var2) {}

    public void endVisit(PrefixExpression var1, BlockScope var2) {}

    public void endVisit(QualifiedAllocationExpression var1, BlockScope var2) {}

    public void endVisit(QualifiedNameReference var1, BlockScope var2) {}

    public void endVisit(QualifiedSuperReference var1, BlockScope var2) {}

    public void endVisit(QualifiedThisReference var1, BlockScope var2) {}

    public void endVisit(QualifiedTypeReference var1, BlockScope var2) {}

    public void endVisit(QualifiedTypeReference var1, ClassScope var2) {}

    public void endVisit(ReturnStatement var1, BlockScope var2) {}

    public void endVisit(SingleMemberAnnotation var1, BlockScope var2) {}

    public void endVisit(SingleNameReference var1, BlockScope var2) {}

    public void endVisit(SingleTypeReference var1, BlockScope var2) {}

    public void endVisit(SingleTypeReference var1, ClassScope var2) {}

    public void endVisit(StringLiteral var1, BlockScope var2) {}

    public void endVisit(SuperReference var1, BlockScope var2) {}

    public void endVisit(SwitchStatement var1, BlockScope var2) {}

    public void endVisit(SynchronizedStatement var1, BlockScope var2) {}

    public void endVisit(ThisReference var1, BlockScope var2) {}

    public void endVisit(ThrowStatement var1, BlockScope var2) {}

    public void endVisit(TrueLiteral var1, BlockScope var2) {}

    public void endVisit(TryStatement var1, BlockScope var2) {}

    public void endVisit(TypeDeclaration var1, BlockScope var2) {}

    public void endVisit(TypeDeclaration var1, ClassScope var2) {}

    public void endVisit(TypeParameter var1, BlockScope var2) {}

    public void endVisit(TypeParameter var1, ClassScope var2) {}

    public void endVisit(UnaryExpression var1, BlockScope var2) {}

    public void endVisit(WhileStatement var1, BlockScope var2) {}

    public void endVisit(Wildcard var1, BlockScope var2) {}

    public void endVisit(Wildcard var1, ClassScope var2) {}

    public boolean visit(AllocationExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(AND_AND_Expression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(AnnotationMethodDeclaration var1, ClassScope var2) {
        return true;
    }

    public boolean visit(Argument var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ArrayAllocationExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ArrayInitializer var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ArrayQualifiedTypeReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ArrayQualifiedTypeReference var1, ClassScope var2) {
        return true;
    }

    public boolean visit(ArrayReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ArrayTypeReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ArrayTypeReference var1, ClassScope var2) {
        return true;
    }

    public boolean visit(AssertStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(Assignment var1, BlockScope var2) {
        return true;
    }

    public boolean visit(BinaryExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(Block var1, BlockScope var2) {
        return true;
    }

    public boolean visit(BreakStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(CaseStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(CastExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(CharLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ClassLiteralAccess var1, BlockScope var2) {
        return true;
    }

    public boolean visit(Clinit var1, ClassScope var2) {
        return true;
    }

    public boolean visit(CompoundAssignment var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ConditionalExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ConstructorDeclaration var1, ClassScope var2) {
        return true;
    }

    public boolean visit(ContinueStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(DoStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(DoubleLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(EmptyStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(EqualExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ExplicitConstructorCall var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ExtendedStringLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(FalseLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(FieldDeclaration var1, MethodScope var2) {
        return true;
    }

    public boolean visit(FieldReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(FloatLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ForeachStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ForStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(IfStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(Initializer var1, MethodScope var2) {
        return true;
    }

    public boolean visit(InstanceOfExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(IntLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(LabeledStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(LocalDeclaration var1, BlockScope var2) {
        return true;
    }

    public boolean visit(LongLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(MarkerAnnotation var1, BlockScope var2) {
        return true;
    }

    public boolean visit(MemberValuePair var1, BlockScope var2) {
        return true;
    }

    public boolean visit(MessageSend var1, BlockScope var2) {
        return true;
    }

    public boolean visit(MethodDeclaration var1, ClassScope var2) {
        return true;
    }

    public boolean visit(StringLiteralConcatenation var1, BlockScope var2) {
        return true;
    }

    public boolean visit(NormalAnnotation var1, BlockScope var2) {
        return true;
    }

    public boolean visit(NullLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(OR_OR_Expression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ParameterizedQualifiedTypeReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ParameterizedQualifiedTypeReference var1, ClassScope var2) {
        return true;
    }

    public boolean visit(ParameterizedSingleTypeReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ParameterizedSingleTypeReference var1, ClassScope var2) {
        return true;
    }

    public boolean visit(PostfixExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(PrefixExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(QualifiedAllocationExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(QualifiedNameReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(QualifiedSuperReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(QualifiedThisReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(QualifiedTypeReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(QualifiedTypeReference var1, ClassScope var2) {
        return true;
    }

    public boolean visit(ReturnStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SingleMemberAnnotation var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SingleNameReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SingleTypeReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SingleTypeReference var1, ClassScope var2) {
        return true;
    }

    public boolean visit(StringLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SuperReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SwitchStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(SynchronizedStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ThisReference var1, BlockScope var2) {
        return true;
    }

    public boolean visit(ThrowStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(TrueLiteral var1, BlockScope var2) {
        return true;
    }

    public boolean visit(TryStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(TypeDeclaration var1, BlockScope var2) {
        return true;
    }

    public boolean visit(TypeDeclaration var1, ClassScope var2) {
        return true;
    }

    public boolean visit(TypeParameter var1, BlockScope var2) {
        return true;
    }

    public boolean visit(TypeParameter var1, ClassScope var2) {
        return true;
    }

    public boolean visit(UnaryExpression var1, BlockScope var2) {
        return true;
    }

    public boolean visit(WhileStatement var1, BlockScope var2) {
        return true;
    }

    public boolean visit(Wildcard var1, BlockScope var2) {
        return true;
    }

    public boolean visit(Wildcard var1, ClassScope var2) {
        return true;
    }
}
