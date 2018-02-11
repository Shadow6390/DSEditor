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
public class AutoCompleteSuggestionIT
{
    
    public AutoCompleteSuggestionIT()
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
     * Test of getSuggestion method, of class AutoCompleteSuggestion.
     */
    @Test
    public void testGetSuggestion()
    {
        System.out.println("getSuggestion");
        AutoCompleteSuggestion instance = new AutoCompleteSuggestionImpl();
        String expResult = "";
        String result = instance.getSuggestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AutoCompleteSuggestionImpl implements AutoCompleteSuggestion
    {

        @Override
        public String getSuggestion()
        {
            return "";
        }

        @Override
        public int compareTo(AutoCompleteSuggestion o)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
