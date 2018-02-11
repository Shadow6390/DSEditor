/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.steam.SteamWorkshopCommunityItem;
import java.util.Map;
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
public class SteamWorkshopInformationChooseUIIT
{
    
    public SteamWorkshopInformationChooseUIIT()
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
     * Test of getAttributeMap method, of class SteamWorkshopInformationChooseUI.
     */
    @Test
    public void testGetAttributeMap()
    {
        System.out.println("getAttributeMap");
        SteamWorkshopInformationChooseUI instance = null;
        Map<SteamWorkshopCommunityItem.ATTRIBUTES, String> expResult = null;
        Map<SteamWorkshopCommunityItem.ATTRIBUTES, String> result = instance.getAttributeMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
