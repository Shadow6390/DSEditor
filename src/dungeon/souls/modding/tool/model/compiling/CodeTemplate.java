/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling;

/**
 * Represents a code template.
 * Should use @Property where needed.
 * @author Diogo
 */
public interface CodeTemplate
{
    /**
     * Fills this template with data for parameters.
     * @param data ({@link TemplateData}) The data to fill this template's parameters with.
     */
    public void fillTemplate(TemplateData data);
    
    /**
     * Returns the template code.
     * @return (String) The code of the template.
     */
    public String getTemplateCode();
}
