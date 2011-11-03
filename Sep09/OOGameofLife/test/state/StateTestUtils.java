/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package state;

import domain.cell.ICell;
import domain.universe.NeighbourLocator;
import domain.universe.Location;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 186946
 */
public class StateTestUtils {
     public static ICell getCellWithNLiveAndMDeadNebhours(final int n , final  int m , final boolean isLive){
        ICell iCell = new ICell() {

            public List<ICell> neighbours() {
                List<ICell> liveCells = getNLiveCells(n);
                List<ICell> deadCells = getNDeadCells(m);

                liveCells.addAll(deadCells);

                return liveCells;

             }

            public ICell next() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setState(CellState cellState) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public CellState getState() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Location getLocation() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setNeighbourhood(NeighbourLocator INeighbourhood) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean isSameState(CellState cellState) {
                if(isLive)
                    return new LiveState().equals(cellState);
                return new DeadState().equals(cellState);
            }
        };

        return iCell;
    }



    private static List<ICell> getNLiveCells(int n){
        List<ICell> cells = new ArrayList<ICell>();

        for(int i=0;i<n;i++){
            cells.add(liveCell());
        }

        return cells;
    }


     private static List<ICell> getNDeadCells(int n){
        List<ICell> cells = new ArrayList<ICell>();

        for(int i=0;i<n;i++){
            cells.add(deadCell());
        }

        return cells;
    }


    private static ICell liveCell(){
        return new ICell() {

            public List<ICell> neighbours() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public ICell next() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setState(CellState cellState) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public CellState getState() {
                return new LiveState();
            }

            public Location getLocation() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setNeighbourhood(NeighbourLocator INeighbourhood) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean isSameState(CellState cellState) {
                return new LiveState().equals(cellState);
            }
        };
    }


    private static ICell deadCell(){
        return new ICell() {

            public List<ICell> neighbours() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public ICell next() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setState(CellState cellState) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public CellState getState() {
                return new DeadState();
            }

            public Location getLocation() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void setNeighbourhood(NeighbourLocator INeighbourhood) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean isSameState(CellState cellState) {
                return new DeadState().equals(cellState);
            }
        };
    }
}
