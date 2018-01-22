/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.reflection;

import dungeon.souls.modding.tool.model.module.SaveListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextPane;

/**
 * Represents an entity that can be edited in a textfile-like method.
 * @author Diogo
 */
public interface FileEditable
{
    /**
     * Converts the contents of the class into a text pane, containing data
     * that can be written into a textfile.
     * @return (JTextPane) The text pane with the information of the class.
     */
    public JTextPane contentToTextPane();
    
    /**
     * Saves this class into a file.
     * @param parentDirectory (File) The parent directory where this class can store data.
     * @throws java.io.IOException
     */
    public void save(File parentDirectory) throws IOException;
    
    /**
     * Saves this class into a file.
     * @param storage (File) The parent directory where this class can store data.
     * @throws java.io.IOException
     */
    //public void load(File storage) throws IOException;
    
    /**
     * Adds a new save listener to this modding file.
     * @param l The save listener to add that will listen for save events of this file.
     * @return True if successfully added.
     */
    public boolean addSaveListener(SaveListener l);
    
    /**
     * Checks whether this modding file contains the specified save listener.
     * @param l The listener to check for.
     * @return True if the listener has already been added.
     */
    public boolean contains(SaveListener l);
    
    /**
     * Deletes this current file.
     */
    public void delete();
}
