package com.kodilla.sudoku.solver.enchancedBacktrackingAlgorithm;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.row.SudokuRow;
import com.kodilla.sudoku.solver.BadNumberException;
import com.kodilla.sudoku.solver.NoSolutionException;
import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.solver.SudokuUpdater;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnchancedBacktrackingAlgorithm implements SudokuSolver {

    private List<SudokuBoard> backtrackList;
    private SudokuBoard sudoku;

    public EnchancedBacktrackingAlgorithm() {
        this.backtrackList = new ArrayList<>();
    }

    @Override
    public SudokuBoard solve(SudokuBoard sudokuToSolve) throws NoSolutionException, CloneNotSupportedException {
        sudoku = sudokuToSolve;
        boolean sudokuChanged = true;
        while (!sudoku.areAllCellsFilled()) {
            if (sudokuChanged) {
                try {
                    sudokuChanged = iterateThrougAllCells(this::checkNumberForRowColumnSectionOccurence, false);
                    if (!sudokuChanged) {
                        sudokuChanged = iterateThrougAllCells(this::canNumberBePlacedInRowColumnSection, true);
                    }
                    if (!sudokuChanged) {
                        System.out.println("--NO CHANGE--");
                    }
                } catch (BadNumberException e) {
                    if (backtrackList.isEmpty()) {
                        throw new NoSolutionException();
                    } else {
                        sudoku = backtrackList.get(backtrackList.size() - 1);
                        backtrackList.remove(backtrackList.size() - 1);
                        System.out.println(sudoku);
                        System.out.println("BACKTRACK");
                        sudokuChanged = true;
                    }
                }
            } else {
                NumberGuesser numberGuesser = new NumberGuesser(sudoku, backtrackList);
                numberGuesser.guessNumber();
                System.out.println(sudoku);
                System.out.println("GUESS");
                sudokuChanged = true;
            }
        }
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

    private boolean checkNumberForRowColumnSectionOccurence(SudokuCell cell, Integer number) {
        ValueOccurenceChecker valueOccurenceChecker = new ValueOccurenceChecker(sudoku);
        boolean isNumberOK = valueOccurenceChecker.isNumberOKForCell(cell, number);
        if (isNumberOK) {
            if (cell.isOnlyOneSolution()) {
                cell.setSolution();
                System.out.println(sudoku);
                System.out.println("SET");
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean canNumberBePlacedInRowColumnSection(SudokuCell cell, Integer number) {
        EliminationChecker eliminationChecker = new EliminationChecker(sudoku);
        boolean isNumberOK = eliminationChecker.isNumberOKByElimination(cell, number);
        if (isNumberOK) {
            cell.setValue(number);
            System.out.println(sudoku);
            System.out.println("SET BY ELIMINATION");
            return true;
        }
        return false;
    }
}
