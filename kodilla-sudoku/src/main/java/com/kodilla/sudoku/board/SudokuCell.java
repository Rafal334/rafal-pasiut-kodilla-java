package com.kodilla.sudoku.board;

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
                .range(1, SudokuBoard.SUDOKU_SIZE+1)
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

    public void copyCell(SudokuCell sourceCell) {
        value = sourceCell.value;
        rowNumber = sourceCell.rowNumber;
        columnNumber = sourceCell.columnNumber;
        availableNumbers.clear();
        sourceCell.availableNumbers.stream().forEach(number -> availableNumbers.add(number));
    }

    public void removeNumberFromAvailableNumbers(Integer number) {
        availableNumbers.remove(number);
    }

    public boolean isOnlyOneSolution() {
        return availableNumbers.size() == 1;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getColumnNumber() {
        return columnNumber;
    }

    public void setSolution() {
        if (availableNumbers.size() == 1) {
            value = availableNumbers.iterator().next();
        }
    }

    public Set<Integer> getAvailableNumbers() {
        return availableNumbers;
    }

    public boolean isNumberInAvailableNumbers(Integer number){
        return availableNumbers.contains(number);
    }

    public boolean differentCellsByPosition(SudokuCell cell){
        return !rowNumber.equals(cell.getRowNumber()) || !columnNumber.equals(cell.getColumnNumber());
    }
}
