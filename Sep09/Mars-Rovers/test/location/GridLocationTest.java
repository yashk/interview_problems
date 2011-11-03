package location;

import org.junit.Test;

/**
 *
 * @author Yashodhan Kocharekar
 */
public class GridLocationTest {

    
    

     /**
     * Test of value method, of class GridLocation.
     */
    @Test
    public void testValue() {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
        GridLocation result = GridLocation.value(5, 5);
        
    }
    
    @Test
    public void testparseGridLocation() {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
        GridLocation result = GridLocation.parseGridLocation("5", "5");
        
    }
    
     @Test(expected=IllegalArgumentException.class)
    public void testInvalideValue() {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
        GridLocation result = GridLocation.value(10, 20);
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testInavlideParseGridLocation() {
        GridLocation.setLocationValidator(new GridLocationValidator("5 5"));
        GridLocation result = GridLocation.parseGridLocation("10", "10");
        
    }
}