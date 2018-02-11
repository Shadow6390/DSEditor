/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.generic;

import dungeon.souls.modding.tool.model.module.SaveListener;
import java.io.File;
import javax.swing.JComponent;
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
public class ImageFileIT
{
    
    public ImageFileIT()
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
     * Test of getFileName method, of class ImageFile.
     */
    @Test
    public void testGetFileName()
    {
        System.out.println("getFileName");
        ImageFile instance = null;
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contentToComponent method, of class ImageFile.
     */
    @Test
    public void testContentToComponent()
    {
        System.out.println("contentToComponent");
        ImageFile instance = null;
        JComponent expResult = null;
        JComponent result = instance.contentToComponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class ImageFile.
     */
    @Test
    public void testSave() throws Exception
    {
        System.out.println("save");
        File parentDirectory = null;
        ImageFile instance = null;
        instance.save(parentDirectory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSaveListener method, of class ImageFile.
     */
    @Test
    public void testAddSaveListener()
    {
        System.out.println("addSaveListener");
        SaveListener l = null;
        ImageFile instance = null;
        boolean expResult = false;
        boolean result = instance.addSaveListener(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class ImageFile.
     */
    @Test
    public void testContains()
    {
        System.out.println("contains");
        SaveListener l = null;
        ImageFile instance = null;
        boolean expResult = false;
        boolean result = instance.contains(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ImageFile.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        ImageFile instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ImageFile.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        ImageFile instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
