/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import dungeon.souls.modding.tool.model.compiling.ModdingFile;
import dungeon.souls.modding.tool.model.generic.ImageFile;
import dungeon.souls.modding.tool.model.item.ItemCodeTemplate;
import dungeon.souls.modding.tool.model.sprite.SpriteCodeTemplate;
import dungeon.souls.modding.tool.reflection.FileEditable;
import dungeon.souls.modding.tool.ui.EditorMain;
import dungeon.souls.modding.tool.utils.Utilities;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
     * This module's list of unrelated files. These can be any files that have
     * no special meaning to the modding context, such as image files and audio.
     */
    private List<FileEditable> otherFiles;
    
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
        projectFiles = new ArrayList<>();
        otherFiles = new ArrayList<>();
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
        projectFiles = new ArrayList<>();
        otherFiles = new ArrayList<>();
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
     * Loads the images contained in the specified files onto the base directory.
     * @param base The base directory to copy the images to.
     * @param images An array with the image files to copy.
     * @return The image files that have been successfully added to the project.
     */
    public List<FileEditable> loadImages(File base,File[] images)
    {
        List<FileEditable> result = new LinkedList<>();
        for (File element:images)
        {
            try
            {
                Path path = Files.copy(element.toPath(), new File(base.getAbsolutePath()+File.separator+element.getName()).toPath(), REPLACE_EXISTING);
                FileEditable file = new ImageFile(path.toFile());
                otherFiles.add(file);
                result.add(file);
                EditorMain.out.println("Added image '"+element.getName()+"' to the project's sprite repository (/Sprites).");
            }
            catch (IOException ex)
            {
                EditorMain.out.println("Error adding image '"+element.getName()+"': "+ex.getMessage());
            }
        }
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
     * @param model The tree model to add to. If null, nodes will be added to the baseNode.
     */
    public void loadFilesAsNodes(DefaultMutableTreeNode baseNode,DefaultTreeModel model)
    {
        int count=0;
        if (model==null)
        {
            baseNode.add(new DefaultMutableTreeNode(module));
        }
        else
        {
            model.insertNodeInto(new DefaultMutableTreeNode(module), baseNode, count);
            count++;
        }
        for (ModdingFile file:projectFiles)
        {
            if (model==null)
            {
                baseNode.add(new DefaultMutableTreeNode(file));
            }
            else
            {
                model.insertNodeInto(new DefaultMutableTreeNode(file), baseNode, count);
                count++;
            }
        }
        for (FileEditable file:otherFiles)
        {
            if (model==null)
            {
                baseNode.add(new DefaultMutableTreeNode(file));
            }
            else
            {
                model.insertNodeInto(new DefaultMutableTreeNode(file), baseNode, count);
                count++;
            }
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
            if (ExtensionManager.getInstance().isExtensionModuleFile(extension)) //Module
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
            else if (ExtensionManager.getInstance().isExtensionItemFile(extension)) //Item
            {
                projectFiles.add(ModdingFile.Factory.loadModdingFile(file,ModdingFile.FileType.ITEM));
            }
            else if (ExtensionManager.getInstance().isExtensionSpriteFile(extension)) //Sprite asset
            {
                projectFiles.add(ModdingFile.Factory.loadModdingFile(file,ModdingFile.FileType.SPRITE));
            }
            else if (ExtensionManager.getInstance().isExtensionImage(extension))
            {
                otherFiles.add(new ImageFile(file));
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
        result+=((JTextPane)module.contentToComponent()).getText();
        for (ModdingFile file:projectFiles)
        {
            JComponent component = file.contentToComponent();
            if (component instanceof JTextPane)
            {
                result+="\n"+((JTextPane)component).getText();
            }
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
