/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import java.util.BitSet;
import java.util.List;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diogo
 */
public class BaseGrammarErrorListenerIT
{
    
    public BaseGrammarErrorListenerIT()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of clearMessages method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testClearMessages()
    {
        System.out.println("clearMessages");
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        instance.clearMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageList method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testGetMessageList()
    {
        System.out.println("getMessageList");
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        List<CompilationErrorMessage> expResult = null;
        List<CompilationErrorMessage> result = instance.getMessageList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testGetMessage()
    {
        System.out.println("getMessage");
        int i = 0;
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        CompilationErrorMessage expResult = null;
        CompilationErrorMessage result = instance.getMessage(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testSize()
    {
        System.out.println("size");
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of syntaxError method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testSyntaxError()
    {
        System.out.println("syntaxError");
        Recognizer rcgnzr = null;
        Object o = null;
        int line = 0;
        int column = 0;
        String string = "";
        RecognitionException re = null;
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        instance.syntaxError(rcgnzr, o, line, column, string, re);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reportAmbiguity method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testReportAmbiguity()
    {
        System.out.println("reportAmbiguity");
        Parser parser = null;
        DFA dfa = null;
        int i = 0;
        int i1 = 0;
        boolean bln = false;
        BitSet bitset = null;
        ATNConfigSet atncs = null;
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        instance.reportAmbiguity(parser, dfa, i, i1, bln, bitset, atncs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reportAttemptingFullContext method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testReportAttemptingFullContext()
    {
        System.out.println("reportAttemptingFullContext");
        Parser parser = null;
        DFA dfa = null;
        int i = 0;
        int i1 = 0;
        BitSet bitset = null;
        ATNConfigSet atncs = null;
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        instance.reportAttemptingFullContext(parser, dfa, i, i1, bitset, atncs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reportContextSensitivity method, of class BaseGrammarErrorListener.
     */
    @Test
    public void testReportContextSensitivity()
    {
        System.out.println("reportContextSensitivity");
        Parser parser = null;
        DFA dfa = null;
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        ATNConfigSet atncs = null;
        BaseGrammarErrorListener instance = new BaseGrammarErrorListener();
        instance.reportContextSensitivity(parser, dfa, i, i1, i2, atncs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
