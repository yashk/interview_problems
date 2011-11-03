/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.universe;

import domain.cell.ICell;
import domain.pattern.Pattern;
import state.CellState;

/**
 *
 * @author 186946
 */
public interface IUniverse  {


    /**
     * 
     * @param location - location of cell.
     * @param state - state of cell.
     */
    public void setCellState(Location location , CellState state);



    /**
     *
     * @param location - location of cell.
     * @param state - state of cell.
     */
    public ICell getnextCell(Location location);


    /**
     * 
     */
    public void tick();

    

    
   
}
