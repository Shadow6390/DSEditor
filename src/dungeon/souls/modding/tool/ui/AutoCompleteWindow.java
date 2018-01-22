/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;

/**
 * A window that allows the user to select an auto-complete option.
 * @author Diogo
 */
public class AutoCompleteWindow implements DocumentListener
{
    /**
     * The scroll pane for the suggestions panel.
     */
    private JScrollPane pane;
    
    /**
     * The JPanel where the suggestiosn will be added.
     */
    private JPanel panel;
    
    /**
     * The set of auto complete suggestion.
     */
    private SortedSet<AutoCompleteSuggestion> suggestions;
    
    /**
     * The window where the suggestions will be displayed.
     */
    private JWindow window;
    
    /**
     * Whether the window is visible or not.
     */
    private boolean visible;
    
    /**
     * The suggestions that can be clicked.
     */
    private List<SuggestionButton> buttons;
    
    /**
     * The currently selected button
     */
    private int currentIndex;
    
    /**
     * The start of the caret.
     */
    private int caretStart;
    
    /**
     * Button navigator.
     */
    private ButtonNavigator navigator;
    
    /**
     * The text area component to bring focus back to..
     */
    private Component textArea;
    
    /**
     * Listeners for auto-complete suggestions.
     */
    private List<AutoCompleteListener> listeners;
    
    /**
     * Creates an auto-complete window.
     * @param frame The parent frame.
     * @param textArea The text area component to focus.
     */
    public AutoCompleteWindow(Frame frame,Component textArea)
    {
        buttons = new ArrayList<>();
        currentIndex=0;
        this.textArea=textArea;
        init(frame);
        listeners = new LinkedList();
    }
    
    /**
     * Initializes the component.
     */
    private void init(Frame frame)
    {
        if (window==null)
        {
            panel = new JPanel();
            pane = new JScrollPane(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            suggestions = new TreeSet<>();
            window = new JWindow(frame);
            navigator=new ButtonNavigator();
            window.addKeyListener(navigator);
            window.add(pane);
        }
    }
    
    /**
     * Adds an auto-complete listener that will listen for suggestions of this
     * window.
     * @param listener The auto-complete listener.
     * @return 
     */
    public boolean addAutoCompleteListener(AutoCompleteListener listener)
    {
        return listeners.add(listener);
    }
    
    /**
     * Adds an auto-complete suggestion to the suggestion window.
     * @param component
     * @return 
     */
    public boolean addAutoCompleteSuggestion(AutoCompleteSuggestion component)
    {
        return suggestions.add(component);
    }
    
    /**
     * Returns whether this window is visible or not.
     * @return 
     */
    public boolean isVisible()
    {
        return visible;
    }
    
    /**
     * Builds the window component.
     * This method should not be called if window is being used as a listener.
     * @return The window itself.
     */
    public AutoCompleteWindow build()
    {
        buildWith(suggestions.iterator(),-1);
        return this;
    }
    
    /**
     * Sets the window visible at the specified place.
     * @param value (boolean) Whether to be set visible or not.
     * @param p (Point) The location at which the window will be set on.
     */
    public void show(boolean value,Point p)
    {
        show(value,p,null);
    }
    
    /**
     * Sets the window visible at the specified place.
     * @param value (boolean) Whether to be set visible or not.
     * @param p (Point) The location at which the window will be set on.
     * @param caret (Caret) The position of the caret in the text.
     */
    public void show(boolean value,Point p,Caret caret)
    {
        if (caret!=null)
        {
            caretStart = caret.getDot();
        }
        else
        {
            caretStart=-1;
        }
        if (!visible)
        {
            visible=true;
            window.pack();
            window.setVisible(true);
        }
        window.requestFocusInWindow();
        window.setLocation(p);
    }
    
    /**
     * Dispatches a AWT event.
     * @param e 
     */
    public void dispatchEvent(AWTEvent e)
    {
        window.dispatchEvent(e);
    }
    
    /**
     * Builds the window with the suggestions contained in the iterator.
     * @param iterator 
     * @param index The starting index. If lower than zero, then it's ignored.
     */
    private void buildWith(Iterator<AutoCompleteSuggestion> iterator,int index)
    {
        currentIndex=0;
        panel.removeAll();
        buttons.clear();
        int maxWidth=-1;
        int width;
        AutoCompleteSuggestion element;
        while (iterator.hasNext())
        {
            element = iterator.next();
            SuggestionButton button = new SuggestionButton(element);
            button.setContentAreaFilled(false);
            panel.add(button);
            buttons.add(button);
            button.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "accept-suggestion");
            button.getActionMap().put("accept-suggestion",new AbstractAction()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    listeners.stream().forEach((listener) ->
                    {
                        int position = index+1;
                        if (position<0)
                        {
                            position = caretStart;
                        }
                        listener.autoCompleteSuggested(new AutoCompleteEvent(button.getSuggestion(), position));
                    });
                    hide();
                }
            });
            button.addKeyListener(navigator);
            width = button.getPreferredSize().width;
            if (maxWidth<width)
            {
                maxWidth=width;
            }
        }
        updateButtonSize(maxWidth);
    }
    
    /**
     * Hides the window.
     */
    public void hide()
    {
        window.setVisible(false);
        visible=false;
    }
    
    /**
     * Handles any changes to the text.
     * @param e 
     */
    private void handleTextChange(DocumentEvent e)
    {
        if (visible && !e.getType().equals(DocumentEvent.EventType.CHANGE))
        {
            int start = e.getOffset();
            int length = e.getLength();
            Document doc = e.getDocument();
            if (caretStart!=-1)
            {
                if (caretStart>start)
                {
                    hide();
                }
            }
            for (int i=start;i>=0;i--)
            {
                try
                {
                    String text = doc.getText(i, length+(start-i));
                    if (foundWord(text))
                    {
                        autoCompleteFor(text.replaceAll("[ \n\r\t]", ""),i);
                        i=-1;
                    }
                }
                catch (BadLocationException ex)
                {
                    Logger.getLogger(AutoCompleteWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Finds a word in the given string.
     * @param text The text to search the word for.
     * @return 
     */
    private boolean foundWord(String text)
    {
        boolean result = false;
        if (text!=null)
        {
            if ((text.charAt(0)==' ' || text.charAt(0)==10 || text.matches("[\n\r]+.*")) && text.length()>1)
            {
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Auto completes for the given starting sentence.
     * @param start The starting sentence.
     * @param index The starting index to replace from.
     */
    private void autoCompleteFor(String start,int index)
    {
        List<AutoCompleteSuggestion> temp = new LinkedList();
        for (AutoCompleteSuggestion element:suggestions)
        {
            String suggestion = element.getSuggestion();
            if (suggestion.startsWith(start))
            {
                temp.add(element);
            }
        }
        buildWith(temp.iterator(),index);
        window.pack();
        window.revalidate();
        window.repaint();
    }
    
    /**
     * Updates the sizes of the buttons displayed.
     * @param maxWidth The max width of the button.
     */
    private void updateButtonSize(int maxWidth)
    {
        if (maxWidth>0)
        {
            for (Component c:panel.getComponents())
            {
                Dimension d = c.getPreferredSize();
                c.setMinimumSize(new Dimension(maxWidth,d.height));
                c.setPreferredSize(new Dimension(maxWidth,d.height));
                c.setMaximumSize(new Dimension(maxWidth,d.height));
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        handleTextChange(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        handleTextChange(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        handleTextChange(e);
    }
    
    private class ButtonNavigator extends KeyAdapter
    {

        @Override
        public void keyPressed(KeyEvent e)
        {
            if (visible)
            {
                boolean shouldFocus=true;
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_UP:
                        if (currentIndex>0)
                        {
                            currentIndex--;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (currentIndex<buttons.size()-1)
                        {
                            currentIndex++;
                        }
                        break;
                    case KeyEvent.VK_ESCAPE:
                        hide();
                        break;
                    default:
                        textArea.requestFocus();
                        shouldFocus=false;
                        break;
                }
                if (0<=currentIndex && currentIndex<buttons.size() && shouldFocus)
                {
                    buttons.get(currentIndex).requestFocus();
                }
            }
        }
    }
}
