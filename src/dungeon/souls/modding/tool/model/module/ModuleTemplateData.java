/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import dungeon.souls.modding.tool.model.compiling.TemplateData;
import dungeon.souls.modding.tool.reflection.Property;

/**
 * The template data of the ModdingCodeTemplate.
 * This class is a bag of data.
 * @author Diogo
 */
public class ModuleTemplateData implements TemplateData
{
    /**
    * The name of this module (must not be null).
    * Corresponds to the name being presented to the player.
    */
    @Property("NAME")
    public String name;

    /**
    * The version of this module (must not be null).
    */
    @Property("VERSION")
    public String version;

    /**
    * The description of this module.
    */
    @Property("DESCRIPTION")
    public String description;

    /**
    * The item directory of this module.
    */
    @Property("ITEM_DIR")
    public String itemDirectory;
    
    /**
    * The sprite directory of this module.
    */
    @Property("SPRITE_DIR")
    public String spriteDirectory;
}
