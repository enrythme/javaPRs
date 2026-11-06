package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task53 {
    // Задание 53. Разложить число на простые множители.
    public static void main(String[] args) {
        System.out.println(primeFactorization(360));
    }

    public static String primeFactorization(int number) { if (number < 2) throw new IllegalArgumentException(); StringBuilder result = new StringBuilder(number + " = "); int remaining = number; for (int divisor = 2; divisor <= remaining / divisor; divisor++) while (remaining % divisor == 0) { result.append(divisor).append(" × "); remaining /= divisor; } result.append(remaining); return result.toString(); }
}
