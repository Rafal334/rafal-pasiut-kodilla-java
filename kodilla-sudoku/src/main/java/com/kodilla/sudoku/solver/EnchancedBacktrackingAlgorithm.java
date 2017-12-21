package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;

import java.util.ArrayList;
import java.util.List;

public class EnchancedBacktrackingAlgorithm implements SudokuSolver {

    private List<SudokuBoard> backtrackList;
    private SudokuBoard sudoku;

    public EnchancedBacktrackingAlgorithm(SudokuBoard sudoku) {
        this.backtrackList = new ArrayList<>();
        this.sudoku = sudoku;
    }

    @Override
    public SudokuBoard solve() throws NoSolutionException {
        return null;
    }
}
