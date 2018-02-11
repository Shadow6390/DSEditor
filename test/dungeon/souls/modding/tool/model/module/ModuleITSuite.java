/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

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
    dungeon.souls.modding.tool.model.module.ModuleProjectIT.class, dungeon.souls.modding.tool.model.module.ModuleTemplateDataIT.class, dungeon.souls.modding.tool.model.module.ExtensionManagerIT.class, dungeon.souls.modding.tool.model.module.SaveListenerIT.class, dungeon.souls.modding.tool.model.module.ModuleCodeTemplateIT.class, dungeon.souls.modding.tool.model.module.ModuleManagerIT.class
})
public class ModuleITSuite
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
