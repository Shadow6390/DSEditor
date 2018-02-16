/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * A JPanel extension that allows to view images.
 * @author Diogo Braga
 */
public class JImagePanel extends JPanel{
    
    public static final int RESIZE_NONE=0;
    public static final int RESIZE_FIT=1;
    /**
     * The image to be displayed.
     */
    private BufferedImage image;
    
    /**
     * The resize mode.
     */
    private int resizeMode=RESIZE_NONE;
    
    public JImagePanel()
    {
        this(null);
    }
    
    public JImagePanel(BufferedImage image)
    {
        super();
        setImage(image);
    }
    
    /**
     * @param resizeMode the resizeMode to set
     */
    public void setResizeMode(int resizeMode)
    {
        this.resizeMode = resizeMode;
    }
    
    /**
     * Sets a new image to this image panel
     * @param image (BufferedImage) The image to draw.
     */
    public void setImage(BufferedImage image)
    {
        this.image=image;
        if (image!=null && resizeMode==RESIZE_NONE)
        {
            Dimension dim = new Dimension(image.getWidth(),image.getHeight());
            setPreferredSize(dim);
            setMinimumSize(dim);
            setMaximumSize(dim);
            setSize(dim);
            repaint();
        }
    }
    
    /**
     * Returns the current image being displayed.
     * @return (BufferedImage) The image being displayed.
     */
    public BufferedImage getImage()
    {
        return image;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        if (image!=null)
        {
            int ww=image.getWidth(),hh=image.getHeight();
            if (resizeMode==RESIZE_FIT)
            {
                ww = getWidth();
                hh = getHeight();
            }
            g.drawImage(image, 0,0,ww,hh, null);
        }
    }
}
