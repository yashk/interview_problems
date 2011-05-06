/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package position;

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
 * @author 186946
 */
public class NothPositionTest {
    private Position currentPosition;
    
    @Before
    public void setUp() {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
        currentPosition = AbstractPosition.parsePosition("N");
    }

    

    /**
     * Test of nextLocation method, of class EastPosition.
     */
    @Test
    public void testvalideNextLocation() {
        GridLocation cuurentGridLocation = GridLocation.value(1,1);
        GridLocation expectedNextGridLocation = GridLocation.value(1, 2);
        GridLocation result = currentPosition.nextLocation(cuurentGridLocation);
        assertEquals(expectedNextGridLocation, result);
    }
    
    /**
     * 
     */
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testInvalideNextLocation() {
        GridLocation cuurentGridLocation = GridLocation.value(0,5);
        GridLocation result = currentPosition.nextLocation(cuurentGridLocation);
    }
    
    
    /**
     * 
     */
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testInvalideNextLocation1() {
        GridLocation cuurentGridLocation = GridLocation.value(5,5);
        GridLocation result = currentPosition.nextLocation(cuurentGridLocation);
    }
    
    
    
    

    /**
     * Test of leftPosition method, of class EastPosition.
     */
    @Test
    public void leftPosition() {
        
        Position expResult = AbstractPosition.parsePosition("W");
        Position result = currentPosition.leftPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of rightPosition method, of class EastPosition.
     */
    @Test
    public void rightPosition() {
        Position expResult = AbstractPosition.parsePosition("E");
        Position result = currentPosition.rightPosition();
        assertEquals(expResult, result);
    }

}