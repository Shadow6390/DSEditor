// Generated from C:\Users\Diogo\Documents\antlrworks2\Workspace\BaseGrammar.g4 by ANTLR 4.1
package dungeon.souls.modding.tool.model.compiling.language;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BaseGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IF=2, ELSE=3, DECLARATION=4, MODULE=5, FUNCTION=6, SPRITE=7, ITEM=8, 
		FUNCTION_ARGUMENT=9, ASSIGN=10, OPERATOR=11, BLOCK_START=12, BLOCK_END=13, 
		OBRACKETS=14, CBRACKETS=15, END_STATEMENT=16, MATH_OPERATOR_MULT_DIV=17, 
		MATH_OPERATOR_PLUS_MINUS=18, VARIABLE=19, STRING=20, REAL=21, GAME_VARIABLE=22, 
		COMMENT=23, WHITESPACE=24;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'if'", "'else'", "'define'", "'module'", "'function'", 
		"'sprite'", "'item'", "FUNCTION_ARGUMENT", "'='", "OPERATOR", "'{'", "'}'", 
		"'('", "')'", "';'", "MATH_OPERATOR_MULT_DIV", "MATH_OPERATOR_PLUS_MINUS", 
		"VARIABLE", "STRING", "REAL", "GAME_VARIABLE", "COMMENT", "WHITESPACE"
	};
	public static final int
		RULE_start = 0, RULE_start_expression = 1, RULE_explicit_code = 2, RULE_block_code = 3, 
		RULE_statement = 4, RULE_if_statement = 5, RULE_expression = 6, RULE_assignment = 7, 
		RULE_math_operation = 8, RULE_factor = 9, RULE_term = 10, RULE_comparison = 11, 
		RULE_function_call = 12, RULE_function_parameter = 13, RULE_functionArgumentDeclaration = 14, 
		RULE_math_value = 15, RULE_variable = 16, RULE_value = 17, RULE_asset = 18, 
		RULE_assetModule = 19, RULE_assetSprite = 20, RULE_assetItem = 21, RULE_assetFunction = 22, 
		RULE_comment = 23;
	public static final String[] ruleNames = {
		"start", "start_expression", "explicit_code", "block_code", "statement", 
		"if_statement", "expression", "assignment", "math_operation", "factor", 
		"term", "comparison", "function_call", "function_parameter", "functionArgumentDeclaration", 
		"math_value", "variable", "value", "asset", "assetModule", "assetSprite", 
		"assetItem", "assetFunction", "comment"
	};

	@Override
	public String getGrammarFileName() { return "BaseGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public BaseGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<Start_expressionContext> start_expression() {
			return getRuleContexts(Start_expressionContext.class);
		}
		public Start_expressionContext start_expression(int i) {
			return getRuleContext(Start_expressionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48); start_expression();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DECLARATION || _la==COMMENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Start_expressionContext extends ParserRuleContext {
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public TerminalNode DECLARATION() { return getToken(BaseGrammarParser.DECLARATION, 0); }
		public AssetContext asset() {
			return getRuleContext(AssetContext.class,0);
		}
		public Start_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterStart_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitStart_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitStart_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_expressionContext start_expression() throws RecognitionException {
		Start_expressionContext _localctx = new Start_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start_expression);
		try {
			setState(56);
			switch (_input.LA(1)) {
			case DECLARATION:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(53); match(DECLARATION);
				setState(54); asset();
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(55); comment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Explicit_codeContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Block_codeContext block_code() {
			return getRuleContext(Block_codeContext.class,0);
		}
		public Explicit_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterExplicit_code(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitExplicit_code(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitExplicit_code(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Explicit_codeContext explicit_code() throws RecognitionException {
		Explicit_codeContext _localctx = new Explicit_codeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_explicit_code);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case IF:
			case FUNCTION_ARGUMENT:
			case VARIABLE:
			case GAME_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(58); statement();
				}
				break;
			case BLOCK_START:
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(59); block_code();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_codeContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public Block_codeContext block_code(int i) {
			return getRuleContext(Block_codeContext.class,i);
		}
		public List<TerminalNode> DECLARATION() { return getTokens(BaseGrammarParser.DECLARATION); }
		public List<AssetFunctionContext> assetFunction() {
			return getRuleContexts(AssetFunctionContext.class);
		}
		public AssetFunctionContext assetFunction(int i) {
			return getRuleContext(AssetFunctionContext.class,i);
		}
		public TerminalNode BLOCK_END() { return getToken(BaseGrammarParser.BLOCK_END, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode DECLARATION(int i) {
			return getToken(BaseGrammarParser.DECLARATION, i);
		}
		public TerminalNode BLOCK_START() { return getToken(BaseGrammarParser.BLOCK_START, 0); }
		public List<Block_codeContext> block_code() {
			return getRuleContexts(Block_codeContext.class);
		}
		public Block_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterBlock_code(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitBlock_code(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitBlock_code(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_codeContext block_code() throws RecognitionException {
		Block_codeContext _localctx = new Block_codeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block_code);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(62); comment();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68); match(BLOCK_START);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << DECLARATION) | (1L << FUNCTION_ARGUMENT) | (1L << BLOCK_START) | (1L << VARIABLE) | (1L << GAME_VARIABLE) | (1L << COMMENT))) != 0)) {
				{
				setState(74);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(69); statement();
					}
					break;

				case 2:
					{
					setState(70); comment();
					}
					break;

				case 3:
					{
					{
					setState(71); match(DECLARATION);
					setState(72); assetFunction();
					}
					}
					break;

				case 4:
					{
					setState(73); block_code();
					}
					break;
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79); match(BLOCK_END);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(80); comment();
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(86); if_statement();
				}
				break;
			case FUNCTION_ARGUMENT:
			case VARIABLE:
			case GAME_VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public List<TerminalNode> CBRACKETS() { return getTokens(BaseGrammarParser.CBRACKETS); }
		public List<TerminalNode> ELSE() { return getTokens(BaseGrammarParser.ELSE); }
		public List<TerminalNode> IF() { return getTokens(BaseGrammarParser.IF); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public List<TerminalNode> OBRACKETS() { return getTokens(BaseGrammarParser.OBRACKETS); }
		public TerminalNode OBRACKETS(int i) {
			return getToken(BaseGrammarParser.OBRACKETS, i);
		}
		public TerminalNode ELSE(int i) {
			return getToken(BaseGrammarParser.ELSE, i);
		}
		public TerminalNode IF(int i) {
			return getToken(BaseGrammarParser.IF, i);
		}
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public Explicit_codeContext explicit_code(int i) {
			return getRuleContext(Explicit_codeContext.class,i);
		}
		public List<Explicit_codeContext> explicit_code() {
			return getRuleContexts(Explicit_codeContext.class);
		}
		public TerminalNode CBRACKETS(int i) {
			return getToken(BaseGrammarParser.CBRACKETS, i);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(90); match(IF);
					setState(91); match(OBRACKETS);
					setState(92); comparison();
					setState(93); match(CBRACKETS);
					setState(97);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(94); comment();
							}
							} 
						}
						setState(99);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					}
					setState(100); explicit_code();
					setState(103);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(101); match(ELSE);
						setState(102); explicit_code();
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(107); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public FunctionArgumentDeclarationContext functionArgumentDeclaration() {
			return getRuleContext(FunctionArgumentDeclarationContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode END_STATEMENT() { return getToken(BaseGrammarParser.END_STATEMENT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(109); assignment();
				}
				break;

			case 2:
				{
				setState(110); function_call();
				}
				break;

			case 3:
				{
				setState(111); functionArgumentDeclaration();
				}
				break;
			}
			setState(114); match(END_STATEMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(BaseGrammarParser.ASSIGN, 0); }
		public Math_operationContext math_operation() {
			return getRuleContext(Math_operationContext.class,0);
		}
		public Math_valueContext math_value() {
			return getRuleContext(Math_valueContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); variable();
			setState(117); match(ASSIGN);
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(118); math_value();
				}
				break;

			case 2:
				{
				setState(119); math_operation();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Math_operationContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TerminalNode MATH_OPERATOR_PLUS_MINUS(int i) {
			return getToken(BaseGrammarParser.MATH_OPERATOR_PLUS_MINUS, i);
		}
		public List<TerminalNode> MATH_OPERATOR_PLUS_MINUS() { return getTokens(BaseGrammarParser.MATH_OPERATOR_PLUS_MINUS); }
		public Math_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterMath_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitMath_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitMath_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_operationContext math_operation() throws RecognitionException {
		Math_operationContext _localctx = new Math_operationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_math_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); factor();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATH_OPERATOR_PLUS_MINUS) {
				{
				{
				setState(123); match(MATH_OPERATOR_PLUS_MINUS);
				setState(124); factor();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode MATH_OPERATOR_MULT_DIV(int i) {
			return getToken(BaseGrammarParser.MATH_OPERATOR_MULT_DIV, i);
		}
		public List<TerminalNode> MATH_OPERATOR_MULT_DIV() { return getTokens(BaseGrammarParser.MATH_OPERATOR_MULT_DIV); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); term();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATH_OPERATOR_MULT_DIV) {
				{
				{
				setState(131); match(MATH_OPERATOR_MULT_DIV);
				setState(132); term();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TerminalNode CBRACKETS() { return getToken(BaseGrammarParser.CBRACKETS, 0); }
		public Math_operationContext math_operation() {
			return getRuleContext(Math_operationContext.class,0);
		}
		public TerminalNode OBRACKETS() { return getToken(BaseGrammarParser.OBRACKETS, 0); }
		public Math_valueContext math_value() {
			return getRuleContext(Math_valueContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_term);
		try {
			setState(143);
			switch (_input.LA(1)) {
			case OBRACKETS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(138); match(OBRACKETS);
				setState(139); math_operation();
				setState(140); match(CBRACKETS);
				}
				}
				break;
			case VARIABLE:
			case STRING:
			case REAL:
			case GAME_VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); math_value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public Function_callContext function_call(int i) {
			return getRuleContext(Function_callContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public List<Function_callContext> function_call() {
			return getRuleContexts(Function_callContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode OPERATOR() { return getToken(BaseGrammarParser.OPERATOR, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(145); variable();
				}
				break;

			case 2:
				{
				setState(146); value();
				}
				break;

			case 3:
				{
				setState(147); function_call();
				}
				break;
			}
			setState(150); match(OPERATOR);
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(151); variable();
				}
				break;

			case 2:
				{
				setState(152); value();
				}
				break;

			case 3:
				{
				setState(153); function_call();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode CBRACKETS() { return getToken(BaseGrammarParser.CBRACKETS, 0); }
		public TerminalNode OBRACKETS() { return getToken(BaseGrammarParser.OBRACKETS, 0); }
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public List<Function_parameterContext> function_parameter() {
			return getRuleContexts(Function_parameterContext.class);
		}
		public Function_parameterContext function_parameter(int i) {
			return getRuleContext(Function_parameterContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(VARIABLE);
			setState(157); match(OBRACKETS);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VARIABLE) | (1L << STRING) | (1L << REAL) | (1L << GAME_VARIABLE))) != 0)) {
				{
				{
				setState(158); function_parameter();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164); match(CBRACKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_parameterContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Function_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterFunction_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitFunction_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitFunction_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parameterContext function_parameter() throws RecognitionException {
		Function_parameterContext _localctx = new Function_parameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_parameter);
		try {
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				switch (_input.LA(1)) {
				case VARIABLE:
				case GAME_VARIABLE:
					{
					setState(166); variable();
					}
					break;
				case STRING:
				case REAL:
					{
					setState(167); value();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(170); match(1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				switch (_input.LA(1)) {
				case VARIABLE:
				case GAME_VARIABLE:
					{
					setState(172); variable();
					}
					break;
				case STRING:
				case REAL:
					{
					setState(173); value();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION_ARGUMENT() { return getToken(BaseGrammarParser.FUNCTION_ARGUMENT, 0); }
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public FunctionArgumentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgumentDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterFunctionArgumentDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitFunctionArgumentDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitFunctionArgumentDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentDeclarationContext functionArgumentDeclaration() throws RecognitionException {
		FunctionArgumentDeclarationContext _localctx = new FunctionArgumentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionArgumentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(FUNCTION_ARGUMENT);
			setState(179); match(VARIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Math_valueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Math_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterMath_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitMath_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitMath_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_valueContext math_value() throws RecognitionException {
		Math_valueContext _localctx = new Math_valueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_math_value);
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181); variable();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); value();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183); function_call();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode GAME_VARIABLE() { return getToken(BaseGrammarParser.GAME_VARIABLE, 0); }
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !(_la==VARIABLE || _la==GAME_VARIABLE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(BaseGrammarParser.REAL, 0); }
		public TerminalNode STRING() { return getToken(BaseGrammarParser.STRING, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==REAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetContext extends ParserRuleContext {
		public AssetFunctionContext assetFunction() {
			return getRuleContext(AssetFunctionContext.class,0);
		}
		public AssetModuleContext assetModule() {
			return getRuleContext(AssetModuleContext.class,0);
		}
		public AssetSpriteContext assetSprite() {
			return getRuleContext(AssetSpriteContext.class,0);
		}
		public AssetItemContext assetItem() {
			return getRuleContext(AssetItemContext.class,0);
		}
		public AssetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterAsset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitAsset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitAsset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetContext asset() throws RecognitionException {
		AssetContext _localctx = new AssetContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_asset);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(190); assetModule();
				}
				break;
			case SPRITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(191); assetSprite();
				}
				break;
			case ITEM:
				enterOuterAlt(_localctx, 3);
				{
				setState(192); assetItem();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(193); assetFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetModuleContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public TerminalNode MODULE() { return getToken(BaseGrammarParser.MODULE, 0); }
		public Block_codeContext block_code() {
			return getRuleContext(Block_codeContext.class,0);
		}
		public AssetModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetModule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterAssetModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitAssetModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitAssetModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetModuleContext assetModule() throws RecognitionException {
		AssetModuleContext _localctx = new AssetModuleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assetModule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(MODULE);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(197); comment();
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203); match(VARIABLE);
			setState(204); block_code();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetSpriteContext extends ParserRuleContext {
		public TerminalNode SPRITE() { return getToken(BaseGrammarParser.SPRITE, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public TerminalNode END_STATEMENT(int i) {
			return getToken(BaseGrammarParser.END_STATEMENT, i);
		}
		public TerminalNode BLOCK_END() { return getToken(BaseGrammarParser.BLOCK_END, 0); }
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> END_STATEMENT() { return getTokens(BaseGrammarParser.END_STATEMENT); }
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public TerminalNode BLOCK_START() { return getToken(BaseGrammarParser.BLOCK_START, 0); }
		public AssetSpriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetSprite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterAssetSprite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitAssetSprite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitAssetSprite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetSpriteContext assetSprite() throws RecognitionException {
		AssetSpriteContext _localctx = new AssetSpriteContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assetSprite);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206); match(SPRITE);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(207); comment();
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213); match(VARIABLE);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(214); comment();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(220); match(BLOCK_START);
			}
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(225);
					switch (_input.LA(1)) {
					case VARIABLE:
					case GAME_VARIABLE:
						{
						{
						setState(221); assignment();
						setState(222); match(END_STATEMENT);
						}
						}
						break;
					case COMMENT:
						{
						setState(224); comment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(237);
			switch (_input.LA(1)) {
			case BLOCK_END:
				{
				setState(230); match(BLOCK_END);
				}
				break;
			case EOF:
			case DECLARATION:
			case COMMENT:
				{
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(231); comment();
						}
						} 
					}
					setState(236);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetItemContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode ITEM() { return getToken(BaseGrammarParser.ITEM, 0); }
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public Block_codeContext block_code() {
			return getRuleContext(Block_codeContext.class,0);
		}
		public AssetItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterAssetItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitAssetItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitAssetItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetItemContext assetItem() throws RecognitionException {
		AssetItemContext _localctx = new AssetItemContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assetItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(ITEM);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(240); comment();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246); match(VARIABLE);
			setState(247); block_code();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetFunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(BaseGrammarParser.FUNCTION, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode VARIABLE() { return getToken(BaseGrammarParser.VARIABLE, 0); }
		public Block_codeContext block_code() {
			return getRuleContext(Block_codeContext.class,0);
		}
		public AssetFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assetFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterAssetFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitAssetFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitAssetFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetFunctionContext assetFunction() throws RecognitionException {
		AssetFunctionContext _localctx = new AssetFunctionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assetFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); match(FUNCTION);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(250); comment();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256); match(VARIABLE);
			setState(257); block_code();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(BaseGrammarParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\32\u0108\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\6\2\64\n\2\r\2\16\2\65\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\5\4?\n\4\3\5"+
		"\7\5B\n\5\f\5\16\5E\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13"+
		"\5\3\5\3\5\7\5T\n\5\f\5\16\5W\13\5\3\6\3\6\5\6[\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\7\7b\n\7\f\7\16\7e\13\7\3\7\3\7\3\7\5\7j\n\7\6\7l\n\7\r\7\16\7m\3\b"+
		"\3\b\3\b\5\bs\n\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t{\n\t\3\n\3\n\3\n\7\n\u0080"+
		"\n\n\f\n\16\n\u0083\13\n\3\13\3\13\3\13\7\13\u0088\n\13\f\13\16\13\u008b"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\5\f\u0092\n\f\3\r\3\r\3\r\5\r\u0097\n\r\3\r"+
		"\3\r\3\r\3\r\5\r\u009d\n\r\3\16\3\16\3\16\7\16\u00a2\n\16\f\16\16\16\u00a5"+
		"\13\16\3\16\3\16\3\17\3\17\5\17\u00ab\n\17\3\17\3\17\3\17\3\17\5\17\u00b1"+
		"\n\17\5\17\u00b3\n\17\3\20\3\20\3\20\3\21\3\21\3\21\5\21\u00bb\n\21\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00c5\n\24\3\25\3\25\7\25"+
		"\u00c9\n\25\f\25\16\25\u00cc\13\25\3\25\3\25\3\25\3\26\3\26\7\26\u00d3"+
		"\n\26\f\26\16\26\u00d6\13\26\3\26\3\26\7\26\u00da\n\26\f\26\16\26\u00dd"+
		"\13\26\3\26\3\26\3\26\3\26\3\26\7\26\u00e4\n\26\f\26\16\26\u00e7\13\26"+
		"\3\26\3\26\7\26\u00eb\n\26\f\26\16\26\u00ee\13\26\5\26\u00f0\n\26\3\27"+
		"\3\27\7\27\u00f4\n\27\f\27\16\27\u00f7\13\27\3\27\3\27\3\27\3\30\3\30"+
		"\7\30\u00fe\n\30\f\30\16\30\u0101\13\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\4\4\2\25\25"+
		"\30\30\3\2\26\27\u0118\2\63\3\2\2\2\4:\3\2\2\2\6>\3\2\2\2\bC\3\2\2\2\n"+
		"Z\3\2\2\2\fk\3\2\2\2\16r\3\2\2\2\20v\3\2\2\2\22|\3\2\2\2\24\u0084\3\2"+
		"\2\2\26\u0091\3\2\2\2\30\u0096\3\2\2\2\32\u009e\3\2\2\2\34\u00b2\3\2\2"+
		"\2\36\u00b4\3\2\2\2 \u00ba\3\2\2\2\"\u00bc\3\2\2\2$\u00be\3\2\2\2&\u00c4"+
		"\3\2\2\2(\u00c6\3\2\2\2*\u00d0\3\2\2\2,\u00f1\3\2\2\2.\u00fb\3\2\2\2\60"+
		"\u0105\3\2\2\2\62\64\5\4\3\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\66\3\3\2\2\2\678\7\6\2\28;\5&\24\29;\5\60\31\2:\67\3\2"+
		"\2\2:9\3\2\2\2;\5\3\2\2\2<?\5\n\6\2=?\5\b\5\2><\3\2\2\2>=\3\2\2\2?\7\3"+
		"\2\2\2@B\5\60\31\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2E"+
		"C\3\2\2\2FN\7\16\2\2GM\5\n\6\2HM\5\60\31\2IJ\7\6\2\2JM\5.\30\2KM\5\b\5"+
		"\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2OQ\3\2\2\2PN\3\2\2\2QU\7\17\2\2RT\5\60\31\2SR\3\2\2\2TW\3\2\2\2US\3"+
		"\2\2\2UV\3\2\2\2V\t\3\2\2\2WU\3\2\2\2X[\5\f\7\2Y[\5\16\b\2ZX\3\2\2\2Z"+
		"Y\3\2\2\2[\13\3\2\2\2\\]\7\4\2\2]^\7\20\2\2^_\5\30\r\2_c\7\21\2\2`b\5"+
		"\60\31\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2f"+
		"i\5\6\4\2gh\7\5\2\2hj\5\6\4\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2k\\\3\2\2\2"+
		"lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\r\3\2\2\2os\5\20\t\2ps\5\32\16\2qs\5\36"+
		"\20\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2st\3\2\2\2tu\7\22\2\2u\17\3\2\2\2v"+
		"w\5\"\22\2wz\7\f\2\2x{\5 \21\2y{\5\22\n\2zx\3\2\2\2zy\3\2\2\2{\21\3\2"+
		"\2\2|\u0081\5\24\13\2}~\7\24\2\2~\u0080\5\24\13\2\177}\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\23\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\u0089\5\26\f\2\u0085\u0086\7\23\2\2\u0086\u0088\5"+
		"\26\f\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\25\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\20\2"+
		"\2\u008d\u008e\5\22\n\2\u008e\u008f\7\21\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u0092\5 \21\2\u0091\u008c\3\2\2\2\u0091\u0090\3\2\2\2\u0092\27\3\2\2"+
		"\2\u0093\u0097\5\"\22\2\u0094\u0097\5$\23\2\u0095\u0097\5\32\16\2\u0096"+
		"\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009c\7\r\2\2\u0099\u009d\5\"\22\2\u009a\u009d\5$\23\2\u009b"+
		"\u009d\5\32\16\2\u009c\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3"+
		"\2\2\2\u009d\31\3\2\2\2\u009e\u009f\7\25\2\2\u009f\u00a3\7\20\2\2\u00a0"+
		"\u00a2\5\34\17\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7\21\2\2\u00a7\33\3\2\2\2\u00a8\u00ab\5\"\22\2\u00a9\u00ab\5$\23"+
		"\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad"+
		"\7\3\2\2\u00ad\u00b3\3\2\2\2\u00ae\u00b1\5\"\22\2\u00af\u00b1\5$\23\2"+
		"\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00aa"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\35\3\2\2\2\u00b4\u00b5\7\13\2\2\u00b5"+
		"\u00b6\7\25\2\2\u00b6\37\3\2\2\2\u00b7\u00bb\5\"\22\2\u00b8\u00bb\5$\23"+
		"\2\u00b9\u00bb\5\32\16\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb!\3\2\2\2\u00bc\u00bd\t\2\2\2\u00bd#\3\2\2\2\u00be"+
		"\u00bf\t\3\2\2\u00bf%\3\2\2\2\u00c0\u00c5\5(\25\2\u00c1\u00c5\5*\26\2"+
		"\u00c2\u00c5\5,\27\2\u00c3\u00c5\5.\30\2\u00c4\u00c0\3\2\2\2\u00c4\u00c1"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\'\3\2\2\2\u00c6"+
		"\u00ca\7\7\2\2\u00c7\u00c9\5\60\31\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3"+
		"\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf\5\b\5\2\u00cf)\3\2\2\2"+
		"\u00d0\u00d4\7\t\2\2\u00d1\u00d3\5\60\31\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00db\7\25\2\2\u00d8\u00da\5\60\31\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e5\7\16\2\2\u00df\u00e0\5"+
		"\20\t\2\u00e0\u00e1\7\22\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e4\5\60\31\2"+
		"\u00e3\u00df\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00ef\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\u00f0\7\17\2\2\u00e9\u00eb\5\60\31\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee"+
		"\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0+\3\2\2\2"+
		"\u00f1\u00f5\7\n\2\2\u00f2\u00f4\5\60\31\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f8\u00f9\7\25\2\2\u00f9\u00fa\5\b\5\2\u00fa-\3\2\2\2"+
		"\u00fb\u00ff\7\b\2\2\u00fc\u00fe\5\60\31\2\u00fd\u00fc\3\2\2\2\u00fe\u0101"+
		"\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0103\7\25\2\2\u0103\u0104\5\b\5\2\u0104/\3\2\2\2"+
		"\u0105\u0106\7\31\2\2\u0106\61\3\2\2\2#\65:>CLNUZcimrz\u0081\u0089\u0091"+
		"\u0096\u009c\u00a3\u00aa\u00b0\u00b2\u00ba\u00c4\u00ca\u00d4\u00db\u00e3"+
		"\u00e5\u00ec\u00ef\u00f5\u00ff";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}