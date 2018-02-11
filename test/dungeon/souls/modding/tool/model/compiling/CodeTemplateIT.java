/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling;

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
public class CodeTemplateIT
{
    
    public CodeTemplateIT()
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
     * Test of fillTemplate method, of class CodeTemplate.
     */
    @Test
    public void testFillTemplate()
    {
        System.out.println("fillTemplate");
        TemplateData data = null;
        CodeTemplate instance = new CodeTemplateImpl();
        instance.fillTemplate(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTemplateCode method, of class CodeTemplate.
     */
    @Test
    public void testGetTemplateCode()
    {
        System.out.println("getTemplateCode");
        CodeTemplate instance = new CodeTemplateImpl();
        String expResult = "";
        String result = instance.getTemplateCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CodeTemplateImpl implements CodeTemplate
    {

        public void fillTemplate(TemplateData data)
        {
        }

        public String getTemplateCode()
        {
            return "";
        }
    }
    
}
