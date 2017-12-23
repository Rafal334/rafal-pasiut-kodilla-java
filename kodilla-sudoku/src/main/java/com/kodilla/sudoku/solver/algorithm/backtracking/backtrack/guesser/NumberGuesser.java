package com.kodilla.sudoku.solver.algorithm.backtracking.backtrack.guesser;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.row.SudokuRow;

import java.util.Iterator;
import java.util.List;

public class NumberGuesser {

    public void guessNumber(SudokuBoard sudoku, List<SudokuBoard> backtrackList) throws CloneNotSupportedException {
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
                    value = cell.getAvailableNumbers().iterator().next();
                    cell.removeNumberFromAvailableNumbers(value);
                    backtrackList.add(sudoku.deepCopy());
                    cell.setValue(value);
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
