package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task30 {
    // Задание 30. Проверить, состоит ли строка только из цифр.
    public static void main(String[] args) {
        System.out.println(isIntegerString("12345"));
    }

    public static boolean isIntegerString(String value) { return value != null && value.matches("\\d+"); }
}
