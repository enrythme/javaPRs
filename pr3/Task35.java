package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task35 {
    // Задание 35. Найти сумму N первых чисел Фибоначчи.
    public static void main(String[] args) {
        System.out.println(fibonacciSum(10));
    }

    public static long fibonacciSum(int n) { if (n < 0) throw new IllegalArgumentException(); long sum = 0, previous = 0, current = 1; for (int i = 0; i < n; i++) { sum += previous; long next = previous + current; previous = current; current = next; } return sum; }
}
