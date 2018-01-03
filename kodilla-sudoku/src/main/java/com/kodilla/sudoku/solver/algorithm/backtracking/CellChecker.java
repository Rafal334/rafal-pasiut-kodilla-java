package com.kodilla.sudoku.solver.algorithm.backtracking;

import com.kodilla.sudoku.board.SudokuCell;

public interface CellChecker {

    boolean checkCell(SudokuCell cell, int number);
}
