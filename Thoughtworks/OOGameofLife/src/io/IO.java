package io;

import domain.cell.Cell;
import domain.cell.ICell;
import domain.universe.Location;
import domain.pattern.Pattern;
import java.util.NoSuchElementException;
import java.util.Scanner;
import state.CellState;
import state.DeadState;
import state.LiveState;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 186946
 */
public class IO {

    /**
     * 
     * @param input
     * @return
     */
    public Pattern getPattern(String input) {
        Pattern pattern = new Pattern();
        try {
            collectCellRows(pattern, input);
            return pattern;
        } catch (NoSuchElementException nsee) {
            throw new IllegalArgumentException("Invalide input Format\n[" + input + "]\n Each line of input should terminate with a line feed and carriage return");
        }
    }

    private void collectCellRows(Pattern pattern, String input) {
        Scanner scanner = new Scanner(input);
        int rowIndex = 0;
        while (scanner.hasNextLine()) {
            collectRow(pattern, scanner.nextLine(), rowIndex);
            rowIndex++;
        }
    }

    private void collectRow(Pattern pattern, String nextLine, int rowIndex) {
        String[] cellStateStringArray = nextLine.split("\\s");
        int columunIndex = 0;
        for (String cellStateString : cellStateStringArray) {
            pattern.addCells(parseCell(rowIndex, columunIndex, cellStateString));
            columunIndex++;
        }
    }

    private ICell parseCell(int x, int y, String stateString) {
        if (stateString.equals("-")) {
            return getCell(new Location(x, y), new DeadState());
        } else if (stateString.equals("X")) {
            return getCell(new Location(x, y), new LiveState());
        }
        throw new IllegalArgumentException("[" + stateString + "]" + "does not represents a valid state");
    }

    private ICell getCell(Location location, CellState cellState) {
        return new Cell(location, cellState);
    }
}
