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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Diogo
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    dungeon.souls.modding.tool.steam.SteamWorkshopListIT.class, dungeon.souls.modding.tool.steam.SteamManagerIT.class, dungeon.souls.modding.tool.steam.SteamWorkshopItemIT.class, dungeon.souls.modding.tool.steam.SteamWorkshopCommunityItemIT.class, dungeon.souls.modding.tool.steam.SteamWorkshopModuleIT.class, dungeon.souls.modding.tool.steam.SteamListenerIT.class
})
public class SteamITSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}
