/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package state;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author 186946
 */
public class LiveStateTest {

    public LiveStateTest() {
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
    public void testLivetoLiveTransistion(){
        LiveState state = new LiveState();
        CellState threeLiveNeighbourResult = state.nextState(StateTestUtils.getCellWithNLiveAndMDeadNebhours(3, 0, false));
        assertEquals(state, threeLiveNeighbourResult);

        CellState twoLiveNeighbourResult = state.nextState(StateTestUtils.getCellWithNLiveAndMDeadNebhours(2, 0, false));
        assertEquals(state, twoLiveNeighbourResult);
    }


    @Test
    public void testLivetoDeadTransistion(){
        DeadState state = new DeadState();
        CellState fourLiveNeighbourResult = state.nextState(StateTestUtils.getCellWithNLiveAndMDeadNebhours(4, 0, false));
        assertEquals(state, fourLiveNeighbourResult);

        CellState oneLiveNeighbourResult = state.nextState(StateTestUtils.getCellWithNLiveAndMDeadNebhours(1, 0, false));
        assertEquals(state, oneLiveNeighbourResult);
    }

    

}