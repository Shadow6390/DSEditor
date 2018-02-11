/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.item;

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
public class ItemCodeTemplateIT
{
    
    public ItemCodeTemplateIT()
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
     * Test of getTemplateCode method, of class ItemCodeTemplate.
     */
    @Test
    public void testGetTemplateCode()
    {
        System.out.println("getTemplateCode");
        ItemCodeTemplate instance = new ItemCodeTemplate();
        ItemTemplateData data = new ItemTemplateData();
        data.name="\"test_item\"";
        data.maxStacks=1;
        data.price=0;
        data.description="\"test description\"";
        data.sprite="spr_potato";
        data.type=ItemCodeTemplate.ITEM_PASSIVE;
        data.rarity=ItemCodeTemplate.ITEM_RARITIES[0];
        instance.fillTemplate(data);
        String expResult = "define item test_item\n" +
"{\n" +
"	[NAME]=\"\"test_item\"\";\n" +
"	[MAX_STACKS]=1;\n" +
"	[DESCRIPTION]=\"\"test description\"\";\n" +
"	[SPRITE]=\"spr_potato\";\n" +
"	[TYPE]=\"item_passive\";\n" +
"	[PRICE]=0;\n" +
"	[RARITY]=\"item_common\";\n" +
"	//[ON_PICKUP_FUNCTION];\n" +
"	//[ON_ACTIVE_FUNCTION];\n" +
"	//[ON_STEP_FUNCTION];\n" +
"\n" +
"\n" +
"	//Place function declarations here...\n" +
"}";
        String result = instance.getTemplateCode();
        assertEquals(expResult, result);
    }
    
}
