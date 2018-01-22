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
        result.codeBlock=result.parseCodeBlock(ctx.block_code());
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
    
    private CodeBlockAssembly parseCodeBlock(Block_codeContext context)
    {
        CodeBlockAssembly result = new CodeBlockAssembly();
        AssemblyCode temp;
        for (ParseTree tree:context.children)
        {
            temp=null;
            if (tree.getClass().equals(StatementContext.class))
            {
                temp=parseStatement((StatementContext)tree);
            }
            else if (tree.getClass().equals(Block_codeContext.class))
            {
                temp=parseCodeBlock((Block_codeContext)tree);
            }
            if (temp!=null) //If we have found a valid code statement.
            {
                if (temp.getClass().equals(AssemblyCodeCollection.class))
                {
                    AssemblyCodeCollection collection = (AssemblyCodeCollection)temp;
                    for (Object element:collection)
                    {
                        result.addAssemblyCode((AssemblyCode)element);
                    }
                }
                else
                {
                    result.addAssemblyCode(temp);
                }
            }
        }
        return result;
    }
    
    private AssemblyCode parseStatement(StatementContext context)
    {
        AssemblyCode result = null;
        if (context.expression()!=null)
        {
            result = parseExpression(context.expression());
        }
        else if (context.if_statement()!=null)
        {
            result = parseIfStatement(context.if_statement());
        }
        return result;
    }
    
    private AssemblyCode parseIfStatement(If_statementContext context)
    {
        AssemblyCodeCollection result = new AssemblyCodeCollection();
        int limit = context.explicit_code().size();
        IfAssembly assembly = null;
        if (!context.ELSE().isEmpty())
        {
            limit--; //Last code will be other ifs..
        }
        for (int i=0;i<limit;i++)
        {
            assembly = new IfAssembly();
            assembly.setComparison(ComparisonAssembly.parseFrom(context.comparison(i)));
            CodeBlockAssembly ifCode;
            AssemblyCode temp = parseExplicitCode(context.explicit_code(i));
            if (temp.getClass().equals(CodeBlockAssembly.class))
            {
                ifCode=(CodeBlockAssembly)temp;
            }
            else
            {
                ifCode = new CodeBlockAssembly();
                ifCode.addAssemblyCode(temp);
            }
            assembly.setIfCode(ifCode);
            result.add(assembly);
        }
        if (context.ELSE(0)!=null)
        {
            if (assembly!=null)
            {
                AssemblyCode elseCode = parseExplicitCode(context.explicit_code(limit));
                if (elseCode instanceof AssemblyCodeCollection)
                {
                    AssemblyCodeCollection collection = (AssemblyCodeCollection)elseCode;
                    CodeBlockAssembly block = new CodeBlockAssembly();
                    for (Object element:collection)
                    {
                        block.addAssemblyCode((AssemblyCode) element);
                    }
                    assembly.setElseCode(block);
                }
                else
                {
                    CodeBlockAssembly block = new CodeBlockAssembly();
                    block.addAssemblyCode(elseCode);
                    assembly.setElseCode(block);
                }
            }
        }
        return result;
    }
    
    private AssemblyCode parseExplicitCode(Explicit_codeContext context)
    {
        AssemblyCode result = null;
        if (context!=null)
        {
            if (context.block_code()!=null)
            {
                result = parseCodeBlock(context.block_code());
            }
            else if (context.statement()!=null)
            {
                result = parseStatement(context.statement());
            }
        }
        return result;
    }
    
    private AssemblyCode parseExpression(BaseGrammarParser.ExpressionContext expression)
    {
        AssemblyCode result = null;
        //Do not worry about function arguments here. These can be processed without being sensitive to order.
        if (expression.assignment()!=null)
        {
            result = AssignmentAssembly.buildFrom(expression.assignment());
        }
        else if (expression.function_call()!=null)
        {
            result = FunctionCallAssembly.parseFrom(expression.function_call());
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
