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
public class IfAssemblyIT
{
    
    public IfAssemblyIT()
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
     * Test of setIfCode method, of class IfAssembly.
     */
    @Test
    public void testSetIfCode()
    {
        System.out.println("setIfCode");
        CodeBlockAssembly ifCode = null;
        IfAssembly instance = new IfAssembly();
        instance.setIfCode(ifCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElseCode method, of class IfAssembly.
     */
    @Test
    public void testSetElseCode()
    {
        System.out.println("setElseCode");
        CodeBlockAssembly elseCode = null;
        IfAssembly instance = new IfAssembly();
        instance.setElseCode(elseCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of toAssembly method, of class IfAssembly.
     */
    @Test
    public void testToAssembly()
    {
        System.out.println("toAssembly");
        IfAssembly instance = new IfAssembly();
        String expResult = "";
        String result = instance.toAssembly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
