package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task28 {
    // Задание 28. Вывести все элементы двумерного массива.
    public static void main(String[] args) {
        printMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static void printMatrix(int[][] matrix) { for (int[] row : matrix) for (int value : row) System.out.print(value + " "); System.out.println(); }
}
