/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui.input.verifiers;

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
public class IntegerRestrictionIT
{
    
    public IntegerRestrictionIT()
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
     * Test of isValid method, of class IntegerRestriction.
     */
    @Test
    public void testIsValid()
    {
        System.out.println("isValid");
        String data = "";
        IntegerRestriction instance = new IntegerRestriction();
        boolean expResult = false;
        boolean result = instance.isValid(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReason method, of class IntegerRestriction.
     */
    @Test
    public void testGetReason()
    {
        System.out.println("getReason");
        IntegerRestriction instance = new IntegerRestriction();
        String expResult = "";
        String result = instance.getReason();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
