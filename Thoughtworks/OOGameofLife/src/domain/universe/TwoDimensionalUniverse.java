/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.universe;

import domain.cell.ICell;
import domain.neighbourhood.Neighborhood;
import domain.pattern.Pattern;
import java.util.ArrayList;
import java.util.List;
import state.CellState;

/**
 *
 * @author 186946
 */
public class TwoDimensionalUniverse implements IUniverse, NeighbourLocator {

    private Location maxLocation;
    private ICell[][] grid;
    private Neighborhood neighborhood;
    ICell[][] nextGrid;

    public TwoDimensionalUniverse(Location maxLocation, Neighborhood neighborhood,ICell[][] grid) {
        this.maxLocation = maxLocation;
        this.grid = grid;
        this.neighborhood = neighborhood;

        setNeighbourLocator(grid);
    }

    public void setCellState(Location location, CellState state) {
        int deltaX = location.getX() + maxLocation.getX() / 2;
        int deltaY = location.getY() + maxLocation.getY() / 2;
        ICell cell = grid[deltaX][deltaY];
        if (cell != null) {
            cell.setState(state);
        }
    }

    public ICell getnextCell(Location location){
        int deltaX = location.getX() + maxLocation.getX() / 2;
        int deltaY = location.getY() + maxLocation.getY() / 2;
        try{
        ICell cell = grid[deltaY][deltaX];
        return cell;
        }catch(Exception exception){
            return null;
        }
       
    }

    public void drawPattern(Pattern pattern) {
        pattern.draw(this);
    }

    

    public void tick() {
        nextGrid = new ICell[maxLocation.getX()][maxLocation.getY()];
        for (int i = 0; i < maxLocation.getX(); i++) {
            for (int j = 0; j < maxLocation.getY(); j++) {
                nextGrid[i][j] = grid[i][j].next();
            }
        }
       System.out.println("Input");
        print(grid);
        System.out.println("Output");
        print(nextGrid);
    }

    private void print(ICell[][] nextGrid) {
        for (int i = 0; i < maxLocation.getX(); i++) {
            System.out.println();
            for (int j = 0; j < maxLocation.getY(); j++) {
                System.out.print(nextGrid[i][j]);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public List<ICell> neighbours(ICell cell) {
        Location cellLocation = cell.getLocation();
        List<ICell> neighborList = new ArrayList<ICell>();
        List<Location> neighborLocations = neighborhood.neighborLocations(cellLocation);

        for (Location neighborLocation : neighborLocations) {
            addIfNotNull(neighborList, getNeighbours(neighborLocation));
        }
        return neighborList;
    }

    private ICell getNeighbours(Location location) {
        try {
            return grid[location.getX()][location.getY()];
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            return null;
        }
    }

    private void addIfNotNull(List<ICell> list, ICell iCell) {
        if (iCell != null) {
            list.add(iCell);
        }
    }

    private void setNeighbourLocator(ICell[][] grid) {
        for(int i=0;i<maxLocation.getX();i++){
            for(int j=0;j<maxLocation.getY();j++){
                grid[i][j].setNeighbourhood(this);
            }
        }
    }

    
}