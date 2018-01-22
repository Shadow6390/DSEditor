/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling;

import dungeon.souls.modding.tool.reflection.ObjectToTextConverter;
import dungeon.souls.modding.tool.reflection.Property;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base class for a code template.
 * Has built-in functionalities to automatically fill properties with
 * data from a ({@link TemplateData}).
 * For the auto-fill to work, the TemplateData and the CodeTemplate must have
 * the same @Property value.
 * <p>
 * For example, if a TemplateData class is defined with the attribute:
 * <p>
 * @Property("XYZ")<p>
 * private String xyz;
 * 
 * <p>
 * Then the CodeTemplate's variables that have @Property("XYZ") will be filled with that data.
 * @author Diogo
 */
public abstract class BaseCodeTemplate implements CodeTemplate
{
    /**
     * Default constructor.
     */
    public BaseCodeTemplate()
    {
        
    }
    
    /**
     * Fills this template with data for parameters.
     * @param data ({@link TemplateData}) The data to fill this template's parameters with.
     */
    @Override
    public void fillTemplate(TemplateData data)
    {
        for (Field f:data.getClass().getDeclaredFields())
        {
            Property[] properties = f.getAnnotationsByType(Property.class);
            if (properties.length>0)
            {
                for (Property p:properties)
                {
                    try 
                    {
                        boolean access = f.isAccessible();
                        f.setAccessible(true);
                        String pValue = p.value();
                        if (pValue.equals(""))
                        {
                            pValue=f.getName();
                        }
                        for (Field templateField:getClass().getDeclaredFields())
                        {
                            Property[] props = templateField.getAnnotationsByType(Property.class);
                            if (props.length>0)
                            {
                                for (Property tp:props)
                                {
                                    boolean accessT = templateField.isAccessible();
                                    String tValue = tp.value();
                                    if (tValue.equals(""))
                                    {
                                        tValue=templateField.getName();
                                    }
                                    if (tValue.equals(pValue) && templateField.getType().equals(f.getType()))
                                    {
                                        templateField.setAccessible(true);
                                        templateField.set(this, f.get(data));
                                        templateField.setAccessible(accessT);
                                    }
                                }
                            }
                        }
                        f.setAccessible(access);
                    } 
                    catch (IllegalArgumentException | SecurityException | IllegalAccessException ex) 
                    {
                        Logger.getLogger(ObjectToTextConverter.class.getName()).log(Level.WARNING, null, ex);
                    }
                }
            }
        }
    }
}
