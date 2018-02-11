/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

import com.codedisaster.steamworks.SteamRemoteStorage;
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
public class SteamWorkshopCommunityItemIT
{
    
    public SteamWorkshopCommunityItemIT()
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
     * Test of put method, of class SteamWorkshopCommunityItem.
     */
    @Test
    public void testPut()
    {
        System.out.println("put");
        SteamWorkshopCommunityItem.ATTRIBUTES key = null;
        String value = "";
        SteamWorkshopCommunityItem instance = null;
        String expResult = "";
        String result = instance.put(key, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isType method, of class SteamWorkshopCommunityItem.
     */
    @Test
    public void testIsType()
    {
        System.out.println("isType");
        SteamRemoteStorage.WorkshopFileType type = null;
        SteamWorkshopCommunityItem instance = null;
        boolean expResult = false;
        boolean result = instance.isType(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadFile method, of class SteamWorkshopCommunityItem.
     */
    @Test
    public void testUploadFile()
    {
        System.out.println("uploadFile");
        SteamWorkshopCommunityItem instance = null;
        instance.uploadFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
