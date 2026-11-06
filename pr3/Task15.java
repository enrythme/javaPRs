package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task15 {
    // Задание 15. Вывести из массива числа, которые делятся на 5.
    public static void main(String[] args) {
        printDivisibleByFive(new int[]{2, 5, 10, 13, 20});
    }

    public static void printDivisibleByFive(int[] values) { for (int value : values) if (value % 5 == 0) System.out.print(value + " "); System.out.println(); }
}
