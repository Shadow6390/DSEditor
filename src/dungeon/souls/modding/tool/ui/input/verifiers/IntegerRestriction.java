/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.ui.input.verifiers;

/**
 * Checks if a string is an integer.
 * @author Diogo
 */
public class IntegerRestriction implements InputRestriction
{

    private String reason;
    
    @Override
    public boolean isValid(String data)
    {
        boolean result = true;
        try
        {
            Integer.parseInt(data);
        }
        catch (NumberFormatException e)
        {
            result=false;
            reason="'"+data+"' is not a whole number";
        }
        return result;
    }

    @Override
    public String getReason()
    {
        return reason;
    }
    
}
