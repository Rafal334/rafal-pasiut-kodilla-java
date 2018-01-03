package com.kodilla.sudoku.solver.algorithm.backtracking;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;

public class Checker {

    private SudokuBoard sudoku;
    private CellChecker checker;

    public Checker(SudokuBoard sudokuBoard) {
        this.sudoku = sudokuBoard;
    }

    public boolean isNumberInRowColumnSection(SudokuCell cell, int number) {
        checker = this::compareCellsValues;
        boolean[] checks = {checkRow(cell, number), checkColumn(cell, number), checkSection(cell, number)};
        return checks[0] || checks[1] || checks[2];
    }

    public boolean canNumberBeAnywhereElse(SudokuCell cell, int number) {
        checker = this::isNumberEmptyAndInAvailableNumbersList;
        boolean[] checks = {checkRow(cell, number), checkColumn(cell, number), checkSection(cell, number)};
        return checks[0] && checks[1] && checks[2];
    }

    private boolean checkRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(currentCell -> (currentCell.differentCellsByPosition(cell)) && checker.checkCell(currentCell,number));
    }

    private boolean checkColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if (checker.checkCell(currentCell,number) && currentCell.differentCellsByPosition(cell)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkSection(SudokuCell cell, int number) {
        int currentRow = ((cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS) * SudokuBoard.SECTION_ROWS;
        int currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if (checker.checkCell(currentCell,number) && currentCell.differentCellsByPosition(cell)) {
                    return true;
                }
            }
            currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        }
        return false;
    }

    private boolean compareCellsValues(SudokuCell cell, int number) {
        return cell.getValue().equals(number);
    }

    private boolean isNumberEmptyAndInAvailableNumbersList(SudokuCell cell, int number) {
        return cell.isNumberInAvailableNumbers(number) && cell.isEmpty();
    }
}
