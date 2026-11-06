package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task52 {
    // Задание 52. Вывести пары дружественных чисел из заданного промежутка.
    public static void main(String[] args) {
        System.out.println(amicablePairs(1, 10000));
    }

    public static String amicablePairs(int min, int max) { StringBuilder result = new StringBuilder(); for (int a = Math.max(2, min); a <= max; a++) { int b = properDivisorSum(a); if (b > a && b <= max && properDivisorSum(b) == a) result.append(a).append("-").append(b).append(' '); } return result.toString().trim(); }

    private static int properDivisorSum(int number) { int sum = 1; for (int i = 2; i <= number / i; i++) if (number % i == 0) sum += i + (i != number / i ? number / i : 0); return number == 1 ? 0 : sum; }
}
