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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diogo
 */
public class BaseGrammarBuildListenerIT
{
    
    public BaseGrammarBuildListenerIT()
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
     * Test of getSemanticErrors method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testGetSemanticErrors()
    {
        System.out.println("getSemanticErrors");
        BaseGrammarBuildListener instance = null;
        int expResult = 0;
        int result = instance.getSemanticErrors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompilationAssemblyCode method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testGetCompilationAssemblyCode()
    {
        System.out.println("getCompilationAssemblyCode");
        BaseGrammarBuildListener instance = null;
        String expResult = "";
        String result = instance.getCompilationAssemblyCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetModule method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testExitAssetModule()
    {
        System.out.println("exitAssetModule");
        BaseGrammarParser.AssetModuleContext ctx = null;
        BaseGrammarBuildListener instance = null;
        instance.exitAssetModule(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterAssetFunction method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testEnterAssetFunction()
    {
        System.out.println("enterAssetFunction");
        BaseGrammarParser.AssetFunctionContext ctx = null;
        BaseGrammarBuildListener instance = null;
        instance.enterAssetFunction(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetFunction method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testExitAssetFunction()
    {
        System.out.println("exitAssetFunction");
        BaseGrammarParser.AssetFunctionContext ctx = null;
        BaseGrammarBuildListener instance = null;
        instance.exitAssetFunction(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetSprite method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testExitAssetSprite()
    {
        System.out.println("exitAssetSprite");
        BaseGrammarParser.AssetSpriteContext ctx = null;
        BaseGrammarBuildListener instance = null;
        instance.exitAssetSprite(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetItem method, of class BaseGrammarBuildListener.
     */
    @Test
    public void testExitAssetItem()
    {
        System.out.println("exitAssetItem");
        BaseGrammarParser.AssetItemContext ctx = null;
        BaseGrammarBuildListener instance = null;
        instance.exitAssetItem(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
