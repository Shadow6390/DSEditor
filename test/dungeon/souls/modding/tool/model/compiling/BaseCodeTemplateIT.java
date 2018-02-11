/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling;

import dungeon.souls.modding.tool.reflection.Property;
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
public class BaseCodeTemplateIT
{
    
    public BaseCodeTemplateIT()
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
     * Test of fillTemplate method, of class BaseCodeTemplate.
     */
    @Test
    public void testFillTemplate()
    {
        System.out.println("fillTemplate");
        String expectedGame = "TEST";
        int expectedData = 512;
        TemplateData data = new TemplateData() {
        @Property("GAME")
        private String game=expectedGame;
        
        @Property("DATA")
        private int data=expectedData;
        };
        BaseCodeTemplateImpl instance = new BaseCodeTemplateImpl();
        instance.fillTemplate(data);
        
        assertEquals(expectedGame,instance.myGame);
        
        assertNotSame("Attribute 'data' shouldn't have been copied", expectedData, instance.data);
    }

    public class BaseCodeTemplateImpl extends BaseCodeTemplate
    {

        @Property("GAME")
        public String myGame;
        
        public int data;
        
        @Override
        public String getTemplateCode()
        {
            return "Lorem Ipsum";
        }
    }
    
}
