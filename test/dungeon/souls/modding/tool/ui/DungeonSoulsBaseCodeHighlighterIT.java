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
public class DungeonSoulsBaseCodeHighlighterIT
{
    
    public DungeonSoulsBaseCodeHighlighterIT()
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
     * Test of clearErrors method, of class DungeonSoulsBaseCodeHighlighter.
     */
    @Test
    public void testClearErrors()
    {
        System.out.println("clearErrors");
        DungeonSoulsBaseCodeHighlighter instance = new DungeonSoulsBaseCodeHighlighter();
        instance.clearErrors();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signalError method, of class DungeonSoulsBaseCodeHighlighter.
     */
    @Test
    public void testSignalError()
    {
        System.out.println("signalError");
        StyledDocument document = null;
        CompilationErrorMessage message = null;
        DungeonSoulsBaseCodeHighlighter instance = new DungeonSoulsBaseCodeHighlighter();
        instance.signalError(document, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onTextChanged method, of class DungeonSoulsBaseCodeHighlighter.
     */
    @Test
    public void testOnTextChanged()
    {
        System.out.println("onTextChanged");
        StyledDocument document = null;
        String text = "";
        DungeonSoulsBaseCodeHighlighter instance = new DungeonSoulsBaseCodeHighlighter();
        instance.onTextChanged(document, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
