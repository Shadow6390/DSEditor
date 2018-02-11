/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

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
public class ExtensionManagerIT
{
    
    public ExtensionManagerIT()
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
     * Test of getInstance method, of class ExtensionManager.
     */
    @Test
    public void testGetInstance()
    {
        System.out.println("getInstance");
        ExtensionManager expResult = null;
        ExtensionManager result = ExtensionManager.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExtensionSpriteFile method, of class ExtensionManager.
     */
    @Test
    public void testIsExtensionSpriteFile()
    {
        System.out.println("isExtensionSpriteFile");
        String extension = "";
        ExtensionManager instance = null;
        boolean expResult = false;
        boolean result = instance.isExtensionSpriteFile(extension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExtensionItemFile method, of class ExtensionManager.
     */
    @Test
    public void testIsExtensionItemFile()
    {
        System.out.println("isExtensionItemFile");
        String extension = "";
        ExtensionManager instance = null;
        boolean expResult = false;
        boolean result = instance.isExtensionItemFile(extension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExtensionModuleFile method, of class ExtensionManager.
     */
    @Test
    public void testIsExtensionModuleFile()
    {
        System.out.println("isExtensionModuleFile");
        String extension = "";
        ExtensionManager instance = null;
        boolean expResult = false;
        boolean result = instance.isExtensionModuleFile(extension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExtensionImage method, of class ExtensionManager.
     */
    @Test
    public void testIsExtensionImage()
    {
        System.out.println("isExtensionImage");
        String extension = "";
        ExtensionManager instance = null;
        boolean expResult = false;
        boolean result = instance.isExtensionImage(extension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
