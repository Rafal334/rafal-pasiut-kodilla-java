package com.kodilla.sudoku.solver.algorithm.backtracking;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.board.SudokuRow;
import com.kodilla.sudoku.exceptions.BadNumberException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CellsIterator {

    private SudokuBoard sudokuBoard;
    private boolean sudokuChanged;
    private SudokuCheckAlgorithm algorithm;
    private boolean breakOnChange;
    private boolean breakIterator;

    public CellsIterator(SudokuBoard sudokuBoard, SudokuCheckAlgorithm algorithm, boolean breakOnChange) {
        this.sudokuBoard = sudokuBoard;
        this.algorithm = algorithm;
        this.breakOnChange = breakOnChange;
    }

    public boolean iterateThroughAllCells() throws BadNumberException {
        breakIterator = false;
        sudokuChanged = false;
        iterateThroughRows();
        return sudokuChanged;
    }

    private void iterateThroughRows() throws BadNumberException {
        Iterator<SudokuRow> rowIterator = sudokuBoard.getRows().iterator();
        SudokuRow row;
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            iterateThroughCells(row.getCells());
            if (breakIterator) {
                break;
            }
        }
    }

    private void iterateThroughCells(List<SudokuCell> cells) throws BadNumberException {
        Iterator<SudokuCell> cellIterator = cells.iterator();
        SudokuCell cell;
        while (cellIterator.hasNext()) {
            cell = cellIterator.next();
            if (cell.isEmpty()) {
                iterateThroughCellAvailableNumbers(cell.getAvailableNumbers(), cell);
                if (breakIterator) {
                    break;
                }
            }
        }
    }

    private void iterateThroughCellAvailableNumbers(Set<Integer> availableNumbers, SudokuCell cell) throws BadNumberException {
        Iterator<Integer> numberIterator = availableNumbers.iterator();
        boolean changed;
        Integer number;

        while (numberIterator.hasNext()) {
            number = numberIterator.next();
            changed = algorithm.runAlgorithm(cell, number);
            if (changed) {
                numberIterator.remove();
                sudokuChanged = true;
                if (cell.getAvailableNumbers().isEmpty() && cell.isEmpty()) {
                    throw new BadNumberException();
                }
                if (breakOnChange) {
                    breakIterator = true;
                    break;
                }
            }
        }
    }
}
