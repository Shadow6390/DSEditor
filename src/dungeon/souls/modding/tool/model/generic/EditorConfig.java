/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.generic;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * The editor's configurations.
 * @author Diogo
 */
public final class EditorConfig
{
    private static EditorConfig instance;
    
    private static final String EDITOR_CONFIG_FILE = "editor_config.xml";
    
    public static final String EDITOR_VERSION="0.8.0";
    
    /**
     * The current documentation version.
     */
    public static final int DOCUMENTATION_VERSION = 1;
    
    /**
     * A house that contains data.
     */
    private EditorData dataHouse;
    
    //Private constructor for protection.
    private EditorConfig()
    {
        try
        {
            loadData();
        }
        catch (JAXBException ex)
        {
            Logger.getLogger(EditorConfig.class.getName()).log(Level.SEVERE, null, ex);
            dataHouse = new EditorData();
            dataHouse.lastEditorVersion=EDITOR_VERSION;
        }
    }
    
    /**
     * Fetches the instance of EditorConfig.
     * @return The Editor Configuration.
     */
    public static EditorConfig getInstance()
    {
        if(instance==null) //don't want to block here
        {
            //two or more threads might be here!!!
            synchronized(EditorConfig.class)
            {
                //must check again as one of the
                //blocked threads can still enter
                if(instance==null)
                {
                  instance= new EditorConfig();//safe
                }
            }
        }
        return instance;
    }
    
    /**
     * Returns the documentation version stored in the config file.
     * @return The documentation version.
     */
    public int getDocumentationVersion()
    {
        return dataHouse.documentationVersion;
    }
    
    /**
     * Sets the documentation version of the editor config file.
     */
    public void setDocumentationVersion(int version)
    {
        dataHouse.documentationVersion=version;
    }
    
    /**
     * Loads Steam data from the tool.
     */
    private void loadData() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(EditorData.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        dataHouse = (EditorData) jaxbUnmarshaller.unmarshal( new File(EDITOR_CONFIG_FILE) );
    }
    
    /**
     * Save Steam data from the tool.
     * For this function to work, Steam must be initialized.
     * @throws javax.xml.bind.JAXBException
     */
    public void saveData() throws JAXBException
    {
        if (dataHouse!=null)
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(EditorData.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(dataHouse, new File(EDITOR_CONFIG_FILE));
        }
    }
}
