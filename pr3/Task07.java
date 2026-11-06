package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task07 {
    // Задание 7. Вывести последнюю цифру целого числа.
    public static void main(String[] args) {
        System.out.println(lastDigit(-735));
    }

    public static int lastDigit(long number) { return (int) (Math.abs(number % 10)); }
}
