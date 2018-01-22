/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

/**
 * Represents an auto-complete suggestion.
 * @author Diogo
 */
public interface AutoCompleteSuggestion extends Comparable<AutoCompleteSuggestion>
{

    /**
     * Returns the string value of this suggestion.
     * @return 
     */
    public String getSuggestion();
    
}
