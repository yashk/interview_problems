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
public class ValideRoverExplorationTest {
    
    private String initRoverConfigurationString;
    private String instructionsString;
    private String expectedRoverConfigurationString;
    
    
    private RoverConfiguration initConfiguration;
    private RoverConfiguration expectedConfiguration;
    private List<Instruction> instructions;
    
    public ValideRoverExplorationTest(String initRoverConfiguration, String instructions, String expectedRoverConfiguration) {
        this.initRoverConfigurationString = initRoverConfiguration;
        this.instructionsString = instructions;
        this.expectedRoverConfigurationString = expectedRoverConfiguration;
    }
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
    }
    
    
    @Before
    public void setUp() {
        initConfiguration = RoverConfiguration.parseConfiguration(initRoverConfigurationString);
        instructions = AbstractInstruction.parseInstructions(instructionsString);
        expectedConfiguration = RoverConfiguration.parseConfiguration(expectedRoverConfigurationString);
        
    }
    
    
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] {
                             { "1 2 N","LMLMLMLMM","1 3 N" },   // initial configuration ,instructions,final expected configuration
                             { "3 3 E","MMRMMRMRRM","5 1 E" }
                             });
    }


    
    @Test
    public void testExplore(){
        Rover rover = new Rover(initConfiguration);
        rover.explore(instructions);
        assertEquals(rover.getRoverConfiguration(),expectedConfiguration);
    }
}