package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;

public interface SudokuSolver {

    SudokuBoard solve() throws NoSolutionException;
}
