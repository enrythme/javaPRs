package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task39 {
    // Задание 39. Составить строку из первых букв слов в верхнем регистре.
    public static void main(String[] args) {
        System.out.println(initials("john ronald reuel tolkien"));
    }

    public static String initials(String value) { StringBuilder result = new StringBuilder(); for (String word : value.trim().split("\\s+")) if (!word.isEmpty()) result.append(Character.toUpperCase(word.charAt(0))); return result.toString(); }
}
