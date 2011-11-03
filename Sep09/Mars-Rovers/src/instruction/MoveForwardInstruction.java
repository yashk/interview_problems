/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;



import rover.RoverConfiguration;
import static util.ValidationUtilities.*;

/**
 * Represnts a Move Forward Instruction
 * @author 186946
 */
public class MoveForwardInstruction extends AbstractInstruction {

    public MoveForwardInstruction() {
        super("M");
    }
    /**
     * 
     * @param currentConfiguration
     * @return
     * @throws IllegalArgumentException if the next position lies beyond the plateau grid
     */
    public RoverConfiguration execute(RoverConfiguration currentConfiguration) {
        assertNotNull(currentConfiguration);
        RoverConfiguration nextRoverConfiguration = currentConfiguration.moveForwardConfiguration();
        return nextRoverConfiguration;
    }
}
