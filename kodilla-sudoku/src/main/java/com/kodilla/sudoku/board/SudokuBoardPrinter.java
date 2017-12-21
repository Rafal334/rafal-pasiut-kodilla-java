package com.kodilla.sudoku.board;

import com.kodilla.sudoku.row.SudokuRow;

public class SudokuBoardPrinter {

    public String drawSudokuString(SudokuBoard sudoku) {
        int i = 0;
        StringBuilder sudokuPrint = new StringBuilder();
        for (SudokuRow row : sudoku.getRows()) {
            if (i % SudokuBoard.SECTION_ROWS == 0) {
                sudokuPrint.append(drawLine(SudokuBoard.SUDOKU_SIZE)).append("\n");
            }
            sudokuPrint.append(row).append("\n");
            i++;
        }
        sudokuPrint.append(drawLine(SudokuBoard.SUDOKU_SIZE)).append("\n");
        return sudokuPrint.toString();
    }

    private String drawLine(int length) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append("--");
        }
        return "-" + line.toString();
    }
}
