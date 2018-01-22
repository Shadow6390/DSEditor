/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import java.util.Arrays;
import java.util.List;
import org.antlr.v4.runtime.misc.Interval;

/**
 * Represents an error message obtained during compilation, at a specific interval
 * in the text to be processed.
 * @author Diogo
 */
public class CompilationErrorMessage
{
    private String message;
    
    private Interval interval;
    
    private String[] suggestions;
    
    private int line;
    
    private int column;
    
    /**
     * Creates a new compilation error message.
     * @param message (String) The message to display.
     * @param interval (Interval) The interval where the error occurred at.
     * @param suggestions (String[]) Any suggestions to fix the error, if it is possible.
     * @param line (int) The line where the error occurred at.
     * @param column (int) The column where the error occurred at.
     */
    public CompilationErrorMessage(String message,Interval interval,String[] suggestions,int line,int column)
    {
        this.message=message;
        this.interval=interval;
        this.suggestions=suggestions;
        this.line=line;
        this.column=column;
    }
    
    /**
     * Returns the suggestions of this error message.
     * @return 
     */
    public List<String> getSuggestionList()
    {
        return Arrays.asList(suggestions);
    }
    
    /**
     * Returns the suggestions of this error message.
     * @return 
     */
    public String[] getSuggestions()
    {
        return suggestions;
    }
    
    /**
     * Returns the interval at which this error occurred.
     * @return 
     */
    public Interval getInterval()
    {
        return interval;
    }
    
    @Override
    public String toString()
    {
        return "At line "+line+" and column "+column+": "+message;
    }
}
