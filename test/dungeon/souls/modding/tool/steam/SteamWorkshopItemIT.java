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
public class SteamWorkshopItemIT
{
    
    public SteamWorkshopItemIT()
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
     * Test of isType method, of class SteamWorkshopItem.
     */
    @Test
    public void testIsType()
    {
        System.out.println("isType");
        SteamRemoteStorage.WorkshopFileType type = null;
        SteamWorkshopItem instance = new SteamWorkshopItemImpl();
        boolean expResult = false;
        boolean result = instance.isType(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uploadFile method, of class SteamWorkshopItem.
     */
    @Test
    public void testUploadFile()
    {
        System.out.println("uploadFile");
        SteamWorkshopItem instance = new SteamWorkshopItemImpl();
        instance.uploadFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class SteamWorkshopItemImpl implements SteamWorkshopItem
    {

        public boolean isType(SteamRemoteStorage.WorkshopFileType type)
        {
            return false;
        }

        public void uploadFile()
        {
        }
    }
    
}
