package com.kodilla.sudoku.creator;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.exceptions.NotUniqueCellValue;
import com.kodilla.sudoku.exceptions.WrogInputException;
import com.kodilla.sudoku.solver.algorithm.backtracking.Checker;

import java.util.Set;

public class Creator {

    private SudokuBoard sudokuBoard = new SudokuBoard();
    private CellInputParser parser = new CellInputParser();
    private Checker checker;

    public void createNewBoard() {
        sudokuBoard = new SudokuBoard();
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public SudokuBoard addNumbersToBoard(String line) throws WrogInputException, NotUniqueCellValue {
        setCellsInSudoku(parser.parseInput(line));
        return sudokuBoard;
    }

    private void setCellsInSudoku(Set<CellValueDTO> cells) throws NotUniqueCellValue {
        checker = new Checker(sudokuBoard);
        for (CellValueDTO cell : cells) {
            if (isValueUnique(cell)) {
                sudokuBoard.setCell(cell);
            } else {
                throw new NotUniqueCellValue("Value " + cell.getValue() + ", can`t be in row: " + cell.getRowNumber() + ", column: " + cell.getColumnNumber() + ". Value is NOT unique.");
            }
        }
    }

    private boolean isValueUnique(CellValueDTO cell) {
        return !checker.isNumberInRowColumnSection(new SudokuCell(cell.getRowNumber(), cell.getColumnNumber()), cell.getValue());
    }
}