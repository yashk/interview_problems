/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package state;

import domain.cell.ICell;
import domain.universe.NeighbourLocator;
import domain.universe.Location;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 186946
 */
public class DeadStateTest {

    public DeadStateTest() {
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
    public void testDeadToLiveTranistion(){
        LiveState state = new LiveState();
        CellState result = state.nextState(StateTestUtils.getCellWithNLiveAndMDeadNebhours(3, 0, false));
        assertEquals(state, result);
    }


    @Test
    public void testDeadToDeadTranistion(){
        DeadState state = new DeadState();
        ICell fourLiveNeighbour = StateTestUtils.getCellWithNLiveAndMDeadNebhours(4, 0, false);
        ICell twoLiveNeighbour = StateTestUtils.getCellWithNLiveAndMDeadNebhours(0, 4, false);

        CellState fourLiveNeighbourResult = state.nextState(fourLiveNeighbour);
        CellState twoLiveNeighbourNeighbourResult = state.nextState(twoLiveNeighbour);
        
        assertEquals(state, fourLiveNeighbourResult);
        assertEquals(state, twoLiveNeighbourNeighbourResult);


    }



   
}