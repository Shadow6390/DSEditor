/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
public class JImagePanelIT
{
    
    public JImagePanelIT()
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
     * Test of setImage method, of class JImagePanel.
     */
    @Test
    public void testSetImage()
    {
        System.out.println("setImage");
        BufferedImage image = null;
        JImagePanel instance = new JImagePanel();
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class JImagePanel.
     */
    @Test
    public void testGetImage()
    {
        System.out.println("getImage");
        JImagePanel instance = new JImagePanel();
        BufferedImage expResult = null;
        BufferedImage result = instance.getImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class JImagePanel.
     */
    @Test
    public void testPaintComponent()
    {
        System.out.println("paintComponent");
        Graphics g = null;
        JImagePanel instance = new JImagePanel();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
