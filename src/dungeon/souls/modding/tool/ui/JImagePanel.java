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
    
    /**
     * The image to be displayed.
     */
    private BufferedImage image;
    
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
     * Sets a new image to this image panel
     * @param image (BufferedImage) The image to draw.
     */
    public void setImage(BufferedImage image)
    {
        this.image=image;
        Dimension dim = new Dimension(image.getWidth(),image.getHeight());
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(dim);
        setSize(dim);
        repaint();
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
            g.drawImage(image, 0,0,image.getWidth(), image.getHeight(), null);
        }
    }
}
