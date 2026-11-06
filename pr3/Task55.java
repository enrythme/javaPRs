package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task55 {
    // Задание 55. Установить правильную форму существительного после числа.
    public static void main(String[] args) {
        System.out.println(nounWithNumber(1223421, "яблоко", "яблока", "яблок"));
    }

    public static String nounWithNumber(long number, String one, String few, String many) { long lastTwo = Math.abs(number) % 100; if (lastTwo >= 11 && lastTwo <= 14) return number + " " + many; int last = (int) (Math.abs(number) % 10); String form = last == 1 ? one : last >= 2 && last <= 4 ? few : many; return number + " " + form; }
}
