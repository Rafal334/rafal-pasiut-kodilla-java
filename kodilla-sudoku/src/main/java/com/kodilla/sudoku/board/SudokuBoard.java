package com.kodilla.sudoku.board;

import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.creator.CellValueDTO;
import com.kodilla.sudoku.row.SudokuRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard extends Prototype {

    public static final int SUDOKU_SIZE = 9;
    public static final int SECTION_ROWS = 3;
    public static final int SECTION_COLUMNS = 3;

    private List<SudokuRow> rows;

    public SudokuBoard() {
        initRows();
    }

    public void setCells(Set<CellValueDTO> cells) {
        cells.forEach(cell -> rows.get(cell.getRowNumber() - 1).setCellValue(cell));
    }

    public SudokuBoard(SudokuBoard sudoku) {
        rows = sudoku.rows;
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public boolean areAllCellsFilled() {
        return rows.stream().flatMap(row -> row.getCells().stream()).noneMatch(cell -> cell.isEmpty());
    }

    @Override
    public String toString() {
        SudokuBoardPrinter printer = new SudokuBoardPrinter();
        return printer.drawSudokuString(this);
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard sudokuBoardCopy = (SudokuBoard) super.clone();
        sudokuBoardCopy.initRows();

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                SudokuCell currentCopyCell = sudokuBoardCopy.rows.get(i).getCells().get(j);
                currentCopyCell.copyCell(rows.get(i).getCells().get(j));
            }
        }
        return sudokuBoardCopy;
    }

    private void initRows() {
        rows = IntStream
                .range(1, SUDOKU_SIZE + 1)
                .mapToObj(i -> new SudokuRow(i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuBoard that = (SudokuBoard) o;

        int i=0, j=0;
        for(SudokuRow row : rows){
            for(SudokuCell cell : row.getCells()){
                if(!cell.getValue().equals(that.rows.get(i).getCells().get(j).getValue())){
                    return false;
                }
                j++;
            }
            i++;
            j=0;
        }

        return true;
    }
}
