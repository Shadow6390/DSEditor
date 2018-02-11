/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool;

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
    dungeon.souls.modding.tool.model.ModelITSuite.class, dungeon.souls.modding.tool.reflection.ReflectionITSuite.class, dungeon.souls.modding.tool.resources.ResourcesITSuite.class, dungeon.souls.modding.tool.utils.UtilsITSuite.class, dungeon.souls.modding.tool.ui.UiITSuite.class, dungeon.souls.modding.tool.steam.SteamITSuite.class
})
public class ToolITSuite
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
