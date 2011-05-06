/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rover;

import instruction.AbstractInstruction;
import instruction.Instruction;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import location.GridLocation;
import location.GridLocationValidator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */

@RunWith(value=Parameterized.class)
public class InvalideRoverExplorationTest {
    
    private String initRoverConfigurationString;
    private String instructionsString;
    
    
    
    private RoverConfiguration initConfiguration;
    private List<Instruction> instructions;
    
    public InvalideRoverExplorationTest(String initRoverConfiguration, String instructions) {
        this.initRoverConfigurationString = initRoverConfiguration;
        this.instructionsString = instructions;
        
    }
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
    }
    
    
    @Before
    public void setUp() {
        initConfiguration = RoverConfiguration.parseConfiguration(initRoverConfigurationString);
        instructions = AbstractInstruction.parseInstructions(instructionsString);
        
    }
    
    
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] {
                             { "1 1 N","MMMMMM" },   // intial configuration ,instructions
                             { "3 3 E","MMM" },
                             { "1 1 N","LMMM" },
                             { "3 3 E","MMM" },
                             
                             { "5 5 N","M" }, 
                             { "5 5 E","M" }, // data for 8 corner cases (2 each for 4 corners of square)
                             { "0 0 S","M" },
                             { "0 0 W","M" },
                             { "5 0 S","M" },
                             { "5 0 E","M" },
                             { "0 5 N","M" },
                             { "0 5 W","M" },
                             });
    }


    
    @Test(expected=IllegalArgumentException.class)
    public void testExplore(){
        Rover rover = new Rover(initConfiguration);
        rover.explore(instructions);
    }

    @Override
    public String toString() {
        return initRoverConfigurationString+ " "+instructionsString;
    }
     
     
}