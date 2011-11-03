/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.universe;

import domain.cell.CellFactory;
import domain.neighbourhood.NeighborhoodFactory;
import domain.pattern.Pattern;
import domain.pattern.PatternFactory;

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
public class UniverseTest {

    public UniverseTest() {
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
    public void testSquare(){
         IUniverse universe = new TwoDimensionalUniverse(
                new Location(25, 25),
                NeighborhoodFactory.getMooreNeighborhood(),
                CellFactory.createDeadCellGrid(25, 25));


         Pattern pattern = PatternFactory.square();
         pattern.draw(universe);
         universe.tick();

         assertTrue(
                 PatternFactory.squareResult().conatinsThisPattern(universe));
    }


    @Test
    public void testBlinker(){
         IUniverse universe = new TwoDimensionalUniverse(
                new Location(25, 25),
                NeighborhoodFactory.getMooreNeighborhood(),
                CellFactory.createDeadCellGrid(25, 25));


         Pattern pattern = PatternFactory.blinker();
         pattern.draw(universe);
         universe.tick();

         assertTrue(
                 PatternFactory.blinkerResult().conatinsThisPattern(universe));
    }


    @Test
    public void testBoat(){
         IUniverse universe = new TwoDimensionalUniverse(
                new Location(25, 25),
                NeighborhoodFactory.getMooreNeighborhood(),
                CellFactory.createDeadCellGrid(25, 25));


         Pattern pattern = PatternFactory.boat();
         pattern.draw(universe);
         universe.tick();

         assertTrue(
                 PatternFactory.boatResult().conatinsThisPattern(universe));
    }

}