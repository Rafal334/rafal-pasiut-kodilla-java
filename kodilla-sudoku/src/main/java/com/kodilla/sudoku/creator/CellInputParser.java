package com.kodilla.sudoku.creator;

import com.kodilla.sudoku.board.SudokuBoard;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CellInputParser {

    public Set<CellValueDTO> parseInput(String input) throws WrogInputException {
        Integer row, column, value;
        Set<CellValueDTO> result = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");

        while (tokenizer.hasMoreTokens()) {
            try {
                row = new Integer(tokenizer.nextToken());
                column = new Integer(tokenizer.nextToken());
                value = new Integer(tokenizer.nextToken());
                if (isDataValid(row, column, value)) {
                    result.add(new CellValueDTO(row, column, value));
                } else {
                    throw new WrogInputException();
                }
            } catch (Exception e) {
                throw new WrogInputException();
            }
        }
        return result;
    }

    private boolean isDataValid(Integer row, Integer column, Integer value) {
        return (row != null && column != null && value != null) && ((row >= 1 && row <= SudokuBoard.SUDOKU_SIZE) && (column >= 1 && column <= SudokuBoard.SUDOKU_SIZE) && (value >= 1 && value <= SudokuBoard.SUDOKU_SIZE));
    }
}
