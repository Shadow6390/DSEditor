/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

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
public class ContentNodeIT
{
    
    public ContentNodeIT()
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
     * Test of getElement method, of class ContentNode.
     */
    @Test
    public void testGetElement()
    {
        System.out.println("getElement");
        ContentNode instance = null;
        Object expResult = null;
        Object result = instance.getElement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrevious method, of class ContentNode.
     */
    @Test
    public void testGetPrevious()
    {
        System.out.println("getPrevious");
        ContentNode instance = null;
        ContentNode expResult = null;
        ContentNode result = instance.getPrevious();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrevious method, of class ContentNode.
     */
    @Test
    public void testSetPrevious()
    {
        System.out.println("setPrevious");
        ContentNode instance = null;
        instance.setPrevious(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNext method, of class ContentNode.
     */
    @Test
    public void testGetNext()
    {
        System.out.println("getNext");
        ContentNode instance = null;
        ContentNode expResult = null;
        ContentNode result = instance.getNext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNext method, of class ContentNode.
     */
    @Test
    public void testSetNext()
    {
        System.out.println("setNext");
        ContentNode instance = null;
        instance.setNext(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ContentNode.
     */
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Object other = null;
        ContentNode instance = null;
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ContentNode.
     */
    @Test
    public void testHashCode()
    {
        System.out.println("hashCode");
        ContentNode instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
