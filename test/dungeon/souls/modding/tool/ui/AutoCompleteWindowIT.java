/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import java.awt.AWTEvent;
import java.awt.Point;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Caret;
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
public class AutoCompleteWindowIT
{
    
    public AutoCompleteWindowIT()
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
     * Test of addAutoCompleteListener method, of class AutoCompleteWindow.
     */
    @Test
    public void testAddAutoCompleteListener()
    {
        System.out.println("addAutoCompleteListener");
        AutoCompleteListener listener = null;
        AutoCompleteWindow instance = null;
        boolean expResult = false;
        boolean result = instance.addAutoCompleteListener(listener);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAutoCompleteSuggestion method, of class AutoCompleteWindow.
     */
    @Test
    public void testAddAutoCompleteSuggestion()
    {
        System.out.println("addAutoCompleteSuggestion");
        AutoCompleteSuggestion component = null;
        AutoCompleteWindow instance = null;
        boolean expResult = false;
        boolean result = instance.addAutoCompleteSuggestion(component);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVisible method, of class AutoCompleteWindow.
     */
    @Test
    public void testIsVisible()
    {
        System.out.println("isVisible");
        AutoCompleteWindow instance = null;
        boolean expResult = false;
        boolean result = instance.isVisible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of build method, of class AutoCompleteWindow.
     */
    @Test
    public void testBuild()
    {
        System.out.println("build");
        AutoCompleteWindow instance = null;
        AutoCompleteWindow expResult = null;
        AutoCompleteWindow result = instance.build();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of show method, of class AutoCompleteWindow.
     */
    @Test
    public void testShow_boolean_Point()
    {
        System.out.println("show");
        boolean value = false;
        Point p = null;
        AutoCompleteWindow instance = null;
        instance.show(value, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of show method, of class AutoCompleteWindow.
     */
    @Test
    public void testShow_3args()
    {
        System.out.println("show");
        boolean value = false;
        Point p = null;
        Caret caret = null;
        AutoCompleteWindow instance = null;
        instance.show(value, p, caret);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dispatchEvent method, of class AutoCompleteWindow.
     */
    @Test
    public void testDispatchEvent()
    {
        System.out.println("dispatchEvent");
        AWTEvent e = null;
        AutoCompleteWindow instance = null;
        instance.dispatchEvent(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hide method, of class AutoCompleteWindow.
     */
    @Test
    public void testHide()
    {
        System.out.println("hide");
        AutoCompleteWindow instance = null;
        instance.hide();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertUpdate method, of class AutoCompleteWindow.
     */
    @Test
    public void testInsertUpdate()
    {
        System.out.println("insertUpdate");
        DocumentEvent e = null;
        AutoCompleteWindow instance = null;
        instance.insertUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUpdate method, of class AutoCompleteWindow.
     */
    @Test
    public void testRemoveUpdate()
    {
        System.out.println("removeUpdate");
        DocumentEvent e = null;
        AutoCompleteWindow instance = null;
        instance.removeUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changedUpdate method, of class AutoCompleteWindow.
     */
    @Test
    public void testChangedUpdate()
    {
        System.out.println("changedUpdate");
        DocumentEvent e = null;
        AutoCompleteWindow instance = null;
        instance.changedUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
