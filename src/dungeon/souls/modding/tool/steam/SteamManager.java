/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

import com.codedisaster.steamworks.SteamAPI;
import com.codedisaster.steamworks.SteamException;
import dungeon.souls.modding.tool.ui.EditorMain;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * A manager that is responsible for all actions related to Steam.
 * This class is mostly used for workshop related actions.
 * @author Diogo
 */
public class SteamManager
{
    
    private static SteamManager instance;
    
    /**
     * Listeners for changes on the Steam status.
     */
    private List<SteamListener> listeners;
    
    /**
     * The list of modules that are compatible with Steam workshop 
     * (i.e. have already been uploaded to the Steam Workshop).
     */
    private SteamWorkshopList moduleList;
    
    /**
     * Should be changed to be encrypted.
     */
    public static final int STEAM_APP_ID=383230;
    
    /**
     * Initialization state of Steam API.
     */
    private boolean initialized;
    
    /**
     * Whether the callback loop was initizlied or not.
     */
    private boolean callbackLoopInitialized;
    
    /**
     * Icon to display when a steam workshop project is open.
     */
    private ImageIcon openIcon;
    
    /**
     * Icon to display when a steam workshop project is closed.
     */
    private ImageIcon closedIcon;
    
    /**
     * The file where the editor's Steam data is kept.
     */
    private static final String STEAM_EDITOR_DATA_FILE="editor_steam.xml";
    
    /**
     * Initializes the manager.
     */
    private SteamManager()
    {
        initialized=false;
        listeners = new LinkedList<>();
        moduleList = new SteamWorkshopList();
    }
    
    /**
     * Fetches the instance of SteamManager.
     * @return The Steam manager.
     */
    public static SteamManager getInstance()
    {
        if(instance==null) //don't want to block here
        {
            //two or more threads might be here!!!
            synchronized(SteamManager.class)
            {
                //must check again as one of the
                //blocked threads can still enter
                if(instance==null)
                {
                  instance= new SteamManager();//safe
                }
            }
        }
        return instance;
    }
    
    /**
     * Adds a Steam listener to this Steam Manager.
     * @param listener The steam listener to add.
     * @return True if successfully added.
     */
    public boolean addSteamListener(SteamListener listener)
    {
        return listeners.add(listener);
    }
    
    /**
     * Returns the icon for open steam projects.
     * @return The image icon for open projects.
     */
    public ImageIcon getOpenProjectIcon()
    {
        if (openIcon==null)
        {
            try
            {
                openIcon=new ImageIcon(ImageIO.read(EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/spr_Steam_Project_Open.png"))
                .getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            }
            catch (IOException ex)
            {
                Logger.getLogger(SteamManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return openIcon;
    }
    
    /**
     * Returns the icon for closed steam projects.
     * @return The image icon for closed projects.
     */
    public ImageIcon getClosedProjectIcon()
    {
        if (closedIcon==null)
        {
            try
            {
                closedIcon=new ImageIcon(ImageIO.read(EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/spr_Steam_Project_Closed.png"))
                .getScaledInstance(16, 16, Image.SCALE_DEFAULT));
            }
            catch (IOException ex)
            {
                Logger.getLogger(SteamManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return closedIcon;
    }
    
    /**
     * Initializes the Steam API.
     * @return True if successfully initialized.
     * @throws java.io.IOException
     * @throws com.codedisaster.steamworks.SteamException
     */
    public boolean initializeSteam() throws IOException,SteamException
    {
        boolean result = false;
        File file = new File("steam_appid.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(String.valueOf(STEAM_APP_ID));
        writer.close();
        result=SteamAPI.init();
        initialized=result;
        listeners.stream().forEach((sl) ->
        {
            sl.onSteamInit(initialized);
        });
        file.delete();
        try
        {
            loadData();
        }
        catch (JAXBException e)
        {
            EditorMain.out.println("Warning: No Steam Workshop modules were present during loading (ignore this message if you haven't uploaded any modules yet!)");
        }
        return result;
    }
    
    /**
     * Loads Steam data from the tool.
     */
    private void loadData() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(SteamWorkshopList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        moduleList = (SteamWorkshopList) jaxbUnmarshaller.unmarshal( new File(STEAM_EDITOR_DATA_FILE) );
    }
    
    /**
     * Save Steam data from the tool.
     * For this function to work, Steam must be initialized.
     * @throws javax.xml.bind.JAXBException
     */
    public void saveData() throws JAXBException
    {
        if (initialized)
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(SteamWorkshopList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(moduleList, new File(STEAM_EDITOR_DATA_FILE));
        }
    }
    
    /**
     * Opens a new browser that requests the user to accept the workshop agreement.
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public void redirectToLicenseAgreement() throws IOException, URISyntaxException
    {
        Desktop.getDesktop().browse(new URI("http://steamcommunity.com/sharedfiles/workshoplegalagreement"));
    }
    
    /**
     * Initializes the loop that will handle callback activation.
     * Steam must be initialized.
     */
    public void initCallbackLoop() throws IllegalStateException
    {
        if (initialized)
        {
            if (!callbackLoopInitialized)
            {
                callbackLoopInitialized=true;
                Timer timer = new Timer(40, (ActionEvent e) ->
                {
                    SteamAPI.runCallbacks();
                });
                timer.setRepeats(true);
                timer.start();
            }
            else
            {
                throw new IllegalStateException("Callback loop already initialized.");
            }
        }
        else
        {
            throw new IllegalStateException("Steam API is not initialized.");
        }
    }

    public void synchronizeWorkshopProjects()
    {
         // TODO add your handling code here:
        /*final SteamUGC ugc = new SteamUGC(new SteamUGCCallback()
        {

            @Override
            public void onUGCQueryCompleted(SteamUGCQuery sugcq, int numberResults, int numberMatchedResults, boolean bln, SteamResult sr)
            {
                if (sr.equals(SteamResult.OK))
                {
                    if (numberResults>0)
                    {
                        SteamUGCDetails details = new SteamUGCDetails();
                        for (int i=0;i<numberResults;i++) //Will only fetch first 50 of the app-
                        {
                            ugc.getQueryUGCResult(sugcq, i, details);
                            if (details.getFileType()==SteamRemoteStorage.WorkshopFileType.Community) //If it's a project module
                            {
                                SteamWorkshopModule module = new SteamWorkshopModule();
                            }          
                        }
                    }
                }
                else
                {
                    out.println("Unexpected error occured: "+sr);
                }
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onSubmitItemUpdate(SteamPublishedFileID spfid, boolean bln, SteamResult sr)
            {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        });
        SteamID id = new SteamID();
        SteamUGCQuery query = ugc.createQueryUserUGCRequest(id.getAccountID(), 
                SteamUGC.UserUGCList.Published, SteamUGC.MatchingUGCType.All, SteamUGC.UserUGCListSortOrder.CreationOrderAsc, 
                SteamManager.STEAM_APP_ID, SteamManager.STEAM_APP_ID, 1);
        ugc.sendQueryUGCRequest(query);*/
    }
    
    /**
     * Whether the API was successfully initialized or not.
     * @return 
     */
    public boolean isAPIInitialized()
    {
        return initialized;
    }

    /**
     * @return the moduleList
     */
    public SteamWorkshopList getModuleList()
    {
        return moduleList;
    }
    
}
