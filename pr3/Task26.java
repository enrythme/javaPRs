package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task26 {
    // Задание 26. Считать два числа через консоль и вывести их сумму.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите два числа: ");
        long first = scanner.nextLong();
        long second = scanner.nextLong();
        System.out.println(first + second);
    }
}
