/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;


import rover.RoverConfiguration;
import static util.ValidationUtilities.*;
/**
 *
 * @author 186946
 */
public class RotateRightInstruction extends AbstractInstruction {

    /**
     * 
     * @param notation
     */
    public RotateRightInstruction() {
        super("R");
    }
    
    
    /**
     * 
     * @param currentRoverConfiguration
     * @return
     */
    public RoverConfiguration execute(RoverConfiguration currentRoverConfiguration) {
        assertNotNull(currentRoverConfiguration);
        RoverConfiguration nextRoverConfiguration = currentRoverConfiguration.rotateRightConfiguration();
        return nextRoverConfiguration;
    }
}
