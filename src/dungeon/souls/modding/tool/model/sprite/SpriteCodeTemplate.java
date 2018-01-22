/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.sprite;

import dungeon.souls.modding.tool.model.compiling.BaseCodeTemplate;
import dungeon.souls.modding.tool.model.compiling.language.DungeonSoulsLanguageCompiler;
import dungeon.souls.modding.tool.reflection.ObjectToTextConverter;
import dungeon.souls.modding.tool.reflection.Property;

/**
 * Code template for the sprite file.
 * @author Diogo
 */
public class SpriteCodeTemplate extends BaseCodeTemplate
{
    /**
    * The name of this sprite (must not be null).
    * Corresponds to the name being presented to the player.
    */
    private String name;

    /**
    * The item directory of this module.
    */
    @Property("SUBIMAGE")
    private String subimage;

    /**
    * Initializes this code template.
    */
    public SpriteCodeTemplate(String name)
    {
        this.name=name;
    }

    /**
    * Returns the code template of the module class.
    * @return (String) The code template.
    */
   @Override
    public String getTemplateCode()
    {
        String base = "define sprite "+DungeonSoulsLanguageCompiler.convertToVarible(name)+"\n{\n";
        String autoFilled = ObjectToTextConverter.toText(this);
        for (String line:autoFilled.split("\n"))
        {
            base+="\t"+line+";\n";
        }
        base+="\n\n\t#Sprites can have multiple [SUBIMAGE] fields.\n#The order of the sprite's animation is defined by the order of appearance of each [SUBIMAGE]\n";
        base+="}";
        return base;
    }
}
