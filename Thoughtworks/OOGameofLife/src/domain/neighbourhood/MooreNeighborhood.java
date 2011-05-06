package domain.neighbourhood;

import domain.universe.Location;
import java.util.ArrayList;
import java.util.List;


public class MooreNeighborhood implements Neighborhood {

    public List<Location> neighborLocations(Location centralLocation) {
        List<Location> locations = new ArrayList<Location>();

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
        

        return locations;
    }
}
