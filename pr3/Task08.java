package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task08 {
    // Задание 8. Найти сумму первой и последней цифр числа.
    public static void main(String[] args) {
        System.out.println(firstAndLastDigitSum(-735));
    }

    public static int firstAndLastDigitSum(long number) { return firstDigit(number) + lastDigit(number); }

    public static int firstDigit(long number) { return (int) (Long.toString(number).replace("-", "").charAt(0) - '0'); }

    public static int lastDigit(long number) { return (int) (Math.abs(number % 10)); }
}
