package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task11 {
    // Задание 11. Вывести числа от 1 до 100.
    public static void main(String[] args) {
        printOneToHundred();
    }

    public static void printOneToHundred() { for (int i = 1; i <= 100; i++) System.out.print(i + (i == 100 ? "\n" : " ")); }
}
