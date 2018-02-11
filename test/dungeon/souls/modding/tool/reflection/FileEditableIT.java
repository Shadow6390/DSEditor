/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.reflection;

import dungeon.souls.modding.tool.model.module.SaveListener;
import java.io.File;
import java.io.IOException;
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
public class FileEditableIT
{
    
    public FileEditableIT()
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
     * Test of getFileName method, of class FileEditable.
     */
    @Test
    public void testGetFileName()
    {
        System.out.println("getFileName");
        FileEditable instance = new FileEditableImpl();
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contentToComponent method, of class FileEditable.
     */
    @Test
    public void testContentToComponent()
    {
        System.out.println("contentToComponent");
        FileEditable instance = new FileEditableImpl();
        JComponent expResult = null;
        JComponent result = instance.contentToComponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class FileEditable.
     */
    @Test
    public void testSave() throws Exception
    {
        System.out.println("save");
        File parentDirectory = null;
        FileEditable instance = new FileEditableImpl();
        instance.save(parentDirectory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSaveListener method, of class FileEditable.
     */
    @Test
    public void testAddSaveListener()
    {
        System.out.println("addSaveListener");
        SaveListener l = null;
        FileEditable instance = new FileEditableImpl();
        boolean expResult = false;
        boolean result = instance.addSaveListener(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class FileEditable.
     */
    @Test
    public void testContains()
    {
        System.out.println("contains");
        SaveListener l = null;
        FileEditable instance = new FileEditableImpl();
        boolean expResult = false;
        boolean result = instance.contains(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FileEditable.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        FileEditable instance = new FileEditableImpl();
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class FileEditableImpl implements FileEditable
    {

        public String getFileName()
        {
            return "";
        }

        public JComponent contentToComponent()
        {
            return null;
        }

        public void save(File parentDirectory) throws IOException
        {
        }

        public boolean addSaveListener(SaveListener l)
        {
            return false;
        }

        public boolean contains(SaveListener l)
        {
            return false;
        }

        public void delete()
        {
        }
    }
    
}
