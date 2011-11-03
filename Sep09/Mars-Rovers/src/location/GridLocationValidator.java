/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package location;


import static util.ValidationUtilities.*;

/**
 * Set of meyhods to validate Grid Location.
 * @author 186946
 */
public class GridLocationValidator {
    
    private  Integer maxXLocation= Integer.MAX_VALUE;
    private  Integer maxYLocation= Integer.MAX_VALUE;

    
    

    
    public GridLocationValidator(String maxLocation) {
         
         if(isNullOrEmpty(maxLocation)){
            throw new IllegalArgumentException("Grid Location can not be null or empty");
         }
         
         String [] locationxy = maxLocation.split(" ");
         
         if(locationxy ==null || locationxy.length!=2){
            throw new IllegalArgumentException("Invalide max location ["+ maxLocation+"] must be of form X 'SPACE' Y");
         }
         if(!isNonNegativeInteger(locationxy[0]) ||
                 !isNonNegativeInteger(locationxy[1])){
            throw new IllegalArgumentException("Invalide max location ["+ maxXLocation +" "+maxYLocation +"] both x and y should be valide non negative integers");
         }
         
         this.maxXLocation = Integer.parseInt(locationxy[0]);
         this.maxYLocation = Integer.parseInt(locationxy[1]);
    }
    
    
    
    
    
    
    public  void assertValideLocation(Integer xLocation ,Integer yLocation) throws IllegalArgumentException{
        
        if(isNegative(xLocation) || isNegative(yLocation)){
            throw new IllegalArgumentException("Location can not be negative");
        }
        assertLessThanMaxLocation(xLocation, yLocation);
        
    }
    
    public  void assertValideLocation(String xLocation ,String yLocation) throws IllegalArgumentException{
        
        if(!isNonNegativeInteger(xLocation) ||
         !isNonNegativeInteger(yLocation)){
            throw new IllegalArgumentException("Invalide  location ["+ xLocation +" "+yLocation +"]");
         }
        assertLessThanMaxLocation(Integer.parseInt(xLocation), Integer.parseInt(yLocation));
        
    }

    private void assertLessThanMaxLocation(Integer xLocation, Integer yLocation) throws IllegalArgumentException {

        if (xLocation > maxXLocation) {
            throw new IllegalArgumentException("X Location can not be >=  : " + maxXLocation);
        }

        if (yLocation > maxYLocation) {
            throw new IllegalArgumentException("Y Location can not be >=  : " + maxYLocation);
        }
    }
    
    
    
}
