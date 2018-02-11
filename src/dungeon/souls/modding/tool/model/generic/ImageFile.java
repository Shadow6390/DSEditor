/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.generic;

import dungeon.souls.modding.tool.model.module.SaveListener;
import dungeon.souls.modding.tool.reflection.FileEditable;
import dungeon.souls.modding.tool.ui.JImagePanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Represents an image file that can only be viewed.
 * This image file cannot be edited in the current editor. As such,
 * all save and load methods will not work.
 * @author Diogo
 */
public class ImageFile implements FileEditable
{

    /**
     * The file's location with the image content.
     */
    private File file;
    
    /**
     * The image panel where the image will be shown.
     */
    private JImagePanel imagePanel;
    
    /**
     * The file name's cached.
     */
    private String cachedFileName;
    
    /**
     * Creates an instance of {@link ImageFile} with the specified parameters.
     * @param file The
     */
    public ImageFile(File file) throws IOException
    {
        this.file=file;
        initImage();
    }
    
    @Override
    public String getFileName()
    {
        String result = "";
        if (file!=null)
        {
            result = file.getName();
            cachedFileName=result;
        }
        return result;
    }
    
    @Override
    public JComponent contentToComponent()
    {
        return imagePanel;
    }

    @Override
    public void save(File parentDirectory) throws IOException
    {
        //No saving performed.
    }

    @Override
    public boolean addSaveListener(SaveListener l)
    {
        return false; //Will not add listeners.
    }

    @Override
    public boolean contains(SaveListener l)
    {
        return false;
    }

    @Override
    public void delete()
    {
        if (file!=null)
        {
            file.delete();
        }
    }
    
    /**
     * Initializes the image panel.
     */
    private void initImage() throws IOException
    {
        BufferedImage image = ImageIO.read(file);
        imagePanel = new JImagePanel(image);
    }
    
    @Override
    public String toString()
    {
        if (cachedFileName==null)
        {
            cachedFileName=getFileName();
        }
        return cachedFileName;
    }
}
