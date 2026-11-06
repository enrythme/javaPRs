package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task45 {
    // Задание 45. Найти самое длинное слово строки.
    public static void main(String[] args) {
        System.out.println(longestWord("Java programming practice"));
    }

    public static String longestWord(String text) { return Arrays.stream(text.trim().split("\\s+")).max((a, b) -> Integer.compare(a.length(), b.length())).orElse(""); }
}
