/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.neighbourhood;

import domain.universe.Location;
import java.util.List;


public interface Neighborhood {
    public List<Location> neighborLocations(Location centralLocation);
}
