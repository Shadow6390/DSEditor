/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.utils;

import javax.swing.text.Document;

/**
 * Represents a change in the document's text.
 * @author Diogo
 */
public interface DocumentTextChange
{
    /**
     * Forces this change to undo itself on the specified document.
     * @param doc 
     */
    public void undo(Document doc);
    
    /**
     * Forces this change to redo itself on the specified document.
     * @param doc 
     */
    public void redo(Document doc);
}
