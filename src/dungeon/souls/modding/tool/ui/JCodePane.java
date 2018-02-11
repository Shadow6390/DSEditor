/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import dungeon.souls.modding.tool.model.compiling.language.CompilationErrorMessage;
import dungeon.souls.modding.tool.model.compiling.language.DungeonSoulsLanguageCompiler;
import dungeon.souls.modding.tool.model.compiling.language.GameVariableAssignment;
import dungeon.souls.modding.tool.utils.DocumentTextUndoManager;
import dungeon.souls.modding.tool.utils.Utilities;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * Represents a JTextPane for coding.
 * The panel automatically highlights key-concepts of the programming langauge 
 * present in the given {@link CodeSyntaxHighlighter}.
 * @author Diogo
 */
public class JCodePane extends JTextPane
{
    /**
     * The code highlighter
     */
    private CodeSyntaxHighlighter codeSyntax;
    
    private JPopupMenu popupMenu;
        
    private AutoCompleteWindow suggestionWindow;
    
    private DocumentTextUndoManager realManager;
    
    /**
     * The compilation handler of this code pane.
     */
    private CompilationHandler cHandler;
    
    /**
     * The compiled game variables.
     */
    private List<GameVariableAssignment> gameVariables;
        
    /**
     * Creates a new JCodePane.
     * @param codeSyntax ({@link CodeSyntaxHighlighter}) The code highlighter.
     */
    public JCodePane(CodeSyntaxHighlighter codeSyntax)
    {
        super();
        this.codeSyntax=codeSyntax;
        realManager = new DocumentTextUndoManager(getDocument());
        ((AbstractDocument)getDocument()).setDocumentFilter(new HighlighterDocumentFilter());

        initInputMap();
        JMenuItem functionCreate = new JMenuItem();
        functionCreate.setText("Create Function");
        functionCreate.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                createFunction();
            }
        });
        popupMenu = new JPopupMenu();
        popupMenu.add(functionCreate);
        
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger() || e.getButton()==MouseEvent.BUTTON3)
                {
                    popupMenu.show(JCodePane.this,e.getX(),e.getY());
                }
            }
        });
        cHandler = new CompilationHandler(getStyledDocument());
        getDocument().addDocumentListener(cHandler);
    }
    
    /**
     * Initializes the suggestion window.
     * @param frame 
     */
    public void initSuggestionWindow(Frame frame)
    {
        suggestionWindow = new AutoCompleteWindow(frame,this);
        loadSuggestions(suggestionWindow);
        getDocument().addDocumentListener(suggestionWindow);
        getActionMap().put("up", new BlockingEventDispatcher(getInputMap(), getActionMap(), KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up", suggestionWindow));
        getActionMap().put("down", new BlockingEventDispatcher(getInputMap(), getActionMap(), KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down", suggestionWindow));
        getActionMap().put("escape", new BlockingEventDispatcher(getInputMap(), getActionMap(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape", suggestionWindow));
        addKeyListener(new KeyListener()
        {

            @Override
            public void keyTyped(KeyEvent e)
            {
                suggestionWindow.dispatchEvent(e);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                suggestionWindow.dispatchEvent(e);
                //For whatever reason, tab isn't working. So, we'll make it.
                if (e.getKeyCode()==KeyEvent.VK_TAB)
                {
                    getActionMap().get(getInputMap().get(KeyStroke.getKeyStroke(e.getKeyCode(), e.getModifiers()))).actionPerformed(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                suggestionWindow.dispatchEvent(e);
            }
        });
        suggestionWindow.addAutoCompleteListener(new AutoCompleteImpl());
    }
    
    /**
     * Creates a function declaratio at this JCodePane's caret position.
     */
    public void createFunction()
    {
        try 
        {
            String functionName = JOptionPane.showInputDialog(JCodePane.this,"Function Name:","Function Definition",JOptionPane.QUESTION_MESSAGE);
            if (functionName.equals(""))
            {
                functionName = "myfunction";
            }
            String template = "\tdefine function "+functionName+"\n"
                    + "\t{\n"
                    + "\t\tfunctionInput arg0;"
                    + "\n\t\tfunctionInput arg1;"
                    + "\n\t\tfunctionOutput result;"
                    + "\n\t}";

            int position = getCaretPosition();
            getDocument().insertString(position, template, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(JCodePane.class.getName()).log(Level.SEVERE, null, ex);
            EditorMain.out.println(ex.getMessage());
        }
    }
    /**
     * Loads stored suggestions to the auto-complete window.
     * @param suggestionWindow 
     */
    private void loadSuggestions(AutoCompleteWindow suggestionWindow)
    {
        try
        {
            String data = Utilities.inputStreamAsString(EditorMain.class.getClassLoader().getResourceAsStream("dungeon/souls/modding/tool/resources/DungeonSoulsGameFunctions.txt"));
            for (String line:data.split("\n"))
            {
                suggestionWindow.addAutoCompleteSuggestion(new SuggestionImpl(line));
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(JCodePane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Inits the code panel's input map.
     */
    private void initInputMap()
    {
        getInputMap().put(KeyStroke.getKeyStroke(' ', InputEvent.CTRL_DOWN_MASK),"suggest");
        getActionMap().put("suggest",new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (suggestionWindow!=null)
                {
                    Point p = getCaret().getMagicCaretPosition();
                    Point d = getLocationOnScreen();
                    p.translate(d.x,d.y+16);
                    suggestionWindow.show(true, p,getCaret());
                    final Document document = getDocument();
                    final Caret caret = getCaret();
                    //Trigger text change to display suggestions.
                    suggestionWindow.handleTextChange(new DocumentEvent()
                    {
                        private Document doc = document;
                        
                        private Caret c = caret;
                        
                        @Override
                        public int getOffset()
                        {
                            return c.getDot();
                        }

                        @Override
                        public int getLength()
                        {
                            return 0;
                        }

                        @Override
                        public Document getDocument()
                        {
                            return doc;
                        }

                        @Override
                        public DocumentEvent.EventType getType()
                        {
                            return DocumentEvent.EventType.INSERT;
                        }

                        @Override
                        public DocumentEvent.ElementChange getChange(Element elem)
                        {
                            return null;
                        }
                    });
                }
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK),"undo");
        getActionMap().put("undo",new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                realManager.undo();
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke('Y', InputEvent.CTRL_DOWN_MASK),"redo");
        getActionMap().put("redo",new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                realManager.redo(); 
            }
        });
        
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB,0),"tabSpace");
        getActionMap().put("tabSpace",new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    getDocument().insertString(getCaret().getDot(), "\t", null);
                }
                catch (BadLocationException ex)
                {
                    Logger.getLogger(JCodePane.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),"enterTabbed");
        getActionMap().put("enterTabbed",new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String text = getDocument().getText(0, getDocument().getLength());
                    int dot = getCaret().getDot()-1;
                    String tabs = "";
                    for (int i=dot;i>=0;i--)
                    {
                        if (text.charAt(i)=='\t')
                        {
                            tabs+="\t";
                        }
                        else if (text.charAt(i)=='\n')
                        {
                            i=-1;
                        }
                    }
                    getDocument().insertString(getCaret().getDot(), "\n"+tabs, null);
                }
                catch (BadLocationException ex)
                {
                    Logger.getLogger(JCodePane.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * @return the gameVariables
     */
    public List<GameVariableAssignment> getGameVariables()
    {
        return gameVariables;
    }

    /**
     * @return the cHandler
     */
    public CompilationHandler getCompilationHandler()
    {
        return cHandler;
    }
    
    private class AutoCompleteImpl implements AutoCompleteListener
    {

        @Override
        public void autoCompleteSuggested(AutoCompleteEvent e)
        {
            try
            {
                Document doc = getDocument();
                int caretPosition = getCaret().getDot();
                int len = caretPosition-e.getSuggestionStart();
                doc.remove(e.getSuggestionStart(), len);
                doc.insertString(e.getSuggestionStart(), e.getSuggestion().getSuggestion(), null);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(JCodePane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * A class that handles compiling the code in this pane and signaling errors.
     */
    protected class CompilationHandler implements DocumentListener
    {
        /**
         * The styled document to signal.
         */
        private StyledDocument document;
        
        /**
         * Creates a Compilation Handler with the specified parameters.
         * @param doc The styled document to signal.
         */
        public CompilationHandler(StyledDocument doc)
        {
            this.document=doc;
        }
        
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            syntaxCheck();
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            syntaxCheck();
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            //syntaxCheck();
        }

        public void syntaxCheck()
        {
            if (EditorMain.out!=null) //Check if window is initialized.
            {
                try
                {
                    String text = getText();
                    if (text!=null)
                    {
                        DungeonSoulsLanguageCompiler compiler = new DungeonSoulsLanguageCompiler();
                        compiler.setVerbose(false);
                        compiler.compileString(text,false);
                        codeSyntax.clearErrors();
                        List<CompilationErrorMessage> list = compiler.getErrorMessages();
                        if (!list.isEmpty())
                        {
                            String tooltipText="<html><body>Errors found:<br><ul>";
                            for (CompilationErrorMessage elem:list)
                            {
                                codeSyntax.signalError(document,elem);
                                tooltipText+="<li>"+elem.toString()+"</li>";
                            }
                            tooltipText+="</ul></body></html>";
                            setToolTipText(tooltipText);
                        }
                        else
                        {
                            setToolTipText("");
                        }
                        gameVariables = compiler.buildListener.getGameVariableList();
                    }
                }
                catch (Exception e)
                {
                    //EditorMain.out.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A class that dispatches events to the suggestion window if it is opened,
     * blocking events on the JCodePane.
     */
    private static class BlockingEventDispatcher extends AbstractAction
    {

        private final Object lastInputAction;
        
        private final AutoCompleteWindow suggestionWindow;
        
        private ActionMap actionMap;
        
        public BlockingEventDispatcher(InputMap inputMap, ActionMap actionMap, KeyStroke keystroke, Object input,AutoCompleteWindow suggestionWindow)
        {
            super();
            this.lastInputAction=inputMap.get(keystroke);
            this.actionMap=actionMap;
            inputMap.put(keystroke, input);
            this.suggestionWindow=suggestionWindow;
        }
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (suggestionWindow.isVisible())
            {
                suggestionWindow.dispatchEvent(e);
            }
            else
            {
                if (lastInputAction!=null)
                {
                    Action action= actionMap.get(lastInputAction);
                    if (action!=null)
                    {
                        action.actionPerformed(e);
                    }
                }
            }
        }
        
    }
    /**
     * Default suggestion implementation.
     */
    private static class SuggestionImpl implements AutoCompleteSuggestion
    {
        private String content;
        
        public SuggestionImpl(String content)
        {
            this.content=content;
        }

        @Override
        public String getSuggestion()
        {
            return content;
        }

        @Override
        public int compareTo(AutoCompleteSuggestion o)
        {
            return content.compareTo(o.getSuggestion());
        }
        
    }
    
    /**
     * Document filter for highlighting code.
     */
    private class HighlighterDocumentFilter extends DocumentFilter
    {
        private final StyledDocument document = getStyledDocument();
        private final StyleContext context = StyleContext.getDefaultStyleContext();
        private final AttributeSet blackAttributeSet = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        
        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
            super.insertString(fb, offset, text, attributeSet);
            handleTextChanged();
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);

            handleTextChanged();
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
            super.replace(fb, offset, length, text, attributeSet);

            handleTextChanged();
        }

        /**
         * Runs your updates later, not during the event notification.
         */
        private void handleTextChanged()
        {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    updateTextStyles();
                }
            });
        }

        private void updateTextStyles()
        {
            // Clear existing styles
            
            document.setCharacterAttributes(0, getText().length(), blackAttributeSet, true);
            
            codeSyntax.onTextChanged(document, getText());
        }
    }
}
