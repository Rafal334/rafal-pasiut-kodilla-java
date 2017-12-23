package com.kodilla.sudoku.solver.algorithm.backtracking.enchanced;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;

public class ValueOccurenceChecker {

    private SudokuBoard sudoku;

    public ValueOccurenceChecker(SudokuBoard sudoku) {
        this.sudoku = sudoku;
    }

    public boolean isNumberOKForCell(SudokuCell cell, int number) {
        boolean[] checks = {!isNumberInRow(cell, number), !isNumberInColumn(cell, number), !isNumberInSection(cell, number)};
        return checks[0] && checks[1] && checks[2];
    }

    private boolean isNumberInRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(rowCell -> rowCell.differentCellsByPosition(cell) && (rowCell.getValue().equals(number)));
    }

    private boolean isNumberInColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if (currentCell.getValue().equals(number) && currentCell.differentCellsByPosition(cell)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInSection(SudokuCell cell, int number) {
        int currentRow = ((cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS) * SudokuBoard.SECTION_ROWS;
        int currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if (currentCell.getValue().equals(number) && currentCell.differentCellsByPosition(cell)) {
                    return true;
                }
            }
            currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        }
        return false;
    }
}
