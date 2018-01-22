/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Represents a JButton that can be used for suggestions
 * @author Diogo
 */
public class SuggestionButton extends JButton
{
    /**
     * The suggestion of this button.
     */
    private AutoCompleteSuggestion suggestion;
    
    /**
     * Creates a Suggestion button with the specified parameters.
     * @param s The suggestion of this button.
     */
    public SuggestionButton(AutoCompleteSuggestion s)
    {
        this(s,s.getSuggestion());
    }
    
    /**
     * Creates a Suggestion button with the specified parameters.
     * @param s The suggestion of this button.
     * @param text The text to display on the button.
     */
    public SuggestionButton(AutoCompleteSuggestion s,String text)
    {
        super(text);
        this.suggestion=s;
        setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    /**
     * Returns the suggestion of this button.
     * @return 
     */
    public AutoCompleteSuggestion getSuggestion()
    {
        return suggestion;
    }
}
