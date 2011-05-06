

package rover;

import instruction.AbstractInstruction;
import location.GridLocation;
import location.GridLocationValidator;
import instruction.Instruction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static util.ValidationUtilities.*;

/**
 *Receives signal from external world and manages rover exploration.
 * @author 186946
 */
public class RoverManager {
    
    private List<Rover> roverList=new ArrayList<Rover>();
    private List<List<Instruction>> instructionsList = new ArrayList<List<Instruction>>();
    
    /**
     * process signal and creates list rover and list of instruction for them.
     * @param signal
     */
    public void processSignal(String signal) {

        roverList.clear();
        instructionsList.clear();

        System.out.println("Input :");
        System.out.println("===============================");
        System.out.println(signal);
        System.out.println("===============================");

        if (isNullOrEmpty(signal)) {
            throw new IllegalArgumentException("signal can not be null or empty");
        }

        Scanner scanner = new Scanner(signal);

        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Invalide Signal Format\n[" + signal + "]\n Each line of signal should terminate with a line feed and carriage return");
        }

        String maxGridLocationString = scanner.nextLine();
        GridLocation.setLocationValidator(new GridLocationValidator(maxGridLocationString));

        while (scanner.hasNextLine()) {
            try {
                String initailConfigurationString = scanner.nextLine();
                String roverInstructionsString = scanner.nextLine();

                populateRover(getRover(initailConfigurationString));
                populateRoverInstructions(getInstructions(roverInstructionsString));
                
                
            } catch (NoSuchElementException nsee) {
                throw new IllegalArgumentException("Invalide Signal Format\n[" + signal + "]\n Each line of signal should terminate with a line feed and carriage return", nsee);
            }
        }


    }
    
    public void startExploring(){
        for(int i=0;i<roverList.size();i++){
            Rover rover = roverList.get(i);
            List <Instruction> instructionList = instructionsList.get(i);
            rover.explore(instructionList);
        }
        
        System.out.println("Output :");
        System.out.println("===============================");
        
        for(Rover rover : roverList){
            rover.printConfiguration();
        }
        
        System.out.println("===============================");
    }
    
    
    
    public static void main(String [] args){
        RoverManager roverManager = new RoverManager();
        String supliedTestData = "5 5\r\n"+
                                 "1 2 N\r\n"+
                                 "LMLMLMLMM\r\n"+
                                 "3 3 E\r\n"+
                                 "MMRMMRMRRM\r\n";
        
        roverManager.processSignal(supliedTestData);
        roverManager.startExploring();
    }

    public List<List<Instruction>> getInstructionsList() {
        return Collections.unmodifiableList(instructionsList);
    }

    public List<Rover> getRoverList() {
        return Collections.unmodifiableList(roverList);
    }

    
    
    private  List <Instruction> getInstructions(String roverInstructionsString) {
        List <Instruction> roverInstructionList =  AbstractInstruction.parseInstructions(roverInstructionsString);
        return roverInstructionList;
    }

    private Rover getRover(String initailConfigurationString) {
        RoverConfiguration initailConfiguration = RoverConfiguration.parseConfiguration(initailConfigurationString);
        Rover rover = new Rover(initailConfiguration);
        return rover;
    }

    private void populateRover(Rover rover) {
        this.roverList.add(rover);
    }

    private void populateRoverInstructions(List <Instruction> instructionList) {
        this.instructionsList.add(instructionList);
    }

}
