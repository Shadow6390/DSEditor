/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.TermContext;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Represents an assembly version of math operations with priority (delimited by
 * brackets).
 * @author Diogo
 */
public class PrioritizedMathOperationAssembly implements AssemblyCode
{
    /**
     * The factors of this prioritized math operation assembly.
     */
    private List<FactorAssembly> factors;
    
    /**
     * The operations of the term.
     * This can be empty.
     */
    private List<String> operations;
    
    /**
     * The slot of memory to use for temporary allocation of values.
     */
    private MemoryAssignmentAssembly memorySlot;
    
    public PrioritizedMathOperationAssembly()
    {
        factors = new LinkedList();
        operations = new LinkedList();
        memorySlot=MemoryAssignmentAssembly.allocate();
    }

    public static PrioritizedMathOperationAssembly parsePrioritizedMathOperations(TermContext context)
    {
        PrioritizedMathOperationAssembly result = new PrioritizedMathOperationAssembly();
        if (context.math_operation()!=null)
        {
            result.factors.addAll(FactorAssembly.parseFactors(context.math_operation()));
            for (TerminalNode node:context.math_operation().MATH_OPERATOR_PLUS_MINUS())
            {
                result.operations.add(node.getText());
            }
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
        String childAssembly = "";
        List<String> registryValues = new LinkedList(); //Keeps record of the registries to add later.
        FactorAssembly assembly;
        for (int i=0;i<factors.size();i++)
        {
            assembly = factors.get(i);
            childAssembly+=assembly.toAssembly()+"\n";
            registryValues.add(assembly.getMemoryRegistry());
        }
        String result = childAssembly+AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_REGISTRY+" "+getMemoryRegistry()+" ";
        for (int i=0;i<registryValues.size()-1;i++)
        {
            result+=registryValues.get(i)+" "+operations.get(i)+" ";
        }
        result+=registryValues.get(registryValues.size()-1);
        return result;
    }
}
