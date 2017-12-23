package com.kodilla.sudoku.solver.algorithm.backtracking.enchanced;

import com.kodilla.sudoku.cell.SudokuCell;

public interface CellChecker {

    boolean checkCell(SudokuCell cell, int number);
}
