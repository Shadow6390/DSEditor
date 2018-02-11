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
public class DocumentTextUndoManagerIT
{
    
    public DocumentTextUndoManagerIT()
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
     * Test of undo method, of class DocumentTextUndoManager.
     */
    @Test
    public void testUndo()
    {
        System.out.println("undo");
        DocumentTextUndoManager instance = null;
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redo method, of class DocumentTextUndoManager.
     */
    @Test
    public void testRedo()
    {
        System.out.println("redo");
        DocumentTextUndoManager instance = null;
        instance.redo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
