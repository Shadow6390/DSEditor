/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import javax.swing.text.Document;
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
public class DocumentTextChangeIT
{
    
    public DocumentTextChangeIT()
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
     * Test of undo method, of class DocumentTextChange.
     */
    @Test
    public void testUndo()
    {
        System.out.println("undo");
        Document doc = null;
        DocumentTextChange instance = new DocumentTextChangeImpl();
        instance.undo(doc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redo method, of class DocumentTextChange.
     */
    @Test
    public void testRedo()
    {
        System.out.println("redo");
        Document doc = null;
        DocumentTextChange instance = new DocumentTextChangeImpl();
        instance.redo(doc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DocumentTextChangeImpl implements DocumentTextChange
    {

        public void undo(Document doc)
        {
        }

        public void redo(Document doc)
        {
        }
    }
    
}
