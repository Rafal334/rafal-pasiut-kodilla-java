package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.row.SudokuRow;

import java.util.ArrayList;
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
                    sudokuChanged = iterateThrougAllCells(this::checkNumberForRowColumnSectionOccurence);
                    sudokuChanged = iterateThrougAllCells(this::canNumberBePlacedInRowColumnSection) || sudokuChanged;
                } catch (BadNumberException e) {
                    if (backtrackList.isEmpty()) {
                        throw new NoSolutionException();
                    } else {
                        sudoku = backtrackList.get(backtrackList.size() - 1);
                        backtrackList.remove(backtrackList.size() - 1);
                    }
                }
            } else {
                backtrackList.add(sudoku.deepCopy());
                guessNumber();
                sudokuChanged = true;
            }

        }
        return sudoku;
    }

    private boolean iterateThrougAllCells(SudokuUpdater updater) throws BadNumberException {
        boolean sudokuChanged = false;
        for (SudokuRow row : sudoku.getRows()) {
            for (SudokuCell cell : row.getCells()) {
                if (cell.isEmpty()) {
                    for (Integer number : cell.getAvailableNumbers()) {
                        sudokuChanged = updater.updateSudoku(cell, number);
                    }
                }
            }
        }
        return sudokuChanged;
    }

    private boolean checkNumberForRowColumnSectionOccurence(SudokuCell cell, Integer number) throws BadNumberException {
        if (isNumberOKForCell(cell, number)) {
            if (cell.isOnlyOneSolution()) {
                cell.setSolution();
                return true;
            }
        } else {
            cell.removeNumberFromAvailableNumbers(number);
            if (cell.getAvailableNumbers().isEmpty()) {
                throw new BadNumberException();
            }
            return false;
        }
        return false;
    }

    private boolean canNumberBePlacedInRowColumnSection(SudokuCell cell, Integer number) {
        if (!canBePlacedInRow(cell, number) && !canBePlacedInColumn(cell, number) && !canBePlacedInSection(cell, number)) {
            cell.setValue(number);
            return true;
        }
        return false;
    }

    private boolean isNumberOKForCell(SudokuCell cell, int number) {
        if (isNumberInRow(cell, number) || isNumberInColumn(cell, number) || isNumberInSection(cell, number)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isNumberInRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(rowCell -> !rowCell.getColumnNumber().equals(cell.getColumnNumber()) && (rowCell.getValue().equals(number)));
    }

    private boolean isNumberInColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if (currentCell.getValue().equals(number) && !(currentCell.getColumnNumber().equals(cell.getColumnNumber()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInSection(SudokuCell cell, int number) {
        int currentRow = (cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS;
        int currentColumn = (cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if (currentCell.getValue().equals(number) && !currentCell.getColumnNumber().equals(cell.getColumnNumber()) && !currentCell.getRowNumber().equals(cell.getRowNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canBePlacedInRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(rowCell -> (!rowCell.getColumnNumber().equals(cell.getColumnNumber())) && (rowCell.isNumberInAvailableNumbers(number)));
    }

    private boolean canBePlacedInColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if (currentCell.isNumberInAvailableNumbers(number) && !currentCell.getColumnNumber().equals(cell.getColumnNumber())) {
                return true;
            }
        }
        return false;
    }

    private boolean canBePlacedInSection(SudokuCell cell, int number) {
        int currentRow = (cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS;
        int currentColumn = (cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if (currentCell.isNumberInAvailableNumbers(number) && !currentCell.getColumnNumber().equals(cell.getColumnNumber()) && !currentCell.getRowNumber().equals(cell.getRowNumber())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void guessNumber() {
        boolean finished = false;
        for (SudokuRow row : sudoku.getRows()) {
            for (SudokuCell cell : row.getCells()) {
                if (cell.isEmpty()) {
                    cell.setValue(cell.getAvailableNumbers().iterator().next());
                    cell.removeNumberFromAvailableNumbers(cell.getAvailableNumbers().iterator().next());
                }
            }
        }
    }
}
