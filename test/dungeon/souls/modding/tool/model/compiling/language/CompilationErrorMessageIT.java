/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import java.util.List;
import org.antlr.v4.runtime.misc.Interval;
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
public class CompilationErrorMessageIT
{
    
    public CompilationErrorMessageIT()
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
     * Test of getSuggestionList method, of class CompilationErrorMessage.
     */
    @Test
    public void testGetSuggestionList()
    {
        System.out.println("getSuggestionList");
        CompilationErrorMessage instance = null;
        List<String> expResult = null;
        List<String> result = instance.getSuggestionList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuggestions method, of class CompilationErrorMessage.
     */
    @Test
    public void testGetSuggestions()
    {
        System.out.println("getSuggestions");
        CompilationErrorMessage instance = null;
        String[] expResult = null;
        String[] result = instance.getSuggestions();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterval method, of class CompilationErrorMessage.
     */
    @Test
    public void testGetInterval()
    {
        System.out.println("getInterval");
        CompilationErrorMessage instance = null;
        Interval expResult = null;
        Interval result = instance.getInterval();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CompilationErrorMessage.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        CompilationErrorMessage instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
