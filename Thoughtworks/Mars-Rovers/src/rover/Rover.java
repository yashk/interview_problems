/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rover;


import instruction.Instruction;
import java.util.List;
import static util.ValidationUtilities.*;

/**
 * Respresnts a Rover.
 * @author 186946
 */
public class Rover {

    private RoverConfiguration roverConfiguration;

    public Rover(RoverConfiguration initConfiguration) {
        assertNotNull(initConfiguration);
        this.roverConfiguration = initConfiguration;
    }

    
    public void explore (List <Instruction> instructions){
        assertNotNull(instructions);
        for(Instruction instruction : instructions){
            roverConfiguration = instruction.execute(roverConfiguration);
        }
    }

    public void printConfiguration() {
        System.out.println(roverConfiguration);
    }

    public RoverConfiguration getRoverConfiguration() {
        return roverConfiguration;
    }
}
