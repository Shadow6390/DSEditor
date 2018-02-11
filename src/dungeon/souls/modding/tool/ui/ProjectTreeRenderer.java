/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.model.module.ModuleProject;
import dungeon.souls.modding.tool.steam.SteamManager;
import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Renders project modules.
 *
 * @author Diogo
 */
public class ProjectTreeRenderer extends DefaultTreeCellRenderer
{
    
    /**
     * Creates a ProjectTreeRenderer.
     */
    public ProjectTreeRenderer()
    {
        super();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus)
    {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object s = node.getUserObject();
        boolean keepDefaults=true;
        if (s instanceof ModuleProject) 
        {
            ModuleProject mp = (ModuleProject)s;
            if (SteamManager.getInstance().getModuleList().containsSteamWorkshopModule(mp.getName()))
            {
                setOpenIcon(SteamManager.getInstance().getOpenProjectIcon());
                setClosedIcon(SteamManager.getInstance().getClosedProjectIcon());
                keepDefaults=false;
            }
        } 
        if (keepDefaults)
        {
            setOpenIcon(getDefaultOpenIcon());
            setClosedIcon(getDefaultClosedIcon());
        }
        super.getTreeCellRendererComponent(
                tree, value, selected, expanded, leaf, row, hasFocus);
        return this;
    }
}
