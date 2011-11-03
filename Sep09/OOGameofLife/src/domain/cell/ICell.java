/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.cell;

import domain.universe.NeighbourLocator;
import domain.universe.Location;
import java.util.List;
import state.CellState;

/**
 *
 * 
 */
public interface ICell  {

    /**
     * 
     * @return
     *  A list of nebhours
     */
    public List<ICell> neighbours();

    /**
     * 
     * @return
     *  A cell with the new state corresponding to current state after a tick.
     */
    public ICell next();

    /**
     * 
     * @param cellState
     *   set the cell state
     */
    public void setState(CellState cellState);

    /**
     * 
     * @return
     *  get the cell state
     */
    public CellState getState();

    /**
     * 
     * @return
     * get the cell current location.
     */
    public Location getLocation();

    /**
     * 
     * @param NeighbourLocator
     */
    public void setNeighbourhood(NeighbourLocator INeighbourhood);

    /**
     * 
     * @param cellState
     * @return
     */
    public boolean isSameState(CellState cellState);

   
}
