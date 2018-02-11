/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import static dungeon.souls.modding.tool.model.compiling.language.assembly.AssemblyUtilities.parseExplicitCode;
import java.util.List;

/**
 * Represents an if/if_else in assembly.
 * @author Diogo
 */
public class WhileAssembly implements AssemblyCode
{

    /**
     * The code to be executed inside the loop.
     */
    private CodeBlockAssembly loopCode;
    
    /**
     * The condition.
     */
    private ConditionAssembly condition;
    
    /**
     * The condition block.
     */
    private CodeBlockAssembly conditionBlock;
    
    private WhileAssembly()
    {
    }
    
    /**
     * Parses module data from the context.
     * @param ctx
     * @return
     */
    public static WhileAssembly parseFrom(BaseGrammarParser.While_statementContext ctx)
    {
        WhileAssembly result = new WhileAssembly();
        result.conditionBlock=new CodeBlockAssembly();
        result.condition=ConditionAssembly.parseFrom(ctx.condition());
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
        return result;
    }
    
    @Override
    public String toAssembly()
    {
        String result = "";
        result+=AssemblyCodeLibrary.ASSEMBLY_WHILE_LOOP+" "+condition.getConditionResultRegistry()+" "+conditionBlock.toString()+" "+loopCode.toString()+"\n";
        result+=loopCode.toAssembly()+"\n";
        result+=conditionBlock.toAssembly();
        return result;
    }
}
