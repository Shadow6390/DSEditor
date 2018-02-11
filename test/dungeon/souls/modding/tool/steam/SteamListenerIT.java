/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.souls.modding.tool.steam;

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
public class SteamListenerIT
{
    
    public SteamListenerIT()
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
     * Test of onSteamInit method, of class SteamListener.
     */
    @Test
    public void testOnSteamInit()
    {
        System.out.println("onSteamInit");
        boolean initState = false;
        SteamListener instance = new SteamListenerImpl();
        instance.onSteamInit(initState);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class SteamListenerImpl implements SteamListener
    {

        public void onSteamInit(boolean initState)
        {
        }
    }
    
}
