// Generated from C:\Users\Diogo\Documents\antlrworks2\Workspace\BaseGrammar.g4 by ANTLR 4.1
package dungeon.souls.modding.tool.model.compiling.language;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BaseGrammarParser}.
 */
public interface BaseGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#assetModule}.
	 * @param ctx the parse tree
	 */
	void enterAssetModule(@NotNull BaseGrammarParser.AssetModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#assetModule}.
	 * @param ctx the parse tree
	 */
	void exitAssetModule(@NotNull BaseGrammarParser.AssetModuleContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#assetItem}.
	 * @param ctx the parse tree
	 */
	void enterAssetItem(@NotNull BaseGrammarParser.AssetItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#assetItem}.
	 * @param ctx the parse tree
	 */
	void exitAssetItem(@NotNull BaseGrammarParser.AssetItemContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(@NotNull BaseGrammarParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(@NotNull BaseGrammarParser.Function_callContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameter(@NotNull BaseGrammarParser.Function_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameter(@NotNull BaseGrammarParser.Function_parameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull BaseGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull BaseGrammarParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#free_expression}.
	 * @param ctx the parse tree
	 */
	void enterFree_expression(@NotNull BaseGrammarParser.Free_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#free_expression}.
	 * @param ctx the parse tree
	 */
	void exitFree_expression(@NotNull BaseGrammarParser.Free_expressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull BaseGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull BaseGrammarParser.TermContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(@NotNull BaseGrammarParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(@NotNull BaseGrammarParser.While_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#assetSprite}.
	 * @param ctx the parse tree
	 */
	void enterAssetSprite(@NotNull BaseGrammarParser.AssetSpriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#assetSprite}.
	 * @param ctx the parse tree
	 */
	void exitAssetSprite(@NotNull BaseGrammarParser.AssetSpriteContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull BaseGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull BaseGrammarParser.FactorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull BaseGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull BaseGrammarParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull BaseGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull BaseGrammarParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(@NotNull BaseGrammarParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(@NotNull BaseGrammarParser.ComparisonContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#functionArgumentDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgumentDeclaration(@NotNull BaseGrammarParser.FunctionArgumentDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#functionArgumentDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgumentDeclaration(@NotNull BaseGrammarParser.FunctionArgumentDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull BaseGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull BaseGrammarParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#math_operation}.
	 * @param ctx the parse tree
	 */
	void enterMath_operation(@NotNull BaseGrammarParser.Math_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#math_operation}.
	 * @param ctx the parse tree
	 */
	void exitMath_operation(@NotNull BaseGrammarParser.Math_operationContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull BaseGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull BaseGrammarParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#explicit_code}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_code(@NotNull BaseGrammarParser.Explicit_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#explicit_code}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_code(@NotNull BaseGrammarParser.Explicit_codeContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(@NotNull BaseGrammarParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(@NotNull BaseGrammarParser.For_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull BaseGrammarParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull BaseGrammarParser.ConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#conditional_operator}.
	 * @param ctx the parse tree
	 */
	void enterConditional_operator(@NotNull BaseGrammarParser.Conditional_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#conditional_operator}.
	 * @param ctx the parse tree
	 */
	void exitConditional_operator(@NotNull BaseGrammarParser.Conditional_operatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#math_value}.
	 * @param ctx the parse tree
	 */
	void enterMath_value(@NotNull BaseGrammarParser.Math_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#math_value}.
	 * @param ctx the parse tree
	 */
	void exitMath_value(@NotNull BaseGrammarParser.Math_valueContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#start_expression}.
	 * @param ctx the parse tree
	 */
	void enterStart_expression(@NotNull BaseGrammarParser.Start_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#start_expression}.
	 * @param ctx the parse tree
	 */
	void exitStart_expression(@NotNull BaseGrammarParser.Start_expressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#block_code}.
	 * @param ctx the parse tree
	 */
	void enterBlock_code(@NotNull BaseGrammarParser.Block_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#block_code}.
	 * @param ctx the parse tree
	 */
	void exitBlock_code(@NotNull BaseGrammarParser.Block_codeContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull BaseGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull BaseGrammarParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull BaseGrammarParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull BaseGrammarParser.If_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(@NotNull BaseGrammarParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(@NotNull BaseGrammarParser.CommentContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#asset}.
	 * @param ctx the parse tree
	 */
	void enterAsset(@NotNull BaseGrammarParser.AssetContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#asset}.
	 * @param ctx the parse tree
	 */
	void exitAsset(@NotNull BaseGrammarParser.AssetContext ctx);

	/**
	 * Enter a parse tree produced by {@link BaseGrammarParser#assetFunction}.
	 * @param ctx the parse tree
	 */
	void enterAssetFunction(@NotNull BaseGrammarParser.AssetFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BaseGrammarParser#assetFunction}.
	 * @param ctx the parse tree
	 */
	void exitAssetFunction(@NotNull BaseGrammarParser.AssetFunctionContext ctx);
}