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
 * @author 186946
 */
public class Cell implements ICell{
    private CellState cellState;
    private Location location;
    private NeighbourLocator neighbourhood;

    /**
     * 
     * @param location
     * @param iNeighbourFinder
     * @param cellState
     */
    public Cell(Location location,CellState cellState) {
        this.cellState = cellState;
        this.location = location;
    }

    public List<ICell> neighbours() {
        return neighbourhood.neighbours(this);
    }

    public ICell next() {
        return new Cell(location,cellState.nextState(this));
    }

    public void setState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getState() {
        return cellState;
    }

    public boolean isSameState(CellState cellState) {
       return this.cellState.equals(cellState);
    }

    public void setNeighbourhood(NeighbourLocator INeighbourhood) {
       this.neighbourhood = INeighbourhood;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (this.cellState != other.cellState && (this.cellState == null || !this.cellState.equals(other.cellState))) {
            return false;
        }
        if (this.location != other.location && (this.location == null || !this.location.equals(other.location))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.cellState != null ? this.cellState.hashCode() : 0);
        hash = 17 * hash + (this.location != null ? this.location.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return cellState.toString();//return "Cell [" + "cellState " + cellState + " " + "location " + location + "]";
    }


}
