package com.kodilla.sudoku.creator.parser;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.creator.CellValueDTO;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CellInputParser {

    public Set<CellValueDTO> parseInput(String input) throws WrogInputException {
        Integer row, column, value;
        Set<CellValueDTO> result = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");

        while (tokenizer.hasMoreTokens()) {
            row = new Integer(tokenizer.nextToken());
            column = new Integer(tokenizer.nextToken());
            value = new Integer(tokenizer.nextToken());
            if (isDataValid(row, column, value)) {
                result.add(new CellValueDTO(row, column, value));
            }
        }
        return result;
    }

    private boolean isDataValid(Integer row, Integer column, Integer value) throws WrogInputException {
        String exceptionMessage ="";
        if(!isNotNull(row, column, value)){
            exceptionMessage+="Bad command\n";
        }
        if(!isElementInRange(row)){
            exceptionMessage+="Row must be in range from 1, to: " + SudokuBoard.SUDOKU_SIZE +"\n";
        }
        if(!isElementInRange(column)){
            exceptionMessage+="Column must be in range from 1, to: " + SudokuBoard.SUDOKU_SIZE +"\n";
        }
        if(!isElementInRange(value)){
            exceptionMessage+="Value must be in range from 1, to: " + SudokuBoard.SUDOKU_SIZE +"\n";
        }
        if(exceptionMessage.isEmpty()){
            return true;
        }else{
            throw new WrogInputException(exceptionMessage);
        }
    }

    private boolean isNotNull(Integer row, Integer column, Integer value) {
        return row != null && column != null && value != null;
    }

    private boolean isElementInRange(Integer elementValue) {
        return elementValue >= 1 && elementValue <= SudokuBoard.SUDOKU_SIZE;
    }
}
