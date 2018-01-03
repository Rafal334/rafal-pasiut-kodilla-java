package com.kodilla.sudoku.solver.algorithm.backtracking;

import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.exceptions.BadNumberException;

public interface SudokuCheckAlgorithm {

    boolean runAlgorithm(SudokuCell cell, Integer number) throws BadNumberException;
}
