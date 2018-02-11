// Generated from C:\Users\Diogo\Documents\antlrworks2\Workspace\BaseGrammar.g4 by ANTLR 4.1
package dungeon.souls.modding.tool.model.compiling.language;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BaseGrammarLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "'foreach'", "'for'", "'while'", "'if'", "'else'", "'define'", 
		"'module'", "'function'", "'sprite'", "'item'", "FUNCTION_ARGUMENT", "BOOLEAN", 
		"'='", "OPERATOR", "AND_OPERATOR", "OR_OPERATOR", "'{'", "'}'", "'('", 
		"')'", "';'", "MATH_OPERATOR_MULT_DIV", "MATH_OPERATOR_PLUS_MINUS", "VARIABLE", 
		"STRING", "REAL", "GAME_VARIABLE", "COMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"T__0", "FOREACH", "FOR", "WHILE", "IF", "ELSE", "DECLARATION", "MODULE", 
		"FUNCTION", "SPRITE", "ITEM", "FUNCTION_ARGUMENT", "BOOLEAN", "ASSIGN", 
		"OPERATOR", "AND_OPERATOR", "OR_OPERATOR", "BLOCK_START", "BLOCK_END", 
		"OBRACKETS", "CBRACKETS", "END_STATEMENT", "MATH_OPERATOR_MULT_DIV", "MATH_OPERATOR_PLUS_MINUS", 
		"VARIABLE", "STRING", "REAL", "ID", "LETTER", "NUMBER", "GAME_VARIABLE", 
		"COMMENT", "WHITESPACE"
	};


	public BaseGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BaseGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2 \u010f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a0\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00ab\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00b8\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u00bf"+
		"\n\21\3\22\3\22\3\22\3\22\5\22\u00c5\n\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\7\33\u00d9"+
		"\n\33\f\33\16\33\u00dc\13\33\3\33\3\33\3\34\6\34\u00e1\n\34\r\34\16\34"+
		"\u00e2\3\34\3\34\6\34\u00e7\n\34\r\34\16\34\u00e8\5\34\u00eb\n\34\3\35"+
		"\3\35\5\35\u00ef\n\35\3\35\3\35\3\35\7\35\u00f4\n\35\f\35\16\35\u00f7"+
		"\13\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\6!\u0105\n!\r!\16!"+
		"\u0106\3\"\6\"\u010a\n\"\r\"\16\"\u010b\3\"\3\"\2#\3\3\1\5\4\1\7\5\1\t"+
		"\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1"+
		"\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32"+
		"\1\63\33\1\65\34\1\67\35\19\2\1;\2\1=\2\1?\36\1A\37\1C \2\3\2\n\4\2>>"+
		"@@\4\2,,\61\61\4\2--//\3\2$$\4\2C\\c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\17"+
		"\17\"\"\u011d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7O\3\2\2\2\tS\3\2\2"+
		"\2\13Y\3\2\2\2\r\\\3\2\2\2\17a\3\2\2\2\21h\3\2\2\2\23o\3\2\2\2\25x\3\2"+
		"\2\2\27\177\3\2\2\2\31\u009f\3\2\2\2\33\u00aa\3\2\2\2\35\u00ac\3\2\2\2"+
		"\37\u00b7\3\2\2\2!\u00be\3\2\2\2#\u00c4\3\2\2\2%\u00c6\3\2\2\2\'\u00c8"+
		"\3\2\2\2)\u00ca\3\2\2\2+\u00cc\3\2\2\2-\u00ce\3\2\2\2/\u00d0\3\2\2\2\61"+
		"\u00d2\3\2\2\2\63\u00d4\3\2\2\2\65\u00d6\3\2\2\2\67\u00e0\3\2\2\29\u00ee"+
		"\3\2\2\2;\u00f8\3\2\2\2=\u00fa\3\2\2\2?\u00fc\3\2\2\2A\u0100\3\2\2\2C"+
		"\u0109\3\2\2\2EF\7.\2\2F\4\3\2\2\2GH\7h\2\2HI\7q\2\2IJ\7t\2\2JK\7g\2\2"+
		"KL\7c\2\2LM\7e\2\2MN\7j\2\2N\6\3\2\2\2OP\7h\2\2PQ\7q\2\2QR\7t\2\2R\b\3"+
		"\2\2\2ST\7y\2\2TU\7j\2\2UV\7k\2\2VW\7n\2\2WX\7g\2\2X\n\3\2\2\2YZ\7k\2"+
		"\2Z[\7h\2\2[\f\3\2\2\2\\]\7g\2\2]^\7n\2\2^_\7u\2\2_`\7g\2\2`\16\3\2\2"+
		"\2ab\7f\2\2bc\7g\2\2cd\7h\2\2de\7k\2\2ef\7p\2\2fg\7g\2\2g\20\3\2\2\2h"+
		"i\7o\2\2ij\7q\2\2jk\7f\2\2kl\7w\2\2lm\7n\2\2mn\7g\2\2n\22\3\2\2\2op\7"+
		"h\2\2pq\7w\2\2qr\7p\2\2rs\7e\2\2st\7v\2\2tu\7k\2\2uv\7q\2\2vw\7p\2\2w"+
		"\24\3\2\2\2xy\7u\2\2yz\7r\2\2z{\7t\2\2{|\7k\2\2|}\7v\2\2}~\7g\2\2~\26"+
		"\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7v\2\2\u0081\u0082\7g\2\2\u0082"+
		"\u0083\7o\2\2\u0083\30\3\2\2\2\u0084\u0085\7h\2\2\u0085\u0086\7w\2\2\u0086"+
		"\u0087\7p\2\2\u0087\u0088\7e\2\2\u0088\u0089\7v\2\2\u0089\u008a\7k\2\2"+
		"\u008a\u008b\7q\2\2\u008b\u008c\7p\2\2\u008c\u008d\7K\2\2\u008d\u008e"+
		"\7p\2\2\u008e\u008f\7r\2\2\u008f\u0090\7w\2\2\u0090\u00a0\7v\2\2\u0091"+
		"\u0092\7h\2\2\u0092\u0093\7w\2\2\u0093\u0094\7p\2\2\u0094\u0095\7e\2\2"+
		"\u0095\u0096\7v\2\2\u0096\u0097\7k\2\2\u0097\u0098\7q\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009a\7Q\2\2\u009a\u009b\7w\2\2\u009b\u009c\7v\2\2\u009c"+
		"\u009d\7r\2\2\u009d\u009e\7w\2\2\u009e\u00a0\7v\2\2\u009f\u0084\3\2\2"+
		"\2\u009f\u0091\3\2\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3"+
		"\7t\2\2\u00a3\u00a4\7w\2\2\u00a4\u00ab\7g\2\2\u00a5\u00a6\7h\2\2\u00a6"+
		"\u00a7\7c\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00ab\7g\2\2"+
		"\u00aa\u00a1\3\2\2\2\u00aa\u00a5\3\2\2\2\u00ab\34\3\2\2\2\u00ac\u00ad"+
		"\7?\2\2\u00ad\36\3\2\2\2\u00ae\u00af\7?\2\2\u00af\u00b8\7?\2\2\u00b0\u00b8"+
		"\t\2\2\2\u00b1\u00b2\7@\2\2\u00b2\u00b8\7?\2\2\u00b3\u00b4\7>\2\2\u00b4"+
		"\u00b8\7?\2\2\u00b5\u00b6\7#\2\2\u00b6\u00b8\7?\2\2\u00b7\u00ae\3\2\2"+
		"\2\u00b7\u00b0\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8 \3\2\2\2\u00b9\u00ba\7(\2\2\u00ba\u00bf\7(\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7p\2\2\u00bd\u00bf\7f\2\2\u00be\u00b9\3\2\2\2\u00be"+
		"\u00bb\3\2\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7~\2\2\u00c1\u00c5\7~\2\2\u00c2"+
		"\u00c3\7q\2\2\u00c3\u00c5\7t\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c2\3\2\2"+
		"\2\u00c5$\3\2\2\2\u00c6\u00c7\7}\2\2\u00c7&\3\2\2\2\u00c8\u00c9\7\177"+
		"\2\2\u00c9(\3\2\2\2\u00ca\u00cb\7*\2\2\u00cb*\3\2\2\2\u00cc\u00cd\7+\2"+
		"\2\u00cd,\3\2\2\2\u00ce\u00cf\7=\2\2\u00cf.\3\2\2\2\u00d0\u00d1\t\3\2"+
		"\2\u00d1\60\3\2\2\2\u00d2\u00d3\t\4\2\2\u00d3\62\3\2\2\2\u00d4\u00d5\5"+
		"9\35\2\u00d5\64\3\2\2\2\u00d6\u00da\7$\2\2\u00d7\u00d9\n\5\2\2\u00d8\u00d7"+
		"\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7$\2\2\u00de\66\3\2\2\2"+
		"\u00df\u00e1\5=\37\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00ea\3\2\2\2\u00e4\u00e6\7\60\2\2"+
		"\u00e5\u00e7\5=\37\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e4\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb8\3\2\2\2\u00ec\u00ef\5;\36\2\u00ed\u00ef\7a\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f5\3\2\2\2\u00f0\u00f4\5;"+
		"\36\2\u00f1\u00f4\5=\37\2\u00f2\u00f4\7a\2\2\u00f3\u00f0\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6:\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9"+
		"\t\6\2\2\u00f9<\3\2\2\2\u00fa\u00fb\t\7\2\2\u00fb>\3\2\2\2\u00fc\u00fd"+
		"\7]\2\2\u00fd\u00fe\59\35\2\u00fe\u00ff\7_\2\2\u00ff@\3\2\2\2\u0100\u0101"+
		"\7\61\2\2\u0101\u0102\7\61\2\2\u0102\u0104\3\2\2\2\u0103\u0105\n\b\2\2"+
		"\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107B\3\2\2\2\u0108\u010a\t\t\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u010e\b\"\2\2\u010eD\3\2\2\2\21\2\u009f\u00aa\u00b7\u00be\u00c4"+
		"\u00da\u00e2\u00e8\u00ea\u00ee\u00f3\u00f5\u0106\u010b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}