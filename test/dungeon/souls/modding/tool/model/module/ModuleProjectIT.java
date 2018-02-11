/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import dungeon.souls.modding.tool.model.compiling.ModdingFile;
import dungeon.souls.modding.tool.model.item.ItemCodeTemplate;
import dungeon.souls.modding.tool.model.sprite.SpriteCodeTemplate;
import dungeon.souls.modding.tool.reflection.FileEditable;
import java.io.File;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
public class ModuleProjectIT
{
    
    public ModuleProjectIT()
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
     * Test of getName method, of class ModuleProject.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        ModuleProject instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewSprite method, of class ModuleProject.
     */
    @Test
    public void testCreateNewSprite()
    {
        System.out.println("createNewSprite");
        String name = "";
        SpriteCodeTemplate template = null;
        ModuleProject instance = null;
        ModdingFile expResult = null;
        ModdingFile result = instance.createNewSprite(name, template);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewItem method, of class ModuleProject.
     */
    @Test
    public void testCreateNewItem()
    {
        System.out.println("createNewItem");
        String name = "";
        ItemCodeTemplate template = null;
        ModuleProject instance = null;
        ModdingFile expResult = null;
        ModdingFile result = instance.createNewItem(name, template);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadImages method, of class ModuleProject.
     */
    @Test
    public void testLoadImages()
    {
        System.out.println("loadImages");
        File base = null;
        File[] images = null;
        ModuleProject instance = null;
        List<FileEditable> expResult = null;
        List<FileEditable> result = instance.loadImages(base, images);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModule method, of class ModuleProject.
     */
    @Test
    public void testGetModule()
    {
        System.out.println("getModule");
        ModuleProject instance = null;
        ModdingFile expResult = null;
        ModdingFile result = instance.getModule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFilesAsNodes method, of class ModuleProject.
     */
    @Test
    public void testLoadFilesAsNodes()
    {
        System.out.println("loadFilesAsNodes");
        DefaultMutableTreeNode baseNode = null;
        DefaultTreeModel model = null;
        ModuleProject instance = null;
        instance.loadFilesAsNodes(baseNode, model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFile method, of class ModuleProject.
     */
    @Test
    public void testRemoveFile()
    {
        System.out.println("removeFile");
        FileEditable file = null;
        ModuleProject instance = null;
        instance.removeFile(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ModuleProject.
     */
    @Test
    public void testDelete()
    {
        System.out.println("delete");
        ModuleProject instance = null;
        instance.delete();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class ModuleProject.
     */
    @Test
    public void testLoad() throws Exception
    {
        System.out.println("load");
        ModuleProject instance = null;
        instance.load();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class ModuleProject.
     */
    @Test
    public void testSave()
    {
        System.out.println("save");
        ModuleProject instance = null;
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ModuleProject.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        ModuleProject instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergeCodeFiles method, of class ModuleProject.
     */
    @Test
    public void testMergeCodeFiles()
    {
        System.out.println("mergeCodeFiles");
        ModuleProject instance = null;
        String expResult = "";
        String result = instance.mergeCodeFiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirectory method, of class ModuleProject.
     */
    @Test
    public void testGetDirectory()
    {
        System.out.println("getDirectory");
        ModuleProject instance = null;
        File expResult = null;
        File result = instance.getDirectory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
