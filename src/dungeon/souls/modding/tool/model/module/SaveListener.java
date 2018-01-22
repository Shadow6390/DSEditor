/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

/**
 * Represents an entity that listens for saves of a specified object.
 * @author Diogo
 */
public interface SaveListener
{
    /**
     * Fired when the object is saving.
     * @param o The object that was saved.
     */
    public void onSave(Object o);
}
