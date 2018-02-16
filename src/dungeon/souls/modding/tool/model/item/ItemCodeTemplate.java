/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.item;

import dungeon.souls.modding.tool.model.compiling.BaseCodeTemplate;
import dungeon.souls.modding.tool.model.compiling.language.DungeonSoulsLanguageCompiler;
import dungeon.souls.modding.tool.reflection.ObjectToTextConverter;
import dungeon.souls.modding.tool.reflection.Property;
import java.util.Arrays;
import java.util.List;

/**
 * Code template for the sprite file.
 * @author Diogo
 */
public class ItemCodeTemplate extends BaseCodeTemplate
{
    
    public static final String ITEM_PASSIVE="item_passive";
    public static final String ITEM_ACTIVE="item_active";
    public static final String ITEM_CONSUMABLE="item_consumable";
    
    //Collection form
    public static final String[] ITEM_TYPES = {ITEM_PASSIVE,ITEM_ACTIVE,ITEM_CONSUMABLE};
    public static final List<String> ITEM_TYPES_LIST = Arrays.asList(ITEM_TYPES);
    
    public static final String RARITY_COMMON="item_common";
    public static final String RARITY_UNCOMMON="item_uncommon";
    public static final String RARITY_RARE="item_rare";
    public static final String RARITY_LEGENDARY="item_legendary";
    public static final String RARITY_CURSED="item_cursed";
    
    //Collection form
    public static final String[] ITEM_RARITIES = {RARITY_COMMON,RARITY_UNCOMMON,RARITY_RARE,RARITY_LEGENDARY,RARITY_CURSED};
    public static final List<String> ITEM_RARITIES_LIST = Arrays.asList(ITEM_RARITIES);
    
    /**
    * The name of this item (must not be null).
    * Corresponds to the name being presented to the player.
    */
    @Property
    private String name;

    /**
    * The maximum amount of stacks of this item.
    */
    @Property("MAX_STACKS")
    private int maxStacks;
    
    /**
    * The description of this item.
    */
    @Property
    private String description;
    
    /**
    * The sprite of this item.
    */
    @Property
    private String sprite;
    
    /**
    * The type of this item.
    */
    @Property
    private String type;
    
    /**
    * The price of this item.
    */
    @Property
    private int price;
    
    /**
    * The rarity of this item.
    */
    @Property
    private String rarity;
    
    /**
    * The function triggered when picking up this item.
    */
    @Property(value="ON_PICKUP_FUNCTION",ignoreType = true)
    private String onPickupFunction;
    
    /**
    * The function triggered when activating this item.
    */
    @Property(value="ON_ACTIVE_FUNCTION",ignoreType = true)
    private String onActiveFunction;
    
    /**
    * The function triggered at each step.
    */
    @Property(value="ON_STEP_FUNCTION",ignoreType = true)
    private String onStepFunction;

    /**
    * Initializes this code template.
    */
    public ItemCodeTemplate()
    {

    }
    
    /**
    * Returns the code template of the module class.
    * @return (String) The code template.
    */
   @Override
    public String getTemplateCode()
    {
        String base = "define item itm_"+DungeonSoulsLanguageCompiler.convertToVarible(name)+"\n{\n";
        String autoFilled = ObjectToTextConverter.toText(this);
        for (String line:autoFilled.split("\n"))
        {
            base+="\t"+line+";\n";
        }
        base+="\n\n\t//Place function declarations here...\n";
        base+="}";
        return base;
    }
}
