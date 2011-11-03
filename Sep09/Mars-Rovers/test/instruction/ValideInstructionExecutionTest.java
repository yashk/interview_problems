package instruction;

import java.util.Arrays;
import java.util.Collection;
import location.GridLocation;
import location.GridLocationValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import rover.RoverConfiguration;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
@RunWith(value=Parameterized.class)
public class ValideInstructionExecutionTest {
    
    
    private Instruction instruction;
    private RoverConfiguration initConfiguration;
    private RoverConfiguration expectedConfiguration;
    
    private String instructionString;
    private String initRoverConfigurationString;
    private String expectedRoverConfigurationString;

    public ValideInstructionExecutionTest(String instructionString, String initConfigurationString, String expectedConfigurationString) {
        this.instructionString = instructionString;
        this.initRoverConfigurationString = initConfigurationString;
        this.expectedRoverConfigurationString = expectedConfigurationString;
    }
    
     @BeforeClass
    public static void setUpClass() throws Exception {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
    }
    
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        initConfiguration = RoverConfiguration.parseConfiguration(initRoverConfigurationString);
        instruction = AbstractInstruction.parseInstruction(instructionString);
        expectedConfiguration = RoverConfiguration.parseConfiguration(expectedRoverConfigurationString);
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] {
                             { "L","1 3 N","1 3 W" },   //instructions, initial configuration ,final expected configuration
                             { "R","1 3 N","1 3 E" },   // data for all 3 types of instruction
                             { "M","1 3 N","1 4 N" }
                             });
    }

    

   /**
     * Test of execute method, of class MoveForwardInstruction.
     */
    @Test
    public void testValideInstructionExecute() {
        
        RoverConfiguration result = instruction.execute(initConfiguration);
        assertEquals(expectedConfiguration, result);
    }

}