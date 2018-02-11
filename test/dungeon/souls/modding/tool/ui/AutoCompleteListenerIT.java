/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

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
public class AutoCompleteListenerIT
{
    
    public AutoCompleteListenerIT()
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
     * Test of autoCompleteSuggested method, of class AutoCompleteListener.
     */
    @Test
    public void testAutoCompleteSuggested()
    {
        System.out.println("autoCompleteSuggested");
        AutoCompleteEvent e = null;
        AutoCompleteListener instance = new AutoCompleteListenerImpl();
        instance.autoCompleteSuggested(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AutoCompleteListenerImpl implements AutoCompleteListener
    {

        public void autoCompleteSuggested(AutoCompleteEvent e)
        {
        }
    }
    
}
