package com.kodilla.sudoku.row;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.creator.CellValueDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuRow {

    private List<SudokuCell> cells;

    public SudokuRow(int rowNumber) {
        cells = IntStream
                .range(1, SudokuBoard.SUDOKU_SIZE + 1)
                .mapToObj(i -> new SudokuCell(rowNumber, i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void setCellValue(CellValueDTO cell) {
        SudokuCell currentCell = cells.get(cell.getColumnNumber() - 1);
        currentCell.setValue(cell.getValue());
    }

    @Override
    public String toString() {

        StringBuilder print = new StringBuilder();
        int i = 0;
        for (SudokuCell cell : cells) {
            if (i % SudokuBoard.SECTION_COLUMNS == 0) {
                print.append("|").append(cell);
            } else {
                print.append(" ").append(cell);
            }
            i++;
        }
        return print + "|";
    }
}
