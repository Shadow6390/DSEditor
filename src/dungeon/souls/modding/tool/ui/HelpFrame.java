/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.utils.Utilities;
import java.io.File;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

/**
 *
 * @author Diogo
 */
public class HelpFrame extends javax.swing.JFrame
{

    /**
     * Creates new form HelpFrame
     */
    public HelpFrame()
    {
        initComponents();
        JFXPanel jfxPanel = new JFXPanel(); // Scrollable JCompenent
        initPages();
        helpPane.setViewportView(jfxPanel);
        Platform.runLater( () -> { // FX components need to be managed by JavaFX
           WebView webView = new WebView();
           File file = new File("./Help/help.html");
           webView.getEngine().load(file.toURI().toString());
           jfxPanel.setScene( new Scene( webView ) );
        });
    }

    private void initPages()
    {
        try
        {
            File baseDir = new File("Help");
            String[] fileNames = {"help.html","help_functions.html","help_modules.html","help_steam_workshop.html",
            "help_sprites.html","help_items.html","help_contact.html","help_loggerWrite.html","help_onboarding.html",
            "help_playerAttribute.html","help_playerAttribute.html","help_distanceToNearestEnemy.html","help_enemyCount.html",
            "help_addGold.html","help_printConsole.html"};
            for (String element:fileNames)
            {
                Utilities.extractPackagedFiled(baseDir, 
                        EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/"+element), element, false);
            }
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
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

        helpPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpPane, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpPane, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane helpPane;
    // End of variables declaration//GEN-END:variables
}