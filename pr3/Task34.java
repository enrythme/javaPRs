package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task34 {
    private static final Random RANDOM = new Random();

    // Задание 34. Заполнить массив случайными латинскими буквами.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomLetters(10)));
    }

    public static char[] randomLetters(int length) { if (length < 0) throw new IllegalArgumentException(); char[] result = new char[length]; for (int i = 0; i < length; i++) result[i] = (char) ('a' + RANDOM.nextInt(26)); return result; }
}
