/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a module that has been uploaded to the Steam Workshop,
 * thus possessing an ItemID.
 * @author Diogo
 */
@XmlRootElement
public class SteamWorkshopModule
{
    /**
     * The name of the module.
     */
    private String moduleName;
    
    /**
     * The title of the Workshop module.
     */
    private String title;
    
    /**
     * The description of the Workshop module.
     */
    private String description;
    
    /**
     * The preview of the Workshop module.
     */
    private String preview;
    
    /**
     * The id of the item.
     */
    private long steamItemID;
    
    /**
     * JAXB ONLY!
     */
    public SteamWorkshopModule()
    {
        
    }
    
    /**
     * Creates a Steam Workshop Module with the specified parameters.
     * @param moduleName The name of the module.
     * @param steamItemID The id of the item on steam's workshop.
     */
    public SteamWorkshopModule(String moduleName,long steamItemID)
    {
        this.moduleName=moduleName;
        this.steamItemID=steamItemID;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName()
    {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    @XmlElement
    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    /**
     * @return the steamItemID
     */
    public long getSteamItemID()
    {
        return steamItemID;
    }

    /**
     * @param steamItemID the steamItemID to set
     */
    @XmlElement
    public void setSteamItemID(long steamItemID)
    {
        this.steamItemID = steamItemID;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    @XmlElement
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    @XmlElement
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the preview
     */
    public String getPreview()
    {
        return preview;
    }

    /**
     * @param preview the preview to set
     */
    @XmlElement
    public void setPreview(String preview)
    {
        this.preview = preview;
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = other != null && getClass().isInstance(other);
        if (result)
        {
            SteamWorkshopModule ob = getClass().cast(other);
            result = (this == other) || (steamItemID==ob.steamItemID);
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 17 * hash + (int) (this.steamItemID ^ (this.steamItemID >>> 32));
        return hash;
    }
}
