package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task01 {
    // Задание 1. Проверить, отрицательное ли число.
    public static void main(String[] args) {
        System.out.println(isNegative(-7));
    }

    public static boolean isNegative(long number) { return number < 0; }
}
