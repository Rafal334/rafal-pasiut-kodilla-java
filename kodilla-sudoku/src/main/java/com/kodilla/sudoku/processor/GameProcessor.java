package com.kodilla.sudoku.processor;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.creator.SudokuCreator;
import com.kodilla.sudoku.creator.WrogInputException;
import com.kodilla.sudoku.solver.EnchancedBacktrackingAlgorithm;
import com.kodilla.sudoku.solver.NoSolutionException;
import com.kodilla.sudoku.solver.SudokuSolver;

import java.util.Scanner;

public class GameProcessor {

    public static final String DEBUG_SUDOKU = "1,1,8,2,3,3,2,4,6,3,2,7,3,5,9,3,7,2,4,2,5,4,6,7,5,5,4,5,6,5,5,7,7,6,4,1,6,8,3,7,3,1,7,8,6,7,9,8,8,3,8,8,4,5,8,8,1,9,2,9,9,7,4";
    private Scanner scanner = new Scanner(System.in);
    private String line;
    private boolean end = false;
    private SudokuCreator sudokuCreator = new SudokuCreator();
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuSolver sudokuSolver = new EnchancedBacktrackingAlgorithm();

    public void run() {
        printWelcomeMessage();
        printHelpMessage();
        while (!end) {
            System.out.println("Please insert new numbers, or other command");
            line = scanner.nextLine();
            try {
                takeAction();
            } catch (Exception e) {
                try {
                    sudokuBoard = sudokuCreator.prepareSudokuDraft(line);
                    System.out.println(sudokuBoard);
                } catch (WrogInputException exception) {
                    System.out.println("Bad command. Type \"help\" for hints");
                }
            }
        }
    }

    private void takeAction() {
        switch (parseLine()) {
            case SUDOKU:
                try {
                    System.out.println(sudokuSolver.solve(sudokuBoard));
                }catch(NoSolutionException e){
                    System.out.println("Can`t solve. Bad sudoku?");
                }catch(CloneNotSupportedException e){
                    System.out.println("Critical ERROR. Clone not support exception.");
                }catch(Exception e){
                    System.out.println("Unhandled exception.");
                }
                break;
            case HELP:
                printHelpMessage();
                break;
            case RESTART:
                clearBoardAndCreator();
                break;
            case SHOW:
                System.out.println(sudokuBoard);
                break;
            case DEBUG:
                prepareDebugSudoku();
                break;
            case EXIT:
                end = true;
        }
    }

    private void prepareDebugSudoku() {
        try {
            line = DEBUG_SUDOKU;
            sudokuBoard = sudokuCreator.prepareSudokuDraft(line);
            System.out.println(sudokuBoard);
        } catch(WrogInputException e){
            System.out.println("Wrong debug sudoku");
        }
    }

    private void printHelpMessage() {
        System.out.println("To insert new number type for example 1,1,3 to insert 3 in column 1, row 1. " +
                "You can insert as many numbers as you like. Numbers must be in range from 1 to " + SudokuBoard.SUDOKU_SIZE + ".\n" +
                "help - show this message again\n" +
                "sudoku - solve sudoku\n" +
                "restart - clear everything and start from scratch\n" +
                "show - print current board\n" +
                "exit - quit application\n");
    }

    private void clearBoardAndCreator() {
        sudokuCreator = new SudokuCreator();
        sudokuBoard = new SudokuBoard();
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to SUDOKU!");
    }

    private UserInput parseLine() throws IllegalArgumentException {
        line = line.toUpperCase();
        return UserInput.valueOf(line);
    }
}
