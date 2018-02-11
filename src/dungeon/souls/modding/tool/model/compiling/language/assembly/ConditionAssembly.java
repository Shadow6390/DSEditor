/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.ConditionContext;
import java.util.LinkedList;
import java.util.List;
import oracle.jrockit.jfr.tools.ConCatRepository;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Represents the comparison in assembly.
 * @author Diogo
 */
public class ConditionAssembly implements AssemblyCode
{
        
    /**
     * The memory slot that will hold the comparison result.
     */
    private MemoryAssignmentAssembly resultMemorySlot;
    
    /**
     * The comparisons within this condition.
     */
    private List<ComparisonAssembly> comparisons;
    
    /**
     * A list containing the conditional operators.
     */
    private List<String> conditionalOperators;
    
    private ConditionAssembly()
    {
        comparisons = new LinkedList<>();
        conditionalOperators = new LinkedList<>();
        resultMemorySlot = MemoryAssignmentAssembly.allocate();
    }
    
    /**
     * Parses a condition assembly.
     * @param context
     * @return 
     */
    public static ConditionAssembly parseFrom(ConditionContext context)
    {
        ConditionAssembly result = new ConditionAssembly();
        for (int i=0;i<context.comparison().size();i++)
        {
            result.comparisons.add(ComparisonAssembly.parseFrom(context.comparison(i)));
        }
        for (int i=0;i<context.conditional_operator().size();i++)
        {
            result.conditionalOperators.add(context.conditional_operator(i).getText());
        }
        
        return result;
    }
    
    /**
     * Returns the registry where the comparison is kept.
     * @return 
     */
    public String getConditionResultRegistry()
    {
        return resultMemorySlot.toString();
    }
    
    @Override
    public String toAssembly()
    {
        String result = "";
        for (ComparisonAssembly elem:comparisons)
        {
            result+=elem.toAssembly()+"\n";
        }
        result+=AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_CONDITION+" "+resultMemorySlot.toString()+" ";
        for (int i=0;i<comparisons.size()-1;i++)
        {
            result+=comparisons.get(i).getComparisonResultRegistry()+" "+conditionalOperators.get(i)+" ";
        }
        result+=comparisons.get(comparisons.size()-1).getComparisonResultRegistry();
        return result;
    }
    
}
