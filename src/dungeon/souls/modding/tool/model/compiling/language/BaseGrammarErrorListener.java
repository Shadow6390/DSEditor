/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;

/**
 * ErrorListener for the built grammar of "BaseGrammar.g4".
 * Provides all the exceptions found whilst compiling the grammar into
 * a list of errors that is "easilly" parsed and understood by the user.
 * @author Diogo
 */
public class BaseGrammarErrorListener implements ANTLRErrorListener
{
    /**
     * The errors obtained during compilation.
     */
    private List<CompilationErrorMessage> messages;
    
    public BaseGrammarErrorListener()
    {
        super();
        messages = new ArrayList();
    }
    
    /**
     * Clears the messages of this listener.
     */
    public void clearMessages()
    {
        messages.clear();
    }
    
    /**
     * Returns the specified message.
     * @param i (int) The location of the message in the list.
     * @return 
     */
    public CompilationErrorMessage getMessage(int i)
    {
        return messages.get(i);
    }
    
    /**
     * The amount of messages found.
     * @return 
     */
    public int size()
    {
        return messages.size();
    }
    
    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int line, int column, String string, RecognitionException re)
    {
        Token token = Token.class.cast(o);
        if (re!=null)
        {
            IntervalSet set = re.getExpectedTokens();
            String[] suggestions = new String[set.size()];
            int index;
            for (int i=0;i<suggestions.length;i++)
            {
                index = set.get(i);
                if (index>0)
                {
                    suggestions[i]=BaseGrammarLexer.tokenNames[index];
                }
            }
            messages.add(new CompilationErrorMessage(string, Interval.INVALID, suggestions,line,column));
        }
        else
        {
            messages.add(new CompilationErrorMessage(string, new Interval(token.getStartIndex(),token.getStopIndex()), null,line,column));
        }
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs)
    {
        //ignore.
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs)
    {
        //ignore
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs)
    {
        //ignore
    }
}
