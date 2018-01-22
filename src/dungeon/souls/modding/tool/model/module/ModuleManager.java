/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

import dungeon.souls.modding.tool.ui.EditorMain;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a manager of modules (contains all "project" modules from user).
 * @author Diogo
 */
public class ModuleManager
{
    /**
     * The default base directory.
     */
    private static final File DEFAULT_BASE_DIRECTORY = new File("Dungeon Souls Modding Tool");
    
    /**
     * The base directory of the modding tool.
     */
    private File baseDirectory;
    
    /**
     * The projects of this manager.
     */
    private List<ModuleProject> projects;
    
    /**
     * Creates an empty ModuleManager.
     */
    public ModuleManager()
    {
        projects = new ArrayList();
        baseDirectory=DEFAULT_BASE_DIRECTORY;
        initManager();
    }
    
    /**
     * Creates an new {@link ModuleProject} contained in this manager.
     * @param name (String) The module's name.
     * @param template (CodeTemplate) The code template for the module.
     * @return ({@link ModuleProject}) The created module project.
     */
    public ModuleProject createModuleProject(String name,ModuleCodeTemplate template)
    {
        ModuleProject temp = new ModuleProject(name,template,baseDirectory);
        projects.add(temp);
        return temp;
    }
    
    /**
     * Returns all the projects handled by this module manager.
     * @return The list of all projects.
     */
    public List<ModuleProject> getAllProjects()
    {
        return projects;
    }
    
    @Override
    public String toString()
    {
        return "Projects";
    }
    
    /**
     * Initializes the manager tool.
     */
    private void initManager()
    {
        initializeDirectory();
        if (baseDirectory.exists())
        {
            recurseLoadProjects(baseDirectory);
        }
    }
    
    /**
     * Loads all projects under the editor's folder.
     * @param directory (File) The base directory to load from.
     */
    private void recurseLoadProjects(File directory) 
    {
        if (directory.isDirectory())
        {
            for (File element:directory.listFiles())
            {
                if (element.isDirectory())
                {
                    try
                    {
                        ModuleProject project = ModuleProject.Factory.createFromDirectory(element);
                        projects.add(project);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace(EditorMain.out);
                    }
                }
            }    
        }
    }
    
    /**
     * Initializes the tool's directory.
     */
    private void initializeDirectory()
    {
        if (baseDirectory!=null)
        {
            if (!baseDirectory.exists())
            {
                baseDirectory.mkdir();
            }
        }
    }
}
