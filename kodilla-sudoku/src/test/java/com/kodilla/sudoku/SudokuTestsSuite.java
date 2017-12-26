package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.creator.SudokuCreator;
import com.kodilla.sudoku.solver.NoSolutionException;
import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.solver.algorithm.backtracking.enchanced.EnchancedBacktrackingAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SudokuTestsSuite {

    private SudokuCreator creator;
    private SudokuSolver solver;

    @Before
    public void before() {
        creator = new SudokuCreator();
        solver = new EnchancedBacktrackingAlgorithm();
    }


    @Test
    public void testSolveHardSudoku() {
        //Given
        String sudokuLine = "1,1,8,2,3,3,2,4,6,3,2,7,3,5,9,3,7,2,4,2,5,4,6,7,5,5,4,5,6,5,5,7,7,6,4,1,6,8,3,7,3,1,7,8,6,7,9,8,8,3,8,8,4,5,8,8,1,9,2,9,9,7,4";
        String sudokuSolution = "1,1,8,1,2,1,1,3,2,1,4,7,1,5,5,1,6,3,1,7,6,1,8,4,1,9,9,2,1,9,2,2,4,2,3,3,2,4,6,2,5,8,2,6,2,2,7,1,2,8,7,2,9,5,3,1,6,3,2,7,3,3,5,3,4,4,3,5,9,3,6,1,3,7,2,3,8,8,3,9,3,4,1,1,4,2,5,4,3,4,4,4,2,4,5,3,4,6,7,4,7,8,4,8,9,4,9,6,5,1,3,5,2,6,5,3,9,5,4,8,5,5,4,5,6,5,5,7,7,5,8,2,5,9,1,6,1,2,6,2,8,6,3,7,6,4,1,6,5,6,6,6,9,6,7,5,6,8,3,6,9,4,7,1,5,7,2,2,7,3,1,7,4,9,7,5,7,7,6,4,7,7,3,7,8,6,7,9,8,8,1,4,8,2,3,8,3,8,8,4,5,8,5,2,8,6,6,8,7,9,8,8,1,8,9,7,9,1,7,9,2,9,9,3,6,9,4,3,9,5,1,9,6,8,9,7,4,9,8,5,9,9,2";
        SudokuBoard sudokuBoard = null;
        SudokuBoard sudokuSolutionBoard = null;

        try {
            sudokuSolutionBoard = creator.addNumbersToBoard(sudokuSolution);
            creator.createNewBoard();
            sudokuBoard = creator.addNumbersToBoard(sudokuLine);
            showSudokus(sudokuBoard, sudokuSolutionBoard);

        } catch (Exception e) {
            System.out.println("Exception when creating sudoku");
        }

        //When
        try {
            sudokuBoard = solver.solve(sudokuBoard);
        } catch (NoSolutionException e) {
            System.out.println("No solution");
        } catch (CloneNotSupportedException cloneException) {
            System.out.println("Critical ERROR");
        }

        //Then
        System.out.println("SOLUTION:");
        System.out.println(sudokuBoard);
        Assert.assertNotNull(sudokuSolutionBoard);
        Assert.assertNotNull(sudokuBoard);
        Assert.assertEquals(sudokuSolutionBoard, sudokuBoard);
    }

    @Test
    public void testSudokuAgainstBruteForce() {
        //Given
        String sudokuLine = "2,6,3,2,8,8,2,9,5,3,3,1,3,5,2,4,4,5,4,6,7,5,3,4,5,7,1,6,2,9,7,1,5,7,8,7,7,9,3,8,3,2,8,5,1,9,5,4,9,9,9";
        String sudokuSolution = "1,1,9,1,2,8,1,3,7,1,4,6,1,5,5,1,6,4,1,7,3,1,8,2,1,9,1,2,1,2,2,2,4,2,3,6,2,4,1,2,5,7,2,6,3,2,7,9,2,8,8,2,9,5,3,1,3,3,2,5,3,3,1,3,4,9,3,5,2,3,6,8,3,7,7,3,8,4,3,9,6,4,1,1,4,2,2,4,3,8,4,4,5,4,5,3,4,6,7,4,7,6,4,8,9,4,9,4,5,1,6,5,2,3,5,3,4,5,4,8,5,5,9,5,6,2,5,7,1,5,8,5,5,9,7,6,1,7,6,2,9,6,3,5,6,4,4,6,5,6,6,6,1,6,7,8,6,8,3,6,9,2,7,1,5,7,2,1,7,3,9,7,4,2,7,5,8,7,6,6,7,7,4,7,8,7,7,9,3,8,1,4,8,2,7,8,3,2,8,4,3,8,5,1,8,6,9,8,7,5,8,8,6,8,9,8,9,1,8,9,2,6,9,3,3,9,4,7,9,5,4,9,6,5,9,7,2,9,8,1,9,9,9";
        SudokuBoard sudokuBoard = null;
        SudokuBoard sudokuSolutionBoard = null;

        try {
            sudokuSolutionBoard = creator.addNumbersToBoard(sudokuSolution);
            creator.createNewBoard();
            sudokuBoard = creator.addNumbersToBoard(sudokuLine);
            showSudokus(sudokuBoard, sudokuSolutionBoard);

        } catch (Exception e) {
            System.out.println("Exception when creating sudoku");
        }

        //When
        try {
            sudokuBoard = solver.solve(sudokuBoard);
        } catch (NoSolutionException e) {
            System.out.println("No solution");
        } catch (CloneNotSupportedException cloneException) {
            System.out.println("Critical ERROR");
        }

        //Then
        System.out.println("SOLUTION:");
        System.out.println(sudokuBoard);
        Assert.assertNotNull(sudokuSolutionBoard);
        Assert.assertNotNull(sudokuBoard);
        Assert.assertEquals(sudokuSolutionBoard, sudokuBoard);
    }

    private void showSudokus(SudokuBoard sudokuBoard, SudokuBoard sudokuSolutionBoard) {
        System.out.println("To solve:");
        System.out.println(sudokuBoard);
        System.out.println("Expected solution:");
        System.out.println(sudokuSolutionBoard);
    }

    @Test
    public void testSudokuWithoutSolution() {
        //Given
        String sudokuLines = "9,3,2,1,1,8,2,3,3,2,4,6,3,2,7,3,5,9,3,7,2,4,2,5,4,6,7,5,5,4,5,6,5,5,7,7,6,4,1,6,8,3,7,3,1,7,8,6,7,9,8,8,3,8,8,4,5,8,8,1,9,2,9,9,7,4";
        SudokuBoard sudokuBoard = null;
        Boolean excepionCought = false;

        try {
            sudokuBoard = creator.addNumbersToBoard(sudokuLines);
            System.out.println("To solve:");
            System.out.println(sudokuBoard);
        } catch (Exception e) {
            System.out.println("Exeption when creating sudoku");
            System.out.println(e.getMessage());
        }

        //When
        try {
            sudokuBoard = solver.solve(sudokuBoard);
        } catch (NoSolutionException e) {
            System.out.println("No solution");
            excepionCought = true;
        } catch (Exception exception) {
            System.out.println("Exception when solving sudoku");
        }

        //Then
        Assert.assertNotNull(sudokuBoard);
        Assert.assertTrue(excepionCought);

    }

    @Test
    public void testLinesAdding() {
        //Given
        String sudokuLines = "1,1,1,9,9,9";
        SudokuBoard multiline = null;
        SudokuBoard simpleAddidtion = null;

        try {
            multiline = creator.addNumbersToBoard(sudokuLines);
            creator.createNewBoard();
            simpleAddidtion = creator.addNumbersToBoard("1,1,1");
            simpleAddidtion = creator.addNumbersToBoard("9,9,9");
            System.out.println("Multiline addition:");
            System.out.println(multiline);
            System.out.println("Single line addition:");
            System.out.println(simpleAddidtion);

        } catch (Exception e) {
            System.out.println("Exception when creating sudoku");
        }
        //When

        //Then
        Assert.assertNotNull(multiline);
        Assert.assertNotNull(simpleAddidtion);
        Assert.assertEquals(multiline, simpleAddidtion);

    }
}
