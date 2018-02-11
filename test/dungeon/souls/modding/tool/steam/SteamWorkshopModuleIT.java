/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

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
public class SteamWorkshopModuleIT
{
    
    public SteamWorkshopModuleIT()
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
     * Test of getModuleName method, of class SteamWorkshopModule.
     */
    @Test
    public void testGetModuleName()
    {
        System.out.println("getModuleName");
        SteamWorkshopModule instance = new SteamWorkshopModule();
        String expResult = "";
        String result = instance.getModuleName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModuleName method, of class SteamWorkshopModule.
     */
    @Test
    public void testSetModuleName()
    {
        System.out.println("setModuleName");
        String moduleName = "";
        SteamWorkshopModule instance = new SteamWorkshopModule();
        instance.setModuleName(moduleName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSteamItemID method, of class SteamWorkshopModule.
     */
    @Test
    public void testGetSteamItemID()
    {
        System.out.println("getSteamItemID");
        SteamWorkshopModule instance = new SteamWorkshopModule();
        long expResult = 0L;
        long result = instance.getSteamItemID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSteamItemID method, of class SteamWorkshopModule.
     */
    @Test
    public void testSetSteamItemID()
    {
        System.out.println("setSteamItemID");
        long steamItemID = 0L;
        SteamWorkshopModule instance = new SteamWorkshopModule();
        instance.setSteamItemID(steamItemID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class SteamWorkshopModule.
     */
    @Test
    public void testGetTitle()
    {
        System.out.println("getTitle");
        SteamWorkshopModule instance = new SteamWorkshopModule();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class SteamWorkshopModule.
     */
    @Test
    public void testSetTitle()
    {
        System.out.println("setTitle");
        String title = "";
        SteamWorkshopModule instance = new SteamWorkshopModule();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class SteamWorkshopModule.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        SteamWorkshopModule instance = new SteamWorkshopModule();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class SteamWorkshopModule.
     */
    @Test
    public void testSetDescription()
    {
        System.out.println("setDescription");
        String description = "";
        SteamWorkshopModule instance = new SteamWorkshopModule();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreview method, of class SteamWorkshopModule.
     */
    @Test
    public void testGetPreview()
    {
        System.out.println("getPreview");
        SteamWorkshopModule instance = new SteamWorkshopModule();
        String expResult = "";
        String result = instance.getPreview();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreview method, of class SteamWorkshopModule.
     */
    @Test
    public void testSetPreview()
    {
        System.out.println("setPreview");
        String preview = "";
        SteamWorkshopModule instance = new SteamWorkshopModule();
        instance.setPreview(preview);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class SteamWorkshopModule.
     */
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Object other = null;
        SteamWorkshopModule instance = new SteamWorkshopModule();
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class SteamWorkshopModule.
     */
    @Test
    public void testHashCode()
    {
        System.out.println("hashCode");
        SteamWorkshopModule instance = new SteamWorkshopModule();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
