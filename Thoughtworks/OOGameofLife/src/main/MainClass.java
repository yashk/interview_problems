/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.cell.CellFactory;
import domain.neighbourhood.NeighborhoodFactory;
import domain.pattern.Pattern;
import domain.pattern.PatternFactory;
import domain.universe.IUniverse;
import domain.universe.Location;
import domain.universe.TwoDimensionalUniverse;

/**
 *
 * @author 186946
 */
public class MainClass {

    public static void main(String[] args) {
        IUniverse universe = new TwoDimensionalUniverse(
                new Location(25, 25),
                NeighborhoodFactory.getMooreNeighborhood(),
                CellFactory.createDeadCellGrid(25, 25));


        Pattern pattern = PatternFactory.blinker();
        pattern.draw(universe);
        universe.tick();


    }
}
