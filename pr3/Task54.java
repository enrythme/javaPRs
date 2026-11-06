package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task54 {
    // Задание 54. Обнулить элементы главной диагонали двумерного массива.
    public static void main(String[] args) {
        int[][] matrix = {{11, 12, 13, 14, 15}, {21, 22, 23, 24, 25}, {31, 32, 33, 34, 35}, {41, 42, 43, 44, 45}, {51, 52, 53, 54, 55}};
        zeroMainDiagonal(matrix);
        printMatrix(matrix);
    }

    public static void zeroMainDiagonal(int[][] matrix) { for (int i = 0; i < Math.min(matrix.length, matrix[0].length); i++) matrix[i][i] = 0; }

    public static void printMatrix(int[][] matrix) { for (int[] row : matrix) for (int value : row) System.out.print(value + " "); System.out.println(); }
}
