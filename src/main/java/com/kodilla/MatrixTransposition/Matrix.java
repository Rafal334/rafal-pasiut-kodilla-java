package com.kodilla.MatrixTransposition;

import java.util.Random;

public class Matrix {
    private int[][] matrix;
    private int rowNumber;
    private int columnNumber;

    public Matrix(int rowNumber, int columnNumber) {

        if(rowNumber >0 && columnNumber >0) {
            this.rowNumber = rowNumber;
            this.columnNumber = columnNumber;
            int[][] randMatrix;
            Random randomGenerator = new Random();

            randMatrix = new int[rowNumber][columnNumber];

            for(int i=0; i<rowNumber; i++) {
                for(int j=0; j<columnNumber; j++) {
                    randMatrix[i][j] = randomGenerator.nextInt(100);
                }
            }
            matrix = randMatrix;
        } else {
            System.out.println("Matrix dimensions must be greater than zero");
        }
    }

    public void printMatrix() {

        if(matrix !=null) {
            for(int i=0; i<rowNumber; i++) {
                for(int j=0; j<columnNumber; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix is null");
        }
    }

    public void transpose(){

        if(matrix != null) {
            int[][] transposedMatrix = new int[columnNumber][rowNumber];

            for(int i=0; i<rowNumber; i++) {
                for(int j=0;j<columnNumber;j++) {
                    transposedMatrix[j][i] = matrix[i][j];
                }
            }
            matrix = transposedMatrix;

            int tmpRowNumber = rowNumber;
            int tmpColumnNumber = columnNumber;

            rowNumber = tmpColumnNumber;
            columnNumber = tmpRowNumber;
        } else {
            System.out.println("Matrix is null");
        }
    }
}
