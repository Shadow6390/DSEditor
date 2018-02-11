/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language;

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
public class BaseGrammarBaseVisitorIT
{
    
    public BaseGrammarBaseVisitorIT()
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
     * Test of visitAssetModule method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitAssetModule()
    {
        System.out.println("visitAssetModule");
        BaseGrammarParser.AssetModuleContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitAssetModule(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitExpression method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitExpression()
    {
        System.out.println("visitExpression");
        BaseGrammarParser.ExpressionContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitExpression(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitComparison method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitComparison()
    {
        System.out.println("visitComparison");
        BaseGrammarParser.ComparisonContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitComparison(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitAssetItem method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitAssetItem()
    {
        System.out.println("visitAssetItem");
        BaseGrammarParser.AssetItemContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitAssetItem(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitFunction_call method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitFunction_call()
    {
        System.out.println("visitFunction_call");
        BaseGrammarParser.Function_callContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitFunction_call(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitFunctionArgumentDeclaration method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitFunctionArgumentDeclaration()
    {
        System.out.println("visitFunctionArgumentDeclaration");
        BaseGrammarParser.FunctionArgumentDeclarationContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitFunctionArgumentDeclaration(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitAssignment method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitAssignment()
    {
        System.out.println("visitAssignment");
        BaseGrammarParser.AssignmentContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitAssignment(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitMath_operation method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitMath_operation()
    {
        System.out.println("visitMath_operation");
        BaseGrammarParser.Math_operationContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitMath_operation(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitStart method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitStart()
    {
        System.out.println("visitStart");
        BaseGrammarParser.StartContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitStart(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitExplicit_code method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitExplicit_code()
    {
        System.out.println("visitExplicit_code");
        BaseGrammarParser.Explicit_codeContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitExplicit_code(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitFunction_parameter method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitFunction_parameter()
    {
        System.out.println("visitFunction_parameter");
        BaseGrammarParser.Function_parameterContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitFunction_parameter(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitMath_value method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitMath_value()
    {
        System.out.println("visitMath_value");
        BaseGrammarParser.Math_valueContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitMath_value(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitStart_expression method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitStart_expression()
    {
        System.out.println("visitStart_expression");
        BaseGrammarParser.Start_expressionContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitStart_expression(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitBlock_code method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitBlock_code()
    {
        System.out.println("visitBlock_code");
        BaseGrammarParser.Block_codeContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitBlock_code(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitStatement method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitStatement()
    {
        System.out.println("visitStatement");
        BaseGrammarParser.StatementContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitStatement(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitVariable method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitVariable()
    {
        System.out.println("visitVariable");
        BaseGrammarParser.VariableContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitVariable(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitIf_statement method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitIf_statement()
    {
        System.out.println("visitIf_statement");
        BaseGrammarParser.If_statementContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitIf_statement(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitTerm method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitTerm()
    {
        System.out.println("visitTerm");
        BaseGrammarParser.TermContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitTerm(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitComment method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitComment()
    {
        System.out.println("visitComment");
        BaseGrammarParser.CommentContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitComment(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitAssetSprite method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitAssetSprite()
    {
        System.out.println("visitAssetSprite");
        BaseGrammarParser.AssetSpriteContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitAssetSprite(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitFactor method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitFactor()
    {
        System.out.println("visitFactor");
        BaseGrammarParser.FactorContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitFactor(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitAsset method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitAsset()
    {
        System.out.println("visitAsset");
        BaseGrammarParser.AssetContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitAsset(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitAssetFunction method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitAssetFunction()
    {
        System.out.println("visitAssetFunction");
        BaseGrammarParser.AssetFunctionContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitAssetFunction(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visitValue method, of class BaseGrammarBaseVisitor.
     */
    @Test
    public void testVisitValue()
    {
        System.out.println("visitValue");
        BaseGrammarParser.ValueContext ctx = null;
        BaseGrammarBaseVisitor instance = new BaseGrammarBaseVisitor();
        Object expResult = null;
        Object result = instance.visitValue(ctx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
