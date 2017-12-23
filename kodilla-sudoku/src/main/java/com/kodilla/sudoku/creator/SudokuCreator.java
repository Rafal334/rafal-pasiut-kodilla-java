package com.kodilla.sudoku.creator;

import com.kodilla.sudoku.board.SudokuBoard;
import java.util.Set;

public class SudokuCreator {

    private SudokuBoard sudokuBoard = new SudokuBoard();
    private CellInputParser parser = new CellInputParser();

    public SudokuBoard prepareSudokuDraft(String line) throws WrogInputException {
        sudokuBoard = new SudokuBoard();
        setCellsInSudoku(parser.parseInput(line));
        return sudokuBoard;
    }

    private void setCellsInSudoku(Set<CellValueDTO> cells) {
        sudokuBoard.setCells(cells);
    }
}