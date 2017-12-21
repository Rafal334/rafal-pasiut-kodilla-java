package com.kodilla.sudoku.creator;

public class CellValueDTO {

    private Integer rowNumber;
    private Integer columnNumber;
    private Integer value;

    public CellValueDTO(Integer rowNumber, Integer columnNumber, Integer value) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.value = value;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public Integer getColumnNumber() {
        return columnNumber;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellValueDTO cellValue = (CellValueDTO) o;

        if (!rowNumber.equals(cellValue.rowNumber)) return false;
        if (!columnNumber.equals(cellValue.columnNumber)) return false;
        return value.equals(cellValue.value);
    }

    @Override
    public int hashCode() {
        int result = rowNumber.hashCode();
        result = 31 * result + columnNumber.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
