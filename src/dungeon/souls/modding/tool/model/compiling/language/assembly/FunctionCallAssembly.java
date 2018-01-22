/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.Function_callContext;

/**
 * Represents an isolated function call in assembly.
 * @author Diogo
 */
public class FunctionCallAssembly implements AssemblyCode
{
    /**
     * Digested version of the funciton call.
     */
    private String digestedFunction;

    private FunctionCallAssembly()
    {
        
    }
    
    /**
     * Parses a function call from the context.
     * @param context
     * @return 
     */
    public static FunctionCallAssembly parseFrom(Function_callContext context)
    {
        FunctionCallAssembly result = new FunctionCallAssembly();
        if (context!=null)
        {
            result.digestedFunction=transformFunctionCall(context.getText());
        }
        return result;
    
    }
    /**
     * Transforms the original function syntax into the assembly version.
     * @param originalCall (String) The function call in the original syntax.
     * @return 
     */
    public static final String transformFunctionCall(String originalCall)
    {
        String result = null;
        if (originalCall!=null)
        {
            result = originalCall.replaceAll("\\(", " ").replaceAll("\\)","").replaceAll(",", " ");
        }
        return result;
    }
    
    @Override
    public String toAssembly()
    {
        return AssemblyCodeLibrary.ASSEMBLY_FUNCTION_CALL+" "+digestedFunction;
    }
    
}
