/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.item;

import dungeon.souls.modding.tool.model.compiling.TemplateData;
import dungeon.souls.modding.tool.reflection.Property;

/**
 * Code template for the sprite file.
 * @author Diogo
 */
public class ItemTemplateData implements TemplateData
{
    /**
    * The name of this item (must not be null).
    * Corresponds to the name being presented to the player.
    */
    @Property
    public String name;

    /**
    * The maximum amount of stacks of this item.
    */
    @Property("MAX_STACKS")
    public int maxStacks;
    
    /**
    * The description of this item.
    */
    @Property
    public String description;
    
    /**
    * The sprite of this item.
    */
    @Property
    public String sprite;
    
    /**
    * The type of this item.
    */
    @Property
    public String type;
    
    /**
    * The price of this item.
    */
    @Property
    public int price;
    
    /**
    * The rarity of this item.
    */
    @Property
    public String rarity;
    
    /**
    * The function triggered when picking up this item.
    */
    @Property("ON_PICKUP_FUNCTION")
    public String onPickupFunction;
    
    /**
    * The function triggered when activating this item.
    */
    @Property("ON_ACTIVE_FUNCTION")
    public String onActiveFunction;
    
    /**
    * The function triggered at each step.
    */
    @Property("ON_STEP_FUNCTION")
    public String onStepFunction;

}
