// Generated from C:\Users\Diogo\Documents\antlrworks2\Workspace\BaseGrammar.g4 by ANTLR 4.1
package dungeon.souls.modding.tool.model.compiling.language;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BaseGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BaseGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#assetModule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetModule(@NotNull BaseGrammarParser.AssetModuleContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull BaseGrammarParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(@NotNull BaseGrammarParser.ComparisonContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#assetItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetItem(@NotNull BaseGrammarParser.AssetItemContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(@NotNull BaseGrammarParser.Function_callContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#functionArgumentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgumentDeclaration(@NotNull BaseGrammarParser.FunctionArgumentDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull BaseGrammarParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#math_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_operation(@NotNull BaseGrammarParser.Math_operationContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull BaseGrammarParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#explicit_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_code(@NotNull BaseGrammarParser.Explicit_codeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#function_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parameter(@NotNull BaseGrammarParser.Function_parameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#math_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_value(@NotNull BaseGrammarParser.Math_valueContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#start_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_expression(@NotNull BaseGrammarParser.Start_expressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#block_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_code(@NotNull BaseGrammarParser.Block_codeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BaseGrammarParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull BaseGrammarParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(@NotNull BaseGrammarParser.If_statementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull BaseGrammarParser.TermContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(@NotNull BaseGrammarParser.CommentContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#assetSprite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetSprite(@NotNull BaseGrammarParser.AssetSpriteContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull BaseGrammarParser.FactorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#asset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsset(@NotNull BaseGrammarParser.AssetContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#assetFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssetFunction(@NotNull BaseGrammarParser.AssetFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link BaseGrammarParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull BaseGrammarParser.ValueContext ctx);
}