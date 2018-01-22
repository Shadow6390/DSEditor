/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui;

/**
 * Represents an entity that listens for auto-complete suggestions.
 * @author Diogo
 */
public interface AutoCompleteListener
{
    /**
     * Triggered when an auto-complete is suggested.
     * @param e The auto-complete suggestion.
     */
    public void autoCompleteSuggested(AutoCompleteEvent e);
}
