/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package location;

import static util.ValidationUtilities.*;

/**
 * Represents a Location on plateau grid.
 * @author 186946
 */
public class GridLocation {
    
    private Integer xLocation;
    private Integer yLocation;
    
    private static GridLocationValidator locationValidator;

    public static void setLocationValidator(GridLocationValidator locationValidator) {
        assertNotNull(locationValidator);
        GridLocation.locationValidator = locationValidator;
    }
    
    private GridLocation(Integer xLocation, Integer yLocation) {
        // validation
        if(locationValidator == null)
            throw new IllegalStateException("Please First set the location Validator");
        
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }
    
    public static GridLocation parseGridLocation(String xLocationString,String yLocationString){
        if(locationValidator == null){
            throw new IllegalStateException("Please First set the location Validator");
        }
        
        locationValidator.assertValideLocation(xLocationString, yLocationString);
        return new GridLocation(Integer.parseInt(xLocationString),Integer.parseInt(yLocationString));
    }
    
    public static GridLocation value(Integer xLocation,Integer yLocation){
        if(locationValidator == null){
            throw new IllegalStateException("Please First set the location Validator");
        }
        
        locationValidator.assertValideLocation(xLocation, yLocation);
        return new GridLocation(xLocation, yLocation);
    }

    public Integer getXLocation() {
        return xLocation;
    }

    public Integer getYLocation() {
        return yLocation;
    }

    @Override
    public String toString() {
        return this.xLocation + " " + this.yLocation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GridLocation other = (GridLocation) obj;
        if (this.xLocation.intValue()!= other.getXLocation().intValue()) {
            return false;
        }
        if (this.yLocation.intValue()!= other.getYLocation().intValue()) {
            return false;
        }
       
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.xLocation != null ? this.xLocation.hashCode() : 0);
        hash = 97 * hash + (this.yLocation != null ? this.yLocation.hashCode() : 0);
        return hash;
    }
    
    
    
    
 }
