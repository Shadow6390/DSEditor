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
public class AutoCompleteEventIT
{
    
    public AutoCompleteEventIT()
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
     * Test of getSuggestion method, of class AutoCompleteEvent.
     */
    @Test
    public void testGetSuggestion()
    {
        System.out.println("getSuggestion");
        AutoCompleteEvent instance = null;
        AutoCompleteSuggestion expResult = null;
        AutoCompleteSuggestion result = instance.getSuggestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuggestionStart method, of class AutoCompleteEvent.
     */
    @Test
    public void testGetSuggestionStart()
    {
        System.out.println("getSuggestionStart");
        AutoCompleteEvent instance = null;
        int expResult = 0;
        int result = instance.getSuggestionStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
