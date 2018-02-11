/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

/**
 * Represents an assignment of a game variable.
 * Currently, only used by the editor (and not used in the translation process).
 * @author Diogo
 */
public class GameVariableAssignment
{
    /**
     * The name of the game variable.
     */
    private String gameVariable;
    
    /**
     * The value of the game variable.
     */
    private String value;
    
    //Private constructor.
    private GameVariableAssignment()
    {
        
    }
    
    /**
     * Parses a game variable assignment from the assignment context.
     * @param ctx
     * @return The game variable assignment. Can be null if the variable is not
     * a game variable.
     */
    public static GameVariableAssignment parseFrom(BaseGrammarParser.AssignmentContext ctx)
    {
        GameVariableAssignment result = null;
        if (ctx.variable().GAME_VARIABLE()!=null)
        {
            result = new GameVariableAssignment();
            result.setGameVariable(ctx.variable().GAME_VARIABLE().getText());
            if (ctx.math_value()!=null)
            {
                result.setValue(ctx.math_value().getText());
            }
            else
            {
                result.setValue(ctx.math_operation().getText());
            }
        }
        return result;
    }

    /**
     * @return the gameVariable
     */
    public String getGameVariable()
    {
        return gameVariable;
    }

    /**
     * @param gameVariable the gameVariable to set
     */
    public void setGameVariable(String gameVariable)
    {
        this.gameVariable = gameVariable;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value)
    {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return gameVariable+"="+value;
    }
}
