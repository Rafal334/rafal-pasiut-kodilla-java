package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.cell.SudokuCell;

public interface SudokuCheckAlgorithm {

    boolean runAlgorithm(SudokuCell cell, Integer number) throws BadNumberException;
}
