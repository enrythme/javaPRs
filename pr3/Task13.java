package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task13 {
    // Задание 13. Найти остаток от деления первого числа на второе.
    public static void main(String[] args) {
        System.out.println(remainder(17, 5));
    }

    public static long remainder(long first, long second) { return first % second; }
}
