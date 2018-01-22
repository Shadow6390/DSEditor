/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import java.util.Objects;

/**
 * Represents a content node.
 * A content node is a node which holds an element
 * and can reference a previous node and a next node.
 * @author Diogo
 */
public class ContentNode<E>
{
    /**
     * Previous node.
     */
    private ContentNode<E> previous;
    
    /**
     * Next node.
     */
    private ContentNode<E> next;
    
    private E element;
    
    public ContentNode(E e)
    {
        element = e;
    }
    
    public E getElement()
    {
        return element;
    }

    /**
     * @return the previous
     */
    public ContentNode<E> getPrevious()
    {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(ContentNode<E> previous)
    {
        this.previous = previous;
    }

    /**
     * @return the next
     */
    public ContentNode<E> getNext()
    {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(ContentNode<E> next)
    {
        this.next = next;
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = other != null && getClass().isInstance(other);
        if (result)
        {
            ContentNode ob = getClass().cast(other);
            result = (this == other) || (element.equals(ob.element));
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.element);
        return hash;
    }
}
