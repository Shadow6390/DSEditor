/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import java.util.List;
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
public class ModuleManagerIT
{
    
    public ModuleManagerIT()
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
     * Test of createModuleProject method, of class ModuleManager.
     */
    @Test
    public void testCreateModuleProject()
    {
        System.out.println("createModuleProject");
        String name = "";
        ModuleCodeTemplate template = null;
        ModuleManager instance = new ModuleManager();
        ModuleProject expResult = null;
        ModuleProject result = instance.createModuleProject(name, template);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProjects method, of class ModuleManager.
     */
    @Test
    public void testGetAllProjects()
    {
        System.out.println("getAllProjects");
        ModuleManager instance = new ModuleManager();
        List<ModuleProject> expResult = null;
        List<ModuleProject> result = instance.getAllProjects();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ModuleManager.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        ModuleManager instance = new ModuleManager();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
