/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui.input.verifiers;

/**
 * Checks if a string isn't either null or empty.
 * @author Diogo
 */
public class StringNotEmtyRestriction implements InputRestriction
{

    @Override
    public boolean isValid(String data)
    {
        return data!=null && !data.isEmpty();
    }

    @Override
    public String getReason()
    {
        return "Cannot be empty!";
    }
    
}
