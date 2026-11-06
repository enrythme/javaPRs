package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task38 {
    private static final Random RANDOM = new Random();

    // Задание 38. Создать строку заданной длины из случайных латинских букв.
    public static void main(String[] args) {
        System.out.println(randomString(12));
    }

    public static String randomString(int length) { return new String(randomLetters(length)); }

    public static char[] randomLetters(int length) { if (length < 0) throw new IllegalArgumentException(); char[] result = new char[length]; for (int i = 0; i < length; i++) result[i] = (char) ('a' + RANDOM.nextInt(26)); return result; }
}
