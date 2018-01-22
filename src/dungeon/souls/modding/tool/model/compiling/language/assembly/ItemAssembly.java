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
import dungeon.souls.modding.tool.model.item.ItemCodeTemplate;
import dungeon.souls.modding.tool.model.item.ItemTemplateData;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Assembly version of the item.
 * @author Diogo
 */
public class ItemAssembly implements AssemblyCode
{
    
    /**
     * The name of the item's variable.
     */
    private String variableName;
    
    /**
     * The data of the item.
     */
    private ItemTemplateData data;
    
    /**
     * The block of code that defines the module.
     */
    private CodeBlockAssembly codeBlock;
    
    /**
     * The errors obtained.
     */
    private List<String> errors;

    private ItemAssembly()
    {
        data = new ItemTemplateData();
        data.description="Modded Item";
        data.maxStacks=1;
        data.price=0;
        data.type=ItemCodeTemplate.ITEM_PASSIVE;
        data.rarity=ItemCodeTemplate.RARITY_COMMON;
        codeBlock = new CodeBlockAssembly();
        errors = new LinkedList();
    }

    /**
     * Parses module data from the context.
     * @param ctx
     * @return
     */
    public static ItemAssembly parseFrom(BaseGrammarParser.AssetItemContext ctx)
    {
        ItemAssembly result = new ItemAssembly();
        List<BaseGrammarParser.AssignmentContext> assignments = result.getAssigments(ctx);
        result.variableName=ctx.VARIABLE().getText();
        result.parseItemVariables(assignments);
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
        if (variableName == null) //Impossible to happen, but still check
        {
            result.add("item variable not found (SEVERE).");
        }
        if (data.name == null)
        {
            result.add("item name must be defined by a constant value.");
        }
        else if (data.name.isEmpty())
        {
            result.add("item name must not be empty.");
        }
        if (data.sprite==null)
        {
            result.add("sprite must not be empty.");
        }
        if (data.price<0)
        {
            result.add("price must be >=0");
        }
        if (data.maxStacks<1)
        {
            result.add("max_stacks must be >= 1");
        }
        if (!ItemCodeTemplate.ITEM_RARITIES_LIST.contains(data.rarity.replaceAll("\"","")))
        {
            result.add("invalid rarity (was "+data.rarity+"; has to be one of the following: "+ItemCodeTemplate.ITEM_RARITIES_LIST.toString()+")");
        }
        if (!ItemCodeTemplate.ITEM_TYPES_LIST.contains(data.type.replaceAll("\"","")))
        {
            result.add("invalid type (was "+data.type+"; has to be one of the following: "+ItemCodeTemplate.ITEM_TYPES_LIST.toString()+")");
        }
        result.addAll(errors);
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
    
    private void parseItemVariables(List<BaseGrammarParser.AssignmentContext> assignments)
    {
        for (BaseGrammarParser.AssignmentContext context : assignments)
        {
            TerminalNode gvar = context.variable().GAME_VARIABLE();
            if (gvar != null)
            {
                if (context.math_value()!=null)
                {
                    ValueContext vcon = context.math_value().value();
                    BaseGrammarParser.Function_callContext fcon = context.math_value().function_call();
                    if (gvar.getText().equals("[NAME]"))
                    {
                        data.name = (vcon == null) ? null : vcon.getText();
                    }
                    else if (gvar.getText().equals("[DESCRIPTION]"))
                    {
                        data.description = (vcon == null) ? data.description : vcon.getText();
                    }
                    else if (gvar.getText().equals("[SPRITE]"))
                    {
                        if (context.math_value().variable()!=null)
                        {
                            data.sprite = context.math_value().variable().getText();
                        }
                        else
                        {
                            errors.add("item sprite must be a variable");
                        }
                    }
                    else if (gvar.getText().equals("[TYPE]"))
                    {
                        if (vcon!=null)
                        {
                            if (vcon.STRING()!=null)
                            {
                                data.type=vcon.getText();
                            }
                            else
                            {
                                errors.add("item type must be a string");
                            }
                        }
                    }
                    else if (gvar.getText().equals("[RARITY]"))
                    {
                        if (vcon!=null)
                        {
                            if (vcon.STRING()!=null)
                            {
                                data.rarity=vcon.getText();
                            }
                            else
                            {
                                errors.add("item rarity must be a string");
                            }
                        }
                    }
                    else if (gvar.getText().equals("[PRICE]"))
                    {
                        if (vcon!=null)
                        {
                            if (vcon.REAL()!=null)
                            {
                                try
                                {
                                    data.price=Integer.parseInt(vcon.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    errors.add("item price must be an integer value");
                                }
                            }
                            else
                            {
                                errors.add("item price must be an integer value (not a string)");
                            }
                        }
                    }
                    else if (gvar.getText().equals("[MAX_STACKS]"))
                    {
                        if (vcon!=null)
                        {
                            if (vcon.REAL()!=null)
                            {
                                try
                                {
                                    data.maxStacks=Integer.parseInt(vcon.getText());
                                }
                                catch (NumberFormatException e)
                                {
                                    errors.add("item max_stacks must be an integer value");
                                }
                            }
                            else
                            {
                                errors.add("item max_stacks must be an integer value (not a string)");
                            }
                        }
                    }
                    else if (gvar.getText().equals("[ON_PICKUP_FUNCTION]"))
                    {
                        if (fcon!=null)
                        {
                            data.onPickupFunction=FunctionCallAssembly.transformFunctionCall(fcon.getText());
                        }
                        else
                        {
                            errors.add("on_pickup_function must be a function call");
                        }
                    }
                    else if (gvar.getText().equals("[ON_ACTIVE_FUNCTION]"))
                    {
                        if (fcon!=null)
                        {
                            data.onActiveFunction=FunctionCallAssembly.transformFunctionCall(fcon.getText());
                        }
                        else
                        {
                            errors.add("on_active_function must be a function call");
                        }
                    }
                    else if (gvar.getText().equals("[ON_STEP_FUNCTION]"))
                    {
                        if (fcon!=null)
                        {
                            data.onStepFunction=FunctionCallAssembly.transformFunctionCall(fcon.getText());
                        }
                        else
                        {
                            errors.add("on_step_function must be a function call");
                        }
                    }
                }
                else
                {
                    errors.add("'"+context.getText()+"' does not have a value assigned");
                }
            }
        }
    }

    private List<BaseGrammarParser.AssignmentContext> getAssigments(BaseGrammarParser.AssetItemContext ctx)
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
    public boolean equals(Object other)
    {
        boolean result = other!=null && getClass().equals(other.getClass());
        if (result)
        {
            ItemAssembly assembly = (ItemAssembly) other;
            result = (this==other) || (variableName.equals(assembly.variableName));
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.variableName);
        return hash;
    }
    
    @Override
    public String toString()
    {
        return variableName;
    }
    
    @Override
    public String toAssembly()
    {
        String result = String.format("modding_define_item %s %s %s %s %d %d %s %s %s",variableName,data.name,data.description,data.sprite,data.maxStacks,data.price,data.type,data.rarity,codeBlock.toString());
        if (data.onPickupFunction!=null)
        {
            result+=String.format("\nmodding_item_set_pickup_function %s %s",variableName,data.onPickupFunction);
        }
        if (data.onActiveFunction!=null)
        {
            result+=String.format("\nmodding_item_set_active_function %s %s",variableName,data.onActiveFunction);
        }
        if (data.onStepFunction!=null)
        {
            result+=String.format("\nmodding_item_set_step_function %s %s",variableName,data.onStepFunction);
        }
        result+="\n"+codeBlock.toAssembly();
        return result;
    }
}
