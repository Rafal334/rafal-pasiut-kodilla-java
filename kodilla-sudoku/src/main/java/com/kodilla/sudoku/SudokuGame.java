package com.kodilla.sudoku;

import com.kodilla.sudoku.processor.GameProcessor;

public class SudokuGame {

    public static void main(String[] args) {
        GameProcessor processor = new GameProcessor();
        processor.run();
    }
}
