package com.kodilla.MatrixTransposition;

public class MatrixTranspositionRunner {
    public static void main(String[] args)
    {
        System.out.println("Draft matrix:");
        Matrix matrix = new Matrix(10,10);
        matrix.printMatrix();
        System.out.println();
        matrix.transpose();
        System.out.println("Transposed matrix:");
        matrix.printMatrix();
    }
}
