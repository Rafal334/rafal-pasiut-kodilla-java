package com.kodilla.sudoku.solver.algorithm.backtracking.enchanced;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;

public class EliminationChecker {

    private SudokuBoard sudoku;

    public EliminationChecker(SudokuBoard sudokuBoard) {
        this.sudoku = sudokuBoard;
    }

    public boolean isNumberOKByElimination(SudokuCell cell, Integer number) {
        boolean[] checks = {!canBePlacedInRow(cell, number), !canBePlacedInColumn(cell, number), !canBePlacedInSection(cell, number)};
        return checks[0] || checks[1] || checks[2];
    }

    private boolean canBePlacedInRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(rowCell -> ((rowCell.differentCellsByPosition(cell))) && (rowCell.isNumberInAvailableNumbers(number)) && rowCell.isEmpty());
    }

    private boolean canBePlacedInColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if ((currentCell.isNumberInAvailableNumbers(number) && currentCell.differentCellsByPosition(cell)) && currentCell.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean canBePlacedInSection(SudokuCell cell, int number) {
        int currentRow = ((cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS) * SudokuBoard.SECTION_ROWS;
        int currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if ((currentCell.isNumberInAvailableNumbers(number) && currentCell.differentCellsByPosition(cell)) && currentCell.isEmpty()) {
                    return true;
                }
            }
            currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        }
        return false;
    }
}
