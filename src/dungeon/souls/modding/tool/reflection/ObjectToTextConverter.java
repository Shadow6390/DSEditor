/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.reflection;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service responsible for convert objects to text using annotations.
 * @author Diogo
 */
public final class ObjectToTextConverter
{
    //Make this class a library.
    private ObjectToTextConverter()
    {
        
    }
    
    /**
     * Converts specific annotations (@Property) from an object into a string.
     * @param o (Object) The object to convert.
     * @return (String) The annotations in text.
     */
    public static String toText(Object o)
    {
        String result = "";
        for (Field f:o.getClass().getDeclaredFields())
        {
            Property[] properties = f.getAnnotationsByType(Property.class);
            if (properties.length>0)
            {
                for (Property p:properties)
                {
                    String value = p.value();
                    if (value.equals("")) //Special auto-complete case.
                    {
                        value = f.getName().toUpperCase();
                    }
                    try 
                    {
                        f.setAccessible(true);
                        Object val = f.get(o);
                        if (val!=null)
                        {
                            String extraMarks = "";
                            if (f.getType().equals(String.class) && !p.ignoreType())
                            {
                                extraMarks="\"";
                            }
                            result+="["+value+"]="+extraMarks+val+extraMarks+"\n"; 
                        }
                        else
                        {
                            result+="//["+value+"]\n"; 
                        }
                    } catch (IllegalArgumentException | SecurityException | IllegalAccessException ex) {
                        Logger.getLogger(ObjectToTextConverter.class.getName()).log(Level.WARNING, null, ex);
                    }
                }
            }
        }
        return result;
    }
}
