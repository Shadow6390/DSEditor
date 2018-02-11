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
		T__0=1, FOREACH=2, FOR=3, WHILE=4, IF=5, ELSE=6, DECLARATION=7, MODULE=8, 
		FUNCTION=9, SPRITE=10, ITEM=11, FUNCTION_ARGUMENT=12, BOOLEAN=13, ASSIGN=14, 
		OPERATOR=15, AND_OPERATOR=16, OR_OPERATOR=17, BLOCK_START=18, BLOCK_END=19, 
		OBRACKETS=20, CBRACKETS=21, END_STATEMENT=22, MATH_OPERATOR_MULT_DIV=23, 
		MATH_OPERATOR_PLUS_MINUS=24, VARIABLE=25, STRING=26, REAL=27, GAME_VARIABLE=28, 
		COMMENT=29, WHITESPACE=30;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'foreach'", "'for'", "'while'", "'if'", "'else'", 
		"'define'", "'module'", "'function'", "'sprite'", "'item'", "FUNCTION_ARGUMENT", 
		"BOOLEAN", "'='", "OPERATOR", "AND_OPERATOR", "OR_OPERATOR", "'{'", "'}'", 
		"'('", "')'", "';'", "MATH_OPERATOR_MULT_DIV", "MATH_OPERATOR_PLUS_MINUS", 
		"VARIABLE", "STRING", "REAL", "GAME_VARIABLE", "COMMENT", "WHITESPACE"
	};
	public static final int
		RULE_start = 0, RULE_start_expression = 1, RULE_explicit_code = 2, RULE_block_code = 3, 
		RULE_statement = 4, RULE_for_statement = 5, RULE_while_statement = 6, 
		RULE_if_statement = 7, RULE_free_expression = 8, RULE_expression = 9, 
		RULE_assignment = 10, RULE_math_operation = 11, RULE_factor = 12, RULE_term = 13, 
		RULE_condition = 14, RULE_conditional_operator = 15, RULE_comparison = 16, 
		RULE_function_call = 17, RULE_function_parameter = 18, RULE_functionArgumentDeclaration = 19, 
		RULE_math_value = 20, RULE_variable = 21, RULE_value = 22, RULE_asset = 23, 
		RULE_assetModule = 24, RULE_assetSprite = 25, RULE_assetItem = 26, RULE_assetFunction = 27, 
		RULE_comment = 28;
	public static final String[] ruleNames = {
		"start", "start_expression", "explicit_code", "block_code", "statement", 
		"for_statement", "while_statement", "if_statement", "free_expression", 
		"expression", "assignment", "math_operation", "factor", "term", "condition", 
		"conditional_operator", "comparison", "function_call", "function_parameter", 
		"functionArgumentDeclaration", "math_value", "variable", "value", "asset", 
		"assetModule", "assetSprite", "assetItem", "assetFunction", "comment"
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
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58); start_expression();
				}
				}
				setState(61); 
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
			setState(66);
			switch (_input.LA(1)) {
			case DECLARATION:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(63); match(DECLARATION);
				setState(64); asset();
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(65); comment();
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
			setState(70);
			switch (_input.LA(1)) {
			case FOR:
			case WHILE:
			case IF:
			case FUNCTION_ARGUMENT:
			case VARIABLE:
			case GAME_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); statement();
				}
				break;
			case BLOCK_START:
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(69); block_code();
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(72); comment();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78); match(BLOCK_START);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FOR) | (1L << WHILE) | (1L << IF) | (1L << DECLARATION) | (1L << FUNCTION_ARGUMENT) | (1L << BLOCK_START) | (1L << VARIABLE) | (1L << GAME_VARIABLE) | (1L << COMMENT))) != 0)) {
				{
				setState(84);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(79); statement();
					}
					break;

				case 2:
					{
					setState(80); comment();
					}
					break;

				case 3:
					{
					{
					setState(81); match(DECLARATION);
					setState(82); assetFunction();
					}
					}
					break;

				case 4:
					{
					setState(83); block_code();
					}
					break;
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); match(BLOCK_END);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(90); comment();
					}
					} 
				}
				setState(95);
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
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
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
			setState(100);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(96); if_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); for_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(98); while_statement();
				}
				break;
			case FUNCTION_ARGUMENT:
			case VARIABLE:
			case GAME_VARIABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(99); expression();
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

	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode CBRACKETS() { return getToken(BaseGrammarParser.CBRACKETS, 0); }
		public Free_expressionContext free_expression() {
			return getRuleContext(Free_expressionContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode END_STATEMENT(int i) {
			return getToken(BaseGrammarParser.END_STATEMENT, i);
		}
		public TerminalNode FOR() { return getToken(BaseGrammarParser.FOR, 0); }
		public TerminalNode OBRACKETS() { return getToken(BaseGrammarParser.OBRACKETS, 0); }
		public List<TerminalNode> END_STATEMENT() { return getTokens(BaseGrammarParser.END_STATEMENT); }
		public Explicit_codeContext explicit_code() {
			return getRuleContext(Explicit_codeContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_for_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(FOR);
			setState(103); match(OBRACKETS);
			setState(105);
			_la = _input.LA(1);
			if (_la==VARIABLE || _la==GAME_VARIABLE) {
				{
				setState(104); assignment();
				}
			}

			setState(107); match(END_STATEMENT);
			setState(108); condition();
			setState(109); match(END_STATEMENT);
			setState(111);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUNCTION_ARGUMENT) | (1L << VARIABLE) | (1L << GAME_VARIABLE))) != 0)) {
				{
				setState(110); free_expression();
				}
			}

			setState(113); match(CBRACKETS);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(114); comment();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(120); explicit_code();
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

	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode CBRACKETS() { return getToken(BaseGrammarParser.CBRACKETS, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode OBRACKETS() { return getToken(BaseGrammarParser.OBRACKETS, 0); }
		public Explicit_codeContext explicit_code() {
			return getRuleContext(Explicit_codeContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(BaseGrammarParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_while_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122); match(WHILE);
			setState(123); match(OBRACKETS);
			setState(124); condition();
			setState(125); match(CBRACKETS);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(126); comment();
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(132); explicit_code();
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
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
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
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
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
		enterRule(_localctx, 14, RULE_if_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(134); match(IF);
					setState(135); match(OBRACKETS);
					setState(136); condition();
					setState(137); match(CBRACKETS);
					setState(141);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(138); comment();
							}
							} 
						}
						setState(143);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(144); explicit_code();
					setState(147);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(145); match(ELSE);
						setState(146); explicit_code();
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(151); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Free_expressionContext extends ParserRuleContext {
		public FunctionArgumentDeclarationContext functionArgumentDeclaration() {
			return getRuleContext(FunctionArgumentDeclarationContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Free_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_free_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterFree_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitFree_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitFree_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Free_expressionContext free_expression() throws RecognitionException {
		Free_expressionContext _localctx = new Free_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_free_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(153); assignment();
				}
				break;

			case 2:
				{
				setState(154); function_call();
				}
				break;

			case 3:
				{
				setState(155); functionArgumentDeclaration();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Free_expressionContext free_expression() {
			return getRuleContext(Free_expressionContext.class,0);
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
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); free_expression();
			setState(159); match(END_STATEMENT);
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
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); variable();
			setState(162); match(ASSIGN);
			setState(165);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(163); math_value();
				}
				break;

			case 2:
				{
				setState(164); math_operation();
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
		enterRule(_localctx, 22, RULE_math_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); factor();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATH_OPERATOR_PLUS_MINUS) {
				{
				{
				setState(168); match(MATH_OPERATOR_PLUS_MINUS);
				setState(169); factor();
				}
				}
				setState(174);
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
		enterRule(_localctx, 24, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); term();
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATH_OPERATOR_MULT_DIV) {
				{
				{
				setState(176); match(MATH_OPERATOR_MULT_DIV);
				setState(177); term();
				}
				}
				setState(182);
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
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(188);
			switch (_input.LA(1)) {
			case OBRACKETS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(183); match(OBRACKETS);
				setState(184); math_operation();
				setState(185); match(CBRACKETS);
				}
				}
				break;
			case BOOLEAN:
			case VARIABLE:
			case STRING:
			case REAL:
			case GAME_VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); math_value();
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode BOOLEAN(int i) {
			return getToken(BaseGrammarParser.BOOLEAN, i);
		}
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public Conditional_operatorContext conditional_operator(int i) {
			return getRuleContext(Conditional_operatorContext.class,i);
		}
		public List<TerminalNode> BOOLEAN() { return getTokens(BaseGrammarParser.BOOLEAN); }
		public List<Conditional_operatorContext> conditional_operator() {
			return getRuleContexts(Conditional_operatorContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(190); comparison();
				}
				break;

			case 2:
				{
				setState(191); match(BOOLEAN);
				}
				break;
			}
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_OPERATOR || _la==OR_OPERATOR) {
				{
				{
				setState(194); conditional_operator();
				setState(197);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(195); comparison();
					}
					break;

				case 2:
					{
					setState(196); match(BOOLEAN);
					}
					break;
				}
				}
				}
				setState(203);
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

	public static class Conditional_operatorContext extends ParserRuleContext {
		public TerminalNode OR_OPERATOR() { return getToken(BaseGrammarParser.OR_OPERATOR, 0); }
		public TerminalNode AND_OPERATOR() { return getToken(BaseGrammarParser.AND_OPERATOR, 0); }
		public Conditional_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).enterConditional_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BaseGrammarListener ) ((BaseGrammarListener)listener).exitConditional_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BaseGrammarVisitor ) return ((BaseGrammarVisitor<? extends T>)visitor).visitConditional_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_operatorContext conditional_operator() throws RecognitionException {
		Conditional_operatorContext _localctx = new Conditional_operatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditional_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_la = _input.LA(1);
			if ( !(_la==AND_OPERATOR || _la==OR_OPERATOR) ) {
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
		enterRule(_localctx, 32, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(206); variable();
				}
				break;

			case 2:
				{
				setState(207); value();
				}
				break;

			case 3:
				{
				setState(208); function_call();
				}
				break;
			}
			setState(211); match(OPERATOR);
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(212); variable();
				}
				break;

			case 2:
				{
				setState(213); value();
				}
				break;

			case 3:
				{
				setState(214); function_call();
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
		enterRule(_localctx, 34, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(VARIABLE);
			setState(218); match(OBRACKETS);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << VARIABLE) | (1L << STRING) | (1L << REAL) | (1L << GAME_VARIABLE))) != 0)) {
				{
				{
				setState(219); function_parameter();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225); match(CBRACKETS);
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
		enterRule(_localctx, 36, RULE_function_parameter);
		try {
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				switch (_input.LA(1)) {
				case VARIABLE:
				case GAME_VARIABLE:
					{
					setState(227); variable();
					}
					break;
				case BOOLEAN:
				case STRING:
				case REAL:
					{
					setState(228); value();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(231); match(1);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				switch (_input.LA(1)) {
				case VARIABLE:
				case GAME_VARIABLE:
					{
					setState(233); variable();
					}
					break;
				case BOOLEAN:
				case STRING:
				case REAL:
					{
					setState(234); value();
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
		enterRule(_localctx, 38, RULE_functionArgumentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(FUNCTION_ARGUMENT);
			setState(240); match(VARIABLE);
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
		enterRule(_localctx, 40, RULE_math_value);
		try {
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242); variable();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243); value();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244); function_call();
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
		enterRule(_localctx, 42, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		public TerminalNode BOOLEAN() { return getToken(BaseGrammarParser.BOOLEAN, 0); }
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
		enterRule(_localctx, 44, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << STRING) | (1L << REAL))) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_asset);
		try {
			setState(255);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(251); assetModule();
				}
				break;
			case SPRITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(252); assetSprite();
				}
				break;
			case ITEM:
				enterOuterAlt(_localctx, 3);
				{
				setState(253); assetItem();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(254); assetFunction();
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
		enterRule(_localctx, 48, RULE_assetModule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(MODULE);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(258); comment();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264); match(VARIABLE);
			setState(265); block_code();
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
		enterRule(_localctx, 50, RULE_assetSprite);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(SPRITE);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(268); comment();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274); match(VARIABLE);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(275); comment();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(281); match(BLOCK_START);
			}
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(286);
					switch (_input.LA(1)) {
					case VARIABLE:
					case GAME_VARIABLE:
						{
						{
						setState(282); assignment();
						setState(283); match(END_STATEMENT);
						}
						}
						break;
					case COMMENT:
						{
						setState(285); comment();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(298);
			switch (_input.LA(1)) {
			case BLOCK_END:
				{
				setState(291); match(BLOCK_END);
				}
				break;
			case EOF:
			case DECLARATION:
			case COMMENT:
				{
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(292); comment();
						}
						} 
					}
					setState(297);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 52, RULE_assetItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300); match(ITEM);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(301); comment();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(307); match(VARIABLE);
			setState(308); block_code();
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
		enterRule(_localctx, 54, RULE_assetFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); match(FUNCTION);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(311); comment();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317); match(VARIABLE);
			setState(318); block_code();
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
		enterRule(_localctx, 56, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(COMMENT);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3 \u0145\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\6\2>\n\2\r\2\16"+
		"\2?\3\3\3\3\3\3\5\3E\n\3\3\4\3\4\5\4I\n\4\3\5\7\5L\n\5\f\5\16\5O\13\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\5\3\5\7\5^\n\5\f\5"+
		"\16\5a\13\5\3\6\3\6\3\6\3\6\5\6g\n\6\3\7\3\7\3\7\5\7l\n\7\3\7\3\7\3\7"+
		"\3\7\5\7r\n\7\3\7\3\7\7\7v\n\7\f\7\16\7y\13\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\7\b\u0082\n\b\f\b\16\b\u0085\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u008e\n\t\f\t\16\t\u0091\13\t\3\t\3\t\3\t\5\t\u0096\n\t\6\t\u0098\n\t"+
		"\r\t\16\t\u0099\3\n\3\n\3\n\5\n\u009f\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\5\f\u00a8\n\f\3\r\3\r\3\r\7\r\u00ad\n\r\f\r\16\r\u00b0\13\r\3\16\3"+
		"\16\3\16\7\16\u00b5\n\16\f\16\16\16\u00b8\13\16\3\17\3\17\3\17\3\17\3"+
		"\17\5\17\u00bf\n\17\3\20\3\20\5\20\u00c3\n\20\3\20\3\20\3\20\5\20\u00c8"+
		"\n\20\7\20\u00ca\n\20\f\20\16\20\u00cd\13\20\3\21\3\21\3\22\3\22\3\22"+
		"\5\22\u00d4\n\22\3\22\3\22\3\22\3\22\5\22\u00da\n\22\3\23\3\23\3\23\7"+
		"\23\u00df\n\23\f\23\16\23\u00e2\13\23\3\23\3\23\3\24\3\24\5\24\u00e8\n"+
		"\24\3\24\3\24\3\24\3\24\5\24\u00ee\n\24\5\24\u00f0\n\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\5\26\u00f8\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\5\31\u0102\n\31\3\32\3\32\7\32\u0106\n\32\f\32\16\32\u0109\13\32\3\32"+
		"\3\32\3\32\3\33\3\33\7\33\u0110\n\33\f\33\16\33\u0113\13\33\3\33\3\33"+
		"\7\33\u0117\n\33\f\33\16\33\u011a\13\33\3\33\3\33\3\33\3\33\3\33\7\33"+
		"\u0121\n\33\f\33\16\33\u0124\13\33\3\33\3\33\7\33\u0128\n\33\f\33\16\33"+
		"\u012b\13\33\5\33\u012d\n\33\3\34\3\34\7\34\u0131\n\34\f\34\16\34\u0134"+
		"\13\34\3\34\3\34\3\34\3\35\3\35\7\35\u013b\n\35\f\35\16\35\u013e\13\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:\2\5\3\2\22\23\4\2\33\33\36\36\4\2\17\17\34"+
		"\35\u0159\2=\3\2\2\2\4D\3\2\2\2\6H\3\2\2\2\bM\3\2\2\2\nf\3\2\2\2\fh\3"+
		"\2\2\2\16|\3\2\2\2\20\u0097\3\2\2\2\22\u009e\3\2\2\2\24\u00a0\3\2\2\2"+
		"\26\u00a3\3\2\2\2\30\u00a9\3\2\2\2\32\u00b1\3\2\2\2\34\u00be\3\2\2\2\36"+
		"\u00c2\3\2\2\2 \u00ce\3\2\2\2\"\u00d3\3\2\2\2$\u00db\3\2\2\2&\u00ef\3"+
		"\2\2\2(\u00f1\3\2\2\2*\u00f7\3\2\2\2,\u00f9\3\2\2\2.\u00fb\3\2\2\2\60"+
		"\u0101\3\2\2\2\62\u0103\3\2\2\2\64\u010d\3\2\2\2\66\u012e\3\2\2\28\u0138"+
		"\3\2\2\2:\u0142\3\2\2\2<>\5\4\3\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2"+
		"\2\2@\3\3\2\2\2AB\7\t\2\2BE\5\60\31\2CE\5:\36\2DA\3\2\2\2DC\3\2\2\2E\5"+
		"\3\2\2\2FI\5\n\6\2GI\5\b\5\2HF\3\2\2\2HG\3\2\2\2I\7\3\2\2\2JL\5:\36\2"+
		"KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PX\7\24\2"+
		"\2QW\5\n\6\2RW\5:\36\2ST\7\t\2\2TW\58\35\2UW\5\b\5\2VQ\3\2\2\2VR\3\2\2"+
		"\2VS\3\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2"+
		"\2[_\7\25\2\2\\^\5:\36\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\t\3"+
		"\2\2\2a_\3\2\2\2bg\5\20\t\2cg\5\f\7\2dg\5\16\b\2eg\5\24\13\2fb\3\2\2\2"+
		"fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\13\3\2\2\2hi\7\5\2\2ik\7\26\2\2jl\5\26"+
		"\f\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\30\2\2no\5\36\20\2oq\7\30\2\2p"+
		"r\5\22\n\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2sw\7\27\2\2tv\5:\36\2ut\3\2\2"+
		"\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\5\6\4\2{\r\3\2"+
		"\2\2|}\7\6\2\2}~\7\26\2\2~\177\5\36\20\2\177\u0083\7\27\2\2\u0080\u0082"+
		"\5:\36\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\5\6"+
		"\4\2\u0087\17\3\2\2\2\u0088\u0089\7\7\2\2\u0089\u008a\7\26\2\2\u008a\u008b"+
		"\5\36\20\2\u008b\u008f\7\27\2\2\u008c\u008e\5:\36\2\u008d\u008c\3\2\2"+
		"\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0095\5\6\4\2\u0093\u0094\7\b\2\2\u0094"+
		"\u0096\5\6\4\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\3\2"+
		"\2\2\u0097\u0088\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\21\3\2\2\2\u009b\u009f\5\26\f\2\u009c\u009f\5$\23"+
		"\2\u009d\u009f\5(\25\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d"+
		"\3\2\2\2\u009f\23\3\2\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\7\30\2\2\u00a2"+
		"\25\3\2\2\2\u00a3\u00a4\5,\27\2\u00a4\u00a7\7\20\2\2\u00a5\u00a8\5*\26"+
		"\2\u00a6\u00a8\5\30\r\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\27\3\2\2\2\u00a9\u00ae\5\32\16\2\u00aa\u00ab\7\32\2\2\u00ab\u00ad\5\32"+
		"\16\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\31\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b6\5\34\17"+
		"\2\u00b2\u00b3\7\31\2\2\u00b3\u00b5\5\34\17\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\33\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\26\2\2\u00ba\u00bb\5\30\r\2\u00bb"+
		"\u00bc\7\27\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bf\5*\26\2\u00be\u00b9\3"+
		"\2\2\2\u00be\u00bd\3\2\2\2\u00bf\35\3\2\2\2\u00c0\u00c3\5\"\22\2\u00c1"+
		"\u00c3\7\17\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00cb\3"+
		"\2\2\2\u00c4\u00c7\5 \21\2\u00c5\u00c8\5\"\22\2\u00c6\u00c8\7\17\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c4\3\2"+
		"\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\37\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\t\2\2\2\u00cf!\3\2\2\2\u00d0"+
		"\u00d4\5,\27\2\u00d1\u00d4\5.\30\2\u00d2\u00d4\5$\23\2\u00d3\u00d0\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d9\7\21\2\2\u00d6\u00da\5,\27\2\u00d7\u00da\5.\30\2\u00d8\u00da\5"+
		"$\23\2\u00d9\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"#\3\2\2\2\u00db\u00dc\7\33\2\2\u00dc\u00e0\7\26\2\2\u00dd\u00df\5&\24"+
		"\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\7\27\2\2"+
		"\u00e4%\3\2\2\2\u00e5\u00e8\5,\27\2\u00e6\u00e8\5.\30\2\u00e7\u00e5\3"+
		"\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\7\3\2\2\u00ea"+
		"\u00f0\3\2\2\2\u00eb\u00ee\5,\27\2\u00ec\u00ee\5.\30\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\'\3\2\2\2\u00f1\u00f2\7\16\2\2\u00f2\u00f3\7\33\2"+
		"\2\u00f3)\3\2\2\2\u00f4\u00f8\5,\27\2\u00f5\u00f8\5.\30\2\u00f6\u00f8"+
		"\5$\23\2\u00f7\u00f4\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"+\3\2\2\2\u00f9\u00fa\t\3\2\2\u00fa-\3\2\2\2\u00fb\u00fc\t\4\2\2\u00fc"+
		"/\3\2\2\2\u00fd\u0102\5\62\32\2\u00fe\u0102\5\64\33\2\u00ff\u0102\5\66"+
		"\34\2\u0100\u0102\58\35\2\u0101\u00fd\3\2\2\2\u0101\u00fe\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\61\3\2\2\2\u0103\u0107\7\n\2"+
		"\2\u0104\u0106\5:\36\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010b\7\33\2\2\u010b\u010c\5\b\5\2\u010c\63\3\2\2\2\u010d\u0111\7\f\2"+
		"\2\u010e\u0110\5:\36\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0118\7\33\2\2\u0115\u0117\5:\36\2\u0116\u0115\3\2\2\2\u0117\u011a\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011b\u0122\7\24\2\2\u011c\u011d\5\26\f\2\u011d\u011e\7"+
		"\30\2\2\u011e\u0121\3\2\2\2\u011f\u0121\5:\36\2\u0120\u011c\3\2\2\2\u0120"+
		"\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u012c\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u012d\7\25\2\2\u0126"+
		"\u0128\5:\36\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012c"+
		"\u0125\3\2\2\2\u012c\u0129\3\2\2\2\u012d\65\3\2\2\2\u012e\u0132\7\r\2"+
		"\2\u012f\u0131\5:\36\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135"+
		"\u0136\7\33\2\2\u0136\u0137\5\b\5\2\u0137\67\3\2\2\2\u0138\u013c\7\13"+
		"\2\2\u0139\u013b\5:\36\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013f\u0140\7\33\2\2\u0140\u0141\5\b\5\2\u01419\3\2\2\2\u0142\u0143"+
		"\7\37\2\2\u0143;\3\2\2\2*?DHMVX_fkqw\u0083\u008f\u0095\u0099\u009e\u00a7"+
		"\u00ae\u00b6\u00be\u00c2\u00c7\u00cb\u00d3\u00d9\u00e0\u00e7\u00ed\u00ef"+
		"\u00f7\u0101\u0107\u0111\u0118\u0120\u0122\u0129\u012c\u0132\u013c";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}