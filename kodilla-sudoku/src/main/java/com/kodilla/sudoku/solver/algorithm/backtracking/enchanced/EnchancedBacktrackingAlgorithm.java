package com.kodilla.sudoku.solver.algorithm.backtracking.enchanced;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.solver.BadNumberException;
import com.kodilla.sudoku.solver.NoSolutionException;
import com.kodilla.sudoku.solver.SudokuCheckAlgorithm;
import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.solver.algorithm.backtracking.backtrack.Backtracker;
import com.kodilla.sudoku.solver.algorithm.backtracking.iterator.CellsIterator;

public class EnchancedBacktrackingAlgorithm implements SudokuSolver {

    private Backtracker backtracker;
    private SudokuBoard sudoku;
    private CellsIterator cellsIterator;

    public EnchancedBacktrackingAlgorithm() {
        backtracker = new Backtracker();
    }

    @Override
    public SudokuBoard solve(SudokuBoard sudokuToSolve) throws NoSolutionException, CloneNotSupportedException {
        if (sudokuToSolve != null) {
            sudoku = sudokuToSolve;
            boolean sudokuChanged = true;
            int i = 0;
            while (!sudoku.areAllCellsFilled()) {
                if (sudokuChanged) {
                    sudokuChanged = runCheckAlgorithms();
                } else {
                    backtracker.guessNumber(sudoku);
                    sudokuChanged = true;
                }
                i++;
            }
            System.out.println("Iterations to solve this sudoku: " + i);
        }
        return sudoku;
    }

    private boolean runCheckAlgorithms() throws NoSolutionException {
        boolean sudokuChanged;
        try {
            sudokuChanged = checkSudokuWithAlgorithm(this::checkNumberSimple, false);
            if (!sudokuChanged) {
                sudokuChanged = checkSudokuWithAlgorithm(this::checkNumberByElimination, true);
            }
        } catch (BadNumberException e) {
            sudoku = backtracker.checkBactrackAndRestore();
            sudokuChanged = true;
        }
        return sudokuChanged;
    }

    private boolean checkSudokuWithAlgorithm(SudokuCheckAlgorithm algorithm, boolean breakOnChange) throws BadNumberException {
        cellsIterator = new CellsIterator(sudoku, algorithm, breakOnChange);
        return cellsIterator.iterateThroughAllCells();
    }

    private boolean checkNumberSimple(SudokuCell cell, Integer number) {
        Checker checker = new Checker(sudoku);
        boolean isNumberNOK = checker.isNumberInRowColumnSection(cell, number);
        if (isNumberNOK) {
            return true;
        } else {
            if (cell.isOnlyOneSolution()) {
                cell.setSolution();
                return true;
            }
            return false;
        }
    }

    private boolean checkNumberByElimination(SudokuCell cell, Integer number) {
        Checker checker = new Checker(sudoku);
        boolean isNumberNOK = checker.canNumberBeAnywhereElse(cell, number);
        if (isNumberNOK) {
            return false;
        } else {
            cell.setValue(number);
            return true;
        }

    }
}
