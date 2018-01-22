/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import java.util.Objects;

/**
 *
 * @author Diogo
 * @param <T>
 * @param <V>
 */
public class Tuple<T,V>
{
    public T first;
    public V second;
    
    public Tuple(T first,V second)
    {
        this.first=first;
        this.second=second;
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = other != null && getClass().isInstance(other);
        if (result)
        {
            Tuple ob = getClass().cast(other);
            result = (this == other) || (first.equals(ob.first) && second.equals(ob.second));
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.first);
        hash = 97 * hash + Objects.hashCode(this.second);
        return hash;
    }
}
