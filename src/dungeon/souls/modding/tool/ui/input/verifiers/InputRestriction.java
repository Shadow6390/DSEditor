/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui.input.verifiers;

/**
 * Represents an input restriction.
 * @author Diogo
 */
public interface InputRestriction
{
    /**
     * Checks if the string input is valid, according to the restrictions defined.
     * @param data (String) The data to be verified.
     * @return (boolean) True if it passes the restriction check. 
     */
    public boolean isValid(String data);
    
    /**
     * Returns the reason why an input is invalid.
     * @return (String) The reason the input is invalid.
     */
    public String getReason();
}
