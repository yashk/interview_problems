

package instruction;

import java.util.ArrayList;
import java.util.List;
import rover.RoverConfiguration;

/**
 *This sekleton implementation of Instruction interface.Holds methode common to all instructions.
 * @author Yashodhan Kocharekar
 */
public abstract class AbstractInstruction implements Instruction {
    
    /**
     *A String representation of an Instruction. 
     */
    private String notation;

    /**
     * Constructor
     * @param notation - String representation of the Instruction.
     */
    public AbstractInstruction(String notation) {
        this.notation = notation;
    }

    /**
     * 
     * @param roverConfiguration
     * @return
     * @throws IllegalArgumentException 
     */
    public abstract RoverConfiguration execute(RoverConfiguration roverConfiguration);
    
    
    
    /**
     * Parses the string argument in to a List of Instructions
     * @param instructionString
     * @return List of instruction
     * @throws IllegalArgumentException if string argument is empty null or does not represent a valide list of instruction
     */
    public static List<Instruction> parseInstructions(String instructionsString) {
        if (instructionsString == null || instructionsString.length() == 0) {
            throw new IllegalArgumentException(" Instructions can not be null or empty");
        }
        
        List<Instruction> instructionList = new ArrayList<Instruction>();
        populateList(instructionList, instructionsString);
        return instructionList;
    }
    
    /**
     * 
     * @param instructionList
     * @param data
     */
    private static void populateList(List<Instruction> instructionList, String data) {
        for (char character : data.toCharArray()) {
            instructionList.add(createInstruction(character));
        }
    }
    
    /**
     * Parses the string argument in to a Instruction
     * @param instructionString
     * @return instruction
     * @throws IllegalArgumentException if string argument is empty null or does not represent a valide list of instructions
     */
    public static Instruction parseInstruction(String instructionString) {
        if (instructionString == null || instructionString.length()!=1) {
            throw new IllegalArgumentException("Instruction can not be null,empty or greater then 1 charcter");
        }
        return createInstruction(character(instructionString));
    }
    
    /**
     * 
     * @param character
     * @return
     */
    private static Instruction createInstruction(char character) {
        
        switch (character) {
            case 'L':
                return new RotateLeftInstruction();
            case 'R':
                return new RotateRightInstruction();
            case 'M':
                return new MoveForwardInstruction();
            default:
                throw new IllegalArgumentException("["+character+"] is not a valide instruction must be one of {L R M}");
        }
    }
    
    /**
     * 
     * @param string
     * @return
     */
    private static char character(String string){
        return string.charAt(0);
                
    }
    
    /**
     * 
     * @param obj
     * @return
     */
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractInstruction other = (AbstractInstruction) obj;
        
        return this.notation.equals(other.getNotation());
    }

    /**
     * 
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.notation != null ? this.notation.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @return
     */
    public String getNotation() {
        return notation;
    }
    
}