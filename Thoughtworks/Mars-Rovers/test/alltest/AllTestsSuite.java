/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alltest;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Administrator
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{instruction.InvalideInstructionExecutionTest.class,
 instruction.ParseInstructionTest.class,
 instruction.ValideInstructionExecutionTest.class,
         
 location.GridLocationTest.class,
 location.GridLocationValidatorTest.class,
 
 position.EastPositionTest.class,
 position.WestPositionTest.class,
 position.NothPositionTest.class,
 position.SouthPositionTest.class,
 
 rover.RoverManagerTest.class,
 rover.InvalideRoverExplorationTest.class,
 rover.ValideRoverExplorationTest.class
})
public class AllTestsSuite {
public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("alltest.AllTestsSuite");
    }

}