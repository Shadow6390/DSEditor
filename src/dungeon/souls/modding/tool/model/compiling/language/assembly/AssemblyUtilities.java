/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

import dungeon.souls.modding.tool.model.compiling.language.BaseGrammarParser;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Holds default utilities for parsing assembly code common to two or more
 * classes.
 * @author Diogo
 */
public class AssemblyUtilities
{
    public static CodeBlockAssembly parseCodeBlock(BaseGrammarParser.Block_codeContext context)
    {
        CodeBlockAssembly result = new CodeBlockAssembly();
        AssemblyCode temp;
        for (ParseTree tree:context.children)
        {
            temp=null;
            if (tree.getClass().equals(BaseGrammarParser.StatementContext.class))
            {
                temp=parseStatement((BaseGrammarParser.StatementContext)tree);
            }
            else if (tree.getClass().equals(BaseGrammarParser.Block_codeContext.class))
            {
                temp=parseCodeBlock((BaseGrammarParser.Block_codeContext)tree);
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
    
    public static AssemblyCode parseStatement(BaseGrammarParser.StatementContext context)
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
        else if (context.while_statement()!=null)
        {
            result = parseWhileStatement(context.while_statement());
        }
        else if (context.for_statement()!=null)
        {
            result = parseForStatement(context.for_statement());
        }
        return result;
    }
    
    public static AssemblyCode parseWhileStatement(BaseGrammarParser.While_statementContext context)
    {
        AssemblyCode result = null;
        if (context!=null)
        {
            result = WhileAssembly.parseFrom(context);
        }
        return result;
    }
    
    public static AssemblyCode parseForStatement(BaseGrammarParser.For_statementContext context)
    {
        AssemblyCode result = null;
        if (context!=null)
        {
            result = ForAssembly.parseFrom(context);
        }
        return result;
    }
    
    public static AssemblyCode parseIfStatement(BaseGrammarParser.If_statementContext context)
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
            assembly.setCondition(ConditionAssembly.parseFrom(context.condition(i)));
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
    
    public static AssemblyCode parseExplicitCode(BaseGrammarParser.Explicit_codeContext context)
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
    
    public static AssemblyCode parseExpression(BaseGrammarParser.ExpressionContext expression)
    {
        return parseFreeExpression(expression.free_expression());
    }
    
    public static AssemblyCode parseFreeExpression(BaseGrammarParser.Free_expressionContext expression)
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
}
