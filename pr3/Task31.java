package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task31 {
    // Задание 31. Проверить, представляет ли строка дробное число.
    public static void main(String[] args) {
        System.out.println(isDecimalString("-12.75"));
    }

    public static boolean isDecimalString(String value) { return value != null && value.matches("[+-]?\\d+[.,]\\d+"); }
}
