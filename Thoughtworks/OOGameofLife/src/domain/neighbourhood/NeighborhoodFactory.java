/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.neighbourhood;

/**
 *
 * @author 186946
 */
public class NeighborhoodFactory {

    public static Neighborhood getMooreNeighborhood(){
        return new MooreNeighborhood();
    }

}
