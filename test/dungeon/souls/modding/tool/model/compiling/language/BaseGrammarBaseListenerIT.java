/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diogo
 */
public class BaseGrammarBaseListenerIT
{
    
    public BaseGrammarBaseListenerIT()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of enterAssetModule method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterAssetModule()
    {
        System.out.println("enterAssetModule");
        BaseGrammarParser.AssetModuleContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterAssetModule(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetModule method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitAssetModule()
    {
        System.out.println("exitAssetModule");
        BaseGrammarParser.AssetModuleContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitAssetModule(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterExpression method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterExpression()
    {
        System.out.println("enterExpression");
        BaseGrammarParser.ExpressionContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterExpression(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitExpression method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitExpression()
    {
        System.out.println("exitExpression");
        BaseGrammarParser.ExpressionContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitExpression(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterComparison method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterComparison()
    {
        System.out.println("enterComparison");
        BaseGrammarParser.ComparisonContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterComparison(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitComparison method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitComparison()
    {
        System.out.println("exitComparison");
        BaseGrammarParser.ComparisonContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitComparison(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterAssetItem method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterAssetItem()
    {
        System.out.println("enterAssetItem");
        BaseGrammarParser.AssetItemContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterAssetItem(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetItem method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitAssetItem()
    {
        System.out.println("exitAssetItem");
        BaseGrammarParser.AssetItemContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitAssetItem(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterFunction_call method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterFunction_call()
    {
        System.out.println("enterFunction_call");
        BaseGrammarParser.Function_callContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterFunction_call(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitFunction_call method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitFunction_call()
    {
        System.out.println("exitFunction_call");
        BaseGrammarParser.Function_callContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitFunction_call(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterFunctionArgumentDeclaration method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterFunctionArgumentDeclaration()
    {
        System.out.println("enterFunctionArgumentDeclaration");
        BaseGrammarParser.FunctionArgumentDeclarationContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterFunctionArgumentDeclaration(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitFunctionArgumentDeclaration method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitFunctionArgumentDeclaration()
    {
        System.out.println("exitFunctionArgumentDeclaration");
        BaseGrammarParser.FunctionArgumentDeclarationContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitFunctionArgumentDeclaration(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterAssignment method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterAssignment()
    {
        System.out.println("enterAssignment");
        BaseGrammarParser.AssignmentContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterAssignment(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssignment method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitAssignment()
    {
        System.out.println("exitAssignment");
        BaseGrammarParser.AssignmentContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitAssignment(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterMath_operation method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterMath_operation()
    {
        System.out.println("enterMath_operation");
        BaseGrammarParser.Math_operationContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterMath_operation(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitMath_operation method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitMath_operation()
    {
        System.out.println("exitMath_operation");
        BaseGrammarParser.Math_operationContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitMath_operation(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterStart method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterStart()
    {
        System.out.println("enterStart");
        BaseGrammarParser.StartContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterStart(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitStart method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitStart()
    {
        System.out.println("exitStart");
        BaseGrammarParser.StartContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitStart(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterExplicit_code method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterExplicit_code()
    {
        System.out.println("enterExplicit_code");
        BaseGrammarParser.Explicit_codeContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterExplicit_code(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitExplicit_code method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitExplicit_code()
    {
        System.out.println("exitExplicit_code");
        BaseGrammarParser.Explicit_codeContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitExplicit_code(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterFunction_parameter method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterFunction_parameter()
    {
        System.out.println("enterFunction_parameter");
        BaseGrammarParser.Function_parameterContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterFunction_parameter(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitFunction_parameter method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitFunction_parameter()
    {
        System.out.println("exitFunction_parameter");
        BaseGrammarParser.Function_parameterContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitFunction_parameter(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterMath_value method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterMath_value()
    {
        System.out.println("enterMath_value");
        BaseGrammarParser.Math_valueContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterMath_value(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitMath_value method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitMath_value()
    {
        System.out.println("exitMath_value");
        BaseGrammarParser.Math_valueContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitMath_value(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterStart_expression method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterStart_expression()
    {
        System.out.println("enterStart_expression");
        BaseGrammarParser.Start_expressionContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterStart_expression(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitStart_expression method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitStart_expression()
    {
        System.out.println("exitStart_expression");
        BaseGrammarParser.Start_expressionContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitStart_expression(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterBlock_code method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterBlock_code()
    {
        System.out.println("enterBlock_code");
        BaseGrammarParser.Block_codeContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterBlock_code(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitBlock_code method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitBlock_code()
    {
        System.out.println("exitBlock_code");
        BaseGrammarParser.Block_codeContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitBlock_code(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterStatement method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterStatement()
    {
        System.out.println("enterStatement");
        BaseGrammarParser.StatementContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterStatement(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitStatement method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitStatement()
    {
        System.out.println("exitStatement");
        BaseGrammarParser.StatementContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitStatement(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterVariable method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterVariable()
    {
        System.out.println("enterVariable");
        BaseGrammarParser.VariableContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterVariable(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitVariable method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitVariable()
    {
        System.out.println("exitVariable");
        BaseGrammarParser.VariableContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitVariable(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterIf_statement method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterIf_statement()
    {
        System.out.println("enterIf_statement");
        BaseGrammarParser.If_statementContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterIf_statement(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitIf_statement method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitIf_statement()
    {
        System.out.println("exitIf_statement");
        BaseGrammarParser.If_statementContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitIf_statement(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterTerm method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterTerm()
    {
        System.out.println("enterTerm");
        BaseGrammarParser.TermContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterTerm(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitTerm method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitTerm()
    {
        System.out.println("exitTerm");
        BaseGrammarParser.TermContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitTerm(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterComment method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterComment()
    {
        System.out.println("enterComment");
        BaseGrammarParser.CommentContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterComment(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitComment method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitComment()
    {
        System.out.println("exitComment");
        BaseGrammarParser.CommentContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitComment(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterAssetSprite method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterAssetSprite()
    {
        System.out.println("enterAssetSprite");
        BaseGrammarParser.AssetSpriteContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterAssetSprite(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetSprite method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitAssetSprite()
    {
        System.out.println("exitAssetSprite");
        BaseGrammarParser.AssetSpriteContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitAssetSprite(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterFactor method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterFactor()
    {
        System.out.println("enterFactor");
        BaseGrammarParser.FactorContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterFactor(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitFactor method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitFactor()
    {
        System.out.println("exitFactor");
        BaseGrammarParser.FactorContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitFactor(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterAsset method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterAsset()
    {
        System.out.println("enterAsset");
        BaseGrammarParser.AssetContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterAsset(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAsset method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitAsset()
    {
        System.out.println("exitAsset");
        BaseGrammarParser.AssetContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitAsset(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterAssetFunction method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterAssetFunction()
    {
        System.out.println("enterAssetFunction");
        BaseGrammarParser.AssetFunctionContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterAssetFunction(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitAssetFunction method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitAssetFunction()
    {
        System.out.println("exitAssetFunction");
        BaseGrammarParser.AssetFunctionContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitAssetFunction(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterValue method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterValue()
    {
        System.out.println("enterValue");
        BaseGrammarParser.ValueContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterValue(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitValue method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitValue()
    {
        System.out.println("exitValue");
        BaseGrammarParser.ValueContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitValue(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterEveryRule method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testEnterEveryRule()
    {
        System.out.println("enterEveryRule");
        ParserRuleContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.enterEveryRule(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitEveryRule method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testExitEveryRule()
    {
        System.out.println("exitEveryRule");
        ParserRuleContext ctx = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.exitEveryRule(ctx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitTerminal method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testVisitTerminal()
    {
        System.out.println("visitTerminal");
        TerminalNode node = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.visitTerminal(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitErrorNode method, of class BaseGrammarBaseListener.
     */
    @Test
    public void testVisitErrorNode()
    {
        System.out.println("visitErrorNode");
        ErrorNode node = null;
        BaseGrammarBaseListener instance = new BaseGrammarBaseListener();
        instance.visitErrorNode(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
