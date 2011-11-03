/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package alltest;

import domain.neighbourhood.NeighborhoodTest;
import io.IOTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import state.DeadStateTest;
import state.LiveStateTest;

/**
 *
 * @author 186946
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{DeadStateTest.class,
 LiveStateTest.class,
 NeighborhoodTest.class,
 IOTest.class
})
public class AllTestSuite {

   

    public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("alltest.AllTestsSuite");
    }

}