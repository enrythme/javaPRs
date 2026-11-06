package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task27 {
    // Задание 27. Проверить, есть ли в числе одинаковые цифры.
    public static void main(String[] args) {
        System.out.println(hasRepeatedDigits(133));
    }

    public static boolean hasRepeatedDigits(long number) { String digits = Long.toString(number).replace("-", ""); return digits.chars().distinct().count() < digits.length(); }
}
