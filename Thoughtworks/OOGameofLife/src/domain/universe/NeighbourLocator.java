/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.universe;

import domain.cell.ICell;
import java.util.List;

/**
 *
 *  A service that returns the all neighbours of a cell.
 */
public interface NeighbourLocator {

    /**
     *
     * @param cell - the central cell whoes neighbours are to be found.
     * @return A list - contataing all the neighbour.
     *
     */
    List<ICell> neighbours(ICell cell);

}
