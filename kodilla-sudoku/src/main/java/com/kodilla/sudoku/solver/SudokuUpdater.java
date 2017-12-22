package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.cell.SudokuCell;

public interface SudokuUpdater {

    boolean updateSudoku(SudokuCell cell, Integer number) throws BadNumberException;
}
