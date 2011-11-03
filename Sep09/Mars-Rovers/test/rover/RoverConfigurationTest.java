/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rover;

import location.GridLocation;
import location.GridLocationValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class RoverConfigurationTest {

    

    @BeforeClass
    public static void setUpClass() throws Exception {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of rotateLeftConfiguration method, of class RoverConfiguration.
     */
    @Test
    public void testRotateLeftConfiguration() {
        RoverConfiguration instance = RoverConfiguration.parseConfiguration("1 1 N");
        RoverConfiguration expResult = RoverConfiguration.parseConfiguration("1 1 W");
        RoverConfiguration result = instance.rotateLeftConfiguration();
        assertEquals(expResult, result);
    }

    /**
     * Test of rotateRightConfiguration method, of class RoverConfiguration.
     */
    @Test
    public void testRotateRightConfiguration() {
        RoverConfiguration instance = RoverConfiguration.parseConfiguration("1 1 N");
        RoverConfiguration expResult = RoverConfiguration.parseConfiguration("1 1 E");
        RoverConfiguration result = instance.rotateRightConfiguration();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of moveForwardConfiguration method, of class RoverConfiguration.
     */
    @Test
    public void testValildeMoveForwardConfiguration() {
        RoverConfiguration instance = RoverConfiguration.parseConfiguration("1 1 N");
        RoverConfiguration expResult = RoverConfiguration.parseConfiguration("1 2 N");
        RoverConfiguration result = instance.moveForwardConfiguration();
        assertEquals(expResult, result);
    }

    /**
     * Test of parseConfiguration method, of class RoverConfiguration.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testEmptyParseConfiguration() {
        RoverConfiguration result = RoverConfiguration.parseConfiguration("");
    }
    
    /**
     * Test of parseConfiguration method, of class RoverConfiguration.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testNullParseConfiguration() {
        RoverConfiguration result = RoverConfiguration.parseConfiguration(null);
        
    }
    
    
    public void testValideParseConfiguration() {
        RoverConfiguration result = RoverConfiguration.parseConfiguration("1 2 N");
    }


}