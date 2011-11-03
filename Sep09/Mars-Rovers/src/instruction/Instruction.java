/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package instruction;

import rover.RoverConfiguration;

/**
 * Represents an Instruction which can be excecuted by a Rover.
 * @author 186946
 */
public interface Instruction {
    /**
     * Executes the instruction.
     * @param roverConfiguration Current Rover Configuration
     * @return new Rover Configuration after exrcuting the instruction
     * @throws IllegalArgumentException if rover configuration is not valide
     */
    public RoverConfiguration execute(RoverConfiguration roverConfiguration);
    
}