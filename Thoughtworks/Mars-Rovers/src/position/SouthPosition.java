package position;

import location.GridLocation;

/**
 *
 * @author 186946
 */
public class SouthPosition extends AbstractPosition {

    public SouthPosition() {
        super("S");
    }
    
    
    public GridLocation nextLocation(GridLocation cuurentGridLocation) {
        GridLocation nextLocation = GridLocation.value(cuurentGridLocation.getXLocation(), cuurentGridLocation.getYLocation() - 1);
        return nextLocation;
    }

    public Position leftPosition() {
        return new EastPosition();
    }

    public Position rightPosition() {
        return new WestPosition();
    }

}
