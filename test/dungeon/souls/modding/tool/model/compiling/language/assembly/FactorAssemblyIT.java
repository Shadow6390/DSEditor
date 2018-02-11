/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import java.util.List;
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
public class FactorAssemblyIT
{
    
    public FactorAssemblyIT()
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
     * Test of parseFactors method, of class FactorAssembly.
     */
    @Test
    public void testParseFactors()
    {
        System.out.println("parseFactors");
        BaseGrammarParser.Math_operationContext context = null;
        List<FactorAssembly> expResult = null;
        List<FactorAssembly> result = FactorAssembly.parseFactors(context);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMemoryRegistry method, of class FactorAssembly.
     */
    @Test
    public void testGetMemoryRegistry()
    {
        System.out.println("getMemoryRegistry");
        FactorAssembly instance = new FactorAssembly();
        String expResult = "";
        String result = instance.getMemoryRegistry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toAssembly method, of class FactorAssembly.
     */
    @Test
    public void testToAssembly()
    {
        System.out.println("toAssembly");
        FactorAssembly instance = new FactorAssembly();
        String expResult = "";
        String result = instance.toAssembly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
