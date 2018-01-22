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
 * Assembly version of assignment.
 * @author Diogo
 */
public class AssignmentAssembly implements AssemblyCode
{

    /**
     * The variable whose value will be changed.
     */
    private String variable;
    
    /**
     * The values to add.
     */
    private List<String> values;
    
    /**
     * The operations of the term.
     * This can be empty.
     */
    private List<String> operations;
    
    /**
     * The factors of this assignment.
     */
    private List<FactorAssembly> factors;
    
    /**
     * The math value of the assignment.
     * Only different from null if the expression is not a mathematical formula (x+y++...)
     */
    private String math_value;
    
    /**
     * The memory for the math_value case.
     */
    private MemoryAssignmentAssembly mem;
    
    private AssignmentAssembly()
    {
        values = new LinkedList();
        operations = new LinkedList(); //There must always exist values.size()-1 operations;
    }
    
    public static AssignmentAssembly buildFrom(BaseGrammarParser.AssignmentContext context)
    {
        AssignmentAssembly result = null;
        if (context!=null)
        {
            if (context.variable().GAME_VARIABLE()==null)
            {
                result = new AssignmentAssembly();
                result.variable=context.variable().getText();
                result.constructExpression(context);
            }
        }
        return result;
    }
    
    /**
     * Constructs the rest of the assignment assembly expression.
     * @param context 
     */
    private void constructExpression(BaseGrammarParser.AssignmentContext context)
    {
        //It's gonna be a complicated method. Basically, assignment, at highest complexity, have a math operation.
        //Math operations can have multiple factors. Factors can have multiple terms. Terms can have multiple prioritized math operations.
        //Prioritized math operations can ahve multiple factors, etc. etc.
        if (context.math_operation()!=null)
        {
            factors = FactorAssembly.parseFactors(context.math_operation());        
            for (TerminalNode node:context.math_operation().MATH_OPERATOR_PLUS_MINUS())
            {
                operations.add(node.getText());
            }
        }
        else
        {
            if (context.math_value()!=null)
            {
                mem = MemoryAssignmentAssembly.allocate();
                String text = context.math_value().getText();
                if (context.math_value().function_call()!=null)
                {
                    math_value = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_FUNCTION+" "+mem.toString()+" "+FunctionCallAssembly.transformFunctionCall(text);
                }
                else if (context.math_value().value()!=null)
                {
                    math_value = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VALUE+" "+mem.toString()+" "+text;
                }
                else if (context.math_value().variable()!=null)
                {
                    math_value = AssemblyCodeLibrary.ASSEMBLY_ASSIGN_REGISTRY_VARIABLE+" "+mem.toString()+" "+text;
                }
            }
        }
    }
    
    @Override
    public String toAssembly()
    {
        String result;
        String childAssembly = "";
        List<String> registryValues = new LinkedList(); //Keeps record of the registries to add later.
        FactorAssembly assembly;
        if (math_value==null)
        {
            for (int i=0;i<factors.size();i++)
            {
                assembly = factors.get(i);
                childAssembly+=assembly.toAssembly()+"\n";
                registryValues.add(assembly.getMemoryRegistry());
            }
        
            result = childAssembly+String.format("modding_set_value %s ",variable);
            for (int i=0;i<registryValues.size()-1;i++)
            {
                result+=registryValues.get(i)+" "+operations.get(i)+" ";
            }
            if (!registryValues.isEmpty())
            {
                result+=registryValues.get(registryValues.size()-1);
            }
        }
        else
        {
            result = math_value;
            result+="\n"+String.format("modding_set_value %s",variable)+" "+mem.toString(); 
        }
        return result;
    }
}
