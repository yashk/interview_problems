
package position;


import location.GridLocation;

/**
 *
 * @author 186946
 */
public class EastPosition extends AbstractPosition{

    public EastPosition() {
        super("E");
    }

    public GridLocation nextLocation(GridLocation cuurentGridLocation) {

        GridLocation nextLocation = GridLocation.value
                                    (cuurentGridLocation.getXLocation() + 1, cuurentGridLocation.getYLocation());
        return nextLocation;
    }

    public Position leftPosition() {
        return new NorthPosition();
    }

    public Position rightPosition() {
        return new SouthPosition();
    }
}
