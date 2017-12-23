package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.cell.SudokuCell;
import com.kodilla.sudoku.row.SudokuRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnchancedBacktrackingAlgorithm implements SudokuSolver {

    private List<SudokuBoard> backtrackList;
    private SudokuBoard sudoku;

    public EnchancedBacktrackingAlgorithm() {
        this.backtrackList = new ArrayList<>();
    }

    @Override
    public SudokuBoard solve(SudokuBoard sudokuToSolve) throws NoSolutionException, CloneNotSupportedException {
        sudoku = sudokuToSolve;
        boolean sudokuChanged = true;
        while (!sudoku.areAllCellsFilled()) {
            if (sudokuChanged) {
                try {
                    sudokuChanged = iterateThrougAllCells(this::checkNumberForRowColumnSectionOccurence);
                    //sudokuChanged = iterateThrougAllCells(this::canNumberBePlacedInRowColumnSection) || sudokuChanged;
                    if (sudokuChanged) {
                        System.out.println("--NO CHANGE--");
                    }
                } catch (BadNumberException e) {
                    if (backtrackList.isEmpty()) {
                        throw new NoSolutionException();
                    } else {
                        sudoku = backtrackList.get(backtrackList.size() - 1);
                        backtrackList.remove(backtrackList.size() - 1);
                        System.out.println(sudoku);
                        System.out.println("BACKTRACK");
                        sudokuChanged = true;
                    }
                }
            } else {
                guessNumber();
                System.out.println(sudoku);
                System.out.println("GUESS");
                sudokuChanged = true;
            }
        }
        return sudoku;
    }

    private boolean iterateThrougAllCells(SudokuUpdater updater) throws BadNumberException {
        boolean sudokuChanged = false;
        boolean update;
        Iterator<SudokuRow> rowIterator = sudoku.getRows().iterator();
        SudokuRow row;
        Iterator<SudokuCell> cellIterator;
        SudokuCell cell;
        Iterator<Integer> numberIterator;
        Integer number;

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            cellIterator = row.getCells().iterator();
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell.isEmpty()) {
                    numberIterator = cell.getAvailableNumbers().iterator();
                    while (numberIterator.hasNext()) {
                        number = numberIterator.next();
                        update = updater.updateSudoku(cell, number);
                        if (update) {
                            numberIterator.remove();
                            if (cell.getAvailableNumbers().isEmpty() && cell.isEmpty()) {
                                throw new BadNumberException();
                            }
                        }
                        if (!sudokuChanged) {
                            sudokuChanged = update;
                        }
                    }
                }
            }
        }
        return sudokuChanged;
    }

    private boolean checkNumberForRowColumnSectionOccurence(SudokuCell cell, Integer number) {
        if (isNumberOKForCell(cell, number)) {
            if (cell.isOnlyOneSolution()) {
                cell.setSolution();
                System.out.println(sudoku);
                System.out.println("SET");
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

    private boolean canNumberBePlacedInRowColumnSection(SudokuCell cell, Integer number) {
        boolean[] checks = {!canBePlacedInRow(cell, number), !canBePlacedInColumn(cell, number), !canBePlacedInSection(cell, number)};
        if (checks[0] && checks[1] && checks[2]) {
            cell.setValue(number);
            return true;
        }
        return false;
    }

    private boolean isNumberOKForCell(SudokuCell cell, int number) {
        boolean[] checks = {!isNumberInRow(cell, number), !isNumberInColumn(cell, number), !isNumberInSection(cell, number)};
        return checks[0] && checks[1] && checks[2];
    }

    private boolean isNumberInRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(rowCell -> !rowCell.getColumnNumber().equals(cell.getColumnNumber()) && (rowCell.getValue().equals(number)));
    }

    private boolean isNumberInColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if (currentCell.getValue().equals(number) && !(currentCell.getRowNumber().equals(cell.getRowNumber()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInSection(SudokuCell cell, int number) {
        int currentRow = ((cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS) * SudokuBoard.SECTION_ROWS;
        int currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if (currentCell.getValue().equals(number) && !currentCell.getColumnNumber().equals(cell.getColumnNumber()) && !currentCell.getRowNumber().equals(cell.getRowNumber())) {
                    return true;
                }
            }
            currentColumn = ((cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS) * SudokuBoard.SECTION_COLUMNS;
        }
        return false;
    }

    private boolean canBePlacedInRow(SudokuCell cell, int number) {
        return sudoku.getRows().get(cell.getRowNumber() - 1).getCells().stream()
                .anyMatch(rowCell -> (!rowCell.getColumnNumber().equals(cell.getColumnNumber())) && (rowCell.isNumberInAvailableNumbers(number)));
    }

    private boolean canBePlacedInColumn(SudokuCell cell, int number) {
        SudokuCell currentCell;
        for (int i = 0; i < SudokuBoard.SUDOKU_SIZE; i++) {
            currentCell = sudoku.getRows().get(i).getCells().get(cell.getColumnNumber() - 1);
            if (currentCell.isNumberInAvailableNumbers(number) && !currentCell.getRowNumber().equals(cell.getRowNumber())) {
                return true;
            }
        }
        return false;
    }

    private boolean canBePlacedInSection(SudokuCell cell, int number) {
        int currentRow = (cell.getRowNumber() - 1) / SudokuBoard.SECTION_ROWS;
        int currentColumn = (cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS;
        int finishRow = currentRow + SudokuBoard.SECTION_ROWS;
        int finishColumn = currentColumn + SudokuBoard.SECTION_COLUMNS;
        SudokuCell currentCell;

        for (; currentRow < finishRow; currentRow++) {
            for (; currentColumn < finishColumn; currentColumn++) {
                currentCell = sudoku.getRows().get(currentRow).getCells().get(currentColumn);
                if (currentCell.isNumberInAvailableNumbers(number) && !currentCell.getColumnNumber().equals(cell.getColumnNumber()) && !currentCell.getRowNumber().equals(cell.getRowNumber())) {
                    return true;
                }
            }
            currentColumn = (cell.getColumnNumber() - 1) / SudokuBoard.SECTION_COLUMNS;
        }
        return false;
    }

    private void guessNumber() throws CloneNotSupportedException {
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
