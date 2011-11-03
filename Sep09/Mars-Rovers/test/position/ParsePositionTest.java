/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package position;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 186946
 */
public class ParsePositionTest {

    
    // smoke tests
    
    @Test
    public void testValideNorthPosition() {
        Position iPosition=AbstractPosition.parsePosition("N");
        assertTrue(iPosition.equals(new NorthPosition()));
    }
    
    @Test
    public void testValideSouthPosition() {
        Position iPosition=AbstractPosition.parsePosition("S");
        assertTrue(iPosition.equals(new SouthPosition()));
    }
    
    @Test
    public void testValideWestPosition() {
        Position iPosition=AbstractPosition.parsePosition("W");
        assertTrue(iPosition.equals(new WestPosition()));
    }
    
    @Test
    public void testValideEastPosition() {
        Position iPosition=AbstractPosition.parsePosition("E");
        assertTrue(iPosition.equals(new EastPosition()));
    }
    
    // illegal input tests
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testEmptyPosition() {
        AbstractPosition.parsePosition("");
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testNullPosition() {
        AbstractPosition.parsePosition(null);
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testInvalidePosition() {
        AbstractPosition.parsePosition("ssda");
    }
    
    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testIllForrmatedPosition() {
        AbstractPosition.parsePosition("W ");
    }

}