/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import static dungeon.souls.modding.tool.model.compiling.language.assembly.AssemblyUtilities.parseExplicitCode;

/**
 * Represents an if/if_else in assembly.
 * @author Diogo
 */
public class ForAssembly implements AssemblyCode
{

    /**
     * The code to be executed inside the loop.
     */
    private CodeBlockAssembly loopCode;
    
    /**
     * The condition to run.
     */
    private ConditionAssembly condition;
    
    /**
     * The condition, inside a block of code. This way,
     * GML can come back to it.
     */
    private CodeBlockAssembly conditionBlock;
    
    /**
     * Assignment statement.
     */
    private AssignmentAssembly assignment;
    
    /**
     * Code to perform when incrementing.
     */
    private CodeBlockAssembly iterationIncrementCode;
    
    private ForAssembly()
    {
    }
    
    /**
     * Parses module data from the context.
     * @param ctx
     * @return
     */
    public static ForAssembly parseFrom(BaseGrammarParser.For_statementContext ctx)
    {
        ForAssembly result = new ForAssembly();
        result.condition=ConditionAssembly.parseFrom(ctx.condition());
        result.conditionBlock=new CodeBlockAssembly();
        result.conditionBlock.addAssemblyCode(result.condition);
        AssemblyCode temp = parseExplicitCode(ctx.explicit_code());
        if (temp.getClass().equals(CodeBlockAssembly.class))
        {
            result.loopCode =(CodeBlockAssembly)temp;
        }
        else
        {
            result.loopCode = new CodeBlockAssembly();
            result.loopCode.addAssemblyCode(temp);
        }
        temp = AssemblyUtilities.parseFreeExpression(ctx.free_expression());
        result.iterationIncrementCode = new CodeBlockAssembly();
        result.iterationIncrementCode.addAssemblyCode(temp);
        result.assignment=AssignmentAssembly.buildFrom(ctx.assignment());
        return result;
    }
    
    @Override
    public String toAssembly()
    {
        String result = assignment.toAssembly()+"\n";//condition.toAssembly()+"\n";
        result+=AssemblyCodeLibrary.ASSEMBLY_FOR_LOOP+" "+condition.getConditionResultRegistry()+" "+conditionBlock.toString()+" "+iterationIncrementCode.toString()+" "+loopCode.toString()+"\n";
        result+=conditionBlock.toAssembly()+"\n";
        result+=loopCode.toAssembly()+"\n";
        result+=iterationIncrementCode.toAssembly();
        return result;
    }
}
