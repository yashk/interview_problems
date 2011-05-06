package instruction;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Administrator
 */
public class ParseInstructionTest {

    public ParseInstructionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void testValideMoveForwardInstruction(){
        String instructionsString = "M";
        List<Instruction> expResult = Arrays.asList
                (new Instruction[]{
                 new MoveForwardInstruction()
                
                });
        List<Instruction> result = AbstractInstruction.parseInstructions(instructionsString);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testValideRotateLeftInstruction(){
        String instructionsString = "L";
        List<Instruction> expResult = Arrays.asList
                (new Instruction[]{
                 new RotateLeftInstruction()
                
                });
        List<Instruction> result = AbstractInstruction.parseInstructions(instructionsString);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testValideRotateRightInstruction(){
        String instructionsString = "R";
        List<Instruction> expResult = Arrays.asList
                (new Instruction[]{
                 new RotateRightInstruction(),
                });
        List<Instruction> result = AbstractInstruction.parseInstructions(instructionsString);
        assertEquals(expResult, result);
        
    }
   
    @Test
    public void testValideParseInstructionList() {
        
        String instructionsString = "LRM";
        List<Instruction> expResult = Arrays.asList
                (new Instruction[]{
                 new RotateLeftInstruction(),
                 new RotateRightInstruction(),
                 new MoveForwardInstruction()
                });
        List<Instruction> result = AbstractInstruction.parseInstructions(instructionsString);
        assertEquals(expResult, result);
        
    }
}