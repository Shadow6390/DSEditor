/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

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
    dungeon.souls.modding.tool.model.compiling.language.BaseGrammarBaseListenerIT.class, dungeon.souls.modding.tool.model.compiling.language.DungeonSoulsLanguageCompilerIT.class, dungeon.souls.modding.tool.model.compiling.language.BaseGrammarBuildListenerIT.class, dungeon.souls.modding.tool.model.compiling.language.BaseGrammarBaseVisitorIT.class, dungeon.souls.modding.tool.model.compiling.language.assembly.AssemblyITSuite.class, dungeon.souls.modding.tool.model.compiling.language.BaseGrammarErrorListenerIT.class, dungeon.souls.modding.tool.model.compiling.language.CompilationErrorMessageIT.class
})
public class LanguageITSuite
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
