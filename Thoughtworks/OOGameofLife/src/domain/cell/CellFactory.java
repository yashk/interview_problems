/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.cell;

import domain.universe.Location;
import state.CellState;
import state.DeadState;

/**
 *
 * @author 186946
 */
public class CellFactory {

    public ICell createCell(int x , int y , CellState cellState){
        return null;
    }


    public static ICell [][] createDeadCellGrid(int maxX,int maxY){
        ICell [][] grid = new ICell[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                CellState cellState = new DeadState();
                ICell cell = new Cell(
                        new Location(i, j),
                        cellState);
               
                cell.setState(cellState);
                grid[i][j] = cell;
            }
        }

        return grid;
    }
    
}
