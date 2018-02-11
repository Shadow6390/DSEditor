/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import javax.swing.event.CaretEvent;
import javax.swing.event.DocumentEvent;
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
public class TextLineNumberIT
{
    
    public TextLineNumberIT()
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
     * Test of getUpdateFont method, of class TextLineNumber.
     */
    @Test
    public void testGetUpdateFont()
    {
        System.out.println("getUpdateFont");
        TextLineNumber instance = null;
        boolean expResult = false;
        boolean result = instance.getUpdateFont();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUpdateFont method, of class TextLineNumber.
     */
    @Test
    public void testSetUpdateFont()
    {
        System.out.println("setUpdateFont");
        boolean updateFont = false;
        TextLineNumber instance = null;
        instance.setUpdateFont(updateFont);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBorderGap method, of class TextLineNumber.
     */
    @Test
    public void testGetBorderGap()
    {
        System.out.println("getBorderGap");
        TextLineNumber instance = null;
        int expResult = 0;
        int result = instance.getBorderGap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBorderGap method, of class TextLineNumber.
     */
    @Test
    public void testSetBorderGap()
    {
        System.out.println("setBorderGap");
        int borderGap = 0;
        TextLineNumber instance = null;
        instance.setBorderGap(borderGap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentLineForeground method, of class TextLineNumber.
     */
    @Test
    public void testGetCurrentLineForeground()
    {
        System.out.println("getCurrentLineForeground");
        TextLineNumber instance = null;
        Color expResult = null;
        Color result = instance.getCurrentLineForeground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentLineForeground method, of class TextLineNumber.
     */
    @Test
    public void testSetCurrentLineForeground()
    {
        System.out.println("setCurrentLineForeground");
        Color currentLineForeground = null;
        TextLineNumber instance = null;
        instance.setCurrentLineForeground(currentLineForeground);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDigitAlignment method, of class TextLineNumber.
     */
    @Test
    public void testGetDigitAlignment()
    {
        System.out.println("getDigitAlignment");
        TextLineNumber instance = null;
        float expResult = 0.0F;
        float result = instance.getDigitAlignment();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDigitAlignment method, of class TextLineNumber.
     */
    @Test
    public void testSetDigitAlignment()
    {
        System.out.println("setDigitAlignment");
        float digitAlignment = 0.0F;
        TextLineNumber instance = null;
        instance.setDigitAlignment(digitAlignment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinimumDisplayDigits method, of class TextLineNumber.
     */
    @Test
    public void testGetMinimumDisplayDigits()
    {
        System.out.println("getMinimumDisplayDigits");
        TextLineNumber instance = null;
        int expResult = 0;
        int result = instance.getMinimumDisplayDigits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMinimumDisplayDigits method, of class TextLineNumber.
     */
    @Test
    public void testSetMinimumDisplayDigits()
    {
        System.out.println("setMinimumDisplayDigits");
        int minimumDisplayDigits = 0;
        TextLineNumber instance = null;
        instance.setMinimumDisplayDigits(minimumDisplayDigits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class TextLineNumber.
     */
    @Test
    public void testPaintComponent()
    {
        System.out.println("paintComponent");
        Graphics g = null;
        TextLineNumber instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTextLineNumber method, of class TextLineNumber.
     */
    @Test
    public void testGetTextLineNumber()
    {
        System.out.println("getTextLineNumber");
        int rowStartOffset = 0;
        TextLineNumber instance = null;
        String expResult = "";
        String result = instance.getTextLineNumber(rowStartOffset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caretUpdate method, of class TextLineNumber.
     */
    @Test
    public void testCaretUpdate()
    {
        System.out.println("caretUpdate");
        CaretEvent e = null;
        TextLineNumber instance = null;
        instance.caretUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changedUpdate method, of class TextLineNumber.
     */
    @Test
    public void testChangedUpdate()
    {
        System.out.println("changedUpdate");
        DocumentEvent e = null;
        TextLineNumber instance = null;
        instance.changedUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertUpdate method, of class TextLineNumber.
     */
    @Test
    public void testInsertUpdate()
    {
        System.out.println("insertUpdate");
        DocumentEvent e = null;
        TextLineNumber instance = null;
        instance.insertUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUpdate method, of class TextLineNumber.
     */
    @Test
    public void testRemoveUpdate()
    {
        System.out.println("removeUpdate");
        DocumentEvent e = null;
        TextLineNumber instance = null;
        instance.removeUpdate(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of propertyChange method, of class TextLineNumber.
     */
    @Test
    public void testPropertyChange()
    {
        System.out.println("propertyChange");
        PropertyChangeEvent evt = null;
        TextLineNumber instance = null;
        instance.propertyChange(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
