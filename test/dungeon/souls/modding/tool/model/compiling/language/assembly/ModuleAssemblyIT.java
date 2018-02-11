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
public class ModuleAssemblyIT
{
    
    public ModuleAssemblyIT()
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
     * Test of parseFrom method, of class ModuleAssembly.
     */
    @Test
    public void testParseFrom()
    {
        System.out.println("parseFrom");
        BaseGrammarParser.AssetModuleContext ctx = null;
        ModuleAssembly expResult = null;
        ModuleAssembly result = ModuleAssembly.parseFrom(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class ModuleAssembly.
     */
    @Test
    public void testValidate()
    {
        System.out.println("validate");
        ModuleAssembly instance = null;
        List<String> expResult = null;
        List<String> result = instance.validate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toAssembly method, of class ModuleAssembly.
     */
    @Test
    public void testToAssembly()
    {
        System.out.println("toAssembly");
        ModuleAssembly instance = null;
        String expResult = "";
        String result = instance.toAssembly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
