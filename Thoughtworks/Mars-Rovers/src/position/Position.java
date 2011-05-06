package position;


import location.GridLocation;

/**
 * Respresnts a position of the rover
 * @author 186946
 */
public interface Position {
    
    /**
     * 
     * @return position left to current position
     */
    public Position leftPosition();
    /**
     * 
     * @return position right to current position
     */
    public Position rightPosition();
    
    /**
     * 
     * @param cuurentGridLocation
     * @return next grid location depndening upon grid location passed as parameter
     */
    public GridLocation nextLocation(GridLocation cuurentGridLocation); 
}
