package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task16 {
    // Задание 16. Получить первые три символа строки.
    public static void main(String[] args) {
        System.out.println(firstThree("abcdef"));
    }

    public static String firstThree(String value) { return value.substring(0, Math.min(3, value.length())); }
}
