package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task06 {
    // Задание 6. Вывести первую цифру целого числа.
    public static void main(String[] args) {
        System.out.println(firstDigit(-735));
    }

    public static int firstDigit(long number) { return (int) (Long.toString(number).replace("-", "").charAt(0) - '0'); }
}
