/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class InvalideInstructionExecutionTest {
    
    
    private Instruction instruction;
    private RoverConfiguration initConfiguration;
    
    
    private String instructionString;
    private String initRoverConfigurationString;
    

    public InvalideInstructionExecutionTest(String instructionString, String initConfigurationString) {
        this.instructionString = instructionString;
        this.initRoverConfigurationString = initConfigurationString;
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
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] {
                             { "M","5 5 N" }, // instruction , current Configuration
                             { "M","5 5 E" }, // data for 8 corner cases (2 each for 4 corners of square)
                             { "M","0 0 S" },
                             { "M","0 0 W" },
                             { "M","5 0 S" },
                             { "M","5 0 E" },
                             { "M","0 5 N" },
                             { "M","0 5 W" },
                             });
    }

    @After
    public void tearDown() {
    }

   /**
     * Test of execute method, of class MoveForwardInstruction.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalideInstructionExecute() {
        RoverConfiguration result = instruction.execute(initConfiguration);
    }

}