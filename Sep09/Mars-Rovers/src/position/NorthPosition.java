

package position;

import location.GridLocation;

/**
 *
 * @author 186946
 */
public class NorthPosition extends AbstractPosition{

    public NorthPosition() {
        super("N");
    }
    
    

    public GridLocation nextLocation(GridLocation cuurentLocation) {
        GridLocation nextLocation = GridLocation.value
                                    (cuurentLocation.getXLocation(), cuurentLocation.getYLocation()+1);
        return nextLocation;
    }

    public Position leftPosition() {
        return new WestPosition();
    }

    public Position rightPosition() {
        return new EastPosition();
    }

  
    
    

}
