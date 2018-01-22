/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import dungeon.souls.modding.tool.model.compiling.ModdingFile;
import dungeon.souls.modding.tool.model.item.ItemCodeTemplate;
import dungeon.souls.modding.tool.model.sprite.SpriteCodeTemplate;
import dungeon.souls.modding.tool.reflection.FileEditable;
import dungeon.souls.modding.tool.utils.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Represents a module project.
 * @author Diogo
 */
public class ModuleProject
{
    /**
     * The directory of the project.
     */
    private File directory;
    
    /**
     * This module's files. Module file is not included.
     */
    private List<ModdingFile> projectFiles;
    
    /**
     * The module of this project.
     */
    private ModdingFile module;
    
    /**
     * The name of this project.
     */
    private String name;
    
    //For factory methods only.
    private ModuleProject()
    {
        projectFiles = new ArrayList();
    }
    
    /**
     * Creates a module project with the specified parameters.
     * @param projectName (String) The name of this project.
     * @param template (ModuleCodeTemplate) The code template for the module.
     * @param baseDirectory (File) The base directory of the project.
     */
    public ModuleProject(String projectName, ModuleCodeTemplate template,File baseDirectory)
    {
        //this.module=new Module(projectName,moduleVersion);
        this.module = new ModdingFile(projectName+".dsmod",template);
        this.name=projectName;
        projectFiles = new ArrayList();
        this.directory=new File(baseDirectory.getAbsolutePath()+File.separator+name);
        initDirectory();
    }
    
    public String getName()
    {
        return name;
    }
    
    /**
     * Creates a new sprite asset for this project.
     * @param name (String) The name of the sprite.
     * @param template (SpriteCodeTemplate) The template of the sprite's code.
     * @return (ModdingFile) The file of the project.
     */
    public ModdingFile createNewSprite(String name, SpriteCodeTemplate template)
    {
        ModdingFile result = new ModdingFile(name+".dsspr", template);
        projectFiles.add(result);
        return result;
    }
    
    /**
     * Creates a new item asset for this project.
     * @param name (String) The name of the item.
     * @param template (ItemCodeTemplate) The template of the item's code.
     * @return (ModdingFile) The file of the project.
     */
    public ModdingFile createNewItem(String name, ItemCodeTemplate template)
    {
        ModdingFile result = new ModdingFile(name+".dsitem", template);
        projectFiles.add(result);
        return result;
    }
    
    /**
     * Returns the module file of this project.
     * @return (ModdingFile) The module file of this project.
     */
    public ModdingFile getModule()
    {
        return module;
    }
    
    /**
     * Loads all the files of this project module into the node.
     * @param baseNode (DefaultMutableTreeNode) The base node to add the files onto.
     */
    public void loadFilesAsNodes(DefaultMutableTreeNode baseNode)
    {
        baseNode.add(new DefaultMutableTreeNode(module));
        for (ModdingFile file:projectFiles)
        {
            baseNode.add(new DefaultMutableTreeNode(file));
        }
    }
    
    /**
     * Removes a file from this project directory.
     * @param file
     */
    public void removeFile(FileEditable file)
    {
        if (file instanceof ModdingFile)
        {
            projectFiles.remove((ModdingFile)file);
        }
    }
    
    /**
     * Deletes the project and all of its data.
     */
    public void delete()
    {
        Utilities.deleteDirectory(directory);
    }
    
    /**
     * Loads the module project.
     * @throws java.io.IOException
     */
    public void load() throws IOException
    {
        recurseLoad(directory);
    }
    
    /**
     * Recursively loads files on the project's directory.
     * Files are identified by their extension.
     * @param directory (File) The current folder being analyzed.
     */
    private void recurseLoad(File directory) throws IOException
    {
        if (directory.isDirectory())
        {
            File[] files = directory.listFiles();
            for (File f:files)
            {
                if (f.isFile())
                {
                    loadModelForFile(f);
                }
                else
                {
                    recurseLoad(f);
                }
            }
        }
    }
    
    /**
     * Loads the model object for the specified file.
     */
    private void loadModelForFile(File file) throws IOException
    {
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf(".")+1);
        if (extension!=null)
        {
            //Should be changed to use visitor pattern.
            if (extension.equals("dsmod")) //Module
            {
                if (module==null)
                {
                    module = ModdingFile.Factory.loadModdingFile(file,ModdingFile.FileType.MODULE);
                }
                else
                {
                    System.out.println("Two modding files found! Exception should be taken care of.");
                }
            }
            else if (extension.equals("dsitem")) //Item
            {
                projectFiles.add(ModdingFile.Factory.loadModdingFile(file,ModdingFile.FileType.ITEM));
            }
            else if (extension.equals("dsspr")) //Sprite asset
            {
                projectFiles.add(ModdingFile.Factory.loadModdingFile(file,ModdingFile.FileType.SPRITE));
            }
            else
            {
                //System.out.println("Unrecognized file... This exception should be taken care of!");
            }
        }
    }
    
    /**
     * Saves this project.
     */
    public void save()
    {
        try
        {
            for (ModdingFile file : projectFiles)
            {
                file.save(directory);
            }
            module.save(directory);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
    /**
     * Initializes the project directory.
     */
    private void initDirectory()
    {
        if (!directory.exists())
        {
            directory.mkdir();
        }
        File spriteDirectory=new File(directory.getAbsolutePath()+File.separator+"Sprites");
        if (!spriteDirectory.exists())
        {
            spriteDirectory.mkdir();
        }
    }

    /**
     * Merges all assets of this project into one string.
     * @return 
     */
    public String mergeCodeFiles()
    {
        String result = "";
        result+=module.contentToTextPane().getText();
        for (ModdingFile file:projectFiles)
        {
            result+="\n"+file.contentToTextPane().getText();
        }
        return result;
    }

    /**
     * Returns the directory of the project.
     * @return 
     */
    public File getDirectory()
    {
        return directory;
    }
    
    /**
     * Factory class.
     */
    public static final class Factory
    {
        private Factory() {}
        
        public static ModuleProject createFromDirectory(File directory) throws IOException
        {
            ModuleProject result=null;
            if (directory.isDirectory())
            {
                result = new ModuleProject();
                result.directory=directory;
                result.name = directory.getName();
                result.load();
            }
            return result;
        }
    }
}
