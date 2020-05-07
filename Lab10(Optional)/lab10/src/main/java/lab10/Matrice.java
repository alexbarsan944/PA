/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.util.Arrays;

/**
 *
 * @author School
 */
public class Matrice {

    public int[][] matrix = new int[11][11];

    public Matrice() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                matrix[i][j] = 0;
                if (i == 10) {
                    matrix[i][j] = j;
                }
                if (j == 10) {
                    matrix[i][j] = i;
                }
            }
        }
    }

    public String show(int i) {
        String line = "";
        for (int j = 0; j < 11; j++) {
            line=line+matrix[i][j]+" ";
        }
        return line;
    }

    public String printMatrix() {
        String tabla = "";
        // Loop through all rows
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                tabla = tabla + matrix[i][j] + " ";
            }
            if (i != 10) {
                tabla = tabla + "\n";
            }
        }
        return tabla;
    }

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    private boolean checkRows(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length - 4; col++) {
                int element = matrix[row][col];
                if (element == matrix[row][col + 1]
                        && element == matrix[row][col + 2]
                        && element == matrix[row][col + 3]
                        && element != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumns(int[][] matrix) {
        for (int row = 0; row < matrix.length - 3; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int element = matrix[row][col];
                if (element == matrix[row + 1][col]
                        && element == matrix[row + 2][col]
                        && element == matrix[row + 3][col]
                        && element != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkMainDiagonal(int[][] matrix) {
        for (int row = 0; row < matrix.length - 3; row++) {
            for (int col = 0; col < matrix[row].length - 3; col++) {
                int element = matrix[row][col];
                if (element == matrix[row + 1][col + 1]
                        && element == matrix[row + 2][col + 2]
                        && element == matrix[row + 3][col + 3]
                        && element != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCounterDiagonal(int[][] matrix) {
        for (int row = 0; row < matrix.length - 3; row++) {
            for (int col = 3; col < matrix[row].length; col++) {
                int element = matrix[row][col];
                if (element == matrix[row + 1][col - 1]
                        && element == matrix[row + 2][col - 2]
                        && element == matrix[row + 3][col - 3]
                        && element != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkForIdenticalFour(int[][] matrix) {
        return checkRows(matrix)
                || checkColumns(matrix)
                || checkMainDiagonal(matrix)
                || checkCounterDiagonal(matrix);
    }

    public String getTheWinner(int x_or_o) {
        String response = "";
        System.out.println(checkForIdenticalFour(matrix));
        if (checkForIdenticalFour(matrix)) {
            if (x_or_o % 2 == 0) {
                response = "X Won!";
            } else {
                response = "O Won!";
            }
        }
        return response;
    }
}
