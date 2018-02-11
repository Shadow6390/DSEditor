/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui.input.verifiers;

import javax.swing.JComponent;
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
public class CombinedInputVerifierIT
{
    
    public CombinedInputVerifierIT()
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
     * Test of addRestriction method, of class CombinedInputVerifier.
     */
    @Test
    public void testAddRestriction()
    {
        System.out.println("addRestriction");
        InputRestriction restriction = null;
        CombinedInputVerifier instance = new CombinedInputVerifier();
        boolean expResult = false;
        boolean result = instance.addRestriction(restriction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verify method, of class CombinedInputVerifier.
     */
    @Test
    public void testVerify()
    {
        System.out.println("verify");
        JComponent input = null;
        CombinedInputVerifier instance = new CombinedInputVerifier();
        boolean expResult = false;
        boolean result = instance.verify(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
