/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipOutputStream;
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
public class UtilitiesIT
{
    
    public UtilitiesIT()
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
     * Test of recurseCopy method, of class Utilities.
     */
    @Test
    public void testRecurseCopy()
    {
        System.out.println("recurseCopy");
        File projectDir = null;
        File targetDir = null;
        Utilities.ZipFileFilter filter = null;
        Utilities.recurseCopy(projectDir, targetDir, filter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zipDirectory method, of class Utilities.
     */
    @Test
    public void testZipDirectory() throws Exception
    {
        System.out.println("zipDirectory");
        File dir = null;
        ZipOutputStream out = null;
        Utilities.ZipFileFilter filter = null;
        boolean ignoreCurrentDir = false;
        Utilities.zipDirectory(dir, out, filter, ignoreCurrentDir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of extractPackagedFiled method, of class Utilities.
     */
    @Test
    public void testExtractPackagedFiled() throws Exception
    {
        System.out.println("extractPackagedFiled");
        File folder = null;
        InputStream stream = null;
        String name = "";
        boolean replace = false;
        Utilities.extractPackagedFile(folder, stream, name, replace);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fileAsString method, of class Utilities.
     */
    @Test
    public void testFileAsString() throws Exception
    {
        System.out.println("fileAsString");
        File file = null;
        String expResult = "";
        String result = Utilities.fileAsString(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputStreamAsString method, of class Utilities.
     */
    @Test
    public void testInputStreamAsString() throws Exception
    {
        System.out.println("inputStreamAsString");
        InputStream inputStream = null;
        String expResult = "";
        String result = Utilities.inputStreamAsString(inputStream);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fileToByteArray method, of class Utilities.
     */
    @Test
    public void testFileToByteArray() throws Exception
    {
        System.out.println("fileToByteArray");
        File file = null;
        byte[] expResult = null;
        byte[] result = Utilities.fileToByteArray(file);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTemporaryDirectory method, of class Utilities.
     */
    @Test
    public void testCreateTemporaryDirectory()
    {
        System.out.println("createTemporaryDirectory");
        boolean expResult = true;
        File result = Utilities.createTemporaryDirectory();
        assertEquals(expResult, result.exists());
        assertTrue(result.getName().startsWith("Temp"));
        result.delete();
    }

    /**
     * Test of deleteDirectory method, of class Utilities.
     */
    @Test
    public void testDeleteDirectory()
    {
        System.out.println("deleteDirectory");
        File file = null;
        Utilities.deleteDirectory(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
