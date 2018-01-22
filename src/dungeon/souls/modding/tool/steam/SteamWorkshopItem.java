/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

import com.codedisaster.steamworks.SteamRemoteStorage;

/**
 * Represents a Steam workshop item.
 * @author Diogo
 */
public interface SteamWorkshopItem
{
    /**
     * Checks whether this Steam Workshop Item is of the given type.
     * @param type The steam workshop file type constants defined by the SDK
     * @return True if it is of the type.
     */
    public boolean isType(SteamRemoteStorage.WorkshopFileType type);
    
    /**
     * Does all the necessary steps for uploading the file to workshop.
     */
    public void uploadFile();
}
