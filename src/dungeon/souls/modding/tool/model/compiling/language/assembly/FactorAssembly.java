/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Represents the assembly version of the factor node.
 * @author Diogo
 */
public class FactorAssembly implements AssemblyCode
{
    private List<TermAssembly> terms;
    
    /**
     * The operations of the term.
     * This can be empty.
     */
    private List<String> operations;
    
    /**
     * The slot of memory to use for temporary allocation of values.
     */
    private MemoryAssignmentAssembly memorySlot;
    
    public FactorAssembly()
    {
        terms = new LinkedList();
        operations = new LinkedList();
        memorySlot=MemoryAssignmentAssembly.allocate();
    }
    
    public static List<FactorAssembly> parseFactors(BaseGrammarParser.Math_operationContext context)
    {
        List<FactorAssembly> result = new LinkedList();
        for (BaseGrammarParser.FactorContext factorContext: context.factor())
        {
            FactorAssembly assembly = new FactorAssembly();
            assembly.terms.addAll(TermAssembly.parseTerms(factorContext));
            for (TerminalNode node:factorContext.MATH_OPERATOR_MULT_DIV())
            {
                assembly.operations.add(node.getText());
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
        String childAssembly = "";
        List<String> registryValues = new LinkedList(); //Keeps record of the registries to add later.
        for (TermAssembly assembly: terms)
        {
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
