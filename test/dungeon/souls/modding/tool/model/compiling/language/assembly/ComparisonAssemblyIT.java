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
public class ComparisonAssemblyIT
{
    
    public ComparisonAssemblyIT()
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
     * Test of parseFrom method, of class ComparisonAssembly.
     */
    @Test
    public void testParseFrom()
    {
        System.out.println("parseFrom");
        BaseGrammarParser.ComparisonContext context = null;
        ComparisonAssembly expResult = null;
        ComparisonAssembly result = ComparisonAssembly.parseFrom(context);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComparisonResultRegistry method, of class ComparisonAssembly.
     */
    @Test
    public void testGetComparisonResultRegistry()
    {
        System.out.println("getComparisonResultRegistry");
        ComparisonAssembly instance = null;
        String expResult = "";
        String result = instance.getComparisonResultRegistry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toAssembly method, of class ComparisonAssembly.
     */
    @Test
    public void testToAssembly()
    {
        System.out.println("toAssembly");
        ComparisonAssembly instance = null;
        String expResult = "";
        String result = instance.toAssembly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
