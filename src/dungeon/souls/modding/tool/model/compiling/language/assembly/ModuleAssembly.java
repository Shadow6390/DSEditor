/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.Block_codeContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.Explicit_codeContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.If_statementContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.StatementContext;
import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser.ValueContext;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Assembly version of the module.
 * @author Diogo
 */
public class ModuleAssembly implements AssemblyCode
{
    
    /**
     * The name of the module's variable.
     */
    private String moduleVariableName;
    /**
     * Name of module
     */
    private String name;
        
    /**
     * Version of module
     */
    private String version;

    /**
     * Description of module.
     */
    private String description;

    /**
     * Item dir of module.
     */
    private String itemDir;

    /**
     * Sprite dir of module.
     */
    private String spriteDir;

    private static final String DEFAULT_DESCRIPTION = "A module for Dungeon Souls";

    private static final String DEFAULT_MISSING_VALUE = "-1";
    
    /**
     * The block of code that defines the module.
     */
    private CodeBlockAssembly codeBlock;

    private ModuleAssembly()
    {
        description = DEFAULT_DESCRIPTION;
        spriteDir = DEFAULT_MISSING_VALUE;
        itemDir = DEFAULT_MISSING_VALUE;
        codeBlock = new CodeBlockAssembly();
    }

    /**
     * Parses module data from the context.
     * @param ctx
     * @return
     */
    public static ModuleAssembly parseFrom(BaseGrammarParser.AssetModuleContext ctx)
    {
        ModuleAssembly result = new ModuleAssembly();
        List<BaseGrammarParser.AssignmentContext> assignments = result.getAssigments(ctx);
        result.moduleVariableName=ctx.VARIABLE().getText();
        result.parseModuleVariables(assignments);
        result.codeBlock=AssemblyUtilities.parseCodeBlock(ctx.block_code());
        return result;
    }

    /**
     * Checks if all required fields are valid. In case they are not, a list of
     * reasons will be returned. If the info is valid, the list will be empty.
     *
     * @return
     */
    public List<String> validate()
    {
        List<String> result = new LinkedList();
        if (moduleVariableName == null) //Impossible to happen, but still check
        {
            result.add("module variable not found (SEVERE).");
        }
        if (name == null)
        {
            result.add("module name must be defined by a constant value.");
        }
        else if (name.isEmpty())
        {
            result.add("module name must not be empty.");
        }
        if (version == null)
        {
            result.add("module version must be defined by a constant value.");
        }
        else if (version.isEmpty())
        {
            result.add("module version must not be empty.");
        }
        return result;
    }
    
    
    private void parseModuleVariables(List<BaseGrammarParser.AssignmentContext> assignments)
    {
        for (BaseGrammarParser.AssignmentContext context : assignments)
        {
            TerminalNode gvar = context.variable().GAME_VARIABLE();
            if (gvar != null)
            {
                ValueContext vcon = context.math_value().value();
                if (gvar.getText().equals("[NAME]"))
                {
                    name = (vcon == null) ? null : vcon.getText();
                }
                else if (gvar.getText().equals("[VERSION]"))
                {
                    version = (vcon == null) ? null : vcon.getText();
                }
                else if (gvar.getText().equals("[DESCRIPTION]"))
                {
                    description = (vcon == null) ? DEFAULT_DESCRIPTION : vcon.getText();
                }
                else if (gvar.getText().equals("[ITEM_DIR]"))
                {
                    itemDir = (vcon == null) ? DEFAULT_MISSING_VALUE : vcon.getText();
                }
                else if (gvar.getText().equals("[SPRITE_DIR]"))
                {
                    spriteDir = (vcon == null) ? DEFAULT_MISSING_VALUE : vcon.getText();
                }
            }
        }
    }

    private List<BaseGrammarParser.AssignmentContext> getAssigments(BaseGrammarParser.AssetModuleContext ctx)
    {
        List<BaseGrammarParser.AssignmentContext> result = new LinkedList();
        getAssigmentsRecurse(ctx, result);
        return result;
    }

    private void getAssigmentsRecurse(ParseTree tree, List<BaseGrammarParser.AssignmentContext> contextList)
    {
        if (tree.getChildCount() > 0)
        {
            for (int i = 0; i < tree.getChildCount(); i++)
            {
                getAssigmentsRecurse(tree.getChild(i), contextList);
            }
            if (tree.getClass().equals(BaseGrammarParser.AssignmentContext.class))
            {
                contextList.add((BaseGrammarParser.AssignmentContext) tree);
            }
        }
    }

    @Override
    public String toAssembly()
    {
        String result = String.format("modding_define_module %s %s %s %s %s %s %s",moduleVariableName,name,version,description,itemDir,spriteDir,codeBlock.toString());
        result+="\n"+codeBlock.toAssembly();
        return result;
    }
}
