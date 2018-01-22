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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Assembly version of the function.
 * @author Diogo
 */
public class FunctionAssembly implements AssemblyCode
{
    
    /**
     * The arguments of the function.
     */
    private List<String> arguments;
    
    /**
     * The result argument (if available).
     */
    private String resultArgument;

    /**
     * The name of the function.
     */
    private String variable;
    
    /**
     * Errors found during semantics check.
     */
    private List<String> errorMessages;
    
    /**
     * The block of code that defines the module.
     */
    private CodeBlockAssembly codeBlock;

    private FunctionAssembly()
    {
        codeBlock = new CodeBlockAssembly();
        errorMessages = new LinkedList();
        arguments = new LinkedList();
    }

    /**
     * Parses module data from the context.
     * @param ctx
     * @return
     */
    public static FunctionAssembly parseFrom(BaseGrammarParser.AssetFunctionContext ctx)
    {
        FunctionAssembly result = new FunctionAssembly();
        List<BaseGrammarParser.ExpressionContext> assignments = result.getExpressionsWithArguments(ctx);
        result.variable=ctx.VARIABLE().getText();
        result.parseFunctionArguments(assignments);
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
        return errorMessages;
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
    
    private void parseFunctionArguments(List<BaseGrammarParser.ExpressionContext> expressions)
    {
        for (BaseGrammarParser.ExpressionContext context : expressions)
        {
            BaseGrammarParser.FunctionArgumentDeclarationContext gvar = context.functionArgumentDeclaration();
            if (gvar != null)
            {
                if (gvar.FUNCTION_ARGUMENT().getText().equals("functionInput"))
                {
                    String txt = gvar.VARIABLE().getText();
                    if (arguments.contains(txt))
                    {
                        errorMessages.add(txt+" is already defined as a function input argument");
                    }
                    else
                    {
                        arguments.add(txt);
                    }
                }
                else if (gvar.FUNCTION_ARGUMENT().getText().equals("functionOutput"))
                {
                    if (resultArgument==null)
                    {
                        resultArgument=gvar.VARIABLE().getText();
                    }
                    else
                    {
                        errorMessages.add(gvar.VARIABLE().getText()+" cannot be defined as a functionOutput (duplicate)");
                    }
                }
            }
        }
    }

    private List<BaseGrammarParser.ExpressionContext> getExpressionsWithArguments(BaseGrammarParser.AssetFunctionContext ctx)
    {
        List<BaseGrammarParser.ExpressionContext> result = new LinkedList();
        getExpressionArgumentsRecurse(ctx, result);
        return result;
    }

    private void getExpressionArgumentsRecurse(ParseTree tree, List<BaseGrammarParser.ExpressionContext> contextList)
    {
        if (tree.getChildCount() > 0)
        {
            for (int i = 0; i < tree.getChildCount(); i++)
            {
                getExpressionArgumentsRecurse(tree.getChild(i), contextList);
            }
            if (tree.getClass().equals(BaseGrammarParser.ExpressionContext.class))
            {
                contextList.add((BaseGrammarParser.ExpressionContext) tree);
            }
        }
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = other!=null && getClass().equals(other.getClass());
        if (result)
        {
            FunctionAssembly assembly = (FunctionAssembly) other;
            result = (this==other) || (variable.equals(assembly.variable));
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.variable);
        return hash;
    }
    
    @Override
    public String toString()
    {
        return variable;
    }

    @Override
    public String toAssembly()
    {
        String result = String.format("modding_define_function %s",variable);
        for (String element:arguments)
        {
            result+=" +"+element;
        }
        if (resultArgument!=null)
        {
            result+=" -"+resultArgument;
        }
        result+=" "+codeBlock.toString();
        result+="\n"+codeBlock.toAssembly();
        return result;
    }
}
