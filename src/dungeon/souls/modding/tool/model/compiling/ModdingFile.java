/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling;

import dungeon.souls.modding.tool.model.item.ItemCodeTemplate;
import dungeon.souls.modding.tool.model.module.ModuleCodeTemplate;
import dungeon.souls.modding.tool.model.module.SaveListener;
import dungeon.souls.modding.tool.model.sprite.SpriteCodeTemplate;
import dungeon.souls.modding.tool.reflection.FileEditable;
import dungeon.souls.modding.tool.ui.DungeonSoulsBaseCodeHighlighter;
import dungeon.souls.modding.tool.ui.JCodePane;
import dungeon.souls.modding.tool.utils.Utilities;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.undo.UndoManager;

/**
 * Represents an opened file of the IDE.
 * @author Diogo
 */
public class ModdingFile implements FileEditable
{
    
    public static enum FileType
    {
        MODULE,SPRITE,ITEM,NONE
    }
    /**
     * The code template of this class.
     */
    private CodeTemplate template;
    /**
     * The code pane used to edit this module.
     */
    private JCodePane codePane;
    
    /**
     * The file where this module is stored.
     */
    private File file;
    
    /**
     * The type of the file.
     * Defaults to NONE.
     */
    private FileType type=FileType.NONE;
    
    /**
     * Whether changes to this file were recently saved.
     */
    private boolean recentlySaved;
    
    /**
     * Represents listeners that listen for saving events.
     */
    private List<SaveListener> saveListeners;
        
    /**
     * Used for loading
     */
    private ModdingFile()
    {
        this((String)null,null);
    }
    
    public ModdingFile(String filename)
    {
        this(filename,null);
    }
    
    public ModdingFile(String filename,CodeTemplate template)
    {
        this(new File(filename),template);
    }
    
    public ModdingFile(File file)
    {
        this(file,null);
    }
    
    public ModdingFile(File file,CodeTemplate template)
    {
        this.file=file;
        this.template=template;
        recentlySaved=true;
        saveListeners = new LinkedList<>();
    }
    
    /**
     * Adds a new save listener to this modding file.
     * @param l The save listener to add that will listen for save events of this file.
     * @return True if successfully added.
     */
    @Override
    public boolean addSaveListener(SaveListener l)
    {
        return saveListeners.add(l);
    }
    
    /**
     * Checks whether this modding file contains the specified save listener.
     * @param l The listener to check for.
     * @return True if the listener has already been added.
     */
    @Override
    public boolean contains(SaveListener l)
    {
        return saveListeners.contains(l);
    }
    
    @Override
    public void delete()
    {
        if (file!=null)
        {
            file.delete();
        }
    }
    
    /**
     * Returns the filename of this module.
     * @return (String) The filename of the module.
     */
    @Override
    public String getFileName()
    {
        
        return file.getName();
    }
    
    @Override
    public String toString()
    {
        String extra = "";
        if (!recentlySaved)
        {
            extra = "*";
        }
        return file.getName()+extra;
    }

    @Override
    public JComponent contentToComponent()
    {
        if (codePane==null)
        {
            this.codePane = new JCodePane(new DungeonSoulsBaseCodeHighlighter(template));
            String code = "";
            if (template!=null)
            {
                code=template.getTemplateCode();
            }
            codePane.setText(code);
            codePane.getDocument().addUndoableEditListener(new UndoManager());
        }
        return codePane;
    }

    @Override
    public void save(File parentDirectory) throws IOException
    {
        File storedFile = new File(parentDirectory.getAbsolutePath()+File.separator+file.getName());
        BufferedWriter writer = new BufferedWriter(new FileWriter(storedFile,false));
        JComponent component = contentToComponent();
        if (component instanceof JTextPane)
        {
            for (String line:((JTextPane)component).getText().split("\n"))
            {
                writer.append(line);
                writer.newLine();
            }
            recentlySaved=true;
            writer.close();
            saveListeners.stream().forEach((elem) ->
            {
                elem.onSave(this);
            });
        }
    }
    
    /**
     * Factory class that constructs modding files.
     */
    public static class Factory
    {
        /**
         * Loads a modding file from a system file.
         * @param location (File) The location of the modding file.
         * @param type (FileType) The type of file the modding file represents.
         * @return (ModdingFile) The modding file.
         * @throws IOException 
         */
        public static ModdingFile loadModdingFile(File location,FileType type) throws IOException
        {
            ModdingFile result = new ModdingFile(location.getName());
            result.type = type;
            switch (type)
            {
                case MODULE:
                    result.template=new ModuleCodeTemplate();
                    break;
                case SPRITE:
                    result.template=new SpriteCodeTemplate("");
                    break;
                case ITEM:
                    result.template=new ItemCodeTemplate();
                    break;
            }
            JComponent component=result.contentToComponent();
            if (component instanceof JTextPane)
            {
                ((JTextPane)component).setText(Utilities.fileAsString(location));
            }
            result.recentlySaved=true;
            return result;
        }
    }
}

