/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
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
public class PrioritizedMathOperationAssemblyIT
{
    
    public PrioritizedMathOperationAssemblyIT()
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
     * Test of parsePrioritizedMathOperations method, of class PrioritizedMathOperationAssembly.
     */
    @Test
    public void testParsePrioritizedMathOperations()
    {
        System.out.println("parsePrioritizedMathOperations");
        BaseGrammarParser.TermContext context = null;
        PrioritizedMathOperationAssembly expResult = null;
        PrioritizedMathOperationAssembly result = PrioritizedMathOperationAssembly.parsePrioritizedMathOperations(context);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemoryRegistry method, of class PrioritizedMathOperationAssembly.
     */
    @Test
    public void testGetMemoryRegistry()
    {
        System.out.println("getMemoryRegistry");
        PrioritizedMathOperationAssembly instance = new PrioritizedMathOperationAssembly();
        String expResult = "";
        String result = instance.getMemoryRegistry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toAssembly method, of class PrioritizedMathOperationAssembly.
     */
    @Test
    public void testToAssembly()
    {
        System.out.println("toAssembly");
        PrioritizedMathOperationAssembly instance = new PrioritizedMathOperationAssembly();
        String expResult = "";
        String result = instance.toAssembly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
