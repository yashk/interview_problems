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
public class RotateLeftInstruction extends AbstractInstruction {

    /**
     * 
     * @param notation
     */
    public RotateLeftInstruction() {
        super("L");
    }
    
    /**
     * 
     * @param currentConfiguration
     * @return
     */
    public RoverConfiguration execute(RoverConfiguration currentConfiguration) {
        assertNotNull(currentConfiguration);
        RoverConfiguration nextRoverConfiguration = currentConfiguration.rotateLeftConfiguration();
        return nextRoverConfiguration;
    }
}
