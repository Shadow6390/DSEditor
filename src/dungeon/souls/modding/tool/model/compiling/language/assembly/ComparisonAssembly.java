/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.ComparisonContext;

/**
 * Represents the comparison in assembly.
 * @author Diogo
 */
public class ComparisonAssembly implements AssemblyCode
{

    /**
     * The first comparison value.
     */
    private String firstComparisonRegister;
    
    /**
     * The second comparison value.
     */
    private String secondComparisonRegister;
    
    /**
     * The comparison operator to use.
     */
    private String comparisonOperator;
    
    /**
     * The memory slots used in the comparison.
     */
    private MemoryAssignmentAssembly[] memorySlots;
    
    private ComparisonAssembly()
    {
        memorySlots= new MemoryAssignmentAssembly[3];
        for (int i=0;i<memorySlots.length;i++)
        {
            memorySlots[i]= MemoryAssignmentAssembly.allocate();
        }
    }
    
    /**
     * Parses a comparison assembly.
     * @param context
     * @return 
     */
    public static ComparisonAssembly parseFrom(ComparisonContext context)
    {
        ComparisonAssembly result = new ComparisonAssembly();
        String text = context.children.get(0).getText();
        if (context.function_call(0)!=null)
        {
            result.firstComparisonRegister = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_FUNCTION+" "+result.memorySlots[0].toString()+" "+FunctionCallAssembly.transformFunctionCall(text);
        }
        else if (context.variable(0)!=null)
        {
            result.firstComparisonRegister = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VARIABLE+" "+result.memorySlots[0].toString()+" "+text;
        }
        else
        {
            result.firstComparisonRegister = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VALUE+" "+result.memorySlots[0].toString()+" "+text;
        }
        
        text = context.children.get(2).getText();
        if (context.function_call(1)!=null)
        {
            result.secondComparisonRegister = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_FUNCTION+" "+result.memorySlots[1].toString()+" "+FunctionCallAssembly.transformFunctionCall(text);
        }
        else if (context.variable(1)!=null)
        {
            result.secondComparisonRegister = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VARIABLE+" "+result.memorySlots[1].toString()+" "+text;
        }
        else
        {
            result.secondComparisonRegister = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VALUE+" "+result.memorySlots[1].toString()+" "+text;
        }
        result.comparisonOperator = context.OPERATOR().getText();
        
        return result;
    }
    
    /**
     * Returns the registry where the comparison is kept.
     * @return 
     */
    public String getComparisonResultRegistry()
    {
        return memorySlots[2].toString();
    }
    
    @Override
    public String toAssembly()
    {
        String result = firstComparisonRegister+"\n"+secondComparisonRegister+"\n";
        result+=AssemblyCodeLibrary.ASSEMBLY_COMPARISON+" "+memorySlots[2]+" "+memorySlots[0].toString()+" "+memorySlots[1]+" "+comparisonOperator;
        return result;
    }
    
}
