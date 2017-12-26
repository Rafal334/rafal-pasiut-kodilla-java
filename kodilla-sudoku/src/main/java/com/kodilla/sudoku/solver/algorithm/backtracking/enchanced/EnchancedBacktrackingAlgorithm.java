package com.kodilla.sudoku.solver.algorithm.backtracking.enchanced;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.row.SudokuRow;
import com.kodilla.sudoku.solver.BadNumberException;
import com.kodilla.sudoku.solver.NoSolutionException;
import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.solver.SudokuUpdater;
import com.kodilla.sudoku.solver.algorithm.backtracking.backtrack.Backtracker;

import java.util.Iterator;

public class EnchancedBacktrackingAlgorithm implements SudokuSolver {

    private Backtracker backtracker;
    private SudokuBoard sudoku;

    public EnchancedBacktrackingAlgorithm() {
        backtracker = new Backtracker();
    }

    @Override
    public SudokuBoard solve(SudokuBoard sudokuToSolve) throws NoSolutionException, CloneNotSupportedException {
        sudoku = sudokuToSolve;
        boolean sudokuChanged = true;
        int i = 0;
        while (!sudoku.areAllCellsFilled()) {
            if (sudokuChanged) {
                try {
                    sudokuChanged = iterateThrougAllCells(this::checkNumberSimple, false);
                    if (!sudokuChanged) {
                        sudokuChanged = iterateThrougAllCells(this::checkNumberByElimination, true);
                    }
                } catch (BadNumberException e) {
                    sudoku = backtracker.checkBactrackAndRestore();
                    sudokuChanged = true;
                }
            } else {
                backtracker.guessNumber(sudoku);
                sudokuChanged = true;
            }
            i++;
        }
        System.out.println("Iterations to solve this sudoku: " + i);
        return sudoku;
    }

    private boolean iterateThrougAllCells(SudokuUpdater updater, boolean breakOnChange) throws BadNumberException {
        boolean sudokuChanged = false;
        boolean updated;
        Iterator<SudokuRow> rowIterator = sudoku.getRows().iterator();
        SudokuRow row;
        Iterator<SudokuCell> cellIterator;
        SudokuCell cell;
        Iterator<Integer> numberIterator;
        Integer number;

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            cellIterator = row.getCells().iterator();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell.isEmpty()) {
                    numberIterator = cell.getAvailableNumbers().iterator();
                    while (numberIterator.hasNext()) {
                        number = numberIterator.next();
                        updated = updater.updateSudoku(cell, number);
                        removeNumberIfUpdated(updated, cell, numberIterator);
                        if (updated && breakOnChange) {
                            return true;
                        }
                        if (!sudokuChanged) {
                            sudokuChanged = updated;
                        }
                    }
                }
            }
        }
        return sudokuChanged;
    }

    private void removeNumberIfUpdated(boolean update, SudokuCell cell, Iterator<Integer> numberIterator) throws BadNumberException {
        if (update) {
            numberIterator.remove();
            if (cell.getAvailableNumbers().isEmpty() && cell.isEmpty()) {
                throw new BadNumberException();
            }
        }
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
