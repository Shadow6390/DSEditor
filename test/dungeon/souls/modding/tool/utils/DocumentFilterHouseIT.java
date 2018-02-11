/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;
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
public class DocumentFilterHouseIT
{
    
    public DocumentFilterHouseIT()
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
     * Test of addDocumentFilter method, of class DocumentFilterHouse.
     */
    @Test
    public void testAddDocumentFilter()
    {
        System.out.println("addDocumentFilter");
        DocumentFilter filter = null;
        DocumentFilterHouse instance = new DocumentFilterHouse();
        boolean expResult = false;
        boolean result = instance.addDocumentFilter(filter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertString method, of class DocumentFilterHouse.
     */
    @Test
    public void testInsertString() throws Exception
    {
        System.out.println("insertString");
        DocumentFilter.FilterBypass fb = null;
        int offset = 0;
        String text = "";
        AttributeSet attributeSet = null;
        DocumentFilterHouse instance = new DocumentFilterHouse();
        instance.insertString(fb, offset, text, attributeSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class DocumentFilterHouse.
     */
    @Test
    public void testRemove() throws Exception
    {
        System.out.println("remove");
        DocumentFilter.FilterBypass fb = null;
        int offset = 0;
        int length = 0;
        DocumentFilterHouse instance = new DocumentFilterHouse();
        instance.remove(fb, offset, length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class DocumentFilterHouse.
     */
    @Test
    public void testReplace() throws Exception
    {
        System.out.println("replace");
        DocumentFilter.FilterBypass fb = null;
        int offset = 0;
        int length = 0;
        String text = "";
        AttributeSet attributeSet = null;
        DocumentFilterHouse instance = new DocumentFilterHouse();
        instance.replace(fb, offset, length, text, attributeSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
