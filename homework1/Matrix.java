/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.matrix;

/**
 *
 * @author remus
 */
public class Matrix {

    public static void main(String[] args) {

        int n;

        // n = Integer.parseInt(args[0]);
        n = 3;
        if (n <= 0) {
            System.out.println("n must be a positive integer");
            return;
        }

        System.out.println("Matrix of " + n + "x" + n);
        long startTime = System.nanoTime();
        int[][] matrix = generateLatinSquare(n);
        printRowStrings(matrix);
        printColumnStrings(matrix);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ns");
    }

    public static int[][] generateLatinSquare(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (i + j) % n + 1;
            }
        }
        return matrix;
    }

    public static void printRowStrings(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                row.append(matrix[i][j]).append(" ");
            }
            System.out.println("row no." + i + ": " + row.toString());
        }
    }

    public static void printColumnStrings(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            StringBuilder col = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                col.append(matrix[i][j]).append(" ");
            }
            System.out.println("col no." + j + ": " + col.toString());
        }
    }
}
