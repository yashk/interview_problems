/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import domain.cell.ICell;
import java.util.List;

/**
 *
 * @author 186946
 */
public class DeadState implements CellState {

    
    private final String uniqueNotation = "-";

    public DeadState() {
    }


    public CellState nextState(ICell cell) {
        assert cell.isSameState(this);
        
        List<ICell> list = cell.neighbours();
        int count = 0;
        for (ICell neighbour : list) {
            if (!neighbour.isSameState(this)) {
                count++;
            }
        }

        if (count == 3) {
            return new LiveState();
        }
        return new DeadState();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeadState other = (DeadState) obj;
        if ((this.uniqueNotation == null) ? (other.uniqueNotation != null) : !this.uniqueNotation.equals(other.uniqueNotation)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return uniqueNotation.hashCode();
    }

    @Override
    public String toString() {
        return uniqueNotation;
    }
}
