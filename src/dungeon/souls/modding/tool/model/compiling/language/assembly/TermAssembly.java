/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.FactorContext;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the assembly version of the term node.
 * @author Diogo
 */
public class TermAssembly implements AssemblyCode
{
    /**
     * 
     */
    private PrioritizedMathOperationAssembly priority;
    
    /**
     * The value of the term.
     */
    private String value;
    
    /**
     * The variable of the term.
     */
    private String variable;
    
    /**
     * The function of the term, if the value is a function.
     */
    private String function;
        
    /**
     * The slot of memory to use for temporary allocation of values.
     */
    private MemoryAssignmentAssembly memorySlot;
    
    /**
     * Creates an assembly version of the term.
     */
    public TermAssembly()
    {
        memorySlot = MemoryAssignmentAssembly.allocate();
    }
    
    public static List<TermAssembly> parseTerms(FactorContext context)
    {
        List<TermAssembly> result = new LinkedList();
        for (BaseGrammarParser.TermContext termContext:context.term())
        {
            TermAssembly assembly = new TermAssembly();
            if (termContext.math_operation()!=null)
            {
                assembly.priority=PrioritizedMathOperationAssembly.parsePrioritizedMathOperations(termContext);
            }
            else
            {
                String text = termContext.math_value().getText();
                if (termContext.math_value().function_call()!=null)
                {
                    assembly.function = FunctionCallAssembly.transformFunctionCall(text);
                }
                else if (termContext.math_value().variable()!=null)
                {
                    assembly.variable = text;
                }
                else
                {
                    assembly.value = text;
                }
            }
            result.add(assembly);
        }
        return result;
    }
    
    /**
     * Returns the memory slot registry allocated to this term.
     * @return 
     */
    public String getMemoryRegistry()
    {
        return memorySlot.toString();
    }

    @Override
    public String toAssembly()
    {
        String result = "(TERM ERROR)";
        if (priority!=null)
        {
            String childAssembly = priority.toAssembly();
            result=childAssembly+
                    "\n"+AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_REGISTRY+" "+getMemoryRegistry()+" "+priority.getMemoryRegistry();
        }
        else if (value!=null)
        {
            result=AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VALUE+" "+getMemoryRegistry()+" "+value;
        }
        else if (variable!=null)
        {
            result=AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VARIABLE+" "+getMemoryRegistry()+" "+variable;
        }
        else if (function!=null)
        {
            result=AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_FUNCTION+" "+getMemoryRegistry()+" "+function;
        }
        return result;
    }
    
}
