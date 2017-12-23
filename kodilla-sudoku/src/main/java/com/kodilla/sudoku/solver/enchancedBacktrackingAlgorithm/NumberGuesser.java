package com.kodilla.sudoku.solver.enchancedBacktrackingAlgorithm;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.row.SudokuRow;

import java.util.Iterator;
import java.util.List;

public class NumberGuesser {

    private SudokuBoard sudoku;
    private List<SudokuBoard> backtrackList;

    public NumberGuesser(SudokuBoard sudoku, List<SudokuBoard> backtrackList) {
        this.sudoku = sudoku;
        this.backtrackList = backtrackList;
    }

    public void guessNumber() throws CloneNotSupportedException {
        boolean finished = false;
        Iterator<SudokuRow> rowIterator = sudoku.getRows().iterator();
        SudokuRow row;
        Iterator<SudokuCell> cellIterator;
        SudokuCell cell;
        Integer value;
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            cellIterator = row.getCells().iterator();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell.isEmpty()) {
                    try {
                        value = cell.getAvailableNumbers().iterator().next();
                        cell.removeNumberFromAvailableNumbers(value);
                        backtrackList.add(sudoku.deepCopy());
                        cell.setValue(value);
                    } catch (Exception e) {
                        System.out.println("here");
                    }
                    finished = true;
                    break;
                }
            }
            if (finished) {
                break;
            }
        }
    }
}
