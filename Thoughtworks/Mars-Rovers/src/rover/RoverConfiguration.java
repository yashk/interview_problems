/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rover;


import location.GridLocation;
import position.AbstractPosition;
import position.Position;
import static util.ValidationUtilities.*;


/**
 * Represents configuration of rover , it is a combination of its position and location.
 * @author Yashodhan Kocharekar
 */
public class RoverConfiguration {
    
    /**
     * 
     */
    private Position currentPosition;
    /**
     * 
     */
    private GridLocation currentLocation;
    
    /**
     * 
     * @param currentPosition
     * @param currentLocation
     */
    public RoverConfiguration(Position currentPosition, GridLocation currentLocation) {
        assertNotNull(currentLocation);
        assertNotNull(currentLocation);
        
        this.currentPosition = currentPosition;
        this.currentLocation = currentLocation;
    }


    /**
     * 
     * @return configuration if the rover rotated left maintaing the same location
     */
    public RoverConfiguration rotateLeftConfiguration(){
        return new RoverConfiguration(currentPosition.leftPosition(),
                currentLocation);
    }
    
    /**
     * 
     * @return configuration if the rover rotated right maintaing the same location
     */
    public RoverConfiguration rotateRightConfiguration(){
        return new RoverConfiguration(currentPosition.rightPosition(),
                currentLocation);
    }
    
    /**
     * 
     * @return configuration if the rover moved one step maintaing the same position
     * @throws IllegalArgumentException if the next position lies beyond the plateau grid
     */
    public RoverConfiguration moveForwardConfiguration(){
        return new RoverConfiguration(currentPosition,
                currentPosition.nextLocation(currentLocation));
    
    }

    /**
     * Parses a configuration from string
     * @param roverConfiguration
     * @return
     * IllegalArgumentException if string argument is empty null or does not represent a valide rover configuration
     */
    public static RoverConfiguration parseConfiguration(String roverConfiguration) {
        
        if (roverConfiguration == null || roverConfiguration.length() == 0) {
            throw new IllegalArgumentException("RoverConfiguration can not be null on empty");
        }
        
        String [] feilds = roverConfiguration.split(" ");
        
        if(feilds.length !=3){
            throw new IllegalArgumentException("Not a valide rover configuration["+roverConfiguration+"] must have format X Y P (p belongs to {N,S,E,W})");
        }

        GridLocation gridLocation = GridLocation.parseGridLocation(feilds[0],feilds[1]);
        Position position = AbstractPosition.parsePosition(feilds[2]);
        
        
        return new RoverConfiguration(position, gridLocation);
            
    }
    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        return currentLocation.toString()+" "+ currentPosition.toString();
    }

    /**
     * 
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoverConfiguration other = (RoverConfiguration) obj;
        if (this.currentPosition != other.currentPosition && (this.currentPosition == null || !this.currentPosition.equals(other.currentPosition))) {
            return false;
        }
        if (this.currentLocation != other.currentLocation && (this.currentLocation == null || !this.currentLocation.equals(other.currentLocation))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.currentPosition != null ? this.currentPosition.hashCode() : 0);
        hash = 37 * hash + (this.currentLocation != null ? this.currentLocation.hashCode() : 0);
        return hash;
    }
}
