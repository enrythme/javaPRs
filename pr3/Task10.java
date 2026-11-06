package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task10 {
    // Задание 10. Проверить совпадение первых цифр двух чисел.
    public static void main(String[] args) {
        System.out.println(firstDigitsEqual(123, 987));
    }

    public static boolean firstDigitsEqual(long first, long second) { return firstDigit(first) == firstDigit(second); }

    public static int firstDigit(long number) { return (int) (Long.toString(number).replace("-", "").charAt(0) - '0'); }
}
