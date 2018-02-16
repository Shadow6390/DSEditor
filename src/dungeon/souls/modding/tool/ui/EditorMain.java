/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import com.codedisaster.steamworks.SteamException;
import dungeon.souls.modding.tool.model.compiling.language.DungeonSoulsLanguageCompiler;
import dungeon.souls.modding.tool.model.compiling.language.GameVariableAssignment;
import dungeon.souls.modding.tool.model.module.ExtensionManager;
import dungeon.souls.modding.tool.model.module.ModuleManager;
import dungeon.souls.modding.tool.model.module.ModuleProject;
import dungeon.souls.modding.tool.model.module.SaveListener;
import dungeon.souls.modding.tool.reflection.FileEditable;
import dungeon.souls.modding.tool.steam.SteamListener;
import dungeon.souls.modding.tool.steam.SteamManager;
import dungeon.souls.modding.tool.steam.SteamWorkshopCommunityItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.xml.bind.JAXBException;
import dungeon.souls.modding.tool.model.generic.EditorConfig;

/**
 *
 * @author Diogo
 */
public class EditorMain extends javax.swing.JFrame
{
    /**
     * The editor's output stream.
     */
    public static PrintStream out;
    
    private DefaultTreeModel model;
    
    private DefaultMutableTreeNode root;
    
    /**
     * The manager of modules.
     */
    private ModuleManager manager;
    
    /**
     * Creates new form EditorMain
     */
    public EditorMain()
    {
        initComponents();
        initCustom();
        out = new PrintStream(new TextAreaOutputStream(editorLogger));
        ((DefaultCaret)editorLogger.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        try
        {
            setIconImage(ImageIO.read(EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/spr_Logo.png")));
        }
        catch (IOException ex)
        {
            Logger.getLogger(EditorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        SteamManager.getInstance().addSteamListener(new ComponentEnabler(compileSteam));
        workingTabPane.addChangeListener(new ChangeListener()
        {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                JCodePane pane = getSelectedCodepane();
                if (pane!=null)
                {
                    pane.getCompilationHandler().syntaxCheck();
                    List<GameVariableAssignment> list = pane.getGameVariables();
                    if (list!=null)
                    {
                        DefaultTableModel model = new DefaultTableModel(new String[]{"Name","Value"}, 0);
                        list.stream().forEach((elem) ->
                        {
                            model.addRow(new String[]{elem.getGameVariable(),elem.getValue()});
                        });
                        propertyTable.setModel(model);
                    }
                }
            }
        });
    }
    
    /**
     * Initializes custom code.
     */
    private void initCustom()
    {
        manager = new ModuleManager();
        root = new DefaultMutableTreeNode(manager);
        model = new DefaultTreeModel(root);
        model.addTreeModelListener(new TreeOrganizer());
        managerTree.setModel(model);
        managerTree.addMouseListener(new ManagerMouseListener());
        loadAllProjects(manager.getAllProjects());
        managerTree.expandRow(0);
        JButton button = new JButton("New Module");
        button.addActionListener((ActionEvent e) ->
        {
            newProjectActionPerformed(e);
        });
        quickActionBar.add(button);
        quickActionBar.addSeparator();
        button = new JButton("New Sprite");
        button.addActionListener((ActionEvent e) ->
        {
            newSpriteActionPerformed(e);
        });
        quickActionBar.add(button);
        quickActionBar.addSeparator();
        button = new JButton("New Item");
        button.addActionListener((ActionEvent e) ->
        {
            newItemActionPerformed(e);
        });
        quickActionBar.add(button);
        quickActionBar.addSeparator();
        button = new JButton("New Function");
        button.addActionListener((ActionEvent e) ->
        {
            Component c = workingTabPane.getSelectedComponent();
            if (c instanceof JScrollPane)
            {
                c=((JScrollPane)c).getComponent(0);
                c=((JViewport)c).getComponent(0);
            }
            if (c instanceof JCodePane)
            {
                ((JCodePane)c).createFunction();
            }
        });
        quickActionBar.add(button);
        quickActionBar.addSeparator();
        
        button = new JButton("Add Image");
        button.addActionListener((ActionEvent e) ->
        {
            imageAddActionPerformed(e);
        });
        quickActionBar.add(button);
        quickActionBar.addSeparator();
        
        button = new JButton();
        try
        {
            button.setIcon(new ImageIcon(ImageIO.read(EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/Play.png"))
                    .getScaledInstance(28, 28, Image.SCALE_DEFAULT)));
        }
        catch (IOException ex)
        {
            Logger.getLogger(EditorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        button.addActionListener((ActionEvent e) ->
        {
            DefaultMutableTreeNode node = getSelectedProjectNode();
            if (node!=null && node.getUserObject() instanceof ModuleProject)
            {
                ModuleProject project = (ModuleProject) node.getUserObject();
                if (project!=null)
                {
                    project.save();
                    EditorMain.out.println("Compiling, building and running project...");
                    DungeonSoulsLanguageCompiler compiler = new DungeonSoulsLanguageCompiler();
                    try
                    {
                        compiler.compileAndRun(project);
                        out.println("Launched Dungeon Souls. Please wait until Steam loads Dungeon Souls. If you do not have the game installed on Steam, you'll have"
                                + " to execute it directly.");
                    }
                    catch (IOException ex)
                    {
                        out.println("An error occurred whilst trying to compile and run: "+ex.getMessage());
                    }
                }
            }
        });
        quickActionBar.add(button);
    }
    
    /**
     * Returns the currently opened code pane.
     * @return Can be null if no panes are opened.
     */
    private JCodePane getSelectedCodepane()
    {
        Component c = workingTabPane.getSelectedComponent();
        if (c instanceof JScrollPane)
        {
            c=((JScrollPane)c).getComponent(0);
            c=((JViewport)c).getComponent(0);
        }
        if (c instanceof JCodePane)
        {
            return ((JCodePane)c);
        }
        return null;
    }
    
    /**
     * Adds all the projects contained in the list to the project tree.
     * @param projects The list of projects.
     */
    private void loadAllProjects(List<ModuleProject> projects)
    {
        int count=0;
        for (ModuleProject project:projects)
        {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(project);
            model.insertNodeInto(node, root, count);
            project.loadFilesAsNodes(node,model);
            count++;
        }
    }
    
    private DefaultMutableTreeNode getSelectedProjectNode()
    {
        DefaultMutableTreeNode result = (DefaultMutableTreeNode)managerTree.getSelectionPath().getLastPathComponent();
        DefaultMutableTreeNode temp = result;
        while (!(temp.getUserObject() instanceof ModuleProject) && temp.getParent()!=null)
        {
            temp=(DefaultMutableTreeNode)temp.getParent();
        }
        if (temp.getUserObject() instanceof ModuleProject)
        {
            result = temp;
        }
        return result;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        popupMenu = new javax.swing.JPopupMenu();
        createNew = new javax.swing.JMenu();
        newSprite = new javax.swing.JMenuItem();
        newItem = new javax.swing.JMenuItem();
        addExisting = new javax.swing.JMenu();
        imageAdd = new javax.swing.JMenuItem();
        compileProjectPopAction = new javax.swing.JMenuItem();
        deleteProjectAction = new javax.swing.JMenuItem();
        popupMenuManager = new javax.swing.JPopupMenu();
        newProject = new javax.swing.JMenuItem();
        popupMenuFile = new javax.swing.JPopupMenu();
        deleteFile = new javax.swing.JMenuItem();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        managerTree = new javax.swing.JTree();
        jSplitPane2 = new javax.swing.JSplitPane();
        workingTabPane = new javax.swing.JTabbedPane();
        outputTabs = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        editorLogger = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        propertyTable = new javax.swing.JTable();
        quickActionBar = new javax.swing.JToolBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        compileMenu = new javax.swing.JMenu();
        checkMenuItem = new javax.swing.JMenuItem();
        compileProjectMenuItem = new javax.swing.JMenuItem();
        compileSteam = new javax.swing.JMenuItem();
        steamMenu = new javax.swing.JMenu();
        steamInitItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        changeLooksMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        popupMenu.setMinimumSize(new java.awt.Dimension(128, 64));

        createNew.setText("Create New...");

        newSprite.setText("Sprite");
        newSprite.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newSpriteActionPerformed(evt);
            }
        });
        createNew.add(newSprite);

        newItem.setText("Item");
        newItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newItemActionPerformed(evt);
            }
        });
        createNew.add(newItem);

        popupMenu.add(createNew);

        addExisting.setText("Add Existing...");
        addExisting.setToolTipText("");

        imageAdd.setText("Image");
        imageAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                imageAddActionPerformed(evt);
            }
        });
        addExisting.add(imageAdd);

        popupMenu.add(addExisting);

        compileProjectPopAction.setText("Compile & Build");
        compileProjectPopAction.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                compileProjectPopActionActionPerformed(evt);
            }
        });
        popupMenu.add(compileProjectPopAction);

        deleteProjectAction.setText("Delete");
        deleteProjectAction.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteProjectActionActionPerformed(evt);
            }
        });
        popupMenu.add(deleteProjectAction);

        newProject.setText("New Module");
        newProject.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newProjectActionPerformed(evt);
            }
        });
        popupMenuManager.add(newProject);

        popupMenuFile.setMinimumSize(new java.awt.Dimension(128, 64));

        deleteFile.setText("Delete");
        deleteFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteFileActionPerformed(evt);
            }
        });
        popupMenuFile.add(deleteFile);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DSEditor ("+EditorConfig.EDITOR_VERSION+")");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jSplitPane3.setDividerLocation(620);
        jSplitPane3.setResizeWeight(0.8);

        jSplitPane1.setDividerLocation(128);

        jScrollPane1.setViewportView(managerTree);
        managerTree.setCellRenderer(new ProjectTreeRenderer());

        jSplitPane1.setLeftComponent(jScrollPane1);

        jSplitPane2.setDividerLocation(320);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setResizeWeight(0.9);

        workingTabPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jSplitPane2.setTopComponent(workingTabPane);

        editorLogger.setEditable(false);
        editorLogger.setColumns(20);
        editorLogger.setRows(5);
        editorLogger.setToolTipText("");
        editorLogger.setWrapStyleWord(true);
        editorLogger.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(editorLogger);

        outputTabs.addTab("tab1", jScrollPane2);
        outputTabs.setTitleAt(outputTabs.getTabCount()-1, "Editor Output");

        jSplitPane2.setRightComponent(outputTabs);
        outputTabs.getAccessibleContext().setAccessibleName("Editor Output");

        jSplitPane1.setRightComponent(jSplitPane2);

        jSplitPane3.setLeftComponent(jSplitPane1);

        propertyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String []
            {
                "Name", "Value"
            }
        ));
        propertyTable.setEnabled(false);
        propertyTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(propertyTable);

        jSplitPane3.setRightComponent(jScrollPane4);

        quickActionBar.setFloatable(false);
        quickActionBar.setRollover(true);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New Module...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save Selected Project");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Undo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Redo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Close Selected File");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        compileMenu.setText("Compile");

        checkMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        checkMenuItem.setText("Check Opened File Errors");
        checkMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                checkMenuItemActionPerformed(evt);
            }
        });
        compileMenu.add(checkMenuItem);

        compileProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        compileProjectMenuItem.setText("Compile Module for Release");
        compileProjectMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                compileProjectMenuItemActionPerformed(evt);
            }
        });
        compileMenu.add(compileProjectMenuItem);

        compileSteam.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        compileSteam.setText("Compile and Release to Steam");
        compileSteam.setEnabled(false);
        compileSteam.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                compileSteamActionPerformed(evt);
            }
        });
        compileMenu.add(compileSteam);

        jMenuBar1.add(compileMenu);

        steamMenu.setText("Steam");

        steamInitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        steamInitItem.setText("Initialize Steam");
        steamInitItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                steamInitItemActionPerformed(evt);
            }
        });
        steamMenu.add(steamInitItem);

        jMenuBar1.add(steamMenu);

        jMenu3.setText("Window");

        changeLooksMenu.setText("Change Looks to");
        fetchLookandFeels();
        jMenu3.add(changeLooksMenu);

        jMenuBar1.add(jMenu3);

        helpMenu.setText("Help");

        jMenuItem6.setText("Documentation");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem6ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem6);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quickActionBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(quickActionBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane3)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new CreateProjectUI(this,true,manager,root).setVisible(true);
        model.reload(root);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        TreePath path = managerTree.getSelectionPath();
        if (path!=null)
        {
            int i=0;
            DefaultMutableTreeNode node = null;
            while (i<path.getPathCount() && !((node=(DefaultMutableTreeNode)path.getPathComponent(i)).getUserObject() instanceof ModuleProject))
            {
                i++;
            }
            if (i<path.getPathCount())
            {
                if (node!=null && node.getUserObject() instanceof ModuleProject)
                {
                    ModuleProject p = (ModuleProject)node.getUserObject();
                    p.save();
                    EditorMain.out.println("Saved project '"+p.getName()+"'");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void newSpriteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newSpriteActionPerformed
    {//GEN-HEADEREND:event_newSpriteActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode node = getSelectedProjectNode();
        new CreateSpriteUI(this,true,(ModuleProject)node.getUserObject(),node).setVisible(true);
        model.reload(node);
    }//GEN-LAST:event_newSpriteActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newItemActionPerformed
    {//GEN-HEADEREND:event_newItemActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode node = getSelectedProjectNode();
        new CreateItemUI(this,true,(ModuleProject)node.getUserObject(),node).setVisible(true);
        model.reload(node);
    }//GEN-LAST:event_newItemActionPerformed

    private void newProjectActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newProjectActionPerformed
    {//GEN-HEADEREND:event_newProjectActionPerformed
        // TODO add your handling code here:
        jMenuItem1ActionPerformed(evt);
    }//GEN-LAST:event_newProjectActionPerformed

    private void compileProjectMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compileProjectMenuItemActionPerformed
    {//GEN-HEADEREND:event_compileProjectMenuItemActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode node = getSelectedProjectNode();
        if (node!=null && node.getUserObject() instanceof ModuleProject)
        {
            ModuleProject project = (ModuleProject) node.getUserObject();
            project.save();
            EditorMain.out.println("Compiling and building project...");
            try
            {
                DialogDirectoryFileChoose choose = new DialogDirectoryFileChoose(EditorMain.this, true, project.getName(),".zip");
                choose.setVisible(true);
                String path=choose.getFinalPath();
                if (!path.equals(""))
                {
                    new DungeonSoulsLanguageCompiler().compileProject(project,new File(path));
                }
            }
            catch (IOException e)
            {
                EditorMain.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_compileProjectMenuItemActionPerformed

    private void checkMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_checkMenuItemActionPerformed
    {//GEN-HEADEREND:event_checkMenuItemActionPerformed
        // TODO add your handling code here:
        Component c = workingTabPane.getSelectedComponent();
        if (c instanceof JScrollPane)
        {
            c=((JScrollPane)c).getComponent(0);
            c=((JViewport)c).getComponent(0);
        }
        if (c instanceof JCodePane)
        {
            JCodePane pane = JCodePane.class.cast(c);
            EditorMain.out.println("Compiling...");
            new DungeonSoulsLanguageCompiler().compileString(pane.getText(),false);
        }
        else
        {
            EditorMain.out.println("Cannot compile the currently opened file. Class is "+c.getClass().getCanonicalName());
        }
    }//GEN-LAST:event_checkMenuItemActionPerformed

    private void compileProjectPopActionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compileProjectPopActionActionPerformed
    {//GEN-HEADEREND:event_compileProjectPopActionActionPerformed
        // TODO add your handling code here:
        compileProjectMenuItemActionPerformed(evt);
    }//GEN-LAST:event_compileProjectPopActionActionPerformed

    private void deleteProjectActionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteProjectActionActionPerformed
    {//GEN-HEADEREND:event_deleteProjectActionActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode node = getSelectedProjectNode();
        if (node!=null && node.getUserObject() instanceof ModuleProject)
        {
            int result = JOptionPane.showConfirmDialog(EditorMain.this, "Do you really want to delete '"+node.getUserObject()+"'? (all files will be deleted from storage)", "Delete Project", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION)
            {
                ((ModuleProject)node.getUserObject()).delete();
                model.removeNodeFromParent(node);
            }
        }
    }//GEN-LAST:event_deleteProjectActionActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem3ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Component c = workingTabPane.getSelectedComponent();
        if (c instanceof JScrollPane)
        {
            c=((JScrollPane)c).getComponent(0);
            c=((JViewport)c).getComponent(0);
        }
        if (c instanceof JCodePane)
        {
            JCodePane pane = JCodePane.class.cast(c);
            pane.getActionMap().get("undo").actionPerformed(evt);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem4ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Component c = workingTabPane.getSelectedComponent();
        if (c instanceof JScrollPane)
        {
            c=((JScrollPane)c).getComponent(0);
            c=((JViewport)c).getComponent(0);
        }
        if (c instanceof JCodePane)
        {
            JCodePane pane = JCodePane.class.cast(c);
            pane.getActionMap().get("redo").actionPerformed(evt);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        // TODO add your handling code here:
        setExtendedState(JFrame.MAXIMIZED_BOTH | getExtendedState());
    }//GEN-LAST:event_formWindowOpened

    private void imageAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_imageAddActionPerformed
    {//GEN-HEADEREND:event_imageAddActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(true);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image file (.png, .jpg, .jpeg, .bmp)", new String[]{"png","jpg","jpeg","bmp"}));
        int result = chooser.showOpenDialog(rootPane);
        if (result==JFileChooser.APPROVE_OPTION)
        {
            File[] images = chooser.getSelectedFiles();
            DefaultMutableTreeNode node = getSelectedProjectNode();
            if (node!=null && node.getUserObject() instanceof ModuleProject)
            {
                ModuleProject mp = (ModuleProject) node.getUserObject();
                File base = new File(mp.getDirectory().getAbsoluteFile()+File.separator+"Sprites");
                List<FileEditable> addedFiles = mp.loadImages(base,images);
                int count=0;
                for (FileEditable elem:addedFiles)
                {
                    model.insertNodeInto(new DefaultMutableTreeNode(elem), node, count++);
                }
            }
        }
    }//GEN-LAST:event_imageAddActionPerformed

    private void compileSteamActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compileSteamActionPerformed
    {//GEN-HEADEREND:event_compileSteamActionPerformed
        // TODO add your handling code here:
        if (SteamManager.getInstance().isAPIInitialized())
        {
            DefaultMutableTreeNode node = getSelectedProjectNode();
            if (node!=null && node.getUserObject() instanceof ModuleProject)
            {
                ModuleProject project = (ModuleProject) node.getUserObject();
                try
                {
                    DialogDirectoryFileChoose choose = new DialogDirectoryFileChoose(EditorMain.this, true, project.getName(),".dsa");
                    choose.setVisible(true);
                    String path=choose.getFinalPath();
                    if (!path.equals(""))
                    {
                        SteamWorkshopInformationChooseUI steamChoose = 
                                new SteamWorkshopInformationChooseUI(EditorMain.this, true, SteamManager.getInstance().getModuleList().getSteamWorkshopModule(project.getName()));
                        steamChoose.setVisible(true);
                        Map<SteamWorkshopCommunityItem.ATTRIBUTES,String> map = steamChoose.getAttributeMap();
                        if (map!=null)
                        {
                            SteamWorkshopCommunityItem item = new SteamWorkshopCommunityItem(project.getName());
                            EditorMain.out.println("Compiling and building project...");
                            String folder = new DungeonSoulsLanguageCompiler().compileProjectFolder(project,new File(path));
                            EditorMain.out.println("Preparing item for upload...");
                            map.entrySet().stream().forEach((entry) ->
                            {
                                item.put(entry.getKey(),entry.getValue());
                            });
                            item.put(SteamWorkshopCommunityItem.ATTRIBUTES.CONTENT, folder);
                            item.uploadFile();
                        }
                    }
                }
                catch (IOException e)
                {
                    EditorMain.out.println(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_compileSteamActionPerformed

    private void steamInitItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_steamInitItemActionPerformed
    {//GEN-HEADEREND:event_steamInitItemActionPerformed
        try
        {
            // TODO add your handling code here:
            boolean init = SteamManager.getInstance().initializeSteam();
            if (init)
            {
                SteamManager.getInstance().initCallbackLoop();
                out.println("Steam API initialized.");
            }
        }
        catch (IOException | IllegalStateException | SteamException ex)
        {
            out.println(ex.getMessage());
        }
    }//GEN-LAST:event_steamInitItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        try
        {
            // TODO add your handling code here:
            SteamManager.getInstance().saveData();
            EditorConfig.getInstance().saveData();
        }
        catch (JAXBException ex)
        {
            Logger.getLogger(EditorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem5ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if (workingTabPane.getTabCount()>0)
        {
            workingTabPane.remove(workingTabPane.getSelectedIndex());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem6ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        HelpFrame frame = new HelpFrame();
        try
        {
            frame.setIconImage(ImageIO.read(EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/spr_Logo.png")));
        }
        catch (IOException ex)
        {
            Logger.getLogger(EditorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void deleteFileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteFileActionPerformed
    {//GEN-HEADEREND:event_deleteFileActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode node = getSelectedProjectNode();
        if (node!=null && node.getUserObject() instanceof FileEditable)
        {
            int result = JOptionPane.showConfirmDialog(EditorMain.this, "Do you really want to delete '"+node.getUserObject()+"'?", "Delete File", JOptionPane.YES_NO_OPTION);
            if (result==JOptionPane.YES_OPTION)
            {
                FileEditable file = (FileEditable)node.getUserObject();
                file.delete();
                ModuleProject project = (ModuleProject)((DefaultMutableTreeNode)node.getParent()).getUserObject();
                project.removeFile(file);
                model.removeNodeFromParent(node);
            }
        }
    }//GEN-LAST:event_deleteFileActionPerformed
    /**
     * Fetches the available look and feels.
     */
    private void fetchLookandFeels()
    {
        UIManager.LookAndFeelInfo[] feels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo elem:feels)
        {
            JMenuItem item = new JMenuItem(elem.getName());
            item.addActionListener((ActionEvent e) ->
            {
                try
                {
                    UIManager.setLookAndFeel(elem.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                    EditorMain.out.println("Failed to set new looks: "+ex.getMessage());
                }
            });
            changeLooksMenu.add(item);
        }
    }
    
    /**
     * Responsible for enabling/disabling a component based on events fired.
     */
    private static class ComponentEnabler implements SteamListener
    {

        /**
         * The component in charge.
         */
        private Component component;
        
        /**
         * Creates a ComponentEnabler with the specified parameters.
         * @param c The target component to modify.
         */
        public ComponentEnabler(Component c)
        {
            this.component=c;
        }
        
        @Override
        public void onSteamInit(boolean initState)
        {
            component.setEnabled(initState);
        }
        
    }
    
    /**
     * Manages the mouse for project selection and item selection.
     */
    public class ManagerMouseListener extends MouseAdapter
    {
        public ManagerMouseListener()
        {
            
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            TreePath selPath = managerTree.getPathForLocation(e.getX(), e.getY());
            if (selPath!=null)
            {
                managerTree.setSelectionPath(selPath);
                if(e.getClickCount() == 2 && e.getButton()==MouseEvent.BUTTON1) 
                {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
                    Object o = node.getUserObject();
                    if (o instanceof FileEditable)
                    {
                        FileEditable editable = FileEditable.class.cast(o);
                        IndicateFileChange indicator = new IndicateFileChange(editable);
                        if (!editable.contains(indicator))
                        {
                            editable.addSaveListener(indicator);
                        }
                        if (editable.contentToComponent() instanceof JCodePane)
                        {
                            addJCodePaneToTab(editable, indicator);
                        }
                        else
                        {
                            addJComponentToTab(editable,indicator);
                        }
                    }
                }
                else if (e.getButton()==MouseEvent.BUTTON3)
                {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
                    Object o = node.getUserObject();
                    if (o instanceof ModuleProject)
                    {
                        popupMenu.show(managerTree, e.getX(), e.getY());
                    }
                    else if (o instanceof ModuleManager)
                    {
                        popupMenuManager.show(managerTree, e.getX(), e.getY());
                    }
                    else if (o instanceof FileEditable)
                    {
                        popupMenuFile.show(managerTree, e.getX(), e.getY());
                    }
                }
            }
        }
            
        /**
         * Adds a JCodePane to the working tab pane.
         * @param editable The file editable that contains the JCodePane.
         * @param indicator The file indicator that listens for modifications.
         */
        private void addJCodePaneToTab(FileEditable editable,IndicateFileChange indicator)
        {
            if (editable.contentToComponent() instanceof JCodePane)
            {
                JCodePane codePane = (JCodePane) editable.contentToComponent();
                if (!alreadyOpened(codePane)) //Check if the tab is already opened.
                {
                    codePane.initSuggestionWindow(EditorMain.this);
                    JScrollPane pane = new JScrollPane(codePane);
                    TextLineNumber number = new TextLineNumber(codePane);
                    number.setCurrentLineForeground(new Color(0,127,255));
                    pane.setRowHeaderView(number);
                    codePane.getInputMap().put(KeyStroke.getKeyStroke("control W"), "closeTab");
                    codePane.getActionMap().put("closeTab", new AbstractAction()
                    {
                        private IndicateFileChange ind = indicator;

                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            workingTabPane.remove(workingTabPane.getSelectedIndex());
                            ind.obsolete=true;
                        }
                    });
                    codePane.getDocument().addDocumentListener(indicator);
                    workingTabPane.addTab(editable.toString(), pane);
                    indicator.index=workingTabPane.getTabCount()-1;
                    workingTabPane.setTabComponentAt(indicator.index, new ButtonTabComponent(workingTabPane));
                    workingTabPane.getModel().setSelectedIndex(workingTabPane.getTabCount()-1);
                }
            }
        }
        
        /**
         * Adds a JComponent to the working tab pane.
         * @param editable The file editable that contains the JComponent.
         * @param indicator The file indicator that listens for modifications.
         */
        private void addJComponentToTab(FileEditable editable,IndicateFileChange indicator)
        {
            JComponent component = editable.contentToComponent();
            if (!alreadyOpened(component)) //Check if the tab is already opened.
            {
                JScrollPane pane = new JScrollPane(component);
                workingTabPane.addTab(editable.toString(), pane);
                indicator.index=workingTabPane.getTabCount()-1;
                workingTabPane.setTabComponentAt(indicator.index, new ButtonTabComponent(workingTabPane));
                workingTabPane.getModel().setSelectedIndex(workingTabPane.getTabCount()-1);
            }
        }
        
        /**
         * Checks whether the given JComponent is already opened.
         * @param pane The pane to check.
         * @return True if already opened.
         */
        private boolean alreadyOpened(JComponent pane)
        {
            boolean result = false;
            for (int i=0;i<workingTabPane.getTabCount() && !result;i++)
            {
                Component c = workingTabPane.getComponentAt(i);
                if (c instanceof JScrollPane)
                {
                    c=((JScrollPane)c).getComponent(0);
                    c=((JViewport)c).getComponent(0);
                    if (c.equals(pane))
                    {
                        result = true;
                    }
                }
            }
            return result;
        }
    }
    
    private static class TreeFolder extends DefaultMutableTreeNode
    {
        public TreeFolder()
        {
            super();
        }
        
        public TreeFolder(Object object)
        {
            super(object);
        }
        
        @Override
        public boolean equals(Object other)
        {
            boolean result = other != null && getClass().isInstance(other);
            if (result)
            {
                TreeFolder ob = getClass().cast(other);
                result = (this == other) || (getUserObject().toString().equals(ob.getUserObject().toString()));
            }
            return result;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            return hash;
        }
    }
    
    /**
     * A class that is responsible for organizing the contents of the tree
     * into folders.
     */
    private class TreeOrganizer implements TreeModelListener
    {
        private boolean requestedRefresh = false;

        @Override
        public void treeNodesChanged(TreeModelEvent e)
        {
            System.out.println("Something changed.");
        }

        @Override
        public void treeNodesInserted(TreeModelEvent e)
        {
            restructureTree(e);
        }

        @Override
        public void treeNodesRemoved(TreeModelEvent e)
        {
            System.out.println("Something removed.");
        }

        @Override
        public void treeStructureChanged(TreeModelEvent e)
        {
            restructureTree(e);
        }

        private void restructureTree(TreeModelEvent e)
        {
            if (!requestedRefresh)
            {
                DefaultMutableTreeNode node = ((DefaultMutableTreeNode)e.getTreePath().getLastPathComponent());
                if (node.getUserObject() instanceof ModuleProject)
                {
                    Map<String,TreeFolder> map = ensureBaseDirectories(node);
                    Enumeration children = node.children();
                    while (children.hasMoreElements())
                    {
                        Object ob = children.nextElement();
                        if (ob instanceof DefaultMutableTreeNode)
                        {
                            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)ob;
                            Object userObject = childNode.getUserObject();
                            if (userObject instanceof FileEditable)
                            {
                                String extension = ((FileEditable) userObject).getFileName();
                                extension = extension.substring(extension.lastIndexOf(".")+1);
                                if (ExtensionManager.getInstance().isExtensionSpriteFile(extension))
                                {
                                    map.get("Sprites").add(childNode);
                                }
                                else if (ExtensionManager.getInstance().isExtensionModuleFile(extension))
                                {
                                    map.get("Module").add(childNode);
                                }
                                else if (ExtensionManager.getInstance().isExtensionItemFile(extension))
                                {
                                    map.get("Items").add(childNode);
                                }
                                else if (ExtensionManager.getInstance().isExtensionImage(extension))
                                {
                                    map.get("Images").add(childNode);
                                }
                            }
                        }
                    }
                }
                requestedRefresh=true;
                model.reload(node);
            }
            else
            {
                requestedRefresh=false;
            }
        }

        /**
         * Ensures that the project node has the default directories.
         * These are the Sprites, Functions, Module and Items directories.
         */
        private Map<String,TreeFolder> ensureBaseDirectories(DefaultMutableTreeNode node)
        {
            Map<TreeFolder,Boolean> rootDirectories = new LinkedHashMap<>();
            TreeFolder sprites = new TreeFolder("Sprites");
            //TreeFolder functions = new TreeFolder("Functions");
            TreeFolder module = new TreeFolder("Module");
            TreeFolder items = new TreeFolder("Items");
            TreeFolder images = new TreeFolder("Images");
            rootDirectories.put(sprites, false);
            //rootDirectories.put(functions, false);
            rootDirectories.put(module, false);
            rootDirectories.put(items, false);
            rootDirectories.put(images, false);
            TreeNode child;
            for (int i=0;i<node.getChildCount();i++)
            {
                child = node.getChildAt(i);
                if (rootDirectories.containsKey(child))
                {
                    rootDirectories.remove((TreeFolder)child);
                    rootDirectories.put((TreeFolder)child,true);
                }
            }
            Map<String,TreeFolder> result = new LinkedHashMap<>();
            for (Entry<TreeFolder,Boolean> elem:rootDirectories.entrySet())
            {
                if (!elem.getValue())
                {
                    node.add(elem.getKey());
                }
                result.put(elem.getKey().toString(),elem.getKey());
            }
            return result;
        }
    }
    
    /**
     * Indicates that a file was changed on a tab's title.
     */
    private class IndicateFileChange implements DocumentListener,SaveListener
    {
        private final FileEditable file;
        
        /**
         * The index of the tab that this indicate file change is responsible for.
         */
        private int index;
        
        /**
         * Whether we're obsolete or not.
         */
        private boolean obsolete;
        
        public IndicateFileChange(FileEditable file)
        {
            this.file=file;
        }
                                
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            notifyUnsaved();
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            notifyUnsaved();
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            notifyUnsaved();
        }

        /**
         * Notifies that a save file was changed.
         */
        private void notifyUnsaved()
        {
            if (!obsolete)
            {
                SwingUtilities.invokeLater(() ->
                {
                    if (index<workingTabPane.getTabCount())
                    {
                        workingTabPane.setBackgroundAt(index, Color.ORANGE);
                        workingTabPane.setTitleAt(index, file.toString()+"*");
                    }
                });
            }
            
        }                            

        @Override
        public void onSave(Object o)
        {
            if (!obsolete)
            {
                SwingUtilities.invokeLater(() ->
                {
                    if (index<workingTabPane.getTabCount())
                    {
                        workingTabPane.setBackgroundAt(index, workingTabPane.getBackground());
                        workingTabPane.setTitleAt(index, file.toString());
                    }
                });
            }
        }
        
        @Override
        public boolean equals(Object other)
        {
            boolean result = other != null && getClass().isInstance(other);
            if (result)
            {
                IndicateFileChange ob = getClass().cast(other);
                result = (this == other) || (ob.file.equals(file));
            }
            return result;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 29 * hash + Objects.hashCode(this.file);
            return hash;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addExisting;
    private javax.swing.JMenu changeLooksMenu;
    private javax.swing.JMenuItem checkMenuItem;
    private javax.swing.JMenu compileMenu;
    private javax.swing.JMenuItem compileProjectMenuItem;
    private javax.swing.JMenuItem compileProjectPopAction;
    private javax.swing.JMenuItem compileSteam;
    private javax.swing.JMenu createNew;
    private javax.swing.JMenuItem deleteFile;
    private javax.swing.JMenuItem deleteProjectAction;
    private javax.swing.JTextArea editorLogger;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem imageAdd;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTree managerTree;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem newProject;
    private javax.swing.JMenuItem newSprite;
    private javax.swing.JTabbedPane outputTabs;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JPopupMenu popupMenuFile;
    private javax.swing.JPopupMenu popupMenuManager;
    private javax.swing.JTable propertyTable;
    private javax.swing.JToolBar quickActionBar;
    private javax.swing.JMenuItem steamInitItem;
    private javax.swing.JMenu steamMenu;
    private javax.swing.JTabbedPane workingTabPane;
    // End of variables declaration//GEN-END:variables
}
