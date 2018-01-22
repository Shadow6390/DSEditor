/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import dungeon.souls.modding.tool.model.compiling.BaseCodeTemplate;
import dungeon.souls.modding.tool.model.compiling.language.DungeonSoulsLanguageCompiler;
import dungeon.souls.modding.tool.reflection.ObjectToTextConverter;
import dungeon.souls.modding.tool.reflection.Property;

/**
 * Code template for the module file.
 * @author Diogo
 */
public class ModuleCodeTemplate extends BaseCodeTemplate
{
    /**
    * The name of this module (must not be null).
    * Corresponds to the name being presented to the player.
    */
    @Property("NAME")
    private String name;

    /**
    * The version of this module (must not be null).
    */
    @Property("VERSION")
    private String version;

    /**
    * The description of this module.
    */
    @Property("DESCRIPTION")
    private String description;

    /**
    * The item directory of this module.
    */
    @Property("ITEM_DIR")
    private String itemDirectory;
    
    /**
    * The sprite directory of this module.
    */
    @Property("SPRITE_DIR")
    private String spriteDirectory;


    /**
    * Initializes this code template.
    */
    public ModuleCodeTemplate()
    {

    }

    /**
    * Returns the code template of the module class.
    * @return (String) The code template.
    */
   @Override
    public String getTemplateCode()
    {
        String base = "define module "+DungeonSoulsLanguageCompiler.convertToVarible(name)+"\n{\n";
        String autoFilled = ObjectToTextConverter.toText(this);
        for (String line:autoFilled.split("\n"))
        {
            base+="\t"+line+";\n";
        }
        base+="\n\n\t#Place code here...\n";
        base+="}";
        return base;
    }
}
