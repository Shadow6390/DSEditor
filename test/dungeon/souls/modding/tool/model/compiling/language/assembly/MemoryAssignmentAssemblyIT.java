/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.model.compiling.language.assembly;

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
public class MemoryAssignmentAssemblyIT
{
    
    public MemoryAssignmentAssemblyIT()
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
     * Test of allocate method, of class MemoryAssignmentAssembly.
     */
    @Test
    public void testAllocate()
    {
        System.out.println("allocate");
        MemoryAssignmentAssembly expResult = null;
        MemoryAssignmentAssembly result = MemoryAssignmentAssembly.allocate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetMemories method, of class MemoryAssignmentAssembly.
     */
    @Test
    public void testResetMemories()
    {
        System.out.println("resetMemories");
        MemoryAssignmentAssembly.resetMemories();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MemoryAssignmentAssembly.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        MemoryAssignmentAssembly instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class MemoryAssignmentAssembly.
     */
    @Test
    public void testEquals()
    {
        System.out.println("equals");
        Object other = null;
        MemoryAssignmentAssembly instance = null;
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class MemoryAssignmentAssembly.
     */
    @Test
    public void testHashCode()
    {
        System.out.println("hashCode");
        MemoryAssignmentAssembly instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
