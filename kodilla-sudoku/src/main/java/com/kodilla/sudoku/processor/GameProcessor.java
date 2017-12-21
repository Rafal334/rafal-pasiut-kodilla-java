package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.creator.SudokuCreator;
import com.kodilla.sudoku.creator.WrogInputException;

import java.util.Scanner;

public class GameProcessor {

    private Scanner scanner = new Scanner(System.in);
    private String line;
    private SudokuCreator sudokuCreator = new SudokuCreator();
    private SudokuBoard sudokuBoard;

    public void run() {
        boolean end = false;
        printWelcomeMessage();
        printHelpMessage();
        while (!end) {
            System.out.println("Please insert new numbers, or other command");
            line = scanner.nextLine();
            try {
                switch (parseLine()) {
                    case SUDOKU:
                        System.out.println("Yet unhandled command");
                        break;
                    case HELP:
                        printHelpMessage();
                        break;
                    case RESTART:
                        System.out.println("Yet unhandled command");
                        break;
                    case SHOW:
                        System.out.println(sudokuBoard);
                        break;
                    case EXIT:
                        end = true;
                }
            } catch (Exception e) {
                try {
                    sudokuBoard = sudokuCreator.prepareSudokuDraft(line);
                    System.out.println(sudokuBoard);
                } catch(WrogInputException exception){
                    System.out.println("Bad command. Type \"help\" for hints");
                }
            }
        }
    }

    private void printHelpMessage() {
        System.out.println("To insert new number type for example 1,1,3 to insert 3 in column 1, row 1. " +
                "You can insert as many numbers as you like. Numbers must be in range from 1 to " + SudokuBoard.SUDOKU_SIZE + ".\n" +
                "help - show this message again\n" +
                "sudoku - solve sudoku\n" +
                "restart - clear everything and start from scratch\n" +
                "show - print current board\n"+
                "exit - quit application\n");
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to SUDOKU!");
    }

    private UserInput parseLine() throws IllegalArgumentException {
        line = line.toUpperCase();
        return UserInput.valueOf(line);
    }
}
