/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

import com.codedisaster.steamworks.SteamFriends;
import com.codedisaster.steamworks.SteamFriendsCallback;
import com.codedisaster.steamworks.SteamID;
import com.codedisaster.steamworks.SteamPublishedFileID;
import com.codedisaster.steamworks.SteamRemoteStorage;
import com.codedisaster.steamworks.SteamResult;
import com.codedisaster.steamworks.SteamUGC;
import com.codedisaster.steamworks.SteamUGCCallback;
import com.codedisaster.steamworks.SteamUGCDetails;
import com.codedisaster.steamworks.SteamUGCQuery;
import com.codedisaster.steamworks.SteamUGCUpdateHandle;
import dungeon.souls.modding.tool.ui.EditorMain;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a community item from Steam Workshop.
 * @author Diogo
 */
public class SteamWorkshopCommunityItem implements SteamWorkshopItem
{

    /**
     * The attributes that are settable for this community item.
     */
    public static enum ATTRIBUTES
    {
        TITLE,DESCRIPTION,CONTENT,ITEM_PREVIEW,CHANGE_LOG
    }
    
    /**
     * The UGC to use for issuing commands.
     */
    private SteamUGC ugc;
    
    /**
     * The data to populate the item with.
     */
    private Map<String,String> data;
    
    /**
     * The name of the module.
     */
    private String moduleName;
    
    /**
     * Creates a new Steam workshop community item.
     * @param moduleName
     */
    public SteamWorkshopCommunityItem(String moduleName)
    {
        ugc = new SteamUGC(new UGCCallBackImpl());
        data = new LinkedHashMap<>();
        this.moduleName=moduleName;
    }
    
    /**
     * Puts a value onto the attribute map.
     * @param key The attribute to set.
     * @param value The value of the attribute.
     * @return 
     */
    public String put(ATTRIBUTES key,String value)
    {
        return data.put(key.name(),value);
    }
    
    /**
     * Private implementation to protect event methods.
     */
    private class UGCCallBackImpl implements SteamUGCCallback
    {
        @Override
        public void onUGCQueryCompleted(SteamUGCQuery sugcq, int i, int i1, boolean bln, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSubscribeItem(SteamPublishedFileID spfid, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onUnsubscribeItem(SteamPublishedFileID spfid, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onRequestUGCDetails(SteamUGCDetails sugcd, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onCreateItem(SteamPublishedFileID spfid, boolean bln, SteamResult sr)
        {
            if (sr.equals(SteamResult.OK))
            {
                SteamWorkshopModule module = new SteamWorkshopModule(moduleName, Integer.parseInt(spfid.toString(),16));
                SteamManager.getInstance().getModuleList().addSteamWorkshopModule(module);
                EditorMain.out.println("Item created successfully (ID="+spfid+")");
                submitFileUpload(module);
            }
            else
            {
                if (bln)
                {
                    try
                    {
                        SteamManager.getInstance().redirectToLicenseAgreement();
                    }
                    catch (IOException | URISyntaxException ex)
                    {
                        EditorMain.out.println(ex.getMessage());
                    }
                }
            }
        }

        @Override
        public void onSubmitItemUpdate(SteamPublishedFileID spfid, boolean bln, SteamResult sr)
        {
            if (sr.equals(SteamResult.OK))
            {
                EditorMain.out.println("Item published successfully.");
                SteamFriends friends = new SteamFriends(new SteamFriendsCallback()
                {

                    @Override
                    public void onSetPersonaNameResponse(boolean bln, boolean bln1, SteamResult sr)
                    {
                        
                    }

                    @Override
                    public void onPersonaStateChange(SteamID sid, SteamFriends.PersonaChange pc)
                    {
                        
                    }

                    @Override
                    public void onGameOverlayActivated(boolean bln)
                    {
                        System.out.println("Boop.");
                    }

                    @Override
                    public void onGameLobbyJoinRequested(SteamID sid, SteamID sid1)
                    {
                        
                    }

                    @Override
                    public void onAvatarImageLoaded(SteamID sid, int i, int i1, int i2)
                    {
                        
                    }

                    @Override
                    public void onFriendRichPresenceUpdate(SteamID sid, int i)
                    {
                        
                    }

                    @Override
                    public void onGameRichPresenceJoinRequested(SteamID sid, String string)
                    {
                        
                    }

                    @Override
                    public void onGameServerChangeRequested(String string, String string1)
                    {
                        
                    }
                });
                friends.activateGameOverlayToWebPage("steam://url/CommunityFilePage/"+spfid);
            }
            else
            {
                EditorMain.out.println("Error "+sr.toString()+": "+getReason(sr));
                if (bln)
                {
                    try
                    {
                        SteamManager.getInstance().redirectToLicenseAgreement();
                    }
                    catch (IOException | URISyntaxException ex)
                    {
                        EditorMain.out.println(ex.getMessage());
                    }
                }
            }
        }

        @Override
        public void onDownloadItemResult(int i, SteamPublishedFileID spfid, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onUserFavoriteItemsListChanged(SteamPublishedFileID spfid, boolean bln, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onSetUserItemVote(SteamPublishedFileID spfid, boolean bln, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onGetUserItemVote(SteamPublishedFileID spfid, boolean bln, boolean bln1, boolean bln2, SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onStartPlaytimeTracking(SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onStopPlaytimeTracking(SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onStopPlaytimeTrackingForAllItems(SteamResult sr)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        /**
         * Gets the reason a steam result failed, for this context only.
         * @param sr The Steam Result to check.
         * @return The information of the error.
         */
        private String getReason(SteamResult sr)
        {
            String result = "Unknown reason.";
            if (sr.equals(SteamResult.Fail))
            {
                result = "Generic failure.";
            }
            else if (sr.equals(SteamResult.InvalidParam))
            {
                result = "Mismatch error in app ID related configurations, or\n" +
                    "the preview file is smaller than 16 bytes.";
            }
            else if (sr.equals(SteamResult.AccessDenied))
            {
                result = "Logged in user doesn't own a license for the provided app ID.";
            }
            else if (sr.equals(SteamResult.FileNotFound))
            {
                result = "Failed to get the workshop info for the item or failed to read the preview file.\n"
                        + "The provided content folder may also be missing.";
            }
            else if (sr.equals(SteamResult.LockingFailed))
            {
                result = "Failed to acquire lock";
            }
            else if (sr.equals(SteamResult.LimitExceeded))
            {
                result = "The preview image is too large, it must be less than 1 Megabyte;"
                        + "\nIt is also possible that there isn't enough space available on the user's Steam Cloud.";
            }
            return result;
        }
    }
    
    @Override
    public boolean isType(SteamRemoteStorage.WorkshopFileType type)
    {
        return type.equals(SteamRemoteStorage.WorkshopFileType.Collection);
    }

    @Override
    public void uploadFile()
    {
        SteamWorkshopList list = SteamManager.getInstance().getModuleList();
        SteamWorkshopModule module = list.getSteamWorkshopModule(moduleName);
        if (module==null) //If we don't have it, create it.
        {
            ugc.createItem(SteamManager.STEAM_APP_ID, SteamRemoteStorage.WorkshopFileType.Community);
        }
        else
        {
            submitFileUpload(module);
        }
    }
    
    /**
     * Submits the file and uploads it.
     * @param module 
     */
    private void submitFileUpload(SteamWorkshopModule module)
    {
        if (!isValid())
        {
            throw new IllegalStateException("Item is not valid for upload.");
        }
        else
        {
            SteamUGCUpdateHandle handle = ugc.startItemUpdate(SteamManager.STEAM_APP_ID, new SteamPublishedFileID(module.getSteamItemID()));
            ugc.setItemContent(handle, data.get(ATTRIBUTES.CONTENT.name()));
            ugc.setItemTitle(handle, data.get(ATTRIBUTES.TITLE.name()));
            if (data.containsKey(ATTRIBUTES.DESCRIPTION.name()))
            {
                ugc.setItemDescription(handle, data.get(ATTRIBUTES.DESCRIPTION.name()));
            }
            if (data.containsKey(ATTRIBUTES.ITEM_PREVIEW.name()))
            {
                ugc.setItemPreview(handle, data.get(ATTRIBUTES.ITEM_PREVIEW.name()));
            }
            ugc.submitItemUpdate(handle, data.get(ATTRIBUTES.CHANGE_LOG.name()));

            //Construct module data for later usages:
            module.setTitle(data.get(ATTRIBUTES.TITLE.name()));
            module.setDescription(data.get(ATTRIBUTES.DESCRIPTION.name()));
            module.setPreview(data.get(ATTRIBUTES.ITEM_PREVIEW.name()));
        }
    }
    
    /**
     * Returns whether the fields of this item are valid,
     * validating the state of the item for uploading.
     * @return True if item is valid and can be uploaded
     */
    private boolean isValid()
    {
        return data.containsKey(ATTRIBUTES.TITLE.name()) && data.containsKey(ATTRIBUTES.CONTENT.name());
    }
}
