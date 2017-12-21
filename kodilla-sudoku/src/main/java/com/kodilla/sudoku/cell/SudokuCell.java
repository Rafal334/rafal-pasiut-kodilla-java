package com.kodilla.sudoku.cell;

import com.kodilla.sudoku.board.SudokuBoard;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuCell {

    private static final int EMPTY_CELL_VALUE = -1;
    private static final String EMPTY_FIELD_SIGN = ".";


    private Integer value;
    private Set<Integer> availableNumbers;
    private Integer rowNumber;
    private Integer columnNumber;

    public SudokuCell(int rowNumber, int columnNumber) {
        value = EMPTY_CELL_VALUE;
        availableNumbers = IntStream
                .range(1, SudokuBoard.SUDOKU_SIZE)
                .mapToObj(i -> (Integer) i)
                .collect(Collectors.toCollection(HashSet::new));
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == EMPTY_CELL_VALUE;
    }

    @Override
    public String toString() {
        if (value != EMPTY_CELL_VALUE) {
            return value.toString();
        } else {
            return EMPTY_FIELD_SIGN;
        }
    }
}
