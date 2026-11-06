package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task23 {
    // Задание 23. Получить три последних символа строки.
    public static void main(String[] args) {
        System.out.println(lastThree("abcdef"));
    }

    public static String lastThree(String value) { return value.substring(Math.max(0, value.length() - 3)); }
}
