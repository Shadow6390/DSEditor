/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.model.compiling.language.CompilationErrorMessage;
import javax.swing.text.StyledDocument;
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
public class CodeSyntaxHighlighterIT
{
    
    public CodeSyntaxHighlighterIT()
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
     * Test of onTextChanged method, of class CodeSyntaxHighlighter.
     */
    @Test
    public void testOnTextChanged()
    {
        System.out.println("onTextChanged");
        StyledDocument document = null;
        String text = "";
        CodeSyntaxHighlighter instance = new CodeSyntaxHighlighterImpl();
        instance.onTextChanged(document, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signalError method, of class CodeSyntaxHighlighter.
     */
    @Test
    public void testSignalError()
    {
        System.out.println("signalError");
        StyledDocument document = null;
        CompilationErrorMessage message = null;
        CodeSyntaxHighlighter instance = new CodeSyntaxHighlighterImpl();
        instance.signalError(document, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearErrors method, of class CodeSyntaxHighlighter.
     */
    @Test
    public void testClearErrors()
    {
        System.out.println("clearErrors");
        CodeSyntaxHighlighter instance = new CodeSyntaxHighlighterImpl();
        instance.clearErrors();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CodeSyntaxHighlighterImpl implements CodeSyntaxHighlighter
    {

        public void onTextChanged(StyledDocument document, String text)
        {
        }

        public void signalError(StyledDocument document, CompilationErrorMessage message)
        {
        }

        public void clearErrors()
        {
        }
    }
    
}
