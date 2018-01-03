package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.exceptions.NoSolutionException;

public interface SudokuSolver {

    SudokuBoard solve(SudokuBoard sudokuToSolve) throws NoSolutionException, CloneNotSupportedException;
}
