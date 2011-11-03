/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.neighbourhood;

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
public class NeighborhoodTest {

    public NeighborhoodTest() {
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

    /**
     * Test of neighborLocations method, of class Neighborhood.
     */
    @Test
    public void testNeighborLocations() {
        Neighborhood instance = new MooreNeighborhood();
        List <Location>locations = new ArrayList<Location>();
        Location centralLocation = new Location(0, 0);

        int x = centralLocation.getX();
        int y = centralLocation.getY();

        locations.add(new Location(x + 1, y));
        locations.add(new Location(x - 1, y));

        locations.add(new Location(x, y + 1));
        locations.add(new Location(x, y - 1));

        locations.add(new Location(x + 1, y + 1));
        locations.add(new Location(x + 1, y - 1));

        locations.add(new Location(x - 1, y + 1));
        locations.add(new Location(x - 1, y - 1));

        List result = instance.neighborLocations(centralLocation);
        assertEquals(locations, result);
        
        
    }

    

}