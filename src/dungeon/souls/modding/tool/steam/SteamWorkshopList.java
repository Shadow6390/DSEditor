/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a list of Steam Workshop modules.
 * @author Diogo
 */
@XmlRootElement
public class SteamWorkshopList
{
    /**
     * The list of modules that have been uploaded to Steam.
     */
    @XmlElementWrapper(name="workshopModules")
    @XmlElement(name="module")
    private List<SteamWorkshopModule> modules;
    
    public SteamWorkshopList()
    {
        modules = new ArrayList<>();
    }
    
    /**
     * Adds an existing Steam Workshop module to this list.
     * @param m
     * @return 
     */
    public boolean addSteamWorkshopModule(SteamWorkshopModule m)
    {
        return modules.add(m);
    }
    
    /**
     * Returns the Steam Workshop module specified by the project module name.
     * @param moduleName The name of the project.
     * @return Returns null if none were found.
     */
    public SteamWorkshopModule getSteamWorkshopModule(String moduleName)
    {
        SteamWorkshopModule result = null;
        SteamWorkshopModule temp;
        for (int i=0;i<modules.size() && result==null;i++)
        {
            temp = modules.get(i);
            if (temp.getModuleName().equals(moduleName))
            {
                result = temp;
            }
        }
        return result;
    }
    
    /**
     * Returns the Steam Workshop module specified by the index.
     * @param i
     * @return 
     */
    public SteamWorkshopModule getSteamWorkshopModule(int i)
    {
        return modules.get(i);
    }
    
    /**
     * Returns the size of this list.
     * @return 
     */
    public int size()
    {
        return modules.size();
    }
}
