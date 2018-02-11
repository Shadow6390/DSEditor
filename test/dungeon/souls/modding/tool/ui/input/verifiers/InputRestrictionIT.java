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
public class InputRestrictionIT
{
    
    public InputRestrictionIT()
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
     * Test of isValid method, of class InputRestriction.
     */
    @Test
    public void testIsValid()
    {
        System.out.println("isValid");
        String data = "";
        InputRestriction instance = new InputRestrictionImpl();
        boolean expResult = false;
        boolean result = instance.isValid(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReason method, of class InputRestriction.
     */
    @Test
    public void testGetReason()
    {
        System.out.println("getReason");
        InputRestriction instance = new InputRestrictionImpl();
        String expResult = "";
        String result = instance.getReason();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class InputRestrictionImpl implements InputRestriction
    {

        public boolean isValid(String data)
        {
            return false;
        }

        public String getReason()
        {
            return "";
        }
    }
    
}
