/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rover;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 186946
 */
public class RoverManagerTest {
    private RoverManager manager;
    
    
    
    @Before
    public void setUp() {
        manager = new RoverManager();;
        
    }

    @Test
    public void testManagerWithSuppliedInput(){
        StringBuilder testdata=new StringBuilder();
        testdata.append("5 5").
                 append("\r\n").
                 append("1 2 N").
                 append("\r\n").
                 append("LMLMLMLMM"). 
                 append("\r\n").
                 append("3 3 E" ).
                 append("\r\n").
                 append("MMRMMRMRRM").
                 append("\r\n");
        
        manager.processSignal(testdata.toString());
        manager.startExploring();
        
        assertEquals(manager.getInstructionsList().size(),2);
        assertEquals(manager.getInstructionsList().size(),2);
        
        Rover rover1= manager.getRoverList().get(0);
        Rover rover2 = manager.getRoverList().get(1);
        
        assertEquals(rover1.getRoverConfiguration(), RoverConfiguration.parseConfiguration("1 3 N"));
        assertEquals(rover2.getRoverConfiguration(), RoverConfiguration.parseConfiguration("5 1 E"));
        
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testEmptySignal(){
        manager.processSignal("");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNullSignal(){
        manager.processSignal(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIllFormatedSignal(){
        manager.processSignal("5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM");
    }

}