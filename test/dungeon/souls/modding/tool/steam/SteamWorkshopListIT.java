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
public class SteamWorkshopListIT
{
    
    public SteamWorkshopListIT()
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
     * Test of addSteamWorkshopModule method, of class SteamWorkshopList.
     */
    @Test
    public void testAddSteamWorkshopModule()
    {
        System.out.println("addSteamWorkshopModule");
        SteamWorkshopModule m = null;
        SteamWorkshopList instance = new SteamWorkshopList();
        boolean expResult = false;
        boolean result = instance.addSteamWorkshopModule(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSteamWorkshopModule method, of class SteamWorkshopList.
     */
    @Test
    public void testGetSteamWorkshopModule_String()
    {
        System.out.println("getSteamWorkshopModule");
        String moduleName = "";
        SteamWorkshopList instance = new SteamWorkshopList();
        SteamWorkshopModule expResult = null;
        SteamWorkshopModule result = instance.getSteamWorkshopModule(moduleName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSteamWorkshopModule method, of class SteamWorkshopList.
     */
    @Test
    public void testGetSteamWorkshopModule_int()
    {
        System.out.println("getSteamWorkshopModule");
        int i = 0;
        SteamWorkshopList instance = new SteamWorkshopList();
        SteamWorkshopModule expResult = null;
        SteamWorkshopModule result = instance.getSteamWorkshopModule(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class SteamWorkshopList.
     */
    @Test
    public void testSize()
    {
        System.out.println("size");
        SteamWorkshopList instance = new SteamWorkshopList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
