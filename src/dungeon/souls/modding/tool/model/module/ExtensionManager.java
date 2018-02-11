/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.module;

/**
 * Responsible for managing the different extensions of the editor.
 * @author Diogo
 */
public final class ExtensionManager
{
    /**
     * The manager instance.
     */
    private static ExtensionManager instance;
    
    private ExtensionManager()
    {
        
    }
    
    
    /**
     * Fetches the instance of ExtensionManager.
     * @return The extension manager.
     */
    public static ExtensionManager getInstance()
    {
        if (instance==null) //don't want to block here
        {
            //two or more threads might be here!!!
            synchronized(ExtensionManager.class)
            {
                //must check again as one of the
                //blocked threads can still enter
                if(instance==null)
                {
                  instance= new ExtensionManager();//safe
                }
            }
        }
        return instance;
    }
    
    /**
     * Checks if the specified extension is a sprite file extension.
     * @param extension The extension to check.
     * @return True if it is a valid sprite extension.
     */
    public boolean isExtensionSpriteFile(String extension)
    {
        return extension!=null && extension.equals("dsspr");
    }
    
    /**
     * Checks if the specified extension is an item file extension.
     * @param extension The extension to check.
     * @return True if it is a valid item extension.
     */
    public boolean isExtensionItemFile(String extension)
    {
        return extension!=null && extension.equals("dsitem");
    }
    
    /**
     * Checks if the specified extension is a module file extension.
     * @param extension The extension to check.
     * @return True if it is a valid module extension.
     */
    public boolean isExtensionModuleFile(String extension)
    {
        return extension!=null && extension.equals("dsmod");
    }
    
    /**
     * Checks if the specified extension is an image extension.
     * @param extension The extension to check.
     * @return True if it is a valid image extension.
     */
    public boolean isExtensionImage(String extension)
    {
        return extension!=null && (extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg") || extension.equals("bmp"));
    }
}
