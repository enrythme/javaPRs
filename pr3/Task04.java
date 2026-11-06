package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task04 {
    // Задание 4. Проверить, чётное ли число.
    public static void main(String[] args) {
        System.out.println(isEven(8));
    }

    public static boolean isEven(long number) { return number % 2 == 0; }
}
