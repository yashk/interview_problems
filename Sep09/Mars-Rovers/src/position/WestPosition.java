package position;


import location.GridLocation;

/**
 *
 * @author 186946
 */
public class WestPosition extends AbstractPosition{

    public WestPosition() {
        super("W");
    }
    
    public GridLocation nextLocation(GridLocation cuurentGridLocation) {
        GridLocation nextLocation =  GridLocation.value
                                    (cuurentGridLocation.getXLocation()-1, cuurentGridLocation.getYLocation());
        return nextLocation;
    }

    public Position leftPosition() {
        return new SouthPosition();
    }

    public Position rightPosition() {
        return new NorthPosition();
    }
    
    

}
