/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import dungeon.souls.modding.tool.model.module.ModuleProject;
import java.io.File;
import java.util.List;
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
public class DungeonSoulsLanguageCompilerIT
{
    
    public DungeonSoulsLanguageCompilerIT()
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
     * Test of setVerbose method, of class DungeonSoulsLanguageCompiler.
     */
    @Test
    public void testSetVerbose()
    {
        System.out.println("setVerbose");
        boolean value = false;
        DungeonSoulsLanguageCompiler instance = new DungeonSoulsLanguageCompiler();
        instance.setVerbose(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compileProjectFolder method, of class DungeonSoulsLanguageCompiler.
     */
    @Test
    public void testCompileProjectFolder() throws Exception
    {
        System.out.println("compileProjectFolder");
        ModuleProject project = null;
        File output = null;
        DungeonSoulsLanguageCompiler instance = new DungeonSoulsLanguageCompiler();
        String expResult = "";
        String result = instance.compileProjectFolder(project, output);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compileProject method, of class DungeonSoulsLanguageCompiler.
     */
    @Test
    public void testCompileProject() throws Exception
    {
        System.out.println("compileProject");
        ModuleProject project = null;
        File output = null;
        DungeonSoulsLanguageCompiler instance = new DungeonSoulsLanguageCompiler();
        instance.compileProject(project, output);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compileString method, of class DungeonSoulsLanguageCompiler.
     */
    @Test
    public void testCompileString()
    {
        System.out.println("compileString");
        String text = "";
        boolean buildCode = false;
        DungeonSoulsLanguageCompiler instance = new DungeonSoulsLanguageCompiler();
        String expResult = "";
        String result = instance.compileString(text, buildCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getErrorMessages method, of class DungeonSoulsLanguageCompiler.
     */
    @Test
    public void testGetErrorMessages()
    {
        System.out.println("getErrorMessages");
        DungeonSoulsLanguageCompiler instance = new DungeonSoulsLanguageCompiler();
        List<CompilationErrorMessage> expResult = null;
        List<CompilationErrorMessage> result = instance.getErrorMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToVarible method, of class DungeonSoulsLanguageCompiler.
     */
    @Test
    public void testConvertToVarible()
    {
        System.out.println("convertToVarible");
        String text = "";
        String expResult = "";
        String result = DungeonSoulsLanguageCompiler.convertToVarible(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
