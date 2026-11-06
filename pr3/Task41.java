package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task41 {
    // Задание 41. Отсортировать слова в тексте по алфавиту.
    public static void main(String[] args) {
        System.out.println(sortWords("pear apple orange"));
    }

    public static String sortWords(String text) { String[] words = text.trim().split("\\s+"); Arrays.sort(words, String.CASE_INSENSITIVE_ORDER); return String.join(" ", words); }
}
