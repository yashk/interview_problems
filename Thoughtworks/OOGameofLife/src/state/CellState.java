/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package state;

import domain.cell.ICell;

/**
 *
 * @author 186946
 */
public interface CellState {
    public CellState nextState(ICell cell);
}
