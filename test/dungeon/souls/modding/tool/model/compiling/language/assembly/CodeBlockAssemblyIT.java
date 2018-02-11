/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

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
public class CodeBlockAssemblyIT
{
    
    public CodeBlockAssemblyIT()
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
     * Test of resetCodeBlockCount method, of class CodeBlockAssembly.
     */
    @Test
    public void testResetCodeBlockCount()
    {
        System.out.println("resetCodeBlockCount");
        CodeBlockAssembly.resetCodeBlockCount();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAssemblyCode method, of class CodeBlockAssembly.
     */
    @Test
    public void testAddAssemblyCode()
    {
        System.out.println("addAssemblyCode");
        AssemblyCode codeLine = null;
        CodeBlockAssembly instance = new CodeBlockAssembly();
        boolean expResult = false;
        boolean result = instance.addAssemblyCode(codeLine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toAssembly method, of class CodeBlockAssembly.
     */
    @Test
    public void testToAssembly()
    {
        System.out.println("toAssembly");
        CodeBlockAssembly instance = new CodeBlockAssembly();
        String expResult = "";
        String result = instance.toAssembly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CodeBlockAssembly.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        CodeBlockAssembly instance = new CodeBlockAssembly();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
