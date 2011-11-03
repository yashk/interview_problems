/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.pattern;

import domain.universe.*;
import domain.cell.ICell;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 186946
 */
public class Pattern {
    private List<ICell> cells = new ArrayList<ICell>();

    public void draw(IUniverse iUniverse){
        for (ICell iCell : cells) {
            iUniverse.setCellState(iCell.getLocation(),iCell.getState());
        }
    }


    public boolean conatinsThisPattern(IUniverse iUniverse){
        boolean success = true;
        for (ICell iCell : cells) {
          ICell nextCell =  iUniverse.getnextCell(iCell.getLocation());
            
           if(!(nextCell.getState().equals(iCell.getState()))){
               success = false;
           }
        }

        return success;
    }



    public void addCells(ICell cell){
        cells.add(cell);
    }

    @Override
    public String toString() {
        return "Pattern [" + "cells " + cells + "]";
    }

   


    
}
