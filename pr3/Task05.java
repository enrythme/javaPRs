package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task05 {
    // Задание 5. Проверить, совпадают ли первые буквы двух слов.
    public static void main(String[] args) {
        System.out.println(firstLettersEqual("apple", "apricot"));
    }

    public static boolean firstLettersEqual(String first, String second) { return !first.isEmpty() && !second.isEmpty() && Character.toLowerCase(first.charAt(0)) == Character.toLowerCase(second.charAt(0)); }
}
