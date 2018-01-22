/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.sprite;

import dungeon.souls.modding.tool.model.compiling.TemplateData;
import dungeon.souls.modding.tool.reflection.Property;

/**
 * Code template for the sprite file.
 * @author Diogo
 */
public class SpriteTemplateData implements TemplateData
{

    /**
    * The subimage of the sprite.
    */
    @Property("SUBIMAGE")
    public String subimage;
}
