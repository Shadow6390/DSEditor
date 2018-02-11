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
public class SteamManagerIT
{
    
    public SteamManagerIT()
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
     * Test of getInstance method, of class SteamManager.
     */
    @Test
    public void testGetInstance()
    {
        System.out.println("getInstance");
        SteamManager expResult = null;
        SteamManager result = SteamManager.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSteamListener method, of class SteamManager.
     */
    @Test
    public void testAddSteamListener()
    {
        System.out.println("addSteamListener");
        SteamListener listener = null;
        SteamManager instance = null;
        boolean expResult = false;
        boolean result = instance.addSteamListener(listener);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeSteam method, of class SteamManager.
     */
    @Test
    public void testInitializeSteam() throws Exception
    {
        System.out.println("initializeSteam");
        SteamManager instance = null;
        boolean expResult = false;
        boolean result = instance.initializeSteam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveData method, of class SteamManager.
     */
    @Test
    public void testSaveData() throws Exception
    {
        System.out.println("saveData");
        SteamManager instance = null;
        instance.saveData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redirectToLicenseAgreement method, of class SteamManager.
     */
    @Test
    public void testRedirectToLicenseAgreement() throws Exception
    {
        System.out.println("redirectToLicenseAgreement");
        SteamManager instance = null;
        instance.redirectToLicenseAgreement();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initCallbackLoop method, of class SteamManager.
     */
    @Test
    public void testInitCallbackLoop()
    {
        System.out.println("initCallbackLoop");
        SteamManager instance = null;
        instance.initCallbackLoop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of synchronizeWorkshopProjects method, of class SteamManager.
     */
    @Test
    public void testSynchronizeWorkshopProjects()
    {
        System.out.println("synchronizeWorkshopProjects");
        SteamManager instance = null;
        instance.synchronizeWorkshopProjects();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAPIInitialized method, of class SteamManager.
     */
    @Test
    public void testIsAPIInitialized()
    {
        System.out.println("isAPIInitialized");
        SteamManager instance = null;
        boolean expResult = false;
        boolean result = instance.isAPIInitialized();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModuleList method, of class SteamManager.
     */
    @Test
    public void testGetModuleList()
    {
        System.out.println("getModuleList");
        SteamManager instance = null;
        SteamWorkshopList expResult = null;
        SteamWorkshopList result = instance.getModuleList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
