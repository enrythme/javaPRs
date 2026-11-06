package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task09 {
    // Задание 9. Посчитать количество цифр в целом числе.
    public static void main(String[] args) {
        System.out.println(digitCount(Long.MIN_VALUE));
    }

    public static int digitCount(long number) { return Long.toString(number).replace("-", "").length(); }
}
