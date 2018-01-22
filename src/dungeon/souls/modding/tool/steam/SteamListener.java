/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

/**
 * Represents an entity that listens for changes on the Steam API.
 * @author Diogo
 */
public interface SteamListener
{
    /**
     * Called when steam is initialized.
     * @param initState The state of the initialization. True if successfully initialized.
     */
    public void onSteamInit(boolean initState);
}
