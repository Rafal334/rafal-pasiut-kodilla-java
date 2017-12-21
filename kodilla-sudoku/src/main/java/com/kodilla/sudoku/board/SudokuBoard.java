package com.kodilla.sudoku.board;

import com.kodilla.sudoku.creator.CellValueDTO;
import com.kodilla.sudoku.row.SudokuRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard implements Cloneable {

    public static final int SUDOKU_SIZE = 9;
    public static final int SECTION_ROWS = 3;
    public static final int SECTION_COLUMNS = 3;

    private List<SudokuRow> rows;

    public SudokuBoard() {
        rows = IntStream
                .range(1, SUDOKU_SIZE+1)
                .mapToObj(i -> new SudokuRow(i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void setCells(Set<CellValueDTO> cells){
        cells.forEach(cell -> rows.get(cell.getRowNumber()-1).setCellValue(cell));
    }

    public SudokuBoard(SudokuBoard sudoku) {
        rows = sudoku.rows;
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        SudokuBoardPrinter printer = new SudokuBoardPrinter();
        return printer.drawSudokuString(this);
    }
}
