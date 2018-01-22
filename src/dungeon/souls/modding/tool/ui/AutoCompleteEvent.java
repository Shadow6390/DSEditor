/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

/**
 * Represents an auto-completion event.
 * @author Diogo
 */
public class AutoCompleteEvent
{
    /**
     * The suggestion of the event.
     */
    private AutoCompleteSuggestion suggestion;
    
    /**
     * Where the suggestion should start being placed on the text.
     */
    private int suggestionStart;
    
    /**
     * Creates an auto-complete event with the specified parameters.
     * @param suggestion The suggestion of the event.
     * @param suggestionStart Where the suggestion should start being placed on the text.
     */
    public AutoCompleteEvent(AutoCompleteSuggestion suggestion,int suggestionStart)
    {
        this.suggestion=suggestion;
        this.suggestionStart=suggestionStart;
    }

    /**
     * @return the suggestion
     */
    public AutoCompleteSuggestion getSuggestion()
    {
        return suggestion;
    }

    /**
     * @return the suggestionStart
     */
    public int getSuggestionStart()
    {
        return suggestionStart;
    }
}
